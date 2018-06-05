package com.google.android.gms.internal;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.RemoteException;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import com.google.android.gms.dynamic.zzn;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.storage.StorageException;
import java.io.InputStream;
import java.net.SocketException;
import org.json.JSONObject;

public final class zzeyc {
    private Exception zzkuq;
    private zzexx zzomc;
    private int zzomd;
    private Exception zzome;

    public zzeyc(@NonNull zzexx com_google_android_gms_internal_zzexx) {
        this.zzomc = com_google_android_gms_internal_zzexx;
    }

    @Nullable
    public final Exception getException() {
        try {
            return this.zzome != null ? this.zzome : this.zzkuq != null ? this.zzkuq : (Exception) zzn.zzx(this.zzomc.zzcml());
        } catch (Throwable e) {
            this.zzkuq = e;
            Log.e("NetworkRequestProxy", "getException failed with a RemoteException:", e);
            return null;
        }
    }

    public final int getResultCode() {
        try {
            return this.zzomd != 0 ? this.zzomd : this.zzomc.getResultCode();
        } catch (Throwable e) {
            this.zzkuq = e;
            Log.e("NetworkRequestProxy", "getResultCode failed with a RemoteException:", e);
            return 0;
        }
    }

    @Nullable
    public final InputStream getStream() {
        try {
            return (InputStream) zzn.zzx(this.zzomc.zzcmi());
        } catch (Throwable e) {
            this.zzkuq = e;
            Log.e("NetworkRequestProxy", "getStream failed with a RemoteException:", e);
            return null;
        }
    }

    public final void reset() {
        try {
            this.zzomd = 0;
            this.zzome = null;
            this.zzomc.reset();
        } catch (Throwable e) {
            this.zzkuq = e;
            Log.e("NetworkRequestProxy", "reset failed with a RemoteException:", e);
        }
    }

    public final <TResult> void zza(TaskCompletionSource<TResult> taskCompletionSource, TResult tResult) {
        Throwable exception = getException();
        if (zzcmm() && exception == null) {
            taskCompletionSource.setResult(tResult);
        } else {
            taskCompletionSource.setException(StorageException.fromExceptionAndHttpCode(exception, getResultCode()));
        }
    }

    public final void zzbq(String str, String str2) {
        try {
            this.zzomc.zzbq(str, str2);
        } catch (Throwable e) {
            String str3 = "NetworkRequestProxy";
            String str4 = "Caught remote exception setting custom header:";
            str = String.valueOf(str);
            Log.e(str3, str.length() != 0 ? str4.concat(str) : new String(str4), e);
        }
    }

    public final void zzcmh() {
        try {
            if (this.zzomc != null) {
                this.zzomc.zzcmh();
            }
        } catch (Throwable e) {
            this.zzkuq = e;
            Log.e("NetworkRequestProxy", "performRequestEnd failed with a RemoteException:", e);
        }
    }

    @Nullable
    public final String zzcmk() {
        try {
            this.zzomc.zzcmk();
        } catch (Throwable e) {
            this.zzkuq = e;
            Log.e("NetworkRequestProxy", "getRawResult failed with a RemoteException:", e);
        }
        return null;
    }

    public final boolean zzcmm() {
        try {
            return (this.zzomd == -2 || this.zzome != null) ? false : this.zzomc.zzcmm();
        } catch (Throwable e) {
            this.zzkuq = e;
            Log.e("NetworkRequestProxy", "isResultSuccess failed with a RemoteException:", e);
            return false;
        }
    }

    public final int zzcmn() {
        try {
            return this.zzomc.zzcmn();
        } catch (Throwable e) {
            this.zzkuq = e;
            Log.e("NetworkRequestProxy", "getResultingContentLength failed with a RemoteException:", e);
            return 0;
        }
    }

    @NonNull
    public final JSONObject zzcmp() throws RemoteException {
        return (JSONObject) zzn.zzx(this.zzomc.zzcmj());
    }

    public final void zze(@Nullable String str, @NonNull Context context) {
        try {
            Object obj;
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                if (activeNetworkInfo.isConnected()) {
                    obj = 1;
                    if (obj == null) {
                        this.zzomc.zzsl(str);
                    }
                }
            }
            this.zzomd = -2;
            this.zzome = new SocketException("Network subsystem is unavailable");
            obj = null;
            if (obj == null) {
                this.zzomc.zzsl(str);
            }
        } catch (Throwable e) {
            this.zzkuq = e;
            Log.e("NetworkRequestProxy", "performRequest failed with a RemoteException:", e);
        }
    }

    public final void zzsm(@Nullable String str) {
        try {
            this.zzomc.zzsm(str);
        } catch (Throwable e) {
            this.zzkuq = e;
            Log.e("NetworkRequestProxy", "performRequestStart failed with a RemoteException:", e);
        }
    }

    @Nullable
    public final String zzsn(String str) {
        try {
            return this.zzomc.zzsn(str);
        } catch (Throwable e) {
            String str2 = "NetworkRequestProxy";
            String str3 = "getResultString failed with a RemoteException:";
            str = String.valueOf(str);
            Log.e(str2, str.length() != 0 ? str3.concat(str) : new String(str3), e);
            return null;
        }
    }
}
