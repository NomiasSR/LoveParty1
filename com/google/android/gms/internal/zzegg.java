package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.List;

public final class zzegg {
    private static final zzehq<zzegd> zzmxa = new zzegi();
    private zzecy zzmwx = zzecy.zzbvq();
    private List<zzegd> zzmwy = new ArrayList();
    private Long zzmwz = Long.valueOf(-1);

    private static zzecy zza(List<zzegd> list, zzehq<zzegd> com_google_android_gms_internal_zzehq_com_google_android_gms_internal_zzegd, zzedk com_google_android_gms_internal_zzedk) {
        zzecy zzbvq = zzecy.zzbvq();
        for (zzegd com_google_android_gms_internal_zzegd : list) {
            if (com_google_android_gms_internal_zzehq_com_google_android_gms_internal_zzegd.zzbs(com_google_android_gms_internal_zzegd)) {
                zzekd zzf;
                zzedk zzbsy = com_google_android_gms_internal_zzegd.zzbsy();
                if (!com_google_android_gms_internal_zzegd.zzbxb()) {
                    if (com_google_android_gms_internal_zzedk.zzi(zzbsy)) {
                        zzbsy = zzedk.zza(com_google_android_gms_internal_zzedk, zzbsy);
                    } else if (zzbsy.zzi(com_google_android_gms_internal_zzedk)) {
                        zzbsy = zzedk.zza(zzbsy, com_google_android_gms_internal_zzedk);
                        if (zzbsy.isEmpty()) {
                            zzbsy = zzedk.zzbwe();
                        } else {
                            zzf = com_google_android_gms_internal_zzegd.zzbxa().zzf(zzbsy);
                            if (zzf != null) {
                                zzbsy = zzedk.zzbwe();
                            }
                        }
                    }
                    zzbvq = zzbvq.zzb(zzbsy, com_google_android_gms_internal_zzegd.zzbxa());
                } else if (com_google_android_gms_internal_zzedk.zzi(zzbsy)) {
                    zzbsy = zzedk.zza(com_google_android_gms_internal_zzedk, zzbsy);
                    zzf = com_google_android_gms_internal_zzegd.zzbwz();
                } else if (zzbsy.zzi(com_google_android_gms_internal_zzedk)) {
                    zzbvq = zzbvq.zze(zzedk.zzbwe(), com_google_android_gms_internal_zzegd.zzbwz().zzan(zzedk.zza(zzbsy, com_google_android_gms_internal_zzedk)));
                }
                zzbvq = zzbvq.zze(zzbsy, zzf);
            }
        }
        return zzbvq;
    }

    public final zzekc zza(zzedk com_google_android_gms_internal_zzedk, zzekd com_google_android_gms_internal_zzekd, zzekc com_google_android_gms_internal_zzekc, boolean z, zzejv com_google_android_gms_internal_zzejv) {
        zzecy zzg = this.zzmwx.zzg(com_google_android_gms_internal_zzedk);
        zzekd zzf = zzg.zzf(zzedk.zzbwe());
        zzekc com_google_android_gms_internal_zzekc2 = null;
        if (zzf == null) {
            if (com_google_android_gms_internal_zzekd != null) {
                zzf = zzg.zzb(com_google_android_gms_internal_zzekd);
            }
            return com_google_android_gms_internal_zzekc2;
        }
        for (zzekc com_google_android_gms_internal_zzekc3 : r0) {
            if (com_google_android_gms_internal_zzejv.zza(com_google_android_gms_internal_zzekc3, com_google_android_gms_internal_zzekc, z) > 0 && (r1 == null || com_google_android_gms_internal_zzejv.zza(com_google_android_gms_internal_zzekc3, r1, z) < 0)) {
                com_google_android_gms_internal_zzekc2 = com_google_android_gms_internal_zzekc3;
            }
        }
        return com_google_android_gms_internal_zzekc2;
    }

    public final zzekd zza(zzedk com_google_android_gms_internal_zzedk, zzedk com_google_android_gms_internal_zzedk2, zzekd com_google_android_gms_internal_zzekd, zzekd com_google_android_gms_internal_zzekd2) {
        com_google_android_gms_internal_zzedk = com_google_android_gms_internal_zzedk.zzh(com_google_android_gms_internal_zzedk2);
        if (this.zzmwx.zze(com_google_android_gms_internal_zzedk)) {
            return null;
        }
        zzecy zzg = this.zzmwx.zzg(com_google_android_gms_internal_zzedk);
        return zzg.isEmpty() ? com_google_android_gms_internal_zzekd2.zzan(com_google_android_gms_internal_zzedk2) : zzg.zzb(com_google_android_gms_internal_zzekd2.zzan(com_google_android_gms_internal_zzedk2));
    }

    public final zzekd zza(zzedk com_google_android_gms_internal_zzedk, zzejg com_google_android_gms_internal_zzejg, zzehx com_google_android_gms_internal_zzehx) {
        com_google_android_gms_internal_zzedk = com_google_android_gms_internal_zzedk.zza(com_google_android_gms_internal_zzejg);
        zzekd zzf = this.zzmwx.zzf(com_google_android_gms_internal_zzedk);
        return zzf != null ? zzf : com_google_android_gms_internal_zzehx.zzf(com_google_android_gms_internal_zzejg) ? this.zzmwx.zzg(com_google_android_gms_internal_zzedk).zzb(com_google_android_gms_internal_zzehx.zzbsv().zzm(com_google_android_gms_internal_zzejg)) : null;
    }

    public final zzekd zza(zzedk com_google_android_gms_internal_zzedk, zzekd com_google_android_gms_internal_zzekd, List<Long> list, boolean z) {
        if (!list.isEmpty() || z) {
            zzecy zzg = this.zzmwx.zzg(com_google_android_gms_internal_zzedk);
            if (!z && zzg.isEmpty()) {
                return com_google_android_gms_internal_zzekd;
            }
            if (!z && com_google_android_gms_internal_zzekd == null && !zzg.zze(zzedk.zzbwe())) {
                return null;
            }
            zzecy zza = zza(this.zzmwy, new zzegh(this, z, list, com_google_android_gms_internal_zzedk), com_google_android_gms_internal_zzedk);
            if (com_google_android_gms_internal_zzekd == null) {
                com_google_android_gms_internal_zzekd = zzeju.zzcaf();
            }
            return zza.zzb(com_google_android_gms_internal_zzekd);
        }
        zzekd zzf = this.zzmwx.zzf(com_google_android_gms_internal_zzedk);
        if (zzf != null) {
            return zzf;
        }
        zza = this.zzmwx.zzg(com_google_android_gms_internal_zzedk);
        if (zza.isEmpty()) {
            return com_google_android_gms_internal_zzekd;
        }
        if (com_google_android_gms_internal_zzekd == null && !zza.zze(zzedk.zzbwe())) {
            return null;
        }
        if (com_google_android_gms_internal_zzekd == null) {
            com_google_android_gms_internal_zzekd = zzeju.zzcaf();
        }
        return zza.zzb(com_google_android_gms_internal_zzekd);
    }

    public final void zza(zzedk com_google_android_gms_internal_zzedk, zzecy com_google_android_gms_internal_zzecy, Long l) {
        this.zzmwy.add(new zzegd(l.longValue(), com_google_android_gms_internal_zzedk, com_google_android_gms_internal_zzecy));
        this.zzmwx = this.zzmwx.zzb(com_google_android_gms_internal_zzedk, com_google_android_gms_internal_zzecy);
        this.zzmwz = l;
    }

    public final void zza(zzedk com_google_android_gms_internal_zzedk, zzekd com_google_android_gms_internal_zzekd, Long l, boolean z) {
        this.zzmwy.add(new zzegd(l.longValue(), com_google_android_gms_internal_zzedk, com_google_android_gms_internal_zzekd, z));
        if (z) {
            this.zzmwx = this.zzmwx.zze(com_google_android_gms_internal_zzedk, com_google_android_gms_internal_zzekd);
        }
        this.zzmwz = l;
    }

    public final zzegd zzbv(long j) {
        for (zzegd com_google_android_gms_internal_zzegd : this.zzmwy) {
            if (com_google_android_gms_internal_zzegd.zzbwy() == j) {
                return com_google_android_gms_internal_zzegd;
            }
        }
        return null;
    }

    public final boolean zzbw(long r11) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:39:0x00d3 in {5, 6, 7, 16, 22, 23, 25, 28, 29, 31, 35, 37, 38, 43, 47, 48} preds:[]
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:129)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.visit(BlockProcessor.java:38)
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
        r10 = this;
        r0 = r10.zzmwy;
        r0 = r0.iterator();
        r1 = 0;
        r2 = r1;
    L_0x0008:
        r3 = r0.hasNext();
        if (r3 == 0) goto L_0x0020;
    L_0x000e:
        r3 = r0.next();
        r3 = (com.google.android.gms.internal.zzegd) r3;
        r4 = r3.zzbwy();
        r4 = (r4 > r11 ? 1 : (r4 == r11 ? 0 : -1));
        if (r4 != 0) goto L_0x001d;
    L_0x001c:
        goto L_0x0021;
    L_0x001d:
        r2 = r2 + 1;
        goto L_0x0008;
    L_0x0020:
        r3 = 0;
    L_0x0021:
        r11 = r10.zzmwy;
        r11.remove(r3);
        r11 = r3.isVisible();
        r12 = r10.zzmwy;
        r12 = r12.size();
        r0 = 1;
        r12 = r12 - r0;
        r4 = r1;
    L_0x0033:
        if (r11 == 0) goto L_0x009b;
    L_0x0035:
        if (r12 < 0) goto L_0x009b;
    L_0x0037:
        r5 = r10.zzmwy;
        r5 = r5.get(r12);
        r5 = (com.google.android.gms.internal.zzegd) r5;
        r6 = r5.isVisible();
        if (r6 == 0) goto L_0x0098;
    L_0x0045:
        if (r12 < r2) goto L_0x0089;
    L_0x0047:
        r6 = r3.zzbsy();
        r7 = r5.zzbxb();
        if (r7 == 0) goto L_0x005a;
    L_0x0051:
        r7 = r5.zzbsy();
        r6 = r7.zzi(r6);
        goto L_0x0085;
    L_0x005a:
        r7 = r5.zzbxa();
        r7 = r7.iterator();
    L_0x0062:
        r8 = r7.hasNext();
        if (r8 == 0) goto L_0x0084;
    L_0x0068:
        r8 = r7.next();
        r8 = (java.util.Map.Entry) r8;
        r9 = r5.zzbsy();
        r8 = r8.getKey();
        r8 = (com.google.android.gms.internal.zzedk) r8;
        r8 = r9.zzh(r8);
        r8 = r8.zzi(r6);
        if (r8 == 0) goto L_0x0062;
    L_0x0082:
        r6 = r0;
        goto L_0x0085;
    L_0x0084:
        r6 = r1;
    L_0x0085:
        if (r6 == 0) goto L_0x0089;
    L_0x0087:
        r11 = r1;
        goto L_0x0098;
    L_0x0089:
        r6 = r3.zzbsy();
        r5 = r5.zzbsy();
        r5 = r6.zzi(r5);
        if (r5 == 0) goto L_0x0098;
    L_0x0097:
        r4 = r0;
    L_0x0098:
        r12 = r12 + -1;
        goto L_0x0033;
    L_0x009b:
        if (r11 != 0) goto L_0x009e;
    L_0x009d:
        return r1;
    L_0x009e:
        if (r4 == 0) goto L_0x00d4;
    L_0x00a0:
        r11 = r10.zzmwy;
        r12 = zzmxa;
        r1 = com.google.android.gms.internal.zzedk.zzbwe();
        r11 = zza(r11, r12, r1);
        r10.zzmwx = r11;
        r11 = r10.zzmwy;
        r11 = r11.size();
        if (r11 <= 0) goto L_0x00d0;
    L_0x00b6:
        r11 = r10.zzmwy;
        r12 = r10.zzmwy;
        r12 = r12.size();
        r12 = r12 - r0;
        r11 = r11.get(r12);
        r11 = (com.google.android.gms.internal.zzegd) r11;
        r11 = r11.zzbwy();
    L_0x00c9:
        r11 = java.lang.Long.valueOf(r11);
        r10.zzmwz = r11;
        return r0;
    L_0x00d0:
        r11 = -1;
        goto L_0x00c9;
        return r0;
    L_0x00d4:
        r11 = r3.zzbxb();
        if (r11 == 0) goto L_0x00e7;
    L_0x00da:
        r11 = r10.zzmwx;
        r12 = r3.zzbsy();
        r11 = r11.zzd(r12);
        r10.zzmwx = r11;
        return r0;
    L_0x00e7:
        r11 = r3.zzbxa();
        r11 = r11.iterator();
    L_0x00ef:
        r12 = r11.hasNext();
        if (r12 == 0) goto L_0x0112;
    L_0x00f5:
        r12 = r11.next();
        r12 = (java.util.Map.Entry) r12;
        r12 = r12.getKey();
        r12 = (com.google.android.gms.internal.zzedk) r12;
        r1 = r10.zzmwx;
        r2 = r3.zzbsy();
        r12 = r2.zzh(r12);
        r12 = r1.zzd(r12);
        r10.zzmwx = r12;
        goto L_0x00ef;
    L_0x0112:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzegg.zzbw(long):boolean");
    }

    public final List<zzegd> zzbxe() {
        List arrayList = new ArrayList(this.zzmwy);
        this.zzmwx = zzecy.zzbvq();
        this.zzmwy = new ArrayList();
        return arrayList;
    }

    public final zzekd zzj(zzedk com_google_android_gms_internal_zzedk, zzekd com_google_android_gms_internal_zzekd) {
        zzekd zzcaf = zzeju.zzcaf();
        zzekd<zzekc> zzf = this.zzmwx.zzf(com_google_android_gms_internal_zzedk);
        if (zzf != null) {
            if (!zzf.zzbzu()) {
                for (zzekc com_google_android_gms_internal_zzekc : zzf) {
                    zzcaf = zzcaf.zze(com_google_android_gms_internal_zzekc.zzcao(), com_google_android_gms_internal_zzekc.zzbsv());
                }
            }
            return zzcaf;
        }
        zzecy zzg = this.zzmwx.zzg(com_google_android_gms_internal_zzedk);
        for (zzekc com_google_android_gms_internal_zzekc2 : com_google_android_gms_internal_zzekd) {
            zzcaf = zzcaf.zze(com_google_android_gms_internal_zzekc2.zzcao(), zzg.zzg(new zzedk(com_google_android_gms_internal_zzekc2.zzcao())).zzb(com_google_android_gms_internal_zzekc2.zzbsv()));
        }
        for (zzekc com_google_android_gms_internal_zzekc3 : zzg.zzbvs()) {
            zzcaf = zzcaf.zze(com_google_android_gms_internal_zzekc3.zzcao(), com_google_android_gms_internal_zzekc3.zzbsv());
        }
        return zzcaf;
    }

    public final zzegj zzt(zzedk com_google_android_gms_internal_zzedk) {
        return new zzegj(com_google_android_gms_internal_zzedk, this);
    }

    public final zzekd zzu(zzedk com_google_android_gms_internal_zzedk) {
        return this.zzmwx.zzf(com_google_android_gms_internal_zzedk);
    }
}
