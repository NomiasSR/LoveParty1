package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.support.annotation.CallSuper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.WorkerThread;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.zzc;
import com.google.android.gms.common.zzf;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class zzd<T extends IInterface> {
    private static String[] zzfyy = new String[]{"service_esmobile", "service_googleme"};
    private final Context mContext;
    final Handler mHandler;
    private final Object mLock;
    private final Looper zzall;
    private final zzf zzfqc;
    private int zzfyd;
    private long zzfye;
    private long zzfyf;
    private int zzfyg;
    private long zzfyh;
    private zzam zzfyi;
    private final zzag zzfyj;
    private final Object zzfyk;
    private zzay zzfyl;
    protected zzj zzfym;
    private T zzfyn;
    private final ArrayList<zzi<?>> zzfyo;
    private zzl zzfyp;
    private int zzfyq;
    private final zzf zzfyr;
    private final zzg zzfys;
    private final int zzfyt;
    private final String zzfyu;
    private ConnectionResult zzfyv;
    private boolean zzfyw;
    protected AtomicInteger zzfyx;

    protected zzd(Context context, Looper looper, int i, zzf com_google_android_gms_common_internal_zzf, zzg com_google_android_gms_common_internal_zzg, String str) {
        this(context, looper, zzag.zzco(context), zzf.zzafy(), i, (zzf) zzbq.checkNotNull(com_google_android_gms_common_internal_zzf), (zzg) zzbq.checkNotNull(com_google_android_gms_common_internal_zzg), null);
    }

    protected zzd(Context context, Looper looper, zzag com_google_android_gms_common_internal_zzag, zzf com_google_android_gms_common_zzf, int i, zzf com_google_android_gms_common_internal_zzf, zzg com_google_android_gms_common_internal_zzg, String str) {
        this.mLock = new Object();
        this.zzfyk = new Object();
        this.zzfyo = new ArrayList();
        this.zzfyq = 1;
        this.zzfyv = null;
        this.zzfyw = false;
        this.zzfyx = new AtomicInteger(0);
        this.mContext = (Context) zzbq.checkNotNull(context, "Context must not be null");
        this.zzall = (Looper) zzbq.checkNotNull(looper, "Looper must not be null");
        this.zzfyj = (zzag) zzbq.checkNotNull(com_google_android_gms_common_internal_zzag, "Supervisor must not be null");
        this.zzfqc = (zzf) zzbq.checkNotNull(com_google_android_gms_common_zzf, "API availability must not be null");
        this.mHandler = new zzh(this, looper);
        this.zzfyt = i;
        this.zzfyr = com_google_android_gms_common_internal_zzf;
        this.zzfys = com_google_android_gms_common_internal_zzg;
        this.zzfyu = str;
    }

    private final void zza(int i, T t) {
        boolean z = true;
        if ((i == 4) != (t != null)) {
            z = false;
        }
        zzbq.checkArgument(z);
        synchronized (this.mLock) {
            this.zzfyq = i;
            this.zzfyn = t;
            switch (i) {
                case 1:
                    if (this.zzfyp != null) {
                        this.zzfyj.zza(zzhi(), zzakh(), 129, this.zzfyp, zzaki());
                        this.zzfyp = null;
                        break;
                    }
                    break;
                case 2:
                case 3:
                    String zzalo;
                    if (!(this.zzfyp == null || this.zzfyi == null)) {
                        zzalo = this.zzfyi.zzalo();
                        String packageName = this.zzfyi.getPackageName();
                        StringBuilder stringBuilder = new StringBuilder((70 + String.valueOf(zzalo).length()) + String.valueOf(packageName).length());
                        stringBuilder.append("Calling connect() while still connected, missing disconnect() for ");
                        stringBuilder.append(zzalo);
                        stringBuilder.append(" on ");
                        stringBuilder.append(packageName);
                        Log.e("GmsClient", stringBuilder.toString());
                        this.zzfyj.zza(this.zzfyi.zzalo(), this.zzfyi.getPackageName(), this.zzfyi.zzalk(), this.zzfyp, zzaki());
                        this.zzfyx.incrementAndGet();
                    }
                    this.zzfyp = new zzl(this, this.zzfyx.get());
                    this.zzfyi = new zzam(zzakh(), zzhi(), false, 129);
                    if (!this.zzfyj.zza(new zzah(this.zzfyi.zzalo(), this.zzfyi.getPackageName(), this.zzfyi.zzalk()), this.zzfyp, zzaki())) {
                        zzalo = this.zzfyi.zzalo();
                        String packageName2 = this.zzfyi.getPackageName();
                        StringBuilder stringBuilder2 = new StringBuilder((34 + String.valueOf(zzalo).length()) + String.valueOf(packageName2).length());
                        stringBuilder2.append("unable to connect to service: ");
                        stringBuilder2.append(zzalo);
                        stringBuilder2.append(" on ");
                        stringBuilder2.append(packageName2);
                        Log.e("GmsClient", stringBuilder2.toString());
                        zza(16, null, this.zzfyx.get());
                        break;
                    }
                    break;
                case 4:
                    zza((IInterface) t);
                    break;
                default:
                    break;
            }
        }
    }

    private final boolean zza(int i, int i2, T t) {
        synchronized (this.mLock) {
            if (this.zzfyq != i) {
                return false;
            }
            zza(i2, (IInterface) t);
            return true;
        }
    }

    @Nullable
    private final String zzaki() {
        return this.zzfyu == null ? this.mContext.getClass().getName() : this.zzfyu;
    }

    private final boolean zzakk() {
        boolean z;
        synchronized (this.mLock) {
            z = this.zzfyq == 3;
        }
        return z;
    }

    private final boolean zzakq() {
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
        r0 = r2.zzfyw;
        r1 = 0;
        if (r0 == 0) goto L_0x0006;
    L_0x0005:
        return r1;
    L_0x0006:
        r0 = r2.zzhj();
        r0 = android.text.TextUtils.isEmpty(r0);
        if (r0 == 0) goto L_0x0011;
    L_0x0010:
        return r1;
    L_0x0011:
        r0 = 0;
        r0 = android.text.TextUtils.isEmpty(r0);
        if (r0 == 0) goto L_0x0019;
    L_0x0018:
        return r1;
    L_0x0019:
        r0 = r2.zzhj();	 Catch:{ ClassNotFoundException -> 0x0022 }
        java.lang.Class.forName(r0);	 Catch:{ ClassNotFoundException -> 0x0022 }
        r0 = 1;
        return r0;
    L_0x0022:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.internal.zzd.zzakq():boolean");
    }

    private final void zzcf(int i) {
        if (zzakk()) {
            i = 5;
            this.zzfyw = true;
        } else {
            i = 4;
        }
        this.mHandler.sendMessage(this.mHandler.obtainMessage(i, this.zzfyx.get(), 16));
    }

    public void disconnect() {
        this.zzfyx.incrementAndGet();
        synchronized (this.zzfyo) {
            int size = this.zzfyo.size();
            for (int i = 0; i < size; i++) {
                ((zzi) this.zzfyo.get(i)).removeListener();
            }
            this.zzfyo.clear();
        }
        synchronized (this.zzfyk) {
            this.zzfyl = null;
        }
        zza(1, null);
    }

    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        String str2;
        synchronized (this.mLock) {
            int i = this.zzfyq;
            IInterface iInterface = this.zzfyn;
        }
        synchronized (this.zzfyk) {
            zzay com_google_android_gms_common_internal_zzay = this.zzfyl;
        }
        printWriter.append(str).append("mConnectState=");
        switch (i) {
            case 1:
                str2 = "DISCONNECTED";
                break;
            case 2:
                str2 = "REMOTE_CONNECTING";
                break;
            case 3:
                str2 = "LOCAL_CONNECTING";
                break;
            case 4:
                str2 = "CONNECTED";
                break;
            case 5:
                str2 = "DISCONNECTING";
                break;
            default:
                str2 = "UNKNOWN";
                break;
        }
        printWriter.print(str2);
        printWriter.append(" mService=");
        if (iInterface == null) {
            printWriter.append("null");
        } else {
            printWriter.append(zzhj()).append("@").append(Integer.toHexString(System.identityHashCode(iInterface.asBinder())));
        }
        printWriter.append(" mServiceBroker=");
        if (com_google_android_gms_common_internal_zzay == null) {
            printWriter.println("null");
        } else {
            printWriter.append("IGmsServiceBroker@").println(Integer.toHexString(System.identityHashCode(com_google_android_gms_common_internal_zzay.asBinder())));
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.US);
        if (this.zzfyf > 0) {
            PrintWriter append = printWriter.append(str).append("lastConnectedTime=");
            long j = this.zzfyf;
            String format = simpleDateFormat.format(new Date(this.zzfyf));
            StringBuilder stringBuilder = new StringBuilder(String.valueOf(format).length() + 21);
            stringBuilder.append(j);
            stringBuilder.append(" ");
            stringBuilder.append(format);
            append.println(stringBuilder.toString());
        }
        if (this.zzfye > 0) {
            CharSequence charSequence;
            printWriter.append(str).append("lastSuspendedCause=");
            switch (this.zzfyd) {
                case 1:
                    charSequence = "CAUSE_SERVICE_DISCONNECTED";
                    break;
                case 2:
                    charSequence = "CAUSE_NETWORK_LOST";
                    break;
                default:
                    charSequence = String.valueOf(this.zzfyd);
                    break;
            }
            printWriter.append(charSequence);
            append = printWriter.append(" lastSuspendedTime=");
            j = this.zzfye;
            format = simpleDateFormat.format(new Date(this.zzfye));
            stringBuilder = new StringBuilder(String.valueOf(format).length() + 21);
            stringBuilder.append(j);
            stringBuilder.append(" ");
            stringBuilder.append(format);
            append.println(stringBuilder.toString());
        }
        if (this.zzfyh > 0) {
            printWriter.append(str).append("lastFailedStatus=").append(CommonStatusCodes.getStatusCodeString(this.zzfyg));
            PrintWriter append2 = printWriter.append(" lastFailedTime=");
            long j2 = this.zzfyh;
            String format2 = simpleDateFormat.format(new Date(this.zzfyh));
            StringBuilder stringBuilder2 = new StringBuilder(21 + String.valueOf(format2).length());
            stringBuilder2.append(j2);
            stringBuilder2.append(" ");
            stringBuilder2.append(format2);
            append2.println(stringBuilder2.toString());
        }
    }

    public Account getAccount() {
        return null;
    }

    public final Context getContext() {
        return this.mContext;
    }

    public final Looper getLooper() {
        return this.zzall;
    }

    public Intent getSignInIntent() {
        throw new UnsupportedOperationException("Not a sign in API");
    }

    public final boolean isConnected() {
        boolean z;
        synchronized (this.mLock) {
            z = this.zzfyq == 4;
        }
        return z;
    }

    public final boolean isConnecting() {
        boolean z;
        synchronized (this.mLock) {
            if (this.zzfyq != 2) {
                if (this.zzfyq != 3) {
                    z = false;
                }
            }
            z = true;
        }
        return z;
    }

    @CallSuper
    protected void onConnectionFailed(ConnectionResult connectionResult) {
        this.zzfyg = connectionResult.getErrorCode();
        this.zzfyh = System.currentTimeMillis();
    }

    @CallSuper
    protected void onConnectionSuspended(int i) {
        this.zzfyd = i;
        this.zzfye = System.currentTimeMillis();
    }

    protected final void zza(int i, @Nullable Bundle bundle, int i2) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(7, i2, -1, new zzo(this, i, null)));
    }

    protected void zza(int i, IBinder iBinder, Bundle bundle, int i2) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(1, i2, -1, new zzn(this, i, iBinder, bundle)));
    }

    @CallSuper
    protected void zza(@NonNull T t) {
        this.zzfyf = System.currentTimeMillis();
    }

    @WorkerThread
    public final void zza(zzan com_google_android_gms_common_internal_zzan, Set<Scope> set) {
        Bundle zzaap = zzaap();
        zzz com_google_android_gms_common_internal_zzz = new zzz(this.zzfyt);
        com_google_android_gms_common_internal_zzz.zzfzt = this.mContext.getPackageName();
        com_google_android_gms_common_internal_zzz.zzfzw = zzaap;
        if (set != null) {
            com_google_android_gms_common_internal_zzz.zzfzv = (Scope[]) set.toArray(new Scope[set.size()]);
        }
        if (zzaay()) {
            com_google_android_gms_common_internal_zzz.zzfzx = getAccount() != null ? getAccount() : new Account("<<default account>>", "com.google");
            if (com_google_android_gms_common_internal_zzan != null) {
                com_google_android_gms_common_internal_zzz.zzfzu = com_google_android_gms_common_internal_zzan.asBinder();
            }
        } else if (zzako()) {
            com_google_android_gms_common_internal_zzz.zzfzx = getAccount();
        }
        com_google_android_gms_common_internal_zzz.zzfzy = zzakl();
        try {
            synchronized (this.zzfyk) {
                if (this.zzfyl != null) {
                    this.zzfyl.zza(new zzk(this, this.zzfyx.get()), com_google_android_gms_common_internal_zzz);
                } else {
                    Log.w("GmsClient", "mServiceBroker is null, client disconnected");
                }
            }
        } catch (Throwable e) {
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e);
            zzce(1);
        } catch (SecurityException e2) {
            throw e2;
        } catch (Throwable e3) {
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e3);
            zza(8, null, null, this.zzfyx.get());
        }
    }

    public void zza(@NonNull zzj com_google_android_gms_common_internal_zzj) {
        this.zzfym = (zzj) zzbq.checkNotNull(com_google_android_gms_common_internal_zzj, "Connection progress callbacks cannot be null.");
        zza(2, null);
    }

    protected final void zza(@NonNull zzj com_google_android_gms_common_internal_zzj, int i, @Nullable PendingIntent pendingIntent) {
        this.zzfym = (zzj) zzbq.checkNotNull(com_google_android_gms_common_internal_zzj, "Connection progress callbacks cannot be null.");
        this.mHandler.sendMessage(this.mHandler.obtainMessage(3, this.zzfyx.get(), i, pendingIntent));
    }

    public void zza(@NonNull zzp com_google_android_gms_common_internal_zzp) {
        com_google_android_gms_common_internal_zzp.zzajf();
    }

    protected Bundle zzaap() {
        return new Bundle();
    }

    public boolean zzaay() {
        return false;
    }

    public boolean zzabj() {
        return false;
    }

    public Bundle zzafi() {
        return null;
    }

    public boolean zzagg() {
        return true;
    }

    @Nullable
    public final IBinder zzagh() {
        synchronized (this.zzfyk) {
            if (this.zzfyl == null) {
                return null;
            }
            IBinder asBinder = this.zzfyl.asBinder();
            return asBinder;
        }
    }

    public final String zzagi() {
        if (isConnected() && this.zzfyi != null) {
            return this.zzfyi.getPackageName();
        }
        throw new RuntimeException("Failed to connect when checking package");
    }

    protected String zzakh() {
        return "com.google.android.gms";
    }

    public final void zzakj() {
        int isGooglePlayServicesAvailable = this.zzfqc.isGooglePlayServicesAvailable(this.mContext);
        if (isGooglePlayServicesAvailable != 0) {
            zza(1, null);
            zza(new zzm(this), isGooglePlayServicesAvailable, null);
            return;
        }
        zza(new zzm(this));
    }

    public zzc[] zzakl() {
        return new zzc[0];
    }

    protected final void zzakm() {
        if (!isConnected()) {
            throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
        }
    }

    public final T zzakn() throws DeadObjectException {
        T t;
        synchronized (this.mLock) {
            if (this.zzfyq == 5) {
                throw new DeadObjectException();
            }
            zzakm();
            zzbq.zza(this.zzfyn != null, (Object) "Client is connected but service is null");
            t = this.zzfyn;
        }
        return t;
    }

    public boolean zzako() {
        return false;
    }

    protected Set<Scope> zzakp() {
        return Collections.EMPTY_SET;
    }

    public final void zzce(int i) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(6, this.zzfyx.get(), i));
    }

    @Nullable
    protected abstract T zzd(IBinder iBinder);

    @NonNull
    protected abstract String zzhi();

    @NonNull
    protected abstract String zzhj();
}
