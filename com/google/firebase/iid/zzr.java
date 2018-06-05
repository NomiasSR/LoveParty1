package com.google.firebase.iid;

import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.tasks.TaskCompletionSource;

abstract class zzr<T> {
    final int what;
    final TaskCompletionSource<T> zzgrq = new TaskCompletionSource();
    final int zzift;
    final Bundle zznzj;

    zzr(int i, int i2, Bundle bundle) {
        this.zzift = i;
        this.what = i2;
        this.zznzj = bundle;
    }

    final void finish(T t) {
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            String valueOf = String.valueOf(this);
            String valueOf2 = String.valueOf(t);
            StringBuilder stringBuilder = new StringBuilder((16 + String.valueOf(valueOf).length()) + String.valueOf(valueOf2).length());
            stringBuilder.append("Finishing ");
            stringBuilder.append(valueOf);
            stringBuilder.append(" with ");
            stringBuilder.append(valueOf2);
            Log.d("MessengerIpcClient", stringBuilder.toString());
        }
        this.zzgrq.setResult(t);
    }

    public String toString() {
        int i = this.what;
        int i2 = this.zzift;
        boolean zzcje = zzcje();
        StringBuilder stringBuilder = new StringBuilder(55);
        stringBuilder.append("Request { what=");
        stringBuilder.append(i);
        stringBuilder.append(" id=");
        stringBuilder.append(i2);
        stringBuilder.append(" oneWay=");
        stringBuilder.append(zzcje);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    abstract void zzac(Bundle bundle);

    final void zzb(zzs com_google_firebase_iid_zzs) {
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            String valueOf = String.valueOf(this);
            String valueOf2 = String.valueOf(com_google_firebase_iid_zzs);
            StringBuilder stringBuilder = new StringBuilder((14 + String.valueOf(valueOf).length()) + String.valueOf(valueOf2).length());
            stringBuilder.append("Failing ");
            stringBuilder.append(valueOf);
            stringBuilder.append(" with ");
            stringBuilder.append(valueOf2);
            Log.d("MessengerIpcClient", stringBuilder.toString());
        }
        this.zzgrq.setException(com_google_firebase_iid_zzs);
    }

    abstract boolean zzcje();
}
