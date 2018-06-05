package com.google.android.gms.internal;

import com.google.android.gms.common.internal.zzbq;

final class zzcgw {
    final String mAppId;
    final String mName;
    final long zzizk;
    final long zzizl;
    final long zzizm;
    final long zzizn;
    final Long zzizo;
    final Long zzizp;
    final Boolean zzizq;

    zzcgw(String str, String str2, long j, long j2, long j3, long j4, Long l, Long l2, Boolean bool) {
        zzcgw com_google_android_gms_internal_zzcgw = this;
        long j5 = j;
        long j6 = j2;
        long j7 = j4;
        zzbq.zzgm(str);
        zzbq.zzgm(str2);
        boolean z = false;
        zzbq.checkArgument(j5 >= 0);
        zzbq.checkArgument(j6 >= 0);
        if (j7 >= 0) {
            z = true;
        }
        zzbq.checkArgument(z);
        com_google_android_gms_internal_zzcgw.mAppId = str;
        com_google_android_gms_internal_zzcgw.mName = str2;
        com_google_android_gms_internal_zzcgw.zzizk = j5;
        com_google_android_gms_internal_zzcgw.zzizl = j6;
        com_google_android_gms_internal_zzcgw.zzizm = j3;
        com_google_android_gms_internal_zzcgw.zzizn = j7;
        com_google_android_gms_internal_zzcgw.zzizo = l;
        com_google_android_gms_internal_zzcgw.zzizp = l2;
        com_google_android_gms_internal_zzcgw.zzizq = bool;
    }

    final zzcgw zza(Long l, Long l2, Boolean bool) {
        zzcgw com_google_android_gms_internal_zzcgw = this;
        Boolean bool2 = (bool == null || bool.booleanValue()) ? bool : null;
        return new zzcgw(com_google_android_gms_internal_zzcgw.mAppId, com_google_android_gms_internal_zzcgw.mName, com_google_android_gms_internal_zzcgw.zzizk, com_google_android_gms_internal_zzcgw.zzizl, com_google_android_gms_internal_zzcgw.zzizm, com_google_android_gms_internal_zzcgw.zzizn, l, l2, bool2);
    }

    final zzcgw zzayw() {
        return new zzcgw(this.mAppId, this.mName, this.zzizk + 1, 1 + this.zzizl, this.zzizm, this.zzizn, this.zzizo, this.zzizp, this.zzizq);
    }

    final zzcgw zzbb(long j) {
        return new zzcgw(this.mAppId, this.mName, this.zzizk, this.zzizl, j, this.zzizn, this.zzizo, this.zzizp, this.zzizq);
    }

    final zzcgw zzbc(long j) {
        return new zzcgw(this.mAppId, this.mName, this.zzizk, this.zzizl, this.zzizm, j, this.zzizo, this.zzizp, this.zzizq);
    }
}
