package com.google.android.gms.internal;

import com.google.android.gms.internal.zzffu.zzb;
import com.google.android.gms.internal.zzffu.zzg;
import com.google.android.gms.internal.zzffu.zzh;
import java.io.IOException;

public final class zzfep extends zzffu<zzfep, zza> implements zzfhg {
    private static volatile zzfhk<zzfep> zzbbk;
    private static final zzfep zzpff;
    private String zzlwa = "";
    private zzfes zzlwb = zzfes.zzpfg;

    public static final class zza extends com.google.android.gms.internal.zzffu.zza<zzfep, zza> implements zzfhg {
        private zza() {
            super(zzfep.zzpff);
        }
    }

    static {
        zzffu com_google_android_gms_internal_zzfep = new zzfep();
        zzpff = com_google_android_gms_internal_zzfep;
        com_google_android_gms_internal_zzfep.zza(zzg.zzphh, null, null);
        com_google_android_gms_internal_zzfep.zzpgr.zzbiy();
    }

    private zzfep() {
    }

    public static zzfep zzcvk() {
        return zzpff;
    }

    protected final Object zza(int i, Object obj, Object obj2) {
        boolean z = true;
        boolean z2;
        switch (zzfeq.zzbbi[i - 1]) {
            case 1:
                return new zzfep();
            case 2:
                return zzpff;
            case 3:
                return null;
            case 4:
                return new zza();
            case 5:
                zzh com_google_android_gms_internal_zzffu_zzh = (zzh) obj;
                zzfep com_google_android_gms_internal_zzfep = (zzfep) obj2;
                this.zzlwa = com_google_android_gms_internal_zzffu_zzh.zza(this.zzlwa.isEmpty() ^ true, this.zzlwa, com_google_android_gms_internal_zzfep.zzlwa.isEmpty() ^ true, com_google_android_gms_internal_zzfep.zzlwa);
                z2 = this.zzlwb != zzfes.zzpfg;
                zzfes com_google_android_gms_internal_zzfes = this.zzlwb;
                if (com_google_android_gms_internal_zzfep.zzlwb == zzfes.zzpfg) {
                    z = false;
                }
                this.zzlwb = com_google_android_gms_internal_zzffu_zzh.zza(z2, com_google_android_gms_internal_zzfes, z, com_google_android_gms_internal_zzfep.zzlwb);
                return this;
            case 6:
                zzffb com_google_android_gms_internal_zzffb = (zzffb) obj;
                if (((zzffm) obj2) != null) {
                    z2 = false;
                    while (!z2) {
                        try {
                            int zzcvt = com_google_android_gms_internal_zzffb.zzcvt();
                            if (zzcvt != 0) {
                                if (zzcvt == 10) {
                                    this.zzlwa = com_google_android_gms_internal_zzffb.zzcwa();
                                } else if (zzcvt != 18) {
                                    boolean z3;
                                    if ((zzcvt & 7) == 4) {
                                        z3 = false;
                                    } else {
                                        if (this.zzpgr == zzfio.zzczu()) {
                                            this.zzpgr = zzfio.zzczv();
                                        }
                                        z3 = this.zzpgr.zzb(zzcvt, com_google_android_gms_internal_zzffb);
                                    }
                                    if (z3) {
                                    }
                                } else {
                                    this.zzlwb = com_google_android_gms_internal_zzffb.zzcwb();
                                }
                            }
                            z2 = true;
                        } catch (zzfge e) {
                            throw new RuntimeException(e.zzi(this));
                        } catch (IOException e2) {
                            throw new RuntimeException(new zzfge(e2.getMessage()).zzi(this));
                        }
                    }
                    break;
                }
                throw new NullPointerException();
            case 7:
                break;
            case 8:
                if (zzbbk == null) {
                    synchronized (zzfep.class) {
                        if (zzbbk == null) {
                            zzbbk = new zzb(zzpff);
                        }
                    }
                }
                return zzbbk;
            case 9:
                return Byte.valueOf((byte) 1);
            case 10:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
        return zzpff;
    }

    public final void zza(zzffg com_google_android_gms_internal_zzffg) throws IOException {
        if (!this.zzlwa.isEmpty()) {
            com_google_android_gms_internal_zzffg.zzn(1, this.zzlwa);
        }
        if (!this.zzlwb.isEmpty()) {
            com_google_android_gms_internal_zzffg.zza(2, this.zzlwb);
        }
        this.zzpgr.zza(com_google_android_gms_internal_zzffg);
    }

    public final int zzho() {
        int i = this.zzpgs;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        if (!this.zzlwa.isEmpty()) {
            i2 = 0 + zzffg.zzo(1, this.zzlwa);
        }
        if (!this.zzlwb.isEmpty()) {
            i2 += zzffg.zzc(2, this.zzlwb);
        }
        i2 += this.zzpgr.zzho();
        this.zzpgs = i2;
        return i2;
    }
}
