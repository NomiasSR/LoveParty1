package com.google.android.gms.internal;

import java.util.Map.Entry;

public final class zzehs<T> {
    private zzejg zzmzd;
    private zzehs<T> zzmze;
    private zzehw<T> zzmzf;

    public zzehs() {
        this(null, null, new zzehw());
    }

    private zzehs(zzejg com_google_android_gms_internal_zzejg, zzehs<T> com_google_android_gms_internal_zzehs_T, zzehw<T> com_google_android_gms_internal_zzehw_T) {
        this.zzmzd = com_google_android_gms_internal_zzejg;
        this.zzmze = com_google_android_gms_internal_zzehs_T;
        this.zzmzf = com_google_android_gms_internal_zzehw_T;
    }

    private final void zzbxy() {
        zzehs com_google_android_gms_internal_zzehs = this;
        while (com_google_android_gms_internal_zzehs.zzmze != null) {
            zzehs com_google_android_gms_internal_zzehs2 = com_google_android_gms_internal_zzehs.zzmze;
            zzejg com_google_android_gms_internal_zzejg = com_google_android_gms_internal_zzehs.zzmzd;
            Object obj = (com_google_android_gms_internal_zzehs.zzmzf.value == null && com_google_android_gms_internal_zzehs.zzmzf.zzmvi.isEmpty()) ? 1 : null;
            boolean containsKey = com_google_android_gms_internal_zzehs2.zzmzf.zzmvi.containsKey(com_google_android_gms_internal_zzejg);
            if (obj != null && containsKey) {
                com_google_android_gms_internal_zzehs2.zzmzf.zzmvi.remove(com_google_android_gms_internal_zzejg);
            } else if (obj == null && !containsKey) {
                com_google_android_gms_internal_zzehs2.zzmzf.zzmvi.put(com_google_android_gms_internal_zzejg, com_google_android_gms_internal_zzehs.zzmzf);
            } else {
                return;
            }
            com_google_android_gms_internal_zzehs = com_google_android_gms_internal_zzehs2;
        }
    }

    public final T getValue() {
        return this.zzmzf.value;
    }

    public final boolean hasChildren() {
        return !this.zzmzf.zzmvi.isEmpty();
    }

    public final void setValue(T t) {
        this.zzmzf.value = t;
        zzbxy();
    }

    public final String toString() {
        String str = "";
        String asString = this.zzmzd == null ? "<anon>" : this.zzmzd.asString();
        String com_google_android_gms_internal_zzehw = this.zzmzf.toString(String.valueOf(str).concat("\t"));
        StringBuilder stringBuilder = new StringBuilder(((1 + String.valueOf(str).length()) + String.valueOf(asString).length()) + String.valueOf(com_google_android_gms_internal_zzehw).length());
        stringBuilder.append(str);
        stringBuilder.append(asString);
        stringBuilder.append("\n");
        stringBuilder.append(com_google_android_gms_internal_zzehw);
        return stringBuilder.toString();
    }

    public final void zza(zzehv<T> com_google_android_gms_internal_zzehv_T) {
        Object[] toArray = this.zzmzf.zzmvi.entrySet().toArray();
        for (Object obj : toArray) {
            Entry entry = (Entry) obj;
            com_google_android_gms_internal_zzehv_T.zzd(new zzehs((zzejg) entry.getKey(), this, (zzehw) entry.getValue()));
        }
    }

    public final void zza(zzehv<T> com_google_android_gms_internal_zzehv_T, boolean z, boolean z2) {
        if (z && !z2) {
            com_google_android_gms_internal_zzehv_T.zzd(this);
        }
        zza(new zzeht(this, com_google_android_gms_internal_zzehv_T, z2));
        if (z && z2) {
            com_google_android_gms_internal_zzehv_T.zzd(this);
        }
    }

    public final boolean zza(zzehu<T> com_google_android_gms_internal_zzehu_T, boolean z) {
        for (zzehs com_google_android_gms_internal_zzehs = this.zzmze; com_google_android_gms_internal_zzehs != null; com_google_android_gms_internal_zzehs = com_google_android_gms_internal_zzehs.zzmze) {
            com_google_android_gms_internal_zzehu_T.zze(com_google_android_gms_internal_zzehs);
        }
        return false;
    }

    public final zzehs<T> zzak(zzedk com_google_android_gms_internal_zzedk) {
        zzejg zzbwh = com_google_android_gms_internal_zzedk.zzbwh();
        zzedk com_google_android_gms_internal_zzedk2 = com_google_android_gms_internal_zzedk;
        zzehs<T> com_google_android_gms_internal_zzehs_T = this;
        while (zzbwh != null) {
            zzehs<T> com_google_android_gms_internal_zzehs = new zzehs(zzbwh, com_google_android_gms_internal_zzehs_T, com_google_android_gms_internal_zzehs_T.zzmzf.zzmvi.containsKey(zzbwh) ? (zzehw) com_google_android_gms_internal_zzehs_T.zzmzf.zzmvi.get(zzbwh) : new zzehw());
            com_google_android_gms_internal_zzedk2 = com_google_android_gms_internal_zzedk2.zzbwi();
            zzbwh = com_google_android_gms_internal_zzedk2.zzbwh();
            com_google_android_gms_internal_zzehs_T = com_google_android_gms_internal_zzehs;
        }
        return com_google_android_gms_internal_zzehs_T;
    }

    public final zzedk zzbsy() {
        if (this.zzmze != null) {
            return this.zzmze.zzbsy().zza(this.zzmzd);
        }
        if (this.zzmzd == null) {
            return zzedk.zzbwe();
        }
        return new zzedk(this.zzmzd);
    }
}
