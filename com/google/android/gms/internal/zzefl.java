package com.google.android.gms.internal;

import com.google.firebase.database.DatabaseError;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;

final class zzefl implements Callable<List<zzeib>> {
    private /* synthetic */ zzeik zzmtx;
    private /* synthetic */ zzefh zzmvz;
    private /* synthetic */ zzedh zzmwc;
    private /* synthetic */ DatabaseError zzmwd;

    zzefl(zzefh com_google_android_gms_internal_zzefh, zzeik com_google_android_gms_internal_zzeik, zzedh com_google_android_gms_internal_zzedh, DatabaseError databaseError) {
        this.zzmvz = com_google_android_gms_internal_zzefh;
        this.zzmtx = com_google_android_gms_internal_zzeik;
        this.zzmwc = com_google_android_gms_internal_zzedh;
        this.zzmwd = databaseError;
    }

    public final /* synthetic */ Object call() throws Exception {
        zzedk zzbsy = this.zzmtx.zzbsy();
        zzefg com_google_android_gms_internal_zzefg = (zzefg) this.zzmvz.zzmvo.zzaj(zzbsy);
        Object arrayList = new ArrayList();
        if (com_google_android_gms_internal_zzefg != null && (this.zzmtx.isDefault() || com_google_android_gms_internal_zzefg.zzc(this.zzmtx))) {
            Object obj;
            zzelq zza = com_google_android_gms_internal_zzefg.zza(this.zzmtx, this.zzmwc, this.zzmwd);
            if (com_google_android_gms_internal_zzefg.isEmpty()) {
                this.zzmvz.zzmvo = this.zzmvz.zzmvo.zzai(zzbsy);
            }
            List<zzeik> list = (List) zza.getFirst();
            arrayList = (List) zza.zzcbg();
            loop0:
            while (true) {
                obj = null;
                for (zzeik com_google_android_gms_internal_zzeik : list) {
                    this.zzmvz.zzmvn.zzh(this.zzmtx);
                    if (obj != null || com_google_android_gms_internal_zzeik.zzbyv()) {
                        int i = 1;
                    }
                }
                break loop0;
            }
            zzehm zzd = this.zzmvz.zzmvo;
            Object obj2 = (zzd.getValue() == null || !((zzefg) zzd.getValue()).zzbwt()) ? null : 1;
            Iterator it = zzbsy.iterator();
            while (it.hasNext()) {
                zzd = zzd.zze((zzejg) it.next());
                if (obj2 == null) {
                    if (zzd.getValue() == null || !((zzefg) zzd.getValue()).zzbwt()) {
                        obj2 = null;
                        if (obj2 == null) {
                            if (zzd.isEmpty()) {
                                break;
                            }
                        }
                        break;
                    }
                }
                obj2 = 1;
                if (obj2 == null) {
                    if (zzd.isEmpty()) {
                        break;
                    }
                }
                break;
            }
            if (obj != null && obj2 == null) {
                zzehm zzah = this.zzmvz.zzmvo.zzah(zzbsy);
                if (!zzah.isEmpty()) {
                    for (zzeil com_google_android_gms_internal_zzeil : this.zzmvz.zza(zzah)) {
                        Object com_google_android_gms_internal_zzefy = new zzefy(this.zzmvz, com_google_android_gms_internal_zzeil);
                        this.zzmvz.zzmvt.zza(zzefh.zzd(com_google_android_gms_internal_zzeil.zzbyz()), com_google_android_gms_internal_zzefy.zzmwn, com_google_android_gms_internal_zzefy, com_google_android_gms_internal_zzefy);
                    }
                }
            }
            if (obj2 == null && !list.isEmpty() && this.zzmwd == null) {
                if (obj != null) {
                    this.zzmvz.zzmvt.zza(zzefh.zzd(this.zzmtx), null);
                } else {
                    for (zzeik com_google_android_gms_internal_zzeik2 : list) {
                        this.zzmvz.zzmvt.zza(zzefh.zzd(com_google_android_gms_internal_zzeik2), this.zzmvz.zze(com_google_android_gms_internal_zzeik2));
                    }
                }
            }
            this.zzmvz.zzav(list);
        }
        return arrayList;
    }
}
