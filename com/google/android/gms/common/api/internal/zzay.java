package com.google.android.gms.common.api.internal;

import android.support.annotation.WorkerThread;

abstract class zzay implements Runnable {
    private /* synthetic */ zzao zzfrl;

    private zzay(zzao com_google_android_gms_common_api_internal_zzao) {
        this.zzfrl = com_google_android_gms_common_api_internal_zzao;
    }

    @WorkerThread
    public void run() {
        this.zzfrl.zzfps.lock();
        try {
            if (!Thread.interrupted()) {
                zzaib();
            }
        } catch (RuntimeException e) {
            this.zzfrl.zzfqv.zza(e);
        } catch (Throwable th) {
            this.zzfrl.zzfps.unlock();
        }
        this.zzfrl.zzfps.unlock();
    }

    @WorkerThread
    protected abstract void zzaib();
}
