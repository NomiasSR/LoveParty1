package com.google.android.gms.internal;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.WorkerThread;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.common.util.zzd;
import com.google.android.gms.measurement.AppMeasurement.Event;
import com.google.android.gms.measurement.AppMeasurement.UserProperty;
import com.google.firebase.analytics.FirebaseAnalytics.Param;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import javax.security.auth.x500.X500Principal;

public final class zzclq extends zzcjl {
    private static String[] zzjjn = new String[]{"firebase_"};
    private SecureRandom zzjjo;
    private final AtomicLong zzjjp = new AtomicLong(0);
    private int zzjjq;

    zzclq(zzcim com_google_android_gms_internal_zzcim) {
        super(com_google_android_gms_internal_zzcim);
    }

    private final int zza(String str, Object obj, boolean z) {
        if (z) {
            int length;
            String str2 = "param";
            int i = 1;
            if (obj instanceof Parcelable[]) {
                length = ((Parcelable[]) obj).length;
            } else {
                if (obj instanceof ArrayList) {
                    length = ((ArrayList) obj).size();
                }
                if (i == 0) {
                    return 17;
                }
            }
            if (length > 1000) {
                zzawy().zzazf().zzd("Parameter array is too long; discarded. Value kind, name, array length", str2, str, Integer.valueOf(length));
                i = 0;
            }
            if (i == 0) {
                return 17;
            }
        }
        return zzki(str) ? zza("param", str, 256, obj, z) : zza("param", str, 100, obj, z) ? 0 : 4;
    }

    private static Object zza(int i, Object obj, boolean z) {
        if (obj == null) {
            return null;
        }
        if ((obj instanceof Long) || (obj instanceof Double)) {
            return obj;
        }
        if (obj instanceof Integer) {
            return Long.valueOf((long) ((Integer) obj).intValue());
        }
        if (obj instanceof Byte) {
            return Long.valueOf((long) ((Byte) obj).byteValue());
        }
        if (obj instanceof Short) {
            return Long.valueOf((long) ((Short) obj).shortValue());
        }
        if (obj instanceof Boolean) {
            return Long.valueOf(((Boolean) obj).booleanValue() ? 1 : 0);
        } else if (obj instanceof Float) {
            return Double.valueOf(((Float) obj).doubleValue());
        } else {
            if (!((obj instanceof String) || (obj instanceof Character))) {
                if (!(obj instanceof CharSequence)) {
                    return null;
                }
            }
            return zza(String.valueOf(obj), i, z);
        }
    }

    public static Object zza(zzcmb com_google_android_gms_internal_zzcmb, String str) {
        for (zzcmc com_google_android_gms_internal_zzcmc : com_google_android_gms_internal_zzcmb.zzjlh) {
            if (com_google_android_gms_internal_zzcmc.name.equals(str)) {
                if (com_google_android_gms_internal_zzcmc.zzgcc != null) {
                    return com_google_android_gms_internal_zzcmc.zzgcc;
                }
                if (com_google_android_gms_internal_zzcmc.zzjll != null) {
                    return com_google_android_gms_internal_zzcmc.zzjll;
                }
                if (com_google_android_gms_internal_zzcmc.zzjjl != null) {
                    return com_google_android_gms_internal_zzcmc.zzjjl;
                }
            }
        }
        return null;
    }

    public static String zza(String str, int i, boolean z) {
        if (str.codePointCount(0, str.length()) > i) {
            if (z) {
                return String.valueOf(str.substring(0, str.offsetByCodePoints(0, i))).concat("...");
            }
            str = null;
        }
        return str;
    }

    @Nullable
    public static String zza(String str, String[] strArr, String[] strArr2) {
        zzbq.checkNotNull(strArr);
        zzbq.checkNotNull(strArr2);
        int min = Math.min(strArr.length, strArr2.length);
        for (int i = 0; i < min; i++) {
            if (zzas(str, strArr[i])) {
                return strArr2[i];
            }
        }
        return null;
    }

    private final boolean zza(String str, String str2, int i, Object obj, boolean z) {
        if (obj == null || (obj instanceof Long) || (obj instanceof Float) || (obj instanceof Integer) || (obj instanceof Byte) || (obj instanceof Short) || (obj instanceof Boolean) || (obj instanceof Double)) {
            return true;
        }
        if (!((obj instanceof String) || (obj instanceof Character))) {
            if (!(obj instanceof CharSequence)) {
                if ((obj instanceof Bundle) && z) {
                    return true;
                }
                int length;
                Object obj2;
                if ((obj instanceof Parcelable[]) && z) {
                    Parcelable[] parcelableArr = (Parcelable[]) obj;
                    length = parcelableArr.length;
                    i = 0;
                    while (i < length) {
                        obj2 = parcelableArr[i];
                        if (obj2 instanceof Bundle) {
                            i++;
                        } else {
                            zzawy().zzazf().zze("All Parcelable[] elements must be of type Bundle. Value type, name", obj2.getClass(), str2);
                            return false;
                        }
                    }
                    return true;
                } else if (!(obj instanceof ArrayList) || !z) {
                    return false;
                } else {
                    ArrayList arrayList = (ArrayList) obj;
                    length = arrayList.size();
                    i = 0;
                    while (i < length) {
                        obj2 = arrayList.get(i);
                        i++;
                        if (!(obj2 instanceof Bundle)) {
                            zzawy().zzazf().zze("All ArrayList elements must be of type Bundle. Value type, name", obj2.getClass(), str2);
                            return false;
                        }
                    }
                    return true;
                }
            }
        }
        String valueOf = String.valueOf(obj);
        if (valueOf.codePointCount(0, valueOf.length()) > i) {
            zzawy().zzazf().zzd("Value is too long; discarded. Value kind, name, value length", str, str2, Integer.valueOf(valueOf.length()));
            return false;
        }
        return true;
    }

    private final boolean zza(String str, String[] strArr, String str2) {
        if (str2 == null) {
            zzawy().zzazd().zzj("Name is required and can't be null. Type", str);
            return false;
        }
        boolean z;
        zzbq.checkNotNull(str2);
        for (String startsWith : zzjjn) {
            if (str2.startsWith(startsWith)) {
                z = true;
                break;
            }
        }
        z = false;
        if (z) {
            zzawy().zzazd().zze("Name starts with reserved prefix. Type, name", str, str2);
            return false;
        }
        if (strArr != null) {
            boolean z2;
            zzbq.checkNotNull(strArr);
            for (String startsWith2 : strArr) {
                if (zzas(str2, startsWith2)) {
                    z2 = true;
                    break;
                }
            }
            z2 = false;
            if (z2) {
                zzawy().zzazd().zze("Name is reserved. Type, name", str, str2);
                return false;
            }
        }
        return true;
    }

    public static boolean zza(long[] jArr, int i) {
        if (i >= (jArr.length << 6)) {
            return false;
        }
        return ((1 << (i % 64)) & jArr[i / 64]) != 0;
    }

    static byte[] zza(Parcelable parcelable) {
        if (parcelable == null) {
            return null;
        }
        Parcel obtain = Parcel.obtain();
        try {
            parcelable.writeToParcel(obtain, 0);
            byte[] marshall = obtain.marshall();
            return marshall;
        } finally {
            obtain.recycle();
        }
    }

    public static long[] zza(BitSet bitSet) {
        int length = (bitSet.length() + 63) / 64;
        long[] jArr = new long[length];
        for (int i = 0; i < length; i++) {
            jArr[i] = 0;
            for (int i2 = 0; i2 < 64; i2++) {
                int i3 = (i << 6) + i2;
                if (i3 >= bitSet.length()) {
                    break;
                }
                if (bitSet.get(i3)) {
                    jArr[i] = jArr[i] | (1 << i2);
                }
            }
        }
        return jArr;
    }

    static zzcmc[] zza(zzcmc[] com_google_android_gms_internal_zzcmcArr, String str, Object obj) {
        for (zzcmc com_google_android_gms_internal_zzcmc : com_google_android_gms_internal_zzcmcArr) {
            if (Objects.equals(com_google_android_gms_internal_zzcmc.name, str)) {
                com_google_android_gms_internal_zzcmc.zzjll = null;
                com_google_android_gms_internal_zzcmc.zzgcc = null;
                com_google_android_gms_internal_zzcmc.zzjjl = null;
                if (obj instanceof Long) {
                    com_google_android_gms_internal_zzcmc.zzjll = (Long) obj;
                    return com_google_android_gms_internal_zzcmcArr;
                } else if (obj instanceof String) {
                    com_google_android_gms_internal_zzcmc.zzgcc = (String) obj;
                    return com_google_android_gms_internal_zzcmcArr;
                } else {
                    if (obj instanceof Double) {
                        com_google_android_gms_internal_zzcmc.zzjjl = (Double) obj;
                    }
                    return com_google_android_gms_internal_zzcmcArr;
                }
            }
        }
        Object obj2 = new zzcmc[(com_google_android_gms_internal_zzcmcArr.length + 1)];
        System.arraycopy(com_google_android_gms_internal_zzcmcArr, 0, obj2, 0, com_google_android_gms_internal_zzcmcArr.length);
        zzcmc com_google_android_gms_internal_zzcmc2 = new zzcmc();
        com_google_android_gms_internal_zzcmc2.name = str;
        if (obj instanceof Long) {
            com_google_android_gms_internal_zzcmc2.zzjll = (Long) obj;
        } else if (obj instanceof String) {
            com_google_android_gms_internal_zzcmc2.zzgcc = (String) obj;
        } else if (obj instanceof Double) {
            com_google_android_gms_internal_zzcmc2.zzjjl = (Double) obj;
        }
        obj2[com_google_android_gms_internal_zzcmcArr.length] = com_google_android_gms_internal_zzcmc2;
        return obj2;
    }

    public static Bundle[] zzaf(Object obj) {
        if (obj instanceof Bundle) {
            return new Bundle[]{(Bundle) obj};
        }
        Object[] copyOf;
        if (obj instanceof Parcelable[]) {
            Parcelable[] parcelableArr = (Parcelable[]) obj;
            copyOf = Arrays.copyOf(parcelableArr, parcelableArr.length, Bundle[].class);
        } else if (!(obj instanceof ArrayList)) {
            return null;
        } else {
            ArrayList arrayList = (ArrayList) obj;
            copyOf = arrayList.toArray(new Bundle[arrayList.size()]);
        }
        return (Bundle[]) copyOf;
    }

    public static java.lang.Object zzag(java.lang.Object r4) {
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
        r0 = 0;
        if (r4 != 0) goto L_0x0004;
    L_0x0003:
        return r0;
    L_0x0004:
        r1 = new java.io.ByteArrayOutputStream;	 Catch:{ all -> 0x0032 }
        r1.<init>();	 Catch:{ all -> 0x0032 }
        r2 = new java.io.ObjectOutputStream;	 Catch:{ all -> 0x0032 }
        r2.<init>(r1);	 Catch:{ all -> 0x0032 }
        r2.writeObject(r4);	 Catch:{ all -> 0x002f }
        r2.flush();	 Catch:{ all -> 0x002f }
        r4 = new java.io.ObjectInputStream;	 Catch:{ all -> 0x002f }
        r3 = new java.io.ByteArrayInputStream;	 Catch:{ all -> 0x002f }
        r1 = r1.toByteArray();	 Catch:{ all -> 0x002f }
        r3.<init>(r1);	 Catch:{ all -> 0x002f }
        r4.<init>(r3);	 Catch:{ all -> 0x002f }
        r1 = r4.readObject();	 Catch:{ all -> 0x002d }
        r2.close();	 Catch:{ IOException -> 0x0040, IOException -> 0x0040 }
        r4.close();	 Catch:{ IOException -> 0x0040, IOException -> 0x0040 }
        return r1;	 Catch:{ IOException -> 0x0040, IOException -> 0x0040 }
    L_0x002d:
        r1 = move-exception;	 Catch:{ IOException -> 0x0040, IOException -> 0x0040 }
        goto L_0x0035;	 Catch:{ IOException -> 0x0040, IOException -> 0x0040 }
    L_0x002f:
        r1 = move-exception;	 Catch:{ IOException -> 0x0040, IOException -> 0x0040 }
        r4 = r0;	 Catch:{ IOException -> 0x0040, IOException -> 0x0040 }
        goto L_0x0035;	 Catch:{ IOException -> 0x0040, IOException -> 0x0040 }
    L_0x0032:
        r1 = move-exception;	 Catch:{ IOException -> 0x0040, IOException -> 0x0040 }
        r4 = r0;	 Catch:{ IOException -> 0x0040, IOException -> 0x0040 }
        r2 = r4;	 Catch:{ IOException -> 0x0040, IOException -> 0x0040 }
    L_0x0035:
        if (r2 == 0) goto L_0x003a;	 Catch:{ IOException -> 0x0040, IOException -> 0x0040 }
    L_0x0037:
        r2.close();	 Catch:{ IOException -> 0x0040, IOException -> 0x0040 }
    L_0x003a:
        if (r4 == 0) goto L_0x003f;	 Catch:{ IOException -> 0x0040, IOException -> 0x0040 }
    L_0x003c:
        r4.close();	 Catch:{ IOException -> 0x0040, IOException -> 0x0040 }
    L_0x003f:
        throw r1;	 Catch:{ IOException -> 0x0040, IOException -> 0x0040 }
    L_0x0040:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzclq.zzag(java.lang.Object):java.lang.Object");
    }

    private final boolean zzag(Context context, String str) {
        Object e;
        zzcho zzazd;
        String str2;
        X500Principal x500Principal = new X500Principal("CN=Android Debug,O=Android,C=US");
        try {
            PackageInfo packageInfo = zzbhf.zzdb(context).getPackageInfo(str, 64);
            if (!(packageInfo == null || packageInfo.signatures == null || packageInfo.signatures.length <= 0)) {
                return ((X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(packageInfo.signatures[0].toByteArray()))).getSubjectX500Principal().equals(x500Principal);
            }
        } catch (CertificateException e2) {
            e = e2;
            zzazd = zzawy().zzazd();
            str2 = "Error obtaining certificate";
            zzazd.zzj(str2, e);
            return true;
        } catch (NameNotFoundException e3) {
            e = e3;
            zzazd = zzawy().zzazd();
            str2 = "Package name not found";
            zzazd.zzj(str2, e);
            return true;
        }
        return true;
    }

    private final boolean zzaq(String str, String str2) {
        if (str2 == null) {
            zzawy().zzazd().zzj("Name is required and can't be null. Type", str);
            return false;
        } else if (str2.length() == 0) {
            zzawy().zzazd().zzj("Name is required and can't be empty. Type", str);
            return false;
        } else {
            int codePointAt = str2.codePointAt(0);
            if (Character.isLetter(codePointAt)) {
                int length = str2.length();
                codePointAt = Character.charCount(codePointAt);
                while (codePointAt < length) {
                    int codePointAt2 = str2.codePointAt(codePointAt);
                    if (codePointAt2 == 95 || Character.isLetterOrDigit(codePointAt2)) {
                        codePointAt += Character.charCount(codePointAt2);
                    } else {
                        zzawy().zzazd().zze("Name must consist of letters, digits or _ (underscores). Type, name", str, str2);
                        return false;
                    }
                }
                return true;
            }
            zzawy().zzazd().zze("Name must start with a letter. Type, name", str, str2);
            return false;
        }
    }

    private final boolean zzar(String str, String str2) {
        if (str2 == null) {
            zzawy().zzazd().zzj("Name is required and can't be null. Type", str);
            return false;
        } else if (str2.length() == 0) {
            zzawy().zzazd().zzj("Name is required and can't be empty. Type", str);
            return false;
        } else {
            int codePointAt = str2.codePointAt(0);
            if (Character.isLetter(codePointAt) || codePointAt == 95) {
                int length = str2.length();
                codePointAt = Character.charCount(codePointAt);
                while (codePointAt < length) {
                    int codePointAt2 = str2.codePointAt(codePointAt);
                    if (codePointAt2 == 95 || Character.isLetterOrDigit(codePointAt2)) {
                        codePointAt += Character.charCount(codePointAt2);
                    } else {
                        zzawy().zzazd().zze("Name must consist of letters, digits or _ (underscores). Type, name", str, str2);
                        return false;
                    }
                }
                return true;
            }
            zzawy().zzazd().zze("Name must start with a letter or _ (underscore). Type, name", str, str2);
            return false;
        }
    }

    public static boolean zzas(String str, String str2) {
        return (str == null && str2 == null) ? true : str == null ? false : str.equals(str2);
    }

    private static void zzb(Bundle bundle, Object obj) {
        zzbq.checkNotNull(bundle);
        if (obj == null) {
            return;
        }
        if ((obj instanceof String) || (obj instanceof CharSequence)) {
            bundle.putLong("_el", (long) String.valueOf(obj).length());
        }
    }

    private final boolean zzb(String str, int i, String str2) {
        if (str2 == null) {
            zzawy().zzazd().zzj("Name is required and can't be null. Type", str);
            return false;
        } else if (str2.codePointCount(0, str2.length()) <= i) {
            return true;
        } else {
            zzawy().zzazd().zzd("Name is too long. Type, maximum supported length, name", str, Integer.valueOf(i), str2);
            return false;
        }
    }

    private static boolean zzd(Bundle bundle, int i) {
        if (bundle.getLong("_err") != 0) {
            return false;
        }
        bundle.putLong("_err", (long) i);
        return true;
    }

    @WorkerThread
    static boolean zzd(zzcha com_google_android_gms_internal_zzcha, zzcgi com_google_android_gms_internal_zzcgi) {
        zzbq.checkNotNull(com_google_android_gms_internal_zzcha);
        zzbq.checkNotNull(com_google_android_gms_internal_zzcgi);
        return !TextUtils.isEmpty(com_google_android_gms_internal_zzcgi.zzixs);
    }

    static java.security.MessageDigest zzek(java.lang.String r2) {
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
        r0 = 0;
    L_0x0001:
        r1 = 2;
        if (r0 >= r1) goto L_0x000e;
    L_0x0004:
        r1 = java.security.MessageDigest.getInstance(r2);	 Catch:{ NoSuchAlgorithmException -> 0x000b }
        if (r1 == 0) goto L_0x000b;
    L_0x000a:
        return r1;
    L_0x000b:
        r0 = r0 + 1;
        goto L_0x0001;
    L_0x000e:
        r2 = 0;
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzclq.zzek(java.lang.String):java.security.MessageDigest");
    }

    static boolean zzjz(String str) {
        zzbq.zzgm(str);
        if (str.charAt(0) == '_') {
            if (!str.equals("_ep")) {
                return false;
            }
        }
        return true;
    }

    private final int zzke(String str) {
        return !zzaq("event param", str) ? 3 : !zza("event param", null, str) ? 14 : !zzb("event param", 40, str) ? 3 : 0;
    }

    private final int zzkf(String str) {
        return !zzar("event param", str) ? 3 : !zza("event param", null, str) ? 14 : !zzb("event param", 40, str) ? 3 : 0;
    }

    private static int zzkh(String str) {
        return "_ldl".equals(str) ? 2048 : 36;
    }

    public static boolean zzki(String str) {
        return !TextUtils.isEmpty(str) && str.startsWith("_");
    }

    static boolean zzkk(String str) {
        return str != null && str.matches("(\\+|-)?([0-9]+\\.?[0-9]*|[0-9]*\\.?[0-9]+)") && str.length() <= 310;
    }

    @WorkerThread
    static boolean zzkn(String str) {
        boolean z;
        zzbq.zzgm(str);
        int hashCode = str.hashCode();
        if (hashCode != 94660) {
            if (hashCode != 95025) {
                if (hashCode == 95027) {
                    if (str.equals("_ui")) {
                        z = true;
                        switch (z) {
                            case false:
                            case true:
                            case true:
                                return true;
                            default:
                                return false;
                        }
                    }
                }
            } else if (str.equals("_ug")) {
                z = true;
                switch (z) {
                    case false:
                    case true:
                    case true:
                        return true;
                    default:
                        return false;
                }
            }
        } else if (str.equals("_in")) {
            z = false;
            switch (z) {
                case false:
                case true:
                case true:
                    return true;
                default:
                    return false;
            }
        }
        z = true;
        switch (z) {
            case false:
            case true:
            case true:
                return true;
            default:
                return false;
        }
    }

    public static boolean zzo(Intent intent) {
        String stringExtra = intent.getStringExtra("android.intent.extra.REFERRER_NAME");
        if (!("android-app://com.google.android.googlequicksearchbox/https/www.google.com".equals(stringExtra) || "https://www.google.com".equals(stringExtra))) {
            if (!"android-app://com.google.appcrawler".equals(stringExtra)) {
                return false;
            }
        }
        return true;
    }

    static long zzs(byte[] bArr) {
        zzbq.checkNotNull(bArr);
        long j = null;
        zzbq.checkState(bArr.length > 0);
        long j2 = 0;
        int length = bArr.length - 1;
        while (length >= 0 && length >= bArr.length - 8) {
            j2 += (((long) bArr[length]) & 255) << j;
            j += 8;
            length--;
        }
        return j2;
    }

    public static boolean zzt(android.content.Context r3, java.lang.String r4) {
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
        r0 = 0;
        r1 = r3.getPackageManager();	 Catch:{ NameNotFoundException -> 0x001a }
        if (r1 != 0) goto L_0x0008;	 Catch:{ NameNotFoundException -> 0x001a }
    L_0x0007:
        return r0;	 Catch:{ NameNotFoundException -> 0x001a }
    L_0x0008:
        r2 = new android.content.ComponentName;	 Catch:{ NameNotFoundException -> 0x001a }
        r2.<init>(r3, r4);	 Catch:{ NameNotFoundException -> 0x001a }
        r3 = 4;	 Catch:{ NameNotFoundException -> 0x001a }
        r3 = r1.getServiceInfo(r2, r3);	 Catch:{ NameNotFoundException -> 0x001a }
        if (r3 == 0) goto L_0x001a;	 Catch:{ NameNotFoundException -> 0x001a }
    L_0x0014:
        r3 = r3.enabled;	 Catch:{ NameNotFoundException -> 0x001a }
        if (r3 == 0) goto L_0x001a;
    L_0x0018:
        r3 = 1;
        return r3;
    L_0x001a:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzclq.zzt(android.content.Context, java.lang.String):boolean");
    }

    public final /* bridge */ /* synthetic */ Context getContext() {
        return super.getContext();
    }

    public final Bundle zza(String str, Bundle bundle, @Nullable List<String> list, boolean z, boolean z2) {
        if (bundle == null) {
            return null;
        }
        Bundle bundle2 = new Bundle(bundle);
        int i = 0;
        for (String str2 : bundle.keySet()) {
            int i2;
            if (list != null) {
                if (list.contains(str2)) {
                    i2 = 0;
                    if (i2 != 0) {
                        i2 = zza(str2, bundle.get(str2), z2);
                        if (i2 != 0 || "_ev".equals(str2)) {
                            if (zzjz(str2)) {
                                i++;
                                if (i > 25) {
                                    StringBuilder stringBuilder = new StringBuilder(48);
                                    stringBuilder.append("Event can't contain more then 25 params");
                                    zzawy().zzazd().zze(stringBuilder.toString(), zzawt().zzjh(str), zzawt().zzx(bundle));
                                    zzd(bundle2, 5);
                                }
                            }
                        } else if (zzd(bundle2, i2)) {
                            bundle2.putString("_ev", zza(str2, 40, true));
                            zzb(bundle2, bundle.get(str2));
                        }
                    } else if (zzd(bundle2, i2)) {
                        bundle2.putString("_ev", zza(str2, 40, true));
                        if (i2 == 3) {
                            zzb(bundle2, (Object) str2);
                        }
                    }
                    bundle2.remove(str2);
                }
            }
            i2 = z ? zzke(str2) : 0;
            if (i2 == 0) {
                i2 = zzkf(str2);
            }
            if (i2 != 0) {
                i2 = zza(str2, bundle.get(str2), z2);
                if (i2 != 0) {
                }
                if (zzjz(str2)) {
                    i++;
                    if (i > 25) {
                        StringBuilder stringBuilder2 = new StringBuilder(48);
                        stringBuilder2.append("Event can't contain more then 25 params");
                        zzawy().zzazd().zze(stringBuilder2.toString(), zzawt().zzjh(str), zzawt().zzx(bundle));
                        zzd(bundle2, 5);
                    }
                }
            } else if (zzd(bundle2, i2)) {
                bundle2.putString("_ev", zza(str2, 40, true));
                if (i2 == 3) {
                    zzb(bundle2, (Object) str2);
                }
            }
            bundle2.remove(str2);
        }
        return bundle2;
    }

    final zzcha zza(String str, Bundle bundle, String str2, long j, boolean z, boolean z2) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (zzkb(str) != 0) {
            zzawy().zzazd().zzj("Invalid conditional property event name", zzawt().zzjj(str));
            throw new IllegalArgumentException();
        }
        Bundle bundle2 = bundle != null ? new Bundle(bundle) : new Bundle();
        bundle2.putString("_o", str2);
        String str3 = str;
        return new zzcha(str3, new zzcgx(zzy(zza(str3, bundle2, Collections.singletonList("_o"), false, false))), str2, j);
    }

    public final void zza(int i, String str, String str2, int i2) {
        zza(null, i, str, str2, i2);
    }

    public final void zza(Bundle bundle, String str, Object obj) {
        if (bundle != null) {
            if (obj instanceof Long) {
                bundle.putLong(str, ((Long) obj).longValue());
            } else if (obj instanceof String) {
                bundle.putString(str, String.valueOf(obj));
            } else if (obj instanceof Double) {
                bundle.putDouble(str, ((Double) obj).doubleValue());
            } else {
                if (str != null) {
                    zzawy().zzazg().zze("Not putting event parameter. Invalid value type. name, type", zzawt().zzji(str), obj != null ? obj.getClass().getSimpleName() : null);
                }
            }
        }
    }

    public final void zza(zzcmc com_google_android_gms_internal_zzcmc, Object obj) {
        zzbq.checkNotNull(obj);
        com_google_android_gms_internal_zzcmc.zzgcc = null;
        com_google_android_gms_internal_zzcmc.zzjll = null;
        com_google_android_gms_internal_zzcmc.zzjjl = null;
        if (obj instanceof String) {
            com_google_android_gms_internal_zzcmc.zzgcc = (String) obj;
        } else if (obj instanceof Long) {
            com_google_android_gms_internal_zzcmc.zzjll = (Long) obj;
        } else if (obj instanceof Double) {
            com_google_android_gms_internal_zzcmc.zzjjl = (Double) obj;
        } else {
            zzawy().zzazd().zzj("Ignoring invalid (type) event param value", obj);
        }
    }

    public final void zza(zzcmg com_google_android_gms_internal_zzcmg, Object obj) {
        zzbq.checkNotNull(obj);
        com_google_android_gms_internal_zzcmg.zzgcc = null;
        com_google_android_gms_internal_zzcmg.zzjll = null;
        com_google_android_gms_internal_zzcmg.zzjjl = null;
        if (obj instanceof String) {
            com_google_android_gms_internal_zzcmg.zzgcc = (String) obj;
        } else if (obj instanceof Long) {
            com_google_android_gms_internal_zzcmg.zzjll = (Long) obj;
        } else if (obj instanceof Double) {
            com_google_android_gms_internal_zzcmg.zzjjl = (Double) obj;
        } else {
            zzawy().zzazd().zzj("Ignoring invalid (type) user attribute value", obj);
        }
    }

    public final void zza(String str, int i, String str2, String str3, int i2) {
        Bundle bundle = new Bundle();
        zzd(bundle, i);
        if (!TextUtils.isEmpty(str2)) {
            bundle.putString(str2, str3);
        }
        if (i == 6 || i == 7 || i == 2) {
            bundle.putLong("_el", (long) i2);
        }
        this.zziwf.zzawm().zzc("auto", "_err", bundle);
    }

    @WorkerThread
    final long zzaf(Context context, String str) {
        zzve();
        zzbq.checkNotNull(context);
        zzbq.zzgm(str);
        PackageManager packageManager = context.getPackageManager();
        MessageDigest zzek = zzek("MD5");
        if (zzek == null) {
            zzawy().zzazd().log("Could not get MD5 instance");
            return -1;
        }
        if (packageManager != null) {
            try {
                if (!zzag(context, str)) {
                    PackageInfo packageInfo = zzbhf.zzdb(context).getPackageInfo(getContext().getPackageName(), 64);
                    if (packageInfo.signatures != null && packageInfo.signatures.length > 0) {
                        return zzs(zzek.digest(packageInfo.signatures[0].toByteArray()));
                    }
                    zzawy().zzazf().log("Could not get signatures");
                    return -1;
                }
            } catch (NameNotFoundException e) {
                zzawy().zzazd().zzj("Package name not found", e);
            }
        }
        return 0;
    }

    public final /* bridge */ /* synthetic */ void zzawi() {
        super.zzawi();
    }

    public final /* bridge */ /* synthetic */ void zzawj() {
        super.zzawj();
    }

    public final /* bridge */ /* synthetic */ zzcgd zzawk() {
        return super.zzawk();
    }

    public final /* bridge */ /* synthetic */ zzcgk zzawl() {
        return super.zzawl();
    }

    public final /* bridge */ /* synthetic */ zzcjn zzawm() {
        return super.zzawm();
    }

    public final /* bridge */ /* synthetic */ zzchh zzawn() {
        return super.zzawn();
    }

    public final /* bridge */ /* synthetic */ zzcgu zzawo() {
        return super.zzawo();
    }

    public final /* bridge */ /* synthetic */ zzckg zzawp() {
        return super.zzawp();
    }

    public final /* bridge */ /* synthetic */ zzckc zzawq() {
        return super.zzawq();
    }

    public final /* bridge */ /* synthetic */ zzchi zzawr() {
        return super.zzawr();
    }

    public final /* bridge */ /* synthetic */ zzcgo zzaws() {
        return super.zzaws();
    }

    public final /* bridge */ /* synthetic */ zzchk zzawt() {
        return super.zzawt();
    }

    public final /* bridge */ /* synthetic */ zzclq zzawu() {
        return super.zzawu();
    }

    public final /* bridge */ /* synthetic */ zzcig zzawv() {
        return super.zzawv();
    }

    public final /* bridge */ /* synthetic */ zzclf zzaww() {
        return super.zzaww();
    }

    public final /* bridge */ /* synthetic */ zzcih zzawx() {
        return super.zzawx();
    }

    public final /* bridge */ /* synthetic */ zzchm zzawy() {
        return super.zzawy();
    }

    public final /* bridge */ /* synthetic */ zzchx zzawz() {
        return super.zzawz();
    }

    public final /* bridge */ /* synthetic */ zzcgn zzaxa() {
        return super.zzaxa();
    }

    protected final boolean zzaxz() {
        return true;
    }

    @WorkerThread
    protected final void zzayy() {
        zzve();
        SecureRandom secureRandom = new SecureRandom();
        long nextLong = secureRandom.nextLong();
        if (nextLong == 0) {
            nextLong = secureRandom.nextLong();
            if (nextLong == 0) {
                zzawy().zzazf().log("Utils falling back to Random for random id");
            }
        }
        this.zzjjp.set(nextLong);
    }

    final <T extends android.os.Parcelable> T zzb(byte[] r5, android.os.Parcelable.Creator<T> r6) {
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
        r0 = 0;
        if (r5 != 0) goto L_0x0004;
    L_0x0003:
        return r0;
    L_0x0004:
        r1 = android.os.Parcel.obtain();
        r2 = r5.length;	 Catch:{ zzbfo -> 0x001c }
        r3 = 0;	 Catch:{ zzbfo -> 0x001c }
        r1.unmarshall(r5, r3, r2);	 Catch:{ zzbfo -> 0x001c }
        r1.setDataPosition(r3);	 Catch:{ zzbfo -> 0x001c }
        r5 = r6.createFromParcel(r1);	 Catch:{ zzbfo -> 0x001c }
        r5 = (android.os.Parcelable) r5;	 Catch:{ zzbfo -> 0x001c }
        r1.recycle();
        return r5;
    L_0x001a:
        r5 = move-exception;
        goto L_0x002d;
    L_0x001c:
        r5 = r4.zzawy();	 Catch:{ all -> 0x001a }
        r5 = r5.zzazd();	 Catch:{ all -> 0x001a }
        r6 = "Failed to load parcelable from buffer";	 Catch:{ all -> 0x001a }
        r5.log(r6);	 Catch:{ all -> 0x001a }
        r1.recycle();
        return r0;
    L_0x002d:
        r1.recycle();
        throw r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzclq.zzb(byte[], android.os.Parcelable$Creator):T");
    }

    public final byte[] zzb(zzcmd com_google_android_gms_internal_zzcmd) {
        try {
            byte[] bArr = new byte[com_google_android_gms_internal_zzcmd.zzho()];
            zzfjk zzo = zzfjk.zzo(bArr, 0, bArr.length);
            com_google_android_gms_internal_zzcmd.zza(zzo);
            zzo.zzcwt();
            return bArr;
        } catch (IOException e) {
            zzawy().zzazd().zzj("Data loss. Failed to serialize batch", e);
            return null;
        }
    }

    public final long zzbay() {
        long nextLong;
        if (this.zzjjp.get() == 0) {
            synchronized (this.zzjjp) {
                nextLong = new Random(System.nanoTime() ^ zzws().currentTimeMillis()).nextLong();
                int i = this.zzjjq + 1;
                this.zzjjq = i;
                nextLong += (long) i;
            }
            return nextLong;
        }
        synchronized (this.zzjjp) {
            this.zzjjp.compareAndSet(-1, 1);
            nextLong = this.zzjjp.getAndIncrement();
        }
        return nextLong;
    }

    @WorkerThread
    final SecureRandom zzbaz() {
        zzve();
        if (this.zzjjo == null) {
            this.zzjjo = new SecureRandom();
        }
        return this.zzjjo;
    }

    @WorkerThread
    public final boolean zzeb(String str) {
        zzve();
        if (zzbhf.zzdb(getContext()).checkCallingOrSelfPermission(str) == 0) {
            return true;
        }
        zzawy().zzazi().zzj("Permission not granted", str);
        return false;
    }

    public final boolean zzf(long j, long j2) {
        return j == 0 || j2 <= 0 || Math.abs(zzws().currentTimeMillis() - j) > j2;
    }

    public final Object zzk(String str, Object obj) {
        boolean z;
        int i = 256;
        if ("_ev".equals(str)) {
            z = true;
        } else {
            if (!zzki(str)) {
                i = 100;
            }
            z = false;
        }
        return zza(i, obj, z);
    }

    public final int zzka(String str) {
        return !zzaq(NotificationCompat.CATEGORY_EVENT, str) ? 2 : !zza(NotificationCompat.CATEGORY_EVENT, Event.zziwg, str) ? 13 : !zzb(NotificationCompat.CATEGORY_EVENT, 40, str) ? 2 : 0;
    }

    public final int zzkb(String str) {
        return !zzar(NotificationCompat.CATEGORY_EVENT, str) ? 2 : !zza(NotificationCompat.CATEGORY_EVENT, Event.zziwg, str) ? 13 : !zzb(NotificationCompat.CATEGORY_EVENT, 40, str) ? 2 : 0;
    }

    public final int zzkc(String str) {
        return !zzaq("user property", str) ? 6 : !zza("user property", UserProperty.zziwn, str) ? 15 : !zzb("user property", 24, str) ? 6 : 0;
    }

    public final int zzkd(String str) {
        return !zzar("user property", str) ? 6 : !zza("user property", UserProperty.zziwn, str) ? 15 : !zzb("user property", 24, str) ? 6 : 0;
    }

    public final boolean zzkg(String str) {
        if (TextUtils.isEmpty(str)) {
            zzawy().zzazd().log("Missing google_app_id. Firebase Analytics disabled. See https://goo.gl/NAOOOI");
            return false;
        }
        zzbq.checkNotNull(str);
        if (str.matches("^1:\\d+:android:[a-f0-9]+$")) {
            return true;
        }
        zzawy().zzazd().zzj("Invalid google_app_id. Firebase Analytics disabled. See https://goo.gl/NAOOOI. provided id", str);
        return false;
    }

    public final boolean zzkj(String str) {
        return TextUtils.isEmpty(str) ? false : zzaxa().zzayd().equals(str);
    }

    final boolean zzkl(String str) {
        return "1".equals(zzawv().zzam(str, "measurement.upload.blacklist_internal"));
    }

    final boolean zzkm(String str) {
        return "1".equals(zzawv().zzam(str, "measurement.upload.blacklist_public"));
    }

    public final int zzl(String str, Object obj) {
        return "_ldl".equals(str) ? zza("user property referrer", str, zzkh(str), obj, false) : zza("user property", str, zzkh(str), obj, false) ? 0 : 7;
    }

    public final Object zzm(String str, Object obj) {
        int zzkh;
        boolean z;
        if ("_ldl".equals(str)) {
            zzkh = zzkh(str);
            z = true;
        } else {
            zzkh = zzkh(str);
            z = false;
        }
        return zza(zzkh, obj, z);
    }

    public final Bundle zzp(@NonNull Uri uri) {
        if (uri == null) {
            return null;
        }
        try {
            Object queryParameter;
            Object queryParameter2;
            Object queryParameter3;
            Object queryParameter4;
            if (uri.isHierarchical()) {
                queryParameter = uri.getQueryParameter("utm_campaign");
                queryParameter2 = uri.getQueryParameter("utm_source");
                queryParameter3 = uri.getQueryParameter("utm_medium");
                queryParameter4 = uri.getQueryParameter("gclid");
            } else {
                queryParameter = null;
                queryParameter2 = queryParameter;
                queryParameter3 = queryParameter2;
                queryParameter4 = queryParameter3;
            }
            if (TextUtils.isEmpty(queryParameter) && TextUtils.isEmpty(queryParameter2) && TextUtils.isEmpty(queryParameter3)) {
                if (TextUtils.isEmpty(queryParameter4)) {
                    return null;
                }
            }
            Bundle bundle = new Bundle();
            if (!TextUtils.isEmpty(queryParameter)) {
                bundle.putString(Param.CAMPAIGN, queryParameter);
            }
            if (!TextUtils.isEmpty(queryParameter2)) {
                bundle.putString(Param.SOURCE, queryParameter2);
            }
            if (!TextUtils.isEmpty(queryParameter3)) {
                bundle.putString(Param.MEDIUM, queryParameter3);
            }
            if (!TextUtils.isEmpty(queryParameter4)) {
                bundle.putString("gclid", queryParameter4);
            }
            queryParameter = uri.getQueryParameter("utm_term");
            if (!TextUtils.isEmpty(queryParameter)) {
                bundle.putString(Param.TERM, queryParameter);
            }
            queryParameter = uri.getQueryParameter("utm_content");
            if (!TextUtils.isEmpty(queryParameter)) {
                bundle.putString(Param.CONTENT, queryParameter);
            }
            queryParameter = uri.getQueryParameter(Param.ACLID);
            if (!TextUtils.isEmpty(queryParameter)) {
                bundle.putString(Param.ACLID, queryParameter);
            }
            queryParameter = uri.getQueryParameter(Param.CP1);
            if (!TextUtils.isEmpty(queryParameter)) {
                bundle.putString(Param.CP1, queryParameter);
            }
            Object queryParameter5 = uri.getQueryParameter("anid");
            if (!TextUtils.isEmpty(queryParameter5)) {
                bundle.putString("anid", queryParameter5);
            }
            return bundle;
        } catch (UnsupportedOperationException e) {
            zzawy().zzazf().zzj("Install referrer url isn't a hierarchical URI", e);
            return null;
        }
    }

    public final byte[] zzq(byte[] bArr) throws IOException {
        try {
            OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.close();
            byteArrayOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            zzawy().zzazd().zzj("Failed to gzip content", e);
            throw e;
        }
    }

    public final byte[] zzr(byte[] bArr) throws IOException {
        try {
            InputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            GZIPInputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr2 = new byte[1024];
            while (true) {
                int read = gZIPInputStream.read(bArr2);
                if (read > 0) {
                    byteArrayOutputStream.write(bArr2, 0, read);
                } else {
                    gZIPInputStream.close();
                    byteArrayInputStream.close();
                    return byteArrayOutputStream.toByteArray();
                }
            }
        } catch (IOException e) {
            zzawy().zzazd().zzj("Failed to ungzip content", e);
            throw e;
        }
    }

    public final /* bridge */ /* synthetic */ void zzve() {
        super.zzve();
    }

    public final /* bridge */ /* synthetic */ zzd zzws() {
        return super.zzws();
    }

    final Bundle zzy(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        if (bundle != null) {
            for (String str : bundle.keySet()) {
                Object zzk = zzk(str, bundle.get(str));
                if (zzk == null) {
                    zzawy().zzazf().zzj("Param value can't be null", zzawt().zzji(str));
                } else {
                    zza(bundle2, str, zzk);
                }
            }
        }
        return bundle2;
    }
}
