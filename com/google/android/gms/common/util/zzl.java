package com.google.android.gms.common.util;

public final class zzl {
    public static String zza(byte[] bArr, int i, int i2, boolean z) {
        if (!(bArr == null || bArr.length == 0 || i2 <= 0)) {
            if (i2 <= bArr.length) {
                StringBuilder stringBuilder = new StringBuilder(57 * (((i2 + 16) - 1) / 16));
                int i3 = 0;
                int i4 = i3;
                int i5 = i2;
                while (i5 > 0) {
                    String str;
                    if (i3 == 0) {
                        Object[] objArr;
                        if (i2 < 65536) {
                            str = "%04X:";
                            objArr = new Object[]{Integer.valueOf(i4)};
                        } else {
                            str = "%08X:";
                            objArr = new Object[]{Integer.valueOf(i4)};
                        }
                        str = String.format(str, objArr);
                    } else {
                        if (i3 == 8) {
                            str = " -";
                        }
                        stringBuilder.append(String.format(" %02X", new Object[]{Integer.valueOf(bArr[i4] & 255)}));
                        i5--;
                        i3++;
                        if (i3 != 16 || i5 == 0) {
                            stringBuilder.append('\n');
                            i3 = 0;
                        }
                        i4++;
                    }
                    stringBuilder.append(str);
                    stringBuilder.append(String.format(" %02X", new Object[]{Integer.valueOf(bArr[i4] & 255)}));
                    i5--;
                    i3++;
                    if (i3 != 16) {
                    }
                    stringBuilder.append('\n');
                    i3 = 0;
                    i4++;
                }
                return stringBuilder.toString();
            }
        }
        return null;
    }
}
