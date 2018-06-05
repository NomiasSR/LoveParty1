package com.google.android.gms.internal;

import java.util.Locale;

public final class zzdxv {
    private static void zza(StringBuilder stringBuilder, Locale locale) {
        String language = locale.getLanguage();
        if (language != null) {
            stringBuilder.append(language);
            String country = locale.getCountry();
            if (country != null) {
                stringBuilder.append("-");
                stringBuilder.append(country);
            }
        }
    }

    public static String zzbrr() {
        Locale locale = Locale.getDefault();
        StringBuilder stringBuilder = new StringBuilder();
        zza(stringBuilder, locale);
        if (!locale.equals(Locale.US)) {
            if (stringBuilder.length() > 0) {
                stringBuilder.append(", ");
            }
            zza(stringBuilder, Locale.US);
        }
        return stringBuilder.toString();
    }
}
