package com.google.android.gms.internal;

import java.util.Iterator;
import java.util.Map.Entry;

final class zzfhj<T> implements zzfhv<T> {
    private final zzfhe zzpiu;
    private final zzfin<?, ?> zzpiv;
    private final boolean zzpiw;
    private final zzffn<?> zzpix;

    private zzfhj(Class<T> cls, zzfin<?, ?> com_google_android_gms_internal_zzfin___, zzffn<?> com_google_android_gms_internal_zzffn_, zzfhe com_google_android_gms_internal_zzfhe) {
        this.zzpiv = com_google_android_gms_internal_zzfin___;
        this.zzpiw = com_google_android_gms_internal_zzffn_.zzh(cls);
        this.zzpix = com_google_android_gms_internal_zzffn_;
        this.zzpiu = com_google_android_gms_internal_zzfhe;
    }

    static <T> zzfhj<T> zza(Class<T> cls, zzfin<?, ?> com_google_android_gms_internal_zzfin___, zzffn<?> com_google_android_gms_internal_zzffn_, zzfhe com_google_android_gms_internal_zzfhe) {
        return new zzfhj(cls, com_google_android_gms_internal_zzfin___, com_google_android_gms_internal_zzffn_, com_google_android_gms_internal_zzfhe);
    }

    public final void zza(T t, zzfji com_google_android_gms_internal_zzfji) {
        Iterator it = this.zzpix.zzcn(t).iterator();
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            zzffs com_google_android_gms_internal_zzffs = (zzffs) entry.getKey();
            if (com_google_android_gms_internal_zzffs.zzcxi() == zzfjd.MESSAGE && !com_google_android_gms_internal_zzffs.zzcxj()) {
                if (!com_google_android_gms_internal_zzffs.zzcxk()) {
                    int zzhq;
                    Object toByteString;
                    if (entry instanceof zzfgi) {
                        zzhq = com_google_android_gms_internal_zzffs.zzhq();
                        toByteString = ((zzfgi) entry).zzcyk().toByteString();
                    } else {
                        zzhq = com_google_android_gms_internal_zzffs.zzhq();
                        toByteString = entry.getValue();
                    }
                    com_google_android_gms_internal_zzfji.zzb(zzhq, toByteString);
                }
            }
            throw new IllegalStateException("Found invalid MessageSet item.");
        }
        zzfin com_google_android_gms_internal_zzfin = this.zzpiv;
        com_google_android_gms_internal_zzfin.zzb(com_google_android_gms_internal_zzfin.zzcq(t), com_google_android_gms_internal_zzfji);
    }

    public final int zzcp(T t) {
        zzfin com_google_android_gms_internal_zzfin = this.zzpiv;
        int zzcr = 0 + com_google_android_gms_internal_zzfin.zzcr(com_google_android_gms_internal_zzfin.zzcq(t));
        return this.zzpiw ? zzcr + this.zzpix.zzcn(t).zzcxg() : zzcr;
    }
}
