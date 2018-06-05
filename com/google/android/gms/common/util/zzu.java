package com.google.android.gms.common.util;

import android.support.annotation.Nullable;
import java.util.regex.Pattern;

public final class zzu {
    private static final Pattern zzgev = Pattern.compile("\\$\\{(.*?)\\}");

    public static boolean zzgs(@Nullable String str) {
        if (str != null) {
            if (!str.trim().isEmpty()) {
                return false;
            }
        }
        return true;
    }
}
