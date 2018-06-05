package com.google.android.gms.internal;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

final class zzefb {
    private zzekd zzmvh = null;
    private Map<zzejg, zzefb> zzmvi = null;

    public final void zza(zzedk com_google_android_gms_internal_zzedk, zzeff com_google_android_gms_internal_zzeff) {
        if (this.zzmvh != null) {
            com_google_android_gms_internal_zzeff.zzf(com_google_android_gms_internal_zzedk, this.zzmvh);
            return;
        }
        zzefe com_google_android_gms_internal_zzefd = new zzefd(this, com_google_android_gms_internal_zzedk, com_google_android_gms_internal_zzeff);
        if (this.zzmvi != null) {
            for (Entry entry : this.zzmvi.entrySet()) {
                com_google_android_gms_internal_zzefd.zza((zzejg) entry.getKey(), (zzefb) entry.getValue());
            }
        }
    }

    public final void zzh(zzedk com_google_android_gms_internal_zzedk, zzekd com_google_android_gms_internal_zzekd) {
        zzefb com_google_android_gms_internal_zzefb = this;
        while (!com_google_android_gms_internal_zzedk.isEmpty()) {
            if (com_google_android_gms_internal_zzefb.zzmvh != null) {
                com_google_android_gms_internal_zzefb.zzmvh = com_google_android_gms_internal_zzefb.zzmvh.zzl(com_google_android_gms_internal_zzedk, com_google_android_gms_internal_zzekd);
                return;
            }
            if (com_google_android_gms_internal_zzefb.zzmvi == null) {
                com_google_android_gms_internal_zzefb.zzmvi = new HashMap();
            }
            zzejg zzbwh = com_google_android_gms_internal_zzedk.zzbwh();
            if (!com_google_android_gms_internal_zzefb.zzmvi.containsKey(zzbwh)) {
                com_google_android_gms_internal_zzefb.zzmvi.put(zzbwh, new zzefb());
            }
            com_google_android_gms_internal_zzefb = (zzefb) com_google_android_gms_internal_zzefb.zzmvi.get(zzbwh);
            com_google_android_gms_internal_zzedk = com_google_android_gms_internal_zzedk.zzbwi();
        }
        com_google_android_gms_internal_zzefb.zzmvh = com_google_android_gms_internal_zzekd;
        com_google_android_gms_internal_zzefb.zzmvi = null;
    }

    public final boolean zzq(zzedk com_google_android_gms_internal_zzedk) {
        while (!com_google_android_gms_internal_zzedk.isEmpty()) {
            if (this.zzmvh != null) {
                if (this.zzmvh.zzbzu()) {
                    return false;
                }
                zzeji com_google_android_gms_internal_zzeji = (zzeji) this.zzmvh;
                this.zzmvh = null;
                com_google_android_gms_internal_zzeji.zza(new zzefc(this, com_google_android_gms_internal_zzedk), false);
            } else if (this.zzmvi == null) {
                return true;
            } else {
                zzejg zzbwh = com_google_android_gms_internal_zzedk.zzbwh();
                com_google_android_gms_internal_zzedk = com_google_android_gms_internal_zzedk.zzbwi();
                if (this.zzmvi.containsKey(zzbwh) && ((zzefb) this.zzmvi.get(zzbwh)).zzq(com_google_android_gms_internal_zzedk)) {
                    this.zzmvi.remove(zzbwh);
                }
                if (!this.zzmvi.isEmpty()) {
                    return false;
                }
                this.zzmvi = null;
                return true;
            }
        }
        this.zzmvh = null;
        this.zzmvi = null;
        return true;
    }
}
