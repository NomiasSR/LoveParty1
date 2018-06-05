package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.internal.view.SupportMenu;
import com.google.android.gms.internal.zzbfn;
import java.util.List;

public final class zzl implements Creator<PolylineOptions> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int zzd = zzbfn.zzd(parcel);
        float f = 0.0f;
        float f2 = f;
        List list = null;
        Cap cap = list;
        Cap cap2 = cap;
        List list2 = cap2;
        int i = 0;
        boolean z = i;
        boolean z2 = z;
        boolean z3 = z2;
        int i2 = z3;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            switch (SupportMenu.USER_MASK & readInt) {
                case 2:
                    list = zzbfn.zzc(parcel2, readInt, LatLng.CREATOR);
                    break;
                case 3:
                    f = zzbfn.zzl(parcel2, readInt);
                    break;
                case 4:
                    i = zzbfn.zzg(parcel2, readInt);
                    break;
                case 5:
                    f2 = zzbfn.zzl(parcel2, readInt);
                    break;
                case 6:
                    z = zzbfn.zzc(parcel2, readInt);
                    break;
                case 7:
                    z2 = zzbfn.zzc(parcel2, readInt);
                    break;
                case 8:
                    z3 = zzbfn.zzc(parcel2, readInt);
                    break;
                case 9:
                    cap = (Cap) zzbfn.zza(parcel2, readInt, Cap.CREATOR);
                    break;
                case 10:
                    cap2 = (Cap) zzbfn.zza(parcel2, readInt, Cap.CREATOR);
                    break;
                case 11:
                    i2 = zzbfn.zzg(parcel2, readInt);
                    break;
                case 12:
                    list2 = zzbfn.zzc(parcel2, readInt, PatternItem.CREATOR);
                    break;
                default:
                    zzbfn.zzb(parcel2, readInt);
                    break;
            }
        }
        zzbfn.zzaf(parcel2, zzd);
        return new PolylineOptions(list, f, i, f2, z, z2, z3, cap, cap2, i2, list2);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new PolylineOptions[i];
    }
}
