package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.WorkerThread;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.Api.zze;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.common.internal.zzbz;
import com.google.android.gms.common.internal.zzj;
import com.google.android.gms.internal.zzcxd;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public final class zzbo<O extends ApiOptions> implements ConnectionCallbacks, OnConnectionFailedListener, zzu {
    private final zzh<O> zzfmf;
    private final zze zzfpv;
    private boolean zzfrw;
    final /* synthetic */ zzbm zzfti;
    private final Queue<zza> zzftj = new LinkedList();
    private final zzb zzftk;
    private final zzae zzftl;
    private final Set<zzj> zzftm = new HashSet();
    private final Map<zzck<?>, zzcr> zzftn = new HashMap();
    private final int zzfto;
    private final zzcv zzftp;
    private ConnectionResult zzftq = null;

    @WorkerThread
    public zzbo(zzbm com_google_android_gms_common_api_internal_zzbm, GoogleApi<O> googleApi) {
        this.zzfti = com_google_android_gms_common_api_internal_zzbm;
        this.zzfpv = googleApi.zza(com_google_android_gms_common_api_internal_zzbm.mHandler.getLooper(), this);
        this.zzftk = this.zzfpv instanceof zzbz ? zzbz.zzals() : this.zzfpv;
        this.zzfmf = googleApi.zzagn();
        this.zzftl = new zzae();
        this.zzfto = googleApi.getInstanceId();
        if (this.zzfpv.zzaay()) {
            this.zzftp = googleApi.zza(com_google_android_gms_common_api_internal_zzbm.mContext, com_google_android_gms_common_api_internal_zzbm.mHandler);
        } else {
            this.zzftp = null;
        }
    }

    @android.support.annotation.WorkerThread
    private final void zzaiw() {
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
        r4 = this;
        r4.zzaiz();
        r0 = com.google.android.gms.common.ConnectionResult.zzfkr;
        r4.zzi(r0);
        r4.zzajb();
        r0 = r4.zzftn;
        r0 = r0.values();
        r0 = r0.iterator();
    L_0x0015:
        r1 = r0.hasNext();
        if (r1 == 0) goto L_0x0037;
    L_0x001b:
        r1 = r0.next();
        r1 = (com.google.android.gms.common.api.internal.zzcr) r1;
        r1 = r1.zzfnq;	 Catch:{ DeadObjectException -> 0x002e, RemoteException -> 0x0015 }
        r2 = r4.zzftk;	 Catch:{ DeadObjectException -> 0x002e, RemoteException -> 0x0015 }
        r3 = new com.google.android.gms.tasks.TaskCompletionSource;	 Catch:{ DeadObjectException -> 0x002e, RemoteException -> 0x0015 }
        r3.<init>();	 Catch:{ DeadObjectException -> 0x002e, RemoteException -> 0x0015 }
        r1.zzb(r2, r3);	 Catch:{ DeadObjectException -> 0x002e, RemoteException -> 0x0015 }
        goto L_0x0015;
    L_0x002e:
        r0 = 1;
        r4.onConnectionSuspended(r0);
        r0 = r4.zzfpv;
        r0.disconnect();
    L_0x0037:
        r0 = r4.zzfpv;
        r0 = r0.isConnected();
        if (r0 == 0) goto L_0x0053;
    L_0x003f:
        r0 = r4.zzftj;
        r0 = r0.isEmpty();
        if (r0 != 0) goto L_0x0053;
    L_0x0047:
        r0 = r4.zzftj;
        r0 = r0.remove();
        r0 = (com.google.android.gms.common.api.internal.zza) r0;
        r4.zzb(r0);
        goto L_0x0037;
    L_0x0053:
        r4.zzajc();
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.internal.zzbo.zzaiw():void");
    }

    @WorkerThread
    private final void zzaix() {
        zzaiz();
        this.zzfrw = true;
        this.zzftl.zzahw();
        this.zzfti.mHandler.sendMessageDelayed(Message.obtain(this.zzfti.mHandler, 9, this.zzfmf), this.zzfti.zzfry);
        this.zzfti.mHandler.sendMessageDelayed(Message.obtain(this.zzfti.mHandler, 11, this.zzfmf), this.zzfti.zzfrx);
        this.zzfti.zzftc = -1;
    }

    @WorkerThread
    private final void zzajb() {
        if (this.zzfrw) {
            this.zzfti.mHandler.removeMessages(11, this.zzfmf);
            this.zzfti.mHandler.removeMessages(9, this.zzfmf);
            this.zzfrw = false;
        }
    }

    private final void zzajc() {
        this.zzfti.mHandler.removeMessages(12, this.zzfmf);
        this.zzfti.mHandler.sendMessageDelayed(this.zzfti.mHandler.obtainMessage(12, this.zzfmf), this.zzfti.zzfta);
    }

    @android.support.annotation.WorkerThread
    private final void zzb(com.google.android.gms.common.api.internal.zza r3) {
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
        r0 = r2.zzftl;
        r1 = r2.zzaay();
        r3.zza(r0, r1);
        r3.zza(r2);	 Catch:{ DeadObjectException -> 0x000d }
        return;
    L_0x000d:
        r3 = 1;
        r2.onConnectionSuspended(r3);
        r3 = r2.zzfpv;
        r3.disconnect();
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.internal.zzbo.zzb(com.google.android.gms.common.api.internal.zza):void");
    }

    @WorkerThread
    private final void zzi(ConnectionResult connectionResult) {
        for (zzj com_google_android_gms_common_api_internal_zzj : this.zzftm) {
            String str = null;
            if (connectionResult == ConnectionResult.zzfkr) {
                str = this.zzfpv.zzagi();
            }
            com_google_android_gms_common_api_internal_zzj.zza(this.zzfmf, connectionResult, str);
        }
        this.zzftm.clear();
    }

    @WorkerThread
    public final void connect() {
        zzbq.zza(this.zzfti.mHandler);
        if (!this.zzfpv.isConnected() && !this.zzfpv.isConnecting()) {
            if (this.zzfpv.zzagg() && this.zzfti.zzftc != 0) {
                this.zzfti.zzftc = this.zzfti.zzfmy.isGooglePlayServicesAvailable(this.zzfti.mContext);
                if (this.zzfti.zzftc != 0) {
                    onConnectionFailed(new ConnectionResult(this.zzfti.zzftc, null));
                    return;
                }
            }
            zzj com_google_android_gms_common_api_internal_zzbu = new zzbu(this.zzfti, this.zzfpv, this.zzfmf);
            if (this.zzfpv.zzaay()) {
                this.zzftp.zza((zzcy) com_google_android_gms_common_api_internal_zzbu);
            }
            this.zzfpv.zza(com_google_android_gms_common_api_internal_zzbu);
        }
    }

    public final int getInstanceId() {
        return this.zzfto;
    }

    final boolean isConnected() {
        return this.zzfpv.isConnected();
    }

    public final void onConnected(@Nullable Bundle bundle) {
        if (Looper.myLooper() == this.zzfti.mHandler.getLooper()) {
            zzaiw();
        } else {
            this.zzfti.mHandler.post(new zzbp(this));
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    @android.support.annotation.WorkerThread
    public final void onConnectionFailed(@android.support.annotation.NonNull com.google.android.gms.common.ConnectionResult r5) {
        /*
        r4 = this;
        r0 = r4.zzfti;
        r0 = r0.mHandler;
        com.google.android.gms.common.internal.zzbq.zza(r0);
        r0 = r4.zzftp;
        if (r0 == 0) goto L_0x0012;
    L_0x000d:
        r0 = r4.zzftp;
        r0.zzajq();
    L_0x0012:
        r4.zzaiz();
        r0 = r4.zzfti;
        r1 = -1;
        r0.zzftc = r1;
        r4.zzi(r5);
        r0 = r5.getErrorCode();
        r1 = 4;
        if (r0 != r1) goto L_0x002d;
    L_0x0025:
        r5 = com.google.android.gms.common.api.internal.zzbm.zzfsz;
        r4.zzw(r5);
        return;
    L_0x002d:
        r0 = r4.zzftj;
        r0 = r0.isEmpty();
        if (r0 == 0) goto L_0x0038;
    L_0x0035:
        r4.zzftq = r5;
        return;
    L_0x0038:
        r0 = com.google.android.gms.common.api.internal.zzbm.sLock;
        monitor-enter(r0);
        r1 = r4.zzfti;	 Catch:{ all -> 0x00ca }
        r1 = r1.zzftf;	 Catch:{ all -> 0x00ca }
        if (r1 == 0) goto L_0x0060;
    L_0x0045:
        r1 = r4.zzfti;	 Catch:{ all -> 0x00ca }
        r1 = r1.zzftg;	 Catch:{ all -> 0x00ca }
        r2 = r4.zzfmf;	 Catch:{ all -> 0x00ca }
        r1 = r1.contains(r2);	 Catch:{ all -> 0x00ca }
        if (r1 == 0) goto L_0x0060;
    L_0x0053:
        r1 = r4.zzfti;	 Catch:{ all -> 0x00ca }
        r1 = r1.zzftf;	 Catch:{ all -> 0x00ca }
        r2 = r4.zzfto;	 Catch:{ all -> 0x00ca }
        r1.zzb(r5, r2);	 Catch:{ all -> 0x00ca }
        monitor-exit(r0);	 Catch:{ all -> 0x00ca }
        return;
    L_0x0060:
        monitor-exit(r0);	 Catch:{ all -> 0x00ca }
        r0 = r4.zzfti;
        r1 = r4.zzfto;
        r0 = r0.zzc(r5, r1);
        if (r0 != 0) goto L_0x00c9;
    L_0x006b:
        r5 = r5.getErrorCode();
        r0 = 18;
        if (r5 != r0) goto L_0x0076;
    L_0x0073:
        r5 = 1;
        r4.zzfrw = r5;
    L_0x0076:
        r5 = r4.zzfrw;
        if (r5 == 0) goto L_0x0098;
    L_0x007a:
        r5 = r4.zzfti;
        r5 = r5.mHandler;
        r0 = r4.zzfti;
        r0 = r0.mHandler;
        r1 = 9;
        r2 = r4.zzfmf;
        r0 = android.os.Message.obtain(r0, r1, r2);
        r1 = r4.zzfti;
        r1 = r1.zzfry;
        r5.sendMessageDelayed(r0, r1);
        return;
    L_0x0098:
        r5 = new com.google.android.gms.common.api.Status;
        r0 = 17;
        r1 = r4.zzfmf;
        r1 = r1.zzagy();
        r2 = 38;
        r3 = java.lang.String.valueOf(r1);
        r3 = r3.length();
        r2 = r2 + r3;
        r3 = new java.lang.StringBuilder;
        r3.<init>(r2);
        r2 = "API: ";
        r3.append(r2);
        r3.append(r1);
        r1 = " is not available on this device.";
        r3.append(r1);
        r1 = r3.toString();
        r5.<init>(r0, r1);
        r4.zzw(r5);
    L_0x00c9:
        return;
    L_0x00ca:
        r5 = move-exception;
        monitor-exit(r0);	 Catch:{ all -> 0x00ca }
        throw r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.internal.zzbo.onConnectionFailed(com.google.android.gms.common.ConnectionResult):void");
    }

    public final void onConnectionSuspended(int i) {
        if (Looper.myLooper() == this.zzfti.mHandler.getLooper()) {
            zzaix();
        } else {
            this.zzfti.mHandler.post(new zzbq(this));
        }
    }

    @WorkerThread
    public final void resume() {
        zzbq.zza(this.zzfti.mHandler);
        if (this.zzfrw) {
            connect();
        }
    }

    @WorkerThread
    public final void signOut() {
        zzbq.zza(this.zzfti.mHandler);
        zzw(zzbm.zzfsy);
        this.zzftl.zzahv();
        for (zzck com_google_android_gms_common_api_internal_zzf : (zzck[]) this.zzftn.keySet().toArray(new zzck[this.zzftn.size()])) {
            zza(new zzf(com_google_android_gms_common_api_internal_zzf, new TaskCompletionSource()));
        }
        zzi(new ConnectionResult(4));
        if (this.zzfpv.isConnected()) {
            this.zzfpv.zza(new zzbs(this));
        }
    }

    public final void zza(ConnectionResult connectionResult, Api<?> api, boolean z) {
        if (Looper.myLooper() == this.zzfti.mHandler.getLooper()) {
            onConnectionFailed(connectionResult);
        } else {
            this.zzfti.mHandler.post(new zzbr(this, connectionResult));
        }
    }

    @WorkerThread
    public final void zza(zza com_google_android_gms_common_api_internal_zza) {
        zzbq.zza(this.zzfti.mHandler);
        if (this.zzfpv.isConnected()) {
            zzb(com_google_android_gms_common_api_internal_zza);
            zzajc();
            return;
        }
        this.zzftj.add(com_google_android_gms_common_api_internal_zza);
        if (this.zzftq == null || !this.zzftq.hasResolution()) {
            connect();
        } else {
            onConnectionFailed(this.zzftq);
        }
    }

    @WorkerThread
    public final void zza(zzj com_google_android_gms_common_api_internal_zzj) {
        zzbq.zza(this.zzfti.mHandler);
        this.zzftm.add(com_google_android_gms_common_api_internal_zzj);
    }

    public final boolean zzaay() {
        return this.zzfpv.zzaay();
    }

    public final zze zzahp() {
        return this.zzfpv;
    }

    @WorkerThread
    public final void zzaij() {
        zzbq.zza(this.zzfti.mHandler);
        if (this.zzfrw) {
            zzajb();
            zzw(this.zzfti.zzfmy.isGooglePlayServicesAvailable(this.zzfti.mContext) == 18 ? new Status(8, "Connection timed out while waiting for Google Play services update to complete.") : new Status(8, "API failed to connect while resuming due to an unknown error."));
            this.zzfpv.disconnect();
        }
    }

    public final Map<zzck<?>, zzcr> zzaiy() {
        return this.zzftn;
    }

    @WorkerThread
    public final void zzaiz() {
        zzbq.zza(this.zzfti.mHandler);
        this.zzftq = null;
    }

    @WorkerThread
    public final ConnectionResult zzaja() {
        zzbq.zza(this.zzfti.mHandler);
        return this.zzftq;
    }

    @WorkerThread
    public final void zzajd() {
        zzbq.zza(this.zzfti.mHandler);
        if (this.zzfpv.isConnected() && this.zzftn.size() == 0) {
            if (this.zzftl.zzahu()) {
                zzajc();
                return;
            }
            this.zzfpv.disconnect();
        }
    }

    final zzcxd zzaje() {
        return this.zzftp == null ? null : this.zzftp.zzaje();
    }

    @WorkerThread
    public final void zzh(@NonNull ConnectionResult connectionResult) {
        zzbq.zza(this.zzfti.mHandler);
        this.zzfpv.disconnect();
        onConnectionFailed(connectionResult);
    }

    @WorkerThread
    public final void zzw(Status status) {
        zzbq.zza(this.zzfti.mHandler);
        for (zza zzs : this.zzftj) {
            zzs.zzs(status);
        }
        this.zzftj.clear();
    }
}
