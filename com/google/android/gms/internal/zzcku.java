package com.google.android.gms.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Looper;
import android.support.annotation.MainThread;
import android.support.annotation.NonNull;
import android.support.annotation.WorkerThread;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzg;
import com.google.android.gms.common.stats.zza;

public final class zzcku implements ServiceConnection, zzf, zzg {
    final /* synthetic */ zzckg zzjij;
    private volatile boolean zzjiq;
    private volatile zzchl zzjir;

    protected zzcku(zzckg com_google_android_gms_internal_zzckg) {
        this.zzjij = com_google_android_gms_internal_zzckg;
    }

    @android.support.annotation.MainThread
    public final void onConnected(@android.support.annotation.Nullable android.os.Bundle r4) {
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
        r4 = "MeasurementServiceConnection.onConnected";
        com.google.android.gms.common.internal.zzbq.zzge(r4);
        monitor-enter(r3);
        r4 = 0;
        r0 = r3.zzjir;	 Catch:{ DeadObjectException -> 0x0022, DeadObjectException -> 0x0022 }
        r0 = r0.zzakn();	 Catch:{ DeadObjectException -> 0x0022, DeadObjectException -> 0x0022 }
        r0 = (com.google.android.gms.internal.zzche) r0;	 Catch:{ DeadObjectException -> 0x0022, DeadObjectException -> 0x0022 }
        r3.zzjir = r4;	 Catch:{ DeadObjectException -> 0x0022, DeadObjectException -> 0x0022 }
        r1 = r3.zzjij;	 Catch:{ DeadObjectException -> 0x0022, DeadObjectException -> 0x0022 }
        r1 = r1.zzawx();	 Catch:{ DeadObjectException -> 0x0022, DeadObjectException -> 0x0022 }
        r2 = new com.google.android.gms.internal.zzckx;	 Catch:{ DeadObjectException -> 0x0022, DeadObjectException -> 0x0022 }
        r2.<init>(r3, r0);	 Catch:{ DeadObjectException -> 0x0022, DeadObjectException -> 0x0022 }
        r1.zzg(r2);	 Catch:{ DeadObjectException -> 0x0022, DeadObjectException -> 0x0022 }
        goto L_0x0027;
    L_0x0020:
        r4 = move-exception;
        goto L_0x0029;
    L_0x0022:
        r3.zzjir = r4;	 Catch:{ all -> 0x0020 }
        r4 = 0;	 Catch:{ all -> 0x0020 }
        r3.zzjiq = r4;	 Catch:{ all -> 0x0020 }
    L_0x0027:
        monitor-exit(r3);	 Catch:{ all -> 0x0020 }
        return;	 Catch:{ all -> 0x0020 }
    L_0x0029:
        monitor-exit(r3);	 Catch:{ all -> 0x0020 }
        throw r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzcku.onConnected(android.os.Bundle):void");
    }

    @MainThread
    public final void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        zzbq.zzge("MeasurementServiceConnection.onConnectionFailed");
        zzchm zzazx = this.zzjij.zziwf.zzazx();
        if (zzazx != null) {
            zzazx.zzazf().zzj("Service connection failed", connectionResult);
        }
        synchronized (this) {
            this.zzjiq = false;
            this.zzjir = null;
        }
        this.zzjij.zzawx().zzg(new zzckz(this));
    }

    @MainThread
    public final void onConnectionSuspended(int i) {
        zzbq.zzge("MeasurementServiceConnection.onConnectionSuspended");
        this.zzjij.zzawy().zzazi().log("Service connection suspended");
        this.zzjij.zzawx().zzg(new zzcky(this));
    }

    @android.support.annotation.MainThread
    public final void onServiceConnected(android.content.ComponentName r4, android.os.IBinder r5) {
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
        r4 = "MeasurementServiceConnection.onServiceConnected";
        com.google.android.gms.common.internal.zzbq.zzge(r4);
        monitor-enter(r3);
        r4 = 0;
        if (r5 != 0) goto L_0x001f;
    L_0x0009:
        r3.zzjiq = r4;	 Catch:{ all -> 0x001c }
        r4 = r3.zzjij;	 Catch:{ all -> 0x001c }
        r4 = r4.zzawy();	 Catch:{ all -> 0x001c }
        r4 = r4.zzazd();	 Catch:{ all -> 0x001c }
        r5 = "Service connected with null binder";	 Catch:{ all -> 0x001c }
        r4.log(r5);	 Catch:{ all -> 0x001c }
        monitor-exit(r3);	 Catch:{ all -> 0x001c }
        return;
    L_0x001c:
        r4 = move-exception;
        goto L_0x0099;
    L_0x001f:
        r0 = 0;
        r1 = r5.getInterfaceDescriptor();	 Catch:{ RemoteException -> 0x0063 }
        r2 = "com.google.android.gms.measurement.internal.IMeasurementService";	 Catch:{ RemoteException -> 0x0063 }
        r2 = r2.equals(r1);	 Catch:{ RemoteException -> 0x0063 }
        if (r2 == 0) goto L_0x0053;	 Catch:{ RemoteException -> 0x0063 }
    L_0x002c:
        if (r5 != 0) goto L_0x002f;	 Catch:{ RemoteException -> 0x0063 }
    L_0x002e:
        goto L_0x0043;	 Catch:{ RemoteException -> 0x0063 }
    L_0x002f:
        r1 = "com.google.android.gms.measurement.internal.IMeasurementService";	 Catch:{ RemoteException -> 0x0063 }
        r1 = r5.queryLocalInterface(r1);	 Catch:{ RemoteException -> 0x0063 }
        r2 = r1 instanceof com.google.android.gms.internal.zzche;	 Catch:{ RemoteException -> 0x0063 }
        if (r2 == 0) goto L_0x003d;	 Catch:{ RemoteException -> 0x0063 }
    L_0x0039:
        r1 = (com.google.android.gms.internal.zzche) r1;	 Catch:{ RemoteException -> 0x0063 }
    L_0x003b:
        r0 = r1;	 Catch:{ RemoteException -> 0x0063 }
        goto L_0x0043;	 Catch:{ RemoteException -> 0x0063 }
    L_0x003d:
        r1 = new com.google.android.gms.internal.zzchg;	 Catch:{ RemoteException -> 0x0063 }
        r1.<init>(r5);	 Catch:{ RemoteException -> 0x0063 }
        goto L_0x003b;	 Catch:{ RemoteException -> 0x0063 }
    L_0x0043:
        r5 = r3.zzjij;	 Catch:{ RemoteException -> 0x0063 }
        r5 = r5.zzawy();	 Catch:{ RemoteException -> 0x0063 }
        r5 = r5.zzazj();	 Catch:{ RemoteException -> 0x0063 }
        r1 = "Bound to IMeasurementService interface";	 Catch:{ RemoteException -> 0x0063 }
        r5.log(r1);	 Catch:{ RemoteException -> 0x0063 }
        goto L_0x0072;	 Catch:{ RemoteException -> 0x0063 }
    L_0x0053:
        r5 = r3.zzjij;	 Catch:{ RemoteException -> 0x0063 }
        r5 = r5.zzawy();	 Catch:{ RemoteException -> 0x0063 }
        r5 = r5.zzazd();	 Catch:{ RemoteException -> 0x0063 }
        r2 = "Got binder with a wrong descriptor";	 Catch:{ RemoteException -> 0x0063 }
        r5.zzj(r2, r1);	 Catch:{ RemoteException -> 0x0063 }
        goto L_0x0072;
    L_0x0063:
        r5 = r3.zzjij;	 Catch:{ all -> 0x001c }
        r5 = r5.zzawy();	 Catch:{ all -> 0x001c }
        r5 = r5.zzazd();	 Catch:{ all -> 0x001c }
        r1 = "Service connect failed to get IMeasurementService";	 Catch:{ all -> 0x001c }
        r5.log(r1);	 Catch:{ all -> 0x001c }
    L_0x0072:
        if (r0 != 0) goto L_0x0089;	 Catch:{ all -> 0x001c }
    L_0x0074:
        r3.zzjiq = r4;	 Catch:{ all -> 0x001c }
        com.google.android.gms.common.stats.zza.zzamc();	 Catch:{ IllegalArgumentException -> 0x0097 }
        r4 = r3.zzjij;	 Catch:{ IllegalArgumentException -> 0x0097 }
        r4 = r4.getContext();	 Catch:{ IllegalArgumentException -> 0x0097 }
        r5 = r3.zzjij;	 Catch:{ IllegalArgumentException -> 0x0097 }
        r5 = r5.zzjic;	 Catch:{ IllegalArgumentException -> 0x0097 }
        r4.unbindService(r5);	 Catch:{ IllegalArgumentException -> 0x0097 }
        goto L_0x0097;
    L_0x0089:
        r4 = r3.zzjij;	 Catch:{ all -> 0x001c }
        r4 = r4.zzawx();	 Catch:{ all -> 0x001c }
        r5 = new com.google.android.gms.internal.zzckv;	 Catch:{ all -> 0x001c }
        r5.<init>(r3, r0);	 Catch:{ all -> 0x001c }
        r4.zzg(r5);	 Catch:{ all -> 0x001c }
    L_0x0097:
        monitor-exit(r3);	 Catch:{ all -> 0x001c }
        return;	 Catch:{ all -> 0x001c }
    L_0x0099:
        monitor-exit(r3);	 Catch:{ all -> 0x001c }
        throw r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzcku.onServiceConnected(android.content.ComponentName, android.os.IBinder):void");
    }

    @MainThread
    public final void onServiceDisconnected(ComponentName componentName) {
        zzbq.zzge("MeasurementServiceConnection.onServiceDisconnected");
        this.zzjij.zzawy().zzazi().log("Service disconnected");
        this.zzjij.zzawx().zzg(new zzckw(this, componentName));
    }

    @WorkerThread
    public final void zzbau() {
        this.zzjij.zzve();
        Context context = this.zzjij.getContext();
        synchronized (this) {
            if (this.zzjiq) {
                this.zzjij.zzawy().zzazj().log("Connection attempt already in progress");
            } else if (this.zzjir != null) {
                this.zzjij.zzawy().zzazj().log("Already awaiting connection attempt");
            } else {
                this.zzjir = new zzchl(context, Looper.getMainLooper(), this, this);
                this.zzjij.zzawy().zzazj().log("Connecting to remote service");
                this.zzjiq = true;
                this.zzjir.zzakj();
            }
        }
    }

    @WorkerThread
    public final void zzn(Intent intent) {
        this.zzjij.zzve();
        Context context = this.zzjij.getContext();
        zza zzamc = zza.zzamc();
        synchronized (this) {
            if (this.zzjiq) {
                this.zzjij.zzawy().zzazj().log("Connection attempt already in progress");
                return;
            }
            this.zzjij.zzawy().zzazj().log("Using local app measurement service");
            this.zzjiq = true;
            zzamc.zza(context, intent, this.zzjij.zzjic, 129);
        }
    }
}
