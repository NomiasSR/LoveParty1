package com.google.android.gms.internal;

import java.io.IOException;

public final class zzcmg extends zzfjm<zzcmg> {
    private static volatile zzcmg[] zzjmr;
    public String name;
    public String zzgcc;
    private Float zzjjk;
    public Double zzjjl;
    public Long zzjll;
    public Long zzjms;

    public zzcmg() {
        this.zzjms = null;
        this.name = null;
        this.zzgcc = null;
        this.zzjll = null;
        this.zzjjk = null;
        this.zzjjl = null;
        this.zzpnc = null;
        this.zzpfd = -1;
    }

    public static zzcmg[] zzbbk() {
        if (zzjmr == null) {
            synchronized (zzfjq.zzpnk) {
                if (zzjmr == null) {
                    zzjmr = new zzcmg[0];
                }
            }
        }
        return zzjmr;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzcmg)) {
            return false;
        }
        zzcmg com_google_android_gms_internal_zzcmg = (zzcmg) obj;
        if (this.zzjms == null) {
            if (com_google_android_gms_internal_zzcmg.zzjms != null) {
                return false;
            }
        } else if (!this.zzjms.equals(com_google_android_gms_internal_zzcmg.zzjms)) {
            return false;
        }
        if (this.name == null) {
            if (com_google_android_gms_internal_zzcmg.name != null) {
                return false;
            }
        } else if (!this.name.equals(com_google_android_gms_internal_zzcmg.name)) {
            return false;
        }
        if (this.zzgcc == null) {
            if (com_google_android_gms_internal_zzcmg.zzgcc != null) {
                return false;
            }
        } else if (!this.zzgcc.equals(com_google_android_gms_internal_zzcmg.zzgcc)) {
            return false;
        }
        if (this.zzjll == null) {
            if (com_google_android_gms_internal_zzcmg.zzjll != null) {
                return false;
            }
        } else if (!this.zzjll.equals(com_google_android_gms_internal_zzcmg.zzjll)) {
            return false;
        }
        if (this.zzjjk == null) {
            if (com_google_android_gms_internal_zzcmg.zzjjk != null) {
                return false;
            }
        } else if (!this.zzjjk.equals(com_google_android_gms_internal_zzcmg.zzjjk)) {
            return false;
        }
        if (this.zzjjl == null) {
            if (com_google_android_gms_internal_zzcmg.zzjjl != null) {
                return false;
            }
        } else if (!this.zzjjl.equals(com_google_android_gms_internal_zzcmg.zzjjl)) {
            return false;
        }
        if (this.zzpnc != null) {
            if (!this.zzpnc.isEmpty()) {
                return this.zzpnc.equals(com_google_android_gms_internal_zzcmg.zzpnc);
            }
        }
        return com_google_android_gms_internal_zzcmg.zzpnc == null || com_google_android_gms_internal_zzcmg.zzpnc.isEmpty();
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = (((((((((((((527 + getClass().getName().hashCode()) * 31) + (this.zzjms == null ? 0 : this.zzjms.hashCode())) * 31) + (this.name == null ? 0 : this.name.hashCode())) * 31) + (this.zzgcc == null ? 0 : this.zzgcc.hashCode())) * 31) + (this.zzjll == null ? 0 : this.zzjll.hashCode())) * 31) + (this.zzjjk == null ? 0 : this.zzjjk.hashCode())) * 31) + (this.zzjjl == null ? 0 : this.zzjjl.hashCode())) * 31;
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
                this.zzjms = Long.valueOf(com_google_android_gms_internal_zzfjj.zzcwn());
            } else if (zzcvt == 18) {
                this.name = com_google_android_gms_internal_zzfjj.readString();
            } else if (zzcvt == 26) {
                this.zzgcc = com_google_android_gms_internal_zzfjj.readString();
            } else if (zzcvt == 32) {
                this.zzjll = Long.valueOf(com_google_android_gms_internal_zzfjj.zzcwn());
            } else if (zzcvt == 45) {
                this.zzjjk = Float.valueOf(Float.intBitsToFloat(com_google_android_gms_internal_zzfjj.zzcwo()));
            } else if (zzcvt == 49) {
                this.zzjjl = Double.valueOf(Double.longBitsToDouble(com_google_android_gms_internal_zzfjj.zzcwp()));
            } else if (!super.zza(com_google_android_gms_internal_zzfjj, zzcvt)) {
                return this;
            }
        }
    }

    public final void zza(zzfjk com_google_android_gms_internal_zzfjk) throws IOException {
        if (this.zzjms != null) {
            com_google_android_gms_internal_zzfjk.zzf(1, this.zzjms.longValue());
        }
        if (this.name != null) {
            com_google_android_gms_internal_zzfjk.zzn(2, this.name);
        }
        if (this.zzgcc != null) {
            com_google_android_gms_internal_zzfjk.zzn(3, this.zzgcc);
        }
        if (this.zzjll != null) {
            com_google_android_gms_internal_zzfjk.zzf(4, this.zzjll.longValue());
        }
        if (this.zzjjk != null) {
            com_google_android_gms_internal_zzfjk.zzc(5, this.zzjjk.floatValue());
        }
        if (this.zzjjl != null) {
            com_google_android_gms_internal_zzfjk.zza(6, this.zzjjl.doubleValue());
        }
        super.zza(com_google_android_gms_internal_zzfjk);
    }

    protected final int zzq() {
        int zzq = super.zzq();
        if (this.zzjms != null) {
            zzq += zzfjk.zzc(1, this.zzjms.longValue());
        }
        if (this.name != null) {
            zzq += zzfjk.zzo(2, this.name);
        }
        if (this.zzgcc != null) {
            zzq += zzfjk.zzo(3, this.zzgcc);
        }
        if (this.zzjll != null) {
            zzq += zzfjk.zzc(4, this.zzjll.longValue());
        }
        if (this.zzjjk != null) {
            this.zzjjk.floatValue();
            zzq += zzfjk.zzlg(5) + 4;
        }
        if (this.zzjjl == null) {
            return zzq;
        }
        this.zzjjl.doubleValue();
        return zzq + (zzfjk.zzlg(6) + 8);
    }
}
