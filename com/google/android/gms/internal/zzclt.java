package com.google.android.gms.internal;

import java.io.IOException;

public final class zzclt extends zzfjm<zzclt> {
    private static volatile zzclt[] zzjkb;
    public zzclw zzjkc;
    public zzclu zzjkd;
    public Boolean zzjke;
    public String zzjkf;

    public zzclt() {
        this.zzjkc = null;
        this.zzjkd = null;
        this.zzjke = null;
        this.zzjkf = null;
        this.zzpnc = null;
        this.zzpfd = -1;
    }

    public static zzclt[] zzbbc() {
        if (zzjkb == null) {
            synchronized (zzfjq.zzpnk) {
                if (zzjkb == null) {
                    zzjkb = new zzclt[0];
                }
            }
        }
        return zzjkb;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzclt)) {
            return false;
        }
        zzclt com_google_android_gms_internal_zzclt = (zzclt) obj;
        if (this.zzjkc == null) {
            if (com_google_android_gms_internal_zzclt.zzjkc != null) {
                return false;
            }
        } else if (!this.zzjkc.equals(com_google_android_gms_internal_zzclt.zzjkc)) {
            return false;
        }
        if (this.zzjkd == null) {
            if (com_google_android_gms_internal_zzclt.zzjkd != null) {
                return false;
            }
        } else if (!this.zzjkd.equals(com_google_android_gms_internal_zzclt.zzjkd)) {
            return false;
        }
        if (this.zzjke == null) {
            if (com_google_android_gms_internal_zzclt.zzjke != null) {
                return false;
            }
        } else if (!this.zzjke.equals(com_google_android_gms_internal_zzclt.zzjke)) {
            return false;
        }
        if (this.zzjkf == null) {
            if (com_google_android_gms_internal_zzclt.zzjkf != null) {
                return false;
            }
        } else if (!this.zzjkf.equals(com_google_android_gms_internal_zzclt.zzjkf)) {
            return false;
        }
        if (this.zzpnc != null) {
            if (!this.zzpnc.isEmpty()) {
                return this.zzpnc.equals(com_google_android_gms_internal_zzclt.zzpnc);
            }
        }
        return com_google_android_gms_internal_zzclt.zzpnc == null || com_google_android_gms_internal_zzclt.zzpnc.isEmpty();
    }

    public final int hashCode() {
        int hashCode = 527 + getClass().getName().hashCode();
        zzclw com_google_android_gms_internal_zzclw = this.zzjkc;
        int i = 0;
        hashCode = (hashCode * 31) + (com_google_android_gms_internal_zzclw == null ? 0 : com_google_android_gms_internal_zzclw.hashCode());
        zzclu com_google_android_gms_internal_zzclu = this.zzjkd;
        hashCode = ((((((hashCode * 31) + (com_google_android_gms_internal_zzclu == null ? 0 : com_google_android_gms_internal_zzclu.hashCode())) * 31) + (this.zzjke == null ? 0 : this.zzjke.hashCode())) * 31) + (this.zzjkf == null ? 0 : this.zzjkf.hashCode())) * 31;
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
            zzfjs com_google_android_gms_internal_zzfjs;
            if (zzcvt == 10) {
                if (this.zzjkc == null) {
                    this.zzjkc = new zzclw();
                }
                com_google_android_gms_internal_zzfjs = this.zzjkc;
            } else if (zzcvt == 18) {
                if (this.zzjkd == null) {
                    this.zzjkd = new zzclu();
                }
                com_google_android_gms_internal_zzfjs = this.zzjkd;
            } else if (zzcvt == 24) {
                this.zzjke = Boolean.valueOf(com_google_android_gms_internal_zzfjj.zzcvz());
            } else if (zzcvt == 34) {
                this.zzjkf = com_google_android_gms_internal_zzfjj.readString();
            } else if (!super.zza(com_google_android_gms_internal_zzfjj, zzcvt)) {
                return this;
            }
            com_google_android_gms_internal_zzfjj.zza(com_google_android_gms_internal_zzfjs);
        }
    }

    public final void zza(zzfjk com_google_android_gms_internal_zzfjk) throws IOException {
        if (this.zzjkc != null) {
            com_google_android_gms_internal_zzfjk.zza(1, this.zzjkc);
        }
        if (this.zzjkd != null) {
            com_google_android_gms_internal_zzfjk.zza(2, this.zzjkd);
        }
        if (this.zzjke != null) {
            com_google_android_gms_internal_zzfjk.zzl(3, this.zzjke.booleanValue());
        }
        if (this.zzjkf != null) {
            com_google_android_gms_internal_zzfjk.zzn(4, this.zzjkf);
        }
        super.zza(com_google_android_gms_internal_zzfjk);
    }

    protected final int zzq() {
        int zzq = super.zzq();
        if (this.zzjkc != null) {
            zzq += zzfjk.zzb(1, this.zzjkc);
        }
        if (this.zzjkd != null) {
            zzq += zzfjk.zzb(2, this.zzjkd);
        }
        if (this.zzjke != null) {
            this.zzjke.booleanValue();
            zzq += zzfjk.zzlg(3) + 1;
        }
        return this.zzjkf != null ? zzq + zzfjk.zzo(4, this.zzjkf) : zzq;
    }
}
