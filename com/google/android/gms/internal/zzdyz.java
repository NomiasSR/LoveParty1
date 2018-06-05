package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.internal.view.SupportMenu;

public final class zzdyz implements Creator<zzdyy> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int zzd = zzbfn.zzd(parcel);
        boolean z = false;
        boolean z2 = z;
        String str = null;
        String str2 = str;
        String str3 = str2;
        String str4 = str3;
        String str5 = str4;
        String str6 = str5;
        String str7 = str6;
        String str8 = str7;
        String str9 = str8;
        String str10 = str9;
        String str11 = str10;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            switch (SupportMenu.USER_MASK & readInt) {
                case 2:
                    str = zzbfn.zzq(parcel2, readInt);
                    break;
                case 3:
                    str2 = zzbfn.zzq(parcel2, readInt);
                    break;
                case 4:
                    str3 = zzbfn.zzq(parcel2, readInt);
                    break;
                case 5:
                    str4 = zzbfn.zzq(parcel2, readInt);
                    break;
                case 6:
                    str5 = zzbfn.zzq(parcel2, readInt);
                    break;
                case 7:
                    str6 = zzbfn.zzq(parcel2, readInt);
                    break;
                case 8:
                    str7 = zzbfn.zzq(parcel2, readInt);
                    break;
                case 9:
                    str8 = zzbfn.zzq(parcel2, readInt);
                    break;
                case 10:
                    z = zzbfn.zzc(parcel2, readInt);
                    break;
                case 11:
                    z2 = zzbfn.zzc(parcel2, readInt);
                    break;
                case 12:
                    str9 = zzbfn.zzq(parcel2, readInt);
                    break;
                case 13:
                    str10 = zzbfn.zzq(parcel2, readInt);
                    break;
                case 14:
                    str11 = zzbfn.zzq(parcel2, readInt);
                    break;
                default:
                    zzbfn.zzb(parcel2, readInt);
                    break;
            }
        }
        zzbfn.zzaf(parcel2, zzd);
        return new zzdyy(str, str2, str3, str4, str5, str6, str7, str8, z, z2, str9, str10, str11);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzdyy[i];
    }
}
