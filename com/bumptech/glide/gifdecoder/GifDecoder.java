package com.bumptech.glide.gifdecoder;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Build.VERSION;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

public class GifDecoder {
    private static final Config BITMAP_CONFIG = Config.ARGB_8888;
    private static final int DISPOSAL_BACKGROUND = 2;
    private static final int DISPOSAL_NONE = 1;
    private static final int DISPOSAL_PREVIOUS = 3;
    private static final int DISPOSAL_UNSPECIFIED = 0;
    private static final int INITIAL_FRAME_POINTER = -1;
    private static final int MAX_STACK_SIZE = 4096;
    private static final int NULL_CODE = -1;
    public static final int STATUS_FORMAT_ERROR = 1;
    public static final int STATUS_OK = 0;
    public static final int STATUS_OPEN_ERROR = 2;
    public static final int STATUS_PARTIAL_DECODE = 3;
    private static final String TAG = "GifDecoder";
    private int[] act;
    private BitmapProvider bitmapProvider;
    private final byte[] block = new byte[256];
    private byte[] data;
    private int framePointer;
    private GifHeader header;
    private byte[] mainPixels;
    private int[] mainScratch;
    private GifHeaderParser parser;
    private byte[] pixelStack;
    private short[] prefix;
    private Bitmap previousImage;
    private ByteBuffer rawData;
    private boolean savePrevious;
    private int status;
    private byte[] suffix;

    public interface BitmapProvider {
        Bitmap obtain(int i, int i2, Config config);

        void release(Bitmap bitmap);
    }

    public GifDecoder(BitmapProvider bitmapProvider) {
        this.bitmapProvider = bitmapProvider;
        this.header = new GifHeader();
    }

    public int getWidth() {
        return this.header.width;
    }

    public int getHeight() {
        return this.header.height;
    }

    public byte[] getData() {
        return this.data;
    }

    public int getStatus() {
        return this.status;
    }

    public void advance() {
        this.framePointer = (this.framePointer + 1) % this.header.frameCount;
    }

    public int getDelay(int i) {
        return (i < 0 || i >= this.header.frameCount) ? -1 : ((GifFrame) this.header.frames.get(i)).delay;
    }

    public int getNextDelay() {
        if (this.header.frameCount > 0) {
            if (this.framePointer >= 0) {
                return getDelay(this.framePointer);
            }
        }
        return -1;
    }

    public int getFrameCount() {
        return this.header.frameCount;
    }

    public int getCurrentFrameIndex() {
        return this.framePointer;
    }

    public void resetFrameIndex() {
        this.framePointer = -1;
    }

    public int getLoopCount() {
        return this.header.loopCount;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized android.graphics.Bitmap getNextFrame() {
        /*
        r9 = this;
        monitor-enter(r9);
        r0 = r9.header;	 Catch:{ all -> 0x00dc }
        r0 = r0.frameCount;	 Catch:{ all -> 0x00dc }
        r1 = 3;
        r2 = 1;
        if (r0 <= 0) goto L_0x000d;
    L_0x0009:
        r0 = r9.framePointer;	 Catch:{ all -> 0x00dc }
        if (r0 >= 0) goto L_0x003b;
    L_0x000d:
        r0 = TAG;	 Catch:{ all -> 0x00dc }
        r0 = android.util.Log.isLoggable(r0, r1);	 Catch:{ all -> 0x00dc }
        if (r0 == 0) goto L_0x0039;
    L_0x0015:
        r0 = TAG;	 Catch:{ all -> 0x00dc }
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00dc }
        r3.<init>();	 Catch:{ all -> 0x00dc }
        r4 = "unable to decode frame, frameCount=";
        r3.append(r4);	 Catch:{ all -> 0x00dc }
        r4 = r9.header;	 Catch:{ all -> 0x00dc }
        r4 = r4.frameCount;	 Catch:{ all -> 0x00dc }
        r3.append(r4);	 Catch:{ all -> 0x00dc }
        r4 = " framePointer=";
        r3.append(r4);	 Catch:{ all -> 0x00dc }
        r4 = r9.framePointer;	 Catch:{ all -> 0x00dc }
        r3.append(r4);	 Catch:{ all -> 0x00dc }
        r3 = r3.toString();	 Catch:{ all -> 0x00dc }
        android.util.Log.d(r0, r3);	 Catch:{ all -> 0x00dc }
    L_0x0039:
        r9.status = r2;	 Catch:{ all -> 0x00dc }
    L_0x003b:
        r0 = r9.status;	 Catch:{ all -> 0x00dc }
        r3 = 0;
        if (r0 == r2) goto L_0x00ba;
    L_0x0040:
        r0 = r9.status;	 Catch:{ all -> 0x00dc }
        r4 = 2;
        if (r0 != r4) goto L_0x0047;
    L_0x0045:
        goto L_0x00ba;
    L_0x0047:
        r0 = 0;
        r9.status = r0;	 Catch:{ all -> 0x00dc }
        r4 = r9.header;	 Catch:{ all -> 0x00dc }
        r4 = r4.frames;	 Catch:{ all -> 0x00dc }
        r5 = r9.framePointer;	 Catch:{ all -> 0x00dc }
        r4 = r4.get(r5);	 Catch:{ all -> 0x00dc }
        r4 = (com.bumptech.glide.gifdecoder.GifFrame) r4;	 Catch:{ all -> 0x00dc }
        r5 = r9.framePointer;	 Catch:{ all -> 0x00dc }
        r5 = r5 - r2;
        if (r5 < 0) goto L_0x0066;
    L_0x005b:
        r6 = r9.header;	 Catch:{ all -> 0x00dc }
        r6 = r6.frames;	 Catch:{ all -> 0x00dc }
        r5 = r6.get(r5);	 Catch:{ all -> 0x00dc }
        r5 = (com.bumptech.glide.gifdecoder.GifFrame) r5;	 Catch:{ all -> 0x00dc }
        goto L_0x0067;
    L_0x0066:
        r5 = r3;
    L_0x0067:
        r6 = r4.lct;	 Catch:{ all -> 0x00dc }
        if (r6 != 0) goto L_0x0072;
    L_0x006b:
        r6 = r9.header;	 Catch:{ all -> 0x00dc }
        r6 = r6.gct;	 Catch:{ all -> 0x00dc }
        r9.act = r6;	 Catch:{ all -> 0x00dc }
        goto L_0x0082;
    L_0x0072:
        r6 = r4.lct;	 Catch:{ all -> 0x00dc }
        r9.act = r6;	 Catch:{ all -> 0x00dc }
        r6 = r9.header;	 Catch:{ all -> 0x00dc }
        r6 = r6.bgIndex;	 Catch:{ all -> 0x00dc }
        r7 = r4.transIndex;	 Catch:{ all -> 0x00dc }
        if (r6 != r7) goto L_0x0082;
    L_0x007e:
        r6 = r9.header;	 Catch:{ all -> 0x00dc }
        r6.bgColor = r0;	 Catch:{ all -> 0x00dc }
    L_0x0082:
        r6 = r4.transparency;	 Catch:{ all -> 0x00dc }
        if (r6 == 0) goto L_0x0093;
    L_0x0086:
        r6 = r9.act;	 Catch:{ all -> 0x00dc }
        r7 = r4.transIndex;	 Catch:{ all -> 0x00dc }
        r6 = r6[r7];	 Catch:{ all -> 0x00dc }
        r7 = r9.act;	 Catch:{ all -> 0x00dc }
        r8 = r4.transIndex;	 Catch:{ all -> 0x00dc }
        r7[r8] = r0;	 Catch:{ all -> 0x00dc }
        r0 = r6;
    L_0x0093:
        r6 = r9.act;	 Catch:{ all -> 0x00dc }
        if (r6 != 0) goto L_0x00aa;
    L_0x0097:
        r0 = TAG;	 Catch:{ all -> 0x00dc }
        r0 = android.util.Log.isLoggable(r0, r1);	 Catch:{ all -> 0x00dc }
        if (r0 == 0) goto L_0x00a6;
    L_0x009f:
        r0 = TAG;	 Catch:{ all -> 0x00dc }
        r1 = "No Valid Color Table";
        android.util.Log.d(r0, r1);	 Catch:{ all -> 0x00dc }
    L_0x00a6:
        r9.status = r2;	 Catch:{ all -> 0x00dc }
        monitor-exit(r9);
        return r3;
    L_0x00aa:
        r1 = r9.setPixels(r4, r5);	 Catch:{ all -> 0x00dc }
        r2 = r4.transparency;	 Catch:{ all -> 0x00dc }
        if (r2 == 0) goto L_0x00b8;
    L_0x00b2:
        r2 = r9.act;	 Catch:{ all -> 0x00dc }
        r3 = r4.transIndex;	 Catch:{ all -> 0x00dc }
        r2[r3] = r0;	 Catch:{ all -> 0x00dc }
    L_0x00b8:
        monitor-exit(r9);
        return r1;
    L_0x00ba:
        r0 = TAG;	 Catch:{ all -> 0x00dc }
        r0 = android.util.Log.isLoggable(r0, r1);	 Catch:{ all -> 0x00dc }
        if (r0 == 0) goto L_0x00da;
    L_0x00c2:
        r0 = TAG;	 Catch:{ all -> 0x00dc }
        r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00dc }
        r1.<init>();	 Catch:{ all -> 0x00dc }
        r2 = "Unable to decode frame, status=";
        r1.append(r2);	 Catch:{ all -> 0x00dc }
        r2 = r9.status;	 Catch:{ all -> 0x00dc }
        r1.append(r2);	 Catch:{ all -> 0x00dc }
        r1 = r1.toString();	 Catch:{ all -> 0x00dc }
        android.util.Log.d(r0, r1);	 Catch:{ all -> 0x00dc }
    L_0x00da:
        monitor-exit(r9);
        return r3;
    L_0x00dc:
        r0 = move-exception;
        monitor-exit(r9);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.gifdecoder.GifDecoder.getNextFrame():android.graphics.Bitmap");
    }

    public int read(InputStream inputStream, int i) {
        if (inputStream != null) {
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(i > 0 ? i + 4096 : 16384);
                i = new byte[16384];
                while (true) {
                    int read = inputStream.read(i, 0, i.length);
                    if (read == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(i, 0, read);
                }
                byteArrayOutputStream.flush();
                read(byteArrayOutputStream.toByteArray());
            } catch (int i2) {
                Log.w(TAG, "Error reading data from stream", i2);
            }
        } else {
            this.status = 2;
        }
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (InputStream inputStream2) {
                Log.w(TAG, "Error closing stream", inputStream2);
            }
        }
        return this.status;
    }

    public void clear() {
        this.header = null;
        this.data = null;
        this.mainPixels = null;
        this.mainScratch = null;
        if (this.previousImage != null) {
            this.bitmapProvider.release(this.previousImage);
        }
        this.previousImage = null;
        this.rawData = null;
    }

    public void setData(GifHeader gifHeader, byte[] bArr) {
        this.header = gifHeader;
        this.data = bArr;
        this.status = 0;
        this.framePointer = -1;
        this.rawData = ByteBuffer.wrap(bArr);
        this.rawData.rewind();
        this.rawData.order(ByteOrder.LITTLE_ENDIAN);
        this.savePrevious = false;
        for (GifFrame gifFrame : gifHeader.frames) {
            if (gifFrame.dispose == 3) {
                this.savePrevious = 1;
                break;
            }
        }
        this.mainPixels = new byte[(gifHeader.width * gifHeader.height)];
        this.mainScratch = new int[(gifHeader.width * gifHeader.height)];
    }

    private GifHeaderParser getHeaderParser() {
        if (this.parser == null) {
            this.parser = new GifHeaderParser();
        }
        return this.parser;
    }

    public int read(byte[] bArr) {
        this.data = bArr;
        this.header = getHeaderParser().setData(bArr).parseHeader();
        if (bArr != null) {
            this.rawData = ByteBuffer.wrap(bArr);
            this.rawData.rewind();
            this.rawData.order(ByteOrder.LITTLE_ENDIAN);
            this.mainPixels = new byte[(this.header.width * this.header.height)];
            this.mainScratch = new int[(this.header.width * this.header.height)];
            this.savePrevious = null;
            for (GifFrame gifFrame : this.header.frames) {
                if (gifFrame.dispose == 3) {
                    this.savePrevious = 1;
                    break;
                }
            }
        }
        return this.status;
    }

    private Bitmap setPixels(GifFrame gifFrame, GifFrame gifFrame2) {
        int i = this.header.width;
        int i2 = this.header.height;
        int[] iArr = this.mainScratch;
        int i3 = 0;
        if (gifFrame2 != null && gifFrame2.dispose > 0) {
            if (gifFrame2.dispose == 2) {
                Arrays.fill(iArr, gifFrame.transparency == null ? this.header.bgColor : null);
            } else if (gifFrame2.dispose == 3 && this.previousImage != null) {
                this.previousImage.getPixels(iArr, 0, i, 0, 0, i, i2);
            }
        }
        decodeBitmapData(gifFrame);
        int i4 = 8;
        int i5 = 1;
        gifFrame2 = null;
        while (i3 < gifFrame.ih) {
            int i6;
            if (gifFrame.interlace) {
                if (gifFrame2 >= gifFrame.ih) {
                    i5++;
                    switch (i5) {
                        case 2:
                            gifFrame2 = 4;
                            break;
                        case 3:
                            i4 = 4;
                            gifFrame2 = 2;
                            break;
                        case 4:
                            gifFrame2 = 1;
                            i4 = 2;
                            break;
                        default:
                            break;
                    }
                }
                i6 = gifFrame2 + i4;
            } else {
                i6 = gifFrame2;
                gifFrame2 = i3;
            }
            gifFrame2 += gifFrame.iy;
            if (gifFrame2 < this.header.height) {
                gifFrame2 *= this.header.width;
                int i7 = gifFrame.ix + gifFrame2;
                int i8 = gifFrame.iw + i7;
                if (this.header.width + gifFrame2 < i8) {
                    i8 = this.header.width + gifFrame2;
                }
                gifFrame2 = gifFrame.iw * i3;
                while (i7 < i8) {
                    int i9 = gifFrame2 + 1;
                    gifFrame2 = this.act[this.mainPixels[gifFrame2] & 255];
                    if (gifFrame2 != null) {
                        iArr[i7] = gifFrame2;
                    }
                    i7++;
                    gifFrame2 = i9;
                }
            }
            i3++;
            gifFrame2 = i6;
        }
        if (this.savePrevious != null && (gifFrame.dispose == null || gifFrame.dispose == 1)) {
            if (this.previousImage == null) {
                this.previousImage = getNextBitmap();
            }
            this.previousImage.setPixels(iArr, 0, i, 0, 0, i, i2);
        }
        gifFrame = getNextBitmap();
        gifFrame.setPixels(iArr, 0, i, 0, 0, i, i2);
        return gifFrame;
    }

    private void decodeBitmapData(GifFrame gifFrame) {
        short s;
        int i;
        GifDecoder gifDecoder = this;
        GifFrame gifFrame2 = gifFrame;
        if (gifFrame2 != null) {
            gifDecoder.rawData.position(gifFrame2.bufferFrameStart);
        }
        if (gifFrame2 == null) {
            s = gifDecoder.header.width * gifDecoder.header.height;
        } else {
            s = gifFrame2.ih * gifFrame2.iw;
        }
        if (gifDecoder.mainPixels == null || gifDecoder.mainPixels.length < s) {
            gifDecoder.mainPixels = new byte[s];
        }
        if (gifDecoder.prefix == null) {
            gifDecoder.prefix = new short[4096];
        }
        if (gifDecoder.suffix == null) {
            gifDecoder.suffix = new byte[4096];
        }
        if (gifDecoder.pixelStack == null) {
            gifDecoder.pixelStack = new byte[FragmentTransaction.TRANSIT_FRAGMENT_OPEN];
        }
        int read = read();
        int i2 = 1;
        int i3 = 1 << read;
        int i4 = i3 + 1;
        int i5 = i3 + 2;
        read++;
        int i6 = (1 << read) - 1;
        for (i = 0; i < i3; i++) {
            gifDecoder.prefix[i] = (short) 0;
            gifDecoder.suffix[i] = (byte) i;
        }
        i = -1;
        int i7 = read;
        int i8 = i5;
        int i9 = i6;
        short s2 = (short) 0;
        int i10 = s2;
        short s3 = i10;
        int i11 = s3;
        int i12 = i11;
        int i13 = i12;
        short s4 = i13;
        int i14 = s4;
        int i15 = -1;
        while (s2 < s) {
            int i16;
            int i17 = 3;
            if (i10 == 0) {
                i10 = readBlock();
                if (i10 <= 0) {
                    gifDecoder.status = 3;
                    break;
                }
                i12 = 0;
            }
            i11 += (gifDecoder.block[i12] & 255) << i13;
            i12 += i2;
            i10 += i;
            int i18 = i13 + 8;
            short s5 = s4;
            i2 = i15;
            short s6 = s2;
            s4 = s3;
            int i19 = i8;
            int i20 = i7;
            while (i18 >= i20) {
                i = i11 & i9;
                i11 >>= i20;
                i18 -= i20;
                if (i != i3) {
                    if (i > i19) {
                        gifDecoder.status = i17;
                    } else if (i != i4) {
                        if (i2 == -1) {
                            i8 = i14 + 1;
                            gifDecoder.pixelStack[i14] = gifDecoder.suffix[i];
                            i2 = i;
                            s5 = i2;
                            i14 = i8;
                        } else {
                            int i21;
                            int i22;
                            if (i >= i19) {
                                i8 = i14 + 1;
                                i21 = read;
                                gifDecoder.pixelStack[i14] = (byte) s5;
                                read = i2;
                                i14 = i8;
                            } else {
                                i21 = read;
                                read = i;
                            }
                            while (read >= i3) {
                                i8 = i14 + 1;
                                i22 = i18;
                                gifDecoder.pixelStack[i14] = gifDecoder.suffix[read];
                                read = gifDecoder.prefix[read];
                                i14 = i8;
                                i18 = i22;
                            }
                            i22 = i18;
                            short s7 = gifDecoder.suffix[read] & 255;
                            i17 = i14 + 1;
                            i16 = i3;
                            byte b = (byte) s7;
                            gifDecoder.pixelStack[i14] = b;
                            if (i19 < 4096) {
                                gifDecoder.prefix[i19] = (short) i2;
                                gifDecoder.suffix[i19] = b;
                                i19++;
                                if ((i19 & i9) == 0) {
                                    if (i19 < 4096) {
                                        i20++;
                                        i9 += i19;
                                    }
                                }
                            }
                            i14 = i17;
                            while (i14 > 0) {
                                i14--;
                                short s8 = s4 + 1;
                                gifDecoder.mainPixels[s4] = gifDecoder.pixelStack[i14];
                                s6++;
                                s4 = s8;
                            }
                            s5 = s7;
                            i2 = i;
                            read = i21;
                            i18 = i22;
                            i3 = i16;
                        }
                        i17 = 3;
                    }
                    i15 = i2;
                    i7 = i20;
                    i8 = i19;
                    s2 = s6;
                    s3 = s4;
                    s4 = s5;
                    i2 = 1;
                    i = -1;
                    i13 = i18;
                    break;
                }
                i20 = read;
                i19 = i5;
                i9 = i6;
                i2 = -1;
                i = -1;
            }
            i16 = i3;
            i15 = i2;
            i7 = i20;
            i8 = i19;
            s2 = s6;
            s3 = s4;
            i2 = 1;
            s4 = s5;
            i13 = i18;
            read = read;
        }
        while (s3 < s) {
            gifDecoder.mainPixels[s3] = (byte) 0;
            s3++;
        }
    }

    private int read() {
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
        r1 = this;
        r0 = r1.rawData;	 Catch:{ Exception -> 0x0009 }
        r0 = r0.get();	 Catch:{ Exception -> 0x0009 }
        r0 = r0 & 255;
        goto L_0x000d;
    L_0x0009:
        r0 = 1;
        r1.status = r0;
        r0 = 0;
    L_0x000d:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.gifdecoder.GifDecoder.read():int");
    }

    private int readBlock() {
        int read = read();
        int i = 0;
        if (read > 0) {
            while (i < read) {
                int i2 = read - i;
                try {
                    this.rawData.get(this.block, i, i2);
                    i += i2;
                } catch (Throwable e) {
                    Log.w(TAG, "Error Reading Block", e);
                    this.status = 1;
                }
            }
        }
        return i;
    }

    private Bitmap getNextBitmap() {
        Bitmap obtain = this.bitmapProvider.obtain(this.header.width, this.header.height, BITMAP_CONFIG);
        if (obtain == null) {
            obtain = Bitmap.createBitmap(this.header.width, this.header.height, BITMAP_CONFIG);
        }
        setAlpha(obtain);
        return obtain;
    }

    @TargetApi(12)
    private static void setAlpha(Bitmap bitmap) {
        if (VERSION.SDK_INT >= 12) {
            bitmap.setHasAlpha(true);
        }
    }
}
