package com.google.android.gms.internal;

import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.zzbq;
import java.io.UnsupportedEncodingException;

public final class zzexs {
    @NonNull
    public static String zzsh(@Nullable String str) throws UnsupportedEncodingException {
        return TextUtils.isEmpty(str) ? "" : zzsi(Uri.encode(str));
    }

    @NonNull
    public static String zzsi(@NonNull String str) {
        zzbq.checkNotNull(str);
        return str.replace("%2F", "/");
    }

    @NonNull
    public static String zzsj(@NonNull String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (!(str.startsWith("/") || str.endsWith("/"))) {
            if (!str.contains("//")) {
                return str;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (Object obj : str.split("/")) {
            if (!TextUtils.isEmpty(obj)) {
                if (stringBuilder.length() > 0) {
                    stringBuilder.append("/");
                }
                stringBuilder.append(obj);
            }
        }
        return stringBuilder.toString();
    }
}
