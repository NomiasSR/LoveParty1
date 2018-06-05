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

final class zzad implements OnCompleteListener<Map<zzh<?>, String>> {
    private /* synthetic */ zzaa zzfqm;
    private zzcu zzfqn;

    zzad(zzaa com_google_android_gms_common_api_internal_zzaa, zzcu com_google_android_gms_common_api_internal_zzcu) {
        this.zzfqm = com_google_android_gms_common_api_internal_zzaa;
        this.zzfqn = com_google_android_gms_common_api_internal_zzcu;
    }

    final void cancel() {
        this.zzfqn.zzabi();
    }

    public final void onComplete(@NonNull Task<Map<zzh<?>, String>> task) {
        this.zzfqm.zzfps.lock();
        try {
            zzcu com_google_android_gms_common_api_internal_zzcu;
            if (this.zzfqm.zzfqh) {
                if (task.isSuccessful()) {
                    this.zzfqm.zzfqj = new ArrayMap(this.zzfqm.zzfpz.size());
                    for (zzz zzagn : this.zzfqm.zzfpz.values()) {
                        this.zzfqm.zzfqj.put(zzagn.zzagn(), ConnectionResult.zzfkr);
                    }
                } else if (task.getException() instanceof AvailabilityException) {
                    AvailabilityException availabilityException = (AvailabilityException) task.getException();
                    if (this.zzfqm.zzfqf) {
                        this.zzfqm.zzfqj = new ArrayMap(this.zzfqm.zzfpz.size());
                        for (zzz com_google_android_gms_common_api_internal_zzz : this.zzfqm.zzfpz.values()) {
                            Map zzg;
                            zzh zzagn2 = com_google_android_gms_common_api_internal_zzz.zzagn();
                            Object connectionResult = availabilityException.getConnectionResult(com_google_android_gms_common_api_internal_zzz);
                            if (this.zzfqm.zza(com_google_android_gms_common_api_internal_zzz, (ConnectionResult) connectionResult)) {
                                zzg = this.zzfqm.zzfqj;
                                connectionResult = new ConnectionResult(16);
                            } else {
                                zzg = this.zzfqm.zzfqj;
                            }
                            zzg.put(zzagn2, connectionResult);
                        }
                    } else {
                        this.zzfqm.zzfqj = availabilityException.zzagj();
                    }
                } else {
                    Log.e("ConnectionlessGAC", "Unexpected availability exception", task.getException());
                    this.zzfqm.zzfqj = Collections.emptyMap();
                }
                if (this.zzfqm.isConnected()) {
                    this.zzfqm.zzfqi.putAll(this.zzfqm.zzfqj);
                    if (this.zzfqm.zzaht() == null) {
                        this.zzfqm.zzahr();
                        this.zzfqm.zzahs();
                        this.zzfqm.zzfqd.signalAll();
                    }
                }
                com_google_android_gms_common_api_internal_zzcu = this.zzfqn;
            } else {
                com_google_android_gms_common_api_internal_zzcu = this.zzfqn;
            }
            com_google_android_gms_common_api_internal_zzcu.zzabi();
        } finally {
            this.zzfqm.zzfps.unlock();
        }
    }
}
