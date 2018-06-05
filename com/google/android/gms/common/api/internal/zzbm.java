package com.google.android.gms.common.api.internal;

import android.app.Application;
import android.app.PendingIntent;
import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.WorkerThread;
import android.support.v4.util.ArraySet;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.internal.zzcxd;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public final class zzbm implements Callback {
    private static final Object sLock = new Object();
    public static final Status zzfsy = new Status(4, "Sign-out occurred while this API call was in progress.");
    private static final Status zzfsz = new Status(4, "The user must be signed in to make this API call.");
    private static zzbm zzftb;
    private final Context mContext;
    private final Handler mHandler;
    private final GoogleApiAvailability zzfmy;
    private final Map<zzh<?>, zzbo<?>> zzfpy = new ConcurrentHashMap(5, 0.75f, 1);
    private long zzfrx = 120000;
    private long zzfry = 5000;
    private long zzfta = 10000;
    private int zzftc = -1;
    private final AtomicInteger zzftd = new AtomicInteger(1);
    private final AtomicInteger zzfte = new AtomicInteger(0);
    private zzah zzftf = null;
    private final Set<zzh<?>> zzftg = new ArraySet();
    private final Set<zzh<?>> zzfth = new ArraySet();

    private zzbm(Context context, Looper looper, GoogleApiAvailability googleApiAvailability) {
        this.mContext = context;
        this.mHandler = new Handler(looper, this);
        this.zzfmy = googleApiAvailability;
        this.mHandler.sendMessage(this.mHandler.obtainMessage(6));
    }

    public static zzbm zzaiq() {
        zzbm com_google_android_gms_common_api_internal_zzbm;
        synchronized (sLock) {
            zzbq.checkNotNull(zzftb, "Must guarantee manager is non-null before using getInstance");
            com_google_android_gms_common_api_internal_zzbm = zzftb;
        }
        return com_google_android_gms_common_api_internal_zzbm;
    }

    public static void zzair() {
        synchronized (sLock) {
            if (zzftb != null) {
                zzbm com_google_android_gms_common_api_internal_zzbm = zzftb;
                com_google_android_gms_common_api_internal_zzbm.zzfte.incrementAndGet();
                com_google_android_gms_common_api_internal_zzbm.mHandler.sendMessageAtFrontOfQueue(com_google_android_gms_common_api_internal_zzbm.mHandler.obtainMessage(10));
            }
        }
    }

    @WorkerThread
    private final void zzait() {
        for (zzh remove : this.zzfth) {
            ((zzbo) this.zzfpy.remove(remove)).signOut();
        }
        this.zzfth.clear();
    }

    @WorkerThread
    private final void zzb(GoogleApi<?> googleApi) {
        zzh zzagn = googleApi.zzagn();
        zzbo com_google_android_gms_common_api_internal_zzbo = (zzbo) this.zzfpy.get(zzagn);
        if (com_google_android_gms_common_api_internal_zzbo == null) {
            com_google_android_gms_common_api_internal_zzbo = new zzbo(this, googleApi);
            this.zzfpy.put(zzagn, com_google_android_gms_common_api_internal_zzbo);
        }
        if (com_google_android_gms_common_api_internal_zzbo.zzaay()) {
            this.zzfth.add(zzagn);
        }
        com_google_android_gms_common_api_internal_zzbo.connect();
    }

    public static zzbm zzcj(Context context) {
        zzbm com_google_android_gms_common_api_internal_zzbm;
        synchronized (sLock) {
            if (zzftb == null) {
                HandlerThread handlerThread = new HandlerThread("GoogleApiHandler", 9);
                handlerThread.start();
                zzftb = new zzbm(context.getApplicationContext(), handlerThread.getLooper(), GoogleApiAvailability.getInstance());
            }
            com_google_android_gms_common_api_internal_zzbm = zzftb;
        }
        return com_google_android_gms_common_api_internal_zzbm;
    }

    @WorkerThread
    public final boolean handleMessage(Message message) {
        long j = 300000;
        zzbo com_google_android_gms_common_api_internal_zzbo;
        zzbo com_google_android_gms_common_api_internal_zzbo2;
        StringBuilder stringBuilder;
        switch (message.what) {
            case 1:
                if (((Boolean) message.obj).booleanValue()) {
                    j = 10000;
                }
                this.zzfta = j;
                this.mHandler.removeMessages(12);
                for (zzh obtainMessage : this.zzfpy.keySet()) {
                    this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(12, obtainMessage), this.zzfta);
                }
                break;
            case 2:
                zzj com_google_android_gms_common_api_internal_zzj = (zzj) message.obj;
                for (zzh obtainMessage2 : com_google_android_gms_common_api_internal_zzj.zzaha()) {
                    com_google_android_gms_common_api_internal_zzbo = (zzbo) this.zzfpy.get(obtainMessage2);
                    if (com_google_android_gms_common_api_internal_zzbo == null) {
                        com_google_android_gms_common_api_internal_zzj.zza(obtainMessage2, new ConnectionResult(13), null);
                        return true;
                    } else if (com_google_android_gms_common_api_internal_zzbo.isConnected()) {
                        com_google_android_gms_common_api_internal_zzj.zza(obtainMessage2, ConnectionResult.zzfkr, com_google_android_gms_common_api_internal_zzbo.zzahp().zzagi());
                    } else if (com_google_android_gms_common_api_internal_zzbo.zzaja() != null) {
                        com_google_android_gms_common_api_internal_zzj.zza(obtainMessage2, com_google_android_gms_common_api_internal_zzbo.zzaja(), null);
                    } else {
                        com_google_android_gms_common_api_internal_zzbo.zza(com_google_android_gms_common_api_internal_zzj);
                    }
                }
                break;
            case 3:
                for (zzbo com_google_android_gms_common_api_internal_zzbo22 : this.zzfpy.values()) {
                    com_google_android_gms_common_api_internal_zzbo22.zzaiz();
                    com_google_android_gms_common_api_internal_zzbo22.connect();
                }
                break;
            case 4:
            case 8:
            case 13:
                zzcp com_google_android_gms_common_api_internal_zzcp = (zzcp) message.obj;
                com_google_android_gms_common_api_internal_zzbo22 = (zzbo) this.zzfpy.get(com_google_android_gms_common_api_internal_zzcp.zzfur.zzagn());
                if (com_google_android_gms_common_api_internal_zzbo22 == null) {
                    zzb(com_google_android_gms_common_api_internal_zzcp.zzfur);
                    com_google_android_gms_common_api_internal_zzbo22 = (zzbo) this.zzfpy.get(com_google_android_gms_common_api_internal_zzcp.zzfur.zzagn());
                }
                if (!com_google_android_gms_common_api_internal_zzbo22.zzaay() || this.zzfte.get() == com_google_android_gms_common_api_internal_zzcp.zzfuq) {
                    com_google_android_gms_common_api_internal_zzbo22.zza(com_google_android_gms_common_api_internal_zzcp.zzfup);
                    return true;
                }
                com_google_android_gms_common_api_internal_zzcp.zzfup.zzs(zzfsy);
                com_google_android_gms_common_api_internal_zzbo22.signOut();
                return true;
            case 5:
                String errorString;
                String errorMessage;
                StringBuilder stringBuilder2;
                int i = message.arg1;
                ConnectionResult connectionResult = (ConnectionResult) message.obj;
                for (zzbo com_google_android_gms_common_api_internal_zzbo3 : this.zzfpy.values()) {
                    if (com_google_android_gms_common_api_internal_zzbo3.getInstanceId() == i) {
                        if (com_google_android_gms_common_api_internal_zzbo3 == null) {
                            errorString = this.zzfmy.getErrorString(connectionResult.getErrorCode());
                            errorMessage = connectionResult.getErrorMessage();
                            stringBuilder2 = new StringBuilder((69 + String.valueOf(errorString).length()) + String.valueOf(errorMessage).length());
                            stringBuilder2.append("Error resolution was canceled by the user, original error message: ");
                            stringBuilder2.append(errorString);
                            stringBuilder2.append(": ");
                            stringBuilder2.append(errorMessage);
                            com_google_android_gms_common_api_internal_zzbo3.zzw(new Status(17, stringBuilder2.toString()));
                            return true;
                        }
                        stringBuilder = new StringBuilder(76);
                        stringBuilder.append("Could not find API instance ");
                        stringBuilder.append(i);
                        stringBuilder.append(" while trying to fail enqueued calls.");
                        Log.wtf("GoogleApiManager", stringBuilder.toString(), new Exception());
                        return true;
                    }
                }
                com_google_android_gms_common_api_internal_zzbo3 = null;
                if (com_google_android_gms_common_api_internal_zzbo3 == null) {
                    stringBuilder = new StringBuilder(76);
                    stringBuilder.append("Could not find API instance ");
                    stringBuilder.append(i);
                    stringBuilder.append(" while trying to fail enqueued calls.");
                    Log.wtf("GoogleApiManager", stringBuilder.toString(), new Exception());
                    return true;
                }
                errorString = this.zzfmy.getErrorString(connectionResult.getErrorCode());
                errorMessage = connectionResult.getErrorMessage();
                stringBuilder2 = new StringBuilder((69 + String.valueOf(errorString).length()) + String.valueOf(errorMessage).length());
                stringBuilder2.append("Error resolution was canceled by the user, original error message: ");
                stringBuilder2.append(errorString);
                stringBuilder2.append(": ");
                stringBuilder2.append(errorMessage);
                com_google_android_gms_common_api_internal_zzbo3.zzw(new Status(17, stringBuilder2.toString()));
                return true;
            case 6:
                if (this.mContext.getApplicationContext() instanceof Application) {
                    zzk.zza((Application) this.mContext.getApplicationContext());
                    zzk.zzahb().zza(new zzbn(this));
                    if (!zzk.zzahb().zzbe(true)) {
                        this.zzfta = 300000;
                        return true;
                    }
                }
                break;
            case 7:
                zzb((GoogleApi) message.obj);
                return true;
            case 9:
                if (this.zzfpy.containsKey(message.obj)) {
                    ((zzbo) this.zzfpy.get(message.obj)).resume();
                    return true;
                }
                break;
            case 10:
                zzait();
                return true;
            case 11:
                if (this.zzfpy.containsKey(message.obj)) {
                    ((zzbo) this.zzfpy.get(message.obj)).zzaij();
                    return true;
                }
                break;
            case 12:
                if (this.zzfpy.containsKey(message.obj)) {
                    ((zzbo) this.zzfpy.get(message.obj)).zzajd();
                    return true;
                }
                break;
            default:
                int i2 = message.what;
                stringBuilder = new StringBuilder(31);
                stringBuilder.append("Unknown message id: ");
                stringBuilder.append(i2);
                Log.w("GoogleApiManager", stringBuilder.toString());
                return false;
        }
        return true;
    }

    final PendingIntent zza(zzh<?> com_google_android_gms_common_api_internal_zzh_, int i) {
        zzbo com_google_android_gms_common_api_internal_zzbo = (zzbo) this.zzfpy.get(com_google_android_gms_common_api_internal_zzh_);
        if (com_google_android_gms_common_api_internal_zzbo == null) {
            return null;
        }
        zzcxd zzaje = com_google_android_gms_common_api_internal_zzbo.zzaje();
        return zzaje == null ? null : PendingIntent.getActivity(this.mContext, i, zzaje.getSignInIntent(), 134217728);
    }

    public final <O extends ApiOptions> Task<Boolean> zza(@NonNull GoogleApi<O> googleApi, @NonNull zzck<?> com_google_android_gms_common_api_internal_zzck_) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.mHandler.sendMessage(this.mHandler.obtainMessage(13, new zzcp(new zzf(com_google_android_gms_common_api_internal_zzck_, taskCompletionSource), this.zzfte.get(), googleApi)));
        return taskCompletionSource.getTask();
    }

    public final <O extends ApiOptions> Task<Void> zza(@NonNull GoogleApi<O> googleApi, @NonNull zzcq<zzb, ?> com_google_android_gms_common_api_internal_zzcq_com_google_android_gms_common_api_Api_zzb__, @NonNull zzdn<zzb, ?> com_google_android_gms_common_api_internal_zzdn_com_google_android_gms_common_api_Api_zzb__) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.mHandler.sendMessage(this.mHandler.obtainMessage(8, new zzcp(new zzd(new zzcr(com_google_android_gms_common_api_internal_zzcq_com_google_android_gms_common_api_Api_zzb__, com_google_android_gms_common_api_internal_zzdn_com_google_android_gms_common_api_Api_zzb__), taskCompletionSource), this.zzfte.get(), googleApi)));
        return taskCompletionSource.getTask();
    }

    public final Task<Map<zzh<?>, String>> zza(Iterable<? extends GoogleApi<?>> iterable) {
        zzj com_google_android_gms_common_api_internal_zzj = new zzj(iterable);
        for (GoogleApi googleApi : iterable) {
            zzbo com_google_android_gms_common_api_internal_zzbo = (zzbo) this.zzfpy.get(googleApi.zzagn());
            if (com_google_android_gms_common_api_internal_zzbo != null) {
                if (com_google_android_gms_common_api_internal_zzbo.isConnected()) {
                    com_google_android_gms_common_api_internal_zzj.zza(googleApi.zzagn(), ConnectionResult.zzfkr, com_google_android_gms_common_api_internal_zzbo.zzahp().zzagi());
                }
            }
            this.mHandler.sendMessage(this.mHandler.obtainMessage(2, com_google_android_gms_common_api_internal_zzj));
            return com_google_android_gms_common_api_internal_zzj.getTask();
        }
        return com_google_android_gms_common_api_internal_zzj.getTask();
    }

    public final void zza(ConnectionResult connectionResult, int i) {
        if (!zzc(connectionResult, i)) {
            this.mHandler.sendMessage(this.mHandler.obtainMessage(5, i, 0, connectionResult));
        }
    }

    public final void zza(GoogleApi<?> googleApi) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(7, googleApi));
    }

    public final <O extends ApiOptions, TResult> void zza(GoogleApi<O> googleApi, int i, zzdd<zzb, TResult> com_google_android_gms_common_api_internal_zzdd_com_google_android_gms_common_api_Api_zzb__TResult, TaskCompletionSource<TResult> taskCompletionSource, zzcz com_google_android_gms_common_api_internal_zzcz) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(4, new zzcp(new zze(i, com_google_android_gms_common_api_internal_zzdd_com_google_android_gms_common_api_Api_zzb__TResult, taskCompletionSource, com_google_android_gms_common_api_internal_zzcz), this.zzfte.get(), googleApi)));
    }

    public final <O extends ApiOptions> void zza(GoogleApi<O> googleApi, int i, zzm<? extends Result, zzb> com_google_android_gms_common_api_internal_zzm__extends_com_google_android_gms_common_api_Result__com_google_android_gms_common_api_Api_zzb) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(4, new zzcp(new zzc(i, com_google_android_gms_common_api_internal_zzm__extends_com_google_android_gms_common_api_Result__com_google_android_gms_common_api_Api_zzb), this.zzfte.get(), googleApi)));
    }

    public final void zza(@NonNull zzah com_google_android_gms_common_api_internal_zzah) {
        synchronized (sLock) {
            if (this.zzftf != com_google_android_gms_common_api_internal_zzah) {
                this.zzftf = com_google_android_gms_common_api_internal_zzah;
                this.zzftg.clear();
                this.zzftg.addAll(com_google_android_gms_common_api_internal_zzah.zzahx());
            }
        }
    }

    final void zzags() {
        this.zzfte.incrementAndGet();
        this.mHandler.sendMessage(this.mHandler.obtainMessage(10));
    }

    public final void zzagz() {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(3));
    }

    public final int zzais() {
        return this.zzftd.getAndIncrement();
    }

    final void zzb(@NonNull zzah com_google_android_gms_common_api_internal_zzah) {
        synchronized (sLock) {
            if (this.zzftf == com_google_android_gms_common_api_internal_zzah) {
                this.zzftf = null;
                this.zzftg.clear();
            }
        }
    }

    final boolean zzc(ConnectionResult connectionResult, int i) {
        return this.zzfmy.zza(this.mContext, connectionResult, i);
    }
}
