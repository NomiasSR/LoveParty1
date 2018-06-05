package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.internal.view.SupportMenu;

public final class zzclo implements Creator<zzcln> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int zzd = zzbfn.zzd(parcel);
        String str = null;
        Long l = str;
        Float f = l;
        String str2 = f;
        String str3 = str2;
        Double d = str3;
        int i = 0;
        long j = 0;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            switch (SupportMenu.USER_MASK & readInt) {
                case 1:
                    i = zzbfn.zzg(parcel2, readInt);
                    break;
                case 2:
                    str = zzbfn.zzq(parcel2, readInt);
                    break;
                case 3:
                    j = zzbfn.zzi(parcel2, readInt);
                    break;
                case 4:
                    l = zzbfn.zzj(parcel2, readInt);
                    break;
                case 5:
                    f = zzbfn.zzm(parcel2, readInt);
                    break;
                case 6:
                    str2 = zzbfn.zzq(parcel2, readInt);
                    break;
                case 7:
                    str3 = zzbfn.zzq(parcel2, readInt);
                    break;
                case 8:
                    d = zzbfn.zzo(parcel2, readInt);
                    break;
                default:
                    zzbfn.zzb(parcel2, readInt);
                    break;
            }
        }
        zzbfn.zzaf(parcel2, zzd);
        return new zzcln(i, str, j, l, f, str2, str3, d);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzcln[i];
    }
}
