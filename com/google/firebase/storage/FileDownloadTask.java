package com.google.firebase.storage;

import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.helper.ItemTouchHelper.Callback;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.zzexr;
import com.google.android.gms.internal.zzeyb;
import com.google.android.gms.internal.zzeyc;
import com.google.firebase.storage.StorageTask.ProvideError;
import com.google.firebase.storage.StorageTask.SnapshotBase;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileDownloadTask extends StorageTask<TaskSnapshot> {
    private int mResultCode;
    private long zzgmb = -1;
    private volatile Exception zzkuq = null;
    private StorageReference zzoht;
    private zzexr zzohv;
    private final Uri zzohw;
    private long zzohx;
    private String zzohy = null;
    private long zzohz = 0;

    public class TaskSnapshot extends SnapshotBase {
        private final long zzohx;
        private /* synthetic */ FileDownloadTask zzoia;

        TaskSnapshot(@Nullable FileDownloadTask fileDownloadTask, Exception exception, long j) {
            this.zzoia = fileDownloadTask;
            super(fileDownloadTask, exception);
            this.zzohx = j;
        }

        public long getBytesTransferred() {
            return this.zzohx;
        }

        public long getTotalByteCount() {
            return this.zzoia.getTotalBytes();
        }
    }

    FileDownloadTask(@NonNull StorageReference storageReference, @NonNull Uri uri) {
        this.zzoht = storageReference;
        this.zzohw = uri;
        this.zzohv = new zzexr(this.zzoht.getStorage().getApp(), this.zzoht.getStorage().getMaxDownloadRetryTimeMillis());
    }

    private final int zza(InputStream inputStream, byte[] bArr) {
        int i = 0;
        int i2 = 0;
        while (i != bArr.length) {
            try {
                int read = inputStream.read(bArr, i, bArr.length - i);
                if (read == -1) {
                    break;
                }
                i2 = 1;
                i += read;
            } catch (Exception e) {
                this.zzkuq = e;
            }
        }
        return i2 != 0 ? i : -1;
    }

    private final boolean zza(zzeyc com_google_android_gms_internal_zzeyc) throws IOException {
        InputStream stream = com_google_android_gms_internal_zzeyc.getStream();
        if (stream != null) {
            OutputStream fileOutputStream;
            File file = new File(this.zzohw.getPath());
            if (!file.exists()) {
                if (this.zzohz > 0) {
                    String str = "FileDownloadTask";
                    String str2 = "The file downloading to has been deleted:";
                    String valueOf = String.valueOf(file.getAbsolutePath());
                    Log.e(str, valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
                    throw new IllegalStateException("expected a file to resume from.");
                } else if (!file.createNewFile()) {
                    String str3 = "FileDownloadTask";
                    String str4 = "unable to create file:";
                    String valueOf2 = String.valueOf(file.getAbsolutePath());
                    Log.w(str3, valueOf2.length() != 0 ? str4.concat(valueOf2) : new String(str4));
                }
            }
            boolean z = true;
            if (this.zzohz > 0) {
                String absolutePath = file.getAbsolutePath();
                long j = this.zzohz;
                StringBuilder stringBuilder = new StringBuilder(47 + String.valueOf(absolutePath).length());
                stringBuilder.append("Resuming download file ");
                stringBuilder.append(absolutePath);
                stringBuilder.append(" at ");
                stringBuilder.append(j);
                Log.d("FileDownloadTask", stringBuilder.toString());
                fileOutputStream = new FileOutputStream(file, true);
            } else {
                fileOutputStream = new FileOutputStream(file);
            }
            try {
                byte[] bArr = new byte[262144];
                while (z) {
                    int zza = zza(stream, bArr);
                    if (zza == -1) {
                        break;
                    }
                    fileOutputStream.write(bArr, 0, zza);
                    this.zzohx += (long) zza;
                    if (this.zzkuq != null) {
                        Log.d("FileDownloadTask", "Exception occurred during file download. Retrying.", this.zzkuq);
                        this.zzkuq = null;
                        z = false;
                    }
                    if (!zzk(4, false)) {
                        z = false;
                    }
                }
                fileOutputStream.flush();
                fileOutputStream.close();
                stream.close();
                return z;
            } catch (Throwable th) {
                fileOutputStream.flush();
                fileOutputStream.close();
                stream.close();
            }
        } else {
            this.zzkuq = new IllegalStateException("Unable to open Firebase Storage stream.");
            return false;
        }
    }

    @NonNull
    final StorageReference getStorage() {
        return this.zzoht;
    }

    final long getTotalBytes() {
        return this.zzgmb;
    }

    protected void onCanceled() {
        this.zzohv.cancel();
        this.zzkuq = StorageException.fromErrorStatus(Status.zzfnm);
    }

    final void run() {
        if (this.zzkuq != null) {
            zzk(64, false);
        } else if (zzk(4, false)) {
            do {
                this.zzohx = 0;
                this.zzkuq = null;
                this.zzohv.reset();
                try {
                    boolean z;
                    Object zzsn;
                    boolean zza;
                    File file;
                    int zzclt;
                    StringBuilder stringBuilder;
                    zzeyc zza2 = zzeyb.zzi(this.zzoht.getStorage().getApp()).zza(this.zzoht.zzclr(), this.zzohz);
                    this.zzohv.zza(zza2, false);
                    this.mResultCode = zza2.getResultCode();
                    this.zzkuq = zza2.getException() != null ? zza2.getException() : this.zzkuq;
                    int i = this.mResultCode;
                    boolean z2 = true;
                    if (i != 308) {
                        if (i < Callback.DEFAULT_DRAG_ANIMATION_DURATION || i >= 300) {
                            z = false;
                            z = z && this.zzkuq == null && zzclt() == 4;
                            if (z) {
                                this.zzgmb = (long) zza2.zzcmn();
                                zzsn = zza2.zzsn("ETag");
                                if (!TextUtils.isEmpty(zzsn) || this.zzohy == null || this.zzohy.equals(zzsn)) {
                                    this.zzohy = zzsn;
                                    try {
                                        zza = zza(zza2);
                                    } catch (Throwable e) {
                                        Log.e("FileDownloadTask", "Exception occurred during file write.  Aborting.", e);
                                        this.zzkuq = e;
                                    }
                                    zza2.zzcmh();
                                    if (zza || this.zzkuq != null || zzclt() != 4) {
                                        z2 = false;
                                    }
                                    if (z2) {
                                        file = new File(this.zzohw.getPath());
                                        if (file.exists()) {
                                            this.zzohz = 0;
                                        } else {
                                            this.zzohz = file.length();
                                        }
                                        if (zzclt() != 8) {
                                            zzk(16, false);
                                            return;
                                        } else if (zzclt() != 32) {
                                            if (!zzk(256, false)) {
                                                zzclt = zzclt();
                                                stringBuilder = new StringBuilder(62);
                                                stringBuilder.append("Unable to change download task to final state from ");
                                                stringBuilder.append(zzclt);
                                                Log.w("FileDownloadTask", stringBuilder.toString());
                                            }
                                            return;
                                        }
                                    } else {
                                        zzk(128, false);
                                        return;
                                    }
                                }
                                Log.w("FileDownloadTask", "The file at the server has changed.  Restarting from the beginning.");
                                this.zzohz = 0;
                                this.zzohy = null;
                                zza2.zzcmh();
                                schedule();
                                return;
                            }
                            zza = z;
                            zza2.zzcmh();
                            if (zza) {
                            }
                            z2 = false;
                            if (z2) {
                                file = new File(this.zzohw.getPath());
                                if (file.exists()) {
                                    this.zzohz = 0;
                                } else {
                                    this.zzohz = file.length();
                                }
                                if (zzclt() != 8) {
                                    zzk(16, false);
                                    return;
                                } else if (zzclt() != 32) {
                                    if (zzk(256, false)) {
                                        zzclt = zzclt();
                                        stringBuilder = new StringBuilder(62);
                                        stringBuilder.append("Unable to change download task to final state from ");
                                        stringBuilder.append(zzclt);
                                        Log.w("FileDownloadTask", stringBuilder.toString());
                                    }
                                    return;
                                }
                            } else {
                                zzk(128, false);
                                return;
                            }
                        }
                    }
                    z = true;
                    if (!z) {
                    }
                    if (z) {
                        this.zzgmb = (long) zza2.zzcmn();
                        zzsn = zza2.zzsn("ETag");
                        if (TextUtils.isEmpty(zzsn)) {
                        }
                        this.zzohy = zzsn;
                        zza = zza(zza2);
                        zza2.zzcmh();
                        if (zza) {
                        }
                        z2 = false;
                        if (z2) {
                            zzk(128, false);
                            return;
                        }
                        file = new File(this.zzohw.getPath());
                        if (file.exists()) {
                            this.zzohz = file.length();
                        } else {
                            this.zzohz = 0;
                        }
                        if (zzclt() != 8) {
                            zzk(16, false);
                            return;
                        } else if (zzclt() != 32) {
                            if (zzk(256, false)) {
                                zzclt = zzclt();
                                stringBuilder = new StringBuilder(62);
                                stringBuilder.append("Unable to change download task to final state from ");
                                stringBuilder.append(zzclt);
                                Log.w("FileDownloadTask", stringBuilder.toString());
                            }
                            return;
                        }
                    }
                    zza = z;
                    zza2.zzcmh();
                    if (zza) {
                    }
                    z2 = false;
                    if (z2) {
                        file = new File(this.zzohw.getPath());
                        if (file.exists()) {
                            this.zzohz = 0;
                        } else {
                            this.zzohz = file.length();
                        }
                        if (zzclt() != 8) {
                            zzk(16, false);
                            return;
                        } else if (zzclt() != 32) {
                            if (zzk(256, false)) {
                                zzclt = zzclt();
                                stringBuilder = new StringBuilder(62);
                                stringBuilder.append("Unable to change download task to final state from ");
                                stringBuilder.append(zzclt);
                                Log.w("FileDownloadTask", stringBuilder.toString());
                            }
                            return;
                        }
                    } else {
                        zzk(128, false);
                        return;
                    }
                } catch (Throwable e2) {
                    Log.e("FileDownloadTask", "Unable to create firebase storage network request.", e2);
                    this.zzkuq = e2;
                    zzk(64, false);
                    return;
                }
            } while (this.zzohx > 0);
            zzk(64, false);
        }
    }

    protected void schedule() {
        zzu.zzu(zzbko());
    }

    @NonNull
    final /* synthetic */ ProvideError zzcln() {
        return new TaskSnapshot(this, StorageException.fromExceptionAndHttpCode(this.zzkuq, this.mResultCode), this.zzohx + this.zzohz);
    }
}
