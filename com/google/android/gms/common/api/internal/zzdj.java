package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.Api.zze;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

public final class zzdj {
    public static final Status zzfvg = new Status(8, "The connection to Google Play services was lost");
    private static final BasePendingResult<?>[] zzfvh = new BasePendingResult[0];
    private final Map<zzc<?>, zze> zzfsb;
    final Set<BasePendingResult<?>> zzfvi = Collections.synchronizedSet(Collections.newSetFromMap(new WeakHashMap()));
    private final zzdm zzfvj = new zzdk(this);

    public zzdj(Map<zzc<?>, zze> map) {
        this.zzfsb = map;
    }

    public final void release() {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r8 = this;
        r0 = r8.zzfvi;
        r1 = zzfvh;
        r0 = r0.toArray(r1);
        r0 = (com.google.android.gms.common.api.internal.BasePendingResult[]) r0;
        r1 = r0.length;
        r2 = 0;
        r3 = r2;
    L_0x000d:
        if (r3 >= r1) goto L_0x0075;
    L_0x000f:
        r4 = r0[r3];
        r5 = 0;
        r4.zza(r5);
        r6 = r4.zzagv();
        if (r6 != 0) goto L_0x0027;
    L_0x001b:
        r5 = r4.zzahh();
        if (r5 == 0) goto L_0x0072;
    L_0x0021:
        r5 = r8.zzfvi;
        r5.remove(r4);
        goto L_0x0072;
    L_0x0027:
        r4.setResultCallback(r5);
        r6 = r8.zzfsb;
        r7 = r4;
        r7 = (com.google.android.gms.common.api.internal.zzm) r7;
        r7 = r7.zzagf();
        r6 = r6.get(r7);
        r6 = (com.google.android.gms.common.api.Api.zze) r6;
        r6 = r6.zzagh();
        r7 = r4.isReady();
        if (r7 == 0) goto L_0x004c;
    L_0x0043:
        r7 = new com.google.android.gms.common.api.internal.zzdl;
        r7.<init>(r4, r5, r6, r5);
        r4.zza(r7);
        goto L_0x0021;
    L_0x004c:
        if (r6 == 0) goto L_0x0060;
    L_0x004e:
        r7 = r6.isBinderAlive();
        if (r7 == 0) goto L_0x0060;
    L_0x0054:
        r7 = new com.google.android.gms.common.api.internal.zzdl;
        r7.<init>(r4, r5, r6, r5);
        r4.zza(r7);
        r6.linkToDeath(r7, r2);	 Catch:{ RemoteException -> 0x0063 }
        goto L_0x0021;
    L_0x0060:
        r4.zza(r5);
    L_0x0063:
        r4.cancel();
        r6 = r4.zzagv();
        r6 = r6.intValue();
        r5.remove(r6);
        goto L_0x0021;
    L_0x0072:
        r3 = r3 + 1;
        goto L_0x000d;
    L_0x0075:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.internal.zzdj.release():void");
    }

    public final void zzaju() {
        for (BasePendingResult zzv : (BasePendingResult[]) this.zzfvi.toArray(zzfvh)) {
            zzv.zzv(zzfvg);
        }
    }

    final void zzb(BasePendingResult<? extends Result> basePendingResult) {
        this.zzfvi.add(basePendingResult);
        basePendingResult.zza(this.zzfvj);
    }
}
