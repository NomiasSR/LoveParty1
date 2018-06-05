package com.google.android.gms.common.util;

import com.google.android.gms.common.internal.zzbg;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public final class zza {
    public static <T> ArrayList<T> zza(T[] tArr) {
        ArrayList<T> arrayList = new ArrayList(r0);
        for (Object add : tArr) {
            arrayList.add(add);
        }
        return arrayList;
    }

    public static void zza(StringBuilder stringBuilder, double[] dArr) {
        int length = dArr.length;
        for (int i = 0; i < length; i++) {
            if (i != 0) {
                stringBuilder.append(",");
            }
            stringBuilder.append(Double.toString(dArr[i]));
        }
    }

    public static void zza(StringBuilder stringBuilder, float[] fArr) {
        int length = fArr.length;
        for (int i = 0; i < length; i++) {
            if (i != 0) {
                stringBuilder.append(",");
            }
            stringBuilder.append(Float.toString(fArr[i]));
        }
    }

    public static void zza(StringBuilder stringBuilder, long[] jArr) {
        int length = jArr.length;
        for (int i = 0; i < length; i++) {
            if (i != 0) {
                stringBuilder.append(",");
            }
            stringBuilder.append(Long.toString(jArr[i]));
        }
    }

    public static <T> void zza(StringBuilder stringBuilder, T[] tArr) {
        int length = tArr.length;
        for (int i = 0; i < length; i++) {
            if (i != 0) {
                stringBuilder.append(",");
            }
            stringBuilder.append(tArr[i].toString());
        }
    }

    public static void zza(StringBuilder stringBuilder, String[] strArr) {
        int length = strArr.length;
        for (int i = 0; i < length; i++) {
            if (i != 0) {
                stringBuilder.append(",");
            }
            stringBuilder.append("\"");
            stringBuilder.append(strArr[i]);
            stringBuilder.append("\"");
        }
    }

    public static void zza(StringBuilder stringBuilder, boolean[] zArr) {
        int length = zArr.length;
        for (int i = 0; i < length; i++) {
            if (i != 0) {
                stringBuilder.append(",");
            }
            stringBuilder.append(Boolean.toString(zArr[i]));
        }
    }

    public static byte[] zza(byte[]... bArr) {
        if (bArr.length == 0) {
            return new byte[0];
        }
        int i = 0;
        int i2 = i;
        while (i < bArr.length) {
            i2 += bArr[i].length;
            i++;
        }
        Object copyOf = Arrays.copyOf(bArr[0], i2);
        i2 = bArr[0].length;
        for (int i3 = 1; i3 < bArr.length; i3++) {
            Object obj = bArr[i3];
            System.arraycopy(obj, 0, copyOf, i2, obj.length);
            i2 += obj.length;
        }
        return copyOf;
    }

    public static <T> T[] zza(T[] tArr, T... tArr2) {
        if (tArr == null) {
            return null;
        }
        if (tArr2.length == 0) {
            return Arrays.copyOf(tArr, tArr.length);
        }
        int i;
        T[] tArr3 = (Object[]) Array.newInstance(tArr2.getClass().getComponentType(), tArr.length);
        int length;
        if (tArr2.length == 1) {
            length = tArr.length;
            int i2 = 0;
            i = i2;
            while (i2 < length) {
                Object obj = tArr[i2];
                if (!zzbg.equal(tArr2[0], obj)) {
                    int i3 = i + 1;
                    tArr3[i] = obj;
                    i = i3;
                }
                i2++;
            }
        } else {
            length = tArr.length;
            i = 0;
            int i4 = i;
            while (i < length) {
                Object obj2 = tArr[i];
                int length2 = tArr2.length;
                int i5 = 0;
                while (i5 < length2) {
                    if (zzbg.equal(tArr2[i5], obj2)) {
                        break;
                    }
                    i5++;
                }
                i5 = -1;
                if ((i5 >= 0 ? 1 : 0) == 0) {
                    length2 = i4 + 1;
                    tArr3[i4] = obj2;
                    i4 = length2;
                }
                i++;
            }
            i = i4;
        }
        if (tArr3 == null) {
            return null;
        }
        if (i != tArr3.length) {
            tArr3 = Arrays.copyOf(tArr3, i);
        }
        return tArr3;
    }

    public static Integer[] zzb(int[] iArr) {
        if (iArr == null) {
            return null;
        }
        int length = iArr.length;
        Integer[] numArr = new Integer[length];
        for (int i = 0; i < length; i++) {
            numArr[i] = Integer.valueOf(iArr[i]);
        }
        return numArr;
    }
}
