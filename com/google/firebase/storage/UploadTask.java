package com.google.firebase.storage;

import android.net.Uri;
import android.os.RemoteException;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.helper.ItemTouchHelper.Callback;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.internal.zzexq;
import com.google.android.gms.internal.zzexr;
import com.google.android.gms.internal.zzexw;
import com.google.android.gms.internal.zzeyb;
import com.google.android.gms.internal.zzeyc;
import com.google.firebase.storage.StorageMetadata.Builder;
import com.google.firebase.storage.StorageTask.ProvideError;
import com.google.firebase.storage.StorageTask.SnapshotBase;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONException;
import org.json.JSONObject;

public class UploadTask extends StorageTask<TaskSnapshot> {
    private volatile int mResultCode = 0;
    private final Uri mUri;
    private volatile Exception zzkuq = null;
    private final StorageReference zzoht;
    private zzexr zzohv;
    private volatile StorageMetadata zzojb;
    private final long zzolc;
    private final zzexq zzold;
    private final AtomicLong zzole = new AtomicLong(0);
    private int zzolf = 262144;
    private boolean zzolg;
    private volatile Uri zzolh = null;
    private volatile Exception zzoli = null;
    private volatile String zzolj;

    public class TaskSnapshot extends SnapshotBase {
        private final StorageMetadata zzojb;
        private final Uri zzolh;
        private /* synthetic */ UploadTask zzoll;
        private final long zzolm;

        TaskSnapshot(@Nullable UploadTask uploadTask, Exception exception, long j, Uri uri, StorageMetadata storageMetadata) {
            this.zzoll = uploadTask;
            super(uploadTask, exception);
            this.zzolm = j;
            this.zzolh = uri;
            this.zzojb = storageMetadata;
        }

        public long getBytesTransferred() {
            return this.zzolm;
        }

        @Nullable
        public Uri getDownloadUrl() {
            StorageMetadata metadata = getMetadata();
            return metadata != null ? metadata.getDownloadUrl() : null;
        }

        @Nullable
        public StorageMetadata getMetadata() {
            return this.zzojb;
        }

        public long getTotalByteCount() {
            return this.zzoll.getTotalByteCount();
        }

        @Nullable
        public Uri getUploadSessionUri() {
            return this.zzolh;
        }
    }

    UploadTask(com.google.firebase.storage.StorageReference r10, com.google.firebase.storage.StorageMetadata r11, android.net.Uri r12, android.net.Uri r13) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r9 = this;
        r9.<init>();
        r0 = new java.util.concurrent.atomic.AtomicLong;
        r1 = 0;
        r0.<init>(r1);
        r9.zzole = r0;
        r0 = 262144; // 0x40000 float:3.67342E-40 double:1.295163E-318;
        r9.zzolf = r0;
        r1 = 0;
        r9.zzolh = r1;
        r9.zzkuq = r1;
        r9.zzoli = r1;
        r2 = 0;
        r9.mResultCode = r2;
        com.google.android.gms.common.internal.zzbq.checkNotNull(r10);
        com.google.android.gms.common.internal.zzbq.checkNotNull(r12);
        r9.zzoht = r10;
        r9.zzojb = r11;
        r9.mUri = r12;
        r10 = new com.google.android.gms.internal.zzexr;
        r11 = r9.zzoht;
        r11 = r11.getStorage();
        r11 = r11.getApp();
        r12 = r9.zzoht;
        r12 = r12.getStorage();
        r2 = r12.getMaxUploadRetryTimeMillis();
        r10.<init>(r11, r2);
        r9.zzohv = r10;
        r10 = -1;
        r12 = r9.zzoht;	 Catch:{ FileNotFoundException -> 0x00be }
        r12 = r12.getStorage();	 Catch:{ FileNotFoundException -> 0x00be }
        r12 = r12.getApp();	 Catch:{ FileNotFoundException -> 0x00be }
        r12 = r12.getApplicationContext();	 Catch:{ FileNotFoundException -> 0x00be }
        r12 = r12.getContentResolver();	 Catch:{ FileNotFoundException -> 0x00be }
        r2 = r9.mUri;	 Catch:{ NullPointerException -> 0x0090, IOException -> 0x006b }
        r3 = "r";	 Catch:{ NullPointerException -> 0x0090, IOException -> 0x006b }
        r2 = r12.openFileDescriptor(r2, r3);	 Catch:{ NullPointerException -> 0x0090, IOException -> 0x006b }
        if (r2 == 0) goto L_0x0099;	 Catch:{ NullPointerException -> 0x0090, IOException -> 0x006b }
    L_0x005f:
        r3 = r2.getStatSize();	 Catch:{ NullPointerException -> 0x0090, IOException -> 0x006b }
        r2.close();	 Catch:{ NullPointerException -> 0x0069, IOException -> 0x0067 }
        goto L_0x009a;
    L_0x0067:
        r2 = move-exception;
        goto L_0x006d;
    L_0x0069:
        r2 = move-exception;
        goto L_0x0092;
    L_0x006b:
        r2 = move-exception;
        r3 = r10;
    L_0x006d:
        r5 = "UploadTask";	 Catch:{ FileNotFoundException -> 0x00bc }
        r6 = "could not retrieve file size for upload ";	 Catch:{ FileNotFoundException -> 0x00bc }
        r7 = r9.mUri;	 Catch:{ FileNotFoundException -> 0x00bc }
        r7 = r7.toString();	 Catch:{ FileNotFoundException -> 0x00bc }
        r7 = java.lang.String.valueOf(r7);	 Catch:{ FileNotFoundException -> 0x00bc }
        r8 = r7.length();	 Catch:{ FileNotFoundException -> 0x00bc }
        if (r8 == 0) goto L_0x0086;	 Catch:{ FileNotFoundException -> 0x00bc }
    L_0x0081:
        r6 = r6.concat(r7);	 Catch:{ FileNotFoundException -> 0x00bc }
        goto L_0x008c;	 Catch:{ FileNotFoundException -> 0x00bc }
    L_0x0086:
        r7 = new java.lang.String;	 Catch:{ FileNotFoundException -> 0x00bc }
        r7.<init>(r6);	 Catch:{ FileNotFoundException -> 0x00bc }
        r6 = r7;	 Catch:{ FileNotFoundException -> 0x00bc }
    L_0x008c:
        android.util.Log.w(r5, r6, r2);	 Catch:{ FileNotFoundException -> 0x00bc }
        goto L_0x009a;	 Catch:{ FileNotFoundException -> 0x00bc }
    L_0x0090:
        r2 = move-exception;	 Catch:{ FileNotFoundException -> 0x00bc }
        r3 = r10;	 Catch:{ FileNotFoundException -> 0x00bc }
    L_0x0092:
        r5 = "UploadTask";	 Catch:{ FileNotFoundException -> 0x00bc }
        r6 = "NullPointerException during file size calculation.";	 Catch:{ FileNotFoundException -> 0x00bc }
        android.util.Log.w(r5, r6, r2);	 Catch:{ FileNotFoundException -> 0x00bc }
    L_0x0099:
        r3 = r10;	 Catch:{ FileNotFoundException -> 0x00bc }
    L_0x009a:
        r2 = r9.mUri;	 Catch:{ FileNotFoundException -> 0x00bc }
        r12 = r12.openInputStream(r2);	 Catch:{ FileNotFoundException -> 0x00bc }
        if (r12 == 0) goto L_0x00e6;
    L_0x00a2:
        r10 = (r3 > r10 ? 1 : (r3 == r10 ? 0 : -1));
        if (r10 != 0) goto L_0x00b0;
    L_0x00a6:
        r10 = r12.available();	 Catch:{ IOException -> 0x00b0, FileNotFoundException -> 0x00ae }
        if (r10 < 0) goto L_0x00b0;
    L_0x00ac:
        r3 = (long) r10;
        goto L_0x00b0;
    L_0x00ae:
        r10 = move-exception;
        goto L_0x00c2;
    L_0x00b0:
        r10 = r3;
        r1 = new java.io.BufferedInputStream;	 Catch:{ FileNotFoundException -> 0x00b8 }
        r1.<init>(r12);	 Catch:{ FileNotFoundException -> 0x00b8 }
        r12 = r1;
        goto L_0x00e7;
    L_0x00b8:
        r1 = move-exception;
        r3 = r10;
        r10 = r1;
        goto L_0x00c2;
    L_0x00bc:
        r10 = move-exception;
        goto L_0x00c1;
    L_0x00be:
        r12 = move-exception;
        r3 = r10;
        r10 = r12;
    L_0x00c1:
        r12 = r1;
    L_0x00c2:
        r11 = "UploadTask";
        r1 = "could not locate file for uploading:";
        r2 = r9.mUri;
        r2 = r2.toString();
        r2 = java.lang.String.valueOf(r2);
        r5 = r2.length();
        if (r5 == 0) goto L_0x00db;
    L_0x00d6:
        r1 = r1.concat(r2);
        goto L_0x00e1;
    L_0x00db:
        r2 = new java.lang.String;
        r2.<init>(r1);
        r1 = r2;
    L_0x00e1:
        android.util.Log.e(r11, r1);
        r9.zzkuq = r10;
    L_0x00e6:
        r10 = r3;
    L_0x00e7:
        r9.zzolc = r10;
        r10 = new com.google.android.gms.internal.zzexq;
        r10.<init>(r12, r0);
        r9.zzold = r10;
        r10 = 1;
        r9.zzolg = r10;
        r9.zzolh = r13;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.storage.UploadTask.<init>(com.google.firebase.storage.StorageReference, com.google.firebase.storage.StorageMetadata, android.net.Uri, android.net.Uri):void");
    }

    UploadTask(StorageReference storageReference, StorageMetadata storageMetadata, InputStream inputStream) {
        zzbq.checkNotNull(storageReference);
        zzbq.checkNotNull(inputStream);
        this.zzolc = -1;
        this.zzoht = storageReference;
        this.zzojb = storageMetadata;
        this.zzold = new zzexq(inputStream, 262144);
        this.zzolg = false;
        this.mUri = null;
        this.zzohv = new zzexr(this.zzoht.getStorage().getApp(), this.zzoht.getStorage().getMaxUploadRetryTimeMillis());
    }

    UploadTask(StorageReference storageReference, StorageMetadata storageMetadata, byte[] bArr) {
        zzbq.checkNotNull(storageReference);
        zzbq.checkNotNull(bArr);
        this.zzolc = (long) bArr.length;
        this.zzoht = storageReference;
        this.zzojb = storageMetadata;
        this.mUri = null;
        this.zzold = new zzexq(new ByteArrayInputStream(bArr), 262144);
        this.zzolg = true;
        this.zzohv = new zzexr(this.zzoht.getStorage().getApp(), this.zzoht.getStorage().getMaxUploadRetryTimeMillis());
    }

    private final boolean zzb(zzeyc com_google_android_gms_internal_zzeyc) {
        com_google_android_gms_internal_zzeyc.zze(zzexw.zzh(this.zzoht.getStorage().getApp()), this.zzoht.getStorage().getApp().getApplicationContext());
        return zzd(com_google_android_gms_internal_zzeyc);
    }

    private final boolean zzc(zzeyc com_google_android_gms_internal_zzeyc) {
        this.zzohv.zza(com_google_android_gms_internal_zzeyc, true);
        return zzd(com_google_android_gms_internal_zzeyc);
    }

    private final boolean zzcmc() {
        if (zzclt() == 128) {
            return false;
        }
        if (Thread.interrupted()) {
            this.zzkuq = new InterruptedException();
            zzk(64, false);
            return false;
        } else if (zzclt() == 32) {
            zzk(256, false);
            return false;
        } else if (zzclt() == 8) {
            zzk(16, false);
            return false;
        } else if (!zzcmd()) {
            return false;
        } else {
            if (this.zzolh == null) {
                if (this.zzkuq == null) {
                    this.zzkuq = new IllegalStateException("Unable to obtain an upload URL.");
                }
                zzk(64, false);
                return false;
            } else if (this.zzkuq != null) {
                zzk(64, false);
                return false;
            } else {
                boolean z;
                if (this.zzoli == null && this.mResultCode >= Callback.DEFAULT_DRAG_ANIMATION_DURATION) {
                    if (this.mResultCode < 300) {
                        z = false;
                        if (z || zzcw(true)) {
                            return true;
                        }
                        if (zzcmd()) {
                            zzk(64, false);
                        }
                        return false;
                    }
                }
                z = true;
                if (z) {
                }
                return true;
            }
        }
    }

    private final boolean zzcmd() {
        if (!"final".equals(this.zzolj)) {
            return true;
        }
        if (this.zzkuq == null) {
            this.zzkuq = new IOException("The server has terminated the upload session", this.zzoli);
        }
        zzk(64, false);
        return false;
    }

    private final boolean zzcw(boolean z) {
        Exception iOException;
        String str;
        String str2;
        try {
            zzeyc zzb = this.zzoht.zzclq().zzb(this.zzoht.zzclr(), this.zzolh.toString());
            if ("final".equals(this.zzolj)) {
                return false;
            }
            if (z) {
                if (!zzc(zzb)) {
                    return false;
                }
            } else if (!zzb(zzb)) {
                return false;
            }
            if ("final".equals(zzb.zzsn("X-Goog-Upload-Status"))) {
                iOException = new IOException("The server has terminated the upload session");
            } else {
                Object zzsn = zzb.zzsn("X-Goog-Upload-Size-Received");
                long parseLong = !TextUtils.isEmpty(zzsn) ? Long.parseLong(zzsn) : 0;
                long j = this.zzole.get();
                int i = (j > parseLong ? 1 : (j == parseLong ? 0 : -1));
                if (i > 0) {
                    iOException = new IOException("Unexpected error. The server lost a chunk update.");
                } else {
                    if (i < 0) {
                        try {
                            long j2 = parseLong - j;
                            if (((long) this.zzold.zzik((int) j2)) != j2) {
                                this.zzkuq = new IOException("Unexpected end of stream encountered.");
                                return false;
                            } else if (!this.zzole.compareAndSet(j, parseLong)) {
                                Log.e("UploadTask", "Somehow, the uploaded bytes changed during an uploaded.  This should nothappen");
                                this.zzkuq = new IllegalStateException("uploaded bytes changed unexpectedly.");
                                return false;
                            }
                        } catch (IOException e) {
                            iOException = e;
                            str = "UploadTask";
                            str2 = "Unable to recover position in Stream during resumable upload";
                            Log.e(str, str2, iOException);
                            this.zzkuq = iOException;
                            return false;
                        }
                    }
                    return true;
                }
            }
            this.zzkuq = iOException;
            return false;
        } catch (RemoteException e2) {
            iOException = e2;
            str = "UploadTask";
            str2 = "Unable to recover status during resumable upload";
            Log.e(str, str2, iOException);
            this.zzkuq = iOException;
            return false;
        }
    }

    private final boolean zzd(zzeyc com_google_android_gms_internal_zzeyc) {
        boolean z;
        int resultCode = com_google_android_gms_internal_zzeyc.getResultCode();
        if (zzexr.zzin(resultCode)) {
            resultCode = -2;
        }
        this.mResultCode = resultCode;
        this.zzoli = com_google_android_gms_internal_zzeyc.getException();
        this.zzolj = com_google_android_gms_internal_zzeyc.zzsn("X-Goog-Upload-Status");
        int i = this.mResultCode;
        if (i != 308) {
            if (i < Callback.DEFAULT_DRAG_ANIMATION_DURATION || i >= 300) {
                z = false;
                return z && this.zzoli == null;
            }
        }
        z = true;
        if (!z) {
        }
    }

    final StorageReference getStorage() {
        return this.zzoht;
    }

    final long getTotalByteCount() {
        return this.zzolc;
    }

    protected void onCanceled() {
        zzeyc zza;
        this.zzohv.cancel();
        if (this.zzolh != null) {
            try {
                zza = this.zzoht.zzclq().zza(this.zzoht.zzclr(), this.zzolh.toString());
            } catch (Throwable e) {
                Log.e("UploadTask", "Unable to create chunk upload request", e);
            }
            if (zza != null) {
                zzu.zzs(new zzad(this, zza));
            }
            this.zzkuq = StorageException.fromErrorStatus(Status.zzfnm);
            super.onCanceled();
        }
        zza = null;
        if (zza != null) {
            zzu.zzs(new zzad(this, zza));
        }
        this.zzkuq = StorageException.fromErrorStatus(Status.zzfnm);
        super.onCanceled();
    }

    protected void resetState() {
        this.zzkuq = null;
        this.zzoli = null;
        this.mResultCode = 0;
        this.zzolj = null;
    }

    final void run() {
        Exception e;
        String valueOf;
        this.zzohv.reset();
        if (zzk(4, false)) {
            if (this.zzoht.getParent() == null) {
                this.zzkuq = new IllegalArgumentException("Cannot upload to getRoot. You should upload to a storage location such as .getReference('image.png').putFile...");
            }
            if (this.zzkuq == null) {
                String contentType;
                if (this.zzolh == null) {
                    JSONObject jSONObject = null;
                    contentType = this.zzojb != null ? this.zzojb.getContentType() : null;
                    if (this.mUri != null && TextUtils.isEmpty(contentType)) {
                        contentType = this.zzoht.getStorage().getApp().getApplicationContext().getContentResolver().getType(this.mUri);
                    }
                    if (TextUtils.isEmpty(contentType)) {
                        contentType = "application/octet-stream";
                    }
                    try {
                        zzeyb zzclq = this.zzoht.zzclq();
                        Uri zzclr = this.zzoht.zzclr();
                        if (this.zzojb != null) {
                            jSONObject = this.zzojb.zzclo();
                        }
                        zzeyc zza = zzclq.zza(zzclr, jSONObject, contentType);
                        if (zzc(zza)) {
                            Object zzsn = zza.zzsn("X-Goog-Upload-URL");
                            if (!TextUtils.isEmpty(zzsn)) {
                                this.zzolh = Uri.parse(zzsn);
                            }
                        }
                    } catch (Throwable e2) {
                        Log.e("UploadTask", "Unable to create a network request from metadata", e2);
                        this.zzkuq = e2;
                    }
                } else {
                    zzcw(false);
                }
                boolean zzcmc = zzcmc();
                while (zzcmc) {
                    try {
                        this.zzold.zzil(this.zzolf);
                        int min = Math.min(this.zzolf, this.zzold.available());
                        try {
                            zzeyc zza2 = this.zzoht.zzclq().zza(this.zzoht.zzclr(), this.zzolh.toString(), this.zzold.zzcmg(), this.zzole.get(), min, this.zzold.isFinished());
                            int i;
                            StringBuilder stringBuilder;
                            if (zzb(zza2)) {
                                this.zzole.getAndAdd((long) min);
                                if (this.zzold.isFinished()) {
                                    try {
                                        this.zzojb = new Builder(zza2.zzcmp(), this.zzoht).build();
                                        zzk(4, false);
                                        zzk(128, false);
                                    } catch (JSONException e3) {
                                        e = e3;
                                        String str = "UploadTask";
                                        String str2 = "Unable to parse resulting metadata from upload:";
                                        valueOf = String.valueOf(zza2.zzcmk());
                                        Log.e(str, valueOf.length() == 0 ? new String(str2) : str2.concat(valueOf), e);
                                        this.zzkuq = e;
                                        zzcmc = zzcmc();
                                        if (!zzcmc) {
                                            zzk(4, false);
                                        }
                                    }
                                } else {
                                    this.zzold.zzik(min);
                                    if (this.zzolf < 33554432) {
                                        this.zzolf <<= 1;
                                        contentType = "UploadTask";
                                        i = this.zzolf;
                                        stringBuilder = new StringBuilder(36);
                                        stringBuilder.append("Increasing chunk size to ");
                                        stringBuilder.append(i);
                                        valueOf = stringBuilder.toString();
                                    }
                                }
                                zzcmc = zzcmc();
                                if (!zzcmc) {
                                    zzk(4, false);
                                }
                            } else {
                                this.zzolf = 262144;
                                contentType = "UploadTask";
                                i = this.zzolf;
                                stringBuilder = new StringBuilder(35);
                                stringBuilder.append("Resetting chunk size to ");
                                stringBuilder.append(i);
                                valueOf = stringBuilder.toString();
                            }
                            Log.d(contentType, valueOf);
                        } catch (RemoteException e4) {
                            e = e4;
                            Log.e("UploadTask", "Unable to create chunk upload request", e);
                            this.zzkuq = e;
                            zzcmc = zzcmc();
                            if (!zzcmc) {
                                zzk(4, false);
                            }
                        }
                    } catch (Throwable e22) {
                        Log.e("UploadTask", "Unable to read bytes for uploading", e22);
                        this.zzkuq = e22;
                    }
                    zzcmc = zzcmc();
                    if (!zzcmc) {
                        zzk(4, false);
                    }
                }
                if (this.zzolg && zzclt() != 16) {
                    try {
                        this.zzold.close();
                        return;
                    } catch (Throwable e5) {
                        Log.e("UploadTask", "Unable to close stream.", e5);
                    }
                }
                return;
            }
            return;
        }
        Log.d("UploadTask", "The upload cannot continue as it is not in a valid state.");
    }

    protected void schedule() {
        zzu.zzt(zzbko());
    }

    @NonNull
    final /* synthetic */ ProvideError zzcln() {
        return new TaskSnapshot(this, StorageException.fromExceptionAndHttpCode(this.zzkuq != null ? this.zzkuq : this.zzoli, this.mResultCode), this.zzole.get(), this.zzolh, this.zzojb);
    }
}
