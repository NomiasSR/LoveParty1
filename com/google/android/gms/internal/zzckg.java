package com.google.android.gms.internal;

import android.content.ComponentName;
import android.content.Context;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.support.annotation.WorkerThread;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.common.util.zzd;
import com.google.android.gms.measurement.AppMeasurement.zzb;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public final class zzckg extends zzcjl {
    private final zzcku zzjic;
    private zzche zzjid;
    private volatile Boolean zzjie;
    private final zzcgs zzjif;
    private final zzclk zzjig;
    private final List<Runnable> zzjih = new ArrayList();
    private final zzcgs zzjii;

    protected zzckg(zzcim com_google_android_gms_internal_zzcim) {
        super(com_google_android_gms_internal_zzcim);
        this.zzjig = new zzclk(com_google_android_gms_internal_zzcim.zzws());
        this.zzjic = new zzcku(this);
        this.zzjif = new zzckh(this, com_google_android_gms_internal_zzcim);
        this.zzjii = new zzckm(this, com_google_android_gms_internal_zzcim);
    }

    @WorkerThread
    private final void onServiceDisconnected(ComponentName componentName) {
        zzve();
        if (this.zzjid != null) {
            this.zzjid = null;
            zzawy().zzazj().zzj("Disconnected from device MeasurementService", componentName);
            zzve();
            zzyc();
        }
    }

    @WorkerThread
    private final void zzbat() {
        zzve();
        zzawy().zzazj().zzj("Processing queued up service tasks", Integer.valueOf(this.zzjih.size()));
        for (Runnable run : this.zzjih) {
            try {
                run.run();
            } catch (Throwable th) {
                zzawy().zzazd().zzj("Task exception while flushing queue", th);
            }
        }
        this.zzjih.clear();
        this.zzjii.cancel();
    }

    @Nullable
    @WorkerThread
    private final zzcgi zzbr(boolean z) {
        return zzawn().zzjg(z ? zzawy().zzazk() : null);
    }

    @WorkerThread
    private final void zzj(Runnable runnable) throws IllegalStateException {
        zzve();
        if (isConnected()) {
            runnable.run();
        } else if (((long) this.zzjih.size()) >= 1000) {
            zzawy().zzazd().log("Discarding data. Max runnable queue size reached");
        } else {
            this.zzjih.add(runnable);
            this.zzjii.zzs(60000);
            zzyc();
        }
    }

    @WorkerThread
    private final void zzxr() {
        zzve();
        this.zzjig.start();
        this.zzjif.zzs(((Long) zzchc.zzjbj.get()).longValue());
    }

    @WorkerThread
    private final void zzxs() {
        zzve();
        if (isConnected()) {
            zzawy().zzazj().log("Inactivity, disconnecting from the service");
            disconnect();
        }
    }

    @android.support.annotation.WorkerThread
    public final void disconnect() {
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
        r2 = this;
        r2.zzve();
        r2.zzxf();
        com.google.android.gms.common.stats.zza.zzamc();	 Catch:{ IllegalStateException -> 0x0012, IllegalStateException -> 0x0012 }
        r0 = r2.getContext();	 Catch:{ IllegalStateException -> 0x0012, IllegalStateException -> 0x0012 }
        r1 = r2.zzjic;	 Catch:{ IllegalStateException -> 0x0012, IllegalStateException -> 0x0012 }
        r0.unbindService(r1);	 Catch:{ IllegalStateException -> 0x0012, IllegalStateException -> 0x0012 }
    L_0x0012:
        r0 = 0;
        r2.zzjid = r0;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzckg.disconnect():void");
    }

    public final /* bridge */ /* synthetic */ Context getContext() {
        return super.getContext();
    }

    @WorkerThread
    public final boolean isConnected() {
        zzve();
        zzxf();
        return this.zzjid != null;
    }

    @WorkerThread
    protected final void resetAnalyticsData() {
        zzve();
        zzxf();
        zzcgi zzbr = zzbr(false);
        zzawr().resetAnalyticsData();
        zzj(new zzcki(this, zzbr));
    }

    @WorkerThread
    protected final void zza(zzche com_google_android_gms_internal_zzche) {
        zzve();
        zzbq.checkNotNull(com_google_android_gms_internal_zzche);
        this.zzjid = com_google_android_gms_internal_zzche;
        zzxr();
        zzbat();
    }

    @WorkerThread
    final void zza(zzche com_google_android_gms_internal_zzche, zzbfm com_google_android_gms_internal_zzbfm, zzcgi com_google_android_gms_internal_zzcgi) {
        zzcho zzazd;
        String str;
        zzve();
        zzxf();
        int i = 0;
        int i2 = 100;
        while (i < 1001 && r3 == 100) {
            int size;
            List arrayList = new ArrayList();
            Object zzeb = zzawr().zzeb(100);
            if (zzeb != null) {
                arrayList.addAll(zzeb);
                size = zzeb.size();
            } else {
                size = 0;
            }
            if (com_google_android_gms_internal_zzbfm != null && size < 100) {
                arrayList.add(com_google_android_gms_internal_zzbfm);
            }
            ArrayList arrayList2 = (ArrayList) arrayList;
            int size2 = arrayList2.size();
            int i3 = 0;
            while (i3 < size2) {
                Object obj = arrayList2.get(i3);
                i3++;
                zzbfm com_google_android_gms_internal_zzbfm2 = (zzbfm) obj;
                if (com_google_android_gms_internal_zzbfm2 instanceof zzcha) {
                    try {
                        com_google_android_gms_internal_zzche.zza((zzcha) com_google_android_gms_internal_zzbfm2, com_google_android_gms_internal_zzcgi);
                    } catch (RemoteException e) {
                        obj = e;
                        zzazd = zzawy().zzazd();
                        str = "Failed to send event to the service";
                        zzazd.zzj(str, obj);
                    }
                } else if (com_google_android_gms_internal_zzbfm2 instanceof zzcln) {
                    try {
                        com_google_android_gms_internal_zzche.zza((zzcln) com_google_android_gms_internal_zzbfm2, com_google_android_gms_internal_zzcgi);
                    } catch (RemoteException e2) {
                        obj = e2;
                        zzazd = zzawy().zzazd();
                        str = "Failed to send attribute to the service";
                        zzazd.zzj(str, obj);
                    }
                } else if (com_google_android_gms_internal_zzbfm2 instanceof zzcgl) {
                    try {
                        com_google_android_gms_internal_zzche.zza((zzcgl) com_google_android_gms_internal_zzbfm2, com_google_android_gms_internal_zzcgi);
                    } catch (RemoteException e3) {
                        obj = e3;
                        zzazd = zzawy().zzazd();
                        str = "Failed to send conditional property to the service";
                        zzazd.zzj(str, obj);
                    }
                } else {
                    zzawy().zzazd().log("Discarding data. Unrecognized parcel type.");
                }
            }
            i++;
            i2 = size;
        }
    }

    @WorkerThread
    protected final void zza(zzb com_google_android_gms_measurement_AppMeasurement_zzb) {
        zzve();
        zzxf();
        zzj(new zzckl(this, com_google_android_gms_measurement_AppMeasurement_zzb));
    }

    @WorkerThread
    public final void zza(AtomicReference<String> atomicReference) {
        zzve();
        zzxf();
        zzj(new zzckj(this, atomicReference, zzbr(false)));
    }

    @WorkerThread
    protected final void zza(AtomicReference<List<zzcgl>> atomicReference, String str, String str2, String str3) {
        zzve();
        zzxf();
        zzj(new zzckq(this, atomicReference, str, str2, str3, zzbr(false)));
    }

    @WorkerThread
    protected final void zza(AtomicReference<List<zzcln>> atomicReference, String str, String str2, String str3, boolean z) {
        zzve();
        zzxf();
        zzj(new zzckr(this, atomicReference, str, str2, str3, z, zzbr(false)));
    }

    @WorkerThread
    protected final void zza(AtomicReference<List<zzcln>> atomicReference, boolean z) {
        zzve();
        zzxf();
        zzj(new zzckt(this, atomicReference, zzbr(false), z));
    }

    public final /* bridge */ /* synthetic */ void zzawi() {
        super.zzawi();
    }

    public final /* bridge */ /* synthetic */ void zzawj() {
        super.zzawj();
    }

    public final /* bridge */ /* synthetic */ zzcgd zzawk() {
        return super.zzawk();
    }

    public final /* bridge */ /* synthetic */ zzcgk zzawl() {
        return super.zzawl();
    }

    public final /* bridge */ /* synthetic */ zzcjn zzawm() {
        return super.zzawm();
    }

    public final /* bridge */ /* synthetic */ zzchh zzawn() {
        return super.zzawn();
    }

    public final /* bridge */ /* synthetic */ zzcgu zzawo() {
        return super.zzawo();
    }

    public final /* bridge */ /* synthetic */ zzckg zzawp() {
        return super.zzawp();
    }

    public final /* bridge */ /* synthetic */ zzckc zzawq() {
        return super.zzawq();
    }

    public final /* bridge */ /* synthetic */ zzchi zzawr() {
        return super.zzawr();
    }

    public final /* bridge */ /* synthetic */ zzcgo zzaws() {
        return super.zzaws();
    }

    public final /* bridge */ /* synthetic */ zzchk zzawt() {
        return super.zzawt();
    }

    public final /* bridge */ /* synthetic */ zzclq zzawu() {
        return super.zzawu();
    }

    public final /* bridge */ /* synthetic */ zzcig zzawv() {
        return super.zzawv();
    }

    public final /* bridge */ /* synthetic */ zzclf zzaww() {
        return super.zzaww();
    }

    public final /* bridge */ /* synthetic */ zzcih zzawx() {
        return super.zzawx();
    }

    public final /* bridge */ /* synthetic */ zzchm zzawy() {
        return super.zzawy();
    }

    public final /* bridge */ /* synthetic */ zzchx zzawz() {
        return super.zzawz();
    }

    public final /* bridge */ /* synthetic */ zzcgn zzaxa() {
        return super.zzaxa();
    }

    protected final boolean zzaxz() {
        return false;
    }

    @WorkerThread
    protected final void zzb(zzcln com_google_android_gms_internal_zzcln) {
        zzve();
        zzxf();
        zzj(new zzcks(this, zzawr().zza(com_google_android_gms_internal_zzcln), com_google_android_gms_internal_zzcln, zzbr(true)));
    }

    @WorkerThread
    protected final void zzbaq() {
        zzve();
        zzxf();
        zzj(new zzckn(this, zzbr(true)));
    }

    @WorkerThread
    protected final void zzbar() {
        zzve();
        zzxf();
        zzj(new zzckk(this, zzbr(true)));
    }

    final Boolean zzbas() {
        return this.zzjie;
    }

    @WorkerThread
    protected final void zzc(zzcha com_google_android_gms_internal_zzcha, String str) {
        zzbq.checkNotNull(com_google_android_gms_internal_zzcha);
        zzve();
        zzxf();
        zzj(new zzcko(this, true, zzawr().zza(com_google_android_gms_internal_zzcha), com_google_android_gms_internal_zzcha, zzbr(true), str));
    }

    @WorkerThread
    protected final void zzf(zzcgl com_google_android_gms_internal_zzcgl) {
        zzbq.checkNotNull(com_google_android_gms_internal_zzcgl);
        zzve();
        zzxf();
        zzj(new zzckp(this, true, zzawr().zzc(com_google_android_gms_internal_zzcgl), new zzcgl(com_google_android_gms_internal_zzcgl), zzbr(true), com_google_android_gms_internal_zzcgl));
    }

    public final /* bridge */ /* synthetic */ void zzve() {
        super.zzve();
    }

    public final /* bridge */ /* synthetic */ zzd zzws() {
        return super.zzws();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    @android.support.annotation.WorkerThread
    final void zzyc() {
        /*
        r6 = this;
        r6.zzve();
        r6.zzxf();
        r0 = r6.isConnected();
        if (r0 == 0) goto L_0x000d;
    L_0x000c:
        return;
    L_0x000d:
        r0 = r6.zzjie;
        r1 = 0;
        r2 = 1;
        if (r0 != 0) goto L_0x00ff;
    L_0x0013:
        r6.zzve();
        r6.zzxf();
        r0 = r6.zzawz();
        r0 = r0.zzazo();
        if (r0 == 0) goto L_0x002c;
    L_0x0023:
        r0 = r0.booleanValue();
        if (r0 == 0) goto L_0x002c;
    L_0x0029:
        r3 = r2;
        goto L_0x00f9;
    L_0x002c:
        r0 = r6.zzawn();
        r0 = r0.zzazb();
        if (r0 != r2) goto L_0x003a;
    L_0x0036:
        r0 = r2;
    L_0x0037:
        r3 = r0;
        goto L_0x00f0;
    L_0x003a:
        r0 = r6.zzawy();
        r0 = r0.zzazj();
        r3 = "Checking service availability";
        r0.log(r3);
        r0 = r6.zzawu();
        r3 = com.google.android.gms.common.zzf.zzafy();
        r0 = r0.getContext();
        r0 = r3.isGooglePlayServicesAvailable(r0);
        r3 = 9;
        if (r0 == r3) goto L_0x00e5;
    L_0x005b:
        r3 = 18;
        if (r0 == r3) goto L_0x00da;
    L_0x005f:
        switch(r0) {
            case 0: goto L_0x00cb;
            case 1: goto L_0x00bb;
            case 2: goto L_0x0083;
            case 3: goto L_0x0075;
            default: goto L_0x0062;
        };
    L_0x0062:
        r3 = r6.zzawy();
        r3 = r3.zzazf();
        r4 = "Unexpected service status";
        r0 = java.lang.Integer.valueOf(r0);
        r3.zzj(r4, r0);
    L_0x0073:
        r0 = r1;
        goto L_0x0037;
    L_0x0075:
        r0 = r6.zzawy();
        r0 = r0.zzazf();
        r3 = "Service disabled";
    L_0x007f:
        r0.log(r3);
        goto L_0x0073;
    L_0x0083:
        r0 = r6.zzawy();
        r0 = r0.zzazi();
        r3 = "Service container out of date";
        r0.log(r3);
        r0 = r6.zzawu();
        com.google.android.gms.common.zzf.zzafy();
        r0 = r0.getContext();
        r0 = com.google.android.gms.common.zzf.zzcf(r0);
        r3 = 11400; // 0x2c88 float:1.5975E-41 double:5.6323E-320;
        if (r0 >= r3) goto L_0x00a4;
    L_0x00a3:
        goto L_0x00c8;
    L_0x00a4:
        r0 = r6.zzawz();
        r0 = r0.zzazo();
        if (r0 == 0) goto L_0x00b7;
    L_0x00ae:
        r0 = r0.booleanValue();
        if (r0 == 0) goto L_0x00b5;
    L_0x00b4:
        goto L_0x00b7;
    L_0x00b5:
        r0 = r1;
        goto L_0x00b8;
    L_0x00b7:
        r0 = r2;
    L_0x00b8:
        r3 = r0;
        r0 = r1;
        goto L_0x00f0;
    L_0x00bb:
        r0 = r6.zzawy();
        r0 = r0.zzazj();
        r3 = "Service missing";
        r0.log(r3);
    L_0x00c8:
        r3 = r1;
        r0 = r2;
        goto L_0x00f0;
    L_0x00cb:
        r0 = r6.zzawy();
        r0 = r0.zzazj();
        r3 = "Service available";
    L_0x00d5:
        r0.log(r3);
        goto L_0x0036;
    L_0x00da:
        r0 = r6.zzawy();
        r0 = r0.zzazf();
        r3 = "Service updating";
        goto L_0x00d5;
    L_0x00e5:
        r0 = r6.zzawy();
        r0 = r0.zzazf();
        r3 = "Service invalid";
        goto L_0x007f;
    L_0x00f0:
        if (r0 == 0) goto L_0x00f9;
    L_0x00f2:
        r0 = r6.zzawz();
        r0.zzbm(r3);
    L_0x00f9:
        r0 = java.lang.Boolean.valueOf(r3);
        r6.zzjie = r0;
    L_0x00ff:
        r0 = r6.zzjie;
        r0 = r0.booleanValue();
        if (r0 == 0) goto L_0x010d;
    L_0x0107:
        r0 = r6.zzjic;
        r0.zzbau();
        return;
    L_0x010d:
        r0 = r6.getContext();
        r0 = r0.getPackageManager();
        r3 = new android.content.Intent;
        r3.<init>();
        r4 = r6.getContext();
        r5 = "com.google.android.gms.measurement.AppMeasurementService";
        r3 = r3.setClassName(r4, r5);
        r4 = 65536; // 0x10000 float:9.18355E-41 double:3.2379E-319;
        r0 = r0.queryIntentServices(r3, r4);
        if (r0 == 0) goto L_0x0133;
    L_0x012c:
        r0 = r0.size();
        if (r0 <= 0) goto L_0x0133;
    L_0x0132:
        r1 = r2;
    L_0x0133:
        if (r1 == 0) goto L_0x0150;
    L_0x0135:
        r0 = new android.content.Intent;
        r1 = "com.google.android.gms.measurement.START";
        r0.<init>(r1);
        r1 = new android.content.ComponentName;
        r2 = r6.getContext();
        r3 = "com.google.android.gms.measurement.AppMeasurementService";
        r1.<init>(r2, r3);
        r0.setComponent(r1);
        r1 = r6.zzjic;
        r1.zzn(r0);
        return;
    L_0x0150:
        r0 = r6.zzawy();
        r0 = r0.zzazd();
        r1 = "Unable to use remote or local measurement implementation. Please register the AppMeasurementService service in the app manifest";
        r0.log(r1);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzckg.zzyc():void");
    }
}
