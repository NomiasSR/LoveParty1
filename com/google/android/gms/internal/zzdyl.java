package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.internal.view.SupportMenu;

public final class zzdyl implements Creator<zzdyk> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int zzd = zzbfn.zzd(parcel);
        long j = 0;
        long j2 = j;
        boolean z = false;
        boolean z2 = z;
        String str = null;
        String str2 = str;
        String str3 = str2;
        String str4 = str3;
        zzdyq com_google_android_gms_internal_zzdyq = str4;
        String str5 = com_google_android_gms_internal_zzdyq;
        String str6 = str5;
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
                    z = zzbfn.zzc(parcel2, readInt);
                    break;
                case 5:
                    str3 = zzbfn.zzq(parcel2, readInt);
                    break;
                case 6:
                    str4 = zzbfn.zzq(parcel2, readInt);
                    break;
                case 7:
                    com_google_android_gms_internal_zzdyq = (zzdyq) zzbfn.zza(parcel2, readInt, zzdyq.CREATOR);
                    break;
                case 8:
                    str5 = zzbfn.zzq(parcel2, readInt);
                    break;
                case 9:
                    str6 = zzbfn.zzq(parcel2, readInt);
                    break;
                case 10:
                    j = zzbfn.zzi(parcel2, readInt);
                    break;
                case 11:
                    j2 = zzbfn.zzi(parcel2, readInt);
                    break;
                case 12:
                    z2 = zzbfn.zzc(parcel2, readInt);
                    break;
                default:
                    zzbfn.zzb(parcel2, readInt);
                    break;
            }
        }
        zzbfn.zzaf(parcel2, zzd);
        return new zzdyk(str, str2, z, str3, str4, com_google_android_gms_internal_zzdyq, str5, str6, j, j2, z2);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzdyk[i];
    }
}
