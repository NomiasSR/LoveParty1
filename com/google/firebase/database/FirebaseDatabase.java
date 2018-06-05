package com.google.firebase.database;

import android.text.TextUtils;
import com.google.android.gms.internal.zzedf;
import com.google.android.gms.internal.zzedk;
import com.google.android.gms.internal.zzedn;
import com.google.android.gms.internal.zzeeq;
import com.google.android.gms.internal.zzeer;
import com.google.android.gms.internal.zzelr;
import com.google.android.gms.internal.zzelt;
import com.google.android.gms.internal.zzelv;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.Logger.Level;
import java.util.HashMap;
import java.util.Map;

public class FirebaseDatabase {
    private static final Map<String, Map<zzeeq, FirebaseDatabase>> zzmkh = new HashMap();
    private final FirebaseApp zzmki;
    private final zzeeq zzmkj;
    private final zzedf zzmkk;
    private zzedn zzmkl;

    private FirebaseDatabase(FirebaseApp firebaseApp, zzeeq com_google_android_gms_internal_zzeeq, zzedf com_google_android_gms_internal_zzedf) {
        this.zzmki = firebaseApp;
        this.zzmkj = com_google_android_gms_internal_zzeeq;
        this.zzmkk = com_google_android_gms_internal_zzedf;
    }

    public static FirebaseDatabase getInstance() {
        FirebaseApp instance = FirebaseApp.getInstance();
        if (instance != null) {
            return getInstance(instance, instance.getOptions().getDatabaseUrl());
        }
        throw new DatabaseException("You must call FirebaseApp.initialize() first.");
    }

    public static FirebaseDatabase getInstance(FirebaseApp firebaseApp) {
        return getInstance(firebaseApp, firebaseApp.getOptions().getDatabaseUrl());
    }

    public static synchronized FirebaseDatabase getInstance(FirebaseApp firebaseApp, String str) {
        FirebaseDatabase firebaseDatabase;
        synchronized (FirebaseDatabase.class) {
            if (TextUtils.isEmpty(str)) {
                throw new DatabaseException("Failed to get FirebaseDatabase instance: Specify DatabaseURL within FirebaseApp or from your getInstance() call.");
            }
            Map map = (Map) zzmkh.get(firebaseApp.getName());
            if (map == null) {
                map = new HashMap();
                zzmkh.put(firebaseApp.getName(), map);
            }
            zzelr zzqd = zzelt.zzqd(str);
            if (zzqd.zzmks.isEmpty()) {
                firebaseDatabase = (FirebaseDatabase) map.get(zzqd.zzmkj);
                if (firebaseDatabase == null) {
                    zzedf com_google_android_gms_internal_zzedf = new zzedf();
                    if (!firebaseApp.zzbqo()) {
                        com_google_android_gms_internal_zzedf.zzpx(firebaseApp.getName());
                    }
                    com_google_android_gms_internal_zzedf.zzd(firebaseApp);
                    FirebaseDatabase firebaseDatabase2 = new FirebaseDatabase(firebaseApp, zzqd.zzmkj, com_google_android_gms_internal_zzedf);
                    map.put(zzqd.zzmkj, firebaseDatabase2);
                    firebaseDatabase = firebaseDatabase2;
                }
            } else {
                String com_google_android_gms_internal_zzedk = zzqd.zzmks.toString();
                StringBuilder stringBuilder = new StringBuilder((113 + String.valueOf(str).length()) + String.valueOf(com_google_android_gms_internal_zzedk).length());
                stringBuilder.append("Specified Database URL '");
                stringBuilder.append(str);
                stringBuilder.append("' is invalid. It should point to the root of a Firebase Database but it includes a path: ");
                stringBuilder.append(com_google_android_gms_internal_zzedk);
                throw new DatabaseException(stringBuilder.toString());
            }
        }
        return firebaseDatabase;
    }

    public static FirebaseDatabase getInstance(String str) {
        FirebaseApp instance = FirebaseApp.getInstance();
        if (instance != null) {
            return getInstance(instance, str);
        }
        throw new DatabaseException("You must call FirebaseApp.initialize() first.");
    }

    public static String getSdkVersion() {
        return "3.0.0";
    }

    private final synchronized void zzbsu() {
        if (this.zzmkl == null) {
            this.zzmkl = zzeer.zza(this.zzmkk, this.zzmkj, this);
        }
    }

    private final void zzph(String str) {
        if (this.zzmkl != null) {
            StringBuilder stringBuilder = new StringBuilder(77 + String.valueOf(str).length());
            stringBuilder.append("Calls to ");
            stringBuilder.append(str);
            stringBuilder.append("() must be made before any other usage of FirebaseDatabase instance.");
            throw new DatabaseException(stringBuilder.toString());
        }
    }

    public FirebaseApp getApp() {
        return this.zzmki;
    }

    public DatabaseReference getReference() {
        zzbsu();
        return new DatabaseReference(this.zzmkl, zzedk.zzbwe());
    }

    public DatabaseReference getReference(String str) {
        zzbsu();
        if (str == null) {
            throw new NullPointerException("Can't pass null for argument 'pathString' in FirebaseDatabase.getReference()");
        }
        zzelv.zzqi(str);
        return new DatabaseReference(this.zzmkl, new zzedk(str));
    }

    public DatabaseReference getReferenceFromUrl(String str) {
        zzbsu();
        if (str == null) {
            throw new NullPointerException("Can't pass null for argument 'url' in FirebaseDatabase.getReferenceFromUrl()");
        }
        zzelr zzqd = zzelt.zzqd(str);
        if (zzqd.zzmkj.host.equals(this.zzmkl.zzbwm().host)) {
            return new DatabaseReference(this.zzmkl, zzqd.zzmks);
        }
        String databaseReference = getReference().toString();
        StringBuilder stringBuilder = new StringBuilder((93 + String.valueOf(str).length()) + String.valueOf(databaseReference).length());
        stringBuilder.append("Invalid URL (");
        stringBuilder.append(str);
        stringBuilder.append(") passed to getReference().  URL was expected to match configured Database URL: ");
        stringBuilder.append(databaseReference);
        throw new DatabaseException(stringBuilder.toString());
    }

    public void goOffline() {
        zzbsu();
        zzeer.zzk(this.zzmkl);
    }

    public void goOnline() {
        zzbsu();
        zzeer.zzl(this.zzmkl);
    }

    public void purgeOutstandingWrites() {
        zzbsu();
        this.zzmkl.zzo(new zzg(this));
    }

    public synchronized void setLogLevel(Level level) {
        zzph("setLogLevel");
        this.zzmkk.setLogLevel(level);
    }

    public synchronized void setPersistenceCacheSizeBytes(long j) {
        zzph("setPersistenceCacheSizeBytes");
        this.zzmkk.setPersistenceCacheSizeBytes(j);
    }

    public synchronized void setPersistenceEnabled(boolean z) {
        zzph("setPersistenceEnabled");
        this.zzmkk.setPersistenceEnabled(z);
    }
}
