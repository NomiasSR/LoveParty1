package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.zzbg;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;
import java.util.Arrays;

public final class LatLngBounds extends zzbfm implements ReflectedParcelable {
    public static final Creator<LatLngBounds> CREATOR = new zze();
    public final LatLng northeast;
    public final LatLng southwest;

    public static final class Builder {
        private double zziva = Double.POSITIVE_INFINITY;
        private double zzivb = Double.NEGATIVE_INFINITY;
        private double zzivc = Double.NaN;
        private double zzivd = Double.NaN;

        public final LatLngBounds build() {
            zzbq.zza(Double.isNaN(this.zzivc) ^ 1, (Object) "no included points");
            return new LatLngBounds(new LatLng(this.zziva, this.zzivc), new LatLng(this.zzivb, this.zzivd));
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final com.google.android.gms.maps.model.LatLngBounds.Builder include(com.google.android.gms.maps.model.LatLng r7) {
            /*
            r6 = this;
            r0 = r6.zziva;
            r2 = r7.latitude;
            r0 = java.lang.Math.min(r0, r2);
            r6.zziva = r0;
            r0 = r6.zzivb;
            r2 = r7.latitude;
            r0 = java.lang.Math.max(r0, r2);
            r6.zzivb = r0;
            r0 = r7.longitude;
            r2 = r6.zzivc;
            r7 = java.lang.Double.isNaN(r2);
            if (r7 == 0) goto L_0x0021;
        L_0x001e:
            r6.zzivc = r0;
            goto L_0x005a;
        L_0x0021:
            r2 = r6.zzivc;
            r4 = r6.zzivd;
            r7 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
            r2 = 0;
            r3 = 1;
            if (r7 > 0) goto L_0x0038;
        L_0x002b:
            r4 = r6.zzivc;
            r7 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1));
            if (r7 > 0) goto L_0x0045;
        L_0x0031:
            r4 = r6.zzivd;
            r7 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1));
            if (r7 > 0) goto L_0x0045;
        L_0x0037:
            goto L_0x0044;
        L_0x0038:
            r4 = r6.zzivc;
            r7 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1));
            if (r7 <= 0) goto L_0x0044;
        L_0x003e:
            r4 = r6.zzivd;
            r7 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1));
            if (r7 > 0) goto L_0x0045;
        L_0x0044:
            r2 = r3;
        L_0x0045:
            if (r2 != 0) goto L_0x005c;
        L_0x0047:
            r2 = r6.zzivc;
            r2 = com.google.android.gms.maps.model.LatLngBounds.zza(r2, r0);
            r4 = r6.zzivd;
            r4 = com.google.android.gms.maps.model.LatLngBounds.zzb(r4, r0);
            r7 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
            if (r7 >= 0) goto L_0x005a;
        L_0x0057:
            r6.zzivc = r0;
            return r6;
        L_0x005a:
            r6.zzivd = r0;
        L_0x005c:
            return r6;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.maps.model.LatLngBounds.Builder.include(com.google.android.gms.maps.model.LatLng):com.google.android.gms.maps.model.LatLngBounds$Builder");
        }
    }

    public LatLngBounds(LatLng latLng, LatLng latLng2) {
        zzbq.checkNotNull(latLng, "null southwest");
        zzbq.checkNotNull(latLng2, "null northeast");
        zzbq.zzb(latLng2.latitude >= latLng.latitude, "southern latitude exceeds northern latitude (%s > %s)", Double.valueOf(latLng.latitude), Double.valueOf(latLng2.latitude));
        this.southwest = latLng;
        this.northeast = latLng2;
    }

    public static Builder builder() {
        return new Builder();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.maps.model.LatLngBounds createFromAttributes(android.content.Context r6, android.util.AttributeSet r7) {
        /*
        r0 = 0;
        if (r6 == 0) goto L_0x008e;
    L_0x0003:
        if (r7 != 0) goto L_0x0006;
    L_0x0005:
        return r0;
    L_0x0006:
        r6 = r6.getResources();
        r1 = com.google.android.gms.C0365R.styleable.MapAttrs;
        r6 = r6.obtainAttributes(r7, r1);
        r7 = com.google.android.gms.C0365R.styleable.MapAttrs_latLngBoundsSouthWestLatitude;
        r7 = r6.hasValue(r7);
        r1 = 0;
        if (r7 == 0) goto L_0x0024;
    L_0x0019:
        r7 = com.google.android.gms.C0365R.styleable.MapAttrs_latLngBoundsSouthWestLatitude;
        r7 = r6.getFloat(r7, r1);
        r7 = java.lang.Float.valueOf(r7);
        goto L_0x0025;
    L_0x0024:
        r7 = r0;
    L_0x0025:
        r2 = com.google.android.gms.C0365R.styleable.MapAttrs_latLngBoundsSouthWestLongitude;
        r2 = r6.hasValue(r2);
        if (r2 == 0) goto L_0x0038;
    L_0x002d:
        r2 = com.google.android.gms.C0365R.styleable.MapAttrs_latLngBoundsSouthWestLongitude;
        r2 = r6.getFloat(r2, r1);
        r2 = java.lang.Float.valueOf(r2);
        goto L_0x0039;
    L_0x0038:
        r2 = r0;
    L_0x0039:
        r3 = com.google.android.gms.C0365R.styleable.MapAttrs_latLngBoundsNorthEastLatitude;
        r3 = r6.hasValue(r3);
        if (r3 == 0) goto L_0x004c;
    L_0x0041:
        r3 = com.google.android.gms.C0365R.styleable.MapAttrs_latLngBoundsNorthEastLatitude;
        r3 = r6.getFloat(r3, r1);
        r3 = java.lang.Float.valueOf(r3);
        goto L_0x004d;
    L_0x004c:
        r3 = r0;
    L_0x004d:
        r4 = com.google.android.gms.C0365R.styleable.MapAttrs_latLngBoundsNorthEastLongitude;
        r4 = r6.hasValue(r4);
        if (r4 == 0) goto L_0x0060;
    L_0x0055:
        r4 = com.google.android.gms.C0365R.styleable.MapAttrs_latLngBoundsNorthEastLongitude;
        r6 = r6.getFloat(r4, r1);
        r6 = java.lang.Float.valueOf(r6);
        goto L_0x0061;
    L_0x0060:
        r6 = r0;
    L_0x0061:
        if (r7 == 0) goto L_0x008e;
    L_0x0063:
        if (r2 == 0) goto L_0x008e;
    L_0x0065:
        if (r3 == 0) goto L_0x008e;
    L_0x0067:
        if (r6 != 0) goto L_0x006a;
    L_0x0069:
        return r0;
    L_0x006a:
        r0 = new com.google.android.gms.maps.model.LatLng;
        r7 = r7.floatValue();
        r4 = (double) r7;
        r7 = r2.floatValue();
        r1 = (double) r7;
        r0.<init>(r4, r1);
        r7 = new com.google.android.gms.maps.model.LatLng;
        r1 = r3.floatValue();
        r1 = (double) r1;
        r6 = r6.floatValue();
        r3 = (double) r6;
        r7.<init>(r1, r3);
        r6 = new com.google.android.gms.maps.model.LatLngBounds;
        r6.<init>(r0, r7);
        return r6;
    L_0x008e:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.maps.model.LatLngBounds.createFromAttributes(android.content.Context, android.util.AttributeSet):com.google.android.gms.maps.model.LatLngBounds");
    }

    private static double zza(double d, double d2) {
        return ((d - d2) + 360.0d) % 360.0d;
    }

    private static double zzb(double d, double d2) {
        return ((d2 - d) + 360.0d) % 360.0d;
    }

    private final boolean zzg(double d) {
        return this.southwest.longitude <= this.northeast.longitude ? this.southwest.longitude <= d && d <= this.northeast.longitude : this.southwest.longitude <= d || d <= this.northeast.longitude;
    }

    public final boolean contains(LatLng latLng) {
        double d = latLng.latitude;
        boolean z = this.southwest.latitude <= d && d <= this.northeast.latitude;
        return z && zzg(latLng.longitude);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LatLngBounds)) {
            return false;
        }
        LatLngBounds latLngBounds = (LatLngBounds) obj;
        return this.southwest.equals(latLngBounds.southwest) && this.northeast.equals(latLngBounds.northeast);
    }

    public final LatLng getCenter() {
        double d = (this.southwest.latitude + this.northeast.latitude) / 2.0d;
        double d2 = this.northeast.longitude;
        double d3 = this.southwest.longitude;
        if (d3 > d2) {
            d2 += 360.0d;
        }
        return new LatLng(d, (d2 + d3) / 2.0d);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.southwest, this.northeast});
    }

    public final LatLngBounds including(LatLng latLng) {
        double min = Math.min(this.southwest.latitude, latLng.latitude);
        double max = Math.max(this.northeast.latitude, latLng.latitude);
        double d = this.northeast.longitude;
        double d2 = this.southwest.longitude;
        double d3 = latLng.longitude;
        if (!zzg(d3)) {
            if (zza(d2, d3) < zzb(d, d3)) {
                d2 = d3;
            } else {
                d = d3;
            }
        }
        return new LatLngBounds(new LatLng(min, d2), new LatLng(max, d));
    }

    public final String toString() {
        return zzbg.zzx(this).zzg("southwest", this.southwest).zzg("northeast", this.northeast).toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int zze = zzbfp.zze(parcel);
        zzbfp.zza(parcel, 2, this.southwest, i, false);
        zzbfp.zza(parcel, 3, this.northeast, i, false);
        zzbfp.zzai(parcel, zze);
    }
}
