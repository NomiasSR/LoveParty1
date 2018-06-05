package com.google.android.gms.internal;

import java.io.IOException;
import java.util.Arrays;

public final class zzfkq extends zzfjm<zzfkq> implements Cloneable {
    private String tag;
    private int zzala;
    private boolean zzmsn;
    private zzfks zzofi;
    public long zzpql;
    public long zzpqm;
    private long zzpqn;
    private int zzpqo;
    private zzfkr[] zzpqp;
    private byte[] zzpqq;
    private zzfko zzpqr;
    public byte[] zzpqs;
    private String zzpqt;
    private String zzpqu;
    private zzfkn zzpqv;
    private String zzpqw;
    public long zzpqx;
    private zzfkp zzpqy;
    public byte[] zzpqz;
    private String zzpra;
    private int zzprb;
    private int[] zzprc;
    private long zzprd;

    public zzfkq() {
        this.zzpql = 0;
        this.zzpqm = 0;
        this.zzpqn = 0;
        this.tag = "";
        this.zzpqo = 0;
        this.zzala = 0;
        this.zzmsn = false;
        this.zzpqp = zzfkr.zzdba();
        this.zzpqq = zzfjv.zzpnv;
        this.zzpqr = null;
        this.zzpqs = zzfjv.zzpnv;
        this.zzpqt = "";
        this.zzpqu = "";
        this.zzpqv = null;
        this.zzpqw = "";
        this.zzpqx = 180000;
        this.zzpqy = null;
        this.zzpqz = zzfjv.zzpnv;
        this.zzpra = "";
        this.zzprb = 0;
        this.zzprc = zzfjv.zzpnp;
        this.zzprd = 0;
        this.zzofi = null;
        this.zzpnc = null;
        this.zzpfd = -1;
    }

    private final com.google.android.gms.internal.zzfkq zzar(com.google.android.gms.internal.zzfjj r7) throws java.io.IOException {
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
        r1 = 0;
        switch(r0) {
            case 0: goto L_0x01af;
            case 8: goto L_0x01a7;
            case 18: goto L_0x019f;
            case 26: goto L_0x015f;
            case 34: goto L_0x0157;
            case 50: goto L_0x014f;
            case 58: goto L_0x013d;
            case 66: goto L_0x0135;
            case 74: goto L_0x0127;
            case 80: goto L_0x011f;
            case 88: goto L_0x0117;
            case 96: goto L_0x010f;
            case 106: goto L_0x0107;
            case 114: goto L_0x00ff;
            case 120: goto L_0x00f7;
            case 130: goto L_0x00e9;
            case 136: goto L_0x00e1;
            case 146: goto L_0x00d9;
            case 152: goto L_0x00a8;
            case 160: goto L_0x0074;
            case 162: goto L_0x0033;
            case 168: goto L_0x002c;
            case 176: goto L_0x0025;
            case 186: goto L_0x0016;
            case 194: goto L_0x000f;
            default: goto L_0x0008;
        };
    L_0x0008:
        r0 = super.zza(r7, r0);
        if (r0 != 0) goto L_0x0000;
    L_0x000e:
        return r6;
    L_0x000f:
        r0 = r7.readString();
        r6.zzpra = r0;
        goto L_0x0000;
    L_0x0016:
        r0 = r6.zzofi;
        if (r0 != 0) goto L_0x0021;
    L_0x001a:
        r0 = new com.google.android.gms.internal.zzfks;
        r0.<init>();
        r6.zzofi = r0;
    L_0x0021:
        r0 = r6.zzofi;
        goto L_0x014a;
    L_0x0025:
        r0 = r7.zzcvv();
        r6.zzprd = r0;
        goto L_0x0000;
    L_0x002c:
        r0 = r7.zzcvv();
        r6.zzpqn = r0;
        goto L_0x0000;
    L_0x0033:
        r0 = r7.zzcwi();
        r0 = r7.zzks(r0);
        r2 = r7.getPosition();
        r3 = r1;
    L_0x0040:
        r4 = r7.zzcwk();
        if (r4 <= 0) goto L_0x004c;
    L_0x0046:
        r7.zzcvw();
        r3 = r3 + 1;
        goto L_0x0040;
    L_0x004c:
        r7.zzmg(r2);
        r2 = r6.zzprc;
        if (r2 != 0) goto L_0x0055;
    L_0x0053:
        r2 = r1;
        goto L_0x0058;
    L_0x0055:
        r2 = r6.zzprc;
        r2 = r2.length;
    L_0x0058:
        r3 = r3 + r2;
        r3 = new int[r3];
        if (r2 == 0) goto L_0x0062;
    L_0x005d:
        r4 = r6.zzprc;
        java.lang.System.arraycopy(r4, r1, r3, r1, r2);
    L_0x0062:
        r1 = r3.length;
        if (r2 >= r1) goto L_0x006e;
    L_0x0065:
        r1 = r7.zzcvw();
        r3[r2] = r1;
        r2 = r2 + 1;
        goto L_0x0062;
    L_0x006e:
        r6.zzprc = r3;
        r7.zzkt(r0);
        goto L_0x0000;
    L_0x0074:
        r0 = 160; // 0xa0 float:2.24E-43 double:7.9E-322;
        r0 = com.google.android.gms.internal.zzfjv.zzb(r7, r0);
        r2 = r6.zzprc;
        if (r2 != 0) goto L_0x0080;
    L_0x007e:
        r2 = r1;
        goto L_0x0083;
    L_0x0080:
        r2 = r6.zzprc;
        r2 = r2.length;
    L_0x0083:
        r0 = r0 + r2;
        r0 = new int[r0];
        if (r2 == 0) goto L_0x008d;
    L_0x0088:
        r3 = r6.zzprc;
        java.lang.System.arraycopy(r3, r1, r0, r1, r2);
    L_0x008d:
        r1 = r0.length;
        r1 = r1 + -1;
        if (r2 >= r1) goto L_0x009e;
    L_0x0092:
        r1 = r7.zzcvw();
        r0[r2] = r1;
        r7.zzcvt();
        r2 = r2 + 1;
        goto L_0x008d;
    L_0x009e:
        r1 = r7.zzcvw();
        r0[r2] = r1;
        r6.zzprc = r0;
        goto L_0x0000;
    L_0x00a8:
        r1 = r7.getPosition();
        r2 = r7.zzcvw();	 Catch:{ IllegalArgumentException -> 0x00d1 }
        switch(r2) {
            case 0: goto L_0x00b6;
            case 1: goto L_0x00b6;
            case 2: goto L_0x00b6;
            default: goto L_0x00b3;
        };	 Catch:{ IllegalArgumentException -> 0x00d1 }
    L_0x00b3:
        r3 = new java.lang.IllegalArgumentException;	 Catch:{ IllegalArgumentException -> 0x00d1 }
        goto L_0x00ba;	 Catch:{ IllegalArgumentException -> 0x00d1 }
    L_0x00b6:
        r6.zzprb = r2;	 Catch:{ IllegalArgumentException -> 0x00d1 }
        goto L_0x0000;	 Catch:{ IllegalArgumentException -> 0x00d1 }
    L_0x00ba:
        r4 = 45;	 Catch:{ IllegalArgumentException -> 0x00d1 }
        r5 = new java.lang.StringBuilder;	 Catch:{ IllegalArgumentException -> 0x00d1 }
        r5.<init>(r4);	 Catch:{ IllegalArgumentException -> 0x00d1 }
        r5.append(r2);	 Catch:{ IllegalArgumentException -> 0x00d1 }
        r2 = " is not a valid enum InternalEvent";	 Catch:{ IllegalArgumentException -> 0x00d1 }
        r5.append(r2);	 Catch:{ IllegalArgumentException -> 0x00d1 }
        r2 = r5.toString();	 Catch:{ IllegalArgumentException -> 0x00d1 }
        r3.<init>(r2);	 Catch:{ IllegalArgumentException -> 0x00d1 }
        throw r3;	 Catch:{ IllegalArgumentException -> 0x00d1 }
    L_0x00d1:
        r7.zzmg(r1);
        r6.zza(r7, r0);
        goto L_0x0000;
    L_0x00d9:
        r0 = r7.readBytes();
        r6.zzpqz = r0;
        goto L_0x0000;
    L_0x00e1:
        r0 = r7.zzcvv();
        r6.zzpqm = r0;
        goto L_0x0000;
    L_0x00e9:
        r0 = r6.zzpqy;
        if (r0 != 0) goto L_0x00f4;
    L_0x00ed:
        r0 = new com.google.android.gms.internal.zzfkp;
        r0.<init>();
        r6.zzpqy = r0;
    L_0x00f4:
        r0 = r6.zzpqy;
        goto L_0x014a;
    L_0x00f7:
        r0 = r7.zzcwh();
        r6.zzpqx = r0;
        goto L_0x0000;
    L_0x00ff:
        r0 = r7.readString();
        r6.zzpqw = r0;
        goto L_0x0000;
    L_0x0107:
        r0 = r7.readString();
        r6.zzpqu = r0;
        goto L_0x0000;
    L_0x010f:
        r0 = r7.zzcvw();
        r6.zzala = r0;
        goto L_0x0000;
    L_0x0117:
        r0 = r7.zzcvw();
        r6.zzpqo = r0;
        goto L_0x0000;
    L_0x011f:
        r0 = r7.zzcvz();
        r6.zzmsn = r0;
        goto L_0x0000;
    L_0x0127:
        r0 = r6.zzpqr;
        if (r0 != 0) goto L_0x0132;
    L_0x012b:
        r0 = new com.google.android.gms.internal.zzfko;
        r0.<init>();
        r6.zzpqr = r0;
    L_0x0132:
        r0 = r6.zzpqr;
        goto L_0x014a;
    L_0x0135:
        r0 = r7.readString();
        r6.zzpqt = r0;
        goto L_0x0000;
    L_0x013d:
        r0 = r6.zzpqv;
        if (r0 != 0) goto L_0x0148;
    L_0x0141:
        r0 = new com.google.android.gms.internal.zzfkn;
        r0.<init>();
        r6.zzpqv = r0;
    L_0x0148:
        r0 = r6.zzpqv;
    L_0x014a:
        r7.zza(r0);
        goto L_0x0000;
    L_0x014f:
        r0 = r7.readBytes();
        r6.zzpqs = r0;
        goto L_0x0000;
    L_0x0157:
        r0 = r7.readBytes();
        r6.zzpqq = r0;
        goto L_0x0000;
    L_0x015f:
        r0 = 26;
        r0 = com.google.android.gms.internal.zzfjv.zzb(r7, r0);
        r2 = r6.zzpqp;
        if (r2 != 0) goto L_0x016b;
    L_0x0169:
        r2 = r1;
        goto L_0x016e;
    L_0x016b:
        r2 = r6.zzpqp;
        r2 = r2.length;
    L_0x016e:
        r0 = r0 + r2;
        r0 = new com.google.android.gms.internal.zzfkr[r0];
        if (r2 == 0) goto L_0x0178;
    L_0x0173:
        r3 = r6.zzpqp;
        java.lang.System.arraycopy(r3, r1, r0, r1, r2);
    L_0x0178:
        r1 = r0.length;
        r1 = r1 + -1;
        if (r2 >= r1) goto L_0x018f;
    L_0x017d:
        r1 = new com.google.android.gms.internal.zzfkr;
        r1.<init>();
        r0[r2] = r1;
        r1 = r0[r2];
        r7.zza(r1);
        r7.zzcvt();
        r2 = r2 + 1;
        goto L_0x0178;
    L_0x018f:
        r1 = new com.google.android.gms.internal.zzfkr;
        r1.<init>();
        r0[r2] = r1;
        r1 = r0[r2];
        r7.zza(r1);
        r6.zzpqp = r0;
        goto L_0x0000;
    L_0x019f:
        r0 = r7.readString();
        r6.tag = r0;
        goto L_0x0000;
    L_0x01a7:
        r0 = r7.zzcvv();
        r6.zzpql = r0;
        goto L_0x0000;
    L_0x01af:
        return r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzfkq.zzar(com.google.android.gms.internal.zzfjj):com.google.android.gms.internal.zzfkq");
    }

    private final zzfkq zzdaz() {
        try {
            zzfkq com_google_android_gms_internal_zzfkq = (zzfkq) super.zzdaf();
            if (this.zzpqp != null && this.zzpqp.length > 0) {
                com_google_android_gms_internal_zzfkq.zzpqp = new zzfkr[this.zzpqp.length];
                for (int i = 0; i < this.zzpqp.length; i++) {
                    if (this.zzpqp[i] != null) {
                        com_google_android_gms_internal_zzfkq.zzpqp[i] = (zzfkr) this.zzpqp[i].clone();
                    }
                }
            }
            if (this.zzpqr != null) {
                com_google_android_gms_internal_zzfkq.zzpqr = (zzfko) this.zzpqr.clone();
            }
            if (this.zzpqv != null) {
                com_google_android_gms_internal_zzfkq.zzpqv = (zzfkn) this.zzpqv.clone();
            }
            if (this.zzpqy != null) {
                com_google_android_gms_internal_zzfkq.zzpqy = (zzfkp) this.zzpqy.clone();
            }
            if (this.zzprc != null && this.zzprc.length > 0) {
                com_google_android_gms_internal_zzfkq.zzprc = (int[]) this.zzprc.clone();
            }
            if (this.zzofi != null) {
                com_google_android_gms_internal_zzfkq.zzofi = (zzfks) this.zzofi.clone();
            }
            return com_google_android_gms_internal_zzfkq;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        return zzdaz();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzfkq)) {
            return false;
        }
        zzfkq com_google_android_gms_internal_zzfkq = (zzfkq) obj;
        if (this.zzpql != com_google_android_gms_internal_zzfkq.zzpql || this.zzpqm != com_google_android_gms_internal_zzfkq.zzpqm || this.zzpqn != com_google_android_gms_internal_zzfkq.zzpqn) {
            return false;
        }
        if (this.tag == null) {
            if (com_google_android_gms_internal_zzfkq.tag != null) {
                return false;
            }
        } else if (!this.tag.equals(com_google_android_gms_internal_zzfkq.tag)) {
            return false;
        }
        if (this.zzpqo != com_google_android_gms_internal_zzfkq.zzpqo || this.zzala != com_google_android_gms_internal_zzfkq.zzala || this.zzmsn != com_google_android_gms_internal_zzfkq.zzmsn || !zzfjq.equals(this.zzpqp, com_google_android_gms_internal_zzfkq.zzpqp) || !Arrays.equals(this.zzpqq, com_google_android_gms_internal_zzfkq.zzpqq)) {
            return false;
        }
        if (this.zzpqr == null) {
            if (com_google_android_gms_internal_zzfkq.zzpqr != null) {
                return false;
            }
        } else if (!this.zzpqr.equals(com_google_android_gms_internal_zzfkq.zzpqr)) {
            return false;
        }
        if (!Arrays.equals(this.zzpqs, com_google_android_gms_internal_zzfkq.zzpqs)) {
            return false;
        }
        if (this.zzpqt == null) {
            if (com_google_android_gms_internal_zzfkq.zzpqt != null) {
                return false;
            }
        } else if (!this.zzpqt.equals(com_google_android_gms_internal_zzfkq.zzpqt)) {
            return false;
        }
        if (this.zzpqu == null) {
            if (com_google_android_gms_internal_zzfkq.zzpqu != null) {
                return false;
            }
        } else if (!this.zzpqu.equals(com_google_android_gms_internal_zzfkq.zzpqu)) {
            return false;
        }
        if (this.zzpqv == null) {
            if (com_google_android_gms_internal_zzfkq.zzpqv != null) {
                return false;
            }
        } else if (!this.zzpqv.equals(com_google_android_gms_internal_zzfkq.zzpqv)) {
            return false;
        }
        if (this.zzpqw == null) {
            if (com_google_android_gms_internal_zzfkq.zzpqw != null) {
                return false;
            }
        } else if (!this.zzpqw.equals(com_google_android_gms_internal_zzfkq.zzpqw)) {
            return false;
        }
        if (this.zzpqx != com_google_android_gms_internal_zzfkq.zzpqx) {
            return false;
        }
        if (this.zzpqy == null) {
            if (com_google_android_gms_internal_zzfkq.zzpqy != null) {
                return false;
            }
        } else if (!this.zzpqy.equals(com_google_android_gms_internal_zzfkq.zzpqy)) {
            return false;
        }
        if (!Arrays.equals(this.zzpqz, com_google_android_gms_internal_zzfkq.zzpqz)) {
            return false;
        }
        if (this.zzpra == null) {
            if (com_google_android_gms_internal_zzfkq.zzpra != null) {
                return false;
            }
        } else if (!this.zzpra.equals(com_google_android_gms_internal_zzfkq.zzpra)) {
            return false;
        }
        if (this.zzprb != com_google_android_gms_internal_zzfkq.zzprb || !zzfjq.equals(this.zzprc, com_google_android_gms_internal_zzfkq.zzprc) || this.zzprd != com_google_android_gms_internal_zzfkq.zzprd) {
            return false;
        }
        if (this.zzofi == null) {
            if (com_google_android_gms_internal_zzfkq.zzofi != null) {
                return false;
            }
        } else if (!this.zzofi.equals(com_google_android_gms_internal_zzfkq.zzofi)) {
            return false;
        }
        if (this.zzpnc != null) {
            if (!this.zzpnc.isEmpty()) {
                return this.zzpnc.equals(com_google_android_gms_internal_zzfkq.zzpnc);
            }
        }
        return com_google_android_gms_internal_zzfkq.zzpnc == null || com_google_android_gms_internal_zzfkq.zzpnc.isEmpty();
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = ((((((((((((((((((527 + getClass().getName().hashCode()) * 31) + ((int) (this.zzpql ^ (this.zzpql >>> 32)))) * 31) + ((int) (this.zzpqm ^ (this.zzpqm >>> 32)))) * 31) + ((int) (this.zzpqn ^ (this.zzpqn >>> 32)))) * 31) + (this.tag == null ? 0 : this.tag.hashCode())) * 31) + this.zzpqo) * 31) + this.zzala) * 31) + (this.zzmsn ? 1231 : 1237)) * 31) + zzfjq.hashCode(this.zzpqp)) * 31) + Arrays.hashCode(this.zzpqq);
        zzfko com_google_android_gms_internal_zzfko = this.zzpqr;
        hashCode = (((((((hashCode * 31) + (com_google_android_gms_internal_zzfko == null ? 0 : com_google_android_gms_internal_zzfko.hashCode())) * 31) + Arrays.hashCode(this.zzpqs)) * 31) + (this.zzpqt == null ? 0 : this.zzpqt.hashCode())) * 31) + (this.zzpqu == null ? 0 : this.zzpqu.hashCode());
        zzfkn com_google_android_gms_internal_zzfkn = this.zzpqv;
        hashCode = (((((hashCode * 31) + (com_google_android_gms_internal_zzfkn == null ? 0 : com_google_android_gms_internal_zzfkn.hashCode())) * 31) + (this.zzpqw == null ? 0 : this.zzpqw.hashCode())) * 31) + ((int) (this.zzpqx ^ (this.zzpqx >>> 32)));
        zzfkp com_google_android_gms_internal_zzfkp = this.zzpqy;
        hashCode = (((((((((((hashCode * 31) + (com_google_android_gms_internal_zzfkp == null ? 0 : com_google_android_gms_internal_zzfkp.hashCode())) * 31) + Arrays.hashCode(this.zzpqz)) * 31) + (this.zzpra == null ? 0 : this.zzpra.hashCode())) * 31) + this.zzprb) * 31) + zzfjq.hashCode(this.zzprc)) * 31) + ((int) (this.zzprd ^ (this.zzprd >>> 32)));
        zzfks com_google_android_gms_internal_zzfks = this.zzofi;
        hashCode = ((hashCode * 31) + (com_google_android_gms_internal_zzfks == null ? 0 : com_google_android_gms_internal_zzfks.hashCode())) * 31;
        if (this.zzpnc != null) {
            if (!this.zzpnc.isEmpty()) {
                i = this.zzpnc.hashCode();
            }
        }
        return hashCode + i;
    }

    public final /* synthetic */ zzfjs zza(zzfjj com_google_android_gms_internal_zzfjj) throws IOException {
        return zzar(com_google_android_gms_internal_zzfjj);
    }

    public final void zza(zzfjk com_google_android_gms_internal_zzfjk) throws IOException {
        if (this.zzpql != 0) {
            com_google_android_gms_internal_zzfjk.zzf(1, this.zzpql);
        }
        if (!(this.tag == null || this.tag.equals(""))) {
            com_google_android_gms_internal_zzfjk.zzn(2, this.tag);
        }
        int i = 0;
        if (this.zzpqp != null && this.zzpqp.length > 0) {
            for (zzfjs com_google_android_gms_internal_zzfjs : this.zzpqp) {
                if (com_google_android_gms_internal_zzfjs != null) {
                    com_google_android_gms_internal_zzfjk.zza(3, com_google_android_gms_internal_zzfjs);
                }
            }
        }
        if (!Arrays.equals(this.zzpqq, zzfjv.zzpnv)) {
            com_google_android_gms_internal_zzfjk.zzc(4, this.zzpqq);
        }
        if (!Arrays.equals(this.zzpqs, zzfjv.zzpnv)) {
            com_google_android_gms_internal_zzfjk.zzc(6, this.zzpqs);
        }
        if (this.zzpqv != null) {
            com_google_android_gms_internal_zzfjk.zza(7, this.zzpqv);
        }
        if (!(this.zzpqt == null || this.zzpqt.equals(""))) {
            com_google_android_gms_internal_zzfjk.zzn(8, this.zzpqt);
        }
        if (this.zzpqr != null) {
            com_google_android_gms_internal_zzfjk.zza(9, this.zzpqr);
        }
        if (this.zzmsn) {
            com_google_android_gms_internal_zzfjk.zzl(10, this.zzmsn);
        }
        if (this.zzpqo != 0) {
            com_google_android_gms_internal_zzfjk.zzaa(11, this.zzpqo);
        }
        if (this.zzala != 0) {
            com_google_android_gms_internal_zzfjk.zzaa(12, this.zzala);
        }
        if (!(this.zzpqu == null || this.zzpqu.equals(""))) {
            com_google_android_gms_internal_zzfjk.zzn(13, this.zzpqu);
        }
        if (!(this.zzpqw == null || this.zzpqw.equals(""))) {
            com_google_android_gms_internal_zzfjk.zzn(14, this.zzpqw);
        }
        if (this.zzpqx != 180000) {
            com_google_android_gms_internal_zzfjk.zzg(15, this.zzpqx);
        }
        if (this.zzpqy != null) {
            com_google_android_gms_internal_zzfjk.zza(16, this.zzpqy);
        }
        if (this.zzpqm != 0) {
            com_google_android_gms_internal_zzfjk.zzf(17, this.zzpqm);
        }
        if (!Arrays.equals(this.zzpqz, zzfjv.zzpnv)) {
            com_google_android_gms_internal_zzfjk.zzc(18, this.zzpqz);
        }
        if (this.zzprb != 0) {
            com_google_android_gms_internal_zzfjk.zzaa(19, this.zzprb);
        }
        if (this.zzprc != null && this.zzprc.length > 0) {
            while (i < this.zzprc.length) {
                com_google_android_gms_internal_zzfjk.zzaa(20, this.zzprc[i]);
                i++;
            }
        }
        if (this.zzpqn != 0) {
            com_google_android_gms_internal_zzfjk.zzf(21, this.zzpqn);
        }
        if (this.zzprd != 0) {
            com_google_android_gms_internal_zzfjk.zzf(22, this.zzprd);
        }
        if (this.zzofi != null) {
            com_google_android_gms_internal_zzfjk.zza(23, this.zzofi);
        }
        if (!(this.zzpra == null || this.zzpra.equals(""))) {
            com_google_android_gms_internal_zzfjk.zzn(24, this.zzpra);
        }
        super.zza(com_google_android_gms_internal_zzfjk);
    }

    public final /* synthetic */ zzfjm zzdaf() throws CloneNotSupportedException {
        return (zzfkq) clone();
    }

    public final /* synthetic */ zzfjs zzdag() throws CloneNotSupportedException {
        return (zzfkq) clone();
    }

    protected final int zzq() {
        int i;
        int zzq = super.zzq();
        if (this.zzpql != 0) {
            zzq += zzfjk.zzc(1, this.zzpql);
        }
        if (!(this.tag == null || this.tag.equals(""))) {
            zzq += zzfjk.zzo(2, this.tag);
        }
        int i2 = 0;
        if (this.zzpqp != null && this.zzpqp.length > 0) {
            i = zzq;
            for (zzfjs com_google_android_gms_internal_zzfjs : this.zzpqp) {
                if (com_google_android_gms_internal_zzfjs != null) {
                    i += zzfjk.zzb(3, com_google_android_gms_internal_zzfjs);
                }
            }
            zzq = i;
        }
        if (!Arrays.equals(this.zzpqq, zzfjv.zzpnv)) {
            zzq += zzfjk.zzd(4, this.zzpqq);
        }
        if (!Arrays.equals(this.zzpqs, zzfjv.zzpnv)) {
            zzq += zzfjk.zzd(6, this.zzpqs);
        }
        if (this.zzpqv != null) {
            zzq += zzfjk.zzb(7, this.zzpqv);
        }
        if (!(this.zzpqt == null || this.zzpqt.equals(""))) {
            zzq += zzfjk.zzo(8, this.zzpqt);
        }
        if (this.zzpqr != null) {
            zzq += zzfjk.zzb(9, this.zzpqr);
        }
        if (this.zzmsn) {
            zzq += zzfjk.zzlg(10) + 1;
        }
        if (this.zzpqo != 0) {
            zzq += zzfjk.zzad(11, this.zzpqo);
        }
        if (this.zzala != 0) {
            zzq += zzfjk.zzad(12, this.zzala);
        }
        if (!(this.zzpqu == null || this.zzpqu.equals(""))) {
            zzq += zzfjk.zzo(13, this.zzpqu);
        }
        if (!(this.zzpqw == null || this.zzpqw.equals(""))) {
            zzq += zzfjk.zzo(14, this.zzpqw);
        }
        if (this.zzpqx != 180000) {
            zzq += zzfjk.zzh(15, this.zzpqx);
        }
        if (this.zzpqy != null) {
            zzq += zzfjk.zzb(16, this.zzpqy);
        }
        if (this.zzpqm != 0) {
            zzq += zzfjk.zzc(17, this.zzpqm);
        }
        if (!Arrays.equals(this.zzpqz, zzfjv.zzpnv)) {
            zzq += zzfjk.zzd(18, this.zzpqz);
        }
        if (this.zzprb != 0) {
            zzq += zzfjk.zzad(19, this.zzprb);
        }
        if (this.zzprc != null && this.zzprc.length > 0) {
            i = 0;
            while (i2 < this.zzprc.length) {
                i += zzfjk.zzlh(this.zzprc[i2]);
                i2++;
            }
            zzq = (zzq + i) + (2 * this.zzprc.length);
        }
        if (this.zzpqn != 0) {
            zzq += zzfjk.zzc(21, this.zzpqn);
        }
        if (this.zzprd != 0) {
            zzq += zzfjk.zzc(22, this.zzprd);
        }
        if (this.zzofi != null) {
            zzq += zzfjk.zzb(23, this.zzofi);
        }
        return (this.zzpra == null || this.zzpra.equals("")) ? zzq : zzq + zzfjk.zzo(24, this.zzpra);
    }
}
