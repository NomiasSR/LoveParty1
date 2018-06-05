package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.zzbg;
import com.google.android.gms.common.internal.zzbq;
import java.util.Arrays;

public final class zzbew extends zzbfm {
    public static final Creator<zzbew> CREATOR = new zzbex();
    private String packageName;
    private int zzfja;
    public final String zzfjb;
    public final int zzfjc;
    private String zzfjd;
    private String zzfje;
    private boolean zzfjf;
    private int zzfjg;
    private boolean zzfko;

    public zzbew(String str, int i, int i2, String str2, String str3, String str4, boolean z, int i3) {
        this.packageName = (String) zzbq.checkNotNull(str);
        this.zzfja = i;
        this.zzfjc = i2;
        this.zzfjb = str2;
        this.zzfjd = str3;
        this.zzfje = str4;
        this.zzfko = z ^ 1;
        this.zzfjf = z;
        this.zzfjg = i3;
    }

    public zzbew(String str, int i, int i2, String str2, String str3, boolean z, String str4, boolean z2, int i3) {
        this.packageName = str;
        this.zzfja = i;
        this.zzfjc = i2;
        this.zzfjd = str2;
        this.zzfje = str3;
        this.zzfko = z;
        this.zzfjb = str4;
        this.zzfjf = z2;
        this.zzfjg = i3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzbew) {
            zzbew com_google_android_gms_internal_zzbew = (zzbew) obj;
            return zzbg.equal(this.packageName, com_google_android_gms_internal_zzbew.packageName) && this.zzfja == com_google_android_gms_internal_zzbew.zzfja && this.zzfjc == com_google_android_gms_internal_zzbew.zzfjc && zzbg.equal(this.zzfjb, com_google_android_gms_internal_zzbew.zzfjb) && zzbg.equal(this.zzfjd, com_google_android_gms_internal_zzbew.zzfjd) && zzbg.equal(this.zzfje, com_google_android_gms_internal_zzbew.zzfje) && this.zzfko == com_google_android_gms_internal_zzbew.zzfko && this.zzfjf == com_google_android_gms_internal_zzbew.zzfjf && this.zzfjg == com_google_android_gms_internal_zzbew.zzfjg;
        }
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.packageName, Integer.valueOf(this.zzfja), Integer.valueOf(this.zzfjc), this.zzfjb, this.zzfjd, this.zzfje, Boolean.valueOf(this.zzfko), Boolean.valueOf(this.zzfjf), Integer.valueOf(this.zzfjg)});
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("PlayLoggerContext[");
        stringBuilder.append("package=");
        stringBuilder.append(this.packageName);
        stringBuilder.append(',');
        stringBuilder.append("packageVersionCode=");
        stringBuilder.append(this.zzfja);
        stringBuilder.append(',');
        stringBuilder.append("logSource=");
        stringBuilder.append(this.zzfjc);
        stringBuilder.append(',');
        stringBuilder.append("logSourceName=");
        stringBuilder.append(this.zzfjb);
        stringBuilder.append(',');
        stringBuilder.append("uploadAccount=");
        stringBuilder.append(this.zzfjd);
        stringBuilder.append(',');
        stringBuilder.append("loggingId=");
        stringBuilder.append(this.zzfje);
        stringBuilder.append(',');
        stringBuilder.append("logAndroidId=");
        stringBuilder.append(this.zzfko);
        stringBuilder.append(',');
        stringBuilder.append("isAnonymous=");
        stringBuilder.append(this.zzfjf);
        stringBuilder.append(',');
        stringBuilder.append("qosTier=");
        stringBuilder.append(this.zzfjg);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        i = zzbfp.zze(parcel);
        zzbfp.zza(parcel, 2, this.packageName, false);
        zzbfp.zzc(parcel, 3, this.zzfja);
        zzbfp.zzc(parcel, 4, this.zzfjc);
        zzbfp.zza(parcel, 5, this.zzfjd, false);
        zzbfp.zza(parcel, 6, this.zzfje, false);
        zzbfp.zza(parcel, 7, this.zzfko);
        zzbfp.zza(parcel, 8, this.zzfjb, false);
        zzbfp.zza(parcel, 9, this.zzfjf);
        zzbfp.zzc(parcel, 10, this.zzfjg);
        zzbfp.zzai(parcel, i);
    }
}
