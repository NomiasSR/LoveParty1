package com.google.android.gms.internal;

import android.net.SSLCertificateSocketFactory;
import android.net.SSLSessionCache;
import android.support.annotation.Nullable;
import com.bumptech.glide.load.Key;
import java.io.File;
import java.lang.Thread.State;
import java.net.Socket;
import java.net.URI;
import java.nio.charset.Charset;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocket;

public final class zzeku {
    private static final AtomicInteger zzndq = new AtomicInteger(0);
    private static final Charset zzndr = Charset.forName(Key.STRING_CHARSET_NAME);
    private static ThreadFactory zzndz = Executors.defaultThreadFactory();
    private static zzekt zznea = new zzekv();
    private volatile Socket socket = null;
    private final int zzfny = zzndq.incrementAndGet();
    private final zzejc zzmlr;
    @Nullable
    private final String zzmnu;
    private volatile int zznds = zzeky.zzned;
    private zzekz zzndt = null;
    private final URI zzndu;
    private final zzeld zzndv;
    private final zzele zzndw;
    private final zzelb zzndx;
    private final Thread zzndy = zzndz.newThread(new zzekw(this));

    public zzeku(zzebi com_google_android_gms_internal_zzebi, URI uri, String str, Map<String, String> map) {
        this.zzndu = uri;
        this.zzmnu = com_google_android_gms_internal_zzebi.zzbug();
        int i = this.zzfny;
        StringBuilder stringBuilder = new StringBuilder(14);
        stringBuilder.append("sk_");
        stringBuilder.append(i);
        this.zzmlr = new zzejc(com_google_android_gms_internal_zzebi.zzbub(), "WebSocket", stringBuilder.toString());
        this.zzndx = new zzelb(uri, null, map);
        this.zzndv = new zzeld(this);
        this.zzndw = new zzele(this, "TubeSock", this.zzfny);
    }

    private final Socket createSocket() {
        String str;
        StringBuilder stringBuilder;
        String scheme = this.zzndu.getScheme();
        String host = this.zzndu.getHost();
        int port = this.zzndu.getPort();
        String valueOf;
        if (scheme != null && scheme.equals("ws")) {
            if (port == -1) {
                port = 80;
            }
            try {
                return new Socket(host, port);
            } catch (Throwable e) {
                str = "unknown host: ";
                host = String.valueOf(host);
                throw new zzela(host.length() != 0 ? str.concat(host) : new String(str), e);
            } catch (Throwable e2) {
                valueOf = String.valueOf(this.zzndu);
                stringBuilder = new StringBuilder(31 + String.valueOf(valueOf).length());
                stringBuilder.append("error while creating socket to ");
                stringBuilder.append(valueOf);
                throw new zzela(stringBuilder.toString(), e2);
            }
        } else if (scheme == null || !scheme.equals("wss")) {
            valueOf = "unsupported protocol: ";
            scheme = String.valueOf(scheme);
            throw new zzela(scheme.length() != 0 ? valueOf.concat(scheme) : new String(valueOf));
        } else {
            if (port == -1) {
                port = 443;
            }
            SSLSessionCache sSLSessionCache = null;
            try {
                if (this.zzmnu != null) {
                    sSLSessionCache = new SSLSessionCache(new File(this.zzmnu));
                }
            } catch (Throwable e3) {
                this.zzmlr.zzb("Failed to initialize SSL session cache", e3, new Object[0]);
            }
            try {
                SSLSocket sSLSocket = (SSLSocket) SSLCertificateSocketFactory.getDefault(60000, sSLSessionCache).createSocket(host, port);
                if (HttpsURLConnection.getDefaultHostnameVerifier().verify(host, sSLSocket.getSession())) {
                    return sSLSocket;
                }
                valueOf = String.valueOf(this.zzndu);
                stringBuilder = new StringBuilder(39 + String.valueOf(valueOf).length());
                stringBuilder.append("Error while verifying secure socket to ");
                stringBuilder.append(valueOf);
                throw new zzela(stringBuilder.toString());
            } catch (Throwable e22) {
                str = "unknown host: ";
                host = String.valueOf(host);
                throw new zzela(host.length() != 0 ? str.concat(host) : new String(str), e22);
            } catch (Throwable e222) {
                valueOf = String.valueOf(this.zzndu);
                stringBuilder = new StringBuilder(38 + String.valueOf(valueOf).length());
                stringBuilder.append("error while creating secure socket to ");
                stringBuilder.append(valueOf);
                throw new zzela(stringBuilder.toString(), e222);
            }
        }
    }

    static ThreadFactory getThreadFactory() {
        return zzndz;
    }

    private final synchronized void zza(byte b, byte[] bArr) {
        if (this.zznds != zzeky.zznef) {
            this.zzndt.zza(new zzela("error while sending data: not connected"));
            return;
        }
        try {
            this.zzndw.zza(b, true, bArr);
        } catch (Throwable e) {
            this.zzndt.zza(new zzela("Failed to send frame", e));
            close();
        }
    }

    static zzekt zzcas() {
        return zznea;
    }

    private final synchronized void zzcav() {
        if (this.zznds != zzeky.zzneh) {
            this.zzndv.zzcba();
            this.zzndw.zzcbc();
            if (this.socket != null) {
                try {
                    this.socket.close();
                } catch (Throwable e) {
                    throw new RuntimeException(e);
                }
            }
            this.zznds = zzeky.zzneh;
            this.zzndt.onClose();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzcax() {
        /*
        r11 = this;
        r0 = r11.createSocket();	 Catch:{ zzela -> 0x01b4, IOException -> 0x018a }
        monitor-enter(r11);	 Catch:{ zzela -> 0x01b4, IOException -> 0x018a }
        r11.socket = r0;	 Catch:{ all -> 0x0185 }
        r1 = r11.zznds;	 Catch:{ all -> 0x0185 }
        r2 = com.google.android.gms.internal.zzeky.zzneh;	 Catch:{ all -> 0x0185 }
        if (r1 != r2) goto L_0x0021;
    L_0x000d:
        r0 = r11.socket;	 Catch:{ IOException -> 0x001a }
        r0.close();	 Catch:{ IOException -> 0x001a }
        r0 = 0;
        r11.socket = r0;	 Catch:{ all -> 0x0185 }
        monitor-exit(r11);	 Catch:{ all -> 0x0185 }
        r11.close();
        return;
    L_0x001a:
        r0 = move-exception;
        r1 = new java.lang.RuntimeException;	 Catch:{ all -> 0x0185 }
        r1.<init>(r0);	 Catch:{ all -> 0x0185 }
        throw r1;	 Catch:{ all -> 0x0185 }
    L_0x0021:
        monitor-exit(r11);	 Catch:{ all -> 0x0185 }
        r1 = new java.io.DataInputStream;	 Catch:{ zzela -> 0x01b4, IOException -> 0x018a }
        r2 = r0.getInputStream();	 Catch:{ zzela -> 0x01b4, IOException -> 0x018a }
        r1.<init>(r2);	 Catch:{ zzela -> 0x01b4, IOException -> 0x018a }
        r0 = r0.getOutputStream();	 Catch:{ zzela -> 0x01b4, IOException -> 0x018a }
        r2 = r11.zzndx;	 Catch:{ zzela -> 0x01b4, IOException -> 0x018a }
        r2 = r2.zzcay();	 Catch:{ zzela -> 0x01b4, IOException -> 0x018a }
        r0.write(r2);	 Catch:{ zzela -> 0x01b4, IOException -> 0x018a }
        r2 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r3 = new byte[r2];	 Catch:{ zzela -> 0x01b4, IOException -> 0x018a }
        r4 = new java.util.ArrayList;	 Catch:{ zzela -> 0x01b4, IOException -> 0x018a }
        r4.<init>();	 Catch:{ zzela -> 0x01b4, IOException -> 0x018a }
        r5 = 0;
        r6 = r3;
        r3 = r5;
        r7 = r3;
    L_0x0045:
        r8 = 1;
        if (r3 != 0) goto L_0x00b1;
    L_0x0048:
        r9 = r1.read();	 Catch:{ zzela -> 0x01b4, IOException -> 0x018a }
        r10 = -1;
        if (r9 != r10) goto L_0x0057;
    L_0x004f:
        r0 = new com.google.android.gms.internal.zzela;	 Catch:{ zzela -> 0x01b4, IOException -> 0x018a }
        r1 = "Connection closed before handshake was complete";
        r0.<init>(r1);	 Catch:{ zzela -> 0x01b4, IOException -> 0x018a }
        throw r0;	 Catch:{ zzela -> 0x01b4, IOException -> 0x018a }
    L_0x0057:
        r9 = (byte) r9;	 Catch:{ zzela -> 0x01b4, IOException -> 0x018a }
        r6[r7] = r9;	 Catch:{ zzela -> 0x01b4, IOException -> 0x018a }
        r7 = r7 + 1;
        r9 = r7 + -1;
        r9 = r6[r9];	 Catch:{ zzela -> 0x01b4, IOException -> 0x018a }
        r10 = 10;
        if (r9 != r10) goto L_0x008c;
    L_0x0064:
        r9 = r7 + -2;
        r9 = r6[r9];	 Catch:{ zzela -> 0x01b4, IOException -> 0x018a }
        r10 = 13;
        if (r9 != r10) goto L_0x008c;
    L_0x006c:
        r7 = new java.lang.String;	 Catch:{ zzela -> 0x01b4, IOException -> 0x018a }
        r9 = zzndr;	 Catch:{ zzela -> 0x01b4, IOException -> 0x018a }
        r7.<init>(r6, r9);	 Catch:{ zzela -> 0x01b4, IOException -> 0x018a }
        r6 = r7.trim();	 Catch:{ zzela -> 0x01b4, IOException -> 0x018a }
        r9 = "";
        r6 = r6.equals(r9);	 Catch:{ zzela -> 0x01b4, IOException -> 0x018a }
        if (r6 == 0) goto L_0x0081;
    L_0x007f:
        r3 = r8;
        goto L_0x0088;
    L_0x0081:
        r6 = r7.trim();	 Catch:{ zzela -> 0x01b4, IOException -> 0x018a }
        r4.add(r6);	 Catch:{ zzela -> 0x01b4, IOException -> 0x018a }
    L_0x0088:
        r6 = new byte[r2];	 Catch:{ zzela -> 0x01b4, IOException -> 0x018a }
        r7 = r5;
        goto L_0x0045;
    L_0x008c:
        if (r7 != r2) goto L_0x0045;
    L_0x008e:
        r0 = new java.lang.String;	 Catch:{ zzela -> 0x01b4, IOException -> 0x018a }
        r1 = zzndr;	 Catch:{ zzela -> 0x01b4, IOException -> 0x018a }
        r0.<init>(r6, r1);	 Catch:{ zzela -> 0x01b4, IOException -> 0x018a }
        r1 = new com.google.android.gms.internal.zzela;	 Catch:{ zzela -> 0x01b4, IOException -> 0x018a }
        r2 = "Unexpected long line in handshake: ";
        r0 = java.lang.String.valueOf(r0);	 Catch:{ zzela -> 0x01b4, IOException -> 0x018a }
        r3 = r0.length();	 Catch:{ zzela -> 0x01b4, IOException -> 0x018a }
        if (r3 == 0) goto L_0x00a8;
    L_0x00a3:
        r0 = r2.concat(r0);	 Catch:{ zzela -> 0x01b4, IOException -> 0x018a }
        goto L_0x00ad;
    L_0x00a8:
        r0 = new java.lang.String;	 Catch:{ zzela -> 0x01b4, IOException -> 0x018a }
        r0.<init>(r2);	 Catch:{ zzela -> 0x01b4, IOException -> 0x018a }
    L_0x00ad:
        r1.<init>(r0);	 Catch:{ zzela -> 0x01b4, IOException -> 0x018a }
        throw r1;	 Catch:{ zzela -> 0x01b4, IOException -> 0x018a }
    L_0x00b1:
        r2 = r4.get(r5);	 Catch:{ zzela -> 0x01b4, IOException -> 0x018a }
        r2 = (java.lang.String) r2;	 Catch:{ zzela -> 0x01b4, IOException -> 0x018a }
        r3 = 9;
        r6 = 12;
        r2 = r2.substring(r3, r6);	 Catch:{ zzela -> 0x01b4, IOException -> 0x018a }
        r2 = java.lang.Integer.valueOf(r2);	 Catch:{ zzela -> 0x01b4, IOException -> 0x018a }
        r2 = r2.intValue();	 Catch:{ zzela -> 0x01b4, IOException -> 0x018a }
        r3 = 407; // 0x197 float:5.7E-43 double:2.01E-321;
        if (r2 != r3) goto L_0x00d3;
    L_0x00cb:
        r0 = new com.google.android.gms.internal.zzela;	 Catch:{ zzela -> 0x01b4, IOException -> 0x018a }
        r1 = "connection failed: proxy authentication not supported";
        r0.<init>(r1);	 Catch:{ zzela -> 0x01b4, IOException -> 0x018a }
        throw r0;	 Catch:{ zzela -> 0x01b4, IOException -> 0x018a }
    L_0x00d3:
        r3 = 404; // 0x194 float:5.66E-43 double:1.996E-321;
        if (r2 != r3) goto L_0x00df;
    L_0x00d7:
        r0 = new com.google.android.gms.internal.zzela;	 Catch:{ zzela -> 0x01b4, IOException -> 0x018a }
        r1 = "connection failed: 404 not found";
        r0.<init>(r1);	 Catch:{ zzela -> 0x01b4, IOException -> 0x018a }
        throw r0;	 Catch:{ zzela -> 0x01b4, IOException -> 0x018a }
    L_0x00df:
        r3 = 101; // 0x65 float:1.42E-43 double:5.0E-322;
        if (r2 == r3) goto L_0x00fc;
    L_0x00e3:
        r0 = new com.google.android.gms.internal.zzela;	 Catch:{ zzela -> 0x01b4, IOException -> 0x018a }
        r1 = 50;
        r3 = new java.lang.StringBuilder;	 Catch:{ zzela -> 0x01b4, IOException -> 0x018a }
        r3.<init>(r1);	 Catch:{ zzela -> 0x01b4, IOException -> 0x018a }
        r1 = "connection failed: unknown status code ";
        r3.append(r1);	 Catch:{ zzela -> 0x01b4, IOException -> 0x018a }
        r3.append(r2);	 Catch:{ zzela -> 0x01b4, IOException -> 0x018a }
        r1 = r3.toString();	 Catch:{ zzela -> 0x01b4, IOException -> 0x018a }
        r0.<init>(r1);	 Catch:{ zzela -> 0x01b4, IOException -> 0x018a }
        throw r0;	 Catch:{ zzela -> 0x01b4, IOException -> 0x018a }
    L_0x00fc:
        r4.remove(r5);	 Catch:{ zzela -> 0x01b4, IOException -> 0x018a }
        r2 = new java.util.HashMap;	 Catch:{ zzela -> 0x01b4, IOException -> 0x018a }
        r2.<init>();	 Catch:{ zzela -> 0x01b4, IOException -> 0x018a }
        r4 = (java.util.ArrayList) r4;	 Catch:{ zzela -> 0x01b4, IOException -> 0x018a }
        r3 = r4.size();	 Catch:{ zzela -> 0x01b4, IOException -> 0x018a }
        r6 = r5;
    L_0x010b:
        if (r6 >= r3) goto L_0x0124;
    L_0x010d:
        r7 = r4.get(r6);	 Catch:{ zzela -> 0x01b4, IOException -> 0x018a }
        r6 = r6 + 1;
        r7 = (java.lang.String) r7;	 Catch:{ zzela -> 0x01b4, IOException -> 0x018a }
        r9 = ": ";
        r10 = 2;
        r7 = r7.split(r9, r10);	 Catch:{ zzela -> 0x01b4, IOException -> 0x018a }
        r9 = r7[r5];	 Catch:{ zzela -> 0x01b4, IOException -> 0x018a }
        r7 = r7[r8];	 Catch:{ zzela -> 0x01b4, IOException -> 0x018a }
        r2.put(r9, r7);	 Catch:{ zzela -> 0x01b4, IOException -> 0x018a }
        goto L_0x010b;
    L_0x0124:
        r3 = "Upgrade";
        r3 = r2.get(r3);	 Catch:{ zzela -> 0x01b4, IOException -> 0x018a }
        r3 = (java.lang.String) r3;	 Catch:{ zzela -> 0x01b4, IOException -> 0x018a }
        r4 = java.util.Locale.US;	 Catch:{ zzela -> 0x01b4, IOException -> 0x018a }
        r3 = r3.toLowerCase(r4);	 Catch:{ zzela -> 0x01b4, IOException -> 0x018a }
        r4 = "websocket";
        r3 = r3.equals(r4);	 Catch:{ zzela -> 0x01b4, IOException -> 0x018a }
        if (r3 != 0) goto L_0x0142;
    L_0x013a:
        r0 = new com.google.android.gms.internal.zzela;	 Catch:{ zzela -> 0x01b4, IOException -> 0x018a }
        r1 = "connection failed: missing header field in server handshake: Upgrade";
        r0.<init>(r1);	 Catch:{ zzela -> 0x01b4, IOException -> 0x018a }
        throw r0;	 Catch:{ zzela -> 0x01b4, IOException -> 0x018a }
    L_0x0142:
        r3 = "Connection";
        r2 = r2.get(r3);	 Catch:{ zzela -> 0x01b4, IOException -> 0x018a }
        r2 = (java.lang.String) r2;	 Catch:{ zzela -> 0x01b4, IOException -> 0x018a }
        r3 = java.util.Locale.US;	 Catch:{ zzela -> 0x01b4, IOException -> 0x018a }
        r2 = r2.toLowerCase(r3);	 Catch:{ zzela -> 0x01b4, IOException -> 0x018a }
        r3 = "upgrade";
        r2 = r2.equals(r3);	 Catch:{ zzela -> 0x01b4, IOException -> 0x018a }
        if (r2 != 0) goto L_0x0160;
    L_0x0158:
        r0 = new com.google.android.gms.internal.zzela;	 Catch:{ zzela -> 0x01b4, IOException -> 0x018a }
        r1 = "connection failed: missing header field in server handshake: Connection";
        r0.<init>(r1);	 Catch:{ zzela -> 0x01b4, IOException -> 0x018a }
        throw r0;	 Catch:{ zzela -> 0x01b4, IOException -> 0x018a }
    L_0x0160:
        r2 = r11.zzndw;	 Catch:{ zzela -> 0x01b4, IOException -> 0x018a }
        r2.zzb(r0);	 Catch:{ zzela -> 0x01b4, IOException -> 0x018a }
        r0 = r11.zzndv;	 Catch:{ zzela -> 0x01b4, IOException -> 0x018a }
        r0.zza(r1);	 Catch:{ zzela -> 0x01b4, IOException -> 0x018a }
        r0 = com.google.android.gms.internal.zzeky.zznef;	 Catch:{ zzela -> 0x01b4, IOException -> 0x018a }
        r11.zznds = r0;	 Catch:{ zzela -> 0x01b4, IOException -> 0x018a }
        r0 = r11.zzndw;	 Catch:{ zzela -> 0x01b4, IOException -> 0x018a }
        r0 = r0.zzcbe();	 Catch:{ zzela -> 0x01b4, IOException -> 0x018a }
        r0.start();	 Catch:{ zzela -> 0x01b4, IOException -> 0x018a }
        r0 = r11.zzndt;	 Catch:{ zzela -> 0x01b4, IOException -> 0x018a }
        r0.zzbvg();	 Catch:{ zzela -> 0x01b4, IOException -> 0x018a }
        r0 = r11.zzndv;	 Catch:{ zzela -> 0x01b4, IOException -> 0x018a }
        r0.run();	 Catch:{ zzela -> 0x01b4, IOException -> 0x018a }
        r11.close();
        return;
    L_0x0185:
        r0 = move-exception;
        monitor-exit(r11);	 Catch:{ all -> 0x0185 }
        throw r0;	 Catch:{ zzela -> 0x01b4, IOException -> 0x018a }
    L_0x0188:
        r0 = move-exception;
        goto L_0x01be;
    L_0x018a:
        r0 = move-exception;
        r1 = r11.zzndt;	 Catch:{ all -> 0x0188 }
        r2 = new com.google.android.gms.internal.zzela;	 Catch:{ all -> 0x0188 }
        r3 = "error while connecting: ";
        r4 = r0.getMessage();	 Catch:{ all -> 0x0188 }
        r4 = java.lang.String.valueOf(r4);	 Catch:{ all -> 0x0188 }
        r5 = r4.length();	 Catch:{ all -> 0x0188 }
        if (r5 == 0) goto L_0x01a4;
    L_0x019f:
        r3 = r3.concat(r4);	 Catch:{ all -> 0x0188 }
        goto L_0x01aa;
    L_0x01a4:
        r4 = new java.lang.String;	 Catch:{ all -> 0x0188 }
        r4.<init>(r3);	 Catch:{ all -> 0x0188 }
        r3 = r4;
    L_0x01aa:
        r2.<init>(r3, r0);	 Catch:{ all -> 0x0188 }
        r1.zza(r2);	 Catch:{ all -> 0x0188 }
        r11.close();
        return;
    L_0x01b4:
        r0 = move-exception;
        r1 = r11.zzndt;	 Catch:{ all -> 0x0188 }
        r1.zza(r0);	 Catch:{ all -> 0x0188 }
        r11.close();
        return;
    L_0x01be:
        r11.close();
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzeku.zzcax():void");
    }

    public final synchronized void close() {
        switch (zzekx.zznec[this.zznds - 1]) {
            case 1:
                this.zznds = zzeky.zzneh;
                return;
            case 2:
                zzcav();
                return;
            case 3:
                try {
                    this.zznds = zzeky.zzneg;
                    this.zzndw.zzcbc();
                    this.zzndw.zza((byte) 8, true, new byte[0]);
                    return;
                } catch (Throwable e) {
                    this.zzndt.zza(new zzela("Failed to send close frame", e));
                    return;
                }
            case 4:
                return;
            case 5:
                return;
            default:
                return;
        }
    }

    public final synchronized void connect() {
        if (this.zznds != zzeky.zzned) {
            this.zzndt.zza(new zzela("connect() already called"));
            close();
            return;
        }
        zzekt com_google_android_gms_internal_zzekt = zznea;
        Thread thread = this.zzndy;
        String str = "TubeSockReader-";
        int i = this.zzfny;
        StringBuilder stringBuilder = new StringBuilder(11 + String.valueOf(str).length());
        stringBuilder.append(str);
        stringBuilder.append(i);
        com_google_android_gms_internal_zzekt.zza(thread, stringBuilder.toString());
        this.zznds = zzeky.zznee;
        this.zzndy.start();
    }

    public final void zza(zzekz com_google_android_gms_internal_zzekz) {
        this.zzndt = com_google_android_gms_internal_zzekz;
    }

    final synchronized void zzaq(byte[] bArr) {
        zza((byte) 10, bArr);
    }

    final void zzb(zzela com_google_android_gms_internal_zzela) {
        this.zzndt.zza(com_google_android_gms_internal_zzela);
        if (this.zznds == zzeky.zznef) {
            close();
        }
        zzcav();
    }

    final zzekz zzcat() {
        return this.zzndt;
    }

    final void zzcau() {
        zzcav();
    }

    public final void zzcaw() throws InterruptedException {
        if (this.zzndw.zzcbe().getState() != State.NEW) {
            this.zzndw.zzcbe().join();
        }
        this.zzndy.join();
    }

    public final synchronized void zzps(String str) {
        zza((byte) 1, str.getBytes(zzndr));
    }
}
