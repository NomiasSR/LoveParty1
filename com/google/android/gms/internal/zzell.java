package com.google.android.gms.internal;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;

final class zzell extends ScheduledThreadPoolExecutor {
    private /* synthetic */ zzelk zznez;

    zzell(zzelk com_google_android_gms_internal_zzelk, int i, ThreadFactory threadFactory) {
        this.zznez = com_google_android_gms_internal_zzelk;
        super(1, threadFactory);
    }

    protected final void afterExecute(java.lang.Runnable r2, java.lang.Throwable r3) {
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
        r1 = this;
        super.afterExecute(r2, r3);
        if (r3 != 0) goto L_0x0022;
    L_0x0005:
        r0 = r2 instanceof java.util.concurrent.Future;
        if (r0 == 0) goto L_0x0022;
    L_0x0009:
        r2 = (java.util.concurrent.Future) r2;
        r0 = r2.isDone();	 Catch:{ CancellationException -> 0x0022, ExecutionException -> 0x001d, InterruptedException -> 0x0015 }
        if (r0 == 0) goto L_0x0022;	 Catch:{ CancellationException -> 0x0022, ExecutionException -> 0x001d, InterruptedException -> 0x0015 }
    L_0x0011:
        r2.get();	 Catch:{ CancellationException -> 0x0022, ExecutionException -> 0x001d, InterruptedException -> 0x0015 }
        goto L_0x0022;
    L_0x0015:
        r2 = java.lang.Thread.currentThread();
        r2.interrupt();
        goto L_0x0022;
    L_0x001d:
        r2 = move-exception;
        r3 = r2.getCause();
    L_0x0022:
        if (r3 == 0) goto L_0x0029;
    L_0x0024:
        r2 = r1.zznez;
        r2.zzi(r3);
    L_0x0029:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzell.afterExecute(java.lang.Runnable, java.lang.Throwable):void");
    }
}
