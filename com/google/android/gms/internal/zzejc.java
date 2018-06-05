package com.google.android.gms.internal;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;

public final class zzejc {
    private final String prefix;
    private final zzejd zzmnq;
    private final String zznbl;

    public zzejc(zzejd com_google_android_gms_internal_zzejd, String str) {
        this(com_google_android_gms_internal_zzejd, str, null);
    }

    public zzejc(zzejd com_google_android_gms_internal_zzejd, String str, String str2) {
        this.zzmnq = com_google_android_gms_internal_zzejd;
        this.zznbl = str;
        this.prefix = str2;
    }

    private final String zzj(String str, Object... objArr) {
        if (objArr.length > 0) {
            str = String.format(str, objArr);
        }
        if (this.prefix == null) {
            return str;
        }
        String str2 = this.prefix;
        StringBuilder stringBuilder = new StringBuilder((3 + String.valueOf(str2).length()) + String.valueOf(str).length());
        stringBuilder.append(str2);
        stringBuilder.append(" - ");
        stringBuilder.append(str);
        return stringBuilder.toString();
    }

    private static String zzj(Throwable th) {
        Writer stringWriter = new StringWriter();
        zzdvl.zza(th, new PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    public final void info(String str) {
        this.zzmnq.zzb(zzeje.INFO, this.zznbl, zzj(str, new Object[0]), System.currentTimeMillis());
    }

    public final void zzb(String str, Throwable th, Object... objArr) {
        if (zzbzl()) {
            str = zzj(str, objArr);
            if (th != null) {
                String zzj = zzj(th);
                StringBuilder stringBuilder = new StringBuilder((1 + String.valueOf(str).length()) + String.valueOf(zzj).length());
                stringBuilder.append(str);
                stringBuilder.append("\n");
                stringBuilder.append(zzj);
                str = stringBuilder.toString();
            }
            this.zzmnq.zzb(zzeje.DEBUG, this.zznbl, str, System.currentTimeMillis());
        }
    }

    public final boolean zzbzl() {
        return this.zzmnq.zzbvy().ordinal() <= zzeje.DEBUG.ordinal();
    }

    public final void zzd(String str, Throwable th) {
        str = zzj(str, new Object[0]);
        String zzj = zzj(th);
        StringBuilder stringBuilder = new StringBuilder((1 + String.valueOf(str).length()) + String.valueOf(zzj).length());
        stringBuilder.append(str);
        stringBuilder.append("\n");
        stringBuilder.append(zzj);
        this.zzmnq.zzb(zzeje.ERROR, this.zznbl, stringBuilder.toString(), System.currentTimeMillis());
    }

    public final void zze(String str, Throwable th) {
        this.zzmnq.zzb(zzeje.WARN, this.zznbl, zzj(str, new Object[0]), System.currentTimeMillis());
    }
}
