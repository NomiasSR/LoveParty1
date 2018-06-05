package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.zza;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.Api.zze;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.internal.zzr;
import com.google.android.gms.common.zzf;
import com.google.android.gms.internal.zzcxd;
import com.google.android.gms.internal.zzcxe;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public final class zzbi implements zzcc, zzu {
    private final Context mContext;
    private zza<? extends zzcxd, zzcxe> zzfmz;
    final zzba zzfpi;
    private final Lock zzfps;
    private zzr zzfpx;
    private Map<Api<?>, Boolean> zzfqa;
    private final zzf zzfqc;
    final Map<zzc<?>, zze> zzfsb;
    private final Condition zzfso;
    private final zzbk zzfsp;
    final Map<zzc<?>, ConnectionResult> zzfsq = new HashMap();
    private volatile zzbh zzfsr;
    private ConnectionResult zzfss = null;
    int zzfst;
    final zzcd zzfsu;

    public zzbi(Context context, zzba com_google_android_gms_common_api_internal_zzba, Lock lock, Looper looper, zzf com_google_android_gms_common_zzf, Map<zzc<?>, zze> map, zzr com_google_android_gms_common_internal_zzr, Map<Api<?>, Boolean> map2, zza<? extends zzcxd, zzcxe> com_google_android_gms_common_api_Api_zza__extends_com_google_android_gms_internal_zzcxd__com_google_android_gms_internal_zzcxe, ArrayList<zzt> arrayList, zzcd com_google_android_gms_common_api_internal_zzcd) {
        this.mContext = context;
        this.zzfps = lock;
        this.zzfqc = com_google_android_gms_common_zzf;
        this.zzfsb = map;
        this.zzfpx = com_google_android_gms_common_internal_zzr;
        this.zzfqa = map2;
        this.zzfmz = com_google_android_gms_common_api_Api_zza__extends_com_google_android_gms_internal_zzcxd__com_google_android_gms_internal_zzcxe;
        this.zzfpi = com_google_android_gms_common_api_internal_zzba;
        this.zzfsu = com_google_android_gms_common_api_internal_zzcd;
        ArrayList arrayList2 = arrayList;
        int size = arrayList2.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList2.get(i);
            i++;
            ((zzt) obj).zza(this);
        }
        this.zzfsp = new zzbk(this, looper);
        this.zzfso = lock.newCondition();
        this.zzfsr = new zzaz(this);
    }

    public final com.google.android.gms.common.ConnectionResult blockingConnect() {
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
        r3 = this;
        r3.connect();
    L_0x0003:
        r0 = r3.isConnecting();
        r1 = 0;
        if (r0 == 0) goto L_0x001f;
    L_0x000a:
        r0 = r3.zzfso;	 Catch:{ InterruptedException -> 0x0010 }
        r0.await();	 Catch:{ InterruptedException -> 0x0010 }
        goto L_0x0003;
    L_0x0010:
        r0 = java.lang.Thread.currentThread();
        r0.interrupt();
        r0 = new com.google.android.gms.common.ConnectionResult;
        r2 = 15;
        r0.<init>(r2, r1);
        return r0;
    L_0x001f:
        r0 = r3.isConnected();
        if (r0 == 0) goto L_0x0028;
    L_0x0025:
        r0 = com.google.android.gms.common.ConnectionResult.zzfkr;
        return r0;
    L_0x0028:
        r0 = r3.zzfss;
        if (r0 == 0) goto L_0x002f;
    L_0x002c:
        r0 = r3.zzfss;
        return r0;
    L_0x002f:
        r0 = new com.google.android.gms.common.ConnectionResult;
        r2 = 13;
        r0.<init>(r2, r1);
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.internal.zzbi.blockingConnect():com.google.android.gms.common.ConnectionResult");
    }

    public final com.google.android.gms.common.ConnectionResult blockingConnect(long r4, java.util.concurrent.TimeUnit r6) {
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
        r3 = this;
        r3.connect();
        r4 = r6.toNanos(r4);
    L_0x0007:
        r6 = r3.isConnecting();
        r0 = 0;
        if (r6 == 0) goto L_0x0035;
    L_0x000e:
        r1 = 0;
        r6 = (r4 > r1 ? 1 : (r4 == r1 ? 0 : -1));
        if (r6 > 0) goto L_0x001f;
    L_0x0014:
        r3.disconnect();	 Catch:{ InterruptedException -> 0x0026 }
        r4 = new com.google.android.gms.common.ConnectionResult;	 Catch:{ InterruptedException -> 0x0026 }
        r5 = 14;	 Catch:{ InterruptedException -> 0x0026 }
        r4.<init>(r5, r0);	 Catch:{ InterruptedException -> 0x0026 }
        return r4;	 Catch:{ InterruptedException -> 0x0026 }
    L_0x001f:
        r6 = r3.zzfso;	 Catch:{ InterruptedException -> 0x0026 }
        r4 = r6.awaitNanos(r4);	 Catch:{ InterruptedException -> 0x0026 }
        goto L_0x0007;
    L_0x0026:
        r4 = java.lang.Thread.currentThread();
        r4.interrupt();
        r4 = new com.google.android.gms.common.ConnectionResult;
        r5 = 15;
        r4.<init>(r5, r0);
        return r4;
    L_0x0035:
        r4 = r3.isConnected();
        if (r4 == 0) goto L_0x003e;
    L_0x003b:
        r4 = com.google.android.gms.common.ConnectionResult.zzfkr;
        return r4;
    L_0x003e:
        r4 = r3.zzfss;
        if (r4 == 0) goto L_0x0045;
    L_0x0042:
        r4 = r3.zzfss;
        return r4;
    L_0x0045:
        r4 = new com.google.android.gms.common.ConnectionResult;
        r5 = 13;
        r4.<init>(r5, r0);
        return r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.internal.zzbi.blockingConnect(long, java.util.concurrent.TimeUnit):com.google.android.gms.common.ConnectionResult");
    }

    public final void connect() {
        this.zzfsr.connect();
    }

    public final void disconnect() {
        if (this.zzfsr.disconnect()) {
            this.zzfsq.clear();
        }
    }

    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        String concat = String.valueOf(str).concat("  ");
        printWriter.append(str).append("mState=").println(this.zzfsr);
        for (Api api : this.zzfqa.keySet()) {
            printWriter.append(str).append(api.getName()).println(":");
            ((zze) this.zzfsb.get(api.zzagf())).dump(concat, fileDescriptor, printWriter, strArr);
        }
    }

    @Nullable
    public final ConnectionResult getConnectionResult(@NonNull Api<?> api) {
        zzc zzagf = api.zzagf();
        if (this.zzfsb.containsKey(zzagf)) {
            if (((zze) this.zzfsb.get(zzagf)).isConnected()) {
                return ConnectionResult.zzfkr;
            }
            if (this.zzfsq.containsKey(zzagf)) {
                return (ConnectionResult) this.zzfsq.get(zzagf);
            }
        }
        return null;
    }

    public final boolean isConnected() {
        return this.zzfsr instanceof zzal;
    }

    public final boolean isConnecting() {
        return this.zzfsr instanceof zzao;
    }

    public final void onConnected(@Nullable Bundle bundle) {
        this.zzfps.lock();
        try {
            this.zzfsr.onConnected(bundle);
        } finally {
            this.zzfps.unlock();
        }
    }

    public final void onConnectionSuspended(int i) {
        this.zzfps.lock();
        try {
            this.zzfsr.onConnectionSuspended(i);
        } finally {
            this.zzfps.unlock();
        }
    }

    public final void zza(@NonNull ConnectionResult connectionResult, @NonNull Api<?> api, boolean z) {
        this.zzfps.lock();
        try {
            this.zzfsr.zza(connectionResult, api, z);
        } finally {
            this.zzfps.unlock();
        }
    }

    final void zza(zzbj com_google_android_gms_common_api_internal_zzbj) {
        this.zzfsp.sendMessage(this.zzfsp.obtainMessage(1, com_google_android_gms_common_api_internal_zzbj));
    }

    final void zza(RuntimeException runtimeException) {
        this.zzfsp.sendMessage(this.zzfsp.obtainMessage(2, runtimeException));
    }

    public final boolean zza(zzcu com_google_android_gms_common_api_internal_zzcu) {
        return false;
    }

    public final void zzags() {
    }

    public final void zzahk() {
        if (isConnected()) {
            ((zzal) this.zzfsr).zzaia();
        }
    }

    final void zzain() {
        this.zzfps.lock();
        try {
            this.zzfsr = new zzao(this, this.zzfpx, this.zzfqa, this.zzfqc, this.zzfmz, this.zzfps, this.mContext);
            this.zzfsr.begin();
            this.zzfso.signalAll();
        } finally {
            this.zzfps.unlock();
        }
    }

    final void zzaio() {
        this.zzfps.lock();
        try {
            this.zzfpi.zzaik();
            this.zzfsr = new zzal(this);
            this.zzfsr.begin();
            this.zzfso.signalAll();
        } finally {
            this.zzfps.unlock();
        }
    }

    public final <A extends zzb, R extends Result, T extends zzm<R, A>> T zzd(@NonNull T t) {
        t.zzahi();
        return this.zzfsr.zzd(t);
    }

    public final <A extends zzb, T extends zzm<? extends Result, A>> T zze(@NonNull T t) {
        t.zzahi();
        return this.zzfsr.zze(t);
    }

    final void zzg(ConnectionResult connectionResult) {
        this.zzfps.lock();
        try {
            this.zzfss = connectionResult;
            this.zzfsr = new zzaz(this);
            this.zzfsr.begin();
            this.zzfso.signalAll();
        } finally {
            this.zzfps.unlock();
        }
    }
}
