package com.firebase.geofire;

public final class GeoLocation {
    public final double latitude;
    public final double longitude;

    public static boolean coordinatesValid(double d, double d2) {
        return d >= -90.0d && d <= 90.0d && d2 >= -180.0d && d2 <= 180.0d;
    }

    public GeoLocation(double d, double d2) {
        if (coordinatesValid(d, d2)) {
            this.latitude = d;
            this.longitude = d2;
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Not a valid geo location: ");
        stringBuilder.append(d);
        stringBuilder.append(", ");
        stringBuilder.append(d2);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null) {
            if (getClass() == obj.getClass()) {
                GeoLocation geoLocation = (GeoLocation) obj;
                return Double.compare(geoLocation.latitude, this.latitude) == 0 && Double.compare(geoLocation.longitude, this.longitude) == null;
            }
        }
        return false;
    }

    public int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.latitude);
        int i = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
        long doubleToLongBits2 = Double.doubleToLongBits(this.longitude);
        return (31 * i) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)));
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("GeoLocation(");
        stringBuilder.append(this.latitude);
        stringBuilder.append(", ");
        stringBuilder.append(this.longitude);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
