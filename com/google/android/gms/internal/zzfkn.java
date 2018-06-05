package com.google.android.gms.internal;

import java.io.IOException;

public final class zzfkn extends zzfjm<zzfkn> implements Cloneable {
    private String[] zzpqb;
    private String[] zzpqc;
    private int[] zzpqd;
    private long[] zzpqe;
    private long[] zzpqf;

    public zzfkn() {
        this.zzpqb = zzfjv.EMPTY_STRING_ARRAY;
        this.zzpqc = zzfjv.EMPTY_STRING_ARRAY;
        this.zzpqd = zzfjv.zzpnp;
        this.zzpqe = zzfjv.zzpnq;
        this.zzpqf = zzfjv.zzpnq;
        this.zzpnc = null;
        this.zzpfd = -1;
    }

    private zzfkn zzdaw() {
        try {
            zzfkn com_google_android_gms_internal_zzfkn = (zzfkn) super.zzdaf();
            if (this.zzpqb != null && this.zzpqb.length > 0) {
                com_google_android_gms_internal_zzfkn.zzpqb = (String[]) this.zzpqb.clone();
            }
            if (this.zzpqc != null && this.zzpqc.length > 0) {
                com_google_android_gms_internal_zzfkn.zzpqc = (String[]) this.zzpqc.clone();
            }
            if (this.zzpqd != null && this.zzpqd.length > 0) {
                com_google_android_gms_internal_zzfkn.zzpqd = (int[]) this.zzpqd.clone();
            }
            if (this.zzpqe != null && this.zzpqe.length > 0) {
                com_google_android_gms_internal_zzfkn.zzpqe = (long[]) this.zzpqe.clone();
            }
            if (this.zzpqf != null && this.zzpqf.length > 0) {
                com_google_android_gms_internal_zzfkn.zzpqf = (long[]) this.zzpqf.clone();
            }
            return com_google_android_gms_internal_zzfkn;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        return zzdaw();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzfkn)) {
            return false;
        }
        zzfkn com_google_android_gms_internal_zzfkn = (zzfkn) obj;
        if (!zzfjq.equals(this.zzpqb, com_google_android_gms_internal_zzfkn.zzpqb) || !zzfjq.equals(this.zzpqc, com_google_android_gms_internal_zzfkn.zzpqc) || !zzfjq.equals(this.zzpqd, com_google_android_gms_internal_zzfkn.zzpqd) || !zzfjq.equals(this.zzpqe, com_google_android_gms_internal_zzfkn.zzpqe) || !zzfjq.equals(this.zzpqf, com_google_android_gms_internal_zzfkn.zzpqf)) {
            return false;
        }
        if (this.zzpnc != null) {
            if (!this.zzpnc.isEmpty()) {
                return this.zzpnc.equals(com_google_android_gms_internal_zzfkn.zzpnc);
            }
        }
        return com_google_android_gms_internal_zzfkn.zzpnc == null || com_google_android_gms_internal_zzfkn.zzpnc.isEmpty();
    }

    public final int hashCode() {
        int hashCode;
        int hashCode2 = (((((((((((527 + getClass().getName().hashCode()) * 31) + zzfjq.hashCode(this.zzpqb)) * 31) + zzfjq.hashCode(this.zzpqc)) * 31) + zzfjq.hashCode(this.zzpqd)) * 31) + zzfjq.hashCode(this.zzpqe)) * 31) + zzfjq.hashCode(this.zzpqf)) * 31;
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
            int length;
            Object obj;
            if (zzcvt == 10) {
                zzcvt = zzfjv.zzb(com_google_android_gms_internal_zzfjj, 10);
                length = this.zzpqb == null ? 0 : this.zzpqb.length;
                obj = new String[(zzcvt + length)];
                if (length != 0) {
                    System.arraycopy(this.zzpqb, 0, obj, 0, length);
                }
                while (length < obj.length - 1) {
                    obj[length] = com_google_android_gms_internal_zzfjj.readString();
                    com_google_android_gms_internal_zzfjj.zzcvt();
                    length++;
                }
                obj[length] = com_google_android_gms_internal_zzfjj.readString();
                this.zzpqb = obj;
            } else if (zzcvt == 18) {
                zzcvt = zzfjv.zzb(com_google_android_gms_internal_zzfjj, 18);
                length = this.zzpqc == null ? 0 : this.zzpqc.length;
                obj = new String[(zzcvt + length)];
                if (length != 0) {
                    System.arraycopy(this.zzpqc, 0, obj, 0, length);
                }
                while (length < obj.length - 1) {
                    obj[length] = com_google_android_gms_internal_zzfjj.readString();
                    com_google_android_gms_internal_zzfjj.zzcvt();
                    length++;
                }
                obj[length] = com_google_android_gms_internal_zzfjj.readString();
                this.zzpqc = obj;
            } else if (zzcvt != 24) {
                int i;
                Object obj2;
                if (zzcvt == 26) {
                    zzcvt = com_google_android_gms_internal_zzfjj.zzks(com_google_android_gms_internal_zzfjj.zzcwi());
                    length = com_google_android_gms_internal_zzfjj.getPosition();
                    i = 0;
                    while (com_google_android_gms_internal_zzfjj.zzcwk() > 0) {
                        com_google_android_gms_internal_zzfjj.zzcvw();
                        i++;
                    }
                    com_google_android_gms_internal_zzfjj.zzmg(length);
                    length = this.zzpqd == null ? 0 : this.zzpqd.length;
                    obj2 = new int[(i + length)];
                    if (length != 0) {
                        System.arraycopy(this.zzpqd, 0, obj2, 0, length);
                    }
                    while (length < obj2.length) {
                        obj2[length] = com_google_android_gms_internal_zzfjj.zzcvw();
                        length++;
                    }
                    this.zzpqd = obj2;
                } else if (zzcvt == 32) {
                    zzcvt = zzfjv.zzb(com_google_android_gms_internal_zzfjj, 32);
                    length = this.zzpqe == null ? 0 : this.zzpqe.length;
                    obj = new long[(zzcvt + length)];
                    if (length != 0) {
                        System.arraycopy(this.zzpqe, 0, obj, 0, length);
                    }
                    while (length < obj.length - 1) {
                        obj[length] = com_google_android_gms_internal_zzfjj.zzcvv();
                        com_google_android_gms_internal_zzfjj.zzcvt();
                        length++;
                    }
                    obj[length] = com_google_android_gms_internal_zzfjj.zzcvv();
                    this.zzpqe = obj;
                } else if (zzcvt == 34) {
                    zzcvt = com_google_android_gms_internal_zzfjj.zzks(com_google_android_gms_internal_zzfjj.zzcwi());
                    length = com_google_android_gms_internal_zzfjj.getPosition();
                    i = 0;
                    while (com_google_android_gms_internal_zzfjj.zzcwk() > 0) {
                        com_google_android_gms_internal_zzfjj.zzcvv();
                        i++;
                    }
                    com_google_android_gms_internal_zzfjj.zzmg(length);
                    length = this.zzpqe == null ? 0 : this.zzpqe.length;
                    obj2 = new long[(i + length)];
                    if (length != 0) {
                        System.arraycopy(this.zzpqe, 0, obj2, 0, length);
                    }
                    while (length < obj2.length) {
                        obj2[length] = com_google_android_gms_internal_zzfjj.zzcvv();
                        length++;
                    }
                    this.zzpqe = obj2;
                } else if (zzcvt == 40) {
                    zzcvt = zzfjv.zzb(com_google_android_gms_internal_zzfjj, 40);
                    length = this.zzpqf == null ? 0 : this.zzpqf.length;
                    obj = new long[(zzcvt + length)];
                    if (length != 0) {
                        System.arraycopy(this.zzpqf, 0, obj, 0, length);
                    }
                    while (length < obj.length - 1) {
                        obj[length] = com_google_android_gms_internal_zzfjj.zzcvv();
                        com_google_android_gms_internal_zzfjj.zzcvt();
                        length++;
                    }
                    obj[length] = com_google_android_gms_internal_zzfjj.zzcvv();
                    this.zzpqf = obj;
                } else if (zzcvt == 42) {
                    zzcvt = com_google_android_gms_internal_zzfjj.zzks(com_google_android_gms_internal_zzfjj.zzcwi());
                    length = com_google_android_gms_internal_zzfjj.getPosition();
                    i = 0;
                    while (com_google_android_gms_internal_zzfjj.zzcwk() > 0) {
                        com_google_android_gms_internal_zzfjj.zzcvv();
                        i++;
                    }
                    com_google_android_gms_internal_zzfjj.zzmg(length);
                    length = this.zzpqf == null ? 0 : this.zzpqf.length;
                    obj2 = new long[(i + length)];
                    if (length != 0) {
                        System.arraycopy(this.zzpqf, 0, obj2, 0, length);
                    }
                    while (length < obj2.length) {
                        obj2[length] = com_google_android_gms_internal_zzfjj.zzcvv();
                        length++;
                    }
                    this.zzpqf = obj2;
                } else if (!super.zza(com_google_android_gms_internal_zzfjj, zzcvt)) {
                    return this;
                }
                com_google_android_gms_internal_zzfjj.zzkt(zzcvt);
            } else {
                zzcvt = zzfjv.zzb(com_google_android_gms_internal_zzfjj, 24);
                length = this.zzpqd == null ? 0 : this.zzpqd.length;
                obj = new int[(zzcvt + length)];
                if (length != 0) {
                    System.arraycopy(this.zzpqd, 0, obj, 0, length);
                }
                while (length < obj.length - 1) {
                    obj[length] = com_google_android_gms_internal_zzfjj.zzcvw();
                    com_google_android_gms_internal_zzfjj.zzcvt();
                    length++;
                }
                obj[length] = com_google_android_gms_internal_zzfjj.zzcvw();
                this.zzpqd = obj;
            }
        }
    }

    public final void zza(zzfjk com_google_android_gms_internal_zzfjk) throws IOException {
        int i = 0;
        if (this.zzpqb != null && this.zzpqb.length > 0) {
            for (String str : this.zzpqb) {
                if (str != null) {
                    com_google_android_gms_internal_zzfjk.zzn(1, str);
                }
            }
        }
        if (this.zzpqc != null && this.zzpqc.length > 0) {
            for (String str2 : this.zzpqc) {
                if (str2 != null) {
                    com_google_android_gms_internal_zzfjk.zzn(2, str2);
                }
            }
        }
        if (this.zzpqd != null && this.zzpqd.length > 0) {
            for (int zzaa : this.zzpqd) {
                com_google_android_gms_internal_zzfjk.zzaa(3, zzaa);
            }
        }
        if (this.zzpqe != null && this.zzpqe.length > 0) {
            for (long zzf : this.zzpqe) {
                com_google_android_gms_internal_zzfjk.zzf(4, zzf);
            }
        }
        if (this.zzpqf != null && this.zzpqf.length > 0) {
            while (i < this.zzpqf.length) {
                com_google_android_gms_internal_zzfjk.zzf(5, this.zzpqf[i]);
                i++;
            }
        }
        super.zza(com_google_android_gms_internal_zzfjk);
    }

    public final /* synthetic */ zzfjm zzdaf() throws CloneNotSupportedException {
        return (zzfkn) clone();
    }

    public final /* synthetic */ zzfjs zzdag() throws CloneNotSupportedException {
        return (zzfkn) clone();
    }

    protected final int zzq() {
        int i;
        int i2;
        int i3;
        String str;
        int zzq = super.zzq();
        int i4 = 0;
        if (this.zzpqb != null && this.zzpqb.length > 0) {
            i = 0;
            i2 = i;
            i3 = i2;
            while (i < this.zzpqb.length) {
                str = this.zzpqb[i];
                if (str != null) {
                    i3++;
                    i2 += zzfjk.zztt(str);
                }
                i++;
            }
            zzq = (zzq + i2) + (i3 * 1);
        }
        if (this.zzpqc != null && this.zzpqc.length > 0) {
            i = 0;
            i2 = i;
            i3 = i2;
            while (i < this.zzpqc.length) {
                str = this.zzpqc[i];
                if (str != null) {
                    i3++;
                    i2 += zzfjk.zztt(str);
                }
                i++;
            }
            zzq = (zzq + i2) + (i3 * 1);
        }
        if (this.zzpqd != null && this.zzpqd.length > 0) {
            i = 0;
            i2 = i;
            while (i < this.zzpqd.length) {
                i2 += zzfjk.zzlh(this.zzpqd[i]);
                i++;
            }
            zzq = (zzq + i2) + (this.zzpqd.length * 1);
        }
        if (this.zzpqe != null && this.zzpqe.length > 0) {
            i = 0;
            i2 = i;
            while (i < this.zzpqe.length) {
                i2 += zzfjk.zzdi(this.zzpqe[i]);
                i++;
            }
            zzq = (zzq + i2) + (this.zzpqe.length * 1);
        }
        if (this.zzpqf == null || this.zzpqf.length <= 0) {
            return zzq;
        }
        i = 0;
        while (i4 < this.zzpqf.length) {
            i += zzfjk.zzdi(this.zzpqf[i4]);
            i4++;
        }
        return (zzq + i) + (1 * this.zzpqf.length);
    }
}
