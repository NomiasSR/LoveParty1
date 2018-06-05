package com.google.android.gms.common.api.internal;

import android.os.Looper;
import android.support.annotation.NonNull;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.common.internal.zzj;
import java.lang.ref.WeakReference;

final class zzaq implements zzj {
    private final Api<?> zzfin;
    private final boolean zzfpg;
    private final WeakReference<zzao> zzfrm;

    public zzaq(zzao com_google_android_gms_common_api_internal_zzao, Api<?> api, boolean z) {
        this.zzfrm = new WeakReference(com_google_android_gms_common_api_internal_zzao);
        this.zzfin = api;
        this.zzfpg = z;
    }

    public final void zzf(@NonNull ConnectionResult connectionResult) {
        zzao com_google_android_gms_common_api_internal_zzao = (zzao) this.zzfrm.get();
        if (com_google_android_gms_common_api_internal_zzao != null) {
            zzbq.zza(Looper.myLooper() == com_google_android_gms_common_api_internal_zzao.zzfqv.zzfpi.getLooper(), (Object) "onReportServiceBinding must be called on the GoogleApiClient handler thread");
            com_google_android_gms_common_api_internal_zzao.zzfps.lock();
            try {
                if (com_google_android_gms_common_api_internal_zzao.zzbt(0)) {
                    if (!connectionResult.isSuccess()) {
                        com_google_android_gms_common_api_internal_zzao.zzb(connectionResult, this.zzfin, this.zzfpg);
                    }
                    if (com_google_android_gms_common_api_internal_zzao.zzaic()) {
                        com_google_android_gms_common_api_internal_zzao.zzaid();
                    }
                }
                com_google_android_gms_common_api_internal_zzao.zzfps.unlock();
            } catch (Throwable th) {
                com_google_android_gms_common_api_internal_zzao.zzfps.unlock();
            }
        }
    }
}
