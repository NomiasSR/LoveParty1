package com.google.firebase.database.connection.idl;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.zzev;

public abstract class zzai extends zzev implements zzah {
    public zzai() {
        attachInterface(this, "com.google.firebase.database.connection.idl.IRequestResultCallback");
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (zza(i, parcel, parcel2, i2)) {
            return true;
        }
        if (i != 1) {
            return false;
        }
        zzbd(parcel.readString(), parcel.readString());
        parcel2.writeNoException();
        return true;
    }
}
