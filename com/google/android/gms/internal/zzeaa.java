package com.google.android.gms.internal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.support.v4.media.session.PlaybackStateCompat;
import com.bumptech.glide.load.Key;
import com.google.firebase.analytics.FirebaseAnalytics.Param;
import com.google.firebase.database.DatabaseException;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class zzeaa implements zzegz {
    private static final Charset zzfhj = Charset.forName(Key.STRING_CHARSET_NAME);
    private final SQLiteDatabase zzmlq;
    private final zzejc zzmlr;
    private boolean zzmls;
    private long zzmlt = 0;

    public zzeaa(Context context, zzedc com_google_android_gms_internal_zzedc, String str) {
        try {
            str = URLEncoder.encode(str, "utf-8");
            this.zzmlr = com_google_android_gms_internal_zzedc.zzpv("Persistence");
            this.zzmlq = zzal(context, str);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    private static int zza(zzedk com_google_android_gms_internal_zzedk, List<String> list, int i) {
        int i2 = i + 1;
        String zzc = zzc(com_google_android_gms_internal_zzedk);
        if (((String) list.get(i)).startsWith(zzc)) {
            while (i2 < list.size() && ((String) list.get(i2)).equals(zza(com_google_android_gms_internal_zzedk, i2 - i))) {
                i2++;
            }
            if (i2 < list.size()) {
                String str = (String) list.get(i2);
                String valueOf = String.valueOf(zzc);
                zzc = String.valueOf(".part-");
                if (str.startsWith(zzc.length() != 0 ? valueOf.concat(zzc) : new String(valueOf))) {
                    throw new IllegalStateException("Run did not finish with all parts");
                }
            }
            return i2 - i;
        }
        throw new IllegalStateException("Extracting split nodes needs to start with path prefix");
    }

    private final int zza(String str, zzedk com_google_android_gms_internal_zzedk) {
        String zzpi = zzpi(zzc(com_google_android_gms_internal_zzedk));
        return this.zzmlq.delete(str, "path >= ? AND path < ?", new String[]{r7, zzpi});
    }

    private final Cursor zza(zzedk com_google_android_gms_internal_zzedk, String[] strArr) {
        String zzc = zzc(com_google_android_gms_internal_zzedk);
        String zzpi = zzpi(zzc);
        String[] strArr2 = new String[(com_google_android_gms_internal_zzedk.size() + 3)];
        StringBuilder stringBuilder = new StringBuilder("(");
        int i = 0;
        zzedk com_google_android_gms_internal_zzedk2 = com_google_android_gms_internal_zzedk;
        while (!com_google_android_gms_internal_zzedk2.isEmpty()) {
            stringBuilder.append("path");
            stringBuilder.append(" = ? OR ");
            strArr2[i] = zzc(com_google_android_gms_internal_zzedk2);
            com_google_android_gms_internal_zzedk2 = com_google_android_gms_internal_zzedk2.zzbwj();
            i++;
        }
        stringBuilder.append("path");
        stringBuilder.append(" = ?)");
        strArr2[i] = zzc(zzedk.zzbwe());
        String valueOf = String.valueOf(stringBuilder.toString());
        String valueOf2 = String.valueOf(" OR (path > ? AND path < ?)");
        String concat = valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
        strArr2[com_google_android_gms_internal_zzedk.size() + 1] = zzc;
        strArr2[com_google_android_gms_internal_zzedk.size() + 2] = zzpi;
        return this.zzmlq.query("serverCache", strArr, concat, strArr2, null, null, "path");
    }

    private static String zza(zzedk com_google_android_gms_internal_zzedk, int i) {
        String valueOf = String.valueOf(zzc(com_google_android_gms_internal_zzedk));
        String valueOf2 = String.valueOf(String.format(".part-%04d", new Object[]{Integer.valueOf(i)}));
        return valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
    }

    private final void zza(zzedk com_google_android_gms_internal_zzedk, long j, String str, byte[] bArr) {
        zzbtf();
        String[] strArr = new String[1];
        int i = 0;
        strArr[0] = String.valueOf(j);
        this.zzmlq.delete("writes", "id = ?", strArr);
        if (bArr.length >= 262144) {
            List zzf = zzf(bArr, 262144);
            while (i < zzf.size()) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("id", Long.valueOf(j));
                contentValues.put("path", zzc(com_google_android_gms_internal_zzedk));
                contentValues.put("type", str);
                contentValues.put("part", Integer.valueOf(i));
                contentValues.put("node", (byte[]) zzf.get(i));
                this.zzmlq.insertWithOnConflict("writes", null, contentValues, 5);
                i++;
            }
            return;
        }
        contentValues = new ContentValues();
        contentValues.put("id", Long.valueOf(j));
        contentValues.put("path", zzc(com_google_android_gms_internal_zzedk));
        contentValues.put("type", str);
        contentValues.put("part", null);
        contentValues.put("node", bArr);
        this.zzmlq.insertWithOnConflict("writes", null, contentValues, 5);
    }

    private final void zza(zzedk com_google_android_gms_internal_zzedk, zzedk com_google_android_gms_internal_zzedk2, zzehm<Long> com_google_android_gms_internal_zzehm_java_lang_Long, zzehm<Long> com_google_android_gms_internal_zzehm_java_lang_Long2, zzeha com_google_android_gms_internal_zzeha, List<zzelq<zzedk, zzekd>> list) {
        zzeaa com_google_android_gms_internal_zzeaa = this;
        zzehm<Long> com_google_android_gms_internal_zzehm_java_lang_Long3 = com_google_android_gms_internal_zzehm_java_lang_Long2;
        zzeha com_google_android_gms_internal_zzeha2 = com_google_android_gms_internal_zzeha;
        if (com_google_android_gms_internal_zzehm_java_lang_Long.getValue() != null) {
            if (((Integer) com_google_android_gms_internal_zzeha2.zza(Integer.valueOf(0), new zzeab(com_google_android_gms_internal_zzeaa, com_google_android_gms_internal_zzehm_java_lang_Long3))).intValue() > 0) {
                zzedk zzh = com_google_android_gms_internal_zzedk.zzh(com_google_android_gms_internal_zzedk2);
                if (com_google_android_gms_internal_zzeaa.zzmlr.zzbzl()) {
                    com_google_android_gms_internal_zzeaa.zzmlr.zzb(String.format("Need to rewrite %d nodes below path %s", new Object[]{Integer.valueOf(r1), zzh}), null, new Object[0]);
                }
                com_google_android_gms_internal_zzeha2.zza(null, new zzeac(com_google_android_gms_internal_zzeaa, com_google_android_gms_internal_zzehm_java_lang_Long3, list, com_google_android_gms_internal_zzedk2, zzb(zzh)));
            }
            return;
        }
        Iterator it = com_google_android_gms_internal_zzehm_java_lang_Long.zzbxx().iterator();
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            zzejg com_google_android_gms_internal_zzejg = (zzejg) entry.getKey();
            zzeha zzd = com_google_android_gms_internal_zzeha2.zzd((zzejg) entry.getKey());
            zza(com_google_android_gms_internal_zzedk, com_google_android_gms_internal_zzedk2.zza(com_google_android_gms_internal_zzejg), (zzehm) entry.getValue(), com_google_android_gms_internal_zzehm_java_lang_Long3.zze(com_google_android_gms_internal_zzejg), zzd, list);
        }
    }

    private final void zza(zzedk com_google_android_gms_internal_zzedk, zzekd com_google_android_gms_internal_zzekd, boolean z) {
        int i;
        int i2;
        long currentTimeMillis = System.currentTimeMillis();
        if (z) {
            i = 0;
            int i3 = i;
            for (zzekc com_google_android_gms_internal_zzekc : com_google_android_gms_internal_zzekd) {
                i3 += zza("serverCache", com_google_android_gms_internal_zzedk.zza(com_google_android_gms_internal_zzekc.zzcao()));
                i += zzc(com_google_android_gms_internal_zzedk.zza(com_google_android_gms_internal_zzekc.zzcao()), com_google_android_gms_internal_zzekc.zzbsv());
            }
            i2 = i;
            i = i3;
        } else {
            i = zza("serverCache", com_google_android_gms_internal_zzedk);
            i2 = zzc(com_google_android_gms_internal_zzedk, com_google_android_gms_internal_zzekd);
        }
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        if (this.zzmlr.zzbzl()) {
            this.zzmlr.zzb(String.format("Persisted a total of %d rows and deleted %d rows for a set at %s in %dms", new Object[]{Integer.valueOf(i2), Integer.valueOf(i), com_google_android_gms_internal_zzedk.toString(), Long.valueOf(currentTimeMillis2)}), null, new Object[0]);
        }
    }

    private static SQLiteDatabase zzal(Context context, String str) {
        try {
            SQLiteDatabase writableDatabase = new zzead(context, str).getWritableDatabase();
            writableDatabase.rawQuery("PRAGMA locking_mode = EXCLUSIVE", null).close();
            writableDatabase.beginTransaction();
            writableDatabase.endTransaction();
            return writableDatabase;
        } catch (Throwable e) {
            if (e instanceof SQLiteDatabaseLockedException) {
                throw new DatabaseException("Failed to gain exclusive lock to Firebase Database's offline persistence. This generally means you are using Firebase Database from multiple processes in your app. Keep in mind that multi-process Android apps execute the code in your Application class in all processes, so you may need to avoid initializing FirebaseDatabase in your Application class. If you are intentionally using Firebase Database from multiple processes, you can only enable offline persistence (i.e. call setPersistenceEnabled(true)) in one of them.", e);
            }
            throw e;
        }
    }

    private static zzekd zzan(byte[] bArr) {
        try {
            return zzekg.zza(zzelh.zzqc(new String(bArr, zzfhj)), zzeju.zzcaf());
        } catch (Throwable e) {
            String str = "Could not deserialize node: ";
            String valueOf = String.valueOf(new String(bArr, zzfhj));
            throw new RuntimeException(valueOf.length() != 0 ? str.concat(valueOf) : new String(str), e);
        }
    }

    private static byte[] zzar(List<byte[]> list) {
        int i = 0;
        for (byte[] length : list) {
            i += length.length;
        }
        Object obj = new byte[i];
        i = 0;
        for (byte[] length2 : list) {
            System.arraycopy(length2, 0, obj, i, length2.length);
            i += length2.length;
        }
        return obj;
    }

    private final zzekd zzb(zzedk com_google_android_gms_internal_zzedk) {
        long j;
        long j2;
        zzedk com_google_android_gms_internal_zzedk2 = com_google_android_gms_internal_zzedk;
        List arrayList = new ArrayList();
        List arrayList2 = new ArrayList();
        long currentTimeMillis = System.currentTimeMillis();
        Cursor zza = zza(com_google_android_gms_internal_zzedk2, new String[]{"path", Param.VALUE});
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        long currentTimeMillis3 = System.currentTimeMillis();
        while (zza.moveToNext()) {
            try {
                arrayList.add(zza.getString(0));
                arrayList2.add(zza.getBlob(1));
            } catch (Throwable th) {
                Throwable th2 = th;
                zza.close();
            }
        }
        zza.close();
        currentTimeMillis3 = System.currentTimeMillis() - currentTimeMillis3;
        long currentTimeMillis4 = System.currentTimeMillis();
        zzeju zzcaf = zzeju.zzcaf();
        Map hashMap = new HashMap();
        zzeju com_google_android_gms_internal_zzeju = zzcaf;
        int i = 0;
        int i2 = i;
        while (i < arrayList2.size()) {
            zzedk com_google_android_gms_internal_zzedk3;
            zzekd zzan;
            int i3;
            if (((String) arrayList.get(i)).endsWith(".part-0000")) {
                zzedk com_google_android_gms_internal_zzedk4;
                String str = (String) arrayList.get(i);
                j = currentTimeMillis3;
                com_google_android_gms_internal_zzedk3 = new zzedk(str.substring(0, str.length() - 10));
                int zza2 = zza(com_google_android_gms_internal_zzedk3, arrayList, i);
                if (r1.zzmlr.zzbzl()) {
                    zzejc com_google_android_gms_internal_zzejc = r1.zzmlr;
                    com_google_android_gms_internal_zzedk4 = com_google_android_gms_internal_zzedk3;
                    StringBuilder stringBuilder = new StringBuilder(42);
                    stringBuilder.append("Loading split node with ");
                    stringBuilder.append(zza2);
                    stringBuilder.append(" parts.");
                    j2 = currentTimeMillis2;
                    com_google_android_gms_internal_zzejc.zzb(stringBuilder.toString(), null, new Object[0]);
                } else {
                    j2 = currentTimeMillis2;
                    com_google_android_gms_internal_zzedk4 = com_google_android_gms_internal_zzedk3;
                }
                zza2 += i;
                zzan = zzan(zzar(arrayList2.subList(i, zza2)));
                i3 = zza2 - 1;
                com_google_android_gms_internal_zzedk3 = com_google_android_gms_internal_zzedk4;
            } else {
                j2 = currentTimeMillis2;
                j = currentTimeMillis3;
                zzekd zzan2 = zzan((byte[]) arrayList2.get(i));
                com_google_android_gms_internal_zzedk3 = new zzedk((String) arrayList.get(i));
                i3 = i;
                zzan = zzan2;
            }
            if (com_google_android_gms_internal_zzedk3.zzbwk() != null && com_google_android_gms_internal_zzedk3.zzbwk().zzbzr()) {
                hashMap.put(com_google_android_gms_internal_zzedk3, zzan);
            } else if (com_google_android_gms_internal_zzedk3.zzi(com_google_android_gms_internal_zzedk2)) {
                zzelt.zzb(i2 ^ 1, "Descendants of path must come after ancestors.");
                zzekd zzan3 = zzan.zzan(zzedk.zza(com_google_android_gms_internal_zzedk3, com_google_android_gms_internal_zzedk2));
            } else if (com_google_android_gms_internal_zzedk2.zzi(com_google_android_gms_internal_zzedk3)) {
                com_google_android_gms_internal_zzeju = com_google_android_gms_internal_zzeju.zzl(zzedk.zza(com_google_android_gms_internal_zzedk2, com_google_android_gms_internal_zzedk3), zzan);
                i2 = 1;
                i = i3 + 1;
                currentTimeMillis3 = j;
                currentTimeMillis2 = j2;
            } else {
                throw new IllegalStateException(String.format("Loading an unrelated row with path %s for %s", new Object[]{com_google_android_gms_internal_zzedk3, com_google_android_gms_internal_zzedk2}));
            }
            i = i3 + 1;
            currentTimeMillis3 = j;
            currentTimeMillis2 = j2;
        }
        j2 = currentTimeMillis2;
        j = currentTimeMillis3;
        zzekd com_google_android_gms_internal_zzekd = com_google_android_gms_internal_zzeju;
        for (Entry entry : hashMap.entrySet()) {
            com_google_android_gms_internal_zzekd = com_google_android_gms_internal_zzekd.zzl(zzedk.zza(com_google_android_gms_internal_zzedk2, (zzedk) entry.getKey()), (zzekd) entry.getValue());
        }
        long currentTimeMillis5 = System.currentTimeMillis() - currentTimeMillis4;
        long currentTimeMillis6 = System.currentTimeMillis() - currentTimeMillis;
        if (r1.zzmlr.zzbzl()) {
            r1.zzmlr.zzb(String.format("Loaded a total of %d rows for a total of %d nodes at %s in %dms (Query: %dms, Loading: %dms, Serializing: %dms)", new Object[]{Integer.valueOf(arrayList2.size()), Integer.valueOf(zzelo.zzo(com_google_android_gms_internal_zzekd)), com_google_android_gms_internal_zzedk2, Long.valueOf(currentTimeMillis6), Long.valueOf(j2), Long.valueOf(j), Long.valueOf(currentTimeMillis5)}), null, new Object[0]);
        }
        return com_google_android_gms_internal_zzekd;
    }

    private static byte[] zzbe(Object obj) {
        try {
            return zzelh.zzbt(obj).getBytes(zzfhj);
        } catch (Throwable e) {
            throw new RuntimeException("Could not serialize leaf node", e);
        }
    }

    private final void zzbtf() {
        zzelt.zzb(this.zzmls, "Transaction expected to already be in progress.");
    }

    private final int zzc(zzedk com_google_android_gms_internal_zzedk, zzekd com_google_android_gms_internal_zzekd) {
        long zzn = zzelo.zzn(com_google_android_gms_internal_zzekd);
        if (!(com_google_android_gms_internal_zzekd instanceof zzeji) || zzn <= PlaybackStateCompat.ACTION_PREPARE) {
            zzd(com_google_android_gms_internal_zzedk, com_google_android_gms_internal_zzekd);
            return 1;
        }
        int i = 0;
        if (this.zzmlr.zzbzl()) {
            this.zzmlr.zzb(String.format("Node estimated serialized size at path %s of %d bytes exceeds limit of %d bytes. Splitting up.", new Object[]{com_google_android_gms_internal_zzedk, Long.valueOf(zzn), Integer.valueOf(16384)}), null, new Object[0]);
        }
        for (zzekc com_google_android_gms_internal_zzekc : com_google_android_gms_internal_zzekd) {
            i += zzc(com_google_android_gms_internal_zzedk.zza(com_google_android_gms_internal_zzekc.zzcao()), com_google_android_gms_internal_zzekc.zzbsv());
        }
        if (!com_google_android_gms_internal_zzekd.zzbzv().isEmpty()) {
            zzd(com_google_android_gms_internal_zzedk.zza(zzejg.zzbzp()), com_google_android_gms_internal_zzekd.zzbzv());
            i++;
        }
        zzd(com_google_android_gms_internal_zzedk, zzeju.zzcaf());
        return i + 1;
    }

    private static String zzc(zzedk com_google_android_gms_internal_zzedk) {
        return com_google_android_gms_internal_zzedk.isEmpty() ? "/" : String.valueOf(com_google_android_gms_internal_zzedk.toString()).concat("/");
    }

    private final void zzd(zzedk com_google_android_gms_internal_zzedk, zzekd com_google_android_gms_internal_zzekd) {
        byte[] zzbe = zzbe(com_google_android_gms_internal_zzekd.getValue(true));
        if (zzbe.length >= 262144) {
            List zzf = zzf(zzbe, 262144);
            int i = 0;
            if (this.zzmlr.zzbzl()) {
                zzejc com_google_android_gms_internal_zzejc = this.zzmlr;
                int size = zzf.size();
                StringBuilder stringBuilder = new StringBuilder(45);
                stringBuilder.append("Saving huge leaf node with ");
                stringBuilder.append(size);
                stringBuilder.append(" parts.");
                com_google_android_gms_internal_zzejc.zzb(stringBuilder.toString(), null, new Object[0]);
            }
            while (i < zzf.size()) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("path", zza(com_google_android_gms_internal_zzedk, i));
                contentValues.put(Param.VALUE, (byte[]) zzf.get(i));
                this.zzmlq.insertWithOnConflict("serverCache", null, contentValues, 5);
                i++;
            }
            return;
        }
        contentValues = new ContentValues();
        contentValues.put("path", zzc(com_google_android_gms_internal_zzedk));
        contentValues.put(Param.VALUE, zzbe);
        this.zzmlq.insertWithOnConflict("serverCache", null, contentValues, 5);
    }

    private static List<byte[]> zzf(byte[] bArr, int i) {
        i = ((bArr.length - 1) / 262144) + 1;
        List<byte[]> arrayList = new ArrayList(i);
        for (int i2 = 0; i2 < i; i2++) {
            int i3 = i2 * 262144;
            int min = Math.min(262144, bArr.length - i3);
            Object obj = new byte[min];
            System.arraycopy(bArr, i3, obj, 0, min);
            arrayList.add(obj);
        }
        return arrayList;
    }

    private static String zzpi(String str) {
        str = str.substring(0, str.length() - 1);
        StringBuilder stringBuilder = new StringBuilder(1 + String.valueOf(str).length());
        stringBuilder.append(str);
        stringBuilder.append('0');
        return stringBuilder.toString();
    }

    private static String zzr(Collection<Long> collection) {
        StringBuilder stringBuilder = new StringBuilder();
        Object obj = 1;
        for (Long longValue : collection) {
            long longValue2 = longValue.longValue();
            if (obj == null) {
                stringBuilder.append(",");
            }
            obj = null;
            stringBuilder.append(longValue2);
        }
        return stringBuilder.toString();
    }

    public final void beginTransaction() {
        zzelt.zzb(this.zzmls ^ true, "runInTransaction called when an existing transaction is already in progress.");
        if (this.zzmlr.zzbzl()) {
            this.zzmlr.zzb("Starting transaction.", null, new Object[0]);
        }
        this.zzmlq.beginTransaction();
        this.zzmls = true;
        this.zzmlt = System.currentTimeMillis();
    }

    public final void endTransaction() {
        this.zzmlq.endTransaction();
        this.zzmls = false;
        long currentTimeMillis = System.currentTimeMillis() - this.zzmlt;
        if (this.zzmlr.zzbzl()) {
            this.zzmlr.zzb(String.format("Transaction completed. Elapsed: %dms", new Object[]{Long.valueOf(currentTimeMillis)}), null, new Object[0]);
        }
    }

    public final void setTransactionSuccessful() {
        this.zzmlq.setTransactionSuccessful();
    }

    public final zzekd zza(zzedk com_google_android_gms_internal_zzedk) {
        return zzb(com_google_android_gms_internal_zzedk);
    }

    public final void zza(long j, Set<zzejg> set) {
        zzbtf();
        long currentTimeMillis = System.currentTimeMillis();
        String valueOf = String.valueOf(j);
        this.zzmlq.delete("trackedKeys", "id = ?", new String[]{valueOf});
        for (zzejg com_google_android_gms_internal_zzejg : set) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("id", Long.valueOf(j));
            contentValues.put("key", com_google_android_gms_internal_zzejg.asString());
            this.zzmlq.insertWithOnConflict("trackedKeys", null, contentValues, 5);
        }
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        if (this.zzmlr.zzbzl()) {
            this.zzmlr.zzb(String.format("Set %d tracked query keys for tracked query %d in %dms", new Object[]{Integer.valueOf(set.size()), Long.valueOf(j), Long.valueOf(currentTimeMillis2)}), null, new Object[0]);
        }
    }

    public final void zza(long j, Set<zzejg> set, Set<zzejg> set2) {
        zzbtf();
        long currentTimeMillis = System.currentTimeMillis();
        String str = "id = ? AND key = ?";
        String valueOf = String.valueOf(j);
        for (zzejg com_google_android_gms_internal_zzejg : set2) {
            this.zzmlq.delete("trackedKeys", str, new String[]{valueOf, com_google_android_gms_internal_zzejg.asString()});
        }
        for (zzejg com_google_android_gms_internal_zzejg2 : set) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("id", Long.valueOf(j));
            contentValues.put("key", com_google_android_gms_internal_zzejg2.asString());
            this.zzmlq.insertWithOnConflict("trackedKeys", null, contentValues, 5);
        }
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        if (this.zzmlr.zzbzl()) {
            this.zzmlr.zzb(String.format("Updated tracked query keys (%d added, %d removed) for tracked query id %d in %dms", new Object[]{Integer.valueOf(set.size()), Integer.valueOf(set2.size()), Long.valueOf(j), Long.valueOf(currentTimeMillis2)}), null, new Object[0]);
        }
    }

    public final void zza(zzedk com_google_android_gms_internal_zzedk, zzecy com_google_android_gms_internal_zzecy) {
        zzbtf();
        long currentTimeMillis = System.currentTimeMillis();
        Iterator it = com_google_android_gms_internal_zzecy.iterator();
        int i = 0;
        int i2 = i;
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            i += zza("serverCache", com_google_android_gms_internal_zzedk.zzh((zzedk) entry.getKey()));
            i2 += zzc(com_google_android_gms_internal_zzedk.zzh((zzedk) entry.getKey()), (zzekd) entry.getValue());
        }
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        if (this.zzmlr.zzbzl()) {
            this.zzmlr.zzb(String.format("Persisted a total of %d rows and deleted %d rows for a merge at %s in %dms", new Object[]{Integer.valueOf(i2), Integer.valueOf(i), com_google_android_gms_internal_zzedk.toString(), Long.valueOf(currentTimeMillis2)}), null, new Object[0]);
        }
    }

    public final void zza(zzedk com_google_android_gms_internal_zzedk, zzecy com_google_android_gms_internal_zzecy, long j) {
        zzbtf();
        long currentTimeMillis = System.currentTimeMillis();
        zzedk com_google_android_gms_internal_zzedk2 = com_google_android_gms_internal_zzedk;
        long j2 = j;
        zza(com_google_android_gms_internal_zzedk2, j2, "m", zzbe(com_google_android_gms_internal_zzecy.zzcn(true)));
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        if (this.zzmlr.zzbzl()) {
            this.zzmlr.zzb(String.format("Persisted user merge in %dms", new Object[]{Long.valueOf(currentTimeMillis2)}), null, new Object[0]);
        }
    }

    public final void zza(zzedk com_google_android_gms_internal_zzedk, zzeha com_google_android_gms_internal_zzeha) {
        zzeaa com_google_android_gms_internal_zzeaa = this;
        zzedk com_google_android_gms_internal_zzedk2 = com_google_android_gms_internal_zzedk;
        zzeha com_google_android_gms_internal_zzeha2 = com_google_android_gms_internal_zzeha;
        if (com_google_android_gms_internal_zzeha.zzbxs()) {
            int i;
            int i2;
            zzbtf();
            long currentTimeMillis = System.currentTimeMillis();
            Cursor zza = zza(com_google_android_gms_internal_zzedk2, new String[]{"rowid", "path"});
            zzehm com_google_android_gms_internal_zzehm = new zzehm(null);
            zzehm com_google_android_gms_internal_zzehm2 = new zzehm(null);
            while (zza.moveToNext()) {
                zzejc com_google_android_gms_internal_zzejc;
                String valueOf;
                StringBuilder stringBuilder;
                long j = zza.getLong(0);
                zzedk com_google_android_gms_internal_zzedk3 = new zzedk(zza.getString(1));
                String valueOf2;
                if (com_google_android_gms_internal_zzedk2.zzi(com_google_android_gms_internal_zzedk3)) {
                    zzedk zza2 = zzedk.zza(com_google_android_gms_internal_zzedk2, com_google_android_gms_internal_zzedk3);
                    if (com_google_android_gms_internal_zzeha2.zzv(zza2)) {
                        com_google_android_gms_internal_zzehm = com_google_android_gms_internal_zzehm.zzb(zza2, Long.valueOf(j));
                    } else if (com_google_android_gms_internal_zzeha2.zzw(zza2)) {
                        com_google_android_gms_internal_zzehm2 = com_google_android_gms_internal_zzehm2.zzb(zza2, Long.valueOf(j));
                    } else {
                        com_google_android_gms_internal_zzejc = com_google_android_gms_internal_zzeaa.zzmlr;
                        valueOf = String.valueOf(com_google_android_gms_internal_zzedk);
                        valueOf2 = String.valueOf(com_google_android_gms_internal_zzedk3);
                        stringBuilder = new StringBuilder((88 + String.valueOf(valueOf).length()) + String.valueOf(valueOf2).length());
                        stringBuilder.append("We are pruning at ");
                        stringBuilder.append(valueOf);
                        stringBuilder.append(" and have data at ");
                        stringBuilder.append(valueOf2);
                        valueOf = " that isn't marked for pruning or keeping. Ignoring.";
                    }
                } else {
                    com_google_android_gms_internal_zzejc = com_google_android_gms_internal_zzeaa.zzmlr;
                    valueOf = String.valueOf(com_google_android_gms_internal_zzedk);
                    valueOf2 = String.valueOf(com_google_android_gms_internal_zzedk3);
                    stringBuilder = new StringBuilder((67 + String.valueOf(valueOf).length()) + String.valueOf(valueOf2).length());
                    stringBuilder.append("We are pruning at ");
                    stringBuilder.append(valueOf);
                    stringBuilder.append(" but we have data stored higher up at ");
                    stringBuilder.append(valueOf2);
                    valueOf = ". Ignoring.";
                }
                stringBuilder.append(valueOf);
                com_google_android_gms_internal_zzejc.zze(stringBuilder.toString(), null);
            }
            if (com_google_android_gms_internal_zzehm.isEmpty()) {
                i = 0;
                i2 = i;
            } else {
                List arrayList = new ArrayList();
                zza(com_google_android_gms_internal_zzedk2, zzedk.zzbwe(), com_google_android_gms_internal_zzehm, com_google_android_gms_internal_zzehm2, com_google_android_gms_internal_zzeha2, arrayList);
                Collection values = com_google_android_gms_internal_zzehm.values();
                String zzr = zzr(values);
                StringBuilder stringBuilder2 = new StringBuilder(11 + String.valueOf(zzr).length());
                stringBuilder2.append("rowid IN (");
                stringBuilder2.append(zzr);
                stringBuilder2.append(")");
                com_google_android_gms_internal_zzeaa.zzmlq.delete("serverCache", stringBuilder2.toString(), null);
                ArrayList arrayList2 = (ArrayList) arrayList;
                int size = arrayList2.size();
                int i3 = 0;
                while (i3 < size) {
                    Object obj = arrayList2.get(i3);
                    i3++;
                    zzelq com_google_android_gms_internal_zzelq = (zzelq) obj;
                    zzc(com_google_android_gms_internal_zzedk2.zzh((zzedk) com_google_android_gms_internal_zzelq.getFirst()), (zzekd) com_google_android_gms_internal_zzelq.zzcbg());
                }
                i = values.size();
                i2 = arrayList.size();
            }
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            if (com_google_android_gms_internal_zzeaa.zzmlr.zzbzl()) {
                com_google_android_gms_internal_zzeaa.zzmlr.zzb(String.format("Pruned %d rows with %d nodes resaved in %dms", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(currentTimeMillis2)}), null, new Object[0]);
            }
        }
    }

    public final void zza(zzedk com_google_android_gms_internal_zzedk, zzekd com_google_android_gms_internal_zzekd) {
        zzbtf();
        zza(com_google_android_gms_internal_zzedk, com_google_android_gms_internal_zzekd, false);
    }

    public final void zza(zzedk com_google_android_gms_internal_zzedk, zzekd com_google_android_gms_internal_zzekd, long j) {
        zzbtf();
        long currentTimeMillis = System.currentTimeMillis();
        zzedk com_google_android_gms_internal_zzedk2 = com_google_android_gms_internal_zzedk;
        long j2 = j;
        zza(com_google_android_gms_internal_zzedk2, j2, "o", zzbe(com_google_android_gms_internal_zzekd.getValue(true)));
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        if (this.zzmlr.zzbzl()) {
            this.zzmlr.zzb(String.format("Persisted user overwrite in %dms", new Object[]{Long.valueOf(currentTimeMillis2)}), null, new Object[0]);
        }
    }

    public final void zza(zzehe com_google_android_gms_internal_zzehe) {
        zzbtf();
        long currentTimeMillis = System.currentTimeMillis();
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", Long.valueOf(com_google_android_gms_internal_zzehe.id));
        contentValues.put("path", zzc(com_google_android_gms_internal_zzehe.zzmyn.zzbsy()));
        contentValues.put("queryParams", com_google_android_gms_internal_zzehe.zzmyn.zzbyy().zzbyw());
        contentValues.put("lastUse", Long.valueOf(com_google_android_gms_internal_zzehe.zzmyo));
        contentValues.put("complete", Boolean.valueOf(com_google_android_gms_internal_zzehe.complete));
        contentValues.put("active", Boolean.valueOf(com_google_android_gms_internal_zzehe.zziyi));
        this.zzmlq.insertWithOnConflict("trackedQueries", null, contentValues, 5);
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        if (this.zzmlr.zzbzl()) {
            this.zzmlr.zzb(String.format("Saved new tracked query in %dms", new Object[]{Long.valueOf(currentTimeMillis2)}), null, new Object[0]);
        }
    }

    public final void zzb(zzedk com_google_android_gms_internal_zzedk, zzekd com_google_android_gms_internal_zzekd) {
        zzbtf();
        zza(com_google_android_gms_internal_zzedk, com_google_android_gms_internal_zzekd, true);
    }

    public final void zzbl(long j) {
        zzbtf();
        long currentTimeMillis = System.currentTimeMillis();
        int delete = this.zzmlq.delete("writes", "id = ?", new String[]{String.valueOf(j)});
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        if (this.zzmlr.zzbzl()) {
            this.zzmlr.zzb(String.format("Deleted %d write(s) with writeId %d in %dms", new Object[]{Integer.valueOf(delete), Long.valueOf(j), Long.valueOf(currentTimeMillis2)}), null, new Object[0]);
        }
    }

    public final void zzbm(long j) {
        zzbtf();
        String valueOf = String.valueOf(j);
        this.zzmlq.delete("trackedQueries", "id = ?", new String[]{valueOf});
        this.zzmlq.delete("trackedKeys", "id = ?", new String[]{valueOf});
    }

    public final void zzbn(long j) {
        zzbtf();
        long currentTimeMillis = System.currentTimeMillis();
        ContentValues contentValues = new ContentValues();
        contentValues.put("active", Boolean.valueOf(false));
        contentValues.put("lastUse", Long.valueOf(j));
        this.zzmlq.updateWithOnConflict("trackedQueries", contentValues, "active = 1", new String[0], 5);
        j = System.currentTimeMillis() - currentTimeMillis;
        if (this.zzmlr.zzbzl()) {
            this.zzmlr.zzb(String.format("Reset active tracked queries in %dms", new Object[]{Long.valueOf(j)}), null, new Object[0]);
        }
    }

    public final Set<zzejg> zzbo(long j) {
        return zze(Collections.singleton(Long.valueOf(j)));
    }

    public final List<zzegd> zzbtb() {
        String[] strArr = new String[]{"id", "path", "type", "part", "node"};
        long currentTimeMillis = System.currentTimeMillis();
        Cursor query = this.zzmlq.query("writes", strArr, null, null, null, null, "id, part");
        List<zzegd> arrayList = new ArrayList();
        while (query.moveToNext()) {
            try {
                byte[] blob;
                Object com_google_android_gms_internal_zzegd;
                long j = query.getLong(0);
                zzedk com_google_android_gms_internal_zzedk = new zzedk(query.getString(1));
                String string = query.getString(2);
                if (query.isNull(3)) {
                    blob = query.getBlob(4);
                } else {
                    List arrayList2 = new ArrayList();
                    do {
                        arrayList2.add(query.getBlob(4));
                        if (!query.moveToNext()) {
                            break;
                        }
                    } while (query.getLong(0) == j);
                    query.moveToPrevious();
                    blob = zzar(arrayList2);
                }
                Object zzqc = zzelh.zzqc(new String(blob, zzfhj));
                if ("o".equals(string)) {
                    zzegd com_google_android_gms_internal_zzegd2 = new zzegd(j, com_google_android_gms_internal_zzedk, zzekg.zza(zzqc, zzeju.zzcaf()), true);
                } else if ("m".equals(string)) {
                    com_google_android_gms_internal_zzegd = new zzegd(j, com_google_android_gms_internal_zzedk, zzecy.zzak((Map) zzqc));
                } else {
                    String str = "Got invalid write type: ";
                    String valueOf = String.valueOf(string);
                    throw new IllegalStateException(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
                }
                arrayList.add(com_google_android_gms_internal_zzegd);
            } catch (Throwable e) {
                throw new RuntimeException("Failed to load writes", e);
            } catch (Throwable th) {
                query.close();
            }
        }
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        if (this.zzmlr.zzbzl()) {
            this.zzmlr.zzb(String.format("Loaded %d writes in %dms", new Object[]{Integer.valueOf(arrayList.size()), Long.valueOf(currentTimeMillis2)}), null, new Object[0]);
        }
        query.close();
        return arrayList;
    }

    public final long zzbtc() {
        Cursor rawQuery = this.zzmlq.rawQuery(String.format("SELECT sum(length(%s) + length(%s)) FROM %s", new Object[]{Param.VALUE, "path", "serverCache"}), null);
        try {
            if (rawQuery.moveToFirst()) {
                long j = rawQuery.getLong(0);
                return j;
            }
            throw new IllegalStateException("Couldn't read database result!");
        } finally {
            rawQuery.close();
        }
    }

    public final List<zzehe> zzbtd() {
        String[] strArr = new String[]{"id", "path", "queryParams", "lastUse", "complete", "active"};
        long currentTimeMillis = System.currentTimeMillis();
        Cursor query = this.zzmlq.query("trackedQueries", strArr, null, null, null, null, "id");
        List<zzehe> arrayList = new ArrayList();
        while (query.moveToNext()) {
            try {
                arrayList.add(new zzehe(query.getLong(0), new zzeik(new zzedk(query.getString(1)), zzeih.zzam(zzelh.zzqb(query.getString(2)))), query.getLong(3), query.getInt(4) != 0, query.getInt(5) != 0));
            } catch (Throwable e) {
                throw new RuntimeException(e);
            } catch (Throwable e2) {
                Throwable th = e2;
                query.close();
            }
        }
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        if (r1.zzmlr.zzbzl()) {
            r1.zzmlr.zzb(String.format("Loaded %d tracked queries in %dms", new Object[]{Integer.valueOf(arrayList.size()), Long.valueOf(currentTimeMillis2)}), null, new Object[0]);
        }
        query.close();
        return arrayList;
    }

    public final void zzbte() {
        zzbtf();
        long currentTimeMillis = System.currentTimeMillis();
        int delete = this.zzmlq.delete("writes", null, null);
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        if (this.zzmlr.zzbzl()) {
            this.zzmlr.zzb(String.format("Deleted %d (all) write(s) in %dms", new Object[]{Integer.valueOf(delete), Long.valueOf(currentTimeMillis2)}), null, new Object[0]);
        }
    }

    public final Set<zzejg> zze(Set<Long> set) {
        String[] strArr = new String[]{"key"};
        long currentTimeMillis = System.currentTimeMillis();
        String str = "id IN (";
        String zzr = zzr(set);
        StringBuilder stringBuilder = new StringBuilder((String.valueOf(str).length() + 1) + String.valueOf(zzr).length());
        stringBuilder.append(str);
        stringBuilder.append(zzr);
        stringBuilder.append(")");
        Cursor query = this.zzmlq.query(true, "trackedKeys", strArr, stringBuilder.toString(), null, null, null, null, null);
        Set<zzejg> hashSet = new HashSet();
        while (query.moveToNext()) {
            try {
                hashSet.add(zzejg.zzpz(query.getString(0)));
            } catch (Throwable th) {
                query.close();
            }
        }
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        if (this.zzmlr.zzbzl()) {
            this.zzmlr.zzb(String.format("Loaded %d tracked queries keys for tracked queries %s in %dms", new Object[]{Integer.valueOf(hashSet.size()), set.toString(), Long.valueOf(currentTimeMillis2)}), null, new Object[0]);
        }
        query.close();
        return hashSet;
    }
}
