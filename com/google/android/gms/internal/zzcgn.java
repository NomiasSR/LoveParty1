package com.google.android.gms.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.support.annotation.Nullable;
import android.support.annotation.Size;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.common.util.zzd;
import com.google.android.gms.common.util.zzs;
import java.lang.reflect.InvocationTargetException;

public final class zzcgn extends zzcjk {
    private Boolean zzdvl;

    zzcgn(zzcim com_google_android_gms_internal_zzcim) {
        super(com_google_android_gms_internal_zzcim);
    }

    public static long zzayb() {
        return ((Long) zzchc.zzjbg.get()).longValue();
    }

    public static long zzayc() {
        return ((Long) zzchc.zzjag.get()).longValue();
    }

    public static boolean zzaye() {
        return ((Boolean) zzchc.zzjab.get()).booleanValue();
    }

    public final /* bridge */ /* synthetic */ Context getContext() {
        return super.getContext();
    }

    public final long zza(java.lang.String r3, com.google.android.gms.internal.zzchd<java.lang.Long> r4) {
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
        if (r3 != 0) goto L_0x000d;
    L_0x0002:
        r3 = r4.get();
        r3 = (java.lang.Long) r3;
        r3 = r3.longValue();
        return r3;
    L_0x000d:
        r0 = r2.zzawv();
        r1 = r4.getKey();
        r3 = r0.zzam(r3, r1);
        r0 = android.text.TextUtils.isEmpty(r3);
        if (r0 == 0) goto L_0x0020;
    L_0x001f:
        goto L_0x0002;
    L_0x0020:
        r3 = java.lang.Long.valueOf(r3);	 Catch:{ NumberFormatException -> 0x0002 }
        r0 = r3.longValue();	 Catch:{ NumberFormatException -> 0x0002 }
        r3 = java.lang.Long.valueOf(r0);	 Catch:{ NumberFormatException -> 0x0002 }
        r3 = r4.get(r3);	 Catch:{ NumberFormatException -> 0x0002 }
        r3 = (java.lang.Long) r3;	 Catch:{ NumberFormatException -> 0x0002 }
        r0 = r3.longValue();	 Catch:{ NumberFormatException -> 0x0002 }
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzcgn.zza(java.lang.String, com.google.android.gms.internal.zzchd):long");
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

    public final boolean zzaya() {
        Boolean zziy = zziy("firebase_analytics_collection_deactivated");
        return zziy != null && zziy.booleanValue();
    }

    public final String zzayd() {
        Object e;
        zzcho zzazd;
        String str;
        try {
            return (String) Class.forName("android.os.SystemProperties").getMethod("get", new Class[]{String.class, String.class}).invoke(null, new Object[]{"debug.firebase.analytics.app", ""});
        } catch (ClassNotFoundException e2) {
            e = e2;
            zzazd = zzawy().zzazd();
            str = "Could not find SystemProperties class";
            zzazd.zzj(str, e);
            return "";
        } catch (NoSuchMethodException e3) {
            e = e3;
            zzazd = zzawy().zzazd();
            str = "Could not find SystemProperties.get() method";
            zzazd.zzj(str, e);
            return "";
        } catch (IllegalAccessException e4) {
            e = e4;
            zzazd = zzawy().zzazd();
            str = "Could not access SystemProperties.get()";
            zzazd.zzj(str, e);
            return "";
        } catch (InvocationTargetException e5) {
            e = e5;
            zzazd = zzawy().zzazd();
            str = "SystemProperties.get() threw an exception";
            zzazd.zzj(str, e);
            return "";
        }
    }

    public final int zzb(java.lang.String r3, com.google.android.gms.internal.zzchd<java.lang.Integer> r4) {
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
        if (r3 != 0) goto L_0x000d;
    L_0x0002:
        r3 = r4.get();
        r3 = (java.lang.Integer) r3;
        r3 = r3.intValue();
        return r3;
    L_0x000d:
        r0 = r2.zzawv();
        r1 = r4.getKey();
        r3 = r0.zzam(r3, r1);
        r0 = android.text.TextUtils.isEmpty(r3);
        if (r0 == 0) goto L_0x0020;
    L_0x001f:
        goto L_0x0002;
    L_0x0020:
        r3 = java.lang.Integer.valueOf(r3);	 Catch:{ NumberFormatException -> 0x0002 }
        r3 = r3.intValue();	 Catch:{ NumberFormatException -> 0x0002 }
        r3 = java.lang.Integer.valueOf(r3);	 Catch:{ NumberFormatException -> 0x0002 }
        r3 = r4.get(r3);	 Catch:{ NumberFormatException -> 0x0002 }
        r3 = (java.lang.Integer) r3;	 Catch:{ NumberFormatException -> 0x0002 }
        r3 = r3.intValue();	 Catch:{ NumberFormatException -> 0x0002 }
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzcgn.zzb(java.lang.String, com.google.android.gms.internal.zzchd):int");
    }

    public final int zzix(@Size(min = 1) String str) {
        return zzb(str, zzchc.zzjar);
    }

    @Nullable
    final Boolean zziy(@Size(min = 1) String str) {
        zzbq.zzgm(str);
        try {
            if (getContext().getPackageManager() == null) {
                zzawy().zzazd().log("Failed to load metadata: PackageManager is null");
                return null;
            }
            ApplicationInfo applicationInfo = zzbhf.zzdb(getContext()).getApplicationInfo(getContext().getPackageName(), 128);
            if (applicationInfo == null) {
                zzawy().zzazd().log("Failed to load metadata: ApplicationInfo is null");
                return null;
            } else if (applicationInfo.metaData != null) {
                return !applicationInfo.metaData.containsKey(str) ? null : Boolean.valueOf(applicationInfo.metaData.getBoolean(str));
            } else {
                zzawy().zzazd().log("Failed to load metadata: Metadata bundle is null");
                return null;
            }
        } catch (NameNotFoundException e) {
            zzawy().zzazd().zzj("Failed to load metadata: Package name not found", e);
            return null;
        }
    }

    public final boolean zziz(String str) {
        return "1".equals(zzawv().zzam(str, "gaia_collection_enabled"));
    }

    public final /* bridge */ /* synthetic */ void zzve() {
        super.zzve();
    }

    public final /* bridge */ /* synthetic */ zzd zzws() {
        return super.zzws();
    }

    public final boolean zzyp() {
        if (this.zzdvl == null) {
            synchronized (this) {
                if (this.zzdvl == null) {
                    ApplicationInfo applicationInfo = getContext().getApplicationInfo();
                    String zzamo = zzs.zzamo();
                    if (applicationInfo != null) {
                        String str = applicationInfo.processName;
                        boolean z = str != null && str.equals(zzamo);
                        this.zzdvl = Boolean.valueOf(z);
                    }
                    if (this.zzdvl == null) {
                        this.zzdvl = Boolean.TRUE;
                        zzawy().zzazd().log("My process not in the list of running processes");
                    }
                }
            }
        }
        return this.zzdvl.booleanValue();
    }
}
