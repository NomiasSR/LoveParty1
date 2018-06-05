package com.google.android.gms.internal;

import java.io.IOException;
import java.util.Arrays;

final class zzffd extends zzffb {
    private final byte[] buffer;
    private final boolean immutable;
    private int limit;
    private int pos;
    private int zzpfr;
    private int zzpfs;
    private int zzpft;
    private int zzpfu;

    private zzffd(byte[] bArr, int i, int i2, boolean z) {
        super();
        this.zzpfu = ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.buffer = bArr;
        this.limit = i2 + i;
        this.pos = i;
        this.zzpfs = this.pos;
        this.immutable = z;
    }

    private final long zzcwn() throws IOException {
        int i = this.pos;
        if (this.limit != i) {
            byte[] bArr = this.buffer;
            int i2 = i + 1;
            byte b = bArr[i];
            if (b >= (byte) 0) {
                this.pos = i2;
                return (long) b;
            } else if (this.limit - i2 >= 9) {
                long j;
                int i3 = i2 + 1;
                i = b ^ (bArr[i2] << 7);
                if (i < 0) {
                    i ^= -128;
                } else {
                    i2 = i3 + 1;
                    i ^= bArr[i3] << 14;
                    if (i >= 0) {
                        long j2 = (long) (i ^ 16256);
                        i = i2;
                        j = j2;
                    } else {
                        i3 = i2 + 1;
                        i ^= bArr[i2] << 21;
                        if (i < 0) {
                            i ^= -2080896;
                        } else {
                            long j3 = (long) i;
                            i = i3 + 1;
                            long j4 = (((long) bArr[i3]) << 28) ^ j3;
                            if (j4 >= 0) {
                                j3 = 266354560;
                            } else {
                                long j5;
                                int i4 = i + 1;
                                j4 ^= ((long) bArr[i]) << 35;
                                if (j4 < 0) {
                                    j5 = -34093383808L;
                                } else {
                                    i = i4 + 1;
                                    j4 ^= ((long) bArr[i4]) << 42;
                                    if (j4 >= 0) {
                                        j3 = 4363953127296L;
                                    } else {
                                        i4 = i + 1;
                                        j4 ^= ((long) bArr[i]) << 49;
                                        if (j4 < 0) {
                                            j5 = -558586000294016L;
                                        } else {
                                            i = i4 + 1;
                                            j4 = (j4 ^ (((long) bArr[i4]) << 56)) ^ 71499008037633920L;
                                            if (j4 < 0) {
                                                i4 = i + 1;
                                                if (((long) bArr[i]) >= 0) {
                                                    j = j4;
                                                    i = i4;
                                                }
                                            } else {
                                                j = j4;
                                            }
                                        }
                                    }
                                }
                                j = j5 ^ j4;
                                i = i4;
                            }
                            j = j4 ^ j3;
                        }
                    }
                    this.pos = i;
                    return j;
                }
                j = (long) i;
                i = i3;
                this.pos = i;
                return j;
            }
        }
        return zzcwj();
    }

    private final int zzcwo() throws IOException {
        int i = this.pos;
        if (this.limit - i < 4) {
            throw zzfge.zzcya();
        }
        byte[] bArr = this.buffer;
        this.pos = i + 4;
        return ((bArr[i + 3] & 255) << 24) | (((bArr[i] & 255) | ((bArr[i + 1] & 255) << 8)) | ((bArr[i + 2] & 255) << 16));
    }

    private final long zzcwp() throws IOException {
        int i = this.pos;
        if (this.limit - i < 8) {
            throw zzfge.zzcya();
        }
        byte[] bArr = this.buffer;
        this.pos = i + 8;
        return ((((long) bArr[i + 7]) & 255) << 56) | (((((((((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8)) | ((((long) bArr[i + 2]) & 255) << 16)) | ((((long) bArr[i + 3]) & 255) << 24)) | ((((long) bArr[i + 4]) & 255) << 32)) | ((((long) bArr[i + 5]) & 255) << 40)) | ((((long) bArr[i + 6]) & 255) << 48));
    }

    private final void zzcwq() {
        this.limit += this.zzpfr;
        int i = this.limit - this.zzpfs;
        if (i > this.zzpfu) {
            this.zzpfr = i - this.zzpfu;
            this.limit -= this.zzpfr;
            return;
        }
        this.zzpfr = 0;
    }

    private final byte zzcwr() throws IOException {
        if (this.pos == this.limit) {
            throw zzfge.zzcya();
        }
        byte[] bArr = this.buffer;
        int i = this.pos;
        this.pos = i + 1;
        return bArr[i];
    }

    public final double readDouble() throws IOException {
        return Double.longBitsToDouble(zzcwp());
    }

    public final float readFloat() throws IOException {
        return Float.intBitsToFloat(zzcwo());
    }

    public final String readString() throws IOException {
        int zzcwi = zzcwi();
        if (zzcwi > 0 && zzcwi <= this.limit - this.pos) {
            String str = new String(this.buffer, this.pos, zzcwi, zzffz.UTF_8);
            this.pos += zzcwi;
            return str;
        } else if (zzcwi == 0) {
            return "";
        } else {
            if (zzcwi < 0) {
                throw zzfge.zzcyb();
            }
            throw zzfge.zzcya();
        }
    }

    public final <T extends zzffu<T, ?>> T zza(T t, zzffm com_google_android_gms_internal_zzffm) throws IOException {
        int zzcwi = zzcwi();
        if (this.zzpfm >= this.zzpfn) {
            throw zzfge.zzcyg();
        }
        zzcwi = zzks(zzcwi);
        this.zzpfm++;
        t = zzffu.zza((zzffu) t, (zzffb) this, com_google_android_gms_internal_zzffm);
        zzkp(0);
        this.zzpfm--;
        zzkt(zzcwi);
        return t;
    }

    public final void zza(zzfhf com_google_android_gms_internal_zzfhf, zzffm com_google_android_gms_internal_zzffm) throws IOException {
        int zzcwi = zzcwi();
        if (this.zzpfm >= this.zzpfn) {
            throw zzfge.zzcyg();
        }
        zzcwi = zzks(zzcwi);
        this.zzpfm++;
        com_google_android_gms_internal_zzfhf.zzb(this, com_google_android_gms_internal_zzffm);
        zzkp(0);
        this.zzpfm--;
        zzkt(zzcwi);
    }

    public final int zzcvt() throws IOException {
        if (zzcwl()) {
            this.zzpft = 0;
            return 0;
        }
        this.zzpft = zzcwi();
        if ((this.zzpft >>> 3) != 0) {
            return this.zzpft;
        }
        throw zzfge.zzcyd();
    }

    public final long zzcvu() throws IOException {
        return zzcwn();
    }

    public final long zzcvv() throws IOException {
        return zzcwn();
    }

    public final int zzcvw() throws IOException {
        return zzcwi();
    }

    public final long zzcvx() throws IOException {
        return zzcwp();
    }

    public final int zzcvy() throws IOException {
        return zzcwo();
    }

    public final boolean zzcvz() throws IOException {
        return zzcwn() != 0;
    }

    public final String zzcwa() throws IOException {
        int zzcwi = zzcwi();
        if (zzcwi <= 0 || zzcwi > this.limit - this.pos) {
            if (zzcwi == 0) {
                return "";
            }
            if (zzcwi <= 0) {
                throw zzfge.zzcyb();
            }
            throw zzfge.zzcya();
        } else if (zzfis.zzk(this.buffer, this.pos, this.pos + zzcwi)) {
            int i = this.pos;
            this.pos += zzcwi;
            return new String(this.buffer, i, zzcwi, zzffz.UTF_8);
        } else {
            throw zzfge.zzcyi();
        }
    }

    public final zzfes zzcwb() throws IOException {
        int zzcwi = zzcwi();
        if (zzcwi > 0 && zzcwi <= this.limit - this.pos) {
            zzfes zze = zzfes.zze(this.buffer, this.pos, zzcwi);
            this.pos += zzcwi;
            return zze;
        } else if (zzcwi == 0) {
            return zzfes.zzpfg;
        } else {
            byte[] copyOfRange;
            if (zzcwi > 0 && zzcwi <= this.limit - this.pos) {
                int i = this.pos;
                this.pos += zzcwi;
                copyOfRange = Arrays.copyOfRange(this.buffer, i, this.pos);
            } else if (zzcwi > 0) {
                throw zzfge.zzcya();
            } else if (zzcwi == 0) {
                copyOfRange = zzffz.EMPTY_BYTE_ARRAY;
            } else {
                throw zzfge.zzcyb();
            }
            return zzfes.zzba(copyOfRange);
        }
    }

    public final int zzcwc() throws IOException {
        return zzcwi();
    }

    public final int zzcwd() throws IOException {
        return zzcwi();
    }

    public final int zzcwe() throws IOException {
        return zzcwo();
    }

    public final long zzcwf() throws IOException {
        return zzcwp();
    }

    public final int zzcwg() throws IOException {
        return zzffb.zzkv(zzcwi());
    }

    public final long zzcwh() throws IOException {
        return zzffb.zzcs(zzcwn());
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zzcwi() throws java.io.IOException {
        /*
        r5 = this;
        r0 = r5.pos;
        r1 = r5.limit;
        if (r1 == r0) goto L_0x006d;
    L_0x0006:
        r1 = r5.buffer;
        r2 = r0 + 1;
        r0 = r1[r0];
        if (r0 < 0) goto L_0x0011;
    L_0x000e:
        r5.pos = r2;
        return r0;
    L_0x0011:
        r3 = r5.limit;
        r3 = r3 - r2;
        r4 = 9;
        if (r3 < r4) goto L_0x006d;
    L_0x0018:
        r3 = r2 + 1;
        r2 = r1[r2];
        r2 = r2 << 7;
        r0 = r0 ^ r2;
        if (r0 >= 0) goto L_0x0024;
    L_0x0021:
        r0 = r0 ^ -128;
        goto L_0x006a;
    L_0x0024:
        r2 = r3 + 1;
        r3 = r1[r3];
        r3 = r3 << 14;
        r0 = r0 ^ r3;
        if (r0 < 0) goto L_0x0031;
    L_0x002d:
        r0 = r0 ^ 16256;
    L_0x002f:
        r3 = r2;
        goto L_0x006a;
    L_0x0031:
        r3 = r2 + 1;
        r2 = r1[r2];
        r2 = r2 << 21;
        r0 = r0 ^ r2;
        if (r0 >= 0) goto L_0x003f;
    L_0x003a:
        r1 = -2080896; // 0xffffffffffe03f80 float:NaN double:NaN;
        r0 = r0 ^ r1;
        goto L_0x006a;
    L_0x003f:
        r2 = r3 + 1;
        r3 = r1[r3];
        r4 = r3 << 28;
        r0 = r0 ^ r4;
        r4 = 266354560; // 0xfe03f80 float:2.2112565E-29 double:1.315966377E-315;
        r0 = r0 ^ r4;
        if (r3 >= 0) goto L_0x002f;
    L_0x004c:
        r3 = r2 + 1;
        r2 = r1[r2];
        if (r2 >= 0) goto L_0x006a;
    L_0x0052:
        r2 = r3 + 1;
        r3 = r1[r3];
        if (r3 >= 0) goto L_0x002f;
    L_0x0058:
        r3 = r2 + 1;
        r2 = r1[r2];
        if (r2 >= 0) goto L_0x006a;
    L_0x005e:
        r2 = r3 + 1;
        r3 = r1[r3];
        if (r3 >= 0) goto L_0x002f;
    L_0x0064:
        r3 = r2 + 1;
        r1 = r1[r2];
        if (r1 < 0) goto L_0x006d;
    L_0x006a:
        r5.pos = r3;
        return r0;
    L_0x006d:
        r0 = r5.zzcwj();
        r0 = (int) r0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzffd.zzcwi():int");
    }

    final long zzcwj() throws IOException {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            byte zzcwr = zzcwr();
            j |= ((long) (zzcwr & 127)) << i;
            if ((zzcwr & 128) == 0) {
                return j;
            }
        }
        throw zzfge.zzcyc();
    }

    public final int zzcwk() {
        return this.zzpfu == ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED ? -1 : this.zzpfu - zzcwm();
    }

    public final boolean zzcwl() throws IOException {
        return this.pos == this.limit;
    }

    public final int zzcwm() {
        return this.pos - this.zzpfs;
    }

    public final void zzkp(int i) throws zzfge {
        if (this.zzpft != i) {
            throw zzfge.zzcye();
        }
    }

    public final boolean zzkq(int i) throws IOException {
        int i2 = 0;
        switch (i & 7) {
            case 0:
                if (this.limit - this.pos >= 10) {
                    while (i2 < 10) {
                        byte[] bArr = this.buffer;
                        int i3 = this.pos;
                        this.pos = i3 + 1;
                        if (bArr[i3] < (byte) 0) {
                            i2++;
                        }
                    }
                    throw zzfge.zzcyc();
                }
                while (i2 < 10) {
                    if (zzcwr() < (byte) 0) {
                        i2++;
                    }
                }
                throw zzfge.zzcyc();
                return true;
            case 1:
                zzku(8);
                return true;
            case 2:
                zzku(zzcwi());
                return true;
            case 3:
                break;
            case 4:
                return false;
            case 5:
                zzku(4);
                return true;
            default:
                throw zzfge.zzcyf();
        }
        int zzcvt;
        do {
            zzcvt = zzcvt();
            if (zzcvt != 0) {
            }
            zzkp(((i >>> 3) << 3) | 4);
            return true;
        } while (zzkq(zzcvt));
        zzkp(((i >>> 3) << 3) | 4);
        return true;
    }

    public final int zzks(int i) throws zzfge {
        if (i < 0) {
            throw zzfge.zzcyb();
        }
        i += zzcwm();
        int i2 = this.zzpfu;
        if (i > i2) {
            throw zzfge.zzcya();
        }
        this.zzpfu = i;
        zzcwq();
        return i2;
    }

    public final void zzkt(int i) {
        this.zzpfu = i;
        zzcwq();
    }

    public final void zzku(int i) throws IOException {
        if (i >= 0 && i <= this.limit - this.pos) {
            this.pos += i;
        } else if (i < 0) {
            throw zzfge.zzcyb();
        } else {
            throw zzfge.zzcya();
        }
    }
}
