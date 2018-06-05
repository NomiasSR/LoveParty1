package com.google.android.gms.internal;

import java.io.IOException;
import java.io.InputStream;

final class zzfhu extends InputStream {
    private int mark;
    private zzfht zzpjp;
    private zzfey zzpjq;
    private int zzpjr;
    private int zzpjs;
    private int zzpjt;
    private /* synthetic */ zzfhq zzpju;

    public zzfhu(zzfhq com_google_android_gms_internal_zzfhq) {
        this.zzpju = com_google_android_gms_internal_zzfhq;
        initialize();
    }

    private final void initialize() {
        this.zzpjp = new zzfht(this.zzpju);
        this.zzpjq = (zzfey) this.zzpjp.next();
        this.zzpjr = this.zzpjq.size();
        this.zzpjs = 0;
        this.zzpjt = 0;
    }

    private final void zzczd() {
        if (this.zzpjq != null && this.zzpjs == this.zzpjr) {
            this.zzpjt += this.zzpjr;
            this.zzpjs = 0;
            if (this.zzpjp.hasNext()) {
                this.zzpjq = (zzfey) this.zzpjp.next();
                this.zzpjr = this.zzpjq.size();
                return;
            }
            this.zzpjq = null;
            this.zzpjr = 0;
        }
    }

    private final int zzj(byte[] bArr, int i, int i2) {
        int i3 = i;
        i = i2;
        while (i > 0) {
            zzczd();
            if (this.zzpjq == null) {
                if (i == i2) {
                    return -1;
                }
                return i2 - i;
            }
            int min = Math.min(this.zzpjr - this.zzpjs, i);
            if (bArr != null) {
                this.zzpjq.zza(bArr, this.zzpjs, i3, min);
                i3 += min;
            }
            this.zzpjs += min;
            i -= min;
        }
        return i2 - i;
    }

    public final int available() throws IOException {
        return this.zzpju.size() - (this.zzpjt + this.zzpjs);
    }

    public final void mark(int i) {
        this.mark = this.zzpjt + this.zzpjs;
    }

    public final boolean markSupported() {
        return true;
    }

    public final int read() throws IOException {
        zzczd();
        if (this.zzpjq == null) {
            return -1;
        }
        zzfes com_google_android_gms_internal_zzfes = this.zzpjq;
        int i = this.zzpjs;
        this.zzpjs = i + 1;
        return com_google_android_gms_internal_zzfes.zzkn(i) & 255;
    }

    public final int read(byte[] bArr, int i, int i2) {
        if (bArr == null) {
            throw new NullPointerException();
        }
        if (i >= 0 && i2 >= 0) {
            if (i2 <= bArr.length - i) {
                return zzj(bArr, i, i2);
            }
        }
        throw new IndexOutOfBoundsException();
    }

    public final synchronized void reset() {
        initialize();
        zzj(null, 0, this.mark);
    }

    public final long skip(long j) {
        if (j < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (j > 2147483647L) {
            j = 2147483647L;
        }
        return (long) zzj(null, 0, (int) j);
    }
}
