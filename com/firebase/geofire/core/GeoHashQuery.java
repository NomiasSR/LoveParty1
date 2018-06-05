package com.firebase.geofire.core;

import com.firebase.geofire.GeoLocation;
import com.firebase.geofire.util.Base32Utils;
import com.firebase.geofire.util.Constants;
import com.firebase.geofire.util.GeoUtils;
import java.util.HashSet;
import java.util.Set;

public class GeoHashQuery {
    private final String endValue;
    private final String startValue;

    public static final class Utils {
        private Utils() {
            throw new AssertionError("No instances.");
        }

        public static double bitsLatitude(double d) {
            return Math.min(Math.log(2.000393E7d / d) / Math.log(2.0d), 110.0d);
        }

        public static double bitsLongitude(double d, double d2) {
            d = GeoUtils.distanceToLongitudeDegrees(d, d2);
            return Math.abs(d) > 0.0d ? Math.max(1.0d, Math.log(360.0d / d) / Math.log(2.0d)) : 1.0d;
        }

        public static int bitsForBoundingBox(GeoLocation geoLocation, double d) {
            double distanceToLatitudeDegrees = GeoUtils.distanceToLatitudeDegrees(d);
            return Math.min(((int) Math.floor(bitsLatitude(d))) * 2, Math.min((((int) Math.floor(bitsLongitude(d, Math.min(90.0d, geoLocation.latitude + distanceToLatitudeDegrees)))) * 2) - 1, (((int) Math.floor(bitsLongitude(d, Math.max(-90.0d, geoLocation.latitude - distanceToLatitudeDegrees)))) * 2) - 1));
        }
    }

    public GeoHashQuery(String str, String str2) {
        this.startValue = str;
        this.endValue = str2;
    }

    public static GeoHashQuery queryForGeoHash(GeoHash geoHash, int i) {
        geoHash = geoHash.getGeoHashString();
        int ceil = (int) Math.ceil(((double) i) / 5.0d);
        if (geoHash.length() < ceil) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(geoHash);
            stringBuilder.append("~");
            return new GeoHashQuery(geoHash, stringBuilder.toString());
        }
        geoHash = geoHash.substring(0, ceil);
        String substring = geoHash.substring(0, geoHash.length() - 1);
        i = 5 - (i - (substring.length() * 5));
        geoHash = (Base32Utils.base32CharToValue(geoHash.charAt(geoHash.length() - 1)) >> i) << i;
        i = (1 << i) + geoHash;
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(substring);
        stringBuilder2.append(Base32Utils.valueToBase32Char(geoHash));
        geoHash = stringBuilder2.toString();
        if (i > 31) {
            i = new StringBuilder();
            i.append(substring);
            i.append("~");
            i = i.toString();
        } else {
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append(substring);
            stringBuilder2.append(Base32Utils.valueToBase32Char(i));
            i = stringBuilder2.toString();
        }
        return new GeoHashQuery(geoHash, i);
    }

    public static Set<GeoHashQuery> queriesAtLocation(GeoLocation geoLocation, double d) {
        GeoLocation geoLocation2 = geoLocation;
        double d2 = d;
        int max = Math.max(1, Utils.bitsForBoundingBox(geoLocation, d));
        int ceil = (int) Math.ceil((double) (((float) max) / 5.0f));
        double d3 = geoLocation2.latitude;
        double d4 = geoLocation2.longitude;
        double d5 = d2 / Constants.METERS_PER_DEGREE_LATITUDE;
        int i = ceil;
        double min = Math.min(90.0d, d3 + d5);
        double max2 = Math.max(-90.0d, d3 - d5);
        double max3 = Math.max(GeoUtils.distanceToLongitudeDegrees(d2, min), GeoUtils.distanceToLongitudeDegrees(d2, max2));
        HashSet hashSet = new HashSet();
        double d6 = max2;
        max2 = d3;
        double d7 = d4;
        GeoHash geoHash = new GeoHash(max2, d4, i);
        d4 = d7 - max3;
        HashSet hashSet2 = hashSet;
        int i2 = max;
        double d8 = d4;
        GeoHash geoHash2 = geoHash;
        geoHash = new GeoHash(max2, GeoUtils.wrapLongitude(d4), i);
        max3 = d7 + max3;
        GeoHash geoHash3 = geoHash;
        int i3 = i;
        geoHash = new GeoHash(max2, GeoUtils.wrapLongitude(max3), i3);
        max2 = min;
        geoHash = new GeoHash(max2, d7, i3);
        GeoHash geoHash4 = geoHash;
        geoHash = new GeoHash(max2, GeoUtils.wrapLongitude(d8), i);
        GeoHash geoHash5 = geoHash;
        i3 = i;
        geoHash = new GeoHash(max2, GeoUtils.wrapLongitude(max3), i3);
        max2 = d6;
        geoHash = new GeoHash(max2, d7, i3);
        d4 = GeoUtils.wrapLongitude(d8);
        GeoHash geoHash6 = geoHash;
        i3 = i;
        geoHash = new GeoHash(max2, d4, i3);
        geoHash = new GeoHash(max2, GeoUtils.wrapLongitude(max3), i3);
        int i4 = i2;
        HashSet<GeoHashQuery> hashSet3 = hashSet2;
        hashSet3.add(queryForGeoHash(geoHash, i4));
        hashSet3.add(queryForGeoHash(geoHash3, i4));
        hashSet3.add(queryForGeoHash(geoHash2, i4));
        hashSet3.add(queryForGeoHash(geoHash, i4));
        hashSet3.add(queryForGeoHash(geoHash5, i4));
        hashSet3.add(queryForGeoHash(geoHash4, i4));
        hashSet3.add(queryForGeoHash(geoHash, i4));
        hashSet3.add(queryForGeoHash(geoHash, i4));
        hashSet3.add(queryForGeoHash(geoHash6, i4));
        Object obj;
        do {
            GeoHashQuery geoHashQuery = null;
            GeoHashQuery geoHashQuery2 = null;
            for (GeoHashQuery geoHashQuery3 : hashSet3) {
                for (GeoHashQuery geoHashQuery4 : hashSet3) {
                    if (geoHashQuery3 != geoHashQuery4 && geoHashQuery3.canJoinWith(geoHashQuery4)) {
                        geoHashQuery = geoHashQuery3;
                        geoHashQuery2 = geoHashQuery4;
                        break;
                    }
                }
            }
            if (geoHashQuery == null || geoHashQuery2 == null) {
                obj = null;
                continue;
            } else {
                hashSet3.remove(geoHashQuery);
                hashSet3.remove(geoHashQuery2);
                hashSet3.add(geoHashQuery.joinWith(geoHashQuery2));
                obj = 1;
                continue;
            }
        } while (obj != null);
        return hashSet3;
    }

    private boolean isPrefix(GeoHashQuery geoHashQuery) {
        return (geoHashQuery.endValue.compareTo(this.startValue) < 0 || geoHashQuery.startValue.compareTo(this.startValue) >= 0 || geoHashQuery.endValue.compareTo(this.endValue) >= null) ? null : true;
    }

    private boolean isSuperQuery(GeoHashQuery geoHashQuery) {
        return (geoHashQuery.startValue.compareTo(this.startValue) > 0 || geoHashQuery.endValue.compareTo(this.endValue) < null) ? null : true;
    }

    public boolean canJoinWith(GeoHashQuery geoHashQuery) {
        if (!(isPrefix(geoHashQuery) || geoHashQuery.isPrefix(this) || isSuperQuery(geoHashQuery))) {
            if (geoHashQuery.isSuperQuery(this) == null) {
                return null;
            }
        }
        return true;
    }

    public GeoHashQuery joinWith(GeoHashQuery geoHashQuery) {
        if (geoHashQuery.isPrefix(this)) {
            return new GeoHashQuery(this.startValue, geoHashQuery.endValue);
        }
        if (isPrefix(geoHashQuery)) {
            return new GeoHashQuery(geoHashQuery.startValue, this.endValue);
        }
        if (isSuperQuery(geoHashQuery)) {
            return geoHashQuery;
        }
        if (geoHashQuery.isSuperQuery(this)) {
            return this;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Can't join these 2 queries: ");
        stringBuilder.append(this);
        stringBuilder.append(", ");
        stringBuilder.append(geoHashQuery);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    public boolean containsGeoHash(GeoHash geoHash) {
        geoHash = geoHash.getGeoHashString();
        return (this.startValue.compareTo(geoHash) > 0 || this.endValue.compareTo(geoHash) <= null) ? null : true;
    }

    public String getStartValue() {
        return this.startValue;
    }

    public String getEndValue() {
        return this.endValue;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null) {
            if (getClass() == obj.getClass()) {
                GeoHashQuery geoHashQuery = (GeoHashQuery) obj;
                return this.endValue.equals(geoHashQuery.endValue) && this.startValue.equals(geoHashQuery.startValue) != null;
            }
        }
        return false;
    }

    public int hashCode() {
        return (31 * this.startValue.hashCode()) + this.endValue.hashCode();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("GeoHashQuery{startValue='");
        stringBuilder.append(this.startValue);
        stringBuilder.append('\'');
        stringBuilder.append(", endValue='");
        stringBuilder.append(this.endValue);
        stringBuilder.append('\'');
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
