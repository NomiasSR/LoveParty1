package com.google.android.gms.internal;

import android.os.Handler;
import com.google.firebase.database.DatabaseException;
import com.google.firebase.database.FirebaseDatabase;

final class zzdzx extends zzelk {
    private /* synthetic */ zzejc zzmlm;
    private /* synthetic */ zzdzw zzmln;

    zzdzx(zzdzw com_google_android_gms_internal_zzdzw, zzejc com_google_android_gms_internal_zzejc) {
        this.zzmln = com_google_android_gms_internal_zzdzw;
        this.zzmlm = com_google_android_gms_internal_zzejc;
    }

    public final void zzi(Throwable th) {
        String str;
        if (th instanceof OutOfMemoryError) {
            str = "Firebase Database encountered an OutOfMemoryError. You may need to reduce the amount of data you are syncing to the client (e.g. by using queries or syncing a deeper path). See https://firebase.google.com/docs/database/ios/structure-data#best_practices_for_data_structure and https://firebase.google.com/docs/database/android/retrieve-data#filtering_data";
        } else if (th instanceof DatabaseException) {
            str = "";
        } else {
            str = FirebaseDatabase.getSdkVersion();
            StringBuilder stringBuilder = new StringBuilder(104 + String.valueOf(str).length());
            stringBuilder.append("Uncaught exception in Firebase Database runloop (");
            stringBuilder.append(str);
            stringBuilder.append("). Please report to firebase-database-client@google.com");
            str = stringBuilder.toString();
        }
        this.zzmlm.zzd(str, th);
        new Handler(this.zzmln.zzajx.getMainLooper()).post(new zzdzy(this, str, th));
        zzbud().shutdownNow();
    }
}
