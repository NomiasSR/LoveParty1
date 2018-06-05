package com.google.android.gms.common.api.internal;

import android.support.annotation.NonNull;
import android.support.v4.util.ArrayMap;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.AvailabilityException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import java.util.Collections;
import java.util.Map;

final class zzac implements OnCompleteListener<Map<zzh<?>, String>> {
    private /* synthetic */ zzaa zzfqm;

    private zzac(zzaa com_google_android_gms_common_api_internal_zzaa) {
        this.zzfqm = com_google_android_gms_common_api_internal_zzaa;
    }

    public final void onComplete(@NonNull Task<Map<zzh<?>, String>> task) {
        this.zzfqm.zzfps.lock();
        try {
            if (this.zzfqm.zzfqh) {
                if (task.isSuccessful()) {
                    this.zzfqm.zzfqi = new ArrayMap(this.zzfqm.zzfpy.size());
                    for (zzz zzagn : this.zzfqm.zzfpy.values()) {
                        this.zzfqm.zzfqi.put(zzagn.zzagn(), ConnectionResult.zzfkr);
                    }
                } else {
                    zzaa com_google_android_gms_common_api_internal_zzaa;
                    ConnectionResult zzf;
                    if (task.getException() instanceof AvailabilityException) {
                        AvailabilityException availabilityException = (AvailabilityException) task.getException();
                        if (this.zzfqm.zzfqf) {
                            this.zzfqm.zzfqi = new ArrayMap(this.zzfqm.zzfpy.size());
                            for (zzz com_google_android_gms_common_api_internal_zzz : this.zzfqm.zzfpy.values()) {
                                Map zzd;
                                zzh zzagn2 = com_google_android_gms_common_api_internal_zzz.zzagn();
                                Object connectionResult = availabilityException.getConnectionResult(com_google_android_gms_common_api_internal_zzz);
                                if (this.zzfqm.zza(com_google_android_gms_common_api_internal_zzz, (ConnectionResult) connectionResult)) {
                                    zzd = this.zzfqm.zzfqi;
                                    connectionResult = new ConnectionResult(16);
                                } else {
                                    zzd = this.zzfqm.zzfqi;
                                }
                                zzd.put(zzagn2, connectionResult);
                            }
                        } else {
                            this.zzfqm.zzfqi = availabilityException.zzagj();
                        }
                        com_google_android_gms_common_api_internal_zzaa = this.zzfqm;
                        zzf = this.zzfqm.zzaht();
                    } else {
                        Log.e("ConnectionlessGAC", "Unexpected availability exception", task.getException());
                        this.zzfqm.zzfqi = Collections.emptyMap();
                        com_google_android_gms_common_api_internal_zzaa = this.zzfqm;
                        zzf = new ConnectionResult(8);
                    }
                    com_google_android_gms_common_api_internal_zzaa.zzfql = zzf;
                }
                if (this.zzfqm.zzfqj != null) {
                    this.zzfqm.zzfqi.putAll(this.zzfqm.zzfqj);
                    this.zzfqm.zzfql = this.zzfqm.zzaht();
                }
                if (this.zzfqm.zzfql == null) {
                    this.zzfqm.zzahr();
                    this.zzfqm.zzahs();
                } else {
                    this.zzfqm.zzfqh = false;
                    this.zzfqm.zzfqb.zzc(this.zzfqm.zzfql);
                }
                this.zzfqm.zzfqd.signalAll();
            }
            this.zzfqm.zzfps.unlock();
        } catch (Throwable th) {
            this.zzfqm.zzfps.unlock();
        }
    }
}
