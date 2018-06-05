package com.google.android.gms.internal;

import java.io.IOException;

public final class zzcmf extends zzfjm<zzcmf> {
    public long[] zzjmp;
    public long[] zzjmq;

    public zzcmf() {
        this.zzjmp = zzfjv.zzpnq;
        this.zzjmq = zzfjv.zzpnq;
        this.zzpnc = null;
        this.zzpfd = -1;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzcmf)) {
            return false;
        }
        zzcmf com_google_android_gms_internal_zzcmf = (zzcmf) obj;
        if (!zzfjq.equals(this.zzjmp, com_google_android_gms_internal_zzcmf.zzjmp) || !zzfjq.equals(this.zzjmq, com_google_android_gms_internal_zzcmf.zzjmq)) {
            return false;
        }
        if (this.zzpnc != null) {
            if (!this.zzpnc.isEmpty()) {
                return this.zzpnc.equals(com_google_android_gms_internal_zzcmf.zzpnc);
            }
        }
        return com_google_android_gms_internal_zzcmf.zzpnc == null || com_google_android_gms_internal_zzcmf.zzpnc.isEmpty();
    }

    public final int hashCode() {
        int hashCode;
        int hashCode2 = (((((527 + getClass().getName().hashCode()) * 31) + zzfjq.hashCode(this.zzjmp)) * 31) + zzfjq.hashCode(this.zzjmq)) * 31;
        if (this.zzpnc != null) {
            if (!this.zzpnc.isEmpty()) {
                hashCode = this.zzpnc.hashCode();
                return hashCode2 + hashCode;
            }
        }
        hashCode = 0;
        return hashCode2 + hashCode;
    }

    public final /* synthetic */ zzfjs zza(zzfjj com_google_android_gms_internal_zzfjj) throws IOException {
        while (true) {
            int zzcvt = com_google_android_gms_internal_zzfjj.zzcvt();
            if (zzcvt == 0) {
                return this;
            }
            int position;
            Object obj;
            if (zzcvt != 8) {
                int i;
                Object obj2;
                if (zzcvt == 10) {
                    zzcvt = com_google_android_gms_internal_zzfjj.zzks(com_google_android_gms_internal_zzfjj.zzcwi());
                    position = com_google_android_gms_internal_zzfjj.getPosition();
                    i = 0;
                    while (com_google_android_gms_internal_zzfjj.zzcwk() > 0) {
                        com_google_android_gms_internal_zzfjj.zzcwn();
                        i++;
                    }
                    com_google_android_gms_internal_zzfjj.zzmg(position);
                    position = this.zzjmp == null ? 0 : this.zzjmp.length;
                    obj2 = new long[(i + position)];
                    if (position != 0) {
                        System.arraycopy(this.zzjmp, 0, obj2, 0, position);
                    }
                    while (position < obj2.length) {
                        obj2[position] = com_google_android_gms_internal_zzfjj.zzcwn();
                        position++;
                    }
                    this.zzjmp = obj2;
                } else if (zzcvt == 16) {
                    zzcvt = zzfjv.zzb(com_google_android_gms_internal_zzfjj, 16);
                    position = this.zzjmq == null ? 0 : this.zzjmq.length;
                    obj = new long[(zzcvt + position)];
                    if (position != 0) {
                        System.arraycopy(this.zzjmq, 0, obj, 0, position);
                    }
                    while (position < obj.length - 1) {
                        obj[position] = com_google_android_gms_internal_zzfjj.zzcwn();
                        com_google_android_gms_internal_zzfjj.zzcvt();
                        position++;
                    }
                    obj[position] = com_google_android_gms_internal_zzfjj.zzcwn();
                    this.zzjmq = obj;
                } else if (zzcvt == 18) {
                    zzcvt = com_google_android_gms_internal_zzfjj.zzks(com_google_android_gms_internal_zzfjj.zzcwi());
                    position = com_google_android_gms_internal_zzfjj.getPosition();
                    i = 0;
                    while (com_google_android_gms_internal_zzfjj.zzcwk() > 0) {
                        com_google_android_gms_internal_zzfjj.zzcwn();
                        i++;
                    }
                    com_google_android_gms_internal_zzfjj.zzmg(position);
                    position = this.zzjmq == null ? 0 : this.zzjmq.length;
                    obj2 = new long[(i + position)];
                    if (position != 0) {
                        System.arraycopy(this.zzjmq, 0, obj2, 0, position);
                    }
                    while (position < obj2.length) {
                        obj2[position] = com_google_android_gms_internal_zzfjj.zzcwn();
                        position++;
                    }
                    this.zzjmq = obj2;
                } else if (!super.zza(com_google_android_gms_internal_zzfjj, zzcvt)) {
                    return this;
                }
                com_google_android_gms_internal_zzfjj.zzkt(zzcvt);
            } else {
                zzcvt = zzfjv.zzb(com_google_android_gms_internal_zzfjj, 8);
                position = this.zzjmp == null ? 0 : this.zzjmp.length;
                obj = new long[(zzcvt + position)];
                if (position != 0) {
                    System.arraycopy(this.zzjmp, 0, obj, 0, position);
                }
                while (position < obj.length - 1) {
                    obj[position] = com_google_android_gms_internal_zzfjj.zzcwn();
                    com_google_android_gms_internal_zzfjj.zzcvt();
                    position++;
                }
                obj[position] = com_google_android_gms_internal_zzfjj.zzcwn();
                this.zzjmp = obj;
            }
        }
    }

    public final void zza(zzfjk com_google_android_gms_internal_zzfjk) throws IOException {
        int i = 0;
        if (this.zzjmp != null && this.zzjmp.length > 0) {
            for (long zza : this.zzjmp) {
                com_google_android_gms_internal_zzfjk.zza(1, zza);
            }
        }
        if (this.zzjmq != null && this.zzjmq.length > 0) {
            while (i < this.zzjmq.length) {
                com_google_android_gms_internal_zzfjk.zza(2, this.zzjmq[i]);
                i++;
            }
        }
        super.zza(com_google_android_gms_internal_zzfjk);
    }

    protected final int zzq() {
        int i;
        int zzq = super.zzq();
        int i2 = 0;
        if (this.zzjmp != null && this.zzjmp.length > 0) {
            i = 0;
            int i3 = i;
            while (i < this.zzjmp.length) {
                i3 += zzfjk.zzdi(this.zzjmp[i]);
                i++;
            }
            zzq = (zzq + i3) + (this.zzjmp.length * 1);
        }
        if (this.zzjmq == null || this.zzjmq.length <= 0) {
            return zzq;
        }
        i = 0;
        while (i2 < this.zzjmq.length) {
            i += zzfjk.zzdi(this.zzjmq[i2]);
            i2++;
        }
        return (zzq + i) + (1 * this.zzjmq.length);
    }
}
