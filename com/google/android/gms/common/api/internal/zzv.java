package com.google.android.gms.common.api.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.util.ArrayMap;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.zza;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.Api.zze;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.common.internal.zzr;
import com.google.android.gms.common.zzf;
import com.google.android.gms.internal.zzcxd;
import com.google.android.gms.internal.zzcxe;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

final class zzv implements zzcc {
    private final Context mContext;
    private final Looper zzall;
    private final zzba zzfpi;
    private final zzbi zzfpj;
    private final zzbi zzfpk;
    private final Map<zzc<?>, zzbi> zzfpl;
    private final Set<zzcu> zzfpm = Collections.newSetFromMap(new WeakHashMap());
    private final zze zzfpn;
    private Bundle zzfpo;
    private ConnectionResult zzfpp = null;
    private ConnectionResult zzfpq = null;
    private boolean zzfpr = false;
    private final Lock zzfps;
    private int zzfpt = 0;

    private zzv(Context context, zzba com_google_android_gms_common_api_internal_zzba, Lock lock, Looper looper, zzf com_google_android_gms_common_zzf, Map<zzc<?>, zze> map, Map<zzc<?>, zze> map2, zzr com_google_android_gms_common_internal_zzr, zza<? extends zzcxd, zzcxe> com_google_android_gms_common_api_Api_zza__extends_com_google_android_gms_internal_zzcxd__com_google_android_gms_internal_zzcxe, zze com_google_android_gms_common_api_Api_zze, ArrayList<zzt> arrayList, ArrayList<zzt> arrayList2, Map<Api<?>, Boolean> map3, Map<Api<?>, Boolean> map4) {
        Context context2 = context;
        this.mContext = context2;
        this.zzfpi = com_google_android_gms_common_api_internal_zzba;
        Lock lock2 = lock;
        this.zzfps = lock2;
        Looper looper2 = looper;
        this.zzall = looper2;
        this.zzfpn = com_google_android_gms_common_api_Api_zze;
        Context context3 = context2;
        Lock lock3 = lock2;
        zzf com_google_android_gms_common_zzf2 = com_google_android_gms_common_zzf;
        zzbi com_google_android_gms_common_api_internal_zzbi = r3;
        zzbi com_google_android_gms_common_api_internal_zzbi2 = new zzbi(context3, this.zzfpi, lock3, looper2, com_google_android_gms_common_zzf2, map2, null, map4, null, arrayList2, new zzx());
        this.zzfpj = com_google_android_gms_common_api_internal_zzbi;
        this.zzfpk = new zzbi(context3, this.zzfpi, lock3, looper, com_google_android_gms_common_zzf2, map, com_google_android_gms_common_internal_zzr, map3, com_google_android_gms_common_api_Api_zza__extends_com_google_android_gms_internal_zzcxd__com_google_android_gms_internal_zzcxe, arrayList, new zzy());
        Map arrayMap = new ArrayMap();
        for (zzc put : map2.keySet()) {
            arrayMap.put(put, r0.zzfpj);
        }
        for (zzc put2 : map.keySet()) {
            arrayMap.put(put2, r0.zzfpk);
        }
        r0.zzfpl = Collections.unmodifiableMap(arrayMap);
    }

    public static zzv zza(Context context, zzba com_google_android_gms_common_api_internal_zzba, Lock lock, Looper looper, zzf com_google_android_gms_common_zzf, Map<zzc<?>, zze> map, zzr com_google_android_gms_common_internal_zzr, Map<Api<?>, Boolean> map2, zza<? extends zzcxd, zzcxe> com_google_android_gms_common_api_Api_zza__extends_com_google_android_gms_internal_zzcxd__com_google_android_gms_internal_zzcxe, ArrayList<zzt> arrayList) {
        Map<Api<?>, Boolean> map3 = map2;
        Map arrayMap = new ArrayMap();
        Map arrayMap2 = new ArrayMap();
        zze com_google_android_gms_common_api_Api_zze = null;
        for (Entry entry : map.entrySet()) {
            zze com_google_android_gms_common_api_Api_zze2 = (zze) entry.getValue();
            if (com_google_android_gms_common_api_Api_zze2.zzabj()) {
                com_google_android_gms_common_api_Api_zze = com_google_android_gms_common_api_Api_zze2;
            }
            if (com_google_android_gms_common_api_Api_zze2.zzaay()) {
                arrayMap.put((zzc) entry.getKey(), com_google_android_gms_common_api_Api_zze2);
            } else {
                arrayMap2.put((zzc) entry.getKey(), com_google_android_gms_common_api_Api_zze2);
            }
        }
        zzbq.zza(arrayMap.isEmpty() ^ 1, (Object) "CompositeGoogleApiClient should not be used without any APIs that require sign-in.");
        Map arrayMap3 = new ArrayMap();
        Map arrayMap4 = new ArrayMap();
        for (Api api : map2.keySet()) {
            zzc zzagf = api.zzagf();
            if (arrayMap.containsKey(zzagf)) {
                arrayMap3.put(api, (Boolean) map3.get(api));
            } else if (arrayMap2.containsKey(zzagf)) {
                arrayMap4.put(api, (Boolean) map3.get(api));
            } else {
                throw new IllegalStateException("Each API in the isOptionalMap must have a corresponding client in the clients map.");
            }
        }
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = arrayList;
        int size = arrayList4.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList4.get(i);
            i++;
            zzt com_google_android_gms_common_api_internal_zzt = (zzt) obj;
            if (arrayMap3.containsKey(com_google_android_gms_common_api_internal_zzt.zzfin)) {
                arrayList2.add(com_google_android_gms_common_api_internal_zzt);
            } else if (arrayMap4.containsKey(com_google_android_gms_common_api_internal_zzt.zzfin)) {
                arrayList3.add(com_google_android_gms_common_api_internal_zzt);
            } else {
                throw new IllegalStateException("Each ClientCallbacks must have a corresponding API in the isOptionalMap");
            }
        }
        return new zzv(context, com_google_android_gms_common_api_internal_zzba, lock, looper, com_google_android_gms_common_zzf, arrayMap, arrayMap2, com_google_android_gms_common_internal_zzr, com_google_android_gms_common_api_Api_zza__extends_com_google_android_gms_internal_zzcxd__com_google_android_gms_internal_zzcxe, com_google_android_gms_common_api_Api_zze, arrayList2, arrayList3, arrayMap3, arrayMap4);
    }

    private final void zza(ConnectionResult connectionResult) {
        switch (this.zzfpt) {
            case 1:
                break;
            case 2:
                this.zzfpi.zzc(connectionResult);
                break;
            default:
                Log.wtf("CompositeGAC", "Attempted to call failure callbacks in CONNECTION_MODE_NONE. Callbacks should be disabled via GmsClientSupervisor", new Exception());
                break;
        }
        zzahm();
        this.zzfpt = 0;
    }

    private final void zzahl() {
        if (zzb(this.zzfpp)) {
            if (!zzb(this.zzfpq)) {
                if (!zzahn()) {
                    if (this.zzfpq != null) {
                        if (this.zzfpt == 1) {
                            zzahm();
                            return;
                        }
                        zza(this.zzfpq);
                        this.zzfpj.disconnect();
                        return;
                    }
                }
            }
            switch (this.zzfpt) {
                case 1:
                    break;
                case 2:
                    this.zzfpi.zzj(this.zzfpo);
                    break;
                default:
                    Log.wtf("CompositeGAC", "Attempted to call success callbacks in CONNECTION_MODE_NONE. Callbacks should be disabled via GmsClientSupervisor", new AssertionError());
                    break;
            }
            zzahm();
            this.zzfpt = 0;
        } else if (this.zzfpp != null && zzb(this.zzfpq)) {
            this.zzfpk.disconnect();
            zza(this.zzfpp);
        } else if (!(this.zzfpp == null || this.zzfpq == null)) {
            ConnectionResult connectionResult = this.zzfpp;
            if (this.zzfpk.zzfst < this.zzfpj.zzfst) {
                connectionResult = this.zzfpq;
            }
            zza(connectionResult);
        }
    }

    private final void zzahm() {
        for (zzcu zzabi : this.zzfpm) {
            zzabi.zzabi();
        }
        this.zzfpm.clear();
    }

    private final boolean zzahn() {
        return this.zzfpq != null && this.zzfpq.getErrorCode() == 4;
    }

    @Nullable
    private final PendingIntent zzaho() {
        return this.zzfpn == null ? null : PendingIntent.getActivity(this.mContext, System.identityHashCode(this.zzfpi), this.zzfpn.getSignInIntent(), 134217728);
    }

    private static boolean zzb(ConnectionResult connectionResult) {
        return connectionResult != null && connectionResult.isSuccess();
    }

    private final void zze(int i, boolean z) {
        this.zzfpi.zzf(i, z);
        this.zzfpq = null;
        this.zzfpp = null;
    }

    private final boolean zzf(zzm<? extends Result, ? extends zzb> com_google_android_gms_common_api_internal_zzm__extends_com_google_android_gms_common_api_Result___extends_com_google_android_gms_common_api_Api_zzb) {
        zzc zzagf = com_google_android_gms_common_api_internal_zzm__extends_com_google_android_gms_common_api_Result___extends_com_google_android_gms_common_api_Api_zzb.zzagf();
        zzbq.checkArgument(this.zzfpl.containsKey(zzagf), "GoogleApiClient is not configured to use the API required for this call.");
        return ((zzbi) this.zzfpl.get(zzagf)).equals(this.zzfpk);
    }

    private final void zzi(Bundle bundle) {
        if (this.zzfpo == null) {
            this.zzfpo = bundle;
            return;
        }
        if (bundle != null) {
            this.zzfpo.putAll(bundle);
        }
    }

    public final ConnectionResult blockingConnect() {
        throw new UnsupportedOperationException();
    }

    public final ConnectionResult blockingConnect(long j, @NonNull TimeUnit timeUnit) {
        throw new UnsupportedOperationException();
    }

    public final void connect() {
        this.zzfpt = 2;
        this.zzfpr = false;
        this.zzfpq = null;
        this.zzfpp = null;
        this.zzfpj.connect();
        this.zzfpk.connect();
    }

    public final void disconnect() {
        this.zzfpq = null;
        this.zzfpp = null;
        this.zzfpt = 0;
        this.zzfpj.disconnect();
        this.zzfpk.disconnect();
        zzahm();
    }

    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.append(str).append("authClient").println(":");
        this.zzfpk.dump(String.valueOf(str).concat("  "), fileDescriptor, printWriter, strArr);
        printWriter.append(str).append("anonClient").println(":");
        this.zzfpj.dump(String.valueOf(str).concat("  "), fileDescriptor, printWriter, strArr);
    }

    @Nullable
    public final ConnectionResult getConnectionResult(@NonNull Api<?> api) {
        return ((zzbi) this.zzfpl.get(api.zzagf())).equals(this.zzfpk) ? zzahn() ? new ConnectionResult(4, zzaho()) : this.zzfpk.getConnectionResult(api) : this.zzfpj.getConnectionResult(api);
    }

    public final boolean isConnected() {
        this.zzfps.lock();
        try {
            boolean z = true;
            if (this.zzfpj.isConnected()) {
                if (!(this.zzfpk.isConnected() || zzahn())) {
                    if (this.zzfpt == 1) {
                    }
                }
                this.zzfps.unlock();
                return z;
            }
            z = false;
            this.zzfps.unlock();
            return z;
        } catch (Throwable th) {
            this.zzfps.unlock();
        }
    }

    public final boolean isConnecting() {
        this.zzfps.lock();
        try {
            boolean z = this.zzfpt == 2;
            this.zzfps.unlock();
            return z;
        } catch (Throwable th) {
            this.zzfps.unlock();
        }
    }

    public final boolean zza(zzcu com_google_android_gms_common_api_internal_zzcu) {
        this.zzfps.lock();
        boolean z;
        try {
            if ((isConnecting() || isConnected()) && !this.zzfpk.isConnected()) {
                this.zzfpm.add(com_google_android_gms_common_api_internal_zzcu);
                z = true;
                if (this.zzfpt == 0) {
                    this.zzfpt = 1;
                }
                this.zzfpq = null;
                this.zzfpk.connect();
                return z;
            }
            this.zzfps.unlock();
            return false;
        } finally {
            z = this.zzfps;
            z.unlock();
        }
    }

    public final void zzags() {
        this.zzfps.lock();
        try {
            boolean isConnecting = isConnecting();
            this.zzfpk.disconnect();
            this.zzfpq = new ConnectionResult(4);
            if (isConnecting) {
                new Handler(this.zzall).post(new zzw(this));
            } else {
                zzahm();
            }
            this.zzfps.unlock();
        } catch (Throwable th) {
            this.zzfps.unlock();
        }
    }

    public final void zzahk() {
        this.zzfpj.zzahk();
        this.zzfpk.zzahk();
    }

    public final <A extends zzb, R extends Result, T extends zzm<R, A>> T zzd(@NonNull T t) {
        if (!zzf((zzm) t)) {
            return this.zzfpj.zzd(t);
        }
        if (!zzahn()) {
            return this.zzfpk.zzd(t);
        }
        t.zzu(new Status(4, null, zzaho()));
        return t;
    }

    public final <A extends zzb, T extends zzm<? extends Result, A>> T zze(@NonNull T t) {
        if (!zzf((zzm) t)) {
            return this.zzfpj.zze(t);
        }
        if (!zzahn()) {
            return this.zzfpk.zze(t);
        }
        t.zzu(new Status(4, null, zzaho()));
        return t;
    }
}
