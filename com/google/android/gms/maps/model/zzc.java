package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.internal.view.SupportMenu;
import com.google.android.gms.internal.zzbfn;
import java.util.List;

public final class zzc implements Creator<CircleOptions> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int zzd = zzbfn.zzd(parcel);
        float f = 0.0f;
        float f2 = f;
        LatLng latLng = null;
        List list = latLng;
        int i = 0;
        int i2 = i;
        boolean z = i2;
        boolean z2 = z;
        double d = 0.0d;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            switch (SupportMenu.USER_MASK & readInt) {
                case 2:
                    latLng = (LatLng) zzbfn.zza(parcel2, readInt, LatLng.CREATOR);
                    break;
                case 3:
                    d = zzbfn.zzn(parcel2, readInt);
                    break;
                case 4:
                    f = zzbfn.zzl(parcel2, readInt);
                    break;
                case 5:
                    i = zzbfn.zzg(parcel2, readInt);
                    break;
                case 6:
                    i2 = zzbfn.zzg(parcel2, readInt);
                    break;
                case 7:
                    f2 = zzbfn.zzl(parcel2, readInt);
                    break;
                case 8:
                    z = zzbfn.zzc(parcel2, readInt);
                    break;
                case 9:
                    z2 = zzbfn.zzc(parcel2, readInt);
                    break;
                case 10:
                    list = zzbfn.zzc(parcel2, readInt, PatternItem.CREATOR);
                    break;
                default:
                    zzbfn.zzb(parcel2, readInt);
                    break;
            }
        }
        zzbfn.zzaf(parcel2, zzd);
        return new CircleOptions(latLng, d, f, i, i2, f2, z, z2, list);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new CircleOptions[i];
    }
}
