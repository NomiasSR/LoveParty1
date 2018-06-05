package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public final class zzeau<K, V> extends zzeag<K, V> {
    private Comparator<K> zzmma;
    private zzeap<K, V> zzmmr;

    private zzeau(zzeap<K, V> com_google_android_gms_internal_zzeap_K__V, Comparator<K> comparator) {
        this.zzmmr = com_google_android_gms_internal_zzeap_K__V;
        this.zzmma = comparator;
    }

    public static <A, B> zzeau<A, B> zzb(Map<A, B> map, Comparator<A> comparator) {
        return zzeaw.zzc(new ArrayList(map.keySet()), map, zzeah.zzbtj(), comparator);
    }

    private final zzeap<K, V> zzbo(K k) {
        zzeap<K, V> com_google_android_gms_internal_zzeap_K__V = this.zzmmr;
        while (!com_google_android_gms_internal_zzeap_K__V.isEmpty()) {
            int compare = this.zzmma.compare(k, com_google_android_gms_internal_zzeap_K__V.getKey());
            if (compare < 0) {
                com_google_android_gms_internal_zzeap_K__V = com_google_android_gms_internal_zzeap_K__V.zzbtp();
            } else if (compare == 0) {
                return com_google_android_gms_internal_zzeap_K__V;
            } else {
                com_google_android_gms_internal_zzeap_K__V = com_google_android_gms_internal_zzeap_K__V.zzbtq();
            }
        }
        return null;
    }

    public final boolean containsKey(K k) {
        return zzbo(k) != null;
    }

    public final V get(K k) {
        zzeap zzbo = zzbo(k);
        return zzbo != null ? zzbo.getValue() : null;
    }

    public final Comparator<K> getComparator() {
        return this.zzmma;
    }

    public final int indexOf(K k) {
        zzeap com_google_android_gms_internal_zzeap = this.zzmmr;
        int i = 0;
        while (!com_google_android_gms_internal_zzeap.isEmpty()) {
            int compare = this.zzmma.compare(k, com_google_android_gms_internal_zzeap.getKey());
            if (compare == 0) {
                return i + com_google_android_gms_internal_zzeap.zzbtp().size();
            }
            if (compare < 0) {
                com_google_android_gms_internal_zzeap = com_google_android_gms_internal_zzeap.zzbtp();
            } else {
                i += com_google_android_gms_internal_zzeap.zzbtp().size() + 1;
                com_google_android_gms_internal_zzeap = com_google_android_gms_internal_zzeap.zzbtq();
            }
        }
        return -1;
    }

    public final boolean isEmpty() {
        return this.zzmmr.isEmpty();
    }

    public final Iterator<Entry<K, V>> iterator() {
        return new zzeak(this.zzmmr, null, this.zzmma, false);
    }

    public final int size() {
        return this.zzmmr.size();
    }

    public final void zza(zzear<K, V> com_google_android_gms_internal_zzear_K__V) {
        this.zzmmr.zza(com_google_android_gms_internal_zzear_K__V);
    }

    public final zzeag<K, V> zzbf(K k) {
        return !containsKey(k) ? this : new zzeau(this.zzmmr.zza(k, this.zzmma).zza(null, null, zzeaq.zzmmm, null, null), this.zzmma);
    }

    public final Iterator<Entry<K, V>> zzbg(K k) {
        return new zzeak(this.zzmmr, k, this.zzmma, false);
    }

    public final K zzbh(K k) {
        zzeap com_google_android_gms_internal_zzeap = this.zzmmr;
        zzeap com_google_android_gms_internal_zzeap2 = null;
        while (!com_google_android_gms_internal_zzeap.isEmpty()) {
            int compare = this.zzmma.compare(k, com_google_android_gms_internal_zzeap.getKey());
            if (compare == 0) {
                if (com_google_android_gms_internal_zzeap.zzbtp().isEmpty()) {
                    return com_google_android_gms_internal_zzeap2 != null ? com_google_android_gms_internal_zzeap2.getKey() : null;
                } else {
                    zzeap zzbtp = com_google_android_gms_internal_zzeap.zzbtp();
                    while (!zzbtp.zzbtq().isEmpty()) {
                        zzbtp = zzbtp.zzbtq();
                    }
                    return zzbtp.getKey();
                }
            } else if (compare < 0) {
                com_google_android_gms_internal_zzeap = com_google_android_gms_internal_zzeap.zzbtp();
            } else {
                com_google_android_gms_internal_zzeap2 = com_google_android_gms_internal_zzeap;
                com_google_android_gms_internal_zzeap = com_google_android_gms_internal_zzeap.zzbtq();
            }
        }
        String valueOf = String.valueOf(k);
        StringBuilder stringBuilder = new StringBuilder(50 + String.valueOf(valueOf).length());
        stringBuilder.append("Couldn't find predecessor key of non-present key: ");
        stringBuilder.append(valueOf);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    public final K zzbtg() {
        return this.zzmmr.zzbtr().getKey();
    }

    public final K zzbth() {
        return this.zzmmr.zzbts().getKey();
    }

    public final Iterator<Entry<K, V>> zzbti() {
        return new zzeak(this.zzmmr, null, this.zzmma, true);
    }

    public final zzeag<K, V> zzg(K k, V v) {
        return new zzeau(this.zzmmr.zza(k, v, this.zzmma).zza(null, null, zzeaq.zzmmm, null, null), this.zzmma);
    }
}
