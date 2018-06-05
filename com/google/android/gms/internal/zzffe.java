package com.google.android.gms.internal;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

final class zzffe extends zzffb {
    private final byte[] buffer;
    private int pos;
    private int zzpfr;
    private int zzpft;
    private int zzpfu;
    private final InputStream zzpfv;
    private int zzpfw;
    private int zzpfx;
    private zzfff zzpfy;

    private zzffe(InputStream inputStream, int i) {
        super();
        this.zzpfu = ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.zzpfy = null;
        zzffz.zzc(inputStream, "input");
        this.zzpfv = inputStream;
        this.buffer = new byte[i];
        this.zzpfw = 0;
        this.pos = 0;
        this.zzpfx = 0;
    }

    private final long zzcwn() throws IOException {
        int i = this.pos;
        if (this.zzpfw != i) {
            byte[] bArr = this.buffer;
            int i2 = i + 1;
            byte b = bArr[i];
            if (b >= (byte) 0) {
                this.pos = i2;
                return (long) b;
            } else if (this.zzpfw - i2 >= 9) {
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
        if (this.zzpfw - i < 4) {
            zzkw(4);
            i = this.pos;
        }
        byte[] bArr = this.buffer;
        this.pos = i + 4;
        return ((bArr[i + 3] & 255) << 24) | (((bArr[i] & 255) | ((bArr[i + 1] & 255) << 8)) | ((bArr[i + 2] & 255) << 16));
    }

    private final long zzcwp() throws IOException {
        int i = this.pos;
        if (this.zzpfw - i < 8) {
            zzkw(8);
            i = this.pos;
        }
        byte[] bArr = this.buffer;
        this.pos = i + 8;
        return ((((long) bArr[i + 7]) & 255) << 56) | (((((((((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8)) | ((((long) bArr[i + 2]) & 255) << 16)) | ((((long) bArr[i + 3]) & 255) << 24)) | ((((long) bArr[i + 4]) & 255) << 32)) | ((((long) bArr[i + 5]) & 255) << 40)) | ((((long) bArr[i + 6]) & 255) << 48));
    }

    private final void zzcwq() {
        this.zzpfw += this.zzpfr;
        int i = this.zzpfx + this.zzpfw;
        if (i > this.zzpfu) {
            this.zzpfr = i - this.zzpfu;
            this.zzpfw -= this.zzpfr;
            return;
        }
        this.zzpfr = 0;
    }

    private final byte zzcwr() throws IOException {
        if (this.pos == this.zzpfw) {
            zzkw(1);
        }
        byte[] bArr = this.buffer;
        int i = this.pos;
        this.pos = i + 1;
        return bArr[i];
    }

    private final void zzkw(int i) throws IOException {
        if (!zzkx(i)) {
            if (i > (this.zzpfo - this.zzpfx) - this.pos) {
                throw zzfge.zzcyh();
            }
            throw zzfge.zzcya();
        }
    }

    private final boolean zzkx(int i) throws IOException {
        StringBuilder stringBuilder;
        while (this.pos + i > this.zzpfw) {
            if (i > (this.zzpfo - this.zzpfx) - this.pos || (this.zzpfx + this.pos) + i > this.zzpfu) {
                return false;
            }
            int i2 = this.pos;
            if (i2 > 0) {
                if (this.zzpfw > i2) {
                    System.arraycopy(this.buffer, i2, this.buffer, 0, this.zzpfw - i2);
                }
                this.zzpfx += i2;
                this.zzpfw -= i2;
                this.pos = 0;
            }
            i2 = this.zzpfv.read(this.buffer, this.zzpfw, Math.min(this.buffer.length - this.zzpfw, (this.zzpfo - this.zzpfx) - this.zzpfw));
            if (i2 != 0 && i2 >= -1) {
                if (i2 <= this.buffer.length) {
                    if (i2 <= 0) {
                        return false;
                    }
                    this.zzpfw += i2;
                    zzcwq();
                    if (this.zzpfw >= i) {
                        return true;
                    }
                }
            }
            stringBuilder = new StringBuilder(102);
            stringBuilder.append("InputStream#read(byte[]) returned invalid result: ");
            stringBuilder.append(i2);
            stringBuilder.append("\nThe InputStream implementation is buggy.");
            throw new IllegalStateException(stringBuilder.toString());
        }
        stringBuilder = new StringBuilder(77);
        stringBuilder.append("refillBuffer() called when ");
        stringBuilder.append(i);
        stringBuilder.append(" bytes were already available in buffer");
        throw new IllegalStateException(stringBuilder.toString());
    }

    private final byte[] zzky(int i) throws IOException {
        byte[] zzkz = zzkz(i);
        if (zzkz != null) {
            return zzkz;
        }
        int i2 = this.pos;
        int i3 = this.zzpfw - this.pos;
        this.zzpfx += this.zzpfw;
        this.pos = 0;
        this.zzpfw = 0;
        List<byte[]> zzla = zzla(i - i3);
        Object obj = new byte[i];
        System.arraycopy(this.buffer, i2, obj, 0, i3);
        for (byte[] bArr : zzla) {
            System.arraycopy(bArr, 0, obj, i3, bArr.length);
            i3 += bArr.length;
        }
        return obj;
    }

    private final byte[] zzkz(int i) throws IOException {
        if (i == 0) {
            return zzffz.EMPTY_BYTE_ARRAY;
        }
        if (i < 0) {
            throw zzfge.zzcyb();
        }
        int i2 = (this.zzpfx + this.pos) + i;
        if (i2 - this.zzpfo > 0) {
            throw zzfge.zzcyh();
        } else if (i2 > this.zzpfu) {
            zzku((this.zzpfu - this.zzpfx) - this.pos);
            throw zzfge.zzcya();
        } else {
            i2 = this.zzpfw - this.pos;
            int i3 = i - i2;
            if (i3 >= 4096) {
                if (i3 > this.zzpfv.available()) {
                    return null;
                }
            }
            Object obj = new byte[i];
            System.arraycopy(this.buffer, this.pos, obj, 0, i2);
            this.zzpfx += this.zzpfw;
            this.pos = 0;
            this.zzpfw = 0;
            while (i2 < obj.length) {
                int read = this.zzpfv.read(obj, i2, i - i2);
                if (read == -1) {
                    throw zzfge.zzcya();
                }
                this.zzpfx += read;
                i2 += read;
            }
            return obj;
        }
    }

    private final List<byte[]> zzla(int i) throws IOException {
        List<byte[]> arrayList = new ArrayList();
        while (i > 0) {
            Object obj = new byte[Math.min(i, 4096)];
            int i2 = 0;
            while (i2 < obj.length) {
                int read = this.zzpfv.read(obj, i2, obj.length - i2);
                if (read == -1) {
                    throw zzfge.zzcya();
                }
                this.zzpfx += read;
                i2 += read;
            }
            i -= obj.length;
            arrayList.add(obj);
        }
        return arrayList;
    }

    public final double readDouble() throws IOException {
        return Double.longBitsToDouble(zzcwp());
    }

    public final float readFloat() throws IOException {
        return Float.intBitsToFloat(zzcwo());
    }

    public final String readString() throws IOException {
        int zzcwi = zzcwi();
        String str;
        if (zzcwi > 0 && zzcwi <= this.zzpfw - this.pos) {
            str = new String(this.buffer, this.pos, zzcwi, zzffz.UTF_8);
            this.pos += zzcwi;
            return str;
        } else if (zzcwi == 0) {
            return "";
        } else {
            if (zzcwi > this.zzpfw) {
                return new String(zzky(zzcwi), zzffz.UTF_8);
            }
            zzkw(zzcwi);
            str = new String(this.buffer, this.pos, zzcwi, zzffz.UTF_8);
            this.pos += zzcwi;
            return str;
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
        byte[] bArr;
        int zzcwi = zzcwi();
        int i = this.pos;
        int i2 = 0;
        if (zzcwi <= this.zzpfw - i && zzcwi > 0) {
            bArr = this.buffer;
            this.pos = i + zzcwi;
            i2 = i;
        } else if (zzcwi == 0) {
            return "";
        } else {
            if (zzcwi <= this.zzpfw) {
                zzkw(zzcwi);
                bArr = this.buffer;
                this.pos = zzcwi;
            } else {
                bArr = zzky(zzcwi);
            }
        }
        if (zzfis.zzk(bArr, i2, i2 + zzcwi)) {
            return new String(bArr, i2, zzcwi, zzffz.UTF_8);
        }
        throw zzfge.zzcyi();
    }

    public final zzfes zzcwb() throws IOException {
        int zzcwi = zzcwi();
        if (zzcwi <= this.zzpfw - this.pos && zzcwi > 0) {
            zzfes zze = zzfes.zze(this.buffer, this.pos, zzcwi);
            this.pos += zzcwi;
            return zze;
        } else if (zzcwi == 0) {
            return zzfes.zzpfg;
        } else {
            byte[] zzkz = zzkz(zzcwi);
            if (zzkz != null) {
                return zzfes.zzba(zzkz);
            }
            int i = this.pos;
            int i2 = this.zzpfw - this.pos;
            this.zzpfx += this.zzpfw;
            this.pos = 0;
            this.zzpfw = 0;
            List<byte[]> zzla = zzla(zzcwi - i2);
            Iterable arrayList = new ArrayList(1 + zzla.size());
            arrayList.add(zzfes.zze(this.buffer, i, i2));
            for (byte[] zzkz2 : zzla) {
                arrayList.add(zzfes.zzba(zzkz2));
            }
            return zzfes.zzf(arrayList);
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
        r1 = r5.zzpfw;
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
        r3 = r5.zzpfw;
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzffe.zzcwi():int");
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
        if (this.zzpfu == ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED) {
            return -1;
        }
        return this.zzpfu - (this.zzpfx + this.pos);
    }

    public final boolean zzcwl() throws IOException {
        return this.pos == this.zzpfw && !zzkx(1);
    }

    public final int zzcwm() {
        return this.zzpfx + this.pos;
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
                if (this.zzpfw - this.pos >= 10) {
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
        i += this.zzpfx + this.pos;
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
        if (i <= this.zzpfw - this.pos && i >= 0) {
            this.pos += i;
        } else if (i < 0) {
            throw zzfge.zzcyb();
        } else if ((this.zzpfx + this.pos) + i > this.zzpfu) {
            zzku((this.zzpfu - this.zzpfx) - this.pos);
            throw zzfge.zzcya();
        } else {
            int i2 = this.zzpfw - this.pos;
            this.pos = this.zzpfw;
            while (true) {
                zzkw(1);
                int i3 = i - i2;
                if (i3 > this.zzpfw) {
                    i2 += this.zzpfw;
                    this.pos = this.zzpfw;
                } else {
                    this.pos = i3;
                    return;
                }
            }
        }
    }
}
