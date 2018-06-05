package com.google.android.gms.common.data;

import android.database.CursorWindow;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.internal.view.SupportMenu;
import com.google.android.gms.internal.zzbfn;

public final class zzf implements Creator<DataHolder> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int zzd = zzbfn.zzd(parcel);
        int i = 0;
        int i2 = i;
        String[] strArr = null;
        CursorWindow[] cursorWindowArr = strArr;
        Bundle bundle = cursorWindowArr;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            int i3 = SupportMenu.USER_MASK & readInt;
            if (i3 != 1000) {
                switch (i3) {
                    case 1:
                        strArr = zzbfn.zzaa(parcel, readInt);
                        break;
                    case 2:
                        cursorWindowArr = (CursorWindow[]) zzbfn.zzb(parcel, readInt, CursorWindow.CREATOR);
                        break;
                    case 3:
                        i2 = zzbfn.zzg(parcel, readInt);
                        break;
                    case 4:
                        bundle = zzbfn.zzs(parcel, readInt);
                        break;
                    default:
                        zzbfn.zzb(parcel, readInt);
                        break;
                }
            }
            i = zzbfn.zzg(parcel, readInt);
        }
        zzbfn.zzaf(parcel, zzd);
        DataHolder dataHolder = new DataHolder(i, strArr, cursorWindowArr, i2, bundle);
        dataHolder.zzajz();
        return dataHolder;
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new DataHolder[i];
    }
}
