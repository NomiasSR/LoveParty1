package com.google.android.gms.internal;

import java.io.EOFException;

final class zzeco implements Runnable {
    private /* synthetic */ zzeck zzmqg;
    private /* synthetic */ zzela zzmqi;

    zzeco(zzeck com_google_android_gms_internal_zzeck, zzela com_google_android_gms_internal_zzela) {
        this.zzmqg = com_google_android_gms_internal_zzeck;
        this.zzmqi = com_google_android_gms_internal_zzela;
    }

    public final void run() {
        zzejc zzb;
        String str;
        Throwable th;
        Object[] objArr;
        if (this.zzmqi.getCause() == null || !(this.zzmqi.getCause() instanceof EOFException)) {
            zzb = this.zzmqg.zzmqe.zzmlr;
            str = "WebSocket error.";
            th = this.zzmqi;
            objArr = new Object[0];
        } else {
            zzb = this.zzmqg.zzmqe.zzmlr;
            str = "WebSocket reached EOF.";
            objArr = new Object[0];
            th = null;
        }
        zzb.zzb(str, th, objArr);
        this.zzmqg.zzmqe.zzbve();
    }
}
