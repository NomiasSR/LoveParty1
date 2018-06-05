package com.google.android.gms.internal;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class zzffu<MessageType extends zzffu<MessageType, BuilderType>, BuilderType extends zza<MessageType, BuilderType>> extends zzfek<MessageType, BuilderType> {
    private static Map<Object, zzffu<?, ?>> zzpgt = new ConcurrentHashMap();
    protected zzfio zzpgr = zzfio.zzczu();
    protected int zzpgs = -1;

    public enum zzg {
        public static final int zzphc = 1;
        public static final int zzphd = 2;
        public static final int zzphe = 3;
        public static final int zzphf = 4;
        public static final int zzphg = 5;
        public static final int zzphh = 6;
        public static final int zzphi = 7;
        public static final int zzphj = 8;
        public static final int zzphk = 9;
        public static final int zzphl = 10;
        private static final /* synthetic */ int[] zzphm = new int[]{zzphc, zzphd, zzphe, zzphf, zzphg, zzphh, zzphi, zzphj, zzphk, zzphl};
        public static final int zzphn = 1;
        public static final int zzpho = 2;
        private static final /* synthetic */ int[] zzphp = new int[]{zzphn, zzpho};

        public static int[] m5x126d66cb() {
            return (int[]) zzphm.clone();
        }
    }

    public interface zzh {
        double zza(boolean z, double d, boolean z2, double d2);

        int zza(boolean z, int i, boolean z2, int i2);

        long zza(boolean z, long j, boolean z2, long j2);

        zzfes zza(boolean z, zzfes com_google_android_gms_internal_zzfes, boolean z2, zzfes com_google_android_gms_internal_zzfes2);

        zzfgc zza(zzfgc com_google_android_gms_internal_zzfgc, zzfgc com_google_android_gms_internal_zzfgc2);

        <T> zzfgd<T> zza(zzfgd<T> com_google_android_gms_internal_zzfgd_T, zzfgd<T> com_google_android_gms_internal_zzfgd_T2);

        <K, V> zzfgy<K, V> zza(zzfgy<K, V> com_google_android_gms_internal_zzfgy_K__V, zzfgy<K, V> com_google_android_gms_internal_zzfgy_K__V2);

        <T extends zzfhe> T zza(T t, T t2);

        zzfio zza(zzfio com_google_android_gms_internal_zzfio, zzfio com_google_android_gms_internal_zzfio2);

        Object zza(boolean z, Object obj, Object obj2);

        String zza(boolean z, String str, boolean z2, String str2);

        boolean zza(boolean z, boolean z2, boolean z3, boolean z4);

        Object zzb(boolean z, Object obj, Object obj2);

        Object zzc(boolean z, Object obj, Object obj2);

        Object zzd(boolean z, Object obj, Object obj2);

        void zzdf(boolean z);

        Object zze(boolean z, Object obj, Object obj2);

        Object zzf(boolean z, Object obj, Object obj2);

        Object zzg(boolean z, Object obj, Object obj2);
    }

    static class zzc implements zzh {
        static final zzc zzpgx = new zzc();
        private static zzffv zzpgy = new zzffv();

        private zzc() {
        }

        public final double zza(boolean z, double d, boolean z2, double d2) {
            if (z == z2) {
                if (d == d2) {
                    return d;
                }
            }
            throw zzpgy;
        }

        public final int zza(boolean z, int i, boolean z2, int i2) {
            if (z == z2) {
                if (i == i2) {
                    return i;
                }
            }
            throw zzpgy;
        }

        public final long zza(boolean z, long j, boolean z2, long j2) {
            if (z == z2) {
                if (j == j2) {
                    return j;
                }
            }
            throw zzpgy;
        }

        public final zzfes zza(boolean z, zzfes com_google_android_gms_internal_zzfes, boolean z2, zzfes com_google_android_gms_internal_zzfes2) {
            if (z == z2) {
                if (com_google_android_gms_internal_zzfes.equals(com_google_android_gms_internal_zzfes2)) {
                    return com_google_android_gms_internal_zzfes;
                }
            }
            throw zzpgy;
        }

        public final zzfgc zza(zzfgc com_google_android_gms_internal_zzfgc, zzfgc com_google_android_gms_internal_zzfgc2) {
            if (com_google_android_gms_internal_zzfgc.equals(com_google_android_gms_internal_zzfgc2)) {
                return com_google_android_gms_internal_zzfgc;
            }
            throw zzpgy;
        }

        public final <T> zzfgd<T> zza(zzfgd<T> com_google_android_gms_internal_zzfgd_T, zzfgd<T> com_google_android_gms_internal_zzfgd_T2) {
            if (com_google_android_gms_internal_zzfgd_T.equals(com_google_android_gms_internal_zzfgd_T2)) {
                return com_google_android_gms_internal_zzfgd_T;
            }
            throw zzpgy;
        }

        public final <K, V> zzfgy<K, V> zza(zzfgy<K, V> com_google_android_gms_internal_zzfgy_K__V, zzfgy<K, V> com_google_android_gms_internal_zzfgy_K__V2) {
            if (com_google_android_gms_internal_zzfgy_K__V.equals(com_google_android_gms_internal_zzfgy_K__V2)) {
                return com_google_android_gms_internal_zzfgy_K__V;
            }
            throw zzpgy;
        }

        public final <T extends zzfhe> T zza(T t, T t2) {
            if (t == null && t2 == null) {
                return null;
            }
            if (t != null) {
                if (t2 != null) {
                    T t3 = (zzffu) t;
                    if (t3 != t2 && ((zzffu) t3.zza(zzg.zzphk, null, null)).getClass().isInstance(t2)) {
                        Object obj = (zzffu) t2;
                        t3.zza(zzg.zzphd, (Object) this, obj);
                        t3.zzpgr = zza(t3.zzpgr, obj.zzpgr);
                    }
                    return t;
                }
            }
            throw zzpgy;
        }

        public final zzfio zza(zzfio com_google_android_gms_internal_zzfio, zzfio com_google_android_gms_internal_zzfio2) {
            if (com_google_android_gms_internal_zzfio.equals(com_google_android_gms_internal_zzfio2)) {
                return com_google_android_gms_internal_zzfio;
            }
            throw zzpgy;
        }

        public final Object zza(boolean z, Object obj, Object obj2) {
            if (z && obj.equals(obj2)) {
                return obj;
            }
            throw zzpgy;
        }

        public final String zza(boolean z, String str, boolean z2, String str2) {
            if (z == z2) {
                if (str.equals(str2)) {
                    return str;
                }
            }
            throw zzpgy;
        }

        public final boolean zza(boolean z, boolean z2, boolean z3, boolean z4) {
            if (z == z3) {
                if (z2 == z4) {
                    return z2;
                }
            }
            throw zzpgy;
        }

        public final Object zzb(boolean z, Object obj, Object obj2) {
            if (z && obj.equals(obj2)) {
                return obj;
            }
            throw zzpgy;
        }

        public final Object zzc(boolean z, Object obj, Object obj2) {
            if (z && obj.equals(obj2)) {
                return obj;
            }
            throw zzpgy;
        }

        public final Object zzd(boolean z, Object obj, Object obj2) {
            if (z && obj.equals(obj2)) {
                return obj;
            }
            throw zzpgy;
        }

        public final void zzdf(boolean z) {
            if (z) {
                throw zzpgy;
            }
        }

        public final Object zze(boolean z, Object obj, Object obj2) {
            if (z && obj.equals(obj2)) {
                return obj;
            }
            throw zzpgy;
        }

        public final Object zzf(boolean z, Object obj, Object obj2) {
            if (z && obj.equals(obj2)) {
                return obj;
            }
            throw zzpgy;
        }

        public final Object zzg(boolean z, Object obj, Object obj2) {
            if (z) {
                zzffu com_google_android_gms_internal_zzffu = (zzffu) obj;
                obj2 = (zzfhe) obj2;
                Object obj3 = 1;
                if (com_google_android_gms_internal_zzffu != obj2) {
                    if (((zzffu) com_google_android_gms_internal_zzffu.zza(zzg.zzphk, null, null)).getClass().isInstance(obj2)) {
                        obj2 = (zzffu) obj2;
                        com_google_android_gms_internal_zzffu.zza(zzg.zzphd, (Object) this, obj2);
                        com_google_android_gms_internal_zzffu.zzpgr = zza(com_google_android_gms_internal_zzffu.zzpgr, obj2.zzpgr);
                    } else {
                        obj3 = null;
                    }
                }
                if (obj3 != null) {
                    return obj;
                }
            }
            throw zzpgy;
        }
    }

    static class zze implements zzh {
        int zzpha = 0;

        zze() {
        }

        public final double zza(boolean z, double d, boolean z2, double d2) {
            this.zzpha = (53 * this.zzpha) + zzffz.zzde(Double.doubleToLongBits(d));
            return d;
        }

        public final int zza(boolean z, int i, boolean z2, int i2) {
            this.zzpha = (53 * this.zzpha) + i;
            return i;
        }

        public final long zza(boolean z, long j, boolean z2, long j2) {
            this.zzpha = (53 * this.zzpha) + zzffz.zzde(j);
            return j;
        }

        public final zzfes zza(boolean z, zzfes com_google_android_gms_internal_zzfes, boolean z2, zzfes com_google_android_gms_internal_zzfes2) {
            this.zzpha = (53 * this.zzpha) + com_google_android_gms_internal_zzfes.hashCode();
            return com_google_android_gms_internal_zzfes;
        }

        public final zzfgc zza(zzfgc com_google_android_gms_internal_zzfgc, zzfgc com_google_android_gms_internal_zzfgc2) {
            this.zzpha = (53 * this.zzpha) + com_google_android_gms_internal_zzfgc.hashCode();
            return com_google_android_gms_internal_zzfgc;
        }

        public final <T> zzfgd<T> zza(zzfgd<T> com_google_android_gms_internal_zzfgd_T, zzfgd<T> com_google_android_gms_internal_zzfgd_T2) {
            this.zzpha = (53 * this.zzpha) + com_google_android_gms_internal_zzfgd_T.hashCode();
            return com_google_android_gms_internal_zzfgd_T;
        }

        public final <K, V> zzfgy<K, V> zza(zzfgy<K, V> com_google_android_gms_internal_zzfgy_K__V, zzfgy<K, V> com_google_android_gms_internal_zzfgy_K__V2) {
            this.zzpha = (53 * this.zzpha) + com_google_android_gms_internal_zzfgy_K__V.hashCode();
            return com_google_android_gms_internal_zzfgy_K__V;
        }

        public final <T extends zzfhe> T zza(T t, T t2) {
            int i;
            if (t == null) {
                i = 37;
            } else if (t instanceof zzffu) {
                Object obj = (zzffu) t;
                if (obj.zzpfa == 0) {
                    int i2 = this.zzpha;
                    this.zzpha = 0;
                    obj.zza(zzg.zzphd, (Object) this, obj);
                    obj.zzpgr = zza(obj.zzpgr, obj.zzpgr);
                    obj.zzpfa = this.zzpha;
                    this.zzpha = i2;
                }
                i = obj.zzpfa;
            } else {
                i = t.hashCode();
            }
            this.zzpha = (53 * this.zzpha) + i;
            return t;
        }

        public final zzfio zza(zzfio com_google_android_gms_internal_zzfio, zzfio com_google_android_gms_internal_zzfio2) {
            this.zzpha = (53 * this.zzpha) + com_google_android_gms_internal_zzfio.hashCode();
            return com_google_android_gms_internal_zzfio;
        }

        public final Object zza(boolean z, Object obj, Object obj2) {
            this.zzpha = (53 * this.zzpha) + zzffz.zzdg(((Boolean) obj).booleanValue());
            return obj;
        }

        public final String zza(boolean z, String str, boolean z2, String str2) {
            this.zzpha = (53 * this.zzpha) + str.hashCode();
            return str;
        }

        public final boolean zza(boolean z, boolean z2, boolean z3, boolean z4) {
            this.zzpha = (53 * this.zzpha) + zzffz.zzdg(z2);
            return z2;
        }

        public final Object zzb(boolean z, Object obj, Object obj2) {
            this.zzpha = (53 * this.zzpha) + ((Integer) obj).intValue();
            return obj;
        }

        public final Object zzc(boolean z, Object obj, Object obj2) {
            this.zzpha = (53 * this.zzpha) + zzffz.zzde(Double.doubleToLongBits(((Double) obj).doubleValue()));
            return obj;
        }

        public final Object zzd(boolean z, Object obj, Object obj2) {
            this.zzpha = (53 * this.zzpha) + zzffz.zzde(((Long) obj).longValue());
            return obj;
        }

        public final void zzdf(boolean z) {
            if (z) {
                throw new IllegalStateException();
            }
        }

        public final Object zze(boolean z, Object obj, Object obj2) {
            this.zzpha = (53 * this.zzpha) + obj.hashCode();
            return obj;
        }

        public final Object zzf(boolean z, Object obj, Object obj2) {
            this.zzpha = (53 * this.zzpha) + obj.hashCode();
            return obj;
        }

        public final Object zzg(boolean z, Object obj, Object obj2) {
            return zza((zzfhe) obj, (zzfhe) obj2);
        }
    }

    public static class zzf implements zzh {
        public static final zzf zzphb = new zzf();

        private zzf() {
        }

        public final double zza(boolean z, double d, boolean z2, double d2) {
            return z2 ? d2 : d;
        }

        public final int zza(boolean z, int i, boolean z2, int i2) {
            return z2 ? i2 : i;
        }

        public final long zza(boolean z, long j, boolean z2, long j2) {
            return z2 ? j2 : j;
        }

        public final zzfes zza(boolean z, zzfes com_google_android_gms_internal_zzfes, boolean z2, zzfes com_google_android_gms_internal_zzfes2) {
            return z2 ? com_google_android_gms_internal_zzfes2 : com_google_android_gms_internal_zzfes;
        }

        public final zzfgc zza(zzfgc com_google_android_gms_internal_zzfgc, zzfgc com_google_android_gms_internal_zzfgc2) {
            int size = com_google_android_gms_internal_zzfgc.size();
            int size2 = com_google_android_gms_internal_zzfgc2.size();
            if (size > 0 && size2 > 0) {
                if (!com_google_android_gms_internal_zzfgc.zzcvi()) {
                    com_google_android_gms_internal_zzfgc = com_google_android_gms_internal_zzfgc.zzlu(size2 + size);
                }
                com_google_android_gms_internal_zzfgc.addAll(com_google_android_gms_internal_zzfgc2);
            }
            return size > 0 ? com_google_android_gms_internal_zzfgc : com_google_android_gms_internal_zzfgc2;
        }

        public final <T> zzfgd<T> zza(zzfgd<T> com_google_android_gms_internal_zzfgd_T, zzfgd<T> com_google_android_gms_internal_zzfgd_T2) {
            int size = com_google_android_gms_internal_zzfgd_T.size();
            int size2 = com_google_android_gms_internal_zzfgd_T2.size();
            if (size > 0 && size2 > 0) {
                if (!com_google_android_gms_internal_zzfgd_T.zzcvi()) {
                    com_google_android_gms_internal_zzfgd_T = com_google_android_gms_internal_zzfgd_T.zzly(size2 + size);
                }
                com_google_android_gms_internal_zzfgd_T.addAll(com_google_android_gms_internal_zzfgd_T2);
            }
            return size > 0 ? com_google_android_gms_internal_zzfgd_T : com_google_android_gms_internal_zzfgd_T2;
        }

        public final <K, V> zzfgy<K, V> zza(zzfgy<K, V> com_google_android_gms_internal_zzfgy_K__V, zzfgy<K, V> com_google_android_gms_internal_zzfgy_K__V2) {
            if (!com_google_android_gms_internal_zzfgy_K__V2.isEmpty()) {
                if (!com_google_android_gms_internal_zzfgy_K__V.isMutable()) {
                    com_google_android_gms_internal_zzfgy_K__V = com_google_android_gms_internal_zzfgy_K__V.zzcyq();
                }
                com_google_android_gms_internal_zzfgy_K__V.zza(com_google_android_gms_internal_zzfgy_K__V2);
            }
            return com_google_android_gms_internal_zzfgy_K__V;
        }

        public final <T extends zzfhe> T zza(T t, T t2) {
            return (t == null || t2 == null) ? t != null ? t : t2 : t.zzcxp().zzd(t2).zzcxv();
        }

        public final zzfio zza(zzfio com_google_android_gms_internal_zzfio, zzfio com_google_android_gms_internal_zzfio2) {
            return com_google_android_gms_internal_zzfio2 == zzfio.zzczu() ? com_google_android_gms_internal_zzfio : zzfio.zzb(com_google_android_gms_internal_zzfio, com_google_android_gms_internal_zzfio2);
        }

        public final Object zza(boolean z, Object obj, Object obj2) {
            return obj2;
        }

        public final String zza(boolean z, String str, boolean z2, String str2) {
            return z2 ? str2 : str;
        }

        public final boolean zza(boolean z, boolean z2, boolean z3, boolean z4) {
            return z3 ? z4 : z2;
        }

        public final Object zzb(boolean z, Object obj, Object obj2) {
            return obj2;
        }

        public final Object zzc(boolean z, Object obj, Object obj2) {
            return obj2;
        }

        public final Object zzd(boolean z, Object obj, Object obj2) {
            return obj2;
        }

        public final void zzdf(boolean z) {
        }

        public final Object zze(boolean z, Object obj, Object obj2) {
            return obj2;
        }

        public final Object zzf(boolean z, Object obj, Object obj2) {
            return obj2;
        }

        public final Object zzg(boolean z, Object obj, Object obj2) {
            return z ? zza((zzfhe) obj, (zzfhe) obj2) : obj2;
        }
    }

    public static class zzb<T extends zzffu<T, ?>> extends zzfen<T> {
        private T zzpgu;

        public zzb(T t) {
            this.zzpgu = t;
        }

        public final /* synthetic */ Object zze(zzffb com_google_android_gms_internal_zzffb, zzffm com_google_android_gms_internal_zzffm) throws zzfge {
            return zzffu.zza(this.zzpgu, com_google_android_gms_internal_zzffb, com_google_android_gms_internal_zzffm);
        }
    }

    public static abstract class zza<MessageType extends zzffu<MessageType, BuilderType>, BuilderType extends zza<MessageType, BuilderType>> extends zzfel<MessageType, BuilderType> {
        private final MessageType zzpgu;
        protected MessageType zzpgv;
        private boolean zzpgw = false;

        protected zza(MessageType messageType) {
            this.zzpgu = messageType;
            this.zzpgv = (zzffu) messageType.zza(zzg.zzphi, null, null);
        }

        private static void zza(MessageType messageType, MessageType messageType2) {
            Object obj = zzf.zzphb;
            messageType.zza(zzg.zzphd, obj, (Object) messageType2);
            messageType.zzpgr = obj.zza(messageType.zzpgr, messageType2.zzpgr);
        }

        private final BuilderType zzd(zzffb com_google_android_gms_internal_zzffb, zzffm com_google_android_gms_internal_zzffm) throws IOException {
            zzcxr();
            try {
                this.zzpgv.zza(zzg.zzphg, (Object) com_google_android_gms_internal_zzffb, (Object) com_google_android_gms_internal_zzffm);
                return this;
            } catch (RuntimeException e) {
                if (e.getCause() instanceof IOException) {
                    throw ((IOException) e.getCause());
                }
                throw e;
            }
        }

        public /* synthetic */ Object clone() throws CloneNotSupportedException {
            zza com_google_android_gms_internal_zzffu_zza = (zza) this.zzpgu.zza(zzg.zzphj, null, null);
            if (!this.zzpgw) {
                zzffu com_google_android_gms_internal_zzffu = this.zzpgv;
                com_google_android_gms_internal_zzffu.zza(zzg.zzphh, null, null);
                com_google_android_gms_internal_zzffu.zzpgr.zzbiy();
                this.zzpgw = true;
            }
            com_google_android_gms_internal_zzffu_zza.zza(this.zzpgv);
            return com_google_android_gms_internal_zzffu_zza;
        }

        public final boolean isInitialized() {
            return zzffu.zza(this.zzpgv, false);
        }

        protected final /* synthetic */ zzfel zza(zzfek com_google_android_gms_internal_zzfek) {
            return zza((zzffu) com_google_android_gms_internal_zzfek);
        }

        public final /* synthetic */ zzfel zza(zzffb com_google_android_gms_internal_zzffb, zzffm com_google_android_gms_internal_zzffm) throws IOException {
            return (zza) zzb(com_google_android_gms_internal_zzffb, com_google_android_gms_internal_zzffm);
        }

        public final BuilderType zza(MessageType messageType) {
            zzcxr();
            zza(this.zzpgv, (zzffu) messageType);
            return this;
        }

        public final /* synthetic */ zzfhf zzb(zzffb com_google_android_gms_internal_zzffb, zzffm com_google_android_gms_internal_zzffm) throws IOException {
            return zzd(com_google_android_gms_internal_zzffb, com_google_android_gms_internal_zzffm);
        }

        public final /* synthetic */ zzfel zzcvh() {
            return (zza) clone();
        }

        public final /* synthetic */ zzfhe zzcxq() {
            return this.zzpgu;
        }

        protected final void zzcxr() {
            if (this.zzpgw) {
                zzffu com_google_android_gms_internal_zzffu = (zzffu) this.zzpgv.zza(zzg.zzphi, null, null);
                zza(com_google_android_gms_internal_zzffu, this.zzpgv);
                this.zzpgv = com_google_android_gms_internal_zzffu;
                this.zzpgw = false;
            }
        }

        public final MessageType zzcxs() {
            if (this.zzpgw) {
                return this.zzpgv;
            }
            zzffu com_google_android_gms_internal_zzffu = this.zzpgv;
            com_google_android_gms_internal_zzffu.zza(zzg.zzphh, null, null);
            com_google_android_gms_internal_zzffu.zzpgr.zzbiy();
            this.zzpgw = true;
            return this.zzpgv;
        }

        public final MessageType zzcxt() {
            zzffu com_google_android_gms_internal_zzffu;
            boolean z = true;
            if (!this.zzpgw) {
                com_google_android_gms_internal_zzffu = this.zzpgv;
                com_google_android_gms_internal_zzffu.zza(zzg.zzphh, null, null);
                com_google_android_gms_internal_zzffu.zzpgr.zzbiy();
                this.zzpgw = true;
            }
            com_google_android_gms_internal_zzffu = this.zzpgv;
            boolean booleanValue = Boolean.TRUE.booleanValue();
            byte byteValue = ((Byte) com_google_android_gms_internal_zzffu.zza(zzg.zzphe, null, null)).byteValue();
            if (byteValue != (byte) 1) {
                if (byteValue == (byte) 0) {
                    z = false;
                } else {
                    if (com_google_android_gms_internal_zzffu.zza(zzg.zzphc, Boolean.FALSE, null) == null) {
                        z = false;
                    }
                    if (booleanValue) {
                        com_google_android_gms_internal_zzffu.zza(zzg.zzphf, z ? com_google_android_gms_internal_zzffu : null, null);
                    }
                }
            }
            if (z) {
                return com_google_android_gms_internal_zzffu;
            }
            throw new zzfim(com_google_android_gms_internal_zzffu);
        }

        public final /* synthetic */ zzfhe zzcxu() {
            if (this.zzpgw) {
                return this.zzpgv;
            }
            zzffu com_google_android_gms_internal_zzffu = this.zzpgv;
            com_google_android_gms_internal_zzffu.zza(zzg.zzphh, null, null);
            com_google_android_gms_internal_zzffu.zzpgr.zzbiy();
            this.zzpgw = true;
            return this.zzpgv;
        }

        public final /* synthetic */ zzfhe zzcxv() {
            zzffu com_google_android_gms_internal_zzffu;
            boolean z = true;
            if (!this.zzpgw) {
                com_google_android_gms_internal_zzffu = this.zzpgv;
                com_google_android_gms_internal_zzffu.zza(zzg.zzphh, null, null);
                com_google_android_gms_internal_zzffu.zzpgr.zzbiy();
                this.zzpgw = true;
            }
            com_google_android_gms_internal_zzffu = this.zzpgv;
            boolean booleanValue = Boolean.TRUE.booleanValue();
            byte byteValue = ((Byte) com_google_android_gms_internal_zzffu.zza(zzg.zzphe, null, null)).byteValue();
            if (byteValue != (byte) 1) {
                if (byteValue == (byte) 0) {
                    z = false;
                } else {
                    if (com_google_android_gms_internal_zzffu.zza(zzg.zzphc, Boolean.FALSE, null) == null) {
                        z = false;
                    }
                    if (booleanValue) {
                        com_google_android_gms_internal_zzffu.zza(zzg.zzphf, z ? com_google_android_gms_internal_zzffu : null, null);
                    }
                }
            }
            if (z) {
                return com_google_android_gms_internal_zzffu;
            }
            throw new zzfim(com_google_android_gms_internal_zzffu);
        }
    }

    public static abstract class zzd<MessageType extends zzd<MessageType, BuilderType>, BuilderType> extends zzffu<MessageType, BuilderType> implements zzfhg {
        protected zzffq<Object> zzpgz = zzffq.zzcxf();
    }

    protected static <T extends zzffu<T, ?>> T zza(T t, zzfes com_google_android_gms_internal_zzfes) throws zzfge {
        boolean booleanValue;
        byte byteValue;
        t = zza((zzffu) t, com_google_android_gms_internal_zzfes, zzffm.zzcxb());
        Object obj = null;
        if (t != null) {
            Object obj2;
            booleanValue = Boolean.TRUE.booleanValue();
            byteValue = ((Byte) t.zza(zzg.zzphe, null, null)).byteValue();
            if (byteValue == (byte) 1) {
                obj2 = 1;
            } else if (byteValue == (byte) 0) {
                obj2 = null;
            } else {
                obj2 = t.zza(zzg.zzphc, Boolean.FALSE, null) != null ? 1 : null;
                if (booleanValue) {
                    t.zza(zzg.zzphf, obj2 != null ? t : null, null);
                }
            }
            if (obj2 == null) {
                throw new zzfim(t).zzczt().zzi(t);
            }
        }
        if (t != null) {
            booleanValue = Boolean.TRUE.booleanValue();
            byteValue = ((Byte) t.zza(zzg.zzphe, null, null)).byteValue();
            if (byteValue == (byte) 1) {
                obj = 1;
            } else if (byteValue != (byte) 0) {
                if (t.zza(zzg.zzphc, Boolean.FALSE, null) != null) {
                    obj = 1;
                }
                if (booleanValue) {
                    t.zza(zzg.zzphf, obj != null ? t : null, null);
                }
            }
            if (obj == null) {
                throw new zzfim(t).zzczt().zzi(t);
            }
        }
        return t;
    }

    private static <T extends zzffu<T, ?>> T zza(T t, zzfes com_google_android_gms_internal_zzfes, zzffm com_google_android_gms_internal_zzffm) throws zzfge {
        try {
            zzffb zzcvm = com_google_android_gms_internal_zzfes.zzcvm();
            t = zza((zzffu) t, zzcvm, com_google_android_gms_internal_zzffm);
            zzcvm.zzkp(0);
            return t;
        } catch (zzfge e) {
            throw e.zzi(t);
        } catch (zzfge e2) {
            throw e2;
        }
    }

    static <T extends zzffu<T, ?>> T zza(T t, zzffb com_google_android_gms_internal_zzffb, zzffm com_google_android_gms_internal_zzffm) throws zzfge {
        zzffu com_google_android_gms_internal_zzffu = (zzffu) t.zza(zzg.zzphi, null, null);
        try {
            com_google_android_gms_internal_zzffu.zza(zzg.zzphg, (Object) com_google_android_gms_internal_zzffb, (Object) com_google_android_gms_internal_zzffm);
            com_google_android_gms_internal_zzffu.zza(zzg.zzphh, null, null);
            com_google_android_gms_internal_zzffu.zzpgr.zzbiy();
            return com_google_android_gms_internal_zzffu;
        } catch (RuntimeException e) {
            if (e.getCause() instanceof zzfge) {
                throw ((zzfge) e.getCause());
            }
            throw e;
        }
    }

    protected static <T extends zzffu<T, ?>> T zza(T t, byte[] bArr) throws zzfge {
        t = zza((zzffu) t, bArr, zzffm.zzcxb());
        if (t != null) {
            boolean booleanValue = Boolean.TRUE.booleanValue();
            byte byteValue = ((Byte) t.zza(zzg.zzphe, null, null)).byteValue();
            Object obj = null;
            if (byteValue == (byte) 1) {
                obj = 1;
            } else if (byteValue != (byte) 0) {
                if (t.zza(zzg.zzphc, Boolean.FALSE, null) != null) {
                    obj = 1;
                }
                if (booleanValue) {
                    t.zza(zzg.zzphf, obj != null ? t : null, null);
                }
            }
            if (obj == null) {
                throw new zzfim(t).zzczt().zzi(t);
            }
        }
        return t;
    }

    private static <T extends zzffu<T, ?>> T zza(T t, byte[] bArr, zzffm com_google_android_gms_internal_zzffm) throws zzfge {
        try {
            zzffb zzbb = zzffb.zzbb(bArr);
            t = zza((zzffu) t, zzbb, com_google_android_gms_internal_zzffm);
            zzbb.zzkp(0);
            return t;
        } catch (zzfge e) {
            throw e.zzi(t);
        } catch (zzfge e2) {
            throw e2;
        }
    }

    static Object zza(Method method, Object obj, Object... objArr) {
        Throwable e;
        try {
            return method.invoke(obj, objArr);
        } catch (Throwable e2) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e2);
        } catch (InvocationTargetException e3) {
            e2 = e3.getCause();
            if (e2 instanceof RuntimeException) {
                throw ((RuntimeException) e2);
            } else if (e2 instanceof Error) {
                throw ((Error) e2);
            } else {
                throw new RuntimeException("Unexpected exception thrown by generated accessor method.", e2);
            }
        }
    }

    protected static final <T extends zzffu<T, ?>> boolean zza(T t, boolean z) {
        byte byteValue = ((Byte) t.zza(zzg.zzphe, null, null)).byteValue();
        return byteValue == (byte) 1 ? true : byteValue == (byte) 0 ? false : t.zza(zzg.zzphc, Boolean.FALSE, null) != null;
    }

    protected static zzfgc zzcxn() {
        return zzffy.zzcxz();
    }

    protected static <E> zzfgd<E> zzcxo() {
        return zzfho.zzcza();
    }

    public boolean equals(java.lang.Object r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r4 = this;
        r0 = 1;
        if (r4 != r5) goto L_0x0004;
    L_0x0003:
        return r0;
    L_0x0004:
        r1 = com.google.android.gms.internal.zzffu.zzg.zzphk;
        r2 = 0;
        r1 = r4.zza(r1, r2, r2);
        r1 = (com.google.android.gms.internal.zzffu) r1;
        r1 = r1.getClass();
        r1 = r1.isInstance(r5);
        r2 = 0;
        if (r1 != 0) goto L_0x0019;
    L_0x0018:
        return r2;
    L_0x0019:
        r1 = com.google.android.gms.internal.zzffu.zzc.zzpgx;	 Catch:{ zzffv -> 0x002d }
        r5 = (com.google.android.gms.internal.zzffu) r5;	 Catch:{ zzffv -> 0x002d }
        r3 = com.google.android.gms.internal.zzffu.zzg.zzphd;	 Catch:{ zzffv -> 0x002d }
        r4.zza(r3, r1, r5);	 Catch:{ zzffv -> 0x002d }
        r3 = r4.zzpgr;	 Catch:{ zzffv -> 0x002d }
        r5 = r5.zzpgr;	 Catch:{ zzffv -> 0x002d }
        r5 = r1.zza(r3, r5);	 Catch:{ zzffv -> 0x002d }
        r4.zzpgr = r5;	 Catch:{ zzffv -> 0x002d }
        return r0;
    L_0x002d:
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzffu.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        if (this.zzpfa != 0) {
            return this.zzpfa;
        }
        Object com_google_android_gms_internal_zzffu_zze = new zze();
        zza(zzg.zzphd, com_google_android_gms_internal_zzffu_zze, (Object) this);
        this.zzpgr = com_google_android_gms_internal_zzffu_zze.zza(this.zzpgr, this.zzpgr);
        this.zzpfa = com_google_android_gms_internal_zzffu_zze.zzpha;
        return this.zzpfa;
    }

    public final boolean isInitialized() {
        boolean booleanValue = Boolean.TRUE.booleanValue();
        byte byteValue = ((Byte) zza(zzg.zzphe, null, null)).byteValue();
        boolean z = true;
        if (byteValue == (byte) 1) {
            return true;
        }
        if (byteValue == (byte) 0) {
            return false;
        }
        if (zza(zzg.zzphc, Boolean.FALSE, null) == null) {
            z = false;
        }
        if (booleanValue) {
            zza(zzg.zzphf, z ? this : null, null);
        }
        return z;
    }

    public String toString() {
        return zzfhh.zza(this, super.toString());
    }

    protected abstract Object zza(int i, Object obj, Object obj2);

    public void zza(zzffg com_google_android_gms_internal_zzffg) throws IOException {
        zzfhn.zzcyz().zzl(getClass()).zza(this, zzffi.zzb(com_google_android_gms_internal_zzffg));
    }

    protected final boolean zza(int i, zzffb com_google_android_gms_internal_zzffb) throws IOException {
        if ((i & 7) == 4) {
            return false;
        }
        if (this.zzpgr == zzfio.zzczu()) {
            this.zzpgr = zzfio.zzczv();
        }
        return this.zzpgr.zzb(i, com_google_android_gms_internal_zzffb);
    }

    public final zzfhk<MessageType> zzcxm() {
        return (zzfhk) zza(zzg.zzphl, null, null);
    }

    public final /* synthetic */ zzfhf zzcxp() {
        zza com_google_android_gms_internal_zzffu_zza = (zza) zza(zzg.zzphj, null, null);
        com_google_android_gms_internal_zzffu_zza.zza(this);
        return com_google_android_gms_internal_zzffu_zza;
    }

    public final /* synthetic */ zzfhe zzcxq() {
        return (zzffu) zza(zzg.zzphk, null, null);
    }

    public int zzho() {
        if (this.zzpgs == -1) {
            this.zzpgs = zzfhn.zzcyz().zzl(getClass()).zzcp(this);
        }
        return this.zzpgs;
    }
}
