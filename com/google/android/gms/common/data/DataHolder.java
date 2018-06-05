package com.google.android.gms.common.data;

import android.content.ContentValues;
import android.database.CharArrayBuffer;
import android.database.CursorIndexOutOfBoundsException;
import android.database.CursorWindow;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.common.internal.zzc;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

@KeepName
public final class DataHolder extends zzbfm implements Closeable {
    public static final Creator<DataHolder> CREATOR = new zzf();
    private static final zza zzfwi = new zze(new String[0], null);
    private boolean mClosed;
    private final int zzcd;
    private int zzeck;
    private final String[] zzfwb;
    private Bundle zzfwc;
    private final CursorWindow[] zzfwd;
    private final Bundle zzfwe;
    private int[] zzfwf;
    int zzfwg;
    private boolean zzfwh;

    public static class zza {
        private final String[] zzfwb;
        private final ArrayList<HashMap<String, Object>> zzfwj;
        private final String zzfwk;
        private final HashMap<Object, Integer> zzfwl;
        private boolean zzfwm;
        private String zzfwn;

        private zza(String[] strArr, String str) {
            this.zzfwb = (String[]) zzbq.checkNotNull(strArr);
            this.zzfwj = new ArrayList();
            this.zzfwk = str;
            this.zzfwl = new HashMap();
            this.zzfwm = false;
            this.zzfwn = null;
        }

        public zza zza(ContentValues contentValues) {
            zzc.zzv(contentValues);
            HashMap hashMap = new HashMap(contentValues.size());
            for (Entry entry : contentValues.valueSet()) {
                hashMap.put((String) entry.getKey(), entry.getValue());
            }
            return zza(hashMap);
        }

        public zza zza(HashMap<String, Object> hashMap) {
            int intValue;
            zzc.zzv(hashMap);
            if (this.zzfwk != null) {
                Object obj = hashMap.get(this.zzfwk);
                if (obj != null) {
                    Integer num = (Integer) this.zzfwl.get(obj);
                    if (num == null) {
                        this.zzfwl.put(obj, Integer.valueOf(this.zzfwj.size()));
                    } else {
                        intValue = num.intValue();
                        if (intValue != -1) {
                            this.zzfwj.add(hashMap);
                        } else {
                            this.zzfwj.remove(intValue);
                            this.zzfwj.add(intValue, hashMap);
                        }
                        this.zzfwm = false;
                        return this;
                    }
                }
            }
            intValue = -1;
            if (intValue != -1) {
                this.zzfwj.remove(intValue);
                this.zzfwj.add(intValue, hashMap);
            } else {
                this.zzfwj.add(hashMap);
            }
            this.zzfwm = false;
            return this;
        }

        public final DataHolder zzcb(int i) {
            return new DataHolder(this);
        }
    }

    public static class zzb extends RuntimeException {
        public zzb(String str) {
            super(str);
        }
    }

    DataHolder(int i, String[] strArr, CursorWindow[] cursorWindowArr, int i2, Bundle bundle) {
        this.mClosed = false;
        this.zzfwh = true;
        this.zzeck = i;
        this.zzfwb = strArr;
        this.zzfwd = cursorWindowArr;
        this.zzcd = i2;
        this.zzfwe = bundle;
    }

    private DataHolder(zza com_google_android_gms_common_data_DataHolder_zza, int i, Bundle bundle) {
        this(com_google_android_gms_common_data_DataHolder_zza.zzfwb, zza(com_google_android_gms_common_data_DataHolder_zza, -1), i, null);
    }

    private DataHolder(String[] strArr, CursorWindow[] cursorWindowArr, int i, Bundle bundle) {
        this.mClosed = false;
        this.zzfwh = true;
        this.zzeck = 1;
        this.zzfwb = (String[]) zzbq.checkNotNull(strArr);
        this.zzfwd = (CursorWindow[]) zzbq.checkNotNull(cursorWindowArr);
        this.zzcd = i;
        this.zzfwe = bundle;
        zzajz();
    }

    private static CursorWindow[] zza(zza com_google_android_gms_common_data_DataHolder_zza, int i) {
        int i2 = 0;
        if (com_google_android_gms_common_data_DataHolder_zza.zzfwb.length == 0) {
            return new CursorWindow[0];
        }
        List zzb = com_google_android_gms_common_data_DataHolder_zza.zzfwj;
        int size = zzb.size();
        CursorWindow cursorWindow = new CursorWindow(false);
        ArrayList arrayList = new ArrayList();
        arrayList.add(cursorWindow);
        cursorWindow.setNumColumns(com_google_android_gms_common_data_DataHolder_zza.zzfwb.length);
        int i3 = 0;
        CursorWindow cursorWindow2 = cursorWindow;
        int i4 = i3;
        while (i4 < size) {
            try {
                if (!cursorWindow2.allocRow()) {
                    StringBuilder stringBuilder = new StringBuilder(72);
                    stringBuilder.append("Allocating additional cursor window for large data set (row ");
                    stringBuilder.append(i4);
                    stringBuilder.append(")");
                    Log.d("DataHolder", stringBuilder.toString());
                    cursorWindow2 = new CursorWindow(false);
                    cursorWindow2.setStartPosition(i4);
                    cursorWindow2.setNumColumns(com_google_android_gms_common_data_DataHolder_zza.zzfwb.length);
                    arrayList.add(cursorWindow2);
                    if (!cursorWindow2.allocRow()) {
                        Log.e("DataHolder", "Unable to allocate row to hold data.");
                        arrayList.remove(cursorWindow2);
                        return (CursorWindow[]) arrayList.toArray(new CursorWindow[arrayList.size()]);
                    }
                }
                Map map = (Map) zzb.get(i4);
                boolean z = true;
                for (int i5 = 0; i5 < com_google_android_gms_common_data_DataHolder_zza.zzfwb.length && z; i5++) {
                    String str = com_google_android_gms_common_data_DataHolder_zza.zzfwb[i5];
                    Object obj = map.get(str);
                    if (obj == null) {
                        z = cursorWindow2.putNull(i4, i5);
                    } else if (obj instanceof String) {
                        z = cursorWindow2.putString((String) obj, i4, i5);
                    } else {
                        long longValue;
                        if (obj instanceof Long) {
                            longValue = ((Long) obj).longValue();
                        } else if (obj instanceof Integer) {
                            z = cursorWindow2.putLong((long) ((Integer) obj).intValue(), i4, i5);
                        } else if (obj instanceof Boolean) {
                            longValue = ((Boolean) obj).booleanValue() ? 1 : 0;
                        } else if (obj instanceof byte[]) {
                            z = cursorWindow2.putBlob((byte[]) obj, i4, i5);
                        } else if (obj instanceof Double) {
                            z = cursorWindow2.putDouble(((Double) obj).doubleValue(), i4, i5);
                        } else if (obj instanceof Float) {
                            z = cursorWindow2.putDouble((double) ((Float) obj).floatValue(), i4, i5);
                        } else {
                            String valueOf = String.valueOf(obj);
                            StringBuilder stringBuilder2 = new StringBuilder((32 + String.valueOf(str).length()) + String.valueOf(valueOf).length());
                            stringBuilder2.append("Unsupported object for column ");
                            stringBuilder2.append(str);
                            stringBuilder2.append(": ");
                            stringBuilder2.append(valueOf);
                            throw new IllegalArgumentException(stringBuilder2.toString());
                        }
                        z = cursorWindow2.putLong(longValue, i4, i5);
                    }
                }
                if (z) {
                    i3 = 0;
                } else if (i3 != 0) {
                    throw new zzb("Could not add the value to a new CursorWindow. The size of value may be larger than what a CursorWindow can handle.");
                } else {
                    StringBuilder stringBuilder3 = new StringBuilder(74);
                    stringBuilder3.append("Couldn't populate window data for row ");
                    stringBuilder3.append(i4);
                    stringBuilder3.append(" - allocating new window.");
                    Log.d("DataHolder", stringBuilder3.toString());
                    cursorWindow2.freeLastRow();
                    cursorWindow2 = new CursorWindow(false);
                    cursorWindow2.setStartPosition(i4);
                    cursorWindow2.setNumColumns(com_google_android_gms_common_data_DataHolder_zza.zzfwb.length);
                    arrayList.add(cursorWindow2);
                    i4--;
                    i3 = 1;
                }
                i4++;
            } catch (RuntimeException e) {
                i = arrayList.size();
                while (i2 < i) {
                    ((CursorWindow) arrayList.get(i2)).close();
                    i2++;
                }
                throw e;
            }
        }
        return (CursorWindow[]) arrayList.toArray(new CursorWindow[arrayList.size()]);
    }

    public static zza zzb(String[] strArr) {
        return new zza(strArr);
    }

    public static DataHolder zzca(int i) {
        return new DataHolder(zzfwi, i, null);
    }

    private final void zzh(String str, int i) {
        if (this.zzfwc != null) {
            if (this.zzfwc.containsKey(str)) {
                if (isClosed()) {
                    throw new IllegalArgumentException("Buffer is closed.");
                }
                if (i >= 0) {
                    if (i < this.zzfwg) {
                        return;
                    }
                }
                throw new CursorIndexOutOfBoundsException(i, this.zzfwg);
            }
        }
        String str2 = "No such column: ";
        str = String.valueOf(str);
        throw new IllegalArgumentException(str.length() != 0 ? str2.concat(str) : new String(str2));
    }

    public final void close() {
        synchronized (this) {
            if (!this.mClosed) {
                this.mClosed = true;
                for (CursorWindow close : this.zzfwd) {
                    close.close();
                }
            }
        }
    }

    protected final void finalize() throws Throwable {
        try {
            if (this.zzfwh && this.zzfwd.length > 0 && !isClosed()) {
                close();
                String obj = toString();
                StringBuilder stringBuilder = new StringBuilder(178 + String.valueOf(obj).length());
                stringBuilder.append("Internal data leak within a DataBuffer object detected!  Be sure to explicitly call release() on all DataBuffer extending objects when you are done with them. (internal object: ");
                stringBuilder.append(obj);
                stringBuilder.append(")");
                Log.e("DataBuffer", stringBuilder.toString());
            }
            super.finalize();
        } catch (Throwable th) {
            super.finalize();
        }
    }

    public final int getCount() {
        return this.zzfwg;
    }

    public final int getStatusCode() {
        return this.zzcd;
    }

    public final boolean isClosed() {
        boolean z;
        synchronized (this) {
            z = this.mClosed;
        }
        return z;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int zze = zzbfp.zze(parcel);
        zzbfp.zza(parcel, 1, this.zzfwb, false);
        zzbfp.zza(parcel, 2, this.zzfwd, i, false);
        zzbfp.zzc(parcel, 3, this.zzcd);
        zzbfp.zza(parcel, 4, this.zzfwe, false);
        zzbfp.zzc(parcel, 1000, this.zzeck);
        zzbfp.zzai(parcel, zze);
        if ((i & 1) != 0) {
            close();
        }
    }

    public final void zza(String str, int i, int i2, CharArrayBuffer charArrayBuffer) {
        zzh(str, i);
        this.zzfwd[i2].copyStringToBuffer(i, this.zzfwc.getInt(str), charArrayBuffer);
    }

    public final Bundle zzagk() {
        return this.zzfwe;
    }

    public final void zzajz() {
        int i;
        this.zzfwc = new Bundle();
        int i2 = 0;
        for (i = 0; i < this.zzfwb.length; i++) {
            this.zzfwc.putInt(this.zzfwb[i], i);
        }
        this.zzfwf = new int[this.zzfwd.length];
        i = 0;
        while (i2 < this.zzfwd.length) {
            this.zzfwf[i2] = i;
            i += this.zzfwd[i2].getNumRows() - (i - this.zzfwd[i2].getStartPosition());
            i2++;
        }
        this.zzfwg = i;
    }

    public final long zzb(String str, int i, int i2) {
        zzh(str, i);
        return this.zzfwd[i2].getLong(i, this.zzfwc.getInt(str));
    }

    public final int zzbz(int i) {
        int i2 = 0;
        boolean z = i >= 0 && i < this.zzfwg;
        zzbq.checkState(z);
        while (i2 < this.zzfwf.length) {
            if (i < this.zzfwf[i2]) {
                i2--;
                break;
            }
            i2++;
        }
        return i2 == this.zzfwf.length ? i2 - 1 : i2;
    }

    public final int zzc(String str, int i, int i2) {
        zzh(str, i);
        return this.zzfwd[i2].getInt(i, this.zzfwc.getInt(str));
    }

    public final String zzd(String str, int i, int i2) {
        zzh(str, i);
        return this.zzfwd[i2].getString(i, this.zzfwc.getInt(str));
    }

    public final boolean zze(String str, int i, int i2) {
        zzh(str, i);
        return Long.valueOf(this.zzfwd[i2].getLong(i, this.zzfwc.getInt(str))).longValue() == 1;
    }

    public final float zzf(String str, int i, int i2) {
        zzh(str, i);
        return this.zzfwd[i2].getFloat(i, this.zzfwc.getInt(str));
    }

    public final byte[] zzg(String str, int i, int i2) {
        zzh(str, i);
        return this.zzfwd[i2].getBlob(i, this.zzfwc.getInt(str));
    }

    public final boolean zzga(String str) {
        return this.zzfwc.containsKey(str);
    }

    public final boolean zzh(String str, int i, int i2) {
        zzh(str, i);
        return this.zzfwd[i2].isNull(i, this.zzfwc.getInt(str));
    }
}
