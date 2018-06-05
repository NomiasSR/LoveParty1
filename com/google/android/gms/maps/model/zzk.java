package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.internal.view.SupportMenu;
import com.google.android.gms.internal.zzbfn;
import java.util.ArrayList;
import java.util.List;

public final class zzk implements Creator<PolygonOptions> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int zzd = zzbfn.zzd(parcel);
        List arrayList = new ArrayList();
        List list = null;
        float f = 0.0f;
        List list2 = null;
        int i = 0;
        int i2 = i;
        boolean z = i2;
        boolean z2 = z;
        boolean z3 = z2;
        int i3 = z3;
        float f2 = f;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            switch (SupportMenu.USER_MASK & readInt) {
                case 2:
                    list = zzbfn.zzc(parcel, readInt, LatLng.CREATOR);
                    break;
                case 3:
                    zzbfn.zza(parcel, readInt, arrayList, getClass().getClassLoader());
                    break;
                case 4:
                    f2 = zzbfn.zzl(parcel, readInt);
                    break;
                case 5:
                    i = zzbfn.zzg(parcel, readInt);
                    break;
                case 6:
                    i2 = zzbfn.zzg(parcel, readInt);
                    break;
                case 7:
                    f = zzbfn.zzl(parcel, readInt);
                    break;
                case 8:
                    z = zzbfn.zzc(parcel, readInt);
                    break;
                case 9:
                    z2 = zzbfn.zzc(parcel, readInt);
                    break;
                case 10:
                    z3 = zzbfn.zzc(parcel, readInt);
                    break;
                case 11:
                    i3 = zzbfn.zzg(parcel, readInt);
                    break;
                case 12:
                    list2 = zzbfn.zzc(parcel, readInt, PatternItem.CREATOR);
                    break;
                default:
                    zzbfn.zzb(parcel, readInt);
                    break;
            }
        }
        zzbfn.zzaf(parcel, zzd);
        return new PolygonOptions(list, arrayList, f2, i, i2, f, z, z2, z3, i3, list2);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new PolygonOptions[i];
    }
}
