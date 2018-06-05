package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.util.ArrayMap;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.zza;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.Api.zze;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzr;
import com.google.android.gms.common.internal.zzt;
import com.google.android.gms.common.zzf;
import com.google.android.gms.internal.zzbha;
import com.google.android.gms.internal.zzcxd;
import com.google.android.gms.internal.zzcxe;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public final class zzaa implements zzcc {
    private final Looper zzall;
    private final zzbm zzfmi;
    private final Lock zzfps;
    private final zzr zzfpx;
    private final Map<zzc<?>, zzz<?>> zzfpy = new HashMap();
    private final Map<zzc<?>, zzz<?>> zzfpz = new HashMap();
    private final Map<Api<?>, Boolean> zzfqa;
    private final zzba zzfqb;
    private final zzf zzfqc;
    private final Condition zzfqd;
    private final boolean zzfqe;
    private final boolean zzfqf;
    private final Queue<zzm<?, ?>> zzfqg = new LinkedList();
    private boolean zzfqh;
    private Map<zzh<?>, ConnectionResult> zzfqi;
    private Map<zzh<?>, ConnectionResult> zzfqj;
    private zzad zzfqk;
    private ConnectionResult zzfql;

    public zzaa(Context context, Lock lock, Looper looper, zzf com_google_android_gms_common_zzf, Map<zzc<?>, zze> map, zzr com_google_android_gms_common_internal_zzr, Map<Api<?>, Boolean> map2, zza<? extends zzcxd, zzcxe> com_google_android_gms_common_api_Api_zza__extends_com_google_android_gms_internal_zzcxd__com_google_android_gms_internal_zzcxe, ArrayList<zzt> arrayList, zzba com_google_android_gms_common_api_internal_zzba, boolean z) {
        this.zzfps = lock;
        Looper looper2 = looper;
        this.zzall = looper2;
        this.zzfqd = lock.newCondition();
        this.zzfqc = com_google_android_gms_common_zzf;
        this.zzfqb = com_google_android_gms_common_api_internal_zzba;
        this.zzfqa = map2;
        zzr com_google_android_gms_common_internal_zzr2 = com_google_android_gms_common_internal_zzr;
        this.zzfpx = com_google_android_gms_common_internal_zzr2;
        this.zzfqe = z;
        Map hashMap = new HashMap();
        for (Api api : map2.keySet()) {
            hashMap.put(api.zzagf(), api);
        }
        Map hashMap2 = new HashMap();
        ArrayList arrayList2 = arrayList;
        int size = arrayList2.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList2.get(i);
            i++;
            zzt com_google_android_gms_common_api_internal_zzt = (zzt) obj;
            hashMap2.put(com_google_android_gms_common_api_internal_zzt.zzfin, com_google_android_gms_common_api_internal_zzt);
        }
        Object obj2 = null;
        Object obj3 = 1;
        Object obj4 = null;
        for (Entry entry : map.entrySet()) {
            Object obj5;
            Object obj6;
            Object obj7;
            Api api2 = (Api) hashMap.get(entry.getKey());
            zze com_google_android_gms_common_api_Api_zze = (zze) entry.getValue();
            if (com_google_android_gms_common_api_Api_zze.zzagg()) {
                if (((Boolean) r0.zzfqa.get(api2)).booleanValue()) {
                    obj5 = obj3;
                    obj6 = obj4;
                } else {
                    obj5 = obj3;
                    obj6 = 1;
                }
                obj7 = 1;
            } else {
                obj7 = obj2;
                obj6 = obj4;
                obj5 = null;
            }
            zzz com_google_android_gms_common_api_internal_zzz = r1;
            zze com_google_android_gms_common_api_Api_zze2 = com_google_android_gms_common_api_Api_zze;
            Entry entry2 = entry;
            zzz com_google_android_gms_common_api_internal_zzz2 = new zzz(context, api2, looper2, com_google_android_gms_common_api_Api_zze, (zzt) hashMap2.get(api2), com_google_android_gms_common_internal_zzr2, com_google_android_gms_common_api_Api_zza__extends_com_google_android_gms_internal_zzcxd__com_google_android_gms_internal_zzcxe);
            r0.zzfpy.put((zzc) entry2.getKey(), com_google_android_gms_common_api_internal_zzz);
            if (com_google_android_gms_common_api_Api_zze2.zzaay()) {
                r0.zzfpz.put((zzc) entry2.getKey(), com_google_android_gms_common_api_internal_zzz);
            }
            obj4 = obj6;
            obj3 = obj5;
            obj2 = obj7;
            looper2 = looper;
        }
        boolean z2 = obj2 != null && obj3 == null && obj4 == null;
        r0.zzfqf = z2;
        r0.zzfmi = zzbm.zzaiq();
    }

    private final boolean zza(zzz<?> com_google_android_gms_common_api_internal_zzz_, ConnectionResult connectionResult) {
        return !connectionResult.isSuccess() && !connectionResult.hasResolution() && ((Boolean) this.zzfqa.get(com_google_android_gms_common_api_internal_zzz_.zzagl())).booleanValue() && com_google_android_gms_common_api_internal_zzz_.zzahp().zzagg() && this.zzfqc.isUserResolvableError(connectionResult.getErrorCode());
    }

    private final boolean zzahq() {
        this.zzfps.lock();
        try {
            if (this.zzfqh) {
                if (this.zzfqe) {
                    for (zzc zzb : this.zzfpz.keySet()) {
                        ConnectionResult zzb2 = zzb(zzb);
                        if (zzb2 != null) {
                            if (!zzb2.isSuccess()) {
                            }
                        }
                    }
                    this.zzfps.unlock();
                    return true;
                }
            }
            this.zzfps.unlock();
            return false;
        } catch (Throwable th) {
            this.zzfps.unlock();
        }
    }

    private final void zzahr() {
        if (this.zzfpx == null) {
            this.zzfqb.zzfsc = Collections.emptySet();
            return;
        }
        Set hashSet = new HashSet(this.zzfpx.zzakv());
        Map zzakx = this.zzfpx.zzakx();
        for (Api api : zzakx.keySet()) {
            ConnectionResult connectionResult = getConnectionResult(api);
            if (connectionResult != null && connectionResult.isSuccess()) {
                hashSet.addAll(((zzt) zzakx.get(api)).zzehs);
            }
        }
        this.zzfqb.zzfsc = hashSet;
    }

    private final void zzahs() {
        while (!this.zzfqg.isEmpty()) {
            zze((zzm) this.zzfqg.remove());
        }
        this.zzfqb.zzj(null);
    }

    @Nullable
    private final ConnectionResult zzaht() {
        ConnectionResult connectionResult = null;
        int i = 0;
        int i2 = i;
        ConnectionResult connectionResult2 = null;
        for (zzz com_google_android_gms_common_api_internal_zzz : this.zzfpy.values()) {
            Api zzagl = com_google_android_gms_common_api_internal_zzz.zzagl();
            ConnectionResult connectionResult3 = (ConnectionResult) this.zzfqi.get(com_google_android_gms_common_api_internal_zzz.zzagn());
            if (!connectionResult3.isSuccess() && (!((Boolean) this.zzfqa.get(zzagl)).booleanValue() || connectionResult3.hasResolution() || this.zzfqc.isUserResolvableError(connectionResult3.getErrorCode()))) {
                int priority;
                if (connectionResult3.getErrorCode() == 4 && this.zzfqe) {
                    priority = zzagl.zzagd().getPriority();
                    if (connectionResult2 == null || i2 > priority) {
                        connectionResult2 = connectionResult3;
                        i2 = priority;
                    }
                } else {
                    priority = zzagl.zzagd().getPriority();
                    if (connectionResult == null || i > priority) {
                        connectionResult = connectionResult3;
                        i = priority;
                    }
                }
            }
        }
        return (connectionResult == null || connectionResult2 == null || i <= i2) ? connectionResult : connectionResult2;
    }

    @Nullable
    private final ConnectionResult zzb(@NonNull zzc<?> com_google_android_gms_common_api_Api_zzc_) {
        this.zzfps.lock();
        try {
            zzz com_google_android_gms_common_api_internal_zzz = (zzz) this.zzfpy.get(com_google_android_gms_common_api_Api_zzc_);
            if (this.zzfqi == null || com_google_android_gms_common_api_internal_zzz == null) {
                this.zzfps.unlock();
                return null;
            }
            ConnectionResult connectionResult = (ConnectionResult) this.zzfqi.get(com_google_android_gms_common_api_internal_zzz.zzagn());
            return connectionResult;
        } finally {
            this.zzfps.unlock();
        }
    }

    private final <T extends zzm<? extends Result, ? extends zzb>> boolean zzg(@NonNull T t) {
        zzc zzagf = t.zzagf();
        ConnectionResult zzb = zzb(zzagf);
        if (zzb == null || zzb.getErrorCode() != 4) {
            return false;
        }
        t.zzu(new Status(4, null, this.zzfmi.zza(((zzz) this.zzfpy.get(zzagf)).zzagn(), System.identityHashCode(this.zzfqb))));
        return true;
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
        r0 = r3.zzfqd;	 Catch:{ InterruptedException -> 0x0010 }
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
        r0 = r3.zzfql;
        if (r0 == 0) goto L_0x002f;
    L_0x002c:
        r0 = r3.zzfql;
        return r0;
    L_0x002f:
        r0 = new com.google.android.gms.common.ConnectionResult;
        r2 = 13;
        r0.<init>(r2, r1);
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.internal.zzaa.blockingConnect():com.google.android.gms.common.ConnectionResult");
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
        r6 = r3.zzfqd;	 Catch:{ InterruptedException -> 0x0026 }
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
        r4 = r3.zzfql;
        if (r4 == 0) goto L_0x0045;
    L_0x0042:
        r4 = r3.zzfql;
        return r4;
    L_0x0045:
        r4 = new com.google.android.gms.common.ConnectionResult;
        r5 = 13;
        r4.<init>(r5, r0);
        return r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.internal.zzaa.blockingConnect(long, java.util.concurrent.TimeUnit):com.google.android.gms.common.ConnectionResult");
    }

    public final void connect() {
        this.zzfps.lock();
        try {
            if (!this.zzfqh) {
                this.zzfqh = true;
                this.zzfqi = null;
                this.zzfqj = null;
                this.zzfqk = null;
                this.zzfql = null;
                this.zzfmi.zzagz();
                this.zzfmi.zza(this.zzfpy.values()).addOnCompleteListener(new zzbha(this.zzall), new zzac());
            }
            this.zzfps.unlock();
        } catch (Throwable th) {
            this.zzfps.unlock();
        }
    }

    public final void disconnect() {
        this.zzfps.lock();
        try {
            this.zzfqh = false;
            this.zzfqi = null;
            this.zzfqj = null;
            if (this.zzfqk != null) {
                this.zzfqk.cancel();
                this.zzfqk = null;
            }
            this.zzfql = null;
            while (!this.zzfqg.isEmpty()) {
                zzm com_google_android_gms_common_api_internal_zzm = (zzm) this.zzfqg.remove();
                com_google_android_gms_common_api_internal_zzm.zza(null);
                com_google_android_gms_common_api_internal_zzm.cancel();
            }
            this.zzfqd.signalAll();
        } finally {
            this.zzfps.unlock();
        }
    }

    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
    }

    @Nullable
    public final ConnectionResult getConnectionResult(@NonNull Api<?> api) {
        return zzb(api.zzagf());
    }

    public final boolean isConnected() {
        this.zzfps.lock();
        try {
            boolean z = this.zzfqi != null && this.zzfql == null;
            this.zzfps.unlock();
            return z;
        } catch (Throwable th) {
            this.zzfps.unlock();
        }
    }

    public final boolean isConnecting() {
        this.zzfps.lock();
        try {
            boolean z = this.zzfqi == null && this.zzfqh;
            this.zzfps.unlock();
            return z;
        } catch (Throwable th) {
            this.zzfps.unlock();
        }
    }

    public final boolean zza(zzcu com_google_android_gms_common_api_internal_zzcu) {
        this.zzfps.lock();
        try {
            if (!this.zzfqh || zzahq()) {
                this.zzfps.unlock();
                return false;
            }
            this.zzfmi.zzagz();
            this.zzfqk = new zzad(this, com_google_android_gms_common_api_internal_zzcu);
            this.zzfmi.zza(this.zzfpz.values()).addOnCompleteListener(new zzbha(this.zzall), this.zzfqk);
            return true;
        } finally {
            this.zzfps.unlock();
        }
    }

    public final void zzags() {
        this.zzfps.lock();
        try {
            this.zzfmi.zzags();
            if (this.zzfqk != null) {
                this.zzfqk.cancel();
                this.zzfqk = null;
            }
            if (this.zzfqj == null) {
                this.zzfqj = new ArrayMap(this.zzfpz.size());
            }
            ConnectionResult connectionResult = new ConnectionResult(4);
            for (zzz zzagn : this.zzfpz.values()) {
                this.zzfqj.put(zzagn.zzagn(), connectionResult);
            }
            if (this.zzfqi != null) {
                this.zzfqi.putAll(this.zzfqj);
            }
            this.zzfps.unlock();
        } catch (Throwable th) {
            this.zzfps.unlock();
        }
    }

    public final void zzahk() {
    }

    public final <A extends zzb, R extends Result, T extends zzm<R, A>> T zzd(@NonNull T t) {
        if (this.zzfqe && zzg((zzm) t)) {
            return t;
        }
        if (isConnected()) {
            this.zzfqb.zzfsh.zzb(t);
            return ((zzz) this.zzfpy.get(t.zzagf())).zza((zzm) t);
        }
        this.zzfqg.add(t);
        return t;
    }

    public final <A extends zzb, T extends zzm<? extends Result, A>> T zze(@NonNull T t) {
        zzc zzagf = t.zzagf();
        if (this.zzfqe && zzg((zzm) t)) {
            return t;
        }
        this.zzfqb.zzfsh.zzb(t);
        return ((zzz) this.zzfpy.get(zzagf)).zzb((zzm) t);
    }
}
