package com.google.android.gms.internal;

import com.google.android.gms.measurement.AppMeasurement.Param;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public final class zzeex {
    public static zzecy zza(zzecy com_google_android_gms_internal_zzecy, Map<String, Object> map) {
        zzecy zzbvq = zzecy.zzbvq();
        Iterator it = com_google_android_gms_internal_zzecy.iterator();
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            zzbvq = zzbvq.zze((zzedk) entry.getKey(), zza((zzekd) entry.getValue(), (Map) map));
        }
        return zzbvq;
    }

    public static zzekd zza(zzekd com_google_android_gms_internal_zzekd, Map<String, Object> map) {
        Object value = com_google_android_gms_internal_zzekd.zzbzv().getValue();
        if (value instanceof Map) {
            Map map2 = (Map) value;
            if (map2.containsKey(".sv")) {
                value = map.get((String) map2.get(".sv"));
            }
        }
        zzekd zzc = zzekj.zzc(null, value);
        if (com_google_android_gms_internal_zzekd.zzbzu()) {
            Object value2 = com_google_android_gms_internal_zzekd.getValue();
            if (value2 instanceof Map) {
                Map map3 = (Map) value2;
                if (map3.containsKey(".sv")) {
                    String str = (String) map3.get(".sv");
                    if (map.containsKey(str)) {
                        value2 = map.get(str);
                    }
                }
            }
            if (value2.equals(com_google_android_gms_internal_zzekd.getValue())) {
                if (zzc.equals(com_google_android_gms_internal_zzekd.zzbzv())) {
                    return com_google_android_gms_internal_zzekd;
                }
            }
            return zzekg.zza(value2, zzc);
        } else if (com_google_android_gms_internal_zzekd.isEmpty()) {
            return com_google_android_gms_internal_zzekd;
        } else {
            zzeji com_google_android_gms_internal_zzeji = (zzeji) com_google_android_gms_internal_zzekd;
            zzefa com_google_android_gms_internal_zzefa = new zzefa(com_google_android_gms_internal_zzeji);
            com_google_android_gms_internal_zzeji.zza(new zzeez(map, com_google_android_gms_internal_zzefa), false);
            return !com_google_android_gms_internal_zzefa.zzbwr().zzbzv().equals(zzc) ? com_google_android_gms_internal_zzefa.zzbwr().zzf(zzc) : com_google_android_gms_internal_zzefa.zzbwr();
        }
    }

    public static Map<String, Object> zza(zzeli com_google_android_gms_internal_zzeli) {
        Map<String, Object> hashMap = new HashMap();
        hashMap.put(Param.TIMESTAMP, Long.valueOf(com_google_android_gms_internal_zzeli.millis()));
        return hashMap;
    }
}
