package com.google.android.gms.internal;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeoutException;

final class zzcjy implements Callable<String> {
    private /* synthetic */ zzcjn zzjhc;

    zzcjy(zzcjn com_google_android_gms_internal_zzcjn) {
        this.zzjhc = com_google_android_gms_internal_zzcjn;
    }

    public final /* synthetic */ Object call() throws Exception {
        String zzazn = this.zzjhc.zzawz().zzazn();
        if (zzazn != null) {
            return zzazn;
        }
        zzcho zzazd;
        String str;
        zzcjk zzawm = this.zzjhc.zzawm();
        String str2 = null;
        if (zzawm.zzawx().zzazs()) {
            zzazd = zzawm.zzawy().zzazd();
            str = "Cannot retrieve app instance id from analytics worker thread";
        } else {
            zzawm.zzawx();
            if (zzcih.zzau()) {
                zzazd = zzawm.zzawy().zzazd();
                str = "Cannot retrieve app instance id from main thread";
            } else {
                long elapsedRealtime = zzawm.zzws().elapsedRealtime();
                String zzbd = zzawm.zzbd(120000);
                long elapsedRealtime2 = zzawm.zzws().elapsedRealtime() - elapsedRealtime;
                str2 = (zzbd != null || elapsedRealtime2 >= 120000) ? zzbd : zzawm.zzbd(120000 - elapsedRealtime2);
                if (str2 != null) {
                    throw new TimeoutException();
                }
                this.zzjhc.zzawz().zzjp(str2);
                return str2;
            }
        }
        zzazd.log(str);
        if (str2 != null) {
            this.zzjhc.zzawz().zzjp(str2);
            return str2;
        }
        throw new TimeoutException();
    }
}
