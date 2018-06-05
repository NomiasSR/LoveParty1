package com.google.android.gms.internal;

import android.app.Activity;
import android.support.annotation.MainThread;
import android.support.annotation.NonNull;
import android.util.Log;
import com.google.android.gms.common.api.internal.LifecycleCallback;
import com.google.android.gms.common.api.internal.zzce;
import com.google.android.gms.common.api.internal.zzcf;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class zzexo {
    private static final zzexo zzoln = new zzexo();
    private final Map<Object, zzexp> zzolo = new HashMap();
    private final Object zzolp = new Object();

    static class zza extends LifecycleCallback {
        private final List<zzexp> zzezo = new ArrayList();

        private zza(zzcf com_google_android_gms_common_api_internal_zzcf) {
            super(com_google_android_gms_common_api_internal_zzcf);
            this.zzfud.zza("StorageOnStopCallback", (LifecycleCallback) this);
        }

        public static zza zzt(Activity activity) {
            zzcf zzb = LifecycleCallback.zzb(new zzce(activity));
            zza com_google_android_gms_internal_zzexo_zza = (zza) zzb.zza("StorageOnStopCallback", zza.class);
            return com_google_android_gms_internal_zzexo_zza == null ? new zza(zzb) : com_google_android_gms_internal_zzexo_zza;
        }

        @MainThread
        public final void onStop() {
            ArrayList arrayList;
            synchronized (this.zzezo) {
                arrayList = new ArrayList(this.zzezo);
                this.zzezo.clear();
            }
            arrayList = arrayList;
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                zzexp com_google_android_gms_internal_zzexp = (zzexp) obj;
                if (com_google_android_gms_internal_zzexp != null) {
                    Log.d("StorageOnStopCallback", "removing subscription from activity.");
                    com_google_android_gms_internal_zzexp.zzbko().run();
                    zzexo.zzcme().zzcm(com_google_android_gms_internal_zzexp.zzcmf());
                }
            }
        }

        public final void zza(zzexp com_google_android_gms_internal_zzexp) {
            synchronized (this.zzezo) {
                this.zzezo.add(com_google_android_gms_internal_zzexp);
            }
        }

        public final void zzb(zzexp com_google_android_gms_internal_zzexp) {
            synchronized (this.zzezo) {
                this.zzezo.remove(com_google_android_gms_internal_zzexp);
            }
        }
    }

    private zzexo() {
    }

    @NonNull
    public static zzexo zzcme() {
        return zzoln;
    }

    public final void zza(@NonNull Activity activity, @NonNull Object obj, @NonNull Runnable runnable) {
        synchronized (this.zzolp) {
            zzexp com_google_android_gms_internal_zzexp = new zzexp(activity, runnable, obj);
            zza.zzt(activity).zza(com_google_android_gms_internal_zzexp);
            this.zzolo.put(obj, com_google_android_gms_internal_zzexp);
        }
    }

    public final void zzcm(@NonNull Object obj) {
        synchronized (this.zzolp) {
            zzexp com_google_android_gms_internal_zzexp = (zzexp) this.zzolo.get(obj);
            if (com_google_android_gms_internal_zzexp != null) {
                zza.zzt(com_google_android_gms_internal_zzexp.getActivity()).zzb(com_google_android_gms_internal_zzexp);
            }
        }
    }
}
