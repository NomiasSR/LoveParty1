package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.internal.view.SupportMenu;
import com.google.android.gms.internal.zzbfn;

public final class zzd implements Creator<GroundOverlayOptions> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int zzd = zzbfn.zzd(parcel);
        boolean z = false;
        boolean z2 = z;
        IBinder iBinder = null;
        LatLng latLng = iBinder;
        LatLngBounds latLngBounds = latLng;
        float f = 0.0f;
        float f2 = f;
        float f3 = f2;
        float f4 = f3;
        float f5 = f4;
        float f6 = f5;
        float f7 = f6;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            switch (SupportMenu.USER_MASK & readInt) {
                case 2:
                    iBinder = zzbfn.zzr(parcel2, readInt);
                    break;
                case 3:
                    latLng = (LatLng) zzbfn.zza(parcel2, readInt, LatLng.CREATOR);
                    break;
                case 4:
                    f = zzbfn.zzl(parcel2, readInt);
                    break;
                case 5:
                    f2 = zzbfn.zzl(parcel2, readInt);
                    break;
                case 6:
                    latLngBounds = (LatLngBounds) zzbfn.zza(parcel2, readInt, LatLngBounds.CREATOR);
                    break;
                case 7:
                    f3 = zzbfn.zzl(parcel2, readInt);
                    break;
                case 8:
                    f4 = zzbfn.zzl(parcel2, readInt);
                    break;
                case 9:
                    z = zzbfn.zzc(parcel2, readInt);
                    break;
                case 10:
                    f5 = zzbfn.zzl(parcel2, readInt);
                    break;
                case 11:
                    f6 = zzbfn.zzl(parcel2, readInt);
                    break;
                case 12:
                    f7 = zzbfn.zzl(parcel2, readInt);
                    break;
                case 13:
                    z2 = zzbfn.zzc(parcel2, readInt);
                    break;
                default:
                    zzbfn.zzb(parcel2, readInt);
                    break;
            }
        }
        zzbfn.zzaf(parcel2, zzd);
        return new GroundOverlayOptions(iBinder, latLng, f, f2, latLngBounds, f3, f4, z, f5, f6, f7, z2);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new GroundOverlayOptions[i];
    }
}
