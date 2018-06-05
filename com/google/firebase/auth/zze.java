package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.internal.view.SupportMenu;
import com.google.android.gms.internal.zzbfn;
import com.google.android.gms.internal.zzdyy;

public final class zze implements Creator<zzd> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int zzd = zzbfn.zzd(parcel);
        String str = null;
        String str2 = null;
        String str3 = str2;
        zzdyy com_google_android_gms_internal_zzdyy = str3;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            switch (SupportMenu.USER_MASK & readInt) {
                case 1:
                    str = zzbfn.zzq(parcel, readInt);
                    break;
                case 2:
                    str2 = zzbfn.zzq(parcel, readInt);
                    break;
                case 3:
                    str3 = zzbfn.zzq(parcel, readInt);
                    break;
                case 4:
                    com_google_android_gms_internal_zzdyy = (zzdyy) zzbfn.zza(parcel, readInt, zzdyy.CREATOR);
                    break;
                default:
                    zzbfn.zzb(parcel, readInt);
                    break;
            }
        }
        zzbfn.zzaf(parcel, zzd);
        return new zzd(str, str2, str3, com_google_android_gms_internal_zzdyy);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzd[i];
    }
}
