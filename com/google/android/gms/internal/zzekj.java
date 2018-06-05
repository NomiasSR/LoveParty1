package com.google.android.gms.internal;

import com.google.firebase.database.DatabaseException;

public final class zzekj {
    public static zzekd zzc(zzedk com_google_android_gms_internal_zzedk, Object obj) {
        zzekd zza = zzekg.zza(obj, zzeju.zzcaf());
        if (zza instanceof zzekb) {
            zza = new zzejt(Double.valueOf((double) ((Long) zza.getValue()).longValue()), zzeju.zzcaf());
        }
        if (zzl(zza)) {
            return zza;
        }
        Object stringBuilder;
        if (com_google_android_gms_internal_zzedk != null) {
            String valueOf = String.valueOf(com_google_android_gms_internal_zzedk);
            StringBuilder stringBuilder2 = new StringBuilder(7 + String.valueOf(valueOf).length());
            stringBuilder2.append("Path '");
            stringBuilder2.append(valueOf);
            stringBuilder2.append("'");
            stringBuilder = stringBuilder2.toString();
        } else {
            stringBuilder = "Node";
        }
        throw new DatabaseException(String.valueOf(stringBuilder).concat(" contains invalid priority: Must be a string, double, ServerValue, or null"));
    }

    public static boolean zzl(zzekd com_google_android_gms_internal_zzekd) {
        return com_google_android_gms_internal_zzekd.zzbzv().isEmpty() && (com_google_android_gms_internal_zzekd.isEmpty() || (com_google_android_gms_internal_zzekd instanceof zzejt) || (com_google_android_gms_internal_zzekd instanceof zzekl) || (com_google_android_gms_internal_zzekd instanceof zzejs));
    }
}
