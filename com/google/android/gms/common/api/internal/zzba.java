package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.zza;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.Api.zze;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.Builder;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzae;
import com.google.android.gms.common.internal.zzaf;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.common.internal.zzr;
import com.google.android.gms.common.zzf;
import com.google.android.gms.internal.zzbft;
import com.google.android.gms.internal.zzcxd;
import com.google.android.gms.internal.zzcxe;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Lock;

public final class zzba extends GoogleApiClient implements zzcd {
    private final Context mContext;
    private final Looper zzall;
    private final int zzfmw;
    private final GoogleApiAvailability zzfmy;
    private zza<? extends zzcxd, zzcxe> zzfmz;
    private boolean zzfnc;
    private final Lock zzfps;
    private zzr zzfpx;
    private Map<Api<?>, Boolean> zzfqa;
    final Queue<zzm<?, ?>> zzfqg = new LinkedList();
    private final zzae zzfru;
    private zzcc zzfrv = null;
    private volatile boolean zzfrw;
    private long zzfrx = 120000;
    private long zzfry = 5000;
    private final zzbf zzfrz;
    private zzbx zzfsa;
    final Map<zzc<?>, zze> zzfsb;
    Set<Scope> zzfsc = new HashSet();
    private final zzcm zzfsd = new zzcm();
    private final ArrayList<zzt> zzfse;
    private Integer zzfsf = null;
    Set<zzdg> zzfsg = null;
    final zzdj zzfsh;
    private final zzaf zzfsi = new zzbb(this);

    public zzba(Context context, Lock lock, Looper looper, zzr com_google_android_gms_common_internal_zzr, GoogleApiAvailability googleApiAvailability, zza<? extends zzcxd, zzcxe> com_google_android_gms_common_api_Api_zza__extends_com_google_android_gms_internal_zzcxd__com_google_android_gms_internal_zzcxe, Map<Api<?>, Boolean> map, List<ConnectionCallbacks> list, List<OnConnectionFailedListener> list2, Map<zzc<?>, zze> map2, int i, int i2, ArrayList<zzt> arrayList, boolean z) {
        Looper looper2 = looper;
        this.mContext = context;
        this.zzfps = lock;
        this.zzfnc = false;
        this.zzfru = new zzae(looper2, this.zzfsi);
        this.zzall = looper2;
        this.zzfrz = new zzbf(this, looper2);
        this.zzfmy = googleApiAvailability;
        this.zzfmw = i;
        if (this.zzfmw >= 0) {
            r0.zzfsf = Integer.valueOf(i2);
        }
        r0.zzfqa = map;
        r0.zzfsb = map2;
        r0.zzfse = arrayList;
        r0.zzfsh = new zzdj(r0.zzfsb);
        for (ConnectionCallbacks registerConnectionCallbacks : list) {
            r0.zzfru.registerConnectionCallbacks(registerConnectionCallbacks);
        }
        for (OnConnectionFailedListener registerConnectionFailedListener : list2) {
            r0.zzfru.registerConnectionFailedListener(registerConnectionFailedListener);
        }
        r0.zzfpx = com_google_android_gms_common_internal_zzr;
        r0.zzfmz = com_google_android_gms_common_api_Api_zza__extends_com_google_android_gms_internal_zzcxd__com_google_android_gms_internal_zzcxe;
    }

    private final void resume() {
        this.zzfps.lock();
        try {
            if (this.zzfrw) {
                zzaii();
            }
            this.zzfps.unlock();
        } catch (Throwable th) {
            this.zzfps.unlock();
        }
    }

    public static int zza(Iterable<zze> iterable, boolean z) {
        int i = 0;
        int i2 = 0;
        for (zze com_google_android_gms_common_api_Api_zze : iterable) {
            if (com_google_android_gms_common_api_Api_zze.zzaay()) {
                i = 1;
            }
            if (com_google_android_gms_common_api_Api_zze.zzabj()) {
                i2 = 1;
            }
        }
        return i != 0 ? (i2 == 0 || !z) ? 1 : 2 : 3;
    }

    private final void zza(GoogleApiClient googleApiClient, zzda com_google_android_gms_common_api_internal_zzda, boolean z) {
        zzbft.zzgbv.zzd(googleApiClient).setResultCallback(new zzbe(this, com_google_android_gms_common_api_internal_zzda, z, googleApiClient));
    }

    private final void zzaii() {
        this.zzfru.zzalj();
        this.zzfrv.connect();
    }

    private final void zzaij() {
        this.zzfps.lock();
        try {
            if (zzaik()) {
                zzaii();
            }
            this.zzfps.unlock();
        } catch (Throwable th) {
            this.zzfps.unlock();
        }
    }

    private final void zzbv(int i) {
        if (this.zzfsf == null) {
            this.zzfsf = Integer.valueOf(i);
        } else if (this.zzfsf.intValue() != i) {
            String zzbw = zzbw(i);
            String zzbw2 = zzbw(this.zzfsf.intValue());
            StringBuilder stringBuilder = new StringBuilder((51 + String.valueOf(zzbw).length()) + String.valueOf(zzbw2).length());
            stringBuilder.append("Cannot use sign-in mode: ");
            stringBuilder.append(zzbw);
            stringBuilder.append(". Mode was already set to ");
            stringBuilder.append(zzbw2);
            throw new IllegalStateException(stringBuilder.toString());
        }
        if (this.zzfrv == null) {
            Object obj = null;
            Object obj2 = null;
            for (zze com_google_android_gms_common_api_Api_zze : this.zzfsb.values()) {
                if (com_google_android_gms_common_api_Api_zze.zzaay()) {
                    obj = 1;
                }
                if (com_google_android_gms_common_api_Api_zze.zzabj()) {
                    obj2 = 1;
                }
            }
            switch (this.zzfsf.intValue()) {
                case 1:
                    if (obj == null) {
                        throw new IllegalStateException("SIGN_IN_MODE_REQUIRED cannot be used on a GoogleApiClient that does not contain any authenticated APIs. Use connect() instead.");
                    } else if (obj2 != null) {
                        throw new IllegalStateException("Cannot use SIGN_IN_MODE_REQUIRED with GOOGLE_SIGN_IN_API. Use connect(SIGN_IN_MODE_OPTIONAL) instead.");
                    }
                    break;
                case 2:
                    if (obj != null) {
                        if (this.zzfnc) {
                            this.zzfrv = new zzaa(this.mContext, this.zzfps, this.zzall, this.zzfmy, this.zzfsb, this.zzfpx, this.zzfqa, this.zzfmz, this.zzfse, this, true);
                            return;
                        } else {
                            this.zzfrv = zzv.zza(this.mContext, this, this.zzfps, this.zzall, this.zzfmy, this.zzfsb, this.zzfpx, this.zzfqa, this.zzfmz, this.zzfse);
                            return;
                        }
                    }
                    break;
                case 3:
                    break;
                default:
                    break;
            }
            if (this.zzfnc && obj2 == null) {
                this.zzfrv = new zzaa(this.mContext, this.zzfps, this.zzall, this.zzfmy, this.zzfsb, this.zzfpx, this.zzfqa, this.zzfmz, this.zzfse, this, false);
            } else {
                this.zzfrv = new zzbi(this.mContext, this, this.zzfps, this.zzall, this.zzfmy, this.zzfsb, this.zzfpx, this.zzfqa, this.zzfmz, this.zzfse, this);
            }
        }
    }

    private static String zzbw(int i) {
        switch (i) {
            case 1:
                return "SIGN_IN_MODE_REQUIRED";
            case 2:
                return "SIGN_IN_MODE_OPTIONAL";
            case 3:
                return "SIGN_IN_MODE_NONE";
            default:
                return "UNKNOWN";
        }
    }

    public final ConnectionResult blockingConnect() {
        boolean z = true;
        zzbq.zza(Looper.myLooper() != Looper.getMainLooper(), (Object) "blockingConnect must not be called on the UI thread");
        this.zzfps.lock();
        try {
            if (this.zzfmw >= 0) {
                if (this.zzfsf == null) {
                    z = false;
                }
                zzbq.zza(z, (Object) "Sign-in mode should have been set explicitly by auto-manage.");
            } else if (this.zzfsf == null) {
                this.zzfsf = Integer.valueOf(zza(this.zzfsb.values(), false));
            } else if (this.zzfsf.intValue() == 2) {
                throw new IllegalStateException("Cannot call blockingConnect() when sign-in mode is set to SIGN_IN_MODE_OPTIONAL. Call connect(SIGN_IN_MODE_OPTIONAL) instead.");
            }
            zzbv(this.zzfsf.intValue());
            this.zzfru.zzalj();
            ConnectionResult blockingConnect = this.zzfrv.blockingConnect();
            return blockingConnect;
        } finally {
            this.zzfps.unlock();
        }
    }

    public final ConnectionResult blockingConnect(long j, @NonNull TimeUnit timeUnit) {
        zzbq.zza(Looper.myLooper() != Looper.getMainLooper(), (Object) "blockingConnect must not be called on the UI thread");
        zzbq.checkNotNull(timeUnit, "TimeUnit must not be null");
        this.zzfps.lock();
        try {
            if (this.zzfsf == null) {
                this.zzfsf = Integer.valueOf(zza(this.zzfsb.values(), false));
            } else if (this.zzfsf.intValue() == 2) {
                throw new IllegalStateException("Cannot call blockingConnect() when sign-in mode is set to SIGN_IN_MODE_OPTIONAL. Call connect(SIGN_IN_MODE_OPTIONAL) instead.");
            }
            zzbv(this.zzfsf.intValue());
            this.zzfru.zzalj();
            ConnectionResult blockingConnect = this.zzfrv.blockingConnect(j, timeUnit);
            return blockingConnect;
        } finally {
            this.zzfps.unlock();
        }
    }

    public final PendingResult<Status> clearDefaultAccountAndReconnect() {
        zzbq.zza(isConnected(), (Object) "GoogleApiClient is not connected yet.");
        zzbq.zza(this.zzfsf.intValue() != 2, (Object) "Cannot use clearDefaultAccountAndReconnect with GOOGLE_SIGN_IN_API");
        PendingResult<Status> com_google_android_gms_common_api_internal_zzda = new zzda((GoogleApiClient) this);
        if (this.zzfsb.containsKey(zzbft.zzebf)) {
            zza(this, com_google_android_gms_common_api_internal_zzda, false);
            return com_google_android_gms_common_api_internal_zzda;
        }
        AtomicReference atomicReference = new AtomicReference();
        GoogleApiClient build = new Builder(this.mContext).addApi(zzbft.API).addConnectionCallbacks(new zzbc(this, atomicReference, com_google_android_gms_common_api_internal_zzda)).addOnConnectionFailedListener(new zzbd(this, com_google_android_gms_common_api_internal_zzda)).setHandler(this.zzfrz).build();
        atomicReference.set(build);
        build.connect();
        return com_google_android_gms_common_api_internal_zzda;
    }

    public final void connect() {
        this.zzfps.lock();
        try {
            boolean z = false;
            if (this.zzfmw >= 0) {
                if (this.zzfsf != null) {
                    z = true;
                }
                zzbq.zza(z, (Object) "Sign-in mode should have been set explicitly by auto-manage.");
            } else if (this.zzfsf == null) {
                this.zzfsf = Integer.valueOf(zza(this.zzfsb.values(), false));
            } else if (this.zzfsf.intValue() == 2) {
                throw new IllegalStateException("Cannot call connect() when SignInMode is set to SIGN_IN_MODE_OPTIONAL. Call connect(SIGN_IN_MODE_OPTIONAL) instead.");
            }
            connect(this.zzfsf.intValue());
        } finally {
            this.zzfps.unlock();
        }
    }

    public final void connect(int i) {
        this.zzfps.lock();
        boolean z = true;
        if (!(i == 3 || i == 1)) {
            if (i != 2) {
                z = false;
            }
        }
        try {
            StringBuilder stringBuilder = new StringBuilder(33);
            stringBuilder.append("Illegal sign-in mode: ");
            stringBuilder.append(i);
            zzbq.checkArgument(z, stringBuilder.toString());
            zzbv(i);
            zzaii();
        } finally {
            this.zzfps.unlock();
        }
    }

    public final void disconnect() {
        this.zzfps.lock();
        try {
            this.zzfsh.release();
            if (this.zzfrv != null) {
                this.zzfrv.disconnect();
            }
            this.zzfsd.release();
            for (zzm com_google_android_gms_common_api_internal_zzm : this.zzfqg) {
                com_google_android_gms_common_api_internal_zzm.zza(null);
                com_google_android_gms_common_api_internal_zzm.cancel();
            }
            this.zzfqg.clear();
            if (this.zzfrv != null) {
                zzaik();
                this.zzfru.zzali();
            }
            this.zzfps.unlock();
        } catch (Throwable th) {
            this.zzfps.unlock();
        }
    }

    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.append(str).append("mContext=").println(this.mContext);
        printWriter.append(str).append("mResuming=").print(this.zzfrw);
        printWriter.append(" mWorkQueue.size()=").print(this.zzfqg.size());
        printWriter.append(" mUnconsumedApiCalls.size()=").println(this.zzfsh.zzfvi.size());
        if (this.zzfrv != null) {
            this.zzfrv.dump(str, fileDescriptor, printWriter, strArr);
        }
    }

    @NonNull
    public final ConnectionResult getConnectionResult(@NonNull Api<?> api) {
        this.zzfps.lock();
        try {
            if (!isConnected() && !this.zzfrw) {
                throw new IllegalStateException("Cannot invoke getConnectionResult unless GoogleApiClient is connected");
            } else if (this.zzfsb.containsKey(api.zzagf())) {
                ConnectionResult connectionResult = this.zzfrv.getConnectionResult(api);
                if (connectionResult == null) {
                    ConnectionResult connectionResult2;
                    if (this.zzfrw) {
                        connectionResult2 = ConnectionResult.zzfkr;
                    } else {
                        Log.w("GoogleApiClientImpl", zzaim());
                        Log.wtf("GoogleApiClientImpl", String.valueOf(api.getName()).concat(" requested in getConnectionResult is not connected but is not present in the failed  connections map"), new Exception());
                        connectionResult2 = new ConnectionResult(8, null);
                    }
                    this.zzfps.unlock();
                    return connectionResult2;
                }
                this.zzfps.unlock();
                return connectionResult;
            } else {
                throw new IllegalArgumentException(String.valueOf(api.getName()).concat(" was never registered with GoogleApiClient"));
            }
        } catch (Throwable th) {
            this.zzfps.unlock();
        }
    }

    public final Context getContext() {
        return this.mContext;
    }

    public final Looper getLooper() {
        return this.zzall;
    }

    public final boolean hasConnectedApi(@NonNull Api<?> api) {
        if (!isConnected()) {
            return false;
        }
        zze com_google_android_gms_common_api_Api_zze = (zze) this.zzfsb.get(api.zzagf());
        return com_google_android_gms_common_api_Api_zze != null && com_google_android_gms_common_api_Api_zze.isConnected();
    }

    public final boolean isConnected() {
        return this.zzfrv != null && this.zzfrv.isConnected();
    }

    public final boolean isConnecting() {
        return this.zzfrv != null && this.zzfrv.isConnecting();
    }

    public final boolean isConnectionCallbacksRegistered(@NonNull ConnectionCallbacks connectionCallbacks) {
        return this.zzfru.isConnectionCallbacksRegistered(connectionCallbacks);
    }

    public final boolean isConnectionFailedListenerRegistered(@NonNull OnConnectionFailedListener onConnectionFailedListener) {
        return this.zzfru.isConnectionFailedListenerRegistered(onConnectionFailedListener);
    }

    public final void reconnect() {
        disconnect();
        connect();
    }

    public final void registerConnectionCallbacks(@NonNull ConnectionCallbacks connectionCallbacks) {
        this.zzfru.registerConnectionCallbacks(connectionCallbacks);
    }

    public final void registerConnectionFailedListener(@NonNull OnConnectionFailedListener onConnectionFailedListener) {
        this.zzfru.registerConnectionFailedListener(onConnectionFailedListener);
    }

    public final void stopAutoManage(@NonNull FragmentActivity fragmentActivity) {
        zzce com_google_android_gms_common_api_internal_zzce = new zzce(fragmentActivity);
        if (this.zzfmw >= 0) {
            zzi.zza(com_google_android_gms_common_api_internal_zzce).zzbr(this.zzfmw);
            return;
        }
        throw new IllegalStateException("Called stopAutoManage but automatic lifecycle management is not enabled.");
    }

    public final void unregisterConnectionCallbacks(@NonNull ConnectionCallbacks connectionCallbacks) {
        this.zzfru.unregisterConnectionCallbacks(connectionCallbacks);
    }

    public final void unregisterConnectionFailedListener(@NonNull OnConnectionFailedListener onConnectionFailedListener) {
        this.zzfru.unregisterConnectionFailedListener(onConnectionFailedListener);
    }

    @NonNull
    public final <C extends zze> C zza(@NonNull zzc<C> com_google_android_gms_common_api_Api_zzc_C) {
        zze com_google_android_gms_common_api_Api_zze = (zze) this.zzfsb.get(com_google_android_gms_common_api_Api_zzc_C);
        zzbq.checkNotNull(com_google_android_gms_common_api_Api_zze, "Appropriate Api was not requested.");
        return com_google_android_gms_common_api_Api_zze;
    }

    public final void zza(zzdg com_google_android_gms_common_api_internal_zzdg) {
        this.zzfps.lock();
        try {
            if (this.zzfsg == null) {
                this.zzfsg = new HashSet();
            }
            this.zzfsg.add(com_google_android_gms_common_api_internal_zzdg);
        } finally {
            this.zzfps.unlock();
        }
    }

    public final boolean zza(@NonNull Api<?> api) {
        return this.zzfsb.containsKey(api.zzagf());
    }

    public final boolean zza(zzcu com_google_android_gms_common_api_internal_zzcu) {
        return this.zzfrv != null && this.zzfrv.zza(com_google_android_gms_common_api_internal_zzcu);
    }

    public final void zzags() {
        if (this.zzfrv != null) {
            this.zzfrv.zzags();
        }
    }

    final boolean zzaik() {
        if (!this.zzfrw) {
            return false;
        }
        this.zzfrw = false;
        this.zzfrz.removeMessages(2);
        this.zzfrz.removeMessages(1);
        if (this.zzfsa != null) {
            this.zzfsa.unregister();
            this.zzfsa = null;
        }
        return true;
    }

    final boolean zzail() {
        this.zzfps.lock();
        try {
            if (this.zzfsg == null) {
                return false;
            }
            boolean isEmpty = this.zzfsg.isEmpty() ^ 1;
            this.zzfps.unlock();
            return isEmpty;
        } finally {
            this.zzfps.unlock();
        }
    }

    final String zzaim() {
        Writer stringWriter = new StringWriter();
        dump("", null, new PrintWriter(stringWriter), null);
        return stringWriter.toString();
    }

    public final void zzb(zzdg com_google_android_gms_common_api_internal_zzdg) {
        this.zzfps.lock();
        try {
            String str;
            String str2;
            Throwable exception;
            if (this.zzfsg == null) {
                str = "GoogleApiClientImpl";
                str2 = "Attempted to remove pending transform when no transforms are registered.";
                exception = new Exception();
            } else if (this.zzfsg.remove(com_google_android_gms_common_api_internal_zzdg)) {
                if (!zzail()) {
                    this.zzfrv.zzahk();
                }
                this.zzfps.unlock();
            } else {
                str = "GoogleApiClientImpl";
                str2 = "Failed to remove pending transform - this may lead to memory leaks!";
                exception = new Exception();
            }
            Log.wtf(str, str2, exception);
            this.zzfps.unlock();
        } catch (Throwable th) {
            this.zzfps.unlock();
        }
    }

    public final void zzc(ConnectionResult connectionResult) {
        if (!zzf.zze(this.mContext, connectionResult.getErrorCode())) {
            zzaik();
        }
        if (!this.zzfrw) {
            this.zzfru.zzk(connectionResult);
            this.zzfru.zzali();
        }
    }

    public final <A extends zzb, R extends Result, T extends zzm<R, A>> T zzd(@NonNull T t) {
        zzbq.checkArgument(t.zzagf() != null, "This task can not be enqueued (it's probably a Batch or malformed)");
        boolean containsKey = this.zzfsb.containsKey(t.zzagf());
        String name = t.zzagl() != null ? t.zzagl().getName() : "the API";
        StringBuilder stringBuilder = new StringBuilder(65 + String.valueOf(name).length());
        stringBuilder.append("GoogleApiClient is not configured to use ");
        stringBuilder.append(name);
        stringBuilder.append(" required for this call.");
        zzbq.checkArgument(containsKey, stringBuilder.toString());
        this.zzfps.lock();
        try {
            if (this.zzfrv == null) {
                this.zzfqg.add(t);
            } else {
                t = this.zzfrv.zzd(t);
            }
            this.zzfps.unlock();
            return t;
        } catch (Throwable th) {
            this.zzfps.unlock();
        }
    }

    public final <A extends zzb, T extends zzm<? extends Result, A>> T zze(@NonNull T t) {
        zzbq.checkArgument(t.zzagf() != null, "This task can not be executed (it's probably a Batch or malformed)");
        boolean containsKey = this.zzfsb.containsKey(t.zzagf());
        String name = t.zzagl() != null ? t.zzagl().getName() : "the API";
        StringBuilder stringBuilder = new StringBuilder(65 + String.valueOf(name).length());
        stringBuilder.append("GoogleApiClient is not configured to use ");
        stringBuilder.append(name);
        stringBuilder.append(" required for this call.");
        zzbq.checkArgument(containsKey, stringBuilder.toString());
        this.zzfps.lock();
        try {
            if (this.zzfrv == null) {
                throw new IllegalStateException("GoogleApiClient is not connected yet.");
            }
            if (this.zzfrw) {
                this.zzfqg.add(t);
                while (!this.zzfqg.isEmpty()) {
                    zzm com_google_android_gms_common_api_internal_zzm = (zzm) this.zzfqg.remove();
                    this.zzfsh.zzb(com_google_android_gms_common_api_internal_zzm);
                    com_google_android_gms_common_api_internal_zzm.zzu(Status.zzfnk);
                }
            } else {
                t = this.zzfrv.zze(t);
            }
            this.zzfps.unlock();
            return t;
        } catch (Throwable th) {
            this.zzfps.unlock();
        }
    }

    public final void zzf(int i, boolean z) {
        if (!(i != 1 || z || this.zzfrw)) {
            this.zzfrw = true;
            if (this.zzfsa == null) {
                this.zzfsa = GoogleApiAvailability.zza(this.mContext.getApplicationContext(), new zzbg(this));
            }
            this.zzfrz.sendMessageDelayed(this.zzfrz.obtainMessage(1), this.zzfrx);
            this.zzfrz.sendMessageDelayed(this.zzfrz.obtainMessage(2), this.zzfry);
        }
        this.zzfsh.zzaju();
        this.zzfru.zzcg(i);
        this.zzfru.zzali();
        if (i == 2) {
            zzaii();
        }
    }

    public final void zzj(Bundle bundle) {
        while (!this.zzfqg.isEmpty()) {
            zze((zzm) this.zzfqg.remove());
        }
        this.zzfru.zzk(bundle);
    }

    public final <L> zzci<L> zzt(@NonNull L l) {
        this.zzfps.lock();
        try {
            zzci<L> zza = this.zzfsd.zza(l, this.zzall, "NO_TYPE");
            return zza;
        } finally {
            this.zzfps.unlock();
        }
    }
}
