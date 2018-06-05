package com.google.firebase.auth.internal;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.internal.zzbfr;
import com.google.android.gms.internal.zzdyy;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import java.lang.ref.WeakReference;

@KeepName
public class FederatedSignInActivity extends FragmentActivity {
    private static boolean zzmhx = false;

    static class zza extends AsyncTask<Void, Void, Task<AuthResult>> {
        private final zzdyy zzmcw;
        private final WeakReference<FederatedSignInActivity> zzmhy;

        public zza(zzdyy com_google_android_gms_internal_zzdyy, FederatedSignInActivity federatedSignInActivity) {
            this.zzmcw = com_google_android_gms_internal_zzdyy;
            this.zzmhy = new WeakReference(federatedSignInActivity);
        }

        private final com.google.android.gms.tasks.Task<com.google.firebase.auth.AuthResult> zzc(java.lang.Void... r2) {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r1 = this;
            r2 = com.google.firebase.auth.FirebaseAuth.getInstance();
            r0 = r1.zzmcw;
            r0 = com.google.firebase.auth.zzd.zza(r0);
            r2 = r2.signInWithCredential(r0);
            com.google.android.gms.tasks.Tasks.await(r2);	 Catch:{ InterruptedException -> 0x0014, InterruptedException -> 0x0014, all -> 0x0012 }
            return r2;
        L_0x0012:
            r2 = move-exception;
            throw r2;
        L_0x0014:
            return r2;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.auth.internal.FederatedSignInActivity.zza.zzc(java.lang.Void[]):com.google.android.gms.tasks.Task<com.google.firebase.auth.AuthResult>");
        }

        private final void zzgo(int i) {
            FederatedSignInActivity federatedSignInActivity = (FederatedSignInActivity) this.zzmhy.get();
            if (federatedSignInActivity != null) {
                federatedSignInActivity.zzgo(i);
            }
        }

        protected final /* synthetic */ Object doInBackground(Object[] objArr) {
            return zzc((Void[]) objArr);
        }

        protected final /* synthetic */ void onCancelled(Object obj) {
            zzgo(0);
        }

        protected final /* synthetic */ void onPostExecute(Object obj) {
            zzgo(-1);
        }
    }

    private final void zzgo(int i) {
        zzmhx = false;
        setResult(i);
        finish();
    }

    protected void onCreate(android.os.Bundle r5) {
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
        super.onCreate(r5);
        r0 = r4.getIntent();
        r0 = r0.getAction();
        r1 = "com.google.firebase.auth.internal.SIGN_IN";
        r1 = r0.equals(r1);
        r2 = 0;
        if (r1 != 0) goto L_0x003e;
    L_0x0014:
        r1 = "com.google.firebase.auth.internal.GET_CRED";
        r1 = r0.equals(r1);
        if (r1 != 0) goto L_0x003e;
    L_0x001c:
        r5 = "IdpSignInActivity";
        r1 = "Unknown action: ";
        r0 = java.lang.String.valueOf(r0);
        r3 = r0.length();
        if (r3 == 0) goto L_0x002f;
    L_0x002a:
        r0 = r1.concat(r0);
        goto L_0x0034;
    L_0x002f:
        r0 = new java.lang.String;
        r0.<init>(r1);
    L_0x0034:
        android.util.Log.e(r5, r0);
    L_0x0037:
        r4.setResult(r2);
        r4.finish();
        return;
    L_0x003e:
        r0 = zzmhx;
        if (r0 == 0) goto L_0x0043;
    L_0x0042:
        goto L_0x0037;
    L_0x0043:
        r0 = 1;
        zzmhx = r0;
        if (r5 != 0) goto L_0x0070;
    L_0x0048:
        r5 = new android.content.Intent;
        r0 = "com.google.firebase.auth.api.gms.ui.START_WEB_SIGN_IN";
        r5.<init>(r0);
        r0 = "com.google.android.gms";
        r5.setPackage(r0);
        r0 = r4.getIntent();
        r0 = r0.getExtras();
        r5.putExtras(r0);
        r0 = 40963; // 0xa003 float:5.7401E-41 double:2.02384E-319;
        r4.startActivityForResult(r5, r0);	 Catch:{ ActivityNotFoundException -> 0x0066 }
        return;
    L_0x0066:
        r5 = "IdpSignInActivity";
        r0 = "Could not launch web sign-in Intent. Google Play service is unavailable";
        android.util.Log.w(r5, r0);
        r4.zzgo(r2);
    L_0x0070:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.auth.internal.FederatedSignInActivity.onCreate(android.os.Bundle):void");
    }

    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if ("com.google.firebase.auth.internal.WEB_SIGN_IN_FAILED".equals(intent.getAction())) {
            Log.e("IdpSignInActivity", "Web sign-in failed, finishing");
            zzgo(0);
            return;
        }
        new zza((zzdyy) zzbfr.zza(intent, "com.google.firebase.auth.internal.VERIFY_ASSERTION_REQUEST", zzdyy.CREATOR), this).execute(new Void[0]);
    }
}
