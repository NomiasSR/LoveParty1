package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.Result;

public final class zzal implements zzbh {
    private final zzbi zzfqv;
    private boolean zzfqw = false;

    public zzal(zzbi com_google_android_gms_common_api_internal_zzbi) {
        this.zzfqv = com_google_android_gms_common_api_internal_zzbi;
    }

    public final void begin() {
    }

    public final void connect() {
        if (this.zzfqw) {
            this.zzfqw = false;
            this.zzfqv.zza(new zzan(this, this));
        }
    }

    public final boolean disconnect() {
        if (this.zzfqw) {
            return false;
        }
        if (this.zzfqv.zzfpi.zzail()) {
            this.zzfqw = true;
            for (zzdg zzajs : this.zzfqv.zzfpi.zzfsg) {
                zzajs.zzajs();
            }
            return false;
        }
        this.zzfqv.zzg(null);
        return true;
    }

    public final void onConnected(Bundle bundle) {
    }

    public final void onConnectionSuspended(int i) {
        this.zzfqv.zzg(null);
        this.zzfqv.zzfsu.zzf(i, this.zzfqw);
    }

    public final void zza(ConnectionResult connectionResult, Api<?> api, boolean z) {
    }

    final void zzaia() {
        if (this.zzfqw) {
            this.zzfqw = false;
            this.zzfqv.zzfpi.zzfsh.release();
            disconnect();
        }
    }

    public final <A extends zzb, R extends Result, T extends zzm<R, A>> T zzd(T t) {
        return zze(t);
    }

    public final <A extends com.google.android.gms.common.api.Api.zzb, T extends com.google.android.gms.common.api.internal.zzm<? extends com.google.android.gms.common.api.Result, A>> T zze(T r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r3 = this;
        r0 = r3.zzfqv;	 Catch:{ DeadObjectException -> 0x0049 }
        r0 = r0.zzfpi;	 Catch:{ DeadObjectException -> 0x0049 }
        r0 = r0.zzfsh;	 Catch:{ DeadObjectException -> 0x0049 }
        r0.zzb(r4);	 Catch:{ DeadObjectException -> 0x0049 }
        r0 = r3.zzfqv;	 Catch:{ DeadObjectException -> 0x0049 }
        r0 = r0.zzfpi;	 Catch:{ DeadObjectException -> 0x0049 }
        r1 = r4.zzagf();	 Catch:{ DeadObjectException -> 0x0049 }
        r0 = r0.zzfsb;	 Catch:{ DeadObjectException -> 0x0049 }
        r0 = r0.get(r1);	 Catch:{ DeadObjectException -> 0x0049 }
        r0 = (com.google.android.gms.common.api.Api.zze) r0;	 Catch:{ DeadObjectException -> 0x0049 }
        r1 = "Appropriate Api was not requested.";	 Catch:{ DeadObjectException -> 0x0049 }
        com.google.android.gms.common.internal.zzbq.checkNotNull(r0, r1);	 Catch:{ DeadObjectException -> 0x0049 }
        r1 = r0.isConnected();	 Catch:{ DeadObjectException -> 0x0049 }
        if (r1 != 0) goto L_0x003d;	 Catch:{ DeadObjectException -> 0x0049 }
    L_0x0024:
        r1 = r3.zzfqv;	 Catch:{ DeadObjectException -> 0x0049 }
        r1 = r1.zzfsq;	 Catch:{ DeadObjectException -> 0x0049 }
        r2 = r4.zzagf();	 Catch:{ DeadObjectException -> 0x0049 }
        r1 = r1.containsKey(r2);	 Catch:{ DeadObjectException -> 0x0049 }
        if (r1 == 0) goto L_0x003d;	 Catch:{ DeadObjectException -> 0x0049 }
    L_0x0032:
        r0 = new com.google.android.gms.common.api.Status;	 Catch:{ DeadObjectException -> 0x0049 }
        r1 = 17;	 Catch:{ DeadObjectException -> 0x0049 }
        r0.<init>(r1);	 Catch:{ DeadObjectException -> 0x0049 }
        r4.zzu(r0);	 Catch:{ DeadObjectException -> 0x0049 }
        return r4;	 Catch:{ DeadObjectException -> 0x0049 }
    L_0x003d:
        r1 = r0 instanceof com.google.android.gms.common.internal.zzbz;	 Catch:{ DeadObjectException -> 0x0049 }
        if (r1 == 0) goto L_0x0045;	 Catch:{ DeadObjectException -> 0x0049 }
    L_0x0041:
        r0 = com.google.android.gms.common.internal.zzbz.zzals();	 Catch:{ DeadObjectException -> 0x0049 }
    L_0x0045:
        r4.zzb(r0);	 Catch:{ DeadObjectException -> 0x0049 }
        return r4;
    L_0x0049:
        r0 = r3.zzfqv;
        r1 = new com.google.android.gms.common.api.internal.zzam;
        r1.<init>(r3, r3);
        r0.zza(r1);
        return r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.internal.zzal.zze(com.google.android.gms.common.api.internal.zzm):T");
    }
}
