package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.internal.view.SupportMenu;

public final class zzcud implements Creator<zzctx> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int zzd = zzbfn.zzd(parcel);
        String str = null;
        byte[] bArr = str;
        byte[][] bArr2 = bArr;
        byte[][] bArr3 = bArr2;
        byte[][] bArr4 = bArr3;
        byte[][] bArr5 = bArr4;
        int[] iArr = bArr5;
        byte[][] bArr6 = iArr;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            switch (SupportMenu.USER_MASK & readInt) {
                case 2:
                    str = zzbfn.zzq(parcel, readInt);
                    break;
                case 3:
                    bArr = zzbfn.zzt(parcel, readInt);
                    break;
                case 4:
                    bArr2 = zzbfn.zzu(parcel, readInt);
                    break;
                case 5:
                    bArr3 = zzbfn.zzu(parcel, readInt);
                    break;
                case 6:
                    bArr4 = zzbfn.zzu(parcel, readInt);
                    break;
                case 7:
                    bArr5 = zzbfn.zzu(parcel, readInt);
                    break;
                case 8:
                    iArr = zzbfn.zzw(parcel, readInt);
                    break;
                case 9:
                    bArr6 = zzbfn.zzu(parcel, readInt);
                    break;
                default:
                    zzbfn.zzb(parcel, readInt);
                    break;
            }
        }
        zzbfn.zzaf(parcel, zzd);
        return new zzctx(str, bArr, bArr2, bArr3, bArr4, bArr5, iArr, bArr6);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzctx[i];
    }
}
