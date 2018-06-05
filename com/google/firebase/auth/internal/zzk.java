package com.google.firebase.auth.internal;

import android.os.Handler;
import android.os.HandlerThread;
import android.support.annotation.NonNull;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.common.util.zzh;
import com.google.android.gms.internal.zzbgg;
import com.google.firebase.FirebaseApp;

public final class zzk {
    private static zzbgg zzecc = new zzbgg("TokenRefresher", "FirebaseAuth:");
    private Handler mHandler;
    private HandlerThread zzdcv = new HandlerThread("TokenRefresher", 10);
    private final FirebaseApp zzmcx;
    volatile long zzmhs;
    volatile long zzmht;
    private long zzmhu;
    private Runnable zzz;

    public zzk(@NonNull FirebaseApp firebaseApp) {
        zzecc.zza("Initializing TokenRefresher", new Object[0]);
        this.zzmcx = (FirebaseApp) zzbq.checkNotNull(firebaseApp);
        this.zzdcv.start();
        this.mHandler = new Handler(this.zzdcv.getLooper());
        this.zzz = new zzl(this, this.zzmcx.getName());
        this.zzmhu = 300000;
    }

    public final void cancel() {
        this.mHandler.removeCallbacks(this.zzz);
    }

    public final void zzbsd() {
        zzbgg com_google_android_gms_internal_zzbgg = zzecc;
        long j = this.zzmhs - this.zzmhu;
        StringBuilder stringBuilder = new StringBuilder(43);
        stringBuilder.append("Scheduling refresh for ");
        stringBuilder.append(j);
        com_google_android_gms_internal_zzbgg.zza(stringBuilder.toString(), new Object[0]);
        cancel();
        this.zzmht = Math.max((this.zzmhs - zzh.zzamg().currentTimeMillis()) - this.zzmhu, 0) / 1000;
        this.mHandler.postDelayed(this.zzz, this.zzmht * 1000);
    }

    final void zzbse() {
        int i = (int) this.zzmht;
        long j = (i == 30 || i == 60 || i == 120 || i == 240 || i == 480) ? 2 * this.zzmht : i != 960 ? 30 : 960;
        this.zzmht = j;
        this.zzmhs = zzh.zzamg().currentTimeMillis() + (this.zzmht * 1000);
        zzbgg com_google_android_gms_internal_zzbgg = zzecc;
        long j2 = this.zzmhs;
        StringBuilder stringBuilder = new StringBuilder(43);
        stringBuilder.append("Scheduling refresh for ");
        stringBuilder.append(j2);
        com_google_android_gms_internal_zzbgg.zza(stringBuilder.toString(), new Object[0]);
        this.mHandler.postDelayed(this.zzz, this.zzmht * 1000);
    }
}
