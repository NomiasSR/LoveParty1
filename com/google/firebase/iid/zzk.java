package com.google.firebase.iid;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;
import android.util.SparseArray;
import com.google.android.gms.common.stats.zza;
import java.util.ArrayDeque;
import java.util.Queue;

final class zzk implements ServiceConnection {
    int state;
    final Messenger zznzb;
    zzp zznzc;
    final Queue<zzr<?>> zznzd;
    final SparseArray<zzr<?>> zznze;
    final /* synthetic */ zzi zznzf;

    private zzk(zzi com_google_firebase_iid_zzi) {
        this.zznzf = com_google_firebase_iid_zzi;
        this.state = 0;
        this.zznzb = new Messenger(new Handler(Looper.getMainLooper(), new zzl(this)));
        this.zznzd = new ArrayDeque();
        this.zznze = new SparseArray();
    }

    private final void zza(zzs com_google_firebase_iid_zzs) {
        for (zzr zzb : this.zznzd) {
            zzb.zzb(com_google_firebase_iid_zzs);
        }
        this.zznzd.clear();
        for (int i = 0; i < this.zznze.size(); i++) {
            ((zzr) this.zznze.valueAt(i)).zzb(com_google_firebase_iid_zzs);
        }
        this.zznze.clear();
    }

    private final void zzcjb() {
        this.zznzf.zznyy.execute(new zzn(this));
    }

    public final synchronized void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        if (Log.isLoggable("MessengerIpcClient", 2)) {
            Log.v("MessengerIpcClient", "Service connected");
        }
        if (iBinder == null) {
            zzm(0, "Null service connection");
            return;
        }
        try {
            this.zznzc = new zzp(iBinder);
            this.state = 2;
            zzcjb();
        } catch (RemoteException e) {
            zzm(0, e.getMessage());
        }
    }

    public final synchronized void onServiceDisconnected(ComponentName componentName) {
        if (Log.isLoggable("MessengerIpcClient", 2)) {
            Log.v("MessengerIpcClient", "Service disconnected");
        }
        zzm(2, "Service disconnected");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    final synchronized boolean zzb(com.google.firebase.iid.zzr r6) {
        /*
        r5 = this;
        monitor-enter(r5);
        r0 = r5.state;	 Catch:{ all -> 0x008e }
        r1 = 0;
        r2 = 1;
        switch(r0) {
            case 0: goto L_0x001e;
            case 1: goto L_0x0017;
            case 2: goto L_0x000d;
            case 3: goto L_0x000b;
            case 4: goto L_0x000b;
            default: goto L_0x0008;
        };	 Catch:{ all -> 0x008e }
    L_0x0008:
        r6 = new java.lang.IllegalStateException;	 Catch:{ all -> 0x008e }
        goto L_0x0075;
    L_0x000b:
        monitor-exit(r5);
        return r1;
    L_0x000d:
        r0 = r5.zznzd;	 Catch:{ all -> 0x008e }
        r0.add(r6);	 Catch:{ all -> 0x008e }
        r5.zzcjb();	 Catch:{ all -> 0x008e }
        monitor-exit(r5);
        return r2;
    L_0x0017:
        r0 = r5.zznzd;	 Catch:{ all -> 0x008e }
        r0.add(r6);	 Catch:{ all -> 0x008e }
        monitor-exit(r5);
        return r2;
    L_0x001e:
        r0 = r5.zznzd;	 Catch:{ all -> 0x008e }
        r0.add(r6);	 Catch:{ all -> 0x008e }
        r6 = r5.state;	 Catch:{ all -> 0x008e }
        if (r6 != 0) goto L_0x0029;
    L_0x0027:
        r6 = r2;
        goto L_0x002a;
    L_0x0029:
        r6 = r1;
    L_0x002a:
        com.google.android.gms.common.internal.zzbq.checkState(r6);	 Catch:{ all -> 0x008e }
        r6 = "MessengerIpcClient";
        r0 = 2;
        r6 = android.util.Log.isLoggable(r6, r0);	 Catch:{ all -> 0x008e }
        if (r6 == 0) goto L_0x003d;
    L_0x0036:
        r6 = "MessengerIpcClient";
        r0 = "Starting bind to GmsCore";
        android.util.Log.v(r6, r0);	 Catch:{ all -> 0x008e }
    L_0x003d:
        r5.state = r2;	 Catch:{ all -> 0x008e }
        r6 = new android.content.Intent;	 Catch:{ all -> 0x008e }
        r0 = "com.google.android.c2dm.intent.REGISTER";
        r6.<init>(r0);	 Catch:{ all -> 0x008e }
        r0 = "com.google.android.gms";
        r6.setPackage(r0);	 Catch:{ all -> 0x008e }
        r0 = com.google.android.gms.common.stats.zza.zzamc();	 Catch:{ all -> 0x008e }
        r3 = r5.zznzf;	 Catch:{ all -> 0x008e }
        r3 = r3.zzair;	 Catch:{ all -> 0x008e }
        r6 = r0.zza(r3, r6, r5, r2);	 Catch:{ all -> 0x008e }
        if (r6 != 0) goto L_0x0061;
    L_0x005b:
        r6 = "Unable to bind to service";
        r5.zzm(r1, r6);	 Catch:{ all -> 0x008e }
        goto L_0x0073;
    L_0x0061:
        r6 = r5.zznzf;	 Catch:{ all -> 0x008e }
        r6 = r6.zznyy;	 Catch:{ all -> 0x008e }
        r0 = new com.google.firebase.iid.zzm;	 Catch:{ all -> 0x008e }
        r0.<init>(r5);	 Catch:{ all -> 0x008e }
        r3 = 30;
        r1 = java.util.concurrent.TimeUnit.SECONDS;	 Catch:{ all -> 0x008e }
        r6.schedule(r0, r3, r1);	 Catch:{ all -> 0x008e }
    L_0x0073:
        monitor-exit(r5);
        return r2;
    L_0x0075:
        r0 = r5.state;	 Catch:{ all -> 0x008e }
        r1 = 26;
        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x008e }
        r2.<init>(r1);	 Catch:{ all -> 0x008e }
        r1 = "Unknown state: ";
        r2.append(r1);	 Catch:{ all -> 0x008e }
        r2.append(r0);	 Catch:{ all -> 0x008e }
        r0 = r2.toString();	 Catch:{ all -> 0x008e }
        r6.<init>(r0);	 Catch:{ all -> 0x008e }
        throw r6;	 Catch:{ all -> 0x008e }
    L_0x008e:
        r6 = move-exception;
        monitor-exit(r5);
        throw r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.iid.zzk.zzb(com.google.firebase.iid.zzr):boolean");
    }

    final synchronized void zzcjc() {
        if (this.state == 2 && this.zznzd.isEmpty() && this.zznze.size() == 0) {
            if (Log.isLoggable("MessengerIpcClient", 2)) {
                Log.v("MessengerIpcClient", "Finished handling requests, unbinding");
            }
            this.state = 3;
            zza.zzamc();
            this.zznzf.zzair.unbindService(this);
        }
    }

    final synchronized void zzcjd() {
        if (this.state == 1) {
            zzm(1, "Timed out while binding");
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    final boolean zzd(android.os.Message r5) {
        /*
        r4 = this;
        r0 = r5.arg1;
        r1 = "MessengerIpcClient";
        r2 = 3;
        r1 = android.util.Log.isLoggable(r1, r2);
        if (r1 == 0) goto L_0x0023;
    L_0x000b:
        r1 = "MessengerIpcClient";
        r2 = 41;
        r3 = new java.lang.StringBuilder;
        r3.<init>(r2);
        r2 = "Received response to request: ";
        r3.append(r2);
        r3.append(r0);
        r2 = r3.toString();
        android.util.Log.d(r1, r2);
    L_0x0023:
        monitor-enter(r4);
        r1 = r4.zznze;	 Catch:{ all -> 0x006f }
        r1 = r1.get(r0);	 Catch:{ all -> 0x006f }
        r1 = (com.google.firebase.iid.zzr) r1;	 Catch:{ all -> 0x006f }
        r2 = 1;
        if (r1 != 0) goto L_0x0049;
    L_0x002f:
        r5 = "MessengerIpcClient";
        r1 = 50;
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x006f }
        r3.<init>(r1);	 Catch:{ all -> 0x006f }
        r1 = "Received response for unknown request: ";
        r3.append(r1);	 Catch:{ all -> 0x006f }
        r3.append(r0);	 Catch:{ all -> 0x006f }
        r0 = r3.toString();	 Catch:{ all -> 0x006f }
        android.util.Log.w(r5, r0);	 Catch:{ all -> 0x006f }
        monitor-exit(r4);	 Catch:{ all -> 0x006f }
        return r2;
    L_0x0049:
        r3 = r4.zznze;	 Catch:{ all -> 0x006f }
        r3.remove(r0);	 Catch:{ all -> 0x006f }
        r4.zzcjc();	 Catch:{ all -> 0x006f }
        monitor-exit(r4);	 Catch:{ all -> 0x006f }
        r5 = r5.getData();
        r0 = "unsupported";
        r3 = 0;
        r0 = r5.getBoolean(r0, r3);
        if (r0 == 0) goto L_0x006b;
    L_0x005f:
        r5 = new com.google.firebase.iid.zzs;
        r0 = 4;
        r3 = "Not supported by GmsCore";
        r5.<init>(r0, r3);
        r1.zzb(r5);
        return r2;
    L_0x006b:
        r1.zzac(r5);
        return r2;
    L_0x006f:
        r5 = move-exception;
        monitor-exit(r4);	 Catch:{ all -> 0x006f }
        throw r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.iid.zzk.zzd(android.os.Message):boolean");
    }

    final synchronized void zzic(int i) {
        zzr com_google_firebase_iid_zzr = (zzr) this.zznze.get(i);
        if (com_google_firebase_iid_zzr != null) {
            StringBuilder stringBuilder = new StringBuilder(31);
            stringBuilder.append("Timing out request: ");
            stringBuilder.append(i);
            Log.w("MessengerIpcClient", stringBuilder.toString());
            this.zznze.remove(i);
            com_google_firebase_iid_zzr.zzb(new zzs(3, "Timed out waiting for response"));
            zzcjc();
        }
    }

    final synchronized void zzm(int i, String str) {
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            String str2 = "MessengerIpcClient";
            String str3 = "Disconnected: ";
            String valueOf = String.valueOf(str);
            Log.d(str2, valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3));
        }
        switch (this.state) {
            case 0:
                throw new IllegalStateException();
            case 1:
            case 2:
                if (Log.isLoggable("MessengerIpcClient", 2)) {
                    Log.v("MessengerIpcClient", "Unbinding service");
                }
                this.state = 4;
                zza.zzamc();
                this.zznzf.zzair.unbindService(this);
                zza(new zzs(i, str));
                return;
            case 3:
                this.state = 4;
                return;
            case 4:
                return;
            default:
                int i2 = this.state;
                StringBuilder stringBuilder = new StringBuilder(26);
                stringBuilder.append("Unknown state: ");
                stringBuilder.append(i2);
                throw new IllegalStateException(stringBuilder.toString());
        }
    }
}
