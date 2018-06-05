package com.google.android.gms.internal;

import android.app.Activity;
import android.support.annotation.NonNull;

final class zzexp {
    @NonNull
    private final Activity mActivity;
    @NonNull
    private final Object zzolq;
    @NonNull
    private final Runnable zzz;

    public zzexp(@NonNull Activity activity, @NonNull Runnable runnable, @NonNull Object obj) {
        this.mActivity = activity;
        this.zzz = runnable;
        this.zzolq = obj;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzexp)) {
            return false;
        }
        zzexp com_google_android_gms_internal_zzexp = (zzexp) obj;
        return com_google_android_gms_internal_zzexp.zzolq.equals(this.zzolq) && com_google_android_gms_internal_zzexp.zzz == this.zzz && com_google_android_gms_internal_zzexp.mActivity == this.mActivity;
    }

    @NonNull
    public final Activity getActivity() {
        return this.mActivity;
    }

    public final int hashCode() {
        return this.zzolq.hashCode();
    }

    @NonNull
    public final Runnable zzbko() {
        return this.zzz;
    }

    @NonNull
    public final Object zzcmf() {
        return this.zzolq;
    }
}
