package com.google.android.gms.internal;

import com.google.firebase.database.DatabaseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class zzege {
    private final List<String> zzmwu = new ArrayList();
    private int zzmwv;

    private zzege(zzedk com_google_android_gms_internal_zzedk) throws DatabaseException {
        int i = 0;
        this.zzmwv = 0;
        Iterator it = com_google_android_gms_internal_zzedk.iterator();
        while (it.hasNext()) {
            this.zzmwu.add(((zzejg) it.next()).asString());
        }
        this.zzmwv = Math.max(1, this.zzmwu.size());
        while (i < this.zzmwu.size()) {
            this.zzmwv += zzc((CharSequence) this.zzmwu.get(i));
            i++;
        }
        zzbxd();
    }

    public static void zza(zzedk com_google_android_gms_internal_zzedk, Object obj) throws DatabaseException {
        new zzege(com_google_android_gms_internal_zzedk).zzbr(obj);
    }

    private final void zzbr(Object obj) throws DatabaseException {
        if (obj instanceof Map) {
            Map map = (Map) obj;
            for (String str : map.keySet()) {
                if (!str.startsWith(".")) {
                    zzpy(str);
                    zzbr(map.get(str));
                    zzbxc();
                }
            }
            return;
        }
        if (obj instanceof List) {
            List list = (List) obj;
            for (int i = 0; i < list.size(); i++) {
                zzpy(Integer.toString(i));
                zzbr(list.get(i));
                zzbxc();
            }
        }
    }

    private final String zzbxc() {
        String str = (String) this.zzmwu.remove(this.zzmwu.size() - 1);
        this.zzmwv -= zzc(str);
        if (this.zzmwu.size() > 0) {
            this.zzmwv--;
        }
        return str;
    }

    private final void zzbxd() throws DatabaseException {
        String str;
        StringBuilder stringBuilder;
        if (this.zzmwv > 768) {
            str = "Data has a key path longer than 768 bytes (";
            int i = this.zzmwv;
            stringBuilder = new StringBuilder(13 + String.valueOf(str).length());
            stringBuilder.append(str);
            stringBuilder.append(i);
            stringBuilder.append(").");
            throw new DatabaseException(stringBuilder.toString());
        } else if (this.zzmwu.size() > 32) {
            Object obj;
            String zzg;
            str = String.valueOf("Path specified exceeds the maximum depth that can be written (32) or object contains a cycle ");
            if (this.zzmwu.size() == 0) {
                obj = "";
            } else {
                zzg = zzg("/", this.zzmwu);
                stringBuilder = new StringBuilder(10 + String.valueOf(zzg).length());
                stringBuilder.append("in path '");
                stringBuilder.append(zzg);
                stringBuilder.append("'");
                obj = stringBuilder.toString();
            }
            zzg = String.valueOf(obj);
            throw new DatabaseException(zzg.length() != 0 ? str.concat(zzg) : new String(str));
        }
    }

    private static int zzc(CharSequence charSequence) {
        int length = charSequence.length();
        int i = 0;
        int i2 = 0;
        while (i < length) {
            char charAt = charSequence.charAt(i);
            if (charAt <= '') {
                i2++;
            } else if (charAt <= '߿') {
                i2 += 2;
            } else if (Character.isHighSurrogate(charAt)) {
                i2 += 4;
                i++;
            } else {
                i2 += 3;
            }
            i++;
        }
        return i2;
    }

    private static String zzg(String str, List<String> list) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            if (i > 0) {
                stringBuilder.append(str);
            }
            stringBuilder.append((String) list.get(i));
        }
        return stringBuilder.toString();
    }

    private final void zzpy(String str) throws DatabaseException {
        if (this.zzmwu.size() > 0) {
            this.zzmwv++;
        }
        this.zzmwu.add(str);
        this.zzmwv += zzc(str);
        zzbxd();
    }
}
