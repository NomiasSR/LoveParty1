package com.google.android.gms.internal;

import java.util.HashMap;
import java.util.Map;

public final class zzeih {
    public static final zzeih zznae = new zzeih();
    private zzejv zznaa = zzeki.zzcap();
    private Integer zznaf;
    private int zznag;
    private zzekd zznah = null;
    private zzejg zznai = null;
    private zzekd zznaj = null;
    private zzejg zznak = null;
    private String zznal = null;

    public static zzeih zzam(Map<String, Object> map) {
        String str;
        zzeih com_google_android_gms_internal_zzeih = new zzeih();
        com_google_android_gms_internal_zzeih.zznaf = (Integer) map.get("l");
        if (map.containsKey("sp")) {
            com_google_android_gms_internal_zzeih.zznah = zze(zzekg.zza(map.get("sp"), zzeju.zzcaf()));
            str = (String) map.get("sn");
            if (str != null) {
                com_google_android_gms_internal_zzeih.zznai = zzejg.zzpz(str);
            }
        }
        if (map.containsKey("ep")) {
            com_google_android_gms_internal_zzeih.zznaj = zze(zzekg.zza(map.get("ep"), zzeju.zzcaf()));
            str = (String) map.get("en");
            if (str != null) {
                com_google_android_gms_internal_zzeih.zznak = zzejg.zzpz(str);
            }
        }
        str = (String) map.get("vf");
        if (str != null) {
            com_google_android_gms_internal_zzeih.zznag = str.equals("l") ? zzeij.zznan : zzeij.zznao;
        }
        String str2 = (String) map.get("i");
        if (str2 != null) {
            zzejv zzcaq;
            if (str2.equals(".value")) {
                zzcaq = zzekn.zzcaq();
            } else if (str2.equals(".key")) {
                zzcaq = zzejx.zzcal();
            } else if (str2.equals(".priority")) {
                throw new IllegalStateException("queryDefinition shouldn't ever be .priority since it's the default");
            } else {
                zzcaq = new zzekh(new zzedk(str2));
            }
            com_google_android_gms_internal_zzeih.zznaa = zzcaq;
        }
        return com_google_android_gms_internal_zzeih;
    }

    private final zzeih zzbys() {
        zzeih com_google_android_gms_internal_zzeih = new zzeih();
        com_google_android_gms_internal_zzeih.zznaf = this.zznaf;
        com_google_android_gms_internal_zzeih.zznah = this.zznah;
        com_google_android_gms_internal_zzeih.zznai = this.zznai;
        com_google_android_gms_internal_zzeih.zznaj = this.zznaj;
        com_google_android_gms_internal_zzeih.zznak = this.zznak;
        com_google_android_gms_internal_zzeih.zznag = this.zznag;
        com_google_android_gms_internal_zzeih.zznaa = this.zznaa;
        return com_google_android_gms_internal_zzeih;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.google.android.gms.internal.zzekd zze(com.google.android.gms.internal.zzekd r3) {
        /*
        r0 = r3 instanceof com.google.android.gms.internal.zzekl;
        if (r0 != 0) goto L_0x0057;
    L_0x0004:
        r0 = r3 instanceof com.google.android.gms.internal.zzejf;
        if (r0 != 0) goto L_0x0057;
    L_0x0008:
        r0 = r3 instanceof com.google.android.gms.internal.zzejt;
        if (r0 != 0) goto L_0x0057;
    L_0x000c:
        r0 = r3 instanceof com.google.android.gms.internal.zzeju;
        if (r0 == 0) goto L_0x0011;
    L_0x0010:
        return r3;
    L_0x0011:
        r0 = r3 instanceof com.google.android.gms.internal.zzekb;
        if (r0 == 0) goto L_0x002d;
    L_0x0015:
        r0 = new com.google.android.gms.internal.zzejt;
        r3 = r3.getValue();
        r3 = (java.lang.Long) r3;
        r1 = r3.doubleValue();
        r3 = java.lang.Double.valueOf(r1);
        r1 = com.google.android.gms.internal.zzeju.zzcaf();
        r0.<init>(r3, r1);
        return r0;
    L_0x002d:
        r0 = new java.lang.IllegalStateException;
        r3 = r3.getValue();
        r3 = java.lang.String.valueOf(r3);
        r1 = 43;
        r2 = java.lang.String.valueOf(r3);
        r2 = r2.length();
        r1 = r1 + r2;
        r2 = new java.lang.StringBuilder;
        r2.<init>(r1);
        r1 = "Unexpected value passed to normalizeValue: ";
        r2.append(r1);
        r2.append(r3);
        r3 = r2.toString();
        r0.<init>(r3);
        throw r0;
    L_0x0057:
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzeih.zze(com.google.android.gms.internal.zzekd):com.google.android.gms.internal.zzekd");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        zzeih com_google_android_gms_internal_zzeih = (zzeih) obj;
        if (this.zznaf != null) {
            if (!this.zznaf.equals(com_google_android_gms_internal_zzeih.zznaf)) {
                return false;
            }
        } else if (com_google_android_gms_internal_zzeih.zznaf != null) {
            return false;
        }
        if (this.zznaa != null) {
            if (!this.zznaa.equals(com_google_android_gms_internal_zzeih.zznaa)) {
                return false;
            }
        } else if (com_google_android_gms_internal_zzeih.zznaa != null) {
            return false;
        }
        if (this.zznak != null) {
            if (!this.zznak.equals(com_google_android_gms_internal_zzeih.zznak)) {
                return false;
            }
        } else if (com_google_android_gms_internal_zzeih.zznak != null) {
            return false;
        }
        if (this.zznaj != null) {
            if (!this.zznaj.equals(com_google_android_gms_internal_zzeih.zznaj)) {
                return false;
            }
        } else if (com_google_android_gms_internal_zzeih.zznaj != null) {
            return false;
        }
        if (this.zznai != null) {
            if (!this.zznai.equals(com_google_android_gms_internal_zzeih.zznai)) {
                return false;
            }
        } else if (com_google_android_gms_internal_zzeih.zznai != null) {
            return false;
        }
        if (this.zznah != null) {
            if (!this.zznah.equals(com_google_android_gms_internal_zzeih.zznah)) {
                return false;
            }
        } else if (com_google_android_gms_internal_zzeih.zznah != null) {
            return false;
        }
        return zzbyt() == com_google_android_gms_internal_zzeih.zzbyt();
    }

    public final int getLimit() {
        if (zzbyp()) {
            return this.zznaf.intValue();
        }
        throw new IllegalArgumentException("Cannot get limit if limit has not been set");
    }

    public final int hashCode() {
        int i = 0;
        int intValue = (((((((((((this.zznaf != null ? this.zznaf.intValue() : 0) * 31) + (zzbyt() ? 1231 : 1237)) * 31) + (this.zznah != null ? this.zznah.hashCode() : 0)) * 31) + (this.zznai != null ? this.zznai.hashCode() : 0)) * 31) + (this.zznaj != null ? this.zznaj.hashCode() : 0)) * 31) + (this.zznak != null ? this.zznak.hashCode() : 0)) * 31;
        if (this.zznaa != null) {
            i = this.zznaa.hashCode();
        }
        return intValue + i;
    }

    public final boolean isDefault() {
        return zzbyv() && this.zznaa.equals(zzeki.zzcap());
    }

    public final String toString() {
        return zzbyu().toString();
    }

    public final zzeih zza(zzejv com_google_android_gms_internal_zzejv) {
        zzeih zzbys = zzbys();
        zzbys.zznaa = com_google_android_gms_internal_zzejv;
        return zzbys;
    }

    public final zzeih zza(zzekd com_google_android_gms_internal_zzekd, zzejg com_google_android_gms_internal_zzejg) {
        zzelt.zzcp(!(com_google_android_gms_internal_zzekd instanceof zzekb));
        zzeih zzbys = zzbys();
        zzbys.zznah = com_google_android_gms_internal_zzekd;
        zzbys.zznai = com_google_android_gms_internal_zzejg;
        return zzbys;
    }

    public final zzeih zzb(zzekd com_google_android_gms_internal_zzekd, zzejg com_google_android_gms_internal_zzejg) {
        zzelt.zzcp(!(com_google_android_gms_internal_zzekd instanceof zzekb));
        zzeih zzbys = zzbys();
        zzbys.zznaj = com_google_android_gms_internal_zzekd;
        zzbys.zznak = com_google_android_gms_internal_zzejg;
        return zzbys;
    }

    public final boolean zzbyj() {
        return this.zznah != null;
    }

    public final zzekd zzbyk() {
        if (zzbyj()) {
            return this.zznah;
        }
        throw new IllegalArgumentException("Cannot get index start value if start has not been set");
    }

    public final zzejg zzbyl() {
        if (zzbyj()) {
            return this.zznai != null ? this.zznai : zzejg.zzbzn();
        } else {
            throw new IllegalArgumentException("Cannot get index start name if start has not been set");
        }
    }

    public final boolean zzbym() {
        return this.zznaj != null;
    }

    public final zzekd zzbyn() {
        if (zzbym()) {
            return this.zznaj;
        }
        throw new IllegalArgumentException("Cannot get index end value if start has not been set");
    }

    public final zzejg zzbyo() {
        if (zzbym()) {
            return this.zznak != null ? this.zznak : zzejg.zzbzo();
        } else {
            throw new IllegalArgumentException("Cannot get index end name if start has not been set");
        }
    }

    public final boolean zzbyp() {
        return this.zznaf != null;
    }

    public final boolean zzbyq() {
        return zzbyp() && this.zznag != 0;
    }

    public final zzejv zzbyr() {
        return this.zznaa;
    }

    public final boolean zzbyt() {
        return this.zznag != 0 ? this.zznag == zzeij.zznan : zzbyj();
    }

    public final Map<String, Object> zzbyu() {
        Map<String, Object> hashMap = new HashMap();
        if (zzbyj()) {
            hashMap.put("sp", this.zznah.getValue());
            if (this.zznai != null) {
                hashMap.put("sn", this.zznai.asString());
            }
        }
        if (zzbym()) {
            hashMap.put("ep", this.zznaj.getValue());
            if (this.zznak != null) {
                hashMap.put("en", this.zznak.asString());
            }
        }
        if (this.zznaf != null) {
            Object obj;
            Object obj2;
            hashMap.put("l", this.zznaf);
            int i = this.zznag;
            if (i == 0) {
                i = zzbyj() ? zzeij.zznan : zzeij.zznao;
            }
            switch (zzeii.zznam[i - 1]) {
                case 1:
                    obj = "vf";
                    obj2 = "l";
                    break;
                case 2:
                    obj = "vf";
                    obj2 = "r";
                    break;
                default:
                    break;
            }
            hashMap.put(obj, obj2);
        }
        if (!this.zznaa.equals(zzeki.zzcap())) {
            hashMap.put("i", this.zznaa.zzcah());
        }
        return hashMap;
    }

    public final boolean zzbyv() {
        return (zzbyj() || zzbym() || zzbyp()) ? false : true;
    }

    public final String zzbyw() {
        if (this.zznal == null) {
            try {
                this.zznal = zzelh.zzbt(zzbyu());
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }
        return this.zznal;
    }

    public final zzeiw zzbyx() {
        return zzbyv() ? new zzeiu(this.zznaa) : zzbyp() ? new zzeiv(this) : new zzeiy(this);
    }

    public final zzeih zzgr(int i) {
        zzeih zzbys = zzbys();
        zzbys.zznaf = Integer.valueOf(i);
        zzbys.zznag = zzeij.zznan;
        return zzbys;
    }

    public final zzeih zzgs(int i) {
        zzeih zzbys = zzbys();
        zzbys.zznaf = Integer.valueOf(i);
        zzbys.zznag = zzeij.zznao;
        return zzbys;
    }
}
