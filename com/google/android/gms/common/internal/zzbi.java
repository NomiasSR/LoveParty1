package com.google.android.gms.common.internal;

import java.util.ArrayList;
import java.util.List;

public final class zzbi {
    private final Object zzddc;
    private final List<String> zzgbe;

    private zzbi(Object obj) {
        this.zzddc = zzbq.checkNotNull(obj);
        this.zzgbe = new ArrayList();
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder(100);
        stringBuilder.append(this.zzddc.getClass().getSimpleName());
        stringBuilder.append('{');
        int size = this.zzgbe.size();
        for (int i = 0; i < size; i++) {
            stringBuilder.append((String) this.zzgbe.get(i));
            if (i < size - 1) {
                stringBuilder.append(", ");
            }
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    public final zzbi zzg(String str, Object obj) {
        List list = this.zzgbe;
        str = (String) zzbq.checkNotNull(str);
        String valueOf = String.valueOf(obj);
        StringBuilder stringBuilder = new StringBuilder((1 + String.valueOf(str).length()) + String.valueOf(valueOf).length());
        stringBuilder.append(str);
        stringBuilder.append("=");
        stringBuilder.append(valueOf);
        list.add(stringBuilder.toString());
        return this;
    }
}
