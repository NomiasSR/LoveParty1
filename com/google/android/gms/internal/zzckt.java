package com.google.android.gms.internal;

import android.os.RemoteException;
import java.util.concurrent.atomic.AtomicReference;

final class zzckt implements Runnable {
    private /* synthetic */ zzcgi zzjgn;
    private /* synthetic */ boolean zzjhf;
    private /* synthetic */ zzckg zzjij;
    private /* synthetic */ AtomicReference zzjik;

    zzckt(zzckg com_google_android_gms_internal_zzckg, AtomicReference atomicReference, zzcgi com_google_android_gms_internal_zzcgi, boolean z) {
        this.zzjij = com_google_android_gms_internal_zzckg;
        this.zzjik = atomicReference;
        this.zzjgn = com_google_android_gms_internal_zzcgi;
        this.zzjhf = z;
    }

    public final void run() {
        synchronized (this.zzjik) {
            Object obj;
            try {
                zzche zzd = this.zzjij.zzjid;
                if (zzd == null) {
                    this.zzjij.zzawy().zzazd().log("Failed to get user properties");
                    this.zzjik.notify();
                    return;
                }
                this.zzjik.set(zzd.zza(this.zzjgn, this.zzjhf));
                this.zzjij.zzxr();
                obj = this.zzjik;
                obj.notify();
            } catch (RemoteException e) {
                try {
                    this.zzjij.zzawy().zzazd().zzj("Failed to get user properties", e);
                    obj = this.zzjik;
                } catch (Throwable th) {
                    this.zzjik.notify();
                }
            }
        }
    }
}
