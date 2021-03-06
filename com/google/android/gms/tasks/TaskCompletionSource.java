package com.google.android.gms.tasks;

import android.support.annotation.NonNull;

public class TaskCompletionSource<TResult> {
    private final zzn<TResult> zzkul = new zzn();

    @NonNull
    public Task<TResult> getTask() {
        return this.zzkul;
    }

    public void setException(@NonNull Exception exception) {
        this.zzkul.setException(exception);
    }

    public void setResult(TResult tResult) {
        this.zzkul.setResult(tResult);
    }

    public boolean trySetException(@NonNull Exception exception) {
        return this.zzkul.trySetException(exception);
    }

    public boolean trySetResult(TResult tResult) {
        return this.zzkul.trySetResult(tResult);
    }
}
