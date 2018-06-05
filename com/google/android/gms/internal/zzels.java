package com.google.android.gms.internal;

import java.util.Random;

public final class zzels {
    private static final Random zznfd = new Random();
    private static long zznfe;
    private static final int[] zznff = new int[12];

    public static synchronized String zzbz(long j) {
        String stringBuilder;
        synchronized (zzels.class) {
            int i = 0;
            int i2 = j == zznfe ? 1 : 0;
            zznfe = j;
            char[] cArr = new char[8];
            StringBuilder stringBuilder2 = new StringBuilder(20);
            for (int i3 = 7; i3 >= 0; i3--) {
                cArr[i3] = "-0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ_abcdefghijklmnopqrstuvwxyz".charAt((int) (j % 64));
                j /= 64;
            }
            stringBuilder2.append(cArr);
            if (i2 == 0) {
                for (int i4 = 0; i4 < 12; i4++) {
                    zznff[i4] = zznfd.nextInt(64);
                }
            } else {
                zzcbh();
            }
            while (i < 12) {
                stringBuilder2.append("-0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ_abcdefghijklmnopqrstuvwxyz".charAt(zznff[i]));
                i++;
            }
            stringBuilder = stringBuilder2.toString();
        }
        return stringBuilder;
    }

    private static void zzcbh() {
        int i = 11;
        while (i >= 0) {
            if (zznff[i] != 63) {
                zznff[i] = zznff[i] + 1;
                return;
            } else {
                zznff[i] = 0;
                i--;
            }
        }
    }
}
