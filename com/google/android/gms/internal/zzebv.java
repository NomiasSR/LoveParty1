package com.google.android.gms.internal;

import java.util.Map;

final class zzebv implements zzebx {
    private /* synthetic */ zzebo zzmot;

    zzebv(zzebo com_google_android_gms_internal_zzebo) {
        this.zzmot = com_google_android_gms_internal_zzebo;
    }

    public final void zzaj(Map<String, Object> map) {
        String str = (String) map.get("s");
        if (!str.equals("ok")) {
            String str2 = (String) map.get("d");
            if (this.zzmot.zzmlr.zzbzl()) {
                zzejc zza = this.zzmot.zzmlr;
                StringBuilder stringBuilder = new StringBuilder((34 + String.valueOf(str).length()) + String.valueOf(str2).length());
                stringBuilder.append("Failed to send stats: ");
                stringBuilder.append(str);
                stringBuilder.append(" (message: ");
                stringBuilder.append(str2);
                stringBuilder.append(")");
                zza.zzb(stringBuilder.toString(), null, new Object[0]);
            }
        }
    }
}
