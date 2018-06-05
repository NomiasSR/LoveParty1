package com.google.android.gms.internal;

import java.io.IOException;

public final class zzclu extends zzfjm<zzclu> {
    public Integer zzjkg;
    public Boolean zzjkh;
    public String zzjki;
    public String zzjkj;
    public String zzjkk;

    public zzclu() {
        this.zzjkg = null;
        this.zzjkh = null;
        this.zzjki = null;
        this.zzjkj = null;
        this.zzjkk = null;
        this.zzpnc = null;
        this.zzpfd = -1;
    }

    private final com.google.android.gms.internal.zzclu zzh(com.google.android.gms.internal.zzfjj r7) throws java.io.IOException {
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
        if (r0 == 0) goto L_0x0074;
    L_0x0006:
        r1 = 8;
        if (r0 == r1) goto L_0x0041;
    L_0x000a:
        r1 = 16;
        if (r0 == r1) goto L_0x0036;
    L_0x000e:
        r1 = 26;
        if (r0 == r1) goto L_0x002f;
    L_0x0012:
        r1 = 34;
        if (r0 == r1) goto L_0x0028;
    L_0x0016:
        r1 = 42;
        if (r0 == r1) goto L_0x0021;
    L_0x001a:
        r0 = super.zza(r7, r0);
        if (r0 != 0) goto L_0x0000;
    L_0x0020:
        return r6;
    L_0x0021:
        r0 = r7.readString();
        r6.zzjkk = r0;
        goto L_0x0000;
    L_0x0028:
        r0 = r7.readString();
        r6.zzjkj = r0;
        goto L_0x0000;
    L_0x002f:
        r0 = r7.readString();
        r6.zzjki = r0;
        goto L_0x0000;
    L_0x0036:
        r0 = r7.zzcvz();
        r0 = java.lang.Boolean.valueOf(r0);
        r6.zzjkh = r0;
        goto L_0x0000;
    L_0x0041:
        r1 = r7.getPosition();
        r2 = r7.zzcwi();	 Catch:{ IllegalArgumentException -> 0x006d }
        switch(r2) {
            case 0: goto L_0x004f;
            case 1: goto L_0x004f;
            case 2: goto L_0x004f;
            case 3: goto L_0x004f;
            case 4: goto L_0x004f;
            default: goto L_0x004c;
        };	 Catch:{ IllegalArgumentException -> 0x006d }
    L_0x004c:
        r3 = new java.lang.IllegalArgumentException;	 Catch:{ IllegalArgumentException -> 0x006d }
        goto L_0x0056;	 Catch:{ IllegalArgumentException -> 0x006d }
    L_0x004f:
        r2 = java.lang.Integer.valueOf(r2);	 Catch:{ IllegalArgumentException -> 0x006d }
        r6.zzjkg = r2;	 Catch:{ IllegalArgumentException -> 0x006d }
        goto L_0x0000;	 Catch:{ IllegalArgumentException -> 0x006d }
    L_0x0056:
        r4 = 46;	 Catch:{ IllegalArgumentException -> 0x006d }
        r5 = new java.lang.StringBuilder;	 Catch:{ IllegalArgumentException -> 0x006d }
        r5.<init>(r4);	 Catch:{ IllegalArgumentException -> 0x006d }
        r5.append(r2);	 Catch:{ IllegalArgumentException -> 0x006d }
        r2 = " is not a valid enum ComparisonType";	 Catch:{ IllegalArgumentException -> 0x006d }
        r5.append(r2);	 Catch:{ IllegalArgumentException -> 0x006d }
        r2 = r5.toString();	 Catch:{ IllegalArgumentException -> 0x006d }
        r3.<init>(r2);	 Catch:{ IllegalArgumentException -> 0x006d }
        throw r3;	 Catch:{ IllegalArgumentException -> 0x006d }
    L_0x006d:
        r7.zzmg(r1);
        r6.zza(r7, r0);
        goto L_0x0000;
    L_0x0074:
        return r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzclu.zzh(com.google.android.gms.internal.zzfjj):com.google.android.gms.internal.zzclu");
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzclu)) {
            return false;
        }
        zzclu com_google_android_gms_internal_zzclu = (zzclu) obj;
        if (this.zzjkg == null) {
            if (com_google_android_gms_internal_zzclu.zzjkg != null) {
                return false;
            }
        } else if (!this.zzjkg.equals(com_google_android_gms_internal_zzclu.zzjkg)) {
            return false;
        }
        if (this.zzjkh == null) {
            if (com_google_android_gms_internal_zzclu.zzjkh != null) {
                return false;
            }
        } else if (!this.zzjkh.equals(com_google_android_gms_internal_zzclu.zzjkh)) {
            return false;
        }
        if (this.zzjki == null) {
            if (com_google_android_gms_internal_zzclu.zzjki != null) {
                return false;
            }
        } else if (!this.zzjki.equals(com_google_android_gms_internal_zzclu.zzjki)) {
            return false;
        }
        if (this.zzjkj == null) {
            if (com_google_android_gms_internal_zzclu.zzjkj != null) {
                return false;
            }
        } else if (!this.zzjkj.equals(com_google_android_gms_internal_zzclu.zzjkj)) {
            return false;
        }
        if (this.zzjkk == null) {
            if (com_google_android_gms_internal_zzclu.zzjkk != null) {
                return false;
            }
        } else if (!this.zzjkk.equals(com_google_android_gms_internal_zzclu.zzjkk)) {
            return false;
        }
        if (this.zzpnc != null) {
            if (!this.zzpnc.isEmpty()) {
                return this.zzpnc.equals(com_google_android_gms_internal_zzclu.zzpnc);
            }
        }
        return com_google_android_gms_internal_zzclu.zzpnc == null || com_google_android_gms_internal_zzclu.zzpnc.isEmpty();
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = (((((((((((527 + getClass().getName().hashCode()) * 31) + (this.zzjkg == null ? 0 : this.zzjkg.intValue())) * 31) + (this.zzjkh == null ? 0 : this.zzjkh.hashCode())) * 31) + (this.zzjki == null ? 0 : this.zzjki.hashCode())) * 31) + (this.zzjkj == null ? 0 : this.zzjkj.hashCode())) * 31) + (this.zzjkk == null ? 0 : this.zzjkk.hashCode())) * 31;
        if (this.zzpnc != null) {
            if (!this.zzpnc.isEmpty()) {
                i = this.zzpnc.hashCode();
            }
        }
        return hashCode + i;
    }

    public final /* synthetic */ zzfjs zza(zzfjj com_google_android_gms_internal_zzfjj) throws IOException {
        return zzh(com_google_android_gms_internal_zzfjj);
    }

    public final void zza(zzfjk com_google_android_gms_internal_zzfjk) throws IOException {
        if (this.zzjkg != null) {
            com_google_android_gms_internal_zzfjk.zzaa(1, this.zzjkg.intValue());
        }
        if (this.zzjkh != null) {
            com_google_android_gms_internal_zzfjk.zzl(2, this.zzjkh.booleanValue());
        }
        if (this.zzjki != null) {
            com_google_android_gms_internal_zzfjk.zzn(3, this.zzjki);
        }
        if (this.zzjkj != null) {
            com_google_android_gms_internal_zzfjk.zzn(4, this.zzjkj);
        }
        if (this.zzjkk != null) {
            com_google_android_gms_internal_zzfjk.zzn(5, this.zzjkk);
        }
        super.zza(com_google_android_gms_internal_zzfjk);
    }

    protected final int zzq() {
        int zzq = super.zzq();
        if (this.zzjkg != null) {
            zzq += zzfjk.zzad(1, this.zzjkg.intValue());
        }
        if (this.zzjkh != null) {
            this.zzjkh.booleanValue();
            zzq += zzfjk.zzlg(2) + 1;
        }
        if (this.zzjki != null) {
            zzq += zzfjk.zzo(3, this.zzjki);
        }
        if (this.zzjkj != null) {
            zzq += zzfjk.zzo(4, this.zzjkj);
        }
        return this.zzjkk != null ? zzq + zzfjk.zzo(5, this.zzjkk) : zzq;
    }
}
