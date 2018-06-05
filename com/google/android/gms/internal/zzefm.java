package com.google.android.gms.internal;

final class zzefm implements zzehp<zzefg, Void> {
    private /* synthetic */ zzefh zzmvz;

    zzefm(zzefh com_google_android_gms_internal_zzefh) {
        this.zzmvz = com_google_android_gms_internal_zzefh;
    }

    public final /* synthetic */ Object zza(zzedk com_google_android_gms_internal_zzedk, Object obj, Object obj2) {
        zzefg com_google_android_gms_internal_zzefg = (zzefg) obj;
        if (com_google_android_gms_internal_zzedk.isEmpty() || !com_google_android_gms_internal_zzefg.zzbwt()) {
            for (zzeil zzbyz : com_google_android_gms_internal_zzefg.zzbws()) {
                zzeik zzbyz2 = zzbyz.zzbyz();
                this.zzmvz.zzmvt.zza(zzefh.zzd(zzbyz2), this.zzmvz.zze(zzbyz2));
            }
        } else {
            zzeik zzbyz3 = com_google_android_gms_internal_zzefg.zzbwu().zzbyz();
            this.zzmvz.zzmvt.zza(zzefh.zzd(zzbyz3), this.zzmvz.zze(zzbyz3));
        }
        return null;
    }
}
