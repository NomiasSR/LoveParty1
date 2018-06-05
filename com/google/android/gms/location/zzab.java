package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.internal.view.SupportMenu;
import com.google.android.gms.internal.zzbfn;
import java.util.List;

public final class zzab implements Creator<LocationSettingsRequest> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int zzd = zzbfn.zzd(parcel);
        boolean z = false;
        List list = null;
        boolean z2 = false;
        zzz com_google_android_gms_location_zzz = null;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            int i = SupportMenu.USER_MASK & readInt;
            if (i != 5) {
                switch (i) {
                    case 1:
                        list = zzbfn.zzc(parcel, readInt, LocationRequest.CREATOR);
                        break;
                    case 2:
                        z = zzbfn.zzc(parcel, readInt);
                        break;
                    case 3:
                        z2 = zzbfn.zzc(parcel, readInt);
                        break;
                    default:
                        zzbfn.zzb(parcel, readInt);
                        break;
                }
            }
            com_google_android_gms_location_zzz = (zzz) zzbfn.zza(parcel, readInt, zzz.CREATOR);
        }
        zzbfn.zzaf(parcel, zzd);
        return new LocationSettingsRequest(list, z, z2, com_google_android_gms_location_zzz);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new LocationSettingsRequest[i];
    }
}
