package com.google.android.gms.internal;

import java.util.Map;

final class zzeeu implements Runnable {
    private /* synthetic */ zzedc zzmvb;
    private /* synthetic */ zzeer zzmvc;

    zzeeu(zzeer com_google_android_gms_internal_zzeer, zzedc com_google_android_gms_internal_zzedc) {
        this.zzmvc = com_google_android_gms_internal_zzeer;
        this.zzmvb = com_google_android_gms_internal_zzedc;
    }

    public final void run() {
        synchronized (this.zzmvc.zzmva) {
            if (this.zzmvc.zzmva.containsKey(this.zzmvb)) {
                Object obj;
                loop0:
                while (true) {
                    obj = 1;
                    for (zzedn com_google_android_gms_internal_zzedn : ((Map) this.zzmvc.zzmva.get(this.zzmvb)).values()) {
                        com_google_android_gms_internal_zzedn.interrupt();
                        if (obj == null || com_google_android_gms_internal_zzedn.zzbwo()) {
                            obj = null;
                        }
                    }
                    break loop0;
                }
                if (obj != null) {
                    this.zzmvb.stop();
                }
            }
        }
    }
}
