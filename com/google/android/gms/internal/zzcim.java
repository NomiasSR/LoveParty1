package com.google.android.gms.internal;

import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.provider.Settings.Secure;
import android.support.annotation.WorkerThread;
import android.support.v7.widget.helper.ItemTouchHelper.Callback;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.common.api.internal.zzbz;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.common.util.zzd;
import com.google.android.gms.common.util.zzh;
import com.google.android.gms.measurement.AppMeasurement;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.analytics.FirebaseAnalytics.Event;
import com.google.firebase.analytics.FirebaseAnalytics.Param;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;

public class zzcim {
    private static volatile zzcim zzjev;
    private final Context mContext;
    private final zzd zzata;
    private boolean zzdtb = false;
    private final zzcgn zzjew;
    private final zzchx zzjex;
    private final zzchm zzjey;
    private final zzcih zzjez;
    private final zzclf zzjfa;
    private final zzcig zzjfb;
    private final AppMeasurement zzjfc;
    private final FirebaseAnalytics zzjfd;
    private final zzclq zzjfe;
    private final zzchk zzjff;
    private final zzcgo zzjfg;
    private final zzchi zzjfh;
    private final zzchq zzjfi;
    private final zzckc zzjfj;
    private final zzckg zzjfk;
    private final zzcgu zzjfl;
    private final zzcjn zzjfm;
    private final zzchh zzjfn;
    private final zzchv zzjfo;
    private final zzcll zzjfp;
    private final zzcgk zzjfq;
    private final zzcgd zzjfr;
    private boolean zzjfs;
    private Boolean zzjft;
    private long zzjfu;
    private FileLock zzjfv;
    private FileChannel zzjfw;
    private List<Long> zzjfx;
    private List<Runnable> zzjfy;
    private int zzjfz;
    private int zzjga;
    private long zzjgb;
    private long zzjgc;
    private boolean zzjgd;
    private boolean zzjge;
    private boolean zzjgf;
    private final long zzjgg;

    class zza implements zzcgq {
        List<zzcmb> zzapa;
        private /* synthetic */ zzcim zzjgh;
        zzcme zzjgi;
        List<Long> zzjgj;
        private long zzjgk;

        private zza(zzcim com_google_android_gms_internal_zzcim) {
            this.zzjgh = com_google_android_gms_internal_zzcim;
        }

        private static long zza(zzcmb com_google_android_gms_internal_zzcmb) {
            return ((com_google_android_gms_internal_zzcmb.zzjli.longValue() / 1000) / 60) / 60;
        }

        public final boolean zza(long j, zzcmb com_google_android_gms_internal_zzcmb) {
            zzbq.checkNotNull(com_google_android_gms_internal_zzcmb);
            if (this.zzapa == null) {
                this.zzapa = new ArrayList();
            }
            if (this.zzjgj == null) {
                this.zzjgj = new ArrayList();
            }
            if (this.zzapa.size() > 0 && zza((zzcmb) this.zzapa.get(0)) != zza(com_google_android_gms_internal_zzcmb)) {
                return false;
            }
            long zzho = this.zzjgk + ((long) com_google_android_gms_internal_zzcmb.zzho());
            if (zzho >= ((long) Math.max(0, ((Integer) zzchc.zzjal.get()).intValue()))) {
                return false;
            }
            this.zzjgk = zzho;
            this.zzapa.add(com_google_android_gms_internal_zzcmb);
            this.zzjgj.add(Long.valueOf(j));
            return this.zzapa.size() < Math.max(1, ((Integer) zzchc.zzjam.get()).intValue());
        }

        public final void zzb(zzcme com_google_android_gms_internal_zzcme) {
            zzbq.checkNotNull(com_google_android_gms_internal_zzcme);
            this.zzjgi = com_google_android_gms_internal_zzcme;
        }
    }

    private zzcim(zzcjm com_google_android_gms_internal_zzcjm) {
        zzcho zzazj;
        String str;
        zzbq.checkNotNull(com_google_android_gms_internal_zzcjm);
        this.mContext = com_google_android_gms_internal_zzcjm.mContext;
        this.zzjgb = -1;
        this.zzata = zzh.zzamg();
        this.zzjgg = this.zzata.currentTimeMillis();
        this.zzjew = new zzcgn(this);
        zzcjl com_google_android_gms_internal_zzchx = new zzchx(this);
        com_google_android_gms_internal_zzchx.initialize();
        this.zzjex = com_google_android_gms_internal_zzchx;
        com_google_android_gms_internal_zzchx = new zzchm(this);
        com_google_android_gms_internal_zzchx.initialize();
        this.zzjey = com_google_android_gms_internal_zzchx;
        com_google_android_gms_internal_zzchx = new zzclq(this);
        com_google_android_gms_internal_zzchx.initialize();
        this.zzjfe = com_google_android_gms_internal_zzchx;
        com_google_android_gms_internal_zzchx = new zzchk(this);
        com_google_android_gms_internal_zzchx.initialize();
        this.zzjff = com_google_android_gms_internal_zzchx;
        com_google_android_gms_internal_zzchx = new zzcgu(this);
        com_google_android_gms_internal_zzchx.initialize();
        this.zzjfl = com_google_android_gms_internal_zzchx;
        com_google_android_gms_internal_zzchx = new zzchh(this);
        com_google_android_gms_internal_zzchx.initialize();
        this.zzjfn = com_google_android_gms_internal_zzchx;
        com_google_android_gms_internal_zzchx = new zzcgo(this);
        com_google_android_gms_internal_zzchx.initialize();
        this.zzjfg = com_google_android_gms_internal_zzchx;
        com_google_android_gms_internal_zzchx = new zzchi(this);
        com_google_android_gms_internal_zzchx.initialize();
        this.zzjfh = com_google_android_gms_internal_zzchx;
        com_google_android_gms_internal_zzchx = new zzcgk(this);
        com_google_android_gms_internal_zzchx.initialize();
        this.zzjfq = com_google_android_gms_internal_zzchx;
        this.zzjfr = new zzcgd(this);
        com_google_android_gms_internal_zzchx = new zzchq(this);
        com_google_android_gms_internal_zzchx.initialize();
        this.zzjfi = com_google_android_gms_internal_zzchx;
        com_google_android_gms_internal_zzchx = new zzckc(this);
        com_google_android_gms_internal_zzchx.initialize();
        this.zzjfj = com_google_android_gms_internal_zzchx;
        com_google_android_gms_internal_zzchx = new zzckg(this);
        com_google_android_gms_internal_zzchx.initialize();
        this.zzjfk = com_google_android_gms_internal_zzchx;
        com_google_android_gms_internal_zzchx = new zzcjn(this);
        com_google_android_gms_internal_zzchx.initialize();
        this.zzjfm = com_google_android_gms_internal_zzchx;
        com_google_android_gms_internal_zzchx = new zzcll(this);
        com_google_android_gms_internal_zzchx.initialize();
        this.zzjfp = com_google_android_gms_internal_zzchx;
        this.zzjfo = new zzchv(this);
        this.zzjfc = new AppMeasurement(this);
        this.zzjfd = new FirebaseAnalytics(this);
        com_google_android_gms_internal_zzchx = new zzclf(this);
        com_google_android_gms_internal_zzchx.initialize();
        this.zzjfa = com_google_android_gms_internal_zzchx;
        com_google_android_gms_internal_zzchx = new zzcig(this);
        com_google_android_gms_internal_zzchx.initialize();
        this.zzjfb = com_google_android_gms_internal_zzchx;
        com_google_android_gms_internal_zzchx = new zzcih(this);
        com_google_android_gms_internal_zzchx.initialize();
        this.zzjez = com_google_android_gms_internal_zzchx;
        if (this.mContext.getApplicationContext() instanceof Application) {
            zzcjk zzawm = zzawm();
            if (zzawm.getContext().getApplicationContext() instanceof Application) {
                Application application = (Application) zzawm.getContext().getApplicationContext();
                if (zzawm.zzjgx == null) {
                    zzawm.zzjgx = new zzckb(zzawm);
                }
                application.unregisterActivityLifecycleCallbacks(zzawm.zzjgx);
                application.registerActivityLifecycleCallbacks(zzawm.zzjgx);
                zzazj = zzawm.zzawy().zzazj();
                str = "Registered activity lifecycle callback";
            }
            this.zzjez.zzg(new zzcin(this));
        }
        zzazj = zzawy().zzazf();
        str = "Application context is not an Application";
        zzazj.log(str);
        this.zzjez.zzg(new zzcin(this));
    }

    @WorkerThread
    private final int zza(FileChannel fileChannel) {
        zzawx().zzve();
        if (fileChannel != null) {
            if (fileChannel.isOpen()) {
                ByteBuffer allocate = ByteBuffer.allocate(4);
                try {
                    fileChannel.position(0);
                    int read = fileChannel.read(allocate);
                    if (read != 4) {
                        if (read != -1) {
                            zzawy().zzazf().zzj("Unexpected data length. Bytes read", Integer.valueOf(read));
                        }
                        return 0;
                    }
                    allocate.flip();
                    return allocate.getInt();
                } catch (IOException e) {
                    zzawy().zzazd().zzj("Failed to read from channel", e);
                    return 0;
                }
            }
        }
        zzawy().zzazd().log("Bad chanel to read from");
        return 0;
    }

    private final com.google.android.gms.internal.zzcgi zza(android.content.Context r23, java.lang.String r24, java.lang.String r25, boolean r26, boolean r27) {
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
        r22 = this;
        r1 = r24;
        r0 = "Unknown";
        r2 = "Unknown";
        r3 = "Unknown";
        r4 = r23.getPackageManager();
        r5 = 0;
        if (r4 != 0) goto L_0x001d;
    L_0x000f:
        r0 = r22.zzawy();
        r0 = r0.zzazd();
        r1 = "PackageManager is null, can not log app install information";
        r0.log(r1);
        return r5;
    L_0x001d:
        r4 = r4.getInstallerPackageName(r1);	 Catch:{ IllegalArgumentException -> 0x0023 }
        r0 = r4;
        goto L_0x0034;
    L_0x0023:
        r4 = r22.zzawy();
        r4 = r4.zzazd();
        r6 = "Error retrieving installer package name. appId";
        r7 = com.google.android.gms.internal.zzchm.zzjk(r24);
        r4.zzj(r6, r7);
    L_0x0034:
        if (r0 != 0) goto L_0x003a;
    L_0x0036:
        r0 = "manual_install";
    L_0x0038:
        r6 = r0;
        goto L_0x0045;
    L_0x003a:
        r4 = "com.android.vending";
        r4 = r4.equals(r0);
        if (r4 == 0) goto L_0x0038;
    L_0x0042:
        r0 = "";
        goto L_0x0038;
    L_0x0045:
        r0 = com.google.android.gms.internal.zzbhf.zzdb(r23);	 Catch:{ NameNotFoundException -> 0x0090 }
        r4 = 0;	 Catch:{ NameNotFoundException -> 0x0090 }
        r0 = r0.getPackageInfo(r1, r4);	 Catch:{ NameNotFoundException -> 0x0090 }
        if (r0 == 0) goto L_0x0068;	 Catch:{ NameNotFoundException -> 0x0090 }
    L_0x0050:
        r2 = com.google.android.gms.internal.zzbhf.zzdb(r23);	 Catch:{ NameNotFoundException -> 0x0090 }
        r2 = r2.zzgt(r1);	 Catch:{ NameNotFoundException -> 0x0090 }
        r4 = android.text.TextUtils.isEmpty(r2);	 Catch:{ NameNotFoundException -> 0x0090 }
        if (r4 != 0) goto L_0x0063;	 Catch:{ NameNotFoundException -> 0x0090 }
    L_0x005e:
        r2 = r2.toString();	 Catch:{ NameNotFoundException -> 0x0090 }
        r3 = r2;	 Catch:{ NameNotFoundException -> 0x0090 }
    L_0x0063:
        r2 = r0.versionName;	 Catch:{ NameNotFoundException -> 0x0090 }
        r0 = r0.versionCode;	 Catch:{ NameNotFoundException -> 0x0090 }
        goto L_0x006a;
    L_0x0068:
        r0 = -2147483648; // 0xffffffff80000000 float:-0.0 double:NaN;
    L_0x006a:
        r3 = r2;
        r21 = new com.google.android.gms.internal.zzcgi;
        r4 = (long) r0;
        r7 = 11910; // 0x2e86 float:1.669E-41 double:5.8843E-320;
        r0 = r22.zzawu();
        r2 = r23;
        r9 = r0.zzaf(r2, r1);
        r11 = 0;
        r13 = 0;
        r14 = "";
        r15 = 0;
        r17 = 0;
        r19 = 0;
        r0 = r21;
        r2 = r25;
        r12 = r26;
        r20 = r27;
        r0.<init>(r1, r2, r3, r4, r6, r7, r9, r11, r12, r13, r14, r15, r17, r19, r20);
        return r21;
    L_0x0090:
        r0 = r22.zzawy();
        r0 = r0.zzazd();
        r2 = "Error retrieving newly installed package info. appId, appName";
        r1 = com.google.android.gms.internal.zzchm.zzjk(r24);
        r0.zze(r2, r1, r3);
        return r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzcim.zza(android.content.Context, java.lang.String, java.lang.String, boolean, boolean):com.google.android.gms.internal.zzcgi");
    }

    private static void zza(zzcjk com_google_android_gms_internal_zzcjk) {
        if (com_google_android_gms_internal_zzcjk == null) {
            throw new IllegalStateException("Component not created");
        }
    }

    private static void zza(zzcjl com_google_android_gms_internal_zzcjl) {
        if (com_google_android_gms_internal_zzcjl == null) {
            throw new IllegalStateException("Component not created");
        } else if (!com_google_android_gms_internal_zzcjl.isInitialized()) {
            throw new IllegalStateException("Component not initialized");
        }
    }

    @WorkerThread
    private final boolean zza(int i, FileChannel fileChannel) {
        zzawx().zzve();
        if (fileChannel != null) {
            if (fileChannel.isOpen()) {
                ByteBuffer allocate = ByteBuffer.allocate(4);
                allocate.putInt(i);
                allocate.flip();
                try {
                    fileChannel.truncate(0);
                    fileChannel.write(allocate);
                    fileChannel.force(true);
                    if (fileChannel.size() != 4) {
                        zzawy().zzazd().zzj("Error writing to channel. Bytes written", Long.valueOf(fileChannel.size()));
                    }
                    return true;
                } catch (IOException e) {
                    zzawy().zzazd().zzj("Failed to write to channel", e);
                    return false;
                }
            }
        }
        zzawy().zzazd().log("Bad chanel to read from");
        return false;
    }

    private static boolean zza(zzcmb com_google_android_gms_internal_zzcmb, String str, Object obj) {
        if (TextUtils.isEmpty(str) || obj == null) {
            return false;
        }
        zzcmc[] com_google_android_gms_internal_zzcmcArr = com_google_android_gms_internal_zzcmb.zzjlh;
        int length = com_google_android_gms_internal_zzcmcArr.length;
        int i = 0;
        while (i < length) {
            zzcmc com_google_android_gms_internal_zzcmc = com_google_android_gms_internal_zzcmcArr[i];
            if (str.equals(com_google_android_gms_internal_zzcmc.name)) {
                return ((obj instanceof Long) && obj.equals(com_google_android_gms_internal_zzcmc.zzjll)) || (((obj instanceof String) && obj.equals(com_google_android_gms_internal_zzcmc.zzgcc)) || ((obj instanceof Double) && obj.equals(com_google_android_gms_internal_zzcmc.zzjjl)));
            } else {
                i++;
            }
        }
        return false;
    }

    private final boolean zza(String str, zzcha com_google_android_gms_internal_zzcha) {
        long round;
        Object string = com_google_android_gms_internal_zzcha.zzizt.getString(Param.CURRENCY);
        if (Event.ECOMMERCE_PURCHASE.equals(com_google_android_gms_internal_zzcha.name)) {
            double doubleValue = com_google_android_gms_internal_zzcha.zzizt.getDouble(Param.VALUE).doubleValue() * 1000000.0d;
            if (doubleValue == 0.0d) {
                doubleValue = ((double) com_google_android_gms_internal_zzcha.zzizt.getLong(Param.VALUE).longValue()) * 1000000.0d;
            }
            if (doubleValue > 9.223372036854776E18d || doubleValue < -9.223372036854776E18d) {
                zzawy().zzazf().zze("Data lost. Currency value is too big. appId", zzchm.zzjk(str), Double.valueOf(doubleValue));
                return false;
            }
            round = Math.round(doubleValue);
        } else {
            round = com_google_android_gms_internal_zzcha.zzizt.getLong(Param.VALUE).longValue();
        }
        if (!TextUtils.isEmpty(string)) {
            String toUpperCase = string.toUpperCase(Locale.US);
            if (toUpperCase.matches("[A-Z]{3}")) {
                String valueOf = String.valueOf("_ltv_");
                toUpperCase = String.valueOf(toUpperCase);
                String concat = toUpperCase.length() != 0 ? valueOf.concat(toUpperCase) : new String(valueOf);
                zzclp zzag = zzaws().zzag(str, concat);
                if (zzag != null) {
                    if (zzag.mValue instanceof Long) {
                        zzag = new zzclp(str, com_google_android_gms_internal_zzcha.zziyf, concat, this.zzata.currentTimeMillis(), Long.valueOf(((Long) zzag.mValue).longValue() + round));
                        if (!zzaws().zza(zzag)) {
                            zzawy().zzazd().zzd("Too many unique user properties are set. Ignoring user property. appId", zzchm.zzjk(str), zzawt().zzjj(zzag.mName), zzag.mValue);
                            zzawu().zza(str, 9, null, null, 0);
                        }
                    }
                }
                zzcjk zzaws = zzaws();
                int zzb = this.zzjew.zzb(str, zzchc.zzjbh) - 1;
                zzbq.zzgm(str);
                zzaws.zzve();
                zzaws.zzxf();
                try {
                    zzaws.getWritableDatabase().execSQL("delete from user_attributes where app_id=? and name in (select name from user_attributes where app_id=? and name like '_ltv_%' order by set_timestamp desc limit ?,10);", new String[]{str, str, String.valueOf(zzb)});
                } catch (SQLiteException e) {
                    zzaws.zzawy().zzazd().zze("Error pruning currencies. appId", zzchm.zzjk(str), e);
                }
                zzclp com_google_android_gms_internal_zzclp = new zzclp(str, com_google_android_gms_internal_zzcha.zziyf, concat, this.zzata.currentTimeMillis(), Long.valueOf(round));
                if (zzaws().zza(zzag)) {
                    zzawy().zzazd().zzd("Too many unique user properties are set. Ignoring user property. appId", zzchm.zzjk(str), zzawt().zzjj(zzag.mName), zzag.mValue);
                    zzawu().zza(str, 9, null, null, 0);
                }
            }
        }
        return true;
    }

    private final zzcma[] zza(String str, zzcmg[] com_google_android_gms_internal_zzcmgArr, zzcmb[] com_google_android_gms_internal_zzcmbArr) {
        zzbq.zzgm(str);
        return zzawl().zza(str, com_google_android_gms_internal_zzcmbArr, com_google_android_gms_internal_zzcmgArr);
    }

    static void zzawi() {
        throw new IllegalStateException("Unexpected call on client side");
    }

    @WorkerThread
    private final void zzazw() {
        zzcho zzazh;
        zzawx().zzve();
        this.zzjfe.zzazw();
        this.zzjex.zzazw();
        this.zzjfn.zzazw();
        zzawy().zzazh().zzj("App measurement is starting up, version", Long.valueOf(11910));
        zzawy().zzazh().log("To enable debug logging run: adb shell setprop log.tag.FA VERBOSE");
        String appId = this.zzjfn.getAppId();
        if (zzawu().zzkj(appId)) {
            zzazh = zzawy().zzazh();
            appId = "Faster debug mode event logging enabled. To disable, run:\n  adb shell setprop debug.firebase.analytics.app .none.";
        } else {
            zzazh = zzawy().zzazh();
            String str = "To enable faster debug mode event logging run:\n  adb shell setprop debug.firebase.analytics.app ";
            appId = String.valueOf(appId);
            appId = appId.length() != 0 ? str.concat(appId) : new String(str);
        }
        zzazh.log(appId);
        zzawy().zzazi().log("Debug-level message logging enabled");
        if (this.zzjfz != this.zzjga) {
            zzawy().zzazd().zze("Not all components initialized", Integer.valueOf(this.zzjfz), Integer.valueOf(this.zzjga));
        }
        this.zzdtb = true;
    }

    @android.support.annotation.WorkerThread
    private final void zzb(com.google.android.gms.internal.zzcgh r11) {
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
        r10 = this;
        r0 = r10.zzawx();
        r0.zzve();
        r0 = r11.getGmpAppId();
        r0 = android.text.TextUtils.isEmpty(r0);
        if (r0 == 0) goto L_0x001f;
    L_0x0011:
        r2 = r11.getAppId();
        r3 = 204; // 0xcc float:2.86E-43 double:1.01E-321;
        r4 = 0;
        r5 = 0;
        r6 = 0;
        r1 = r10;
        r1.zzb(r2, r3, r4, r5, r6);
        return;
    L_0x001f:
        r0 = r11.getGmpAppId();
        r1 = r11.getAppInstanceId();
        r2 = new android.net.Uri$Builder;
        r2.<init>();
        r3 = com.google.android.gms.internal.zzchc.zzjah;
        r3 = r3.get();
        r3 = (java.lang.String) r3;
        r3 = r2.scheme(r3);
        r4 = com.google.android.gms.internal.zzchc.zzjai;
        r4 = r4.get();
        r4 = (java.lang.String) r4;
        r3 = r3.encodedAuthority(r4);
        r4 = "config/app/";
        r0 = java.lang.String.valueOf(r0);
        r5 = r0.length();
        if (r5 == 0) goto L_0x0055;
    L_0x0050:
        r0 = r4.concat(r0);
        goto L_0x005a;
    L_0x0055:
        r0 = new java.lang.String;
        r0.<init>(r4);
    L_0x005a:
        r0 = r3.path(r0);
        r3 = "app_instance_id";
        r0 = r0.appendQueryParameter(r3, r1);
        r1 = "platform";
        r3 = "android";
        r0 = r0.appendQueryParameter(r1, r3);
        r1 = "gmp_version";
        r3 = "11910";
        r0.appendQueryParameter(r1, r3);
        r0 = r2.build();
        r0 = r0.toString();
        r4 = new java.net.URL;	 Catch:{ MalformedURLException -> 0x00ea }
        r4.<init>(r0);	 Catch:{ MalformedURLException -> 0x00ea }
        r1 = r10.zzawy();	 Catch:{ MalformedURLException -> 0x00ea }
        r1 = r1.zzazj();	 Catch:{ MalformedURLException -> 0x00ea }
        r2 = "Fetching remote configuration";	 Catch:{ MalformedURLException -> 0x00ea }
        r3 = r11.getAppId();	 Catch:{ MalformedURLException -> 0x00ea }
        r1.zzj(r2, r3);	 Catch:{ MalformedURLException -> 0x00ea }
        r1 = r10.zzawv();	 Catch:{ MalformedURLException -> 0x00ea }
        r2 = r11.getAppId();	 Catch:{ MalformedURLException -> 0x00ea }
        r1 = r1.zzjs(r2);	 Catch:{ MalformedURLException -> 0x00ea }
        r2 = 0;	 Catch:{ MalformedURLException -> 0x00ea }
        r3 = r10.zzawv();	 Catch:{ MalformedURLException -> 0x00ea }
        r5 = r11.getAppId();	 Catch:{ MalformedURLException -> 0x00ea }
        r3 = r3.zzjt(r5);	 Catch:{ MalformedURLException -> 0x00ea }
        if (r1 == 0) goto L_0x00be;	 Catch:{ MalformedURLException -> 0x00ea }
    L_0x00ac:
        r1 = android.text.TextUtils.isEmpty(r3);	 Catch:{ MalformedURLException -> 0x00ea }
        if (r1 != 0) goto L_0x00be;	 Catch:{ MalformedURLException -> 0x00ea }
    L_0x00b2:
        r1 = new android.support.v4.util.ArrayMap;	 Catch:{ MalformedURLException -> 0x00ea }
        r1.<init>();	 Catch:{ MalformedURLException -> 0x00ea }
        r2 = "If-Modified-Since";	 Catch:{ MalformedURLException -> 0x00ea }
        r1.put(r2, r3);	 Catch:{ MalformedURLException -> 0x00ea }
        r6 = r1;	 Catch:{ MalformedURLException -> 0x00ea }
        goto L_0x00bf;	 Catch:{ MalformedURLException -> 0x00ea }
    L_0x00be:
        r6 = r2;	 Catch:{ MalformedURLException -> 0x00ea }
    L_0x00bf:
        r1 = 1;	 Catch:{ MalformedURLException -> 0x00ea }
        r10.zzjgd = r1;	 Catch:{ MalformedURLException -> 0x00ea }
        r2 = r10.zzbab();	 Catch:{ MalformedURLException -> 0x00ea }
        r3 = r11.getAppId();	 Catch:{ MalformedURLException -> 0x00ea }
        r7 = new com.google.android.gms.internal.zzciq;	 Catch:{ MalformedURLException -> 0x00ea }
        r7.<init>(r10);	 Catch:{ MalformedURLException -> 0x00ea }
        r2.zzve();	 Catch:{ MalformedURLException -> 0x00ea }
        r2.zzxf();	 Catch:{ MalformedURLException -> 0x00ea }
        com.google.android.gms.common.internal.zzbq.checkNotNull(r4);	 Catch:{ MalformedURLException -> 0x00ea }
        com.google.android.gms.common.internal.zzbq.checkNotNull(r7);	 Catch:{ MalformedURLException -> 0x00ea }
        r8 = r2.zzawx();	 Catch:{ MalformedURLException -> 0x00ea }
        r9 = new com.google.android.gms.internal.zzchu;	 Catch:{ MalformedURLException -> 0x00ea }
        r5 = 0;	 Catch:{ MalformedURLException -> 0x00ea }
        r1 = r9;	 Catch:{ MalformedURLException -> 0x00ea }
        r1.<init>(r2, r3, r4, r5, r6, r7);	 Catch:{ MalformedURLException -> 0x00ea }
        r8.zzh(r9);	 Catch:{ MalformedURLException -> 0x00ea }
        return;
    L_0x00ea:
        r1 = r10.zzawy();
        r1 = r1.zzazd();
        r2 = "Failed to parse config URL. Not fetching. appId";
        r11 = r11.getAppId();
        r11 = com.google.android.gms.internal.zzchm.zzjk(r11);
        r1.zze(r2, r11, r0);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzcim.zzb(com.google.android.gms.internal.zzcgh):void");
    }

    private final zzchv zzbac() {
        if (this.zzjfo != null) {
            return this.zzjfo;
        }
        throw new IllegalStateException("Network broadcast receiver not created");
    }

    private final zzcll zzbad() {
        zza(this.zzjfp);
        return this.zzjfp;
    }

    @WorkerThread
    private final boolean zzbae() {
        Object e;
        zzcho zzazd;
        String str;
        zzawx().zzve();
        try {
            this.zzjfw = new RandomAccessFile(new File(this.mContext.getFilesDir(), "google_app_measurement.db"), "rw").getChannel();
            this.zzjfv = this.zzjfw.tryLock();
            if (this.zzjfv != null) {
                zzawy().zzazj().log("Storage concurrent access okay");
                return true;
            }
            zzawy().zzazd().log("Storage concurrent data access panic");
            return false;
        } catch (FileNotFoundException e2) {
            e = e2;
            zzazd = zzawy().zzazd();
            str = "Failed to acquire storage lock";
            zzazd.zzj(str, e);
            return false;
        } catch (IOException e3) {
            e = e3;
            zzazd = zzawy().zzazd();
            str = "Failed to access storage lock file";
            zzazd.zzj(str, e);
            return false;
        }
    }

    private final long zzbag() {
        long currentTimeMillis = this.zzata.currentTimeMillis();
        zzcjk zzawz = zzawz();
        zzawz.zzxf();
        zzawz.zzve();
        long j = zzawz.zzjcv.get();
        if (j == 0) {
            j = 1 + ((long) zzawz.zzawu().zzbaz().nextInt(86400000));
            zzawz.zzjcv.set(j);
        }
        return ((((currentTimeMillis + j) / 1000) / 60) / 60) / 24;
    }

    private final boolean zzbai() {
        zzawx().zzve();
        zzxf();
        if (!zzaws().zzayk()) {
            if (TextUtils.isEmpty(zzaws().zzayf())) {
                return false;
            }
        }
        return true;
    }

    @WorkerThread
    private final void zzbaj() {
        zzcim com_google_android_gms_internal_zzcim = this;
        zzawx().zzve();
        zzxf();
        if (zzbam()) {
            long abs;
            if (com_google_android_gms_internal_zzcim.zzjgc > 0) {
                abs = 3600000 - Math.abs(com_google_android_gms_internal_zzcim.zzata.elapsedRealtime() - com_google_android_gms_internal_zzcim.zzjgc);
                if (abs > 0) {
                    zzawy().zzazj().zzj("Upload has been suspended. Will update scheduling later in approximately ms", Long.valueOf(abs));
                    zzbac().unregister();
                    zzbad().cancel();
                    return;
                }
                com_google_android_gms_internal_zzcim.zzjgc = 0;
            }
            if (zzazv()) {
                if (zzbai()) {
                    Object obj;
                    CharSequence zzayd;
                    zzchd com_google_android_gms_internal_zzchd;
                    long max;
                    long j;
                    long j2;
                    long j3;
                    long j4;
                    long abs2;
                    long j5;
                    long j6;
                    int i;
                    long currentTimeMillis = com_google_android_gms_internal_zzcim.zzata.currentTimeMillis();
                    abs = Math.max(0, ((Long) zzchc.zzjbd.get()).longValue());
                    if (!zzaws().zzayl()) {
                        if (!zzaws().zzayg()) {
                            obj = null;
                            if (obj == null) {
                                zzayd = com_google_android_gms_internal_zzcim.zzjew.zzayd();
                                com_google_android_gms_internal_zzchd = (TextUtils.isEmpty(zzayd) || ".none.".equals(zzayd)) ? zzchc.zzjax : zzchc.zzjay;
                            } else {
                                com_google_android_gms_internal_zzchd = zzchc.zzjaw;
                            }
                            max = Math.max(0, ((Long) com_google_android_gms_internal_zzchd.get()).longValue());
                            j = zzawz().zzjcr.get();
                            j2 = zzawz().zzjcs.get();
                            j3 = max;
                            j4 = abs;
                            abs = Math.max(zzaws().zzayi(), zzaws().zzayj());
                            if (abs != 0) {
                                abs = currentTimeMillis - Math.abs(abs - currentTimeMillis);
                                abs2 = currentTimeMillis - Math.abs(j - currentTimeMillis);
                                currentTimeMillis -= Math.abs(j2 - currentTimeMillis);
                                abs2 = Math.max(abs2, currentTimeMillis);
                                j5 = abs + j4;
                                if (obj != null && abs2 > 0) {
                                    j5 = Math.min(abs, abs2) + j3;
                                }
                                j6 = j3;
                                abs2 = zzawu().zzf(abs2, j6) ? abs2 + j6 : j5;
                                if (currentTimeMillis != 0 && currentTimeMillis >= abs) {
                                    for (i = 0; i < Math.min(20, Math.max(0, ((Integer) zzchc.zzjbf.get()).intValue())); i++) {
                                        abs2 += Math.max(0, ((Long) zzchc.zzjbe.get()).longValue()) * (1 << i);
                                        if (abs2 > currentTimeMillis) {
                                            break;
                                        }
                                    }
                                }
                                if (abs2 != 0) {
                                    zzawy().zzazj().log("Next upload time is 0");
                                    zzbac().unregister();
                                    zzbad().cancel();
                                    return;
                                } else if (zzbab().zzzs()) {
                                    currentTimeMillis = zzawz().zzjct.get();
                                    abs = Math.max(0, ((Long) zzchc.zzjau.get()).longValue());
                                    if (!zzawu().zzf(currentTimeMillis, abs)) {
                                        abs2 = Math.max(abs2, currentTimeMillis + abs);
                                    }
                                    zzbac().unregister();
                                    abs2 -= com_google_android_gms_internal_zzcim.zzata.currentTimeMillis();
                                    if (abs2 <= 0) {
                                        abs2 = Math.max(0, ((Long) zzchc.zzjaz.get()).longValue());
                                        zzawz().zzjcr.set(com_google_android_gms_internal_zzcim.zzata.currentTimeMillis());
                                    }
                                    zzawy().zzazj().zzj("Upload scheduled in approximately ms", Long.valueOf(abs2));
                                    zzbad().zzs(abs2);
                                    return;
                                } else {
                                    zzawy().zzazj().log("No network");
                                    zzbac().zzzp();
                                    zzbad().cancel();
                                    return;
                                }
                            }
                            abs2 = 0;
                            if (abs2 != 0) {
                                zzawy().zzazj().log("Next upload time is 0");
                                zzbac().unregister();
                                zzbad().cancel();
                                return;
                            } else if (zzbab().zzzs()) {
                                currentTimeMillis = zzawz().zzjct.get();
                                abs = Math.max(0, ((Long) zzchc.zzjau.get()).longValue());
                                if (zzawu().zzf(currentTimeMillis, abs)) {
                                    abs2 = Math.max(abs2, currentTimeMillis + abs);
                                }
                                zzbac().unregister();
                                abs2 -= com_google_android_gms_internal_zzcim.zzata.currentTimeMillis();
                                if (abs2 <= 0) {
                                    abs2 = Math.max(0, ((Long) zzchc.zzjaz.get()).longValue());
                                    zzawz().zzjcr.set(com_google_android_gms_internal_zzcim.zzata.currentTimeMillis());
                                }
                                zzawy().zzazj().zzj("Upload scheduled in approximately ms", Long.valueOf(abs2));
                                zzbad().zzs(abs2);
                                return;
                            } else {
                                zzawy().zzazj().log("No network");
                                zzbac().zzzp();
                                zzbad().cancel();
                                return;
                            }
                        }
                    }
                    obj = 1;
                    if (obj == null) {
                        com_google_android_gms_internal_zzchd = zzchc.zzjaw;
                    } else {
                        zzayd = com_google_android_gms_internal_zzcim.zzjew.zzayd();
                        if (!TextUtils.isEmpty(zzayd)) {
                        }
                    }
                    max = Math.max(0, ((Long) com_google_android_gms_internal_zzchd.get()).longValue());
                    j = zzawz().zzjcr.get();
                    j2 = zzawz().zzjcs.get();
                    j3 = max;
                    j4 = abs;
                    abs = Math.max(zzaws().zzayi(), zzaws().zzayj());
                    if (abs != 0) {
                        abs = currentTimeMillis - Math.abs(abs - currentTimeMillis);
                        abs2 = currentTimeMillis - Math.abs(j - currentTimeMillis);
                        currentTimeMillis -= Math.abs(j2 - currentTimeMillis);
                        abs2 = Math.max(abs2, currentTimeMillis);
                        j5 = abs + j4;
                        j5 = Math.min(abs, abs2) + j3;
                        j6 = j3;
                        if (zzawu().zzf(abs2, j6)) {
                        }
                        for (i = 0; i < Math.min(20, Math.max(0, ((Integer) zzchc.zzjbf.get()).intValue())); i++) {
                            abs2 += Math.max(0, ((Long) zzchc.zzjbe.get()).longValue()) * (1 << i);
                            if (abs2 > currentTimeMillis) {
                                break;
                            }
                        }
                    }
                    abs2 = 0;
                    if (abs2 != 0) {
                        zzawy().zzazj().log("Next upload time is 0");
                        zzbac().unregister();
                        zzbad().cancel();
                        return;
                    } else if (zzbab().zzzs()) {
                        zzawy().zzazj().log("No network");
                        zzbac().zzzp();
                        zzbad().cancel();
                        return;
                    } else {
                        currentTimeMillis = zzawz().zzjct.get();
                        abs = Math.max(0, ((Long) zzchc.zzjau.get()).longValue());
                        if (zzawu().zzf(currentTimeMillis, abs)) {
                            abs2 = Math.max(abs2, currentTimeMillis + abs);
                        }
                        zzbac().unregister();
                        abs2 -= com_google_android_gms_internal_zzcim.zzata.currentTimeMillis();
                        if (abs2 <= 0) {
                            abs2 = Math.max(0, ((Long) zzchc.zzjaz.get()).longValue());
                            zzawz().zzjcr.set(com_google_android_gms_internal_zzcim.zzata.currentTimeMillis());
                        }
                        zzawy().zzazj().zzj("Upload scheduled in approximately ms", Long.valueOf(abs2));
                        zzbad().zzs(abs2);
                        return;
                    }
                }
            }
            zzawy().zzazj().log("Nothing to upload or uploading impossible");
            zzbac().unregister();
            zzbad().cancel();
        }
    }

    @WorkerThread
    private final boolean zzbam() {
        zzawx().zzve();
        zzxf();
        return this.zzjfs;
    }

    @WorkerThread
    private final void zzban() {
        zzawx().zzve();
        if (!(this.zzjgd || this.zzjge)) {
            if (!this.zzjgf) {
                zzawy().zzazj().log("Stopping uploading service(s)");
                if (this.zzjfy != null) {
                    for (Runnable run : this.zzjfy) {
                        run.run();
                    }
                    this.zzjfy.clear();
                    return;
                }
                return;
            }
        }
        zzawy().zzazj().zzd("Not stopping services. fetch, network, upload", Boolean.valueOf(this.zzjgd), Boolean.valueOf(this.zzjge), Boolean.valueOf(this.zzjgf));
    }

    @WorkerThread
    private final void zzc(zzcha com_google_android_gms_internal_zzcha, zzcgi com_google_android_gms_internal_zzcgi) {
        zzcim com_google_android_gms_internal_zzcim = this;
        zzcha com_google_android_gms_internal_zzcha2 = com_google_android_gms_internal_zzcha;
        zzcgi com_google_android_gms_internal_zzcgi2 = com_google_android_gms_internal_zzcgi;
        zzbq.checkNotNull(com_google_android_gms_internal_zzcgi);
        zzbq.zzgm(com_google_android_gms_internal_zzcgi2.packageName);
        long nanoTime = System.nanoTime();
        zzawx().zzve();
        zzxf();
        String str = com_google_android_gms_internal_zzcgi2.packageName;
        zzawu();
        if (!zzclq.zzd(com_google_android_gms_internal_zzcha, com_google_android_gms_internal_zzcgi)) {
            return;
        }
        if (!com_google_android_gms_internal_zzcgi2.zzixx) {
            zzg(com_google_android_gms_internal_zzcgi2);
        } else if (zzawv().zzan(str, com_google_android_gms_internal_zzcha2.name)) {
            Object obj;
            zzcgh zzjb;
            zzawy().zzazf().zze("Dropping blacklisted event. appId", zzchm.zzjk(str), zzawt().zzjh(com_google_android_gms_internal_zzcha2.name));
            if (!zzawu().zzkl(str)) {
                if (!zzawu().zzkm(str)) {
                    obj = null;
                    if (obj == null && !"_err".equals(com_google_android_gms_internal_zzcha2.name)) {
                        zzawu().zza(str, 11, "_ev", com_google_android_gms_internal_zzcha2.name, 0);
                    }
                    if (obj != null) {
                        zzjb = zzaws().zzjb(str);
                        if (zzjb != null) {
                            if (Math.abs(com_google_android_gms_internal_zzcim.zzata.currentTimeMillis() - Math.max(zzjb.zzaxn(), zzjb.zzaxm())) > ((Long) zzchc.zzjbc.get()).longValue()) {
                                zzawy().zzazi().log("Fetching config for blacklisted app");
                                zzb(zzjb);
                            }
                        }
                    }
                }
            }
            obj = 1;
            zzawu().zza(str, 11, "_ev", com_google_android_gms_internal_zzcha2.name, 0);
            if (obj != null) {
                zzjb = zzaws().zzjb(str);
                if (zzjb != null) {
                    if (Math.abs(com_google_android_gms_internal_zzcim.zzata.currentTimeMillis() - Math.max(zzjb.zzaxn(), zzjb.zzaxm())) > ((Long) zzchc.zzjbc.get()).longValue()) {
                        zzawy().zzazi().log("Fetching config for blacklisted app");
                        zzb(zzjb);
                    }
                }
            }
        } else {
            if (zzawy().zzae(2)) {
                zzawy().zzazj().zzj("Logging event", zzawt().zzb(com_google_android_gms_internal_zzcha2));
            }
            zzaws().beginTransaction();
            zzg(com_google_android_gms_internal_zzcgi2);
            if (("_iap".equals(com_google_android_gms_internal_zzcha2.name) || Event.ECOMMERCE_PURCHASE.equals(com_google_android_gms_internal_zzcha2.name)) && !zza(str, com_google_android_gms_internal_zzcha2)) {
                zzaws().setTransactionSuccessful();
                zzaws().endTransaction();
                return;
            }
            zzcme com_google_android_gms_internal_zzcme;
            try {
                boolean zzjz = zzclq.zzjz(com_google_android_gms_internal_zzcha2.name);
                boolean equals = "_err".equals(com_google_android_gms_internal_zzcha2.name);
                zzcgp zza = zzaws().zza(zzbag(), str, true, zzjz, false, equals, false);
                long intValue = zza.zziyy - ((long) ((Integer) zzchc.zzjan.get()).intValue());
                if (intValue > 0) {
                    if (intValue % 1000 == 1) {
                        zzawy().zzazd().zze("Data loss. Too many events logged. appId, count", zzchm.zzjk(str), Long.valueOf(zza.zziyy));
                    }
                    zzaws().setTransactionSuccessful();
                    zzaws().endTransaction();
                    return;
                }
                if (zzjz) {
                    intValue = zza.zziyx - ((long) ((Integer) zzchc.zzjap.get()).intValue());
                    if (intValue > 0) {
                        if (intValue % 1000 == 1) {
                            zzawy().zzazd().zze("Data loss. Too many public events logged. appId, count", zzchm.zzjk(str), Long.valueOf(zza.zziyx));
                        }
                        zzawu().zza(str, 16, "_ev", com_google_android_gms_internal_zzcha2.name, 0);
                        zzaws().setTransactionSuccessful();
                        zzaws().endTransaction();
                        return;
                    }
                }
                if (equals) {
                    intValue = zza.zziza - ((long) Math.max(0, Math.min(1000000, com_google_android_gms_internal_zzcim.zzjew.zzb(com_google_android_gms_internal_zzcgi2.packageName, zzchc.zzjao))));
                    if (intValue > 0) {
                        if (intValue == 1) {
                            zzawy().zzazd().zze("Too many error events logged. appId, count", zzchm.zzjk(str), Long.valueOf(zza.zziza));
                        }
                        zzaws().setTransactionSuccessful();
                        zzaws().endTransaction();
                        return;
                    }
                }
                Bundle zzayx = com_google_android_gms_internal_zzcha2.zzizt.zzayx();
                zzawu().zza(zzayx, "_o", com_google_android_gms_internal_zzcha2.zziyf);
                if (zzawu().zzkj(str)) {
                    zzawu().zza(zzayx, "_dbg", Long.valueOf(1));
                    zzawu().zza(zzayx, "_r", Long.valueOf(1));
                }
                long zzjc = zzaws().zzjc(str);
                if (zzjc > 0) {
                    zzawy().zzazf().zze("Data lost. Too many events stored on disk, deleted. appId", zzchm.zzjk(str), Long.valueOf(zzjc));
                }
                long j = nanoTime;
                nanoTime = 0;
                zzcgv com_google_android_gms_internal_zzcgv = r1;
                String str2 = str;
                zzcgv com_google_android_gms_internal_zzcgv2 = new zzcgv(com_google_android_gms_internal_zzcim, com_google_android_gms_internal_zzcha2.zziyf, str, com_google_android_gms_internal_zzcha2.name, com_google_android_gms_internal_zzcha2.zzizu, 0, zzayx);
                zzcgw zzae = zzaws().zzae(str2, com_google_android_gms_internal_zzcgv.mName);
                if (zzae != null) {
                    zzcgv zza2 = com_google_android_gms_internal_zzcgv.zza(com_google_android_gms_internal_zzcim, zzae.zzizm);
                    zzae = zzae.zzbb(zza2.zzfij);
                    com_google_android_gms_internal_zzcgv = zza2;
                } else if (zzaws().zzjf(str2) < 500 || !zzjz) {
                    zzcgw com_google_android_gms_internal_zzcgw = new zzcgw(str2, com_google_android_gms_internal_zzcgv.mName, 0, 0, com_google_android_gms_internal_zzcgv.zzfij, 0, null, null, null);
                } else {
                    zzawy().zzazd().zzd("Too many event names used, ignoring event. appId, name, supported count", zzchm.zzjk(str2), zzawt().zzjh(com_google_android_gms_internal_zzcgv.mName), Integer.valueOf(500));
                    zzawu().zza(str2, 8, null, null, 0);
                    zzaws().endTransaction();
                    return;
                }
                zzaws().zza(zzae);
                zzawx().zzve();
                zzxf();
                zzbq.checkNotNull(com_google_android_gms_internal_zzcgv);
                zzbq.checkNotNull(com_google_android_gms_internal_zzcgi);
                zzbq.zzgm(com_google_android_gms_internal_zzcgv.mAppId);
                zzbq.checkArgument(com_google_android_gms_internal_zzcgv.mAppId.equals(com_google_android_gms_internal_zzcgi2.packageName));
                com_google_android_gms_internal_zzcme = new zzcme();
                equals = true;
                com_google_android_gms_internal_zzcme.zzjlo = Integer.valueOf(1);
                com_google_android_gms_internal_zzcme.zzjlw = "android";
                com_google_android_gms_internal_zzcme.zzcn = com_google_android_gms_internal_zzcgi2.packageName;
                com_google_android_gms_internal_zzcme.zzixt = com_google_android_gms_internal_zzcgi2.zzixt;
                com_google_android_gms_internal_zzcme.zzifm = com_google_android_gms_internal_zzcgi2.zzifm;
                com_google_android_gms_internal_zzcme.zzjmj = com_google_android_gms_internal_zzcgi2.zzixz == -2147483648L ? null : Integer.valueOf((int) com_google_android_gms_internal_zzcgi2.zzixz);
                com_google_android_gms_internal_zzcme.zzjma = Long.valueOf(com_google_android_gms_internal_zzcgi2.zzixu);
                com_google_android_gms_internal_zzcme.zzixs = com_google_android_gms_internal_zzcgi2.zzixs;
                com_google_android_gms_internal_zzcme.zzjmf = com_google_android_gms_internal_zzcgi2.zzixv == 0 ? null : Long.valueOf(com_google_android_gms_internal_zzcgi2.zzixv);
                Pair zzjm = zzawz().zzjm(com_google_android_gms_internal_zzcgi2.packageName);
                if (zzjm == null || TextUtils.isEmpty((CharSequence) zzjm.first)) {
                    if (!zzawo().zzdw(com_google_android_gms_internal_zzcim.mContext)) {
                        String string = Secure.getString(com_google_android_gms_internal_zzcim.mContext.getContentResolver(), "android_id");
                        if (string == null) {
                            zzawy().zzazf().zzj("null secure ID. appId", zzchm.zzjk(com_google_android_gms_internal_zzcme.zzcn));
                            string = "null";
                        } else if (string.isEmpty()) {
                            zzawy().zzazf().zzj("empty secure ID. appId", zzchm.zzjk(com_google_android_gms_internal_zzcme.zzcn));
                        }
                        com_google_android_gms_internal_zzcme.zzjmm = string;
                    }
                } else if (com_google_android_gms_internal_zzcgi2.zziye) {
                    com_google_android_gms_internal_zzcme.zzjmc = (String) zzjm.first;
                    com_google_android_gms_internal_zzcme.zzjmd = (Boolean) zzjm.second;
                }
                zzawo().zzxf();
                com_google_android_gms_internal_zzcme.zzjlx = Build.MODEL;
                zzawo().zzxf();
                com_google_android_gms_internal_zzcme.zzdb = VERSION.RELEASE;
                com_google_android_gms_internal_zzcme.zzjlz = Integer.valueOf((int) zzawo().zzayu());
                com_google_android_gms_internal_zzcme.zzjly = zzawo().zzayv();
                com_google_android_gms_internal_zzcme.zzjmb = null;
                com_google_android_gms_internal_zzcme.zzjlr = null;
                com_google_android_gms_internal_zzcme.zzjls = null;
                com_google_android_gms_internal_zzcme.zzjlt = null;
                com_google_android_gms_internal_zzcme.zzfkk = Long.valueOf(com_google_android_gms_internal_zzcgi2.zziyb);
                if (isEnabled() && zzcgn.zzaye()) {
                    zzawn();
                    com_google_android_gms_internal_zzcme.zzjmo = null;
                }
                zzcgh zzjb2 = zzaws().zzjb(com_google_android_gms_internal_zzcgi2.packageName);
                if (zzjb2 == null) {
                    zzjb2 = new zzcgh(com_google_android_gms_internal_zzcim, com_google_android_gms_internal_zzcgi2.packageName);
                    zzjb2.zzir(zzawn().zzayz());
                    zzjb2.zziu(com_google_android_gms_internal_zzcgi2.zziya);
                    zzjb2.zzis(com_google_android_gms_internal_zzcgi2.zzixs);
                    zzjb2.zzit(zzawz().zzjn(com_google_android_gms_internal_zzcgi2.packageName));
                    zzjb2.zzaq(0);
                    zzjb2.zzal(0);
                    zzjb2.zzam(0);
                    zzjb2.setAppVersion(com_google_android_gms_internal_zzcgi2.zzifm);
                    zzjb2.zzan(com_google_android_gms_internal_zzcgi2.zzixz);
                    zzjb2.zziv(com_google_android_gms_internal_zzcgi2.zzixt);
                    zzjb2.zzao(com_google_android_gms_internal_zzcgi2.zzixu);
                    zzjb2.zzap(com_google_android_gms_internal_zzcgi2.zzixv);
                    zzjb2.setMeasurementEnabled(com_google_android_gms_internal_zzcgi2.zzixx);
                    zzjb2.zzaz(com_google_android_gms_internal_zzcgi2.zziyb);
                    zzaws().zza(zzjb2);
                }
                com_google_android_gms_internal_zzcme.zzjme = zzjb2.getAppInstanceId();
                com_google_android_gms_internal_zzcme.zziya = zzjb2.zzaxd();
                List zzja = zzaws().zzja(com_google_android_gms_internal_zzcgi2.packageName);
                com_google_android_gms_internal_zzcme.zzjlq = new zzcmg[zzja.size()];
                for (int i = 0; i < zzja.size(); i++) {
                    zzcmg com_google_android_gms_internal_zzcmg = new zzcmg();
                    com_google_android_gms_internal_zzcme.zzjlq[i] = com_google_android_gms_internal_zzcmg;
                    com_google_android_gms_internal_zzcmg.name = ((zzclp) zzja.get(i)).mName;
                    com_google_android_gms_internal_zzcmg.zzjms = Long.valueOf(((zzclp) zzja.get(i)).zzjjm);
                    zzawu().zza(com_google_android_gms_internal_zzcmg, ((zzclp) zzja.get(i)).mValue);
                }
                long zza3 = zzaws().zza(com_google_android_gms_internal_zzcme);
                zzcgo zzaws = zzaws();
                if (com_google_android_gms_internal_zzcgv.zzizj != null) {
                    Iterator it = com_google_android_gms_internal_zzcgv.zzizj.iterator();
                    while (it.hasNext()) {
                        if ("_r".equals((String) it.next())) {
                            break;
                        }
                    }
                    boolean zzao = zzawv().zzao(com_google_android_gms_internal_zzcgv.mAppId, com_google_android_gms_internal_zzcgv.mName);
                    zzcgp zza4 = zzaws().zza(zzbag(), com_google_android_gms_internal_zzcgv.mAppId, false, false, false, false, false);
                    if (zzao && zza4.zzizb < ((long) com_google_android_gms_internal_zzcim.zzjew.zzix(com_google_android_gms_internal_zzcgv.mAppId))) {
                        if (zzaws.zza(com_google_android_gms_internal_zzcgv, zza3, equals)) {
                            com_google_android_gms_internal_zzcim.zzjgc = 0;
                        }
                        zzaws().setTransactionSuccessful();
                        if (zzawy().zzae(2)) {
                            zzawy().zzazj().zzj("Event recorded", zzawt().zza(com_google_android_gms_internal_zzcgv));
                        }
                        zzaws().endTransaction();
                        zzbaj();
                        zzawy().zzazj().zzj("Background event processing time, ms", Long.valueOf(((System.nanoTime() - j) + 500000) / 1000000));
                    }
                }
                equals = false;
                if (zzaws.zza(com_google_android_gms_internal_zzcgv, zza3, equals)) {
                    com_google_android_gms_internal_zzcim.zzjgc = 0;
                }
                zzaws().setTransactionSuccessful();
                if (zzawy().zzae(2)) {
                    zzawy().zzazj().zzj("Event recorded", zzawt().zza(com_google_android_gms_internal_zzcgv));
                }
                zzaws().endTransaction();
                zzbaj();
                zzawy().zzazj().zzj("Background event processing time, ms", Long.valueOf(((System.nanoTime() - j) + 500000) / 1000000));
            } catch (IOException e) {
                zzawy().zzazd().zze("Data loss. Failed to insert raw event metadata. appId", zzchm.zzjk(com_google_android_gms_internal_zzcme.zzcn), e);
            } catch (Throwable th) {
                Throwable th2 = th;
                zzaws().endTransaction();
            }
        }
    }

    public static zzcim zzdx(Context context) {
        zzbq.checkNotNull(context);
        zzbq.checkNotNull(context.getApplicationContext());
        if (zzjev == null) {
            synchronized (zzcim.class) {
                if (zzjev == null) {
                    zzjev = new zzcim(new zzcjm(context));
                }
            }
        }
        return zzjev;
    }

    @WorkerThread
    private final void zzg(zzcgi com_google_android_gms_internal_zzcgi) {
        Object obj;
        zzawx().zzve();
        zzxf();
        zzbq.checkNotNull(com_google_android_gms_internal_zzcgi);
        zzbq.zzgm(com_google_android_gms_internal_zzcgi.packageName);
        zzcgh zzjb = zzaws().zzjb(com_google_android_gms_internal_zzcgi.packageName);
        String zzjn = zzawz().zzjn(com_google_android_gms_internal_zzcgi.packageName);
        if (zzjb == null) {
            zzjb = new zzcgh(this, com_google_android_gms_internal_zzcgi.packageName);
            zzjb.zzir(zzawn().zzayz());
            zzjb.zzit(zzjn);
        } else if (zzjn.equals(zzjb.zzaxc())) {
            obj = null;
            if (!(TextUtils.isEmpty(com_google_android_gms_internal_zzcgi.zzixs) || com_google_android_gms_internal_zzcgi.zzixs.equals(zzjb.getGmpAppId()))) {
                zzjb.zzis(com_google_android_gms_internal_zzcgi.zzixs);
                obj = 1;
            }
            if (!(TextUtils.isEmpty(com_google_android_gms_internal_zzcgi.zziya) || com_google_android_gms_internal_zzcgi.zziya.equals(zzjb.zzaxd()))) {
                zzjb.zziu(com_google_android_gms_internal_zzcgi.zziya);
                obj = 1;
            }
            if (!(com_google_android_gms_internal_zzcgi.zzixu == 0 || com_google_android_gms_internal_zzcgi.zzixu == zzjb.zzaxi())) {
                zzjb.zzao(com_google_android_gms_internal_zzcgi.zzixu);
                obj = 1;
            }
            if (!(TextUtils.isEmpty(com_google_android_gms_internal_zzcgi.zzifm) || com_google_android_gms_internal_zzcgi.zzifm.equals(zzjb.zzvj()))) {
                zzjb.setAppVersion(com_google_android_gms_internal_zzcgi.zzifm);
                obj = 1;
            }
            if (com_google_android_gms_internal_zzcgi.zzixz != zzjb.zzaxg()) {
                zzjb.zzan(com_google_android_gms_internal_zzcgi.zzixz);
                obj = 1;
            }
            if (!(com_google_android_gms_internal_zzcgi.zzixt == null || com_google_android_gms_internal_zzcgi.zzixt.equals(zzjb.zzaxh()))) {
                zzjb.zziv(com_google_android_gms_internal_zzcgi.zzixt);
                obj = 1;
            }
            if (com_google_android_gms_internal_zzcgi.zzixv != zzjb.zzaxj()) {
                zzjb.zzap(com_google_android_gms_internal_zzcgi.zzixv);
                obj = 1;
            }
            if (com_google_android_gms_internal_zzcgi.zzixx != zzjb.zzaxk()) {
                zzjb.setMeasurementEnabled(com_google_android_gms_internal_zzcgi.zzixx);
                obj = 1;
            }
            if (!(TextUtils.isEmpty(com_google_android_gms_internal_zzcgi.zzixw) || com_google_android_gms_internal_zzcgi.zzixw.equals(zzjb.zzaxv()))) {
                zzjb.zziw(com_google_android_gms_internal_zzcgi.zzixw);
                obj = 1;
            }
            if (com_google_android_gms_internal_zzcgi.zziyb != zzjb.zzaxx()) {
                zzjb.zzaz(com_google_android_gms_internal_zzcgi.zziyb);
                obj = 1;
            }
            if (com_google_android_gms_internal_zzcgi.zziye != zzjb.zzaxy()) {
                zzjb.zzbl(com_google_android_gms_internal_zzcgi.zziye);
                obj = 1;
            }
            if (obj != null) {
                zzaws().zza(zzjb);
            }
        } else {
            zzjb.zzit(zzjn);
            zzjb.zzir(zzawn().zzayz());
        }
        obj = 1;
        zzjb.zzis(com_google_android_gms_internal_zzcgi.zzixs);
        obj = 1;
        zzjb.zziu(com_google_android_gms_internal_zzcgi.zziya);
        obj = 1;
        zzjb.zzao(com_google_android_gms_internal_zzcgi.zzixu);
        obj = 1;
        zzjb.setAppVersion(com_google_android_gms_internal_zzcgi.zzifm);
        obj = 1;
        if (com_google_android_gms_internal_zzcgi.zzixz != zzjb.zzaxg()) {
            zzjb.zzan(com_google_android_gms_internal_zzcgi.zzixz);
            obj = 1;
        }
        zzjb.zziv(com_google_android_gms_internal_zzcgi.zzixt);
        obj = 1;
        if (com_google_android_gms_internal_zzcgi.zzixv != zzjb.zzaxj()) {
            zzjb.zzap(com_google_android_gms_internal_zzcgi.zzixv);
            obj = 1;
        }
        if (com_google_android_gms_internal_zzcgi.zzixx != zzjb.zzaxk()) {
            zzjb.setMeasurementEnabled(com_google_android_gms_internal_zzcgi.zzixx);
            obj = 1;
        }
        zzjb.zziw(com_google_android_gms_internal_zzcgi.zzixw);
        obj = 1;
        if (com_google_android_gms_internal_zzcgi.zziyb != zzjb.zzaxx()) {
            zzjb.zzaz(com_google_android_gms_internal_zzcgi.zziyb);
            obj = 1;
        }
        if (com_google_android_gms_internal_zzcgi.zziye != zzjb.zzaxy()) {
            zzjb.zzbl(com_google_android_gms_internal_zzcgi.zziye);
            obj = 1;
        }
        if (obj != null) {
            zzaws().zza(zzjb);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean zzg(java.lang.String r47, long r48) {
        /*
        r46 = this;
        r1 = r46;
        r2 = r46.zzaws();
        r2.beginTransaction();
        r2 = new com.google.android.gms.internal.zzcim$zza;	 Catch:{ all -> 0x09eb }
        r3 = 0;
        r2.<init>();	 Catch:{ all -> 0x09eb }
        r4 = r46.zzaws();	 Catch:{ all -> 0x09eb }
        r5 = r1.zzjgb;	 Catch:{ all -> 0x09eb }
        com.google.android.gms.common.internal.zzbq.checkNotNull(r2);	 Catch:{ all -> 0x09eb }
        r4.zzve();	 Catch:{ all -> 0x09eb }
        r4.zzxf();	 Catch:{ all -> 0x09eb }
        r7 = -1;
        r9 = 2;
        r10 = 0;
        r11 = 1;
        r15 = r4.getWritableDatabase();	 Catch:{ SQLiteException -> 0x0264, all -> 0x025f }
        r12 = android.text.TextUtils.isEmpty(r3);	 Catch:{ SQLiteException -> 0x0264, all -> 0x025f }
        if (r12 == 0) goto L_0x00a0;
    L_0x002d:
        r12 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1));
        if (r12 == 0) goto L_0x004b;
    L_0x0031:
        r13 = new java.lang.String[r9];	 Catch:{ SQLiteException -> 0x0045, all -> 0x0040 }
        r14 = java.lang.String.valueOf(r5);	 Catch:{ SQLiteException -> 0x0045, all -> 0x0040 }
        r13[r10] = r14;	 Catch:{ SQLiteException -> 0x0045, all -> 0x0040 }
        r14 = java.lang.String.valueOf(r48);	 Catch:{ SQLiteException -> 0x0045, all -> 0x0040 }
        r13[r11] = r14;	 Catch:{ SQLiteException -> 0x0045, all -> 0x0040 }
        goto L_0x0053;
    L_0x0040:
        r0 = move-exception;
        r2 = r0;
        r9 = r3;
        goto L_0x09e5;
    L_0x0045:
        r0 = move-exception;
        r9 = r3;
        r12 = r9;
    L_0x0048:
        r3 = r0;
        goto L_0x0268;
    L_0x004b:
        r13 = new java.lang.String[r11];	 Catch:{ SQLiteException -> 0x0264, all -> 0x025f }
        r14 = java.lang.String.valueOf(r48);	 Catch:{ SQLiteException -> 0x0264, all -> 0x025f }
        r13[r10] = r14;	 Catch:{ SQLiteException -> 0x0264, all -> 0x025f }
    L_0x0053:
        if (r12 == 0) goto L_0x0058;
    L_0x0055:
        r12 = "rowid <= ? and ";
        goto L_0x005a;
    L_0x0058:
        r12 = "";
    L_0x005a:
        r14 = 148; // 0x94 float:2.07E-43 double:7.3E-322;
        r3 = java.lang.String.valueOf(r12);	 Catch:{ SQLiteException -> 0x0264, all -> 0x025f }
        r3 = r3.length();	 Catch:{ SQLiteException -> 0x0264, all -> 0x025f }
        r14 = r14 + r3;
        r3 = new java.lang.StringBuilder;	 Catch:{ SQLiteException -> 0x0264, all -> 0x025f }
        r3.<init>(r14);	 Catch:{ SQLiteException -> 0x0264, all -> 0x025f }
        r14 = "select app_id, metadata_fingerprint from raw_events where ";
        r3.append(r14);	 Catch:{ SQLiteException -> 0x0264, all -> 0x025f }
        r3.append(r12);	 Catch:{ SQLiteException -> 0x0264, all -> 0x025f }
        r12 = "app_id in (select app_id from apps where config_fetched_time >= ?) order by rowid limit 1;";
        r3.append(r12);	 Catch:{ SQLiteException -> 0x0264, all -> 0x025f }
        r3 = r3.toString();	 Catch:{ SQLiteException -> 0x0264, all -> 0x025f }
        r3 = r15.rawQuery(r3, r13);	 Catch:{ SQLiteException -> 0x0264, all -> 0x025f }
        r12 = r3.moveToFirst();	 Catch:{ SQLiteException -> 0x025a, all -> 0x0040 }
        if (r12 != 0) goto L_0x008c;
    L_0x0085:
        if (r3 == 0) goto L_0x027c;
    L_0x0087:
        r3.close();	 Catch:{ all -> 0x09eb }
        goto L_0x027c;
    L_0x008c:
        r12 = r3.getString(r10);	 Catch:{ SQLiteException -> 0x025a, all -> 0x0040 }
        r13 = r3.getString(r11);	 Catch:{ SQLiteException -> 0x009d, all -> 0x0040 }
        r3.close();	 Catch:{ SQLiteException -> 0x009d, all -> 0x0040 }
        r22 = r3;
        r3 = r12;
        r21 = r13;
        goto L_0x00f7;
    L_0x009d:
        r0 = move-exception;
        r9 = r3;
        goto L_0x0048;
    L_0x00a0:
        r3 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1));
        if (r3 == 0) goto L_0x00b0;
    L_0x00a4:
        r12 = new java.lang.String[r9];	 Catch:{ SQLiteException -> 0x0264, all -> 0x025f }
        r13 = 0;
        r12[r10] = r13;	 Catch:{ SQLiteException -> 0x0264, all -> 0x025f }
        r13 = java.lang.String.valueOf(r5);	 Catch:{ SQLiteException -> 0x0264, all -> 0x025f }
        r12[r11] = r13;	 Catch:{ SQLiteException -> 0x0264, all -> 0x025f }
        goto L_0x00b6;
    L_0x00b0:
        r12 = 0;
        r13 = new java.lang.String[]{r12};	 Catch:{ SQLiteException -> 0x0264, all -> 0x025f }
        r12 = r13;
    L_0x00b6:
        if (r3 == 0) goto L_0x00bb;
    L_0x00b8:
        r3 = " and rowid <= ?";
        goto L_0x00bd;
    L_0x00bb:
        r3 = "";
    L_0x00bd:
        r13 = 84;
        r14 = java.lang.String.valueOf(r3);	 Catch:{ SQLiteException -> 0x0264, all -> 0x025f }
        r14 = r14.length();	 Catch:{ SQLiteException -> 0x0264, all -> 0x025f }
        r13 = r13 + r14;
        r14 = new java.lang.StringBuilder;	 Catch:{ SQLiteException -> 0x0264, all -> 0x025f }
        r14.<init>(r13);	 Catch:{ SQLiteException -> 0x0264, all -> 0x025f }
        r13 = "select metadata_fingerprint from raw_events where app_id = ?";
        r14.append(r13);	 Catch:{ SQLiteException -> 0x0264, all -> 0x025f }
        r14.append(r3);	 Catch:{ SQLiteException -> 0x0264, all -> 0x025f }
        r3 = " order by rowid limit 1;";
        r14.append(r3);	 Catch:{ SQLiteException -> 0x0264, all -> 0x025f }
        r3 = r14.toString();	 Catch:{ SQLiteException -> 0x0264, all -> 0x025f }
        r3 = r15.rawQuery(r3, r12);	 Catch:{ SQLiteException -> 0x0264, all -> 0x025f }
        r12 = r3.moveToFirst();	 Catch:{ SQLiteException -> 0x025a, all -> 0x0040 }
        if (r12 != 0) goto L_0x00eb;
    L_0x00e8:
        if (r3 == 0) goto L_0x027c;
    L_0x00ea:
        goto L_0x0087;
    L_0x00eb:
        r13 = r3.getString(r10);	 Catch:{ SQLiteException -> 0x025a, all -> 0x0040 }
        r3.close();	 Catch:{ SQLiteException -> 0x025a, all -> 0x0040 }
        r22 = r3;
        r21 = r13;
        r3 = 0;
    L_0x00f7:
        r13 = "raw_events_metadata";
        r12 = "metadata";
        r14 = new java.lang.String[]{r12};	 Catch:{ SQLiteException -> 0x0254, all -> 0x024e }
        r16 = "app_id = ? and metadata_fingerprint = ?";
        r12 = new java.lang.String[r9];	 Catch:{ SQLiteException -> 0x0254, all -> 0x024e }
        r12[r10] = r3;	 Catch:{ SQLiteException -> 0x0254, all -> 0x024e }
        r12[r11] = r21;	 Catch:{ SQLiteException -> 0x0254, all -> 0x024e }
        r17 = 0;
        r18 = 0;
        r19 = "rowid";
        r20 = "2";
        r23 = r12;
        r12 = r15;
        r24 = r15;
        r15 = r16;
        r16 = r23;
        r15 = r12.query(r13, r14, r15, r16, r17, r18, r19, r20);	 Catch:{ SQLiteException -> 0x0254, all -> 0x024e }
        r12 = r15.moveToFirst();	 Catch:{ SQLiteException -> 0x0249, all -> 0x0245 }
        if (r12 != 0) goto L_0x0144;
    L_0x0122:
        r5 = r4.zzawy();	 Catch:{ SQLiteException -> 0x013f, all -> 0x013a }
        r5 = r5.zzazd();	 Catch:{ SQLiteException -> 0x013f, all -> 0x013a }
        r6 = "Raw event metadata record is missing. appId";
        r12 = com.google.android.gms.internal.zzchm.zzjk(r3);	 Catch:{ SQLiteException -> 0x013f, all -> 0x013a }
        r5.zzj(r6, r12);	 Catch:{ SQLiteException -> 0x013f, all -> 0x013a }
        if (r15 == 0) goto L_0x027c;
    L_0x0135:
        r15.close();	 Catch:{ all -> 0x09eb }
        goto L_0x027c;
    L_0x013a:
        r0 = move-exception;
        r2 = r0;
        r9 = r15;
        goto L_0x09e5;
    L_0x013f:
        r0 = move-exception;
        r12 = r3;
        r9 = r15;
        goto L_0x0048;
    L_0x0144:
        r12 = r15.getBlob(r10);	 Catch:{ SQLiteException -> 0x0249, all -> 0x0245 }
        r13 = r12.length;	 Catch:{ SQLiteException -> 0x0249, all -> 0x0245 }
        r12 = com.google.android.gms.internal.zzfjj.zzn(r12, r10, r13);	 Catch:{ SQLiteException -> 0x0249, all -> 0x0245 }
        r13 = new com.google.android.gms.internal.zzcme;	 Catch:{ SQLiteException -> 0x0249, all -> 0x0245 }
        r13.<init>();	 Catch:{ SQLiteException -> 0x0249, all -> 0x0245 }
        r13.zza(r12);	 Catch:{ IOException -> 0x022a }
        r12 = r15.moveToNext();	 Catch:{ SQLiteException -> 0x0249, all -> 0x0245 }
        if (r12 == 0) goto L_0x016c;
    L_0x015b:
        r12 = r4.zzawy();	 Catch:{ SQLiteException -> 0x013f, all -> 0x013a }
        r12 = r12.zzazf();	 Catch:{ SQLiteException -> 0x013f, all -> 0x013a }
        r14 = "Get multiple raw event metadata records, expected one. appId";
        r9 = com.google.android.gms.internal.zzchm.zzjk(r3);	 Catch:{ SQLiteException -> 0x013f, all -> 0x013a }
        r12.zzj(r14, r9);	 Catch:{ SQLiteException -> 0x013f, all -> 0x013a }
    L_0x016c:
        r15.close();	 Catch:{ SQLiteException -> 0x0249, all -> 0x0245 }
        r2.zzb(r13);	 Catch:{ SQLiteException -> 0x0249, all -> 0x0245 }
        r9 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1));
        r14 = 3;
        if (r9 == 0) goto L_0x018a;
    L_0x0177:
        r9 = "app_id = ? and metadata_fingerprint = ? and rowid <= ?";
        r12 = new java.lang.String[r14];	 Catch:{ SQLiteException -> 0x013f, all -> 0x013a }
        r12[r10] = r3;	 Catch:{ SQLiteException -> 0x013f, all -> 0x013a }
        r12[r11] = r21;	 Catch:{ SQLiteException -> 0x013f, all -> 0x013a }
        r5 = java.lang.String.valueOf(r5);	 Catch:{ SQLiteException -> 0x013f, all -> 0x013a }
        r6 = 2;
        r12[r6] = r5;	 Catch:{ SQLiteException -> 0x013f, all -> 0x013a }
        r5 = r9;
        r16 = r12;
        goto L_0x0195;
    L_0x018a:
        r5 = "app_id = ? and metadata_fingerprint = ?";
        r6 = 2;
        r9 = new java.lang.String[r6];	 Catch:{ SQLiteException -> 0x0249, all -> 0x0245 }
        r9[r10] = r3;	 Catch:{ SQLiteException -> 0x0249, all -> 0x0245 }
        r9[r11] = r21;	 Catch:{ SQLiteException -> 0x0249, all -> 0x0245 }
        r16 = r9;
    L_0x0195:
        r13 = "raw_events";
        r6 = "rowid";
        r9 = "name";
        r12 = "timestamp";
        r14 = "data";
        r14 = new java.lang.String[]{r6, r9, r12, r14};	 Catch:{ SQLiteException -> 0x0249, all -> 0x0245 }
        r17 = 0;
        r18 = 0;
        r19 = "rowid";
        r20 = 0;
        r12 = r24;
        r6 = 3;
        r9 = r15;
        r15 = r5;
        r5 = r12.query(r13, r14, r15, r16, r17, r18, r19, r20);	 Catch:{ SQLiteException -> 0x0243 }
        r9 = r5.moveToFirst();	 Catch:{ SQLiteException -> 0x0225, all -> 0x0220 }
        if (r9 != 0) goto L_0x01d2;
    L_0x01ba:
        r6 = r4.zzawy();	 Catch:{ SQLiteException -> 0x0225, all -> 0x0220 }
        r6 = r6.zzazf();	 Catch:{ SQLiteException -> 0x0225, all -> 0x0220 }
        r9 = "Raw event data disappeared while in transaction. appId";
        r12 = com.google.android.gms.internal.zzchm.zzjk(r3);	 Catch:{ SQLiteException -> 0x0225, all -> 0x0220 }
        r6.zzj(r9, r12);	 Catch:{ SQLiteException -> 0x0225, all -> 0x0220 }
        if (r5 == 0) goto L_0x027c;
    L_0x01cd:
        r5.close();	 Catch:{ all -> 0x09eb }
        goto L_0x027c;
    L_0x01d2:
        r12 = r5.getLong(r10);	 Catch:{ SQLiteException -> 0x0225, all -> 0x0220 }
        r9 = r5.getBlob(r6);	 Catch:{ SQLiteException -> 0x0225, all -> 0x0220 }
        r14 = r9.length;	 Catch:{ SQLiteException -> 0x0225, all -> 0x0220 }
        r9 = com.google.android.gms.internal.zzfjj.zzn(r9, r10, r14);	 Catch:{ SQLiteException -> 0x0225, all -> 0x0220 }
        r14 = new com.google.android.gms.internal.zzcmb;	 Catch:{ SQLiteException -> 0x0225, all -> 0x0220 }
        r14.<init>();	 Catch:{ SQLiteException -> 0x0225, all -> 0x0220 }
        r14.zza(r9);	 Catch:{ IOException -> 0x0201 }
        r9 = r5.getString(r11);	 Catch:{ SQLiteException -> 0x0225, all -> 0x0220 }
        r14.name = r9;	 Catch:{ SQLiteException -> 0x0225, all -> 0x0220 }
        r9 = 2;
        r6 = r5.getLong(r9);	 Catch:{ SQLiteException -> 0x0225, all -> 0x0220 }
        r6 = java.lang.Long.valueOf(r6);	 Catch:{ SQLiteException -> 0x0225, all -> 0x0220 }
        r14.zzjli = r6;	 Catch:{ SQLiteException -> 0x0225, all -> 0x0220 }
        r6 = r2.zza(r12, r14);	 Catch:{ SQLiteException -> 0x0225, all -> 0x0220 }
        if (r6 != 0) goto L_0x0213;
    L_0x01fe:
        if (r5 == 0) goto L_0x027c;
    L_0x0200:
        goto L_0x01cd;
    L_0x0201:
        r0 = move-exception;
        r6 = r4.zzawy();	 Catch:{ SQLiteException -> 0x0225, all -> 0x0220 }
        r6 = r6.zzazd();	 Catch:{ SQLiteException -> 0x0225, all -> 0x0220 }
        r7 = "Data loss. Failed to merge raw event. appId";
        r8 = com.google.android.gms.internal.zzchm.zzjk(r3);	 Catch:{ SQLiteException -> 0x0225, all -> 0x0220 }
        r6.zze(r7, r8, r0);	 Catch:{ SQLiteException -> 0x0225, all -> 0x0220 }
    L_0x0213:
        r6 = r5.moveToNext();	 Catch:{ SQLiteException -> 0x0225, all -> 0x0220 }
        if (r6 != 0) goto L_0x021c;
    L_0x0219:
        if (r5 == 0) goto L_0x027c;
    L_0x021b:
        goto L_0x01cd;
    L_0x021c:
        r6 = 3;
        r7 = -1;
        goto L_0x01d2;
    L_0x0220:
        r0 = move-exception;
        r2 = r0;
        r9 = r5;
        goto L_0x09e5;
    L_0x0225:
        r0 = move-exception;
        r12 = r3;
        r9 = r5;
        goto L_0x0048;
    L_0x022a:
        r0 = move-exception;
        r9 = r15;
        r5 = r4.zzawy();	 Catch:{ SQLiteException -> 0x0243 }
        r5 = r5.zzazd();	 Catch:{ SQLiteException -> 0x0243 }
        r6 = "Data loss. Failed to merge raw event metadata. appId";
        r7 = com.google.android.gms.internal.zzchm.zzjk(r3);	 Catch:{ SQLiteException -> 0x0243 }
        r5.zze(r6, r7, r0);	 Catch:{ SQLiteException -> 0x0243 }
        if (r9 == 0) goto L_0x027c;
    L_0x023f:
        r9.close();	 Catch:{ all -> 0x09eb }
        goto L_0x027c;
    L_0x0243:
        r0 = move-exception;
        goto L_0x024b;
    L_0x0245:
        r0 = move-exception;
        r9 = r15;
        goto L_0x09e4;
    L_0x0249:
        r0 = move-exception;
        r9 = r15;
    L_0x024b:
        r12 = r3;
        goto L_0x0048;
    L_0x024e:
        r0 = move-exception;
        r2 = r0;
        r9 = r22;
        goto L_0x09e5;
    L_0x0254:
        r0 = move-exception;
        r12 = r3;
        r9 = r22;
        goto L_0x0048;
    L_0x025a:
        r0 = move-exception;
        r9 = r3;
        r12 = 0;
        goto L_0x0048;
    L_0x025f:
        r0 = move-exception;
        r2 = r0;
        r9 = 0;
        goto L_0x09e5;
    L_0x0264:
        r0 = move-exception;
        r3 = r0;
        r9 = 0;
        r12 = 0;
    L_0x0268:
        r4 = r4.zzawy();	 Catch:{ all -> 0x09e3 }
        r4 = r4.zzazd();	 Catch:{ all -> 0x09e3 }
        r5 = "Data loss. Error selecting raw event. appId";
        r6 = com.google.android.gms.internal.zzchm.zzjk(r12);	 Catch:{ all -> 0x09e3 }
        r4.zze(r5, r6, r3);	 Catch:{ all -> 0x09e3 }
        if (r9 == 0) goto L_0x027c;
    L_0x027b:
        goto L_0x023f;
    L_0x027c:
        r3 = r2.zzapa;	 Catch:{ all -> 0x09eb }
        if (r3 == 0) goto L_0x028b;
    L_0x0280:
        r3 = r2.zzapa;	 Catch:{ all -> 0x09eb }
        r3 = r3.isEmpty();	 Catch:{ all -> 0x09eb }
        if (r3 == 0) goto L_0x0289;
    L_0x0288:
        goto L_0x028b;
    L_0x0289:
        r3 = r10;
        goto L_0x028c;
    L_0x028b:
        r3 = r11;
    L_0x028c:
        if (r3 != 0) goto L_0x09d3;
    L_0x028e:
        r3 = r2.zzjgi;	 Catch:{ all -> 0x09eb }
        r4 = r2.zzapa;	 Catch:{ all -> 0x09eb }
        r4 = r4.size();	 Catch:{ all -> 0x09eb }
        r4 = new com.google.android.gms.internal.zzcmb[r4];	 Catch:{ all -> 0x09eb }
        r3.zzjlp = r4;	 Catch:{ all -> 0x09eb }
        r4 = r10;
        r5 = r4;
        r6 = r5;
    L_0x029d:
        r7 = r2.zzapa;	 Catch:{ all -> 0x09eb }
        r7 = r7.size();	 Catch:{ all -> 0x09eb }
        if (r4 >= r7) goto L_0x05aa;
    L_0x02a5:
        r7 = r46.zzawv();	 Catch:{ all -> 0x09eb }
        r12 = r2.zzjgi;	 Catch:{ all -> 0x09eb }
        r12 = r12.zzcn;	 Catch:{ all -> 0x09eb }
        r13 = r2.zzapa;	 Catch:{ all -> 0x09eb }
        r13 = r13.get(r4);	 Catch:{ all -> 0x09eb }
        r13 = (com.google.android.gms.internal.zzcmb) r13;	 Catch:{ all -> 0x09eb }
        r13 = r13.name;	 Catch:{ all -> 0x09eb }
        r7 = r7.zzan(r12, r13);	 Catch:{ all -> 0x09eb }
        if (r7 == 0) goto L_0x0337;
    L_0x02bd:
        r7 = r46.zzawy();	 Catch:{ all -> 0x09eb }
        r7 = r7.zzazf();	 Catch:{ all -> 0x09eb }
        r8 = "Dropping blacklisted raw event. appId";
        r9 = r2.zzjgi;	 Catch:{ all -> 0x09eb }
        r9 = r9.zzcn;	 Catch:{ all -> 0x09eb }
        r9 = com.google.android.gms.internal.zzchm.zzjk(r9);	 Catch:{ all -> 0x09eb }
        r12 = r46.zzawt();	 Catch:{ all -> 0x09eb }
        r13 = r2.zzapa;	 Catch:{ all -> 0x09eb }
        r13 = r13.get(r4);	 Catch:{ all -> 0x09eb }
        r13 = (com.google.android.gms.internal.zzcmb) r13;	 Catch:{ all -> 0x09eb }
        r13 = r13.name;	 Catch:{ all -> 0x09eb }
        r12 = r12.zzjh(r13);	 Catch:{ all -> 0x09eb }
        r7.zze(r8, r9, r12);	 Catch:{ all -> 0x09eb }
        r7 = r46.zzawu();	 Catch:{ all -> 0x09eb }
        r8 = r2.zzjgi;	 Catch:{ all -> 0x09eb }
        r8 = r8.zzcn;	 Catch:{ all -> 0x09eb }
        r7 = r7.zzkl(r8);	 Catch:{ all -> 0x09eb }
        if (r7 != 0) goto L_0x0303;
    L_0x02f2:
        r7 = r46.zzawu();	 Catch:{ all -> 0x09eb }
        r8 = r2.zzjgi;	 Catch:{ all -> 0x09eb }
        r8 = r8.zzcn;	 Catch:{ all -> 0x09eb }
        r7 = r7.zzkm(r8);	 Catch:{ all -> 0x09eb }
        if (r7 == 0) goto L_0x0301;
    L_0x0300:
        goto L_0x0303;
    L_0x0301:
        r7 = r10;
        goto L_0x0304;
    L_0x0303:
        r7 = r11;
    L_0x0304:
        if (r7 != 0) goto L_0x05a4;
    L_0x0306:
        r7 = "_err";
        r8 = r2.zzapa;	 Catch:{ all -> 0x09eb }
        r8 = r8.get(r4);	 Catch:{ all -> 0x09eb }
        r8 = (com.google.android.gms.internal.zzcmb) r8;	 Catch:{ all -> 0x09eb }
        r8 = r8.name;	 Catch:{ all -> 0x09eb }
        r7 = r7.equals(r8);	 Catch:{ all -> 0x09eb }
        if (r7 != 0) goto L_0x05a4;
    L_0x0318:
        r12 = r46.zzawu();	 Catch:{ all -> 0x09eb }
        r7 = r2.zzjgi;	 Catch:{ all -> 0x09eb }
        r13 = r7.zzcn;	 Catch:{ all -> 0x09eb }
        r14 = 11;
        r15 = "_ev";
        r7 = r2.zzapa;	 Catch:{ all -> 0x09eb }
        r7 = r7.get(r4);	 Catch:{ all -> 0x09eb }
        r7 = (com.google.android.gms.internal.zzcmb) r7;	 Catch:{ all -> 0x09eb }
        r7 = r7.name;	 Catch:{ all -> 0x09eb }
        r17 = 0;
        r16 = r7;
        r12.zza(r13, r14, r15, r16, r17);	 Catch:{ all -> 0x09eb }
        goto L_0x05a4;
    L_0x0337:
        r7 = r46.zzawv();	 Catch:{ all -> 0x09eb }
        r12 = r2.zzjgi;	 Catch:{ all -> 0x09eb }
        r12 = r12.zzcn;	 Catch:{ all -> 0x09eb }
        r13 = r2.zzapa;	 Catch:{ all -> 0x09eb }
        r13 = r13.get(r4);	 Catch:{ all -> 0x09eb }
        r13 = (com.google.android.gms.internal.zzcmb) r13;	 Catch:{ all -> 0x09eb }
        r13 = r13.name;	 Catch:{ all -> 0x09eb }
        r7 = r7.zzao(r12, r13);	 Catch:{ all -> 0x09eb }
        if (r7 != 0) goto L_0x0362;
    L_0x034f:
        r46.zzawu();	 Catch:{ all -> 0x09eb }
        r12 = r2.zzapa;	 Catch:{ all -> 0x09eb }
        r12 = r12.get(r4);	 Catch:{ all -> 0x09eb }
        r12 = (com.google.android.gms.internal.zzcmb) r12;	 Catch:{ all -> 0x09eb }
        r12 = r12.name;	 Catch:{ all -> 0x09eb }
        r12 = com.google.android.gms.internal.zzclq.zzkn(r12);	 Catch:{ all -> 0x09eb }
        if (r12 == 0) goto L_0x0595;
    L_0x0362:
        r12 = r2.zzapa;	 Catch:{ all -> 0x09eb }
        r12 = r12.get(r4);	 Catch:{ all -> 0x09eb }
        r12 = (com.google.android.gms.internal.zzcmb) r12;	 Catch:{ all -> 0x09eb }
        r12 = r12.zzjlh;	 Catch:{ all -> 0x09eb }
        if (r12 != 0) goto L_0x037a;
    L_0x036e:
        r12 = r2.zzapa;	 Catch:{ all -> 0x09eb }
        r12 = r12.get(r4);	 Catch:{ all -> 0x09eb }
        r12 = (com.google.android.gms.internal.zzcmb) r12;	 Catch:{ all -> 0x09eb }
        r13 = new com.google.android.gms.internal.zzcmc[r10];	 Catch:{ all -> 0x09eb }
        r12.zzjlh = r13;	 Catch:{ all -> 0x09eb }
    L_0x037a:
        r12 = r2.zzapa;	 Catch:{ all -> 0x09eb }
        r12 = r12.get(r4);	 Catch:{ all -> 0x09eb }
        r12 = (com.google.android.gms.internal.zzcmb) r12;	 Catch:{ all -> 0x09eb }
        r12 = r12.zzjlh;	 Catch:{ all -> 0x09eb }
        r13 = r12.length;	 Catch:{ all -> 0x09eb }
        r14 = r10;
        r15 = r14;
        r16 = r15;
    L_0x0389:
        if (r14 >= r13) goto L_0x03ba;
    L_0x038b:
        r10 = r12[r14];	 Catch:{ all -> 0x09eb }
        r11 = "_c";
        r8 = r10.name;	 Catch:{ all -> 0x09eb }
        r8 = r11.equals(r8);	 Catch:{ all -> 0x09eb }
        if (r8 == 0) goto L_0x03a1;
    L_0x0397:
        r8 = 1;
        r11 = java.lang.Long.valueOf(r8);	 Catch:{ all -> 0x09eb }
        r10.zzjll = r11;	 Catch:{ all -> 0x09eb }
        r15 = 1;
        goto L_0x03b5;
    L_0x03a1:
        r8 = "_r";
        r9 = r10.name;	 Catch:{ all -> 0x09eb }
        r8 = r8.equals(r9);	 Catch:{ all -> 0x09eb }
        if (r8 == 0) goto L_0x03b5;
    L_0x03ab:
        r8 = 1;
        r11 = java.lang.Long.valueOf(r8);	 Catch:{ all -> 0x09eb }
        r10.zzjll = r11;	 Catch:{ all -> 0x09eb }
        r16 = 1;
    L_0x03b5:
        r14 = r14 + 1;
        r10 = 0;
        r11 = 1;
        goto L_0x0389;
    L_0x03ba:
        if (r15 != 0) goto L_0x041a;
    L_0x03bc:
        if (r7 == 0) goto L_0x041a;
    L_0x03be:
        r8 = r46.zzawy();	 Catch:{ all -> 0x09eb }
        r8 = r8.zzazj();	 Catch:{ all -> 0x09eb }
        r9 = "Marking event as conversion";
        r10 = r46.zzawt();	 Catch:{ all -> 0x09eb }
        r11 = r2.zzapa;	 Catch:{ all -> 0x09eb }
        r11 = r11.get(r4);	 Catch:{ all -> 0x09eb }
        r11 = (com.google.android.gms.internal.zzcmb) r11;	 Catch:{ all -> 0x09eb }
        r11 = r11.name;	 Catch:{ all -> 0x09eb }
        r10 = r10.zzjh(r11);	 Catch:{ all -> 0x09eb }
        r8.zzj(r9, r10);	 Catch:{ all -> 0x09eb }
        r8 = r2.zzapa;	 Catch:{ all -> 0x09eb }
        r8 = r8.get(r4);	 Catch:{ all -> 0x09eb }
        r8 = (com.google.android.gms.internal.zzcmb) r8;	 Catch:{ all -> 0x09eb }
        r8 = r8.zzjlh;	 Catch:{ all -> 0x09eb }
        r9 = r2.zzapa;	 Catch:{ all -> 0x09eb }
        r9 = r9.get(r4);	 Catch:{ all -> 0x09eb }
        r9 = (com.google.android.gms.internal.zzcmb) r9;	 Catch:{ all -> 0x09eb }
        r9 = r9.zzjlh;	 Catch:{ all -> 0x09eb }
        r9 = r9.length;	 Catch:{ all -> 0x09eb }
        r10 = 1;
        r9 = r9 + r10;
        r8 = java.util.Arrays.copyOf(r8, r9);	 Catch:{ all -> 0x09eb }
        r8 = (com.google.android.gms.internal.zzcmc[]) r8;	 Catch:{ all -> 0x09eb }
        r9 = new com.google.android.gms.internal.zzcmc;	 Catch:{ all -> 0x09eb }
        r9.<init>();	 Catch:{ all -> 0x09eb }
        r10 = "_c";
        r9.name = r10;	 Catch:{ all -> 0x09eb }
        r10 = 1;
        r12 = java.lang.Long.valueOf(r10);	 Catch:{ all -> 0x09eb }
        r9.zzjll = r12;	 Catch:{ all -> 0x09eb }
        r10 = r8.length;	 Catch:{ all -> 0x09eb }
        r11 = 1;
        r10 = r10 - r11;
        r8[r10] = r9;	 Catch:{ all -> 0x09eb }
        r9 = r2.zzapa;	 Catch:{ all -> 0x09eb }
        r9 = r9.get(r4);	 Catch:{ all -> 0x09eb }
        r9 = (com.google.android.gms.internal.zzcmb) r9;	 Catch:{ all -> 0x09eb }
        r9.zzjlh = r8;	 Catch:{ all -> 0x09eb }
    L_0x041a:
        if (r16 != 0) goto L_0x0478;
    L_0x041c:
        r8 = r46.zzawy();	 Catch:{ all -> 0x09eb }
        r8 = r8.zzazj();	 Catch:{ all -> 0x09eb }
        r9 = "Marking event as real-time";
        r10 = r46.zzawt();	 Catch:{ all -> 0x09eb }
        r11 = r2.zzapa;	 Catch:{ all -> 0x09eb }
        r11 = r11.get(r4);	 Catch:{ all -> 0x09eb }
        r11 = (com.google.android.gms.internal.zzcmb) r11;	 Catch:{ all -> 0x09eb }
        r11 = r11.name;	 Catch:{ all -> 0x09eb }
        r10 = r10.zzjh(r11);	 Catch:{ all -> 0x09eb }
        r8.zzj(r9, r10);	 Catch:{ all -> 0x09eb }
        r8 = r2.zzapa;	 Catch:{ all -> 0x09eb }
        r8 = r8.get(r4);	 Catch:{ all -> 0x09eb }
        r8 = (com.google.android.gms.internal.zzcmb) r8;	 Catch:{ all -> 0x09eb }
        r8 = r8.zzjlh;	 Catch:{ all -> 0x09eb }
        r9 = r2.zzapa;	 Catch:{ all -> 0x09eb }
        r9 = r9.get(r4);	 Catch:{ all -> 0x09eb }
        r9 = (com.google.android.gms.internal.zzcmb) r9;	 Catch:{ all -> 0x09eb }
        r9 = r9.zzjlh;	 Catch:{ all -> 0x09eb }
        r9 = r9.length;	 Catch:{ all -> 0x09eb }
        r10 = 1;
        r9 = r9 + r10;
        r8 = java.util.Arrays.copyOf(r8, r9);	 Catch:{ all -> 0x09eb }
        r8 = (com.google.android.gms.internal.zzcmc[]) r8;	 Catch:{ all -> 0x09eb }
        r9 = new com.google.android.gms.internal.zzcmc;	 Catch:{ all -> 0x09eb }
        r9.<init>();	 Catch:{ all -> 0x09eb }
        r10 = "_r";
        r9.name = r10;	 Catch:{ all -> 0x09eb }
        r10 = 1;
        r10 = java.lang.Long.valueOf(r10);	 Catch:{ all -> 0x09eb }
        r9.zzjll = r10;	 Catch:{ all -> 0x09eb }
        r10 = r8.length;	 Catch:{ all -> 0x09eb }
        r11 = 1;
        r10 = r10 - r11;
        r8[r10] = r9;	 Catch:{ all -> 0x09eb }
        r9 = r2.zzapa;	 Catch:{ all -> 0x09eb }
        r9 = r9.get(r4);	 Catch:{ all -> 0x09eb }
        r9 = (com.google.android.gms.internal.zzcmb) r9;	 Catch:{ all -> 0x09eb }
        r9.zzjlh = r8;	 Catch:{ all -> 0x09eb }
    L_0x0478:
        r10 = r46.zzaws();	 Catch:{ all -> 0x09eb }
        r11 = r46.zzbag();	 Catch:{ all -> 0x09eb }
        r8 = r2.zzjgi;	 Catch:{ all -> 0x09eb }
        r13 = r8.zzcn;	 Catch:{ all -> 0x09eb }
        r14 = 0;
        r15 = 0;
        r16 = 0;
        r17 = 0;
        r18 = 1;
        r8 = r10.zza(r11, r13, r14, r15, r16, r17, r18);	 Catch:{ all -> 0x09eb }
        r8 = r8.zzizb;	 Catch:{ all -> 0x09eb }
        r10 = r1.zzjew;	 Catch:{ all -> 0x09eb }
        r11 = r2.zzjgi;	 Catch:{ all -> 0x09eb }
        r11 = r11.zzcn;	 Catch:{ all -> 0x09eb }
        r10 = r10.zzix(r11);	 Catch:{ all -> 0x09eb }
        r10 = (long) r10;	 Catch:{ all -> 0x09eb }
        r8 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1));
        if (r8 <= 0) goto L_0x04de;
    L_0x04a1:
        r8 = r2.zzapa;	 Catch:{ all -> 0x09eb }
        r8 = r8.get(r4);	 Catch:{ all -> 0x09eb }
        r8 = (com.google.android.gms.internal.zzcmb) r8;	 Catch:{ all -> 0x09eb }
        r9 = 0;
    L_0x04aa:
        r10 = r8.zzjlh;	 Catch:{ all -> 0x09eb }
        r10 = r10.length;	 Catch:{ all -> 0x09eb }
        if (r9 >= r10) goto L_0x04df;
    L_0x04af:
        r10 = "_r";
        r11 = r8.zzjlh;	 Catch:{ all -> 0x09eb }
        r11 = r11[r9];	 Catch:{ all -> 0x09eb }
        r11 = r11.name;	 Catch:{ all -> 0x09eb }
        r10 = r10.equals(r11);	 Catch:{ all -> 0x09eb }
        if (r10 == 0) goto L_0x04db;
    L_0x04bd:
        r10 = r8.zzjlh;	 Catch:{ all -> 0x09eb }
        r10 = r10.length;	 Catch:{ all -> 0x09eb }
        r11 = 1;
        r10 = r10 - r11;
        r10 = new com.google.android.gms.internal.zzcmc[r10];	 Catch:{ all -> 0x09eb }
        if (r9 <= 0) goto L_0x04cc;
    L_0x04c6:
        r11 = r8.zzjlh;	 Catch:{ all -> 0x09eb }
        r12 = 0;
        java.lang.System.arraycopy(r11, r12, r10, r12, r9);	 Catch:{ all -> 0x09eb }
    L_0x04cc:
        r11 = r10.length;	 Catch:{ all -> 0x09eb }
        if (r9 >= r11) goto L_0x04d8;
    L_0x04cf:
        r11 = r8.zzjlh;	 Catch:{ all -> 0x09eb }
        r12 = r9 + 1;
        r13 = r10.length;	 Catch:{ all -> 0x09eb }
        r13 = r13 - r9;
        java.lang.System.arraycopy(r11, r12, r10, r9, r13);	 Catch:{ all -> 0x09eb }
    L_0x04d8:
        r8.zzjlh = r10;	 Catch:{ all -> 0x09eb }
        goto L_0x04df;
    L_0x04db:
        r9 = r9 + 1;
        goto L_0x04aa;
    L_0x04de:
        r5 = 1;
    L_0x04df:
        r8 = r2.zzapa;	 Catch:{ all -> 0x09eb }
        r8 = r8.get(r4);	 Catch:{ all -> 0x09eb }
        r8 = (com.google.android.gms.internal.zzcmb) r8;	 Catch:{ all -> 0x09eb }
        r8 = r8.name;	 Catch:{ all -> 0x09eb }
        r8 = com.google.android.gms.internal.zzclq.zzjz(r8);	 Catch:{ all -> 0x09eb }
        if (r8 == 0) goto L_0x0595;
    L_0x04ef:
        if (r7 == 0) goto L_0x0595;
    L_0x04f1:
        r9 = r46.zzaws();	 Catch:{ all -> 0x09eb }
        r10 = r46.zzbag();	 Catch:{ all -> 0x09eb }
        r7 = r2.zzjgi;	 Catch:{ all -> 0x09eb }
        r12 = r7.zzcn;	 Catch:{ all -> 0x09eb }
        r13 = 0;
        r14 = 0;
        r15 = 1;
        r16 = 0;
        r17 = 0;
        r7 = r9.zza(r10, r12, r13, r14, r15, r16, r17);	 Catch:{ all -> 0x09eb }
        r7 = r7.zziyz;	 Catch:{ all -> 0x09eb }
        r9 = r1.zzjew;	 Catch:{ all -> 0x09eb }
        r10 = r2.zzjgi;	 Catch:{ all -> 0x09eb }
        r10 = r10.zzcn;	 Catch:{ all -> 0x09eb }
        r11 = com.google.android.gms.internal.zzchc.zzjaq;	 Catch:{ all -> 0x09eb }
        r9 = r9.zzb(r10, r11);	 Catch:{ all -> 0x09eb }
        r9 = (long) r9;	 Catch:{ all -> 0x09eb }
        r7 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1));
        if (r7 <= 0) goto L_0x0595;
    L_0x051b:
        r7 = r46.zzawy();	 Catch:{ all -> 0x09eb }
        r7 = r7.zzazf();	 Catch:{ all -> 0x09eb }
        r8 = "Too many conversions. Not logging as conversion. appId";
        r9 = r2.zzjgi;	 Catch:{ all -> 0x09eb }
        r9 = r9.zzcn;	 Catch:{ all -> 0x09eb }
        r9 = com.google.android.gms.internal.zzchm.zzjk(r9);	 Catch:{ all -> 0x09eb }
        r7.zzj(r8, r9);	 Catch:{ all -> 0x09eb }
        r7 = r2.zzapa;	 Catch:{ all -> 0x09eb }
        r7 = r7.get(r4);	 Catch:{ all -> 0x09eb }
        r7 = (com.google.android.gms.internal.zzcmb) r7;	 Catch:{ all -> 0x09eb }
        r8 = r7.zzjlh;	 Catch:{ all -> 0x09eb }
        r9 = r8.length;	 Catch:{ all -> 0x09eb }
        r10 = 0;
        r11 = 0;
        r12 = 0;
    L_0x053e:
        if (r10 >= r9) goto L_0x055c;
    L_0x0540:
        r13 = r8[r10];	 Catch:{ all -> 0x09eb }
        r14 = "_c";
        r15 = r13.name;	 Catch:{ all -> 0x09eb }
        r14 = r14.equals(r15);	 Catch:{ all -> 0x09eb }
        if (r14 == 0) goto L_0x054e;
    L_0x054c:
        r12 = r13;
        goto L_0x0559;
    L_0x054e:
        r14 = "_err";
        r13 = r13.name;	 Catch:{ all -> 0x09eb }
        r13 = r14.equals(r13);	 Catch:{ all -> 0x09eb }
        if (r13 == 0) goto L_0x0559;
    L_0x0558:
        r11 = 1;
    L_0x0559:
        r10 = r10 + 1;
        goto L_0x053e;
    L_0x055c:
        if (r11 == 0) goto L_0x0571;
    L_0x055e:
        if (r12 == 0) goto L_0x0571;
    L_0x0560:
        r8 = r7.zzjlh;	 Catch:{ all -> 0x09eb }
        r9 = 1;
        r10 = new com.google.android.gms.internal.zzcmc[r9];	 Catch:{ all -> 0x09eb }
        r9 = 0;
        r10[r9] = r12;	 Catch:{ all -> 0x09eb }
        r8 = com.google.android.gms.common.util.zza.zza(r8, r10);	 Catch:{ all -> 0x09eb }
        r8 = (com.google.android.gms.internal.zzcmc[]) r8;	 Catch:{ all -> 0x09eb }
        r7.zzjlh = r8;	 Catch:{ all -> 0x09eb }
        goto L_0x0595;
    L_0x0571:
        if (r12 == 0) goto L_0x0580;
    L_0x0573:
        r7 = "_err";
        r12.name = r7;	 Catch:{ all -> 0x09eb }
        r7 = 10;
        r7 = java.lang.Long.valueOf(r7);	 Catch:{ all -> 0x09eb }
        r12.zzjll = r7;	 Catch:{ all -> 0x09eb }
        goto L_0x0595;
    L_0x0580:
        r7 = r46.zzawy();	 Catch:{ all -> 0x09eb }
        r7 = r7.zzazd();	 Catch:{ all -> 0x09eb }
        r8 = "Did not find conversion parameter. appId";
        r9 = r2.zzjgi;	 Catch:{ all -> 0x09eb }
        r9 = r9.zzcn;	 Catch:{ all -> 0x09eb }
        r9 = com.google.android.gms.internal.zzchm.zzjk(r9);	 Catch:{ all -> 0x09eb }
        r7.zzj(r8, r9);	 Catch:{ all -> 0x09eb }
    L_0x0595:
        r7 = r3.zzjlp;	 Catch:{ all -> 0x09eb }
        r8 = r6 + 1;
        r9 = r2.zzapa;	 Catch:{ all -> 0x09eb }
        r9 = r9.get(r4);	 Catch:{ all -> 0x09eb }
        r9 = (com.google.android.gms.internal.zzcmb) r9;	 Catch:{ all -> 0x09eb }
        r7[r6] = r9;	 Catch:{ all -> 0x09eb }
        r6 = r8;
    L_0x05a4:
        r4 = r4 + 1;
        r10 = 0;
        r11 = 1;
        goto L_0x029d;
    L_0x05aa:
        r4 = r2.zzapa;	 Catch:{ all -> 0x09eb }
        r4 = r4.size();	 Catch:{ all -> 0x09eb }
        if (r6 >= r4) goto L_0x05bc;
    L_0x05b2:
        r4 = r3.zzjlp;	 Catch:{ all -> 0x09eb }
        r4 = java.util.Arrays.copyOf(r4, r6);	 Catch:{ all -> 0x09eb }
        r4 = (com.google.android.gms.internal.zzcmb[]) r4;	 Catch:{ all -> 0x09eb }
        r3.zzjlp = r4;	 Catch:{ all -> 0x09eb }
    L_0x05bc:
        r4 = r2.zzjgi;	 Catch:{ all -> 0x09eb }
        r4 = r4.zzcn;	 Catch:{ all -> 0x09eb }
        r6 = r2.zzjgi;	 Catch:{ all -> 0x09eb }
        r6 = r6.zzjlq;	 Catch:{ all -> 0x09eb }
        r7 = r3.zzjlp;	 Catch:{ all -> 0x09eb }
        r4 = r1.zza(r4, r6, r7);	 Catch:{ all -> 0x09eb }
        r3.zzjmi = r4;	 Catch:{ all -> 0x09eb }
        r4 = com.google.android.gms.internal.zzchc.zzjac;	 Catch:{ all -> 0x09eb }
        r4 = r4.get();	 Catch:{ all -> 0x09eb }
        r4 = (java.lang.Boolean) r4;	 Catch:{ all -> 0x09eb }
        r4 = r4.booleanValue();	 Catch:{ all -> 0x09eb }
        if (r4 == 0) goto L_0x0879;
    L_0x05da:
        r4 = r1.zzjew;	 Catch:{ all -> 0x09eb }
        r6 = r2.zzjgi;	 Catch:{ all -> 0x09eb }
        r6 = r6.zzcn;	 Catch:{ all -> 0x09eb }
        r7 = "1";
        r4 = r4.zzawv();	 Catch:{ all -> 0x09eb }
        r8 = "measurement.event_sampling_enabled";
        r4 = r4.zzam(r6, r8);	 Catch:{ all -> 0x09eb }
        r4 = r7.equals(r4);	 Catch:{ all -> 0x09eb }
        if (r4 == 0) goto L_0x0879;
    L_0x05f2:
        r4 = new java.util.HashMap;	 Catch:{ all -> 0x09eb }
        r4.<init>();	 Catch:{ all -> 0x09eb }
        r6 = r3.zzjlp;	 Catch:{ all -> 0x09eb }
        r6 = r6.length;	 Catch:{ all -> 0x09eb }
        r6 = new com.google.android.gms.internal.zzcmb[r6];	 Catch:{ all -> 0x09eb }
        r7 = r46.zzawu();	 Catch:{ all -> 0x09eb }
        r7 = r7.zzbaz();	 Catch:{ all -> 0x09eb }
        r8 = r3.zzjlp;	 Catch:{ all -> 0x09eb }
        r9 = r8.length;	 Catch:{ all -> 0x09eb }
        r10 = 0;
        r11 = 0;
    L_0x0609:
        if (r10 >= r9) goto L_0x0843;
    L_0x060b:
        r12 = r8[r10];	 Catch:{ all -> 0x09eb }
        r13 = r12.name;	 Catch:{ all -> 0x09eb }
        r14 = "_ep";
        r13 = r13.equals(r14);	 Catch:{ all -> 0x09eb }
        if (r13 == 0) goto L_0x0695;
    L_0x0617:
        r46.zzawu();	 Catch:{ all -> 0x09eb }
        r13 = "_en";
        r13 = com.google.android.gms.internal.zzclq.zza(r12, r13);	 Catch:{ all -> 0x09eb }
        r13 = (java.lang.String) r13;	 Catch:{ all -> 0x09eb }
        r14 = r4.get(r13);	 Catch:{ all -> 0x09eb }
        r14 = (com.google.android.gms.internal.zzcgw) r14;	 Catch:{ all -> 0x09eb }
        if (r14 != 0) goto L_0x0639;
    L_0x062a:
        r14 = r46.zzaws();	 Catch:{ all -> 0x09eb }
        r15 = r2.zzjgi;	 Catch:{ all -> 0x09eb }
        r15 = r15.zzcn;	 Catch:{ all -> 0x09eb }
        r14 = r14.zzae(r15, r13);	 Catch:{ all -> 0x09eb }
        r4.put(r13, r14);	 Catch:{ all -> 0x09eb }
    L_0x0639:
        r13 = r14.zzizo;	 Catch:{ all -> 0x09eb }
        if (r13 != 0) goto L_0x0686;
    L_0x063d:
        r13 = r14.zzizp;	 Catch:{ all -> 0x09eb }
        r15 = r13.longValue();	 Catch:{ all -> 0x09eb }
        r17 = 1;
        r13 = (r15 > r17 ? 1 : (r15 == r17 ? 0 : -1));
        if (r13 <= 0) goto L_0x065b;
    L_0x0649:
        r46.zzawu();	 Catch:{ all -> 0x09eb }
        r13 = r12.zzjlh;	 Catch:{ all -> 0x09eb }
        r15 = "_sr";
        r25 = r8;
        r8 = r14.zzizp;	 Catch:{ all -> 0x09eb }
        r8 = com.google.android.gms.internal.zzclq.zza(r13, r15, r8);	 Catch:{ all -> 0x09eb }
        r12.zzjlh = r8;	 Catch:{ all -> 0x09eb }
        goto L_0x065d;
    L_0x065b:
        r25 = r8;
    L_0x065d:
        r8 = r14.zzizq;	 Catch:{ all -> 0x09eb }
        if (r8 == 0) goto L_0x067f;
    L_0x0661:
        r8 = r14.zzizq;	 Catch:{ all -> 0x09eb }
        r8 = r8.booleanValue();	 Catch:{ all -> 0x09eb }
        if (r8 == 0) goto L_0x067f;
    L_0x0669:
        r46.zzawu();	 Catch:{ all -> 0x09eb }
        r8 = r12.zzjlh;	 Catch:{ all -> 0x09eb }
        r13 = "_efs";
        r26 = r9;
        r14 = 1;
        r9 = java.lang.Long.valueOf(r14);	 Catch:{ all -> 0x09eb }
        r8 = com.google.android.gms.internal.zzclq.zza(r8, r13, r9);	 Catch:{ all -> 0x09eb }
        r12.zzjlh = r8;	 Catch:{ all -> 0x09eb }
        goto L_0x0681;
    L_0x067f:
        r26 = r9;
    L_0x0681:
        r8 = r11 + 1;
        r6[r11] = r12;	 Catch:{ all -> 0x09eb }
        goto L_0x06d0;
    L_0x0686:
        r25 = r8;
        r26 = r9;
        r43 = r2;
        r44 = r3;
        r8 = r4;
        r42 = r5;
        r41 = r7;
        goto L_0x07ac;
    L_0x0695:
        r25 = r8;
        r26 = r9;
        r8 = "_dbg";
        r13 = 1;
        r9 = java.lang.Long.valueOf(r13);	 Catch:{ all -> 0x09eb }
        r8 = zza(r12, r8, r9);	 Catch:{ all -> 0x09eb }
        if (r8 != 0) goto L_0x06b6;
    L_0x06a7:
        r8 = r46.zzawv();	 Catch:{ all -> 0x09eb }
        r9 = r2.zzjgi;	 Catch:{ all -> 0x09eb }
        r9 = r9.zzcn;	 Catch:{ all -> 0x09eb }
        r13 = r12.name;	 Catch:{ all -> 0x09eb }
        r8 = r8.zzap(r9, r13);	 Catch:{ all -> 0x09eb }
        goto L_0x06b7;
    L_0x06b6:
        r8 = 1;
    L_0x06b7:
        if (r8 > 0) goto L_0x06df;
    L_0x06b9:
        r9 = r46.zzawy();	 Catch:{ all -> 0x09eb }
        r9 = r9.zzazf();	 Catch:{ all -> 0x09eb }
        r13 = "Sample rate must be positive. event, rate";
        r14 = r12.name;	 Catch:{ all -> 0x09eb }
        r8 = java.lang.Integer.valueOf(r8);	 Catch:{ all -> 0x09eb }
        r9.zze(r13, r14, r8);	 Catch:{ all -> 0x09eb }
        r8 = r11 + 1;
        r6[r11] = r12;	 Catch:{ all -> 0x09eb }
    L_0x06d0:
        r43 = r2;
        r44 = r3;
        r42 = r5;
        r41 = r7;
        r11 = r8;
        r3 = 0;
        r8 = r4;
    L_0x06db:
        r4 = 1;
        goto L_0x0832;
    L_0x06df:
        r9 = r12.name;	 Catch:{ all -> 0x09eb }
        r9 = r4.get(r9);	 Catch:{ all -> 0x09eb }
        r9 = (com.google.android.gms.internal.zzcgw) r9;	 Catch:{ all -> 0x09eb }
        if (r9 != 0) goto L_0x072f;
    L_0x06e9:
        r9 = r46.zzaws();	 Catch:{ all -> 0x09eb }
        r13 = r2.zzjgi;	 Catch:{ all -> 0x09eb }
        r13 = r13.zzcn;	 Catch:{ all -> 0x09eb }
        r14 = r12.name;	 Catch:{ all -> 0x09eb }
        r9 = r9.zzae(r13, r14);	 Catch:{ all -> 0x09eb }
        if (r9 != 0) goto L_0x072f;
    L_0x06f9:
        r9 = r46.zzawy();	 Catch:{ all -> 0x09eb }
        r9 = r9.zzazf();	 Catch:{ all -> 0x09eb }
        r13 = "Event being bundled has no eventAggregate. appId, eventName";
        r14 = r2.zzjgi;	 Catch:{ all -> 0x09eb }
        r14 = r14.zzcn;	 Catch:{ all -> 0x09eb }
        r15 = r12.name;	 Catch:{ all -> 0x09eb }
        r9.zze(r13, r14, r15);	 Catch:{ all -> 0x09eb }
        r9 = new com.google.android.gms.internal.zzcgw;	 Catch:{ all -> 0x09eb }
        r13 = r2.zzjgi;	 Catch:{ all -> 0x09eb }
        r13 = r13.zzcn;	 Catch:{ all -> 0x09eb }
        r14 = r12.name;	 Catch:{ all -> 0x09eb }
        r30 = 1;
        r32 = 1;
        r15 = r12.zzjli;	 Catch:{ all -> 0x09eb }
        r34 = r15.longValue();	 Catch:{ all -> 0x09eb }
        r36 = 0;
        r38 = 0;
        r39 = 0;
        r40 = 0;
        r27 = r9;
        r28 = r13;
        r29 = r14;
        r27.<init>(r28, r29, r30, r32, r34, r36, r38, r39, r40);	 Catch:{ all -> 0x09eb }
    L_0x072f:
        r46.zzawu();	 Catch:{ all -> 0x09eb }
        r13 = "_eid";
        r13 = com.google.android.gms.internal.zzclq.zza(r12, r13);	 Catch:{ all -> 0x09eb }
        r13 = (java.lang.Long) r13;	 Catch:{ all -> 0x09eb }
        if (r13 == 0) goto L_0x073e;
    L_0x073c:
        r14 = 1;
        goto L_0x073f;
    L_0x073e:
        r14 = 0;
    L_0x073f:
        r14 = java.lang.Boolean.valueOf(r14);	 Catch:{ all -> 0x09eb }
        r15 = 1;
        if (r8 != r15) goto L_0x0768;
    L_0x0746:
        r8 = r11 + 1;
        r6[r11] = r12;	 Catch:{ all -> 0x09eb }
        r11 = r14.booleanValue();	 Catch:{ all -> 0x09eb }
        if (r11 == 0) goto L_0x06d0;
    L_0x0750:
        r11 = r9.zzizo;	 Catch:{ all -> 0x09eb }
        if (r11 != 0) goto L_0x075c;
    L_0x0754:
        r11 = r9.zzizp;	 Catch:{ all -> 0x09eb }
        if (r11 != 0) goto L_0x075c;
    L_0x0758:
        r11 = r9.zzizq;	 Catch:{ all -> 0x09eb }
        if (r11 == 0) goto L_0x06d0;
    L_0x075c:
        r11 = 0;
        r9 = r9.zza(r11, r11, r11);	 Catch:{ all -> 0x09eb }
        r11 = r12.name;	 Catch:{ all -> 0x09eb }
        r4.put(r11, r9);	 Catch:{ all -> 0x09eb }
        goto L_0x06d0;
    L_0x0768:
        r15 = r7.nextInt(r8);	 Catch:{ all -> 0x09eb }
        if (r15 != 0) goto L_0x07af;
    L_0x076e:
        r46.zzawu();	 Catch:{ all -> 0x09eb }
        r13 = r12.zzjlh;	 Catch:{ all -> 0x09eb }
        r15 = "_sr";
        r41 = r7;
        r7 = (long) r8;	 Catch:{ all -> 0x09eb }
        r42 = r5;
        r5 = java.lang.Long.valueOf(r7);	 Catch:{ all -> 0x09eb }
        r5 = com.google.android.gms.internal.zzclq.zza(r13, r15, r5);	 Catch:{ all -> 0x09eb }
        r12.zzjlh = r5;	 Catch:{ all -> 0x09eb }
        r5 = r11 + 1;
        r6[r11] = r12;	 Catch:{ all -> 0x09eb }
        r11 = r14.booleanValue();	 Catch:{ all -> 0x09eb }
        if (r11 == 0) goto L_0x0797;
    L_0x078e:
        r7 = java.lang.Long.valueOf(r7);	 Catch:{ all -> 0x09eb }
        r8 = 0;
        r9 = r9.zza(r8, r7, r8);	 Catch:{ all -> 0x09eb }
    L_0x0797:
        r7 = r12.name;	 Catch:{ all -> 0x09eb }
        r8 = r12.zzjli;	 Catch:{ all -> 0x09eb }
        r11 = r8.longValue();	 Catch:{ all -> 0x09eb }
        r8 = r9.zzbc(r11);	 Catch:{ all -> 0x09eb }
        r4.put(r7, r8);	 Catch:{ all -> 0x09eb }
        r43 = r2;
        r44 = r3;
        r8 = r4;
        r11 = r5;
    L_0x07ac:
        r3 = 0;
        goto L_0x06db;
    L_0x07af:
        r43 = r2;
        r44 = r3;
        r42 = r5;
        r41 = r7;
        r2 = r9.zzizn;	 Catch:{ all -> 0x09eb }
        r5 = r12.zzjli;	 Catch:{ all -> 0x09eb }
        r15 = r5.longValue();	 Catch:{ all -> 0x09eb }
        r2 = r15 - r2;
        r2 = java.lang.Math.abs(r2);	 Catch:{ all -> 0x09eb }
        r15 = 86400000; // 0x5265c00 float:7.82218E-36 double:4.2687272E-316;
        r2 = (r2 > r15 ? 1 : (r2 == r15 ? 0 : -1));
        if (r2 < 0) goto L_0x081f;
    L_0x07cc:
        r46.zzawu();	 Catch:{ all -> 0x09eb }
        r2 = r12.zzjlh;	 Catch:{ all -> 0x09eb }
        r3 = "_efs";
        r45 = r4;
        r4 = 1;
        r7 = java.lang.Long.valueOf(r4);	 Catch:{ all -> 0x09eb }
        r2 = com.google.android.gms.internal.zzclq.zza(r2, r3, r7);	 Catch:{ all -> 0x09eb }
        r12.zzjlh = r2;	 Catch:{ all -> 0x09eb }
        r46.zzawu();	 Catch:{ all -> 0x09eb }
        r2 = r12.zzjlh;	 Catch:{ all -> 0x09eb }
        r3 = "_sr";
        r7 = (long) r8;	 Catch:{ all -> 0x09eb }
        r13 = java.lang.Long.valueOf(r7);	 Catch:{ all -> 0x09eb }
        r2 = com.google.android.gms.internal.zzclq.zza(r2, r3, r13);	 Catch:{ all -> 0x09eb }
        r12.zzjlh = r2;	 Catch:{ all -> 0x09eb }
        r2 = r11 + 1;
        r6[r11] = r12;	 Catch:{ all -> 0x09eb }
        r3 = r14.booleanValue();	 Catch:{ all -> 0x09eb }
        if (r3 == 0) goto L_0x080b;
    L_0x07fd:
        r3 = java.lang.Long.valueOf(r7);	 Catch:{ all -> 0x09eb }
        r7 = 1;
        r8 = java.lang.Boolean.valueOf(r7);	 Catch:{ all -> 0x09eb }
        r7 = 0;
        r9 = r9.zza(r7, r3, r8);	 Catch:{ all -> 0x09eb }
    L_0x080b:
        r3 = r12.name;	 Catch:{ all -> 0x09eb }
        r7 = r12.zzjli;	 Catch:{ all -> 0x09eb }
        r7 = r7.longValue();	 Catch:{ all -> 0x09eb }
        r7 = r9.zzbc(r7);	 Catch:{ all -> 0x09eb }
        r8 = r45;
        r8.put(r3, r7);	 Catch:{ all -> 0x09eb }
        r11 = r2;
    L_0x081d:
        r3 = 0;
        goto L_0x0832;
    L_0x081f:
        r8 = r4;
        r4 = 1;
        r2 = r14.booleanValue();	 Catch:{ all -> 0x09eb }
        if (r2 == 0) goto L_0x081d;
    L_0x0828:
        r2 = r12.name;	 Catch:{ all -> 0x09eb }
        r3 = 0;
        r7 = r9.zza(r13, r3, r3);	 Catch:{ all -> 0x09eb }
        r8.put(r2, r7);	 Catch:{ all -> 0x09eb }
    L_0x0832:
        r10 = r10 + 1;
        r4 = r8;
        r8 = r25;
        r9 = r26;
        r7 = r41;
        r5 = r42;
        r2 = r43;
        r3 = r44;
        goto L_0x0609;
    L_0x0843:
        r43 = r2;
        r2 = r3;
        r8 = r4;
        r42 = r5;
        r3 = 0;
        r4 = r2.zzjlp;	 Catch:{ all -> 0x09eb }
        r4 = r4.length;	 Catch:{ all -> 0x09eb }
        if (r11 >= r4) goto L_0x0857;
    L_0x084f:
        r4 = java.util.Arrays.copyOf(r6, r11);	 Catch:{ all -> 0x09eb }
        r4 = (com.google.android.gms.internal.zzcmb[]) r4;	 Catch:{ all -> 0x09eb }
        r2.zzjlp = r4;	 Catch:{ all -> 0x09eb }
    L_0x0857:
        r4 = r8.entrySet();	 Catch:{ all -> 0x09eb }
        r4 = r4.iterator();	 Catch:{ all -> 0x09eb }
    L_0x085f:
        r5 = r4.hasNext();	 Catch:{ all -> 0x09eb }
        if (r5 == 0) goto L_0x087f;
    L_0x0865:
        r5 = r4.next();	 Catch:{ all -> 0x09eb }
        r5 = (java.util.Map.Entry) r5;	 Catch:{ all -> 0x09eb }
        r6 = r46.zzaws();	 Catch:{ all -> 0x09eb }
        r5 = r5.getValue();	 Catch:{ all -> 0x09eb }
        r5 = (com.google.android.gms.internal.zzcgw) r5;	 Catch:{ all -> 0x09eb }
        r6.zza(r5);	 Catch:{ all -> 0x09eb }
        goto L_0x085f;
    L_0x0879:
        r43 = r2;
        r2 = r3;
        r42 = r5;
        r3 = 0;
    L_0x087f:
        r4 = 9223372036854775807; // 0x7fffffffffffffff float:NaN double:NaN;
        r4 = java.lang.Long.valueOf(r4);	 Catch:{ all -> 0x09eb }
        r2.zzjls = r4;	 Catch:{ all -> 0x09eb }
        r4 = -9223372036854775808;
        r4 = java.lang.Long.valueOf(r4);	 Catch:{ all -> 0x09eb }
        r2.zzjlt = r4;	 Catch:{ all -> 0x09eb }
        r4 = 0;
    L_0x0893:
        r5 = r2.zzjlp;	 Catch:{ all -> 0x09eb }
        r5 = r5.length;	 Catch:{ all -> 0x09eb }
        if (r4 >= r5) goto L_0x08c7;
    L_0x0898:
        r5 = r2.zzjlp;	 Catch:{ all -> 0x09eb }
        r5 = r5[r4];	 Catch:{ all -> 0x09eb }
        r6 = r5.zzjli;	 Catch:{ all -> 0x09eb }
        r6 = r6.longValue();	 Catch:{ all -> 0x09eb }
        r8 = r2.zzjls;	 Catch:{ all -> 0x09eb }
        r8 = r8.longValue();	 Catch:{ all -> 0x09eb }
        r6 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1));
        if (r6 >= 0) goto L_0x08b0;
    L_0x08ac:
        r6 = r5.zzjli;	 Catch:{ all -> 0x09eb }
        r2.zzjls = r6;	 Catch:{ all -> 0x09eb }
    L_0x08b0:
        r6 = r5.zzjli;	 Catch:{ all -> 0x09eb }
        r6 = r6.longValue();	 Catch:{ all -> 0x09eb }
        r8 = r2.zzjlt;	 Catch:{ all -> 0x09eb }
        r8 = r8.longValue();	 Catch:{ all -> 0x09eb }
        r6 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1));
        if (r6 <= 0) goto L_0x08c4;
    L_0x08c0:
        r5 = r5.zzjli;	 Catch:{ all -> 0x09eb }
        r2.zzjlt = r5;	 Catch:{ all -> 0x09eb }
    L_0x08c4:
        r4 = r4 + 1;
        goto L_0x0893;
    L_0x08c7:
        r4 = r43;
        r5 = r4.zzjgi;	 Catch:{ all -> 0x09eb }
        r5 = r5.zzcn;	 Catch:{ all -> 0x09eb }
        r6 = r46.zzaws();	 Catch:{ all -> 0x09eb }
        r6 = r6.zzjb(r5);	 Catch:{ all -> 0x09eb }
        if (r6 != 0) goto L_0x08ed;
    L_0x08d7:
        r3 = r46.zzawy();	 Catch:{ all -> 0x09eb }
        r3 = r3.zzazd();	 Catch:{ all -> 0x09eb }
        r6 = "Bundling raw events w/o app info. appId";
        r7 = r4.zzjgi;	 Catch:{ all -> 0x09eb }
        r7 = r7.zzcn;	 Catch:{ all -> 0x09eb }
        r7 = com.google.android.gms.internal.zzchm.zzjk(r7);	 Catch:{ all -> 0x09eb }
        r3.zzj(r6, r7);	 Catch:{ all -> 0x09eb }
        goto L_0x0944;
    L_0x08ed:
        r7 = r2.zzjlp;	 Catch:{ all -> 0x09eb }
        r7 = r7.length;	 Catch:{ all -> 0x09eb }
        if (r7 <= 0) goto L_0x0944;
    L_0x08f2:
        r7 = r6.zzaxf();	 Catch:{ all -> 0x09eb }
        r9 = 0;
        r11 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1));
        if (r11 == 0) goto L_0x0901;
    L_0x08fc:
        r11 = java.lang.Long.valueOf(r7);	 Catch:{ all -> 0x09eb }
        goto L_0x0902;
    L_0x0901:
        r11 = r3;
    L_0x0902:
        r2.zzjlv = r11;	 Catch:{ all -> 0x09eb }
        r11 = r6.zzaxe();	 Catch:{ all -> 0x09eb }
        r13 = (r11 > r9 ? 1 : (r11 == r9 ? 0 : -1));
        if (r13 != 0) goto L_0x090d;
    L_0x090c:
        r11 = r7;
    L_0x090d:
        r7 = (r11 > r9 ? 1 : (r11 == r9 ? 0 : -1));
        if (r7 == 0) goto L_0x0915;
    L_0x0911:
        r3 = java.lang.Long.valueOf(r11);	 Catch:{ all -> 0x09eb }
    L_0x0915:
        r2.zzjlu = r3;	 Catch:{ all -> 0x09eb }
        r6.zzaxo();	 Catch:{ all -> 0x09eb }
        r7 = r6.zzaxl();	 Catch:{ all -> 0x09eb }
        r3 = (int) r7;	 Catch:{ all -> 0x09eb }
        r3 = java.lang.Integer.valueOf(r3);	 Catch:{ all -> 0x09eb }
        r2.zzjmg = r3;	 Catch:{ all -> 0x09eb }
        r3 = r2.zzjls;	 Catch:{ all -> 0x09eb }
        r7 = r3.longValue();	 Catch:{ all -> 0x09eb }
        r6.zzal(r7);	 Catch:{ all -> 0x09eb }
        r3 = r2.zzjlt;	 Catch:{ all -> 0x09eb }
        r7 = r3.longValue();	 Catch:{ all -> 0x09eb }
        r6.zzam(r7);	 Catch:{ all -> 0x09eb }
        r3 = r6.zzaxw();	 Catch:{ all -> 0x09eb }
        r2.zzixw = r3;	 Catch:{ all -> 0x09eb }
        r3 = r46.zzaws();	 Catch:{ all -> 0x09eb }
        r3.zza(r6);	 Catch:{ all -> 0x09eb }
    L_0x0944:
        r3 = r2.zzjlp;	 Catch:{ all -> 0x09eb }
        r3 = r3.length;	 Catch:{ all -> 0x09eb }
        if (r3 <= 0) goto L_0x0990;
    L_0x0949:
        r3 = r46.zzawv();	 Catch:{ all -> 0x09eb }
        r6 = r4.zzjgi;	 Catch:{ all -> 0x09eb }
        r6 = r6.zzcn;	 Catch:{ all -> 0x09eb }
        r3 = r3.zzjs(r6);	 Catch:{ all -> 0x09eb }
        if (r3 == 0) goto L_0x0961;
    L_0x0957:
        r6 = r3.zzjkw;	 Catch:{ all -> 0x09eb }
        if (r6 != 0) goto L_0x095c;
    L_0x095b:
        goto L_0x0961;
    L_0x095c:
        r3 = r3.zzjkw;	 Catch:{ all -> 0x09eb }
    L_0x095e:
        r2.zzjmn = r3;	 Catch:{ all -> 0x09eb }
        goto L_0x0987;
    L_0x0961:
        r3 = r4.zzjgi;	 Catch:{ all -> 0x09eb }
        r3 = r3.zzixs;	 Catch:{ all -> 0x09eb }
        r3 = android.text.TextUtils.isEmpty(r3);	 Catch:{ all -> 0x09eb }
        if (r3 == 0) goto L_0x0972;
    L_0x096b:
        r6 = -1;
        r3 = java.lang.Long.valueOf(r6);	 Catch:{ all -> 0x09eb }
        goto L_0x095e;
    L_0x0972:
        r3 = r46.zzawy();	 Catch:{ all -> 0x09eb }
        r3 = r3.zzazf();	 Catch:{ all -> 0x09eb }
        r6 = "Did not find measurement config or missing version info. appId";
        r7 = r4.zzjgi;	 Catch:{ all -> 0x09eb }
        r7 = r7.zzcn;	 Catch:{ all -> 0x09eb }
        r7 = com.google.android.gms.internal.zzchm.zzjk(r7);	 Catch:{ all -> 0x09eb }
        r3.zzj(r6, r7);	 Catch:{ all -> 0x09eb }
    L_0x0987:
        r3 = r46.zzaws();	 Catch:{ all -> 0x09eb }
        r10 = r42;
        r3.zza(r2, r10);	 Catch:{ all -> 0x09eb }
    L_0x0990:
        r2 = r46.zzaws();	 Catch:{ all -> 0x09eb }
        r3 = r4.zzjgj;	 Catch:{ all -> 0x09eb }
        r2.zzah(r3);	 Catch:{ all -> 0x09eb }
        r2 = r46.zzaws();	 Catch:{ all -> 0x09eb }
        r3 = r2.getWritableDatabase();	 Catch:{ all -> 0x09eb }
        r4 = "delete from raw_events_metadata where app_id=? and metadata_fingerprint not in (select distinct metadata_fingerprint from raw_events where app_id=?)";
        r6 = 2;
        r6 = new java.lang.String[r6];	 Catch:{ SQLiteException -> 0x09b0 }
        r7 = 0;
        r6[r7] = r5;	 Catch:{ SQLiteException -> 0x09b0 }
        r7 = 1;
        r6[r7] = r5;	 Catch:{ SQLiteException -> 0x09b0 }
        r3.execSQL(r4, r6);	 Catch:{ SQLiteException -> 0x09b0 }
        goto L_0x09c3;
    L_0x09b0:
        r0 = move-exception;
        r3 = r0;
        r2 = r2.zzawy();	 Catch:{ all -> 0x09eb }
        r2 = r2.zzazd();	 Catch:{ all -> 0x09eb }
        r4 = "Failed to remove unused event metadata. appId";
        r5 = com.google.android.gms.internal.zzchm.zzjk(r5);	 Catch:{ all -> 0x09eb }
        r2.zze(r4, r5, r3);	 Catch:{ all -> 0x09eb }
    L_0x09c3:
        r2 = r46.zzaws();	 Catch:{ all -> 0x09eb }
        r2.setTransactionSuccessful();	 Catch:{ all -> 0x09eb }
        r2 = r46.zzaws();
        r2.endTransaction();
        r2 = 1;
        return r2;
    L_0x09d3:
        r2 = r46.zzaws();	 Catch:{ all -> 0x09eb }
        r2.setTransactionSuccessful();	 Catch:{ all -> 0x09eb }
        r2 = r46.zzaws();
        r2.endTransaction();
        r2 = 0;
        return r2;
    L_0x09e3:
        r0 = move-exception;
    L_0x09e4:
        r2 = r0;
    L_0x09e5:
        if (r9 == 0) goto L_0x09ea;
    L_0x09e7:
        r9.close();	 Catch:{ all -> 0x09eb }
    L_0x09ea:
        throw r2;	 Catch:{ all -> 0x09eb }
    L_0x09eb:
        r0 = move-exception;
        r2 = r0;
        r3 = r46.zzaws();
        r3.endTransaction();
        throw r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzcim.zzg(java.lang.String, long):boolean");
    }

    @android.support.annotation.WorkerThread
    private final com.google.android.gms.internal.zzcgi zzjw(java.lang.String r24) {
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
        r23 = this;
        r1 = r24;
        r0 = r23.zzaws();
        r0 = r0.zzjb(r1);
        r2 = 0;
        if (r0 == 0) goto L_0x0087;
    L_0x000d:
        r3 = r0.zzvj();
        r3 = android.text.TextUtils.isEmpty(r3);
        if (r3 == 0) goto L_0x0018;
    L_0x0017:
        goto L_0x0087;
    L_0x0018:
        r15 = r23;
        r3 = r15.mContext;	 Catch:{ NameNotFoundException -> 0x0049 }
        r3 = com.google.android.gms.internal.zzbhf.zzdb(r3);	 Catch:{ NameNotFoundException -> 0x0049 }
        r4 = 0;	 Catch:{ NameNotFoundException -> 0x0049 }
        r3 = r3.getPackageInfo(r1, r4);	 Catch:{ NameNotFoundException -> 0x0049 }
        r3 = r3.versionName;	 Catch:{ NameNotFoundException -> 0x0049 }
        r4 = r0.zzvj();	 Catch:{ NameNotFoundException -> 0x0049 }
        if (r4 == 0) goto L_0x0049;	 Catch:{ NameNotFoundException -> 0x0049 }
    L_0x002d:
        r4 = r0.zzvj();	 Catch:{ NameNotFoundException -> 0x0049 }
        r3 = r4.equals(r3);	 Catch:{ NameNotFoundException -> 0x0049 }
        if (r3 != 0) goto L_0x0049;	 Catch:{ NameNotFoundException -> 0x0049 }
    L_0x0037:
        r3 = r23.zzawy();	 Catch:{ NameNotFoundException -> 0x0049 }
        r3 = r3.zzazf();	 Catch:{ NameNotFoundException -> 0x0049 }
        r4 = "App version does not match; dropping. appId";	 Catch:{ NameNotFoundException -> 0x0049 }
        r5 = com.google.android.gms.internal.zzchm.zzjk(r24);	 Catch:{ NameNotFoundException -> 0x0049 }
        r3.zzj(r4, r5);	 Catch:{ NameNotFoundException -> 0x0049 }
        return r2;
    L_0x0049:
        r21 = new com.google.android.gms.internal.zzcgi;
        r2 = r0.getGmpAppId();
        r3 = r0.zzvj();
        r4 = r0.zzaxg();
        r6 = r0.zzaxh();
        r7 = r0.zzaxi();
        r9 = r0.zzaxj();
        r11 = 0;
        r12 = r0.zzaxk();
        r13 = 0;
        r14 = r0.zzaxd();
        r16 = r0.zzaxx();
        r18 = 0;
        r20 = 0;
        r22 = r0.zzaxy();
        r0 = r21;
        r15 = r16;
        r17 = r18;
        r19 = r20;
        r20 = r22;
        r0.<init>(r1, r2, r3, r4, r6, r7, r9, r11, r12, r13, r14, r15, r17, r19, r20);
        return r21;
    L_0x0087:
        r0 = r23.zzawy();
        r0 = r0.zzazi();
        r3 = "No app data available; dropping";
        r0.zzj(r3, r1);
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzcim.zzjw(java.lang.String):com.google.android.gms.internal.zzcgi");
    }

    public final Context getContext() {
        return this.mContext;
    }

    @WorkerThread
    public final boolean isEnabled() {
        zzawx().zzve();
        zzxf();
        boolean z = false;
        if (this.zzjew.zzaya()) {
            return false;
        }
        Boolean zziy = this.zzjew.zziy("firebase_analytics_collection_enabled");
        if (zziy != null) {
            z = zziy.booleanValue();
        } else if (!zzbz.zzaji()) {
            z = true;
        }
        return zzawz().zzbn(z);
    }

    @WorkerThread
    protected final void start() {
        zzawx().zzve();
        zzaws().zzayh();
        if (zzawz().zzjcr.get() == 0) {
            zzawz().zzjcr.set(this.zzata.currentTimeMillis());
        }
        if (Long.valueOf(zzawz().zzjcw.get()).longValue() == 0) {
            zzawy().zzazj().zzj("Persisting first open", Long.valueOf(this.zzjgg));
            zzawz().zzjcw.set(this.zzjgg);
        }
        if (zzazv()) {
            if (!TextUtils.isEmpty(zzawn().getGmpAppId())) {
                String zzazm = zzawz().zzazm();
                if (zzazm == null) {
                    zzawz().zzjo(zzawn().getGmpAppId());
                } else if (!zzazm.equals(zzawn().getGmpAppId())) {
                    zzawy().zzazh().log("Rechecking which service to use due to a GMP App Id change");
                    zzawz().zzazp();
                    this.zzjfk.disconnect();
                    this.zzjfk.zzyc();
                    zzawz().zzjo(zzawn().getGmpAppId());
                    zzawz().zzjcw.set(this.zzjgg);
                    zzawz().zzjcx.zzjq(null);
                }
            }
            zzawm().zzjp(zzawz().zzjcx.zzazr());
            if (!TextUtils.isEmpty(zzawn().getGmpAppId())) {
                zzcjk zzawm = zzawm();
                zzawm.zzve();
                zzawm.zzxf();
                if (zzawm.zziwf.zzazv()) {
                    zzawm.zzawp().zzbar();
                    String zzazq = zzawm.zzawz().zzazq();
                    if (!TextUtils.isEmpty(zzazq)) {
                        zzawm.zzawo().zzxf();
                        if (!zzazq.equals(VERSION.RELEASE)) {
                            Bundle bundle = new Bundle();
                            bundle.putString("_po", zzazq);
                            zzawm.zzc("auto", "_ou", bundle);
                        }
                    }
                }
                zzawp().zza(new AtomicReference());
            }
        } else if (isEnabled()) {
            if (!zzawu().zzeb("android.permission.INTERNET")) {
                zzawy().zzazd().log("App is missing INTERNET permission");
            }
            if (!zzawu().zzeb("android.permission.ACCESS_NETWORK_STATE")) {
                zzawy().zzazd().log("App is missing ACCESS_NETWORK_STATE permission");
            }
            if (!zzbhf.zzdb(this.mContext).zzamu()) {
                if (!zzcid.zzbk(this.mContext)) {
                    zzawy().zzazd().log("AppMeasurementReceiver not registered/enabled");
                }
                if (!zzcla.zzk(this.mContext, false)) {
                    zzawy().zzazd().log("AppMeasurementService not registered/enabled");
                }
            }
            zzawy().zzazd().log("Uploading is not possible. App measurement disabled");
        }
        zzbaj();
    }

    @WorkerThread
    protected final void zza(int i, Throwable th, byte[] bArr) {
        zzcjk zzaws;
        zzawx().zzve();
        zzxf();
        if (bArr == null) {
            try {
                bArr = new byte[0];
            } catch (Throwable th2) {
                this.zzjge = false;
                zzban();
            }
        }
        List<Long> list = this.zzjfx;
        this.zzjfx = null;
        int i2 = 1;
        if ((i == Callback.DEFAULT_DRAG_ANIMATION_DURATION || i == 204) && th == null) {
            try {
                zzawz().zzjcr.set(this.zzata.currentTimeMillis());
                zzawz().zzjcs.set(0);
                zzbaj();
                zzawy().zzazj().zze("Successful upload. Got network response. code, size", Integer.valueOf(i), Integer.valueOf(bArr.length));
                zzaws().beginTransaction();
                try {
                    for (Long l : list) {
                        zzaws = zzaws();
                        long longValue = l.longValue();
                        zzaws.zzve();
                        zzaws.zzxf();
                        if (zzaws.getWritableDatabase().delete("queue", "rowid=?", new String[]{String.valueOf(longValue)}) != 1) {
                            throw new SQLiteException("Deleted fewer rows from queue than expected");
                        }
                    }
                    zzaws().setTransactionSuccessful();
                    zzaws().endTransaction();
                    if (zzbab().zzzs() && zzbai()) {
                        zzbah();
                    } else {
                        this.zzjgb = -1;
                        zzbaj();
                    }
                    this.zzjgc = 0;
                } catch (SQLiteException e) {
                    zzaws.zzawy().zzazd().zzj("Failed to delete a bundle in a queue table", e);
                    throw e;
                } catch (Throwable th3) {
                    zzaws().endTransaction();
                }
            } catch (SQLiteException e2) {
                zzawy().zzazd().zzj("Database error while trying to delete uploaded bundles", e2);
                this.zzjgc = this.zzata.elapsedRealtime();
                zzawy().zzazj().zzj("Disable upload, time", Long.valueOf(this.zzjgc));
            }
        } else {
            zzawy().zzazj().zze("Network upload failed. Will retry later. code, error", Integer.valueOf(i), th);
            zzawz().zzjcs.set(this.zzata.currentTimeMillis());
            if (i != 503) {
                if (i != 429) {
                    i2 = 0;
                }
            }
            if (i2 != 0) {
                zzawz().zzjct.set(this.zzata.currentTimeMillis());
            }
            zzbaj();
        }
        this.zzjge = false;
        zzban();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    @android.support.annotation.WorkerThread
    public final byte[] zza(@android.support.annotation.NonNull com.google.android.gms.internal.zzcha r34, @android.support.annotation.Size(min = 1) java.lang.String r35) {
        /*
        r33 = this;
        r11 = r33;
        r1 = r34;
        r10 = r35;
        r33.zzxf();
        r2 = r33.zzawx();
        r2.zzve();
        zzawi();
        com.google.android.gms.common.internal.zzbq.checkNotNull(r34);
        com.google.android.gms.common.internal.zzbq.zzgm(r35);
        r8 = new com.google.android.gms.internal.zzcmd;
        r8.<init>();
        r2 = r33.zzaws();
        r2.beginTransaction();
        r2 = r33.zzaws();	 Catch:{ all -> 0x0392 }
        r9 = r2.zzjb(r10);	 Catch:{ all -> 0x0392 }
        r6 = 0;
        if (r9 != 0) goto L_0x004c;
    L_0x0030:
        r1 = r33.zzawy();	 Catch:{ all -> 0x0047 }
        r1 = r1.zzazi();	 Catch:{ all -> 0x0047 }
        r2 = "Log and bundle not available. package_name";
        r1.zzj(r2, r10);	 Catch:{ all -> 0x0047 }
    L_0x003d:
        r1 = new byte[r6];	 Catch:{ all -> 0x0047 }
        r2 = r33.zzaws();
        r2.endTransaction();
        return r1;
    L_0x0047:
        r0 = move-exception;
        r1 = r0;
        r5 = r11;
        goto L_0x0395;
    L_0x004c:
        r2 = r9.zzaxk();	 Catch:{ all -> 0x0392 }
        if (r2 != 0) goto L_0x0060;
    L_0x0052:
        r1 = r33.zzawy();	 Catch:{ all -> 0x0047 }
        r1 = r1.zzazi();	 Catch:{ all -> 0x0047 }
        r2 = "Log and bundle disabled. package_name";
        r1.zzj(r2, r10);	 Catch:{ all -> 0x0047 }
        goto L_0x003d;
    L_0x0060:
        r2 = "_iap";
        r3 = r1.name;	 Catch:{ all -> 0x0392 }
        r2 = r2.equals(r3);	 Catch:{ all -> 0x0392 }
        if (r2 != 0) goto L_0x0074;
    L_0x006a:
        r2 = "ecommerce_purchase";
        r3 = r1.name;	 Catch:{ all -> 0x0047 }
        r2 = r2.equals(r3);	 Catch:{ all -> 0x0047 }
        if (r2 == 0) goto L_0x008b;
    L_0x0074:
        r2 = r11.zza(r10, r1);	 Catch:{ all -> 0x0392 }
        if (r2 != 0) goto L_0x008b;
    L_0x007a:
        r2 = r33.zzawy();	 Catch:{ all -> 0x0047 }
        r2 = r2.zzazf();	 Catch:{ all -> 0x0047 }
        r3 = "Failed to handle purchase event at single event bundle creation. appId";
        r4 = com.google.android.gms.internal.zzchm.zzjk(r35);	 Catch:{ all -> 0x0047 }
        r2.zzj(r3, r4);	 Catch:{ all -> 0x0047 }
    L_0x008b:
        r7 = new com.google.android.gms.internal.zzcme;	 Catch:{ all -> 0x0392 }
        r7.<init>();	 Catch:{ all -> 0x0392 }
        r5 = 1;
        r2 = new com.google.android.gms.internal.zzcme[r5];	 Catch:{ all -> 0x0392 }
        r2[r6] = r7;	 Catch:{ all -> 0x0392 }
        r8.zzjlm = r2;	 Catch:{ all -> 0x0392 }
        r2 = java.lang.Integer.valueOf(r5);	 Catch:{ all -> 0x0392 }
        r7.zzjlo = r2;	 Catch:{ all -> 0x0392 }
        r2 = "android";
        r7.zzjlw = r2;	 Catch:{ all -> 0x0392 }
        r2 = r9.getAppId();	 Catch:{ all -> 0x0392 }
        r7.zzcn = r2;	 Catch:{ all -> 0x0392 }
        r2 = r9.zzaxh();	 Catch:{ all -> 0x0392 }
        r7.zzixt = r2;	 Catch:{ all -> 0x0392 }
        r2 = r9.zzvj();	 Catch:{ all -> 0x0392 }
        r7.zzifm = r2;	 Catch:{ all -> 0x0392 }
        r2 = r9.zzaxg();	 Catch:{ all -> 0x0392 }
        r12 = -2147483648; // 0xffffffff80000000 float:-0.0 double:NaN;
        r4 = (r2 > r12 ? 1 : (r2 == r12 ? 0 : -1));
        r15 = 0;
        if (r4 != 0) goto L_0x00c1;
    L_0x00bf:
        r2 = r15;
        goto L_0x00c6;
    L_0x00c1:
        r2 = (int) r2;	 Catch:{ all -> 0x0392 }
        r2 = java.lang.Integer.valueOf(r2);	 Catch:{ all -> 0x0392 }
    L_0x00c6:
        r7.zzjmj = r2;	 Catch:{ all -> 0x0392 }
        r2 = r9.zzaxi();	 Catch:{ all -> 0x0392 }
        r2 = java.lang.Long.valueOf(r2);	 Catch:{ all -> 0x0392 }
        r7.zzjma = r2;	 Catch:{ all -> 0x0392 }
        r2 = r9.getGmpAppId();	 Catch:{ all -> 0x0392 }
        r7.zzixs = r2;	 Catch:{ all -> 0x0392 }
        r2 = r9.zzaxj();	 Catch:{ all -> 0x0392 }
        r2 = java.lang.Long.valueOf(r2);	 Catch:{ all -> 0x0392 }
        r7.zzjmf = r2;	 Catch:{ all -> 0x0392 }
        r2 = r33.isEnabled();	 Catch:{ all -> 0x0392 }
        if (r2 == 0) goto L_0x00fd;
    L_0x00e8:
        r2 = com.google.android.gms.internal.zzcgn.zzaye();	 Catch:{ all -> 0x0047 }
        if (r2 == 0) goto L_0x00fd;
    L_0x00ee:
        r2 = r11.zzjew;	 Catch:{ all -> 0x0047 }
        r3 = r7.zzcn;	 Catch:{ all -> 0x0047 }
        r2 = r2.zziz(r3);	 Catch:{ all -> 0x0047 }
        if (r2 == 0) goto L_0x00fd;
    L_0x00f8:
        r33.zzawn();	 Catch:{ all -> 0x0047 }
        r7.zzjmo = r15;	 Catch:{ all -> 0x0047 }
    L_0x00fd:
        r2 = r33.zzawz();	 Catch:{ all -> 0x0392 }
        r3 = r9.getAppId();	 Catch:{ all -> 0x0392 }
        r2 = r2.zzjm(r3);	 Catch:{ all -> 0x0392 }
        r3 = r9.zzaxy();	 Catch:{ all -> 0x0392 }
        if (r3 == 0) goto L_0x0127;
    L_0x010f:
        if (r2 == 0) goto L_0x0127;
    L_0x0111:
        r3 = r2.first;	 Catch:{ all -> 0x0047 }
        r3 = (java.lang.CharSequence) r3;	 Catch:{ all -> 0x0047 }
        r3 = android.text.TextUtils.isEmpty(r3);	 Catch:{ all -> 0x0047 }
        if (r3 != 0) goto L_0x0127;
    L_0x011b:
        r3 = r2.first;	 Catch:{ all -> 0x0047 }
        r3 = (java.lang.String) r3;	 Catch:{ all -> 0x0047 }
        r7.zzjmc = r3;	 Catch:{ all -> 0x0047 }
        r2 = r2.second;	 Catch:{ all -> 0x0047 }
        r2 = (java.lang.Boolean) r2;	 Catch:{ all -> 0x0047 }
        r7.zzjmd = r2;	 Catch:{ all -> 0x0047 }
    L_0x0127:
        r2 = r33.zzawo();	 Catch:{ all -> 0x0392 }
        r2.zzxf();	 Catch:{ all -> 0x0392 }
        r2 = android.os.Build.MODEL;	 Catch:{ all -> 0x0392 }
        r7.zzjlx = r2;	 Catch:{ all -> 0x0392 }
        r2 = r33.zzawo();	 Catch:{ all -> 0x0392 }
        r2.zzxf();	 Catch:{ all -> 0x0392 }
        r2 = android.os.Build.VERSION.RELEASE;	 Catch:{ all -> 0x0392 }
        r7.zzdb = r2;	 Catch:{ all -> 0x0392 }
        r2 = r33.zzawo();	 Catch:{ all -> 0x0392 }
        r2 = r2.zzayu();	 Catch:{ all -> 0x0392 }
        r2 = (int) r2;	 Catch:{ all -> 0x0392 }
        r2 = java.lang.Integer.valueOf(r2);	 Catch:{ all -> 0x0392 }
        r7.zzjlz = r2;	 Catch:{ all -> 0x0392 }
        r2 = r33.zzawo();	 Catch:{ all -> 0x0392 }
        r2 = r2.zzayv();	 Catch:{ all -> 0x0392 }
        r7.zzjly = r2;	 Catch:{ all -> 0x0392 }
        r2 = r9.getAppInstanceId();	 Catch:{ all -> 0x0392 }
        r7.zzjme = r2;	 Catch:{ all -> 0x0392 }
        r2 = r9.zzaxd();	 Catch:{ all -> 0x0392 }
        r7.zziya = r2;	 Catch:{ all -> 0x0392 }
        r2 = r33.zzaws();	 Catch:{ all -> 0x0392 }
        r3 = r9.getAppId();	 Catch:{ all -> 0x0392 }
        r2 = r2.zzja(r3);	 Catch:{ all -> 0x0392 }
        r3 = r2.size();	 Catch:{ all -> 0x0392 }
        r3 = new com.google.android.gms.internal.zzcmg[r3];	 Catch:{ all -> 0x0392 }
        r7.zzjlq = r3;	 Catch:{ all -> 0x0392 }
        r3 = r6;
    L_0x0177:
        r4 = r2.size();	 Catch:{ all -> 0x0392 }
        if (r3 >= r4) goto L_0x01b0;
    L_0x017d:
        r4 = new com.google.android.gms.internal.zzcmg;	 Catch:{ all -> 0x0047 }
        r4.<init>();	 Catch:{ all -> 0x0047 }
        r12 = r7.zzjlq;	 Catch:{ all -> 0x0047 }
        r12[r3] = r4;	 Catch:{ all -> 0x0047 }
        r12 = r2.get(r3);	 Catch:{ all -> 0x0047 }
        r12 = (com.google.android.gms.internal.zzclp) r12;	 Catch:{ all -> 0x0047 }
        r12 = r12.mName;	 Catch:{ all -> 0x0047 }
        r4.name = r12;	 Catch:{ all -> 0x0047 }
        r12 = r2.get(r3);	 Catch:{ all -> 0x0047 }
        r12 = (com.google.android.gms.internal.zzclp) r12;	 Catch:{ all -> 0x0047 }
        r12 = r12.zzjjm;	 Catch:{ all -> 0x0047 }
        r12 = java.lang.Long.valueOf(r12);	 Catch:{ all -> 0x0047 }
        r4.zzjms = r12;	 Catch:{ all -> 0x0047 }
        r12 = r33.zzawu();	 Catch:{ all -> 0x0047 }
        r13 = r2.get(r3);	 Catch:{ all -> 0x0047 }
        r13 = (com.google.android.gms.internal.zzclp) r13;	 Catch:{ all -> 0x0047 }
        r13 = r13.mValue;	 Catch:{ all -> 0x0047 }
        r12.zza(r4, r13);	 Catch:{ all -> 0x0047 }
        r3 = r3 + 1;
        goto L_0x0177;
    L_0x01b0:
        r2 = r1.zzizt;	 Catch:{ all -> 0x0392 }
        r4 = r2.zzayx();	 Catch:{ all -> 0x0392 }
        r2 = "_iap";
        r3 = r1.name;	 Catch:{ all -> 0x0392 }
        r2 = r2.equals(r3);	 Catch:{ all -> 0x0392 }
        r12 = 1;
        if (r2 == 0) goto L_0x01d9;
    L_0x01c2:
        r2 = "_c";
        r4.putLong(r2, r12);	 Catch:{ all -> 0x0047 }
        r2 = r33.zzawy();	 Catch:{ all -> 0x0047 }
        r2 = r2.zzazi();	 Catch:{ all -> 0x0047 }
        r3 = "Marking in-app purchase as real-time";
        r2.log(r3);	 Catch:{ all -> 0x0047 }
        r2 = "_r";
        r4.putLong(r2, r12);	 Catch:{ all -> 0x0047 }
    L_0x01d9:
        r2 = "_o";
        r3 = r1.zziyf;	 Catch:{ all -> 0x0392 }
        r4.putString(r2, r3);	 Catch:{ all -> 0x0392 }
        r2 = r33.zzawu();	 Catch:{ all -> 0x0392 }
        r3 = r7.zzcn;	 Catch:{ all -> 0x0392 }
        r2 = r2.zzkj(r3);	 Catch:{ all -> 0x0392 }
        if (r2 == 0) goto L_0x0206;
    L_0x01ec:
        r2 = r33.zzawu();	 Catch:{ all -> 0x0047 }
        r3 = "_dbg";
        r14 = java.lang.Long.valueOf(r12);	 Catch:{ all -> 0x0047 }
        r2.zza(r4, r3, r14);	 Catch:{ all -> 0x0047 }
        r2 = r33.zzawu();	 Catch:{ all -> 0x0047 }
        r3 = "_r";
        r12 = java.lang.Long.valueOf(r12);	 Catch:{ all -> 0x0047 }
        r2.zza(r4, r3, r12);	 Catch:{ all -> 0x0047 }
    L_0x0206:
        r2 = r33.zzaws();	 Catch:{ all -> 0x0392 }
        r3 = r1.name;	 Catch:{ all -> 0x0392 }
        r2 = r2.zzae(r10, r3);	 Catch:{ all -> 0x0392 }
        r26 = 0;
        if (r2 != 0) goto L_0x023f;
    L_0x0214:
        r2 = new com.google.android.gms.internal.zzcgw;	 Catch:{ all -> 0x0047 }
        r14 = r1.name;	 Catch:{ all -> 0x0047 }
        r16 = 1;
        r18 = 0;
        r12 = r1.zzizu;	 Catch:{ all -> 0x0047 }
        r21 = 0;
        r23 = 0;
        r24 = 0;
        r25 = 0;
        r28 = r12;
        r12 = r2;
        r13 = r10;
        r30 = r15;
        r15 = r16;
        r17 = r18;
        r19 = r28;
        r12.<init>(r13, r14, r15, r17, r19, r21, r23, r24, r25);	 Catch:{ all -> 0x0047 }
        r3 = r33.zzaws();	 Catch:{ all -> 0x0047 }
        r3.zza(r2);	 Catch:{ all -> 0x0047 }
        r12 = r26;
        goto L_0x0254;
    L_0x023f:
        r30 = r15;
        r12 = r2.zzizm;	 Catch:{ all -> 0x0392 }
        r14 = r1.zzizu;	 Catch:{ all -> 0x0392 }
        r2 = r2.zzbb(r14);	 Catch:{ all -> 0x0392 }
        r2 = r2.zzayw();	 Catch:{ all -> 0x0392 }
        r3 = r33.zzaws();	 Catch:{ all -> 0x0392 }
        r3.zza(r2);	 Catch:{ all -> 0x0392 }
    L_0x0254:
        r14 = new com.google.android.gms.internal.zzcgv;	 Catch:{ all -> 0x0392 }
        r3 = r1.zziyf;	 Catch:{ all -> 0x0392 }
        r15 = r1.name;	 Catch:{ all -> 0x0392 }
        r1 = r1.zzizu;	 Catch:{ all -> 0x0392 }
        r16 = r1;
        r1 = r14;
        r2 = r11;
        r18 = r4;
        r4 = r10;
        r11 = r5;
        r5 = r15;
        r15 = r7;
        r6 = r16;
        r31 = r8;
        r32 = r9;
        r8 = r12;
        r10 = r18;
        r1.<init>(r2, r3, r4, r5, r6, r8, r10);	 Catch:{ all -> 0x038e }
        r1 = new com.google.android.gms.internal.zzcmb;	 Catch:{ all -> 0x038e }
        r1.<init>();	 Catch:{ all -> 0x038e }
        r2 = new com.google.android.gms.internal.zzcmb[r11];	 Catch:{ all -> 0x038e }
        r3 = 0;
        r2[r3] = r1;	 Catch:{ all -> 0x038e }
        r15.zzjlp = r2;	 Catch:{ all -> 0x038e }
        r4 = r14.zzfij;	 Catch:{ all -> 0x038e }
        r2 = java.lang.Long.valueOf(r4);	 Catch:{ all -> 0x038e }
        r1.zzjli = r2;	 Catch:{ all -> 0x038e }
        r2 = r14.mName;	 Catch:{ all -> 0x038e }
        r1.name = r2;	 Catch:{ all -> 0x038e }
        r4 = r14.zzizi;	 Catch:{ all -> 0x038e }
        r2 = java.lang.Long.valueOf(r4);	 Catch:{ all -> 0x038e }
        r1.zzjlj = r2;	 Catch:{ all -> 0x038e }
        r2 = r14.zzizj;	 Catch:{ all -> 0x038e }
        r2 = r2.size();	 Catch:{ all -> 0x038e }
        r2 = new com.google.android.gms.internal.zzcmc[r2];	 Catch:{ all -> 0x038e }
        r1.zzjlh = r2;	 Catch:{ all -> 0x038e }
        r2 = r14.zzizj;	 Catch:{ all -> 0x038e }
        r2 = r2.iterator();	 Catch:{ all -> 0x038e }
        r4 = r3;
    L_0x02a3:
        r5 = r2.hasNext();	 Catch:{ all -> 0x038e }
        if (r5 == 0) goto L_0x02cd;
    L_0x02a9:
        r5 = r2.next();	 Catch:{ all -> 0x038e }
        r5 = (java.lang.String) r5;	 Catch:{ all -> 0x038e }
        r6 = new com.google.android.gms.internal.zzcmc;	 Catch:{ all -> 0x038e }
        r6.<init>();	 Catch:{ all -> 0x038e }
        r7 = r1.zzjlh;	 Catch:{ all -> 0x038e }
        r8 = r4 + 1;
        r7[r4] = r6;	 Catch:{ all -> 0x038e }
        r6.name = r5;	 Catch:{ all -> 0x038e }
        r4 = r14.zzizj;	 Catch:{ all -> 0x038e }
        r4 = r4.get(r5);	 Catch:{ all -> 0x038e }
        r5 = r33;
        r7 = r33.zzawu();	 Catch:{ all -> 0x038c }
        r7.zza(r6, r4);	 Catch:{ all -> 0x038c }
        r4 = r8;
        goto L_0x02a3;
    L_0x02cd:
        r2 = r32;
        r5 = r33;
        r4 = r2.getAppId();	 Catch:{ all -> 0x038c }
        r6 = r15.zzjlq;	 Catch:{ all -> 0x038c }
        r7 = r15.zzjlp;	 Catch:{ all -> 0x038c }
        r4 = r5.zza(r4, r6, r7);	 Catch:{ all -> 0x038c }
        r15.zzjmi = r4;	 Catch:{ all -> 0x038c }
        r4 = r1.zzjli;	 Catch:{ all -> 0x038c }
        r15.zzjls = r4;	 Catch:{ all -> 0x038c }
        r1 = r1.zzjli;	 Catch:{ all -> 0x038c }
        r15.zzjlt = r1;	 Catch:{ all -> 0x038c }
        r6 = r2.zzaxf();	 Catch:{ all -> 0x038c }
        r1 = (r6 > r26 ? 1 : (r6 == r26 ? 0 : -1));
        if (r1 == 0) goto L_0x02f4;
    L_0x02ef:
        r1 = java.lang.Long.valueOf(r6);	 Catch:{ all -> 0x038c }
        goto L_0x02f6;
    L_0x02f4:
        r1 = r30;
    L_0x02f6:
        r15.zzjlv = r1;	 Catch:{ all -> 0x038c }
        r8 = r2.zzaxe();	 Catch:{ all -> 0x038c }
        r1 = (r8 > r26 ? 1 : (r8 == r26 ? 0 : -1));
        if (r1 != 0) goto L_0x0301;
    L_0x0300:
        goto L_0x0302;
    L_0x0301:
        r6 = r8;
    L_0x0302:
        r1 = (r6 > r26 ? 1 : (r6 == r26 ? 0 : -1));
        if (r1 == 0) goto L_0x030b;
    L_0x0306:
        r1 = java.lang.Long.valueOf(r6);	 Catch:{ all -> 0x038c }
        goto L_0x030d;
    L_0x030b:
        r1 = r30;
    L_0x030d:
        r15.zzjlu = r1;	 Catch:{ all -> 0x038c }
        r2.zzaxo();	 Catch:{ all -> 0x038c }
        r6 = r2.zzaxl();	 Catch:{ all -> 0x038c }
        r1 = (int) r6;	 Catch:{ all -> 0x038c }
        r1 = java.lang.Integer.valueOf(r1);	 Catch:{ all -> 0x038c }
        r15.zzjmg = r1;	 Catch:{ all -> 0x038c }
        r6 = 11910; // 0x2e86 float:1.669E-41 double:5.8843E-320;
        r1 = java.lang.Long.valueOf(r6);	 Catch:{ all -> 0x038c }
        r15.zzjmb = r1;	 Catch:{ all -> 0x038c }
        r1 = r5.zzata;	 Catch:{ all -> 0x038c }
        r6 = r1.currentTimeMillis();	 Catch:{ all -> 0x038c }
        r1 = java.lang.Long.valueOf(r6);	 Catch:{ all -> 0x038c }
        r15.zzjlr = r1;	 Catch:{ all -> 0x038c }
        r1 = java.lang.Boolean.TRUE;	 Catch:{ all -> 0x038c }
        r15.zzjmh = r1;	 Catch:{ all -> 0x038c }
        r1 = r15.zzjls;	 Catch:{ all -> 0x038c }
        r6 = r1.longValue();	 Catch:{ all -> 0x038c }
        r2.zzal(r6);	 Catch:{ all -> 0x038c }
        r1 = r15.zzjlt;	 Catch:{ all -> 0x038c }
        r6 = r1.longValue();	 Catch:{ all -> 0x038c }
        r2.zzam(r6);	 Catch:{ all -> 0x038c }
        r1 = r33.zzaws();	 Catch:{ all -> 0x038c }
        r1.zza(r2);	 Catch:{ all -> 0x038c }
        r1 = r33.zzaws();	 Catch:{ all -> 0x038c }
        r1.setTransactionSuccessful();	 Catch:{ all -> 0x038c }
        r1 = r33.zzaws();
        r1.endTransaction();
        r1 = r31;
        r2 = r1.zzho();	 Catch:{ IOException -> 0x0378 }
        r2 = new byte[r2];	 Catch:{ IOException -> 0x0378 }
        r4 = r2.length;	 Catch:{ IOException -> 0x0378 }
        r3 = com.google.android.gms.internal.zzfjk.zzo(r2, r3, r4);	 Catch:{ IOException -> 0x0378 }
        r1.zza(r3);	 Catch:{ IOException -> 0x0378 }
        r3.zzcwt();	 Catch:{ IOException -> 0x0378 }
        r1 = r33.zzawu();	 Catch:{ IOException -> 0x0378 }
        r1 = r1.zzq(r2);	 Catch:{ IOException -> 0x0378 }
        return r1;
    L_0x0378:
        r0 = move-exception;
        r1 = r0;
        r2 = r33.zzawy();
        r2 = r2.zzazd();
        r3 = "Data loss. Failed to bundle and serialize. appId";
        r4 = com.google.android.gms.internal.zzchm.zzjk(r35);
        r2.zze(r3, r4, r1);
        return r30;
    L_0x038c:
        r0 = move-exception;
        goto L_0x0394;
    L_0x038e:
        r0 = move-exception;
        r5 = r33;
        goto L_0x0394;
    L_0x0392:
        r0 = move-exception;
        r5 = r11;
    L_0x0394:
        r1 = r0;
    L_0x0395:
        r2 = r33.zzaws();
        r2.endTransaction();
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzcim.zza(com.google.android.gms.internal.zzcha, java.lang.String):byte[]");
    }

    public final zzcgd zzawk() {
        zza(this.zzjfr);
        return this.zzjfr;
    }

    public final zzcgk zzawl() {
        zza(this.zzjfq);
        return this.zzjfq;
    }

    public final zzcjn zzawm() {
        zza(this.zzjfm);
        return this.zzjfm;
    }

    public final zzchh zzawn() {
        zza(this.zzjfn);
        return this.zzjfn;
    }

    public final zzcgu zzawo() {
        zza(this.zzjfl);
        return this.zzjfl;
    }

    public final zzckg zzawp() {
        zza(this.zzjfk);
        return this.zzjfk;
    }

    public final zzckc zzawq() {
        zza(this.zzjfj);
        return this.zzjfj;
    }

    public final zzchi zzawr() {
        zza(this.zzjfh);
        return this.zzjfh;
    }

    public final zzcgo zzaws() {
        zza(this.zzjfg);
        return this.zzjfg;
    }

    public final zzchk zzawt() {
        zza(this.zzjff);
        return this.zzjff;
    }

    public final zzclq zzawu() {
        zza(this.zzjfe);
        return this.zzjfe;
    }

    public final zzcig zzawv() {
        zza(this.zzjfb);
        return this.zzjfb;
    }

    public final zzclf zzaww() {
        zza(this.zzjfa);
        return this.zzjfa;
    }

    public final zzcih zzawx() {
        zza(this.zzjez);
        return this.zzjez;
    }

    public final zzchm zzawy() {
        zza(this.zzjey);
        return this.zzjey;
    }

    public final zzchx zzawz() {
        zza(this.zzjex);
        return this.zzjex;
    }

    public final zzcgn zzaxa() {
        return this.zzjew;
    }

    @WorkerThread
    protected final boolean zzazv() {
        zzxf();
        zzawx().zzve();
        if (this.zzjft == null || this.zzjfu == 0 || !(this.zzjft == null || this.zzjft.booleanValue() || Math.abs(this.zzata.elapsedRealtime() - this.zzjfu) <= 1000)) {
            this.zzjfu = this.zzata.elapsedRealtime();
            boolean z = false;
            if (zzawu().zzeb("android.permission.INTERNET") && zzawu().zzeb("android.permission.ACCESS_NETWORK_STATE") && (zzbhf.zzdb(this.mContext).zzamu() || (zzcid.zzbk(this.mContext) && zzcla.zzk(this.mContext, false)))) {
                z = true;
            }
            this.zzjft = Boolean.valueOf(z);
            if (this.zzjft.booleanValue()) {
                this.zzjft = Boolean.valueOf(zzawu().zzkg(zzawn().getGmpAppId()));
            }
        }
        return this.zzjft.booleanValue();
    }

    public final zzchm zzazx() {
        return (this.zzjey == null || !this.zzjey.isInitialized()) ? null : this.zzjey;
    }

    final zzcih zzazy() {
        return this.zzjez;
    }

    public final AppMeasurement zzazz() {
        return this.zzjfc;
    }

    @WorkerThread
    final void zzb(zzcgl com_google_android_gms_internal_zzcgl, zzcgi com_google_android_gms_internal_zzcgi) {
        zzbq.checkNotNull(com_google_android_gms_internal_zzcgl);
        zzbq.zzgm(com_google_android_gms_internal_zzcgl.packageName);
        zzbq.checkNotNull(com_google_android_gms_internal_zzcgl.zziyf);
        zzbq.checkNotNull(com_google_android_gms_internal_zzcgl.zziyg);
        zzbq.zzgm(com_google_android_gms_internal_zzcgl.zziyg.name);
        zzawx().zzve();
        zzxf();
        if (!TextUtils.isEmpty(com_google_android_gms_internal_zzcgi.zzixs)) {
            if (com_google_android_gms_internal_zzcgi.zzixx) {
                zzcgl com_google_android_gms_internal_zzcgl2 = new zzcgl(com_google_android_gms_internal_zzcgl);
                boolean z = false;
                com_google_android_gms_internal_zzcgl2.zziyi = false;
                zzaws().beginTransaction();
                try {
                    zzcho zzazi;
                    String str;
                    Object obj;
                    Object zzjj;
                    Object value;
                    zzcgl zzah = zzaws().zzah(com_google_android_gms_internal_zzcgl2.packageName, com_google_android_gms_internal_zzcgl2.zziyg.name);
                    if (!(zzah == null || zzah.zziyf.equals(com_google_android_gms_internal_zzcgl2.zziyf))) {
                        zzawy().zzazf().zzd("Updating a conditional user property with different origin. name, origin, origin (from DB)", zzawt().zzjj(com_google_android_gms_internal_zzcgl2.zziyg.name), com_google_android_gms_internal_zzcgl2.zziyf, zzah.zziyf);
                    }
                    if (zzah != null && zzah.zziyi) {
                        com_google_android_gms_internal_zzcgl2.zziyf = zzah.zziyf;
                        com_google_android_gms_internal_zzcgl2.zziyh = zzah.zziyh;
                        com_google_android_gms_internal_zzcgl2.zziyl = zzah.zziyl;
                        com_google_android_gms_internal_zzcgl2.zziyj = zzah.zziyj;
                        com_google_android_gms_internal_zzcgl2.zziym = zzah.zziym;
                        com_google_android_gms_internal_zzcgl2.zziyi = zzah.zziyi;
                        com_google_android_gms_internal_zzcgl2.zziyg = new zzcln(com_google_android_gms_internal_zzcgl2.zziyg.name, zzah.zziyg.zzjji, com_google_android_gms_internal_zzcgl2.zziyg.getValue(), zzah.zziyg.zziyf);
                    } else if (TextUtils.isEmpty(com_google_android_gms_internal_zzcgl2.zziyj)) {
                        com_google_android_gms_internal_zzcgl2.zziyg = new zzcln(com_google_android_gms_internal_zzcgl2.zziyg.name, com_google_android_gms_internal_zzcgl2.zziyh, com_google_android_gms_internal_zzcgl2.zziyg.getValue(), com_google_android_gms_internal_zzcgl2.zziyg.zziyf);
                        com_google_android_gms_internal_zzcgl2.zziyi = true;
                        z = true;
                    }
                    if (com_google_android_gms_internal_zzcgl2.zziyi) {
                        zzcho zzazi2;
                        String str2;
                        Object obj2;
                        Object zzjj2;
                        Object obj3;
                        zzcln com_google_android_gms_internal_zzcln = com_google_android_gms_internal_zzcgl2.zziyg;
                        zzclp com_google_android_gms_internal_zzclp = new zzclp(com_google_android_gms_internal_zzcgl2.packageName, com_google_android_gms_internal_zzcgl2.zziyf, com_google_android_gms_internal_zzcln.name, com_google_android_gms_internal_zzcln.zzjji, com_google_android_gms_internal_zzcln.getValue());
                        if (zzaws().zza(com_google_android_gms_internal_zzclp)) {
                            zzazi2 = zzawy().zzazi();
                            str2 = "User property updated immediately";
                            obj2 = com_google_android_gms_internal_zzcgl2.packageName;
                            zzjj2 = zzawt().zzjj(com_google_android_gms_internal_zzclp.mName);
                            obj3 = com_google_android_gms_internal_zzclp.mValue;
                        } else {
                            zzazi2 = zzawy().zzazd();
                            str2 = "(2)Too many active user properties, ignoring";
                            obj2 = zzchm.zzjk(com_google_android_gms_internal_zzcgl2.packageName);
                            zzjj2 = zzawt().zzjj(com_google_android_gms_internal_zzclp.mName);
                            obj3 = com_google_android_gms_internal_zzclp.mValue;
                        }
                        zzazi2.zzd(str2, obj2, zzjj2, obj3);
                        if (z && com_google_android_gms_internal_zzcgl2.zziym != null) {
                            zzc(new zzcha(com_google_android_gms_internal_zzcgl2.zziym, com_google_android_gms_internal_zzcgl2.zziyh), com_google_android_gms_internal_zzcgi);
                        }
                    }
                    if (zzaws().zza(com_google_android_gms_internal_zzcgl2)) {
                        zzazi = zzawy().zzazi();
                        str = "Conditional property added";
                        obj = com_google_android_gms_internal_zzcgl2.packageName;
                        zzjj = zzawt().zzjj(com_google_android_gms_internal_zzcgl2.zziyg.name);
                        value = com_google_android_gms_internal_zzcgl2.zziyg.getValue();
                    } else {
                        zzazi = zzawy().zzazd();
                        str = "Too many conditional properties, ignoring";
                        obj = zzchm.zzjk(com_google_android_gms_internal_zzcgl2.packageName);
                        zzjj = zzawt().zzjj(com_google_android_gms_internal_zzcgl2.zziyg.name);
                        value = com_google_android_gms_internal_zzcgl2.zziyg.getValue();
                    }
                    zzazi.zzd(str, obj, zzjj, value);
                    zzaws().setTransactionSuccessful();
                } finally {
                    zzaws().endTransaction();
                }
            } else {
                zzg(com_google_android_gms_internal_zzcgi);
            }
        }
    }

    @WorkerThread
    final void zzb(zzcha com_google_android_gms_internal_zzcha, zzcgi com_google_android_gms_internal_zzcgi) {
        zzcim com_google_android_gms_internal_zzcim = this;
        zzcha com_google_android_gms_internal_zzcha2 = com_google_android_gms_internal_zzcha;
        zzcgi com_google_android_gms_internal_zzcgi2 = com_google_android_gms_internal_zzcgi;
        zzbq.checkNotNull(com_google_android_gms_internal_zzcgi);
        zzbq.zzgm(com_google_android_gms_internal_zzcgi2.packageName);
        zzawx().zzve();
        zzxf();
        String str = com_google_android_gms_internal_zzcgi2.packageName;
        long j = com_google_android_gms_internal_zzcha2.zzizu;
        zzawu();
        if (!zzclq.zzd(com_google_android_gms_internal_zzcha, com_google_android_gms_internal_zzcgi)) {
            return;
        }
        if (com_google_android_gms_internal_zzcgi2.zzixx) {
            zzaws().beginTransaction();
            try {
                List emptyList;
                Object obj;
                List emptyList2;
                zzcjk zzaws = zzaws();
                zzbq.zzgm(str);
                zzaws.zzve();
                zzaws.zzxf();
                int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
                if (i < 0) {
                    zzaws.zzawy().zzazf().zze("Invalid time querying timed out conditional properties", zzchm.zzjk(str), Long.valueOf(j));
                    emptyList = Collections.emptyList();
                } else {
                    emptyList = zzaws.zzc("active=0 and app_id=? and abs(? - creation_timestamp) > trigger_timeout", new String[]{str, String.valueOf(j)});
                }
                for (zzcgl com_google_android_gms_internal_zzcgl : r5) {
                    if (com_google_android_gms_internal_zzcgl != null) {
                        zzawy().zzazi().zzd("User property timed out", com_google_android_gms_internal_zzcgl.packageName, zzawt().zzjj(com_google_android_gms_internal_zzcgl.zziyg.name), com_google_android_gms_internal_zzcgl.zziyg.getValue());
                        if (com_google_android_gms_internal_zzcgl.zziyk != null) {
                            zzc(new zzcha(com_google_android_gms_internal_zzcgl.zziyk, j), com_google_android_gms_internal_zzcgi2);
                        }
                        zzaws().zzai(str, com_google_android_gms_internal_zzcgl.zziyg.name);
                    }
                }
                zzaws = zzaws();
                zzbq.zzgm(str);
                zzaws.zzve();
                zzaws.zzxf();
                if (i < 0) {
                    zzaws.zzawy().zzazf().zze("Invalid time querying expired conditional properties", zzchm.zzjk(str), Long.valueOf(j));
                    emptyList = Collections.emptyList();
                } else {
                    emptyList = zzaws.zzc("active<>0 and app_id=? and abs(? - triggered_timestamp) > time_to_live", new String[]{str, String.valueOf(j)});
                }
                List arrayList = new ArrayList(r5.size());
                for (zzcgl com_google_android_gms_internal_zzcgl2 : r5) {
                    if (com_google_android_gms_internal_zzcgl2 != null) {
                        zzawy().zzazi().zzd("User property expired", com_google_android_gms_internal_zzcgl2.packageName, zzawt().zzjj(com_google_android_gms_internal_zzcgl2.zziyg.name), com_google_android_gms_internal_zzcgl2.zziyg.getValue());
                        zzaws().zzaf(str, com_google_android_gms_internal_zzcgl2.zziyg.name);
                        if (com_google_android_gms_internal_zzcgl2.zziyo != null) {
                            arrayList.add(com_google_android_gms_internal_zzcgl2.zziyo);
                        }
                        zzaws().zzai(str, com_google_android_gms_internal_zzcgl2.zziyg.name);
                    }
                }
                ArrayList arrayList2 = (ArrayList) arrayList;
                int size = arrayList2.size();
                int i2 = 0;
                while (i2 < size) {
                    obj = arrayList2.get(i2);
                    i2++;
                    zzc(new zzcha((zzcha) obj, j), com_google_android_gms_internal_zzcgi2);
                }
                zzaws = zzaws();
                String str2 = com_google_android_gms_internal_zzcha2.name;
                zzbq.zzgm(str);
                zzbq.zzgm(str2);
                zzaws.zzve();
                zzaws.zzxf();
                if (i < 0) {
                    zzaws.zzawy().zzazf().zzd("Invalid time querying triggered conditional properties", zzchm.zzjk(str), zzaws.zzawt().zzjh(str2), Long.valueOf(j));
                    emptyList2 = Collections.emptyList();
                } else {
                    emptyList2 = zzaws.zzc("active=0 and app_id=? and trigger_event_name=? and abs(? - creation_timestamp) <= trigger_timeout", new String[]{str, str2, String.valueOf(j)});
                }
                List arrayList3 = new ArrayList(emptyList2.size());
                Iterator it = emptyList2.iterator();
                while (it.hasNext()) {
                    zzcgl com_google_android_gms_internal_zzcgl3 = (zzcgl) it.next();
                    if (com_google_android_gms_internal_zzcgl3 != null) {
                        zzcho zzazi;
                        String str3;
                        Object obj2;
                        Object zzjj;
                        zzcln com_google_android_gms_internal_zzcln = com_google_android_gms_internal_zzcgl3.zziyg;
                        zzclp com_google_android_gms_internal_zzclp = r5;
                        Iterator it2 = it;
                        zzcgl com_google_android_gms_internal_zzcgl4 = com_google_android_gms_internal_zzcgl3;
                        zzclp com_google_android_gms_internal_zzclp2 = new zzclp(com_google_android_gms_internal_zzcgl3.packageName, com_google_android_gms_internal_zzcgl3.zziyf, com_google_android_gms_internal_zzcln.name, j, com_google_android_gms_internal_zzcln.getValue());
                        if (zzaws().zza(com_google_android_gms_internal_zzclp)) {
                            zzazi = zzawy().zzazi();
                            str3 = "User property triggered";
                            obj2 = com_google_android_gms_internal_zzcgl4.packageName;
                            zzjj = zzawt().zzjj(com_google_android_gms_internal_zzclp.mName);
                            obj = com_google_android_gms_internal_zzclp.mValue;
                        } else {
                            zzazi = zzawy().zzazd();
                            str3 = "Too many active user properties, ignoring";
                            obj2 = zzchm.zzjk(com_google_android_gms_internal_zzcgl4.packageName);
                            zzjj = zzawt().zzjj(com_google_android_gms_internal_zzclp.mName);
                            obj = com_google_android_gms_internal_zzclp.mValue;
                        }
                        zzazi.zzd(str3, obj2, zzjj, obj);
                        if (com_google_android_gms_internal_zzcgl4.zziym != null) {
                            arrayList3.add(com_google_android_gms_internal_zzcgl4.zziym);
                        }
                        com_google_android_gms_internal_zzcgl4.zziyg = new zzcln(com_google_android_gms_internal_zzclp);
                        com_google_android_gms_internal_zzcgl4.zziyi = true;
                        zzaws().zza(com_google_android_gms_internal_zzcgl4);
                        it = it2;
                    }
                }
                zzc(com_google_android_gms_internal_zzcha, com_google_android_gms_internal_zzcgi);
                ArrayList arrayList4 = (ArrayList) arrayList3;
                int size2 = arrayList4.size();
                int i3 = 0;
                while (i3 < size2) {
                    Object obj3 = arrayList4.get(i3);
                    i3++;
                    zzc(new zzcha((zzcha) obj3, j), com_google_android_gms_internal_zzcgi2);
                }
                zzaws().setTransactionSuccessful();
                zzaws().endTransaction();
            } catch (Throwable th) {
                Throwable th2 = th;
                zzaws().endTransaction();
            }
        } else {
            zzg(com_google_android_gms_internal_zzcgi2);
        }
    }

    @android.support.annotation.WorkerThread
    final void zzb(com.google.android.gms.internal.zzcha r26, java.lang.String r27) {
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
        r25 = this;
        r0 = r25;
        r1 = r26;
        r3 = r27;
        r2 = r25.zzaws();
        r2 = r2.zzjb(r3);
        if (r2 == 0) goto L_0x00af;
    L_0x0010:
        r4 = r2.zzvj();
        r4 = android.text.TextUtils.isEmpty(r4);
        if (r4 == 0) goto L_0x001c;
    L_0x001a:
        goto L_0x00af;
    L_0x001c:
        r4 = r0.mContext;	 Catch:{ NameNotFoundException -> 0x004b }
        r4 = com.google.android.gms.internal.zzbhf.zzdb(r4);	 Catch:{ NameNotFoundException -> 0x004b }
        r5 = 0;	 Catch:{ NameNotFoundException -> 0x004b }
        r4 = r4.getPackageInfo(r3, r5);	 Catch:{ NameNotFoundException -> 0x004b }
        r4 = r4.versionName;	 Catch:{ NameNotFoundException -> 0x004b }
        r5 = r2.zzvj();	 Catch:{ NameNotFoundException -> 0x004b }
        if (r5 == 0) goto L_0x0066;	 Catch:{ NameNotFoundException -> 0x004b }
    L_0x002f:
        r5 = r2.zzvj();	 Catch:{ NameNotFoundException -> 0x004b }
        r4 = r5.equals(r4);	 Catch:{ NameNotFoundException -> 0x004b }
        if (r4 != 0) goto L_0x0066;	 Catch:{ NameNotFoundException -> 0x004b }
    L_0x0039:
        r4 = r25.zzawy();	 Catch:{ NameNotFoundException -> 0x004b }
        r4 = r4.zzazf();	 Catch:{ NameNotFoundException -> 0x004b }
        r5 = "App version does not match; dropping event. appId";	 Catch:{ NameNotFoundException -> 0x004b }
        r6 = com.google.android.gms.internal.zzchm.zzjk(r27);	 Catch:{ NameNotFoundException -> 0x004b }
        r4.zzj(r5, r6);	 Catch:{ NameNotFoundException -> 0x004b }
        return;
    L_0x004b:
        r4 = "_ui";
        r5 = r1.name;
        r4 = r4.equals(r5);
        if (r4 != 0) goto L_0x0066;
    L_0x0055:
        r4 = r25.zzawy();
        r4 = r4.zzazf();
        r5 = "Could not find package. appId";
        r6 = com.google.android.gms.internal.zzchm.zzjk(r27);
        r4.zzj(r5, r6);
    L_0x0066:
        r15 = new com.google.android.gms.internal.zzcgi;
        r4 = r2.getGmpAppId();
        r5 = r2.zzvj();
        r6 = r2.zzaxg();
        r8 = r2.zzaxh();
        r9 = r2.zzaxi();
        r11 = r2.zzaxj();
        r13 = 0;
        r14 = r2.zzaxk();
        r16 = 0;
        r17 = r2.zzaxd();
        r18 = r2.zzaxx();
        r20 = 0;
        r22 = 0;
        r23 = r2.zzaxy();
        r2 = r15;
        r24 = r15;
        r15 = r16;
        r16 = r17;
        r17 = r18;
        r19 = r20;
        r21 = r22;
        r22 = r23;
        r2.<init>(r3, r4, r5, r6, r8, r9, r11, r13, r14, r15, r16, r17, r19, r21, r22);
        r2 = r24;
        r0.zzb(r1, r2);
        return;
    L_0x00af:
        r1 = r25.zzawy();
        r1 = r1.zzazi();
        r2 = "No app data available; dropping event";
        r1.zzj(r2, r3);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzcim.zzb(com.google.android.gms.internal.zzcha, java.lang.String):void");
    }

    final void zzb(zzcjl com_google_android_gms_internal_zzcjl) {
        this.zzjfz++;
    }

    @WorkerThread
    final void zzb(zzcln com_google_android_gms_internal_zzcln, zzcgi com_google_android_gms_internal_zzcgi) {
        zzawx().zzve();
        zzxf();
        if (!TextUtils.isEmpty(com_google_android_gms_internal_zzcgi.zzixs)) {
            if (com_google_android_gms_internal_zzcgi.zzixx) {
                int zzkd = zzawu().zzkd(com_google_android_gms_internal_zzcln.name);
                int i = 0;
                if (zzkd != 0) {
                    zzawu();
                    zzawu().zza(com_google_android_gms_internal_zzcgi.packageName, zzkd, "_ev", zzclq.zza(com_google_android_gms_internal_zzcln.name, 24, true), com_google_android_gms_internal_zzcln.name != null ? com_google_android_gms_internal_zzcln.name.length() : 0);
                    return;
                }
                int zzl = zzawu().zzl(com_google_android_gms_internal_zzcln.name, com_google_android_gms_internal_zzcln.getValue());
                if (zzl != 0) {
                    zzawu();
                    String zza = zzclq.zza(com_google_android_gms_internal_zzcln.name, 24, true);
                    Object value = com_google_android_gms_internal_zzcln.getValue();
                    if (value != null && ((value instanceof String) || (value instanceof CharSequence))) {
                        i = String.valueOf(value).length();
                    }
                    zzawu().zza(com_google_android_gms_internal_zzcgi.packageName, zzl, "_ev", zza, i);
                    return;
                }
                Object zzm = zzawu().zzm(com_google_android_gms_internal_zzcln.name, com_google_android_gms_internal_zzcln.getValue());
                if (zzm != null) {
                    zzclp com_google_android_gms_internal_zzclp = new zzclp(com_google_android_gms_internal_zzcgi.packageName, com_google_android_gms_internal_zzcln.zziyf, com_google_android_gms_internal_zzcln.name, com_google_android_gms_internal_zzcln.zzjji, zzm);
                    zzawy().zzazi().zze("Setting user property", zzawt().zzjj(com_google_android_gms_internal_zzclp.mName), zzm);
                    zzaws().beginTransaction();
                    try {
                        zzg(com_google_android_gms_internal_zzcgi);
                        boolean zza2 = zzaws().zza(com_google_android_gms_internal_zzclp);
                        zzaws().setTransactionSuccessful();
                        if (zza2) {
                            zzawy().zzazi().zze("User property set", zzawt().zzjj(com_google_android_gms_internal_zzclp.mName), com_google_android_gms_internal_zzclp.mValue);
                        } else {
                            zzawy().zzazd().zze("Too many unique user properties are set. Ignoring user property", zzawt().zzjj(com_google_android_gms_internal_zzclp.mName), com_google_android_gms_internal_zzclp.mValue);
                            zzawu().zza(com_google_android_gms_internal_zzcgi.packageName, 9, null, null, 0);
                        }
                        zzaws().endTransaction();
                        return;
                    } catch (Throwable th) {
                        zzaws().endTransaction();
                    }
                } else {
                    return;
                }
            }
            zzg(com_google_android_gms_internal_zzcgi);
        }
    }

    @WorkerThread
    final void zzb(String str, int i, Throwable th, byte[] bArr, Map<String, List<String>> map) {
        zzcgo zzaws;
        zzawx().zzve();
        zzxf();
        zzbq.zzgm(str);
        if (bArr == null) {
            try {
                bArr = new byte[0];
            } catch (Throwable th2) {
                this.zzjgd = false;
                zzban();
            }
        }
        zzawy().zzazj().zzj("onConfigFetched. Response size", Integer.valueOf(bArr.length));
        zzaws().beginTransaction();
        zzcgh zzjb = zzaws().zzjb(str);
        boolean z = true;
        boolean z2 = (i == Callback.DEFAULT_DRAG_ANIMATION_DURATION || i == 204 || i == 304) && th == null;
        if (zzjb == null) {
            zzawy().zzazf().zzj("App does not exist in onConfigFetched. appId", zzchm.zzjk(str));
            zzaws().setTransactionSuccessful();
            zzaws = zzaws();
        } else {
            if (!z2) {
                if (i != 404) {
                    zzjb.zzas(this.zzata.currentTimeMillis());
                    zzaws().zza(zzjb);
                    zzawy().zzazj().zze("Fetching config failed. code, error", Integer.valueOf(i), th);
                    zzawv().zzju(str);
                    zzawz().zzjcs.set(this.zzata.currentTimeMillis());
                    if (i != 503) {
                        if (i != 429) {
                            z = false;
                        }
                    }
                    if (z) {
                        zzawz().zzjct.set(this.zzata.currentTimeMillis());
                    }
                    zzbaj();
                    zzaws().setTransactionSuccessful();
                    zzaws = zzaws();
                }
            }
            List list = map != null ? (List) map.get("Last-Modified") : null;
            String str2 = (list == null || list.size() <= 0) ? null : (String) list.get(0);
            if (i != 404) {
                if (i != 304) {
                    if (!zzawv().zzb(str, bArr, str2)) {
                        zzaws = zzaws();
                    }
                    zzjb.zzar(this.zzata.currentTimeMillis());
                    zzaws().zza(zzjb);
                    if (i != 404) {
                        zzawy().zzazg().zzj("Config not found. Using empty config. appId", str);
                    } else {
                        zzawy().zzazj().zze("Successfully fetched config. Got network response. code, size", Integer.valueOf(i), Integer.valueOf(bArr.length));
                    }
                    if (zzbab().zzzs() && zzbai()) {
                        zzbah();
                        zzaws().setTransactionSuccessful();
                        zzaws = zzaws();
                    }
                    zzbaj();
                    zzaws().setTransactionSuccessful();
                    zzaws = zzaws();
                }
            }
            if (zzawv().zzjs(str) == null && !zzawv().zzb(str, null, null)) {
                zzaws = zzaws();
            }
            zzjb.zzar(this.zzata.currentTimeMillis());
            zzaws().zza(zzjb);
            if (i != 404) {
                zzawy().zzazj().zze("Successfully fetched config. Got network response. code, size", Integer.valueOf(i), Integer.valueOf(bArr.length));
            } else {
                zzawy().zzazg().zzj("Config not found. Using empty config. appId", str);
            }
            zzbah();
            zzaws().setTransactionSuccessful();
            zzaws = zzaws();
        }
        zzaws.endTransaction();
        this.zzjgd = false;
        zzban();
    }

    public final FirebaseAnalytics zzbaa() {
        return this.zzjfd;
    }

    public final zzchq zzbab() {
        zza(this.zzjfi);
        return this.zzjfi;
    }

    final long zzbaf() {
        Long valueOf = Long.valueOf(zzawz().zzjcw.get());
        return valueOf.longValue() == 0 ? this.zzjgg : Math.min(this.zzjgg, valueOf.longValue());
    }

    @android.support.annotation.WorkerThread
    public final void zzbah() {
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
        r18 = this;
        r1 = r18;
        r2 = r18.zzawx();
        r2.zzve();
        r18.zzxf();
        r2 = 1;
        r1.zzjgf = r2;
        r3 = 0;
        r4 = r18.zzawp();	 Catch:{ all -> 0x0288 }
        r4 = r4.zzbas();	 Catch:{ all -> 0x0288 }
        if (r4 != 0) goto L_0x002d;	 Catch:{ all -> 0x0288 }
    L_0x001a:
        r2 = r18.zzawy();	 Catch:{ all -> 0x0288 }
        r2 = r2.zzazf();	 Catch:{ all -> 0x0288 }
        r4 = "Upload data called on the client side before use of service was decided";	 Catch:{ all -> 0x0288 }
    L_0x0024:
        r2.log(r4);	 Catch:{ all -> 0x0288 }
    L_0x0027:
        r1.zzjgf = r3;
        r18.zzban();
        return;
    L_0x002d:
        r4 = r4.booleanValue();	 Catch:{ all -> 0x0288 }
        if (r4 == 0) goto L_0x003e;	 Catch:{ all -> 0x0288 }
    L_0x0033:
        r2 = r18.zzawy();	 Catch:{ all -> 0x0288 }
        r2 = r2.zzazd();	 Catch:{ all -> 0x0288 }
        r4 = "Upload called in the client side when service should be used";	 Catch:{ all -> 0x0288 }
        goto L_0x0024;	 Catch:{ all -> 0x0288 }
    L_0x003e:
        r4 = r1.zzjgc;	 Catch:{ all -> 0x0288 }
        r6 = 0;	 Catch:{ all -> 0x0288 }
        r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));	 Catch:{ all -> 0x0288 }
        if (r4 <= 0) goto L_0x004a;	 Catch:{ all -> 0x0288 }
    L_0x0046:
        r18.zzbaj();	 Catch:{ all -> 0x0288 }
        goto L_0x0027;	 Catch:{ all -> 0x0288 }
    L_0x004a:
        r4 = r18.zzawx();	 Catch:{ all -> 0x0288 }
        r4.zzve();	 Catch:{ all -> 0x0288 }
        r4 = r1.zzjfx;	 Catch:{ all -> 0x0288 }
        if (r4 == 0) goto L_0x0057;	 Catch:{ all -> 0x0288 }
    L_0x0055:
        r4 = r2;	 Catch:{ all -> 0x0288 }
        goto L_0x0058;	 Catch:{ all -> 0x0288 }
    L_0x0057:
        r4 = r3;	 Catch:{ all -> 0x0288 }
    L_0x0058:
        if (r4 == 0) goto L_0x0065;	 Catch:{ all -> 0x0288 }
    L_0x005a:
        r2 = r18.zzawy();	 Catch:{ all -> 0x0288 }
        r2 = r2.zzazj();	 Catch:{ all -> 0x0288 }
        r4 = "Uploading requested multiple times";	 Catch:{ all -> 0x0288 }
        goto L_0x0024;	 Catch:{ all -> 0x0288 }
    L_0x0065:
        r4 = r18.zzbab();	 Catch:{ all -> 0x0288 }
        r4 = r4.zzzs();	 Catch:{ all -> 0x0288 }
        if (r4 != 0) goto L_0x007d;	 Catch:{ all -> 0x0288 }
    L_0x006f:
        r2 = r18.zzawy();	 Catch:{ all -> 0x0288 }
        r2 = r2.zzazj();	 Catch:{ all -> 0x0288 }
        r4 = "Network not connected, ignoring upload request";	 Catch:{ all -> 0x0288 }
        r2.log(r4);	 Catch:{ all -> 0x0288 }
        goto L_0x0046;	 Catch:{ all -> 0x0288 }
    L_0x007d:
        r4 = r1.zzata;	 Catch:{ all -> 0x0288 }
        r4 = r4.currentTimeMillis();	 Catch:{ all -> 0x0288 }
        r8 = com.google.android.gms.internal.zzcgn.zzayc();	 Catch:{ all -> 0x0288 }
        r8 = r4 - r8;	 Catch:{ all -> 0x0288 }
        r10 = 0;	 Catch:{ all -> 0x0288 }
        r1.zzg(r10, r8);	 Catch:{ all -> 0x0288 }
        r8 = r18.zzawz();	 Catch:{ all -> 0x0288 }
        r8 = r8.zzjcr;	 Catch:{ all -> 0x0288 }
        r8 = r8.get();	 Catch:{ all -> 0x0288 }
        r6 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1));	 Catch:{ all -> 0x0288 }
        if (r6 == 0) goto L_0x00b2;	 Catch:{ all -> 0x0288 }
    L_0x009b:
        r6 = r18.zzawy();	 Catch:{ all -> 0x0288 }
        r6 = r6.zzazi();	 Catch:{ all -> 0x0288 }
        r7 = "Uploading events. Elapsed time since last upload attempt (ms)";	 Catch:{ all -> 0x0288 }
        r8 = r4 - r8;	 Catch:{ all -> 0x0288 }
        r8 = java.lang.Math.abs(r8);	 Catch:{ all -> 0x0288 }
        r8 = java.lang.Long.valueOf(r8);	 Catch:{ all -> 0x0288 }
        r6.zzj(r7, r8);	 Catch:{ all -> 0x0288 }
    L_0x00b2:
        r6 = r18.zzaws();	 Catch:{ all -> 0x0288 }
        r6 = r6.zzayf();	 Catch:{ all -> 0x0288 }
        r7 = android.text.TextUtils.isEmpty(r6);	 Catch:{ all -> 0x0288 }
        r8 = -1;	 Catch:{ all -> 0x0288 }
        if (r7 != 0) goto L_0x0264;	 Catch:{ all -> 0x0288 }
    L_0x00c2:
        r11 = r1.zzjgb;	 Catch:{ all -> 0x0288 }
        r7 = (r11 > r8 ? 1 : (r11 == r8 ? 0 : -1));	 Catch:{ all -> 0x0288 }
        if (r7 != 0) goto L_0x00d2;	 Catch:{ all -> 0x0288 }
    L_0x00c8:
        r7 = r18.zzaws();	 Catch:{ all -> 0x0288 }
        r7 = r7.zzaym();	 Catch:{ all -> 0x0288 }
        r1.zzjgb = r7;	 Catch:{ all -> 0x0288 }
    L_0x00d2:
        r7 = r1.zzjew;	 Catch:{ all -> 0x0288 }
        r8 = com.google.android.gms.internal.zzchc.zzjaj;	 Catch:{ all -> 0x0288 }
        r7 = r7.zzb(r6, r8);	 Catch:{ all -> 0x0288 }
        r8 = r1.zzjew;	 Catch:{ all -> 0x0288 }
        r9 = com.google.android.gms.internal.zzchc.zzjak;	 Catch:{ all -> 0x0288 }
        r8 = r8.zzb(r6, r9);	 Catch:{ all -> 0x0288 }
        r8 = java.lang.Math.max(r3, r8);	 Catch:{ all -> 0x0288 }
        r9 = r18.zzaws();	 Catch:{ all -> 0x0288 }
        r7 = r9.zzl(r6, r7, r8);	 Catch:{ all -> 0x0288 }
        r8 = r7.isEmpty();	 Catch:{ all -> 0x0288 }
        if (r8 != 0) goto L_0x0027;	 Catch:{ all -> 0x0288 }
    L_0x00f4:
        r8 = r7.iterator();	 Catch:{ all -> 0x0288 }
    L_0x00f8:
        r9 = r8.hasNext();	 Catch:{ all -> 0x0288 }
        if (r9 == 0) goto L_0x0113;	 Catch:{ all -> 0x0288 }
    L_0x00fe:
        r9 = r8.next();	 Catch:{ all -> 0x0288 }
        r9 = (android.util.Pair) r9;	 Catch:{ all -> 0x0288 }
        r9 = r9.first;	 Catch:{ all -> 0x0288 }
        r9 = (com.google.android.gms.internal.zzcme) r9;	 Catch:{ all -> 0x0288 }
        r11 = r9.zzjmc;	 Catch:{ all -> 0x0288 }
        r11 = android.text.TextUtils.isEmpty(r11);	 Catch:{ all -> 0x0288 }
        if (r11 != 0) goto L_0x00f8;	 Catch:{ all -> 0x0288 }
    L_0x0110:
        r8 = r9.zzjmc;	 Catch:{ all -> 0x0288 }
        goto L_0x0114;	 Catch:{ all -> 0x0288 }
    L_0x0113:
        r8 = r10;	 Catch:{ all -> 0x0288 }
    L_0x0114:
        if (r8 == 0) goto L_0x013f;	 Catch:{ all -> 0x0288 }
    L_0x0116:
        r9 = r3;	 Catch:{ all -> 0x0288 }
    L_0x0117:
        r11 = r7.size();	 Catch:{ all -> 0x0288 }
        if (r9 >= r11) goto L_0x013f;	 Catch:{ all -> 0x0288 }
    L_0x011d:
        r11 = r7.get(r9);	 Catch:{ all -> 0x0288 }
        r11 = (android.util.Pair) r11;	 Catch:{ all -> 0x0288 }
        r11 = r11.first;	 Catch:{ all -> 0x0288 }
        r11 = (com.google.android.gms.internal.zzcme) r11;	 Catch:{ all -> 0x0288 }
        r12 = r11.zzjmc;	 Catch:{ all -> 0x0288 }
        r12 = android.text.TextUtils.isEmpty(r12);	 Catch:{ all -> 0x0288 }
        if (r12 != 0) goto L_0x013c;	 Catch:{ all -> 0x0288 }
    L_0x012f:
        r11 = r11.zzjmc;	 Catch:{ all -> 0x0288 }
        r11 = r11.equals(r8);	 Catch:{ all -> 0x0288 }
        if (r11 != 0) goto L_0x013c;	 Catch:{ all -> 0x0288 }
    L_0x0137:
        r7 = r7.subList(r3, r9);	 Catch:{ all -> 0x0288 }
        goto L_0x013f;	 Catch:{ all -> 0x0288 }
    L_0x013c:
        r9 = r9 + 1;	 Catch:{ all -> 0x0288 }
        goto L_0x0117;	 Catch:{ all -> 0x0288 }
    L_0x013f:
        r8 = new com.google.android.gms.internal.zzcmd;	 Catch:{ all -> 0x0288 }
        r8.<init>();	 Catch:{ all -> 0x0288 }
        r9 = r7.size();	 Catch:{ all -> 0x0288 }
        r9 = new com.google.android.gms.internal.zzcme[r9];	 Catch:{ all -> 0x0288 }
        r8.zzjlm = r9;	 Catch:{ all -> 0x0288 }
        r9 = new java.util.ArrayList;	 Catch:{ all -> 0x0288 }
        r11 = r7.size();	 Catch:{ all -> 0x0288 }
        r9.<init>(r11);	 Catch:{ all -> 0x0288 }
        r11 = com.google.android.gms.internal.zzcgn.zzaye();	 Catch:{ all -> 0x0288 }
        if (r11 == 0) goto L_0x0165;	 Catch:{ all -> 0x0288 }
    L_0x015b:
        r11 = r1.zzjew;	 Catch:{ all -> 0x0288 }
        r11 = r11.zziz(r6);	 Catch:{ all -> 0x0288 }
        if (r11 == 0) goto L_0x0165;	 Catch:{ all -> 0x0288 }
    L_0x0163:
        r11 = r2;	 Catch:{ all -> 0x0288 }
        goto L_0x0166;	 Catch:{ all -> 0x0288 }
    L_0x0165:
        r11 = r3;	 Catch:{ all -> 0x0288 }
    L_0x0166:
        r12 = r3;	 Catch:{ all -> 0x0288 }
    L_0x0167:
        r13 = r8.zzjlm;	 Catch:{ all -> 0x0288 }
        r13 = r13.length;	 Catch:{ all -> 0x0288 }
        if (r12 >= r13) goto L_0x01b2;	 Catch:{ all -> 0x0288 }
    L_0x016c:
        r13 = r8.zzjlm;	 Catch:{ all -> 0x0288 }
        r14 = r7.get(r12);	 Catch:{ all -> 0x0288 }
        r14 = (android.util.Pair) r14;	 Catch:{ all -> 0x0288 }
        r14 = r14.first;	 Catch:{ all -> 0x0288 }
        r14 = (com.google.android.gms.internal.zzcme) r14;	 Catch:{ all -> 0x0288 }
        r13[r12] = r14;	 Catch:{ all -> 0x0288 }
        r13 = r7.get(r12);	 Catch:{ all -> 0x0288 }
        r13 = (android.util.Pair) r13;	 Catch:{ all -> 0x0288 }
        r13 = r13.second;	 Catch:{ all -> 0x0288 }
        r13 = (java.lang.Long) r13;	 Catch:{ all -> 0x0288 }
        r9.add(r13);	 Catch:{ all -> 0x0288 }
        r13 = r8.zzjlm;	 Catch:{ all -> 0x0288 }
        r13 = r13[r12];	 Catch:{ all -> 0x0288 }
        r14 = 11910; // 0x2e86 float:1.669E-41 double:5.8843E-320;	 Catch:{ all -> 0x0288 }
        r14 = java.lang.Long.valueOf(r14);	 Catch:{ all -> 0x0288 }
        r13.zzjmb = r14;	 Catch:{ all -> 0x0288 }
        r13 = r8.zzjlm;	 Catch:{ all -> 0x0288 }
        r13 = r13[r12];	 Catch:{ all -> 0x0288 }
        r14 = java.lang.Long.valueOf(r4);	 Catch:{ all -> 0x0288 }
        r13.zzjlr = r14;	 Catch:{ all -> 0x0288 }
        r13 = r8.zzjlm;	 Catch:{ all -> 0x0288 }
        r13 = r13[r12];	 Catch:{ all -> 0x0288 }
        r14 = java.lang.Boolean.valueOf(r3);	 Catch:{ all -> 0x0288 }
        r13.zzjmh = r14;	 Catch:{ all -> 0x0288 }
        if (r11 != 0) goto L_0x01af;	 Catch:{ all -> 0x0288 }
    L_0x01a9:
        r13 = r8.zzjlm;	 Catch:{ all -> 0x0288 }
        r13 = r13[r12];	 Catch:{ all -> 0x0288 }
        r13.zzjmo = r10;	 Catch:{ all -> 0x0288 }
    L_0x01af:
        r12 = r12 + 1;	 Catch:{ all -> 0x0288 }
        goto L_0x0167;	 Catch:{ all -> 0x0288 }
    L_0x01b2:
        r7 = r18.zzawy();	 Catch:{ all -> 0x0288 }
        r11 = 2;	 Catch:{ all -> 0x0288 }
        r7 = r7.zzae(r11);	 Catch:{ all -> 0x0288 }
        if (r7 == 0) goto L_0x01c5;	 Catch:{ all -> 0x0288 }
    L_0x01bd:
        r7 = r18.zzawt();	 Catch:{ all -> 0x0288 }
        r10 = r7.zza(r8);	 Catch:{ all -> 0x0288 }
    L_0x01c5:
        r7 = r18.zzawu();	 Catch:{ all -> 0x0288 }
        r15 = r7.zzb(r8);	 Catch:{ all -> 0x0288 }
        r7 = com.google.android.gms.internal.zzchc.zzjat;	 Catch:{ all -> 0x0288 }
        r7 = r7.get();	 Catch:{ all -> 0x0288 }
        r7 = (java.lang.String) r7;	 Catch:{ all -> 0x0288 }
        r14 = new java.net.URL;	 Catch:{ MalformedURLException -> 0x0251 }
        r14.<init>(r7);	 Catch:{ MalformedURLException -> 0x0251 }
        r11 = r9.isEmpty();	 Catch:{ MalformedURLException -> 0x0251 }
        r11 = r11 ^ r2;	 Catch:{ MalformedURLException -> 0x0251 }
        com.google.android.gms.common.internal.zzbq.checkArgument(r11);	 Catch:{ MalformedURLException -> 0x0251 }
        r11 = r1.zzjfx;	 Catch:{ MalformedURLException -> 0x0251 }
        if (r11 == 0) goto L_0x01f4;	 Catch:{ MalformedURLException -> 0x0251 }
    L_0x01e6:
        r9 = r18.zzawy();	 Catch:{ MalformedURLException -> 0x0251 }
        r9 = r9.zzazd();	 Catch:{ MalformedURLException -> 0x0251 }
        r11 = "Set uploading progress before finishing the previous upload";	 Catch:{ MalformedURLException -> 0x0251 }
        r9.log(r11);	 Catch:{ MalformedURLException -> 0x0251 }
        goto L_0x01fb;	 Catch:{ MalformedURLException -> 0x0251 }
    L_0x01f4:
        r11 = new java.util.ArrayList;	 Catch:{ MalformedURLException -> 0x0251 }
        r11.<init>(r9);	 Catch:{ MalformedURLException -> 0x0251 }
        r1.zzjfx = r11;	 Catch:{ MalformedURLException -> 0x0251 }
    L_0x01fb:
        r9 = r18.zzawz();	 Catch:{ MalformedURLException -> 0x0251 }
        r9 = r9.zzjcs;	 Catch:{ MalformedURLException -> 0x0251 }
        r9.set(r4);	 Catch:{ MalformedURLException -> 0x0251 }
        r4 = "?";	 Catch:{ MalformedURLException -> 0x0251 }
        r5 = r8.zzjlm;	 Catch:{ MalformedURLException -> 0x0251 }
        r5 = r5.length;	 Catch:{ MalformedURLException -> 0x0251 }
        if (r5 <= 0) goto L_0x0211;	 Catch:{ MalformedURLException -> 0x0251 }
    L_0x020b:
        r4 = r8.zzjlm;	 Catch:{ MalformedURLException -> 0x0251 }
        r4 = r4[r3];	 Catch:{ MalformedURLException -> 0x0251 }
        r4 = r4.zzcn;	 Catch:{ MalformedURLException -> 0x0251 }
    L_0x0211:
        r5 = r18.zzawy();	 Catch:{ MalformedURLException -> 0x0251 }
        r5 = r5.zzazj();	 Catch:{ MalformedURLException -> 0x0251 }
        r8 = "Uploading data. app, uncompressed size, data";	 Catch:{ MalformedURLException -> 0x0251 }
        r9 = r15.length;	 Catch:{ MalformedURLException -> 0x0251 }
        r9 = java.lang.Integer.valueOf(r9);	 Catch:{ MalformedURLException -> 0x0251 }
        r5.zzd(r8, r4, r9, r10);	 Catch:{ MalformedURLException -> 0x0251 }
        r1.zzjge = r2;	 Catch:{ MalformedURLException -> 0x0251 }
        r12 = r18.zzbab();	 Catch:{ MalformedURLException -> 0x0251 }
        r2 = new com.google.android.gms.internal.zzcip;	 Catch:{ MalformedURLException -> 0x0251 }
        r2.<init>(r1);	 Catch:{ MalformedURLException -> 0x0251 }
        r12.zzve();	 Catch:{ MalformedURLException -> 0x0251 }
        r12.zzxf();	 Catch:{ MalformedURLException -> 0x0251 }
        com.google.android.gms.common.internal.zzbq.checkNotNull(r14);	 Catch:{ MalformedURLException -> 0x0251 }
        com.google.android.gms.common.internal.zzbq.checkNotNull(r15);	 Catch:{ MalformedURLException -> 0x0251 }
        com.google.android.gms.common.internal.zzbq.checkNotNull(r2);	 Catch:{ MalformedURLException -> 0x0251 }
        r4 = r12.zzawx();	 Catch:{ MalformedURLException -> 0x0251 }
        r5 = new com.google.android.gms.internal.zzchu;	 Catch:{ MalformedURLException -> 0x0251 }
        r16 = 0;	 Catch:{ MalformedURLException -> 0x0251 }
        r11 = r5;	 Catch:{ MalformedURLException -> 0x0251 }
        r13 = r6;	 Catch:{ MalformedURLException -> 0x0251 }
        r17 = r2;	 Catch:{ MalformedURLException -> 0x0251 }
        r11.<init>(r12, r13, r14, r15, r16, r17);	 Catch:{ MalformedURLException -> 0x0251 }
        r4.zzh(r5);	 Catch:{ MalformedURLException -> 0x0251 }
        goto L_0x0027;
    L_0x0251:
        r2 = r18.zzawy();	 Catch:{ all -> 0x0288 }
        r2 = r2.zzazd();	 Catch:{ all -> 0x0288 }
        r4 = "Failed to parse upload URL. Not uploading. appId";	 Catch:{ all -> 0x0288 }
        r5 = com.google.android.gms.internal.zzchm.zzjk(r6);	 Catch:{ all -> 0x0288 }
        r2.zze(r4, r5, r7);	 Catch:{ all -> 0x0288 }
        goto L_0x0027;	 Catch:{ all -> 0x0288 }
    L_0x0264:
        r1.zzjgb = r8;	 Catch:{ all -> 0x0288 }
        r2 = r18.zzaws();	 Catch:{ all -> 0x0288 }
        r6 = com.google.android.gms.internal.zzcgn.zzayc();	 Catch:{ all -> 0x0288 }
        r4 = r4 - r6;	 Catch:{ all -> 0x0288 }
        r2 = r2.zzba(r4);	 Catch:{ all -> 0x0288 }
        r4 = android.text.TextUtils.isEmpty(r2);	 Catch:{ all -> 0x0288 }
        if (r4 != 0) goto L_0x0027;	 Catch:{ all -> 0x0288 }
    L_0x0279:
        r4 = r18.zzaws();	 Catch:{ all -> 0x0288 }
        r2 = r4.zzjb(r2);	 Catch:{ all -> 0x0288 }
        if (r2 == 0) goto L_0x0027;	 Catch:{ all -> 0x0288 }
    L_0x0283:
        r1.zzb(r2);	 Catch:{ all -> 0x0288 }
        goto L_0x0027;
    L_0x0288:
        r0 = move-exception;
        r2 = r0;
        r1.zzjgf = r3;
        r18.zzban();
        throw r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzcim.zzbah():void");
    }

    final void zzbak() {
        this.zzjga++;
    }

    @WorkerThread
    final void zzbal() {
        zzawx().zzve();
        zzxf();
        if (!this.zzjfs) {
            zzawy().zzazh().log("This instance being marked as an uploader");
            zzawx().zzve();
            zzxf();
            if (zzbam() && zzbae()) {
                zzcho zzazd;
                String str;
                int zza = zza(this.zzjfw);
                int zzaza = zzawn().zzaza();
                zzawx().zzve();
                if (zza > zzaza) {
                    zzazd = zzawy().zzazd();
                    str = "Panic: can't downgrade version. Previous, current version";
                } else if (zza < zzaza) {
                    if (zza(zzaza, this.zzjfw)) {
                        zzazd = zzawy().zzazj();
                        str = "Storage version upgraded. Previous, current version";
                    } else {
                        zzazd = zzawy().zzazd();
                        str = "Storage version upgrade failed. Previous, current version";
                    }
                }
                zzazd.zze(str, Integer.valueOf(zza), Integer.valueOf(zzaza));
            }
            this.zzjfs = true;
            zzbaj();
        }
    }

    public final void zzbo(boolean z) {
        zzbaj();
    }

    @WorkerThread
    final void zzc(zzcgl com_google_android_gms_internal_zzcgl, zzcgi com_google_android_gms_internal_zzcgi) {
        zzbq.checkNotNull(com_google_android_gms_internal_zzcgl);
        zzbq.zzgm(com_google_android_gms_internal_zzcgl.packageName);
        zzbq.checkNotNull(com_google_android_gms_internal_zzcgl.zziyg);
        zzbq.zzgm(com_google_android_gms_internal_zzcgl.zziyg.name);
        zzawx().zzve();
        zzxf();
        if (!TextUtils.isEmpty(com_google_android_gms_internal_zzcgi.zzixs)) {
            if (com_google_android_gms_internal_zzcgi.zzixx) {
                zzaws().beginTransaction();
                try {
                    zzg(com_google_android_gms_internal_zzcgi);
                    zzcgl zzah = zzaws().zzah(com_google_android_gms_internal_zzcgl.packageName, com_google_android_gms_internal_zzcgl.zziyg.name);
                    if (zzah != null) {
                        zzawy().zzazi().zze("Removing conditional user property", com_google_android_gms_internal_zzcgl.packageName, zzawt().zzjj(com_google_android_gms_internal_zzcgl.zziyg.name));
                        zzaws().zzai(com_google_android_gms_internal_zzcgl.packageName, com_google_android_gms_internal_zzcgl.zziyg.name);
                        if (zzah.zziyi) {
                            zzaws().zzaf(com_google_android_gms_internal_zzcgl.packageName, com_google_android_gms_internal_zzcgl.zziyg.name);
                        }
                        if (com_google_android_gms_internal_zzcgl.zziyo != null) {
                            Bundle bundle = null;
                            if (com_google_android_gms_internal_zzcgl.zziyo.zzizt != null) {
                                bundle = com_google_android_gms_internal_zzcgl.zziyo.zzizt.zzayx();
                            }
                            Bundle bundle2 = bundle;
                            zzc(zzawu().zza(com_google_android_gms_internal_zzcgl.zziyo.name, bundle2, zzah.zziyf, com_google_android_gms_internal_zzcgl.zziyo.zzizu, true, false), com_google_android_gms_internal_zzcgi);
                        }
                    } else {
                        zzawy().zzazf().zze("Conditional user property doesn't exist", zzchm.zzjk(com_google_android_gms_internal_zzcgl.packageName), zzawt().zzjj(com_google_android_gms_internal_zzcgl.zziyg.name));
                    }
                    zzaws().setTransactionSuccessful();
                } finally {
                    zzaws().endTransaction();
                }
            } else {
                zzg(com_google_android_gms_internal_zzcgi);
            }
        }
    }

    @WorkerThread
    final void zzc(zzcln com_google_android_gms_internal_zzcln, zzcgi com_google_android_gms_internal_zzcgi) {
        zzawx().zzve();
        zzxf();
        if (!TextUtils.isEmpty(com_google_android_gms_internal_zzcgi.zzixs)) {
            if (com_google_android_gms_internal_zzcgi.zzixx) {
                zzawy().zzazi().zzj("Removing user property", zzawt().zzjj(com_google_android_gms_internal_zzcln.name));
                zzaws().beginTransaction();
                try {
                    zzg(com_google_android_gms_internal_zzcgi);
                    zzaws().zzaf(com_google_android_gms_internal_zzcgi.packageName, com_google_android_gms_internal_zzcln.name);
                    zzaws().setTransactionSuccessful();
                    zzawy().zzazi().zzj("User property removed", zzawt().zzjj(com_google_android_gms_internal_zzcln.name));
                } finally {
                    zzaws().endTransaction();
                }
            } else {
                zzg(com_google_android_gms_internal_zzcgi);
            }
        }
    }

    final void zzd(zzcgi com_google_android_gms_internal_zzcgi) {
        zzaws().zzjb(com_google_android_gms_internal_zzcgi.packageName);
        zzcjk zzaws = zzaws();
        String str = com_google_android_gms_internal_zzcgi.packageName;
        zzbq.zzgm(str);
        zzaws.zzve();
        zzaws.zzxf();
        try {
            SQLiteDatabase writableDatabase = zzaws.getWritableDatabase();
            String[] strArr = new String[]{str};
            int delete = (((((((0 + writableDatabase.delete("apps", "app_id=?", strArr)) + writableDatabase.delete("events", "app_id=?", strArr)) + writableDatabase.delete("user_attributes", "app_id=?", strArr)) + writableDatabase.delete("conditional_properties", "app_id=?", strArr)) + writableDatabase.delete("raw_events", "app_id=?", strArr)) + writableDatabase.delete("raw_events_metadata", "app_id=?", strArr)) + writableDatabase.delete("queue", "app_id=?", strArr)) + writableDatabase.delete("audience_filter_values", "app_id=?", strArr);
            if (delete > 0) {
                zzaws.zzawy().zzazj().zze("Reset analytics data. app, records", str, Integer.valueOf(delete));
            }
        } catch (SQLiteException e) {
            zzaws.zzawy().zzazd().zze("Error resetting analytics data. appId, error", zzchm.zzjk(str), e);
        }
        zzf(zza(this.mContext, com_google_android_gms_internal_zzcgi.packageName, com_google_android_gms_internal_zzcgi.zzixs, com_google_android_gms_internal_zzcgi.zzixx, com_google_android_gms_internal_zzcgi.zziye));
    }

    @WorkerThread
    final void zzd(zzcgl com_google_android_gms_internal_zzcgl) {
        zzcgi zzjw = zzjw(com_google_android_gms_internal_zzcgl.packageName);
        if (zzjw != null) {
            zzb(com_google_android_gms_internal_zzcgl, zzjw);
        }
    }

    final void zze(zzcgi com_google_android_gms_internal_zzcgi) {
        zzawx().zzve();
        zzxf();
        zzbq.zzgm(com_google_android_gms_internal_zzcgi.packageName);
        zzg(com_google_android_gms_internal_zzcgi);
    }

    @WorkerThread
    final void zze(zzcgl com_google_android_gms_internal_zzcgl) {
        zzcgi zzjw = zzjw(com_google_android_gms_internal_zzcgl.packageName);
        if (zzjw != null) {
            zzc(com_google_android_gms_internal_zzcgl, zzjw);
        }
    }

    @WorkerThread
    public final void zzf(zzcgi com_google_android_gms_internal_zzcgi) {
        zzcim com_google_android_gms_internal_zzcim = this;
        zzcgi com_google_android_gms_internal_zzcgi2 = com_google_android_gms_internal_zzcgi;
        zzawx().zzve();
        zzxf();
        zzbq.checkNotNull(com_google_android_gms_internal_zzcgi);
        zzbq.zzgm(com_google_android_gms_internal_zzcgi2.packageName);
        if (!TextUtils.isEmpty(com_google_android_gms_internal_zzcgi2.zzixs)) {
            zzcgh zzjb = zzaws().zzjb(com_google_android_gms_internal_zzcgi2.packageName);
            if (!(zzjb == null || !TextUtils.isEmpty(zzjb.getGmpAppId()) || TextUtils.isEmpty(com_google_android_gms_internal_zzcgi2.zzixs))) {
                zzjb.zzar(0);
                zzaws().zza(zzjb);
                zzawv().zzjv(com_google_android_gms_internal_zzcgi2.packageName);
            }
            if (com_google_android_gms_internal_zzcgi2.zzixx) {
                zzcgh zzjb2;
                zzcgo zzaws;
                String str;
                String str2;
                zzcgw com_google_android_gms_internal_zzcgw;
                long j;
                long j2;
                Bundle bundle;
                PackageInfo packageInfo;
                int i;
                ApplicationInfo applicationInfo;
                zzcjk zzaws2;
                long zzal;
                zzcha com_google_android_gms_internal_zzcha;
                long j3 = com_google_android_gms_internal_zzcgi2.zziyc;
                if (j3 == 0) {
                    j3 = com_google_android_gms_internal_zzcim.zzata.currentTimeMillis();
                }
                int i2 = com_google_android_gms_internal_zzcgi2.zziyd;
                if (!(i2 == 0 || i2 == 1)) {
                    zzawy().zzazf().zze("Incorrect app type, assuming installed app. appId, appType", zzchm.zzjk(com_google_android_gms_internal_zzcgi2.packageName), Integer.valueOf(i2));
                    i2 = 0;
                }
                zzaws().beginTransaction();
                zzcjk zzaws3;
                String appId;
                try {
                    zzjb2 = zzaws().zzjb(com_google_android_gms_internal_zzcgi2.packageName);
                    if (!(zzjb2 == null || zzjb2.getGmpAppId() == null || zzjb2.getGmpAppId().equals(com_google_android_gms_internal_zzcgi2.zzixs))) {
                        zzawy().zzazf().zzj("New GMP App Id passed in. Removing cached database data. appId", zzchm.zzjk(zzjb2.getAppId()));
                        zzaws3 = zzaws();
                        appId = zzjb2.getAppId();
                        zzaws3.zzxf();
                        zzaws3.zzve();
                        zzbq.zzgm(appId);
                        SQLiteDatabase writableDatabase = zzaws3.getWritableDatabase();
                        String[] strArr = new String[]{appId};
                        int delete = ((((((((writableDatabase.delete("events", "app_id=?", strArr) + 0) + writableDatabase.delete("user_attributes", "app_id=?", strArr)) + writableDatabase.delete("conditional_properties", "app_id=?", strArr)) + writableDatabase.delete("apps", "app_id=?", strArr)) + writableDatabase.delete("raw_events", "app_id=?", strArr)) + writableDatabase.delete("raw_events_metadata", "app_id=?", strArr)) + writableDatabase.delete("event_filters", "app_id=?", strArr)) + writableDatabase.delete("property_filters", "app_id=?", strArr)) + writableDatabase.delete("audience_filter_values", "app_id=?", strArr);
                        if (delete > 0) {
                            zzaws3.zzawy().zzazj().zze("Deleted application data. app, records", appId, Integer.valueOf(delete));
                        }
                        zzjb2 = null;
                    }
                } catch (SQLiteException e) {
                    zzaws3.zzawy().zzazd().zze("Error deleting application data. appId, error", zzchm.zzjk(appId), e);
                } catch (Throwable th) {
                    Throwable th2 = th;
                    zzaws().endTransaction();
                }
                if (!(zzjb2 == null || zzjb2.zzvj() == null || zzjb2.zzvj().equals(com_google_android_gms_internal_zzcgi2.zzifm))) {
                    Bundle bundle2 = new Bundle();
                    bundle2.putString("_pv", zzjb2.zzvj());
                    zzb(new zzcha("_au", new zzcgx(bundle2), "auto", j3), com_google_android_gms_internal_zzcgi2);
                }
                zzg(com_google_android_gms_internal_zzcgi);
                if (i2 == 0) {
                    zzaws = zzaws();
                    str = com_google_android_gms_internal_zzcgi2.packageName;
                    str2 = "_f";
                } else if (i2 == 1) {
                    zzaws = zzaws();
                    str = com_google_android_gms_internal_zzcgi2.packageName;
                    str2 = "_v";
                } else {
                    com_google_android_gms_internal_zzcgw = null;
                    if (com_google_android_gms_internal_zzcgw != null) {
                        j = ((j3 / 3600000) + 1) * 3600000;
                        if (i2 != 0) {
                            j2 = 1;
                            zzb(new zzcln("_fot", j3, Long.valueOf(j), "auto"), com_google_android_gms_internal_zzcgi2);
                            zzawx().zzve();
                            zzxf();
                            bundle = new Bundle();
                            bundle.putLong("_c", j2);
                            bundle.putLong("_r", j2);
                            bundle.putLong("_uwa", 0);
                            bundle.putLong("_pfo", 0);
                            bundle.putLong("_sys", 0);
                            bundle.putLong("_sysu", 0);
                            if (com_google_android_gms_internal_zzcim.mContext.getPackageManager() != null) {
                                zzawy().zzazd().zzj("PackageManager is null, first open report might be inaccurate. appId", zzchm.zzjk(com_google_android_gms_internal_zzcgi2.packageName));
                            } else {
                                try {
                                    packageInfo = zzbhf.zzdb(com_google_android_gms_internal_zzcim.mContext).getPackageInfo(com_google_android_gms_internal_zzcgi2.packageName, 0);
                                } catch (NameNotFoundException e2) {
                                    zzawy().zzazd().zze("Package info is null, first open report might be inaccurate. appId", zzchm.zzjk(com_google_android_gms_internal_zzcgi2.packageName), e2);
                                    packageInfo = null;
                                }
                                if (!(packageInfo == null || packageInfo.firstInstallTime == 0)) {
                                    if (packageInfo.firstInstallTime == packageInfo.lastUpdateTime) {
                                        bundle.putLong("_uwa", j2);
                                        i = 0;
                                    } else {
                                        i = 1;
                                    }
                                    zzb(new zzcln("_fi", j3, Long.valueOf(i == 0 ? j2 : 0), "auto"), com_google_android_gms_internal_zzcgi2);
                                }
                                try {
                                    applicationInfo = zzbhf.zzdb(com_google_android_gms_internal_zzcim.mContext).getApplicationInfo(com_google_android_gms_internal_zzcgi2.packageName, 0);
                                } catch (NameNotFoundException e22) {
                                    zzawy().zzazd().zze("Application info is null, first open report might be inaccurate. appId", zzchm.zzjk(com_google_android_gms_internal_zzcgi2.packageName), e22);
                                    applicationInfo = null;
                                }
                                if (applicationInfo != null) {
                                    if ((applicationInfo.flags & 1) != 0) {
                                        bundle.putLong("_sys", j2);
                                    }
                                    if ((applicationInfo.flags & 128) != 0) {
                                        bundle.putLong("_sysu", j2);
                                    }
                                }
                            }
                            zzaws2 = zzaws();
                            str = com_google_android_gms_internal_zzcgi2.packageName;
                            zzbq.zzgm(str);
                            zzaws2.zzve();
                            zzaws2.zzxf();
                            zzal = zzaws2.zzal(str, "first_open_count");
                            if (zzal >= 0) {
                                bundle.putLong("_pfo", zzal);
                            }
                            com_google_android_gms_internal_zzcha = new zzcha("_f", new zzcgx(bundle), "auto", j3);
                        } else {
                            j2 = 1;
                            if (i2 == 1) {
                                zzb(new zzcln("_fvt", j3, Long.valueOf(j), "auto"), com_google_android_gms_internal_zzcgi2);
                                zzawx().zzve();
                                zzxf();
                                bundle = new Bundle();
                                bundle.putLong("_c", j2);
                                bundle.putLong("_r", j2);
                                com_google_android_gms_internal_zzcha = new zzcha("_v", new zzcgx(bundle), "auto", j3);
                            }
                            bundle = new Bundle();
                            bundle.putLong("_et", j2);
                            com_google_android_gms_internal_zzcha = new zzcha("_e", new zzcgx(bundle), "auto", j3);
                        }
                        zzb(r14, com_google_android_gms_internal_zzcgi2);
                        bundle = new Bundle();
                        bundle.putLong("_et", j2);
                        com_google_android_gms_internal_zzcha = new zzcha("_e", new zzcgx(bundle), "auto", j3);
                    } else {
                        if (com_google_android_gms_internal_zzcgi2.zzixy) {
                            com_google_android_gms_internal_zzcha = new zzcha("_cd", new zzcgx(new Bundle()), "auto", j3);
                        }
                        zzaws().setTransactionSuccessful();
                        zzaws().endTransaction();
                        return;
                    }
                    zzb(r4, com_google_android_gms_internal_zzcgi2);
                    zzaws().setTransactionSuccessful();
                    zzaws().endTransaction();
                    return;
                }
                com_google_android_gms_internal_zzcgw = zzaws.zzae(str, str2);
                if (com_google_android_gms_internal_zzcgw != null) {
                    if (com_google_android_gms_internal_zzcgi2.zzixy) {
                        com_google_android_gms_internal_zzcha = new zzcha("_cd", new zzcgx(new Bundle()), "auto", j3);
                    }
                    zzaws().setTransactionSuccessful();
                    zzaws().endTransaction();
                    return;
                }
                j = ((j3 / 3600000) + 1) * 3600000;
                if (i2 != 0) {
                    j2 = 1;
                    if (i2 == 1) {
                        zzb(new zzcln("_fvt", j3, Long.valueOf(j), "auto"), com_google_android_gms_internal_zzcgi2);
                        zzawx().zzve();
                        zzxf();
                        bundle = new Bundle();
                        bundle.putLong("_c", j2);
                        bundle.putLong("_r", j2);
                        com_google_android_gms_internal_zzcha = new zzcha("_v", new zzcgx(bundle), "auto", j3);
                    }
                    bundle = new Bundle();
                    bundle.putLong("_et", j2);
                    com_google_android_gms_internal_zzcha = new zzcha("_e", new zzcgx(bundle), "auto", j3);
                } else {
                    j2 = 1;
                    zzb(new zzcln("_fot", j3, Long.valueOf(j), "auto"), com_google_android_gms_internal_zzcgi2);
                    zzawx().zzve();
                    zzxf();
                    bundle = new Bundle();
                    bundle.putLong("_c", j2);
                    bundle.putLong("_r", j2);
                    bundle.putLong("_uwa", 0);
                    bundle.putLong("_pfo", 0);
                    bundle.putLong("_sys", 0);
                    bundle.putLong("_sysu", 0);
                    if (com_google_android_gms_internal_zzcim.mContext.getPackageManager() != null) {
                        packageInfo = zzbhf.zzdb(com_google_android_gms_internal_zzcim.mContext).getPackageInfo(com_google_android_gms_internal_zzcgi2.packageName, 0);
                        if (packageInfo.firstInstallTime == packageInfo.lastUpdateTime) {
                            i = 1;
                        } else {
                            bundle.putLong("_uwa", j2);
                            i = 0;
                        }
                        if (i == 0) {
                        }
                        zzb(new zzcln("_fi", j3, Long.valueOf(i == 0 ? j2 : 0), "auto"), com_google_android_gms_internal_zzcgi2);
                        applicationInfo = zzbhf.zzdb(com_google_android_gms_internal_zzcim.mContext).getApplicationInfo(com_google_android_gms_internal_zzcgi2.packageName, 0);
                        if (applicationInfo != null) {
                            if ((applicationInfo.flags & 1) != 0) {
                                bundle.putLong("_sys", j2);
                            }
                            if ((applicationInfo.flags & 128) != 0) {
                                bundle.putLong("_sysu", j2);
                            }
                        }
                    } else {
                        zzawy().zzazd().zzj("PackageManager is null, first open report might be inaccurate. appId", zzchm.zzjk(com_google_android_gms_internal_zzcgi2.packageName));
                    }
                    zzaws2 = zzaws();
                    str = com_google_android_gms_internal_zzcgi2.packageName;
                    zzbq.zzgm(str);
                    zzaws2.zzve();
                    zzaws2.zzxf();
                    zzal = zzaws2.zzal(str, "first_open_count");
                    if (zzal >= 0) {
                        bundle.putLong("_pfo", zzal);
                    }
                    com_google_android_gms_internal_zzcha = new zzcha("_f", new zzcgx(bundle), "auto", j3);
                }
                zzb(r14, com_google_android_gms_internal_zzcgi2);
                bundle = new Bundle();
                bundle.putLong("_et", j2);
                com_google_android_gms_internal_zzcha = new zzcha("_e", new zzcgx(bundle), "auto", j3);
                zzb(r4, com_google_android_gms_internal_zzcgi2);
                zzaws().setTransactionSuccessful();
                zzaws().endTransaction();
                return;
            }
            zzg(com_google_android_gms_internal_zzcgi);
        }
    }

    @WorkerThread
    final void zzi(Runnable runnable) {
        zzawx().zzve();
        if (this.zzjfy == null) {
            this.zzjfy = new ArrayList();
        }
        this.zzjfy.add(runnable);
    }

    public final String zzjx(String str) {
        try {
            return (String) zzawx().zzc(new zzcio(this, str)).get(30000, TimeUnit.MILLISECONDS);
        } catch (TimeoutException e) {
            zzawy().zzazd().zze("Failed to get app instance id. appId", zzchm.zzjk(str), e);
            return null;
        }
    }

    public final zzd zzws() {
        return this.zzata;
    }

    final void zzxf() {
        if (!this.zzdtb) {
            throw new IllegalStateException("AppMeasurement is not initialized");
        }
    }
}
