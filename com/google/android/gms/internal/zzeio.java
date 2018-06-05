package com.google.android.gms.internal;

import java.util.Map;
import java.util.Map.Entry;

public final class zzeio {
    private static zzeix zznaz = new zzeip();
    private final zzeiw zznay;

    public zzeio(zzeiw com_google_android_gms_internal_zzeiw) {
        this.zznay = com_google_android_gms_internal_zzeiw;
    }

    private final zzein zza(zzein com_google_android_gms_internal_zzein, zzedk com_google_android_gms_internal_zzedk, zzecy com_google_android_gms_internal_zzecy, zzegj com_google_android_gms_internal_zzegj, zzekd com_google_android_gms_internal_zzekd, boolean z, zzeit com_google_android_gms_internal_zzeit) {
        if (com_google_android_gms_internal_zzein.zzbze().zzbsv().isEmpty() && !com_google_android_gms_internal_zzein.zzbze().zzbxz()) {
            return com_google_android_gms_internal_zzein;
        }
        zzecy zzb = com_google_android_gms_internal_zzedk.isEmpty() ? com_google_android_gms_internal_zzecy : zzecy.zzbvq().zzb(com_google_android_gms_internal_zzedk, com_google_android_gms_internal_zzecy);
        zzekd zzbsv = com_google_android_gms_internal_zzein.zzbze().zzbsv();
        Map zzbvt = zzb.zzbvt();
        zzein com_google_android_gms_internal_zzein2 = com_google_android_gms_internal_zzein;
        for (Entry entry : zzbvt.entrySet()) {
            zzejg com_google_android_gms_internal_zzejg = (zzejg) entry.getKey();
            if (zzbsv.zzk(com_google_android_gms_internal_zzejg)) {
                com_google_android_gms_internal_zzein2 = zza(com_google_android_gms_internal_zzein2, new zzedk(com_google_android_gms_internal_zzejg), ((zzecy) entry.getValue()).zzb(zzbsv.zzm(com_google_android_gms_internal_zzejg)), com_google_android_gms_internal_zzegj, com_google_android_gms_internal_zzekd, z, com_google_android_gms_internal_zzeit);
            }
        }
        zzein com_google_android_gms_internal_zzein3 = com_google_android_gms_internal_zzein2;
        for (Entry entry2 : zzbvt.entrySet()) {
            zzejg com_google_android_gms_internal_zzejg2 = (zzejg) entry2.getKey();
            int i = (com_google_android_gms_internal_zzein.zzbze().zzf(com_google_android_gms_internal_zzejg2) || ((zzecy) entry2.getValue()).zzbvr() != null) ? 0 : 1;
            if (!zzbsv.zzk(com_google_android_gms_internal_zzejg2) && i == 0) {
                com_google_android_gms_internal_zzein3 = zza(com_google_android_gms_internal_zzein3, new zzedk(com_google_android_gms_internal_zzejg2), ((zzecy) entry2.getValue()).zzb(zzbsv.zzm(com_google_android_gms_internal_zzejg2)), com_google_android_gms_internal_zzegj, com_google_android_gms_internal_zzekd, z, com_google_android_gms_internal_zzeit);
            }
        }
        return com_google_android_gms_internal_zzein3;
    }

    private final zzein zza(zzein com_google_android_gms_internal_zzein, zzedk com_google_android_gms_internal_zzedk, zzegj com_google_android_gms_internal_zzegj, zzeix com_google_android_gms_internal_zzeix, zzeit com_google_android_gms_internal_zzeit) {
        zzehx zzbzc = com_google_android_gms_internal_zzein.zzbzc();
        if (com_google_android_gms_internal_zzegj.zzu(com_google_android_gms_internal_zzedk) != null) {
            return com_google_android_gms_internal_zzein;
        }
        zzejw zza;
        boolean z;
        zzekd zzd;
        if (com_google_android_gms_internal_zzedk.isEmpty()) {
            if (com_google_android_gms_internal_zzein.zzbze().zzbya()) {
                zzekd zzbzf = com_google_android_gms_internal_zzein.zzbzf();
                if (!(zzbzf instanceof zzeji)) {
                    zzbzf = zzeju.zzcaf();
                }
                zzd = com_google_android_gms_internal_zzegj.zzd(zzbzf);
            } else {
                zzd = com_google_android_gms_internal_zzegj.zzc(com_google_android_gms_internal_zzein.zzbzf());
            }
            zza = this.zznay.zza(com_google_android_gms_internal_zzein.zzbzc().zzbyb(), zzejw.zza(zzd, this.zznay.zzbyr()), com_google_android_gms_internal_zzeit);
        } else {
            zzejg zzbwh = com_google_android_gms_internal_zzedk.zzbwh();
            if (zzbwh.zzbzr()) {
                zzd = com_google_android_gms_internal_zzegj.zza(com_google_android_gms_internal_zzedk, zzbzc.zzbsv(), com_google_android_gms_internal_zzein.zzbze().zzbsv());
                if (zzd != null) {
                    zza = this.zznay.zza(zzbzc.zzbyb(), zzd);
                }
            } else {
                zzedk zzbwi = com_google_android_gms_internal_zzedk.zzbwi();
                if (zzbzc.zzf(zzbwh)) {
                    zzd = com_google_android_gms_internal_zzegj.zza(com_google_android_gms_internal_zzedk, zzbzc.zzbsv(), com_google_android_gms_internal_zzein.zzbze().zzbsv());
                    zzd = zzd != null ? zzbzc.zzbsv().zzm(zzbwh).zzl(zzbwi, zzd) : zzbzc.zzbsv().zzm(zzbwh);
                } else {
                    zzd = com_google_android_gms_internal_zzegj.zza(zzbwh, com_google_android_gms_internal_zzein.zzbze());
                }
                zzekd com_google_android_gms_internal_zzekd = zzd;
                if (com_google_android_gms_internal_zzekd != null) {
                    zza = this.zznay.zza(zzbzc.zzbyb(), zzbwh, com_google_android_gms_internal_zzekd, zzbwi, com_google_android_gms_internal_zzeix, com_google_android_gms_internal_zzeit);
                }
            }
            zza = zzbzc.zzbyb();
        }
        if (!zzbzc.zzbxz()) {
            if (!com_google_android_gms_internal_zzedk.isEmpty()) {
                z = false;
                return com_google_android_gms_internal_zzein.zza(zza, z, this.zznay.zzbzi());
            }
        }
        z = true;
        return com_google_android_gms_internal_zzein.zza(zza, z, this.zznay.zzbzi());
    }

    private final zzein zza(zzein com_google_android_gms_internal_zzein, zzedk com_google_android_gms_internal_zzedk, zzekd com_google_android_gms_internal_zzekd, zzegj com_google_android_gms_internal_zzegj, zzekd com_google_android_gms_internal_zzekd2, zzeit com_google_android_gms_internal_zzeit) {
        zzejw zza;
        boolean z;
        boolean zzbya;
        zzehx zzbzc = com_google_android_gms_internal_zzein.zzbzc();
        zzeix com_google_android_gms_internal_zzeis = new zzeis(com_google_android_gms_internal_zzegj, com_google_android_gms_internal_zzein, com_google_android_gms_internal_zzekd2);
        if (com_google_android_gms_internal_zzedk.isEmpty()) {
            zza = this.zznay.zza(com_google_android_gms_internal_zzein.zzbzc().zzbyb(), zzejw.zza(com_google_android_gms_internal_zzekd, this.zznay.zzbyr()), com_google_android_gms_internal_zzeit);
            z = true;
        } else {
            zzejg zzbwh = com_google_android_gms_internal_zzedk.zzbwh();
            if (zzbwh.zzbzr()) {
                zza = this.zznay.zza(com_google_android_gms_internal_zzein.zzbzc().zzbyb(), com_google_android_gms_internal_zzekd);
                z = zzbzc.zzbxz();
                zzbya = zzbzc.zzbya();
                return com_google_android_gms_internal_zzein.zza(zza, z, zzbya);
            }
            zzekd com_google_android_gms_internal_zzekd3;
            zzedk zzbwi = com_google_android_gms_internal_zzedk.zzbwi();
            zzekd zzm = zzbzc.zzbsv().zzm(zzbwh);
            if (!zzbwi.isEmpty()) {
                zzekd zzh = com_google_android_gms_internal_zzeis.zzh(zzbwh);
                if (zzh == null) {
                    com_google_android_gms_internal_zzekd = zzeju.zzcaf();
                } else if (zzbwi.zzbwk().zzbzr() && zzh.zzan(zzbwi.zzbwj()).isEmpty()) {
                    com_google_android_gms_internal_zzekd3 = zzh;
                    if (!zzm.equals(com_google_android_gms_internal_zzekd3)) {
                        return com_google_android_gms_internal_zzein;
                    }
                    zza = this.zznay.zza(zzbzc.zzbyb(), zzbwh, com_google_android_gms_internal_zzekd3, zzbwi, com_google_android_gms_internal_zzeis, com_google_android_gms_internal_zzeit);
                    z = zzbzc.zzbxz();
                } else {
                    com_google_android_gms_internal_zzekd = zzh.zzl(zzbwi, com_google_android_gms_internal_zzekd);
                }
            }
            com_google_android_gms_internal_zzekd3 = com_google_android_gms_internal_zzekd;
            if (!zzm.equals(com_google_android_gms_internal_zzekd3)) {
                return com_google_android_gms_internal_zzein;
            }
            zza = this.zznay.zza(zzbzc.zzbyb(), zzbwh, com_google_android_gms_internal_zzekd3, zzbwi, com_google_android_gms_internal_zzeis, com_google_android_gms_internal_zzeit);
            z = zzbzc.zzbxz();
        }
        zzbya = this.zznay.zzbzi();
        return com_google_android_gms_internal_zzein.zza(zza, z, zzbya);
    }

    private final zzein zza(zzein com_google_android_gms_internal_zzein, zzedk com_google_android_gms_internal_zzedk, zzekd com_google_android_gms_internal_zzekd, zzegj com_google_android_gms_internal_zzegj, zzekd com_google_android_gms_internal_zzekd2, boolean z, zzeit com_google_android_gms_internal_zzeit) {
        zzejw zzbyb;
        zzejw zza;
        zzedk com_google_android_gms_internal_zzedk2;
        zzein zzb;
        zzegj com_google_android_gms_internal_zzegj2;
        zzeio com_google_android_gms_internal_zzeio = this;
        zzein com_google_android_gms_internal_zzein2 = com_google_android_gms_internal_zzein;
        zzekd com_google_android_gms_internal_zzekd3 = com_google_android_gms_internal_zzekd;
        zzehx zzbze = com_google_android_gms_internal_zzein2.zzbze();
        zzeiw zzbzh = z ? com_google_android_gms_internal_zzeio.zznay : com_google_android_gms_internal_zzeio.zznay.zzbzh();
        boolean z2 = true;
        if (com_google_android_gms_internal_zzedk.isEmpty()) {
            zzbyb = zzbze.zzbyb();
            zza = zzejw.zza(com_google_android_gms_internal_zzekd3, zzbzh.zzbyr());
        } else if (!zzbzh.zzbzi() || zzbze.zzbya()) {
            zzejg zzbwh = com_google_android_gms_internal_zzedk.zzbwh();
            com_google_android_gms_internal_zzedk2 = com_google_android_gms_internal_zzedk;
            if (!zzbze.zzal(com_google_android_gms_internal_zzedk2) && com_google_android_gms_internal_zzedk.size() > 1) {
                return com_google_android_gms_internal_zzein2;
            }
            zzedk zzbwi = com_google_android_gms_internal_zzedk.zzbwi();
            zzekd zzl = zzbze.zzbsv().zzm(zzbwh).zzl(zzbwi, com_google_android_gms_internal_zzekd3);
            zza = zzbwh.zzbzr() ? zzbzh.zza(zzbze.zzbyb(), zzl) : zzbzh.zza(zzbze.zzbyb(), zzbwh, zzl, zzbwi, zznaz, null);
            if (!zzbze.zzbxz()) {
                if (com_google_android_gms_internal_zzedk.isEmpty()) {
                    z2 = false;
                }
            }
            zzb = com_google_android_gms_internal_zzein2.zzb(zza, z2, zzbzh.zzbzi());
            com_google_android_gms_internal_zzegj2 = com_google_android_gms_internal_zzegj;
            return zza(zzb, com_google_android_gms_internal_zzedk2, com_google_android_gms_internal_zzegj2, new zzeis(com_google_android_gms_internal_zzegj2, zzb, com_google_android_gms_internal_zzekd2), com_google_android_gms_internal_zzeit);
        } else {
            zzejg zzbwh2 = com_google_android_gms_internal_zzedk.zzbwh();
            zza = zzbze.zzbyb().zzg(zzbwh2, zzbze.zzbsv().zzm(zzbwh2).zzl(com_google_android_gms_internal_zzedk.zzbwi(), com_google_android_gms_internal_zzekd3));
            zzbyb = zzbze.zzbyb();
        }
        zza = zzbzh.zza(zzbyb, zza, null);
        com_google_android_gms_internal_zzedk2 = com_google_android_gms_internal_zzedk;
        if (zzbze.zzbxz()) {
            if (com_google_android_gms_internal_zzedk.isEmpty()) {
                z2 = false;
            }
        }
        zzb = com_google_android_gms_internal_zzein2.zzb(zza, z2, zzbzh.zzbzi());
        com_google_android_gms_internal_zzegj2 = com_google_android_gms_internal_zzegj;
        return zza(zzb, com_google_android_gms_internal_zzedk2, com_google_android_gms_internal_zzegj2, new zzeis(com_google_android_gms_internal_zzegj2, zzb, com_google_android_gms_internal_zzekd2), com_google_android_gms_internal_zzeit);
    }

    private static boolean zza(zzein com_google_android_gms_internal_zzein, zzejg com_google_android_gms_internal_zzejg) {
        return com_google_android_gms_internal_zzein.zzbzc().zzf(com_google_android_gms_internal_zzejg);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.zzeir zza(com.google.android.gms.internal.zzein r18, com.google.android.gms.internal.zzego r19, com.google.android.gms.internal.zzegj r20, com.google.android.gms.internal.zzekd r21) {
        /*
        r17 = this;
        r8 = r17;
        r9 = r18;
        r7 = r20;
        r10 = new com.google.android.gms.internal.zzeit;
        r10.<init>();
        r1 = com.google.android.gms.internal.zzeiq.zznba;
        r2 = r19.zzbxk();
        r2 = r2.ordinal();
        r1 = r1[r2];
        r11 = 1;
        r12 = 0;
        switch(r1) {
            case 1: goto L_0x02cd;
            case 2: goto L_0x0217;
            case 3: goto L_0x0075;
            case 4: goto L_0x0046;
            default: goto L_0x001c;
        };
    L_0x001c:
        r1 = new java.lang.AssertionError;
        r0 = r19.zzbxk();
        r0 = java.lang.String.valueOf(r0);
        r2 = 19;
        r3 = java.lang.String.valueOf(r0);
        r3 = r3.length();
        r2 = r2 + r3;
        r3 = new java.lang.StringBuilder;
        r3.<init>(r2);
        r2 = "Unknown operation: ";
        r3.append(r2);
        r3.append(r0);
        r0 = r3.toString();
        r1.<init>(r0);
        throw r1;
    L_0x0046:
        r2 = r19.zzbsy();
        r0 = r18.zzbze();
        r1 = r0.zzbyb();
        r3 = r0.zzbxz();
        if (r3 != 0) goto L_0x0061;
    L_0x0058:
        r3 = r2.isEmpty();
        if (r3 == 0) goto L_0x005f;
    L_0x005e:
        goto L_0x0061;
    L_0x005f:
        r3 = r12;
        goto L_0x0062;
    L_0x0061:
        r3 = r11;
    L_0x0062:
        r0 = r0.zzbya();
        r1 = r9.zzb(r1, r3, r0);
        r4 = zznaz;
        r0 = r8;
        r3 = r7;
        r5 = r10;
        r0 = r0.zza(r1, r2, r3, r4, r5);
        goto L_0x0322;
    L_0x0075:
        r0 = r19;
        r0 = (com.google.android.gms.internal.zzegl) r0;
        r1 = r0.zzbxh();
        if (r1 != 0) goto L_0x0128;
    L_0x007f:
        r2 = r0.zzbsy();
        r0 = r0.zzbxg();
        r1 = r7.zzu(r2);
        if (r1 == 0) goto L_0x008e;
    L_0x008d:
        goto L_0x00ed;
    L_0x008e:
        r1 = r18.zzbze();
        r6 = r1.zzbya();
        r1 = r18.zzbze();
        r3 = r0.getValue();
        if (r3 == 0) goto L_0x00f0;
    L_0x00a0:
        r0 = r2.isEmpty();
        if (r0 == 0) goto L_0x00ac;
    L_0x00a6:
        r0 = r1.zzbxz();
        if (r0 != 0) goto L_0x00b2;
    L_0x00ac:
        r0 = r1.zzal(r2);
        if (r0 == 0) goto L_0x00c1;
    L_0x00b2:
        r0 = r1.zzbsv();
        r3 = r0.zzan(r2);
        r0 = r8;
        r1 = r9;
        r4 = r7;
        r5 = r21;
        goto L_0x031d;
    L_0x00c1:
        r0 = r2.isEmpty();
        if (r0 == 0) goto L_0x00ed;
    L_0x00c7:
        r0 = com.google.android.gms.internal.zzecy.zzbvq();
        r1 = r1.zzbsv();
        r1 = r1.iterator();
        r3 = r0;
    L_0x00d4:
        r0 = r1.hasNext();
        if (r0 == 0) goto L_0x0121;
    L_0x00da:
        r0 = r1.next();
        r0 = (com.google.android.gms.internal.zzekc) r0;
        r4 = r0.zzcao();
        r0 = r0.zzbsv();
        r3 = r3.zza(r4, r0);
        goto L_0x00d4;
    L_0x00ed:
        r0 = r9;
        goto L_0x0322;
    L_0x00f0:
        r3 = com.google.android.gms.internal.zzecy.zzbvq();
        r0 = r0.iterator();
    L_0x00f8:
        r4 = r0.hasNext();
        if (r4 == 0) goto L_0x0121;
    L_0x00fe:
        r4 = r0.next();
        r4 = (java.util.Map.Entry) r4;
        r4 = r4.getKey();
        r4 = (com.google.android.gms.internal.zzedk) r4;
        r5 = r2.zzh(r4);
        r13 = r1.zzal(r5);
        if (r13 == 0) goto L_0x00f8;
    L_0x0114:
        r13 = r1.zzbsv();
        r5 = r13.zzan(r5);
        r3 = r3.zze(r4, r5);
        goto L_0x00f8;
    L_0x0121:
        r0 = r8;
        r1 = r9;
        r4 = r7;
        r5 = r21;
        goto L_0x02c7;
    L_0x0128:
        r0 = r0.zzbsy();
        r1 = r7.zzu(r0);
        if (r1 == 0) goto L_0x0133;
    L_0x0132:
        goto L_0x00ed;
    L_0x0133:
        r5 = new com.google.android.gms.internal.zzeis;
        r13 = r21;
        r5.<init>(r7, r9, r13);
        r1 = r18.zzbzc();
        r1 = r1.zzbyb();
        r2 = r0.isEmpty();
        if (r2 != 0) goto L_0x01c4;
    L_0x0148:
        r2 = r0.zzbwh();
        r2 = r2.zzbzr();
        if (r2 == 0) goto L_0x0154;
    L_0x0152:
        goto L_0x01c4;
    L_0x0154:
        r2 = r0.zzbwh();
        r3 = r18.zzbze();
        r3 = r7.zza(r2, r3);
        if (r3 != 0) goto L_0x0174;
    L_0x0162:
        r4 = r18.zzbze();
        r4 = r4.zzf(r2);
        if (r4 == 0) goto L_0x0174;
    L_0x016c:
        r3 = r1.zzbsv();
        r3 = r3.zzm(r2);
    L_0x0174:
        if (r3 == 0) goto L_0x0184;
    L_0x0176:
        r4 = r8.zznay;
        r6 = r0.zzbwi();
        r0 = r4;
    L_0x017d:
        r4 = r6;
        r6 = r10;
        r1 = r0.zza(r1, r2, r3, r4, r5, r6);
        goto L_0x01a1;
    L_0x0184:
        if (r3 != 0) goto L_0x01a1;
    L_0x0186:
        r3 = r18.zzbzc();
        r3 = r3.zzbsv();
        r3 = r3.zzk(r2);
        if (r3 == 0) goto L_0x01a1;
    L_0x0194:
        r3 = r8.zznay;
        r4 = com.google.android.gms.internal.zzeju.zzcaf();
        r6 = r0.zzbwi();
        r0 = r3;
        r3 = r4;
        goto L_0x017d;
    L_0x01a1:
        r0 = r1.zzbsv();
        r0 = r0.isEmpty();
        if (r0 == 0) goto L_0x01f3;
    L_0x01ab:
        r0 = r18.zzbze();
        r0 = r0.zzbxz();
        if (r0 == 0) goto L_0x01f3;
    L_0x01b5:
        r0 = r18.zzbzf();
        r0 = r7.zzc(r0);
        r2 = r0.zzbzu();
        if (r2 == 0) goto L_0x01f3;
    L_0x01c3:
        goto L_0x01e3;
    L_0x01c4:
        r0 = r18.zzbze();
        r0 = r0.zzbxz();
        if (r0 == 0) goto L_0x01d7;
    L_0x01ce:
        r0 = r18.zzbzf();
        r0 = r7.zzc(r0);
        goto L_0x01e3;
    L_0x01d7:
        r0 = r18.zzbze();
        r0 = r0.zzbsv();
        r0 = r7.zzd(r0);
    L_0x01e3:
        r2 = r8.zznay;
        r2 = r2.zzbyr();
        r0 = com.google.android.gms.internal.zzejw.zza(r0, r2);
        r2 = r8.zznay;
        r1 = r2.zza(r1, r0, r10);
    L_0x01f3:
        r0 = r18.zzbze();
        r0 = r0.zzbxz();
        if (r0 != 0) goto L_0x020a;
    L_0x01fd:
        r0 = com.google.android.gms.internal.zzedk.zzbwe();
        r0 = r7.zzu(r0);
        if (r0 == 0) goto L_0x0208;
    L_0x0207:
        goto L_0x020a;
    L_0x0208:
        r0 = r12;
        goto L_0x020b;
    L_0x020a:
        r0 = r11;
    L_0x020b:
        r2 = r8.zznay;
        r2 = r2.zzbzi();
        r0 = r9.zza(r1, r0, r2);
        goto L_0x0322;
    L_0x0217:
        r13 = r21;
        r0 = r19;
        r0 = (com.google.android.gms.internal.zzegn) r0;
        r1 = r0.zzbxj();
        r1 = r1.zzbxl();
        if (r1 == 0) goto L_0x02a3;
    L_0x0227:
        r14 = r0.zzbsy();
        r15 = r0.zzbxi();
        r6 = r15.iterator();
        r1 = r9;
    L_0x0234:
        r0 = r6.hasNext();
        if (r0 == 0) goto L_0x026c;
    L_0x023a:
        r0 = r6.next();
        r0 = (java.util.Map.Entry) r0;
        r2 = r0.getKey();
        r2 = (com.google.android.gms.internal.zzedk) r2;
        r2 = r14.zzh(r2);
        r3 = r2.zzbwh();
        r3 = zza(r9, r3);
        if (r3 == 0) goto L_0x0267;
    L_0x0254:
        r0 = r0.getValue();
        r3 = r0;
        r3 = (com.google.android.gms.internal.zzekd) r3;
        r0 = r8;
        r4 = r7;
        r5 = r13;
        r16 = r6;
        r6 = r10;
        r0 = r0.zza(r1, r2, r3, r4, r5, r6);
        r1 = r0;
        goto L_0x0269;
    L_0x0267:
        r16 = r6;
    L_0x0269:
        r6 = r16;
        goto L_0x0234;
    L_0x026c:
        r15 = r15.iterator();
    L_0x0270:
        r0 = r15.hasNext();
        if (r0 == 0) goto L_0x02a0;
    L_0x0276:
        r0 = r15.next();
        r0 = (java.util.Map.Entry) r0;
        r2 = r0.getKey();
        r2 = (com.google.android.gms.internal.zzedk) r2;
        r2 = r14.zzh(r2);
        r3 = r2.zzbwh();
        r3 = zza(r9, r3);
        if (r3 != 0) goto L_0x0270;
    L_0x0290:
        r0 = r0.getValue();
        r3 = r0;
        r3 = (com.google.android.gms.internal.zzekd) r3;
        r0 = r8;
        r4 = r7;
        r5 = r13;
        r6 = r10;
        r1 = r0.zza(r1, r2, r3, r4, r5, r6);
        goto L_0x0270;
    L_0x02a0:
        r0 = r1;
        goto L_0x0322;
    L_0x02a3:
        r1 = r0.zzbxj();
        r1 = r1.zzbxm();
        if (r1 != 0) goto L_0x02ba;
    L_0x02ad:
        r1 = r18.zzbze();
        r1 = r1.zzbya();
        if (r1 == 0) goto L_0x02b8;
    L_0x02b7:
        goto L_0x02ba;
    L_0x02b8:
        r6 = r12;
        goto L_0x02bb;
    L_0x02ba:
        r6 = r11;
    L_0x02bb:
        r2 = r0.zzbsy();
        r3 = r0.zzbxi();
        r0 = r8;
        r1 = r9;
        r4 = r7;
        r5 = r13;
    L_0x02c7:
        r7 = r10;
        r0 = r0.zza(r1, r2, r3, r4, r5, r6, r7);
        goto L_0x0322;
    L_0x02cd:
        r13 = r21;
        r0 = r19;
        r0 = (com.google.android.gms.internal.zzegs) r0;
        r1 = r0.zzbxj();
        r1 = r1.zzbxl();
        if (r1 == 0) goto L_0x02ef;
    L_0x02dd:
        r2 = r0.zzbsy();
        r3 = r0.zzbxo();
        r0 = r8;
        r1 = r9;
        r4 = r7;
        r5 = r13;
        r6 = r10;
        r0 = r0.zza(r1, r2, r3, r4, r5, r6);
        goto L_0x0322;
    L_0x02ef:
        r1 = r0.zzbxj();
        r1 = r1.zzbxm();
        if (r1 != 0) goto L_0x0310;
    L_0x02f9:
        r1 = r18.zzbze();
        r1 = r1.zzbya();
        if (r1 == 0) goto L_0x030e;
    L_0x0303:
        r1 = r0.zzbsy();
        r1 = r1.isEmpty();
        if (r1 != 0) goto L_0x030e;
    L_0x030d:
        goto L_0x0310;
    L_0x030e:
        r6 = r12;
        goto L_0x0311;
    L_0x0310:
        r6 = r11;
    L_0x0311:
        r2 = r0.zzbsy();
        r3 = r0.zzbxo();
        r0 = r8;
        r1 = r9;
        r4 = r7;
        r5 = r13;
    L_0x031d:
        r7 = r10;
        r0 = r0.zza(r1, r2, r3, r4, r5, r6, r7);
    L_0x0322:
        r1 = new java.util.ArrayList;
        r2 = r10.zzbzg();
        r1.<init>(r2);
        r2 = r0.zzbzc();
        r3 = r2.zzbxz();
        if (r3 == 0) goto L_0x038c;
    L_0x0335:
        r3 = r2.zzbsv();
        r3 = r3.zzbzu();
        if (r3 != 0) goto L_0x034b;
    L_0x033f:
        r3 = r2.zzbsv();
        r3 = r3.isEmpty();
        if (r3 == 0) goto L_0x034a;
    L_0x0349:
        goto L_0x034b;
    L_0x034a:
        r11 = r12;
    L_0x034b:
        r3 = r1.isEmpty();
        if (r3 == 0) goto L_0x0381;
    L_0x0351:
        r3 = r18.zzbzc();
        r3 = r3.zzbxz();
        if (r3 == 0) goto L_0x0381;
    L_0x035b:
        if (r11 == 0) goto L_0x036b;
    L_0x035d:
        r3 = r2.zzbsv();
        r4 = r18.zzbzd();
        r3 = r3.equals(r4);
        if (r3 == 0) goto L_0x0381;
    L_0x036b:
        r3 = r2.zzbsv();
        r3 = r3.zzbzv();
        r4 = r18.zzbzd();
        r4 = r4.zzbzv();
        r3 = r3.equals(r4);
        if (r3 != 0) goto L_0x038c;
    L_0x0381:
        r2 = r2.zzbyb();
        r2 = com.google.android.gms.internal.zzehz.zza(r2);
        r1.add(r2);
    L_0x038c:
        r2 = new com.google.android.gms.internal.zzeir;
        r2.<init>(r0, r1);
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzeio.zza(com.google.android.gms.internal.zzein, com.google.android.gms.internal.zzego, com.google.android.gms.internal.zzegj, com.google.android.gms.internal.zzekd):com.google.android.gms.internal.zzeir");
    }
}
