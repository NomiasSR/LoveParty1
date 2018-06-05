package com.google.android.gms.internal;

public final class zzelo {
    private static long zzc(zzejy<?> com_google_android_gms_internal_zzejy_) {
        long j = 8;
        if (!(com_google_android_gms_internal_zzejy_ instanceof zzejt)) {
            if (!(com_google_android_gms_internal_zzejy_ instanceof zzekb)) {
                if (com_google_android_gms_internal_zzejy_ instanceof zzejf) {
                    j = 4;
                } else if (com_google_android_gms_internal_zzejy_ instanceof zzekl) {
                    j = (long) (2 + ((String) com_google_android_gms_internal_zzejy_.getValue()).length());
                } else {
                    String valueOf = String.valueOf(com_google_android_gms_internal_zzejy_.getClass());
                    StringBuilder stringBuilder = new StringBuilder(24 + String.valueOf(valueOf).length());
                    stringBuilder.append("Unknown leaf node type: ");
                    stringBuilder.append(valueOf);
                    throw new IllegalArgumentException(stringBuilder.toString());
                }
            }
        }
        return com_google_android_gms_internal_zzejy_.zzbzv().isEmpty() ? j : (j + 24) + zzc((zzejy) com_google_android_gms_internal_zzejy_.zzbzv());
    }

    public static long zzn(zzekd com_google_android_gms_internal_zzekd) {
        if (com_google_android_gms_internal_zzekd.isEmpty()) {
            return 4;
        }
        if (com_google_android_gms_internal_zzekd.zzbzu()) {
            return zzc((zzejy) com_google_android_gms_internal_zzekd);
        }
        long j = 1;
        for (zzekc com_google_android_gms_internal_zzekc : com_google_android_gms_internal_zzekd) {
            j = ((j + ((long) com_google_android_gms_internal_zzekc.zzcao().asString().length())) + 4) + zzn(com_google_android_gms_internal_zzekc.zzbsv());
        }
        if (!com_google_android_gms_internal_zzekd.zzbzv().isEmpty()) {
            j = (j + 12) + zzc((zzejy) com_google_android_gms_internal_zzekd.zzbzv());
        }
        return j;
    }

    public static int zzo(zzekd com_google_android_gms_internal_zzekd) {
        int i = 0;
        if (com_google_android_gms_internal_zzekd.isEmpty()) {
            return 0;
        }
        if (com_google_android_gms_internal_zzekd.zzbzu()) {
            return 1;
        }
        for (zzekc zzbsv : com_google_android_gms_internal_zzekd) {
            i += zzo(zzbsv.zzbsv());
        }
        return i;
    }
}
