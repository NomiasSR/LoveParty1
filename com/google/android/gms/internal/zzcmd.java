package com.google.android.gms.internal;

import java.io.IOException;

public final class zzcmd extends zzfjm<zzcmd> {
    public zzcme[] zzjlm;

    public zzcmd() {
        this.zzjlm = zzcme.zzbbj();
        this.zzpnc = null;
        this.zzpfd = -1;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzcmd)) {
            return false;
        }
        zzcmd com_google_android_gms_internal_zzcmd = (zzcmd) obj;
        if (!zzfjq.equals(this.zzjlm, com_google_android_gms_internal_zzcmd.zzjlm)) {
            return false;
        }
        if (this.zzpnc != null) {
            if (!this.zzpnc.isEmpty()) {
                return this.zzpnc.equals(com_google_android_gms_internal_zzcmd.zzpnc);
            }
        }
        return com_google_android_gms_internal_zzcmd.zzpnc == null || com_google_android_gms_internal_zzcmd.zzpnc.isEmpty();
    }

    public final int hashCode() {
        int hashCode;
        int hashCode2 = (((527 + getClass().getName().hashCode()) * 31) + zzfjq.hashCode(this.zzjlm)) * 31;
        if (this.zzpnc != null) {
            if (!this.zzpnc.isEmpty()) {
                hashCode = this.zzpnc.hashCode();
                return hashCode2 + hashCode;
            }
        }
        hashCode = 0;
        return hashCode2 + hashCode;
    }

    public final /* synthetic */ zzfjs zza(zzfjj com_google_android_gms_internal_zzfjj) throws IOException {
        while (true) {
            int zzcvt = com_google_android_gms_internal_zzfjj.zzcvt();
            if (zzcvt == 0) {
                return this;
            }
            if (zzcvt == 10) {
                zzcvt = zzfjv.zzb(com_google_android_gms_internal_zzfjj, 10);
                int length = this.zzjlm == null ? 0 : this.zzjlm.length;
                Object obj = new zzcme[(zzcvt + length)];
                if (length != 0) {
                    System.arraycopy(this.zzjlm, 0, obj, 0, length);
                }
                while (length < obj.length - 1) {
                    obj[length] = new zzcme();
                    com_google_android_gms_internal_zzfjj.zza(obj[length]);
                    com_google_android_gms_internal_zzfjj.zzcvt();
                    length++;
                }
                obj[length] = new zzcme();
                com_google_android_gms_internal_zzfjj.zza(obj[length]);
                this.zzjlm = obj;
            } else if (!super.zza(com_google_android_gms_internal_zzfjj, zzcvt)) {
                return this;
            }
        }
    }

    public final void zza(zzfjk com_google_android_gms_internal_zzfjk) throws IOException {
        if (this.zzjlm != null && this.zzjlm.length > 0) {
            for (zzfjs com_google_android_gms_internal_zzfjs : this.zzjlm) {
                if (com_google_android_gms_internal_zzfjs != null) {
                    com_google_android_gms_internal_zzfjk.zza(1, com_google_android_gms_internal_zzfjs);
                }
            }
        }
        super.zza(com_google_android_gms_internal_zzfjk);
    }

    protected final int zzq() {
        int zzq = super.zzq();
        if (this.zzjlm != null && this.zzjlm.length > 0) {
            for (zzfjs com_google_android_gms_internal_zzfjs : this.zzjlm) {
                if (com_google_android_gms_internal_zzfjs != null) {
                    zzq += zzfjk.zzb(1, com_google_android_gms_internal_zzfjs);
                }
            }
        }
        return zzq;
    }
}
