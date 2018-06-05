package com.google.android.gms.internal;

import java.io.DataInputStream;
import java.io.IOException;

final class zzeld {
    private zzekz zzndt = null;
    private DataInputStream zzneo = null;
    private zzeku zznep = null;
    private byte[] zzneq = new byte[112];
    private zzekp zzner;
    private volatile boolean zznes = false;

    zzeld(zzeku com_google_android_gms_internal_zzeku) {
        this.zznep = com_google_android_gms_internal_zzeku;
    }

    private final int read(byte[] bArr, int i, int i2) throws IOException {
        this.zzneo.readFully(bArr, i, i2);
        return i2;
    }

    private final void zzc(zzela com_google_android_gms_internal_zzela) {
        this.zznes = true;
        this.zznep.zzb(com_google_android_gms_internal_zzela);
    }

    final void run() {
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
        r15 = this;
        r0 = r15.zznep;
        r0 = r0.zzcat();
        r15.zzndt = r0;
    L_0x0008:
        r0 = r15.zznes;
        if (r0 != 0) goto L_0x0181;
    L_0x000c:
        r0 = r15.zzneq;	 Catch:{ SocketTimeoutException -> 0x0008, IOException -> 0x0174, zzela -> 0x016e }
        r1 = 1;	 Catch:{ SocketTimeoutException -> 0x0008, IOException -> 0x0174, zzela -> 0x016e }
        r2 = 0;	 Catch:{ SocketTimeoutException -> 0x0008, IOException -> 0x0174, zzela -> 0x016e }
        r0 = r15.read(r0, r2, r1);	 Catch:{ SocketTimeoutException -> 0x0008, IOException -> 0x0174, zzela -> 0x016e }
        r0 = r0 + r2;	 Catch:{ SocketTimeoutException -> 0x0008, IOException -> 0x0174, zzela -> 0x016e }
        r3 = r15.zzneq;	 Catch:{ SocketTimeoutException -> 0x0008, IOException -> 0x0174, zzela -> 0x016e }
        r3 = r3[r2];	 Catch:{ SocketTimeoutException -> 0x0008, IOException -> 0x0174, zzela -> 0x016e }
        r3 = r3 & 128;	 Catch:{ SocketTimeoutException -> 0x0008, IOException -> 0x0174, zzela -> 0x016e }
        if (r3 == 0) goto L_0x001f;	 Catch:{ SocketTimeoutException -> 0x0008, IOException -> 0x0174, zzela -> 0x016e }
    L_0x001d:
        r3 = r1;	 Catch:{ SocketTimeoutException -> 0x0008, IOException -> 0x0174, zzela -> 0x016e }
        goto L_0x0020;	 Catch:{ SocketTimeoutException -> 0x0008, IOException -> 0x0174, zzela -> 0x016e }
    L_0x001f:
        r3 = r2;	 Catch:{ SocketTimeoutException -> 0x0008, IOException -> 0x0174, zzela -> 0x016e }
    L_0x0020:
        r4 = r15.zzneq;	 Catch:{ SocketTimeoutException -> 0x0008, IOException -> 0x0174, zzela -> 0x016e }
        r4 = r4[r2];	 Catch:{ SocketTimeoutException -> 0x0008, IOException -> 0x0174, zzela -> 0x016e }
        r4 = r4 & 112;	 Catch:{ SocketTimeoutException -> 0x0008, IOException -> 0x0174, zzela -> 0x016e }
        if (r4 == 0) goto L_0x002a;	 Catch:{ SocketTimeoutException -> 0x0008, IOException -> 0x0174, zzela -> 0x016e }
    L_0x0028:
        r4 = r1;	 Catch:{ SocketTimeoutException -> 0x0008, IOException -> 0x0174, zzela -> 0x016e }
        goto L_0x002b;	 Catch:{ SocketTimeoutException -> 0x0008, IOException -> 0x0174, zzela -> 0x016e }
    L_0x002a:
        r4 = r2;	 Catch:{ SocketTimeoutException -> 0x0008, IOException -> 0x0174, zzela -> 0x016e }
    L_0x002b:
        if (r4 == 0) goto L_0x0035;	 Catch:{ SocketTimeoutException -> 0x0008, IOException -> 0x0174, zzela -> 0x016e }
    L_0x002d:
        r0 = new com.google.android.gms.internal.zzela;	 Catch:{ SocketTimeoutException -> 0x0008, IOException -> 0x0174, zzela -> 0x016e }
        r1 = "Invalid frame received";	 Catch:{ SocketTimeoutException -> 0x0008, IOException -> 0x0174, zzela -> 0x016e }
        r0.<init>(r1);	 Catch:{ SocketTimeoutException -> 0x0008, IOException -> 0x0174, zzela -> 0x016e }
        throw r0;	 Catch:{ SocketTimeoutException -> 0x0008, IOException -> 0x0174, zzela -> 0x016e }
    L_0x0035:
        r4 = r15.zzneq;	 Catch:{ SocketTimeoutException -> 0x0008, IOException -> 0x0174, zzela -> 0x016e }
        r4 = r4[r2];	 Catch:{ SocketTimeoutException -> 0x0008, IOException -> 0x0174, zzela -> 0x016e }
        r4 = r4 & 15;	 Catch:{ SocketTimeoutException -> 0x0008, IOException -> 0x0174, zzela -> 0x016e }
        r4 = (byte) r4;	 Catch:{ SocketTimeoutException -> 0x0008, IOException -> 0x0174, zzela -> 0x016e }
        r5 = r15.zzneq;	 Catch:{ SocketTimeoutException -> 0x0008, IOException -> 0x0174, zzela -> 0x016e }
        r5 = r15.read(r5, r0, r1);	 Catch:{ SocketTimeoutException -> 0x0008, IOException -> 0x0174, zzela -> 0x016e }
        r0 = r0 + r5;	 Catch:{ SocketTimeoutException -> 0x0008, IOException -> 0x0174, zzela -> 0x016e }
        r5 = r15.zzneq;	 Catch:{ SocketTimeoutException -> 0x0008, IOException -> 0x0174, zzela -> 0x016e }
        r5 = r5[r1];	 Catch:{ SocketTimeoutException -> 0x0008, IOException -> 0x0174, zzela -> 0x016e }
        r6 = 0;	 Catch:{ SocketTimeoutException -> 0x0008, IOException -> 0x0174, zzela -> 0x016e }
        r8 = 24;	 Catch:{ SocketTimeoutException -> 0x0008, IOException -> 0x0174, zzela -> 0x016e }
        r9 = 126; // 0x7e float:1.77E-43 double:6.23E-322;	 Catch:{ SocketTimeoutException -> 0x0008, IOException -> 0x0174, zzela -> 0x016e }
        r10 = 8;	 Catch:{ SocketTimeoutException -> 0x0008, IOException -> 0x0174, zzela -> 0x016e }
        r11 = 2;	 Catch:{ SocketTimeoutException -> 0x0008, IOException -> 0x0174, zzela -> 0x016e }
        if (r5 >= r9) goto L_0x0054;	 Catch:{ SocketTimeoutException -> 0x0008, IOException -> 0x0174, zzela -> 0x016e }
    L_0x0052:
        r6 = (long) r5;	 Catch:{ SocketTimeoutException -> 0x0008, IOException -> 0x0174, zzela -> 0x016e }
        goto L_0x00be;	 Catch:{ SocketTimeoutException -> 0x0008, IOException -> 0x0174, zzela -> 0x016e }
    L_0x0054:
        r12 = 255; // 0xff float:3.57E-43 double:1.26E-321;	 Catch:{ SocketTimeoutException -> 0x0008, IOException -> 0x0174, zzela -> 0x016e }
        if (r5 != r9) goto L_0x006c;	 Catch:{ SocketTimeoutException -> 0x0008, IOException -> 0x0174, zzela -> 0x016e }
    L_0x0058:
        r5 = r15.zzneq;	 Catch:{ SocketTimeoutException -> 0x0008, IOException -> 0x0174, zzela -> 0x016e }
        r15.read(r5, r0, r11);	 Catch:{ SocketTimeoutException -> 0x0008, IOException -> 0x0174, zzela -> 0x016e }
        r0 = r15.zzneq;	 Catch:{ SocketTimeoutException -> 0x0008, IOException -> 0x0174, zzela -> 0x016e }
        r0 = r0[r11];	 Catch:{ SocketTimeoutException -> 0x0008, IOException -> 0x0174, zzela -> 0x016e }
        r0 = r0 & r12;	 Catch:{ SocketTimeoutException -> 0x0008, IOException -> 0x0174, zzela -> 0x016e }
        r0 = r0 << r10;	 Catch:{ SocketTimeoutException -> 0x0008, IOException -> 0x0174, zzela -> 0x016e }
        r5 = r15.zzneq;	 Catch:{ SocketTimeoutException -> 0x0008, IOException -> 0x0174, zzela -> 0x016e }
        r6 = 3;	 Catch:{ SocketTimeoutException -> 0x0008, IOException -> 0x0174, zzela -> 0x016e }
        r5 = r5[r6];	 Catch:{ SocketTimeoutException -> 0x0008, IOException -> 0x0174, zzela -> 0x016e }
        r5 = r5 & r12;	 Catch:{ SocketTimeoutException -> 0x0008, IOException -> 0x0174, zzela -> 0x016e }
        r0 = r0 | r5;	 Catch:{ SocketTimeoutException -> 0x0008, IOException -> 0x0174, zzela -> 0x016e }
        r6 = (long) r0;	 Catch:{ SocketTimeoutException -> 0x0008, IOException -> 0x0174, zzela -> 0x016e }
        goto L_0x00be;	 Catch:{ SocketTimeoutException -> 0x0008, IOException -> 0x0174, zzela -> 0x016e }
    L_0x006c:
        r9 = 127; // 0x7f float:1.78E-43 double:6.27E-322;	 Catch:{ SocketTimeoutException -> 0x0008, IOException -> 0x0174, zzela -> 0x016e }
        if (r5 != r9) goto L_0x00be;	 Catch:{ SocketTimeoutException -> 0x0008, IOException -> 0x0174, zzela -> 0x016e }
    L_0x0070:
        r5 = r15.zzneq;	 Catch:{ SocketTimeoutException -> 0x0008, IOException -> 0x0174, zzela -> 0x016e }
        r5 = r15.read(r5, r0, r10);	 Catch:{ SocketTimeoutException -> 0x0008, IOException -> 0x0174, zzela -> 0x016e }
        r0 = r0 + r5;	 Catch:{ SocketTimeoutException -> 0x0008, IOException -> 0x0174, zzela -> 0x016e }
        r5 = r15.zzneq;	 Catch:{ SocketTimeoutException -> 0x0008, IOException -> 0x0174, zzela -> 0x016e }
        r0 = r0 - r10;	 Catch:{ SocketTimeoutException -> 0x0008, IOException -> 0x0174, zzela -> 0x016e }
        r6 = r5[r0];	 Catch:{ SocketTimeoutException -> 0x0008, IOException -> 0x0174, zzela -> 0x016e }
        r6 = (long) r6;	 Catch:{ SocketTimeoutException -> 0x0008, IOException -> 0x0174, zzela -> 0x016e }
        r9 = 56;	 Catch:{ SocketTimeoutException -> 0x0008, IOException -> 0x0174, zzela -> 0x016e }
        r6 = r6 << r9;	 Catch:{ SocketTimeoutException -> 0x0008, IOException -> 0x0174, zzela -> 0x016e }
        r9 = r0 + 1;	 Catch:{ SocketTimeoutException -> 0x0008, IOException -> 0x0174, zzela -> 0x016e }
        r9 = r5[r9];	 Catch:{ SocketTimeoutException -> 0x0008, IOException -> 0x0174, zzela -> 0x016e }
        r9 = r9 & r12;	 Catch:{ SocketTimeoutException -> 0x0008, IOException -> 0x0174, zzela -> 0x016e }
        r13 = (long) r9;	 Catch:{ SocketTimeoutException -> 0x0008, IOException -> 0x0174, zzela -> 0x016e }
        r9 = 48;	 Catch:{ SocketTimeoutException -> 0x0008, IOException -> 0x0174, zzela -> 0x016e }
        r13 = r13 << r9;	 Catch:{ SocketTimeoutException -> 0x0008, IOException -> 0x0174, zzela -> 0x016e }
        r6 = r6 + r13;	 Catch:{ SocketTimeoutException -> 0x0008, IOException -> 0x0174, zzela -> 0x016e }
        r9 = r0 + 2;	 Catch:{ SocketTimeoutException -> 0x0008, IOException -> 0x0174, zzela -> 0x016e }
        r9 = r5[r9];	 Catch:{ SocketTimeoutException -> 0x0008, IOException -> 0x0174, zzela -> 0x016e }
        r9 = r9 & r12;	 Catch:{ SocketTimeoutException -> 0x0008, IOException -> 0x0174, zzela -> 0x016e }
        r13 = (long) r9;	 Catch:{ SocketTimeoutException -> 0x0008, IOException -> 0x0174, zzela -> 0x016e }
        r9 = 40;	 Catch:{ SocketTimeoutException -> 0x0008, IOException -> 0x0174, zzela -> 0x016e }
        r13 = r13 << r9;	 Catch:{ SocketTimeoutException -> 0x0008, IOException -> 0x0174, zzela -> 0x016e }
        r6 = r6 + r13;	 Catch:{ SocketTimeoutException -> 0x0008, IOException -> 0x0174, zzela -> 0x016e }
        r9 = r0 + 3;	 Catch:{ SocketTimeoutException -> 0x0008, IOException -> 0x0174, zzela -> 0x016e }
        r9 = r5[r9];	 Catch:{ SocketTimeoutException -> 0x0008, IOException -> 0x0174, zzela -> 0x016e }
        r9 = r9 & r12;	 Catch:{ SocketTimeoutException -> 0x0008, IOException -> 0x0174, zzela -> 0x016e }
        r13 = (long) r9;	 Catch:{ SocketTimeoutException -> 0x0008, IOException -> 0x0174, zzela -> 0x016e }
        r9 = 32;	 Catch:{ SocketTimeoutException -> 0x0008, IOException -> 0x0174, zzela -> 0x016e }
        r13 = r13 << r9;	 Catch:{ SocketTimeoutException -> 0x0008, IOException -> 0x0174, zzela -> 0x016e }
        r6 = r6 + r13;	 Catch:{ SocketTimeoutException -> 0x0008, IOException -> 0x0174, zzela -> 0x016e }
        r9 = r0 + 4;	 Catch:{ SocketTimeoutException -> 0x0008, IOException -> 0x0174, zzela -> 0x016e }
        r9 = r5[r9];	 Catch:{ SocketTimeoutException -> 0x0008, IOException -> 0x0174, zzela -> 0x016e }
        r9 = r9 & r12;	 Catch:{ SocketTimeoutException -> 0x0008, IOException -> 0x0174, zzela -> 0x016e }
        r13 = (long) r9;	 Catch:{ SocketTimeoutException -> 0x0008, IOException -> 0x0174, zzela -> 0x016e }
        r13 = r13 << r8;	 Catch:{ SocketTimeoutException -> 0x0008, IOException -> 0x0174, zzela -> 0x016e }
        r6 = r6 + r13;	 Catch:{ SocketTimeoutException -> 0x0008, IOException -> 0x0174, zzela -> 0x016e }
        r9 = r0 + 5;	 Catch:{ SocketTimeoutException -> 0x0008, IOException -> 0x0174, zzela -> 0x016e }
        r9 = r5[r9];	 Catch:{ SocketTimeoutException -> 0x0008, IOException -> 0x0174, zzela -> 0x016e }
        r9 = r9 & r12;	 Catch:{ SocketTimeoutException -> 0x0008, IOException -> 0x0174, zzela -> 0x016e }
        r9 = r9 << 16;	 Catch:{ SocketTimeoutException -> 0x0008, IOException -> 0x0174, zzela -> 0x016e }
        r13 = (long) r9;	 Catch:{ SocketTimeoutException -> 0x0008, IOException -> 0x0174, zzela -> 0x016e }
        r6 = r6 + r13;	 Catch:{ SocketTimeoutException -> 0x0008, IOException -> 0x0174, zzela -> 0x016e }
        r9 = r0 + 6;	 Catch:{ SocketTimeoutException -> 0x0008, IOException -> 0x0174, zzela -> 0x016e }
        r9 = r5[r9];	 Catch:{ SocketTimeoutException -> 0x0008, IOException -> 0x0174, zzela -> 0x016e }
        r9 = r9 & r12;	 Catch:{ SocketTimeoutException -> 0x0008, IOException -> 0x0174, zzela -> 0x016e }
        r9 = r9 << r10;	 Catch:{ SocketTimeoutException -> 0x0008, IOException -> 0x0174, zzela -> 0x016e }
        r13 = (long) r9;	 Catch:{ SocketTimeoutException -> 0x0008, IOException -> 0x0174, zzela -> 0x016e }
        r6 = r6 + r13;	 Catch:{ SocketTimeoutException -> 0x0008, IOException -> 0x0174, zzela -> 0x016e }
        r0 = r0 + 7;	 Catch:{ SocketTimeoutException -> 0x0008, IOException -> 0x0174, zzela -> 0x016e }
        r0 = r5[r0];	 Catch:{ SocketTimeoutException -> 0x0008, IOException -> 0x0174, zzela -> 0x016e }
        r0 = r0 & r12;	 Catch:{ SocketTimeoutException -> 0x0008, IOException -> 0x0174, zzela -> 0x016e }
        r12 = (long) r0;	 Catch:{ SocketTimeoutException -> 0x0008, IOException -> 0x0174, zzela -> 0x016e }
        r6 = r6 + r12;	 Catch:{ SocketTimeoutException -> 0x0008, IOException -> 0x0174, zzela -> 0x016e }
    L_0x00be:
        r0 = (int) r6;	 Catch:{ SocketTimeoutException -> 0x0008, IOException -> 0x0174, zzela -> 0x016e }
        r5 = new byte[r0];	 Catch:{ SocketTimeoutException -> 0x0008, IOException -> 0x0174, zzela -> 0x016e }
        r15.read(r5, r2, r0);	 Catch:{ SocketTimeoutException -> 0x0008, IOException -> 0x0174, zzela -> 0x016e }
        if (r4 != r10) goto L_0x00cd;	 Catch:{ SocketTimeoutException -> 0x0008, IOException -> 0x0174, zzela -> 0x016e }
    L_0x00c6:
        r0 = r15.zznep;	 Catch:{ SocketTimeoutException -> 0x0008, IOException -> 0x0174, zzela -> 0x016e }
        r0.zzcau();	 Catch:{ SocketTimeoutException -> 0x0008, IOException -> 0x0174, zzela -> 0x016e }
        goto L_0x0008;	 Catch:{ SocketTimeoutException -> 0x0008, IOException -> 0x0174, zzela -> 0x016e }
    L_0x00cd:
        r0 = 10;	 Catch:{ SocketTimeoutException -> 0x0008, IOException -> 0x0174, zzela -> 0x016e }
        if (r4 == r0) goto L_0x0008;	 Catch:{ SocketTimeoutException -> 0x0008, IOException -> 0x0174, zzela -> 0x016e }
    L_0x00d1:
        r0 = 9;	 Catch:{ SocketTimeoutException -> 0x0008, IOException -> 0x0174, zzela -> 0x016e }
        if (r4 == r1) goto L_0x00f3;	 Catch:{ SocketTimeoutException -> 0x0008, IOException -> 0x0174, zzela -> 0x016e }
    L_0x00d5:
        if (r4 == r11) goto L_0x00f3;	 Catch:{ SocketTimeoutException -> 0x0008, IOException -> 0x0174, zzela -> 0x016e }
    L_0x00d7:
        if (r4 == r0) goto L_0x00f3;	 Catch:{ SocketTimeoutException -> 0x0008, IOException -> 0x0174, zzela -> 0x016e }
    L_0x00d9:
        if (r4 != 0) goto L_0x00dc;	 Catch:{ SocketTimeoutException -> 0x0008, IOException -> 0x0174, zzela -> 0x016e }
    L_0x00db:
        goto L_0x00f3;	 Catch:{ SocketTimeoutException -> 0x0008, IOException -> 0x0174, zzela -> 0x016e }
    L_0x00dc:
        r0 = new com.google.android.gms.internal.zzela;	 Catch:{ SocketTimeoutException -> 0x0008, IOException -> 0x0174, zzela -> 0x016e }
        r1 = new java.lang.StringBuilder;	 Catch:{ SocketTimeoutException -> 0x0008, IOException -> 0x0174, zzela -> 0x016e }
        r1.<init>(r8);	 Catch:{ SocketTimeoutException -> 0x0008, IOException -> 0x0174, zzela -> 0x016e }
        r2 = "Unsupported opcode: ";	 Catch:{ SocketTimeoutException -> 0x0008, IOException -> 0x0174, zzela -> 0x016e }
        r1.append(r2);	 Catch:{ SocketTimeoutException -> 0x0008, IOException -> 0x0174, zzela -> 0x016e }
        r1.append(r4);	 Catch:{ SocketTimeoutException -> 0x0008, IOException -> 0x0174, zzela -> 0x016e }
        r1 = r1.toString();	 Catch:{ SocketTimeoutException -> 0x0008, IOException -> 0x0174, zzela -> 0x016e }
        r0.<init>(r1);	 Catch:{ SocketTimeoutException -> 0x0008, IOException -> 0x0174, zzela -> 0x016e }
        throw r0;	 Catch:{ SocketTimeoutException -> 0x0008, IOException -> 0x0174, zzela -> 0x016e }
    L_0x00f3:
        if (r4 != r0) goto L_0x0113;	 Catch:{ SocketTimeoutException -> 0x0008, IOException -> 0x0174, zzela -> 0x016e }
    L_0x00f5:
        if (r3 == 0) goto L_0x010b;	 Catch:{ SocketTimeoutException -> 0x0008, IOException -> 0x0174, zzela -> 0x016e }
    L_0x00f7:
        r0 = r5.length;	 Catch:{ SocketTimeoutException -> 0x0008, IOException -> 0x0174, zzela -> 0x016e }
        r1 = 125; // 0x7d float:1.75E-43 double:6.2E-322;	 Catch:{ SocketTimeoutException -> 0x0008, IOException -> 0x0174, zzela -> 0x016e }
        if (r0 > r1) goto L_0x0103;	 Catch:{ SocketTimeoutException -> 0x0008, IOException -> 0x0174, zzela -> 0x016e }
    L_0x00fc:
        r0 = r15.zznep;	 Catch:{ SocketTimeoutException -> 0x0008, IOException -> 0x0174, zzela -> 0x016e }
        r0.zzaq(r5);	 Catch:{ SocketTimeoutException -> 0x0008, IOException -> 0x0174, zzela -> 0x016e }
        goto L_0x0008;	 Catch:{ SocketTimeoutException -> 0x0008, IOException -> 0x0174, zzela -> 0x016e }
    L_0x0103:
        r0 = new com.google.android.gms.internal.zzela;	 Catch:{ SocketTimeoutException -> 0x0008, IOException -> 0x0174, zzela -> 0x016e }
        r1 = "PING frame too long";	 Catch:{ SocketTimeoutException -> 0x0008, IOException -> 0x0174, zzela -> 0x016e }
        r0.<init>(r1);	 Catch:{ SocketTimeoutException -> 0x0008, IOException -> 0x0174, zzela -> 0x016e }
        throw r0;	 Catch:{ SocketTimeoutException -> 0x0008, IOException -> 0x0174, zzela -> 0x016e }
    L_0x010b:
        r0 = new com.google.android.gms.internal.zzela;	 Catch:{ SocketTimeoutException -> 0x0008, IOException -> 0x0174, zzela -> 0x016e }
        r1 = "PING must not fragment across frames";	 Catch:{ SocketTimeoutException -> 0x0008, IOException -> 0x0174, zzela -> 0x016e }
        r0.<init>(r1);	 Catch:{ SocketTimeoutException -> 0x0008, IOException -> 0x0174, zzela -> 0x016e }
        throw r0;	 Catch:{ SocketTimeoutException -> 0x0008, IOException -> 0x0174, zzela -> 0x016e }
    L_0x0113:
        r0 = r15.zzner;	 Catch:{ SocketTimeoutException -> 0x0008, IOException -> 0x0174, zzela -> 0x016e }
        if (r0 == 0) goto L_0x0121;	 Catch:{ SocketTimeoutException -> 0x0008, IOException -> 0x0174, zzela -> 0x016e }
    L_0x0117:
        if (r4 == 0) goto L_0x0121;	 Catch:{ SocketTimeoutException -> 0x0008, IOException -> 0x0174, zzela -> 0x016e }
    L_0x0119:
        r0 = new com.google.android.gms.internal.zzela;	 Catch:{ SocketTimeoutException -> 0x0008, IOException -> 0x0174, zzela -> 0x016e }
        r1 = "Failed to continue outstanding frame";	 Catch:{ SocketTimeoutException -> 0x0008, IOException -> 0x0174, zzela -> 0x016e }
        r0.<init>(r1);	 Catch:{ SocketTimeoutException -> 0x0008, IOException -> 0x0174, zzela -> 0x016e }
        throw r0;	 Catch:{ SocketTimeoutException -> 0x0008, IOException -> 0x0174, zzela -> 0x016e }
    L_0x0121:
        r0 = r15.zzner;	 Catch:{ SocketTimeoutException -> 0x0008, IOException -> 0x0174, zzela -> 0x016e }
        if (r0 != 0) goto L_0x012f;	 Catch:{ SocketTimeoutException -> 0x0008, IOException -> 0x0174, zzela -> 0x016e }
    L_0x0125:
        if (r4 != 0) goto L_0x012f;	 Catch:{ SocketTimeoutException -> 0x0008, IOException -> 0x0174, zzela -> 0x016e }
    L_0x0127:
        r0 = new com.google.android.gms.internal.zzela;	 Catch:{ SocketTimeoutException -> 0x0008, IOException -> 0x0174, zzela -> 0x016e }
        r1 = "Received continuing frame, but there's nothing to continue";	 Catch:{ SocketTimeoutException -> 0x0008, IOException -> 0x0174, zzela -> 0x016e }
        r0.<init>(r1);	 Catch:{ SocketTimeoutException -> 0x0008, IOException -> 0x0174, zzela -> 0x016e }
        throw r0;	 Catch:{ SocketTimeoutException -> 0x0008, IOException -> 0x0174, zzela -> 0x016e }
    L_0x012f:
        r0 = r15.zzner;	 Catch:{ SocketTimeoutException -> 0x0008, IOException -> 0x0174, zzela -> 0x016e }
        if (r0 != 0) goto L_0x0142;	 Catch:{ SocketTimeoutException -> 0x0008, IOException -> 0x0174, zzela -> 0x016e }
    L_0x0133:
        if (r4 != r11) goto L_0x013b;	 Catch:{ SocketTimeoutException -> 0x0008, IOException -> 0x0174, zzela -> 0x016e }
    L_0x0135:
        r0 = new com.google.android.gms.internal.zzeko;	 Catch:{ SocketTimeoutException -> 0x0008, IOException -> 0x0174, zzela -> 0x016e }
        r0.<init>();	 Catch:{ SocketTimeoutException -> 0x0008, IOException -> 0x0174, zzela -> 0x016e }
        goto L_0x0140;	 Catch:{ SocketTimeoutException -> 0x0008, IOException -> 0x0174, zzela -> 0x016e }
    L_0x013b:
        r0 = new com.google.android.gms.internal.zzekq;	 Catch:{ SocketTimeoutException -> 0x0008, IOException -> 0x0174, zzela -> 0x016e }
        r0.<init>();	 Catch:{ SocketTimeoutException -> 0x0008, IOException -> 0x0174, zzela -> 0x016e }
    L_0x0140:
        r15.zzner = r0;	 Catch:{ SocketTimeoutException -> 0x0008, IOException -> 0x0174, zzela -> 0x016e }
    L_0x0142:
        r0 = r15.zzner;	 Catch:{ SocketTimeoutException -> 0x0008, IOException -> 0x0174, zzela -> 0x016e }
        r0 = r0.zzao(r5);	 Catch:{ SocketTimeoutException -> 0x0008, IOException -> 0x0174, zzela -> 0x016e }
        if (r0 != 0) goto L_0x0152;	 Catch:{ SocketTimeoutException -> 0x0008, IOException -> 0x0174, zzela -> 0x016e }
    L_0x014a:
        r0 = new com.google.android.gms.internal.zzela;	 Catch:{ SocketTimeoutException -> 0x0008, IOException -> 0x0174, zzela -> 0x016e }
        r1 = "Failed to decode frame";	 Catch:{ SocketTimeoutException -> 0x0008, IOException -> 0x0174, zzela -> 0x016e }
        r0.<init>(r1);	 Catch:{ SocketTimeoutException -> 0x0008, IOException -> 0x0174, zzela -> 0x016e }
        throw r0;	 Catch:{ SocketTimeoutException -> 0x0008, IOException -> 0x0174, zzela -> 0x016e }
    L_0x0152:
        if (r3 == 0) goto L_0x0008;	 Catch:{ SocketTimeoutException -> 0x0008, IOException -> 0x0174, zzela -> 0x016e }
    L_0x0154:
        r0 = r15.zzner;	 Catch:{ SocketTimeoutException -> 0x0008, IOException -> 0x0174, zzela -> 0x016e }
        r0 = r0.zzcar();	 Catch:{ SocketTimeoutException -> 0x0008, IOException -> 0x0174, zzela -> 0x016e }
        r1 = 0;	 Catch:{ SocketTimeoutException -> 0x0008, IOException -> 0x0174, zzela -> 0x016e }
        r15.zzner = r1;	 Catch:{ SocketTimeoutException -> 0x0008, IOException -> 0x0174, zzela -> 0x016e }
        if (r0 != 0) goto L_0x0167;	 Catch:{ SocketTimeoutException -> 0x0008, IOException -> 0x0174, zzela -> 0x016e }
    L_0x015f:
        r0 = new com.google.android.gms.internal.zzela;	 Catch:{ SocketTimeoutException -> 0x0008, IOException -> 0x0174, zzela -> 0x016e }
        r1 = "Failed to decode whole message";	 Catch:{ SocketTimeoutException -> 0x0008, IOException -> 0x0174, zzela -> 0x016e }
        r0.<init>(r1);	 Catch:{ SocketTimeoutException -> 0x0008, IOException -> 0x0174, zzela -> 0x016e }
        throw r0;	 Catch:{ SocketTimeoutException -> 0x0008, IOException -> 0x0174, zzela -> 0x016e }
    L_0x0167:
        r1 = r15.zzndt;	 Catch:{ SocketTimeoutException -> 0x0008, IOException -> 0x0174, zzela -> 0x016e }
        r1.zza(r0);	 Catch:{ SocketTimeoutException -> 0x0008, IOException -> 0x0174, zzela -> 0x016e }
        goto L_0x0008;
    L_0x016e:
        r0 = move-exception;
        r15.zzc(r0);
        goto L_0x0008;
    L_0x0174:
        r0 = move-exception;
        r1 = new com.google.android.gms.internal.zzela;
        r2 = "IO Error";
        r1.<init>(r2, r0);
        r15.zzc(r1);
        goto L_0x0008;
    L_0x0181:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzeld.run():void");
    }

    final void zza(DataInputStream dataInputStream) {
        this.zzneo = dataInputStream;
    }

    final void zzcba() {
        this.zznes = true;
    }
}
