package com.google.firebase.storage;

import android.net.Uri;
import android.os.RemoteException;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.internal.zzexs;
import com.google.android.gms.internal.zzeyb;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.storage.StreamDownloadTask.StreamProcessor;
import java.io.File;
import java.io.InputStream;
import java.util.List;

public class StorageReference {
    private final Uri zzoje;
    private final FirebaseStorage zzojf;

    StorageReference(@NonNull Uri uri, @NonNull FirebaseStorage firebaseStorage) {
        boolean z = false;
        zzbq.checkArgument(uri != null, "storageUri cannot be null");
        if (firebaseStorage != null) {
            z = true;
        }
        zzbq.checkArgument(z, "FirebaseApp cannot be null");
        this.zzoje = uri;
        this.zzojf = firebaseStorage;
    }

    @NonNull
    public StorageReference child(@NonNull String str) {
        zzbq.checkArgument(TextUtils.isEmpty(str) ^ 1, "childName cannot be null or empty");
        str = zzexs.zzsj(str);
        try {
            return new StorageReference(this.zzoje.buildUpon().appendEncodedPath(zzexs.zzsh(str)).build(), this.zzojf);
        } catch (Throwable e) {
            String str2 = "StorageReference";
            String str3 = "Unable to create a valid default Uri. ";
            str = String.valueOf(str);
            Log.e(str2, str.length() != 0 ? str3.concat(str) : new String(str3), e);
            throw new IllegalArgumentException("childName");
        }
    }

    public Task<Void> delete() {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        zzu.zzs(new zzb(this, taskCompletionSource));
        return taskCompletionSource.getTask();
    }

    public boolean equals(Object obj) {
        return !(obj instanceof StorageReference) ? false : ((StorageReference) obj).toString().equals(toString());
    }

    @NonNull
    public List<FileDownloadTask> getActiveDownloadTasks() {
        return zzt.zzclx().zzb(this);
    }

    @NonNull
    public List<UploadTask> getActiveUploadTasks() {
        return zzt.zzclx().zza(this);
    }

    @NonNull
    public String getBucket() {
        return this.zzoje.getAuthority();
    }

    @NonNull
    public Task<byte[]> getBytes(long j) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        StorageTask streamDownloadTask = new StreamDownloadTask(this);
        ((StorageTask) streamDownloadTask.zza(new zzi(this, j, taskCompletionSource)).addOnSuccessListener(new zzh(this, taskCompletionSource))).addOnFailureListener(new zzg(this, taskCompletionSource));
        streamDownloadTask.zzcls();
        return taskCompletionSource.getTask();
    }

    @NonNull
    public Task<Uri> getDownloadUrl() {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        Task metadata = getMetadata();
        metadata.addOnSuccessListener(new zze(this, taskCompletionSource));
        metadata.addOnFailureListener(new zzf(this, taskCompletionSource));
        return taskCompletionSource.getTask();
    }

    @NonNull
    public FileDownloadTask getFile(@NonNull Uri uri) {
        StorageTask fileDownloadTask = new FileDownloadTask(this, uri);
        fileDownloadTask.zzcls();
        return fileDownloadTask;
    }

    @NonNull
    public FileDownloadTask getFile(@NonNull File file) {
        return getFile(Uri.fromFile(file));
    }

    @NonNull
    public Task<StorageMetadata> getMetadata() {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        zzu.zzs(new zzc(this, taskCompletionSource));
        return taskCompletionSource.getTask();
    }

    @NonNull
    public String getName() {
        String path = this.zzoje.getPath();
        int lastIndexOf = path.lastIndexOf(47);
        return lastIndexOf != -1 ? path.substring(lastIndexOf + 1) : path;
    }

    @Nullable
    public StorageReference getParent() {
        String path = this.zzoje.getPath();
        if (!TextUtils.isEmpty(path)) {
            if (!path.equals("/")) {
                int lastIndexOf = path.lastIndexOf(47);
                return new StorageReference(this.zzoje.buildUpon().path(lastIndexOf == -1 ? "/" : path.substring(0, lastIndexOf)).build(), this.zzojf);
            }
        }
        return null;
    }

    @NonNull
    public String getPath() {
        return this.zzoje.getPath();
    }

    @NonNull
    public StorageReference getRoot() {
        return new StorageReference(this.zzoje.buildUpon().path("").build(), this.zzojf);
    }

    @NonNull
    public FirebaseStorage getStorage() {
        return this.zzojf;
    }

    @NonNull
    public StreamDownloadTask getStream() {
        StorageTask streamDownloadTask = new StreamDownloadTask(this);
        streamDownloadTask.zzcls();
        return streamDownloadTask;
    }

    @NonNull
    public StreamDownloadTask getStream(@NonNull StreamProcessor streamProcessor) {
        StorageTask streamDownloadTask = new StreamDownloadTask(this);
        streamDownloadTask.zza(streamProcessor);
        streamDownloadTask.zzcls();
        return streamDownloadTask;
    }

    public int hashCode() {
        return toString().hashCode();
    }

    @NonNull
    public UploadTask putBytes(@NonNull byte[] bArr) {
        zzbq.checkArgument(bArr != null, "bytes cannot be null");
        StorageTask uploadTask = new UploadTask(this, null, bArr);
        uploadTask.zzcls();
        return uploadTask;
    }

    @NonNull
    public UploadTask putBytes(@NonNull byte[] bArr, @NonNull StorageMetadata storageMetadata) {
        boolean z = false;
        zzbq.checkArgument(bArr != null, "bytes cannot be null");
        if (storageMetadata != null) {
            z = true;
        }
        zzbq.checkArgument(z, "metadata cannot be null");
        StorageTask uploadTask = new UploadTask(this, storageMetadata, bArr);
        uploadTask.zzcls();
        return uploadTask;
    }

    @NonNull
    public UploadTask putFile(@NonNull Uri uri) {
        zzbq.checkArgument(uri != null, "uri cannot be null");
        StorageTask uploadTask = new UploadTask(this, null, uri, null);
        uploadTask.zzcls();
        return uploadTask;
    }

    @NonNull
    public UploadTask putFile(@NonNull Uri uri, @NonNull StorageMetadata storageMetadata) {
        boolean z = false;
        zzbq.checkArgument(uri != null, "uri cannot be null");
        if (storageMetadata != null) {
            z = true;
        }
        zzbq.checkArgument(z, "metadata cannot be null");
        StorageTask uploadTask = new UploadTask(this, storageMetadata, uri, null);
        uploadTask.zzcls();
        return uploadTask;
    }

    @NonNull
    public UploadTask putFile(@NonNull Uri uri, @Nullable StorageMetadata storageMetadata, @Nullable Uri uri2) {
        boolean z = false;
        zzbq.checkArgument(uri != null, "uri cannot be null");
        if (storageMetadata != null) {
            z = true;
        }
        zzbq.checkArgument(z, "metadata cannot be null");
        StorageTask uploadTask = new UploadTask(this, storageMetadata, uri, uri2);
        uploadTask.zzcls();
        return uploadTask;
    }

    @NonNull
    public UploadTask putStream(@NonNull InputStream inputStream) {
        zzbq.checkArgument(inputStream != null, "stream cannot be null");
        StorageTask uploadTask = new UploadTask(this, null, inputStream);
        uploadTask.zzcls();
        return uploadTask;
    }

    @NonNull
    public UploadTask putStream(@NonNull InputStream inputStream, @NonNull StorageMetadata storageMetadata) {
        boolean z = false;
        zzbq.checkArgument(inputStream != null, "stream cannot be null");
        if (storageMetadata != null) {
            z = true;
        }
        zzbq.checkArgument(z, "metadata cannot be null");
        StorageTask uploadTask = new UploadTask(this, storageMetadata, inputStream);
        uploadTask.zzcls();
        return uploadTask;
    }

    public String toString() {
        String authority = this.zzoje.getAuthority();
        String encodedPath = this.zzoje.getEncodedPath();
        StringBuilder stringBuilder = new StringBuilder((5 + String.valueOf(authority).length()) + String.valueOf(encodedPath).length());
        stringBuilder.append("gs://");
        stringBuilder.append(authority);
        stringBuilder.append(encodedPath);
        return stringBuilder.toString();
    }

    @NonNull
    public Task<StorageMetadata> updateMetadata(@NonNull StorageMetadata storageMetadata) {
        zzbq.checkNotNull(storageMetadata);
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        zzu.zzs(new zzac(this, taskCompletionSource, storageMetadata));
        return taskCompletionSource.getTask();
    }

    @NonNull
    final zzeyb zzclq() throws RemoteException {
        return zzeyb.zzi(getStorage().getApp());
    }

    @NonNull
    final Uri zzclr() {
        return this.zzoje;
    }
}
