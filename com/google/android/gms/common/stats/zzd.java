package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.internal.view.SupportMenu;
import com.google.android.gms.internal.zzbfn;
import java.util.List;

public final class zzd implements Creator<WakeLockEvent> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int zzd = zzbfn.zzd(parcel);
        long j = 0;
        long j2 = j;
        long j3 = j2;
        int i = 0;
        int i2 = i;
        int i3 = i2;
        int i4 = i3;
        String str = null;
        List list = str;
        String str2 = list;
        String str3 = str2;
        String str4 = str3;
        String str5 = str4;
        float f = 0.0f;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            switch (SupportMenu.USER_MASK & readInt) {
                case 1:
                    i = zzbfn.zzg(parcel2, readInt);
                    break;
                case 2:
                    j = zzbfn.zzi(parcel2, readInt);
                    break;
                case 4:
                    str = zzbfn.zzq(parcel2, readInt);
                    break;
                case 5:
                    i3 = zzbfn.zzg(parcel2, readInt);
                    break;
                case 6:
                    list = zzbfn.zzac(parcel2, readInt);
                    break;
                case 8:
                    j2 = zzbfn.zzi(parcel2, readInt);
                    break;
                case 10:
                    str3 = zzbfn.zzq(parcel2, readInt);
                    break;
                case 11:
                    i2 = zzbfn.zzg(parcel2, readInt);
                    break;
                case 12:
                    str2 = zzbfn.zzq(parcel2, readInt);
                    break;
                case 13:
                    str4 = zzbfn.zzq(parcel2, readInt);
                    break;
                case 14:
                    i4 = zzbfn.zzg(parcel2, readInt);
                    break;
                case 15:
                    f = zzbfn.zzl(parcel2, readInt);
                    break;
                case 16:
                    j3 = zzbfn.zzi(parcel2, readInt);
                    break;
                case 17:
                    str5 = zzbfn.zzq(parcel2, readInt);
                    break;
                default:
                    zzbfn.zzb(parcel2, readInt);
                    break;
            }
        }
        zzbfn.zzaf(parcel2, zzd);
        return new WakeLockEvent(i, j, i2, str, i3, list, str2, j2, i4, str3, str4, f, j3, str5);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new WakeLockEvent[i];
    }
}
