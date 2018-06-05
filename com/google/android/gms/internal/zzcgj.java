package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.internal.view.SupportMenu;

public final class zzcgj implements Creator<zzcgi> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int zzd = zzbfn.zzd(parcel);
        boolean z = false;
        int i = z;
        boolean z2 = true;
        boolean z3 = z2;
        long j = 0;
        long j2 = j;
        long j3 = j2;
        long j4 = j3;
        String str = null;
        String str2 = str;
        String str3 = str2;
        String str4 = str3;
        String str5 = str4;
        String str6 = str5;
        long j5 = -2147483648L;
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
                    j = zzbfn.zzi(parcel2, readInt);
                    break;
                case 7:
                    j2 = zzbfn.zzi(parcel2, readInt);
                    break;
                case 8:
                    str5 = zzbfn.zzq(parcel2, readInt);
                    break;
                case 9:
                    z2 = zzbfn.zzc(parcel2, readInt);
                    break;
                case 10:
                    z = zzbfn.zzc(parcel2, readInt);
                    break;
                case 11:
                    j5 = zzbfn.zzi(parcel2, readInt);
                    break;
                case 12:
                    str6 = zzbfn.zzq(parcel2, readInt);
                    break;
                case 13:
                    j3 = zzbfn.zzi(parcel2, readInt);
                    break;
                case 14:
                    j4 = zzbfn.zzi(parcel2, readInt);
                    break;
                case 15:
                    i = zzbfn.zzg(parcel2, readInt);
                    break;
                case 16:
                    z3 = zzbfn.zzc(parcel2, readInt);
                    break;
                default:
                    zzbfn.zzb(parcel2, readInt);
                    break;
            }
        }
        zzbfn.zzaf(parcel2, zzd);
        return new zzcgi(str, str2, str3, str4, j, j2, str5, z2, z, j5, str6, j3, j4, i, z3);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzcgi[i];
    }
}
