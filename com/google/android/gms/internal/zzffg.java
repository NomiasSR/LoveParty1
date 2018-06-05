package com.google.android.gms.internal;

import java.io.IOException;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class zzffg extends zzfer {
    private static final Logger logger = Logger.getLogger(zzffg.class.getName());
    private static final boolean zzpfz = zzfiq.zzczx();
    zzffi zzpga = this;

    public static class zzc extends IOException {
        zzc() {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.");
        }

        zzc(String str, Throwable th) {
            String valueOf = String.valueOf("CodedOutputStream was writing to a flat byte array and ran out of space.: ");
            str = String.valueOf(str);
            super(str.length() != 0 ? valueOf.concat(str) : new String(valueOf), th);
        }

        zzc(Throwable th) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.", th);
        }
    }

    static abstract class zza extends zzffg {
        final byte[] buffer;
        final int limit;
        int position;
        int zzpgb;

        zza(int i) {
            super();
            if (i < 0) {
                throw new IllegalArgumentException("bufferSize must be >= 0");
            }
            this.buffer = new byte[Math.max(i, 20)];
            this.limit = this.buffer.length;
        }

        final void zzah(int i, int i2) {
            zzlq((i << 3) | i2);
        }

        final void zzc(byte b) {
            byte[] bArr = this.buffer;
            int i = this.position;
            this.position = i + 1;
            bArr[i] = b;
            this.zzpgb++;
        }

        public final int zzcws() {
            throw new UnsupportedOperationException("spaceLeft() can only be called on CodedOutputStreams that are writing to a flat array or ByteBuffer.");
        }

        final void zzdc(long j) {
            byte[] bArr;
            if (zzffg.zzpfz) {
                long j2 = (long) this.position;
                while ((j & -128) != 0) {
                    bArr = this.buffer;
                    int i = this.position;
                    this.position = i + 1;
                    zzfiq.zza(bArr, (long) i, (byte) ((((int) j) & 127) | 128));
                    j >>>= 7;
                }
                bArr = this.buffer;
                int i2 = this.position;
                this.position = i2 + 1;
                zzfiq.zza(bArr, (long) i2, (byte) ((int) j));
                this.zzpgb += (int) (((long) this.position) - j2);
                return;
            }
            while ((j & -128) != 0) {
                bArr = this.buffer;
                int i3 = this.position;
                this.position = i3 + 1;
                bArr[i3] = (byte) ((((int) j) & 127) | 128);
                this.zzpgb++;
                j >>>= 7;
            }
            bArr = this.buffer;
            i2 = this.position;
            this.position = i2 + 1;
            bArr[i2] = (byte) ((int) j);
            this.zzpgb++;
        }

        final void zzdd(long j) {
            byte[] bArr = this.buffer;
            int i = this.position;
            this.position = i + 1;
            bArr[i] = (byte) ((int) (j & 255));
            bArr = this.buffer;
            i = this.position;
            this.position = i + 1;
            bArr[i] = (byte) ((int) ((j >> 8) & 255));
            bArr = this.buffer;
            i = this.position;
            this.position = i + 1;
            bArr[i] = (byte) ((int) ((j >> 16) & 255));
            bArr = this.buffer;
            i = this.position;
            this.position = i + 1;
            bArr[i] = (byte) ((int) (255 & (j >> 24)));
            bArr = this.buffer;
            i = this.position;
            this.position = i + 1;
            bArr[i] = (byte) ((int) (j >> 32));
            bArr = this.buffer;
            i = this.position;
            this.position = i + 1;
            bArr[i] = (byte) ((int) (j >> 40));
            bArr = this.buffer;
            i = this.position;
            this.position = i + 1;
            bArr[i] = (byte) ((int) (j >> 48));
            bArr = this.buffer;
            i = this.position;
            this.position = i + 1;
            bArr[i] = (byte) ((int) (j >> 56));
            this.zzpgb += 8;
        }

        final void zzlq(int i) {
            if (zzffg.zzpfz) {
                byte[] bArr;
                int i2;
                long j = (long) this.position;
                while ((i & -128) != 0) {
                    bArr = this.buffer;
                    i2 = this.position;
                    this.position = i2 + 1;
                    zzfiq.zza(bArr, (long) i2, (byte) ((i & 127) | 128));
                    i >>>= 7;
                }
                bArr = this.buffer;
                i2 = this.position;
                this.position = i2 + 1;
                zzfiq.zza(bArr, (long) i2, (byte) i);
                this.zzpgb += (int) (((long) this.position) - j);
                return;
            }
            byte[] bArr2;
            int i3;
            while ((i & -128) != 0) {
                bArr2 = this.buffer;
                i3 = this.position;
                this.position = i3 + 1;
                bArr2[i3] = (byte) ((i & 127) | 128);
                this.zzpgb++;
                i >>>= 7;
            }
            bArr2 = this.buffer;
            i3 = this.position;
            this.position = i3 + 1;
            bArr2[i3] = (byte) i;
            this.zzpgb++;
        }

        final void zzlr(int i) {
            byte[] bArr = this.buffer;
            int i2 = this.position;
            this.position = i2 + 1;
            bArr[i2] = (byte) i;
            bArr = this.buffer;
            i2 = this.position;
            this.position = i2 + 1;
            bArr[i2] = (byte) (i >> 8);
            bArr = this.buffer;
            i2 = this.position;
            this.position = i2 + 1;
            bArr[i2] = (byte) (i >> 16);
            bArr = this.buffer;
            i2 = this.position;
            this.position = i2 + 1;
            bArr[i2] = i >> 24;
            this.zzpgb += 4;
        }
    }

    static class zzb extends zzffg {
        private final byte[] buffer;
        private final int limit;
        private final int offset;
        private int position;

        zzb(byte[] bArr, int i, int i2) {
            super();
            if (bArr == null) {
                throw new NullPointerException("buffer");
            }
            int i3 = i + i2;
            if (((i | i2) | (bArr.length - i3)) < 0) {
                throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", new Object[]{Integer.valueOf(bArr.length), Integer.valueOf(i), Integer.valueOf(i2)}));
            }
            this.buffer = bArr;
            this.offset = i;
            this.position = i;
            this.limit = i3;
        }

        public void flush() {
        }

        public final void write(byte[] bArr, int i, int i2) throws IOException {
            try {
                System.arraycopy(bArr, i, this.buffer, this.position, i2);
                this.position += i2;
            } catch (Throwable e) {
                throw new zzc(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.position), Integer.valueOf(this.limit), Integer.valueOf(i2)}), e);
            }
        }

        public final void zza(int i, long j) throws IOException {
            zzz(i, 0);
            zzct(j);
        }

        public final void zza(int i, zzfes com_google_android_gms_internal_zzfes) throws IOException {
            zzz(i, 2);
            zzay(com_google_android_gms_internal_zzfes);
        }

        public final void zza(int i, zzfhe com_google_android_gms_internal_zzfhe) throws IOException {
            zzz(i, 2);
            zze(com_google_android_gms_internal_zzfhe);
        }

        public final void zzaa(int i, int i2) throws IOException {
            zzz(i, 0);
            zzlc(i2);
        }

        public final void zzab(int i, int i2) throws IOException {
            zzz(i, 0);
            zzld(i2);
        }

        public final void zzac(int i, int i2) throws IOException {
            zzz(i, 5);
            zzlf(i2);
        }

        public final void zzay(zzfes com_google_android_gms_internal_zzfes) throws IOException {
            zzld(com_google_android_gms_internal_zzfes.size());
            com_google_android_gms_internal_zzfes.zza(this);
        }

        public final void zzb(byte b) throws IOException {
            try {
                byte[] bArr = this.buffer;
                int i = this.position;
                this.position = i + 1;
                bArr[i] = b;
            } catch (Throwable e) {
                throw new zzc(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.position), Integer.valueOf(this.limit), Integer.valueOf(1)}), e);
            }
        }

        public final void zzb(int i, long j) throws IOException {
            zzz(i, 1);
            zzcv(j);
        }

        public final void zzb(int i, zzfes com_google_android_gms_internal_zzfes) throws IOException {
            zzz(1, 3);
            zzab(2, i);
            zza(3, com_google_android_gms_internal_zzfes);
            zzz(1, 4);
        }

        public final void zzb(int i, zzfhe com_google_android_gms_internal_zzfhe) throws IOException {
            zzz(1, 3);
            zzab(2, i);
            zza(3, com_google_android_gms_internal_zzfhe);
            zzz(1, 4);
        }

        public final void zzct(long j) throws IOException {
            byte[] bArr;
            if (!zzffg.zzpfz || zzcws() < 10) {
                while ((j & -128) != 0) {
                    bArr = this.buffer;
                    int i = this.position;
                    this.position = i + 1;
                    bArr[i] = (byte) ((((int) j) & 127) | 128);
                    j >>>= 7;
                }
                try {
                    bArr = this.buffer;
                    int i2 = this.position;
                    this.position = i2 + 1;
                    bArr[i2] = (byte) ((int) j);
                    return;
                } catch (Throwable e) {
                    throw new zzc(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.position), Integer.valueOf(this.limit), Integer.valueOf(1)}), e);
                }
            }
            while ((j & -128) != 0) {
                bArr = this.buffer;
                i = this.position;
                this.position = i + 1;
                zzfiq.zza(bArr, (long) i, (byte) ((((int) j) & 127) | 128));
                j >>>= 7;
            }
            bArr = this.buffer;
            i2 = this.position;
            this.position = i2 + 1;
            zzfiq.zza(bArr, (long) i2, (byte) ((int) j));
        }

        public final void zzcv(long j) throws IOException {
            try {
                byte[] bArr = this.buffer;
                int i = this.position;
                this.position = i + 1;
                bArr[i] = (byte) ((int) j);
                bArr = this.buffer;
                i = this.position;
                this.position = i + 1;
                bArr[i] = (byte) ((int) (j >> 8));
                bArr = this.buffer;
                i = this.position;
                this.position = i + 1;
                bArr[i] = (byte) ((int) (j >> 16));
                bArr = this.buffer;
                i = this.position;
                this.position = i + 1;
                bArr[i] = (byte) ((int) (j >> 24));
                bArr = this.buffer;
                i = this.position;
                this.position = i + 1;
                bArr[i] = (byte) ((int) (j >> 32));
                bArr = this.buffer;
                i = this.position;
                this.position = i + 1;
                bArr[i] = (byte) ((int) (j >> 40));
                bArr = this.buffer;
                i = this.position;
                this.position = i + 1;
                bArr[i] = (byte) ((int) (j >> 48));
                bArr = this.buffer;
                i = this.position;
                this.position = i + 1;
                bArr[i] = (byte) ((int) (j >> 56));
            } catch (Throwable e) {
                throw new zzc(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.position), Integer.valueOf(this.limit), Integer.valueOf(1)}), e);
            }
        }

        public final int zzcws() {
            return this.limit - this.position;
        }

        public final void zzd(byte[] bArr, int i, int i2) throws IOException {
            write(bArr, i, i2);
        }

        public final void zze(zzfhe com_google_android_gms_internal_zzfhe) throws IOException {
            zzld(com_google_android_gms_internal_zzfhe.zzho());
            com_google_android_gms_internal_zzfhe.zza(this);
        }

        public final void zzi(byte[] bArr, int i, int i2) throws IOException {
            zzld(i2);
            write(bArr, 0, i2);
        }

        public final void zzl(int i, boolean z) throws IOException {
            zzz(i, 0);
            zzb((byte) z);
        }

        public final void zzlc(int i) throws IOException {
            if (i >= 0) {
                zzld(i);
            } else {
                zzct((long) i);
            }
        }

        public final void zzld(int i) throws IOException {
            byte[] bArr;
            int i2;
            if (!zzffg.zzpfz || zzcws() < 10) {
                while ((i & -128) != 0) {
                    bArr = this.buffer;
                    i2 = this.position;
                    this.position = i2 + 1;
                    bArr[i2] = (byte) ((i & 127) | 128);
                    i >>>= 7;
                }
                try {
                    bArr = this.buffer;
                    i2 = this.position;
                    this.position = i2 + 1;
                    bArr[i2] = (byte) i;
                    return;
                } catch (Throwable e) {
                    throw new zzc(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.position), Integer.valueOf(this.limit), Integer.valueOf(1)}), e);
                }
            }
            while ((i & -128) != 0) {
                bArr = this.buffer;
                i2 = this.position;
                this.position = i2 + 1;
                zzfiq.zza(bArr, (long) i2, (byte) ((i & 127) | 128));
                i >>>= 7;
            }
            bArr = this.buffer;
            i2 = this.position;
            this.position = i2 + 1;
            zzfiq.zza(bArr, (long) i2, (byte) i);
        }

        public final void zzlf(int i) throws IOException {
            try {
                byte[] bArr = this.buffer;
                int i2 = this.position;
                this.position = i2 + 1;
                bArr[i2] = (byte) i;
                bArr = this.buffer;
                i2 = this.position;
                this.position = i2 + 1;
                bArr[i2] = (byte) (i >> 8);
                bArr = this.buffer;
                i2 = this.position;
                this.position = i2 + 1;
                bArr[i2] = (byte) (i >> 16);
                bArr = this.buffer;
                i2 = this.position;
                this.position = i2 + 1;
                bArr[i2] = i >> 24;
            } catch (Throwable e) {
                throw new zzc(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.position), Integer.valueOf(this.limit), Integer.valueOf(1)}), e);
            }
        }

        public final void zzn(int i, String str) throws IOException {
            zzz(i, 2);
            zzts(str);
        }

        public final void zzts(String str) throws IOException {
            int i = this.position;
            try {
                int zzli = zzffg.zzli(str.length() * 3);
                int zzli2 = zzffg.zzli(str.length());
                if (zzli2 == zzli) {
                    this.position = i + zzli2;
                    zzli = zzfis.zza(str, this.buffer, this.position, zzcws());
                    this.position = i;
                    zzld((zzli - i) - zzli2);
                    this.position = zzli;
                    return;
                }
                zzld(zzfis.zzd(str));
                this.position = zzfis.zza(str, this.buffer, this.position, zzcws());
            } catch (zzfiv e) {
                this.position = i;
                zza(str, e);
            } catch (Throwable e2) {
                throw new zzc(e2);
            }
        }

        public final void zzz(int i, int i2) throws IOException {
            zzld((i << 3) | i2);
        }
    }

    static final class zzd extends zza {
        private final OutputStream out;

        zzd(OutputStream outputStream, int i) {
            super(i);
            if (outputStream == null) {
                throw new NullPointerException("out");
            }
            this.out = outputStream;
        }

        private final void doFlush() throws IOException {
            this.out.write(this.buffer, 0, this.position);
            this.position = 0;
        }

        private final void zzls(int i) throws IOException {
            if (this.limit - this.position < i) {
                doFlush();
            }
        }

        public final void flush() throws IOException {
            if (this.position > 0) {
                doFlush();
            }
        }

        public final void write(byte[] bArr, int i, int i2) throws IOException {
            if (this.limit - this.position >= i2) {
                System.arraycopy(bArr, i, this.buffer, this.position, i2);
                this.position += i2;
            } else {
                int i3 = this.limit - this.position;
                System.arraycopy(bArr, i, this.buffer, this.position, i3);
                i += i3;
                i2 -= i3;
                this.position = this.limit;
                this.zzpgb += i3;
                doFlush();
                if (i2 <= this.limit) {
                    System.arraycopy(bArr, i, this.buffer, 0, i2);
                    this.position = i2;
                } else {
                    this.out.write(bArr, i, i2);
                }
            }
            this.zzpgb += i2;
        }

        public final void zza(int i, long j) throws IOException {
            zzls(20);
            zzah(i, 0);
            zzdc(j);
        }

        public final void zza(int i, zzfes com_google_android_gms_internal_zzfes) throws IOException {
            zzz(i, 2);
            zzay(com_google_android_gms_internal_zzfes);
        }

        public final void zza(int i, zzfhe com_google_android_gms_internal_zzfhe) throws IOException {
            zzz(i, 2);
            zze(com_google_android_gms_internal_zzfhe);
        }

        public final void zzaa(int i, int i2) throws IOException {
            zzls(20);
            zzah(i, 0);
            if (i2 >= 0) {
                zzlq(i2);
            } else {
                zzdc((long) i2);
            }
        }

        public final void zzab(int i, int i2) throws IOException {
            zzls(20);
            zzah(i, 0);
            zzlq(i2);
        }

        public final void zzac(int i, int i2) throws IOException {
            zzls(14);
            zzah(i, 5);
            zzlr(i2);
        }

        public final void zzay(zzfes com_google_android_gms_internal_zzfes) throws IOException {
            zzld(com_google_android_gms_internal_zzfes.size());
            com_google_android_gms_internal_zzfes.zza(this);
        }

        public final void zzb(byte b) throws IOException {
            if (this.position == this.limit) {
                doFlush();
            }
            zzc(b);
        }

        public final void zzb(int i, long j) throws IOException {
            zzls(18);
            zzah(i, 1);
            zzdd(j);
        }

        public final void zzb(int i, zzfes com_google_android_gms_internal_zzfes) throws IOException {
            zzz(1, 3);
            zzab(2, i);
            zza(3, com_google_android_gms_internal_zzfes);
            zzz(1, 4);
        }

        public final void zzb(int i, zzfhe com_google_android_gms_internal_zzfhe) throws IOException {
            zzz(1, 3);
            zzab(2, i);
            zza(3, com_google_android_gms_internal_zzfhe);
            zzz(1, 4);
        }

        public final void zzct(long j) throws IOException {
            zzls(10);
            zzdc(j);
        }

        public final void zzcv(long j) throws IOException {
            zzls(8);
            zzdd(j);
        }

        public final void zzd(byte[] bArr, int i, int i2) throws IOException {
            write(bArr, i, i2);
        }

        public final void zze(zzfhe com_google_android_gms_internal_zzfhe) throws IOException {
            zzld(com_google_android_gms_internal_zzfhe.zzho());
            com_google_android_gms_internal_zzfhe.zza(this);
        }

        public final void zzi(byte[] bArr, int i, int i2) throws IOException {
            zzld(i2);
            write(bArr, 0, i2);
        }

        public final void zzl(int i, boolean z) throws IOException {
            zzls(11);
            zzah(i, 0);
            zzc((byte) z);
        }

        public final void zzlc(int i) throws IOException {
            if (i >= 0) {
                zzld(i);
            } else {
                zzct((long) i);
            }
        }

        public final void zzld(int i) throws IOException {
            zzls(10);
            zzlq(i);
        }

        public final void zzlf(int i) throws IOException {
            zzls(4);
            zzlr(i);
        }

        public final void zzn(int i, String str) throws IOException {
            zzz(i, 2);
            zzts(str);
        }

        public final void zzts(String str) throws IOException {
            int i;
            try {
                int length = str.length() * 3;
                int zzli = zzffg.zzli(length);
                i = zzli + length;
                if (i > this.limit) {
                    byte[] bArr = new byte[length];
                    length = zzfis.zza(str, bArr, 0, length);
                    zzld(length);
                    zzd(bArr, 0, length);
                    return;
                }
                int i2;
                if (i > this.limit - this.position) {
                    doFlush();
                }
                length = zzffg.zzli(str.length());
                i = this.position;
                if (length == zzli) {
                    this.position = i + length;
                    zzli = zzfis.zza(str, this.buffer, this.position, this.limit - this.position);
                    this.position = i;
                    i2 = (zzli - i) - length;
                    zzlq(i2);
                    this.position = zzli;
                } else {
                    i2 = zzfis.zzd(str);
                    zzlq(i2);
                    this.position = zzfis.zza(str, this.buffer, this.position, i2);
                }
                this.zzpgb += i2;
            } catch (zzfiv e) {
                this.zzpgb -= this.position - i;
                this.position = i;
                throw e;
            } catch (Throwable e2) {
                throw new zzc(e2);
            } catch (zzfiv e3) {
                zza(str, e3);
            }
        }

        public final void zzz(int i, int i2) throws IOException {
            zzld((i << 3) | i2);
        }
    }

    private zzffg() {
    }

    public static int zza(int i, zzfgk com_google_android_gms_internal_zzfgk) {
        i = zzlg(i);
        int zzho = com_google_android_gms_internal_zzfgk.zzho();
        return i + (zzli(zzho) + zzho);
    }

    public static int zza(zzfgk com_google_android_gms_internal_zzfgk) {
        int zzho = com_google_android_gms_internal_zzfgk.zzho();
        return zzli(zzho) + zzho;
    }

    public static int zzad(int i, int i2) {
        return zzlg(i) + zzlh(i2);
    }

    public static int zzae(int i, int i2) {
        return zzlg(i) + zzli(i2);
    }

    public static int zzaf(int i, int i2) {
        return zzlg(i) + 4;
    }

    public static int zzag(int i, int i2) {
        return zzlg(i) + zzlh(i2);
    }

    public static int zzaz(zzfes com_google_android_gms_internal_zzfes) {
        int size = com_google_android_gms_internal_zzfes.size();
        return zzli(size) + size;
    }

    public static int zzb(int i, double d) {
        return zzlg(i) + 8;
    }

    public static int zzb(int i, zzfgk com_google_android_gms_internal_zzfgk) {
        return ((zzlg(1) << 1) + zzae(2, i)) + zza(3, com_google_android_gms_internal_zzfgk);
    }

    public static zzffg zzb(OutputStream outputStream, int i) {
        return new zzd(outputStream, i);
    }

    public static zzffg zzbc(byte[] bArr) {
        return zzh(bArr, 0, bArr.length);
    }

    public static int zzbd(byte[] bArr) {
        int length = bArr.length;
        return zzli(length) + length;
    }

    public static int zzc(int i, long j) {
        return zzlg(i) + zzcx(j);
    }

    public static int zzc(int i, zzfes com_google_android_gms_internal_zzfes) {
        i = zzlg(i);
        int size = com_google_android_gms_internal_zzfes.size();
        return i + (zzli(size) + size);
    }

    public static int zzc(int i, zzfhe com_google_android_gms_internal_zzfhe) {
        return zzlg(i) + zzf(com_google_android_gms_internal_zzfhe);
    }

    public static int zzcw(long j) {
        return zzcx(j);
    }

    public static int zzcx(long j) {
        if ((-128 & j) == 0) {
            return 1;
        }
        if (j < 0) {
            return 10;
        }
        int i;
        if ((-34359738368L & j) != 0) {
            i = 6;
            j >>>= 28;
        } else {
            i = 2;
        }
        if ((-2097152 & j) != 0) {
            i += 2;
            j >>>= 14;
        }
        if ((j & -16384) != 0) {
            i++;
        }
        return i;
    }

    public static int zzcy(long j) {
        return zzcx(zzdb(j));
    }

    public static int zzcz(long j) {
        return 8;
    }

    public static int zzd(int i, long j) {
        return zzlg(i) + zzcx(j);
    }

    public static int zzd(int i, zzfes com_google_android_gms_internal_zzfes) {
        return ((zzlg(1) << 1) + zzae(2, i)) + zzc(3, com_google_android_gms_internal_zzfes);
    }

    public static int zzd(int i, zzfhe com_google_android_gms_internal_zzfhe) {
        return ((zzlg(1) << 1) + zzae(2, i)) + zzc(3, com_google_android_gms_internal_zzfhe);
    }

    public static int zzda(long j) {
        return 8;
    }

    private static long zzdb(long j) {
        return (j >> 63) ^ (j << 1);
    }

    public static int zzde(boolean z) {
        return 1;
    }

    public static int zze(int i, long j) {
        return zzlg(i) + 8;
    }

    public static int zzf(zzfhe com_google_android_gms_internal_zzfhe) {
        int zzho = com_google_android_gms_internal_zzfhe.zzho();
        return zzli(zzho) + zzho;
    }

    public static int zzg(float f) {
        return 4;
    }

    @Deprecated
    public static int zzg(zzfhe com_google_android_gms_internal_zzfhe) {
        return com_google_android_gms_internal_zzfhe.zzho();
    }

    public static zzffg zzh(byte[] bArr, int i, int i2) {
        return new zzb(bArr, i, i2);
    }

    static int zzlb(int i) {
        return i > 4096 ? 4096 : i;
    }

    public static int zzlg(int i) {
        return zzli(i << 3);
    }

    public static int zzlh(int i) {
        return i >= 0 ? zzli(i) : 10;
    }

    public static int zzli(int i) {
        return (i & -128) == 0 ? 1 : (i & -16384) == 0 ? 2 : (-2097152 & i) == 0 ? 3 : (i & -268435456) == 0 ? 4 : 5;
    }

    public static int zzlj(int i) {
        return zzli(zzlo(i));
    }

    public static int zzlk(int i) {
        return 4;
    }

    public static int zzll(int i) {
        return 4;
    }

    public static int zzlm(int i) {
        return zzlh(i);
    }

    static int zzln(int i) {
        return zzli(i) + i;
    }

    private static int zzlo(int i) {
        return (i >> 31) ^ (i << 1);
    }

    @Deprecated
    public static int zzlp(int i) {
        return zzli(i);
    }

    public static int zzm(int i, boolean z) {
        return zzlg(i) + 1;
    }

    public static int zzo(double d) {
        return 8;
    }

    public static int zzo(int i, String str) {
        return zzlg(i) + zztt(str);
    }

    public static int zztt(java.lang.String r1) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = com.google.android.gms.internal.zzfis.zzd(r1);	 Catch:{ zzfiv -> 0x0005 }
        goto L_0x000c;
    L_0x0005:
        r0 = com.google.android.gms.internal.zzffz.UTF_8;
        r1 = r1.getBytes(r0);
        r0 = r1.length;
    L_0x000c:
        r1 = zzli(r0);
        r1 = r1 + r0;
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzffg.zztt(java.lang.String):int");
    }

    public abstract void flush() throws IOException;

    public abstract void write(byte[] bArr, int i, int i2) throws IOException;

    public final void zza(int i, double d) throws IOException {
        zzb(i, Double.doubleToRawLongBits(d));
    }

    public abstract void zza(int i, long j) throws IOException;

    public abstract void zza(int i, zzfes com_google_android_gms_internal_zzfes) throws IOException;

    public abstract void zza(int i, zzfhe com_google_android_gms_internal_zzfhe) throws IOException;

    final void zza(String str, zzfiv com_google_android_gms_internal_zzfiv) throws IOException {
        logger.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", com_google_android_gms_internal_zzfiv);
        byte[] bytes = str.getBytes(zzffz.UTF_8);
        try {
            zzld(bytes.length);
            zzd(bytes, 0, bytes.length);
        } catch (Throwable e) {
            throw new zzc(e);
        } catch (zzc e2) {
            throw e2;
        }
    }

    public abstract void zzaa(int i, int i2) throws IOException;

    public abstract void zzab(int i, int i2) throws IOException;

    public abstract void zzac(int i, int i2) throws IOException;

    public abstract void zzay(zzfes com_google_android_gms_internal_zzfes) throws IOException;

    public abstract void zzb(byte b) throws IOException;

    public abstract void zzb(int i, long j) throws IOException;

    public abstract void zzb(int i, zzfes com_google_android_gms_internal_zzfes) throws IOException;

    public abstract void zzb(int i, zzfhe com_google_android_gms_internal_zzfhe) throws IOException;

    public abstract void zzct(long j) throws IOException;

    public final void zzcu(long j) throws IOException {
        zzct(zzdb(j));
    }

    public abstract void zzcv(long j) throws IOException;

    public abstract int zzcws();

    public final void zzcwt() {
        if (zzcws() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    public final void zzdd(boolean z) throws IOException {
        zzb((byte) z);
    }

    @Deprecated
    public final void zze(int i, zzfhe com_google_android_gms_internal_zzfhe) throws IOException {
        zzz(i, 3);
        com_google_android_gms_internal_zzfhe.zza(this);
        zzz(i, 4);
    }

    public abstract void zze(zzfhe com_google_android_gms_internal_zzfhe) throws IOException;

    public final void zzf(float f) throws IOException {
        zzlf(Float.floatToRawIntBits(f));
    }

    abstract void zzi(byte[] bArr, int i, int i2) throws IOException;

    public abstract void zzl(int i, boolean z) throws IOException;

    public abstract void zzlc(int i) throws IOException;

    public abstract void zzld(int i) throws IOException;

    public final void zzle(int i) throws IOException {
        zzld(zzlo(i));
    }

    public abstract void zzlf(int i) throws IOException;

    public final void zzn(double d) throws IOException {
        zzcv(Double.doubleToRawLongBits(d));
    }

    public abstract void zzn(int i, String str) throws IOException;

    public abstract void zzts(String str) throws IOException;

    public abstract void zzz(int i, int i2) throws IOException;
}
