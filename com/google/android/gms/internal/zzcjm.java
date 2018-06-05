package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.common.internal.zzbq;

public final class zzcjm {
    final Context mContext;

    public zzcjm(Context context) {
        zzbq.checkNotNull(context);
        context = context.getApplicationContext();
        zzbq.checkNotNull(context);
        this.mContext = context;
    }
}
