package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.List;

public final class zzeif {
    private final zzejc zzmlr;
    private final zzedj zzmsc;

    public zzeif(zzedc com_google_android_gms_internal_zzedc) {
        this.zzmsc = com_google_android_gms_internal_zzedc.zzbwa();
        this.zzmlr = com_google_android_gms_internal_zzedc.zzpv("EventRaiser");
    }

    public final void zzaw(List<? extends zzeib> list) {
        if (this.zzmlr.zzbzl()) {
            zzejc com_google_android_gms_internal_zzejc = this.zzmlr;
            int size = list.size();
            StringBuilder stringBuilder = new StringBuilder(28);
            stringBuilder.append("Raising ");
            stringBuilder.append(size);
            stringBuilder.append(" event(s)");
            com_google_android_gms_internal_zzejc.zzb(stringBuilder.toString(), null, new Object[0]);
        }
        this.zzmsc.zzm(new zzeig(this, new ArrayList(list)));
    }
}
