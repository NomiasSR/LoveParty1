package com.google.firebase.iid;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Base64;
import android.util.Log;
import com.google.android.gms.common.util.zzv;
import java.io.File;
import java.io.IOException;
import java.security.KeyPair;

final class zzy {
    private Context zzair;
    private SharedPreferences zzige;

    public zzy(Context context) {
        this(context, "com.google.android.gms.appid");
    }

    private zzy(Context context, String str) {
        this.zzair = context;
        this.zzige = context.getSharedPreferences(str, 0);
        String valueOf = String.valueOf(str);
        str = String.valueOf("-no-backup");
        File file = new File(zzv.getNoBackupFilesDir(this.zzair), str.length() != 0 ? valueOf.concat(str) : new String(valueOf));
        if (!file.exists()) {
            try {
                if (file.createNewFile() && !isEmpty()) {
                    Log.i("FirebaseInstanceId", "App restored, clearing state");
                    zzavj();
                    FirebaseInstanceId.getInstance().zzciy();
                }
            } catch (IOException e) {
                if (Log.isLoggable("FirebaseInstanceId", 3)) {
                    str = "FirebaseInstanceId";
                    String str2 = "Error creating file in no backup dir: ";
                    valueOf = String.valueOf(e.getMessage());
                    Log.d(str, valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
                }
            }
        }
    }

    private final synchronized boolean isEmpty() {
        return this.zzige.getAll().isEmpty();
    }

    private static String zzbm(String str, String str2) {
        String str3 = "|S|";
        StringBuilder stringBuilder = new StringBuilder((String.valueOf(str).length() + String.valueOf(str3).length()) + String.valueOf(str2).length());
        stringBuilder.append(str);
        stringBuilder.append(str3);
        stringBuilder.append(str2);
        return stringBuilder.toString();
    }

    private final void zzhz(String str) {
        Editor edit = this.zzige.edit();
        for (String str2 : this.zzige.getAll().keySet()) {
            if (str2.startsWith(str)) {
                edit.remove(str2);
            }
        }
        edit.commit();
    }

    private static String zzo(String str, String str2, String str3) {
        String str4 = "|T|";
        StringBuilder stringBuilder = new StringBuilder((((1 + String.valueOf(str).length()) + String.valueOf(str4).length()) + String.valueOf(str2).length()) + String.valueOf(str3).length());
        stringBuilder.append(str);
        stringBuilder.append(str4);
        stringBuilder.append(str2);
        stringBuilder.append("|");
        stringBuilder.append(str3);
        return stringBuilder.toString();
    }

    public final synchronized void zza(String str, String str2, String str3, String str4, String str5) {
        str4 = zzz.zzc(str4, str5, System.currentTimeMillis());
        if (str4 != null) {
            Editor edit = this.zzige.edit();
            edit.putString(zzo(str, str2, str3), str4);
            edit.commit();
        }
    }

    public final synchronized void zzavj() {
        this.zzige.edit().clear().commit();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    @android.support.annotation.Nullable
    public final synchronized java.lang.String zzcjm() {
        /*
        r4 = this;
        monitor-enter(r4);
        r0 = r4.zzige;	 Catch:{ all -> 0x0024 }
        r1 = "topic_operaion_queue";
        r2 = 0;
        r0 = r0.getString(r1, r2);	 Catch:{ all -> 0x0024 }
        if (r0 == 0) goto L_0x0022;
    L_0x000c:
        r1 = ",";
        r0 = r0.split(r1);	 Catch:{ all -> 0x0024 }
        r1 = r0.length;	 Catch:{ all -> 0x0024 }
        r3 = 1;
        if (r1 <= r3) goto L_0x0022;
    L_0x0016:
        r1 = r0[r3];	 Catch:{ all -> 0x0024 }
        r1 = android.text.TextUtils.isEmpty(r1);	 Catch:{ all -> 0x0024 }
        if (r1 != 0) goto L_0x0022;
    L_0x001e:
        r0 = r0[r3];	 Catch:{ all -> 0x0024 }
        monitor-exit(r4);
        return r0;
    L_0x0022:
        monitor-exit(r4);
        return r2;
    L_0x0024:
        r0 = move-exception;
        monitor-exit(r4);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.iid.zzy.zzcjm():java.lang.String");
    }

    public final synchronized void zzf(String str, String str2, String str3) {
        str = zzo(str, str2, str3);
        Editor edit = this.zzige.edit();
        edit.remove(str);
        edit.commit();
    }

    public final synchronized void zzia(String str) {
        zzhz(String.valueOf(str).concat("|T|"));
    }

    public final synchronized zzz zzp(String str, String str2, String str3) {
        return zzz.zzrn(this.zzige.getString(zzo(str, str2, str3), null));
    }

    public final synchronized void zzrf(String str) {
        String string = this.zzige.getString("topic_operaion_queue", "");
        String str2 = ",";
        StringBuilder stringBuilder = new StringBuilder((String.valueOf(string).length() + String.valueOf(str2).length()) + String.valueOf(str).length());
        stringBuilder.append(string);
        stringBuilder.append(str2);
        stringBuilder.append(str);
        this.zzige.edit().putString("topic_operaion_queue", stringBuilder.toString()).apply();
    }

    public final synchronized boolean zzri(String str) {
        boolean z;
        String string = this.zzige.getString("topic_operaion_queue", "");
        String valueOf = String.valueOf(",");
        String valueOf2 = String.valueOf(str);
        if (string.startsWith(valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf))) {
            valueOf = String.valueOf(",");
            str = String.valueOf(str);
            this.zzige.edit().putString("topic_operaion_queue", string.substring((str.length() != 0 ? valueOf.concat(str) : new String(valueOf)).length())).apply();
            z = true;
        } else {
            z = false;
        }
        return z;
    }

    public final synchronized long zzrj(java.lang.String r3) {
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
        r2 = this;
        monitor-enter(r2);
        r0 = "cre";	 Catch:{ all -> 0x001a }
        r3 = zzbm(r3, r0);	 Catch:{ all -> 0x001a }
        r0 = r2.zzige;	 Catch:{ all -> 0x001a }
        r1 = 0;	 Catch:{ all -> 0x001a }
        r3 = r0.getString(r3, r1);	 Catch:{ all -> 0x001a }
        if (r3 == 0) goto L_0x0016;
    L_0x0010:
        r0 = java.lang.Long.parseLong(r3);	 Catch:{ NumberFormatException -> 0x0016 }
        monitor-exit(r2);
        return r0;
    L_0x0016:
        r0 = 0;
        monitor-exit(r2);
        return r0;
    L_0x001a:
        r3 = move-exception;
        monitor-exit(r2);
        throw r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.iid.zzy.zzrj(java.lang.String):long");
    }

    final synchronized KeyPair zzrk(String str) {
        KeyPair zzavc;
        zzavc = zza.zzavc();
        long currentTimeMillis = System.currentTimeMillis();
        Editor edit = this.zzige.edit();
        edit.putString(zzbm(str, "|P|"), Base64.encodeToString(zzavc.getPublic().getEncoded(), 11));
        edit.putString(zzbm(str, "|K|"), Base64.encodeToString(zzavc.getPrivate().getEncoded(), 11));
        edit.putString(zzbm(str, "cre"), Long.toString(currentTimeMillis));
        edit.commit();
        return zzavc;
    }

    final synchronized void zzrl(String str) {
        zzhz(String.valueOf(str).concat("|"));
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized java.security.KeyPair zzrm(java.lang.String r5) {
        /*
        r4 = this;
        monitor-enter(r4);
        r0 = r4.zzige;	 Catch:{ all -> 0x0079 }
        r1 = "|P|";
        r1 = zzbm(r5, r1);	 Catch:{ all -> 0x0079 }
        r2 = 0;
        r0 = r0.getString(r1, r2);	 Catch:{ all -> 0x0079 }
        r1 = r4.zzige;	 Catch:{ all -> 0x0079 }
        r3 = "|K|";
        r5 = zzbm(r5, r3);	 Catch:{ all -> 0x0079 }
        r5 = r1.getString(r5, r2);	 Catch:{ all -> 0x0079 }
        if (r0 == 0) goto L_0x0077;
    L_0x001c:
        if (r5 != 0) goto L_0x001f;
    L_0x001e:
        goto L_0x0077;
    L_0x001f:
        r1 = 8;
        r0 = android.util.Base64.decode(r0, r1);	 Catch:{ InvalidKeySpecException -> 0x0048, InvalidKeySpecException -> 0x0048 }
        r5 = android.util.Base64.decode(r5, r1);	 Catch:{ InvalidKeySpecException -> 0x0048, InvalidKeySpecException -> 0x0048 }
        r1 = "RSA";
        r1 = java.security.KeyFactory.getInstance(r1);	 Catch:{ InvalidKeySpecException -> 0x0048, InvalidKeySpecException -> 0x0048 }
        r3 = new java.security.spec.X509EncodedKeySpec;	 Catch:{ InvalidKeySpecException -> 0x0048, InvalidKeySpecException -> 0x0048 }
        r3.<init>(r0);	 Catch:{ InvalidKeySpecException -> 0x0048, InvalidKeySpecException -> 0x0048 }
        r0 = r1.generatePublic(r3);	 Catch:{ InvalidKeySpecException -> 0x0048, InvalidKeySpecException -> 0x0048 }
        r3 = new java.security.spec.PKCS8EncodedKeySpec;	 Catch:{ InvalidKeySpecException -> 0x0048, InvalidKeySpecException -> 0x0048 }
        r3.<init>(r5);	 Catch:{ InvalidKeySpecException -> 0x0048, InvalidKeySpecException -> 0x0048 }
        r5 = r1.generatePrivate(r3);	 Catch:{ InvalidKeySpecException -> 0x0048, InvalidKeySpecException -> 0x0048 }
        r1 = new java.security.KeyPair;	 Catch:{ InvalidKeySpecException -> 0x0048, InvalidKeySpecException -> 0x0048 }
        r1.<init>(r0, r5);	 Catch:{ InvalidKeySpecException -> 0x0048, InvalidKeySpecException -> 0x0048 }
        monitor-exit(r4);
        return r1;
    L_0x0048:
        r5 = move-exception;
        r0 = "FirebaseInstanceId";
        r5 = java.lang.String.valueOf(r5);	 Catch:{ all -> 0x0079 }
        r1 = 19;
        r3 = java.lang.String.valueOf(r5);	 Catch:{ all -> 0x0079 }
        r3 = r3.length();	 Catch:{ all -> 0x0079 }
        r1 = r1 + r3;
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0079 }
        r3.<init>(r1);	 Catch:{ all -> 0x0079 }
        r1 = "Invalid key stored ";
        r3.append(r1);	 Catch:{ all -> 0x0079 }
        r3.append(r5);	 Catch:{ all -> 0x0079 }
        r5 = r3.toString();	 Catch:{ all -> 0x0079 }
        android.util.Log.w(r0, r5);	 Catch:{ all -> 0x0079 }
        r5 = com.google.firebase.iid.FirebaseInstanceId.getInstance();	 Catch:{ all -> 0x0079 }
        r5.zzciy();	 Catch:{ all -> 0x0079 }
        monitor-exit(r4);
        return r2;
    L_0x0077:
        monitor-exit(r4);
        return r2;
    L_0x0079:
        r5 = move-exception;
        monitor-exit(r4);
        throw r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.iid.zzy.zzrm(java.lang.String):java.security.KeyPair");
    }
}
