package com.google.android.gms.internal;

import java.util.concurrent.BlockingQueue;

public final class zzn extends Thread {
    private final BlockingQueue<zzr<?>> zzaa;
    private final zzm zzab;
    private final zzb zzj;
    private final zzz zzk;
    private volatile boolean zzl = false;

    public zzn(BlockingQueue<zzr<?>> blockingQueue, zzm com_google_android_gms_internal_zzm, zzb com_google_android_gms_internal_zzb, zzz com_google_android_gms_internal_zzz) {
        this.zzaa = blockingQueue;
        this.zzab = com_google_android_gms_internal_zzm;
        this.zzj = com_google_android_gms_internal_zzb;
        this.zzk = com_google_android_gms_internal_zzz;
    }

    public final void quit() {
        this.zzl = true;
        interrupt();
    }

    public final void run() {
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
        r0 = 10;
        android.os.Process.setThreadPriority(r0);
    L_0x0005:
        r0 = android.os.SystemClock.elapsedRealtime();
        r2 = r8.zzaa;	 Catch:{ InterruptedException -> 0x00a0 }
        r2 = r2.take();	 Catch:{ InterruptedException -> 0x00a0 }
        r2 = (com.google.android.gms.internal.zzr) r2;	 Catch:{ InterruptedException -> 0x00a0 }
        r3 = "network-queue-take";	 Catch:{ zzad -> 0x008d, Exception -> 0x006a }
        r2.zzb(r3);	 Catch:{ zzad -> 0x008d, Exception -> 0x006a }
        r3 = r2.zzd();	 Catch:{ zzad -> 0x008d, Exception -> 0x006a }
        android.net.TrafficStats.setThreadStatsTag(r3);	 Catch:{ zzad -> 0x008d, Exception -> 0x006a }
        r3 = r8.zzab;	 Catch:{ zzad -> 0x008d, Exception -> 0x006a }
        r3 = r3.zzc(r2);	 Catch:{ zzad -> 0x008d, Exception -> 0x006a }
        r4 = "network-http-complete";	 Catch:{ zzad -> 0x008d, Exception -> 0x006a }
        r2.zzb(r4);	 Catch:{ zzad -> 0x008d, Exception -> 0x006a }
        r4 = r3.zzad;	 Catch:{ zzad -> 0x008d, Exception -> 0x006a }
        if (r4 == 0) goto L_0x003b;	 Catch:{ zzad -> 0x008d, Exception -> 0x006a }
    L_0x002c:
        r4 = r2.zzk();	 Catch:{ zzad -> 0x008d, Exception -> 0x006a }
        if (r4 == 0) goto L_0x003b;	 Catch:{ zzad -> 0x008d, Exception -> 0x006a }
    L_0x0032:
        r3 = "not-modified";	 Catch:{ zzad -> 0x008d, Exception -> 0x006a }
        r2.zzc(r3);	 Catch:{ zzad -> 0x008d, Exception -> 0x006a }
        r2.zzl();	 Catch:{ zzad -> 0x008d, Exception -> 0x006a }
        goto L_0x0005;	 Catch:{ zzad -> 0x008d, Exception -> 0x006a }
    L_0x003b:
        r3 = r2.zza(r3);	 Catch:{ zzad -> 0x008d, Exception -> 0x006a }
        r4 = "network-parse-complete";	 Catch:{ zzad -> 0x008d, Exception -> 0x006a }
        r2.zzb(r4);	 Catch:{ zzad -> 0x008d, Exception -> 0x006a }
        r4 = r2.zzg();	 Catch:{ zzad -> 0x008d, Exception -> 0x006a }
        if (r4 == 0) goto L_0x005e;	 Catch:{ zzad -> 0x008d, Exception -> 0x006a }
    L_0x004a:
        r4 = r3.zzbh;	 Catch:{ zzad -> 0x008d, Exception -> 0x006a }
        if (r4 == 0) goto L_0x005e;	 Catch:{ zzad -> 0x008d, Exception -> 0x006a }
    L_0x004e:
        r4 = r8.zzj;	 Catch:{ zzad -> 0x008d, Exception -> 0x006a }
        r5 = r2.getUrl();	 Catch:{ zzad -> 0x008d, Exception -> 0x006a }
        r6 = r3.zzbh;	 Catch:{ zzad -> 0x008d, Exception -> 0x006a }
        r4.zza(r5, r6);	 Catch:{ zzad -> 0x008d, Exception -> 0x006a }
        r4 = "network-cache-written";	 Catch:{ zzad -> 0x008d, Exception -> 0x006a }
        r2.zzb(r4);	 Catch:{ zzad -> 0x008d, Exception -> 0x006a }
    L_0x005e:
        r2.zzj();	 Catch:{ zzad -> 0x008d, Exception -> 0x006a }
        r4 = r8.zzk;	 Catch:{ zzad -> 0x008d, Exception -> 0x006a }
        r4.zzb(r2, r3);	 Catch:{ zzad -> 0x008d, Exception -> 0x006a }
        r2.zza(r3);	 Catch:{ zzad -> 0x008d, Exception -> 0x006a }
        goto L_0x0005;
    L_0x006a:
        r3 = move-exception;
        r4 = "Unhandled exception %s";
        r5 = 1;
        r5 = new java.lang.Object[r5];
        r6 = 0;
        r7 = r3.toString();
        r5[r6] = r7;
        com.google.android.gms.internal.zzae.zza(r3, r4, r5);
        r4 = new com.google.android.gms.internal.zzad;
        r4.<init>(r3);
        r5 = android.os.SystemClock.elapsedRealtime();
        r5 = r5 - r0;
        r4.zza(r5);
        r0 = r8.zzk;
        r0.zza(r2, r4);
        goto L_0x009b;
    L_0x008d:
        r3 = move-exception;
        r4 = android.os.SystemClock.elapsedRealtime();
        r4 = r4 - r0;
        r3.zza(r4);
        r0 = r8.zzk;
        r0.zza(r2, r3);
    L_0x009b:
        r2.zzl();
        goto L_0x0005;
    L_0x00a0:
        r0 = r8.zzl;
        if (r0 == 0) goto L_0x0005;
    L_0x00a4:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzn.run():void");
    }
}
