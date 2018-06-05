package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.internal.view.SupportMenu;
import com.google.android.gms.internal.zzbfn;

public final class zzu implements Creator<VisibleRegion> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int zzd = zzbfn.zzd(parcel);
        LatLng latLng = null;
        LatLng latLng2 = latLng;
        LatLng latLng3 = latLng2;
        LatLng latLng4 = latLng3;
        LatLngBounds latLngBounds = latLng4;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            switch (SupportMenu.USER_MASK & readInt) {
                case 2:
                    latLng = (LatLng) zzbfn.zza(parcel, readInt, LatLng.CREATOR);
                    break;
                case 3:
                    latLng2 = (LatLng) zzbfn.zza(parcel, readInt, LatLng.CREATOR);
                    break;
                case 4:
                    latLng3 = (LatLng) zzbfn.zza(parcel, readInt, LatLng.CREATOR);
                    break;
                case 5:
                    latLng4 = (LatLng) zzbfn.zza(parcel, readInt, LatLng.CREATOR);
                    break;
                case 6:
                    latLngBounds = (LatLngBounds) zzbfn.zza(parcel, readInt, LatLngBounds.CREATOR);
                    break;
                default:
                    zzbfn.zzb(parcel, readInt);
                    break;
            }
        }
        zzbfn.zzaf(parcel, zzd);
        return new VisibleRegion(latLng, latLng2, latLng3, latLng4, latLngBounds);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new VisibleRegion[i];
    }
}
