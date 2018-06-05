package com.google.android.gms.internal;

public final class zzdyh {
    @android.support.annotation.Nullable
    public static java.lang.String getProperty(@android.support.annotation.NonNull java.lang.String r7) {
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
        r0 = "android.os.SystemProperties";
        r1 = 0;
        r0 = java.lang.Class.forName(r0);	 Catch:{ Exception -> 0x002e }
        r2 = "get";	 Catch:{ Exception -> 0x002e }
        r3 = 1;	 Catch:{ Exception -> 0x002e }
        r4 = new java.lang.Class[r3];	 Catch:{ Exception -> 0x002e }
        r5 = java.lang.String.class;	 Catch:{ Exception -> 0x002e }
        r6 = 0;	 Catch:{ Exception -> 0x002e }
        r4[r6] = r5;	 Catch:{ Exception -> 0x002e }
        r0 = r0.getDeclaredMethod(r2, r4);	 Catch:{ Exception -> 0x002e }
        r2 = new java.lang.Object[r3];	 Catch:{ Exception -> 0x002e }
        r2[r6] = r7;	 Catch:{ Exception -> 0x002e }
        r7 = r0.invoke(r1, r2);	 Catch:{ Exception -> 0x002e }
        if (r7 == 0) goto L_0x002e;	 Catch:{ Exception -> 0x002e }
    L_0x001f:
        r0 = java.lang.String.class;	 Catch:{ Exception -> 0x002e }
        r2 = r7.getClass();	 Catch:{ Exception -> 0x002e }
        r0 = r0.isAssignableFrom(r2);	 Catch:{ Exception -> 0x002e }
        if (r0 == 0) goto L_0x002e;	 Catch:{ Exception -> 0x002e }
    L_0x002b:
        r7 = (java.lang.String) r7;	 Catch:{ Exception -> 0x002e }
        return r7;
    L_0x002e:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzdyh.getProperty(java.lang.String):java.lang.String");
    }
}
