package com.google.android.gms.common;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.util.Log;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.internal.zzbhf;

public class zzq {
    private static zzq zzflp;
    private final Context mContext;

    private zzq(Context context) {
        this.mContext = context.getApplicationContext();
    }

    static zzh zza(PackageInfo packageInfo, zzh... com_google_android_gms_common_zzhArr) {
        if (packageInfo.signatures == null) {
            return null;
        }
        if (packageInfo.signatures.length != 1) {
            Log.w("GoogleSignatureVerifier", "Package has more than one signature.");
            return null;
        }
        int i = 0;
        zzi com_google_android_gms_common_zzi = new zzi(packageInfo.signatures[0].toByteArray());
        while (i < com_google_android_gms_common_zzhArr.length) {
            if (com_google_android_gms_common_zzhArr[i].equals(com_google_android_gms_common_zzi)) {
                return com_google_android_gms_common_zzhArr[i];
            }
            i++;
        }
        return null;
    }

    private static boolean zza(PackageInfo packageInfo, boolean z) {
        if (!(packageInfo == null || packageInfo.signatures == null)) {
            if (zza(packageInfo, z ? zzk.zzflf : new zzh[]{zzk.zzflf[0]}) != null) {
                return true;
            }
        }
        return false;
    }

    private static boolean zzb(PackageInfo packageInfo, boolean z) {
        if (packageInfo.signatures.length != 1) {
            Log.w("GoogleSignatureVerifier", "Package has more than one signature.");
            return false;
        }
        zzh com_google_android_gms_common_zzi = new zzi(packageInfo.signatures[0].toByteArray());
        String str = packageInfo.packageName;
        boolean zzb = z ? zzg.zzb(str, com_google_android_gms_common_zzi) : zzg.zza(str, com_google_android_gms_common_zzi);
        if (!zzb) {
            StringBuilder stringBuilder = new StringBuilder(27);
            stringBuilder.append("Cert not in list. atk=");
            stringBuilder.append(z);
            Log.d("GoogleSignatureVerifier", stringBuilder.toString());
        }
        return zzb;
    }

    public static zzq zzci(Context context) {
        zzbq.checkNotNull(context);
        synchronized (zzq.class) {
            if (zzflp == null) {
                zzg.zzcg(context);
                zzflp = new zzq(context);
            }
        }
        return zzflp;
    }

    private final boolean zzfy(java.lang.String r4) {
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
        r3 = this;
        r0 = 0;
        r1 = r3.mContext;	 Catch:{ NameNotFoundException -> 0x0032 }
        r1 = com.google.android.gms.internal.zzbhf.zzdb(r1);	 Catch:{ NameNotFoundException -> 0x0032 }
        r2 = 64;	 Catch:{ NameNotFoundException -> 0x0032 }
        r4 = r1.getPackageInfo(r4, r2);	 Catch:{ NameNotFoundException -> 0x0032 }
        if (r4 != 0) goto L_0x0010;	 Catch:{ NameNotFoundException -> 0x0032 }
    L_0x000f:
        return r0;	 Catch:{ NameNotFoundException -> 0x0032 }
    L_0x0010:
        r1 = r3.mContext;	 Catch:{ NameNotFoundException -> 0x0032 }
        r1 = com.google.android.gms.common.zzp.zzch(r1);	 Catch:{ NameNotFoundException -> 0x0032 }
        r2 = 1;	 Catch:{ NameNotFoundException -> 0x0032 }
        if (r1 == 0) goto L_0x001e;	 Catch:{ NameNotFoundException -> 0x0032 }
    L_0x0019:
        r4 = zzb(r4, r2);	 Catch:{ NameNotFoundException -> 0x0032 }
        return r4;	 Catch:{ NameNotFoundException -> 0x0032 }
    L_0x001e:
        r1 = zzb(r4, r0);	 Catch:{ NameNotFoundException -> 0x0032 }
        if (r1 != 0) goto L_0x0031;	 Catch:{ NameNotFoundException -> 0x0032 }
    L_0x0024:
        r4 = zzb(r4, r2);	 Catch:{ NameNotFoundException -> 0x0032 }
        if (r4 == 0) goto L_0x0031;	 Catch:{ NameNotFoundException -> 0x0032 }
    L_0x002a:
        r4 = "GoogleSignatureVerifier";	 Catch:{ NameNotFoundException -> 0x0032 }
        r2 = "Test-keys aren't accepted on this build.";	 Catch:{ NameNotFoundException -> 0x0032 }
        android.util.Log.w(r4, r2);	 Catch:{ NameNotFoundException -> 0x0032 }
    L_0x0031:
        return r1;
    L_0x0032:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.zzq.zzfy(java.lang.String):boolean");
    }

    public final boolean zza(PackageInfo packageInfo) {
        if (packageInfo == null) {
            return false;
        }
        if (zza(packageInfo, false)) {
            return true;
        }
        if (zza(packageInfo, true)) {
            if (zzp.zzch(this.mContext)) {
                return true;
            }
            Log.w("GoogleSignatureVerifier", "Test-keys aren't accepted on this build.");
        }
        return false;
    }

    public final boolean zzbq(int i) {
        String[] packagesForUid = zzbhf.zzdb(this.mContext).getPackagesForUid(i);
        if (packagesForUid == null || packagesForUid.length == 0) {
            return false;
        }
        for (String zzfy : packagesForUid) {
            if (zzfy(zzfy)) {
                return true;
            }
        }
        return false;
    }
}
