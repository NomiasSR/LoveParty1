package com.google.android.gms.internal;

import java.util.Iterator;

public final class zzeiv implements zzeiw {
    private final int limit;
    private final zzejv zznaa;
    private final zzeiy zznbe;
    private final boolean zznbf;

    public zzeiv(zzeih com_google_android_gms_internal_zzeih) {
        this.zznbe = new zzeiy(com_google_android_gms_internal_zzeih);
        this.zznaa = com_google_android_gms_internal_zzeih.zzbyr();
        this.limit = com_google_android_gms_internal_zzeih.getLimit();
        this.zznbf = com_google_android_gms_internal_zzeih.zzbyt() ^ 1;
    }

    public final zzejw zza(zzejw com_google_android_gms_internal_zzejw, zzejg com_google_android_gms_internal_zzejg, zzekd com_google_android_gms_internal_zzekd, zzedk com_google_android_gms_internal_zzedk, zzeix com_google_android_gms_internal_zzeix, zzeit com_google_android_gms_internal_zzeit) {
        if (!this.zznbe.zza(new zzekc(com_google_android_gms_internal_zzejg, com_google_android_gms_internal_zzekd))) {
            com_google_android_gms_internal_zzekd = zzeju.zzcaf();
        }
        zzekd com_google_android_gms_internal_zzekd2 = com_google_android_gms_internal_zzekd;
        if (com_google_android_gms_internal_zzejw.zzbsv().zzm(com_google_android_gms_internal_zzejg).equals(com_google_android_gms_internal_zzekd2)) {
            return com_google_android_gms_internal_zzejw;
        }
        if (com_google_android_gms_internal_zzejw.zzbsv().getChildCount() < this.limit) {
            return this.zznbe.zzbzh().zza(com_google_android_gms_internal_zzejw, com_google_android_gms_internal_zzejg, com_google_android_gms_internal_zzekd2, com_google_android_gms_internal_zzedk, com_google_android_gms_internal_zzeix, com_google_android_gms_internal_zzeit);
        }
        zzekc com_google_android_gms_internal_zzekc = new zzekc(com_google_android_gms_internal_zzejg, com_google_android_gms_internal_zzekd2);
        zzekc zzcaj = this.zznbf ? com_google_android_gms_internal_zzejw.zzcaj() : com_google_android_gms_internal_zzejw.zzcak();
        boolean zza = this.zznbe.zza(com_google_android_gms_internal_zzekc);
        if (com_google_android_gms_internal_zzejw.zzbsv().zzk(com_google_android_gms_internal_zzejg)) {
            zzekd zzm = com_google_android_gms_internal_zzejw.zzbsv().zzm(com_google_android_gms_internal_zzejg);
            while (true) {
                zzcaj = com_google_android_gms_internal_zzeix.zza(this.zznaa, zzcaj, this.zznbf);
                if (zzcaj != null) {
                    if (!zzcaj.zzcao().equals(com_google_android_gms_internal_zzejg)) {
                        if (!com_google_android_gms_internal_zzejw.zzbsv().zzk(zzcaj.zzcao())) {
                            break;
                        }
                    }
                } else {
                    break;
                }
            }
            Object obj = 1;
            Object obj2 = (!zza || com_google_android_gms_internal_zzekd2.isEmpty() || (zzcaj == null ? 1 : this.zznaa.zza(zzcaj, com_google_android_gms_internal_zzekc, this.zznbf)) < 0) ? null : 1;
            if (obj2 != null) {
                if (com_google_android_gms_internal_zzeit != null) {
                    com_google_android_gms_internal_zzeit.zza(zzehz.zza(com_google_android_gms_internal_zzejg, com_google_android_gms_internal_zzekd2, zzm));
                }
                return com_google_android_gms_internal_zzejw.zzg(com_google_android_gms_internal_zzejg, com_google_android_gms_internal_zzekd2);
            }
            if (com_google_android_gms_internal_zzeit != null) {
                com_google_android_gms_internal_zzeit.zza(zzehz.zzd(com_google_android_gms_internal_zzejg, zzm));
            }
            com_google_android_gms_internal_zzejw = com_google_android_gms_internal_zzejw.zzg(com_google_android_gms_internal_zzejg, zzeju.zzcaf());
            if (zzcaj == null || !this.zznbe.zza(zzcaj)) {
                obj = null;
            }
            if (obj != null) {
                if (com_google_android_gms_internal_zzeit != null) {
                    com_google_android_gms_internal_zzeit.zza(zzehz.zzc(zzcaj.zzcao(), zzcaj.zzbsv()));
                }
                com_google_android_gms_internal_zzejw = com_google_android_gms_internal_zzejw.zzg(zzcaj.zzcao(), zzcaj.zzbsv());
            }
            return com_google_android_gms_internal_zzejw;
        }
        if (!com_google_android_gms_internal_zzekd2.isEmpty() && zza && this.zznaa.zza(zzcaj, com_google_android_gms_internal_zzekc, this.zznbf) >= 0) {
            if (com_google_android_gms_internal_zzeit != null) {
                com_google_android_gms_internal_zzeit.zza(zzehz.zzd(zzcaj.zzcao(), zzcaj.zzbsv()));
                com_google_android_gms_internal_zzeit.zza(zzehz.zzc(com_google_android_gms_internal_zzejg, com_google_android_gms_internal_zzekd2));
            }
            com_google_android_gms_internal_zzejw = com_google_android_gms_internal_zzejw.zzg(com_google_android_gms_internal_zzejg, com_google_android_gms_internal_zzekd2).zzg(zzcaj.zzcao(), zzeju.zzcaf());
        }
        return com_google_android_gms_internal_zzejw;
    }

    public final zzejw zza(zzejw com_google_android_gms_internal_zzejw, zzejw com_google_android_gms_internal_zzejw2, zzeit com_google_android_gms_internal_zzeit) {
        zzejw zzk;
        if (!com_google_android_gms_internal_zzejw2.zzbsv().zzbzu()) {
            if (!com_google_android_gms_internal_zzejw2.zzbsv().isEmpty()) {
                Iterator zzbti;
                Object zzbzj;
                int i;
                zzk = com_google_android_gms_internal_zzejw2.zzk(zzeju.zzcaf());
                Object zzbzk;
                if (this.zznbf) {
                    zzbti = com_google_android_gms_internal_zzejw2.zzbti();
                    zzbzk = this.zznbe.zzbzk();
                    zzbzj = this.zznbe.zzbzj();
                    i = -1;
                } else {
                    zzbti = com_google_android_gms_internal_zzejw2.iterator();
                    zzbzk = this.zznbe.zzbzj();
                    zzbzj = this.zznbe.zzbzk();
                    i = 1;
                }
                int i2 = 0;
                int i3 = i2;
                while (zzbti.hasNext()) {
                    zzekc com_google_android_gms_internal_zzekc = (zzekc) zzbti.next();
                    if (i2 == 0 && this.zznaa.compare(r1, com_google_android_gms_internal_zzekc) * i <= 0) {
                        i2 = 1;
                    }
                    Object obj = (i2 == 0 || i3 >= this.limit || this.zznaa.compare(com_google_android_gms_internal_zzekc, zzbzj) * i > 0) ? null : 1;
                    if (obj != null) {
                        i3++;
                    } else {
                        zzk = zzk.zzg(com_google_android_gms_internal_zzekc.zzcao(), zzeju.zzcaf());
                    }
                }
                return this.zznbe.zzbzh().zza(com_google_android_gms_internal_zzejw, zzk, com_google_android_gms_internal_zzeit);
            }
        }
        zzk = zzejw.zza(zzeju.zzcaf(), this.zznaa);
        return this.zznbe.zzbzh().zza(com_google_android_gms_internal_zzejw, zzk, com_google_android_gms_internal_zzeit);
    }

    public final zzejw zza(zzejw com_google_android_gms_internal_zzejw, zzekd com_google_android_gms_internal_zzekd) {
        return com_google_android_gms_internal_zzejw;
    }

    public final zzejv zzbyr() {
        return this.zznaa;
    }

    public final zzeiw zzbzh() {
        return this.zznbe.zzbzh();
    }

    public final boolean zzbzi() {
        return true;
    }
}
