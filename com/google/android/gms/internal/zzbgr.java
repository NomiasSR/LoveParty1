package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.internal.view.SupportMenu;

public final class zzbgr implements Creator<zzbgo> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int zzd = zzbfn.zzd(parcel);
        String str = null;
        String str2 = str;
        zzbgh com_google_android_gms_internal_zzbgh = str2;
        int i = 0;
        int i2 = i;
        boolean z = i2;
        int i3 = z;
        boolean z2 = i3;
        int i4 = z2;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            switch (SupportMenu.USER_MASK & readInt) {
                case 1:
                    i = zzbfn.zzg(parcel, readInt);
                    break;
                case 2:
                    i2 = zzbfn.zzg(parcel, readInt);
                    break;
                case 3:
                    z = zzbfn.zzc(parcel, readInt);
                    break;
                case 4:
                    i3 = zzbfn.zzg(parcel, readInt);
                    break;
                case 5:
                    z2 = zzbfn.zzc(parcel, readInt);
                    break;
                case 6:
                    str = zzbfn.zzq(parcel, readInt);
                    break;
                case 7:
                    i4 = zzbfn.zzg(parcel, readInt);
                    break;
                case 8:
                    str2 = zzbfn.zzq(parcel, readInt);
                    break;
                case 9:
                    com_google_android_gms_internal_zzbgh = (zzbgh) zzbfn.zza(parcel, readInt, zzbgh.CREATOR);
                    break;
                default:
                    zzbfn.zzb(parcel, readInt);
                    break;
            }
        }
        zzbfn.zzaf(parcel, zzd);
        return new zzbgo(i, i2, z, i3, z2, str, i4, str2, com_google_android_gms_internal_zzbgh);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzbgo[i];
    }
}
