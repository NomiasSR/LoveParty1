package com.google.firebase.storage;

import android.app.Activity;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.internal.zzexo;
import com.google.android.gms.internal.zzexv;
import com.google.firebase.storage.StorageTask.ProvideError;
import java.util.HashMap;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;

final class zzx<TListenerType, TResult extends ProvideError> {
    private final Queue<TListenerType> zzoks = new ConcurrentLinkedQueue();
    private final HashMap<TListenerType, zzexv> zzokt = new HashMap();
    private StorageTask<TResult> zzoku;
    private int zzokv;
    private zzab<TListenerType, TResult> zzokw;

    public zzx(@NonNull StorageTask<TResult> storageTask, int i, @NonNull zzab<TListenerType, TResult> com_google_firebase_storage_zzab_TListenerType__TResult) {
        this.zzoku = storageTask;
        this.zzokv = i;
        this.zzokw = com_google_firebase_storage_zzab_TListenerType__TResult;
    }

    public final void zza(@Nullable Activity activity, @Nullable Executor executor, @NonNull TListenerType tListenerType) {
        zzbq.checkNotNull(tListenerType);
        synchronized (this.zzoku.mSyncObject) {
            int i = (this.zzoku.zzclt() & this.zzokv) != 0 ? 1 : 0;
            this.zzoks.add(tListenerType);
            zzexv com_google_android_gms_internal_zzexv = new zzexv(executor);
            this.zzokt.put(tListenerType, com_google_android_gms_internal_zzexv);
            if (activity != null) {
                if (VERSION.SDK_INT >= 17) {
                    zzbq.checkArgument(activity.isDestroyed() ^ true, "Activity is already destroyed!");
                }
                zzexo.zzcme().zza(activity, tListenerType, new zzy(this, tListenerType));
            }
        }
        if (i != 0) {
            com_google_android_gms_internal_zzexv.zzw(new zzz(this, tListenerType, this.zzoku.zzclu()));
        }
    }

    public final void zzcl(@NonNull TListenerType tListenerType) {
        zzbq.checkNotNull(tListenerType);
        synchronized (this.zzoku.mSyncObject) {
            this.zzokt.remove(tListenerType);
            this.zzoks.remove(tListenerType);
            zzexo.zzcme().zzcm(tListenerType);
        }
    }

    public final void zzcmb() {
        if ((this.zzoku.zzclt() & this.zzokv) != 0) {
            ProvideError zzclu = this.zzoku.zzclu();
            for (Object next : this.zzoks) {
                zzexv com_google_android_gms_internal_zzexv = (zzexv) this.zzokt.get(next);
                if (com_google_android_gms_internal_zzexv != null) {
                    com_google_android_gms_internal_zzexv.zzw(new zzaa(this, next, zzclu));
                }
            }
        }
    }
}
