package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.HashSet;
import java.util.Set;

final class zzaj implements ServiceConnection {
    private ComponentName mComponentName;
    private int mState = 2;
    private IBinder zzfzf;
    private final Set<ServiceConnection> zzgaq = new HashSet();
    private boolean zzgar;
    private final zzah zzgas;
    private /* synthetic */ zzai zzgat;

    public zzaj(zzai com_google_android_gms_common_internal_zzai, zzah com_google_android_gms_common_internal_zzah) {
        this.zzgat = com_google_android_gms_common_internal_zzai;
        this.zzgas = com_google_android_gms_common_internal_zzah;
    }

    public final IBinder getBinder() {
        return this.zzfzf;
    }

    public final ComponentName getComponentName() {
        return this.mComponentName;
    }

    public final int getState() {
        return this.mState;
    }

    public final boolean isBound() {
        return this.zzgar;
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        synchronized (this.zzgat.zzgam) {
            this.zzgat.mHandler.removeMessages(1, this.zzgas);
            this.zzfzf = iBinder;
            this.mComponentName = componentName;
            for (ServiceConnection onServiceConnected : this.zzgaq) {
                onServiceConnected.onServiceConnected(componentName, iBinder);
            }
            this.mState = 1;
        }
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        synchronized (this.zzgat.zzgam) {
            this.zzgat.mHandler.removeMessages(1, this.zzgas);
            this.zzfzf = null;
            this.mComponentName = componentName;
            for (ServiceConnection onServiceDisconnected : this.zzgaq) {
                onServiceDisconnected.onServiceDisconnected(componentName);
            }
            this.mState = 2;
        }
    }

    public final void zza(ServiceConnection serviceConnection, String str) {
        this.zzgat.zzgan;
        this.zzgat.mApplicationContext;
        this.zzgas.zzall();
        this.zzgaq.add(serviceConnection);
    }

    public final boolean zza(ServiceConnection serviceConnection) {
        return this.zzgaq.contains(serviceConnection);
    }

    public final boolean zzalm() {
        return this.zzgaq.isEmpty();
    }

    public final void zzb(ServiceConnection serviceConnection, String str) {
        this.zzgat.zzgan;
        this.zzgat.mApplicationContext;
        this.zzgaq.remove(serviceConnection);
    }

    public final void zzgi(java.lang.String r8) {
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
        r7 = this;
        r0 = 3;
        r7.mState = r0;
        r0 = r7.zzgat;
        r1 = r0.zzgan;
        r0 = r7.zzgat;
        r2 = r0.mApplicationContext;
        r0 = r7.zzgas;
        r4 = r0.zzall();
        r0 = r7.zzgas;
        r6 = r0.zzalk();
        r3 = r8;
        r5 = r7;
        r8 = r1.zza(r2, r3, r4, r5, r6);
        r7.zzgar = r8;
        r8 = r7.zzgar;
        if (r8 == 0) goto L_0x0044;
    L_0x0027:
        r8 = r7.zzgat;
        r8 = r8.mHandler;
        r0 = 1;
        r1 = r7.zzgas;
        r8 = r8.obtainMessage(r0, r1);
        r0 = r7.zzgat;
        r0 = r0.mHandler;
        r1 = r7.zzgat;
        r1 = r1.zzgap;
        r0.sendMessageDelayed(r8, r1);
        return;
    L_0x0044:
        r8 = 2;
        r7.mState = r8;
        r8 = r7.zzgat;	 Catch:{ IllegalArgumentException -> 0x0055 }
        r8.zzgan;	 Catch:{ IllegalArgumentException -> 0x0055 }
        r8 = r7.zzgat;	 Catch:{ IllegalArgumentException -> 0x0055 }
        r8 = r8.mApplicationContext;	 Catch:{ IllegalArgumentException -> 0x0055 }
        r8.unbindService(r7);	 Catch:{ IllegalArgumentException -> 0x0055 }
    L_0x0055:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.internal.zzaj.zzgi(java.lang.String):void");
    }

    public final void zzgj(String str) {
        this.zzgat.mHandler.removeMessages(1, this.zzgas);
        this.zzgat.zzgan;
        this.zzgat.mApplicationContext.unbindService(this);
        this.zzgar = false;
        this.mState = 2;
    }
}
