package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.internal.view.SupportMenu;

public final class zzcft implements Creator<zzcfs> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int zzd = zzbfn.zzd(parcel);
        double d = 0.0d;
        double d2 = d;
        int i = 0;
        short s = i;
        int i2 = s;
        String str = null;
        float f = 0.0f;
        long j = 0;
        int i3 = -1;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            switch (SupportMenu.USER_MASK & readInt) {
                case 1:
                    str = zzbfn.zzq(parcel2, readInt);
                    break;
                case 2:
                    j = zzbfn.zzi(parcel2, readInt);
                    break;
                case 3:
                    s = zzbfn.zzf(parcel2, readInt);
                    break;
                case 4:
                    d = zzbfn.zzn(parcel2, readInt);
                    break;
                case 5:
                    d2 = zzbfn.zzn(parcel2, readInt);
                    break;
                case 6:
                    f = zzbfn.zzl(parcel2, readInt);
                    break;
                case 7:
                    i = zzbfn.zzg(parcel2, readInt);
                    break;
                case 8:
                    i2 = zzbfn.zzg(parcel2, readInt);
                    break;
                case 9:
                    i3 = zzbfn.zzg(parcel2, readInt);
                    break;
                default:
                    zzbfn.zzb(parcel2, readInt);
                    break;
            }
        }
        zzbfn.zzaf(parcel2, zzd);
        return new zzcfs(str, i, s, d, d2, f, j, i2, i3);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzcfs[i];
    }
}
