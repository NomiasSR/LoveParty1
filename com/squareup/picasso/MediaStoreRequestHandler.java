package com.squareup.picasso;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.provider.MediaStore.Images;
import android.provider.MediaStore.Video.Thumbnails;
import com.google.firebase.analytics.FirebaseAnalytics.Param;
import com.squareup.picasso.Picasso.LoadedFrom;
import com.squareup.picasso.RequestHandler.Result;
import java.io.IOException;

class MediaStoreRequestHandler extends ContentStreamRequestHandler {
    private static final String[] CONTENT_ORIENTATION = new String[]{"orientation"};

    enum PicassoKind {
        MICRO(3, 96, 96),
        MINI(1, 512, 384),
        FULL(2, -1, -1);
        
        final int androidKind;
        final int height;
        final int width;

        private PicassoKind(int i, int i2, int i3) {
            this.androidKind = i;
            this.width = i2;
            this.height = i3;
        }
    }

    MediaStoreRequestHandler(Context context) {
        super(context);
    }

    public boolean canHandleRequest(Request request) {
        request = request.uri;
        return (!Param.CONTENT.equals(request.getScheme()) || "media".equals(request.getAuthority()) == null) ? null : true;
    }

    public Result load(Request request, int i) throws IOException {
        Request request2 = request;
        ContentResolver contentResolver = this.context.getContentResolver();
        int exifOrientation = getExifOrientation(contentResolver, request2.uri);
        String type = contentResolver.getType(request2.uri);
        boolean z = type != null && type.startsWith("video/");
        if (request.hasSize()) {
            PicassoKind picassoKind = getPicassoKind(request2.targetWidth, request2.targetHeight);
            if (!z && picassoKind == PicassoKind.FULL) {
                return new Result(null, getInputStream(request), LoadedFrom.DISK, exifOrientation);
            }
            Bitmap thumbnail;
            long parseId = ContentUris.parseId(request2.uri);
            Options createBitmapOptions = RequestHandler.createBitmapOptions(request);
            createBitmapOptions.inJustDecodeBounds = true;
            Options options = createBitmapOptions;
            RequestHandler.calculateInSampleSize(request2.targetWidth, request2.targetHeight, picassoKind.width, picassoKind.height, createBitmapOptions, request2);
            if (z) {
                thumbnail = Thumbnails.getThumbnail(contentResolver, parseId, picassoKind == PicassoKind.FULL ? 1 : picassoKind.androidKind, options);
            } else {
                thumbnail = Images.Thumbnails.getThumbnail(contentResolver, parseId, picassoKind.androidKind, options);
            }
            if (thumbnail != null) {
                return new Result(thumbnail, null, LoadedFrom.DISK, exifOrientation);
            }
        }
        return new Result(null, getInputStream(request), LoadedFrom.DISK, exifOrientation);
    }

    static PicassoKind getPicassoKind(int i, int i2) {
        if (i <= PicassoKind.MICRO.width && i2 <= PicassoKind.MICRO.height) {
            return PicassoKind.MICRO;
        }
        if (i > PicassoKind.MINI.width || i2 > PicassoKind.MINI.height) {
            return PicassoKind.FULL;
        }
        return PicassoKind.MINI;
    }

    static int getExifOrientation(android.content.ContentResolver r8, android.net.Uri r9) {
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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = 0;
        r1 = 0;
        r4 = CONTENT_ORIENTATION;	 Catch:{ RuntimeException -> 0x0030, all -> 0x0028 }
        r5 = 0;	 Catch:{ RuntimeException -> 0x0030, all -> 0x0028 }
        r6 = 0;	 Catch:{ RuntimeException -> 0x0030, all -> 0x0028 }
        r7 = 0;	 Catch:{ RuntimeException -> 0x0030, all -> 0x0028 }
        r2 = r8;	 Catch:{ RuntimeException -> 0x0030, all -> 0x0028 }
        r3 = r9;	 Catch:{ RuntimeException -> 0x0030, all -> 0x0028 }
        r8 = r2.query(r3, r4, r5, r6, r7);	 Catch:{ RuntimeException -> 0x0030, all -> 0x0028 }
        if (r8 == 0) goto L_0x0022;
    L_0x000f:
        r9 = r8.moveToFirst();	 Catch:{ RuntimeException -> 0x0031, all -> 0x0020 }
        if (r9 != 0) goto L_0x0016;	 Catch:{ RuntimeException -> 0x0031, all -> 0x0020 }
    L_0x0015:
        goto L_0x0022;	 Catch:{ RuntimeException -> 0x0031, all -> 0x0020 }
    L_0x0016:
        r9 = r8.getInt(r0);	 Catch:{ RuntimeException -> 0x0031, all -> 0x0020 }
        if (r8 == 0) goto L_0x001f;
    L_0x001c:
        r8.close();
    L_0x001f:
        return r9;
    L_0x0020:
        r9 = move-exception;
        goto L_0x002a;
    L_0x0022:
        if (r8 == 0) goto L_0x0027;
    L_0x0024:
        r8.close();
    L_0x0027:
        return r0;
    L_0x0028:
        r9 = move-exception;
        r8 = r1;
    L_0x002a:
        if (r8 == 0) goto L_0x002f;
    L_0x002c:
        r8.close();
    L_0x002f:
        throw r9;
    L_0x0030:
        r8 = r1;
    L_0x0031:
        if (r8 == 0) goto L_0x0036;
    L_0x0033:
        r8.close();
    L_0x0036:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.picasso.MediaStoreRequestHandler.getExifOrientation(android.content.ContentResolver, android.net.Uri):int");
    }
}
