package com.google.android.gms.internal;

import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.concurrent.Callable;

final class zzefk implements Callable<List<? extends zzeib>> {
    private /* synthetic */ zzefh zzmvz;
    private /* synthetic */ zzedh zzmwc;

    zzefk(zzefh com_google_android_gms_internal_zzefh, zzedh com_google_android_gms_internal_zzedh) {
        this.zzmvz = com_google_android_gms_internal_zzefh;
        this.zzmwc = com_google_android_gms_internal_zzedh;
    }

    public final /* synthetic */ Object call() throws Exception {
        zzehx com_google_android_gms_internal_zzehx;
        zzeik zzbvp = this.zzmwc.zzbvp();
        zzedk zzbsy = zzbvp.zzbsy();
        zzehm zzd = this.zzmvz.zzmvo;
        zzekd com_google_android_gms_internal_zzekd = null;
        zzedk com_google_android_gms_internal_zzedk = zzbsy;
        boolean z = false;
        while (true) {
            boolean z2 = true;
            if (zzd.isEmpty()) {
                break;
            }
            zzefg com_google_android_gms_internal_zzefg = (zzefg) zzd.getValue();
            if (com_google_android_gms_internal_zzefg != null) {
                if (com_google_android_gms_internal_zzekd == null) {
                    com_google_android_gms_internal_zzekd = com_google_android_gms_internal_zzefg.zzr(com_google_android_gms_internal_zzedk);
                }
                if (!z) {
                    if (!com_google_android_gms_internal_zzefg.zzbwt()) {
                        z2 = false;
                    }
                }
                z = z2;
            }
            zzd = zzd.zze(com_google_android_gms_internal_zzedk.isEmpty() ? zzejg.zzpz("") : com_google_android_gms_internal_zzedk.zzbwh());
            com_google_android_gms_internal_zzedk = com_google_android_gms_internal_zzedk.zzbwi();
        }
        zzefg com_google_android_gms_internal_zzefg2 = (zzefg) this.zzmvz.zzmvo.zzaj(zzbsy);
        if (com_google_android_gms_internal_zzefg2 == null) {
            com_google_android_gms_internal_zzefg2 = new zzefg(this.zzmvz.zzmvn);
            this.zzmvz.zzmvo = this.zzmvz.zzmvo.zzb(zzbsy, (Object) com_google_android_gms_internal_zzefg2);
        } else {
            if (!z) {
                if (!com_google_android_gms_internal_zzefg2.zzbwt()) {
                    z = false;
                    if (com_google_android_gms_internal_zzekd != null) {
                        com_google_android_gms_internal_zzekd = com_google_android_gms_internal_zzefg2.zzr(zzedk.zzbwe());
                    }
                }
            }
            z = true;
            if (com_google_android_gms_internal_zzekd != null) {
                com_google_android_gms_internal_zzekd = com_google_android_gms_internal_zzefg2.zzr(zzedk.zzbwe());
            }
        }
        this.zzmvz.zzmvn.zzg(zzbvp);
        if (com_google_android_gms_internal_zzekd != null) {
            com_google_android_gms_internal_zzehx = new zzehx(zzejw.zza(com_google_android_gms_internal_zzekd, zzbvp.zzbyr()), true, false);
        } else {
            com_google_android_gms_internal_zzehx = this.zzmvz.zzmvn.zzf(zzbvp);
            if (!com_google_android_gms_internal_zzehx.zzbxz()) {
                com_google_android_gms_internal_zzekd = zzeju.zzcaf();
                Iterator it = this.zzmvz.zzmvo.zzah(zzbsy).zzbxx().iterator();
                while (it.hasNext()) {
                    Entry entry = (Entry) it.next();
                    zzefg com_google_android_gms_internal_zzefg3 = (zzefg) ((zzehm) entry.getValue()).getValue();
                    if (com_google_android_gms_internal_zzefg3 != null) {
                        zzekd zzr = com_google_android_gms_internal_zzefg3.zzr(zzedk.zzbwe());
                        if (zzr != null) {
                            com_google_android_gms_internal_zzekd = com_google_android_gms_internal_zzekd.zze((zzejg) entry.getKey(), zzr);
                        }
                    }
                }
                for (zzekc com_google_android_gms_internal_zzekc : com_google_android_gms_internal_zzehx.zzbsv()) {
                    if (!com_google_android_gms_internal_zzekd.zzk(com_google_android_gms_internal_zzekc.zzcao())) {
                        com_google_android_gms_internal_zzekd = com_google_android_gms_internal_zzekd.zze(com_google_android_gms_internal_zzekc.zzcao(), com_google_android_gms_internal_zzekc.zzbsv());
                    }
                }
                com_google_android_gms_internal_zzehx = new zzehx(zzejw.zza(com_google_android_gms_internal_zzekd, zzbvp.zzbyr()), false, false);
            }
        }
        boolean zzc = com_google_android_gms_internal_zzefg2.zzc(zzbvp);
        if (!(zzc || zzbvp.zzbyv())) {
            zzega zzf = this.zzmvz.zzbww();
            this.zzmvz.zzmvr.put(zzbvp, zzf);
            this.zzmvz.zzmvq.put(zzf, zzbvp);
        }
        List zza = com_google_android_gms_internal_zzefg2.zza(this.zzmwc, this.zzmvz.zzmvp.zzt(zzbsy), com_google_android_gms_internal_zzehx);
        if (!(zzc || r5)) {
            this.zzmvz.zza(zzbvp, com_google_android_gms_internal_zzefg2.zzb(zzbvp));
        }
        return zza;
    }
}
