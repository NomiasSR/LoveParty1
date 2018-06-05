package com.google.android.gms.internal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

final class zzfhq extends zzfes {
    private static final int[] zzpjg;
    private final int zzpjh;
    private final zzfes zzpji;
    private final zzfes zzpjj;
    private final int zzpjk;
    private final int zzpjl;

    static {
        List arrayList = new ArrayList();
        int i = 1;
        int i2 = 1;
        while (i > 0) {
            arrayList.add(Integer.valueOf(i));
            int i3 = i2 + i;
            i2 = i;
            i = i3;
        }
        arrayList.add(Integer.valueOf(ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED));
        zzpjg = new int[arrayList.size()];
        for (i = 0; i < zzpjg.length; i++) {
            zzpjg[i] = ((Integer) arrayList.get(i)).intValue();
        }
    }

    private zzfhq(zzfes com_google_android_gms_internal_zzfes, zzfes com_google_android_gms_internal_zzfes2) {
        this.zzpji = com_google_android_gms_internal_zzfes;
        this.zzpjj = com_google_android_gms_internal_zzfes2;
        this.zzpjk = com_google_android_gms_internal_zzfes.size();
        this.zzpjh = this.zzpjk + com_google_android_gms_internal_zzfes2.size();
        this.zzpjl = Math.max(com_google_android_gms_internal_zzfes.zzcvn(), com_google_android_gms_internal_zzfes2.zzcvn()) + 1;
    }

    static zzfes zza(zzfes com_google_android_gms_internal_zzfes, zzfes com_google_android_gms_internal_zzfes2) {
        if (com_google_android_gms_internal_zzfes2.size() == 0) {
            return com_google_android_gms_internal_zzfes;
        }
        if (com_google_android_gms_internal_zzfes.size() == 0) {
            return com_google_android_gms_internal_zzfes2;
        }
        int size = com_google_android_gms_internal_zzfes.size() + com_google_android_gms_internal_zzfes2.size();
        if (size < 128) {
            return zzb(com_google_android_gms_internal_zzfes, com_google_android_gms_internal_zzfes2);
        }
        if (com_google_android_gms_internal_zzfes instanceof zzfhq) {
            zzfhq com_google_android_gms_internal_zzfhq = (zzfhq) com_google_android_gms_internal_zzfes;
            if (com_google_android_gms_internal_zzfhq.zzpjj.size() + com_google_android_gms_internal_zzfes2.size() < 128) {
                return new zzfhq(com_google_android_gms_internal_zzfhq.zzpji, zzb(com_google_android_gms_internal_zzfhq.zzpjj, com_google_android_gms_internal_zzfes2));
            } else if (com_google_android_gms_internal_zzfhq.zzpji.zzcvn() > com_google_android_gms_internal_zzfhq.zzpjj.zzcvn() && com_google_android_gms_internal_zzfhq.zzcvn() > com_google_android_gms_internal_zzfes2.zzcvn()) {
                return new zzfhq(com_google_android_gms_internal_zzfhq.zzpji, new zzfhq(com_google_android_gms_internal_zzfhq.zzpjj, com_google_android_gms_internal_zzfes2));
            }
        }
        return size >= zzpjg[Math.max(com_google_android_gms_internal_zzfes.zzcvn(), com_google_android_gms_internal_zzfes2.zzcvn()) + 1] ? new zzfhq(com_google_android_gms_internal_zzfes, com_google_android_gms_internal_zzfes2) : new zzfhs().zzc(com_google_android_gms_internal_zzfes, com_google_android_gms_internal_zzfes2);
    }

    private static zzfes zzb(zzfes com_google_android_gms_internal_zzfes, zzfes com_google_android_gms_internal_zzfes2) {
        int size = com_google_android_gms_internal_zzfes.size();
        int size2 = com_google_android_gms_internal_zzfes2.size();
        byte[] bArr = new byte[(size + size2)];
        com_google_android_gms_internal_zzfes.zza(bArr, 0, 0, size);
        com_google_android_gms_internal_zzfes2.zza(bArr, 0, size, size2);
        return zzfes.zzba(bArr);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzfes)) {
            return false;
        }
        zzfes com_google_android_gms_internal_zzfes = (zzfes) obj;
        if (this.zzpjh != com_google_android_gms_internal_zzfes.size()) {
            return false;
        }
        if (this.zzpjh == 0) {
            return true;
        }
        int zzcvp = zzcvp();
        int zzcvp2 = com_google_android_gms_internal_zzfes.zzcvp();
        if (zzcvp != 0 && zzcvp2 != 0 && zzcvp != zzcvp2) {
            return false;
        }
        Iterator com_google_android_gms_internal_zzfht = new zzfht(this);
        zzfes com_google_android_gms_internal_zzfes2 = (zzfey) com_google_android_gms_internal_zzfht.next();
        Iterator com_google_android_gms_internal_zzfht2 = new zzfht(com_google_android_gms_internal_zzfes);
        zzfes com_google_android_gms_internal_zzfes3 = (zzfey) com_google_android_gms_internal_zzfht2.next();
        int i = 0;
        int i2 = i;
        int i3 = i2;
        while (true) {
            int size = com_google_android_gms_internal_zzfes2.size() - i;
            int size2 = com_google_android_gms_internal_zzfes3.size() - i2;
            int min = Math.min(size, size2);
            if (!(i == 0 ? com_google_android_gms_internal_zzfes2.zza(com_google_android_gms_internal_zzfes3, i2, min) : com_google_android_gms_internal_zzfes3.zza(com_google_android_gms_internal_zzfes2, i, min))) {
                return false;
            }
            i3 += min;
            if (i3 >= this.zzpjh) {
                break;
            }
            if (min == size) {
                com_google_android_gms_internal_zzfes2 = (zzfey) com_google_android_gms_internal_zzfht.next();
                i = 0;
            } else {
                i += min;
            }
            if (min == size2) {
                com_google_android_gms_internal_zzfes3 = (zzfey) com_google_android_gms_internal_zzfht2.next();
                i2 = 0;
            } else {
                i2 += min;
            }
        }
        if (i3 == this.zzpjh) {
            return true;
        }
        throw new IllegalStateException();
    }

    public final int size() {
        return this.zzpjh;
    }

    final void zza(zzfer com_google_android_gms_internal_zzfer) throws IOException {
        this.zzpji.zza(com_google_android_gms_internal_zzfer);
        this.zzpjj.zza(com_google_android_gms_internal_zzfer);
    }

    protected final void zzb(byte[] bArr, int i, int i2, int i3) {
        if (i + i3 <= this.zzpjk) {
            this.zzpji.zzb(bArr, i, i2, i3);
        } else if (i >= this.zzpjk) {
            this.zzpjj.zzb(bArr, i - this.zzpjk, i2, i3);
        } else {
            int i4 = this.zzpjk - i;
            this.zzpji.zzb(bArr, i, i2, i4);
            this.zzpjj.zzb(bArr, 0, i2 + i4, i3 - i4);
        }
    }

    public final zzffb zzcvm() {
        return zzffb.zzi(new zzfhu(this));
    }

    protected final int zzcvn() {
        return this.zzpjl;
    }

    protected final boolean zzcvo() {
        return this.zzpjh >= zzpjg[this.zzpjl];
    }

    protected final int zzg(int i, int i2, int i3) {
        if (i2 + i3 <= this.zzpjk) {
            return this.zzpji.zzg(i, i2, i3);
        }
        if (i2 >= this.zzpjk) {
            return this.zzpjj.zzg(i, i2 - this.zzpjk, i3);
        }
        int i4 = this.zzpjk - i2;
        return this.zzpjj.zzg(this.zzpji.zzg(i, i2, i4), 0, i3 - i4);
    }

    public final byte zzkn(int i) {
        zzfes com_google_android_gms_internal_zzfes;
        zzfes.zzy(i, this.zzpjh);
        if (i < this.zzpjk) {
            com_google_android_gms_internal_zzfes = this.zzpji;
        } else {
            com_google_android_gms_internal_zzfes = this.zzpjj;
            i -= this.zzpjk;
        }
        return com_google_android_gms_internal_zzfes.zzkn(i);
    }

    public final zzfes zzx(int i, int i2) {
        int zzh = zzfes.zzh(i, i2, this.zzpjh);
        if (zzh == 0) {
            return zzfes.zzpfg;
        }
        if (zzh == this.zzpjh) {
            return this;
        }
        zzfes com_google_android_gms_internal_zzfes;
        if (i2 <= this.zzpjk) {
            com_google_android_gms_internal_zzfes = this.zzpji;
        } else if (i >= this.zzpjk) {
            com_google_android_gms_internal_zzfes = this.zzpjj;
            i -= this.zzpjk;
            i2 -= this.zzpjk;
        } else {
            com_google_android_gms_internal_zzfes = this.zzpji;
            return new zzfhq(com_google_android_gms_internal_zzfes.zzx(i, com_google_android_gms_internal_zzfes.size()), this.zzpjj.zzx(0, i2 - this.zzpjk));
        }
        return com_google_android_gms_internal_zzfes.zzx(i, i2);
    }
}
