package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.internal.view.SupportMenu;
import com.google.android.gms.internal.zzbfn;

public final class zzf implements Creator<zze> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int zzd = zzbfn.zzd(parcel);
        boolean z = true;
        long j = 50;
        float f = 0.0f;
        long j2 = Long.MAX_VALUE;
        int i = ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            switch (SupportMenu.USER_MASK & readInt) {
                case 1:
                    z = zzbfn.zzc(parcel2, readInt);
                    break;
                case 2:
                    j = zzbfn.zzi(parcel2, readInt);
                    break;
                case 3:
                    f = zzbfn.zzl(parcel2, readInt);
                    break;
                case 4:
                    j2 = zzbfn.zzi(parcel2, readInt);
                    break;
                case 5:
                    i = zzbfn.zzg(parcel2, readInt);
                    break;
                default:
                    zzbfn.zzb(parcel2, readInt);
                    break;
            }
        }
        zzbfn.zzaf(parcel2, zzd);
        return new zze(z, j, f, j2, i);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zze[i];
    }
}
