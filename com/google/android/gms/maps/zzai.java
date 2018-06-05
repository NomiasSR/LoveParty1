package com.google.android.gms.maps;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.internal.view.SupportMenu;
import com.google.android.gms.internal.zzbfn;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;

public final class zzai implements Creator<StreetViewPanoramaOptions> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int zzd = zzbfn.zzd(parcel);
        StreetViewPanoramaCamera streetViewPanoramaCamera = null;
        String str = streetViewPanoramaCamera;
        LatLng latLng = str;
        Integer num = latLng;
        byte b = (byte) 0;
        byte b2 = b;
        byte b3 = b2;
        byte b4 = b3;
        byte b5 = b4;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            switch (SupportMenu.USER_MASK & readInt) {
                case 2:
                    streetViewPanoramaCamera = (StreetViewPanoramaCamera) zzbfn.zza(parcel, readInt, StreetViewPanoramaCamera.CREATOR);
                    break;
                case 3:
                    str = zzbfn.zzq(parcel, readInt);
                    break;
                case 4:
                    latLng = (LatLng) zzbfn.zza(parcel, readInt, LatLng.CREATOR);
                    break;
                case 5:
                    num = zzbfn.zzh(parcel, readInt);
                    break;
                case 6:
                    b = zzbfn.zze(parcel, readInt);
                    break;
                case 7:
                    b2 = zzbfn.zze(parcel, readInt);
                    break;
                case 8:
                    b3 = zzbfn.zze(parcel, readInt);
                    break;
                case 9:
                    b4 = zzbfn.zze(parcel, readInt);
                    break;
                case 10:
                    b5 = zzbfn.zze(parcel, readInt);
                    break;
                default:
                    zzbfn.zzb(parcel, readInt);
                    break;
            }
        }
        zzbfn.zzaf(parcel, zzd);
        return new StreetViewPanoramaOptions(streetViewPanoramaCamera, str, latLng, num, b, b2, b3, b4, b5);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new StreetViewPanoramaOptions[i];
    }
}
