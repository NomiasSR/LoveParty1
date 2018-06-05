package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.BinderThread;
import com.google.android.gms.common.ConnectionResult;

public final class zzn extends zze {
    private /* synthetic */ zzd zzfza;
    private IBinder zzfze;

    @BinderThread
    public zzn(zzd com_google_android_gms_common_internal_zzd, int i, IBinder iBinder, Bundle bundle) {
        this.zzfza = com_google_android_gms_common_internal_zzd;
        super(com_google_android_gms_common_internal_zzd, i, bundle);
        this.zzfze = iBinder;
    }

    protected final boolean zzakr() {
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
        r6 = this;
        r0 = 0;
        r1 = r6.zzfze;	 Catch:{ RemoteException -> 0x0088 }
        r1 = r1.getInterfaceDescriptor();	 Catch:{ RemoteException -> 0x0088 }
        r2 = r6.zzfza;
        r2 = r2.zzhj();
        r2 = r2.equals(r1);
        if (r2 != 0) goto L_0x004c;
    L_0x0013:
        r2 = "GmsClient";
        r3 = r6.zzfza;
        r3 = r3.zzhj();
        r4 = 34;
        r5 = java.lang.String.valueOf(r3);
        r5 = r5.length();
        r4 = r4 + r5;
        r5 = java.lang.String.valueOf(r1);
        r5 = r5.length();
        r4 = r4 + r5;
        r5 = new java.lang.StringBuilder;
        r5.<init>(r4);
        r4 = "service descriptor mismatch: ";
        r5.append(r4);
        r5.append(r3);
        r3 = " vs. ";
        r5.append(r3);
        r5.append(r1);
        r1 = r5.toString();
        android.util.Log.e(r2, r1);
        return r0;
    L_0x004c:
        r1 = r6.zzfza;
        r2 = r6.zzfze;
        r1 = r1.zzd(r2);
        if (r1 == 0) goto L_0x0087;
    L_0x0056:
        r2 = r6.zzfza;
        r3 = 2;
        r4 = 4;
        r2 = r2.zza(r3, r4, r1);
        if (r2 != 0) goto L_0x0069;
    L_0x0060:
        r2 = r6.zzfza;
        r3 = 3;
        r1 = r2.zza(r3, r4, r1);
        if (r1 == 0) goto L_0x0087;
    L_0x0069:
        r0 = r6.zzfza;
        r1 = 0;
        r0.zzfyv = r1;
        r0 = r6.zzfza;
        r0 = r0.zzafi();
        r1 = r6.zzfza;
        r1 = r1.zzfyr;
        if (r1 == 0) goto L_0x0086;
    L_0x007d:
        r1 = r6.zzfza;
        r1 = r1.zzfyr;
        r1.onConnected(r0);
    L_0x0086:
        r0 = 1;
    L_0x0087:
        return r0;
    L_0x0088:
        r1 = "GmsClient";
        r2 = "service probably died";
        android.util.Log.w(r1, r2);
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.internal.zzn.zzakr():boolean");
    }

    protected final void zzj(ConnectionResult connectionResult) {
        if (this.zzfza.zzfys != null) {
            this.zzfza.zzfys.onConnectionFailed(connectionResult);
        }
        this.zzfza.onConnectionFailed(connectionResult);
    }
}
