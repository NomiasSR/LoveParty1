package com.google.android.gms.internal;

import java.io.IOException;

public final class zzfko extends zzfjm<zzfko> implements Cloneable {
    private String version;
    private int zziyd;
    private String zzpqg;

    public zzfko() {
        this.zziyd = 0;
        this.zzpqg = "";
        this.version = "";
        this.zzpnc = null;
        this.zzpfd = -1;
    }

    private zzfko zzdax() {
        try {
            return (zzfko) super.zzdaf();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        return zzdax();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzfko)) {
            return false;
        }
        zzfko com_google_android_gms_internal_zzfko = (zzfko) obj;
        if (this.zziyd != com_google_android_gms_internal_zzfko.zziyd) {
            return false;
        }
        if (this.zzpqg == null) {
            if (com_google_android_gms_internal_zzfko.zzpqg != null) {
                return false;
            }
        } else if (!this.zzpqg.equals(com_google_android_gms_internal_zzfko.zzpqg)) {
            return false;
        }
        if (this.version == null) {
            if (com_google_android_gms_internal_zzfko.version != null) {
                return false;
            }
        } else if (!this.version.equals(com_google_android_gms_internal_zzfko.version)) {
            return false;
        }
        if (this.zzpnc != null) {
            if (!this.zzpnc.isEmpty()) {
                return this.zzpnc.equals(com_google_android_gms_internal_zzfko.zzpnc);
            }
        }
        return com_google_android_gms_internal_zzfko.zzpnc == null || com_google_android_gms_internal_zzfko.zzpnc.isEmpty();
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = (((((((527 + getClass().getName().hashCode()) * 31) + this.zziyd) * 31) + (this.zzpqg == null ? 0 : this.zzpqg.hashCode())) * 31) + (this.version == null ? 0 : this.version.hashCode())) * 31;
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
            if (zzcvt == 8) {
                this.zziyd = com_google_android_gms_internal_zzfjj.zzcvw();
            } else if (zzcvt == 18) {
                this.zzpqg = com_google_android_gms_internal_zzfjj.readString();
            } else if (zzcvt == 26) {
                this.version = com_google_android_gms_internal_zzfjj.readString();
            } else if (!super.zza(com_google_android_gms_internal_zzfjj, zzcvt)) {
                return this;
            }
        }
    }

    public final void zza(zzfjk com_google_android_gms_internal_zzfjk) throws IOException {
        if (this.zziyd != 0) {
            com_google_android_gms_internal_zzfjk.zzaa(1, this.zziyd);
        }
        if (!(this.zzpqg == null || this.zzpqg.equals(""))) {
            com_google_android_gms_internal_zzfjk.zzn(2, this.zzpqg);
        }
        if (!(this.version == null || this.version.equals(""))) {
            com_google_android_gms_internal_zzfjk.zzn(3, this.version);
        }
        super.zza(com_google_android_gms_internal_zzfjk);
    }

    public final /* synthetic */ zzfjm zzdaf() throws CloneNotSupportedException {
        return (zzfko) clone();
    }

    public final /* synthetic */ zzfjs zzdag() throws CloneNotSupportedException {
        return (zzfko) clone();
    }

    protected final int zzq() {
        int zzq = super.zzq();
        if (this.zziyd != 0) {
            zzq += zzfjk.zzad(1, this.zziyd);
        }
        if (!(this.zzpqg == null || this.zzpqg.equals(""))) {
            zzq += zzfjk.zzo(2, this.zzpqg);
        }
        return (this.version == null || this.version.equals("")) ? zzq : zzq + zzfjk.zzo(3, this.version);
    }
}
