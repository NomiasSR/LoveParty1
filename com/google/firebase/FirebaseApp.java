package com.google.firebase;

import android.annotation.TargetApi;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.UiThread;
import android.support.v4.util.ArrayMap;
import android.support.v4.util.ArraySet;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.internal.zzk;
import com.google.android.gms.common.internal.zzbg;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.common.util.zzs;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.auth.GetTokenResult;
import com.google.firebase.internal.InternalTokenProvider;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public class FirebaseApp {
    public static final String DEFAULT_APP_NAME = "[DEFAULT]";
    private static final Object sLock = new Object();
    static final Map<String, FirebaseApp> zzifg = new ArrayMap();
    private static final List<String> zzman = Arrays.asList(new String[]{"com.google.firebase.auth.FirebaseAuth", "com.google.firebase.iid.FirebaseInstanceId"});
    private static final List<String> zzmao = Collections.singletonList("com.google.firebase.crash.FirebaseCrash");
    private static final List<String> zzmap = Arrays.asList(new String[]{"com.google.android.gms.measurement.AppMeasurement"});
    private static final List<String> zzmaq = Arrays.asList(new String[0]);
    private static final Set<String> zzmar = Collections.emptySet();
    private final Context mApplicationContext;
    private final String mName;
    private final FirebaseOptions zzmas;
    private final AtomicBoolean zzmat = new AtomicBoolean(false);
    private final AtomicBoolean zzmau = new AtomicBoolean();
    private final List<IdTokenListener> zzmav = new CopyOnWriteArrayList();
    private final List<zza> zzmaw = new CopyOnWriteArrayList();
    private final List<Object> zzmax = new CopyOnWriteArrayList();
    private InternalTokenProvider zzmay;
    private zzb zzmaz;

    @KeepForSdk
    public interface IdTokenListener {
        void zzb(@NonNull com.google.firebase.internal.zzc com_google_firebase_internal_zzc);
    }

    public interface zza {
        void zzbf(boolean z);
    }

    public interface zzb {
        void zzgj(int i);
    }

    @TargetApi(24)
    static class zzc extends BroadcastReceiver {
        private static AtomicReference<zzc> zzmba = new AtomicReference();
        private final Context mApplicationContext;

        private zzc(Context context) {
            this.mApplicationContext = context;
        }

        private static void zzer(Context context) {
            if (zzmba.get() == null) {
                BroadcastReceiver com_google_firebase_FirebaseApp_zzc = new zzc(context);
                if (zzmba.compareAndSet(null, com_google_firebase_FirebaseApp_zzc)) {
                    context.registerReceiver(com_google_firebase_FirebaseApp_zzc, new IntentFilter("android.intent.action.USER_UNLOCKED"));
                }
            }
        }

        public final void onReceive(Context context, Intent intent) {
            synchronized (FirebaseApp.sLock) {
                for (FirebaseApp zza : FirebaseApp.zzifg.values()) {
                    zza.zzbqr();
                }
            }
            this.mApplicationContext.unregisterReceiver(this);
        }
    }

    private FirebaseApp(Context context, String str, FirebaseOptions firebaseOptions) {
        this.mApplicationContext = (Context) zzbq.checkNotNull(context);
        this.mName = zzbq.zzgm(str);
        this.zzmas = (FirebaseOptions) zzbq.checkNotNull(firebaseOptions);
        this.zzmaz = new com.google.firebase.internal.zza();
    }

    public static List<FirebaseApp> getApps(Context context) {
        List<FirebaseApp> arrayList;
        com.google.firebase.internal.zzb.zzew(context);
        synchronized (sLock) {
            arrayList = new ArrayList(zzifg.values());
            com.google.firebase.internal.zzb.zzcjr();
            Set<String> zzcjs = com.google.firebase.internal.zzb.zzcjs();
            zzcjs.removeAll(zzifg.keySet());
            for (String str : zzcjs) {
                com.google.firebase.internal.zzb.zzrq(str);
                arrayList.add(initializeApp(context, null, str));
            }
        }
        return arrayList;
    }

    @Nullable
    public static FirebaseApp getInstance() {
        FirebaseApp firebaseApp;
        synchronized (sLock) {
            firebaseApp = (FirebaseApp) zzifg.get(DEFAULT_APP_NAME);
            if (firebaseApp == null) {
                String zzamo = zzs.zzamo();
                StringBuilder stringBuilder = new StringBuilder(116 + String.valueOf(zzamo).length());
                stringBuilder.append("Default FirebaseApp is not initialized in this process ");
                stringBuilder.append(zzamo);
                stringBuilder.append(". Make sure to call FirebaseApp.initializeApp(Context) first.");
                throw new IllegalStateException(stringBuilder.toString());
            }
        }
        return firebaseApp;
    }

    public static FirebaseApp getInstance(@NonNull String str) {
        FirebaseApp firebaseApp;
        synchronized (sLock) {
            firebaseApp = (FirebaseApp) zzifg.get(str.trim());
            if (firebaseApp != null) {
            } else {
                String str2;
                Iterable zzbqq = zzbqq();
                if (zzbqq.isEmpty()) {
                    str2 = "";
                } else {
                    String str3 = "Available app names: ";
                    str2 = String.valueOf(TextUtils.join(", ", zzbqq));
                    str2 = str2.length() != 0 ? str3.concat(str2) : new String(str3);
                }
                throw new IllegalStateException(String.format("FirebaseApp with name %s doesn't exist. %s", new Object[]{str, str2}));
            }
        }
        return firebaseApp;
    }

    @Nullable
    public static FirebaseApp initializeApp(Context context) {
        synchronized (sLock) {
            if (zzifg.containsKey(DEFAULT_APP_NAME)) {
                FirebaseApp instance = getInstance();
                return instance;
            }
            FirebaseOptions fromResource = FirebaseOptions.fromResource(context);
            if (fromResource == null) {
                return null;
            }
            instance = initializeApp(context, fromResource);
            return instance;
        }
    }

    public static FirebaseApp initializeApp(Context context, FirebaseOptions firebaseOptions) {
        return initializeApp(context, firebaseOptions, DEFAULT_APP_NAME);
    }

    public static FirebaseApp initializeApp(Context context, FirebaseOptions firebaseOptions, String str) {
        FirebaseApp firebaseApp;
        com.google.firebase.internal.zzb.zzew(context);
        if (context.getApplicationContext() instanceof Application) {
            zzk.zza((Application) context.getApplicationContext());
            zzk.zzahb().zza(new zza());
        }
        str = str.trim();
        if (context.getApplicationContext() != null) {
            context = context.getApplicationContext();
        }
        synchronized (sLock) {
            boolean containsKey = zzifg.containsKey(str) ^ 1;
            StringBuilder stringBuilder = new StringBuilder(33 + String.valueOf(str).length());
            stringBuilder.append("FirebaseApp name ");
            stringBuilder.append(str);
            stringBuilder.append(" already exists!");
            zzbq.zza(containsKey, stringBuilder.toString());
            zzbq.checkNotNull(context, "Application context cannot be null.");
            firebaseApp = new FirebaseApp(context, str, firebaseOptions);
            zzifg.put(str, firebaseApp);
        }
        com.google.firebase.internal.zzb.zzg(firebaseApp);
        firebaseApp.zza(FirebaseApp.class, firebaseApp, zzman);
        if (firebaseApp.zzbqo()) {
            firebaseApp.zza(FirebaseApp.class, firebaseApp, zzmao);
            firebaseApp.zza(Context.class, firebaseApp.getApplicationContext(), zzmap);
        }
        return firebaseApp;
    }

    private final <T> void zza(java.lang.Class<T> r8, T r9, java.lang.Iterable<java.lang.String> r10) {
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
        r7 = this;
        r0 = r7.mApplicationContext;
        r0 = android.support.v4.content.ContextCompat.isDeviceProtectedStorage(r0);
        if (r0 == 0) goto L_0x000d;
    L_0x0008:
        r1 = r7.mApplicationContext;
        com.google.firebase.FirebaseApp.zzc.zzer(r1);
    L_0x000d:
        r10 = r10.iterator();
    L_0x0011:
        r1 = r10.hasNext();
        if (r1 == 0) goto L_0x00b2;
    L_0x0017:
        r1 = r10.next();
        r1 = (java.lang.String) r1;
        if (r0 == 0) goto L_0x002c;
    L_0x001f:
        r2 = zzmaq;	 Catch:{ ClassNotFoundException -> 0x0089, NoSuchMethodException -> 0x0079, InvocationTargetException -> 0x002a, IllegalAccessException -> 0x0028 }
        r2 = r2.contains(r1);	 Catch:{ ClassNotFoundException -> 0x0089, NoSuchMethodException -> 0x0079, InvocationTargetException -> 0x002a, IllegalAccessException -> 0x0028 }
        if (r2 == 0) goto L_0x0011;	 Catch:{ ClassNotFoundException -> 0x0089, NoSuchMethodException -> 0x0079, InvocationTargetException -> 0x002a, IllegalAccessException -> 0x0028 }
    L_0x0027:
        goto L_0x002c;	 Catch:{ ClassNotFoundException -> 0x0089, NoSuchMethodException -> 0x0079, InvocationTargetException -> 0x002a, IllegalAccessException -> 0x0028 }
    L_0x0028:
        r2 = move-exception;	 Catch:{ ClassNotFoundException -> 0x0089, NoSuchMethodException -> 0x0079, InvocationTargetException -> 0x002a, IllegalAccessException -> 0x0028 }
        goto L_0x0055;	 Catch:{ ClassNotFoundException -> 0x0089, NoSuchMethodException -> 0x0079, InvocationTargetException -> 0x002a, IllegalAccessException -> 0x0028 }
    L_0x002a:
        r1 = move-exception;	 Catch:{ ClassNotFoundException -> 0x0089, NoSuchMethodException -> 0x0079, InvocationTargetException -> 0x002a, IllegalAccessException -> 0x0028 }
        goto L_0x0071;	 Catch:{ ClassNotFoundException -> 0x0089, NoSuchMethodException -> 0x0079, InvocationTargetException -> 0x002a, IllegalAccessException -> 0x0028 }
    L_0x002c:
        r2 = java.lang.Class.forName(r1);	 Catch:{ ClassNotFoundException -> 0x0089, NoSuchMethodException -> 0x0079, InvocationTargetException -> 0x002a, IllegalAccessException -> 0x0028 }
        r3 = "getInstance";	 Catch:{ ClassNotFoundException -> 0x0089, NoSuchMethodException -> 0x0079, InvocationTargetException -> 0x002a, IllegalAccessException -> 0x0028 }
        r4 = 1;	 Catch:{ ClassNotFoundException -> 0x0089, NoSuchMethodException -> 0x0079, InvocationTargetException -> 0x002a, IllegalAccessException -> 0x0028 }
        r5 = new java.lang.Class[r4];	 Catch:{ ClassNotFoundException -> 0x0089, NoSuchMethodException -> 0x0079, InvocationTargetException -> 0x002a, IllegalAccessException -> 0x0028 }
        r6 = 0;	 Catch:{ ClassNotFoundException -> 0x0089, NoSuchMethodException -> 0x0079, InvocationTargetException -> 0x002a, IllegalAccessException -> 0x0028 }
        r5[r6] = r8;	 Catch:{ ClassNotFoundException -> 0x0089, NoSuchMethodException -> 0x0079, InvocationTargetException -> 0x002a, IllegalAccessException -> 0x0028 }
        r2 = r2.getMethod(r3, r5);	 Catch:{ ClassNotFoundException -> 0x0089, NoSuchMethodException -> 0x0079, InvocationTargetException -> 0x002a, IllegalAccessException -> 0x0028 }
        r3 = r2.getModifiers();	 Catch:{ ClassNotFoundException -> 0x0089, NoSuchMethodException -> 0x0079, InvocationTargetException -> 0x002a, IllegalAccessException -> 0x0028 }
        r5 = java.lang.reflect.Modifier.isPublic(r3);	 Catch:{ ClassNotFoundException -> 0x0089, NoSuchMethodException -> 0x0079, InvocationTargetException -> 0x002a, IllegalAccessException -> 0x0028 }
        if (r5 == 0) goto L_0x0011;	 Catch:{ ClassNotFoundException -> 0x0089, NoSuchMethodException -> 0x0079, InvocationTargetException -> 0x002a, IllegalAccessException -> 0x0028 }
    L_0x0046:
        r3 = java.lang.reflect.Modifier.isStatic(r3);	 Catch:{ ClassNotFoundException -> 0x0089, NoSuchMethodException -> 0x0079, InvocationTargetException -> 0x002a, IllegalAccessException -> 0x0028 }
        if (r3 == 0) goto L_0x0011;	 Catch:{ ClassNotFoundException -> 0x0089, NoSuchMethodException -> 0x0079, InvocationTargetException -> 0x002a, IllegalAccessException -> 0x0028 }
    L_0x004c:
        r3 = 0;	 Catch:{ ClassNotFoundException -> 0x0089, NoSuchMethodException -> 0x0079, InvocationTargetException -> 0x002a, IllegalAccessException -> 0x0028 }
        r4 = new java.lang.Object[r4];	 Catch:{ ClassNotFoundException -> 0x0089, NoSuchMethodException -> 0x0079, InvocationTargetException -> 0x002a, IllegalAccessException -> 0x0028 }
        r4[r6] = r9;	 Catch:{ ClassNotFoundException -> 0x0089, NoSuchMethodException -> 0x0079, InvocationTargetException -> 0x002a, IllegalAccessException -> 0x0028 }
        r2.invoke(r3, r4);	 Catch:{ ClassNotFoundException -> 0x0089, NoSuchMethodException -> 0x0079, InvocationTargetException -> 0x002a, IllegalAccessException -> 0x0028 }
        goto L_0x0011;
    L_0x0055:
        r3 = "FirebaseApp";
        r4 = "Failed to initialize ";
        r1 = java.lang.String.valueOf(r1);
        r5 = r1.length();
        if (r5 == 0) goto L_0x0068;
    L_0x0063:
        r1 = r4.concat(r1);
        goto L_0x006d;
    L_0x0068:
        r1 = new java.lang.String;
        r1.<init>(r4);
    L_0x006d:
        android.util.Log.wtf(r3, r1, r2);
        goto L_0x0011;
    L_0x0071:
        r2 = "FirebaseApp";
        r3 = "Firebase API initialization failure.";
        android.util.Log.wtf(r2, r3, r1);
        goto L_0x0011;
    L_0x0079:
        r8 = new java.lang.IllegalStateException;
        r9 = java.lang.String.valueOf(r1);
        r10 = "#getInstance has been removed by Proguard. Add keep rule to prevent it.";
        r9 = r9.concat(r10);
        r8.<init>(r9);
        throw r8;
    L_0x0089:
        r2 = zzmar;
        r2 = r2.contains(r1);
        if (r2 == 0) goto L_0x00a1;
    L_0x0091:
        r8 = new java.lang.IllegalStateException;
        r9 = java.lang.String.valueOf(r1);
        r10 = " is missing, but is required. Check if it has been removed by Proguard.";
        r9 = r9.concat(r10);
        r8.<init>(r9);
        throw r8;
    L_0x00a1:
        r2 = "FirebaseApp";
        r1 = java.lang.String.valueOf(r1);
        r3 = " is not linked. Skipping initialization.";
        r1 = r1.concat(r3);
        android.util.Log.d(r2, r1);
        goto L_0x0011;
    L_0x00b2:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.FirebaseApp.zza(java.lang.Class, java.lang.Object, java.lang.Iterable):void");
    }

    public static void zzbf(boolean z) {
        synchronized (sLock) {
            ArrayList arrayList = new ArrayList(zzifg.values());
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                FirebaseApp firebaseApp = (FirebaseApp) obj;
                if (firebaseApp.zzmat.get()) {
                    firebaseApp.zzcd(z);
                }
            }
        }
    }

    private final void zzbqn() {
        zzbq.zza(this.zzmau.get() ^ 1, (Object) "FirebaseApp was deleted");
    }

    private static List<String> zzbqq() {
        Collection arraySet = new ArraySet();
        synchronized (sLock) {
            for (FirebaseApp name : zzifg.values()) {
                arraySet.add(name.getName());
            }
            if (com.google.firebase.internal.zzb.zzcjr() != null) {
                arraySet.addAll(com.google.firebase.internal.zzb.zzcjs());
            }
        }
        List<String> arrayList = new ArrayList(arraySet);
        Collections.sort(arrayList);
        return arrayList;
    }

    private final void zzbqr() {
        zza(FirebaseApp.class, this, zzman);
        if (zzbqo()) {
            zza(FirebaseApp.class, this, zzmao);
            zza(Context.class, this.mApplicationContext, zzmap);
        }
    }

    private final void zzcd(boolean z) {
        Log.d("FirebaseApp", "Notifying background state change listeners.");
        for (zza zzbf : this.zzmaw) {
            zzbf.zzbf(z);
        }
    }

    public boolean equals(Object obj) {
        return !(obj instanceof FirebaseApp) ? false : this.mName.equals(((FirebaseApp) obj).getName());
    }

    @NonNull
    public Context getApplicationContext() {
        zzbqn();
        return this.mApplicationContext;
    }

    @NonNull
    public String getName() {
        zzbqn();
        return this.mName;
    }

    @NonNull
    public FirebaseOptions getOptions() {
        zzbqn();
        return this.zzmas;
    }

    @KeepForSdk
    public Task<GetTokenResult> getToken(boolean z) {
        zzbqn();
        return this.zzmay == null ? Tasks.forException(new FirebaseApiNotAvailableException("firebase-auth is not linked, please fall back to unauthenticated mode.")) : this.zzmay.zzce(z);
    }

    @Nullable
    public final String getUid() throws FirebaseApiNotAvailableException {
        zzbqn();
        if (this.zzmay != null) {
            return this.zzmay.getUid();
        }
        throw new FirebaseApiNotAvailableException("firebase-auth is not linked, please fall back to unauthenticated mode.");
    }

    public int hashCode() {
        return this.mName.hashCode();
    }

    public void setAutomaticResourceManagementEnabled(boolean z) {
        zzbqn();
        if (this.zzmat.compareAndSet(z ^ 1, z)) {
            boolean zzahc = zzk.zzahb().zzahc();
            if (z && zzahc) {
                zzcd(true);
            } else if (!z && zzahc) {
                zzcd(false);
            }
        }
    }

    public String toString() {
        return zzbg.zzx(this).zzg("name", this.mName).zzg("options", this.zzmas).toString();
    }

    public final void zza(@NonNull IdTokenListener idTokenListener) {
        zzbqn();
        zzbq.checkNotNull(idTokenListener);
        this.zzmav.add(idTokenListener);
        this.zzmaz.zzgj(this.zzmav.size());
    }

    public final void zza(zza com_google_firebase_FirebaseApp_zza) {
        zzbqn();
        if (this.zzmat.get() && zzk.zzahb().zzahc()) {
            com_google_firebase_FirebaseApp_zza.zzbf(true);
        }
        this.zzmaw.add(com_google_firebase_FirebaseApp_zza);
    }

    public final void zza(@NonNull zzb com_google_firebase_FirebaseApp_zzb) {
        this.zzmaz = (zzb) zzbq.checkNotNull(com_google_firebase_FirebaseApp_zzb);
        this.zzmaz.zzgj(this.zzmav.size());
    }

    public final void zza(@NonNull InternalTokenProvider internalTokenProvider) {
        this.zzmay = (InternalTokenProvider) zzbq.checkNotNull(internalTokenProvider);
    }

    @UiThread
    public final void zza(@NonNull com.google.firebase.internal.zzc com_google_firebase_internal_zzc) {
        Log.d("FirebaseApp", "Notifying auth state listeners.");
        int i = 0;
        for (IdTokenListener zzb : this.zzmav) {
            zzb.zzb(com_google_firebase_internal_zzc);
            i++;
        }
        Log.d("FirebaseApp", String.format("Notified %d auth state listeners.", new Object[]{Integer.valueOf(i)}));
    }

    public final void zzb(@NonNull IdTokenListener idTokenListener) {
        zzbqn();
        zzbq.checkNotNull(idTokenListener);
        this.zzmav.remove(idTokenListener);
        this.zzmaz.zzgj(this.zzmav.size());
    }

    public final boolean zzbqo() {
        return DEFAULT_APP_NAME.equals(getName());
    }

    public final String zzbqp() {
        String zzm = com.google.android.gms.common.util.zzb.zzm(getName().getBytes());
        String zzm2 = com.google.android.gms.common.util.zzb.zzm(getOptions().getApplicationId().getBytes());
        StringBuilder stringBuilder = new StringBuilder((1 + String.valueOf(zzm).length()) + String.valueOf(zzm2).length());
        stringBuilder.append(zzm);
        stringBuilder.append("+");
        stringBuilder.append(zzm2);
        return stringBuilder.toString();
    }
}
