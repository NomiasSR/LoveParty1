package com.google.android.gms.common.internal;

import android.util.Log;

public abstract class zzi<TListener> {
    private TListener zzfuk;
    private /* synthetic */ zzd zzfza;
    private boolean zzfzb = false;

    public zzi(zzd com_google_android_gms_common_internal_zzd, TListener tListener) {
        this.zzfza = com_google_android_gms_common_internal_zzd;
        this.zzfuk = tListener;
    }

    public final void removeListener() {
        synchronized (this) {
            this.zzfuk = null;
        }
    }

    public final void unregister() {
        removeListener();
        synchronized (this.zzfza.zzfyo) {
            this.zzfza.zzfyo.remove(this);
        }
    }

    public final void zzaks() {
        synchronized (this) {
            Object obj = this.zzfuk;
            if (this.zzfzb) {
                String valueOf = String.valueOf(this);
                StringBuilder stringBuilder = new StringBuilder(47 + String.valueOf(valueOf).length());
                stringBuilder.append("Callback proxy ");
                stringBuilder.append(valueOf);
                stringBuilder.append(" being reused. This is not safe.");
                Log.w("GmsClient", stringBuilder.toString());
            }
        }
        if (obj != null) {
            try {
                zzw(obj);
            } catch (RuntimeException e) {
                throw e;
            }
        }
        synchronized (this) {
            this.zzfzb = true;
        }
        unregister();
    }

    protected abstract void zzw(TListener tListener);
}
