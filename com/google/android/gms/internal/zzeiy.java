package com.google.android.gms.internal;

import java.util.Iterator;

public final class zzeiy implements zzeiw {
    private final zzejv zznaa;
    private final zzeiu zznbg;
    private final zzekc zznbh;
    private final zzekc zznbi;

    public zzeiy(zzeih com_google_android_gms_internal_zzeih) {
        zzekc zzf;
        zzekc zzf2;
        this.zznbg = new zzeiu(com_google_android_gms_internal_zzeih.zzbyr());
        this.zznaa = com_google_android_gms_internal_zzeih.zzbyr();
        if (com_google_android_gms_internal_zzeih.zzbyj()) {
            zzf = com_google_android_gms_internal_zzeih.zzbyr().zzf(com_google_android_gms_internal_zzeih.zzbyl(), com_google_android_gms_internal_zzeih.zzbyk());
        } else {
            com_google_android_gms_internal_zzeih.zzbyr();
            zzf = zzekc.zzcam();
        }
        this.zznbh = zzf;
        if (com_google_android_gms_internal_zzeih.zzbym()) {
            zzf2 = com_google_android_gms_internal_zzeih.zzbyr().zzf(com_google_android_gms_internal_zzeih.zzbyo(), com_google_android_gms_internal_zzeih.zzbyn());
        } else {
            zzf2 = com_google_android_gms_internal_zzeih.zzbyr().zzcag();
        }
        this.zznbi = zzf2;
    }

    public final zzejw zza(zzejw com_google_android_gms_internal_zzejw, zzejg com_google_android_gms_internal_zzejg, zzekd com_google_android_gms_internal_zzekd, zzedk com_google_android_gms_internal_zzedk, zzeix com_google_android_gms_internal_zzeix, zzeit com_google_android_gms_internal_zzeit) {
        if (!zza(new zzekc(com_google_android_gms_internal_zzejg, com_google_android_gms_internal_zzekd))) {
            com_google_android_gms_internal_zzekd = zzeju.zzcaf();
        }
        return this.zznbg.zza(com_google_android_gms_internal_zzejw, com_google_android_gms_internal_zzejg, com_google_android_gms_internal_zzekd, com_google_android_gms_internal_zzedk, com_google_android_gms_internal_zzeix, com_google_android_gms_internal_zzeit);
    }

    public final zzejw zza(zzejw com_google_android_gms_internal_zzejw, zzejw com_google_android_gms_internal_zzejw2, zzeit com_google_android_gms_internal_zzeit) {
        if (com_google_android_gms_internal_zzejw2.zzbsv().zzbzu()) {
            com_google_android_gms_internal_zzejw2 = zzejw.zza(zzeju.zzcaf(), this.zznaa);
        } else {
            zzejw zzk = com_google_android_gms_internal_zzejw2.zzk(zzeju.zzcaf());
            Iterator it = com_google_android_gms_internal_zzejw2.iterator();
            while (it.hasNext()) {
                zzekc com_google_android_gms_internal_zzekc = (zzekc) it.next();
                if (!zza(com_google_android_gms_internal_zzekc)) {
                    zzk = zzk.zzg(com_google_android_gms_internal_zzekc.zzcao(), zzeju.zzcaf());
                }
            }
            com_google_android_gms_internal_zzejw2 = zzk;
        }
        return this.zznbg.zza(com_google_android_gms_internal_zzejw, com_google_android_gms_internal_zzejw2, com_google_android_gms_internal_zzeit);
    }

    public final zzejw zza(zzejw com_google_android_gms_internal_zzejw, zzekd com_google_android_gms_internal_zzekd) {
        return com_google_android_gms_internal_zzejw;
    }

    public final boolean zza(zzekc com_google_android_gms_internal_zzekc) {
        return this.zznaa.compare(this.zznbh, com_google_android_gms_internal_zzekc) <= 0 && this.zznaa.compare(com_google_android_gms_internal_zzekc, this.zznbi) <= 0;
    }

    public final zzejv zzbyr() {
        return this.zznaa;
    }

    public final zzeiw zzbzh() {
        return this.zznbg;
    }

    public final boolean zzbzi() {
        return true;
    }

    public final zzekc zzbzj() {
        return this.zznbh;
    }

    public final zzekc zzbzk() {
        return this.zznbi;
    }
}
