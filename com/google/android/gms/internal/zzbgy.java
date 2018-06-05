package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.internal.view.SupportMenu;
import android.util.SparseArray;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.common.util.zza;
import com.google.android.gms.common.util.zzb;
import com.google.android.gms.common.util.zzo;
import com.google.android.gms.common.util.zzp;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class zzbgy extends zzbgq {
    public static final Creator<zzbgy> CREATOR = new zzbgz();
    private final String mClassName;
    private final int zzeck;
    private final zzbgt zzgcm;
    private final Parcel zzgct;
    private final int zzgcu = 2;
    private int zzgcv;
    private int zzgcw;

    zzbgy(int i, Parcel parcel, zzbgt com_google_android_gms_internal_zzbgt) {
        this.zzeck = i;
        this.zzgct = (Parcel) zzbq.checkNotNull(parcel);
        this.zzgcm = com_google_android_gms_internal_zzbgt;
        this.mClassName = this.zzgcm == null ? null : this.zzgcm.zzalz();
        this.zzgcv = 2;
    }

    private static void zza(StringBuilder stringBuilder, int i, Object obj) {
        switch (i) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                stringBuilder.append(obj);
                return;
            case 7:
                stringBuilder.append("\"");
                stringBuilder.append(zzo.zzgr(obj.toString()));
                stringBuilder.append("\"");
                return;
            case 8:
                stringBuilder.append("\"");
                stringBuilder.append(zzb.zzk((byte[]) obj));
                stringBuilder.append("\"");
                return;
            case 9:
                stringBuilder.append("\"");
                stringBuilder.append(zzb.zzl((byte[]) obj));
                stringBuilder.append("\"");
                return;
            case 10:
                zzp.zza(stringBuilder, (HashMap) obj);
                return;
            case 11:
                throw new IllegalArgumentException("Method does not accept concrete type.");
            default:
                StringBuilder stringBuilder2 = new StringBuilder(26);
                stringBuilder2.append("Unknown type = ");
                stringBuilder2.append(i);
                throw new IllegalArgumentException(stringBuilder2.toString());
        }
    }

    private final void zza(StringBuilder stringBuilder, zzbgo<?, ?> com_google_android_gms_internal_zzbgo___, Parcel parcel, int i) {
        int i2 = 0;
        if (com_google_android_gms_internal_zzbgo___.zzgch) {
            stringBuilder.append("[");
            Object[] objArr = null;
            int zza;
            int readInt;
            switch (com_google_android_gms_internal_zzbgo___.zzgcg) {
                case 0:
                    int[] zzw = zzbfn.zzw(parcel, i);
                    int length = zzw.length;
                    while (i2 < length) {
                        if (i2 != 0) {
                            stringBuilder.append(",");
                        }
                        stringBuilder.append(Integer.toString(zzw[i2]));
                        i2++;
                    }
                    break;
                case 1:
                    zza = zzbfn.zza(parcel, i);
                    i = parcel.dataPosition();
                    if (zza != 0) {
                        readInt = parcel.readInt();
                        objArr = new BigInteger[readInt];
                        while (i2 < readInt) {
                            objArr[i2] = new BigInteger(parcel.createByteArray());
                            i2++;
                        }
                        parcel.setDataPosition(i + zza);
                    }
                    zza.zza(stringBuilder, objArr);
                    break;
                case 2:
                    zza.zza(stringBuilder, zzbfn.zzx(parcel, i));
                    break;
                case 3:
                    zza.zza(stringBuilder, zzbfn.zzy(parcel, i));
                    break;
                case 4:
                    double[] createDoubleArray;
                    zza = zzbfn.zza(parcel, i);
                    i = parcel.dataPosition();
                    if (zza != 0) {
                        createDoubleArray = parcel.createDoubleArray();
                        parcel.setDataPosition(i + zza);
                    }
                    zza.zza(stringBuilder, createDoubleArray);
                    break;
                case 5:
                    zza.zza(stringBuilder, zzbfn.zzz(parcel, i));
                    break;
                case 6:
                    zza.zza(stringBuilder, zzbfn.zzv(parcel, i));
                    break;
                case 7:
                    zza.zza(stringBuilder, zzbfn.zzaa(parcel, i));
                    break;
                case 8:
                case 9:
                case 10:
                    throw new UnsupportedOperationException("List of type BASE64, BASE64_URL_SAFE, or STRING_MAP is not supported");
                case 11:
                    Parcel[] zzae = zzbfn.zzae(parcel, i);
                    i = zzae.length;
                    for (readInt = 0; readInt < i; readInt++) {
                        if (readInt > 0) {
                            stringBuilder.append(",");
                        }
                        zzae[readInt].setDataPosition(0);
                        zza(stringBuilder, com_google_android_gms_internal_zzbgo___.zzalx(), zzae[readInt]);
                    }
                    break;
                default:
                    throw new IllegalStateException("Unknown field type out.");
            }
            stringBuilder.append("]");
            return;
        }
        byte[] zzt;
        switch (com_google_android_gms_internal_zzbgo___.zzgcg) {
            case 0:
                stringBuilder.append(zzbfn.zzg(parcel, i));
                return;
            case 1:
                stringBuilder.append(zzbfn.zzk(parcel, i));
                return;
            case 2:
                stringBuilder.append(zzbfn.zzi(parcel, i));
                return;
            case 3:
                stringBuilder.append(zzbfn.zzl(parcel, i));
                return;
            case 4:
                stringBuilder.append(zzbfn.zzn(parcel, i));
                return;
            case 5:
                stringBuilder.append(zzbfn.zzp(parcel, i));
                return;
            case 6:
                stringBuilder.append(zzbfn.zzc(parcel, i));
                return;
            case 7:
                String zzq = zzbfn.zzq(parcel, i);
                stringBuilder.append("\"");
                stringBuilder.append(zzo.zzgr(zzq));
                stringBuilder.append("\"");
                return;
            case 8:
                zzt = zzbfn.zzt(parcel, i);
                stringBuilder.append("\"");
                stringBuilder.append(zzb.zzk(zzt));
                stringBuilder.append("\"");
                return;
            case 9:
                zzt = zzbfn.zzt(parcel, i);
                stringBuilder.append("\"");
                stringBuilder.append(zzb.zzl(zzt));
                stringBuilder.append("\"");
                return;
            case 10:
                Bundle zzs = zzbfn.zzs(parcel, i);
                Set<String> keySet = zzs.keySet();
                keySet.size();
                stringBuilder.append("{");
                i = 1;
                for (String str : keySet) {
                    if (i == 0) {
                        stringBuilder.append(",");
                    }
                    stringBuilder.append("\"");
                    stringBuilder.append(str);
                    stringBuilder.append("\"");
                    stringBuilder.append(":");
                    stringBuilder.append("\"");
                    stringBuilder.append(zzo.zzgr(zzs.getString(str)));
                    stringBuilder.append("\"");
                    i = 0;
                }
                stringBuilder.append("}");
                return;
            case 11:
                parcel = zzbfn.zzad(parcel, i);
                parcel.setDataPosition(0);
                zza(stringBuilder, com_google_android_gms_internal_zzbgo___.zzalx(), parcel);
                return;
            default:
                throw new IllegalStateException("Unknown field type out");
        }
    }

    private final void zza(StringBuilder stringBuilder, Map<String, zzbgo<?, ?>> map, Parcel parcel) {
        SparseArray sparseArray = new SparseArray();
        for (Entry entry : map.entrySet()) {
            sparseArray.put(((zzbgo) entry.getValue()).zzgcj, entry);
        }
        stringBuilder.append('{');
        int zzd = zzbfn.zzd(parcel);
        Object obj = null;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            Entry entry2 = (Entry) sparseArray.get(SupportMenu.USER_MASK & readInt);
            if (entry2 != null) {
                if (obj != null) {
                    stringBuilder.append(",");
                }
                String str = (String) entry2.getKey();
                zzbgo com_google_android_gms_internal_zzbgo = (zzbgo) entry2.getValue();
                stringBuilder.append("\"");
                stringBuilder.append(str);
                stringBuilder.append("\":");
                if (com_google_android_gms_internal_zzbgo.zzalw()) {
                    switch (com_google_android_gms_internal_zzbgo.zzgcg) {
                        case 0:
                            obj = Integer.valueOf(zzbfn.zzg(parcel, readInt));
                            break;
                        case 1:
                            obj = zzbfn.zzk(parcel, readInt);
                            break;
                        case 2:
                            obj = Long.valueOf(zzbfn.zzi(parcel, readInt));
                            break;
                        case 3:
                            obj = Float.valueOf(zzbfn.zzl(parcel, readInt));
                            break;
                        case 4:
                            obj = Double.valueOf(zzbfn.zzn(parcel, readInt));
                            break;
                        case 5:
                            obj = zzbfn.zzp(parcel, readInt);
                            break;
                        case 6:
                            obj = Boolean.valueOf(zzbfn.zzc(parcel, readInt));
                            break;
                        case 7:
                            obj = zzbfn.zzq(parcel, readInt);
                            break;
                        case 8:
                        case 9:
                            obj = zzbfn.zzt(parcel, readInt);
                            break;
                        case 10:
                            obj = zzl(zzbfn.zzs(parcel, readInt));
                            break;
                        case 11:
                            throw new IllegalArgumentException("Method does not accept concrete type.");
                        default:
                            zzd = com_google_android_gms_internal_zzbgo.zzgcg;
                            StringBuilder stringBuilder2 = new StringBuilder(36);
                            stringBuilder2.append("Unknown field out type = ");
                            stringBuilder2.append(zzd);
                            throw new IllegalArgumentException(stringBuilder2.toString());
                    }
                    zzb(stringBuilder, com_google_android_gms_internal_zzbgo, zzbgn.zza(com_google_android_gms_internal_zzbgo, obj));
                } else {
                    zza(stringBuilder, com_google_android_gms_internal_zzbgo, parcel, readInt);
                }
                obj = 1;
            }
        }
        if (parcel.dataPosition() != zzd) {
            StringBuilder stringBuilder3 = new StringBuilder(37);
            stringBuilder3.append("Overread allowed size end=");
            stringBuilder3.append(zzd);
            throw new zzbfo(stringBuilder3.toString(), parcel);
        }
        stringBuilder.append('}');
    }

    private Parcel zzamb() {
        switch (this.zzgcv) {
            case 0:
                this.zzgcw = zzbfp.zze(this.zzgct);
                break;
            case 1:
                break;
            default:
                break;
        }
        zzbfp.zzai(this.zzgct, this.zzgcw);
        this.zzgcv = 2;
        return this.zzgct;
    }

    private final void zzb(StringBuilder stringBuilder, zzbgo<?, ?> com_google_android_gms_internal_zzbgo___, Object obj) {
        if (com_google_android_gms_internal_zzbgo___.zzgcf) {
            ArrayList arrayList = (ArrayList) obj;
            stringBuilder.append("[");
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                if (i != 0) {
                    stringBuilder.append(",");
                }
                zza(stringBuilder, com_google_android_gms_internal_zzbgo___.zzgce, arrayList.get(i));
            }
            stringBuilder.append("]");
            return;
        }
        zza(stringBuilder, com_google_android_gms_internal_zzbgo___.zzgce, obj);
    }

    private static HashMap<String, String> zzl(Bundle bundle) {
        HashMap<String, String> hashMap = new HashMap();
        for (String str : bundle.keySet()) {
            hashMap.put(str, bundle.getString(str));
        }
        return hashMap;
    }

    public String toString() {
        zzbq.checkNotNull(this.zzgcm, "Cannot convert to JSON on client side.");
        Parcel zzamb = zzamb();
        zzamb.setDataPosition(0);
        StringBuilder stringBuilder = new StringBuilder(100);
        zza(stringBuilder, this.zzgcm.zzgq(this.mClassName), zzamb);
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        Parcelable parcelable;
        int zze = zzbfp.zze(parcel);
        zzbfp.zzc(parcel, 1, this.zzeck);
        zzbfp.zza(parcel, 2, zzamb(), false);
        switch (this.zzgcu) {
            case 0:
                parcelable = null;
                break;
            case 1:
            case 2:
                parcelable = this.zzgcm;
                break;
            default:
                i = this.zzgcu;
                StringBuilder stringBuilder = new StringBuilder(34);
                stringBuilder.append("Invalid creation type: ");
                stringBuilder.append(i);
                throw new IllegalStateException(stringBuilder.toString());
        }
        zzbfp.zza(parcel, 3, parcelable, i, false);
        zzbfp.zzai(parcel, zze);
    }

    public final Map<String, zzbgo<?, ?>> zzaav() {
        return this.zzgcm == null ? null : this.zzgcm.zzgq(this.mClassName);
    }

    public final Object zzgo(String str) {
        throw new UnsupportedOperationException("Converting to JSON does not require this method.");
    }

    public final boolean zzgp(String str) {
        throw new UnsupportedOperationException("Converting to JSON does not require this method.");
    }
}
