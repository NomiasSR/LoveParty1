package com.google.firebase.storage;

import com.google.android.gms.tasks.OnSuccessListener;

final class zzq implements OnSuccessListener<TContinuationResult> {
    private /* synthetic */ zzp zzojt;

    zzq(zzp com_google_firebase_storage_zzp) {
        this.zzojt = com_google_firebase_storage_zzp;
    }

    public final void onSuccess(TContinuationResult tContinuationResult) {
        this.zzojt.zzgbh.setResult(tContinuationResult);
    }
}
