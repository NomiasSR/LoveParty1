package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class zzehf {
    private static final zzehq<Map<zzeih, zzehe>> zzmyp = new zzehg();
    private static final zzehq<Map<zzeih, zzehe>> zzmyq = new zzehh();
    private static final zzehq<zzehe> zzmyr = new zzehi();
    private static final zzehq<zzehe> zzmys = new zzehj();
    private final zzejc zzmlr;
    private final zzegz zzmyc;
    private zzehm<Map<zzeih, zzehe>> zzmyt;
    private final zzeli zzmyu;
    private long zzmyv = 0;

    public zzehf(zzegz com_google_android_gms_internal_zzegz, zzejc com_google_android_gms_internal_zzejc, zzeli com_google_android_gms_internal_zzeli) {
        this.zzmyc = com_google_android_gms_internal_zzegz;
        this.zzmlr = com_google_android_gms_internal_zzejc;
        this.zzmyu = com_google_android_gms_internal_zzeli;
        this.zzmyt = new zzehm(null);
        try {
            this.zzmyc.beginTransaction();
            this.zzmyc.zzbn(this.zzmyu.millis());
            this.zzmyc.setTransactionSuccessful();
            for (zzehe com_google_android_gms_internal_zzehe : this.zzmyc.zzbtd()) {
                this.zzmyv = Math.max(com_google_android_gms_internal_zzehe.id + 1, this.zzmyv);
                zzb(com_google_android_gms_internal_zzehe);
            }
        } finally {
            this.zzmyc.endTransaction();
        }
    }

    private final List<zzehe> zza(zzehq<zzehe> com_google_android_gms_internal_zzehq_com_google_android_gms_internal_zzehe) {
        List<zzehe> arrayList = new ArrayList();
        Iterator it = this.zzmyt.iterator();
        while (it.hasNext()) {
            for (zzehe com_google_android_gms_internal_zzehe : ((Map) ((Entry) it.next()).getValue()).values()) {
                if (com_google_android_gms_internal_zzehq_com_google_android_gms_internal_zzehe.zzbs(com_google_android_gms_internal_zzehe)) {
                    arrayList.add(com_google_android_gms_internal_zzehe);
                }
            }
        }
        return arrayList;
    }

    private final void zza(zzehe com_google_android_gms_internal_zzehe) {
        zzb(com_google_android_gms_internal_zzehe);
        this.zzmyc.zza(com_google_android_gms_internal_zzehe);
    }

    private final boolean zzad(zzedk com_google_android_gms_internal_zzedk) {
        return this.zzmyt.zza(com_google_android_gms_internal_zzedk, zzmyp) != null;
    }

    private final Set<Long> zzae(zzedk com_google_android_gms_internal_zzedk) {
        Set<Long> hashSet = new HashSet();
        Map map = (Map) this.zzmyt.zzaj(com_google_android_gms_internal_zzedk);
        if (map != null) {
            for (zzehe com_google_android_gms_internal_zzehe : map.values()) {
                if (!com_google_android_gms_internal_zzehe.zzmyn.zzbyv()) {
                    hashSet.add(Long.valueOf(com_google_android_gms_internal_zzehe.id));
                }
            }
        }
        return hashSet;
    }

    private final void zzb(zzehe com_google_android_gms_internal_zzehe) {
        boolean z;
        Map map;
        zzehe com_google_android_gms_internal_zzehe2;
        zzeik com_google_android_gms_internal_zzeik = com_google_android_gms_internal_zzehe.zzmyn;
        boolean z2 = true;
        if (com_google_android_gms_internal_zzeik.zzbyv()) {
            if (!com_google_android_gms_internal_zzeik.isDefault()) {
                z = false;
                zzelt.zzb(z, "Can't have tracked non-default query that loads all data");
                map = (Map) this.zzmyt.zzaj(com_google_android_gms_internal_zzehe.zzmyn.zzbsy());
                if (map == null) {
                    map = new HashMap();
                    this.zzmyt = this.zzmyt.zzb(com_google_android_gms_internal_zzehe.zzmyn.zzbsy(), (Object) map);
                }
                com_google_android_gms_internal_zzehe2 = (zzehe) map.get(com_google_android_gms_internal_zzehe.zzmyn.zzbyy());
                if (com_google_android_gms_internal_zzehe2 != null) {
                    if (com_google_android_gms_internal_zzehe2.id == com_google_android_gms_internal_zzehe.id) {
                        z2 = false;
                    }
                }
                zzelt.zzcp(z2);
                map.put(com_google_android_gms_internal_zzehe.zzmyn.zzbyy(), com_google_android_gms_internal_zzehe);
            }
        }
        z = true;
        zzelt.zzb(z, "Can't have tracked non-default query that loads all data");
        map = (Map) this.zzmyt.zzaj(com_google_android_gms_internal_zzehe.zzmyn.zzbsy());
        if (map == null) {
            map = new HashMap();
            this.zzmyt = this.zzmyt.zzb(com_google_android_gms_internal_zzehe.zzmyn.zzbsy(), (Object) map);
        }
        com_google_android_gms_internal_zzehe2 = (zzehe) map.get(com_google_android_gms_internal_zzehe.zzmyn.zzbyy());
        if (com_google_android_gms_internal_zzehe2 != null) {
            if (com_google_android_gms_internal_zzehe2.id == com_google_android_gms_internal_zzehe.id) {
                z2 = false;
            }
        }
        zzelt.zzcp(z2);
        map.put(com_google_android_gms_internal_zzehe.zzmyn.zzbyy(), com_google_android_gms_internal_zzehe);
    }

    private final void zzb(zzeik com_google_android_gms_internal_zzeik, boolean z) {
        zzehe com_google_android_gms_internal_zzehe;
        zzeik zzj = zzj(com_google_android_gms_internal_zzeik);
        zzehe zzk = zzk(zzj);
        long millis = this.zzmyu.millis();
        if (zzk != null) {
            zzehe com_google_android_gms_internal_zzehe2 = new zzehe(zzk.id, zzk.zzmyn, millis, zzk.complete, zzk.zziyi);
            com_google_android_gms_internal_zzehe = new zzehe(com_google_android_gms_internal_zzehe2.id, com_google_android_gms_internal_zzehe2.zzmyn, com_google_android_gms_internal_zzehe2.zzmyo, com_google_android_gms_internal_zzehe2.complete, z);
        } else {
            long j = r0.zzmyv;
            r0.zzmyv = 1 + j;
            zzk = new zzehe(j, zzj, millis, false, z);
        }
        zza(com_google_android_gms_internal_zzehe);
    }

    private static zzeik zzj(zzeik com_google_android_gms_internal_zzeik) {
        return com_google_android_gms_internal_zzeik.zzbyv() ? zzeik.zzam(com_google_android_gms_internal_zzeik.zzbsy()) : com_google_android_gms_internal_zzeik;
    }

    public final zzeha zza(zzegt com_google_android_gms_internal_zzegt) {
        int i;
        List zza = zza(zzmyr);
        long size = (long) zza.size();
        size -= Math.min((long) Math.floor((double) (((float) size) * (1.0f - com_google_android_gms_internal_zzegt.zzbxp()))), com_google_android_gms_internal_zzegt.zzbxq());
        zzeha com_google_android_gms_internal_zzeha = new zzeha();
        if (this.zzmlr.zzbzl()) {
            zzejc com_google_android_gms_internal_zzejc = this.zzmlr;
            int size2 = zza.size();
            StringBuilder stringBuilder = new StringBuilder(80);
            stringBuilder.append("Pruning old queries.  Prunable: ");
            stringBuilder.append(size2);
            stringBuilder.append(" Count to prune: ");
            stringBuilder.append(size);
            com_google_android_gms_internal_zzejc.zzb(stringBuilder.toString(), null, new Object[0]);
        }
        Collections.sort(zza, new zzehl(this));
        zzeha com_google_android_gms_internal_zzeha2 = com_google_android_gms_internal_zzeha;
        for (i = 0; ((long) i) < size; i++) {
            zzehe com_google_android_gms_internal_zzehe = (zzehe) zza.get(i);
            com_google_android_gms_internal_zzeha2 = com_google_android_gms_internal_zzeha2.zzx(com_google_android_gms_internal_zzehe.zzmyn.zzbsy());
            zzeik zzj = zzj(com_google_android_gms_internal_zzehe.zzmyn);
            this.zzmyc.zzbm(zzk(zzj).id);
            Map map = (Map) this.zzmyt.zzaj(zzj.zzbsy());
            map.remove(zzj.zzbyy());
            if (map.isEmpty()) {
                this.zzmyt = this.zzmyt.zzai(zzj.zzbsy());
            }
        }
        for (i = (int) size; i < zza.size(); i++) {
            com_google_android_gms_internal_zzeha2 = com_google_android_gms_internal_zzeha2.zzy(((zzehe) zza.get(i)).zzmyn.zzbsy());
        }
        List<zzehe> zza2 = zza(zzmys);
        if (this.zzmlr.zzbzl()) {
            zzejc com_google_android_gms_internal_zzejc2 = this.zzmlr;
            int size3 = zza2.size();
            StringBuilder stringBuilder2 = new StringBuilder(31);
            stringBuilder2.append("Unprunable queries: ");
            stringBuilder2.append(size3);
            com_google_android_gms_internal_zzejc2.zzb(stringBuilder2.toString(), null, new Object[0]);
        }
        for (zzehe com_google_android_gms_internal_zzehe2 : zza2) {
            com_google_android_gms_internal_zzeha2 = com_google_android_gms_internal_zzeha2.zzy(com_google_android_gms_internal_zzehe2.zzmyn.zzbsy());
        }
        return com_google_android_gms_internal_zzeha2;
    }

    public final Set<zzejg> zzaa(zzedk com_google_android_gms_internal_zzedk) {
        Set<zzejg> hashSet = new HashSet();
        Set zzae = zzae(com_google_android_gms_internal_zzedk);
        if (!zzae.isEmpty()) {
            hashSet.addAll(this.zzmyc.zze(zzae));
        }
        Iterator it = this.zzmyt.zzah(com_google_android_gms_internal_zzedk).zzbxx().iterator();
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            zzejg com_google_android_gms_internal_zzejg = (zzejg) entry.getKey();
            zzehm com_google_android_gms_internal_zzehm = (zzehm) entry.getValue();
            if (com_google_android_gms_internal_zzehm.getValue() != null && zzmyp.zzbs((Map) com_google_android_gms_internal_zzehm.getValue())) {
                hashSet.add(com_google_android_gms_internal_zzejg);
            }
        }
        return hashSet;
    }

    public final void zzab(zzedk com_google_android_gms_internal_zzedk) {
        if (!zzad(com_google_android_gms_internal_zzedk)) {
            zzeik zzam = zzeik.zzam(com_google_android_gms_internal_zzedk);
            zzehe zzk = zzk(zzam);
            if (zzk == null) {
                long j = this.zzmyv;
                this.zzmyv = 1 + j;
                zzehe com_google_android_gms_internal_zzehe = new zzehe(j, zzam, this.zzmyu.millis(), true, false);
            } else {
                zzk = zzk.zzbxt();
            }
            zza(zzk);
        }
    }

    public final boolean zzac(zzedk com_google_android_gms_internal_zzedk) {
        return this.zzmyt.zzb(com_google_android_gms_internal_zzedk, zzmyq) != null;
    }

    public final long zzbxu() {
        return (long) zza(zzmyr).size();
    }

    public final void zzg(zzeik com_google_android_gms_internal_zzeik) {
        zzb(com_google_android_gms_internal_zzeik, true);
    }

    public final void zzh(zzeik com_google_android_gms_internal_zzeik) {
        zzb(com_google_android_gms_internal_zzeik, false);
    }

    public final zzehe zzk(zzeik com_google_android_gms_internal_zzeik) {
        com_google_android_gms_internal_zzeik = zzj(com_google_android_gms_internal_zzeik);
        Map map = (Map) this.zzmyt.zzaj(com_google_android_gms_internal_zzeik.zzbsy());
        return map != null ? (zzehe) map.get(com_google_android_gms_internal_zzeik.zzbyy()) : null;
    }

    public final void zzl(zzeik com_google_android_gms_internal_zzeik) {
        zzehe zzk = zzk(zzj(com_google_android_gms_internal_zzeik));
        if (zzk != null && !zzk.complete) {
            zza(zzk.zzbxt());
        }
    }

    public final boolean zzm(zzeik com_google_android_gms_internal_zzeik) {
        if (zzad(com_google_android_gms_internal_zzeik.zzbsy())) {
            return true;
        }
        if (com_google_android_gms_internal_zzeik.zzbyv()) {
            return false;
        }
        Map map = (Map) this.zzmyt.zzaj(com_google_android_gms_internal_zzeik.zzbsy());
        return map != null && map.containsKey(com_google_android_gms_internal_zzeik.zzbyy()) && ((zzehe) map.get(com_google_android_gms_internal_zzeik.zzbyy())).complete;
    }

    public final void zzz(zzedk com_google_android_gms_internal_zzedk) {
        this.zzmyt.zzah(com_google_android_gms_internal_zzedk).zza(new zzehk(this));
    }
}
