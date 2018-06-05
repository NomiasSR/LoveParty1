package com.google.android.gms.internal;

import java.io.IOException;

public final class zzfkr extends zzfjm<zzfkr> implements Cloneable {
    private static volatile zzfkr[] zzpre;
    private String key;
    private String value;

    public zzfkr() {
        this.key = "";
        this.value = "";
        this.zzpnc = null;
        this.zzpfd = -1;
    }

    public static zzfkr[] zzdba() {
        if (zzpre == null) {
            synchronized (zzfjq.zzpnk) {
                if (zzpre == null) {
                    zzpre = new zzfkr[0];
                }
            }
        }
        return zzpre;
    }

    private zzfkr zzdbb() {
        try {
            return (zzfkr) super.zzdaf();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        return zzdbb();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzfkr)) {
            return false;
        }
        zzfkr com_google_android_gms_internal_zzfkr = (zzfkr) obj;
        if (this.key == null) {
            if (com_google_android_gms_internal_zzfkr.key != null) {
                return false;
            }
        } else if (!this.key.equals(com_google_android_gms_internal_zzfkr.key)) {
            return false;
        }
        if (this.value == null) {
            if (com_google_android_gms_internal_zzfkr.value != null) {
                return false;
            }
        } else if (!this.value.equals(com_google_android_gms_internal_zzfkr.value)) {
            return false;
        }
        if (this.zzpnc != null) {
            if (!this.zzpnc.isEmpty()) {
                return this.zzpnc.equals(com_google_android_gms_internal_zzfkr.zzpnc);
            }
        }
        return com_google_android_gms_internal_zzfkr.zzpnc == null || com_google_android_gms_internal_zzfkr.zzpnc.isEmpty();
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
        if (!(this.key == null || this.key.equals(""))) {
            com_google_android_gms_internal_zzfjk.zzn(1, this.key);
        }
        if (!(this.value == null || this.value.equals(""))) {
            com_google_android_gms_internal_zzfjk.zzn(2, this.value);
        }
        super.zza(com_google_android_gms_internal_zzfjk);
    }

    public final /* synthetic */ zzfjm zzdaf() throws CloneNotSupportedException {
        return (zzfkr) clone();
    }

    public final /* synthetic */ zzfjs zzdag() throws CloneNotSupportedException {
        return (zzfkr) clone();
    }

    protected final int zzq() {
        int zzq = super.zzq();
        if (!(this.key == null || this.key.equals(""))) {
            zzq += zzfjk.zzo(1, this.key);
        }
        return (this.value == null || this.value.equals("")) ? zzq : zzq + zzfjk.zzo(2, this.value);
    }
}
