package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.internal.view.SupportMenu;
import com.google.android.gms.location.LocationRequest;
import java.util.List;

public final class zzcfp implements Creator<zzcfo> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int zzd = zzbfn.zzd(parcel);
        List list = zzcfo.zzikv;
        boolean z = false;
        boolean z2 = z;
        boolean z3 = z2;
        LocationRequest locationRequest = null;
        String str = locationRequest;
        String str2 = str;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            int i = SupportMenu.USER_MASK & readInt;
            if (i != 1) {
                switch (i) {
                    case 5:
                        list = zzbfn.zzc(parcel, readInt, zzcdv.CREATOR);
                        break;
                    case 6:
                        str = zzbfn.zzq(parcel, readInt);
                        break;
                    case 7:
                        z = zzbfn.zzc(parcel, readInt);
                        break;
                    case 8:
                        z2 = zzbfn.zzc(parcel, readInt);
                        break;
                    case 9:
                        z3 = zzbfn.zzc(parcel, readInt);
                        break;
                    case 10:
                        str2 = zzbfn.zzq(parcel, readInt);
                        break;
                    default:
                        zzbfn.zzb(parcel, readInt);
                        break;
                }
            }
            locationRequest = (LocationRequest) zzbfn.zza(parcel, readInt, LocationRequest.CREATOR);
        }
        zzbfn.zzaf(parcel, zzd);
        return new zzcfo(locationRequest, list, str, z, z2, z3, str2);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzcfo[i];
    }
}
