package com.google.firebase.storage;

import android.support.annotation.NonNull;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zzg implements OnFailureListener {
    private /* synthetic */ TaskCompletionSource zzojh;

    zzg(StorageReference storageReference, TaskCompletionSource taskCompletionSource) {
        this.zzojh = taskCompletionSource;
    }

    public final void onFailure(@NonNull Exception exception) {
        this.zzojh.setException(StorageException.fromExceptionAndHttpCode(exception, 0));
    }
}
