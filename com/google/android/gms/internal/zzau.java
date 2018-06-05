package com.google.android.gms.internal;

public class zzau extends zzr<String> {
    private final zzy<String> zzcj;

    public zzau(int i, String str, zzy<String> com_google_android_gms_internal_zzy_java_lang_String, zzx com_google_android_gms_internal_zzx) {
        super(i, str, com_google_android_gms_internal_zzx);
        this.zzcj = com_google_android_gms_internal_zzy_java_lang_String;
    }

    protected final com.google.android.gms.internal.zzw<java.lang.String> zza(com.google.android.gms.internal.zzp r4) {
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
        r3 = this;
        r0 = new java.lang.String;	 Catch:{ UnsupportedEncodingException -> 0x000e }
        r1 = r4.data;	 Catch:{ UnsupportedEncodingException -> 0x000e }
        r2 = r4.zzac;	 Catch:{ UnsupportedEncodingException -> 0x000e }
        r2 = com.google.android.gms.internal.zzao.zzb(r2);	 Catch:{ UnsupportedEncodingException -> 0x000e }
        r0.<init>(r1, r2);	 Catch:{ UnsupportedEncodingException -> 0x000e }
        goto L_0x0015;
    L_0x000e:
        r0 = new java.lang.String;
        r1 = r4.data;
        r0.<init>(r1);
    L_0x0015:
        r4 = com.google.android.gms.internal.zzao.zzb(r4);
        r4 = com.google.android.gms.internal.zzw.zza(r0, r4);
        return r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzau.zza(com.google.android.gms.internal.zzp):com.google.android.gms.internal.zzw<java.lang.String>");
    }

    protected /* synthetic */ void zza(Object obj) {
        zzh((String) obj);
    }

    protected void zzh(String str) {
        if (this.zzcj != null) {
            this.zzcj.zzb(str);
        }
    }
}
