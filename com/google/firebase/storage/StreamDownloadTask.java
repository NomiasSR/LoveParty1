package com.google.firebase.storage;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.media.session.PlaybackStateCompat;
import android.support.v7.widget.helper.ItemTouchHelper.Callback;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.internal.zzexr;
import com.google.android.gms.internal.zzeyc;
import com.google.firebase.storage.StorageTask.ProvideError;
import com.google.firebase.storage.StorageTask.SnapshotBase;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Callable;

public class StreamDownloadTask extends StorageTask<TaskSnapshot> {
    private volatile int mResultCode = 0;
    private long zzgmb = -1;
    private volatile Exception zzkuq = null;
    private InputStream zzljj;
    private StorageReference zzoht;
    private zzexr zzohv;
    private long zzohx;
    private String zzohy;
    private StreamProcessor zzokh;
    private long zzoki;
    private zzeyc zzokj;

    public interface StreamProcessor {
        void doInBackground(TaskSnapshot taskSnapshot, InputStream inputStream) throws IOException;
    }

    static class zza extends InputStream {
        @Nullable
        private StreamDownloadTask zzokl;
        @Nullable
        private InputStream zzokm;
        private Callable<InputStream> zzokn;
        private IOException zzoko;
        private int zzokp;
        private int zzokq;
        private boolean zzokr;

        zza(@NonNull Callable<InputStream> callable, @Nullable StreamDownloadTask streamDownloadTask) {
            this.zzokl = streamDownloadTask;
            this.zzokn = callable;
        }

        private final void zzclz() throws IOException {
            if (this.zzokl != null && this.zzokl.zzclt() == 32) {
                throw new zza();
            }
        }

        private final boolean zzcma() throws java.io.IOException {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r5 = this;
            r5.zzclz();
            r0 = r5.zzoko;
            if (r0 == 0) goto L_0x0046;
        L_0x0007:
            r0 = r5.zzokm;	 Catch:{ IOException -> 0x0010 }
            if (r0 == 0) goto L_0x0010;	 Catch:{ IOException -> 0x0010 }
        L_0x000b:
            r0 = r5.zzokm;	 Catch:{ IOException -> 0x0010 }
            r0.close();	 Catch:{ IOException -> 0x0010 }
        L_0x0010:
            r0 = 0;
            r5.zzokm = r0;
            r1 = r5.zzokq;
            r2 = r5.zzokp;
            if (r1 != r2) goto L_0x0024;
        L_0x0019:
            r0 = "StreamDownloadTask";
            r1 = "Encountered exception during stream operation. Aborting.";
            r2 = r5.zzoko;
            android.util.Log.i(r0, r1, r2);
            r0 = 0;
            return r0;
        L_0x0024:
            r1 = "StreamDownloadTask";
            r2 = r5.zzokp;
            r3 = 70;
            r4 = new java.lang.StringBuilder;
            r4.<init>(r3);
            r3 = "Encountered exception during stream operation. Retrying at ";
            r4.append(r3);
            r4.append(r2);
            r2 = r4.toString();
            r3 = r5.zzoko;
            android.util.Log.i(r1, r2, r3);
            r1 = r5.zzokp;
            r5.zzokq = r1;
            r5.zzoko = r0;
        L_0x0046:
            r0 = r5.zzokr;
            if (r0 == 0) goto L_0x0052;
        L_0x004a:
            r0 = new java.io.IOException;
            r1 = "Can't perform operation on closed stream";
            r0.<init>(r1);
            throw r0;
        L_0x0052:
            r0 = r5.zzokm;
            if (r0 != 0) goto L_0x0071;
        L_0x0056:
            r0 = r5.zzokn;	 Catch:{ Exception -> 0x0061 }
            r0 = r0.call();	 Catch:{ Exception -> 0x0061 }
            r0 = (java.io.InputStream) r0;	 Catch:{ Exception -> 0x0061 }
            r5.zzokm = r0;	 Catch:{ Exception -> 0x0061 }
            goto L_0x0071;
        L_0x0061:
            r0 = move-exception;
            r1 = r0 instanceof java.io.IOException;
            if (r1 == 0) goto L_0x0069;
        L_0x0066:
            r0 = (java.io.IOException) r0;
            throw r0;
        L_0x0069:
            r1 = new java.io.IOException;
            r2 = "Unable to open stream";
            r1.<init>(r2, r0);
            throw r1;
        L_0x0071:
            r0 = 1;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.storage.StreamDownloadTask.zza.zzcma():boolean");
        }

        private final void zzcp(long j) {
            if (this.zzokl != null) {
                this.zzokl.zzcp(j);
            }
            this.zzokp = (int) (((long) this.zzokp) + j);
        }

        public final int available() throws IOException {
            while (zzcma()) {
                try {
                    return this.zzokm.available();
                } catch (IOException e) {
                    this.zzoko = e;
                }
            }
            throw this.zzoko;
        }

        public final void close() throws IOException {
            if (this.zzokm != null) {
                this.zzokm.close();
            }
            this.zzokr = true;
            if (!(this.zzokl == null || this.zzokl.zzokj == null)) {
                this.zzokl.zzokj.zzcmh();
                this.zzokl.zzokj = null;
            }
            zzclz();
        }

        public final void mark(int i) {
        }

        public final boolean markSupported() {
            return false;
        }

        public final int read() throws IOException {
            while (zzcma()) {
                try {
                    int read = this.zzokm.read();
                    if (read != -1) {
                        zzcp(1);
                    }
                    return read;
                } catch (IOException e) {
                    this.zzoko = e;
                }
            }
            throw this.zzoko;
        }

        public final int read(@NonNull byte[] bArr, int i, int i2) throws IOException {
            int i3 = 0;
            while (zzcma()) {
                int read;
                while (((long) i2) > PlaybackStateCompat.ACTION_SET_REPEAT_MODE) {
                    try {
                        read = this.zzokm.read(bArr, i, 262144);
                        if (read == -1) {
                            return i3 == 0 ? -1 : i3;
                        } else {
                            i3 += read;
                            i += read;
                            i2 -= read;
                            zzcp((long) read);
                            zzclz();
                        }
                    } catch (IOException e) {
                        this.zzoko = e;
                    }
                }
                if (i2 > 0) {
                    read = this.zzokm.read(bArr, i, i2);
                    if (read == -1) {
                        return i3 == 0 ? -1 : i3;
                    } else {
                        i += read;
                        i3 += read;
                        i2 -= read;
                        zzcp((long) read);
                    }
                }
                if (i2 == 0) {
                    return i3;
                }
            }
            throw this.zzoko;
        }

        public final long skip(long j) throws IOException {
            int i = 0;
            while (zzcma()) {
                while (j > PlaybackStateCompat.ACTION_SET_REPEAT_MODE) {
                    long skip;
                    try {
                        skip = this.zzokm.skip(PlaybackStateCompat.ACTION_SET_REPEAT_MODE);
                        if (skip < 0) {
                            return i == 0 ? -1 : (long) i;
                        } else {
                            i = (int) (((long) i) + skip);
                            j -= skip;
                            zzcp(skip);
                            zzclz();
                        }
                    } catch (IOException e) {
                        this.zzoko = e;
                    }
                }
                if (j > 0) {
                    skip = this.zzokm.skip(j);
                    if (skip < 0) {
                        return i == 0 ? -1 : (long) i;
                    } else {
                        i = (int) (((long) i) + skip);
                        j -= skip;
                        zzcp(skip);
                    }
                }
                if (j == 0) {
                    return (long) i;
                }
            }
            throw this.zzoko;
        }
    }

    public class TaskSnapshot extends SnapshotBase {
        private final long zzohx;
        private /* synthetic */ StreamDownloadTask zzokk;

        TaskSnapshot(@Nullable StreamDownloadTask streamDownloadTask, Exception exception, long j) {
            this.zzokk = streamDownloadTask;
            super(streamDownloadTask, exception);
            this.zzohx = j;
        }

        public long getBytesTransferred() {
            return this.zzohx;
        }

        public InputStream getStream() {
            return this.zzokk.zzljj;
        }

        public long getTotalByteCount() {
            return this.zzokk.getTotalBytes();
        }
    }

    StreamDownloadTask(@NonNull StorageReference storageReference) {
        this.zzoht = storageReference;
        this.zzohv = new zzexr(this.zzoht.getStorage().getApp(), this.zzoht.getStorage().getMaxDownloadRetryTimeMillis());
    }

    private final InputStream zzcly() throws Exception {
        this.zzohv.reset();
        if (this.zzokj != null) {
            this.zzokj.zzcmh();
        }
        try {
            boolean z;
            Object zzsn;
            this.zzokj = this.zzoht.zzclq().zza(this.zzoht.zzclr(), this.zzohx);
            boolean z2 = false;
            this.zzohv.zza(this.zzokj, false);
            this.mResultCode = this.zzokj.getResultCode();
            this.zzkuq = this.zzokj.getException() != null ? this.zzokj.getException() : this.zzkuq;
            int i = this.mResultCode;
            if (i != 308) {
                if (i < Callback.DEFAULT_DRAG_ANIMATION_DURATION || i >= 300) {
                    z = false;
                    if (z && this.zzkuq == null && zzclt() == 4) {
                        z2 = true;
                    }
                    if (z2) {
                        throw new IOException("Could not open resulting stream.");
                    }
                    zzsn = this.zzokj.zzsn("ETag");
                    if (!TextUtils.isEmpty(zzsn) || this.zzohy == null || this.zzohy.equals(zzsn)) {
                        this.zzohy = zzsn;
                        if (this.zzgmb == -1) {
                            this.zzgmb = (long) this.zzokj.zzcmn();
                        }
                        return this.zzokj.getStream();
                    }
                    this.mResultCode = 409;
                    throw new IOException("The ETag on the server changed.");
                }
            }
            z = true;
            z2 = true;
            if (z2) {
                throw new IOException("Could not open resulting stream.");
            }
            zzsn = this.zzokj.zzsn("ETag");
            if (TextUtils.isEmpty(zzsn)) {
            }
            this.zzohy = zzsn;
            if (this.zzgmb == -1) {
                this.zzgmb = (long) this.zzokj.zzcmn();
            }
            return this.zzokj.getStream();
        } catch (Throwable e) {
            Log.e("StreamDownloadTask", "Unable to create firebase storage network request.", e);
            throw e;
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

    protected void onProgress() {
        this.zzoki = this.zzohx;
    }

    public boolean pause() {
        throw new UnsupportedOperationException("this operation is not supported on StreamDownloadTask.");
    }

    public boolean resume() {
        throw new UnsupportedOperationException("this operation is not supported on StreamDownloadTask.");
    }

    final void run() {
        int i = 64;
        if (this.zzkuq != null) {
            zzk(64, false);
        } else if (zzk(4, false)) {
            InputStream com_google_firebase_storage_StreamDownloadTask_zza = new zza(new zzw(this), this);
            this.zzljj = new BufferedInputStream(com_google_firebase_storage_StreamDownloadTask_zza);
            try {
                com_google_firebase_storage_StreamDownloadTask_zza.zzcma();
                if (this.zzokh != null) {
                    try {
                        this.zzokh.doInBackground((TaskSnapshot) zzclu(), this.zzljj);
                    } catch (Throwable e) {
                        Log.w("StreamDownloadTask", "Exception occurred calling doInBackground.", e);
                        this.zzkuq = e;
                    }
                }
            } catch (Throwable e2) {
                Log.d("StreamDownloadTask", "Initial opening of Stream failed", e2);
                this.zzkuq = e2;
            }
            if (this.zzljj == null) {
                this.zzokj.zzcmh();
                this.zzokj = null;
            }
            boolean z = this.zzkuq == null && zzclt() == 4;
            if (z) {
                zzk(4, false);
                zzk(128, false);
                return;
            }
            if (zzclt() == 32) {
                i = 256;
            }
            if (!zzk(i, false)) {
                i = zzclt();
                StringBuilder stringBuilder = new StringBuilder(62);
                stringBuilder.append("Unable to change download task to final state from ");
                stringBuilder.append(i);
                Log.w("StreamDownloadTask", stringBuilder.toString());
            }
        }
    }

    protected void schedule() {
        zzu.zzu(zzbko());
    }

    final StreamDownloadTask zza(@NonNull StreamProcessor streamProcessor) {
        zzbq.checkNotNull(streamProcessor);
        zzbq.checkState(this.zzokh == null);
        this.zzokh = streamProcessor;
        return this;
    }

    @NonNull
    final /* synthetic */ ProvideError zzcln() {
        return new TaskSnapshot(this, StorageException.fromExceptionAndHttpCode(this.zzkuq, this.mResultCode), this.zzoki);
    }

    final void zzcp(long j) {
        this.zzohx += j;
        if (this.zzoki + PlaybackStateCompat.ACTION_SET_REPEAT_MODE <= this.zzohx) {
            if (zzclt() == 4) {
                zzk(4, false);
                return;
            }
            this.zzoki = this.zzohx;
        }
    }
}
