package com.google.firebase.storage;

import android.net.Uri;
import android.net.Uri.Builder;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.internal.zzexw;
import com.google.firebase.FirebaseApp;
import java.util.HashMap;
import java.util.Map;

public class FirebaseStorage {
    private static final Map<String, Map<String, FirebaseStorage>> zzoib = new HashMap();
    @NonNull
    private final FirebaseApp zzoic;
    @Nullable
    private final String zzoid;
    private long zzoie = 600000;
    private long zzoif = 600000;
    private long zzoig = 120000;

    private FirebaseStorage(@Nullable String str, @NonNull FirebaseApp firebaseApp) {
        this.zzoid = str;
        this.zzoic = firebaseApp;
    }

    @NonNull
    public static FirebaseStorage getInstance() {
        FirebaseApp instance = FirebaseApp.getInstance();
        zzbq.checkArgument(instance != null, "You must call FirebaseApp.initialize() first.");
        return getInstance(instance);
    }

    @NonNull
    public static FirebaseStorage getInstance(@NonNull FirebaseApp firebaseApp) {
        zzbq.checkArgument(firebaseApp != null, "Null is not a valid value for the FirebaseApp.");
        String storageBucket = firebaseApp.getOptions().getStorageBucket();
        if (storageBucket == null) {
            return zza(firebaseApp, null);
        }
        String str;
        String valueOf;
        try {
            str = "gs://";
            valueOf = String.valueOf(firebaseApp.getOptions().getStorageBucket());
            return zza(firebaseApp, zzexw.zzf(firebaseApp, valueOf.length() != 0 ? str.concat(valueOf) : new String(str)));
        } catch (Throwable e) {
            str = "FirebaseStorage";
            valueOf = "Unable to parse bucket:";
            storageBucket = String.valueOf(storageBucket);
            Log.e(str, storageBucket.length() != 0 ? valueOf.concat(storageBucket) : new String(valueOf), e);
            throw new IllegalArgumentException("The storage Uri could not be parsed.");
        }
    }

    @NonNull
    public static FirebaseStorage getInstance(@NonNull FirebaseApp firebaseApp, @NonNull String str) {
        zzbq.checkArgument(firebaseApp != null, "Null is not a valid value for the FirebaseApp.");
        if (str.toLowerCase().startsWith("gs://")) {
            try {
                return zza(firebaseApp, zzexw.zzf(firebaseApp, str));
            } catch (Throwable e) {
                String str2 = "FirebaseStorage";
                String str3 = "Unable to parse url:";
                str = String.valueOf(str);
                Log.e(str2, str.length() != 0 ? str3.concat(str) : new String(str3), e);
                throw new IllegalArgumentException("The storage Uri could not be parsed.");
            }
        }
        throw new IllegalArgumentException("Please use a gs:// URL for your Firebase Storage bucket.");
    }

    @NonNull
    public static FirebaseStorage getInstance(@NonNull String str) {
        FirebaseApp instance = FirebaseApp.getInstance();
        zzbq.checkArgument(instance != null, "You must call FirebaseApp.initialize() first.");
        return getInstance(instance, str);
    }

    private static FirebaseStorage zza(@NonNull FirebaseApp firebaseApp, @Nullable Uri uri) {
        String host = uri != null ? uri.getHost() : null;
        if (uri == null || TextUtils.isEmpty(uri.getPath())) {
            FirebaseStorage firebaseStorage;
            synchronized (zzoib) {
                Map map = (Map) zzoib.get(firebaseApp.getName());
                if (map == null) {
                    map = new HashMap();
                    zzoib.put(firebaseApp.getName(), map);
                }
                firebaseStorage = (FirebaseStorage) map.get(host);
                if (firebaseStorage == null) {
                    firebaseStorage = new FirebaseStorage(host, firebaseApp);
                    map.put(host, firebaseStorage);
                }
            }
            return firebaseStorage;
        }
        throw new IllegalArgumentException("The storage Uri cannot contain a path element.");
    }

    @NonNull
    private final StorageReference zzt(@NonNull Uri uri) {
        boolean z;
        zzbq.checkNotNull(uri, "uri must not be null");
        Object obj = this.zzoid;
        if (!TextUtils.isEmpty(obj)) {
            if (!uri.getAuthority().equalsIgnoreCase(obj)) {
                z = false;
                zzbq.checkArgument(z, "The supplied bucketname does not match the storage bucket of the current instance.");
                return new StorageReference(uri, this);
            }
        }
        z = true;
        zzbq.checkArgument(z, "The supplied bucketname does not match the storage bucket of the current instance.");
        return new StorageReference(uri, this);
    }

    @NonNull
    public FirebaseApp getApp() {
        return this.zzoic;
    }

    public long getMaxDownloadRetryTimeMillis() {
        return this.zzoif;
    }

    public long getMaxOperationRetryTimeMillis() {
        return this.zzoig;
    }

    public long getMaxUploadRetryTimeMillis() {
        return this.zzoie;
    }

    @NonNull
    public StorageReference getReference() {
        if (!TextUtils.isEmpty(this.zzoid)) {
            return zzt(new Builder().scheme("gs").authority(this.zzoid).path("/").build());
        }
        throw new IllegalStateException("FirebaseApp was not initialized with a bucket name.");
    }

    @NonNull
    public StorageReference getReference(@NonNull String str) {
        zzbq.checkArgument(TextUtils.isEmpty(str) ^ 1, "location must not be null or empty");
        String toLowerCase = str.toLowerCase();
        if (!(toLowerCase.startsWith("gs://") || toLowerCase.startsWith("https://"))) {
            if (!toLowerCase.startsWith("http://")) {
                return getReference().child(str);
            }
        }
        throw new IllegalArgumentException("location should not be a full URL.");
    }

    @NonNull
    public StorageReference getReferenceFromUrl(@NonNull String str) {
        zzbq.checkArgument(TextUtils.isEmpty(str) ^ 1, "location must not be null or empty");
        String toLowerCase = str.toLowerCase();
        if (!(toLowerCase.startsWith("gs://") || toLowerCase.startsWith("https://"))) {
            if (!toLowerCase.startsWith("http://")) {
                throw new IllegalArgumentException("The storage Uri could not be parsed.");
            }
        }
        try {
            Uri zzf = zzexw.zzf(this.zzoic, str);
            if (zzf != null) {
                return zzt(zzf);
            }
            throw new IllegalArgumentException("The storage Uri could not be parsed.");
        } catch (Throwable e) {
            String str2 = "FirebaseStorage";
            String str3 = "Unable to parse location:";
            str = String.valueOf(str);
            Log.e(str2, str.length() != 0 ? str3.concat(str) : new String(str3), e);
            throw new IllegalArgumentException("The storage Uri could not be parsed.");
        }
    }

    public void setMaxDownloadRetryTimeMillis(long j) {
        this.zzoif = j;
    }

    public void setMaxOperationRetryTimeMillis(long j) {
        this.zzoig = j;
    }

    public void setMaxUploadRetryTimeMillis(long j) {
        this.zzoie = j;
    }
}
