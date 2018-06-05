package com.google.firebase.auth.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.internal.zzbgg;
import com.google.android.gms.internal.zzdvu;
import com.google.android.gms.internal.zzdym;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseUser;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class zzr {
    private Context mContext;
    private SharedPreferences zzbhh = this.mContext.getSharedPreferences(String.format("com.google.firebase.auth.api.Store.%s", new Object[]{this.zzmhz}), 0);
    private zzbgg zzehz = new zzbgg("StorageHelpers", new String[0]);
    private String zzmhz;

    public zzr(@NonNull Context context, @NonNull String str) {
        zzbq.checkNotNull(context);
        this.zzmhz = zzbq.zzgm(str);
        this.mContext = context.getApplicationContext();
    }

    private final zzh zzaa(@NonNull JSONObject jSONObject) {
        try {
            Object string = jSONObject.getString("cachedTokenState");
            String string2 = jSONObject.getString("applicationName");
            boolean z = jSONObject.getBoolean("anonymous");
            String str = "2";
            String string3 = jSONObject.getString("version");
            if (string3 != null) {
                str = string3;
            }
            JSONArray jSONArray = jSONObject.getJSONArray("userInfos");
            int length = jSONArray.length();
            List arrayList = new ArrayList(length);
            for (int i = 0; i < length; i++) {
                arrayList.add(zzf.zzpb(jSONArray.getString(i)));
            }
            FirebaseUser com_google_firebase_auth_internal_zzh = new zzh(FirebaseApp.getInstance(string2), arrayList);
            if (!TextUtils.isEmpty(string)) {
                com_google_firebase_auth_internal_zzh.zza(zzdym.zzpa(string));
            }
            ((zzh) com_google_firebase_auth_internal_zzh.zzcf(z)).zzpc(str);
            return com_google_firebase_auth_internal_zzh;
        } catch (Throwable e) {
            this.zzehz.zze(e);
            return null;
        }
    }

    @Nullable
    private final String zzh(@NonNull FirebaseUser firebaseUser) {
        JSONObject jSONObject = new JSONObject();
        if (!zzh.class.isAssignableFrom(firebaseUser.getClass())) {
            return null;
        }
        zzh com_google_firebase_auth_internal_zzh = (zzh) firebaseUser;
        try {
            jSONObject.put("cachedTokenState", com_google_firebase_auth_internal_zzh.zzbrg());
            jSONObject.put("applicationName", com_google_firebase_auth_internal_zzh.zzbre().getName());
            jSONObject.put("type", "com.google.firebase.auth.internal.DefaultFirebaseUser");
            if (com_google_firebase_auth_internal_zzh.zzbsc() != null) {
                JSONArray jSONArray = new JSONArray();
                List zzbsc = com_google_firebase_auth_internal_zzh.zzbsc();
                for (int i = 0; i < zzbsc.size(); i++) {
                    jSONArray.put(((zzf) zzbsc.get(i)).zzabg());
                }
                jSONObject.put("userInfos", jSONArray);
            }
            jSONObject.put("anonymous", com_google_firebase_auth_internal_zzh.isAnonymous());
            jSONObject.put("version", "2");
            return jSONObject.toString();
        } catch (Throwable e) {
            this.zzehz.zza("Failed to turn object into JSON", e, new Object[0]);
            throw new zzdvu(e);
        }
    }

    public final void clear(String str) {
        this.zzbhh.edit().remove(str).apply();
    }

    public final void zza(@NonNull FirebaseUser firebaseUser, @NonNull zzdym com_google_android_gms_internal_zzdym) {
        zzbq.checkNotNull(firebaseUser);
        zzbq.checkNotNull(com_google_android_gms_internal_zzdym);
        this.zzbhh.edit().putString(String.format("com.google.firebase.auth.GET_TOKEN_RESPONSE.%s", new Object[]{firebaseUser.getUid()}), com_google_android_gms_internal_zzdym.zzabg()).apply();
    }

    @android.support.annotation.Nullable
    public final com.google.firebase.auth.FirebaseUser zzbsh() {
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
        r4 = this;
        r0 = "com.google.firebase.auth.FIREBASE_USER";
        r1 = r4.zzbhh;
        r2 = 0;
        r0 = r1.getString(r0, r2);
        r1 = android.text.TextUtils.isEmpty(r0);
        if (r1 == 0) goto L_0x0010;
    L_0x000f:
        return r2;
    L_0x0010:
        r1 = new org.json.JSONObject;	 Catch:{ Exception -> 0x0030 }
        r1.<init>(r0);	 Catch:{ Exception -> 0x0030 }
        r0 = "type";	 Catch:{ Exception -> 0x0030 }
        r0 = r1.has(r0);	 Catch:{ Exception -> 0x0030 }
        if (r0 == 0) goto L_0x0030;	 Catch:{ Exception -> 0x0030 }
    L_0x001d:
        r0 = "type";	 Catch:{ Exception -> 0x0030 }
        r0 = r1.optString(r0);	 Catch:{ Exception -> 0x0030 }
        r3 = "com.google.firebase.auth.internal.DefaultFirebaseUser";	 Catch:{ Exception -> 0x0030 }
        r0 = r3.equalsIgnoreCase(r0);	 Catch:{ Exception -> 0x0030 }
        if (r0 == 0) goto L_0x0030;	 Catch:{ Exception -> 0x0030 }
    L_0x002b:
        r0 = r4.zzaa(r1);	 Catch:{ Exception -> 0x0030 }
        return r0;
    L_0x0030:
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.auth.internal.zzr.zzbsh():com.google.firebase.auth.FirebaseUser");
    }

    public final void zzf(@NonNull FirebaseUser firebaseUser) {
        zzbq.checkNotNull(firebaseUser);
        Object zzh = zzh(firebaseUser);
        if (!TextUtils.isEmpty(zzh)) {
            this.zzbhh.edit().putString("com.google.firebase.auth.FIREBASE_USER", zzh).apply();
        }
    }

    public final zzdym zzg(@NonNull FirebaseUser firebaseUser) {
        zzbq.checkNotNull(firebaseUser);
        String string = this.zzbhh.getString(String.format("com.google.firebase.auth.GET_TOKEN_RESPONSE.%s", new Object[]{firebaseUser.getUid()}), null);
        return string != null ? zzdym.zzpa(string) : null;
    }
}
