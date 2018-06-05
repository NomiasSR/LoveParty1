package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.BinderThread;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.WorkerThread;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api.zza;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.common.internal.zzbt;
import com.google.android.gms.common.internal.zzr;
import com.google.android.gms.internal.zzcxa;
import com.google.android.gms.internal.zzcxd;
import com.google.android.gms.internal.zzcxe;
import com.google.android.gms.internal.zzcxi;
import com.google.android.gms.internal.zzcxq;
import java.util.Set;

public final class zzcv extends zzcxi implements ConnectionCallbacks, OnConnectionFailedListener {
    private static zza<? extends zzcxd, zzcxe> zzfut = zzcxa.zzebg;
    private final Context mContext;
    private final Handler mHandler;
    private Set<Scope> zzehs;
    private final zza<? extends zzcxd, zzcxe> zzfls;
    private zzr zzfpx;
    private zzcxd zzfrd;
    private zzcy zzfuu;

    @WorkerThread
    public zzcv(Context context, Handler handler, @NonNull zzr com_google_android_gms_common_internal_zzr) {
        this(context, handler, com_google_android_gms_common_internal_zzr, zzfut);
    }

    @WorkerThread
    public zzcv(Context context, Handler handler, @NonNull zzr com_google_android_gms_common_internal_zzr, zza<? extends zzcxd, zzcxe> com_google_android_gms_common_api_Api_zza__extends_com_google_android_gms_internal_zzcxd__com_google_android_gms_internal_zzcxe) {
        this.mContext = context;
        this.mHandler = handler;
        this.zzfpx = (zzr) zzbq.checkNotNull(com_google_android_gms_common_internal_zzr, "ClientSettings must not be null");
        this.zzehs = com_google_android_gms_common_internal_zzr.zzakv();
        this.zzfls = com_google_android_gms_common_api_Api_zza__extends_com_google_android_gms_internal_zzcxd__com_google_android_gms_internal_zzcxe;
    }

    @WorkerThread
    private final void zzc(zzcxq com_google_android_gms_internal_zzcxq) {
        ConnectionResult zzahf = com_google_android_gms_internal_zzcxq.zzahf();
        if (zzahf.isSuccess()) {
            zzbt zzbdi = com_google_android_gms_internal_zzcxq.zzbdi();
            zzahf = zzbdi.zzahf();
            if (zzahf.isSuccess()) {
                this.zzfuu.zzb(zzbdi.zzalp(), this.zzehs);
                this.zzfrd.disconnect();
            }
            String valueOf = String.valueOf(zzahf);
            StringBuilder stringBuilder = new StringBuilder(48 + String.valueOf(valueOf).length());
            stringBuilder.append("Sign-in succeeded with resolve account failure: ");
            stringBuilder.append(valueOf);
            Log.wtf("SignInCoordinator", stringBuilder.toString(), new Exception());
        }
        this.zzfuu.zzh(zzahf);
        this.zzfrd.disconnect();
    }

    @WorkerThread
    public final void onConnected(@Nullable Bundle bundle) {
        this.zzfrd.zza(this);
    }

    @WorkerThread
    public final void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        this.zzfuu.zzh(connectionResult);
    }

    @WorkerThread
    public final void onConnectionSuspended(int i) {
        this.zzfrd.disconnect();
    }

    @WorkerThread
    public final void zza(zzcy com_google_android_gms_common_api_internal_zzcy) {
        if (this.zzfrd != null) {
            this.zzfrd.disconnect();
        }
        this.zzfpx.zzc(Integer.valueOf(System.identityHashCode(this)));
        this.zzfrd = (zzcxd) this.zzfls.zza(this.mContext, this.mHandler.getLooper(), this.zzfpx, this.zzfpx.zzalb(), this, this);
        this.zzfuu = com_google_android_gms_common_api_internal_zzcy;
        if (this.zzehs != null) {
            if (!this.zzehs.isEmpty()) {
                this.zzfrd.connect();
                return;
            }
        }
        this.mHandler.post(new zzcw(this));
    }

    public final zzcxd zzaje() {
        return this.zzfrd;
    }

    public final void zzajq() {
        if (this.zzfrd != null) {
            this.zzfrd.disconnect();
        }
    }

    @BinderThread
    public final void zzb(zzcxq com_google_android_gms_internal_zzcxq) {
        this.mHandler.post(new zzcx(this, com_google_android_gms_internal_zzcxq));
    }
}
