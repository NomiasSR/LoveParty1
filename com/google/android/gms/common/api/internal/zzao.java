package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.zza;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.Api.zze;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.zzan;
import com.google.android.gms.common.internal.zzbt;
import com.google.android.gms.common.internal.zzr;
import com.google.android.gms.common.internal.zzt;
import com.google.android.gms.common.zzf;
import com.google.android.gms.internal.zzcxd;
import com.google.android.gms.internal.zzcxe;
import com.google.android.gms.internal.zzcxq;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Future;
import java.util.concurrent.locks.Lock;

public final class zzao implements zzbh {
    private final Context mContext;
    private final zza<? extends zzcxd, zzcxe> zzfmz;
    private final Lock zzfps;
    private final zzr zzfpx;
    private final Map<Api<?>, Boolean> zzfqa;
    private final zzf zzfqc;
    private ConnectionResult zzfql;
    private final zzbi zzfqv;
    private int zzfqy;
    private int zzfqz = 0;
    private int zzfra;
    private final Bundle zzfrb = new Bundle();
    private final Set<zzc> zzfrc = new HashSet();
    private zzcxd zzfrd;
    private boolean zzfre;
    private boolean zzfrf;
    private boolean zzfrg;
    private zzan zzfrh;
    private boolean zzfri;
    private boolean zzfrj;
    private ArrayList<Future<?>> zzfrk = new ArrayList();

    public zzao(zzbi com_google_android_gms_common_api_internal_zzbi, zzr com_google_android_gms_common_internal_zzr, Map<Api<?>, Boolean> map, zzf com_google_android_gms_common_zzf, zza<? extends zzcxd, zzcxe> com_google_android_gms_common_api_Api_zza__extends_com_google_android_gms_internal_zzcxd__com_google_android_gms_internal_zzcxe, Lock lock, Context context) {
        this.zzfqv = com_google_android_gms_common_api_internal_zzbi;
        this.zzfpx = com_google_android_gms_common_internal_zzr;
        this.zzfqa = map;
        this.zzfqc = com_google_android_gms_common_zzf;
        this.zzfmz = com_google_android_gms_common_api_Api_zza__extends_com_google_android_gms_internal_zzcxd__com_google_android_gms_internal_zzcxe;
        this.zzfps = lock;
        this.mContext = context;
    }

    private final void zza(zzcxq com_google_android_gms_internal_zzcxq) {
        if (zzbt(0)) {
            ConnectionResult zzahf = com_google_android_gms_internal_zzcxq.zzahf();
            if (zzahf.isSuccess()) {
                zzbt zzbdi = com_google_android_gms_internal_zzcxq.zzbdi();
                zzahf = zzbdi.zzahf();
                if (zzahf.isSuccess()) {
                    this.zzfrg = true;
                    this.zzfrh = zzbdi.zzalp();
                    this.zzfri = zzbdi.zzalq();
                    this.zzfrj = zzbdi.zzalr();
                    zzaid();
                    return;
                }
                String valueOf = String.valueOf(zzahf);
                StringBuilder stringBuilder = new StringBuilder(48 + String.valueOf(valueOf).length());
                stringBuilder.append("Sign-in succeeded with resolve account failure: ");
                stringBuilder.append(valueOf);
                Log.wtf("GoogleApiClientConnecting", stringBuilder.toString(), new Exception());
                zze(zzahf);
            } else if (zzd(zzahf)) {
                zzaif();
                zzaid();
            } else {
                zze(zzahf);
            }
        }
    }

    private final boolean zzaic() {
        this.zzfra--;
        if (this.zzfra > 0) {
            return false;
        }
        ConnectionResult connectionResult;
        if (this.zzfra < 0) {
            Log.w("GoogleApiClientConnecting", this.zzfqv.zzfpi.zzaim());
            Log.wtf("GoogleApiClientConnecting", "GoogleApiClient received too many callbacks for the given step. Clients may be in an unexpected state; GoogleApiClient will now disconnect.", new Exception());
            connectionResult = new ConnectionResult(8, null);
        } else if (this.zzfql == null) {
            return true;
        } else {
            this.zzfqv.zzfst = this.zzfqy;
            connectionResult = this.zzfql;
        }
        zze(connectionResult);
        return false;
    }

    private final void zzaid() {
        if (this.zzfra == 0) {
            if (!this.zzfrf || this.zzfrg) {
                ArrayList arrayList = new ArrayList();
                this.zzfqz = 1;
                this.zzfra = this.zzfqv.zzfsb.size();
                for (zzc com_google_android_gms_common_api_Api_zzc : this.zzfqv.zzfsb.keySet()) {
                    if (!this.zzfqv.zzfsq.containsKey(com_google_android_gms_common_api_Api_zzc)) {
                        arrayList.add((zze) this.zzfqv.zzfsb.get(com_google_android_gms_common_api_Api_zzc));
                    } else if (zzaic()) {
                        zzaie();
                    }
                }
                if (!arrayList.isEmpty()) {
                    this.zzfrk.add(zzbl.zzaip().submit(new zzau(this, arrayList)));
                }
            }
        }
    }

    private final void zzaie() {
        this.zzfqv.zzaio();
        zzbl.zzaip().execute(new zzap(this));
        if (this.zzfrd != null) {
            if (this.zzfri) {
                this.zzfrd.zza(this.zzfrh, this.zzfrj);
            }
            zzbg(false);
        }
        for (zzc com_google_android_gms_common_api_Api_zzc : this.zzfqv.zzfsq.keySet()) {
            ((zze) this.zzfqv.zzfsb.get(com_google_android_gms_common_api_Api_zzc)).disconnect();
        }
        this.zzfqv.zzfsu.zzj(this.zzfrb.isEmpty() ? null : this.zzfrb);
    }

    private final void zzaif() {
        this.zzfrf = false;
        this.zzfqv.zzfpi.zzfsc = Collections.emptySet();
        for (zzc com_google_android_gms_common_api_Api_zzc : this.zzfrc) {
            if (!this.zzfqv.zzfsq.containsKey(com_google_android_gms_common_api_Api_zzc)) {
                this.zzfqv.zzfsq.put(com_google_android_gms_common_api_Api_zzc, new ConnectionResult(17, null));
            }
        }
    }

    private final void zzaig() {
        ArrayList arrayList = this.zzfrk;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            ((Future) obj).cancel(true);
        }
        this.zzfrk.clear();
    }

    private final Set<Scope> zzaih() {
        if (this.zzfpx == null) {
            return Collections.emptySet();
        }
        Set<Scope> hashSet = new HashSet(this.zzfpx.zzakv());
        Map zzakx = this.zzfpx.zzakx();
        for (Api api : zzakx.keySet()) {
            if (!this.zzfqv.zzfsq.containsKey(api.zzagf())) {
                hashSet.addAll(((zzt) zzakx.get(api)).zzehs);
            }
        }
        return hashSet;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzb(com.google.android.gms.common.ConnectionResult r5, com.google.android.gms.common.api.Api<?> r6, boolean r7) {
        /*
        r4 = this;
        r0 = r6.zzagd();
        r0 = r0.getPriority();
        r1 = 0;
        r2 = 1;
        if (r7 == 0) goto L_0x0024;
    L_0x000c:
        r7 = r5.hasResolution();
        if (r7 == 0) goto L_0x0014;
    L_0x0012:
        r7 = r2;
        goto L_0x0022;
    L_0x0014:
        r7 = r4.zzfqc;
        r3 = r5.getErrorCode();
        r7 = r7.zzbp(r3);
        if (r7 == 0) goto L_0x0021;
    L_0x0020:
        goto L_0x0012;
    L_0x0021:
        r7 = r1;
    L_0x0022:
        if (r7 == 0) goto L_0x002d;
    L_0x0024:
        r7 = r4.zzfql;
        if (r7 == 0) goto L_0x002c;
    L_0x0028:
        r7 = r4.zzfqy;
        if (r0 >= r7) goto L_0x002d;
    L_0x002c:
        r1 = r2;
    L_0x002d:
        if (r1 == 0) goto L_0x0033;
    L_0x002f:
        r4.zzfql = r5;
        r4.zzfqy = r0;
    L_0x0033:
        r7 = r4.zzfqv;
        r7 = r7.zzfsq;
        r6 = r6.zzagf();
        r7.put(r6, r5);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.internal.zzao.zzb(com.google.android.gms.common.ConnectionResult, com.google.android.gms.common.api.Api, boolean):void");
    }

    private final void zzbg(boolean z) {
        if (this.zzfrd != null) {
            if (this.zzfrd.isConnected() && z) {
                this.zzfrd.zzbdb();
            }
            this.zzfrd.disconnect();
            this.zzfrh = null;
        }
    }

    private final boolean zzbt(int i) {
        if (this.zzfqz == i) {
            return true;
        }
        Log.w("GoogleApiClientConnecting", this.zzfqv.zzfpi.zzaim());
        String valueOf = String.valueOf(this);
        StringBuilder stringBuilder = new StringBuilder(23 + String.valueOf(valueOf).length());
        stringBuilder.append("Unexpected callback in ");
        stringBuilder.append(valueOf);
        Log.w("GoogleApiClientConnecting", stringBuilder.toString());
        int i2 = this.zzfra;
        stringBuilder = new StringBuilder(33);
        stringBuilder.append("mRemainingConnections=");
        stringBuilder.append(i2);
        Log.w("GoogleApiClientConnecting", stringBuilder.toString());
        valueOf = zzbu(this.zzfqz);
        String zzbu = zzbu(i);
        stringBuilder = new StringBuilder((70 + String.valueOf(valueOf).length()) + String.valueOf(zzbu).length());
        stringBuilder.append("GoogleApiClient connecting is in step ");
        stringBuilder.append(valueOf);
        stringBuilder.append(" but received callback for step ");
        stringBuilder.append(zzbu);
        Log.wtf("GoogleApiClientConnecting", stringBuilder.toString(), new Exception());
        zze(new ConnectionResult(8, null));
        return false;
    }

    private static String zzbu(int i) {
        switch (i) {
            case 0:
                return "STEP_SERVICE_BINDINGS_AND_SIGN_IN";
            case 1:
                return "STEP_GETTING_REMOTE_SERVICE";
            default:
                return "UNKNOWN";
        }
    }

    private final boolean zzd(ConnectionResult connectionResult) {
        return this.zzfre && !connectionResult.hasResolution();
    }

    private final void zze(ConnectionResult connectionResult) {
        zzaig();
        zzbg(connectionResult.hasResolution() ^ 1);
        this.zzfqv.zzg(connectionResult);
        this.zzfqv.zzfsu.zzc(connectionResult);
    }

    public final void begin() {
        this.zzfqv.zzfsq.clear();
        this.zzfrf = false;
        this.zzfql = null;
        this.zzfqz = 0;
        this.zzfre = true;
        this.zzfrg = false;
        this.zzfri = false;
        Map hashMap = new HashMap();
        int i = 0;
        for (Api api : this.zzfqa.keySet()) {
            zze com_google_android_gms_common_api_Api_zze = (zze) this.zzfqv.zzfsb.get(api.zzagf());
            i |= api.zzagd().getPriority() == 1 ? 1 : 0;
            boolean booleanValue = ((Boolean) this.zzfqa.get(api)).booleanValue();
            if (com_google_android_gms_common_api_Api_zze.zzaay()) {
                this.zzfrf = true;
                if (booleanValue) {
                    this.zzfrc.add(api.zzagf());
                } else {
                    this.zzfre = false;
                }
            }
            hashMap.put(com_google_android_gms_common_api_Api_zze, new zzaq(this, api, booleanValue));
        }
        if (i != 0) {
            this.zzfrf = false;
        }
        if (this.zzfrf) {
            this.zzfpx.zzc(Integer.valueOf(System.identityHashCode(this.zzfqv.zzfpi)));
            OnConnectionFailedListener com_google_android_gms_common_api_internal_zzax = new zzax();
            this.zzfrd = (zzcxd) this.zzfmz.zza(this.mContext, this.zzfqv.zzfpi.getLooper(), this.zzfpx, this.zzfpx.zzalb(), com_google_android_gms_common_api_internal_zzax, com_google_android_gms_common_api_internal_zzax);
        }
        this.zzfra = this.zzfqv.zzfsb.size();
        this.zzfrk.add(zzbl.zzaip().submit(new zzar(this, hashMap)));
    }

    public final void connect() {
    }

    public final boolean disconnect() {
        zzaig();
        zzbg(true);
        this.zzfqv.zzg(null);
        return true;
    }

    public final void onConnected(Bundle bundle) {
        if (zzbt(1)) {
            if (bundle != null) {
                this.zzfrb.putAll(bundle);
            }
            if (zzaic()) {
                zzaie();
            }
        }
    }

    public final void onConnectionSuspended(int i) {
        zze(new ConnectionResult(8, null));
    }

    public final void zza(ConnectionResult connectionResult, Api<?> api, boolean z) {
        if (zzbt(1)) {
            zzb(connectionResult, api, z);
            if (zzaic()) {
                zzaie();
            }
        }
    }

    public final <A extends zzb, R extends Result, T extends zzm<R, A>> T zzd(T t) {
        this.zzfqv.zzfpi.zzfqg.add(t);
        return t;
    }

    public final <A extends zzb, T extends zzm<? extends Result, A>> T zze(T t) {
        throw new IllegalStateException("GoogleApiClient is not connected yet.");
    }
}
