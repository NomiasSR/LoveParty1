package com.google.firebase.storage;

import android.support.annotation.NonNull;
import com.google.android.gms.tasks.OnFailureListener;

final class zzr implements OnFailureListener {
    private /* synthetic */ zzp zzojt;

    zzr(zzp com_google_firebase_storage_zzp) {
        this.zzojt = com_google_firebase_storage_zzp;
    }

    public final void onFailure(@NonNull Exception exception) {
        this.zzojt.zzgbh.setException(exception);
    }
}
