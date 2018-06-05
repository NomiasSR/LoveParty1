package com.google.android.gms.common.api.internal;

import android.os.IBinder;
import android.os.IBinder.DeathRecipient;
import com.google.android.gms.common.api.zze;
import java.lang.ref.WeakReference;

final class zzdl implements DeathRecipient, zzdm {
    private final WeakReference<BasePendingResult<?>> zzfvl;
    private final WeakReference<zze> zzfvm;
    private final WeakReference<IBinder> zzfvn;

    private zzdl(BasePendingResult<?> basePendingResult, zze com_google_android_gms_common_api_zze, IBinder iBinder) {
        this.zzfvm = new WeakReference(com_google_android_gms_common_api_zze);
        this.zzfvl = new WeakReference(basePendingResult);
        this.zzfvn = new WeakReference(iBinder);
    }

    private final void zzajv() {
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
        r2 = this;
        r0 = r2.zzfvl;
        r0 = r0.get();
        r0 = (com.google.android.gms.common.api.internal.BasePendingResult) r0;
        r1 = r2.zzfvm;
        r1 = r1.get();
        r1 = (com.google.android.gms.common.api.zze) r1;
        if (r1 == 0) goto L_0x001f;
    L_0x0012:
        if (r0 == 0) goto L_0x001f;
    L_0x0014:
        r0 = r0.zzagv();
        r0 = r0.intValue();
        r1.remove(r0);
    L_0x001f:
        r0 = r2.zzfvn;
        r0 = r0.get();
        r0 = (android.os.IBinder) r0;
        if (r0 == 0) goto L_0x002d;
    L_0x0029:
        r1 = 0;
        r0.unlinkToDeath(r2, r1);	 Catch:{ NoSuchElementException -> 0x002d }
    L_0x002d:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.internal.zzdl.zzajv():void");
    }

    public final void binderDied() {
        zzajv();
    }

    public final void zzc(BasePendingResult<?> basePendingResult) {
        zzajv();
    }
}
