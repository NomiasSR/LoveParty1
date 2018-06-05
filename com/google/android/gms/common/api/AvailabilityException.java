package com.google.android.gms.common.api;

import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.api.internal.zzh;
import com.google.android.gms.common.internal.zzbq;
import java.util.ArrayList;

public class AvailabilityException extends Exception {
    private final ArrayMap<zzh<?>, ConnectionResult> zzflw;

    public AvailabilityException(ArrayMap<zzh<?>, ConnectionResult> arrayMap) {
        this.zzflw = arrayMap;
    }

    public ConnectionResult getConnectionResult(GoogleApi<? extends ApiOptions> googleApi) {
        zzh zzagn = googleApi.zzagn();
        zzbq.checkArgument(this.zzflw.get(zzagn) != null, "The given API was not part of the availability request.");
        return (ConnectionResult) this.zzflw.get(zzagn);
    }

    public String getMessage() {
        Iterable arrayList = new ArrayList();
        Object obj = 1;
        for (zzh com_google_android_gms_common_api_internal_zzh : this.zzflw.keySet()) {
            ConnectionResult connectionResult = (ConnectionResult) this.zzflw.get(com_google_android_gms_common_api_internal_zzh);
            if (connectionResult.isSuccess()) {
                obj = null;
            }
            String zzagy = com_google_android_gms_common_api_internal_zzh.zzagy();
            String valueOf = String.valueOf(connectionResult);
            StringBuilder stringBuilder = new StringBuilder((2 + String.valueOf(zzagy).length()) + String.valueOf(valueOf).length());
            stringBuilder.append(zzagy);
            stringBuilder.append(": ");
            stringBuilder.append(valueOf);
            arrayList.add(stringBuilder.toString());
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(obj != null ? "None of the queried APIs are available. " : "Some of the queried APIs are unavailable. ");
        stringBuilder2.append(TextUtils.join("; ", arrayList));
        return stringBuilder2.toString();
    }

    public final ArrayMap<zzh<?>, ConnectionResult> zzagj() {
        return this.zzflw;
    }
}
