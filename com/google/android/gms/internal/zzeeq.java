package com.google.android.gms.internal;

public final class zzeeq {
    public String host;
    public boolean secure;
    public String zzjrg;
    public String zzmuy;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        zzeeq com_google_android_gms_internal_zzeeq = (zzeeq) obj;
        return (this.secure == com_google_android_gms_internal_zzeeq.secure && this.host.equals(com_google_android_gms_internal_zzeeq.host)) ? this.zzjrg.equals(com_google_android_gms_internal_zzeeq.zzjrg) : false;
    }

    public final int hashCode() {
        return (((this.host.hashCode() * 31) + this.secure) * 31) + this.zzjrg.hashCode();
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
