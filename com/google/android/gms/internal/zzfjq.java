package com.google.android.gms.internal;

import com.bumptech.glide.load.Key;
import java.nio.charset.Charset;
import java.util.Arrays;

public final class zzfjq {
    private static Charset ISO_8859_1 = Charset.forName("ISO-8859-1");
    protected static final Charset UTF_8 = Charset.forName(Key.STRING_CHARSET_NAME);
    public static final Object zzpnk = new Object();

    public static boolean equals(double[] dArr, double[] dArr2) {
        if (dArr != null) {
            if (dArr.length != 0) {
                return Arrays.equals(dArr, dArr2);
            }
        }
        if (dArr2 != null) {
            if (dArr2.length != 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean equals(float[] fArr, float[] fArr2) {
        if (fArr != null) {
            if (fArr.length != 0) {
                return Arrays.equals(fArr, fArr2);
            }
        }
        if (fArr2 != null) {
            if (fArr2.length != 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean equals(int[] iArr, int[] iArr2) {
        if (iArr != null) {
            if (iArr.length != 0) {
                return Arrays.equals(iArr, iArr2);
            }
        }
        if (iArr2 != null) {
            if (iArr2.length != 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean equals(long[] jArr, long[] jArr2) {
        if (jArr != null) {
            if (jArr.length != 0) {
                return Arrays.equals(jArr, jArr2);
            }
        }
        if (jArr2 != null) {
            if (jArr2.length != 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean equals(Object[] objArr, Object[] objArr2) {
        int length = objArr == null ? 0 : objArr.length;
        int length2 = objArr2 == null ? 0 : objArr2.length;
        int i = 0;
        int i2 = i;
        while (true) {
            if (i >= length || objArr[i] != null) {
                while (i2 < length2 && objArr2[i2] == null) {
                    i2++;
                }
                boolean z = i >= length;
                boolean z2 = i2 >= length2;
                if (z && z2) {
                    return true;
                }
                if (z != z2 || !objArr[i].equals(objArr2[i2])) {
                    return false;
                }
                i++;
                i2++;
            } else {
                i++;
            }
        }
    }

    public static boolean equals(boolean[] zArr, boolean[] zArr2) {
        if (zArr != null) {
            if (zArr.length != 0) {
                return Arrays.equals(zArr, zArr2);
            }
        }
        if (zArr2 != null) {
            if (zArr2.length != 0) {
                return false;
            }
        }
        return true;
    }

    public static int hashCode(double[] dArr) {
        if (dArr != null) {
            if (dArr.length != 0) {
                return Arrays.hashCode(dArr);
            }
        }
        return 0;
    }

    public static int hashCode(float[] fArr) {
        if (fArr != null) {
            if (fArr.length != 0) {
                return Arrays.hashCode(fArr);
            }
        }
        return 0;
    }

    public static int hashCode(int[] iArr) {
        if (iArr != null) {
            if (iArr.length != 0) {
                return Arrays.hashCode(iArr);
            }
        }
        return 0;
    }

    public static int hashCode(long[] jArr) {
        if (jArr != null) {
            if (jArr.length != 0) {
                return Arrays.hashCode(jArr);
            }
        }
        return 0;
    }

    public static int hashCode(Object[] objArr) {
        int i = 0;
        int length = objArr == null ? 0 : objArr.length;
        int i2 = 0;
        while (i < length) {
            Object obj = objArr[i];
            if (obj != null) {
                i2 = (i2 * 31) + obj.hashCode();
            }
            i++;
        }
        return i2;
    }

    public static int hashCode(boolean[] zArr) {
        if (zArr != null) {
            if (zArr.length != 0) {
                return Arrays.hashCode(zArr);
            }
        }
        return 0;
    }

    public static void zza(zzfjm com_google_android_gms_internal_zzfjm, zzfjm com_google_android_gms_internal_zzfjm2) {
        if (com_google_android_gms_internal_zzfjm.zzpnc != null) {
            com_google_android_gms_internal_zzfjm2.zzpnc = (zzfjo) com_google_android_gms_internal_zzfjm.zzpnc.clone();
        }
    }

    public static boolean zza(byte[][] bArr, byte[][] bArr2) {
        int length = bArr == null ? 0 : bArr.length;
        int length2 = bArr2 == null ? 0 : bArr2.length;
        int i = 0;
        int i2 = i;
        while (true) {
            if (i >= length || bArr[i] != null) {
                while (i2 < length2 && bArr2[i2] == null) {
                    i2++;
                }
                boolean z = i >= length;
                boolean z2 = i2 >= length2;
                if (z && z2) {
                    return true;
                }
                if (z != z2 || !Arrays.equals(bArr[i], bArr2[i2])) {
                    return false;
                }
                i++;
                i2++;
            } else {
                i++;
            }
        }
    }

    public static int zzd(byte[][] bArr) {
        int i = 0;
        int length = bArr == null ? 0 : bArr.length;
        int i2 = 0;
        while (i < length) {
            byte[] bArr2 = bArr[i];
            if (bArr2 != null) {
                i2 = (i2 * 31) + Arrays.hashCode(bArr2);
            }
            i++;
        }
        return i2;
    }
}
