package com.google.android.gms.internal;

import java.util.concurrent.BlockingQueue;

public final class zzd extends Thread {
    private static final boolean DEBUG = zzae.DEBUG;
    private final BlockingQueue<zzr<?>> zzh;
    private final BlockingQueue<zzr<?>> zzi;
    private final zzb zzj;
    private final zzz zzk;
    private volatile boolean zzl = false;
    private final zzf zzm;

    public zzd(BlockingQueue<zzr<?>> blockingQueue, BlockingQueue<zzr<?>> blockingQueue2, zzb com_google_android_gms_internal_zzb, zzz com_google_android_gms_internal_zzz) {
        this.zzh = blockingQueue;
        this.zzi = blockingQueue2;
        this.zzj = com_google_android_gms_internal_zzb;
        this.zzk = com_google_android_gms_internal_zzz;
        this.zzm = new zzf(this);
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
        r0 = DEBUG;
        r1 = 0;
        if (r0 == 0) goto L_0x000c;
    L_0x0005:
        r0 = "start new dispatcher";
        r2 = new java.lang.Object[r1];
        com.google.android.gms.internal.zzae.zza(r0, r2);
    L_0x000c:
        r0 = 10;
        android.os.Process.setThreadPriority(r0);
        r0 = r8.zzj;
        r0.initialize();
    L_0x0016:
        r0 = r8.zzh;	 Catch:{ InterruptedException -> 0x00a4 }
        r0 = r0.take();	 Catch:{ InterruptedException -> 0x00a4 }
        r0 = (com.google.android.gms.internal.zzr) r0;	 Catch:{ InterruptedException -> 0x00a4 }
        r2 = "cache-queue-take";	 Catch:{ InterruptedException -> 0x00a4 }
        r0.zzb(r2);	 Catch:{ InterruptedException -> 0x00a4 }
        r2 = r8.zzj;	 Catch:{ InterruptedException -> 0x00a4 }
        r3 = r0.getUrl();	 Catch:{ InterruptedException -> 0x00a4 }
        r2 = r2.zza(r3);	 Catch:{ InterruptedException -> 0x00a4 }
        if (r2 != 0) goto L_0x0042;	 Catch:{ InterruptedException -> 0x00a4 }
    L_0x002f:
        r2 = "cache-miss";	 Catch:{ InterruptedException -> 0x00a4 }
        r0.zzb(r2);	 Catch:{ InterruptedException -> 0x00a4 }
        r2 = r8.zzm;	 Catch:{ InterruptedException -> 0x00a4 }
        r2 = r2.zzb(r0);	 Catch:{ InterruptedException -> 0x00a4 }
        if (r2 != 0) goto L_0x0016;	 Catch:{ InterruptedException -> 0x00a4 }
    L_0x003c:
        r2 = r8.zzi;	 Catch:{ InterruptedException -> 0x00a4 }
        r2.put(r0);	 Catch:{ InterruptedException -> 0x00a4 }
        goto L_0x0016;	 Catch:{ InterruptedException -> 0x00a4 }
    L_0x0042:
        r3 = r2.zza();	 Catch:{ InterruptedException -> 0x00a4 }
        if (r3 == 0) goto L_0x0059;	 Catch:{ InterruptedException -> 0x00a4 }
    L_0x0048:
        r3 = "cache-hit-expired";	 Catch:{ InterruptedException -> 0x00a4 }
        r0.zzb(r3);	 Catch:{ InterruptedException -> 0x00a4 }
        r0.zza(r2);	 Catch:{ InterruptedException -> 0x00a4 }
        r2 = r8.zzm;	 Catch:{ InterruptedException -> 0x00a4 }
        r2 = r2.zzb(r0);	 Catch:{ InterruptedException -> 0x00a4 }
        if (r2 != 0) goto L_0x0016;	 Catch:{ InterruptedException -> 0x00a4 }
    L_0x0058:
        goto L_0x003c;	 Catch:{ InterruptedException -> 0x00a4 }
    L_0x0059:
        r3 = "cache-hit";	 Catch:{ InterruptedException -> 0x00a4 }
        r0.zzb(r3);	 Catch:{ InterruptedException -> 0x00a4 }
        r3 = new com.google.android.gms.internal.zzp;	 Catch:{ InterruptedException -> 0x00a4 }
        r4 = r2.data;	 Catch:{ InterruptedException -> 0x00a4 }
        r5 = r2.zzf;	 Catch:{ InterruptedException -> 0x00a4 }
        r3.<init>(r4, r5);	 Catch:{ InterruptedException -> 0x00a4 }
        r3 = r0.zza(r3);	 Catch:{ InterruptedException -> 0x00a4 }
        r4 = "cache-hit-parsed";	 Catch:{ InterruptedException -> 0x00a4 }
        r0.zzb(r4);	 Catch:{ InterruptedException -> 0x00a4 }
        r4 = r2.zze;	 Catch:{ InterruptedException -> 0x00a4 }
        r6 = java.lang.System.currentTimeMillis();	 Catch:{ InterruptedException -> 0x00a4 }
        r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));	 Catch:{ InterruptedException -> 0x00a4 }
        r5 = 1;	 Catch:{ InterruptedException -> 0x00a4 }
        if (r4 >= 0) goto L_0x007d;	 Catch:{ InterruptedException -> 0x00a4 }
    L_0x007b:
        r4 = r5;	 Catch:{ InterruptedException -> 0x00a4 }
        goto L_0x007e;	 Catch:{ InterruptedException -> 0x00a4 }
    L_0x007d:
        r4 = r1;	 Catch:{ InterruptedException -> 0x00a4 }
    L_0x007e:
        if (r4 != 0) goto L_0x0086;	 Catch:{ InterruptedException -> 0x00a4 }
    L_0x0080:
        r2 = r8.zzk;	 Catch:{ InterruptedException -> 0x00a4 }
        r2.zzb(r0, r3);	 Catch:{ InterruptedException -> 0x00a4 }
        goto L_0x0016;	 Catch:{ InterruptedException -> 0x00a4 }
    L_0x0086:
        r4 = "cache-hit-refresh-needed";	 Catch:{ InterruptedException -> 0x00a4 }
        r0.zzb(r4);	 Catch:{ InterruptedException -> 0x00a4 }
        r0.zza(r2);	 Catch:{ InterruptedException -> 0x00a4 }
        r3.zzbj = r5;	 Catch:{ InterruptedException -> 0x00a4 }
        r2 = r8.zzm;	 Catch:{ InterruptedException -> 0x00a4 }
        r2 = r2.zzb(r0);	 Catch:{ InterruptedException -> 0x00a4 }
        if (r2 != 0) goto L_0x0080;	 Catch:{ InterruptedException -> 0x00a4 }
    L_0x0098:
        r2 = r8.zzk;	 Catch:{ InterruptedException -> 0x00a4 }
        r4 = new com.google.android.gms.internal.zze;	 Catch:{ InterruptedException -> 0x00a4 }
        r4.<init>(r8, r0);	 Catch:{ InterruptedException -> 0x00a4 }
        r2.zza(r0, r3, r4);	 Catch:{ InterruptedException -> 0x00a4 }
        goto L_0x0016;
    L_0x00a4:
        r0 = r8.zzl;
        if (r0 == 0) goto L_0x0016;
    L_0x00a8:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzd.run():void");
    }
}
