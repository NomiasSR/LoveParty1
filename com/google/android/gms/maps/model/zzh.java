package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.internal.view.SupportMenu;
import com.google.android.gms.internal.zzbfn;

public final class zzh implements Creator<MarkerOptions> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int zzd = zzbfn.zzd(parcel);
        boolean z = false;
        boolean z2 = z;
        boolean z3 = z2;
        LatLng latLng = null;
        String str = latLng;
        String str2 = str;
        IBinder iBinder = str2;
        float f = 0.0f;
        float f2 = f;
        float f3 = f2;
        float f4 = f3;
        float f5 = f4;
        float f6 = 0.5f;
        float f7 = 1.0f;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            switch (SupportMenu.USER_MASK & readInt) {
                case 2:
                    latLng = (LatLng) zzbfn.zza(parcel2, readInt, LatLng.CREATOR);
                    break;
                case 3:
                    str = zzbfn.zzq(parcel2, readInt);
                    break;
                case 4:
                    str2 = zzbfn.zzq(parcel2, readInt);
                    break;
                case 5:
                    iBinder = zzbfn.zzr(parcel2, readInt);
                    break;
                case 6:
                    f = zzbfn.zzl(parcel2, readInt);
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
                    z3 = zzbfn.zzc(parcel2, readInt);
                    break;
                case 11:
                    f3 = zzbfn.zzl(parcel2, readInt);
                    break;
                case 12:
                    f6 = zzbfn.zzl(parcel2, readInt);
                    break;
                case 13:
                    f4 = zzbfn.zzl(parcel2, readInt);
                    break;
                case 14:
                    f7 = zzbfn.zzl(parcel2, readInt);
                    break;
                case 15:
                    f5 = zzbfn.zzl(parcel2, readInt);
                    break;
                default:
                    zzbfn.zzb(parcel2, readInt);
                    break;
            }
        }
        zzbfn.zzaf(parcel2, zzd);
        return new MarkerOptions(latLng, str, str2, iBinder, f, f2, z, z2, z3, f3, f6, f4, f7, f5);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new MarkerOptions[i];
    }
}
