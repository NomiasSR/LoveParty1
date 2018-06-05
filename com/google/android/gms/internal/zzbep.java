package com.google.android.gms.internal;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public final class zzbep {
    private static long zza(long j, long j2, long j3) {
        j = (j ^ j2) * j3;
        j = ((j ^ (j >>> 47)) ^ j2) * j3;
        return (j ^ (j >>> 47)) * j3;
    }

    private static long zza(byte[] bArr, int i, int i2) {
        byte[] bArr2 = bArr;
        long[] jArr = new long[2];
        long[] jArr2 = new long[2];
        long zzc = 95310865018149119L + zzc(bArr2, 0);
        int i3 = i2 - 1;
        int i4 = 0 + ((i3 / 64) << 6);
        int i5 = i3 & 63;
        int i6 = (i4 + i5) - 63;
        long j = 2480279821605975764L;
        long j2 = 1390051526045402406L;
        int i7 = i;
        while (true) {
            zzc = Long.rotateRight(((zzc + j) + jArr[0]) + zzc(bArr2, i7 + 8), 37) * -5435081209227447693L;
            long j3 = zzc ^ jArr2[1];
            long rotateRight = (Long.rotateRight((j + jArr[1]) + zzc(bArr2, i7 + 48), 42) * -5435081209227447693L) + (jArr[0] + zzc(bArr2, i7 + 40));
            long rotateRight2 = Long.rotateRight(j2 + jArr2[0], 33) * -5435081209227447693L;
            zza(bArr2, i7, jArr[1] * -5435081209227447693L, j3 + jArr2[0], jArr);
            zza(bArr2, i7 + 32, rotateRight2 + jArr2[1], rotateRight + zzc(bArr2, i7 + 16), jArr2);
            i7 += 64;
            if (i7 == i4) {
                long j4 = -5435081209227447693L + ((j3 & 255) << 1);
                jArr2[0] = jArr2[0] + ((long) i5);
                jArr[0] = jArr[0] + jArr2[0];
                jArr2[0] = jArr2[0] + jArr[0];
                long rotateRight3 = (Long.rotateRight(((rotateRight2 + rotateRight) + jArr[0]) + zzc(bArr2, i6 + 8), 37) * j4) ^ (jArr2[1] * 9);
                long rotateRight4 = (Long.rotateRight((rotateRight + jArr[1]) + zzc(bArr2, i6 + 48), 42) * j4) + ((jArr[0] * 9) + zzc(bArr2, i6 + 40));
                long rotateRight5 = Long.rotateRight(j3 + jArr2[0], 33) * j4;
                byte[] bArr3 = bArr2;
                zza(bArr3, i6, jArr[1] * j4, rotateRight3 + jArr2[0], jArr);
                zza(bArr3, i6 + 32, rotateRight5 + jArr2[1], zzc(bArr2, i6 + 16) + rotateRight4, jArr2);
                long j5 = j4;
                return zza((zza(jArr[0], jArr2[0], j5) + (((rotateRight4 >>> 47) ^ rotateRight4) * -4348849565147123417L)) + rotateRight3, zza(jArr[1], jArr2[1], j5) + rotateRight5, j5);
            }
            j2 = j3;
            j = rotateRight;
            zzc = rotateRight2;
        }
    }

    private static void zza(byte[] bArr, int i, long j, long j2, long[] jArr) {
        long zzc = zzc(bArr, i);
        long zzc2 = zzc(bArr, i + 8);
        long zzc3 = zzc(bArr, i + 16);
        long zzc4 = zzc(bArr, i + 24);
        j += zzc;
        zzc2 = (zzc2 + j) + zzc3;
        j2 = Long.rotateRight((j2 + j) + zzc4, 21) + Long.rotateRight(zzc2, 44);
        jArr[0] = zzc2 + zzc4;
        jArr[1] = j2 + j;
    }

    private static int zzb(byte[] bArr, int i) {
        return ((bArr[i + 3] & 255) << 24) | (((bArr[i] & 255) | ((bArr[i + 1] & 255) << 8)) | ((bArr[i + 2] & 255) << 16));
    }

    private static long zzc(byte[] bArr, int i) {
        ByteBuffer wrap = ByteBuffer.wrap(bArr, i, 8);
        wrap.order(ByteOrder.LITTLE_ENDIAN);
        return wrap.getLong();
    }

    public static long zzj(byte[] bArr) {
        byte[] bArr2 = bArr;
        int length = bArr2.length;
        if (length >= 0) {
            if (length <= bArr2.length) {
                long zzc;
                long zzc2;
                long zzc3;
                long j;
                if (length <= 32) {
                    if (length > 16) {
                        long j2 = -7286425919675154353L + ((long) (length << 1));
                        zzc = zzc(bArr2, 0) * -5435081209227447693L;
                        zzc2 = zzc(bArr2, 8);
                        length += 0;
                        zzc3 = zzc(bArr2, length - 8) * j2;
                        return zza((zzc(bArr2, length - 16) * -7286425919675154353L) + (Long.rotateRight(zzc + zzc2, 43) + Long.rotateRight(zzc3, 30)), (zzc + Long.rotateRight(zzc2 - 7286425919675154353L, 18)) + zzc3, j2);
                    } else if (length >= 8) {
                        j = -7286425919675154353L + ((long) (length << 1));
                        long zzc4 = zzc(bArr2, 0) - 7286425919675154353L;
                        r0 = zzc(bArr2, (length + 0) - 8);
                        return zza((Long.rotateRight(r0, 37) * j) + zzc4, (Long.rotateRight(zzc4, 25) + r0) * j, j);
                    } else if (length >= 4) {
                        return zza(((long) length) + ((((long) zzb(bArr2, 0)) & 4294967295L) << 3), ((long) zzb(bArr2, (length + 0) - 4)) & 4294967295L, -7286425919675154353L + ((long) (length << 1)));
                    } else if (length <= 0) {
                        return -7286425919675154353L;
                    } else {
                        byte b = bArr2[0];
                        byte b2 = bArr2[(length >> 1) + 0];
                        r0 = (((long) (length + ((bArr2[0 + (length - 1)] & 255) << 2))) * -4348849565147123417L) ^ (((long) ((b & 255) + ((b2 & 255) << 8))) * -7286425919675154353L);
                        return (r0 ^ (r0 >>> 47)) * -7286425919675154353L;
                    }
                } else if (length > 64) {
                    return zza(bArr2, 0, length);
                } else {
                    long j3 = ((long) (length << 1)) - 7286425919675154353L;
                    long zzc5 = zzc(bArr2, 0) * -7286425919675154353L;
                    zzc2 = zzc(bArr2, 8);
                    length += 0;
                    zzc3 = zzc(bArr2, length - 8) * j3;
                    zzc = (Long.rotateRight(zzc5 + zzc2, 43) + Long.rotateRight(zzc3, 30)) + (zzc(bArr2, length - 16) * -7286425919675154353L);
                    zzc3 = zza(zzc, (zzc5 + Long.rotateRight(zzc2 - 7286425919675154353L, 18)) + zzc3, j3);
                    zzc2 = zzc(bArr2, 16) * j3;
                    j = zzc(bArr2, 24);
                    zzc = (zzc + zzc(bArr2, length - 32)) * j3;
                    return zza((Long.rotateRight(zzc2 + j, 43) + Long.rotateRight(zzc, 30)) + ((zzc3 + zzc(bArr2, length - 24)) * j3), (zzc2 + Long.rotateRight(j + zzc5, 18)) + zzc, j3);
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder(67);
        stringBuilder.append("Out of bound index with offput: 0 and length: ");
        stringBuilder.append(length);
        throw new IndexOutOfBoundsException(stringBuilder.toString());
    }
}
