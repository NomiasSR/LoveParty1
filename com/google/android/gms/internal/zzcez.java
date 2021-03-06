package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.location.Location;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.location.GeofencingRequest;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.zzag;

public interface zzcez extends IInterface {
    void zza(long j, boolean z, PendingIntent pendingIntent) throws RemoteException;

    void zza(zzcdz com_google_android_gms_internal_zzcdz) throws RemoteException;

    void zza(zzceu com_google_android_gms_internal_zzceu) throws RemoteException;

    void zza(zzcfq com_google_android_gms_internal_zzcfq) throws RemoteException;

    void zza(GeofencingRequest geofencingRequest, PendingIntent pendingIntent, zzcex com_google_android_gms_internal_zzcex) throws RemoteException;

    void zza(LocationSettingsRequest locationSettingsRequest, zzcfb com_google_android_gms_internal_zzcfb, String str) throws RemoteException;

    void zza(zzag com_google_android_gms_location_zzag, zzcex com_google_android_gms_internal_zzcex) throws RemoteException;

    void zzbj(boolean z) throws RemoteException;

    void zzc(PendingIntent pendingIntent) throws RemoteException;

    void zzc(Location location) throws RemoteException;

    Location zzif(String str) throws RemoteException;

    LocationAvailability zzig(String str) throws RemoteException;
}
