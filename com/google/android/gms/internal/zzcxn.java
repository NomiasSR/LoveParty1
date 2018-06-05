package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.common.internal.zzm;
import com.google.android.gms.common.internal.zzr;

public final class zzcxn extends zzab<zzcxl> implements zzcxd {
    private final zzr zzfpx;
    private Integer zzfzj;
    private final boolean zzkbz;
    private final Bundle zzkca;

    private zzcxn(Context context, Looper looper, boolean z, zzr com_google_android_gms_common_internal_zzr, Bundle bundle, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 44, com_google_android_gms_common_internal_zzr, connectionCallbacks, onConnectionFailedListener);
        this.zzkbz = true;
        this.zzfpx = com_google_android_gms_common_internal_zzr;
        this.zzkca = bundle;
        this.zzfzj = com_google_android_gms_common_internal_zzr.zzalc();
    }

    public zzcxn(Context context, Looper looper, boolean z, zzr com_google_android_gms_common_internal_zzr, zzcxe com_google_android_gms_internal_zzcxe, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        this(context, looper, true, com_google_android_gms_common_internal_zzr, zza(com_google_android_gms_common_internal_zzr), connectionCallbacks, onConnectionFailedListener);
    }

    public static Bundle zza(zzr com_google_android_gms_common_internal_zzr) {
        zzcxe zzalb = com_google_android_gms_common_internal_zzr.zzalb();
        Integer zzalc = com_google_android_gms_common_internal_zzr.zzalc();
        Bundle bundle = new Bundle();
        bundle.putParcelable("com.google.android.gms.signin.internal.clientRequestedAccount", com_google_android_gms_common_internal_zzr.getAccount());
        if (zzalc != null) {
            bundle.putInt("com.google.android.gms.common.internal.ClientSettings.sessionId", zzalc.intValue());
        }
        if (zzalb != null) {
            bundle.putBoolean("com.google.android.gms.signin.internal.offlineAccessRequested", zzalb.zzbdc());
            bundle.putBoolean("com.google.android.gms.signin.internal.idTokenRequested", zzalb.isIdTokenRequested());
            bundle.putString("com.google.android.gms.signin.internal.serverClientId", zzalb.getServerClientId());
            bundle.putBoolean("com.google.android.gms.signin.internal.usePromptModeForAuthCode", true);
            bundle.putBoolean("com.google.android.gms.signin.internal.forceCodeForRefreshToken", zzalb.zzbdd());
            bundle.putString("com.google.android.gms.signin.internal.hostedDomain", zzalb.zzbde());
            bundle.putBoolean("com.google.android.gms.signin.internal.waitForAccessTokenRefresh", zzalb.zzbdf());
            if (zzalb.zzbdg() != null) {
                bundle.putLong("com.google.android.gms.signin.internal.authApiSignInModuleVersion", zzalb.zzbdg().longValue());
            }
            if (zzalb.zzbdh() != null) {
                bundle.putLong("com.google.android.gms.signin.internal.realClientLibraryVersion", zzalb.zzbdh().longValue());
            }
        }
        return bundle;
    }

    public final void connect() {
        zza(new zzm(this));
    }

    public final void zza(com.google.android.gms.common.internal.zzan r3, boolean r4) {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r2 = this;
        r0 = r2.zzakn();	 Catch:{ RemoteException -> 0x0010 }
        r0 = (com.google.android.gms.internal.zzcxl) r0;	 Catch:{ RemoteException -> 0x0010 }
        r1 = r2.zzfzj;	 Catch:{ RemoteException -> 0x0010 }
        r1 = r1.intValue();	 Catch:{ RemoteException -> 0x0010 }
        r0.zza(r3, r1, r4);	 Catch:{ RemoteException -> 0x0010 }
        return;
    L_0x0010:
        r3 = "SignInClientImpl";
        r4 = "Remote service probably died when saveDefaultAccount is called";
        android.util.Log.w(r3, r4);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzcxn.zza(com.google.android.gms.common.internal.zzan, boolean):void");
    }

    public final void zza(com.google.android.gms.internal.zzcxj r5) {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r4 = this;
        r0 = "Expecting a valid ISignInCallbacks";
        com.google.android.gms.common.internal.zzbq.checkNotNull(r5, r0);
        r0 = r4.zzfpx;	 Catch:{ RemoteException -> 0x003c }
        r0 = r0.zzakt();	 Catch:{ RemoteException -> 0x003c }
        r1 = 0;	 Catch:{ RemoteException -> 0x003c }
        r2 = "<<default account>>";	 Catch:{ RemoteException -> 0x003c }
        r3 = r0.name;	 Catch:{ RemoteException -> 0x003c }
        r2 = r2.equals(r3);	 Catch:{ RemoteException -> 0x003c }
        if (r2 == 0) goto L_0x0022;	 Catch:{ RemoteException -> 0x003c }
    L_0x0016:
        r1 = r4.getContext();	 Catch:{ RemoteException -> 0x003c }
        r1 = com.google.android.gms.auth.api.signin.internal.zzz.zzbt(r1);	 Catch:{ RemoteException -> 0x003c }
        r1 = r1.zzabt();	 Catch:{ RemoteException -> 0x003c }
    L_0x0022:
        r2 = new com.google.android.gms.common.internal.zzbr;	 Catch:{ RemoteException -> 0x003c }
        r3 = r4.zzfzj;	 Catch:{ RemoteException -> 0x003c }
        r3 = r3.intValue();	 Catch:{ RemoteException -> 0x003c }
        r2.<init>(r0, r3, r1);	 Catch:{ RemoteException -> 0x003c }
        r0 = r4.zzakn();	 Catch:{ RemoteException -> 0x003c }
        r0 = (com.google.android.gms.internal.zzcxl) r0;	 Catch:{ RemoteException -> 0x003c }
        r1 = new com.google.android.gms.internal.zzcxo;	 Catch:{ RemoteException -> 0x003c }
        r1.<init>(r2);	 Catch:{ RemoteException -> 0x003c }
        r0.zza(r1, r5);	 Catch:{ RemoteException -> 0x003c }
        return;
    L_0x003c:
        r0 = move-exception;
        r1 = "SignInClientImpl";
        r2 = "Remote service probably died when signIn is called";
        android.util.Log.w(r1, r2);
        r1 = new com.google.android.gms.internal.zzcxq;	 Catch:{ RemoteException -> 0x004f }
        r2 = 8;	 Catch:{ RemoteException -> 0x004f }
        r1.<init>(r2);	 Catch:{ RemoteException -> 0x004f }
        r5.zzb(r1);	 Catch:{ RemoteException -> 0x004f }
        return;
    L_0x004f:
        r5 = "SignInClientImpl";
        r1 = "ISignInCallbacks#onSignInComplete should be executed from the same process, unexpected RemoteException.";
        android.util.Log.wtf(r5, r1, r0);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzcxn.zza(com.google.android.gms.internal.zzcxj):void");
    }

    protected final Bundle zzaap() {
        if (!getContext().getPackageName().equals(this.zzfpx.zzaky())) {
            this.zzkca.putString("com.google.android.gms.signin.internal.realClientPackageName", this.zzfpx.zzaky());
        }
        return this.zzkca;
    }

    public final boolean zzaay() {
        return this.zzkbz;
    }

    public final void zzbdb() {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r2 = this;
        r0 = r2.zzakn();	 Catch:{ RemoteException -> 0x0010 }
        r0 = (com.google.android.gms.internal.zzcxl) r0;	 Catch:{ RemoteException -> 0x0010 }
        r1 = r2.zzfzj;	 Catch:{ RemoteException -> 0x0010 }
        r1 = r1.intValue();	 Catch:{ RemoteException -> 0x0010 }
        r0.zzeh(r1);	 Catch:{ RemoteException -> 0x0010 }
        return;
    L_0x0010:
        r0 = "SignInClientImpl";
        r1 = "Remote service probably died when clearAccountFromSessionStore is called";
        android.util.Log.w(r0, r1);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzcxn.zzbdb():void");
    }

    protected final /* synthetic */ IInterface zzd(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.signin.internal.ISignInService");
        return queryLocalInterface instanceof zzcxl ? (zzcxl) queryLocalInterface : new zzcxm(iBinder);
    }

    protected final String zzhi() {
        return "com.google.android.gms.signin.service.START";
    }

    protected final String zzhj() {
        return "com.google.android.gms.signin.internal.ISignInService";
    }
}
