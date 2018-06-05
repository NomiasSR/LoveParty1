package com.google.android.gms.common;

import android.util.Log;
import com.google.android.gms.common.internal.zzat;
import com.google.android.gms.common.internal.zzau;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.common.util.zzl;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.zzn;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

abstract class zzh extends zzau {
    private int zzflb;

    protected zzh(byte[] bArr) {
        if (bArr.length != 25) {
            int length = bArr.length;
            boolean z = false;
            String zza = zzl.zza(bArr, 0, bArr.length, false);
            StringBuilder stringBuilder = new StringBuilder(51 + String.valueOf(zza).length());
            stringBuilder.append("Cert hash data has incorrect length (");
            stringBuilder.append(length);
            stringBuilder.append("):\n");
            stringBuilder.append(zza);
            Log.wtf("GoogleCertificates", stringBuilder.toString(), new Exception());
            bArr = Arrays.copyOfRange(bArr, 0, 25);
            if (bArr.length == 25) {
                z = true;
            }
            int length2 = bArr.length;
            StringBuilder stringBuilder2 = new StringBuilder(55);
            stringBuilder2.append("cert hash data has incorrect length. length=");
            stringBuilder2.append(length2);
            zzbq.checkArgument(z, stringBuilder2.toString());
        }
        this.zzflb = Arrays.hashCode(bArr);
    }

    protected static byte[] zzfx(String str) {
        try {
            return str.getBytes("ISO-8859-1");
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError(e);
        }
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof zzat)) {
            return false;
        }
        try {
            zzat com_google_android_gms_common_internal_zzat = (zzat) obj;
            if (com_google_android_gms_common_internal_zzat.zzagb() != hashCode()) {
                return false;
            }
            IObjectWrapper zzaga = com_google_android_gms_common_internal_zzat.zzaga();
            if (zzaga == null) {
                return false;
            }
            return Arrays.equals(getBytes(), (byte[]) zzn.zzx(zzaga));
        } catch (Throwable e) {
            Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e);
            return false;
        }
    }

    abstract byte[] getBytes();

    public int hashCode() {
        return this.zzflb;
    }

    public final IObjectWrapper zzaga() {
        return zzn.zzz(getBytes());
    }

    public final int zzagb() {
        return hashCode();
    }
}
