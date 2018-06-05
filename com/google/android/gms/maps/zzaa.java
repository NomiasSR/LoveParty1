package com.google.android.gms.maps;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.internal.view.SupportMenu;
import com.google.android.gms.internal.zzbfn;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLngBounds;

public final class zzaa implements Creator<GoogleMapOptions> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int zzd = zzbfn.zzd(parcel);
        CameraPosition cameraPosition = null;
        Float f = cameraPosition;
        Float f2 = f;
        LatLngBounds latLngBounds = f2;
        byte b = (byte) -1;
        byte b2 = b;
        byte b3 = b2;
        byte b4 = b3;
        byte b5 = b4;
        byte b6 = b5;
        byte b7 = b6;
        byte b8 = b7;
        byte b9 = b8;
        byte b10 = b9;
        byte b11 = b10;
        int i = 0;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            switch (SupportMenu.USER_MASK & readInt) {
                case 2:
                    b = zzbfn.zze(parcel2, readInt);
                    break;
                case 3:
                    b2 = zzbfn.zze(parcel2, readInt);
                    break;
                case 4:
                    i = zzbfn.zzg(parcel2, readInt);
                    break;
                case 5:
                    cameraPosition = (CameraPosition) zzbfn.zza(parcel2, readInt, CameraPosition.CREATOR);
                    break;
                case 6:
                    b3 = zzbfn.zze(parcel2, readInt);
                    break;
                case 7:
                    b4 = zzbfn.zze(parcel2, readInt);
                    break;
                case 8:
                    b5 = zzbfn.zze(parcel2, readInt);
                    break;
                case 9:
                    b6 = zzbfn.zze(parcel2, readInt);
                    break;
                case 10:
                    b7 = zzbfn.zze(parcel2, readInt);
                    break;
                case 11:
                    b8 = zzbfn.zze(parcel2, readInt);
                    break;
                case 12:
                    b9 = zzbfn.zze(parcel2, readInt);
                    break;
                case 14:
                    b10 = zzbfn.zze(parcel2, readInt);
                    break;
                case 15:
                    b11 = zzbfn.zze(parcel2, readInt);
                    break;
                case 16:
                    f = zzbfn.zzm(parcel2, readInt);
                    break;
                case 17:
                    f2 = zzbfn.zzm(parcel2, readInt);
                    break;
                case 18:
                    latLngBounds = (LatLngBounds) zzbfn.zza(parcel2, readInt, LatLngBounds.CREATOR);
                    break;
                default:
                    zzbfn.zzb(parcel2, readInt);
                    break;
            }
        }
        zzbfn.zzaf(parcel2, zzd);
        return new GoogleMapOptions(b, b2, i, cameraPosition, b3, b4, b5, b6, b7, b8, b9, b10, b11, f, f2, latLngBounds);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new GoogleMapOptions[i];
    }
}
