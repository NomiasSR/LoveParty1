package com.google.android.gms.auth.api.signin;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.internal.view.SupportMenu;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.internal.zzbfn;
import java.util.List;

public final class zzb implements Creator<GoogleSignInAccount> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int zzd = zzbfn.zzd(parcel);
        String str = null;
        String str2 = str;
        String str3 = str2;
        String str4 = str3;
        Uri uri = str4;
        String str5 = uri;
        String str6 = str5;
        List list = str6;
        String str7 = list;
        String str8 = str7;
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
                    str2 = zzbfn.zzq(parcel2, readInt);
                    break;
                case 4:
                    str3 = zzbfn.zzq(parcel2, readInt);
                    break;
                case 5:
                    str4 = zzbfn.zzq(parcel2, readInt);
                    break;
                case 6:
                    uri = (Uri) zzbfn.zza(parcel2, readInt, Uri.CREATOR);
                    break;
                case 7:
                    str5 = zzbfn.zzq(parcel2, readInt);
                    break;
                case 8:
                    j = zzbfn.zzi(parcel2, readInt);
                    break;
                case 9:
                    str6 = zzbfn.zzq(parcel2, readInt);
                    break;
                case 10:
                    list = zzbfn.zzc(parcel2, readInt, Scope.CREATOR);
                    break;
                case 11:
                    str7 = zzbfn.zzq(parcel2, readInt);
                    break;
                case 12:
                    str8 = zzbfn.zzq(parcel2, readInt);
                    break;
                default:
                    zzbfn.zzb(parcel2, readInt);
                    break;
            }
        }
        zzbfn.zzaf(parcel2, zzd);
        return new GoogleSignInAccount(i, str, str2, str3, str4, uri, str5, j, str6, list, str7, str8);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new GoogleSignInAccount[i];
    }
}
