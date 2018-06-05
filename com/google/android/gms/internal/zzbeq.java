package com.google.android.gms.internal;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;

public interface zzbeq extends IInterface {
    void zza(Status status, long j) throws RemoteException;

    void zza(Status status, zzbef com_google_android_gms_internal_zzbef) throws RemoteException;

    void zza(Status status, zzbeh[] com_google_android_gms_internal_zzbehArr) throws RemoteException;

    void zza(DataHolder dataHolder) throws RemoteException;

    void zzb(Status status, long j) throws RemoteException;

    void zzb(Status status, zzbef com_google_android_gms_internal_zzbef) throws RemoteException;

    void zzo(Status status) throws RemoteException;

    void zzp(Status status) throws RemoteException;

    void zzq(Status status) throws RemoteException;
}
