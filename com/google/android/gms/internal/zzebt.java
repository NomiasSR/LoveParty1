package com.google.android.gms.internal;

import java.util.Map;

final class zzebt implements zzebx {
    private /* synthetic */ String val$action;
    private /* synthetic */ zzebo zzmot;
    private /* synthetic */ zzece zzmow;
    private /* synthetic */ long zzmoy;
    private /* synthetic */ zzecc zzmoz;

    zzebt(zzebo com_google_android_gms_internal_zzebo, String str, long j, zzecc com_google_android_gms_internal_zzecc, zzece com_google_android_gms_internal_zzece) {
        this.zzmot = com_google_android_gms_internal_zzebo;
        this.val$action = str;
        this.zzmoy = j;
        this.zzmoz = com_google_android_gms_internal_zzecc;
        this.zzmow = com_google_android_gms_internal_zzece;
    }

    public final void zzaj(Map<String, Object> map) {
        if (this.zzmot.zzmlr.zzbzl()) {
            zzejc zza = this.zzmot.zzmlr;
            String str = this.val$action;
            String valueOf = String.valueOf(map);
            StringBuilder stringBuilder = new StringBuilder((11 + String.valueOf(str).length()) + String.valueOf(valueOf).length());
            stringBuilder.append(str);
            stringBuilder.append(" response: ");
            stringBuilder.append(valueOf);
            zza.zzb(stringBuilder.toString(), null, new Object[0]);
        }
        if (((zzecc) this.zzmot.zzmog.get(Long.valueOf(this.zzmoy))) == this.zzmoz) {
            this.zzmot.zzmog.remove(Long.valueOf(this.zzmoy));
            if (this.zzmow != null) {
                String str2 = (String) map.get("s");
                if (str2.equals("ok")) {
                    this.zzmow.zzbd(null, null);
                } else {
                    this.zzmow.zzbd(str2, (String) map.get("d"));
                }
            }
        } else if (this.zzmot.zzmlr.zzbzl()) {
            zzejc zza2 = this.zzmot.zzmlr;
            long j = this.zzmoy;
            StringBuilder stringBuilder2 = new StringBuilder(81);
            stringBuilder2.append("Ignoring on complete for put ");
            stringBuilder2.append(j);
            stringBuilder2.append(" because it was removed already.");
            zza2.zzb(stringBuilder2.toString(), null, new Object[0]);
        }
        this.zzmot.zzbur();
    }
}
