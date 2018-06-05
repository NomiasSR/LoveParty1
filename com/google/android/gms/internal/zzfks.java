package com.google.android.gms.internal;

import java.io.IOException;

public final class zzfks extends zzfjm<zzfks> implements Cloneable {
    private int zzprf;
    private int zzprg;

    public zzfks() {
        this.zzprf = -1;
        this.zzprg = 0;
        this.zzpnc = null;
        this.zzpfd = -1;
    }

    private final com.google.android.gms.internal.zzfks zzas(com.google.android.gms.internal.zzfjj r7) throws java.io.IOException {
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
        r6 = this;
    L_0x0000:
        r0 = r7.zzcvt();
        if (r0 == 0) goto L_0x006f;
    L_0x0006:
        r1 = 8;
        if (r0 == r1) goto L_0x0040;
    L_0x000a:
        r1 = 16;
        if (r0 == r1) goto L_0x0015;
    L_0x000e:
        r0 = super.zza(r7, r0);
        if (r0 != 0) goto L_0x0000;
    L_0x0014:
        return r6;
    L_0x0015:
        r1 = r7.getPosition();
        r2 = r7.zzcvw();	 Catch:{ IllegalArgumentException -> 0x0068 }
        r3 = 100;	 Catch:{ IllegalArgumentException -> 0x0068 }
        if (r2 == r3) goto L_0x003d;	 Catch:{ IllegalArgumentException -> 0x0068 }
    L_0x0021:
        switch(r2) {
            case 0: goto L_0x003d;
            case 1: goto L_0x003d;
            case 2: goto L_0x003d;
            case 3: goto L_0x003d;
            case 4: goto L_0x003d;
            case 5: goto L_0x003d;
            case 6: goto L_0x003d;
            case 7: goto L_0x003d;
            case 8: goto L_0x003d;
            case 9: goto L_0x003d;
            case 10: goto L_0x003d;
            case 11: goto L_0x003d;
            case 12: goto L_0x003d;
            case 13: goto L_0x003d;
            case 14: goto L_0x003d;
            case 15: goto L_0x003d;
            case 16: goto L_0x003d;
            default: goto L_0x0024;
        };	 Catch:{ IllegalArgumentException -> 0x0068 }
    L_0x0024:
        r3 = new java.lang.IllegalArgumentException;	 Catch:{ IllegalArgumentException -> 0x0068 }
        r4 = 45;	 Catch:{ IllegalArgumentException -> 0x0068 }
        r5 = new java.lang.StringBuilder;	 Catch:{ IllegalArgumentException -> 0x0068 }
        r5.<init>(r4);	 Catch:{ IllegalArgumentException -> 0x0068 }
        r5.append(r2);	 Catch:{ IllegalArgumentException -> 0x0068 }
        r2 = " is not a valid enum MobileSubtype";	 Catch:{ IllegalArgumentException -> 0x0068 }
        r5.append(r2);	 Catch:{ IllegalArgumentException -> 0x0068 }
        r2 = r5.toString();	 Catch:{ IllegalArgumentException -> 0x0068 }
        r3.<init>(r2);	 Catch:{ IllegalArgumentException -> 0x0068 }
        throw r3;	 Catch:{ IllegalArgumentException -> 0x0068 }
    L_0x003d:
        r6.zzprg = r2;	 Catch:{ IllegalArgumentException -> 0x0068 }
        goto L_0x0000;
    L_0x0040:
        r1 = r7.getPosition();
        r2 = r7.zzcvw();	 Catch:{ IllegalArgumentException -> 0x0068 }
        switch(r2) {
            case -1: goto L_0x004e;
            case 0: goto L_0x004e;
            case 1: goto L_0x004e;
            case 2: goto L_0x004e;
            case 3: goto L_0x004e;
            case 4: goto L_0x004e;
            case 5: goto L_0x004e;
            case 6: goto L_0x004e;
            case 7: goto L_0x004e;
            case 8: goto L_0x004e;
            case 9: goto L_0x004e;
            case 10: goto L_0x004e;
            case 11: goto L_0x004e;
            case 12: goto L_0x004e;
            case 13: goto L_0x004e;
            case 14: goto L_0x004e;
            case 15: goto L_0x004e;
            case 16: goto L_0x004e;
            case 17: goto L_0x004e;
            default: goto L_0x004b;
        };	 Catch:{ IllegalArgumentException -> 0x0068 }
    L_0x004b:
        r3 = new java.lang.IllegalArgumentException;	 Catch:{ IllegalArgumentException -> 0x0068 }
        goto L_0x0051;	 Catch:{ IllegalArgumentException -> 0x0068 }
    L_0x004e:
        r6.zzprf = r2;	 Catch:{ IllegalArgumentException -> 0x0068 }
        goto L_0x0000;	 Catch:{ IllegalArgumentException -> 0x0068 }
    L_0x0051:
        r4 = 43;	 Catch:{ IllegalArgumentException -> 0x0068 }
        r5 = new java.lang.StringBuilder;	 Catch:{ IllegalArgumentException -> 0x0068 }
        r5.<init>(r4);	 Catch:{ IllegalArgumentException -> 0x0068 }
        r5.append(r2);	 Catch:{ IllegalArgumentException -> 0x0068 }
        r2 = " is not a valid enum NetworkType";	 Catch:{ IllegalArgumentException -> 0x0068 }
        r5.append(r2);	 Catch:{ IllegalArgumentException -> 0x0068 }
        r2 = r5.toString();	 Catch:{ IllegalArgumentException -> 0x0068 }
        r3.<init>(r2);	 Catch:{ IllegalArgumentException -> 0x0068 }
        throw r3;	 Catch:{ IllegalArgumentException -> 0x0068 }
    L_0x0068:
        r7.zzmg(r1);
        r6.zza(r7, r0);
        goto L_0x0000;
    L_0x006f:
        return r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzfks.zzas(com.google.android.gms.internal.zzfjj):com.google.android.gms.internal.zzfks");
    }

    private zzfks zzdbc() {
        try {
            return (zzfks) super.zzdaf();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        return zzdbc();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzfks)) {
            return false;
        }
        zzfks com_google_android_gms_internal_zzfks = (zzfks) obj;
        if (this.zzprf != com_google_android_gms_internal_zzfks.zzprf || this.zzprg != com_google_android_gms_internal_zzfks.zzprg) {
            return false;
        }
        if (this.zzpnc != null) {
            if (!this.zzpnc.isEmpty()) {
                return this.zzpnc.equals(com_google_android_gms_internal_zzfks.zzpnc);
            }
        }
        return com_google_android_gms_internal_zzfks.zzpnc == null || com_google_android_gms_internal_zzfks.zzpnc.isEmpty();
    }

    public final int hashCode() {
        int hashCode;
        int hashCode2 = (((((527 + getClass().getName().hashCode()) * 31) + this.zzprf) * 31) + this.zzprg) * 31;
        if (this.zzpnc != null) {
            if (!this.zzpnc.isEmpty()) {
                hashCode = this.zzpnc.hashCode();
                return hashCode2 + hashCode;
            }
        }
        hashCode = 0;
        return hashCode2 + hashCode;
    }

    public final /* synthetic */ zzfjs zza(zzfjj com_google_android_gms_internal_zzfjj) throws IOException {
        return zzas(com_google_android_gms_internal_zzfjj);
    }

    public final void zza(zzfjk com_google_android_gms_internal_zzfjk) throws IOException {
        if (this.zzprf != -1) {
            com_google_android_gms_internal_zzfjk.zzaa(1, this.zzprf);
        }
        if (this.zzprg != 0) {
            com_google_android_gms_internal_zzfjk.zzaa(2, this.zzprg);
        }
        super.zza(com_google_android_gms_internal_zzfjk);
    }

    public final /* synthetic */ zzfjm zzdaf() throws CloneNotSupportedException {
        return (zzfks) clone();
    }

    public final /* synthetic */ zzfjs zzdag() throws CloneNotSupportedException {
        return (zzfks) clone();
    }

    protected final int zzq() {
        int zzq = super.zzq();
        if (this.zzprf != -1) {
            zzq += zzfjk.zzad(1, this.zzprf);
        }
        return this.zzprg != 0 ? zzq + zzfjk.zzad(2, this.zzprg) : zzq;
    }
}
