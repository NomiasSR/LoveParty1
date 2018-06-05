package com.google.android.gms.internal;

import com.google.android.gms.common.util.zzd;
import com.google.android.gms.common.util.zzh;
import com.google.firebase.FirebaseApp;
import java.util.Random;

public final class zzexr {
    private static zzd zzegr = zzh.zzamg();
    private static Random zzlgv = new Random();
    private static zzext zzolw = new zzexu();
    private volatile boolean zzan;
    private FirebaseApp zzoic;
    private long zzolx;

    public zzexr(FirebaseApp firebaseApp, long j) {
        this.zzoic = firebaseApp;
        this.zzolx = j;
    }

    public static boolean zzin(int i) {
        if (!((i >= 500 && i < 600) || i == -2 || i == 429)) {
            if (i != 408) {
                return false;
            }
        }
        return true;
    }

    public final void cancel() {
        this.zzan = true;
    }

    public final void reset() {
        this.zzan = false;
    }

    public final void zza(@android.support.annotation.NonNull com.google.android.gms.internal.zzeyc r9, boolean r10) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r8 = this;
        com.google.android.gms.common.internal.zzbq.checkNotNull(r9);
        r0 = zzegr;
        r0 = r0.elapsedRealtime();
        r2 = r8.zzolx;
        r0 = r0 + r2;
        if (r10 == 0) goto L_0x001e;
    L_0x000e:
        r2 = r8.zzoic;
        r2 = com.google.android.gms.internal.zzexw.zzh(r2);
        r3 = r8.zzoic;
        r3 = r3.getApplicationContext();
        r9.zze(r2, r3);
        goto L_0x0027;
    L_0x001e:
        r2 = r8.zzoic;
        r2 = com.google.android.gms.internal.zzexw.zzh(r2);
        r9.zzsm(r2);
    L_0x0027:
        r2 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r3 = r2;
    L_0x002a:
        r4 = zzegr;
        r4 = r4.elapsedRealtime();
        r6 = (long) r3;
        r4 = r4 + r6;
        r4 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1));
        if (r4 > 0) goto L_0x00a3;
    L_0x0036:
        r4 = r9.zzcmm();
        if (r4 != 0) goto L_0x00a3;
    L_0x003c:
        r4 = r9.getResultCode();
        r4 = zzin(r4);
        if (r4 == 0) goto L_0x00a3;
    L_0x0046:
        r4 = zzolw;	 Catch:{ InterruptedException -> 0x0095 }
        r5 = zzlgv;	 Catch:{ InterruptedException -> 0x0095 }
        r6 = 250; // 0xfa float:3.5E-43 double:1.235E-321;	 Catch:{ InterruptedException -> 0x0095 }
        r5 = r5.nextInt(r6);	 Catch:{ InterruptedException -> 0x0095 }
        r5 = r5 + r3;	 Catch:{ InterruptedException -> 0x0095 }
        r4.zzio(r5);	 Catch:{ InterruptedException -> 0x0095 }
        r4 = 30000; // 0x7530 float:4.2039E-41 double:1.4822E-319;
        if (r3 >= r4) goto L_0x0071;
    L_0x0058:
        r4 = r9.getResultCode();
        r5 = -2;
        if (r4 == r5) goto L_0x0069;
    L_0x005f:
        r3 = r3 << 1;
        r4 = "ExponenentialBackoff";
        r5 = "network error occurred, backing off/sleeping.";
        android.util.Log.w(r4, r5);
        goto L_0x0071;
    L_0x0069:
        r3 = "ExponenentialBackoff";
        r4 = "network unavailable, sleeping.";
        android.util.Log.w(r3, r4);
        r3 = r2;
    L_0x0071:
        r4 = r8.zzan;
        if (r4 == 0) goto L_0x0076;
    L_0x0075:
        return;
    L_0x0076:
        r9.reset();
        if (r10 == 0) goto L_0x008b;
    L_0x007b:
        r4 = r8.zzoic;
        r4 = com.google.android.gms.internal.zzexw.zzh(r4);
        r5 = r8.zzoic;
        r5 = r5.getApplicationContext();
        r9.zze(r4, r5);
        goto L_0x002a;
    L_0x008b:
        r4 = r8.zzoic;
        r4 = com.google.android.gms.internal.zzexw.zzh(r4);
        r9.zzsm(r4);
        goto L_0x002a;
    L_0x0095:
        r9 = "ExponenentialBackoff";
        r10 = "thread interrupted during exponential backoff.";
        android.util.Log.w(r9, r10);
        r9 = java.lang.Thread.currentThread();
        r9.interrupt();
    L_0x00a3:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzexr.zza(com.google.android.gms.internal.zzeyc, boolean):void");
    }
}
