package com.google.android.gms.common.api;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.util.ArrayMap;
import android.view.View;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.api.Api.ApiOptions.HasOptions;
import com.google.android.gms.common.api.Api.ApiOptions.NotRequiredOptions;
import com.google.android.gms.common.api.Api.zza;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.Api.zzd;
import com.google.android.gms.common.api.Api.zze;
import com.google.android.gms.common.api.internal.zzba;
import com.google.android.gms.common.api.internal.zzce;
import com.google.android.gms.common.api.internal.zzci;
import com.google.android.gms.common.api.internal.zzcu;
import com.google.android.gms.common.api.internal.zzdg;
import com.google.android.gms.common.api.internal.zzi;
import com.google.android.gms.common.api.internal.zzm;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.common.internal.zzr;
import com.google.android.gms.common.internal.zzt;
import com.google.android.gms.internal.zzcxa;
import com.google.android.gms.internal.zzcxd;
import com.google.android.gms.internal.zzcxe;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public abstract class GoogleApiClient {
    public static final int SIGN_IN_MODE_OPTIONAL = 2;
    public static final int SIGN_IN_MODE_REQUIRED = 1;
    private static final Set<GoogleApiClient> zzfmn = Collections.newSetFromMap(new WeakHashMap());

    public static final class Builder {
        private final Context mContext;
        private Looper zzall;
        private String zzebs;
        private Account zzebz;
        private final Set<Scope> zzfmo;
        private final Set<Scope> zzfmp;
        private int zzfmq;
        private View zzfmr;
        private String zzfms;
        private final Map<Api<?>, zzt> zzfmt;
        private final Map<Api<?>, ApiOptions> zzfmu;
        private zzce zzfmv;
        private int zzfmw;
        private OnConnectionFailedListener zzfmx;
        private GoogleApiAvailability zzfmy;
        private zza<? extends zzcxd, zzcxe> zzfmz;
        private final ArrayList<ConnectionCallbacks> zzfna;
        private final ArrayList<OnConnectionFailedListener> zzfnb;
        private boolean zzfnc;

        public Builder(@NonNull Context context) {
            this.zzfmo = new HashSet();
            this.zzfmp = new HashSet();
            this.zzfmt = new ArrayMap();
            this.zzfmu = new ArrayMap();
            this.zzfmw = -1;
            this.zzfmy = GoogleApiAvailability.getInstance();
            this.zzfmz = zzcxa.zzebg;
            this.zzfna = new ArrayList();
            this.zzfnb = new ArrayList();
            this.zzfnc = false;
            this.mContext = context;
            this.zzall = context.getMainLooper();
            this.zzebs = context.getPackageName();
            this.zzfms = context.getClass().getName();
        }

        public Builder(@NonNull Context context, @NonNull ConnectionCallbacks connectionCallbacks, @NonNull OnConnectionFailedListener onConnectionFailedListener) {
            this(context);
            zzbq.checkNotNull(connectionCallbacks, "Must provide a connected listener");
            this.zzfna.add(connectionCallbacks);
            zzbq.checkNotNull(onConnectionFailedListener, "Must provide a connection failed listener");
            this.zzfnb.add(onConnectionFailedListener);
        }

        private final <O extends ApiOptions> void zza(Api<O> api, O o, Scope... scopeArr) {
            Set hashSet = new HashSet(api.zzagd().zzr(o));
            for (Object add : scopeArr) {
                hashSet.add(add);
            }
            this.zzfmt.put(api, new zzt(hashSet));
        }

        public final Builder addApi(@NonNull Api<? extends NotRequiredOptions> api) {
            zzbq.checkNotNull(api, "Api must not be null");
            this.zzfmu.put(api, null);
            Collection zzr = api.zzagd().zzr(null);
            this.zzfmp.addAll(zzr);
            this.zzfmo.addAll(zzr);
            return this;
        }

        public final <O extends HasOptions> Builder addApi(@NonNull Api<O> api, @NonNull O o) {
            zzbq.checkNotNull(api, "Api must not be null");
            zzbq.checkNotNull(o, "Null options are not permitted for this Api");
            this.zzfmu.put(api, o);
            Collection zzr = api.zzagd().zzr(o);
            this.zzfmp.addAll(zzr);
            this.zzfmo.addAll(zzr);
            return this;
        }

        public final <O extends HasOptions> Builder addApiIfAvailable(@NonNull Api<O> api, @NonNull O o, Scope... scopeArr) {
            zzbq.checkNotNull(api, "Api must not be null");
            zzbq.checkNotNull(o, "Null options are not permitted for this Api");
            this.zzfmu.put(api, o);
            zza(api, o, scopeArr);
            return this;
        }

        public final Builder addApiIfAvailable(@NonNull Api<? extends NotRequiredOptions> api, Scope... scopeArr) {
            zzbq.checkNotNull(api, "Api must not be null");
            this.zzfmu.put(api, null);
            zza(api, null, scopeArr);
            return this;
        }

        public final Builder addConnectionCallbacks(@NonNull ConnectionCallbacks connectionCallbacks) {
            zzbq.checkNotNull(connectionCallbacks, "Listener must not be null");
            this.zzfna.add(connectionCallbacks);
            return this;
        }

        public final Builder addOnConnectionFailedListener(@NonNull OnConnectionFailedListener onConnectionFailedListener) {
            zzbq.checkNotNull(onConnectionFailedListener, "Listener must not be null");
            this.zzfnb.add(onConnectionFailedListener);
            return this;
        }

        public final Builder addScope(@NonNull Scope scope) {
            zzbq.checkNotNull(scope, "Scope must not be null");
            this.zzfmo.add(scope);
            return this;
        }

        public final GoogleApiClient build() {
            boolean z;
            boolean z2 = true;
            zzbq.checkArgument(this.zzfmu.isEmpty() ^ true, "must call addApi() to add at least one API");
            zzr zzagu = zzagu();
            Api api = null;
            Map zzakx = zzagu.zzakx();
            Map arrayMap = new ArrayMap();
            Map arrayMap2 = new ArrayMap();
            ArrayList arrayList = new ArrayList();
            Iterator it = this.zzfmu.keySet().iterator();
            int i = 0;
            while (it.hasNext()) {
                Api api2 = (Api) it.next();
                Object obj = r1.zzfmu.get(api2);
                boolean z3 = zzakx.get(api2) != null ? z2 : false;
                arrayMap.put(api2, Boolean.valueOf(z3));
                com.google.android.gms.common.api.internal.zzt com_google_android_gms_common_api_internal_zzt = new com.google.android.gms.common.api.internal.zzt(api2, z3);
                arrayList.add(com_google_android_gms_common_api_internal_zzt);
                zzd zzage = api2.zzage();
                zzd com_google_android_gms_common_api_Api_zzd = zzage;
                com.google.android.gms.common.api.internal.zzt com_google_android_gms_common_api_internal_zzt2 = com_google_android_gms_common_api_internal_zzt;
                Map map = zzakx;
                Api api3 = api2;
                Iterator it2 = it;
                zze zza = zzage.zza(r1.mContext, r1.zzall, zzagu, obj, com_google_android_gms_common_api_internal_zzt2, com_google_android_gms_common_api_internal_zzt2);
                arrayMap2.put(api3.zzagf(), zza);
                if (com_google_android_gms_common_api_Api_zzd.getPriority() == 1) {
                    i = obj != null ? 1 : 0;
                }
                if (zza.zzabj()) {
                    if (api != null) {
                        String name = api3.getName();
                        String name2 = api.getName();
                        StringBuilder stringBuilder = new StringBuilder((21 + String.valueOf(name).length()) + String.valueOf(name2).length());
                        stringBuilder.append(name);
                        stringBuilder.append(" cannot be used with ");
                        stringBuilder.append(name2);
                        throw new IllegalStateException(stringBuilder.toString());
                    }
                    api = api3;
                }
                zzakx = map;
                it = it2;
                z2 = true;
            }
            if (api == null) {
                z = true;
            } else if (i != 0) {
                name = api.getName();
                StringBuilder stringBuilder2 = new StringBuilder(82 + String.valueOf(name).length());
                stringBuilder2.append("With using ");
                stringBuilder2.append(name);
                stringBuilder2.append(", GamesOptions can only be specified within GoogleSignInOptions.Builder");
                throw new IllegalStateException(stringBuilder2.toString());
            } else {
                z = true;
                zzbq.zza(r1.zzebz == null, "Must not set an account in GoogleApiClient.Builder when using %s. Set account in GoogleSignInOptions.Builder instead", api.getName());
                zzbq.zza(r1.zzfmo.equals(r1.zzfmp), "Must not set scopes in GoogleApiClient.Builder when using %s. Set account in GoogleSignInOptions.Builder instead.", api.getName());
            }
            zzr com_google_android_gms_common_internal_zzr = zzagu;
            GoogleApiClient com_google_android_gms_common_api_internal_zzba = new zzba(r1.mContext, new ReentrantLock(), r1.zzall, com_google_android_gms_common_internal_zzr, r1.zzfmy, r1.zzfmz, arrayMap, r1.zzfna, r1.zzfnb, arrayMap2, r1.zzfmw, zzba.zza(arrayMap2.values(), z), arrayList, false);
            synchronized (GoogleApiClient.zzfmn) {
                try {
                    GoogleApiClient.zzfmn.add(com_google_android_gms_common_api_internal_zzba);
                } catch (Throwable th) {
                    while (true) {
                        Throwable th2 = th;
                    }
                }
            }
            if (r1.zzfmw >= 0) {
                zzi.zza(r1.zzfmv).zza(r1.zzfmw, com_google_android_gms_common_api_internal_zzba, r1.zzfmx);
            }
            return com_google_android_gms_common_api_internal_zzba;
        }

        public final Builder enableAutoManage(@NonNull FragmentActivity fragmentActivity, int i, @Nullable OnConnectionFailedListener onConnectionFailedListener) {
            zzce com_google_android_gms_common_api_internal_zzce = new zzce(fragmentActivity);
            zzbq.checkArgument(i >= 0, "clientId must be non-negative");
            this.zzfmw = i;
            this.zzfmx = onConnectionFailedListener;
            this.zzfmv = com_google_android_gms_common_api_internal_zzce;
            return this;
        }

        public final Builder enableAutoManage(@NonNull FragmentActivity fragmentActivity, @Nullable OnConnectionFailedListener onConnectionFailedListener) {
            return enableAutoManage(fragmentActivity, 0, onConnectionFailedListener);
        }

        public final Builder setAccountName(String str) {
            this.zzebz = str == null ? null : new Account(str, "com.google");
            return this;
        }

        public final Builder setGravityForPopups(int i) {
            this.zzfmq = i;
            return this;
        }

        public final Builder setHandler(@NonNull Handler handler) {
            zzbq.checkNotNull(handler, "Handler must not be null");
            this.zzall = handler.getLooper();
            return this;
        }

        public final Builder setViewForPopups(@NonNull View view) {
            zzbq.checkNotNull(view, "View must not be null");
            this.zzfmr = view;
            return this;
        }

        public final Builder useDefaultAccount() {
            return setAccountName("<<default account>>");
        }

        public final zzr zzagu() {
            zzcxe com_google_android_gms_internal_zzcxe = zzcxe.zzkbs;
            if (this.zzfmu.containsKey(zzcxa.API)) {
                com_google_android_gms_internal_zzcxe = (zzcxe) this.zzfmu.get(zzcxa.API);
            }
            return new zzr(this.zzebz, this.zzfmo, this.zzfmt, this.zzfmq, this.zzfmr, this.zzebs, this.zzfms, com_google_android_gms_internal_zzcxe);
        }
    }

    public interface ConnectionCallbacks {
        public static final int CAUSE_NETWORK_LOST = 2;
        public static final int CAUSE_SERVICE_DISCONNECTED = 1;

        void onConnected(@Nullable Bundle bundle);

        void onConnectionSuspended(int i);
    }

    public interface OnConnectionFailedListener {
        void onConnectionFailed(@NonNull ConnectionResult connectionResult);
    }

    public static void dumpAll(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        synchronized (zzfmn) {
            int i = 0;
            String concat = String.valueOf(str).concat("  ");
            for (GoogleApiClient googleApiClient : zzfmn) {
                int i2 = i + 1;
                printWriter.append(str).append("GoogleApiClient#").println(i);
                googleApiClient.dump(concat, fileDescriptor, printWriter, strArr);
                i = i2;
            }
        }
    }

    public static Set<GoogleApiClient> zzagr() {
        Set<GoogleApiClient> set;
        synchronized (zzfmn) {
            set = zzfmn;
        }
        return set;
    }

    public abstract ConnectionResult blockingConnect();

    public abstract ConnectionResult blockingConnect(long j, @NonNull TimeUnit timeUnit);

    public abstract PendingResult<Status> clearDefaultAccountAndReconnect();

    public abstract void connect();

    public void connect(int i) {
        throw new UnsupportedOperationException();
    }

    public abstract void disconnect();

    public abstract void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    @NonNull
    public abstract ConnectionResult getConnectionResult(@NonNull Api<?> api);

    public Context getContext() {
        throw new UnsupportedOperationException();
    }

    public Looper getLooper() {
        throw new UnsupportedOperationException();
    }

    public abstract boolean hasConnectedApi(@NonNull Api<?> api);

    public abstract boolean isConnected();

    public abstract boolean isConnecting();

    public abstract boolean isConnectionCallbacksRegistered(@NonNull ConnectionCallbacks connectionCallbacks);

    public abstract boolean isConnectionFailedListenerRegistered(@NonNull OnConnectionFailedListener onConnectionFailedListener);

    public abstract void reconnect();

    public abstract void registerConnectionCallbacks(@NonNull ConnectionCallbacks connectionCallbacks);

    public abstract void registerConnectionFailedListener(@NonNull OnConnectionFailedListener onConnectionFailedListener);

    public abstract void stopAutoManage(@NonNull FragmentActivity fragmentActivity);

    public abstract void unregisterConnectionCallbacks(@NonNull ConnectionCallbacks connectionCallbacks);

    public abstract void unregisterConnectionFailedListener(@NonNull OnConnectionFailedListener onConnectionFailedListener);

    @NonNull
    public <C extends zze> C zza(@NonNull zzc<C> com_google_android_gms_common_api_Api_zzc_C) {
        throw new UnsupportedOperationException();
    }

    public void zza(zzdg com_google_android_gms_common_api_internal_zzdg) {
        throw new UnsupportedOperationException();
    }

    public boolean zza(@NonNull Api<?> api) {
        throw new UnsupportedOperationException();
    }

    public boolean zza(zzcu com_google_android_gms_common_api_internal_zzcu) {
        throw new UnsupportedOperationException();
    }

    public void zzags() {
        throw new UnsupportedOperationException();
    }

    public void zzb(zzdg com_google_android_gms_common_api_internal_zzdg) {
        throw new UnsupportedOperationException();
    }

    public <A extends zzb, R extends Result, T extends zzm<R, A>> T zzd(@NonNull T t) {
        throw new UnsupportedOperationException();
    }

    public <A extends zzb, T extends zzm<? extends Result, A>> T zze(@NonNull T t) {
        throw new UnsupportedOperationException();
    }

    public <L> zzci<L> zzt(@NonNull L l) {
        throw new UnsupportedOperationException();
    }
}
