package com.google.android.gms.internal;

import java.io.IOException;
import java.io.InputStream;

public final class zzexq {
    private static final Runtime zzolr = Runtime.getRuntime();
    private byte[] buffer = new byte[262144];
    private final InputStream zzols;
    private int zzolt = 0;
    private boolean zzolu = false;
    private boolean zzolv = true;

    public zzexq(InputStream inputStream, int i) {
        this.zzols = inputStream;
    }

    private final int zzim(int r5) {
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
        r4 = this;
        r0 = r4.buffer;
        r0 = r0.length;
        r0 = r0 << 1;
        r5 = java.lang.Math.max(r0, r5);
        r0 = zzolr;
        r0 = r0.totalMemory();
        r2 = zzolr;
        r2 = r2.freeMemory();
        r0 = r0 - r2;
        r2 = zzolr;
        r2 = r2.maxMemory();
        r2 = r2 - r0;
        r0 = r4.zzolv;
        if (r0 == 0) goto L_0x003d;
    L_0x0021:
        r0 = (long) r5;
        r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
        if (r0 >= 0) goto L_0x003d;
    L_0x0026:
        r0 = 0;
        r5 = new byte[r5];	 Catch:{ OutOfMemoryError -> 0x0033 }
        r1 = r4.buffer;	 Catch:{ OutOfMemoryError -> 0x0033 }
        r2 = r4.zzolt;	 Catch:{ OutOfMemoryError -> 0x0033 }
        java.lang.System.arraycopy(r1, r0, r5, r0, r2);	 Catch:{ OutOfMemoryError -> 0x0033 }
        r4.buffer = r5;	 Catch:{ OutOfMemoryError -> 0x0033 }
        goto L_0x0044;
    L_0x0033:
        r5 = "AdaptiveStreamBuffer";
        r1 = "Turning off adaptive buffer resizing due to low memory.";
        android.util.Log.w(r5, r1);
        r4.zzolv = r0;
        goto L_0x0044;
    L_0x003d:
        r5 = "AdaptiveStreamBuffer";
        r0 = "Turning off adaptive buffer resizing to conserve memory.";
        android.util.Log.w(r5, r0);
    L_0x0044:
        r5 = r4.buffer;
        r5 = r5.length;
        return r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzexq.zzim(int):int");
    }

    public final int available() {
        return this.zzolt;
    }

    public final void close() throws IOException {
        this.zzols.close();
    }

    public final boolean isFinished() {
        return this.zzolu;
    }

    public final byte[] zzcmg() {
        return this.buffer;
    }

    public final int zzik(int i) throws IOException {
        if (i <= this.zzolt) {
            this.zzolt -= i;
            System.arraycopy(this.buffer, i, this.buffer, 0, this.zzolt);
            return i;
        }
        this.zzolt = 0;
        int i2 = this.zzolt;
        while (i2 < i) {
            long skip = this.zzols.skip((long) (i - i2));
            int i3 = (skip > 0 ? 1 : (skip == 0 ? 0 : -1));
            if (i3 <= 0) {
                if (i3 == 0) {
                    if (this.zzols.read() == -1) {
                        break;
                    }
                    i2++;
                } else {
                    continue;
                }
            } else {
                i2 = (int) (((long) i2) + skip);
            }
        }
        return i2;
    }

    public final int zzil(int i) throws IOException {
        if (i > this.buffer.length) {
            i = Math.min(i, zzim(i));
        }
        while (this.zzolt < i) {
            int read = this.zzols.read(this.buffer, this.zzolt, i - this.zzolt);
            if (read == -1) {
                this.zzolu = true;
                break;
            }
            this.zzolt += read;
        }
        return this.zzolt;
    }
}
