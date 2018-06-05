package com.google.android.gms.internal;

import java.io.IOException;

public final class zzclw extends zzfjm<zzclw> {
    public Integer zzjko;
    public String zzjkp;
    public Boolean zzjkq;
    public String[] zzjkr;

    public zzclw() {
        this.zzjko = null;
        this.zzjkp = null;
        this.zzjkq = null;
        this.zzjkr = zzfjv.EMPTY_STRING_ARRAY;
        this.zzpnc = null;
        this.zzpfd = -1;
    }

    private final com.google.android.gms.internal.zzclw zzi(com.google.android.gms.internal.zzfjj r7) throws java.io.IOException {
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
        r6 = this;
    L_0x0000:
        r0 = r7.zzcvt();
        if (r0 == 0) goto L_0x0095;
    L_0x0006:
        r1 = 8;
        if (r0 == r1) goto L_0x0061;
    L_0x000a:
        r1 = 18;
        if (r0 == r1) goto L_0x005a;
    L_0x000e:
        r1 = 24;
        if (r0 == r1) goto L_0x004f;
    L_0x0012:
        r1 = 34;
        if (r0 == r1) goto L_0x001d;
    L_0x0016:
        r0 = super.zza(r7, r0);
        if (r0 != 0) goto L_0x0000;
    L_0x001c:
        return r6;
    L_0x001d:
        r0 = com.google.android.gms.internal.zzfjv.zzb(r7, r1);
        r1 = r6.zzjkr;
        r2 = 0;
        if (r1 != 0) goto L_0x0028;
    L_0x0026:
        r1 = r2;
        goto L_0x002b;
    L_0x0028:
        r1 = r6.zzjkr;
        r1 = r1.length;
    L_0x002b:
        r0 = r0 + r1;
        r0 = new java.lang.String[r0];
        if (r1 == 0) goto L_0x0035;
    L_0x0030:
        r3 = r6.zzjkr;
        java.lang.System.arraycopy(r3, r2, r0, r2, r1);
    L_0x0035:
        r2 = r0.length;
        r2 = r2 + -1;
        if (r1 >= r2) goto L_0x0046;
    L_0x003a:
        r2 = r7.readString();
        r0[r1] = r2;
        r7.zzcvt();
        r1 = r1 + 1;
        goto L_0x0035;
    L_0x0046:
        r2 = r7.readString();
        r0[r1] = r2;
        r6.zzjkr = r0;
        goto L_0x0000;
    L_0x004f:
        r0 = r7.zzcvz();
        r0 = java.lang.Boolean.valueOf(r0);
        r6.zzjkq = r0;
        goto L_0x0000;
    L_0x005a:
        r0 = r7.readString();
        r6.zzjkp = r0;
        goto L_0x0000;
    L_0x0061:
        r1 = r7.getPosition();
        r2 = r7.zzcwi();	 Catch:{ IllegalArgumentException -> 0x008d }
        switch(r2) {
            case 0: goto L_0x006f;
            case 1: goto L_0x006f;
            case 2: goto L_0x006f;
            case 3: goto L_0x006f;
            case 4: goto L_0x006f;
            case 5: goto L_0x006f;
            case 6: goto L_0x006f;
            default: goto L_0x006c;
        };	 Catch:{ IllegalArgumentException -> 0x008d }
    L_0x006c:
        r3 = new java.lang.IllegalArgumentException;	 Catch:{ IllegalArgumentException -> 0x008d }
        goto L_0x0076;	 Catch:{ IllegalArgumentException -> 0x008d }
    L_0x006f:
        r2 = java.lang.Integer.valueOf(r2);	 Catch:{ IllegalArgumentException -> 0x008d }
        r6.zzjko = r2;	 Catch:{ IllegalArgumentException -> 0x008d }
        goto L_0x0000;	 Catch:{ IllegalArgumentException -> 0x008d }
    L_0x0076:
        r4 = 41;	 Catch:{ IllegalArgumentException -> 0x008d }
        r5 = new java.lang.StringBuilder;	 Catch:{ IllegalArgumentException -> 0x008d }
        r5.<init>(r4);	 Catch:{ IllegalArgumentException -> 0x008d }
        r5.append(r2);	 Catch:{ IllegalArgumentException -> 0x008d }
        r2 = " is not a valid enum MatchType";	 Catch:{ IllegalArgumentException -> 0x008d }
        r5.append(r2);	 Catch:{ IllegalArgumentException -> 0x008d }
        r2 = r5.toString();	 Catch:{ IllegalArgumentException -> 0x008d }
        r3.<init>(r2);	 Catch:{ IllegalArgumentException -> 0x008d }
        throw r3;	 Catch:{ IllegalArgumentException -> 0x008d }
    L_0x008d:
        r7.zzmg(r1);
        r6.zza(r7, r0);
        goto L_0x0000;
    L_0x0095:
        return r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzclw.zzi(com.google.android.gms.internal.zzfjj):com.google.android.gms.internal.zzclw");
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzclw)) {
            return false;
        }
        zzclw com_google_android_gms_internal_zzclw = (zzclw) obj;
        if (this.zzjko == null) {
            if (com_google_android_gms_internal_zzclw.zzjko != null) {
                return false;
            }
        } else if (!this.zzjko.equals(com_google_android_gms_internal_zzclw.zzjko)) {
            return false;
        }
        if (this.zzjkp == null) {
            if (com_google_android_gms_internal_zzclw.zzjkp != null) {
                return false;
            }
        } else if (!this.zzjkp.equals(com_google_android_gms_internal_zzclw.zzjkp)) {
            return false;
        }
        if (this.zzjkq == null) {
            if (com_google_android_gms_internal_zzclw.zzjkq != null) {
                return false;
            }
        } else if (!this.zzjkq.equals(com_google_android_gms_internal_zzclw.zzjkq)) {
            return false;
        }
        if (!zzfjq.equals(this.zzjkr, com_google_android_gms_internal_zzclw.zzjkr)) {
            return false;
        }
        if (this.zzpnc != null) {
            if (!this.zzpnc.isEmpty()) {
                return this.zzpnc.equals(com_google_android_gms_internal_zzclw.zzpnc);
            }
        }
        return com_google_android_gms_internal_zzclw.zzpnc == null || com_google_android_gms_internal_zzclw.zzpnc.isEmpty();
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = (((((((((527 + getClass().getName().hashCode()) * 31) + (this.zzjko == null ? 0 : this.zzjko.intValue())) * 31) + (this.zzjkp == null ? 0 : this.zzjkp.hashCode())) * 31) + (this.zzjkq == null ? 0 : this.zzjkq.hashCode())) * 31) + zzfjq.hashCode(this.zzjkr)) * 31;
        if (this.zzpnc != null) {
            if (!this.zzpnc.isEmpty()) {
                i = this.zzpnc.hashCode();
            }
        }
        return hashCode + i;
    }

    public final /* synthetic */ zzfjs zza(zzfjj com_google_android_gms_internal_zzfjj) throws IOException {
        return zzi(com_google_android_gms_internal_zzfjj);
    }

    public final void zza(zzfjk com_google_android_gms_internal_zzfjk) throws IOException {
        if (this.zzjko != null) {
            com_google_android_gms_internal_zzfjk.zzaa(1, this.zzjko.intValue());
        }
        if (this.zzjkp != null) {
            com_google_android_gms_internal_zzfjk.zzn(2, this.zzjkp);
        }
        if (this.zzjkq != null) {
            com_google_android_gms_internal_zzfjk.zzl(3, this.zzjkq.booleanValue());
        }
        if (this.zzjkr != null && this.zzjkr.length > 0) {
            for (String str : this.zzjkr) {
                if (str != null) {
                    com_google_android_gms_internal_zzfjk.zzn(4, str);
                }
            }
        }
        super.zza(com_google_android_gms_internal_zzfjk);
    }

    protected final int zzq() {
        int zzq = super.zzq();
        if (this.zzjko != null) {
            zzq += zzfjk.zzad(1, this.zzjko.intValue());
        }
        if (this.zzjkp != null) {
            zzq += zzfjk.zzo(2, this.zzjkp);
        }
        if (this.zzjkq != null) {
            this.zzjkq.booleanValue();
            zzq += zzfjk.zzlg(3) + 1;
        }
        if (this.zzjkr == null || this.zzjkr.length <= 0) {
            return zzq;
        }
        int i = 0;
        int i2 = 0;
        int i3 = i2;
        while (i < this.zzjkr.length) {
            String str = this.zzjkr[i];
            if (str != null) {
                i3++;
                i2 += zzfjk.zztt(str);
            }
            i++;
        }
        return (zzq + i2) + (1 * i3);
    }
}
