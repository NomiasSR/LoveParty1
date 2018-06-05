package com.google.android.gms.internal;

import com.google.firebase.database.DatabaseError;

public final class zzehy implements zzeib {
    private final zzedk zzmks;
    private final zzedh zzmzl;
    private final DatabaseError zzmzm;

    public zzehy(zzedh com_google_android_gms_internal_zzedh, DatabaseError databaseError, zzedk com_google_android_gms_internal_zzedk) {
        this.zzmzl = com_google_android_gms_internal_zzedh;
        this.zzmks = com_google_android_gms_internal_zzedk;
        this.zzmzm = databaseError;
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zzmks);
        StringBuilder stringBuilder = new StringBuilder(7 + String.valueOf(valueOf).length());
        stringBuilder.append(valueOf);
        stringBuilder.append(":CANCEL");
        return stringBuilder.toString();
    }

    public final void zzbyc() {
        this.zzmzl.zza(this.zzmzm);
    }
}
