package com.google.android.gms.internal;

import com.google.firebase.database.DatabaseException;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.regex.Pattern;

public final class zzelv {
    private static final Pattern zznfh = Pattern.compile("[\\[\\]\\.#$]");
    private static final Pattern zznfi = Pattern.compile("[\\[\\]\\.#\\$\\/\\u0000-\\u001F\\u007F]");

    public static void zzao(zzedk com_google_android_gms_internal_zzedk) throws DatabaseException {
        Object obj;
        zzejg zzbwh = com_google_android_gms_internal_zzedk.zzbwh();
        if (zzbwh != null) {
            if (zzbwh.asString().startsWith(".")) {
                obj = null;
                if (obj == null) {
                    String str = "Invalid write location: ";
                    String valueOf = String.valueOf(com_google_android_gms_internal_zzedk.toString());
                    throw new DatabaseException(valueOf.length() == 0 ? str.concat(valueOf) : new String(str));
                }
            }
        }
        obj = 1;
        if (obj == null) {
            String str2 = "Invalid write location: ";
            String valueOf2 = String.valueOf(com_google_android_gms_internal_zzedk.toString());
            if (valueOf2.length() == 0) {
            }
            throw new DatabaseException(valueOf2.length() == 0 ? str2.concat(valueOf2) : new String(str2));
        }
    }

    public static Map<zzedk, zzekd> zzb(zzedk com_google_android_gms_internal_zzedk, Map<String, Object> map) throws DatabaseException {
        Map treeMap = new TreeMap();
        for (Entry entry : map.entrySet()) {
            zzedk com_google_android_gms_internal_zzedk2 = new zzedk((String) entry.getKey());
            Object value = entry.getValue();
            zzege.zza(com_google_android_gms_internal_zzedk.zzh(com_google_android_gms_internal_zzedk2), value);
            String asString = !com_google_android_gms_internal_zzedk2.isEmpty() ? com_google_android_gms_internal_zzedk2.zzbwk().asString() : "";
            if (!asString.equals(".sv")) {
                if (!asString.equals(".value")) {
                    Object zzc = asString.equals(".priority") ? zzekj.zzc(com_google_android_gms_internal_zzedk2, value) : zzekg.zza(value, zzeju.zzcaf());
                    zzbv(value);
                    treeMap.put(com_google_android_gms_internal_zzedk2, zzc);
                }
            }
            String valueOf = String.valueOf(com_google_android_gms_internal_zzedk2);
            StringBuilder stringBuilder = new StringBuilder((40 + String.valueOf(valueOf).length()) + String.valueOf(asString).length());
            stringBuilder.append("Path '");
            stringBuilder.append(valueOf);
            stringBuilder.append("' contains disallowed child name: ");
            stringBuilder.append(asString);
            throw new DatabaseException(stringBuilder.toString());
        }
        com_google_android_gms_internal_zzedk = null;
        for (zzedk com_google_android_gms_internal_zzedk3 : treeMap.keySet()) {
            boolean z;
            if (com_google_android_gms_internal_zzedk != null) {
                if (com_google_android_gms_internal_zzedk.zzj(com_google_android_gms_internal_zzedk3) >= 0) {
                    z = false;
                    zzelt.zzcp(z);
                    if (com_google_android_gms_internal_zzedk == null && com_google_android_gms_internal_zzedk.zzi(com_google_android_gms_internal_zzedk3)) {
                        String valueOf2 = String.valueOf(com_google_android_gms_internal_zzedk);
                        String valueOf3 = String.valueOf(com_google_android_gms_internal_zzedk3);
                        StringBuilder stringBuilder2 = new StringBuilder((42 + String.valueOf(valueOf2).length()) + String.valueOf(valueOf3).length());
                        stringBuilder2.append("Path '");
                        stringBuilder2.append(valueOf2);
                        stringBuilder2.append("' is an ancestor of '");
                        stringBuilder2.append(valueOf3);
                        stringBuilder2.append("' in an update.");
                        throw new DatabaseException(stringBuilder2.toString());
                    }
                    com_google_android_gms_internal_zzedk = com_google_android_gms_internal_zzedk3;
                }
            }
            z = true;
            zzelt.zzcp(z);
            if (com_google_android_gms_internal_zzedk == null) {
            }
            com_google_android_gms_internal_zzedk = com_google_android_gms_internal_zzedk3;
        }
        return treeMap;
    }

    public static void zzbv(Object obj) {
        if (obj instanceof Map) {
            Map map = (Map) obj;
            if (!map.containsKey(".sv")) {
                for (Entry entry : map.entrySet()) {
                    String str = (String) entry.getKey();
                    Object obj2 = (str == null || str.length() <= 0 || !(str.equals(".value") || str.equals(".priority") || (!str.startsWith(".") && !zznfi.matcher(str).find()))) ? null : 1;
                    if (obj2 == null) {
                        StringBuilder stringBuilder = new StringBuilder(68 + String.valueOf(str).length());
                        stringBuilder.append("Invalid key: ");
                        stringBuilder.append(str);
                        stringBuilder.append(". Keys must not contain '/', '.', '#', '$', '[', or ']'");
                        throw new DatabaseException(stringBuilder.toString());
                    }
                    zzbv(entry.getValue());
                }
            }
        } else if (obj instanceof List) {
            for (Object zzbv : (List) obj) {
                zzbv(zzbv);
            }
        } else {
            if ((obj instanceof Double) || (obj instanceof Float)) {
                double doubleValue = ((Double) obj).doubleValue();
                if (!Double.isInfinite(doubleValue)) {
                    if (Double.isNaN(doubleValue)) {
                    }
                }
                throw new DatabaseException("Invalid value: Value cannot be NaN, Inf or -Inf.");
            }
        }
    }

    public static void zzqh(String str) throws DatabaseException {
        if ((zznfh.matcher(str).find() ^ 1) == 0) {
            StringBuilder stringBuilder = new StringBuilder(101 + String.valueOf(str).length());
            stringBuilder.append("Invalid Firebase Database path: ");
            stringBuilder.append(str);
            stringBuilder.append(". Firebase Database paths must not contain '.', '#', '$', '[', or ']'");
            throw new DatabaseException(stringBuilder.toString());
        }
    }

    public static void zzqi(String str) throws DatabaseException {
        int i;
        if (str.startsWith(".info")) {
            i = 5;
        } else if (str.startsWith("/.info")) {
            i = 6;
        } else {
            zzqh(str);
            return;
        }
        zzqh(str.substring(i));
    }

    public static void zzqj(String str) throws DatabaseException {
        if (str != null) {
            Object obj;
            StringBuilder stringBuilder;
            if (!str.equals(".info")) {
                if (zznfi.matcher(str).find()) {
                    obj = null;
                    if (obj == null) {
                        stringBuilder = new StringBuilder(68 + String.valueOf(str).length());
                        stringBuilder.append("Invalid key: ");
                        stringBuilder.append(str);
                        stringBuilder.append(". Keys must not contain '/', '.', '#', '$', '[', or ']'");
                        throw new DatabaseException(stringBuilder.toString());
                    }
                }
            }
            obj = 1;
            if (obj == null) {
                stringBuilder = new StringBuilder(68 + String.valueOf(str).length());
                stringBuilder.append("Invalid key: ");
                stringBuilder.append(str);
                stringBuilder.append(". Keys must not contain '/', '.', '#', '$', '[', or ']'");
                throw new DatabaseException(stringBuilder.toString());
            }
        }
    }
}
