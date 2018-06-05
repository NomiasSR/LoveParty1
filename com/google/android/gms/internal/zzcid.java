package com.google.android.gms.internal;

import android.content.BroadcastReceiver.PendingResult;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.MainThread;
import com.google.android.gms.common.internal.zzbq;

public final class zzcid {
    private final zzcif zzjds;

    public zzcid(zzcif com_google_android_gms_internal_zzcif) {
        zzbq.checkNotNull(com_google_android_gms_internal_zzcif);
        this.zzjds = com_google_android_gms_internal_zzcif;
    }

    public static boolean zzbk(android.content.Context r4) {
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
        com.google.android.gms.common.internal.zzbq.checkNotNull(r4);
        r0 = 0;
        r1 = r4.getPackageManager();	 Catch:{ NameNotFoundException -> 0x001f }
        if (r1 != 0) goto L_0x000b;	 Catch:{ NameNotFoundException -> 0x001f }
    L_0x000a:
        return r0;	 Catch:{ NameNotFoundException -> 0x001f }
    L_0x000b:
        r2 = new android.content.ComponentName;	 Catch:{ NameNotFoundException -> 0x001f }
        r3 = "com.google.android.gms.measurement.AppMeasurementReceiver";	 Catch:{ NameNotFoundException -> 0x001f }
        r2.<init>(r4, r3);	 Catch:{ NameNotFoundException -> 0x001f }
        r4 = 2;	 Catch:{ NameNotFoundException -> 0x001f }
        r4 = r1.getReceiverInfo(r2, r4);	 Catch:{ NameNotFoundException -> 0x001f }
        if (r4 == 0) goto L_0x001f;	 Catch:{ NameNotFoundException -> 0x001f }
    L_0x0019:
        r4 = r4.enabled;	 Catch:{ NameNotFoundException -> 0x001f }
        if (r4 == 0) goto L_0x001f;
    L_0x001d:
        r4 = 1;
        return r4;
    L_0x001f:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzcid.zzbk(android.content.Context):boolean");
    }

    @MainThread
    public final void onReceive(Context context, Intent intent) {
        zzcim zzdx = zzcim.zzdx(context);
        zzchm zzawy = zzdx.zzawy();
        if (intent == null) {
            zzawy.zzazf().log("Receiver called with null intent");
            return;
        }
        String action = intent.getAction();
        zzawy.zzazj().zzj("Local receiver got", action);
        if ("com.google.android.gms.measurement.UPLOAD".equals(action)) {
            intent = new Intent().setClassName(context, "com.google.android.gms.measurement.AppMeasurementService");
            intent.setAction("com.google.android.gms.measurement.UPLOAD");
            zzawy.zzazj().log("Starting wakeful intent.");
            this.zzjds.doStartService(context, intent);
            return;
        }
        if ("com.android.vending.INSTALL_REFERRER".equals(action)) {
            PendingResult doGoAsync = this.zzjds.doGoAsync();
            action = intent.getStringExtra("referrer");
            if (action == null) {
                zzawy.zzazj().log("Install referrer extras are null");
                if (doGoAsync != null) {
                    doGoAsync.finish();
                }
                return;
            }
            zzawy.zzazh().zzj("Install referrer extras are", action);
            if (!action.contains("?")) {
                String str = "?";
                action = String.valueOf(action);
                action = action.length() != 0 ? str.concat(action) : new String(str);
            }
            Bundle zzp = zzdx.zzawu().zzp(Uri.parse(action));
            if (zzp == null) {
                zzawy.zzazj().log("No campaign defined in install referrer broadcast");
                if (doGoAsync != null) {
                    doGoAsync.finish();
                    return;
                }
            }
            long longExtra = 1000 * intent.getLongExtra("referrer_timestamp_seconds", 0);
            if (longExtra == 0) {
                zzawy.zzazf().log("Install referrer is missing timestamp");
            }
            zzdx.zzawx().zzg(new zzcie(this, zzdx, longExtra, zzp, context, zzawy, doGoAsync));
        }
    }
}
