package com.google.android.gms.common.util;

import android.annotation.TargetApi;
import android.content.Context;
import com.google.android.gms.internal.zzbhf;

public final class zzx {
    @TargetApi(19)
    public static boolean zzb(Context context, int i, String str) {
        return zzbhf.zzdb(context).zzf(i, str);
    }

    public static boolean zzf(android.content.Context r3, int r4) {
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
        r0 = "com.google.android.gms";
        r4 = zzb(r3, r4, r0);
        r0 = 0;
        if (r4 != 0) goto L_0x000a;
    L_0x0009:
        return r0;
    L_0x000a:
        r4 = r3.getPackageManager();
        r1 = "com.google.android.gms";	 Catch:{ NameNotFoundException -> 0x001f }
        r2 = 64;	 Catch:{ NameNotFoundException -> 0x001f }
        r4 = r4.getPackageInfo(r1, r2);	 Catch:{ NameNotFoundException -> 0x001f }
        r3 = com.google.android.gms.common.zzq.zzci(r3);
        r3 = r3.zza(r4);
        return r3;
    L_0x001f:
        r3 = "UidVerifier";
        r4 = 3;
        r3 = android.util.Log.isLoggable(r3, r4);
        if (r3 == 0) goto L_0x002f;
    L_0x0028:
        r3 = "UidVerifier";
        r4 = "Package manager can't find google play services package, defaulting to false";
        android.util.Log.d(r3, r4);
    L_0x002f:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.util.zzx.zzf(android.content.Context, int):boolean");
    }
}
