package com.google.android.gms.internal;

final class zzfgq implements zzfhw {
    private static final zzfhd zzpig = new zzfgr();
    private final zzfhd zzpie;
    private final zzfgu zzpif;

    public zzfgq() {
        this(zzfgu.DYNAMIC);
    }

    private zzfgq(zzfgu com_google_android_gms_internal_zzfgu) {
        this(new zzfgt(zzfft.zzcxl(), zzcyo()), com_google_android_gms_internal_zzfgu);
    }

    private zzfgq(zzfhd com_google_android_gms_internal_zzfhd, zzfgu com_google_android_gms_internal_zzfgu) {
        this.zzpie = (zzfhd) zzffz.zzc(com_google_android_gms_internal_zzfhd, "messageInfoFactory");
        this.zzpif = (zzfgu) zzffz.zzc(com_google_android_gms_internal_zzfgu, "mode");
    }

    private static <T> zzfhv<T> zza(Class<T> cls, zzfhc com_google_android_gms_internal_zzfhc) {
        if (zzffu.class.isAssignableFrom(cls)) {
            if (zza(com_google_android_gms_internal_zzfhc)) {
                return zzfhi.zza(cls, com_google_android_gms_internal_zzfhc, zzfgm.zzcyn(), zzfhx.zzczg(), zzffp.zzcxd(), zzfhb.zzcyt());
            }
            return zzfhi.zza(cls, com_google_android_gms_internal_zzfhc, zzfgm.zzcyn(), zzfhx.zzczg(), null, zzfhb.zzcyt());
        } else if (zza(com_google_android_gms_internal_zzfhc)) {
            return zzfhi.zza(cls, com_google_android_gms_internal_zzfhc, zzfgm.zzcym(), zzfhx.zzcze(), zzffp.zzcxe(), zzfhb.zzcys());
        } else {
            return zzfhi.zza(cls, com_google_android_gms_internal_zzfhc, zzfgm.zzcym(), zzfhx.zzczf(), null, zzfhb.zzcys());
        }
    }

    private static boolean zza(zzfhc com_google_android_gms_internal_zzfhc) {
        return com_google_android_gms_internal_zzfhc.zzcyv() == zzfhm.zzpiy;
    }

    private static <T> zzfhv<T> zzb(Class<T> cls, zzfhc com_google_android_gms_internal_zzfhc) {
        if (zzffu.class.isAssignableFrom(cls)) {
            if (zza(com_google_android_gms_internal_zzfhc)) {
                return zzfhi.zzb(cls, com_google_android_gms_internal_zzfhc, zzfgm.zzcyn(), zzfhx.zzczg(), zzffp.zzcxd(), zzfhb.zzcyt());
            }
            return zzfhi.zzb(cls, com_google_android_gms_internal_zzfhc, zzfgm.zzcyn(), zzfhx.zzczg(), null, zzfhb.zzcyt());
        } else if (zza(com_google_android_gms_internal_zzfhc)) {
            return zzfhi.zzb(cls, com_google_android_gms_internal_zzfhc, zzfgm.zzcym(), zzfhx.zzcze(), zzffp.zzcxe(), zzfhb.zzcys());
        } else {
            return zzfhi.zzb(cls, com_google_android_gms_internal_zzfhc, zzfgm.zzcym(), zzfhx.zzczf(), null, zzfhb.zzcys());
        }
    }

    private static com.google.android.gms.internal.zzfhd zzcyo() {
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
        r0 = "com.google.protobuf.DescriptorMessageInfoFactory";	 Catch:{ Exception -> 0x0019 }
        r0 = java.lang.Class.forName(r0);	 Catch:{ Exception -> 0x0019 }
        r1 = "getInstance";	 Catch:{ Exception -> 0x0019 }
        r2 = 0;	 Catch:{ Exception -> 0x0019 }
        r3 = new java.lang.Class[r2];	 Catch:{ Exception -> 0x0019 }
        r0 = r0.getDeclaredMethod(r1, r3);	 Catch:{ Exception -> 0x0019 }
        r1 = 0;	 Catch:{ Exception -> 0x0019 }
        r2 = new java.lang.Object[r2];	 Catch:{ Exception -> 0x0019 }
        r0 = r0.invoke(r1, r2);	 Catch:{ Exception -> 0x0019 }
        r0 = (com.google.android.gms.internal.zzfhd) r0;	 Catch:{ Exception -> 0x0019 }
        return r0;
    L_0x0019:
        r0 = zzpig;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzfgq.zzcyo():com.google.android.gms.internal.zzfhd");
    }

    public final <T> zzfhv<T> zzk(Class<T> cls) {
        zzfhx.zzm(cls);
        zzfhc zzj = this.zzpie.zzj(cls);
        if (zzj.zzcyw()) {
            zzfin zzczg;
            zzffn zzcxd;
            if (zzffu.class.isAssignableFrom(cls)) {
                zzczg = zzfhx.zzczg();
                zzcxd = zzffp.zzcxd();
            } else {
                zzczg = zzfhx.zzcze();
                zzcxd = zzffp.zzcxe();
            }
            return zzfhj.zza(cls, zzczg, zzcxd, zzj.zzcyx());
        }
        switch (zzfgs.zzpih[this.zzpif.ordinal()]) {
            case 1:
                return zza(cls, zzj);
            case 2:
                return zzb(cls, zzj);
            default:
                return zzj.zzcyy() ? zza(cls, zzj) : zzb(cls, zzj);
        }
    }
}
