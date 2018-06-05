package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.internal.zzbq;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public final class zzz {
    private static final Lock zzeiu = new ReentrantLock();
    private static zzz zzeiv;
    private final Lock zzeiw = new ReentrantLock();
    private final SharedPreferences zzeix;

    private zzz(Context context) {
        this.zzeix = context.getSharedPreferences("com.google.android.gms.signin", 0);
    }

    public static zzz zzbt(Context context) {
        zzbq.checkNotNull(context);
        zzeiu.lock();
        try {
            if (zzeiv == null) {
                zzeiv = new zzz(context.getApplicationContext());
            }
            zzz com_google_android_gms_auth_api_signin_internal_zzz = zzeiv;
            return com_google_android_gms_auth_api_signin_internal_zzz;
        } finally {
            zzeiu.unlock();
        }
    }

    private final com.google.android.gms.auth.api.signin.GoogleSignInAccount zzex(java.lang.String r3) {
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
        r2 = this;
        r0 = android.text.TextUtils.isEmpty(r3);
        r1 = 0;
        if (r0 == 0) goto L_0x0008;
    L_0x0007:
        return r1;
    L_0x0008:
        r0 = "googleSignInAccount";
        r3 = zzp(r0, r3);
        r3 = r2.zzez(r3);
        if (r3 == 0) goto L_0x0019;
    L_0x0014:
        r3 = com.google.android.gms.auth.api.signin.GoogleSignInAccount.zzeu(r3);	 Catch:{ JSONException -> 0x0019 }
        return r3;
    L_0x0019:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.auth.api.signin.internal.zzz.zzex(java.lang.String):com.google.android.gms.auth.api.signin.GoogleSignInAccount");
    }

    private final com.google.android.gms.auth.api.signin.GoogleSignInOptions zzey(java.lang.String r3) {
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
        r2 = this;
        r0 = android.text.TextUtils.isEmpty(r3);
        r1 = 0;
        if (r0 == 0) goto L_0x0008;
    L_0x0007:
        return r1;
    L_0x0008:
        r0 = "googleSignInOptions";
        r3 = zzp(r0, r3);
        r3 = r2.zzez(r3);
        if (r3 == 0) goto L_0x0019;
    L_0x0014:
        r3 = com.google.android.gms.auth.api.signin.GoogleSignInOptions.zzev(r3);	 Catch:{ JSONException -> 0x0019 }
        return r3;
    L_0x0019:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.auth.api.signin.internal.zzz.zzey(java.lang.String):com.google.android.gms.auth.api.signin.GoogleSignInOptions");
    }

    private final String zzez(String str) {
        this.zzeiw.lock();
        try {
            str = this.zzeix.getString(str, null);
            return str;
        } finally {
            this.zzeiw.unlock();
        }
    }

    private final void zzfa(String str) {
        this.zzeiw.lock();
        try {
            this.zzeix.edit().remove(str).apply();
        } finally {
            this.zzeiw.unlock();
        }
    }

    private static String zzp(String str, String str2) {
        String str3 = ":";
        StringBuilder stringBuilder = new StringBuilder((String.valueOf(str).length() + String.valueOf(str3).length()) + String.valueOf(str2).length());
        stringBuilder.append(str);
        stringBuilder.append(str3);
        stringBuilder.append(str2);
        return stringBuilder.toString();
    }

    public final void clear() {
        this.zzeiw.lock();
        try {
            this.zzeix.edit().clear().apply();
        } finally {
            this.zzeiw.unlock();
        }
    }

    final void zza(GoogleSignInAccount googleSignInAccount, GoogleSignInOptions googleSignInOptions) {
        zzbq.checkNotNull(googleSignInAccount);
        zzbq.checkNotNull(googleSignInOptions);
        String zzaba = googleSignInAccount.zzaba();
        zzo(zzp("googleSignInAccount", zzaba), googleSignInAccount.zzabc());
        zzo(zzp("googleSignInOptions", zzaba), googleSignInOptions.zzabg());
    }

    public final GoogleSignInAccount zzabt() {
        return zzex(zzez("defaultGoogleSignInAccount"));
    }

    public final GoogleSignInOptions zzabu() {
        return zzey(zzez("defaultGoogleSignInAccount"));
    }

    public final void zzabv() {
        String zzez = zzez("defaultGoogleSignInAccount");
        zzfa("defaultGoogleSignInAccount");
        if (!TextUtils.isEmpty(zzez)) {
            zzfa(zzp("googleSignInAccount", zzez));
            zzfa(zzp("googleSignInOptions", zzez));
        }
    }

    protected final void zzo(String str, String str2) {
        this.zzeiw.lock();
        try {
            this.zzeix.edit().putString(str, str2).apply();
        } finally {
            this.zzeiw.unlock();
        }
    }
}
