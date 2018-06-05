package com.google.android.gms.internal;

import android.support.v4.media.session.PlaybackStateCompat;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseException;
import com.google.firebase.database.Logger.Level;

public final class zzedf extends zzedc {
    public final synchronized void setLogLevel(Level level) {
        zzbvx();
        switch (zzedg.zzmsk[level.ordinal()]) {
            case 1:
                this.zzmsg = zzeje.DEBUG;
                return;
            case 2:
                this.zzmsg = zzeje.INFO;
                return;
            case 3:
                this.zzmsg = zzeje.WARN;
                return;
            case 4:
                this.zzmsg = zzeje.ERROR;
                return;
            case 5:
                this.zzmsg = zzeje.NONE;
                return;
            default:
                String valueOf = String.valueOf(level);
                StringBuilder stringBuilder = new StringBuilder(19 + String.valueOf(valueOf).length());
                stringBuilder.append("Unknown log level: ");
                stringBuilder.append(valueOf);
                throw new IllegalArgumentException(stringBuilder.toString());
        }
    }

    public final synchronized void setPersistenceCacheSizeBytes(long j) {
        zzbvx();
        if (j < PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) {
            throw new DatabaseException("The minimum cache size must be at least 1MB");
        } else if (j > 104857600) {
            throw new DatabaseException("Firebase Database currently doesn't support a cache size larger than 100MB");
        } else {
            this.cacheSize = j;
        }
    }

    public final synchronized void setPersistenceEnabled(boolean z) {
        zzbvx();
        this.zzmnr = z;
    }

    public final synchronized void zzd(FirebaseApp firebaseApp) {
        this.zzmlg = firebaseApp;
    }

    public final synchronized void zzpx(String str) {
        zzbvx();
        if (str != null) {
            if (!str.isEmpty()) {
                this.zzmsf = str;
            }
        }
        throw new IllegalArgumentException("Session identifier is not allowed to be empty or null!");
    }
}
