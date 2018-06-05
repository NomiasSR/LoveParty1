package com.google.android.gms.internal;

import android.support.v4.internal.view.SupportMenu;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.WritableByteChannel;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

final class zzele {
    private final Random random = new Random();
    private final Thread zzndy = zzeku.getThreadFactory().newThread(new zzelf(this));
    private zzeku zznep;
    private volatile boolean zznes = false;
    private BlockingQueue<ByteBuffer> zznet;
    private boolean zzneu = false;
    private WritableByteChannel zznev;

    zzele(zzeku com_google_android_gms_internal_zzeku, String str, int i) {
        zzekt zzcas = zzeku.zzcas();
        Thread thread = this.zzndy;
        StringBuilder stringBuilder = new StringBuilder(18 + String.valueOf(str).length());
        stringBuilder.append(str);
        stringBuilder.append("Writer-");
        stringBuilder.append(i);
        zzcas.zza(thread, stringBuilder.toString());
        this.zznep = com_google_android_gms_internal_zzeku;
        this.zznet = new LinkedBlockingQueue();
    }

    private final void zzcbb() throws InterruptedException, IOException {
        this.zznev.write((ByteBuffer) this.zznet.take());
    }

    private final void zzcbd() {
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
        r3 = this;
    L_0x0000:
        r0 = r3.zznes;	 Catch:{ IOException -> 0x001e, InterruptedException -> 0x001d }
        if (r0 != 0) goto L_0x000e;	 Catch:{ IOException -> 0x001e, InterruptedException -> 0x001d }
    L_0x0004:
        r0 = java.lang.Thread.interrupted();	 Catch:{ IOException -> 0x001e, InterruptedException -> 0x001d }
        if (r0 != 0) goto L_0x000e;	 Catch:{ IOException -> 0x001e, InterruptedException -> 0x001d }
    L_0x000a:
        r3.zzcbb();	 Catch:{ IOException -> 0x001e, InterruptedException -> 0x001d }
        goto L_0x0000;	 Catch:{ IOException -> 0x001e, InterruptedException -> 0x001d }
    L_0x000e:
        r0 = 0;	 Catch:{ IOException -> 0x001e, InterruptedException -> 0x001d }
    L_0x000f:
        r1 = r3.zznet;	 Catch:{ IOException -> 0x001e, InterruptedException -> 0x001d }
        r1 = r1.size();	 Catch:{ IOException -> 0x001e, InterruptedException -> 0x001d }
        if (r0 >= r1) goto L_0x001d;	 Catch:{ IOException -> 0x001e, InterruptedException -> 0x001d }
    L_0x0017:
        r3.zzcbb();	 Catch:{ IOException -> 0x001e, InterruptedException -> 0x001d }
        r0 = r0 + 1;
        goto L_0x000f;
    L_0x001d:
        return;
    L_0x001e:
        r0 = move-exception;
        r1 = new com.google.android.gms.internal.zzela;
        r2 = "IO Exception";
        r1.<init>(r2, r0);
        r0 = r3.zznep;
        r0.zzb(r1);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzele.zzcbd():void");
    }

    final synchronized void zza(byte b, boolean z, byte[] bArr) throws IOException {
        int i = 6;
        int length = bArr.length;
        if (length >= 126) {
            i = length <= SupportMenu.USER_MASK ? 8 : 14;
        }
        ByteBuffer allocate = ByteBuffer.allocate(bArr.length + i);
        allocate.put((byte) (-128 | b));
        int i2 = 0;
        if (length < 126) {
            allocate.put((byte) (length | 128));
        } else if (length <= SupportMenu.USER_MASK) {
            allocate.put((byte) -2);
            allocate.putShort((short) length);
        } else {
            allocate.put((byte) -1);
            allocate.putInt(0);
            allocate.putInt(length);
        }
        byte[] bArr2 = new byte[4];
        this.random.nextBytes(bArr2);
        allocate.put(bArr2);
        while (i2 < bArr.length) {
            allocate.put((byte) (bArr[i2] ^ bArr2[i2 % 4]));
            i2++;
        }
        allocate.flip();
        if (!this.zznes || (!this.zzneu && b == (byte) 8)) {
            if (b == (byte) 8) {
                this.zzneu = true;
            }
            this.zznet.add(allocate);
        } else {
            throw new zzela("Shouldn't be sending");
        }
    }

    final void zzb(OutputStream outputStream) {
        this.zznev = Channels.newChannel(outputStream);
    }

    final void zzcbc() {
        this.zznes = true;
    }

    final Thread zzcbe() {
        return this.zzndy;
    }
}
