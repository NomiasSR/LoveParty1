package com.google.android.gms.common.util;

import android.annotation.TargetApi;
import android.content.Context;

public final class zzi {
    private static Boolean zzgeg;
    private static Boolean zzgeh;
    private static Boolean zzgei;
    private static Boolean zzgej;
    private static Boolean zzgek;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean zza(android.content.res.Resources r4) {
        /*
        r0 = 0;
        if (r4 != 0) goto L_0x0004;
    L_0x0003:
        return r0;
    L_0x0004:
        r1 = zzgeg;
        if (r1 != 0) goto L_0x0045;
    L_0x0008:
        r1 = r4.getConfiguration();
        r1 = r1.screenLayout;
        r1 = r1 & 15;
        r2 = 3;
        r3 = 1;
        if (r1 <= r2) goto L_0x0016;
    L_0x0014:
        r1 = r3;
        goto L_0x0017;
    L_0x0016:
        r1 = r0;
    L_0x0017:
        if (r1 != 0) goto L_0x003e;
    L_0x0019:
        r1 = zzgeh;
        if (r1 != 0) goto L_0x0036;
    L_0x001d:
        r4 = r4.getConfiguration();
        r1 = r4.screenLayout;
        r1 = r1 & 15;
        if (r1 > r2) goto L_0x002f;
    L_0x0027:
        r4 = r4.smallestScreenWidthDp;
        r1 = 600; // 0x258 float:8.41E-43 double:2.964E-321;
        if (r4 < r1) goto L_0x002f;
    L_0x002d:
        r4 = r3;
        goto L_0x0030;
    L_0x002f:
        r4 = r0;
    L_0x0030:
        r4 = java.lang.Boolean.valueOf(r4);
        zzgeh = r4;
    L_0x0036:
        r4 = zzgeh;
        r4 = r4.booleanValue();
        if (r4 == 0) goto L_0x003f;
    L_0x003e:
        r0 = r3;
    L_0x003f:
        r4 = java.lang.Boolean.valueOf(r0);
        zzgeg = r4;
    L_0x0045:
        r4 = zzgeg;
        r4 = r4.booleanValue();
        return r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.util.zzi.zza(android.content.res.Resources):boolean");
    }

    @TargetApi(20)
    public static boolean zzcs(Context context) {
        if (zzgei == null) {
            boolean z = zzq.zzamm() && context.getPackageManager().hasSystemFeature("android.hardware.type.watch");
            zzgei = Boolean.valueOf(z);
        }
        return zzgei.booleanValue();
    }

    @TargetApi(24)
    public static boolean zzct(Context context) {
        return (!zzq.isAtLeastN() || zzcu(context)) && zzcs(context);
    }

    @TargetApi(21)
    public static boolean zzcu(Context context) {
        if (zzgej == null) {
            boolean z = zzq.zzamn() && context.getPackageManager().hasSystemFeature("cn.google");
            zzgej = Boolean.valueOf(z);
        }
        return zzgej.booleanValue();
    }

    public static boolean zzcv(Context context) {
        if (zzgek == null) {
            boolean z;
            if (!context.getPackageManager().hasSystemFeature("android.hardware.type.iot")) {
                if (!context.getPackageManager().hasSystemFeature("android.hardware.type.embedded")) {
                    z = false;
                    zzgek = Boolean.valueOf(z);
                }
            }
            z = true;
            zzgek = Boolean.valueOf(z);
        }
        return zzgek.booleanValue();
    }
}
