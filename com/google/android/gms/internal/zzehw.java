package com.google.android.gms.internal;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public final class zzehw<T> {
    public T value;
    public Map<zzejg, zzehw<T>> zzmvi = new HashMap();

    final String toString(String str) {
        String valueOf = String.valueOf(this.value);
        StringBuilder stringBuilder = new StringBuilder((10 + String.valueOf(str).length()) + String.valueOf(valueOf).length());
        stringBuilder.append(str);
        stringBuilder.append("<value>: ");
        stringBuilder.append(valueOf);
        stringBuilder.append("\n");
        valueOf = stringBuilder.toString();
        if (this.zzmvi.isEmpty()) {
            StringBuilder stringBuilder2 = new StringBuilder((7 + String.valueOf(valueOf).length()) + String.valueOf(str).length());
            stringBuilder2.append(valueOf);
            stringBuilder2.append(str);
            stringBuilder2.append("<empty>");
            return stringBuilder2.toString();
        }
        for (Entry entry : this.zzmvi.entrySet()) {
            valueOf = String.valueOf(valueOf);
            String valueOf2 = String.valueOf(entry.getKey());
            String com_google_android_gms_internal_zzehw = ((zzehw) entry.getValue()).toString(String.valueOf(str).concat("\t"));
            StringBuilder stringBuilder3 = new StringBuilder((((3 + String.valueOf(valueOf).length()) + String.valueOf(str).length()) + String.valueOf(valueOf2).length()) + String.valueOf(com_google_android_gms_internal_zzehw).length());
            stringBuilder3.append(valueOf);
            stringBuilder3.append(str);
            stringBuilder3.append(valueOf2);
            stringBuilder3.append(":\n");
            stringBuilder3.append(com_google_android_gms_internal_zzehw);
            stringBuilder3.append("\n");
            valueOf = stringBuilder3.toString();
        }
        return valueOf;
    }
}
