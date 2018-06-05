package com.google.android.gms.internal;

final class zzfis {
    private static final zzfit zzplo;

    static {
        Object obj = (zzfiq.zzczx() && zzfiq.zzczy()) ? 1 : null;
        zzplo = obj != null ? new zzfiw() : new zzfiu();
    }

    static int zza(CharSequence charSequence, byte[] bArr, int i, int i2) {
        return zzplo.zzb(charSequence, bArr, i, i2);
    }

    private static int zzaj(int i, int i2) {
        if (i <= -12) {
            if (i2 <= -65) {
                return i ^ (i2 << 8);
            }
        }
        return -1;
    }

    static int zzd(CharSequence charSequence) {
        int length = charSequence.length();
        int i = 0;
        int i2 = 0;
        while (i2 < length && charSequence.charAt(i2) < '') {
            i2++;
        }
        int i3 = length;
        while (i2 < length) {
            char charAt = charSequence.charAt(i2);
            if (charAt < 'ࠀ') {
                i3 += (127 - charAt) >>> 31;
                i2++;
            } else {
                int length2 = charSequence.length();
                while (i2 < length2) {
                    char charAt2 = charSequence.charAt(i2);
                    if (charAt2 < 'ࠀ') {
                        i += (127 - charAt2) >>> 31;
                    } else {
                        i += 2;
                        if ('?' <= charAt2 && charAt2 <= '?') {
                            if (Character.codePointAt(charSequence, i2) < 65536) {
                                throw new zzfiv(i2, length2);
                            }
                            i2++;
                        }
                    }
                    i2++;
                }
                i3 += i;
                if (i3 < length) {
                    return i3;
                }
                long j = ((long) i3) + 4294967296L;
                StringBuilder stringBuilder = new StringBuilder(54);
                stringBuilder.append("UTF-8 length does not fit in int: ");
                stringBuilder.append(j);
                throw new IllegalArgumentException(stringBuilder.toString());
            }
        }
        if (i3 < length) {
            return i3;
        }
        long j2 = ((long) i3) + 4294967296L;
        StringBuilder stringBuilder2 = new StringBuilder(54);
        stringBuilder2.append("UTF-8 length does not fit in int: ");
        stringBuilder2.append(j2);
        throw new IllegalArgumentException(stringBuilder2.toString());
    }

    private static int zzi(int i, int i2, int i3) {
        if (i <= -12 && i2 <= -65) {
            if (i3 <= -65) {
                return (i ^ (i2 << 8)) ^ (i3 << 16);
            }
        }
        return -1;
    }

    public static boolean zzk(byte[] bArr, int i, int i2) {
        return zzplo.zzb(0, bArr, i, i2) == 0;
    }

    private static int zzl(byte[] bArr, int i, int i2) {
        byte b = bArr[i - 1];
        switch (i2 - i) {
            case 0:
                return zzme(b);
            case 1:
                return zzaj(b, bArr[i]);
            case 2:
                return zzi(b, bArr[i], bArr[i + 1]);
            default:
                throw new AssertionError();
        }
    }

    private static int zzme(int i) {
        return i > -12 ? -1 : i;
    }
}
