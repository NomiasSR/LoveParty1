package com.google.android.gms.internal;

import android.text.TextUtils;
import com.bumptech.glide.load.Key;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public final class zzal implements zzb {
    private final Map<String, zzam> zzbx;
    private long zzby;
    private final File zzbz;
    private final int zzca;

    public zzal(File file) {
        this(file, 5242880);
    }

    private zzal(File file, int i) {
        this.zzbx = new LinkedHashMap(16, 0.75f, true);
        this.zzby = 0;
        this.zzbz = file;
        this.zzca = 5242880;
    }

    private final synchronized void remove(String str) {
        boolean delete = zze(str).delete();
        removeEntry(str);
        if (!delete) {
            zzae.zzb("Could not delete cache entry for key=%s, filename=%s", str, zzd(str));
        }
    }

    private final void removeEntry(String str) {
        zzam com_google_android_gms_internal_zzam = (zzam) this.zzbx.remove(str);
        if (com_google_android_gms_internal_zzam != null) {
            this.zzby -= com_google_android_gms_internal_zzam.zzcb;
        }
    }

    private static int zza(InputStream inputStream) throws IOException {
        int read = inputStream.read();
        if (read != -1) {
            return read;
        }
        throw new EOFException();
    }

    private static InputStream zza(File file) throws FileNotFoundException {
        return new FileInputStream(file);
    }

    static String zza(zzan com_google_android_gms_internal_zzan) throws IOException {
        return new String(zza(com_google_android_gms_internal_zzan, zzc(com_google_android_gms_internal_zzan)), Key.STRING_CHARSET_NAME);
    }

    static void zza(OutputStream outputStream, int i) throws IOException {
        outputStream.write(i & 255);
        outputStream.write((i >> 8) & 255);
        outputStream.write((i >> 16) & 255);
        outputStream.write(i >>> 24);
    }

    static void zza(OutputStream outputStream, long j) throws IOException {
        outputStream.write((byte) ((int) j));
        outputStream.write((byte) ((int) (j >>> 8)));
        outputStream.write((byte) ((int) (j >>> 16)));
        outputStream.write((byte) ((int) (j >>> 24)));
        outputStream.write((byte) ((int) (j >>> 32)));
        outputStream.write((byte) ((int) (j >>> 40)));
        outputStream.write((byte) ((int) (j >>> 48)));
        outputStream.write((byte) ((int) (j >>> 56)));
    }

    static void zza(OutputStream outputStream, String str) throws IOException {
        byte[] bytes = str.getBytes(Key.STRING_CHARSET_NAME);
        zza(outputStream, (long) bytes.length);
        outputStream.write(bytes, 0, bytes.length);
    }

    private final void zza(String str, zzam com_google_android_gms_internal_zzam) {
        if (this.zzbx.containsKey(str)) {
            this.zzby += com_google_android_gms_internal_zzam.zzcb - ((zzam) this.zzbx.get(str)).zzcb;
        } else {
            this.zzby += com_google_android_gms_internal_zzam.zzcb;
        }
        this.zzbx.put(str, com_google_android_gms_internal_zzam);
    }

    private static byte[] zza(zzan com_google_android_gms_internal_zzan, long j) throws IOException {
        long zzn = com_google_android_gms_internal_zzan.zzn();
        if (j >= 0 && j <= zzn) {
            int i = (int) j;
            if (((long) i) == j) {
                byte[] bArr = new byte[i];
                new DataInputStream(com_google_android_gms_internal_zzan).readFully(bArr);
                return bArr;
            }
        }
        StringBuilder stringBuilder = new StringBuilder(73);
        stringBuilder.append("streamToBytes length=");
        stringBuilder.append(j);
        stringBuilder.append(", maxLength=");
        stringBuilder.append(zzn);
        throw new IOException(stringBuilder.toString());
    }

    static int zzb(InputStream inputStream) throws IOException {
        return (zza(inputStream) << 24) | (((zza(inputStream) | 0) | (zza(inputStream) << 8)) | (zza(inputStream) << 16));
    }

    static List<zzl> zzb(zzan com_google_android_gms_internal_zzan) throws IOException {
        int zzb = zzb((InputStream) com_google_android_gms_internal_zzan);
        List<zzl> emptyList = zzb == 0 ? Collections.emptyList() : new ArrayList(zzb);
        for (int i = 0; i < zzb; i++) {
            emptyList.add(new zzl(zza(com_google_android_gms_internal_zzan).intern(), zza(com_google_android_gms_internal_zzan).intern()));
        }
        return emptyList;
    }

    static long zzc(InputStream inputStream) throws IOException {
        return ((((((((((long) zza(inputStream)) & 255) | 0) | ((((long) zza(inputStream)) & 255) << 8)) | ((((long) zza(inputStream)) & 255) << 16)) | ((((long) zza(inputStream)) & 255) << 24)) | ((((long) zza(inputStream)) & 255) << 32)) | ((((long) zza(inputStream)) & 255) << 40)) | ((((long) zza(inputStream)) & 255) << 48)) | ((255 & ((long) zza(inputStream))) << 56);
    }

    private static String zzd(String str) {
        int length = str.length() / 2;
        String valueOf = String.valueOf(String.valueOf(str.substring(0, length).hashCode()));
        str = String.valueOf(String.valueOf(str.substring(length).hashCode()));
        return str.length() != 0 ? valueOf.concat(str) : new String(valueOf);
    }

    private final File zze(String str) {
        return new File(this.zzbz, zzd(str));
    }

    public final synchronized void initialize() {
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
        r9 = this;
        monitor-enter(r9);
        r0 = r9.zzbz;	 Catch:{ all -> 0x0061 }
        r0 = r0.exists();	 Catch:{ all -> 0x0061 }
        r1 = 0;	 Catch:{ all -> 0x0061 }
        if (r0 != 0) goto L_0x0024;	 Catch:{ all -> 0x0061 }
    L_0x000a:
        r0 = r9.zzbz;	 Catch:{ all -> 0x0061 }
        r0 = r0.mkdirs();	 Catch:{ all -> 0x0061 }
        if (r0 != 0) goto L_0x0022;	 Catch:{ all -> 0x0061 }
    L_0x0012:
        r0 = "Unable to create cache dir %s";	 Catch:{ all -> 0x0061 }
        r2 = 1;	 Catch:{ all -> 0x0061 }
        r2 = new java.lang.Object[r2];	 Catch:{ all -> 0x0061 }
        r3 = r9.zzbz;	 Catch:{ all -> 0x0061 }
        r3 = r3.getAbsolutePath();	 Catch:{ all -> 0x0061 }
        r2[r1] = r3;	 Catch:{ all -> 0x0061 }
        com.google.android.gms.internal.zzae.zzc(r0, r2);	 Catch:{ all -> 0x0061 }
    L_0x0022:
        monitor-exit(r9);
        return;
    L_0x0024:
        r0 = r9.zzbz;	 Catch:{ all -> 0x0061 }
        r0 = r0.listFiles();	 Catch:{ all -> 0x0061 }
        if (r0 != 0) goto L_0x002e;
    L_0x002c:
        monitor-exit(r9);
        return;
    L_0x002e:
        r2 = r0.length;	 Catch:{ all -> 0x0061 }
    L_0x002f:
        if (r1 >= r2) goto L_0x005f;	 Catch:{ all -> 0x0061 }
    L_0x0031:
        r3 = r0[r1];	 Catch:{ all -> 0x0061 }
        r4 = r3.length();	 Catch:{ IOException -> 0x0059 }
        r6 = new com.google.android.gms.internal.zzan;	 Catch:{ IOException -> 0x0059 }
        r7 = new java.io.BufferedInputStream;	 Catch:{ IOException -> 0x0059 }
        r8 = zza(r3);	 Catch:{ IOException -> 0x0059 }
        r7.<init>(r8);	 Catch:{ IOException -> 0x0059 }
        r6.<init>(r7, r4);	 Catch:{ IOException -> 0x0059 }
        r7 = com.google.android.gms.internal.zzam.zzc(r6);	 Catch:{ all -> 0x0054 }
        r7.zzcb = r4;	 Catch:{ all -> 0x0054 }
        r4 = r7.key;	 Catch:{ all -> 0x0054 }
        r9.zza(r4, r7);	 Catch:{ all -> 0x0054 }
        r6.close();	 Catch:{ IOException -> 0x0059 }
        goto L_0x005c;	 Catch:{ IOException -> 0x0059 }
    L_0x0054:
        r4 = move-exception;	 Catch:{ IOException -> 0x0059 }
        r6.close();	 Catch:{ IOException -> 0x0059 }
        throw r4;	 Catch:{ IOException -> 0x0059 }
    L_0x0059:
        r3.delete();	 Catch:{ all -> 0x0061 }
    L_0x005c:
        r1 = r1 + 1;
        goto L_0x002f;
    L_0x005f:
        monitor-exit(r9);
        return;
    L_0x0061:
        r0 = move-exception;
        monitor-exit(r9);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzal.initialize():void");
    }

    public final synchronized zzc zza(String str) {
        zzan com_google_android_gms_internal_zzan;
        zzam com_google_android_gms_internal_zzam = (zzam) this.zzbx.get(str);
        if (com_google_android_gms_internal_zzam == null) {
            return null;
        }
        File zze = zze(str);
        try {
            com_google_android_gms_internal_zzan = new zzan(new BufferedInputStream(zza(zze)), zze.length());
            if (TextUtils.equals(str, zzam.zzc(com_google_android_gms_internal_zzan).key)) {
                byte[] zza = zza(com_google_android_gms_internal_zzan, com_google_android_gms_internal_zzan.zzn());
                zzc com_google_android_gms_internal_zzc = new zzc();
                com_google_android_gms_internal_zzc.data = zza;
                com_google_android_gms_internal_zzc.zza = com_google_android_gms_internal_zzam.zza;
                com_google_android_gms_internal_zzc.zzb = com_google_android_gms_internal_zzam.zzb;
                com_google_android_gms_internal_zzc.zzc = com_google_android_gms_internal_zzam.zzc;
                com_google_android_gms_internal_zzc.zzd = com_google_android_gms_internal_zzam.zzd;
                com_google_android_gms_internal_zzc.zze = com_google_android_gms_internal_zzam.zze;
                com_google_android_gms_internal_zzc.zzf = zzao.zza(com_google_android_gms_internal_zzam.zzg);
                com_google_android_gms_internal_zzc.zzg = Collections.unmodifiableList(com_google_android_gms_internal_zzam.zzg);
                com_google_android_gms_internal_zzan.close();
                return com_google_android_gms_internal_zzc;
            }
            zzae.zzb("%s: key=%s, found=%s", zze.getAbsolutePath(), str, zzam.zzc(com_google_android_gms_internal_zzan).key);
            removeEntry(str);
            com_google_android_gms_internal_zzan.close();
            return null;
        } catch (IOException e) {
            zzae.zzb("%s: %s", zze.getAbsolutePath(), e.toString());
            remove(str);
            return null;
        } catch (Throwable th) {
            com_google_android_gms_internal_zzan.close();
        }
    }

    public final synchronized void zza(java.lang.String r20, com.google.android.gms.internal.zzc r21) {
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
        r19 = this;
        r1 = r19;
        r2 = r20;
        r3 = r21;
        monitor-enter(r19);
        r4 = r3.data;	 Catch:{ all -> 0x0111 }
        r4 = r4.length;	 Catch:{ all -> 0x0111 }
        r5 = r1.zzby;	 Catch:{ all -> 0x0111 }
        r7 = (long) r4;	 Catch:{ all -> 0x0111 }
        r5 = r5 + r7;	 Catch:{ all -> 0x0111 }
        r4 = r1.zzca;	 Catch:{ all -> 0x0111 }
        r9 = (long) r4;	 Catch:{ all -> 0x0111 }
        r4 = (r5 > r9 ? 1 : (r5 == r9 ? 0 : -1));	 Catch:{ all -> 0x0111 }
        r6 = 0;	 Catch:{ all -> 0x0111 }
        if (r4 < 0) goto L_0x00ba;	 Catch:{ all -> 0x0111 }
    L_0x0016:
        r4 = com.google.android.gms.internal.zzae.DEBUG;	 Catch:{ all -> 0x0111 }
        if (r4 == 0) goto L_0x0021;	 Catch:{ all -> 0x0111 }
    L_0x001a:
        r4 = "Pruning old cache entries.";	 Catch:{ all -> 0x0111 }
        r9 = new java.lang.Object[r6];	 Catch:{ all -> 0x0111 }
        com.google.android.gms.internal.zzae.zza(r4, r9);	 Catch:{ all -> 0x0111 }
    L_0x0021:
        r9 = r1.zzby;	 Catch:{ all -> 0x0111 }
        r11 = android.os.SystemClock.elapsedRealtime();	 Catch:{ all -> 0x0111 }
        r4 = r1.zzbx;	 Catch:{ all -> 0x0111 }
        r4 = r4.entrySet();	 Catch:{ all -> 0x0111 }
        r4 = r4.iterator();	 Catch:{ all -> 0x0111 }
        r13 = r6;	 Catch:{ all -> 0x0111 }
    L_0x0032:
        r14 = r4.hasNext();	 Catch:{ all -> 0x0111 }
        r15 = 2;	 Catch:{ all -> 0x0111 }
        if (r14 == 0) goto L_0x0090;	 Catch:{ all -> 0x0111 }
    L_0x0039:
        r14 = r4.next();	 Catch:{ all -> 0x0111 }
        r14 = (java.util.Map.Entry) r14;	 Catch:{ all -> 0x0111 }
        r14 = r14.getValue();	 Catch:{ all -> 0x0111 }
        r14 = (com.google.android.gms.internal.zzam) r14;	 Catch:{ all -> 0x0111 }
        r5 = r14.key;	 Catch:{ all -> 0x0111 }
        r5 = r1.zze(r5);	 Catch:{ all -> 0x0111 }
        r5 = r5.delete();	 Catch:{ all -> 0x0111 }
        if (r5 == 0) goto L_0x005b;	 Catch:{ all -> 0x0111 }
    L_0x0051:
        r16 = r7;	 Catch:{ all -> 0x0111 }
        r6 = r1.zzby;	 Catch:{ all -> 0x0111 }
        r2 = r14.zzcb;	 Catch:{ all -> 0x0111 }
        r6 = r6 - r2;	 Catch:{ all -> 0x0111 }
        r1.zzby = r6;	 Catch:{ all -> 0x0111 }
        goto L_0x0072;	 Catch:{ all -> 0x0111 }
    L_0x005b:
        r16 = r7;	 Catch:{ all -> 0x0111 }
        r2 = "Could not delete cache entry for key=%s, filename=%s";	 Catch:{ all -> 0x0111 }
        r3 = new java.lang.Object[r15];	 Catch:{ all -> 0x0111 }
        r5 = r14.key;	 Catch:{ all -> 0x0111 }
        r6 = 0;	 Catch:{ all -> 0x0111 }
        r3[r6] = r5;	 Catch:{ all -> 0x0111 }
        r5 = r14.key;	 Catch:{ all -> 0x0111 }
        r5 = zzd(r5);	 Catch:{ all -> 0x0111 }
        r6 = 1;	 Catch:{ all -> 0x0111 }
        r3[r6] = r5;	 Catch:{ all -> 0x0111 }
        com.google.android.gms.internal.zzae.zzb(r2, r3);	 Catch:{ all -> 0x0111 }
    L_0x0072:
        r4.remove();	 Catch:{ all -> 0x0111 }
        r13 = r13 + 1;	 Catch:{ all -> 0x0111 }
        r2 = r1.zzby;	 Catch:{ all -> 0x0111 }
        r2 = r2 + r16;	 Catch:{ all -> 0x0111 }
        r2 = (float) r2;	 Catch:{ all -> 0x0111 }
        r3 = r1.zzca;	 Catch:{ all -> 0x0111 }
        r3 = (float) r3;	 Catch:{ all -> 0x0111 }
        r5 = 1063675494; // 0x3f666666 float:0.9 double:5.2552552E-315;	 Catch:{ all -> 0x0111 }
        r3 = r3 * r5;	 Catch:{ all -> 0x0111 }
        r2 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1));	 Catch:{ all -> 0x0111 }
        if (r2 >= 0) goto L_0x0088;	 Catch:{ all -> 0x0111 }
    L_0x0087:
        goto L_0x0090;	 Catch:{ all -> 0x0111 }
    L_0x0088:
        r7 = r16;	 Catch:{ all -> 0x0111 }
        r2 = r20;	 Catch:{ all -> 0x0111 }
        r3 = r21;	 Catch:{ all -> 0x0111 }
        r6 = 0;	 Catch:{ all -> 0x0111 }
        goto L_0x0032;	 Catch:{ all -> 0x0111 }
    L_0x0090:
        r2 = com.google.android.gms.internal.zzae.DEBUG;	 Catch:{ all -> 0x0111 }
        if (r2 == 0) goto L_0x00b8;	 Catch:{ all -> 0x0111 }
    L_0x0094:
        r2 = "pruned %d files, %d bytes, %d ms";	 Catch:{ all -> 0x0111 }
        r3 = 3;	 Catch:{ all -> 0x0111 }
        r3 = new java.lang.Object[r3];	 Catch:{ all -> 0x0111 }
        r4 = java.lang.Integer.valueOf(r13);	 Catch:{ all -> 0x0111 }
        r5 = 0;	 Catch:{ all -> 0x0111 }
        r3[r5] = r4;	 Catch:{ all -> 0x0111 }
        r4 = r1.zzby;	 Catch:{ all -> 0x0111 }
        r4 = r4 - r9;	 Catch:{ all -> 0x0111 }
        r4 = java.lang.Long.valueOf(r4);	 Catch:{ all -> 0x0111 }
        r5 = 1;	 Catch:{ all -> 0x0111 }
        r3[r5] = r4;	 Catch:{ all -> 0x0111 }
        r4 = android.os.SystemClock.elapsedRealtime();	 Catch:{ all -> 0x0111 }
        r4 = r4 - r11;	 Catch:{ all -> 0x0111 }
        r4 = java.lang.Long.valueOf(r4);	 Catch:{ all -> 0x0111 }
        r3[r15] = r4;	 Catch:{ all -> 0x0111 }
        com.google.android.gms.internal.zzae.zza(r2, r3);	 Catch:{ all -> 0x0111 }
    L_0x00b8:
        r2 = r20;	 Catch:{ all -> 0x0111 }
    L_0x00ba:
        r3 = r19.zze(r20);	 Catch:{ all -> 0x0111 }
        r4 = new java.io.BufferedOutputStream;	 Catch:{ IOException -> 0x00fa }
        r5 = new java.io.FileOutputStream;	 Catch:{ IOException -> 0x00fa }
        r5.<init>(r3);	 Catch:{ IOException -> 0x00fa }
        r4.<init>(r5);	 Catch:{ IOException -> 0x00fa }
        r5 = new com.google.android.gms.internal.zzam;	 Catch:{ IOException -> 0x00fa }
        r6 = r21;	 Catch:{ IOException -> 0x00fa }
        r5.<init>(r2, r6);	 Catch:{ IOException -> 0x00fa }
        r7 = r5.zza(r4);	 Catch:{ IOException -> 0x00fa }
        if (r7 != 0) goto L_0x00ed;	 Catch:{ IOException -> 0x00fa }
    L_0x00d5:
        r4.close();	 Catch:{ IOException -> 0x00fa }
        r2 = "Failed to write header for %s";	 Catch:{ IOException -> 0x00fa }
        r4 = 1;	 Catch:{ IOException -> 0x00fa }
        r5 = new java.lang.Object[r4];	 Catch:{ IOException -> 0x00fa }
        r4 = r3.getAbsolutePath();	 Catch:{ IOException -> 0x00fa }
        r6 = 0;	 Catch:{ IOException -> 0x00fa }
        r5[r6] = r4;	 Catch:{ IOException -> 0x00fa }
        com.google.android.gms.internal.zzae.zzb(r2, r5);	 Catch:{ IOException -> 0x00fa }
        r2 = new java.io.IOException;	 Catch:{ IOException -> 0x00fa }
        r2.<init>();	 Catch:{ IOException -> 0x00fa }
        throw r2;	 Catch:{ IOException -> 0x00fa }
    L_0x00ed:
        r6 = r6.data;	 Catch:{ IOException -> 0x00fa }
        r4.write(r6);	 Catch:{ IOException -> 0x00fa }
        r4.close();	 Catch:{ IOException -> 0x00fa }
        r1.zza(r2, r5);	 Catch:{ IOException -> 0x00fa }
        monitor-exit(r19);
        return;
    L_0x00fa:
        r2 = r3.delete();	 Catch:{ all -> 0x0111 }
        if (r2 != 0) goto L_0x010f;	 Catch:{ all -> 0x0111 }
    L_0x0100:
        r2 = "Could not clean up file %s";	 Catch:{ all -> 0x0111 }
        r4 = 1;	 Catch:{ all -> 0x0111 }
        r4 = new java.lang.Object[r4];	 Catch:{ all -> 0x0111 }
        r3 = r3.getAbsolutePath();	 Catch:{ all -> 0x0111 }
        r5 = 0;	 Catch:{ all -> 0x0111 }
        r4[r5] = r3;	 Catch:{ all -> 0x0111 }
        com.google.android.gms.internal.zzae.zzb(r2, r4);	 Catch:{ all -> 0x0111 }
    L_0x010f:
        monitor-exit(r19);
        return;
    L_0x0111:
        r0 = move-exception;
        r2 = r0;
        monitor-exit(r19);
        throw r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzal.zza(java.lang.String, com.google.android.gms.internal.zzc):void");
    }
}
