package com.google.android.gms.internal;

import android.util.Base64;
import java.net.URI;
import java.util.LinkedHashMap;
import java.util.Map;

final class zzelb {
    private String protocol = null;
    private URI zzndu = null;
    private String zznej = null;
    private Map<String, String> zznek = null;

    public zzelb(URI uri, String str, Map<String, String> map) {
        this.zzndu = uri;
        this.protocol = null;
        this.zznek = map;
        this.zznej = zzcaz();
    }

    private static String zza(LinkedHashMap<String, String> linkedHashMap) {
        String str = new String();
        for (String str2 : linkedHashMap.keySet()) {
            str = String.valueOf(str);
            String str3 = (String) linkedHashMap.get(str2);
            StringBuilder stringBuilder = new StringBuilder(((4 + String.valueOf(str).length()) + String.valueOf(str2).length()) + String.valueOf(str3).length());
            stringBuilder.append(str);
            stringBuilder.append(str2);
            stringBuilder.append(": ");
            stringBuilder.append(str3);
            stringBuilder.append("\r\n");
            str = stringBuilder.toString();
        }
        return str;
    }

    private static String zzcaz() {
        byte[] bArr = new byte[16];
        for (int i = 0; i < 16; i++) {
            bArr[i] = (byte) ((int) ((Math.random() * 255.0d) + 0.0d));
        }
        return Base64.encodeToString(bArr, 2);
    }

    public final byte[] zzcay() {
        Object obj;
        String path = this.zzndu.getPath();
        String query = this.zzndu.getQuery();
        path = String.valueOf(path);
        if (query == null) {
            obj = "";
        } else {
            String str = "?";
            query = String.valueOf(query);
            obj = query.length() != 0 ? str.concat(query) : new String(str);
        }
        query = String.valueOf(obj);
        path = query.length() != 0 ? path.concat(query) : new String(path);
        obj = this.zzndu.getHost();
        if (this.zzndu.getPort() != -1) {
            query = String.valueOf(obj);
            int port = this.zzndu.getPort();
            StringBuilder stringBuilder = new StringBuilder(12 + String.valueOf(query).length());
            stringBuilder.append(query);
            stringBuilder.append(":");
            stringBuilder.append(port);
            obj = stringBuilder.toString();
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("Host", obj);
        linkedHashMap.put("Upgrade", "websocket");
        linkedHashMap.put("Connection", "Upgrade");
        linkedHashMap.put("Sec-WebSocket-Version", "13");
        linkedHashMap.put("Sec-WebSocket-Key", this.zznej);
        if (this.protocol != null) {
            linkedHashMap.put("Sec-WebSocket-Protocol", this.protocol);
        }
        if (this.zznek != null) {
            for (String str2 : this.zznek.keySet()) {
                if (!linkedHashMap.containsKey(str2)) {
                    linkedHashMap.put(str2, (String) this.zznek.get(str2));
                }
            }
        }
        StringBuilder stringBuilder2 = new StringBuilder(15 + String.valueOf(path).length());
        stringBuilder2.append("GET ");
        stringBuilder2.append(path);
        stringBuilder2.append(" HTTP/1.1\r\n");
        path = String.valueOf(stringBuilder2.toString());
        query = String.valueOf(zza(linkedHashMap));
        path = String.valueOf(query.length() != 0 ? path.concat(query) : new String(path)).concat("\r\n");
        obj = new byte[path.getBytes().length];
        System.arraycopy(path.getBytes(), 0, obj, 0, path.getBytes().length);
        return obj;
    }
}
