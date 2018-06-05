package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.support.v4.os.EnvironmentCompat;
import android.util.Log;
import com.google.android.gms.common.stats.zza;
import java.util.HashMap;

final class zzai extends zzag implements Callback {
    private final Context mApplicationContext;
    private final Handler mHandler;
    private final HashMap<zzah, zzaj> zzgam = new HashMap();
    private final zza zzgan;
    private final long zzgao;
    private final long zzgap;

    zzai(Context context) {
        this.mApplicationContext = context.getApplicationContext();
        this.mHandler = new Handler(context.getMainLooper(), this);
        this.zzgan = zza.zzamc();
        this.zzgao = 5000;
        this.zzgap = 300000;
    }

    public final boolean handleMessage(Message message) {
        zzah com_google_android_gms_common_internal_zzah;
        zzaj com_google_android_gms_common_internal_zzaj;
        switch (message.what) {
            case 0:
                synchronized (this.zzgam) {
                    com_google_android_gms_common_internal_zzah = (zzah) message.obj;
                    com_google_android_gms_common_internal_zzaj = (zzaj) this.zzgam.get(com_google_android_gms_common_internal_zzah);
                    if (com_google_android_gms_common_internal_zzaj != null && com_google_android_gms_common_internal_zzaj.zzalm()) {
                        if (com_google_android_gms_common_internal_zzaj.isBound()) {
                            com_google_android_gms_common_internal_zzaj.zzgj("GmsClientSupervisor");
                        }
                        this.zzgam.remove(com_google_android_gms_common_internal_zzah);
                    }
                }
                return true;
            case 1:
                synchronized (this.zzgam) {
                    com_google_android_gms_common_internal_zzah = (zzah) message.obj;
                    com_google_android_gms_common_internal_zzaj = (zzaj) this.zzgam.get(com_google_android_gms_common_internal_zzah);
                    if (com_google_android_gms_common_internal_zzaj != null && com_google_android_gms_common_internal_zzaj.getState() == 3) {
                        String valueOf = String.valueOf(com_google_android_gms_common_internal_zzah);
                        StringBuilder stringBuilder = new StringBuilder(47 + String.valueOf(valueOf).length());
                        stringBuilder.append("Timeout waiting for ServiceConnection callback ");
                        stringBuilder.append(valueOf);
                        Log.wtf("GmsClientSupervisor", stringBuilder.toString(), new Exception());
                        ComponentName componentName = com_google_android_gms_common_internal_zzaj.getComponentName();
                        if (componentName == null) {
                            componentName = com_google_android_gms_common_internal_zzah.getComponentName();
                        }
                        if (componentName == null) {
                            componentName = new ComponentName(com_google_android_gms_common_internal_zzah.getPackage(), EnvironmentCompat.MEDIA_UNKNOWN);
                        }
                        com_google_android_gms_common_internal_zzaj.onServiceDisconnected(componentName);
                    }
                }
                return true;
            default:
                return false;
        }
    }

    protected final boolean zza(zzah com_google_android_gms_common_internal_zzah, ServiceConnection serviceConnection, String str) {
        boolean isBound;
        zzbq.checkNotNull(serviceConnection, "ServiceConnection must not be null");
        synchronized (this.zzgam) {
            zzaj com_google_android_gms_common_internal_zzaj = (zzaj) this.zzgam.get(com_google_android_gms_common_internal_zzah);
            if (com_google_android_gms_common_internal_zzaj != null) {
                this.mHandler.removeMessages(0, com_google_android_gms_common_internal_zzah);
                if (!com_google_android_gms_common_internal_zzaj.zza(serviceConnection)) {
                    com_google_android_gms_common_internal_zzaj.zza(serviceConnection, str);
                    switch (com_google_android_gms_common_internal_zzaj.getState()) {
                        case 1:
                            serviceConnection.onServiceConnected(com_google_android_gms_common_internal_zzaj.getComponentName(), com_google_android_gms_common_internal_zzaj.getBinder());
                            break;
                        case 2:
                            com_google_android_gms_common_internal_zzaj.zzgi(str);
                            break;
                        default:
                            break;
                    }
                }
                String valueOf = String.valueOf(com_google_android_gms_common_internal_zzah);
                StringBuilder stringBuilder = new StringBuilder(81 + String.valueOf(valueOf).length());
                stringBuilder.append("Trying to bind a GmsServiceConnection that was already connected before.  config=");
                stringBuilder.append(valueOf);
                throw new IllegalStateException(stringBuilder.toString());
            }
            com_google_android_gms_common_internal_zzaj = new zzaj(this, com_google_android_gms_common_internal_zzah);
            com_google_android_gms_common_internal_zzaj.zza(serviceConnection, str);
            com_google_android_gms_common_internal_zzaj.zzgi(str);
            this.zzgam.put(com_google_android_gms_common_internal_zzah, com_google_android_gms_common_internal_zzaj);
            isBound = com_google_android_gms_common_internal_zzaj.isBound();
        }
        return isBound;
    }

    protected final void zzb(zzah com_google_android_gms_common_internal_zzah, ServiceConnection serviceConnection, String str) {
        zzbq.checkNotNull(serviceConnection, "ServiceConnection must not be null");
        synchronized (this.zzgam) {
            zzaj com_google_android_gms_common_internal_zzaj = (zzaj) this.zzgam.get(com_google_android_gms_common_internal_zzah);
            String valueOf;
            StringBuilder stringBuilder;
            if (com_google_android_gms_common_internal_zzaj == null) {
                valueOf = String.valueOf(com_google_android_gms_common_internal_zzah);
                stringBuilder = new StringBuilder(50 + String.valueOf(valueOf).length());
                stringBuilder.append("Nonexistent connection status for service config: ");
                stringBuilder.append(valueOf);
                throw new IllegalStateException(stringBuilder.toString());
            } else if (com_google_android_gms_common_internal_zzaj.zza(serviceConnection)) {
                com_google_android_gms_common_internal_zzaj.zzb(serviceConnection, str);
                if (com_google_android_gms_common_internal_zzaj.zzalm()) {
                    this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(0, com_google_android_gms_common_internal_zzah), this.zzgao);
                }
            } else {
                valueOf = String.valueOf(com_google_android_gms_common_internal_zzah);
                stringBuilder = new StringBuilder(76 + String.valueOf(valueOf).length());
                stringBuilder.append("Trying to unbind a GmsServiceConnection  that was not bound before.  config=");
                stringBuilder.append(valueOf);
                throw new IllegalStateException(stringBuilder.toString());
            }
        }
    }
}
