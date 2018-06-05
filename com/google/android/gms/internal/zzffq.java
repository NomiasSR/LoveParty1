package com.google.android.gms.internal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

final class zzffq<FieldDescriptorType extends zzffs<FieldDescriptorType>> {
    private static final zzffq zzpgm = new zzffq(true);
    private boolean zzktj;
    private final zzfhy<FieldDescriptorType, Object> zzpgk = zzfhy.zzma(16);
    private boolean zzpgl = false;

    private zzffq() {
    }

    private zzffq(boolean z) {
        if (!this.zzktj) {
            this.zzpgk.zzbiy();
            this.zzktj = true;
        }
    }

    static int zza(zzfiy com_google_android_gms_internal_zzfiy, int i, Object obj) {
        i = zzffg.zzlg(i);
        if (com_google_android_gms_internal_zzfiy == zzfiy.GROUP) {
            zzffz.zzh((zzfhe) obj);
            i <<= 1;
        }
        return i + zzb(com_google_android_gms_internal_zzfiy, obj);
    }

    public static Object zza(zzffb com_google_android_gms_internal_zzffb, zzfiy com_google_android_gms_internal_zzfiy, boolean z) throws IOException {
        zzfje com_google_android_gms_internal_zzfje = zzfje.STRICT;
        switch (zzfix.zzpgo[com_google_android_gms_internal_zzfiy.ordinal()]) {
            case 1:
                return Double.valueOf(com_google_android_gms_internal_zzffb.readDouble());
            case 2:
                return Float.valueOf(com_google_android_gms_internal_zzffb.readFloat());
            case 3:
                return Long.valueOf(com_google_android_gms_internal_zzffb.zzcvv());
            case 4:
                return Long.valueOf(com_google_android_gms_internal_zzffb.zzcvu());
            case 5:
                return Integer.valueOf(com_google_android_gms_internal_zzffb.zzcvw());
            case 6:
                return Long.valueOf(com_google_android_gms_internal_zzffb.zzcvx());
            case 7:
                return Integer.valueOf(com_google_android_gms_internal_zzffb.zzcvy());
            case 8:
                return Boolean.valueOf(com_google_android_gms_internal_zzffb.zzcvz());
            case 9:
                return com_google_android_gms_internal_zzffb.zzcwb();
            case 10:
                return Integer.valueOf(com_google_android_gms_internal_zzffb.zzcwc());
            case 11:
                return Integer.valueOf(com_google_android_gms_internal_zzffb.zzcwe());
            case 12:
                return Long.valueOf(com_google_android_gms_internal_zzffb.zzcwf());
            case 13:
                return Integer.valueOf(com_google_android_gms_internal_zzffb.zzcwg());
            case 14:
                return Long.valueOf(com_google_android_gms_internal_zzffb.zzcwh());
            case 15:
                return com_google_android_gms_internal_zzfje.zza(com_google_android_gms_internal_zzffb);
            case 16:
                throw new IllegalArgumentException("readPrimitiveField() cannot handle nested groups.");
            case 17:
                throw new IllegalArgumentException("readPrimitiveField() cannot handle embedded messages.");
            case 18:
                throw new IllegalArgumentException("readPrimitiveField() cannot handle enums.");
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    static void zza(zzffg com_google_android_gms_internal_zzffg, zzfiy com_google_android_gms_internal_zzfiy, int i, Object obj) throws IOException {
        if (com_google_android_gms_internal_zzfiy == zzfiy.GROUP) {
            zzfhe com_google_android_gms_internal_zzfhe = (zzfhe) obj;
            zzffz.zzh(com_google_android_gms_internal_zzfhe);
            com_google_android_gms_internal_zzffg.zze(i, com_google_android_gms_internal_zzfhe);
            return;
        }
        com_google_android_gms_internal_zzffg.zzz(i, com_google_android_gms_internal_zzfiy.zzdae());
        switch (zzffr.zzpgo[com_google_android_gms_internal_zzfiy.ordinal()]) {
            case 1:
                com_google_android_gms_internal_zzffg.zzn(((Double) obj).doubleValue());
                return;
            case 2:
                com_google_android_gms_internal_zzffg.zzf(((Float) obj).floatValue());
                return;
            case 3:
                com_google_android_gms_internal_zzffg.zzct(((Long) obj).longValue());
                return;
            case 4:
                com_google_android_gms_internal_zzffg.zzct(((Long) obj).longValue());
                return;
            case 5:
                com_google_android_gms_internal_zzffg.zzlc(((Integer) obj).intValue());
                return;
            case 6:
                com_google_android_gms_internal_zzffg.zzcv(((Long) obj).longValue());
                return;
            case 7:
                com_google_android_gms_internal_zzffg.zzlf(((Integer) obj).intValue());
                return;
            case 8:
                com_google_android_gms_internal_zzffg.zzdd(((Boolean) obj).booleanValue());
                return;
            case 9:
                ((zzfhe) obj).zza(com_google_android_gms_internal_zzffg);
                return;
            case 10:
                com_google_android_gms_internal_zzffg.zze((zzfhe) obj);
                return;
            case 11:
                if (obj instanceof zzfes) {
                    com_google_android_gms_internal_zzffg.zzay((zzfes) obj);
                    return;
                } else {
                    com_google_android_gms_internal_zzffg.zzts((String) obj);
                    return;
                }
            case 12:
                if (obj instanceof zzfes) {
                    com_google_android_gms_internal_zzffg.zzay((zzfes) obj);
                    return;
                }
                byte[] bArr = (byte[]) obj;
                com_google_android_gms_internal_zzffg.zzi(bArr, 0, bArr.length);
                return;
            case 13:
                com_google_android_gms_internal_zzffg.zzld(((Integer) obj).intValue());
                return;
            case 14:
                com_google_android_gms_internal_zzffg.zzlf(((Integer) obj).intValue());
                return;
            case 15:
                com_google_android_gms_internal_zzffg.zzcv(((Long) obj).longValue());
                return;
            case 16:
                com_google_android_gms_internal_zzffg.zzle(((Integer) obj).intValue());
                return;
            case 17:
                com_google_android_gms_internal_zzffg.zzcu(((Long) obj).longValue());
                return;
            case 18:
                if (obj instanceof zzfga) {
                    com_google_android_gms_internal_zzffg.zzlc(((zzfga) obj).zzhq());
                    return;
                } else {
                    com_google_android_gms_internal_zzffg.zzlc(((Integer) obj).intValue());
                    return;
                }
            default:
                return;
        }
    }

    private void zza(FieldDescriptorType fieldDescriptorType, Object obj) {
        if (!fieldDescriptorType.zzcxj()) {
            zza(fieldDescriptorType.zzcxh(), obj);
        } else if (obj instanceof List) {
            List arrayList = new ArrayList();
            arrayList.addAll((List) obj);
            ArrayList arrayList2 = (ArrayList) arrayList;
            int size = arrayList2.size();
            int i = 0;
            while (i < size) {
                Object obj2 = arrayList2.get(i);
                i++;
                zza(fieldDescriptorType.zzcxh(), obj2);
            }
            obj = arrayList;
        } else {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
        if (obj instanceof zzfgg) {
            this.zzpgl = true;
        }
        this.zzpgk.zza((Comparable) fieldDescriptorType, obj);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void zza(com.google.android.gms.internal.zzfiy r2, java.lang.Object r3) {
        /*
        com.google.android.gms.internal.zzffz.checkNotNull(r3);
        r0 = com.google.android.gms.internal.zzffr.zzpgn;
        r2 = r2.zzdad();
        r2 = r2.ordinal();
        r2 = r0[r2];
        r0 = 1;
        r1 = 0;
        switch(r2) {
            case 1: goto L_0x0040;
            case 2: goto L_0x003d;
            case 3: goto L_0x003a;
            case 4: goto L_0x0037;
            case 5: goto L_0x0034;
            case 6: goto L_0x0031;
            case 7: goto L_0x0028;
            case 8: goto L_0x001e;
            case 9: goto L_0x0015;
            default: goto L_0x0014;
        };
    L_0x0014:
        goto L_0x0043;
    L_0x0015:
        r2 = r3 instanceof com.google.android.gms.internal.zzfhe;
        if (r2 != 0) goto L_0x0026;
    L_0x0019:
        r2 = r3 instanceof com.google.android.gms.internal.zzfgg;
        if (r2 == 0) goto L_0x0043;
    L_0x001d:
        goto L_0x0026;
    L_0x001e:
        r2 = r3 instanceof java.lang.Integer;
        if (r2 != 0) goto L_0x0026;
    L_0x0022:
        r2 = r3 instanceof com.google.android.gms.internal.zzfga;
        if (r2 == 0) goto L_0x0043;
    L_0x0026:
        r1 = r0;
        goto L_0x0043;
    L_0x0028:
        r2 = r3 instanceof com.google.android.gms.internal.zzfes;
        if (r2 != 0) goto L_0x0026;
    L_0x002c:
        r2 = r3 instanceof byte[];
        if (r2 == 0) goto L_0x0043;
    L_0x0030:
        goto L_0x0026;
    L_0x0031:
        r0 = r3 instanceof java.lang.String;
        goto L_0x0026;
    L_0x0034:
        r0 = r3 instanceof java.lang.Boolean;
        goto L_0x0026;
    L_0x0037:
        r0 = r3 instanceof java.lang.Double;
        goto L_0x0026;
    L_0x003a:
        r0 = r3 instanceof java.lang.Float;
        goto L_0x0026;
    L_0x003d:
        r0 = r3 instanceof java.lang.Long;
        goto L_0x0026;
    L_0x0040:
        r0 = r3 instanceof java.lang.Integer;
        goto L_0x0026;
    L_0x0043:
        if (r1 != 0) goto L_0x004d;
    L_0x0045:
        r2 = new java.lang.IllegalArgumentException;
        r3 = "Wrong object type used with protocol message reflection.";
        r2.<init>(r3);
        throw r2;
    L_0x004d:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzffq.zza(com.google.android.gms.internal.zzfiy, java.lang.Object):void");
    }

    private static int zzb(zzffs<?> com_google_android_gms_internal_zzffs_, Object obj) {
        zzfiy zzcxh = com_google_android_gms_internal_zzffs_.zzcxh();
        int zzhq = com_google_android_gms_internal_zzffs_.zzhq();
        if (!com_google_android_gms_internal_zzffs_.zzcxj()) {
            return zza(zzcxh, zzhq, obj);
        }
        int i = 0;
        if (com_google_android_gms_internal_zzffs_.zzcxk()) {
            for (Object obj2 : (List) obj2) {
                i += zzb(zzcxh, obj2);
            }
            return (zzffg.zzlg(zzhq) + i) + zzffg.zzlp(i);
        }
        for (Object obj22 : (List) obj22) {
            i += zza(zzcxh, zzhq, obj22);
        }
        return i;
    }

    private static int zzb(zzfiy com_google_android_gms_internal_zzfiy, Object obj) {
        switch (zzffr.zzpgo[com_google_android_gms_internal_zzfiy.ordinal()]) {
            case 1:
                return zzffg.zzo(((Double) obj).doubleValue());
            case 2:
                return zzffg.zzg(((Float) obj).floatValue());
            case 3:
                return zzffg.zzcw(((Long) obj).longValue());
            case 4:
                return zzffg.zzcx(((Long) obj).longValue());
            case 5:
                return zzffg.zzlh(((Integer) obj).intValue());
            case 6:
                return zzffg.zzcz(((Long) obj).longValue());
            case 7:
                return zzffg.zzlk(((Integer) obj).intValue());
            case 8:
                return zzffg.zzde(((Boolean) obj).booleanValue());
            case 9:
                return zzffg.zzg((zzfhe) obj);
            case 10:
                return obj instanceof zzfgg ? zzffg.zza((zzfgg) obj) : zzffg.zzf((zzfhe) obj);
            case 11:
                return obj instanceof zzfes ? zzffg.zzaz((zzfes) obj) : zzffg.zztt((String) obj);
            case 12:
                return obj instanceof zzfes ? zzffg.zzaz((zzfes) obj) : zzffg.zzbd((byte[]) obj);
            case 13:
                return zzffg.zzli(((Integer) obj).intValue());
            case 14:
                return zzffg.zzll(((Integer) obj).intValue());
            case 15:
                return zzffg.zzda(((Long) obj).longValue());
            case 16:
                return zzffg.zzlj(((Integer) obj).intValue());
            case 17:
                return zzffg.zzcy(((Long) obj).longValue());
            case 18:
                return obj instanceof zzfga ? zzffg.zzlm(((zzfga) obj).zzhq()) : zzffg.zzlm(((Integer) obj).intValue());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    private static int zzb(Entry<FieldDescriptorType, Object> entry) {
        zzffs com_google_android_gms_internal_zzffs = (zzffs) entry.getKey();
        Object value = entry.getValue();
        return (com_google_android_gms_internal_zzffs.zzcxi() != zzfjd.MESSAGE || com_google_android_gms_internal_zzffs.zzcxj() || com_google_android_gms_internal_zzffs.zzcxk()) ? zzb(com_google_android_gms_internal_zzffs, value) : value instanceof zzfgg ? zzffg.zzb(((zzffs) entry.getKey()).zzhq(), (zzfgg) value) : zzffg.zzd(((zzffs) entry.getKey()).zzhq(), (zzfhe) value);
    }

    public static <T extends zzffs<T>> zzffq<T> zzcxf() {
        return new zzffq();
    }

    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        zzffq com_google_android_gms_internal_zzffq = new zzffq();
        for (int i = 0; i < this.zzpgk.zzczj(); i++) {
            Entry zzmb = this.zzpgk.zzmb(i);
            com_google_android_gms_internal_zzffq.zza((zzffs) zzmb.getKey(), zzmb.getValue());
        }
        for (Entry zzmb2 : this.zzpgk.zzczk()) {
            com_google_android_gms_internal_zzffq.zza((zzffs) zzmb2.getKey(), zzmb2.getValue());
        }
        com_google_android_gms_internal_zzffq.zzpgl = this.zzpgl;
        return com_google_android_gms_internal_zzffq;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzffq)) {
            return false;
        }
        return this.zzpgk.equals(((zzffq) obj).zzpgk);
    }

    public final int hashCode() {
        return this.zzpgk.hashCode();
    }

    public final Iterator<Entry<FieldDescriptorType, Object>> iterator() {
        return this.zzpgl ? new zzfgj(this.zzpgk.entrySet().iterator()) : this.zzpgk.entrySet().iterator();
    }

    public final int zzcxg() {
        int i = 0;
        int i2 = 0;
        while (i < this.zzpgk.zzczj()) {
            i2 += zzb(this.zzpgk.zzmb(i));
            i++;
        }
        for (Entry zzb : this.zzpgk.zzczk()) {
            i2 += zzb(zzb);
        }
        return i2;
    }
}
