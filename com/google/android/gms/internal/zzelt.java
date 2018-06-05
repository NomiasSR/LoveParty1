package com.google.android.gms.internal;

import com.bumptech.glide.load.Key;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.database.DatabaseException;
import com.google.firebase.database.DatabaseReference.CompletionListener;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;

public final class zzelt {
    private static final char[] zznfg = "0123456789abcdef".toCharArray();

    public static zzelq<Task<Void>, CompletionListener> zzb(CompletionListener completionListener) {
        if (completionListener != null) {
            return new zzelq(null, completionListener);
        }
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        return new zzelq(taskCompletionSource.getTask(), new zzelu(taskCompletionSource));
    }

    public static void zzb(boolean z, String str) {
        if (!z) {
            String str2 = "hardAssert failed: ";
            str = String.valueOf(str);
            throw new AssertionError(str.length() != 0 ? str2.concat(str) : new String(str2));
        }
    }

    public static void zzcp(boolean z) {
        zzb(z, "");
    }

    public static int zzi(long j, long j2) {
        int i = (j > j2 ? 1 : (j == j2 ? 0 : -1));
        return i < 0 ? -1 : i == 0 ? 0 : 1;
    }

    public static String zzk(double d) {
        StringBuilder stringBuilder = new StringBuilder(16);
        long doubleToLongBits = Double.doubleToLongBits(d);
        for (int i = 7; i >= 0; i--) {
            int i2 = (int) ((doubleToLongBits >>> (i << 3)) & 255);
            int i3 = (i2 >> 4) & 15;
            i2 &= 15;
            stringBuilder.append(zznfg[i3]);
            stringBuilder.append(zznfg[i2]);
        }
        return stringBuilder.toString();
    }

    public static zzelr zzqd(String str) throws DatabaseException {
        try {
            int indexOf = str.indexOf("//");
            if (indexOf == -1) {
                throw new URISyntaxException(str, "Invalid scheme specified");
            }
            indexOf += 2;
            int indexOf2 = str.substring(indexOf).indexOf("/");
            if (indexOf2 != -1) {
                indexOf2 += indexOf;
                String[] split = str.substring(indexOf2).split("/");
                StringBuilder stringBuilder = new StringBuilder();
                for (int i = 0; i < split.length; i++) {
                    if (!split[i].equals("")) {
                        stringBuilder.append("/");
                        stringBuilder.append(URLEncoder.encode(split[i], Key.STRING_CHARSET_NAME));
                    }
                }
                str = String.valueOf(str.substring(0, indexOf2));
                String valueOf = String.valueOf(stringBuilder.toString());
                str = valueOf.length() != 0 ? str.concat(valueOf) : new String(str);
            }
            URI uri = new URI(str);
            str = uri.getPath().replace("+", " ");
            zzelv.zzqi(str);
            zzedk com_google_android_gms_internal_zzedk = new zzedk(str);
            str = uri.getScheme();
            zzeeq com_google_android_gms_internal_zzeeq = new zzeeq();
            com_google_android_gms_internal_zzeeq.host = uri.getHost().toLowerCase();
            indexOf = uri.getPort();
            if (indexOf != -1) {
                com_google_android_gms_internal_zzeeq.secure = str.equals("https");
                str = String.valueOf(com_google_android_gms_internal_zzeeq.host);
                StringBuilder stringBuilder2 = new StringBuilder(12 + String.valueOf(str).length());
                stringBuilder2.append(str);
                stringBuilder2.append(":");
                stringBuilder2.append(indexOf);
                com_google_android_gms_internal_zzeeq.host = stringBuilder2.toString();
            } else {
                com_google_android_gms_internal_zzeeq.secure = true;
            }
            com_google_android_gms_internal_zzeeq.zzjrg = com_google_android_gms_internal_zzeeq.host.split("\\.")[0].toLowerCase();
            com_google_android_gms_internal_zzeeq.zzmuy = com_google_android_gms_internal_zzeeq.host;
            zzelr com_google_android_gms_internal_zzelr = new zzelr();
            com_google_android_gms_internal_zzelr.zzmks = com_google_android_gms_internal_zzedk;
            com_google_android_gms_internal_zzelr.zzmkj = com_google_android_gms_internal_zzeeq;
            return com_google_android_gms_internal_zzelr;
        } catch (Throwable e) {
            throw new DatabaseException("Invalid Firebase Database url specified", e);
        } catch (Throwable e2) {
            throw new DatabaseException("Failed to URLEncode the path", e2);
        }
    }

    public static java.lang.String zzqe(java.lang.String r2) {
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
        r0 = "SHA-1";	 Catch:{ NoSuchAlgorithmException -> 0x0021, UnsupportedEncodingException -> 0x0019 }
        r0 = java.security.MessageDigest.getInstance(r0);	 Catch:{ NoSuchAlgorithmException -> 0x0021, UnsupportedEncodingException -> 0x0019 }
        r1 = "UTF-8";	 Catch:{ NoSuchAlgorithmException -> 0x0021, UnsupportedEncodingException -> 0x0019 }
        r2 = r2.getBytes(r1);	 Catch:{ NoSuchAlgorithmException -> 0x0021, UnsupportedEncodingException -> 0x0019 }
        r0.update(r2);	 Catch:{ NoSuchAlgorithmException -> 0x0021, UnsupportedEncodingException -> 0x0019 }
        r2 = r0.digest();	 Catch:{ NoSuchAlgorithmException -> 0x0021, UnsupportedEncodingException -> 0x0019 }
        r0 = 2;	 Catch:{ NoSuchAlgorithmException -> 0x0021, UnsupportedEncodingException -> 0x0019 }
        r2 = android.util.Base64.encodeToString(r2, r0);	 Catch:{ NoSuchAlgorithmException -> 0x0021, UnsupportedEncodingException -> 0x0019 }
        return r2;
    L_0x0019:
        r2 = new java.lang.RuntimeException;
        r0 = "UTF-8 encoding is required for Firebase Database to run!";
        r2.<init>(r0);
        throw r2;
    L_0x0021:
        r2 = move-exception;
        r0 = new java.lang.RuntimeException;
        r1 = "Missing SHA-1 MessageDigest provider.";
        r0.<init>(r1, r2);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzelt.zzqe(java.lang.String):java.lang.String");
    }

    public static String zzqf(String str) {
        String replace = str.indexOf(92) != -1 ? str.replace("\\", "\\\\") : str;
        if (str.indexOf(34) != -1) {
            replace = replace.replace("\"", "\\\"");
        }
        StringBuilder stringBuilder = new StringBuilder(2 + String.valueOf(replace).length());
        stringBuilder.append("\"");
        stringBuilder.append(replace);
        stringBuilder.append("\"");
        return stringBuilder.toString();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.Integer zzqg(java.lang.String r8) {
        /*
        r0 = r8.length();
        r1 = 0;
        r2 = 11;
        if (r0 > r2) goto L_0x005c;
    L_0x0009:
        r0 = r8.length();
        if (r0 != 0) goto L_0x0010;
    L_0x000f:
        return r1;
    L_0x0010:
        r0 = 0;
        r2 = r8.charAt(r0);
        r3 = 45;
        r4 = 1;
        if (r2 != r3) goto L_0x0023;
    L_0x001a:
        r0 = r8.length();
        if (r0 != r4) goto L_0x0021;
    L_0x0020:
        return r1;
    L_0x0021:
        r0 = r4;
        goto L_0x0024;
    L_0x0023:
        r4 = r0;
    L_0x0024:
        r2 = 0;
    L_0x0026:
        r5 = r8.length();
        if (r0 >= r5) goto L_0x0044;
    L_0x002c:
        r5 = r8.charAt(r0);
        r6 = 48;
        if (r5 < r6) goto L_0x0043;
    L_0x0034:
        r6 = 57;
        if (r5 <= r6) goto L_0x0039;
    L_0x0038:
        return r1;
    L_0x0039:
        r6 = 10;
        r2 = r2 * r6;
        r5 = r5 + -48;
        r5 = (long) r5;
        r2 = r2 + r5;
        r0 = r0 + 1;
        goto L_0x0026;
    L_0x0043:
        return r1;
    L_0x0044:
        if (r4 == 0) goto L_0x0055;
    L_0x0046:
        r2 = -r2;
        r4 = -2147483648; // 0xffffffff80000000 float:-0.0 double:NaN;
        r8 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r8 >= 0) goto L_0x004f;
    L_0x004e:
        return r1;
    L_0x004f:
        r8 = (int) r2;
        r8 = java.lang.Integer.valueOf(r8);
        return r8;
    L_0x0055:
        r4 = 2147483647; // 0x7fffffff float:NaN double:1.060997895E-314;
        r8 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r8 <= 0) goto L_0x004f;
    L_0x005c:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzelt.zzqg(java.lang.String):java.lang.Integer");
    }

    public static int zzv(int i, int i2) {
        return i < i2 ? -1 : i == i2 ? 0 : 1;
    }
}
