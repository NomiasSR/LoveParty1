package com.google.android.gms.internal;

import java.util.Map;

final class zzebr implements zzebx {
    private /* synthetic */ zzece zzmow;

    zzebr(zzebo com_google_android_gms_internal_zzebo, zzece com_google_android_gms_internal_zzece) {
        this.zzmow = com_google_android_gms_internal_zzece;
    }

    public final void zzaj(Map<String, Object> map) {
        String str = (String) map.get("s");
        String str2 = null;
        if (str.equals("ok")) {
            str = null;
        } else {
            str2 = (String) map.get("d");
        }
        if (this.zzmow != null) {
            this.zzmow.zzbd(str, str2);
        }
    }
}
