package com.google.android.gms.internal;

import com.google.firebase.database.DatabaseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class zzekg {
    public static zzekd zza(Object obj, zzekd com_google_android_gms_internal_zzekd) throws DatabaseException {
        try {
            Map map;
            if (obj instanceof Map) {
                map = (Map) obj;
                if (map.containsKey(".priority")) {
                    com_google_android_gms_internal_zzekd = zzekj.zzc(null, map.get(".priority"));
                }
                if (map.containsKey(".value")) {
                    obj = map.get(".value");
                }
            }
            if (obj == null) {
                return zzeju.zzcaf();
            }
            if (obj instanceof String) {
                return new zzekl((String) obj, com_google_android_gms_internal_zzekd);
            }
            if (obj instanceof Long) {
                return new zzekb((Long) obj, com_google_android_gms_internal_zzekd);
            }
            if (obj instanceof Integer) {
                return new zzekb(Long.valueOf((long) ((Integer) obj).intValue()), com_google_android_gms_internal_zzekd);
            }
            if (obj instanceof Double) {
                return new zzejt((Double) obj, com_google_android_gms_internal_zzekd);
            }
            if (obj instanceof Boolean) {
                return new zzejf((Boolean) obj, com_google_android_gms_internal_zzekd);
            }
            if (!(obj instanceof Map)) {
                if (!(obj instanceof List)) {
                    String str = "Failed to parse node with class ";
                    String valueOf = String.valueOf(obj.getClass().toString());
                    throw new DatabaseException(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
                }
            }
            String stringBuilder;
            zzekd zza;
            if (obj instanceof Map) {
                Map map2 = (Map) obj;
                if (map2.containsKey(".sv")) {
                    return new zzejs(map2, com_google_android_gms_internal_zzekd);
                }
                map = new HashMap(map2.size());
                for (String stringBuilder2 : map2.keySet()) {
                    if (!stringBuilder2.startsWith(".")) {
                        zza = zza(map2.get(stringBuilder2), zzeju.zzcaf());
                        if (!zza.isEmpty()) {
                            map.put(zzejg.zzpz(stringBuilder2), zza);
                        }
                    }
                }
            } else {
                List list = (List) obj;
                map = new HashMap(list.size());
                for (int i = 0; i < list.size(); i++) {
                    StringBuilder stringBuilder3 = new StringBuilder(11);
                    stringBuilder3.append(i);
                    stringBuilder2 = stringBuilder3.toString();
                    zza = zza(list.get(i), zzeju.zzcaf());
                    if (!zza.isEmpty()) {
                        map.put(zzejg.zzpz(stringBuilder2), zza);
                    }
                }
            }
            return map.isEmpty() ? zzeju.zzcaf() : new zzeji(zzeah.zza(map, zzeji.zznbw), com_google_android_gms_internal_zzekd);
        } catch (Throwable e) {
            throw new DatabaseException("Failed to parse node", e);
        }
    }
}
