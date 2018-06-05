package com.google.android.gms.internal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.os.WorkSource;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.common.util.zzu;
import com.google.android.gms.common.util.zzy;
import java.util.HashMap;
import java.util.Map;

public final class zzcxt {
    private static boolean DEBUG = false;
    private static String TAG = "WakeLock";
    private static String zzkcd = "*gcore*:";
    private final Context mContext;
    private final String zzgdn;
    private final String zzgdp;
    private final WakeLock zzkce;
    private WorkSource zzkcf;
    private final int zzkcg;
    private final String zzkch;
    private boolean zzkci;
    private final Map<String, Integer[]> zzkcj;
    private int zzkck;

    public zzcxt(Context context, int i, String str) {
        this(context, 1, str, null, context == null ? null : context.getPackageName());
    }

    @SuppressLint({"UnwrappedWakeLock"})
    private zzcxt(Context context, int i, String str, String str2, String str3) {
        this(context, 1, str, null, str3, null);
    }

    @SuppressLint({"UnwrappedWakeLock"})
    private zzcxt(Context context, int i, String str, String str2, String str3, String str4) {
        this.zzkci = true;
        this.zzkcj = new HashMap();
        zzbq.zzh(str, "Wake lock name can NOT be empty");
        this.zzkcg = i;
        this.zzkch = null;
        this.zzgdp = null;
        this.mContext = context.getApplicationContext();
        if ("com.google.android.gms".equals(context.getPackageName())) {
            this.zzgdn = str;
        } else {
            str2 = String.valueOf(zzkcd);
            str4 = String.valueOf(str);
            this.zzgdn = str4.length() != 0 ? str2.concat(str4) : new String(str2);
        }
        this.zzkce = ((PowerManager) context.getSystemService("power")).newWakeLock(i, str);
        if (zzy.zzcy(this.mContext)) {
            if (zzu.zzgs(str3)) {
                str3 = context.getPackageName();
            }
            this.zzkcf = zzy.zzaa(context, str3);
            WorkSource workSource = this.zzkcf;
            if (workSource != null && zzy.zzcy(this.mContext)) {
                if (this.zzkcf != null) {
                    this.zzkcf.add(workSource);
                } else {
                    this.zzkcf = workSource;
                }
                try {
                    this.zzkce.setWorkSource(this.zzkcf);
                } catch (IllegalArgumentException e) {
                    Log.wtf(TAG, e.toString());
                }
            }
        }
    }

    private final String zzkz(String str) {
        return this.zzkci ? !TextUtils.isEmpty(null) ? null : this.zzkch : this.zzkch;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void acquire(long r12) {
        /*
        r11 = this;
        r12 = 0;
        r4 = r11.zzkz(r12);
        monitor-enter(r11);
        r12 = r11.zzkcj;	 Catch:{ all -> 0x0081 }
        r12 = r12.isEmpty();	 Catch:{ all -> 0x0081 }
        r13 = 0;
        if (r12 == 0) goto L_0x0013;
    L_0x000f:
        r12 = r11.zzkck;	 Catch:{ all -> 0x0081 }
        if (r12 <= 0) goto L_0x0022;
    L_0x0013:
        r12 = r11.zzkce;	 Catch:{ all -> 0x0081 }
        r12 = r12.isHeld();	 Catch:{ all -> 0x0081 }
        if (r12 != 0) goto L_0x0022;
    L_0x001b:
        r12 = r11.zzkcj;	 Catch:{ all -> 0x0081 }
        r12.clear();	 Catch:{ all -> 0x0081 }
        r11.zzkck = r13;	 Catch:{ all -> 0x0081 }
    L_0x0022:
        r12 = r11.zzkci;	 Catch:{ all -> 0x0081 }
        r10 = 1;
        if (r12 == 0) goto L_0x004f;
    L_0x0027:
        r12 = r11.zzkcj;	 Catch:{ all -> 0x0081 }
        r12 = r12.get(r4);	 Catch:{ all -> 0x0081 }
        r12 = (java.lang.Integer[]) r12;	 Catch:{ all -> 0x0081 }
        if (r12 != 0) goto L_0x0040;
    L_0x0031:
        r12 = r11.zzkcj;	 Catch:{ all -> 0x0081 }
        r0 = new java.lang.Integer[r10];	 Catch:{ all -> 0x0081 }
        r1 = java.lang.Integer.valueOf(r10);	 Catch:{ all -> 0x0081 }
        r0[r13] = r1;	 Catch:{ all -> 0x0081 }
        r12.put(r4, r0);	 Catch:{ all -> 0x0081 }
        r13 = r10;
        goto L_0x004d;
    L_0x0040:
        r0 = r12[r13];	 Catch:{ all -> 0x0081 }
        r0 = r0.intValue();	 Catch:{ all -> 0x0081 }
        r0 = r0 + r10;
        r0 = java.lang.Integer.valueOf(r0);	 Catch:{ all -> 0x0081 }
        r12[r13] = r0;	 Catch:{ all -> 0x0081 }
    L_0x004d:
        if (r13 != 0) goto L_0x0057;
    L_0x004f:
        r12 = r11.zzkci;	 Catch:{ all -> 0x0081 }
        if (r12 != 0) goto L_0x0078;
    L_0x0053:
        r12 = r11.zzkck;	 Catch:{ all -> 0x0081 }
        if (r12 != 0) goto L_0x0078;
    L_0x0057:
        com.google.android.gms.common.stats.zze.zzamf();	 Catch:{ all -> 0x0081 }
        r0 = r11.mContext;	 Catch:{ all -> 0x0081 }
        r12 = r11.zzkce;	 Catch:{ all -> 0x0081 }
        r1 = com.google.android.gms.common.stats.zzc.zza(r12, r4);	 Catch:{ all -> 0x0081 }
        r2 = 7;
        r3 = r11.zzgdn;	 Catch:{ all -> 0x0081 }
        r5 = 0;
        r6 = r11.zzkcg;	 Catch:{ all -> 0x0081 }
        r12 = r11.zzkcf;	 Catch:{ all -> 0x0081 }
        r7 = com.google.android.gms.common.util.zzy.zzb(r12);	 Catch:{ all -> 0x0081 }
        r8 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        com.google.android.gms.common.stats.zze.zza(r0, r1, r2, r3, r4, r5, r6, r7, r8);	 Catch:{ all -> 0x0081 }
        r12 = r11.zzkck;	 Catch:{ all -> 0x0081 }
        r12 = r12 + r10;
        r11.zzkck = r12;	 Catch:{ all -> 0x0081 }
    L_0x0078:
        monitor-exit(r11);	 Catch:{ all -> 0x0081 }
        r12 = r11.zzkce;
        r0 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r12.acquire(r0);
        return;
    L_0x0081:
        r12 = move-exception;
        monitor-exit(r11);	 Catch:{ all -> 0x0081 }
        throw r12;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzcxt.acquire(long):void");
    }

    public final boolean isHeld() {
        return this.zzkce.isHeld();
    }

    public final void release() {
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
        r10 = this;
        r0 = 0;
        r5 = r10.zzkz(r0);
        monitor-enter(r10);
        r0 = r10.zzkci;	 Catch:{ all -> 0x0064 }
        r9 = 1;	 Catch:{ all -> 0x0064 }
        if (r0 == 0) goto L_0x0035;	 Catch:{ all -> 0x0064 }
    L_0x000b:
        r0 = r10.zzkcj;	 Catch:{ all -> 0x0064 }
        r0 = r0.get(r5);	 Catch:{ all -> 0x0064 }
        r0 = (java.lang.Integer[]) r0;	 Catch:{ all -> 0x0064 }
        r1 = 0;	 Catch:{ all -> 0x0064 }
        if (r0 != 0) goto L_0x0017;	 Catch:{ all -> 0x0064 }
    L_0x0016:
        goto L_0x0033;	 Catch:{ all -> 0x0064 }
    L_0x0017:
        r2 = r0[r1];	 Catch:{ all -> 0x0064 }
        r2 = r2.intValue();	 Catch:{ all -> 0x0064 }
        if (r2 != r9) goto L_0x0026;	 Catch:{ all -> 0x0064 }
    L_0x001f:
        r0 = r10.zzkcj;	 Catch:{ all -> 0x0064 }
        r0.remove(r5);	 Catch:{ all -> 0x0064 }
        r1 = r9;	 Catch:{ all -> 0x0064 }
        goto L_0x0033;	 Catch:{ all -> 0x0064 }
    L_0x0026:
        r2 = r0[r1];	 Catch:{ all -> 0x0064 }
        r2 = r2.intValue();	 Catch:{ all -> 0x0064 }
        r2 = r2 - r9;	 Catch:{ all -> 0x0064 }
        r2 = java.lang.Integer.valueOf(r2);	 Catch:{ all -> 0x0064 }
        r0[r1] = r2;	 Catch:{ all -> 0x0064 }
    L_0x0033:
        if (r1 != 0) goto L_0x003d;	 Catch:{ all -> 0x0064 }
    L_0x0035:
        r0 = r10.zzkci;	 Catch:{ all -> 0x0064 }
        if (r0 != 0) goto L_0x005d;	 Catch:{ all -> 0x0064 }
    L_0x0039:
        r0 = r10.zzkck;	 Catch:{ all -> 0x0064 }
        if (r0 != r9) goto L_0x005d;	 Catch:{ all -> 0x0064 }
    L_0x003d:
        com.google.android.gms.common.stats.zze.zzamf();	 Catch:{ all -> 0x0064 }
        r1 = r10.mContext;	 Catch:{ all -> 0x0064 }
        r0 = r10.zzkce;	 Catch:{ all -> 0x0064 }
        r2 = com.google.android.gms.common.stats.zzc.zza(r0, r5);	 Catch:{ all -> 0x0064 }
        r3 = 8;	 Catch:{ all -> 0x0064 }
        r4 = r10.zzgdn;	 Catch:{ all -> 0x0064 }
        r6 = 0;	 Catch:{ all -> 0x0064 }
        r7 = r10.zzkcg;	 Catch:{ all -> 0x0064 }
        r0 = r10.zzkcf;	 Catch:{ all -> 0x0064 }
        r8 = com.google.android.gms.common.util.zzy.zzb(r0);	 Catch:{ all -> 0x0064 }
        com.google.android.gms.common.stats.zze.zza(r1, r2, r3, r4, r5, r6, r7, r8);	 Catch:{ all -> 0x0064 }
        r0 = r10.zzkck;	 Catch:{ all -> 0x0064 }
        r0 = r0 - r9;	 Catch:{ all -> 0x0064 }
        r10.zzkck = r0;	 Catch:{ all -> 0x0064 }
    L_0x005d:
        monitor-exit(r10);	 Catch:{ all -> 0x0064 }
        r0 = r10.zzkce;	 Catch:{ RuntimeException -> 0x0063 }
        r0.release();	 Catch:{ RuntimeException -> 0x0063 }
    L_0x0063:
        return;
    L_0x0064:
        r0 = move-exception;
        monitor-exit(r10);	 Catch:{ all -> 0x0064 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzcxt.release():void");
    }

    public final void setReferenceCounted(boolean z) {
        this.zzkce.setReferenceCounted(false);
        this.zzkci = false;
    }
}
