package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.internal.view.SupportMenu;

public final class zzdyj implements Creator<zzdyi> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int zzd = zzbfn.zzd(parcel);
        boolean z = false;
        boolean z2 = z;
        String str = null;
        String str2 = str;
        zzdyw com_google_android_gms_internal_zzdyw = str2;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            switch (SupportMenu.USER_MASK & readInt) {
                case 2:
                    str = zzbfn.zzq(parcel, readInt);
                    break;
                case 3:
                    z = zzbfn.zzc(parcel, readInt);
                    break;
                case 4:
                    str2 = zzbfn.zzq(parcel, readInt);
                    break;
                case 5:
                    z2 = zzbfn.zzc(parcel, readInt);
                    break;
                case 6:
                    com_google_android_gms_internal_zzdyw = (zzdyw) zzbfn.zza(parcel, readInt, zzdyw.CREATOR);
                    break;
                default:
                    zzbfn.zzb(parcel, readInt);
                    break;
            }
        }
        zzbfn.zzaf(parcel, zzd);
        return new zzdyi(str, z, str2, z2, com_google_android_gms_internal_zzdyw);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzdyi[i];
    }
}
