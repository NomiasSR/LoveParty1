package com.google.firebase.iid;

import android.content.Intent;
import android.util.Log;

final class zze implements Runnable {
    private /* synthetic */ Intent val$intent;
    private /* synthetic */ zzd zznyk;

    zze(zzd com_google_firebase_iid_zzd, Intent intent) {
        this.zznyk = com_google_firebase_iid_zzd;
        this.val$intent = intent;
    }

    public final void run() {
        String action = this.val$intent.getAction();
        StringBuilder stringBuilder = new StringBuilder(61 + String.valueOf(action).length());
        stringBuilder.append("Service took too long to process intent: ");
        stringBuilder.append(action);
        stringBuilder.append(" App may get closed.");
        Log.w("EnhancedIntentService", stringBuilder.toString());
        this.zznyk.finish();
    }
}
