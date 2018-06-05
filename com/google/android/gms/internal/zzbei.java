package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.internal.view.SupportMenu;

public final class zzbei implements Creator<zzbeh> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int zzd = zzbfn.zzd(parcel);
        zzbew com_google_android_gms_internal_zzbew = null;
        byte[] bArr = com_google_android_gms_internal_zzbew;
        int[] iArr = bArr;
        String[] strArr = iArr;
        int[] iArr2 = strArr;
        byte[][] bArr2 = iArr2;
        zzctx[] com_google_android_gms_internal_zzctxArr = bArr2;
        boolean z = true;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            switch (SupportMenu.USER_MASK & readInt) {
                case 2:
                    com_google_android_gms_internal_zzbew = (zzbew) zzbfn.zza(parcel, readInt, zzbew.CREATOR);
                    break;
                case 3:
                    bArr = zzbfn.zzt(parcel, readInt);
                    break;
                case 4:
                    iArr = zzbfn.zzw(parcel, readInt);
                    break;
                case 5:
                    strArr = zzbfn.zzaa(parcel, readInt);
                    break;
                case 6:
                    iArr2 = zzbfn.zzw(parcel, readInt);
                    break;
                case 7:
                    bArr2 = zzbfn.zzu(parcel, readInt);
                    break;
                case 8:
                    z = zzbfn.zzc(parcel, readInt);
                    break;
                case 9:
                    com_google_android_gms_internal_zzctxArr = (zzctx[]) zzbfn.zzb(parcel, readInt, zzctx.CREATOR);
                    break;
                default:
                    zzbfn.zzb(parcel, readInt);
                    break;
            }
        }
        zzbfn.zzaf(parcel, zzd);
        return new zzbeh(com_google_android_gms_internal_zzbew, bArr, iArr, strArr, iArr2, bArr2, z, com_google_android_gms_internal_zzctxArr);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzbeh[i];
    }
}
