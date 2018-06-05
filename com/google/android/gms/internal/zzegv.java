package com.google.android.gms.internal;

import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.Callable;

public final class zzegv implements zzegy {
    private final zzejc zzmlr;
    private final zzegz zzmyc;
    private final zzehf zzmyd;
    private final zzegt zzmye;
    private long zzmyf;

    public zzegv(zzedc com_google_android_gms_internal_zzedc, zzegz com_google_android_gms_internal_zzegz, zzegt com_google_android_gms_internal_zzegt) {
        this(com_google_android_gms_internal_zzedc, com_google_android_gms_internal_zzegz, com_google_android_gms_internal_zzegt, new zzelj());
    }

    private zzegv(zzedc com_google_android_gms_internal_zzedc, zzegz com_google_android_gms_internal_zzegz, zzegt com_google_android_gms_internal_zzegt, zzeli com_google_android_gms_internal_zzeli) {
        this.zzmyf = 0;
        this.zzmyc = com_google_android_gms_internal_zzegz;
        this.zzmlr = com_google_android_gms_internal_zzedc.zzpv("Persistence");
        this.zzmyd = new zzehf(this.zzmyc, this.zzmlr, com_google_android_gms_internal_zzeli);
        this.zzmye = com_google_android_gms_internal_zzegt;
    }

    private final void zzbxr() {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:37)
	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:61)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:33)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r8 = this;
        r0 = r8.zzmyf;
        r2 = 1;
        r0 = r0 + r2;
        r8.zzmyf = r0;
        r0 = r8.zzmye;
        r1 = r8.zzmyf;
        r0 = r0.zzbx(r1);
        if (r0 == 0) goto L_0x0094;
    L_0x0011:
        r0 = r8.zzmlr;
        r0 = r0.zzbzl();
        r1 = 0;
        r2 = 0;
        if (r0 == 0) goto L_0x0024;
    L_0x001b:
        r0 = r8.zzmlr;
        r3 = "Reached prune check threshold.";
        r4 = new java.lang.Object[r2];
        r0.zzb(r3, r1, r4);
    L_0x0024:
        r3 = 0;
        r8.zzmyf = r3;
        r0 = 1;
        r3 = r8.zzmyc;
        r3 = r3.zzbtc();
        r5 = r8.zzmlr;
        r5 = r5.zzbzl();
        if (r5 == 0) goto L_0x0051;
    L_0x0037:
        r5 = r8.zzmlr;
        r6 = 32;
        r7 = new java.lang.StringBuilder;
        r7.<init>(r6);
        r6 = "Cache size: ";
    L_0x0042:
        r7.append(r6);
        r7.append(r3);
        r6 = r7.toString();
        r7 = new java.lang.Object[r2];
        r5.zzb(r6, r1, r7);
    L_0x0051:
        if (r0 == 0) goto L_0x0094;
    L_0x0053:
        r5 = r8.zzmye;
        r6 = r8.zzmyd;
        r6 = r6.zzbxu();
        r3 = r5.zzj(r3, r6);
        if (r3 == 0) goto L_0x0094;
    L_0x0061:
        r3 = r8.zzmyd;
        r4 = r8.zzmye;
        r3 = r3.zza(r4);
        r4 = r3.zzbxs();
        if (r4 == 0) goto L_0x0079;
    L_0x006f:
        r4 = r8.zzmyc;
        r5 = com.google.android.gms.internal.zzedk.zzbwe();
        r4.zza(r5, r3);
        goto L_0x007a;
    L_0x0079:
        r0 = r2;
    L_0x007a:
        r3 = r8.zzmyc;
        r3 = r3.zzbtc();
        r5 = r8.zzmlr;
        r5 = r5.zzbzl();
        if (r5 == 0) goto L_0x0051;
    L_0x0088:
        r5 = r8.zzmlr;
        r6 = 44;
        r7 = new java.lang.StringBuilder;
        r7.<init>(r6);
        r6 = "Cache size after prune: ";
        goto L_0x0042;
    L_0x0094:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzegv.zzbxr():void");
    }

    public final void zza(zzedk com_google_android_gms_internal_zzedk, zzecy com_google_android_gms_internal_zzecy, long j) {
        this.zzmyc.zza(com_google_android_gms_internal_zzedk, com_google_android_gms_internal_zzecy, j);
    }

    public final void zza(zzedk com_google_android_gms_internal_zzedk, zzekd com_google_android_gms_internal_zzekd, long j) {
        this.zzmyc.zza(com_google_android_gms_internal_zzedk, com_google_android_gms_internal_zzekd, j);
    }

    public final void zza(zzeik com_google_android_gms_internal_zzeik, zzekd com_google_android_gms_internal_zzekd) {
        if (com_google_android_gms_internal_zzeik.zzbyv()) {
            this.zzmyc.zza(com_google_android_gms_internal_zzeik.zzbsy(), com_google_android_gms_internal_zzekd);
        } else {
            this.zzmyc.zzb(com_google_android_gms_internal_zzeik.zzbsy(), com_google_android_gms_internal_zzekd);
        }
        zzi(com_google_android_gms_internal_zzeik);
        zzbxr();
    }

    public final void zza(zzeik com_google_android_gms_internal_zzeik, Set<zzejg> set) {
        this.zzmyc.zza(this.zzmyd.zzk(com_google_android_gms_internal_zzeik).id, (Set) set);
    }

    public final void zza(zzeik com_google_android_gms_internal_zzeik, Set<zzejg> set, Set<zzejg> set2) {
        this.zzmyc.zza(this.zzmyd.zzk(com_google_android_gms_internal_zzeik).id, (Set) set, (Set) set2);
    }

    public final void zzbl(long j) {
        this.zzmyc.zzbl(j);
    }

    public final List<zzegd> zzbtb() {
        return this.zzmyc.zzbtb();
    }

    public final void zzbte() {
        this.zzmyc.zzbte();
    }

    public final void zzc(zzedk com_google_android_gms_internal_zzedk, zzecy com_google_android_gms_internal_zzecy) {
        Iterator it = com_google_android_gms_internal_zzecy.iterator();
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            zzk(com_google_android_gms_internal_zzedk.zzh((zzedk) entry.getKey()), (zzekd) entry.getValue());
        }
    }

    public final void zzd(zzedk com_google_android_gms_internal_zzedk, zzecy com_google_android_gms_internal_zzecy) {
        this.zzmyc.zza(com_google_android_gms_internal_zzedk, com_google_android_gms_internal_zzecy);
        zzbxr();
    }

    public final <T> T zze(Callable<T> callable) {
        this.zzmyc.beginTransaction();
        try {
            T call = callable.call();
            this.zzmyc.setTransactionSuccessful();
            this.zzmyc.endTransaction();
            return call;
        } catch (Throwable th) {
            this.zzmyc.endTransaction();
        }
    }

    public final zzehx zzf(zzeik com_google_android_gms_internal_zzeik) {
        boolean z;
        Set zzbo;
        if (this.zzmyd.zzm(com_google_android_gms_internal_zzeik)) {
            zzehe zzk = this.zzmyd.zzk(com_google_android_gms_internal_zzeik);
            zzbo = (com_google_android_gms_internal_zzeik.zzbyv() || zzk == null || !zzk.complete) ? null : this.zzmyc.zzbo(zzk.id);
            z = true;
        } else {
            zzbo = this.zzmyd.zzaa(com_google_android_gms_internal_zzeik.zzbsy());
            z = false;
        }
        zzekd zza = this.zzmyc.zza(com_google_android_gms_internal_zzeik.zzbsy());
        if (r0 == null) {
            return new zzehx(zzejw.zza(zza, com_google_android_gms_internal_zzeik.zzbyr()), true, false);
        }
        zzekd zzcaf = zzeju.zzcaf();
        for (zzejg com_google_android_gms_internal_zzejg : r0) {
            zzcaf = zzcaf.zze(com_google_android_gms_internal_zzejg, zza.zzm(com_google_android_gms_internal_zzejg));
        }
        return new zzehx(zzejw.zza(zzcaf, com_google_android_gms_internal_zzeik.zzbyr()), z, true);
    }

    public final void zzg(zzeik com_google_android_gms_internal_zzeik) {
        this.zzmyd.zzg(com_google_android_gms_internal_zzeik);
    }

    public final void zzh(zzeik com_google_android_gms_internal_zzeik) {
        this.zzmyd.zzh(com_google_android_gms_internal_zzeik);
    }

    public final void zzi(zzeik com_google_android_gms_internal_zzeik) {
        if (com_google_android_gms_internal_zzeik.zzbyv()) {
            this.zzmyd.zzz(com_google_android_gms_internal_zzeik.zzbsy());
        } else {
            this.zzmyd.zzl(com_google_android_gms_internal_zzeik);
        }
    }

    public final void zzk(zzedk com_google_android_gms_internal_zzedk, zzekd com_google_android_gms_internal_zzekd) {
        if (!this.zzmyd.zzac(com_google_android_gms_internal_zzedk)) {
            this.zzmyc.zza(com_google_android_gms_internal_zzedk, com_google_android_gms_internal_zzekd);
            this.zzmyd.zzab(com_google_android_gms_internal_zzedk);
        }
    }
}
