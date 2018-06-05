package com.google.android.gms.internal;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

final class zzfjp implements Cloneable {
    private Object value;
    private zzfjn<?, ?> zzpni;
    private List<zzfju> zzpnj = new ArrayList();

    zzfjp() {
    }

    private final byte[] toByteArray() throws IOException {
        byte[] bArr = new byte[zzq()];
        zza(zzfjk.zzbf(bArr));
        return bArr;
    }

    private zzfjp zzdah() {
        zzfjp com_google_android_gms_internal_zzfjp = new zzfjp();
        try {
            com_google_android_gms_internal_zzfjp.zzpni = this.zzpni;
            if (this.zzpnj == null) {
                com_google_android_gms_internal_zzfjp.zzpnj = null;
            } else {
                com_google_android_gms_internal_zzfjp.zzpnj.addAll(this.zzpnj);
            }
            if (this.value != null) {
                Object obj;
                if (this.value instanceof zzfjs) {
                    obj = (zzfjs) ((zzfjs) this.value).clone();
                } else if (this.value instanceof byte[]) {
                    obj = ((byte[]) this.value).clone();
                } else {
                    int i = 0;
                    Object obj2;
                    if (this.value instanceof byte[][]) {
                        byte[][] bArr = (byte[][]) this.value;
                        obj2 = new byte[bArr.length][];
                        com_google_android_gms_internal_zzfjp.value = obj2;
                        while (i < bArr.length) {
                            obj2[i] = (byte[]) bArr[i].clone();
                            i++;
                        }
                    } else if (this.value instanceof boolean[]) {
                        obj = ((boolean[]) this.value).clone();
                    } else if (this.value instanceof int[]) {
                        obj = ((int[]) this.value).clone();
                    } else if (this.value instanceof long[]) {
                        obj = ((long[]) this.value).clone();
                    } else if (this.value instanceof float[]) {
                        obj = ((float[]) this.value).clone();
                    } else if (this.value instanceof double[]) {
                        obj = ((double[]) this.value).clone();
                    } else if (this.value instanceof zzfjs[]) {
                        zzfjs[] com_google_android_gms_internal_zzfjsArr = (zzfjs[]) this.value;
                        obj2 = new zzfjs[com_google_android_gms_internal_zzfjsArr.length];
                        com_google_android_gms_internal_zzfjp.value = obj2;
                        while (i < com_google_android_gms_internal_zzfjsArr.length) {
                            obj2[i] = (zzfjs) com_google_android_gms_internal_zzfjsArr[i].clone();
                            i++;
                        }
                    }
                }
                com_google_android_gms_internal_zzfjp.value = obj;
                return com_google_android_gms_internal_zzfjp;
            }
            return com_google_android_gms_internal_zzfjp;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        return zzdah();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzfjp)) {
            return false;
        }
        zzfjp com_google_android_gms_internal_zzfjp = (zzfjp) obj;
        if (this.value != null && com_google_android_gms_internal_zzfjp.value != null) {
            return this.zzpni != com_google_android_gms_internal_zzfjp.zzpni ? false : !this.zzpni.zznfk.isArray() ? this.value.equals(com_google_android_gms_internal_zzfjp.value) : this.value instanceof byte[] ? Arrays.equals((byte[]) this.value, (byte[]) com_google_android_gms_internal_zzfjp.value) : this.value instanceof int[] ? Arrays.equals((int[]) this.value, (int[]) com_google_android_gms_internal_zzfjp.value) : this.value instanceof long[] ? Arrays.equals((long[]) this.value, (long[]) com_google_android_gms_internal_zzfjp.value) : this.value instanceof float[] ? Arrays.equals((float[]) this.value, (float[]) com_google_android_gms_internal_zzfjp.value) : this.value instanceof double[] ? Arrays.equals((double[]) this.value, (double[]) com_google_android_gms_internal_zzfjp.value) : this.value instanceof boolean[] ? Arrays.equals((boolean[]) this.value, (boolean[]) com_google_android_gms_internal_zzfjp.value) : Arrays.deepEquals((Object[]) this.value, (Object[]) com_google_android_gms_internal_zzfjp.value);
        } else {
            if (this.zzpnj != null && com_google_android_gms_internal_zzfjp.zzpnj != null) {
                return this.zzpnj.equals(com_google_android_gms_internal_zzfjp.zzpnj);
            }
            try {
                return Arrays.equals(toByteArray(), com_google_android_gms_internal_zzfjp.toByteArray());
            } catch (Throwable e) {
                throw new IllegalStateException(e);
            }
        }
    }

    public final int hashCode() {
        try {
            return 527 + Arrays.hashCode(toByteArray());
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }

    final void zza(zzfjk com_google_android_gms_internal_zzfjk) throws IOException {
        if (this.value != null) {
            zzfjn com_google_android_gms_internal_zzfjn = this.zzpni;
            Object obj = this.value;
            if (com_google_android_gms_internal_zzfjn.zzpnd) {
                int length = Array.getLength(obj);
                for (int i = 0; i < length; i++) {
                    Object obj2 = Array.get(obj, i);
                    if (obj2 != null) {
                        com_google_android_gms_internal_zzfjn.zza(obj2, com_google_android_gms_internal_zzfjk);
                    }
                }
                return;
            }
            com_google_android_gms_internal_zzfjn.zza(obj, com_google_android_gms_internal_zzfjk);
            return;
        }
        for (zzfju com_google_android_gms_internal_zzfju : this.zzpnj) {
            com_google_android_gms_internal_zzfjk.zzmi(com_google_android_gms_internal_zzfju.tag);
            com_google_android_gms_internal_zzfjk.zzbh(com_google_android_gms_internal_zzfju.zzjng);
        }
    }

    final void zza(zzfju com_google_android_gms_internal_zzfju) {
        this.zzpnj.add(com_google_android_gms_internal_zzfju);
    }

    final <T> T zzb(zzfjn<?, T> com_google_android_gms_internal_zzfjn___T) {
        if (this.value == null) {
            this.zzpni = com_google_android_gms_internal_zzfjn___T;
            this.value = com_google_android_gms_internal_zzfjn___T.zzbq(this.zzpnj);
            this.zzpnj = null;
        } else if (!this.zzpni.equals(com_google_android_gms_internal_zzfjn___T)) {
            throw new IllegalStateException("Tried to getExtension with a different Extension.");
        }
        return this.value;
    }

    final int zzq() {
        int i;
        int i2 = 0;
        if (this.value != null) {
            zzfjn com_google_android_gms_internal_zzfjn = this.zzpni;
            Object obj = this.value;
            if (!com_google_android_gms_internal_zzfjn.zzpnd) {
                return com_google_android_gms_internal_zzfjn.zzcs(obj);
            }
            int length = Array.getLength(obj);
            i = 0;
            while (i2 < length) {
                if (Array.get(obj, i2) != null) {
                    i += com_google_android_gms_internal_zzfjn.zzcs(Array.get(obj, i2));
                }
                i2++;
            }
        } else {
            i = 0;
            for (zzfju com_google_android_gms_internal_zzfju : this.zzpnj) {
                i += (zzfjk.zzlp(com_google_android_gms_internal_zzfju.tag) + 0) + com_google_android_gms_internal_zzfju.zzjng.length;
            }
        }
        return i;
    }
}
