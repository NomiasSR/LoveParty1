package com.google.android.gms.maps.model;

import android.content.Context;
import android.content.res.Resources.NotFoundException;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.bumptech.glide.load.Key;
import com.google.android.gms.common.util.zzn;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;
import java.io.IOException;

public final class MapStyleOptions extends zzbfm {
    public static final Creator<MapStyleOptions> CREATOR = new zzg();
    private static final String TAG = "MapStyleOptions";
    private String zzive;

    public MapStyleOptions(String str) {
        this.zzive = str;
    }

    public static MapStyleOptions loadRawResourceStyle(Context context, int i) throws NotFoundException {
        try {
            return new MapStyleOptions(new String(zzn.zza(context.getResources().openRawResource(i), true), Key.STRING_CHARSET_NAME));
        } catch (IOException e) {
            String valueOf = String.valueOf(e);
            StringBuilder stringBuilder = new StringBuilder(37 + String.valueOf(valueOf).length());
            stringBuilder.append("Failed to read resource ");
            stringBuilder.append(i);
            stringBuilder.append(": ");
            stringBuilder.append(valueOf);
            throw new NotFoundException(stringBuilder.toString());
        }
    }

    public final void writeToParcel(Parcel parcel, int i) {
        i = zzbfp.zze(parcel);
        zzbfp.zza(parcel, 2, this.zzive, false);
        zzbfp.zzai(parcel, i);
    }
}
