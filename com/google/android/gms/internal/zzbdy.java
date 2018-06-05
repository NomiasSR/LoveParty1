package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.Api.zza;
import com.google.android.gms.common.api.Api.zzf;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.common.util.zzd;
import java.util.ArrayList;

public final class zzbdy {
    @Deprecated
    public static final Api<NoOptions> API = new Api("ClearcutLogger.API", zzebg, zzebf);
    private static zzf<zzbeo> zzebf = new zzf();
    private static zza<zzbeo, NoOptions> zzebg = new zzbdz();
    private static final zzctx[] zzfix = new zzctx[0];
    private static final String[] zzfiy = new String[0];
    private static final byte[][] zzfiz = new byte[0][];
    private final String packageName;
    private final zzd zzddz;
    private final int zzfja;
    private String zzfjb;
    private int zzfjc = -1;
    private String zzfjd;
    private String zzfje;
    private final boolean zzfjf;
    private int zzfjg = 0;
    private final zzbee zzfjh;
    private zzbed zzfji;
    private final zzbeb zzfjj;

    public zzbdy(Context context, int i, String str, String str2, String str3, boolean z, zzbee com_google_android_gms_internal_zzbee, zzd com_google_android_gms_common_util_zzd, zzbed com_google_android_gms_internal_zzbed, zzbeb com_google_android_gms_internal_zzbeb) {
        this.packageName = context.getPackageName();
        this.zzfja = zzbz(context);
        this.zzfjc = -1;
        this.zzfjb = str;
        this.zzfjd = null;
        this.zzfje = null;
        this.zzfjf = true;
        this.zzfjh = com_google_android_gms_internal_zzbee;
        this.zzddz = com_google_android_gms_common_util_zzd;
        this.zzfji = new zzbed();
        this.zzfjg = 0;
        this.zzfjj = com_google_android_gms_internal_zzbeb;
        zzbq.checkArgument(true, "can't be anonymous with an upload account");
    }

    private static int[] zzb(ArrayList<Integer> arrayList) {
        if (arrayList == null) {
            return null;
        }
        int[] iArr = new int[arrayList.size()];
        ArrayList arrayList2 = arrayList;
        int size = arrayList2.size();
        int i = 0;
        int i2 = 0;
        while (i < size) {
            Object obj = arrayList2.get(i);
            i++;
            int i3 = i2 + 1;
            iArr[i2] = ((Integer) obj).intValue();
            i2 = i3;
        }
        return iArr;
    }

    private static int zzbz(android.content.Context r2) {
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
        r0 = 0;
        r1 = r2.getPackageManager();	 Catch:{ NameNotFoundException -> 0x0010 }
        r2 = r2.getPackageName();	 Catch:{ NameNotFoundException -> 0x0010 }
        r2 = r1.getPackageInfo(r2, r0);	 Catch:{ NameNotFoundException -> 0x0010 }
        r2 = r2.versionCode;	 Catch:{ NameNotFoundException -> 0x0010 }
        return r2;
    L_0x0010:
        r2 = "ClearcutLogger";
        r1 = "This can't happen.";
        android.util.Log.wtf(r2, r1);
        r2 = r0;
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzbdy.zzbz(android.content.Context):int");
    }

    public final zzbea zzi(byte[] bArr) {
        return new zzbea(this, bArr);
    }
}
