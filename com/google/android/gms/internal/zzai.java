package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;

public class zzai implements zzm {
    private static boolean DEBUG = zzae.DEBUG;
    @Deprecated
    private zzaq zzbp;
    private final zzah zzbq;
    private zzaj zzbr;

    public zzai(zzah com_google_android_gms_internal_zzah) {
        this(com_google_android_gms_internal_zzah, new zzaj(4096));
    }

    private zzai(zzah com_google_android_gms_internal_zzah, zzaj com_google_android_gms_internal_zzaj) {
        this.zzbq = com_google_android_gms_internal_zzah;
        this.zzbp = com_google_android_gms_internal_zzah;
        this.zzbr = com_google_android_gms_internal_zzaj;
    }

    @Deprecated
    public zzai(zzaq com_google_android_gms_internal_zzaq) {
        this(com_google_android_gms_internal_zzaq, new zzaj(4096));
    }

    @Deprecated
    private zzai(zzaq com_google_android_gms_internal_zzaq, zzaj com_google_android_gms_internal_zzaj) {
        this.zzbp = com_google_android_gms_internal_zzaq;
        this.zzbq = new zzag(com_google_android_gms_internal_zzaq);
        this.zzbr = com_google_android_gms_internal_zzaj;
    }

    private static List<zzl> zza(List<zzl> list, zzc com_google_android_gms_internal_zzc) {
        Set treeSet = new TreeSet(String.CASE_INSENSITIVE_ORDER);
        if (!list.isEmpty()) {
            for (zzl name : list) {
                treeSet.add(name.getName());
            }
        }
        List<zzl> arrayList = new ArrayList(list);
        if (com_google_android_gms_internal_zzc.zzg != null) {
            if (!com_google_android_gms_internal_zzc.zzg.isEmpty()) {
                for (zzl com_google_android_gms_internal_zzl : com_google_android_gms_internal_zzc.zzg) {
                    if (!treeSet.contains(com_google_android_gms_internal_zzl.getName())) {
                        arrayList.add(com_google_android_gms_internal_zzl);
                    }
                }
            }
        } else if (!com_google_android_gms_internal_zzc.zzf.isEmpty()) {
            for (Entry entry : com_google_android_gms_internal_zzc.zzf.entrySet()) {
                if (!treeSet.contains(entry.getKey())) {
                    arrayList.add(new zzl((String) entry.getKey(), (String) entry.getValue()));
                }
            }
        }
        return arrayList;
    }

    private static void zza(String str, zzr<?> com_google_android_gms_internal_zzr_, zzad com_google_android_gms_internal_zzad) throws zzad {
        zzaa zzi = com_google_android_gms_internal_zzr_.zzi();
        int zzh = com_google_android_gms_internal_zzr_.zzh();
        try {
            zzi.zza(com_google_android_gms_internal_zzad);
            com_google_android_gms_internal_zzr_.zzb(String.format("%s-retry [timeout=%s]", new Object[]{str, Integer.valueOf(zzh)}));
        } catch (zzad com_google_android_gms_internal_zzad2) {
            com_google_android_gms_internal_zzr_.zzb(String.format("%s-timeout-giveup [timeout=%s]", new Object[]{str, Integer.valueOf(zzh)}));
            throw com_google_android_gms_internal_zzad2;
        }
    }

    private final byte[] zza(java.io.InputStream r6, int r7) throws java.io.IOException, com.google.android.gms.internal.zzab {
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
        r5 = this;
        r0 = new com.google.android.gms.internal.zzat;
        r1 = r5.zzbr;
        r0.<init>(r1, r7);
        r7 = 0;
        r1 = 0;
        if (r6 != 0) goto L_0x0013;
    L_0x000b:
        r2 = new com.google.android.gms.internal.zzab;	 Catch:{ all -> 0x0011 }
        r2.<init>();	 Catch:{ all -> 0x0011 }
        throw r2;	 Catch:{ all -> 0x0011 }
    L_0x0011:
        r2 = move-exception;	 Catch:{ all -> 0x0011 }
        goto L_0x0044;	 Catch:{ all -> 0x0011 }
    L_0x0013:
        r2 = r5.zzbr;	 Catch:{ all -> 0x0011 }
        r3 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;	 Catch:{ all -> 0x0011 }
        r2 = r2.zzb(r3);	 Catch:{ all -> 0x0011 }
    L_0x001b:
        r1 = r6.read(r2);	 Catch:{ all -> 0x0040 }
        r3 = -1;	 Catch:{ all -> 0x0040 }
        if (r1 == r3) goto L_0x0026;	 Catch:{ all -> 0x0040 }
    L_0x0022:
        r0.write(r2, r7, r1);	 Catch:{ all -> 0x0040 }
        goto L_0x001b;	 Catch:{ all -> 0x0040 }
    L_0x0026:
        r1 = r0.toByteArray();	 Catch:{ all -> 0x0040 }
        if (r6 == 0) goto L_0x0037;
    L_0x002c:
        r6.close();	 Catch:{ IOException -> 0x0030 }
        goto L_0x0037;
    L_0x0030:
        r6 = "Error occurred when closing InputStream";
        r7 = new java.lang.Object[r7];
        com.google.android.gms.internal.zzae.zza(r6, r7);
    L_0x0037:
        r6 = r5.zzbr;
        r6.zza(r2);
        r0.close();
        return r1;
    L_0x0040:
        r1 = move-exception;
        r4 = r2;
        r2 = r1;
        r1 = r4;
    L_0x0044:
        if (r6 == 0) goto L_0x0051;
    L_0x0046:
        r6.close();	 Catch:{ IOException -> 0x004a }
        goto L_0x0051;
    L_0x004a:
        r6 = "Error occurred when closing InputStream";
        r7 = new java.lang.Object[r7];
        com.google.android.gms.internal.zzae.zza(r6, r7);
    L_0x0051:
        r6 = r5.zzbr;
        r6.zza(r1);
        r0.close();
        throw r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzai.zza(java.io.InputStream, int):byte[]");
    }

    public com.google.android.gms.internal.zzp zzc(com.google.android.gms.internal.zzr<?> r27) throws com.google.android.gms.internal.zzad {
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
        r26 = this;
        r1 = r26;
        r2 = r27;
        r3 = android.os.SystemClock.elapsedRealtime();
    L_0x0008:
        r5 = java.util.Collections.emptyList();
        r6 = 2;
        r7 = 1;
        r8 = 0;
        r9 = 0;
        r10 = r27.zze();	 Catch:{ SocketTimeoutException -> 0x01b3, MalformedURLException -> 0x0191, IOException -> 0x011d }
        if (r10 != 0) goto L_0x001b;	 Catch:{ SocketTimeoutException -> 0x01b3, MalformedURLException -> 0x0191, IOException -> 0x011d }
    L_0x0016:
        r10 = java.util.Collections.emptyMap();	 Catch:{ SocketTimeoutException -> 0x01b3, MalformedURLException -> 0x0191, IOException -> 0x011d }
        goto L_0x003f;	 Catch:{ SocketTimeoutException -> 0x01b3, MalformedURLException -> 0x0191, IOException -> 0x011d }
    L_0x001b:
        r11 = new java.util.HashMap;	 Catch:{ SocketTimeoutException -> 0x01b3, MalformedURLException -> 0x0191, IOException -> 0x011d }
        r11.<init>();	 Catch:{ SocketTimeoutException -> 0x01b3, MalformedURLException -> 0x0191, IOException -> 0x011d }
        r12 = r10.zza;	 Catch:{ SocketTimeoutException -> 0x01b3, MalformedURLException -> 0x0191, IOException -> 0x011d }
        if (r12 == 0) goto L_0x002b;	 Catch:{ SocketTimeoutException -> 0x01b3, MalformedURLException -> 0x0191, IOException -> 0x011d }
    L_0x0024:
        r12 = "If-None-Match";	 Catch:{ SocketTimeoutException -> 0x01b3, MalformedURLException -> 0x0191, IOException -> 0x011d }
        r13 = r10.zza;	 Catch:{ SocketTimeoutException -> 0x01b3, MalformedURLException -> 0x0191, IOException -> 0x011d }
        r11.put(r12, r13);	 Catch:{ SocketTimeoutException -> 0x01b3, MalformedURLException -> 0x0191, IOException -> 0x011d }
    L_0x002b:
        r12 = r10.zzc;	 Catch:{ SocketTimeoutException -> 0x01b3, MalformedURLException -> 0x0191, IOException -> 0x011d }
        r14 = 0;	 Catch:{ SocketTimeoutException -> 0x01b3, MalformedURLException -> 0x0191, IOException -> 0x011d }
        r12 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1));	 Catch:{ SocketTimeoutException -> 0x01b3, MalformedURLException -> 0x0191, IOException -> 0x011d }
        if (r12 <= 0) goto L_0x003e;	 Catch:{ SocketTimeoutException -> 0x01b3, MalformedURLException -> 0x0191, IOException -> 0x011d }
    L_0x0033:
        r12 = "If-Modified-Since";	 Catch:{ SocketTimeoutException -> 0x01b3, MalformedURLException -> 0x0191, IOException -> 0x011d }
        r13 = r10.zzc;	 Catch:{ SocketTimeoutException -> 0x01b3, MalformedURLException -> 0x0191, IOException -> 0x011d }
        r10 = com.google.android.gms.internal.zzao.zzb(r13);	 Catch:{ SocketTimeoutException -> 0x01b3, MalformedURLException -> 0x0191, IOException -> 0x011d }
        r11.put(r12, r10);	 Catch:{ SocketTimeoutException -> 0x01b3, MalformedURLException -> 0x0191, IOException -> 0x011d }
    L_0x003e:
        r10 = r11;	 Catch:{ SocketTimeoutException -> 0x01b3, MalformedURLException -> 0x0191, IOException -> 0x011d }
    L_0x003f:
        r11 = r1.zzbq;	 Catch:{ SocketTimeoutException -> 0x01b3, MalformedURLException -> 0x0191, IOException -> 0x011d }
        r10 = r11.zza(r2, r10);	 Catch:{ SocketTimeoutException -> 0x01b3, MalformedURLException -> 0x0191, IOException -> 0x011d }
        r12 = r10.getStatusCode();	 Catch:{ SocketTimeoutException -> 0x01b3, MalformedURLException -> 0x0191, IOException -> 0x0118 }
        r11 = r10.zzp();	 Catch:{ SocketTimeoutException -> 0x01b3, MalformedURLException -> 0x0191, IOException -> 0x0118 }
        r5 = 304; // 0x130 float:4.26E-43 double:1.5E-321;
        if (r12 != r5) goto L_0x008c;
    L_0x0051:
        r5 = r27.zze();	 Catch:{ SocketTimeoutException -> 0x01b3, MalformedURLException -> 0x0191, IOException -> 0x0085 }
        if (r5 != 0) goto L_0x006b;	 Catch:{ SocketTimeoutException -> 0x01b3, MalformedURLException -> 0x0191, IOException -> 0x0085 }
    L_0x0057:
        r5 = new com.google.android.gms.internal.zzp;	 Catch:{ SocketTimeoutException -> 0x01b3, MalformedURLException -> 0x0191, IOException -> 0x0085 }
        r14 = 304; // 0x130 float:4.26E-43 double:1.5E-321;	 Catch:{ SocketTimeoutException -> 0x01b3, MalformedURLException -> 0x0191, IOException -> 0x0085 }
        r15 = 0;	 Catch:{ SocketTimeoutException -> 0x01b3, MalformedURLException -> 0x0191, IOException -> 0x0085 }
        r16 = 1;	 Catch:{ SocketTimeoutException -> 0x01b3, MalformedURLException -> 0x0191, IOException -> 0x0085 }
        r12 = android.os.SystemClock.elapsedRealtime();	 Catch:{ SocketTimeoutException -> 0x01b3, MalformedURLException -> 0x0191, IOException -> 0x0085 }
        r17 = r12 - r3;	 Catch:{ SocketTimeoutException -> 0x01b3, MalformedURLException -> 0x0191, IOException -> 0x0085 }
        r13 = r5;	 Catch:{ SocketTimeoutException -> 0x01b3, MalformedURLException -> 0x0191, IOException -> 0x0085 }
        r19 = r11;	 Catch:{ SocketTimeoutException -> 0x01b3, MalformedURLException -> 0x0191, IOException -> 0x0085 }
        r13.<init>(r14, r15, r16, r17, r19);	 Catch:{ SocketTimeoutException -> 0x01b3, MalformedURLException -> 0x0191, IOException -> 0x0085 }
        return r5;	 Catch:{ SocketTimeoutException -> 0x01b3, MalformedURLException -> 0x0191, IOException -> 0x0085 }
    L_0x006b:
        r25 = zza(r11, r5);	 Catch:{ SocketTimeoutException -> 0x01b3, MalformedURLException -> 0x0191, IOException -> 0x0085 }
        r12 = new com.google.android.gms.internal.zzp;	 Catch:{ SocketTimeoutException -> 0x01b3, MalformedURLException -> 0x0191, IOException -> 0x0085 }
        r20 = 304; // 0x130 float:4.26E-43 double:1.5E-321;	 Catch:{ SocketTimeoutException -> 0x01b3, MalformedURLException -> 0x0191, IOException -> 0x0085 }
        r5 = r5.data;	 Catch:{ SocketTimeoutException -> 0x01b3, MalformedURLException -> 0x0191, IOException -> 0x0085 }
        r22 = 1;	 Catch:{ SocketTimeoutException -> 0x01b3, MalformedURLException -> 0x0191, IOException -> 0x0085 }
        r13 = android.os.SystemClock.elapsedRealtime();	 Catch:{ SocketTimeoutException -> 0x01b3, MalformedURLException -> 0x0191, IOException -> 0x0085 }
        r23 = r13 - r3;	 Catch:{ SocketTimeoutException -> 0x01b3, MalformedURLException -> 0x0191, IOException -> 0x0085 }
        r19 = r12;	 Catch:{ SocketTimeoutException -> 0x01b3, MalformedURLException -> 0x0191, IOException -> 0x0085 }
        r21 = r5;	 Catch:{ SocketTimeoutException -> 0x01b3, MalformedURLException -> 0x0191, IOException -> 0x0085 }
        r19.<init>(r20, r21, r22, r23, r25);	 Catch:{ SocketTimeoutException -> 0x01b3, MalformedURLException -> 0x0191, IOException -> 0x0085 }
        return r12;
    L_0x0085:
        r0 = move-exception;
        r5 = r0;
        r13 = r8;
        r17 = r11;
        goto L_0x0123;
    L_0x008c:
        r5 = r10.getContent();	 Catch:{ SocketTimeoutException -> 0x01b3, MalformedURLException -> 0x0191, IOException -> 0x0110 }
        if (r5 == 0) goto L_0x009b;
    L_0x0092:
        r13 = r10.getContentLength();	 Catch:{ SocketTimeoutException -> 0x01b3, MalformedURLException -> 0x0191, IOException -> 0x0085 }
        r5 = r1.zza(r5, r13);	 Catch:{ SocketTimeoutException -> 0x01b3, MalformedURLException -> 0x0191, IOException -> 0x0085 }
        goto L_0x009d;
    L_0x009b:
        r5 = new byte[r9];	 Catch:{ SocketTimeoutException -> 0x01b3, MalformedURLException -> 0x0191, IOException -> 0x0110 }
    L_0x009d:
        r13 = android.os.SystemClock.elapsedRealtime();	 Catch:{ SocketTimeoutException -> 0x01b3, MalformedURLException -> 0x0191, IOException -> 0x0109 }
        r13 = r13 - r3;	 Catch:{ SocketTimeoutException -> 0x01b3, MalformedURLException -> 0x0191, IOException -> 0x0109 }
        r8 = DEBUG;	 Catch:{ SocketTimeoutException -> 0x01b3, MalformedURLException -> 0x0191, IOException -> 0x0109 }
        if (r8 != 0) goto L_0x00ac;	 Catch:{ SocketTimeoutException -> 0x01b3, MalformedURLException -> 0x0191, IOException -> 0x0109 }
    L_0x00a6:
        r15 = 3000; // 0xbb8 float:4.204E-42 double:1.482E-320;	 Catch:{ SocketTimeoutException -> 0x01b3, MalformedURLException -> 0x0191, IOException -> 0x0109 }
        r8 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1));	 Catch:{ SocketTimeoutException -> 0x01b3, MalformedURLException -> 0x0191, IOException -> 0x0109 }
        if (r8 <= 0) goto L_0x00e4;	 Catch:{ SocketTimeoutException -> 0x01b3, MalformedURLException -> 0x0191, IOException -> 0x0109 }
    L_0x00ac:
        r8 = "HTTP response for request=<%s> [lifetime=%d], [size=%s], [rc=%d], [retryCount=%s]";	 Catch:{ SocketTimeoutException -> 0x01b3, MalformedURLException -> 0x0191, IOException -> 0x0109 }
        r15 = 5;	 Catch:{ SocketTimeoutException -> 0x01b3, MalformedURLException -> 0x0191, IOException -> 0x0109 }
        r15 = new java.lang.Object[r15];	 Catch:{ SocketTimeoutException -> 0x01b3, MalformedURLException -> 0x0191, IOException -> 0x0109 }
        r15[r9] = r2;	 Catch:{ SocketTimeoutException -> 0x01b3, MalformedURLException -> 0x0191, IOException -> 0x0109 }
        r13 = java.lang.Long.valueOf(r13);	 Catch:{ SocketTimeoutException -> 0x01b3, MalformedURLException -> 0x0191, IOException -> 0x0109 }
        r15[r7] = r13;	 Catch:{ SocketTimeoutException -> 0x01b3, MalformedURLException -> 0x0191, IOException -> 0x0109 }
        if (r5 == 0) goto L_0x00c7;
    L_0x00bb:
        r13 = r5.length;	 Catch:{ SocketTimeoutException -> 0x01b3, MalformedURLException -> 0x0191, IOException -> 0x00c1 }
        r13 = java.lang.Integer.valueOf(r13);	 Catch:{ SocketTimeoutException -> 0x01b3, MalformedURLException -> 0x0191, IOException -> 0x00c1 }
        goto L_0x00c9;
    L_0x00c1:
        r0 = move-exception;
        r13 = r5;
        r17 = r11;
        goto L_0x0122;
    L_0x00c7:
        r13 = "null";	 Catch:{ SocketTimeoutException -> 0x01b3, MalformedURLException -> 0x0191, IOException -> 0x0109 }
    L_0x00c9:
        r15[r6] = r13;	 Catch:{ SocketTimeoutException -> 0x01b3, MalformedURLException -> 0x0191, IOException -> 0x0109 }
        r13 = 3;	 Catch:{ SocketTimeoutException -> 0x01b3, MalformedURLException -> 0x0191, IOException -> 0x0109 }
        r14 = java.lang.Integer.valueOf(r12);	 Catch:{ SocketTimeoutException -> 0x01b3, MalformedURLException -> 0x0191, IOException -> 0x0109 }
        r15[r13] = r14;	 Catch:{ SocketTimeoutException -> 0x01b3, MalformedURLException -> 0x0191, IOException -> 0x0109 }
        r13 = 4;	 Catch:{ SocketTimeoutException -> 0x01b3, MalformedURLException -> 0x0191, IOException -> 0x0109 }
        r14 = r27.zzi();	 Catch:{ SocketTimeoutException -> 0x01b3, MalformedURLException -> 0x0191, IOException -> 0x0109 }
        r14 = r14.zzc();	 Catch:{ SocketTimeoutException -> 0x01b3, MalformedURLException -> 0x0191, IOException -> 0x0109 }
        r14 = java.lang.Integer.valueOf(r14);	 Catch:{ SocketTimeoutException -> 0x01b3, MalformedURLException -> 0x0191, IOException -> 0x0109 }
        r15[r13] = r14;	 Catch:{ SocketTimeoutException -> 0x01b3, MalformedURLException -> 0x0191, IOException -> 0x0109 }
        com.google.android.gms.internal.zzae.zzb(r8, r15);	 Catch:{ SocketTimeoutException -> 0x01b3, MalformedURLException -> 0x0191, IOException -> 0x0109 }
    L_0x00e4:
        r8 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;	 Catch:{ SocketTimeoutException -> 0x01b3, MalformedURLException -> 0x0191, IOException -> 0x0109 }
        if (r12 < r8) goto L_0x00ff;	 Catch:{ SocketTimeoutException -> 0x01b3, MalformedURLException -> 0x0191, IOException -> 0x0109 }
    L_0x00e8:
        r8 = 299; // 0x12b float:4.19E-43 double:1.477E-321;	 Catch:{ SocketTimeoutException -> 0x01b3, MalformedURLException -> 0x0191, IOException -> 0x0109 }
        if (r12 <= r8) goto L_0x00ed;	 Catch:{ SocketTimeoutException -> 0x01b3, MalformedURLException -> 0x0191, IOException -> 0x0109 }
    L_0x00ec:
        goto L_0x00ff;	 Catch:{ SocketTimeoutException -> 0x01b3, MalformedURLException -> 0x0191, IOException -> 0x0109 }
    L_0x00ed:
        r8 = new com.google.android.gms.internal.zzp;	 Catch:{ SocketTimeoutException -> 0x01b3, MalformedURLException -> 0x0191, IOException -> 0x0109 }
        r14 = 0;	 Catch:{ SocketTimeoutException -> 0x01b3, MalformedURLException -> 0x0191, IOException -> 0x0109 }
        r15 = android.os.SystemClock.elapsedRealtime();	 Catch:{ SocketTimeoutException -> 0x01b3, MalformedURLException -> 0x0191, IOException -> 0x0109 }
        r15 = r15 - r3;
        r18 = r11;
        r11 = r8;
        r13 = r5;
        r17 = r18;
        r11.<init>(r12, r13, r14, r15, r17);	 Catch:{ SocketTimeoutException -> 0x01b3, MalformedURLException -> 0x0191, IOException -> 0x0107 }
        return r8;	 Catch:{ SocketTimeoutException -> 0x01b3, MalformedURLException -> 0x0191, IOException -> 0x0107 }
    L_0x00ff:
        r18 = r11;	 Catch:{ SocketTimeoutException -> 0x01b3, MalformedURLException -> 0x0191, IOException -> 0x0107 }
        r8 = new java.io.IOException;	 Catch:{ SocketTimeoutException -> 0x01b3, MalformedURLException -> 0x0191, IOException -> 0x0107 }
        r8.<init>();	 Catch:{ SocketTimeoutException -> 0x01b3, MalformedURLException -> 0x0191, IOException -> 0x0107 }
        throw r8;	 Catch:{ SocketTimeoutException -> 0x01b3, MalformedURLException -> 0x0191, IOException -> 0x0107 }
    L_0x0107:
        r0 = move-exception;
        goto L_0x010c;
    L_0x0109:
        r0 = move-exception;
        r18 = r11;
    L_0x010c:
        r13 = r5;
        r17 = r18;
        goto L_0x0122;
    L_0x0110:
        r0 = move-exception;
        r18 = r11;
        r5 = r0;
        r13 = r8;
        r17 = r18;
        goto L_0x0123;
    L_0x0118:
        r0 = move-exception;
        r17 = r5;
        r13 = r8;
        goto L_0x0122;
    L_0x011d:
        r0 = move-exception;
        r17 = r5;
        r10 = r8;
        r13 = r10;
    L_0x0122:
        r5 = r0;
    L_0x0123:
        if (r10 == 0) goto L_0x018b;
    L_0x0125:
        r5 = r10.getStatusCode();
        r8 = "Unexpected response code %d for %s";
        r6 = new java.lang.Object[r6];
        r10 = java.lang.Integer.valueOf(r5);
        r6[r9] = r10;
        r9 = r27.getUrl();
        r6[r7] = r9;
        com.google.android.gms.internal.zzae.zzc(r8, r6);
        if (r13 == 0) goto L_0x0183;
    L_0x013e:
        r6 = new com.google.android.gms.internal.zzp;
        r14 = 0;
        r7 = android.os.SystemClock.elapsedRealtime();
        r15 = r7 - r3;
        r11 = r6;
        r12 = r5;
        r11.<init>(r12, r13, r14, r15, r17);
        r7 = 401; // 0x191 float:5.62E-43 double:1.98E-321;
        if (r5 == r7) goto L_0x0177;
    L_0x0150:
        r7 = 403; // 0x193 float:5.65E-43 double:1.99E-321;
        if (r5 != r7) goto L_0x0155;
    L_0x0154:
        goto L_0x0177;
    L_0x0155:
        r2 = 400; // 0x190 float:5.6E-43 double:1.976E-321;
        if (r5 < r2) goto L_0x0163;
    L_0x0159:
        r2 = 499; // 0x1f3 float:6.99E-43 double:2.465E-321;
        if (r5 > r2) goto L_0x0163;
    L_0x015d:
        r2 = new com.google.android.gms.internal.zzg;
        r2.<init>(r6);
        throw r2;
    L_0x0163:
        r2 = 500; // 0x1f4 float:7.0E-43 double:2.47E-321;
        if (r5 < r2) goto L_0x0171;
    L_0x0167:
        r2 = 599; // 0x257 float:8.4E-43 double:2.96E-321;
        if (r5 > r2) goto L_0x0171;
    L_0x016b:
        r2 = new com.google.android.gms.internal.zzab;
        r2.<init>(r6);
        throw r2;
    L_0x0171:
        r2 = new com.google.android.gms.internal.zzab;
        r2.<init>(r6);
        throw r2;
    L_0x0177:
        r5 = "auth";
        r7 = new com.google.android.gms.internal.zza;
        r7.<init>(r6);
        zza(r5, r2, r7);
        goto L_0x0008;
    L_0x0183:
        r5 = "network";
        r6 = new com.google.android.gms.internal.zzo;
        r6.<init>();
        goto L_0x01ba;
    L_0x018b:
        r2 = new com.google.android.gms.internal.zzq;
        r2.<init>(r5);
        throw r2;
    L_0x0191:
        r0 = move-exception;
        r3 = r0;
        r4 = new java.lang.RuntimeException;
        r5 = "Bad URL ";
        r2 = r27.getUrl();
        r2 = java.lang.String.valueOf(r2);
        r6 = r2.length();
        if (r6 == 0) goto L_0x01aa;
    L_0x01a5:
        r2 = r5.concat(r2);
        goto L_0x01af;
    L_0x01aa:
        r2 = new java.lang.String;
        r2.<init>(r5);
    L_0x01af:
        r4.<init>(r2, r3);
        throw r4;
    L_0x01b3:
        r5 = "socket";
        r6 = new com.google.android.gms.internal.zzac;
        r6.<init>();
    L_0x01ba:
        zza(r5, r2, r6);
        goto L_0x0008;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzai.zzc(com.google.android.gms.internal.zzr):com.google.android.gms.internal.zzp");
    }
}
