package com.google.android.gms.common.api.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.ResultTransform;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.TransformedResult;
import com.google.android.gms.common.internal.zzaq;
import com.google.android.gms.common.internal.zzbq;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

@KeepName
public abstract class BasePendingResult<R extends Result> extends PendingResult<R> {
    static final ThreadLocal<Boolean> zzfot = new zzs();
    @KeepName
    private zzb mResultGuardian;
    private Status mStatus;
    private boolean zzan;
    private final CountDownLatch zzapd;
    private R zzfne;
    private final Object zzfou;
    private zza<R> zzfov;
    private WeakReference<GoogleApiClient> zzfow;
    private final ArrayList<com.google.android.gms.common.api.PendingResult.zza> zzfox;
    private ResultCallback<? super R> zzfoy;
    private final AtomicReference<zzdm> zzfoz;
    private volatile boolean zzfpa;
    private boolean zzfpb;
    private zzaq zzfpc;
    private volatile zzdg<R> zzfpd;
    private boolean zzfpe;

    public static class zza<R extends Result> extends Handler {
        public zza() {
            this(Looper.getMainLooper());
        }

        public zza(Looper looper) {
            super(looper);
        }

        public final void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    Pair pair = (Pair) message.obj;
                    ResultCallback resultCallback = (ResultCallback) pair.first;
                    Result result = (Result) pair.second;
                    try {
                        resultCallback.onResult(result);
                        return;
                    } catch (RuntimeException e) {
                        BasePendingResult.zzd(result);
                        throw e;
                    }
                case 2:
                    ((BasePendingResult) message.obj).zzv(Status.zzfnl);
                    return;
                default:
                    int i = message.what;
                    StringBuilder stringBuilder = new StringBuilder(45);
                    stringBuilder.append("Don't know how to handle message: ");
                    stringBuilder.append(i);
                    Log.wtf("BasePendingResult", stringBuilder.toString(), new Exception());
                    return;
            }
        }

        public final void zza(ResultCallback<? super R> resultCallback, R r) {
            sendMessage(obtainMessage(1, new Pair(resultCallback, r)));
        }
    }

    final class zzb {
        private /* synthetic */ BasePendingResult zzfpf;

        private zzb(BasePendingResult basePendingResult) {
            this.zzfpf = basePendingResult;
        }

        protected final void finalize() throws Throwable {
            BasePendingResult.zzd(this.zzfpf.zzfne);
            super.finalize();
        }
    }

    @Deprecated
    BasePendingResult() {
        this.zzfou = new Object();
        this.zzapd = new CountDownLatch(1);
        this.zzfox = new ArrayList();
        this.zzfoz = new AtomicReference();
        this.zzfpe = false;
        this.zzfov = new zza(Looper.getMainLooper());
        this.zzfow = new WeakReference(null);
    }

    @Deprecated
    protected BasePendingResult(Looper looper) {
        this.zzfou = new Object();
        this.zzapd = new CountDownLatch(1);
        this.zzfox = new ArrayList();
        this.zzfoz = new AtomicReference();
        this.zzfpe = false;
        this.zzfov = new zza(looper);
        this.zzfow = new WeakReference(null);
    }

    protected BasePendingResult(GoogleApiClient googleApiClient) {
        this.zzfou = new Object();
        this.zzapd = new CountDownLatch(1);
        this.zzfox = new ArrayList();
        this.zzfoz = new AtomicReference();
        this.zzfpe = false;
        this.zzfov = new zza(googleApiClient != null ? googleApiClient.getLooper() : Looper.getMainLooper());
        this.zzfow = new WeakReference(googleApiClient);
    }

    private final R get() {
        R r;
        synchronized (this.zzfou) {
            zzbq.zza(this.zzfpa ^ true, (Object) "Result has already been consumed.");
            zzbq.zza(isReady(), (Object) "Result is not ready.");
            r = this.zzfne;
            this.zzfne = null;
            this.zzfoy = null;
            this.zzfpa = true;
        }
        zzdm com_google_android_gms_common_api_internal_zzdm = (zzdm) this.zzfoz.getAndSet(null);
        if (com_google_android_gms_common_api_internal_zzdm != null) {
            com_google_android_gms_common_api_internal_zzdm.zzc(this);
        }
        return r;
    }

    private final void zzc(R r) {
        this.zzfne = r;
        this.zzfpc = null;
        this.zzapd.countDown();
        this.mStatus = this.zzfne.getStatus();
        if (this.zzan) {
            this.zzfoy = null;
        } else if (this.zzfoy != null) {
            this.zzfov.removeMessages(2);
            this.zzfov.zza(this.zzfoy, get());
        } else if (this.zzfne instanceof Releasable) {
            this.mResultGuardian = new zzb();
        }
        ArrayList arrayList = this.zzfox;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            ((com.google.android.gms.common.api.PendingResult.zza) obj).zzr(this.mStatus);
        }
        this.zzfox.clear();
    }

    public static void zzd(Result result) {
        if (result instanceof Releasable) {
            try {
                ((Releasable) result).release();
            } catch (Throwable e) {
                String valueOf = String.valueOf(result);
                StringBuilder stringBuilder = new StringBuilder(18 + String.valueOf(valueOf).length());
                stringBuilder.append("Unable to release ");
                stringBuilder.append(valueOf);
                Log.w("BasePendingResult", stringBuilder.toString(), e);
            }
        }
    }

    public final R await() {
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
        r0 = "await must not be called on the UI thread";
        com.google.android.gms.common.internal.zzbq.zzgn(r0);
        r0 = r3.zzfpa;
        r1 = 1;
        r0 = r0 ^ r1;
        r2 = "Result has already been consumed";
        com.google.android.gms.common.internal.zzbq.zza(r0, r2);
        r0 = r3.zzfpd;
        if (r0 != 0) goto L_0x0013;
    L_0x0012:
        goto L_0x0014;
    L_0x0013:
        r1 = 0;
    L_0x0014:
        r0 = "Cannot await if then() has been called.";
        com.google.android.gms.common.internal.zzbq.zza(r1, r0);
        r0 = r3.zzapd;	 Catch:{ InterruptedException -> 0x001f }
        r0.await();	 Catch:{ InterruptedException -> 0x001f }
        goto L_0x0024;
    L_0x001f:
        r0 = com.google.android.gms.common.api.Status.zzfnj;
        r3.zzv(r0);
    L_0x0024:
        r0 = r3.isReady();
        r1 = "Result is not ready.";
        com.google.android.gms.common.internal.zzbq.zza(r0, r1);
        r0 = r3.get();
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.internal.BasePendingResult.await():R");
    }

    public final R await(long r4, java.util.concurrent.TimeUnit r6) {
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
        r0 = 0;
        r0 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1));
        if (r0 <= 0) goto L_0x000b;
    L_0x0006:
        r0 = "await must not be called on the UI thread when time is greater than zero.";
        com.google.android.gms.common.internal.zzbq.zzgn(r0);
    L_0x000b:
        r0 = r3.zzfpa;
        r1 = 1;
        r0 = r0 ^ r1;
        r2 = "Result has already been consumed.";
        com.google.android.gms.common.internal.zzbq.zza(r0, r2);
        r0 = r3.zzfpd;
        if (r0 != 0) goto L_0x0019;
    L_0x0018:
        goto L_0x001a;
    L_0x0019:
        r1 = 0;
    L_0x001a:
        r0 = "Cannot await if then() has been called.";
        com.google.android.gms.common.internal.zzbq.zza(r1, r0);
        r0 = r3.zzapd;	 Catch:{ InterruptedException -> 0x002d }
        r4 = r0.await(r4, r6);	 Catch:{ InterruptedException -> 0x002d }
        if (r4 != 0) goto L_0x0032;	 Catch:{ InterruptedException -> 0x002d }
    L_0x0027:
        r4 = com.google.android.gms.common.api.Status.zzfnl;	 Catch:{ InterruptedException -> 0x002d }
        r3.zzv(r4);	 Catch:{ InterruptedException -> 0x002d }
        goto L_0x0032;
    L_0x002d:
        r4 = com.google.android.gms.common.api.Status.zzfnj;
        r3.zzv(r4);
    L_0x0032:
        r4 = r3.isReady();
        r5 = "Result is not ready.";
        com.google.android.gms.common.internal.zzbq.zza(r4, r5);
        r4 = r3.get();
        return r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.internal.BasePendingResult.await(long, java.util.concurrent.TimeUnit):R");
    }

    public void cancel() {
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
        r2 = this;
        r0 = r2.zzfou;
        monitor-enter(r0);
        r1 = r2.zzan;	 Catch:{ all -> 0x002a }
        if (r1 != 0) goto L_0x0028;	 Catch:{ all -> 0x002a }
    L_0x0007:
        r1 = r2.zzfpa;	 Catch:{ all -> 0x002a }
        if (r1 == 0) goto L_0x000c;	 Catch:{ all -> 0x002a }
    L_0x000b:
        goto L_0x0028;	 Catch:{ all -> 0x002a }
    L_0x000c:
        r1 = r2.zzfpc;	 Catch:{ all -> 0x002a }
        if (r1 == 0) goto L_0x0015;
    L_0x0010:
        r1 = r2.zzfpc;	 Catch:{ RemoteException -> 0x0015 }
        r1.cancel();	 Catch:{ RemoteException -> 0x0015 }
    L_0x0015:
        r1 = r2.zzfne;	 Catch:{ all -> 0x002a }
        zzd(r1);	 Catch:{ all -> 0x002a }
        r1 = 1;	 Catch:{ all -> 0x002a }
        r2.zzan = r1;	 Catch:{ all -> 0x002a }
        r1 = com.google.android.gms.common.api.Status.zzfnm;	 Catch:{ all -> 0x002a }
        r1 = r2.zzb(r1);	 Catch:{ all -> 0x002a }
        r2.zzc(r1);	 Catch:{ all -> 0x002a }
        monitor-exit(r0);	 Catch:{ all -> 0x002a }
        return;	 Catch:{ all -> 0x002a }
    L_0x0028:
        monitor-exit(r0);	 Catch:{ all -> 0x002a }
        return;	 Catch:{ all -> 0x002a }
    L_0x002a:
        r1 = move-exception;	 Catch:{ all -> 0x002a }
        monitor-exit(r0);	 Catch:{ all -> 0x002a }
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.internal.BasePendingResult.cancel():void");
    }

    public boolean isCanceled() {
        boolean z;
        synchronized (this.zzfou) {
            z = this.zzan;
        }
        return z;
    }

    public final boolean isReady() {
        return this.zzapd.getCount() == 0;
    }

    public final void setResult(R r) {
        synchronized (this.zzfou) {
            if (this.zzfpb || this.zzan) {
                zzd(r);
                return;
            }
            isReady();
            zzbq.zza(isReady() ^ 1, (Object) "Results have already been set");
            zzbq.zza(this.zzfpa ^ 1, (Object) "Result has already been consumed");
            zzc(r);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void setResultCallback(com.google.android.gms.common.api.ResultCallback<? super R> r5) {
        /*
        r4 = this;
        r0 = r4.zzfou;
        monitor-enter(r0);
        if (r5 != 0) goto L_0x000c;
    L_0x0005:
        r5 = 0;
        r4.zzfoy = r5;	 Catch:{ all -> 0x000a }
        monitor-exit(r0);	 Catch:{ all -> 0x000a }
        return;
    L_0x000a:
        r5 = move-exception;
        goto L_0x003c;
    L_0x000c:
        r1 = r4.zzfpa;	 Catch:{ all -> 0x000a }
        r2 = 1;
        r1 = r1 ^ r2;
        r3 = "Result has already been consumed.";
        com.google.android.gms.common.internal.zzbq.zza(r1, r3);	 Catch:{ all -> 0x000a }
        r1 = r4.zzfpd;	 Catch:{ all -> 0x000a }
        if (r1 != 0) goto L_0x001a;
    L_0x0019:
        goto L_0x001b;
    L_0x001a:
        r2 = 0;
    L_0x001b:
        r1 = "Cannot set callbacks if then() has been called.";
        com.google.android.gms.common.internal.zzbq.zza(r2, r1);	 Catch:{ all -> 0x000a }
        r1 = r4.isCanceled();	 Catch:{ all -> 0x000a }
        if (r1 == 0) goto L_0x0028;
    L_0x0026:
        monitor-exit(r0);	 Catch:{ all -> 0x000a }
        return;
    L_0x0028:
        r1 = r4.isReady();	 Catch:{ all -> 0x000a }
        if (r1 == 0) goto L_0x0038;
    L_0x002e:
        r1 = r4.zzfov;	 Catch:{ all -> 0x000a }
        r2 = r4.get();	 Catch:{ all -> 0x000a }
        r1.zza(r5, r2);	 Catch:{ all -> 0x000a }
        goto L_0x003a;
    L_0x0038:
        r4.zzfoy = r5;	 Catch:{ all -> 0x000a }
    L_0x003a:
        monitor-exit(r0);	 Catch:{ all -> 0x000a }
        return;
    L_0x003c:
        monitor-exit(r0);	 Catch:{ all -> 0x000a }
        throw r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.internal.BasePendingResult.setResultCallback(com.google.android.gms.common.api.ResultCallback):void");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void setResultCallback(com.google.android.gms.common.api.ResultCallback<? super R> r5, long r6, java.util.concurrent.TimeUnit r8) {
        /*
        r4 = this;
        r0 = r4.zzfou;
        monitor-enter(r0);
        if (r5 != 0) goto L_0x000c;
    L_0x0005:
        r5 = 0;
        r4.zzfoy = r5;	 Catch:{ all -> 0x000a }
        monitor-exit(r0);	 Catch:{ all -> 0x000a }
        return;
    L_0x000a:
        r5 = move-exception;
        goto L_0x004a;
    L_0x000c:
        r1 = r4.zzfpa;	 Catch:{ all -> 0x000a }
        r2 = 1;
        r1 = r1 ^ r2;
        r3 = "Result has already been consumed.";
        com.google.android.gms.common.internal.zzbq.zza(r1, r3);	 Catch:{ all -> 0x000a }
        r1 = r4.zzfpd;	 Catch:{ all -> 0x000a }
        if (r1 != 0) goto L_0x001a;
    L_0x0019:
        goto L_0x001b;
    L_0x001a:
        r2 = 0;
    L_0x001b:
        r1 = "Cannot set callbacks if then() has been called.";
        com.google.android.gms.common.internal.zzbq.zza(r2, r1);	 Catch:{ all -> 0x000a }
        r1 = r4.isCanceled();	 Catch:{ all -> 0x000a }
        if (r1 == 0) goto L_0x0028;
    L_0x0026:
        monitor-exit(r0);	 Catch:{ all -> 0x000a }
        return;
    L_0x0028:
        r1 = r4.isReady();	 Catch:{ all -> 0x000a }
        if (r1 == 0) goto L_0x0038;
    L_0x002e:
        r6 = r4.zzfov;	 Catch:{ all -> 0x000a }
        r7 = r4.get();	 Catch:{ all -> 0x000a }
        r6.zza(r5, r7);	 Catch:{ all -> 0x000a }
        goto L_0x0048;
    L_0x0038:
        r4.zzfoy = r5;	 Catch:{ all -> 0x000a }
        r5 = r4.zzfov;	 Catch:{ all -> 0x000a }
        r6 = r8.toMillis(r6);	 Catch:{ all -> 0x000a }
        r8 = 2;
        r8 = r5.obtainMessage(r8, r4);	 Catch:{ all -> 0x000a }
        r5.sendMessageDelayed(r8, r6);	 Catch:{ all -> 0x000a }
    L_0x0048:
        monitor-exit(r0);	 Catch:{ all -> 0x000a }
        return;
    L_0x004a:
        monitor-exit(r0);	 Catch:{ all -> 0x000a }
        throw r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.internal.BasePendingResult.setResultCallback(com.google.android.gms.common.api.ResultCallback, long, java.util.concurrent.TimeUnit):void");
    }

    public <S extends Result> TransformedResult<S> then(ResultTransform<? super R, ? extends S> resultTransform) {
        TransformedResult<S> then;
        zzbq.zza(this.zzfpa ^ true, (Object) "Result has already been consumed.");
        synchronized (this.zzfou) {
            boolean z = false;
            zzbq.zza(this.zzfpd == null, (Object) "Cannot call then() twice.");
            if (this.zzfoy == null) {
                z = true;
            }
            zzbq.zza(z, (Object) "Cannot call then() if callbacks are set.");
            zzbq.zza(this.zzan ^ true, (Object) "Cannot call then() if result was canceled.");
            this.zzfpe = true;
            this.zzfpd = new zzdg(this.zzfow);
            then = this.zzfpd.then(resultTransform);
            if (isReady()) {
                this.zzfov.zza(this.zzfpd, get());
            } else {
                this.zzfoy = this.zzfpd;
            }
        }
        return then;
    }

    public final void zza(com.google.android.gms.common.api.PendingResult.zza com_google_android_gms_common_api_PendingResult_zza) {
        zzbq.checkArgument(com_google_android_gms_common_api_PendingResult_zza != null, "Callback cannot be null.");
        synchronized (this.zzfou) {
            if (isReady()) {
                com_google_android_gms_common_api_PendingResult_zza.zzr(this.mStatus);
            } else {
                this.zzfox.add(com_google_android_gms_common_api_PendingResult_zza);
            }
        }
    }

    public final void zza(zzdm com_google_android_gms_common_api_internal_zzdm) {
        this.zzfoz.set(com_google_android_gms_common_api_internal_zzdm);
    }

    protected final void zza(zzaq com_google_android_gms_common_internal_zzaq) {
        synchronized (this.zzfou) {
            this.zzfpc = com_google_android_gms_common_internal_zzaq;
        }
    }

    public final Integer zzagv() {
        return null;
    }

    public final boolean zzahh() {
        boolean isCanceled;
        synchronized (this.zzfou) {
            if (((GoogleApiClient) this.zzfow.get()) == null || !this.zzfpe) {
                cancel();
            }
            isCanceled = isCanceled();
        }
        return isCanceled;
    }

    public final void zzahi() {
        boolean z;
        if (!this.zzfpe) {
            if (!((Boolean) zzfot.get()).booleanValue()) {
                z = false;
                this.zzfpe = z;
            }
        }
        z = true;
        this.zzfpe = z;
    }

    @NonNull
    protected abstract R zzb(Status status);

    public final void zzv(Status status) {
        synchronized (this.zzfou) {
            if (!isReady()) {
                setResult(zzb(status));
                this.zzfpb = true;
            }
        }
    }
}
