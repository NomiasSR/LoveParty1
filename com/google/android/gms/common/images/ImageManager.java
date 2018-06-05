package com.google.android.gms.common.images;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.os.ResultReceiver;
import android.os.SystemClock;
import android.support.v4.util.LruCache;
import android.widget.ImageView;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.internal.zzbfl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class ImageManager {
    private static final Object zzfwr = new Object();
    private static HashSet<Uri> zzfws = new HashSet();
    private static ImageManager zzfwt;
    private final Context mContext;
    private final Handler mHandler = new Handler(Looper.getMainLooper());
    private final ExecutorService zzfwu = Executors.newFixedThreadPool(4);
    private final zza zzfwv = null;
    private final zzbfl zzfww = new zzbfl();
    private final Map<zza, ImageReceiver> zzfwx = new HashMap();
    private final Map<Uri, ImageReceiver> zzfwy = new HashMap();
    private final Map<Uri, Long> zzfwz = new HashMap();

    @KeepName
    final class ImageReceiver extends ResultReceiver {
        private final Uri mUri;
        private final ArrayList<zza> zzfxa = new ArrayList();
        private /* synthetic */ ImageManager zzfxb;

        ImageReceiver(ImageManager imageManager, Uri uri) {
            this.zzfxb = imageManager;
            super(new Handler(Looper.getMainLooper()));
            this.mUri = uri;
        }

        public final void onReceiveResult(int i, Bundle bundle) {
            this.zzfxb.zzfwu.execute(new zzb(this.zzfxb, this.mUri, (ParcelFileDescriptor) bundle.getParcelable("com.google.android.gms.extra.fileDescriptor")));
        }

        public final void zzakd() {
            Intent intent = new Intent("com.google.android.gms.common.images.LOAD_IMAGE");
            intent.putExtra("com.google.android.gms.extras.uri", this.mUri);
            intent.putExtra("com.google.android.gms.extras.resultReceiver", this);
            intent.putExtra("com.google.android.gms.extras.priority", 3);
            this.zzfxb.mContext.sendBroadcast(intent);
        }

        public final void zzb(zza com_google_android_gms_common_images_zza) {
            com.google.android.gms.common.internal.zzc.zzge("ImageReceiver.addImageRequest() must be called in the main thread");
            this.zzfxa.add(com_google_android_gms_common_images_zza);
        }

        public final void zzc(zza com_google_android_gms_common_images_zza) {
            com.google.android.gms.common.internal.zzc.zzge("ImageReceiver.removeImageRequest() must be called in the main thread");
            this.zzfxa.remove(com_google_android_gms_common_images_zza);
        }
    }

    public interface OnImageLoadedListener {
        void onImageLoaded(Uri uri, Drawable drawable, boolean z);
    }

    final class zzb implements Runnable {
        private final Uri mUri;
        private /* synthetic */ ImageManager zzfxb;
        private final ParcelFileDescriptor zzfxc;

        public zzb(ImageManager imageManager, Uri uri, ParcelFileDescriptor parcelFileDescriptor) {
            this.zzfxb = imageManager;
            this.mUri = uri;
            this.zzfxc = parcelFileDescriptor;
        }

        public final void run() {
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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r12 = this;
            r0 = "LoadBitmapFromDiskRunnable can't be executed in the main thread";
            r1 = android.os.Looper.getMainLooper();
            r1 = r1.getThread();
            r2 = java.lang.Thread.currentThread();
            if (r1 != r2) goto L_0x0061;
        L_0x0010:
            r1 = "Asserts";
            r2 = java.lang.Thread.currentThread();
            r2 = java.lang.String.valueOf(r2);
            r3 = android.os.Looper.getMainLooper();
            r3 = r3.getThread();
            r3 = java.lang.String.valueOf(r3);
            r4 = 56;
            r5 = java.lang.String.valueOf(r2);
            r5 = r5.length();
            r4 = r4 + r5;
            r5 = java.lang.String.valueOf(r3);
            r5 = r5.length();
            r4 = r4 + r5;
            r5 = new java.lang.StringBuilder;
            r5.<init>(r4);
            r4 = "checkNotMainThread: current thread ";
            r5.append(r4);
            r5.append(r2);
            r2 = " IS the main thread ";
            r5.append(r2);
            r5.append(r3);
            r2 = "!";
            r5.append(r2);
            r2 = r5.toString();
            android.util.Log.e(r1, r2);
            r1 = new java.lang.IllegalStateException;
            r1.<init>(r0);
            throw r1;
        L_0x0061:
            r0 = 0;
            r1 = 0;
            r2 = r12.zzfxc;
            r3 = 1;
            if (r2 == 0) goto L_0x00ab;
        L_0x0068:
            r2 = r12.zzfxc;	 Catch:{ OutOfMemoryError -> 0x0074 }
            r2 = r2.getFileDescriptor();	 Catch:{ OutOfMemoryError -> 0x0074 }
            r2 = android.graphics.BitmapFactory.decodeFileDescriptor(r2);	 Catch:{ OutOfMemoryError -> 0x0074 }
            r1 = r2;
            goto L_0x009d;
        L_0x0074:
            r0 = move-exception;
            r2 = "ImageManager";
            r4 = r12.mUri;
            r4 = java.lang.String.valueOf(r4);
            r5 = 34;
            r6 = java.lang.String.valueOf(r4);
            r6 = r6.length();
            r5 = r5 + r6;
            r6 = new java.lang.StringBuilder;
            r6.<init>(r5);
            r5 = "OOM while loading bitmap for uri: ";
            r6.append(r5);
            r6.append(r4);
            r4 = r6.toString();
            android.util.Log.e(r2, r4, r0);
            r0 = r3;
        L_0x009d:
            r2 = r12.zzfxc;	 Catch:{ IOException -> 0x00a3 }
            r2.close();	 Catch:{ IOException -> 0x00a3 }
            goto L_0x00ab;
        L_0x00a3:
            r2 = move-exception;
            r4 = "ImageManager";
            r5 = "closed failed";
            android.util.Log.e(r4, r5, r2);
        L_0x00ab:
            r10 = r0;
            r9 = r1;
            r0 = new java.util.concurrent.CountDownLatch;
            r0.<init>(r3);
            r1 = r12.zzfxb;
            r1 = r1.mHandler;
            r2 = new com.google.android.gms.common.images.ImageManager$zzd;
            r7 = r12.zzfxb;
            r8 = r12.mUri;
            r6 = r2;
            r11 = r0;
            r6.<init>(r7, r8, r9, r10, r11);
            r1.post(r2);
            r0.await();	 Catch:{ InterruptedException -> 0x00ca }
            return;
        L_0x00ca:
            r0 = "ImageManager";
            r1 = r12.mUri;
            r1 = java.lang.String.valueOf(r1);
            r2 = 32;
            r3 = java.lang.String.valueOf(r1);
            r3 = r3.length();
            r2 = r2 + r3;
            r3 = new java.lang.StringBuilder;
            r3.<init>(r2);
            r2 = "Latch interrupted while posting ";
            r3.append(r2);
            r3.append(r1);
            r1 = r3.toString();
            android.util.Log.w(r0, r1);
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.images.ImageManager.zzb.run():void");
        }
    }

    final class zzc implements Runnable {
        private /* synthetic */ ImageManager zzfxb;
        private final zza zzfxd;

        public zzc(ImageManager imageManager, zza com_google_android_gms_common_images_zza) {
            this.zzfxb = imageManager;
            this.zzfxd = com_google_android_gms_common_images_zza;
        }

        public final void run() {
            com.google.android.gms.common.internal.zzc.zzge("LoadImageRunnable must be executed on the main thread");
            ImageReceiver imageReceiver = (ImageReceiver) this.zzfxb.zzfwx.get(this.zzfxd);
            if (imageReceiver != null) {
                this.zzfxb.zzfwx.remove(this.zzfxd);
                imageReceiver.zzc(this.zzfxd);
            }
            zzb com_google_android_gms_common_images_zzb = this.zzfxd.zzfxf;
            if (com_google_android_gms_common_images_zzb.uri == null) {
                this.zzfxd.zza(this.zzfxb.mContext, this.zzfxb.zzfww, true);
                return;
            }
            Bitmap zza = this.zzfxb.zza(com_google_android_gms_common_images_zzb);
            if (zza != null) {
                this.zzfxd.zza(this.zzfxb.mContext, zza, true);
                return;
            }
            Long l = (Long) this.zzfxb.zzfwz.get(com_google_android_gms_common_images_zzb.uri);
            if (l != null) {
                if (SystemClock.elapsedRealtime() - l.longValue() < 3600000) {
                    this.zzfxd.zza(this.zzfxb.mContext, this.zzfxb.zzfww, true);
                    return;
                }
                this.zzfxb.zzfwz.remove(com_google_android_gms_common_images_zzb.uri);
            }
            this.zzfxd.zza(this.zzfxb.mContext, this.zzfxb.zzfww);
            ImageReceiver imageReceiver2 = (ImageReceiver) this.zzfxb.zzfwy.get(com_google_android_gms_common_images_zzb.uri);
            if (imageReceiver2 == null) {
                imageReceiver2 = new ImageReceiver(this.zzfxb, com_google_android_gms_common_images_zzb.uri);
                this.zzfxb.zzfwy.put(com_google_android_gms_common_images_zzb.uri, imageReceiver2);
            }
            imageReceiver2.zzb(this.zzfxd);
            if (!(this.zzfxd instanceof zzd)) {
                this.zzfxb.zzfwx.put(this.zzfxd, imageReceiver2);
            }
            synchronized (ImageManager.zzfwr) {
                if (!ImageManager.zzfws.contains(com_google_android_gms_common_images_zzb.uri)) {
                    ImageManager.zzfws.add(com_google_android_gms_common_images_zzb.uri);
                    imageReceiver2.zzakd();
                }
            }
        }
    }

    final class zzd implements Runnable {
        private final Bitmap mBitmap;
        private final Uri mUri;
        private final CountDownLatch zzapd;
        private /* synthetic */ ImageManager zzfxb;
        private boolean zzfxe;

        public zzd(ImageManager imageManager, Uri uri, Bitmap bitmap, boolean z, CountDownLatch countDownLatch) {
            this.zzfxb = imageManager;
            this.mUri = uri;
            this.mBitmap = bitmap;
            this.zzfxe = z;
            this.zzapd = countDownLatch;
        }

        public final void run() {
            com.google.android.gms.common.internal.zzc.zzge("OnBitmapLoadedRunnable must be executed in the main thread");
            boolean z = this.mBitmap != null;
            if (this.zzfxb.zzfwv != null) {
                if (this.zzfxe) {
                    this.zzfxb.zzfwv.evictAll();
                    System.gc();
                    this.zzfxe = false;
                    this.zzfxb.mHandler.post(this);
                    return;
                } else if (z) {
                    this.zzfxb.zzfwv.put(new zzb(this.mUri), this.mBitmap);
                }
            }
            ImageReceiver imageReceiver = (ImageReceiver) this.zzfxb.zzfwy.remove(this.mUri);
            if (imageReceiver != null) {
                ArrayList zza = imageReceiver.zzfxa;
                int size = zza.size();
                for (int i = 0; i < size; i++) {
                    zza com_google_android_gms_common_images_zza = (zza) zza.get(i);
                    if (z) {
                        com_google_android_gms_common_images_zza.zza(this.zzfxb.mContext, this.mBitmap, false);
                    } else {
                        this.zzfxb.zzfwz.put(this.mUri, Long.valueOf(SystemClock.elapsedRealtime()));
                        com_google_android_gms_common_images_zza.zza(this.zzfxb.mContext, this.zzfxb.zzfww, false);
                    }
                    if (!(com_google_android_gms_common_images_zza instanceof zzd)) {
                        this.zzfxb.zzfwx.remove(com_google_android_gms_common_images_zza);
                    }
                }
            }
            this.zzapd.countDown();
            synchronized (ImageManager.zzfwr) {
                ImageManager.zzfws.remove(this.mUri);
            }
        }
    }

    static final class zza extends LruCache<zzb, Bitmap> {
        protected final /* synthetic */ void entryRemoved(boolean z, Object obj, Object obj2, Object obj3) {
            super.entryRemoved(z, (zzb) obj, (Bitmap) obj2, (Bitmap) obj3);
        }

        protected final /* synthetic */ int sizeOf(Object obj, Object obj2) {
            Bitmap bitmap = (Bitmap) obj2;
            return bitmap.getHeight() * bitmap.getRowBytes();
        }
    }

    private ImageManager(Context context, boolean z) {
        this.mContext = context.getApplicationContext();
    }

    public static ImageManager create(Context context) {
        if (zzfwt == null) {
            zzfwt = new ImageManager(context, false);
        }
        return zzfwt;
    }

    private final Bitmap zza(zzb com_google_android_gms_common_images_zzb) {
        return this.zzfwv == null ? null : (Bitmap) this.zzfwv.get(com_google_android_gms_common_images_zzb);
    }

    private final void zza(zza com_google_android_gms_common_images_zza) {
        com.google.android.gms.common.internal.zzc.zzge("ImageManager.loadImage() must be called in the main thread");
        new zzc(this, com_google_android_gms_common_images_zza).run();
    }

    public final void loadImage(ImageView imageView, int i) {
        zza(new zzc(imageView, i));
    }

    public final void loadImage(ImageView imageView, Uri uri) {
        zza(new zzc(imageView, uri));
    }

    public final void loadImage(ImageView imageView, Uri uri, int i) {
        zza com_google_android_gms_common_images_zzc = new zzc(imageView, uri);
        com_google_android_gms_common_images_zzc.zzfxh = i;
        zza(com_google_android_gms_common_images_zzc);
    }

    public final void loadImage(OnImageLoadedListener onImageLoadedListener, Uri uri) {
        zza(new zzd(onImageLoadedListener, uri));
    }

    public final void loadImage(OnImageLoadedListener onImageLoadedListener, Uri uri, int i) {
        zza com_google_android_gms_common_images_zzd = new zzd(onImageLoadedListener, uri);
        com_google_android_gms_common_images_zzd.zzfxh = i;
        zza(com_google_android_gms_common_images_zzd);
    }
}
