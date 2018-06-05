package com.google.android.gms.maps.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.dynamic.zzn;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.maps.model.RuntimeRemoteException;

public class zzbz {
    private static final String TAG = "zzbz";
    private static Context zziub;
    private static zze zziuc;

    private static <T> T zza(java.lang.ClassLoader r2, java.lang.String r3) {
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
        r2 = com.google.android.gms.common.internal.zzbq.checkNotNull(r2);	 Catch:{ ClassNotFoundException -> 0x000f }
        r2 = (java.lang.ClassLoader) r2;	 Catch:{ ClassNotFoundException -> 0x000f }
        r2 = r2.loadClass(r3);	 Catch:{ ClassNotFoundException -> 0x000f }
        r2 = zzd(r2);	 Catch:{ ClassNotFoundException -> 0x000f }
        return r2;
    L_0x000f:
        r2 = new java.lang.IllegalStateException;
        r0 = "Unable to find dynamic class ";
        r3 = java.lang.String.valueOf(r3);
        r1 = r3.length();
        if (r1 == 0) goto L_0x0022;
    L_0x001d:
        r3 = r0.concat(r3);
        goto L_0x0027;
    L_0x0022:
        r3 = new java.lang.String;
        r3.<init>(r0);
    L_0x0027:
        r2.<init>(r3);
        throw r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.maps.internal.zzbz.zza(java.lang.ClassLoader, java.lang.String):T");
    }

    private static <T> T zzd(java.lang.Class<?> r3) {
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
        r0 = r3.newInstance();	 Catch:{ InstantiationException -> 0x0025, IllegalAccessException -> 0x0005 }
        return r0;
    L_0x0005:
        r0 = new java.lang.IllegalStateException;
        r1 = "Unable to call the default constructor of ";
        r3 = r3.getName();
        r3 = java.lang.String.valueOf(r3);
        r2 = r3.length();
        if (r2 == 0) goto L_0x001c;
    L_0x0017:
        r3 = r1.concat(r3);
        goto L_0x0021;
    L_0x001c:
        r3 = new java.lang.String;
        r3.<init>(r1);
    L_0x0021:
        r0.<init>(r3);
        throw r0;
    L_0x0025:
        r0 = new java.lang.IllegalStateException;
        r1 = "Unable to instantiate the dynamic class ";
        r3 = r3.getName();
        r3 = java.lang.String.valueOf(r3);
        r2 = r3.length();
        if (r2 == 0) goto L_0x003c;
    L_0x0037:
        r3 = r1.concat(r3);
        goto L_0x0041;
    L_0x003c:
        r3 = new java.lang.String;
        r3.<init>(r1);
    L_0x0041:
        r0.<init>(r3);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.maps.internal.zzbz.zzd(java.lang.Class):T");
    }

    public static zze zzdt(Context context) throws GooglePlayServicesNotAvailableException {
        zzbq.checkNotNull(context);
        if (zziuc != null) {
            return zziuc;
        }
        int isGooglePlayServicesAvailable = GooglePlayServicesUtil.isGooglePlayServicesAvailable(context);
        if (isGooglePlayServicesAvailable != 0) {
            throw new GooglePlayServicesNotAvailableException(isGooglePlayServicesAvailable);
        }
        zze com_google_android_gms_maps_internal_zze;
        Log.i(TAG, "Making Creator dynamically");
        IBinder iBinder = (IBinder) zza(zzdu(context).getClassLoader(), "com.google.android.gms.maps.internal.CreatorImpl");
        if (iBinder == null) {
            com_google_android_gms_maps_internal_zze = null;
        } else {
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.internal.ICreator");
            com_google_android_gms_maps_internal_zze = queryLocalInterface instanceof zze ? (zze) queryLocalInterface : new zzf(iBinder);
        }
        zziuc = com_google_android_gms_maps_internal_zze;
        try {
            zziuc.zzi(zzn.zzz(zzdu(context).getResources()), GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE);
            return zziuc;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    private static Context zzdu(Context context) {
        if (zziub != null) {
            return zziub;
        }
        context = zzdv(context);
        zziub = context;
        return context;
    }

    private static Context zzdv(Context context) {
        try {
            return DynamiteModule.zza(context, DynamiteModule.zzgww, "com.google.android.gms.maps_dynamite").zzaqb();
        } catch (Throwable th) {
            Log.e(TAG, "Failed to load maps module, use legacy", th);
            return GooglePlayServicesUtil.getRemoteContext(context);
        }
    }
}
