package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.internal.view.SupportMenu;
import com.google.android.gms.common.api.Status;

public final class zzcep implements Creator<zzceo> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int zzd = zzbfn.zzd(parcel);
        Status status = null;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            if ((SupportMenu.USER_MASK & readInt) != 1) {
                zzbfn.zzb(parcel, readInt);
            } else {
                status = (Status) zzbfn.zza(parcel, readInt, Status.CREATOR);
            }
        }
        zzbfn.zzaf(parcel, zzd);
        return new zzceo(status);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzceo[i];
    }
}
