package com.google.android.gms.common.api.internal;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.util.SparseArray;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzbq;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public class zzi extends zzo {
    private final SparseArray<zza> zzfnx = new SparseArray();

    class zza implements OnConnectionFailedListener {
        public final int zzfny;
        public final GoogleApiClient zzfnz;
        public final OnConnectionFailedListener zzfoa;
        private /* synthetic */ zzi zzfob;

        public zza(zzi com_google_android_gms_common_api_internal_zzi, int i, GoogleApiClient googleApiClient, OnConnectionFailedListener onConnectionFailedListener) {
            this.zzfob = com_google_android_gms_common_api_internal_zzi;
            this.zzfny = i;
            this.zzfnz = googleApiClient;
            this.zzfoa = onConnectionFailedListener;
            googleApiClient.registerConnectionFailedListener(this);
        }

        public final void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
            String valueOf = String.valueOf(connectionResult);
            StringBuilder stringBuilder = new StringBuilder(27 + String.valueOf(valueOf).length());
            stringBuilder.append("beginFailureResolution for ");
            stringBuilder.append(valueOf);
            Log.d("AutoManageHelper", stringBuilder.toString());
            this.zzfob.zzb(connectionResult, this.zzfny);
        }
    }

    private zzi(zzcf com_google_android_gms_common_api_internal_zzcf) {
        super(com_google_android_gms_common_api_internal_zzcf);
        this.zzfud.zza("AutoManageHelper", (LifecycleCallback) this);
    }

    public static zzi zza(zzce com_google_android_gms_common_api_internal_zzce) {
        zzcf zzb = LifecycleCallback.zzb(com_google_android_gms_common_api_internal_zzce);
        zzi com_google_android_gms_common_api_internal_zzi = (zzi) zzb.zza("AutoManageHelper", zzi.class);
        return com_google_android_gms_common_api_internal_zzi != null ? com_google_android_gms_common_api_internal_zzi : new zzi(zzb);
    }

    @Nullable
    private final zza zzbs(int i) {
        return this.zzfnx.size() <= i ? null : (zza) this.zzfnx.get(this.zzfnx.keyAt(i));
    }

    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        for (int i = 0; i < this.zzfnx.size(); i++) {
            zza zzbs = zzbs(i);
            if (zzbs != null) {
                printWriter.append(str).append("GoogleApiClient #").print(zzbs.zzfny);
                printWriter.println(":");
                zzbs.zzfnz.dump(String.valueOf(str).concat("  "), fileDescriptor, printWriter, strArr);
            }
        }
    }

    public final void onStart() {
        super.onStart();
        boolean z = this.mStarted;
        String valueOf = String.valueOf(this.zzfnx);
        StringBuilder stringBuilder = new StringBuilder(14 + String.valueOf(valueOf).length());
        stringBuilder.append("onStart ");
        stringBuilder.append(z);
        stringBuilder.append(" ");
        stringBuilder.append(valueOf);
        Log.d("AutoManageHelper", stringBuilder.toString());
        if (this.zzfol.get() == null) {
            for (int i = 0; i < this.zzfnx.size(); i++) {
                zza zzbs = zzbs(i);
                if (zzbs != null) {
                    zzbs.zzfnz.connect();
                }
            }
        }
    }

    public final void onStop() {
        super.onStop();
        for (int i = 0; i < this.zzfnx.size(); i++) {
            zza zzbs = zzbs(i);
            if (zzbs != null) {
                zzbs.zzfnz.disconnect();
            }
        }
    }

    public final void zza(int i, GoogleApiClient googleApiClient, OnConnectionFailedListener onConnectionFailedListener) {
        zzbq.checkNotNull(googleApiClient, "GoogleApiClient instance cannot be null");
        boolean z = this.zzfnx.indexOfKey(i) < 0;
        StringBuilder stringBuilder = new StringBuilder(54);
        stringBuilder.append("Already managing a GoogleApiClient with id ");
        stringBuilder.append(i);
        zzbq.zza(z, stringBuilder.toString());
        zzp com_google_android_gms_common_api_internal_zzp = (zzp) this.zzfol.get();
        boolean z2 = this.mStarted;
        String valueOf = String.valueOf(com_google_android_gms_common_api_internal_zzp);
        StringBuilder stringBuilder2 = new StringBuilder(49 + String.valueOf(valueOf).length());
        stringBuilder2.append("starting AutoManage for client ");
        stringBuilder2.append(i);
        stringBuilder2.append(" ");
        stringBuilder2.append(z2);
        stringBuilder2.append(" ");
        stringBuilder2.append(valueOf);
        Log.d("AutoManageHelper", stringBuilder2.toString());
        this.zzfnx.put(i, new zza(this, i, googleApiClient, onConnectionFailedListener));
        if (this.mStarted && com_google_android_gms_common_api_internal_zzp == null) {
            String valueOf2 = String.valueOf(googleApiClient);
            StringBuilder stringBuilder3 = new StringBuilder(11 + String.valueOf(valueOf2).length());
            stringBuilder3.append("connecting ");
            stringBuilder3.append(valueOf2);
            Log.d("AutoManageHelper", stringBuilder3.toString());
            googleApiClient.connect();
        }
    }

    protected final void zza(ConnectionResult connectionResult, int i) {
        Log.w("AutoManageHelper", "Unresolved error while connecting client. Stopping auto-manage.");
        if (i < 0) {
            Log.wtf("AutoManageHelper", "AutoManageLifecycleHelper received onErrorResolutionFailed callback but no failing client ID is set", new Exception());
            return;
        }
        zza com_google_android_gms_common_api_internal_zzi_zza = (zza) this.zzfnx.get(i);
        if (com_google_android_gms_common_api_internal_zzi_zza != null) {
            zzbr(i);
            OnConnectionFailedListener onConnectionFailedListener = com_google_android_gms_common_api_internal_zzi_zza.zzfoa;
            if (onConnectionFailedListener != null) {
                onConnectionFailedListener.onConnectionFailed(connectionResult);
            }
        }
    }

    protected final void zzagz() {
        for (int i = 0; i < this.zzfnx.size(); i++) {
            zza zzbs = zzbs(i);
            if (zzbs != null) {
                zzbs.zzfnz.connect();
            }
        }
    }

    public final void zzbr(int i) {
        zza com_google_android_gms_common_api_internal_zzi_zza = (zza) this.zzfnx.get(i);
        this.zzfnx.remove(i);
        if (com_google_android_gms_common_api_internal_zzi_zza != null) {
            com_google_android_gms_common_api_internal_zzi_zza.zzfnz.unregisterConnectionFailedListener(com_google_android_gms_common_api_internal_zzi_zza);
            com_google_android_gms_common_api_internal_zzi_zza.zzfnz.disconnect();
        }
    }
}
