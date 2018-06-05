package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.internal.view.SupportMenu;

public final class zzcgz implements Creator<zzcgx> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int zzd = zzbfn.zzd(parcel);
        Bundle bundle = null;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            if ((SupportMenu.USER_MASK & readInt) != 2) {
                zzbfn.zzb(parcel, readInt);
            } else {
                bundle = zzbfn.zzs(parcel, readInt);
            }
        }
        zzbfn.zzaf(parcel, zzd);
        return new zzcgx(bundle);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzcgx[i];
    }
}
