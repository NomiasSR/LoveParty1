package com.google.android.gms.internal;

public final class zzebk {
    private final String host;
    private final boolean secure;
    private final String zzjrg;

    public zzebk(String str, String str2, boolean z) {
        this.host = str;
        this.zzjrg = str2;
        this.secure = z;
    }

    public final String getHost() {
        return this.host;
    }

    public final String getNamespace() {
        return this.zzjrg;
    }

    public final boolean isSecure() {
        return this.secure;
    }

    public final String toString() {
        String str = this.secure ? "s" : "";
        String str2 = this.host;
        StringBuilder stringBuilder = new StringBuilder((7 + String.valueOf(str).length()) + String.valueOf(str2).length());
        stringBuilder.append("http");
        stringBuilder.append(str);
        stringBuilder.append("://");
        stringBuilder.append(str2);
        return stringBuilder.toString();
    }
}
