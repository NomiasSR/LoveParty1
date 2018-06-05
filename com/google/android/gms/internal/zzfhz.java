package com.google.android.gms.internal;

import java.util.Collections;
import java.util.List;
import java.util.Map.Entry;

final class zzfhz extends zzfhy<FieldDescriptorType, Object> {
    zzfhz(int i) {
        super(i);
    }

    public final void zzbiy() {
        if (!isImmutable()) {
            Entry zzmb;
            for (int i = 0; i < zzczj(); i++) {
                zzmb = zzmb(i);
                if (((zzffs) zzmb.getKey()).zzcxj()) {
                    zzmb.setValue(Collections.unmodifiableList((List) zzmb.getValue()));
                }
            }
            for (Entry zzmb2 : zzczk()) {
                if (((zzffs) zzmb2.getKey()).zzcxj()) {
                    zzmb2.setValue(Collections.unmodifiableList((List) zzmb2.getValue()));
                }
            }
        }
        super.zzbiy();
    }
}
