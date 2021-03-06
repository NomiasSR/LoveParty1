package com.google.android.gms.common.util;

import android.os.Build.VERSION;

public final class zzq {
    public static boolean isAtLeastN() {
        return VERSION.SDK_INT >= 24;
    }

    public static boolean isAtLeastO() {
        if (!(VERSION.SDK_INT >= 26 || "O".equals(VERSION.CODENAME) || VERSION.CODENAME.startsWith("OMR"))) {
            if (!VERSION.CODENAME.startsWith("ODR")) {
                return false;
            }
        }
        return true;
    }

    public static boolean zzamh() {
        return VERSION.SDK_INT >= 15;
    }

    public static boolean zzami() {
        return VERSION.SDK_INT >= 16;
    }

    public static boolean zzamj() {
        return VERSION.SDK_INT >= 17;
    }

    public static boolean zzamk() {
        return VERSION.SDK_INT >= 18;
    }

    public static boolean zzaml() {
        return VERSION.SDK_INT >= 19;
    }

    public static boolean zzamm() {
        return VERSION.SDK_INT >= 20;
    }

    public static boolean zzamn() {
        return VERSION.SDK_INT >= 21;
    }
}
