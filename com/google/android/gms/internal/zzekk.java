package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

public final class zzekk {
    private final zzedk zzndh;
    private final zzedk zzndi;
    private final zzekd zzndj;

    public zzekk(zzecd com_google_android_gms_internal_zzecd) {
        List zzbva = com_google_android_gms_internal_zzecd.zzbva();
        zzedk com_google_android_gms_internal_zzedk = null;
        this.zzndh = zzbva != null ? new zzedk(zzbva) : null;
        zzbva = com_google_android_gms_internal_zzecd.zzbvb();
        if (zzbva != null) {
            com_google_android_gms_internal_zzedk = new zzedk(zzbva);
        }
        this.zzndi = com_google_android_gms_internal_zzedk;
        this.zzndj = zzekg.zza(com_google_android_gms_internal_zzecd.zzbvc(), zzeju.zzcaf());
    }

    private final zzekd zzb(zzedk com_google_android_gms_internal_zzedk, zzekd com_google_android_gms_internal_zzekd, zzekd com_google_android_gms_internal_zzekd2) {
        int zzj = this.zzndh == null ? 1 : com_google_android_gms_internal_zzedk.zzj(this.zzndh);
        int zzj2 = this.zzndi == null ? -1 : com_google_android_gms_internal_zzedk.zzj(this.zzndi);
        int i = 0;
        int i2 = (this.zzndh == null || !com_google_android_gms_internal_zzedk.zzi(this.zzndh)) ? 0 : 1;
        int i3 = (this.zzndi == null || !com_google_android_gms_internal_zzedk.zzi(this.zzndi)) ? 0 : 1;
        if (zzj > 0 && zzj2 < 0 && i3 == 0) {
            return com_google_android_gms_internal_zzekd2;
        }
        if (zzj > 0 && i3 != 0 && com_google_android_gms_internal_zzekd2.zzbzu()) {
            return com_google_android_gms_internal_zzekd2;
        }
        if (zzj > 0 && zzj2 == 0) {
            return com_google_android_gms_internal_zzekd.zzbzu() ? zzeju.zzcaf() : com_google_android_gms_internal_zzekd;
        } else {
            if (i2 == 0) {
                if (i3 == 0) {
                    return com_google_android_gms_internal_zzekd;
                }
            }
            Collection hashSet = new HashSet();
            for (zzekc zzcao : com_google_android_gms_internal_zzekd) {
                hashSet.add(zzcao.zzcao());
            }
            for (zzekc zzcao2 : com_google_android_gms_internal_zzekd2) {
                hashSet.add(zzcao2.zzcao());
            }
            List arrayList = new ArrayList(hashSet.size() + 1);
            arrayList.addAll(hashSet);
            if (!(com_google_android_gms_internal_zzekd2.zzbzv().isEmpty() && com_google_android_gms_internal_zzekd.zzbzv().isEmpty())) {
                arrayList.add(zzejg.zzbzp());
            }
            ArrayList arrayList2 = (ArrayList) arrayList;
            zzj = arrayList2.size();
            zzekd com_google_android_gms_internal_zzekd3 = com_google_android_gms_internal_zzekd;
            while (i < zzj) {
                Object obj = arrayList2.get(i);
                i++;
                zzejg com_google_android_gms_internal_zzejg = (zzejg) obj;
                zzekd zzm = com_google_android_gms_internal_zzekd.zzm(com_google_android_gms_internal_zzejg);
                zzekd zzb = zzb(com_google_android_gms_internal_zzedk.zza(com_google_android_gms_internal_zzejg), com_google_android_gms_internal_zzekd.zzm(com_google_android_gms_internal_zzejg), com_google_android_gms_internal_zzekd2.zzm(com_google_android_gms_internal_zzejg));
                if (zzb != zzm) {
                    com_google_android_gms_internal_zzekd3 = com_google_android_gms_internal_zzekd3.zze(com_google_android_gms_internal_zzejg, zzb);
                }
            }
            return com_google_android_gms_internal_zzekd3;
        }
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zzndh);
        String valueOf2 = String.valueOf(this.zzndi);
        String valueOf3 = String.valueOf(this.zzndj);
        StringBuilder stringBuilder = new StringBuilder(((55 + String.valueOf(valueOf).length()) + String.valueOf(valueOf2).length()) + String.valueOf(valueOf3).length());
        stringBuilder.append("RangeMerge{optExclusiveStart=");
        stringBuilder.append(valueOf);
        stringBuilder.append(", optInclusiveEnd=");
        stringBuilder.append(valueOf2);
        stringBuilder.append(", snap=");
        stringBuilder.append(valueOf3);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public final zzekd zzm(zzekd com_google_android_gms_internal_zzekd) {
        return zzb(zzedk.zzbwe(), com_google_android_gms_internal_zzekd, this.zzndj);
    }
}
