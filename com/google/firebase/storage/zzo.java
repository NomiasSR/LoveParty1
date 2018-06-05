package com.google.firebase.storage;

import android.support.annotation.NonNull;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.RuntimeExecutionException;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zzo implements OnCompleteListener<TResult> {
    private /* synthetic */ TaskCompletionSource zzgbh;
    private /* synthetic */ StorageTask zzojr;
    private /* synthetic */ Continuation zzojs;

    zzo(StorageTask storageTask, Continuation continuation, TaskCompletionSource taskCompletionSource) {
        this.zzojr = storageTask;
        this.zzojs = continuation;
        this.zzgbh = taskCompletionSource;
    }

    public final void onComplete(@NonNull Task<TResult> task) {
        Exception e;
        TaskCompletionSource taskCompletionSource;
        try {
            Object then = this.zzojs.then(this.zzojr);
            if (!this.zzgbh.getTask().isComplete()) {
                this.zzgbh.setResult(then);
            }
        } catch (RuntimeExecutionException e2) {
            e = e2;
            if (e.getCause() instanceof Exception) {
                taskCompletionSource = this.zzgbh;
                e = (Exception) e.getCause();
                taskCompletionSource.setException(e);
            }
            taskCompletionSource = this.zzgbh;
            taskCompletionSource.setException(e);
        } catch (Exception e3) {
            e = e3;
            taskCompletionSource = this.zzgbh;
            taskCompletionSource.setException(e);
        }
    }
}
