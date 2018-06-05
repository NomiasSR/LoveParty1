package com.google.android.gms.internal;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.GetTokenResult;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public final class zzexw {
    @android.support.annotation.Nullable
    public static android.net.Uri zzf(@android.support.annotation.NonNull com.google.firebase.FirebaseApp r4, @android.support.annotation.Nullable java.lang.String r5) throws java.io.UnsupportedEncodingException {
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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = android.text.TextUtils.isEmpty(r5);
        if (r0 == 0) goto L_0x0008;
    L_0x0006:
        r4 = 0;
        return r4;
    L_0x0008:
        r0 = r5.toLowerCase();
        r1 = "gs://";
        r0 = r0.startsWith(r1);
        if (r0 == 0) goto L_0x003c;
    L_0x0014:
        r4 = 5;
        r4 = r5.substring(r4);
        r4 = com.google.android.gms.internal.zzexs.zzsj(r4);
        r4 = com.google.android.gms.internal.zzexs.zzsh(r4);
        r5 = "gs://";
        r4 = java.lang.String.valueOf(r4);
        r0 = r4.length();
        if (r0 == 0) goto L_0x0032;
    L_0x002d:
        r4 = r5.concat(r4);
        goto L_0x0037;
    L_0x0032:
        r4 = new java.lang.String;
        r4.<init>(r5);
    L_0x0037:
        r4 = android.net.Uri.parse(r4);
        return r4;
    L_0x003c:
        r5 = android.net.Uri.parse(r5);
        r0 = r5.getScheme();
        if (r0 == 0) goto L_0x00fd;
    L_0x0046:
        r1 = r0.toLowerCase();
        r2 = "http";
        r1 = com.google.android.gms.common.internal.zzbg.equal(r1, r2);
        if (r1 != 0) goto L_0x005e;
    L_0x0052:
        r1 = r0.toLowerCase();
        r2 = "https";
        r1 = com.google.android.gms.common.internal.zzbg.equal(r1, r2);
        if (r1 == 0) goto L_0x00fd;
    L_0x005e:
        r0 = r5.getAuthority();
        r0 = r0.toLowerCase();
        r4 = com.google.android.gms.internal.zzeyb.zzi(r4);	 Catch:{ RemoteException -> 0x00f5 }
        r4 = r4.zzcmo();	 Catch:{ RemoteException -> 0x00f5 }
        r4 = r0.indexOf(r4);	 Catch:{ RemoteException -> 0x00f5 }
        r0 = r5.getEncodedPath();
        r0 = com.google.android.gms.internal.zzexs.zzsi(r0);
        r1 = 0;
        if (r4 != 0) goto L_0x00bd;
    L_0x007d:
        r2 = "/";
        r2 = r0.startsWith(r2);
        if (r2 == 0) goto L_0x00bd;
    L_0x0085:
        r4 = "/b/";
        r4 = r0.indexOf(r4, r1);
        r5 = "/";
        r2 = r4 + 3;
        r5 = r0.indexOf(r5, r2);
        r3 = "/o/";
        r1 = r0.indexOf(r3, r1);
        r3 = -1;
        if (r4 == r3) goto L_0x00ae;
    L_0x009c:
        if (r5 == r3) goto L_0x00ae;
    L_0x009e:
        r4 = r0.substring(r2, r5);
        if (r1 == r3) goto L_0x00ab;
    L_0x00a4:
        r1 = r1 + 3;
        r0 = r0.substring(r1);
        goto L_0x00c9;
    L_0x00ab:
        r0 = "";
        goto L_0x00c9;
    L_0x00ae:
        r4 = "StorageUtil";
        r5 = "Firebase Storage URLs must point to an object in your Storage Bucket. Please obtain a URL using the Firebase Console or getDownloadUrl().";
        android.util.Log.w(r4, r5);
        r4 = new java.lang.IllegalArgumentException;
        r5 = "Firebase Storage URLs must point to an object in your Storage Bucket. Please obtain a URL using the Firebase Console or getDownloadUrl().";
        r4.<init>(r5);
        throw r4;
    L_0x00bd:
        r2 = 1;
        if (r4 <= r2) goto L_0x00e6;
    L_0x00c0:
        r5 = r5.getAuthority();
        r4 = r4 - r2;
        r4 = r5.substring(r1, r4);
    L_0x00c9:
        r5 = "No bucket specified";
        com.google.android.gms.common.internal.zzbq.zzh(r4, r5);
        r5 = new android.net.Uri$Builder;
        r5.<init>();
        r1 = "gs";
        r5 = r5.scheme(r1);
        r4 = r5.authority(r4);
        r4 = r4.encodedPath(r0);
        r4 = r4.build();
        return r4;
    L_0x00e6:
        r4 = "StorageUtil";
        r5 = "Firebase Storage URLs must point to an object in your Storage Bucket. Please obtain a URL using the Firebase Console or getDownloadUrl().";
        android.util.Log.w(r4, r5);
        r4 = new java.lang.IllegalArgumentException;
        r5 = "Firebase Storage URLs must point to an object in your Storage Bucket. Please obtain a URL using the Firebase Console or getDownloadUrl().";
        r4.<init>(r5);
        throw r4;
    L_0x00f5:
        r4 = new java.io.UnsupportedEncodingException;
        r5 = "Could not parse Url because the Storage network layer did not load";
        r4.<init>(r5);
        throw r4;
    L_0x00fd:
        r4 = "StorageUtil";
        r5 = "FirebaseStorage is unable to support the scheme:";
        r0 = java.lang.String.valueOf(r0);
        r1 = r0.length();
        if (r1 == 0) goto L_0x0110;
    L_0x010b:
        r5 = r5.concat(r0);
        goto L_0x0116;
    L_0x0110:
        r0 = new java.lang.String;
        r0.<init>(r5);
        r5 = r0;
    L_0x0116:
        android.util.Log.w(r4, r5);
        r4 = new java.lang.IllegalArgumentException;
        r5 = "Uri scheme";
        r4.<init>(r5);
        throw r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzexw.zzf(com.google.firebase.FirebaseApp, java.lang.String):android.net.Uri");
    }

    @Nullable
    public static String zzh(FirebaseApp firebaseApp) {
        try {
            Object token = ((GetTokenResult) Tasks.await(firebaseApp.getToken(false), 30000, TimeUnit.MILLISECONDS)).getToken();
            if (!TextUtils.isEmpty(token)) {
                return token;
            }
            Log.w("StorageUtil", "no auth token for request");
            return null;
        } catch (ExecutionException e) {
            String valueOf = String.valueOf(e);
            StringBuilder stringBuilder = new StringBuilder(20 + String.valueOf(valueOf).length());
            stringBuilder.append("error getting token ");
            stringBuilder.append(valueOf);
            Log.e("StorageUtil", stringBuilder.toString());
        }
    }

    public static long zzsk(@Nullable String str) {
        if (str == null) {
            return 0;
        }
        str = str.replaceAll("Z$", "-0000");
        try {
            return new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ", Locale.getDefault()).parse(str).getTime();
        } catch (Throwable e) {
            String str2 = "StorageUtil";
            String str3 = "unable to parse datetime:";
            str = String.valueOf(str);
            Log.w(str2, str.length() != 0 ? str3.concat(str) : new String(str3), e);
            return 0;
        }
    }
}
