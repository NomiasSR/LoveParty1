package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.internal.zzbfp;
import java.util.List;

public final class WakeLockEvent extends StatsEvent {
    public static final Creator<WakeLockEvent> CREATOR = new zzd();
    private final long mTimeout;
    private int zzeck;
    private final long zzgdl;
    private int zzgdm;
    private final String zzgdn;
    private final String zzgdo;
    private final String zzgdp;
    private final int zzgdq;
    private final List<String> zzgdr;
    private final String zzgds;
    private final long zzgdt;
    private int zzgdu;
    private final String zzgdv;
    private final float zzgdw;
    private long zzgdx;

    WakeLockEvent(int i, long j, int i2, String str, int i3, List<String> list, String str2, long j2, int i4, String str3, String str4, float f, long j3, String str5) {
        this.zzeck = i;
        this.zzgdl = j;
        this.zzgdm = i2;
        this.zzgdn = str;
        this.zzgdo = str3;
        this.zzgdp = str5;
        this.zzgdq = i3;
        this.zzgdx = -1;
        this.zzgdr = list;
        this.zzgds = str2;
        this.zzgdt = j2;
        this.zzgdu = i4;
        this.zzgdv = str4;
        this.zzgdw = f;
        this.mTimeout = j3;
    }

    public WakeLockEvent(long j, int i, String str, int i2, List<String> list, String str2, long j2, int i3, String str3, String str4, float f, long j3, String str5) {
        this(2, j, i, str, i2, list, str2, j2, i3, str3, str4, f, j3, str5);
    }

    public final int getEventType() {
        return this.zzgdm;
    }

    public final long getTimeMillis() {
        return this.zzgdl;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        i = zzbfp.zze(parcel);
        zzbfp.zzc(parcel, 1, this.zzeck);
        zzbfp.zza(parcel, 2, getTimeMillis());
        zzbfp.zza(parcel, 4, this.zzgdn, false);
        zzbfp.zzc(parcel, 5, this.zzgdq);
        zzbfp.zzb(parcel, 6, this.zzgdr, false);
        zzbfp.zza(parcel, 8, this.zzgdt);
        zzbfp.zza(parcel, 10, this.zzgdo, false);
        zzbfp.zzc(parcel, 11, getEventType());
        zzbfp.zza(parcel, 12, this.zzgds, false);
        zzbfp.zza(parcel, 13, this.zzgdv, false);
        zzbfp.zzc(parcel, 14, this.zzgdu);
        zzbfp.zza(parcel, 15, this.zzgdw);
        zzbfp.zza(parcel, 16, this.mTimeout);
        zzbfp.zza(parcel, 17, this.zzgdp, false);
        zzbfp.zzai(parcel, i);
    }

    public final long zzamd() {
        return this.zzgdx;
    }

    public final String zzame() {
        String str = "\t";
        String str2 = this.zzgdn;
        String str3 = "\t";
        int i = this.zzgdq;
        String str4 = "\t";
        String join = this.zzgdr == null ? "" : TextUtils.join(",", r0.zzgdr);
        String str5 = "\t";
        int i2 = r0.zzgdu;
        String str6 = "\t";
        String str7 = r0.zzgdo == null ? "" : r0.zzgdo;
        String str8 = "\t";
        String str9 = r0.zzgdv == null ? "" : r0.zzgdv;
        String str10 = "\t";
        String str11 = "\t";
        float f = r0.zzgdw;
        String str12 = r0.zzgdp == null ? "" : r0.zzgdp;
        String str13 = str12;
        StringBuilder stringBuilder = new StringBuilder(((((((((((((37 + String.valueOf(str).length()) + String.valueOf(str2).length()) + String.valueOf(str3).length()) + String.valueOf(str4).length()) + String.valueOf(join).length()) + String.valueOf(str5).length()) + String.valueOf(str6).length()) + String.valueOf(str7).length()) + String.valueOf(str8).length()) + String.valueOf(str9).length()) + String.valueOf(str10).length()) + String.valueOf(str11).length()) + String.valueOf(str12).length());
        stringBuilder.append(str);
        stringBuilder.append(str2);
        stringBuilder.append(str3);
        stringBuilder.append(i);
        stringBuilder.append(str4);
        stringBuilder.append(join);
        stringBuilder.append(str5);
        stringBuilder.append(i2);
        stringBuilder.append(str6);
        stringBuilder.append(str7);
        stringBuilder.append(str8);
        stringBuilder.append(str9);
        stringBuilder.append(str10);
        stringBuilder.append(f);
        stringBuilder.append(str11);
        stringBuilder.append(str13);
        return stringBuilder.toString();
    }
}
