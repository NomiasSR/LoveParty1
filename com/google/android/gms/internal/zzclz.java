package com.google.android.gms.internal;

import java.io.IOException;

public final class zzclz extends zzfjm<zzclz> {
    private static volatile zzclz[] zzjlb;
    public String key;
    public String value;

    public zzclz() {
        this.key = null;
        this.value = null;
        this.zzpnc = null;
        this.zzpfd = -1;
    }

    public static zzclz[] zzbbf() {
        if (zzjlb == null) {
            synchronized (zzfjq.zzpnk) {
                if (zzjlb == null) {
                    zzjlb = new zzclz[0];
                }
            }
        }
        return zzjlb;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzclz)) {
            return false;
        }
        zzclz com_google_android_gms_internal_zzclz = (zzclz) obj;
        if (this.key == null) {
            if (com_google_android_gms_internal_zzclz.key != null) {
                return false;
            }
        } else if (!this.key.equals(com_google_android_gms_internal_zzclz.key)) {
            return false;
        }
        if (this.value == null) {
            if (com_google_android_gms_internal_zzclz.value != null) {
                return false;
            }
        } else if (!this.value.equals(com_google_android_gms_internal_zzclz.value)) {
            return false;
        }
        if (this.zzpnc != null) {
            if (!this.zzpnc.isEmpty()) {
                return this.zzpnc.equals(com_google_android_gms_internal_zzclz.zzpnc);
            }
        }
        return com_google_android_gms_internal_zzclz.zzpnc == null || com_google_android_gms_internal_zzclz.zzpnc.isEmpty();
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = (((((527 + getClass().getName().hashCode()) * 31) + (this.key == null ? 0 : this.key.hashCode())) * 31) + (this.value == null ? 0 : this.value.hashCode())) * 31;
        if (this.zzpnc != null) {
            if (!this.zzpnc.isEmpty()) {
                i = this.zzpnc.hashCode();
            }
        }
        return hashCode + i;
    }

    public final /* synthetic */ zzfjs zza(zzfjj com_google_android_gms_internal_zzfjj) throws IOException {
        while (true) {
            int zzcvt = com_google_android_gms_internal_zzfjj.zzcvt();
            if (zzcvt == 0) {
                return this;
            }
            if (zzcvt == 10) {
                this.key = com_google_android_gms_internal_zzfjj.readString();
            } else if (zzcvt == 18) {
                this.value = com_google_android_gms_internal_zzfjj.readString();
            } else if (!super.zza(com_google_android_gms_internal_zzfjj, zzcvt)) {
                return this;
            }
        }
    }

    public final void zza(zzfjk com_google_android_gms_internal_zzfjk) throws IOException {
        if (this.key != null) {
            com_google_android_gms_internal_zzfjk.zzn(1, this.key);
        }
        if (this.value != null) {
            com_google_android_gms_internal_zzfjk.zzn(2, this.value);
        }
        super.zza(com_google_android_gms_internal_zzfjk);
    }

    protected final int zzq() {
        int zzq = super.zzq();
        if (this.key != null) {
            zzq += zzfjk.zzo(1, this.key);
        }
        return this.value != null ? zzq + zzfjk.zzo(2, this.value) : zzq;
    }
}
