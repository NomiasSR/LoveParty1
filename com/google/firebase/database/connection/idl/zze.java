package com.google.firebase.database.connection.idl;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.internal.view.SupportMenu;
import com.google.android.gms.internal.zzbfn;
import java.util.List;

public final class zze implements Creator<zzc> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int zzd = zzbfn.zzd(parcel);
        int i = 0;
        boolean z = i;
        zzi com_google_firebase_database_connection_idl_zzi = null;
        List list = com_google_firebase_database_connection_idl_zzi;
        String str = list;
        String str2 = str;
        String str3 = str2;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            switch (SupportMenu.USER_MASK & readInt) {
                case 2:
                    com_google_firebase_database_connection_idl_zzi = (zzi) zzbfn.zza(parcel, readInt, zzi.CREATOR);
                    break;
                case 3:
                    i = zzbfn.zzg(parcel, readInt);
                    break;
                case 4:
                    list = zzbfn.zzac(parcel, readInt);
                    break;
                case 5:
                    z = zzbfn.zzc(parcel, readInt);
                    break;
                case 6:
                    str = zzbfn.zzq(parcel, readInt);
                    break;
                case 7:
                    str2 = zzbfn.zzq(parcel, readInt);
                    break;
                case 8:
                    str3 = zzbfn.zzq(parcel, readInt);
                    break;
                default:
                    zzbfn.zzb(parcel, readInt);
                    break;
            }
        }
        zzbfn.zzaf(parcel, zzd);
        return new zzc(com_google_firebase_database_connection_idl_zzi, i, list, z, str, str2, str3);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzc[i];
    }
}
