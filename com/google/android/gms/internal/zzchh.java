package com.google.android.gms.internal;

import android.content.Context;
import android.support.annotation.WorkerThread;
import com.google.android.gms.common.util.zzd;
import java.math.BigInteger;
import java.util.Locale;

public final class zzchh extends zzcjl {
    private String mAppId;
    private String zzcwz;
    private String zzdqz;
    private String zzdra;
    private String zzixc;
    private long zzixg;
    private int zzjbk;
    private long zzjbl;
    private int zzjbm;

    zzchh(zzcim com_google_android_gms_internal_zzcim) {
        super(com_google_android_gms_internal_zzcim);
    }

    @android.support.annotation.WorkerThread
    private final java.lang.String zzaxd() {
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
        r2.zzve();
        r0 = com.google.firebase.iid.FirebaseInstanceId.getInstance();	 Catch:{ IllegalStateException -> 0x000c }
        r0 = r0.getId();	 Catch:{ IllegalStateException -> 0x000c }
        return r0;
    L_0x000c:
        r0 = r2.zzawy();
        r0 = r0.zzazf();
        r1 = "Failed to retrieve Firebase Instance Id";
        r0.log(r1);
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzchh.zzaxd():java.lang.String");
    }

    final String getAppId() {
        zzxf();
        return this.mAppId;
    }

    public final /* bridge */ /* synthetic */ Context getContext() {
        return super.getContext();
    }

    final String getGmpAppId() {
        zzxf();
        return this.zzcwz;
    }

    public final /* bridge */ /* synthetic */ void zzawi() {
        super.zzawi();
    }

    public final /* bridge */ /* synthetic */ void zzawj() {
        super.zzawj();
    }

    public final /* bridge */ /* synthetic */ zzcgd zzawk() {
        return super.zzawk();
    }

    public final /* bridge */ /* synthetic */ zzcgk zzawl() {
        return super.zzawl();
    }

    public final /* bridge */ /* synthetic */ zzcjn zzawm() {
        return super.zzawm();
    }

    public final /* bridge */ /* synthetic */ zzchh zzawn() {
        return super.zzawn();
    }

    public final /* bridge */ /* synthetic */ zzcgu zzawo() {
        return super.zzawo();
    }

    public final /* bridge */ /* synthetic */ zzckg zzawp() {
        return super.zzawp();
    }

    public final /* bridge */ /* synthetic */ zzckc zzawq() {
        return super.zzawq();
    }

    public final /* bridge */ /* synthetic */ zzchi zzawr() {
        return super.zzawr();
    }

    public final /* bridge */ /* synthetic */ zzcgo zzaws() {
        return super.zzaws();
    }

    public final /* bridge */ /* synthetic */ zzchk zzawt() {
        return super.zzawt();
    }

    public final /* bridge */ /* synthetic */ zzclq zzawu() {
        return super.zzawu();
    }

    public final /* bridge */ /* synthetic */ zzcig zzawv() {
        return super.zzawv();
    }

    public final /* bridge */ /* synthetic */ zzclf zzaww() {
        return super.zzaww();
    }

    public final /* bridge */ /* synthetic */ zzcih zzawx() {
        return super.zzawx();
    }

    public final /* bridge */ /* synthetic */ zzchm zzawy() {
        return super.zzawy();
    }

    public final /* bridge */ /* synthetic */ zzchx zzawz() {
        return super.zzawz();
    }

    public final /* bridge */ /* synthetic */ zzcgn zzaxa() {
        return super.zzaxa();
    }

    protected final boolean zzaxz() {
        return true;
    }

    protected final void zzayy() {
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
        r10 = this;
        r0 = "unknown";
        r1 = "Unknown";
        r2 = "Unknown";
        r3 = r10.getContext();
        r3 = r3.getPackageName();
        r4 = r10.getContext();
        r4 = r4.getPackageManager();
        r5 = 0;
        r6 = -2147483648; // 0xffffffff80000000 float:-0.0 double:NaN;
        if (r4 != 0) goto L_0x002d;
    L_0x001b:
        r4 = r10.zzawy();
        r4 = r4.zzazd();
        r7 = "PackageManager is null, app identity information might be inaccurate. appId";
        r8 = com.google.android.gms.internal.zzchm.zzjk(r3);
        r4.zzj(r7, r8);
        goto L_0x008b;
    L_0x002d:
        r7 = r4.getInstallerPackageName(r3);	 Catch:{ IllegalArgumentException -> 0x0033 }
        r0 = r7;
        goto L_0x0044;
    L_0x0033:
        r7 = r10.zzawy();
        r7 = r7.zzazd();
        r8 = "Error retrieving app installer package name. appId";
        r9 = com.google.android.gms.internal.zzchm.zzjk(r3);
        r7.zzj(r8, r9);
    L_0x0044:
        if (r0 != 0) goto L_0x0049;
    L_0x0046:
        r0 = "manual_install";
        goto L_0x0053;
    L_0x0049:
        r7 = "com.android.vending";
        r7 = r7.equals(r0);
        if (r7 == 0) goto L_0x0053;
    L_0x0051:
        r0 = "";
    L_0x0053:
        r7 = r10.getContext();	 Catch:{ NameNotFoundException -> 0x007a }
        r7 = r7.getPackageName();	 Catch:{ NameNotFoundException -> 0x007a }
        r7 = r4.getPackageInfo(r7, r5);	 Catch:{ NameNotFoundException -> 0x007a }
        if (r7 == 0) goto L_0x008b;	 Catch:{ NameNotFoundException -> 0x007a }
    L_0x0061:
        r8 = r7.applicationInfo;	 Catch:{ NameNotFoundException -> 0x007a }
        r4 = r4.getApplicationLabel(r8);	 Catch:{ NameNotFoundException -> 0x007a }
        r8 = android.text.TextUtils.isEmpty(r4);	 Catch:{ NameNotFoundException -> 0x007a }
        if (r8 != 0) goto L_0x0072;	 Catch:{ NameNotFoundException -> 0x007a }
    L_0x006d:
        r4 = r4.toString();	 Catch:{ NameNotFoundException -> 0x007a }
        r2 = r4;	 Catch:{ NameNotFoundException -> 0x007a }
    L_0x0072:
        r4 = r7.versionName;	 Catch:{ NameNotFoundException -> 0x007a }
        r1 = r7.versionCode;	 Catch:{ NameNotFoundException -> 0x0079 }
        r6 = r1;
        r1 = r4;
        goto L_0x008b;
    L_0x0079:
        r1 = r4;
    L_0x007a:
        r4 = r10.zzawy();
        r4 = r4.zzazd();
        r7 = "Error retrieving package info. appId, appName";
        r8 = com.google.android.gms.internal.zzchm.zzjk(r3);
        r4.zze(r7, r8, r2);
    L_0x008b:
        r10.mAppId = r3;
        r10.zzixc = r0;
        r10.zzdra = r1;
        r10.zzjbk = r6;
        r10.zzdqz = r2;
        r0 = 0;
        r10.zzjbl = r0;
        r2 = r10.getContext();
        r2 = com.google.android.gms.common.api.internal.zzbz.zzck(r2);
        r4 = 1;
        if (r2 == 0) goto L_0x00ac;
    L_0x00a4:
        r6 = r2.isSuccess();
        if (r6 == 0) goto L_0x00ac;
    L_0x00aa:
        r6 = r4;
        goto L_0x00ad;
    L_0x00ac:
        r6 = r5;
    L_0x00ad:
        if (r6 != 0) goto L_0x00d8;
    L_0x00af:
        if (r2 != 0) goto L_0x00bf;
    L_0x00b1:
        r2 = r10.zzawy();
        r2 = r2.zzazd();
        r7 = "GoogleService failed to initialize (no status)";
        r2.log(r7);
        goto L_0x00d8;
    L_0x00bf:
        r7 = r10.zzawy();
        r7 = r7.zzazd();
        r8 = "GoogleService failed to initialize, status";
        r9 = r2.getStatusCode();
        r9 = java.lang.Integer.valueOf(r9);
        r2 = r2.getStatusMessage();
        r7.zze(r8, r9, r2);
    L_0x00d8:
        if (r6 == 0) goto L_0x0130;
    L_0x00da:
        r2 = r10.zzaxa();
        r6 = "firebase_analytics_collection_enabled";
        r2 = r2.zziy(r6);
        r6 = r10.zzaxa();
        r6 = r6.zzaya();
        if (r6 == 0) goto L_0x00fc;
    L_0x00ee:
        r2 = r10.zzawy();
        r2 = r2.zzazh();
        r4 = "Collection disabled with firebase_analytics_collection_deactivated=1";
    L_0x00f8:
        r2.log(r4);
        goto L_0x0130;
    L_0x00fc:
        if (r2 == 0) goto L_0x010f;
    L_0x00fe:
        r6 = r2.booleanValue();
        if (r6 != 0) goto L_0x010f;
    L_0x0104:
        r2 = r10.zzawy();
        r2 = r2.zzazh();
        r4 = "Collection disabled with firebase_analytics_collection_enabled=0";
        goto L_0x00f8;
    L_0x010f:
        if (r2 != 0) goto L_0x0122;
    L_0x0111:
        r2 = com.google.android.gms.common.api.internal.zzbz.zzaji();
        if (r2 == 0) goto L_0x0122;
    L_0x0117:
        r2 = r10.zzawy();
        r2 = r2.zzazh();
        r4 = "Collection disabled with google_app_measurement_enable=0";
        goto L_0x00f8;
    L_0x0122:
        r2 = r10.zzawy();
        r2 = r2.zzazj();
        r6 = "Collection enabled";
        r2.log(r6);
        goto L_0x0131;
    L_0x0130:
        r4 = r5;
    L_0x0131:
        r2 = "";
        r10.zzcwz = r2;
        r10.zzixg = r0;
        r0 = com.google.android.gms.common.api.internal.zzbz.zzajh();	 Catch:{ IllegalStateException -> 0x0159 }
        r1 = android.text.TextUtils.isEmpty(r0);	 Catch:{ IllegalStateException -> 0x0159 }
        if (r1 == 0) goto L_0x0143;	 Catch:{ IllegalStateException -> 0x0159 }
    L_0x0141:
        r0 = "";	 Catch:{ IllegalStateException -> 0x0159 }
    L_0x0143:
        r10.zzcwz = r0;	 Catch:{ IllegalStateException -> 0x0159 }
        if (r4 == 0) goto L_0x016b;	 Catch:{ IllegalStateException -> 0x0159 }
    L_0x0147:
        r0 = r10.zzawy();	 Catch:{ IllegalStateException -> 0x0159 }
        r0 = r0.zzazj();	 Catch:{ IllegalStateException -> 0x0159 }
        r1 = "App package, google app id";	 Catch:{ IllegalStateException -> 0x0159 }
        r2 = r10.mAppId;	 Catch:{ IllegalStateException -> 0x0159 }
        r4 = r10.zzcwz;	 Catch:{ IllegalStateException -> 0x0159 }
        r0.zze(r1, r2, r4);	 Catch:{ IllegalStateException -> 0x0159 }
        goto L_0x016b;
    L_0x0159:
        r0 = move-exception;
        r1 = r10.zzawy();
        r1 = r1.zzazd();
        r2 = "getGoogleAppId or isMeasurementEnabled failed with exception. appId";
        r3 = com.google.android.gms.internal.zzchm.zzjk(r3);
        r1.zze(r2, r3, r0);
    L_0x016b:
        r0 = android.os.Build.VERSION.SDK_INT;
        r1 = 16;
        if (r0 < r1) goto L_0x017c;
    L_0x0171:
        r0 = r10.getContext();
        r0 = com.google.android.gms.internal.zzbhd.zzcz(r0);
        r10.zzjbm = r0;
        return;
    L_0x017c:
        r10.zzjbm = r5;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzchh.zzayy():void");
    }

    @WorkerThread
    final String zzayz() {
        zzawu().zzbaz().nextBytes(new byte[16]);
        return String.format(Locale.US, "%032x", new Object[]{new BigInteger(1, r0)});
    }

    final int zzaza() {
        zzxf();
        return this.zzjbk;
    }

    final int zzazb() {
        zzxf();
        return this.zzjbm;
    }

    @WorkerThread
    final zzcgi zzjg(String str) {
        zzve();
        String appId = getAppId();
        String gmpAppId = getGmpAppId();
        zzxf();
        String str2 = this.zzdra;
        long zzaza = (long) zzaza();
        zzxf();
        String str3 = this.zzixc;
        zzxf();
        zzve();
        if (this.zzjbl == 0) {
            r0.zzjbl = r0.zziwf.zzawu().zzaf(getContext(), getContext().getPackageName());
        }
        long j = r0.zzjbl;
        boolean isEnabled = r0.zziwf.isEnabled();
        boolean z = true;
        boolean z2 = zzawz().zzjdj ^ 1;
        String zzaxd = zzaxd();
        zzxf();
        long zzbaf = r0.zziwf.zzbaf();
        int zzazb = zzazb();
        Boolean zziy = zzaxa().zziy("google_analytics_adid_collection_enabled");
        if (zziy != null) {
            if (!zziy.booleanValue()) {
                z = false;
            }
        }
        return new zzcgi(appId, gmpAppId, str2, zzaza, str3, 11910, j, str, isEnabled, z2, zzaxd, 0, zzbaf, zzazb, Boolean.valueOf(z).booleanValue());
    }

    public final /* bridge */ /* synthetic */ void zzve() {
        super.zzve();
    }

    public final /* bridge */ /* synthetic */ zzd zzws() {
        return super.zzws();
    }
}
