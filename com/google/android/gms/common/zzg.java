package com.google.android.gms.common;

import android.content.Context;
import android.util.Log;
import com.google.android.gms.common.internal.zzba;
import com.google.android.gms.common.internal.zzbb;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.dynamic.zzn;
import com.google.android.gms.dynamite.DynamiteModule;

final class zzg {
    private static zzba zzfky;
    private static final Object zzfkz = new Object();
    private static Context zzfla;

    static boolean zza(String str, zzh com_google_android_gms_common_zzh) {
        return zza(str, com_google_android_gms_common_zzh, false);
    }

    private static boolean zza(String str, zzh com_google_android_gms_common_zzh, boolean z) {
        if (!zzafz()) {
            return false;
        }
        zzbq.checkNotNull(zzfla);
        try {
            return zzfky.zza(new zzn(str, com_google_android_gms_common_zzh, z), zzn.zzz(zzfla.getPackageManager()));
        } catch (Throwable e) {
            Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e);
            return false;
        }
    }

    private static boolean zzafz() {
        if (zzfky != null) {
            return true;
        }
        zzbq.checkNotNull(zzfla);
        synchronized (zzfkz) {
            if (zzfky == null) {
                try {
                    zzfky = zzbb.zzan(DynamiteModule.zza(zzfla, DynamiteModule.zzgwz, "com.google.android.gms.googlecertificates").zzhb("com.google.android.gms.common.GoogleCertificatesImpl"));
                } catch (Throwable e) {
                    Log.e("GoogleCertificates", "Failed to load com.google.android.gms.googlecertificates", e);
                    return false;
                }
            }
        }
        return true;
    }

    static boolean zzb(String str, zzh com_google_android_gms_common_zzh) {
        return zza(str, com_google_android_gms_common_zzh, true);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static synchronized void zzcg(android.content.Context r2) {
        /*
        r0 = com.google.android.gms.common.zzg.class;
        monitor-enter(r0);
        r1 = zzfla;	 Catch:{ all -> 0x001a }
        if (r1 != 0) goto L_0x0011;
    L_0x0007:
        if (r2 == 0) goto L_0x0018;
    L_0x0009:
        r2 = r2.getApplicationContext();	 Catch:{ all -> 0x001a }
        zzfla = r2;	 Catch:{ all -> 0x001a }
        monitor-exit(r0);
        return;
    L_0x0011:
        r2 = "GoogleCertificates";
        r1 = "GoogleCertificates has been initialized already";
        android.util.Log.w(r2, r1);	 Catch:{ all -> 0x001a }
    L_0x0018:
        monitor-exit(r0);
        return;
    L_0x001a:
        r2 = move-exception;
        monitor-exit(r0);
        throw r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.zzg.zzcg(android.content.Context):void");
    }
}
