package com.google.android.gms.internal;

public class zzfgk {
    private static final zzffm zzpfe = zzffm.zzcxb();
    private zzfes zzphy;
    private volatile zzfhe zzphz;
    private volatile zzfes zzpia;

    private com.google.android.gms.internal.zzfhe zzj(com.google.android.gms.internal.zzfhe r2) {
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
        r0 = r1.zzphz;
        if (r0 != 0) goto L_0x001c;
    L_0x0004:
        monitor-enter(r1);
        r0 = r1.zzphz;	 Catch:{ all -> 0x0019 }
        if (r0 == 0) goto L_0x000b;	 Catch:{ all -> 0x0019 }
    L_0x0009:
        monitor-exit(r1);	 Catch:{ all -> 0x0019 }
        goto L_0x001c;
    L_0x000b:
        r1.zzphz = r2;	 Catch:{ zzfge -> 0x0012 }
        r0 = com.google.android.gms.internal.zzfes.zzpfg;	 Catch:{ zzfge -> 0x0012 }
        r1.zzpia = r0;	 Catch:{ zzfge -> 0x0012 }
        goto L_0x0009;
    L_0x0012:
        r1.zzphz = r2;	 Catch:{ all -> 0x0019 }
        r2 = com.google.android.gms.internal.zzfes.zzpfg;	 Catch:{ all -> 0x0019 }
        r1.zzpia = r2;	 Catch:{ all -> 0x0019 }
        goto L_0x0009;	 Catch:{ all -> 0x0019 }
    L_0x0019:
        r2 = move-exception;	 Catch:{ all -> 0x0019 }
        monitor-exit(r1);	 Catch:{ all -> 0x0019 }
        throw r2;
    L_0x001c:
        r2 = r1.zzphz;
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzfgk.zzj(com.google.android.gms.internal.zzfhe):com.google.android.gms.internal.zzfhe");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzfgk)) {
            return false;
        }
        zzfgk com_google_android_gms_internal_zzfgk = (zzfgk) obj;
        zzfhe com_google_android_gms_internal_zzfhe = this.zzphz;
        zzfhe com_google_android_gms_internal_zzfhe2 = com_google_android_gms_internal_zzfgk.zzphz;
        return (com_google_android_gms_internal_zzfhe == null && com_google_android_gms_internal_zzfhe2 == null) ? toByteString().equals(com_google_android_gms_internal_zzfgk.toByteString()) : (com_google_android_gms_internal_zzfhe == null || com_google_android_gms_internal_zzfhe2 == null) ? com_google_android_gms_internal_zzfhe != null ? com_google_android_gms_internal_zzfhe.equals(com_google_android_gms_internal_zzfgk.zzj(com_google_android_gms_internal_zzfhe.zzcxq())) : zzj(com_google_android_gms_internal_zzfhe2.zzcxq()).equals(com_google_android_gms_internal_zzfhe2) : com_google_android_gms_internal_zzfhe.equals(com_google_android_gms_internal_zzfhe2);
    }

    public int hashCode() {
        return 1;
    }

    public final zzfes toByteString() {
        if (this.zzpia != null) {
            return this.zzpia;
        }
        synchronized (this) {
            if (this.zzpia != null) {
                zzfes com_google_android_gms_internal_zzfes = this.zzpia;
                return com_google_android_gms_internal_zzfes;
            }
            this.zzpia = this.zzphz == null ? zzfes.zzpfg : this.zzphz.toByteString();
            com_google_android_gms_internal_zzfes = this.zzpia;
            return com_google_android_gms_internal_zzfes;
        }
    }

    public final int zzho() {
        return this.zzpia != null ? this.zzpia.size() : this.zzphz != null ? this.zzphz.zzho() : 0;
    }

    public final zzfhe zzk(zzfhe com_google_android_gms_internal_zzfhe) {
        zzfhe com_google_android_gms_internal_zzfhe2 = this.zzphz;
        this.zzphy = null;
        this.zzpia = null;
        this.zzphz = com_google_android_gms_internal_zzfhe;
        return com_google_android_gms_internal_zzfhe2;
    }
}
