package com.google.android.gms.internal;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

final class zzfhn {
    private static final zzfhn zzpjb = new zzfhn();
    private final zzfhw zzpjc;
    private final ConcurrentMap<Class<?>, zzfhv<?>> zzpjd = new ConcurrentHashMap();

    private zzfhn() {
        String[] strArr = new String[]{"com.google.protobuf.AndroidProto3SchemaFactory"};
        zzfhw com_google_android_gms_internal_zzfhw = null;
        for (int i = 0; i <= 0; i++) {
            com_google_android_gms_internal_zzfhw = zztw(strArr[0]);
            if (com_google_android_gms_internal_zzfhw != null) {
                break;
            }
        }
        if (com_google_android_gms_internal_zzfhw == null) {
            com_google_android_gms_internal_zzfhw = new zzfgq();
        }
        this.zzpjc = com_google_android_gms_internal_zzfhw;
    }

    public static zzfhn zzcyz() {
        return zzpjb;
    }

    private static com.google.android.gms.internal.zzfhw zztw(java.lang.String r2) {
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
        r2 = java.lang.Class.forName(r2);	 Catch:{ Throwable -> 0x0014 }
        r0 = 0;	 Catch:{ Throwable -> 0x0014 }
        r1 = new java.lang.Class[r0];	 Catch:{ Throwable -> 0x0014 }
        r2 = r2.getConstructor(r1);	 Catch:{ Throwable -> 0x0014 }
        r0 = new java.lang.Object[r0];	 Catch:{ Throwable -> 0x0014 }
        r2 = r2.newInstance(r0);	 Catch:{ Throwable -> 0x0014 }
        r2 = (com.google.android.gms.internal.zzfhw) r2;	 Catch:{ Throwable -> 0x0014 }
        return r2;
    L_0x0014:
        r2 = 0;
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzfhn.zztw(java.lang.String):com.google.android.gms.internal.zzfhw");
    }

    public final <T> zzfhv<T> zzl(Class<T> cls) {
        zzffz.zzc(cls, "messageType");
        zzfhv<T> com_google_android_gms_internal_zzfhv_T = (zzfhv) this.zzpjd.get(cls);
        if (com_google_android_gms_internal_zzfhv_T != null) {
            return com_google_android_gms_internal_zzfhv_T;
        }
        com_google_android_gms_internal_zzfhv_T = this.zzpjc.zzk(cls);
        zzffz.zzc(cls, "messageType");
        zzffz.zzc(com_google_android_gms_internal_zzfhv_T, "schema");
        zzfhv<T> com_google_android_gms_internal_zzfhv_T2 = (zzfhv) this.zzpjd.putIfAbsent(cls, com_google_android_gms_internal_zzfhv_T);
        return com_google_android_gms_internal_zzfhv_T2 != null ? com_google_android_gms_internal_zzfhv_T2 : com_google_android_gms_internal_zzfhv_T;
    }
}
