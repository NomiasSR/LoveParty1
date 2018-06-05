package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.internal.view.SupportMenu;
import com.google.android.gms.internal.zzbfn;

public final class zzad implements Creator<LocationSettingsStates> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int zzd = zzbfn.zzd(parcel);
        boolean z = false;
        boolean z2 = z;
        boolean z3 = z2;
        boolean z4 = z3;
        boolean z5 = z4;
        boolean z6 = z5;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            switch (SupportMenu.USER_MASK & readInt) {
                case 1:
                    z = zzbfn.zzc(parcel, readInt);
                    break;
                case 2:
                    z2 = zzbfn.zzc(parcel, readInt);
                    break;
                case 3:
                    z3 = zzbfn.zzc(parcel, readInt);
                    break;
                case 4:
                    z4 = zzbfn.zzc(parcel, readInt);
                    break;
                case 5:
                    z5 = zzbfn.zzc(parcel, readInt);
                    break;
                case 6:
                    z6 = zzbfn.zzc(parcel, readInt);
                    break;
                default:
                    zzbfn.zzb(parcel, readInt);
                    break;
            }
        }
        zzbfn.zzaf(parcel, zzd);
        return new LocationSettingsStates(z, z2, z3, z4, z5, z6);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new LocationSettingsStates[i];
    }
}
