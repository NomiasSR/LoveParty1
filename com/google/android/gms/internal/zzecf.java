package com.google.android.gms.internal;

import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

final class zzecf {
    private static long zzmpu;
    private final ScheduledExecutorService zzmlf;
    private final zzejc zzmlr;
    private zzecj zzmpv;
    private boolean zzmpw = false;
    private boolean zzmpx = false;
    private long zzmpy = 0;
    private zzecs zzmpz;
    private zzeci zzmqa;
    private ScheduledFuture<?> zzmqb;
    private ScheduledFuture<?> zzmqc;
    private final zzebi zzmqd;

    public zzecf(zzebi com_google_android_gms_internal_zzebi, zzebk com_google_android_gms_internal_zzebk, String str, zzeci com_google_android_gms_internal_zzeci, String str2) {
        this.zzmqd = com_google_android_gms_internal_zzebi;
        this.zzmlf = com_google_android_gms_internal_zzebi.zzbud();
        this.zzmqa = com_google_android_gms_internal_zzeci;
        long j = zzmpu;
        zzmpu = 1 + j;
        StringBuilder stringBuilder = new StringBuilder(23);
        stringBuilder.append("ws_");
        stringBuilder.append(j);
        this.zzmlr = new zzejc(com_google_android_gms_internal_zzebi.zzbub(), "WebSocket", stringBuilder.toString());
        if (str == null) {
            str = com_google_android_gms_internal_zzebk.getHost();
        }
        boolean isSecure = com_google_android_gms_internal_zzebk.isSecure();
        String namespace = com_google_android_gms_internal_zzebk.getNamespace();
        String str3 = isSecure ? "wss" : "ws";
        String str4 = "v";
        String str5 = "5";
        StringBuilder stringBuilder2 = new StringBuilder(((((13 + String.valueOf(str3).length()) + String.valueOf(str).length()) + String.valueOf(namespace).length()) + String.valueOf(str4).length()) + String.valueOf(str5).length());
        stringBuilder2.append(str3);
        stringBuilder2.append("://");
        stringBuilder2.append(str);
        stringBuilder2.append("/.ws?ns=");
        stringBuilder2.append(namespace);
        stringBuilder2.append("&");
        stringBuilder2.append(str4);
        stringBuilder2.append("=");
        stringBuilder2.append(str5);
        str3 = stringBuilder2.toString();
        if (str2 != null) {
            str3 = String.valueOf(str3);
            namespace = "&ls=";
            StringBuilder stringBuilder3 = new StringBuilder((String.valueOf(str3).length() + String.valueOf(namespace).length()) + String.valueOf(str2).length());
            stringBuilder3.append(str3);
            stringBuilder3.append(namespace);
            stringBuilder3.append(str2);
            str3 = stringBuilder3.toString();
        }
        URI create = URI.create(str3);
        Map hashMap = new HashMap();
        hashMap.put("User-Agent", this.zzmqd.zzbuf());
        this.zzmpv = new zzeck(this, new zzeku(this.zzmqd, create, null, hashMap), null);
    }

    private final void shutdown() {
        this.zzmpx = true;
        this.zzmqa.zzck(this.zzmpw);
    }

    private final void zzbvd() {
        if (!this.zzmpx) {
            zzejc com_google_android_gms_internal_zzejc;
            String stringBuilder;
            if (this.zzmqb != null) {
                this.zzmqb.cancel(false);
                if (this.zzmlr.zzbzl()) {
                    com_google_android_gms_internal_zzejc = this.zzmlr;
                    long delay = this.zzmqb.getDelay(TimeUnit.MILLISECONDS);
                    StringBuilder stringBuilder2 = new StringBuilder(48);
                    stringBuilder2.append("Reset keepAlive. Remaining: ");
                    stringBuilder2.append(delay);
                    stringBuilder = stringBuilder2.toString();
                }
                this.zzmqb = this.zzmlf.schedule(new zzech(this), 45000, TimeUnit.MILLISECONDS);
            }
            if (this.zzmlr.zzbzl()) {
                com_google_android_gms_internal_zzejc = this.zzmlr;
                stringBuilder = "Reset keepAlive";
            }
            this.zzmqb = this.zzmlf.schedule(new zzech(this), 45000, TimeUnit.MILLISECONDS);
            com_google_android_gms_internal_zzejc.zzb(stringBuilder, null, new Object[0]);
            this.zzmqb = this.zzmlf.schedule(new zzech(this), 45000, TimeUnit.MILLISECONDS);
        }
    }

    private final void zzbve() {
        if (!this.zzmpx) {
            if (this.zzmlr.zzbzl()) {
                this.zzmlr.zzb("closing itself", null, new Object[0]);
            }
            shutdown();
        }
        this.zzmpv = null;
        if (this.zzmqb != null) {
            this.zzmqb.cancel(false);
        }
    }

    private final void zzbvf() {
        if (!this.zzmpw && !this.zzmpx) {
            if (this.zzmlr.zzbzl()) {
                this.zzmlr.zzb("timed out on connect", null, new Object[0]);
            }
            this.zzmpv.close();
        }
    }

    private final void zzgq(int i) {
        this.zzmpy = (long) i;
        this.zzmpz = new zzecs();
        if (this.zzmlr.zzbzl()) {
            zzejc com_google_android_gms_internal_zzejc = this.zzmlr;
            long j = this.zzmpy;
            StringBuilder stringBuilder = new StringBuilder(41);
            stringBuilder.append("HandleNewFrameCount: ");
            stringBuilder.append(j);
            com_google_android_gms_internal_zzejc.zzb(stringBuilder.toString(), null, new Object[0]);
        }
    }

    private final void zzpp(String str) {
        String valueOf;
        zzejc com_google_android_gms_internal_zzejc;
        String str2;
        this.zzmpz.zzpt(str);
        this.zzmpy--;
        if (this.zzmpy == 0) {
            try {
                this.zzmpz.zzbvl();
                Map zzqb = zzelh.zzqb(this.zzmpz.toString());
                this.zzmpz = null;
                if (this.zzmlr.zzbzl()) {
                    zzejc com_google_android_gms_internal_zzejc2 = this.zzmlr;
                    valueOf = String.valueOf(zzqb);
                    StringBuilder stringBuilder = new StringBuilder(36 + String.valueOf(valueOf).length());
                    stringBuilder.append("handleIncomingFrame complete frame: ");
                    stringBuilder.append(valueOf);
                    com_google_android_gms_internal_zzejc2.zzb(stringBuilder.toString(), null, new Object[0]);
                }
                this.zzmqa.zzag(zzqb);
            } catch (Throwable e) {
                com_google_android_gms_internal_zzejc = this.zzmlr;
                str2 = "Error parsing frame: ";
                valueOf = String.valueOf(this.zzmpz.toString());
                com_google_android_gms_internal_zzejc.zzd(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2), e);
                close();
                shutdown();
            } catch (Throwable e2) {
                com_google_android_gms_internal_zzejc = this.zzmlr;
                str2 = "Error parsing frame (cast error): ";
                valueOf = String.valueOf(this.zzmpz.toString());
                com_google_android_gms_internal_zzejc.zzd(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2), e2);
                close();
                shutdown();
            }
        }
    }

    private final java.lang.String zzpq(java.lang.String r3) {
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
        r2 = this;
        r0 = r3.length();
        r1 = 6;
        if (r0 > r1) goto L_0x0012;
    L_0x0007:
        r0 = java.lang.Integer.parseInt(r3);	 Catch:{ NumberFormatException -> 0x0012 }
        if (r0 <= 0) goto L_0x0010;	 Catch:{ NumberFormatException -> 0x0012 }
    L_0x000d:
        r2.zzgq(r0);	 Catch:{ NumberFormatException -> 0x0012 }
    L_0x0010:
        r3 = 0;
        return r3;
    L_0x0012:
        r0 = 1;
        r2.zzgq(r0);
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzecf.zzpq(java.lang.String):java.lang.String");
    }

    private final void zzpr(String str) {
        if (!this.zzmpx) {
            zzbvd();
            if ((this.zzmpz != null ? 1 : null) != null) {
                zzpp(str);
                return;
            }
            str = zzpq(str);
            if (str != null) {
                zzpp(str);
            }
        }
    }

    public final void close() {
        if (this.zzmlr.zzbzl()) {
            this.zzmlr.zzb("websocket is being closed", null, new Object[0]);
        }
        this.zzmpx = true;
        this.zzmpv.close();
        if (this.zzmqc != null) {
            this.zzmqc.cancel(true);
        }
        if (this.zzmqb != null) {
            this.zzmqb.cancel(true);
        }
    }

    public final void open() {
        this.zzmpv.connect();
        this.zzmqc = this.zzmlf.schedule(new zzecg(this), 30000, TimeUnit.MILLISECONDS);
    }

    public final void send(Map<String, Object> map) {
        zzbvd();
        try {
            String[] strArr;
            int i;
            String zzbt = zzelh.zzbt(map);
            int i2 = 0;
            if (zzbt.length() <= 16384) {
                strArr = new String[]{zzbt};
            } else {
                ArrayList arrayList = new ArrayList();
                i = 0;
                while (i < zzbt.length()) {
                    int i3 = i + 16384;
                    arrayList.add(zzbt.substring(i, Math.min(i3, zzbt.length())));
                    i = i3;
                }
                strArr = (String[]) arrayList.toArray(new String[arrayList.size()]);
            }
            if (strArr.length > 1) {
                zzecj com_google_android_gms_internal_zzecj = this.zzmpv;
                i = strArr.length;
                StringBuilder stringBuilder = new StringBuilder(11);
                stringBuilder.append(i);
                com_google_android_gms_internal_zzecj.zzps(stringBuilder.toString());
            }
            while (i2 < strArr.length) {
                this.zzmpv.zzps(strArr[i2]);
                i2++;
            }
        } catch (Throwable e) {
            zzejc com_google_android_gms_internal_zzejc = this.zzmlr;
            String str = "Failed to serialize message: ";
            String valueOf = String.valueOf(map.toString());
            com_google_android_gms_internal_zzejc.zzd(valueOf.length() != 0 ? str.concat(valueOf) : new String(str), e);
            shutdown();
        }
    }
}
