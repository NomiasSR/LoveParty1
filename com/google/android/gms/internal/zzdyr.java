package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.internal.view.SupportMenu;
import java.util.List;

public final class zzdyr implements Creator<zzdyq> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int zzd = zzbfn.zzd(parcel);
        List list = null;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            if ((SupportMenu.USER_MASK & readInt) != 2) {
                zzbfn.zzb(parcel, readInt);
            } else {
                list = zzbfn.zzc(parcel, readInt, zzdyo.CREATOR);
            }
        }
        zzbfn.zzaf(parcel, zzd);
        return new zzdyq(list);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzdyq[i];
    }
}
