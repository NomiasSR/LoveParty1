package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.internal.view.SupportMenu;

public final class zzchb implements Creator<zzcha> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int zzd = zzbfn.zzd(parcel);
        String str = null;
        zzcgx com_google_android_gms_internal_zzcgx = str;
        String str2 = com_google_android_gms_internal_zzcgx;
        long j = 0;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            switch (SupportMenu.USER_MASK & readInt) {
                case 2:
                    str = zzbfn.zzq(parcel, readInt);
                    break;
                case 3:
                    com_google_android_gms_internal_zzcgx = (zzcgx) zzbfn.zza(parcel, readInt, zzcgx.CREATOR);
                    break;
                case 4:
                    str2 = zzbfn.zzq(parcel, readInt);
                    break;
                case 5:
                    j = zzbfn.zzi(parcel, readInt);
                    break;
                default:
                    zzbfn.zzb(parcel, readInt);
                    break;
            }
        }
        zzbfn.zzaf(parcel, zzd);
        return new zzcha(str, com_google_android_gms_internal_zzcgx, str2, j);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzcha[i];
    }
}
