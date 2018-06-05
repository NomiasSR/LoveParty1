package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.location.Geofence;
import java.util.Locale;

public final class zzcfs extends zzbfm implements Geofence {
    public static final Creator<zzcfs> CREATOR = new zzcft();
    private final String zzcrt;
    private final int zziiy;
    private final short zzija;
    private final double zzijb;
    private final double zzijc;
    private final float zzijd;
    private final int zzije;
    private final int zzijf;
    private final long zzimd;

    public zzcfs(String str, int i, short s, double d, double d2, float f, long j, int i2, int i3) {
        if (str != null) {
            if (str.length() <= 100) {
                StringBuilder stringBuilder;
                if (f <= 0.0f) {
                    stringBuilder = new StringBuilder(31);
                    stringBuilder.append("invalid radius: ");
                    stringBuilder.append(f);
                    throw new IllegalArgumentException(stringBuilder.toString());
                }
                if (d <= 90.0d) {
                    if (d >= -90.0d) {
                        if (d2 <= 180.0d) {
                            if (d2 >= -180.0d) {
                                int i4 = i & 7;
                                if (i4 == 0) {
                                    StringBuilder stringBuilder2 = new StringBuilder(46);
                                    stringBuilder2.append("No supported transition specified: ");
                                    stringBuilder2.append(i);
                                    throw new IllegalArgumentException(stringBuilder2.toString());
                                }
                                this.zzija = s;
                                this.zzcrt = str;
                                this.zzijb = d;
                                this.zzijc = d2;
                                this.zzijd = f;
                                this.zzimd = j;
                                this.zziiy = i4;
                                this.zzije = i2;
                                this.zzijf = i3;
                                return;
                            }
                        }
                        stringBuilder = new StringBuilder(43);
                        stringBuilder.append("invalid longitude: ");
                        stringBuilder.append(d2);
                        throw new IllegalArgumentException(stringBuilder.toString());
                    }
                }
                stringBuilder = new StringBuilder(42);
                stringBuilder.append("invalid latitude: ");
                stringBuilder.append(d);
                throw new IllegalArgumentException(stringBuilder.toString());
            }
        }
        String str2 = "requestId is null or too long: ";
        str = String.valueOf(str);
        throw new IllegalArgumentException(str.length() != 0 ? str2.concat(str) : new String(str2));
    }

    public static zzcfs zzp(byte[] bArr) {
        Parcel obtain = Parcel.obtain();
        obtain.unmarshall(bArr, 0, bArr.length);
        obtain.setDataPosition(0);
        zzcfs com_google_android_gms_internal_zzcfs = (zzcfs) CREATOR.createFromParcel(obtain);
        obtain.recycle();
        return com_google_android_gms_internal_zzcfs;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof zzcfs)) {
            return false;
        }
        zzcfs com_google_android_gms_internal_zzcfs = (zzcfs) obj;
        return this.zzijd == com_google_android_gms_internal_zzcfs.zzijd && this.zzijb == com_google_android_gms_internal_zzcfs.zzijb && this.zzijc == com_google_android_gms_internal_zzcfs.zzijc && this.zzija == com_google_android_gms_internal_zzcfs.zzija;
    }

    public final String getRequestId() {
        return this.zzcrt;
    }

    public final int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.zzijb);
        int i = ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) + 31;
        long doubleToLongBits2 = Double.doubleToLongBits(this.zzijc);
        return (((((((i * 31) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)))) * 31) + Float.floatToIntBits(this.zzijd)) * 31) + this.zzija) * 31) + this.zziiy;
    }

    public final String toString() {
        Locale locale = Locale.US;
        String str = "Geofence[%s id:%s transitions:%d %.6f, %.6f %.0fm, resp=%ds, dwell=%dms, @%d]";
        Object[] objArr = new Object[9];
        objArr[0] = this.zzija != (short) 1 ? null : "CIRCLE";
        objArr[1] = this.zzcrt.replaceAll("\\p{C}", "?");
        objArr[2] = Integer.valueOf(this.zziiy);
        objArr[3] = Double.valueOf(this.zzijb);
        objArr[4] = Double.valueOf(this.zzijc);
        objArr[5] = Float.valueOf(this.zzijd);
        objArr[6] = Integer.valueOf(this.zzije / 1000);
        objArr[7] = Integer.valueOf(this.zzijf);
        objArr[8] = Long.valueOf(this.zzimd);
        return String.format(locale, str, objArr);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        i = zzbfp.zze(parcel);
        zzbfp.zza(parcel, 1, getRequestId(), false);
        zzbfp.zza(parcel, 2, this.zzimd);
        zzbfp.zza(parcel, 3, this.zzija);
        zzbfp.zza(parcel, 4, this.zzijb);
        zzbfp.zza(parcel, 5, this.zzijc);
        zzbfp.zza(parcel, 6, this.zzijd);
        zzbfp.zzc(parcel, 7, this.zziiy);
        zzbfp.zzc(parcel, 8, this.zzije);
        zzbfp.zzc(parcel, 9, this.zzijf);
        zzbfp.zzai(parcel, i);
    }
}
