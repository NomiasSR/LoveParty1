package com.google.android.gms.auth.api.signin;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.android.gms.auth.api.signin.internal.zzn;
import com.google.android.gms.auth.api.signin.internal.zzp;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.Api.ApiOptions.Optional;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class GoogleSignInOptions extends zzbfm implements Optional, ReflectedParcelable {
    public static final Creator<GoogleSignInOptions> CREATOR = new zze();
    public static final GoogleSignInOptions DEFAULT_GAMES_SIGN_IN = new Builder().requestScopes(SCOPE_GAMES_LITE, new Scope[0]).build();
    public static final GoogleSignInOptions DEFAULT_SIGN_IN = new Builder().requestId().requestProfile().build();
    public static final Scope SCOPE_GAMES = new Scope(Scopes.GAMES);
    public static final Scope SCOPE_GAMES_LITE = new Scope("https://www.googleapis.com/auth/games_lite");
    public static final Scope zzehi = new Scope(Scopes.PROFILE);
    public static final Scope zzehj = new Scope("email");
    public static final Scope zzehk = new Scope("openid");
    private static Comparator<Scope> zzehr = new zzd();
    private int versionCode;
    private Account zzebz;
    private boolean zzefl;
    private String zzefm;
    private final ArrayList<Scope> zzehl;
    private final boolean zzehm;
    private final boolean zzehn;
    private String zzeho;
    private ArrayList<zzn> zzehp;
    private Map<Integer, zzn> zzehq;

    public static final class Builder {
        private Account zzebz;
        private boolean zzefl;
        private String zzefm;
        private boolean zzehm;
        private boolean zzehn;
        private String zzeho;
        private Set<Scope> zzehs = new HashSet();
        private Map<Integer, zzn> zzeht = new HashMap();

        public Builder(@NonNull GoogleSignInOptions googleSignInOptions) {
            zzbq.checkNotNull(googleSignInOptions);
            this.zzehs = new HashSet(googleSignInOptions.zzehl);
            this.zzehm = googleSignInOptions.zzehm;
            this.zzehn = googleSignInOptions.zzehn;
            this.zzefl = googleSignInOptions.zzefl;
            this.zzefm = googleSignInOptions.zzefm;
            this.zzebz = googleSignInOptions.zzebz;
            this.zzeho = googleSignInOptions.zzeho;
            this.zzeht = GoogleSignInOptions.zzx(googleSignInOptions.zzehp);
        }

        private final String zzew(String str) {
            boolean z;
            zzbq.zzgm(str);
            if (this.zzefm != null) {
                if (!this.zzefm.equals(str)) {
                    z = false;
                    zzbq.checkArgument(z, "two different server client ids provided");
                    return str;
                }
            }
            z = true;
            zzbq.checkArgument(z, "two different server client ids provided");
            return str;
        }

        public final Builder addExtension(GoogleSignInOptionsExtension googleSignInOptionsExtension) {
            if (this.zzeht.containsKey(Integer.valueOf(googleSignInOptionsExtension.getExtensionType()))) {
                throw new IllegalStateException("Only one extension per type may be added");
            }
            if (googleSignInOptionsExtension.getImpliedScopes() != null) {
                this.zzehs.addAll(googleSignInOptionsExtension.getImpliedScopes());
            }
            this.zzeht.put(Integer.valueOf(googleSignInOptionsExtension.getExtensionType()), new zzn(googleSignInOptionsExtension));
            return this;
        }

        public final GoogleSignInOptions build() {
            if (this.zzehs.contains(GoogleSignInOptions.SCOPE_GAMES) && this.zzehs.contains(GoogleSignInOptions.SCOPE_GAMES_LITE)) {
                this.zzehs.remove(GoogleSignInOptions.SCOPE_GAMES_LITE);
            }
            if (this.zzefl && (this.zzebz == null || !this.zzehs.isEmpty())) {
                requestId();
            }
            return new GoogleSignInOptions(new ArrayList(this.zzehs), this.zzebz, this.zzefl, this.zzehm, this.zzehn, this.zzefm, this.zzeho, this.zzeht);
        }

        public final Builder requestEmail() {
            this.zzehs.add(GoogleSignInOptions.zzehj);
            return this;
        }

        public final Builder requestId() {
            this.zzehs.add(GoogleSignInOptions.zzehk);
            return this;
        }

        public final Builder requestIdToken(String str) {
            this.zzefl = true;
            this.zzefm = zzew(str);
            return this;
        }

        public final Builder requestProfile() {
            this.zzehs.add(GoogleSignInOptions.zzehi);
            return this;
        }

        public final Builder requestScopes(Scope scope, Scope... scopeArr) {
            this.zzehs.add(scope);
            this.zzehs.addAll(Arrays.asList(scopeArr));
            return this;
        }

        public final Builder requestServerAuthCode(String str) {
            return requestServerAuthCode(str, false);
        }

        public final Builder requestServerAuthCode(String str, boolean z) {
            this.zzehm = true;
            this.zzefm = zzew(str);
            this.zzehn = z;
            return this;
        }

        public final Builder setAccountName(String str) {
            this.zzebz = new Account(zzbq.zzgm(str), "com.google");
            return this;
        }

        public final Builder setHostedDomain(String str) {
            this.zzeho = zzbq.zzgm(str);
            return this;
        }
    }

    GoogleSignInOptions(int i, ArrayList<Scope> arrayList, Account account, boolean z, boolean z2, boolean z3, String str, String str2, ArrayList<zzn> arrayList2) {
        this(i, (ArrayList) arrayList, account, z, z2, z3, str, str2, zzx(arrayList2));
    }

    private GoogleSignInOptions(int i, ArrayList<Scope> arrayList, Account account, boolean z, boolean z2, boolean z3, String str, String str2, Map<Integer, zzn> map) {
        this.versionCode = i;
        this.zzehl = arrayList;
        this.zzebz = account;
        this.zzefl = z;
        this.zzehm = z2;
        this.zzehn = z3;
        this.zzefm = str;
        this.zzeho = str2;
        this.zzehp = new ArrayList(map.values());
        this.zzehq = map;
    }

    private final JSONObject toJsonObject() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            Collections.sort(this.zzehl, zzehr);
            ArrayList arrayList = this.zzehl;
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                jSONArray.put(((Scope) obj).zzagw());
            }
            jSONObject.put("scopes", jSONArray);
            if (this.zzebz != null) {
                jSONObject.put("accountName", this.zzebz.name);
            }
            jSONObject.put("idTokenRequested", this.zzefl);
            jSONObject.put("forceCodeForRefreshToken", this.zzehn);
            jSONObject.put("serverAuthRequested", this.zzehm);
            if (!TextUtils.isEmpty(this.zzefm)) {
                jSONObject.put("serverClientId", this.zzefm);
            }
            if (!TextUtils.isEmpty(this.zzeho)) {
                jSONObject.put("hostedDomain", this.zzeho);
            }
            return jSONObject;
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    @Nullable
    public static GoogleSignInOptions zzev(@Nullable String str) throws JSONException {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(str);
        Collection hashSet = new HashSet();
        JSONArray jSONArray = jSONObject.getJSONArray("scopes");
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            hashSet.add(new Scope(jSONArray.getString(i)));
        }
        Object optString = jSONObject.optString("accountName", null);
        return new GoogleSignInOptions(3, new ArrayList(hashSet), !TextUtils.isEmpty(optString) ? new Account(optString, "com.google") : null, jSONObject.getBoolean("idTokenRequested"), jSONObject.getBoolean("serverAuthRequested"), jSONObject.getBoolean("forceCodeForRefreshToken"), jSONObject.optString("serverClientId", null), jSONObject.optString("hostedDomain", null), new HashMap());
    }

    private static Map<Integer, zzn> zzx(@Nullable List<zzn> list) {
        Map<Integer, zzn> hashMap = new HashMap();
        if (list == null) {
            return hashMap;
        }
        for (zzn com_google_android_gms_auth_api_signin_internal_zzn : list) {
            hashMap.put(Integer.valueOf(com_google_android_gms_auth_api_signin_internal_zzn.getType()), com_google_android_gms_auth_api_signin_internal_zzn);
        }
        return hashMap;
    }

    public boolean equals(java.lang.Object r4) {
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
        r3 = this;
        r0 = 0;
        if (r4 != 0) goto L_0x0004;
    L_0x0003:
        return r0;
    L_0x0004:
        r4 = (com.google.android.gms.auth.api.signin.GoogleSignInOptions) r4;	 Catch:{ ClassCastException -> 0x0076 }
        r1 = r3.zzehp;	 Catch:{ ClassCastException -> 0x0076 }
        r1 = r1.size();	 Catch:{ ClassCastException -> 0x0076 }
        if (r1 > 0) goto L_0x0076;	 Catch:{ ClassCastException -> 0x0076 }
    L_0x000e:
        r1 = r4.zzehp;	 Catch:{ ClassCastException -> 0x0076 }
        r1 = r1.size();	 Catch:{ ClassCastException -> 0x0076 }
        if (r1 <= 0) goto L_0x0017;	 Catch:{ ClassCastException -> 0x0076 }
    L_0x0016:
        return r0;	 Catch:{ ClassCastException -> 0x0076 }
    L_0x0017:
        r1 = r3.zzehl;	 Catch:{ ClassCastException -> 0x0076 }
        r1 = r1.size();	 Catch:{ ClassCastException -> 0x0076 }
        r2 = r4.zzabe();	 Catch:{ ClassCastException -> 0x0076 }
        r2 = r2.size();	 Catch:{ ClassCastException -> 0x0076 }
        if (r1 != r2) goto L_0x0076;	 Catch:{ ClassCastException -> 0x0076 }
    L_0x0027:
        r1 = r3.zzehl;	 Catch:{ ClassCastException -> 0x0076 }
        r2 = r4.zzabe();	 Catch:{ ClassCastException -> 0x0076 }
        r1 = r1.containsAll(r2);	 Catch:{ ClassCastException -> 0x0076 }
        if (r1 != 0) goto L_0x0034;	 Catch:{ ClassCastException -> 0x0076 }
    L_0x0033:
        return r0;	 Catch:{ ClassCastException -> 0x0076 }
    L_0x0034:
        r1 = r3.zzebz;	 Catch:{ ClassCastException -> 0x0076 }
        if (r1 != 0) goto L_0x003d;	 Catch:{ ClassCastException -> 0x0076 }
    L_0x0038:
        r1 = r4.zzebz;	 Catch:{ ClassCastException -> 0x0076 }
        if (r1 != 0) goto L_0x0076;	 Catch:{ ClassCastException -> 0x0076 }
    L_0x003c:
        goto L_0x0047;	 Catch:{ ClassCastException -> 0x0076 }
    L_0x003d:
        r1 = r3.zzebz;	 Catch:{ ClassCastException -> 0x0076 }
        r2 = r4.zzebz;	 Catch:{ ClassCastException -> 0x0076 }
        r1 = r1.equals(r2);	 Catch:{ ClassCastException -> 0x0076 }
        if (r1 == 0) goto L_0x0076;	 Catch:{ ClassCastException -> 0x0076 }
    L_0x0047:
        r1 = r3.zzefm;	 Catch:{ ClassCastException -> 0x0076 }
        r1 = android.text.TextUtils.isEmpty(r1);	 Catch:{ ClassCastException -> 0x0076 }
        if (r1 == 0) goto L_0x0058;	 Catch:{ ClassCastException -> 0x0076 }
    L_0x004f:
        r1 = r4.zzefm;	 Catch:{ ClassCastException -> 0x0076 }
        r1 = android.text.TextUtils.isEmpty(r1);	 Catch:{ ClassCastException -> 0x0076 }
        if (r1 == 0) goto L_0x0076;	 Catch:{ ClassCastException -> 0x0076 }
    L_0x0057:
        goto L_0x0062;	 Catch:{ ClassCastException -> 0x0076 }
    L_0x0058:
        r1 = r3.zzefm;	 Catch:{ ClassCastException -> 0x0076 }
        r2 = r4.zzefm;	 Catch:{ ClassCastException -> 0x0076 }
        r1 = r1.equals(r2);	 Catch:{ ClassCastException -> 0x0076 }
        if (r1 == 0) goto L_0x0076;	 Catch:{ ClassCastException -> 0x0076 }
    L_0x0062:
        r1 = r3.zzehn;	 Catch:{ ClassCastException -> 0x0076 }
        r2 = r4.zzehn;	 Catch:{ ClassCastException -> 0x0076 }
        if (r1 != r2) goto L_0x0076;	 Catch:{ ClassCastException -> 0x0076 }
    L_0x0068:
        r1 = r3.zzefl;	 Catch:{ ClassCastException -> 0x0076 }
        r2 = r4.zzefl;	 Catch:{ ClassCastException -> 0x0076 }
        if (r1 != r2) goto L_0x0076;	 Catch:{ ClassCastException -> 0x0076 }
    L_0x006e:
        r1 = r3.zzehm;	 Catch:{ ClassCastException -> 0x0076 }
        r4 = r4.zzehm;	 Catch:{ ClassCastException -> 0x0076 }
        if (r1 != r4) goto L_0x0076;
    L_0x0074:
        r4 = 1;
        return r4;
    L_0x0076:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.auth.api.signin.GoogleSignInOptions.equals(java.lang.Object):boolean");
    }

    public final Account getAccount() {
        return this.zzebz;
    }

    public Scope[] getScopeArray() {
        return (Scope[]) this.zzehl.toArray(new Scope[this.zzehl.size()]);
    }

    public final String getServerClientId() {
        return this.zzefm;
    }

    public int hashCode() {
        List arrayList = new ArrayList();
        ArrayList arrayList2 = this.zzehl;
        int size = arrayList2.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList2.get(i);
            i++;
            arrayList.add(((Scope) obj).zzagw());
        }
        Collections.sort(arrayList);
        return new zzp().zzs(arrayList).zzs(this.zzebz).zzs(this.zzefm).zzar(this.zzehn).zzar(this.zzefl).zzar(this.zzehm).zzabn();
    }

    public final boolean isIdTokenRequested() {
        return this.zzefl;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int zze = zzbfp.zze(parcel);
        zzbfp.zzc(parcel, 1, this.versionCode);
        zzbfp.zzc(parcel, 2, zzabe(), false);
        zzbfp.zza(parcel, 3, this.zzebz, i, false);
        zzbfp.zza(parcel, 4, this.zzefl);
        zzbfp.zza(parcel, 5, this.zzehm);
        zzbfp.zza(parcel, 6, this.zzehn);
        zzbfp.zza(parcel, 7, this.zzefm, false);
        zzbfp.zza(parcel, 8, this.zzeho, false);
        zzbfp.zzc(parcel, 9, this.zzehp, false);
        zzbfp.zzai(parcel, zze);
    }

    public final ArrayList<Scope> zzabe() {
        return new ArrayList(this.zzehl);
    }

    public final boolean zzabf() {
        return this.zzehm;
    }

    public final String zzabg() {
        return toJsonObject().toString();
    }
}
