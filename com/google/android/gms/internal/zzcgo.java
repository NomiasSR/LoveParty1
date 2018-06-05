package com.google.android.gms.internal;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.support.annotation.WorkerThread;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.measurement.AppMeasurement;
import com.google.firebase.analytics.FirebaseAnalytics.Param;
import java.io.File;
import java.io.IOException;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

final class zzcgo extends zzcjl {
    private static final String[] zziyp = new String[]{"last_bundled_timestamp", "ALTER TABLE events ADD COLUMN last_bundled_timestamp INTEGER;", "last_sampled_complex_event_id", "ALTER TABLE events ADD COLUMN last_sampled_complex_event_id INTEGER;", "last_sampling_rate", "ALTER TABLE events ADD COLUMN last_sampling_rate INTEGER;", "last_exempt_from_sampling", "ALTER TABLE events ADD COLUMN last_exempt_from_sampling INTEGER;"};
    private static final String[] zziyq = new String[]{Param.ORIGIN, "ALTER TABLE user_attributes ADD COLUMN origin TEXT;"};
    private static final String[] zziyr = new String[]{"app_version", "ALTER TABLE apps ADD COLUMN app_version TEXT;", "app_store", "ALTER TABLE apps ADD COLUMN app_store TEXT;", "gmp_version", "ALTER TABLE apps ADD COLUMN gmp_version INTEGER;", "dev_cert_hash", "ALTER TABLE apps ADD COLUMN dev_cert_hash INTEGER;", "measurement_enabled", "ALTER TABLE apps ADD COLUMN measurement_enabled INTEGER;", "last_bundle_start_timestamp", "ALTER TABLE apps ADD COLUMN last_bundle_start_timestamp INTEGER;", "day", "ALTER TABLE apps ADD COLUMN day INTEGER;", "daily_public_events_count", "ALTER TABLE apps ADD COLUMN daily_public_events_count INTEGER;", "daily_events_count", "ALTER TABLE apps ADD COLUMN daily_events_count INTEGER;", "daily_conversions_count", "ALTER TABLE apps ADD COLUMN daily_conversions_count INTEGER;", "remote_config", "ALTER TABLE apps ADD COLUMN remote_config BLOB;", "config_fetched_time", "ALTER TABLE apps ADD COLUMN config_fetched_time INTEGER;", "failed_config_fetch_time", "ALTER TABLE apps ADD COLUMN failed_config_fetch_time INTEGER;", "app_version_int", "ALTER TABLE apps ADD COLUMN app_version_int INTEGER;", "firebase_instance_id", "ALTER TABLE apps ADD COLUMN firebase_instance_id TEXT;", "daily_error_events_count", "ALTER TABLE apps ADD COLUMN daily_error_events_count INTEGER;", "daily_realtime_events_count", "ALTER TABLE apps ADD COLUMN daily_realtime_events_count INTEGER;", "health_monitor_sample", "ALTER TABLE apps ADD COLUMN health_monitor_sample TEXT;", "android_id", "ALTER TABLE apps ADD COLUMN android_id INTEGER;", "adid_reporting_enabled", "ALTER TABLE apps ADD COLUMN adid_reporting_enabled INTEGER;"};
    private static final String[] zziys = new String[]{"realtime", "ALTER TABLE raw_events ADD COLUMN realtime INTEGER;"};
    private static final String[] zziyt = new String[]{"has_realtime", "ALTER TABLE queue ADD COLUMN has_realtime INTEGER;"};
    private static final String[] zziyu = new String[]{"previous_install_count", "ALTER TABLE app2 ADD COLUMN previous_install_count INTEGER;"};
    private final zzcgr zziyv = new zzcgr(this, getContext(), "google_app_measurement.db");
    private final zzclk zziyw = new zzclk(zzws());

    zzcgo(zzcim com_google_android_gms_internal_zzcim) {
        super(com_google_android_gms_internal_zzcim);
    }

    @WorkerThread
    private final long zza(String str, String[] strArr, long j) {
        Object e;
        Throwable th;
        Cursor cursor = null;
        try {
            Cursor rawQuery = getWritableDatabase().rawQuery(str, strArr);
            try {
                if (rawQuery.moveToFirst()) {
                    j = rawQuery.getLong(0);
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                    return j;
                }
                if (rawQuery != null) {
                    rawQuery.close();
                }
                return j;
            } catch (SQLiteException e2) {
                e = e2;
                cursor = rawQuery;
                try {
                    zzawy().zzazd().zze("Database error", str, e);
                    throw e;
                } catch (Throwable th2) {
                    th = th2;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                cursor = rawQuery;
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        } catch (SQLiteException e3) {
            e = e3;
            zzawy().zzazd().zze("Database error", str, e);
            throw e;
        }
    }

    @WorkerThread
    private final Object zza(Cursor cursor, int i) {
        int type = cursor.getType(i);
        switch (type) {
            case 0:
                zzawy().zzazd().log("Loaded invalid null value from database");
                return null;
            case 1:
                return Long.valueOf(cursor.getLong(i));
            case 2:
                return Double.valueOf(cursor.getDouble(i));
            case 3:
                return cursor.getString(i);
            case 4:
                zzawy().zzazd().log("Loaded invalid blob type value, ignoring it");
                return null;
            default:
                zzawy().zzazd().zzj("Loaded invalid unknown value type, ignoring it", Integer.valueOf(type));
                return null;
        }
    }

    @WorkerThread
    private static void zza(ContentValues contentValues, String str, Object obj) {
        zzbq.zzgm(str);
        zzbq.checkNotNull(obj);
        if (obj instanceof String) {
            contentValues.put(str, (String) obj);
        } else if (obj instanceof Long) {
            contentValues.put(str, (Long) obj);
        } else if (obj instanceof Double) {
            contentValues.put(str, (Double) obj);
        } else {
            throw new IllegalArgumentException("Invalid value type");
        }
    }

    static void zza(zzchm com_google_android_gms_internal_zzchm, SQLiteDatabase sQLiteDatabase) {
        if (com_google_android_gms_internal_zzchm == null) {
            throw new IllegalArgumentException("Monitor must not be null");
        }
        File file = new File(sQLiteDatabase.getPath());
        if (!file.setReadable(false, false)) {
            com_google_android_gms_internal_zzchm.zzazf().log("Failed to turn off database read permission");
        }
        if (!file.setWritable(false, false)) {
            com_google_android_gms_internal_zzchm.zzazf().log("Failed to turn off database write permission");
        }
        if (!file.setReadable(true, true)) {
            com_google_android_gms_internal_zzchm.zzazf().log("Failed to turn on database read permission for owner");
        }
        if (!file.setWritable(true, true)) {
            com_google_android_gms_internal_zzchm.zzazf().log("Failed to turn on database write permission for owner");
        }
    }

    @WorkerThread
    static void zza(zzchm com_google_android_gms_internal_zzchm, SQLiteDatabase sQLiteDatabase, String str, String str2, String str3, String[] strArr) throws SQLiteException {
        if (com_google_android_gms_internal_zzchm == null) {
            throw new IllegalArgumentException("Monitor must not be null");
        }
        if (!zza(com_google_android_gms_internal_zzchm, sQLiteDatabase, str)) {
            sQLiteDatabase.execSQL(str2);
        }
        try {
            zza(com_google_android_gms_internal_zzchm, sQLiteDatabase, str, str3, strArr);
        } catch (SQLiteException e) {
            com_google_android_gms_internal_zzchm.zzazd().zzj("Failed to verify columns on table that was just created", str);
            throw e;
        }
    }

    @WorkerThread
    private static void zza(zzchm com_google_android_gms_internal_zzchm, SQLiteDatabase sQLiteDatabase, String str, String str2, String[] strArr) throws SQLiteException {
        if (com_google_android_gms_internal_zzchm == null) {
            throw new IllegalArgumentException("Monitor must not be null");
        }
        Iterable zzb = zzb(sQLiteDatabase, str);
        String[] split = str2.split(",");
        int length = split.length;
        int i = 0;
        int i2 = 0;
        while (i2 < length) {
            String str3 = split[i2];
            if (zzb.remove(str3)) {
                i2++;
            } else {
                StringBuilder stringBuilder = new StringBuilder((35 + String.valueOf(str).length()) + String.valueOf(str3).length());
                stringBuilder.append("Table ");
                stringBuilder.append(str);
                stringBuilder.append(" is missing required column: ");
                stringBuilder.append(str3);
                throw new SQLiteException(stringBuilder.toString());
            }
        }
        if (strArr != null) {
            while (i < strArr.length) {
                if (!zzb.remove(strArr[i])) {
                    sQLiteDatabase.execSQL(strArr[i + 1]);
                }
                i += 2;
            }
        }
        if (!zzb.isEmpty()) {
            com_google_android_gms_internal_zzchm.zzazf().zze("Table has extra columns. table, columns", str, TextUtils.join(", ", zzb));
        }
    }

    @WorkerThread
    private static boolean zza(zzchm com_google_android_gms_internal_zzchm, SQLiteDatabase sQLiteDatabase, String str) {
        Object obj;
        Throwable th;
        if (com_google_android_gms_internal_zzchm == null) {
            throw new IllegalArgumentException("Monitor must not be null");
        }
        Cursor cursor = null;
        try {
            SQLiteDatabase sQLiteDatabase2 = sQLiteDatabase;
            Cursor query = sQLiteDatabase2.query("SQLITE_MASTER", new String[]{"name"}, "name=?", new String[]{str}, null, null, null);
            try {
                boolean moveToFirst = query.moveToFirst();
                if (query != null) {
                    query.close();
                }
                return moveToFirst;
            } catch (SQLiteException e) {
                SQLiteException sQLiteException = e;
                cursor = query;
                obj = sQLiteException;
                try {
                    com_google_android_gms_internal_zzchm.zzazf().zze("Error querying for table", str, obj);
                    if (cursor != null) {
                        cursor.close();
                    }
                    return false;
                } catch (Throwable th2) {
                    th = th2;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                cursor = query;
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        } catch (SQLiteException e2) {
            obj = e2;
            com_google_android_gms_internal_zzchm.zzazf().zze("Error querying for table", str, obj);
            if (cursor != null) {
                cursor.close();
            }
            return false;
        }
    }

    @WorkerThread
    private final boolean zza(String str, int i, zzcls com_google_android_gms_internal_zzcls) {
        zzxf();
        zzve();
        zzbq.zzgm(str);
        zzbq.checkNotNull(com_google_android_gms_internal_zzcls);
        if (TextUtils.isEmpty(com_google_android_gms_internal_zzcls.zzjjx)) {
            zzawy().zzazf().zzd("Event filter had no event name. Audience definition ignored. appId, audienceId, filterId", zzchm.zzjk(str), Integer.valueOf(i), String.valueOf(com_google_android_gms_internal_zzcls.zzjjw));
            return false;
        }
        try {
            byte[] bArr = new byte[com_google_android_gms_internal_zzcls.zzho()];
            zzfjk zzo = zzfjk.zzo(bArr, 0, bArr.length);
            com_google_android_gms_internal_zzcls.zza(zzo);
            zzo.zzcwt();
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", str);
            contentValues.put("audience_id", Integer.valueOf(i));
            contentValues.put("filter_id", com_google_android_gms_internal_zzcls.zzjjw);
            contentValues.put("event_name", com_google_android_gms_internal_zzcls.zzjjx);
            contentValues.put("data", bArr);
            try {
                if (getWritableDatabase().insertWithOnConflict("event_filters", null, contentValues, 5) == -1) {
                    zzawy().zzazd().zzj("Failed to insert event filter (got -1). appId", zzchm.zzjk(str));
                }
                return true;
            } catch (SQLiteException e) {
                zzawy().zzazd().zze("Error storing event filter. appId", zzchm.zzjk(str), e);
                return false;
            }
        } catch (IOException e2) {
            zzawy().zzazd().zze("Configuration loss. Failed to serialize event filter. appId", zzchm.zzjk(str), e2);
            return false;
        }
    }

    @WorkerThread
    private final boolean zza(String str, int i, zzclv com_google_android_gms_internal_zzclv) {
        zzxf();
        zzve();
        zzbq.zzgm(str);
        zzbq.checkNotNull(com_google_android_gms_internal_zzclv);
        if (TextUtils.isEmpty(com_google_android_gms_internal_zzclv.zzjkm)) {
            zzawy().zzazf().zzd("Property filter had no property name. Audience definition ignored. appId, audienceId, filterId", zzchm.zzjk(str), Integer.valueOf(i), String.valueOf(com_google_android_gms_internal_zzclv.zzjjw));
            return false;
        }
        try {
            byte[] bArr = new byte[com_google_android_gms_internal_zzclv.zzho()];
            zzfjk zzo = zzfjk.zzo(bArr, 0, bArr.length);
            com_google_android_gms_internal_zzclv.zza(zzo);
            zzo.zzcwt();
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", str);
            contentValues.put("audience_id", Integer.valueOf(i));
            contentValues.put("filter_id", com_google_android_gms_internal_zzclv.zzjjw);
            contentValues.put("property_name", com_google_android_gms_internal_zzclv.zzjkm);
            contentValues.put("data", bArr);
            try {
                if (getWritableDatabase().insertWithOnConflict("property_filters", null, contentValues, 5) != -1) {
                    return true;
                }
                zzawy().zzazd().zzj("Failed to insert property filter (got -1). appId", zzchm.zzjk(str));
                return false;
            } catch (SQLiteException e) {
                zzawy().zzazd().zze("Error storing property filter. appId", zzchm.zzjk(str), e);
                return false;
            }
        } catch (IOException e2) {
            zzawy().zzazd().zze("Configuration loss. Failed to serialize property filter. appId", zzchm.zzjk(str), e2);
            return false;
        }
    }

    private final boolean zzayn() {
        return getContext().getDatabasePath("google_app_measurement.db").exists();
    }

    @WorkerThread
    private final long zzb(String str, String[] strArr) {
        Object e;
        Throwable th;
        Cursor cursor = null;
        try {
            Cursor rawQuery = getWritableDatabase().rawQuery(str, strArr);
            try {
                if (rawQuery.moveToFirst()) {
                    long j = rawQuery.getLong(0);
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                    return j;
                }
                throw new SQLiteException("Database returned empty set");
            } catch (SQLiteException e2) {
                e = e2;
                cursor = rawQuery;
                try {
                    zzawy().zzazd().zze("Database error", str, e);
                    throw e;
                } catch (Throwable th2) {
                    th = th2;
                    rawQuery = cursor;
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                if (rawQuery != null) {
                    rawQuery.close();
                }
                throw th;
            }
        } catch (SQLiteException e3) {
            e = e3;
            zzawy().zzazd().zze("Database error", str, e);
            throw e;
        }
    }

    @WorkerThread
    private static Set<String> zzb(SQLiteDatabase sQLiteDatabase, String str) {
        Object hashSet = new HashSet();
        StringBuilder stringBuilder = new StringBuilder(22 + String.valueOf(str).length());
        stringBuilder.append("SELECT * FROM ");
        stringBuilder.append(str);
        stringBuilder.append(" LIMIT 0");
        Cursor rawQuery = sQLiteDatabase.rawQuery(stringBuilder.toString(), null);
        try {
            Collections.addAll(hashSet, rawQuery.getColumnNames());
            return hashSet;
        } finally {
            rawQuery.close();
        }
    }

    private final boolean zze(String str, List<Integer> list) {
        zzbq.zzgm(str);
        zzxf();
        zzve();
        SQLiteDatabase writableDatabase = getWritableDatabase();
        try {
            if (zzb("select count(1) from audience_filter_values where app_id=?", new String[]{str}) <= ((long) Math.max(0, Math.min(2000, zzaxa().zzb(str, zzchc.zzjbi))))) {
                return false;
            }
            Iterable arrayList = new ArrayList();
            for (int i = 0; i < list.size(); i++) {
                Integer num = (Integer) list.get(i);
                if (num == null || !(num instanceof Integer)) {
                    return false;
                }
                arrayList.add(Integer.toString(num.intValue()));
            }
            String join = TextUtils.join(",", arrayList);
            StringBuilder stringBuilder = new StringBuilder(String.valueOf(join).length() + 2);
            stringBuilder.append("(");
            stringBuilder.append(join);
            stringBuilder.append(")");
            join = stringBuilder.toString();
            StringBuilder stringBuilder2 = new StringBuilder(140 + String.valueOf(join).length());
            stringBuilder2.append("audience_id in (select audience_id from audience_filter_values where app_id=? and audience_id not in ");
            stringBuilder2.append(join);
            stringBuilder2.append(" order by rowid desc limit -1 offset ?)");
            return writableDatabase.delete("audience_filter_values", stringBuilder2.toString(), new String[]{str, Integer.toString(r2)}) > 0;
        } catch (SQLiteException e) {
            zzawy().zzazd().zze("Database error querying filters. appId", zzchm.zzjk(str), e);
            return false;
        }
    }

    @WorkerThread
    public final void beginTransaction() {
        zzxf();
        getWritableDatabase().beginTransaction();
    }

    @WorkerThread
    public final void endTransaction() {
        zzxf();
        getWritableDatabase().endTransaction();
    }

    @WorkerThread
    final SQLiteDatabase getWritableDatabase() {
        zzve();
        try {
            return this.zziyv.getWritableDatabase();
        } catch (SQLiteException e) {
            zzawy().zzazf().zzj("Error opening database", e);
            throw e;
        }
    }

    @WorkerThread
    public final void setTransactionSuccessful() {
        zzxf();
        getWritableDatabase().setTransactionSuccessful();
    }

    public final long zza(zzcme com_google_android_gms_internal_zzcme) throws IOException {
        zzve();
        zzxf();
        zzbq.checkNotNull(com_google_android_gms_internal_zzcme);
        zzbq.zzgm(com_google_android_gms_internal_zzcme.zzcn);
        try {
            long j;
            Object obj = new byte[com_google_android_gms_internal_zzcme.zzho()];
            zzfjk zzo = zzfjk.zzo(obj, 0, obj.length);
            com_google_android_gms_internal_zzcme.zza(zzo);
            zzo.zzcwt();
            zzcjk zzawu = zzawu();
            zzbq.checkNotNull(obj);
            zzawu.zzve();
            MessageDigest zzek = zzclq.zzek("MD5");
            if (zzek == null) {
                zzawu.zzawy().zzazd().log("Failed to get MD5");
                j = 0;
            } else {
                j = zzclq.zzs(zzek.digest(obj));
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", com_google_android_gms_internal_zzcme.zzcn);
            contentValues.put("metadata_fingerprint", Long.valueOf(j));
            contentValues.put("metadata", obj);
            try {
                getWritableDatabase().insertWithOnConflict("raw_events_metadata", null, contentValues, 4);
                return j;
            } catch (SQLiteException e) {
                zzawy().zzazd().zze("Error storing raw event metadata. appId", zzchm.zzjk(com_google_android_gms_internal_zzcme.zzcn), e);
                throw e;
            }
        } catch (IOException e2) {
            zzawy().zzazd().zze("Data loss. Failed to serialize event metadata. appId", zzchm.zzjk(com_google_android_gms_internal_zzcme.zzcn), e2);
            throw e2;
        }
    }

    @WorkerThread
    public final zzcgp zza(long j, String str, boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        Object obj;
        Throwable th;
        zzbq.zzgm(str);
        zzve();
        zzxf();
        String[] strArr = new String[]{str};
        zzcgp com_google_android_gms_internal_zzcgp = new zzcgp();
        Cursor cursor = null;
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            SQLiteDatabase sQLiteDatabase = writableDatabase;
            Cursor query = sQLiteDatabase.query("apps", new String[]{"day", "daily_events_count", "daily_public_events_count", "daily_conversions_count", "daily_error_events_count", "daily_realtime_events_count"}, "app_id=?", new String[]{str}, null, null, null);
            try {
                if (query.moveToFirst()) {
                    if (query.getLong(0) == j) {
                        com_google_android_gms_internal_zzcgp.zziyy = query.getLong(1);
                        com_google_android_gms_internal_zzcgp.zziyx = query.getLong(2);
                        com_google_android_gms_internal_zzcgp.zziyz = query.getLong(3);
                        com_google_android_gms_internal_zzcgp.zziza = query.getLong(4);
                        com_google_android_gms_internal_zzcgp.zzizb = query.getLong(5);
                    }
                    if (z) {
                        com_google_android_gms_internal_zzcgp.zziyy++;
                    }
                    if (z2) {
                        com_google_android_gms_internal_zzcgp.zziyx++;
                    }
                    if (z3) {
                        com_google_android_gms_internal_zzcgp.zziyz++;
                    }
                    if (z4) {
                        com_google_android_gms_internal_zzcgp.zziza++;
                    }
                    if (z5) {
                        com_google_android_gms_internal_zzcgp.zzizb++;
                    }
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("day", Long.valueOf(j));
                    contentValues.put("daily_public_events_count", Long.valueOf(com_google_android_gms_internal_zzcgp.zziyx));
                    contentValues.put("daily_events_count", Long.valueOf(com_google_android_gms_internal_zzcgp.zziyy));
                    contentValues.put("daily_conversions_count", Long.valueOf(com_google_android_gms_internal_zzcgp.zziyz));
                    contentValues.put("daily_error_events_count", Long.valueOf(com_google_android_gms_internal_zzcgp.zziza));
                    contentValues.put("daily_realtime_events_count", Long.valueOf(com_google_android_gms_internal_zzcgp.zzizb));
                    writableDatabase.update("apps", contentValues, "app_id=?", strArr);
                    if (query != null) {
                        query.close();
                    }
                    return com_google_android_gms_internal_zzcgp;
                }
                zzawy().zzazf().zzj("Not updating daily counts, app is not known. appId", zzchm.zzjk(str));
                if (query != null) {
                    query.close();
                }
                return com_google_android_gms_internal_zzcgp;
            } catch (SQLiteException e) {
                obj = e;
                cursor = query;
                try {
                    zzawy().zzazd().zze("Error updating daily counts. appId", zzchm.zzjk(str), obj);
                    if (cursor != null) {
                        cursor.close();
                    }
                    return com_google_android_gms_internal_zzcgp;
                } catch (Throwable th2) {
                    th = th2;
                    query = cursor;
                    if (query != null) {
                        query.close();
                    }
                    throw th;
                }
            } catch (Throwable th22) {
                th = th22;
                if (query != null) {
                    query.close();
                }
                throw th;
            }
        } catch (SQLiteException e2) {
            obj = e2;
            zzawy().zzazd().zze("Error updating daily counts. appId", zzchm.zzjk(str), obj);
            if (cursor != null) {
                cursor.close();
            }
            return com_google_android_gms_internal_zzcgp;
        }
    }

    @WorkerThread
    public final void zza(zzcgh com_google_android_gms_internal_zzcgh) {
        zzbq.checkNotNull(com_google_android_gms_internal_zzcgh);
        zzve();
        zzxf();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", com_google_android_gms_internal_zzcgh.getAppId());
        contentValues.put("app_instance_id", com_google_android_gms_internal_zzcgh.getAppInstanceId());
        contentValues.put("gmp_app_id", com_google_android_gms_internal_zzcgh.getGmpAppId());
        contentValues.put("resettable_device_id_hash", com_google_android_gms_internal_zzcgh.zzaxc());
        contentValues.put("last_bundle_index", Long.valueOf(com_google_android_gms_internal_zzcgh.zzaxl()));
        contentValues.put("last_bundle_start_timestamp", Long.valueOf(com_google_android_gms_internal_zzcgh.zzaxe()));
        contentValues.put("last_bundle_end_timestamp", Long.valueOf(com_google_android_gms_internal_zzcgh.zzaxf()));
        contentValues.put("app_version", com_google_android_gms_internal_zzcgh.zzvj());
        contentValues.put("app_store", com_google_android_gms_internal_zzcgh.zzaxh());
        contentValues.put("gmp_version", Long.valueOf(com_google_android_gms_internal_zzcgh.zzaxi()));
        contentValues.put("dev_cert_hash", Long.valueOf(com_google_android_gms_internal_zzcgh.zzaxj()));
        contentValues.put("measurement_enabled", Boolean.valueOf(com_google_android_gms_internal_zzcgh.zzaxk()));
        contentValues.put("day", Long.valueOf(com_google_android_gms_internal_zzcgh.zzaxp()));
        contentValues.put("daily_public_events_count", Long.valueOf(com_google_android_gms_internal_zzcgh.zzaxq()));
        contentValues.put("daily_events_count", Long.valueOf(com_google_android_gms_internal_zzcgh.zzaxr()));
        contentValues.put("daily_conversions_count", Long.valueOf(com_google_android_gms_internal_zzcgh.zzaxs()));
        contentValues.put("config_fetched_time", Long.valueOf(com_google_android_gms_internal_zzcgh.zzaxm()));
        contentValues.put("failed_config_fetch_time", Long.valueOf(com_google_android_gms_internal_zzcgh.zzaxn()));
        contentValues.put("app_version_int", Long.valueOf(com_google_android_gms_internal_zzcgh.zzaxg()));
        contentValues.put("firebase_instance_id", com_google_android_gms_internal_zzcgh.zzaxd());
        contentValues.put("daily_error_events_count", Long.valueOf(com_google_android_gms_internal_zzcgh.zzaxu()));
        contentValues.put("daily_realtime_events_count", Long.valueOf(com_google_android_gms_internal_zzcgh.zzaxt()));
        contentValues.put("health_monitor_sample", com_google_android_gms_internal_zzcgh.zzaxv());
        contentValues.put("android_id", Long.valueOf(com_google_android_gms_internal_zzcgh.zzaxx()));
        contentValues.put("adid_reporting_enabled", Boolean.valueOf(com_google_android_gms_internal_zzcgh.zzaxy()));
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            if (((long) writableDatabase.update("apps", contentValues, "app_id = ?", new String[]{com_google_android_gms_internal_zzcgh.getAppId()})) == 0 && writableDatabase.insertWithOnConflict("apps", null, contentValues, 5) == -1) {
                zzawy().zzazd().zzj("Failed to insert/update app (got -1). appId", zzchm.zzjk(com_google_android_gms_internal_zzcgh.getAppId()));
            }
        } catch (SQLiteException e) {
            zzawy().zzazd().zze("Error storing app. appId", zzchm.zzjk(com_google_android_gms_internal_zzcgh.getAppId()), e);
        }
    }

    @WorkerThread
    public final void zza(zzcgw com_google_android_gms_internal_zzcgw) {
        zzbq.checkNotNull(com_google_android_gms_internal_zzcgw);
        zzve();
        zzxf();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", com_google_android_gms_internal_zzcgw.mAppId);
        contentValues.put("name", com_google_android_gms_internal_zzcgw.mName);
        contentValues.put("lifetime_count", Long.valueOf(com_google_android_gms_internal_zzcgw.zzizk));
        contentValues.put("current_bundle_count", Long.valueOf(com_google_android_gms_internal_zzcgw.zzizl));
        contentValues.put("last_fire_timestamp", Long.valueOf(com_google_android_gms_internal_zzcgw.zzizm));
        contentValues.put("last_bundled_timestamp", Long.valueOf(com_google_android_gms_internal_zzcgw.zzizn));
        contentValues.put("last_sampled_complex_event_id", com_google_android_gms_internal_zzcgw.zzizo);
        contentValues.put("last_sampling_rate", com_google_android_gms_internal_zzcgw.zzizp);
        Long valueOf = (com_google_android_gms_internal_zzcgw.zzizq == null || !com_google_android_gms_internal_zzcgw.zzizq.booleanValue()) ? null : Long.valueOf(1);
        contentValues.put("last_exempt_from_sampling", valueOf);
        try {
            if (getWritableDatabase().insertWithOnConflict("events", null, contentValues, 5) == -1) {
                zzawy().zzazd().zzj("Failed to insert/update event aggregates (got -1). appId", zzchm.zzjk(com_google_android_gms_internal_zzcgw.mAppId));
            }
        } catch (SQLiteException e) {
            zzawy().zzazd().zze("Error storing event aggregates. appId", zzchm.zzjk(com_google_android_gms_internal_zzcgw.mAppId), e);
        }
    }

    @WorkerThread
    final void zza(String str, zzclr[] com_google_android_gms_internal_zzclrArr) {
        zzxf();
        zzve();
        zzbq.zzgm(str);
        zzbq.checkNotNull(com_google_android_gms_internal_zzclrArr);
        SQLiteDatabase writableDatabase = getWritableDatabase();
        writableDatabase.beginTransaction();
        try {
            zzxf();
            zzve();
            zzbq.zzgm(str);
            SQLiteDatabase writableDatabase2 = getWritableDatabase();
            String[] strArr = new String[1];
            int i = 0;
            strArr[0] = str;
            writableDatabase2.delete("property_filters", "app_id=?", strArr);
            writableDatabase2.delete("event_filters", "app_id=?", new String[]{str});
            for (zzclr com_google_android_gms_internal_zzclr : com_google_android_gms_internal_zzclrArr) {
                zzxf();
                zzve();
                zzbq.zzgm(str);
                zzbq.checkNotNull(com_google_android_gms_internal_zzclr);
                zzbq.checkNotNull(com_google_android_gms_internal_zzclr.zzjju);
                zzbq.checkNotNull(com_google_android_gms_internal_zzclr.zzjjt);
                if (com_google_android_gms_internal_zzclr.zzjjs == null) {
                    zzawy().zzazf().zzj("Audience with no ID. appId", zzchm.zzjk(str));
                } else {
                    zzcho zzazf;
                    String str2;
                    Object zzjk;
                    Object obj;
                    int i2;
                    int intValue = com_google_android_gms_internal_zzclr.zzjjs.intValue();
                    for (zzcls com_google_android_gms_internal_zzcls : com_google_android_gms_internal_zzclr.zzjju) {
                        if (com_google_android_gms_internal_zzcls.zzjjw == null) {
                            zzazf = zzawy().zzazf();
                            str2 = "Event filter with no ID. Audience definition ignored. appId, audienceId";
                            zzjk = zzchm.zzjk(str);
                            obj = com_google_android_gms_internal_zzclr.zzjjs;
                            break;
                        }
                    }
                    for (zzclv com_google_android_gms_internal_zzclv : com_google_android_gms_internal_zzclr.zzjjt) {
                        if (com_google_android_gms_internal_zzclv.zzjjw == null) {
                            zzazf = zzawy().zzazf();
                            str2 = "Property filter with no ID. Audience definition ignored. appId, audienceId";
                            zzjk = zzchm.zzjk(str);
                            obj = com_google_android_gms_internal_zzclr.zzjjs;
                            zzazf.zze(str2, zzjk, obj);
                            break;
                        }
                    }
                    for (zzcls com_google_android_gms_internal_zzcls2 : com_google_android_gms_internal_zzclr.zzjju) {
                        if (!zza(str, intValue, com_google_android_gms_internal_zzcls2)) {
                            i2 = 0;
                            break;
                        }
                    }
                    i2 = 1;
                    if (i2 != 0) {
                        for (zzclv com_google_android_gms_internal_zzclv2 : com_google_android_gms_internal_zzclr.zzjjt) {
                            if (!zza(str, intValue, com_google_android_gms_internal_zzclv2)) {
                                i2 = 0;
                                break;
                            }
                        }
                    }
                    if (i2 == 0) {
                        zzxf();
                        zzve();
                        zzbq.zzgm(str);
                        SQLiteDatabase writableDatabase3 = getWritableDatabase();
                        writableDatabase3.delete("property_filters", "app_id=? and audience_id=?", new String[]{str, String.valueOf(intValue)});
                        writableDatabase3.delete("event_filters", "app_id=? and audience_id=?", new String[]{str, String.valueOf(intValue)});
                    }
                }
            }
            List arrayList = new ArrayList();
            int length = com_google_android_gms_internal_zzclrArr.length;
            while (i < length) {
                arrayList.add(com_google_android_gms_internal_zzclrArr[i].zzjjs);
                i++;
            }
            zze(str, arrayList);
            writableDatabase.setTransactionSuccessful();
        } finally {
            writableDatabase.endTransaction();
        }
    }

    @WorkerThread
    public final boolean zza(zzcgl com_google_android_gms_internal_zzcgl) {
        zzbq.checkNotNull(com_google_android_gms_internal_zzcgl);
        zzve();
        zzxf();
        if (zzag(com_google_android_gms_internal_zzcgl.packageName, com_google_android_gms_internal_zzcgl.zziyg.name) == null) {
            if (zzb("SELECT COUNT(1) FROM conditional_properties WHERE app_id=?", new String[]{com_google_android_gms_internal_zzcgl.packageName}) >= 1000) {
                return false;
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", com_google_android_gms_internal_zzcgl.packageName);
        contentValues.put(Param.ORIGIN, com_google_android_gms_internal_zzcgl.zziyf);
        contentValues.put("name", com_google_android_gms_internal_zzcgl.zziyg.name);
        zza(contentValues, Param.VALUE, com_google_android_gms_internal_zzcgl.zziyg.getValue());
        contentValues.put("active", Boolean.valueOf(com_google_android_gms_internal_zzcgl.zziyi));
        contentValues.put("trigger_event_name", com_google_android_gms_internal_zzcgl.zziyj);
        contentValues.put("trigger_timeout", Long.valueOf(com_google_android_gms_internal_zzcgl.zziyl));
        zzawu();
        contentValues.put("timed_out_event", zzclq.zza(com_google_android_gms_internal_zzcgl.zziyk));
        contentValues.put("creation_timestamp", Long.valueOf(com_google_android_gms_internal_zzcgl.zziyh));
        zzawu();
        contentValues.put("triggered_event", zzclq.zza(com_google_android_gms_internal_zzcgl.zziym));
        contentValues.put("triggered_timestamp", Long.valueOf(com_google_android_gms_internal_zzcgl.zziyg.zzjji));
        contentValues.put("time_to_live", Long.valueOf(com_google_android_gms_internal_zzcgl.zziyn));
        zzawu();
        contentValues.put("expired_event", zzclq.zza(com_google_android_gms_internal_zzcgl.zziyo));
        try {
            if (getWritableDatabase().insertWithOnConflict("conditional_properties", null, contentValues, 5) == -1) {
                zzawy().zzazd().zzj("Failed to insert/update conditional user property (got -1)", zzchm.zzjk(com_google_android_gms_internal_zzcgl.packageName));
                return true;
            }
        } catch (SQLiteException e) {
            zzawy().zzazd().zze("Error storing conditional user property", zzchm.zzjk(com_google_android_gms_internal_zzcgl.packageName), e);
        }
        return true;
    }

    public final boolean zza(zzcgv com_google_android_gms_internal_zzcgv, long j, boolean z) {
        Object e;
        zzcho zzazd;
        String str;
        zzve();
        zzxf();
        zzbq.checkNotNull(com_google_android_gms_internal_zzcgv);
        zzbq.zzgm(com_google_android_gms_internal_zzcgv.mAppId);
        zzfjs com_google_android_gms_internal_zzcmb = new zzcmb();
        com_google_android_gms_internal_zzcmb.zzjlj = Long.valueOf(com_google_android_gms_internal_zzcgv.zzizi);
        com_google_android_gms_internal_zzcmb.zzjlh = new zzcmc[com_google_android_gms_internal_zzcgv.zzizj.size()];
        Iterator it = com_google_android_gms_internal_zzcgv.zzizj.iterator();
        int i = 0;
        while (it.hasNext()) {
            String str2 = (String) it.next();
            zzcmc com_google_android_gms_internal_zzcmc = new zzcmc();
            int i2 = i + 1;
            com_google_android_gms_internal_zzcmb.zzjlh[i] = com_google_android_gms_internal_zzcmc;
            com_google_android_gms_internal_zzcmc.name = str2;
            zzawu().zza(com_google_android_gms_internal_zzcmc, com_google_android_gms_internal_zzcgv.zzizj.get(str2));
            i = i2;
        }
        try {
            byte[] bArr = new byte[com_google_android_gms_internal_zzcmb.zzho()];
            zzfjk zzo = zzfjk.zzo(bArr, 0, bArr.length);
            com_google_android_gms_internal_zzcmb.zza(zzo);
            zzo.zzcwt();
            zzawy().zzazj().zze("Saving event, name, data size", zzawt().zzjh(com_google_android_gms_internal_zzcgv.mName), Integer.valueOf(bArr.length));
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", com_google_android_gms_internal_zzcgv.mAppId);
            contentValues.put("name", com_google_android_gms_internal_zzcgv.mName);
            contentValues.put(AppMeasurement.Param.TIMESTAMP, Long.valueOf(com_google_android_gms_internal_zzcgv.zzfij));
            contentValues.put("metadata_fingerprint", Long.valueOf(j));
            contentValues.put("data", bArr);
            contentValues.put("realtime", Integer.valueOf(z));
            try {
                if (getWritableDatabase().insert("raw_events", null, contentValues) != -1) {
                    return true;
                }
                zzawy().zzazd().zzj("Failed to insert raw event (got -1). appId", zzchm.zzjk(com_google_android_gms_internal_zzcgv.mAppId));
                return false;
            } catch (SQLiteException e2) {
                e = e2;
                zzazd = zzawy().zzazd();
                str = "Error storing raw event. appId";
                zzazd.zze(str, zzchm.zzjk(com_google_android_gms_internal_zzcgv.mAppId), e);
                return false;
            }
        } catch (IOException e3) {
            e = e3;
            zzazd = zzawy().zzazd();
            str = "Data loss. Failed to serialize event params/data. appId";
            zzazd.zze(str, zzchm.zzjk(com_google_android_gms_internal_zzcgv.mAppId), e);
            return false;
        }
    }

    @WorkerThread
    public final boolean zza(zzclp com_google_android_gms_internal_zzclp) {
        zzbq.checkNotNull(com_google_android_gms_internal_zzclp);
        zzve();
        zzxf();
        if (zzag(com_google_android_gms_internal_zzclp.mAppId, com_google_android_gms_internal_zzclp.mName) == null) {
            if (zzclq.zzjz(com_google_android_gms_internal_zzclp.mName)) {
                if (zzb("select count(1) from user_attributes where app_id=? and name not like '!_%' escape '!'", new String[]{com_google_android_gms_internal_zzclp.mAppId}) >= 25) {
                    return false;
                }
            }
            if (zzb("select count(1) from user_attributes where app_id=? and origin=? AND name like '!_%' escape '!'", new String[]{com_google_android_gms_internal_zzclp.mAppId, com_google_android_gms_internal_zzclp.mOrigin}) >= 25) {
                return false;
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", com_google_android_gms_internal_zzclp.mAppId);
        contentValues.put(Param.ORIGIN, com_google_android_gms_internal_zzclp.mOrigin);
        contentValues.put("name", com_google_android_gms_internal_zzclp.mName);
        contentValues.put("set_timestamp", Long.valueOf(com_google_android_gms_internal_zzclp.zzjjm));
        zza(contentValues, Param.VALUE, com_google_android_gms_internal_zzclp.mValue);
        try {
            if (getWritableDatabase().insertWithOnConflict("user_attributes", null, contentValues, 5) == -1) {
                zzawy().zzazd().zzj("Failed to insert/update user property (got -1). appId", zzchm.zzjk(com_google_android_gms_internal_zzclp.mAppId));
                return true;
            }
        } catch (SQLiteException e) {
            zzawy().zzazd().zze("Error storing user property. appId", zzchm.zzjk(com_google_android_gms_internal_zzclp.mAppId), e);
        }
        return true;
    }

    @WorkerThread
    public final boolean zza(zzcme com_google_android_gms_internal_zzcme, boolean z) {
        Object e;
        zzcho zzazd;
        String str;
        zzve();
        zzxf();
        zzbq.checkNotNull(com_google_android_gms_internal_zzcme);
        zzbq.zzgm(com_google_android_gms_internal_zzcme.zzcn);
        zzbq.checkNotNull(com_google_android_gms_internal_zzcme.zzjlt);
        zzayh();
        long currentTimeMillis = zzws().currentTimeMillis();
        if (com_google_android_gms_internal_zzcme.zzjlt.longValue() < currentTimeMillis - zzcgn.zzayb() || com_google_android_gms_internal_zzcme.zzjlt.longValue() > zzcgn.zzayb() + currentTimeMillis) {
            zzawy().zzazf().zzd("Storing bundle outside of the max uploading time span. appId, now, timestamp", zzchm.zzjk(com_google_android_gms_internal_zzcme.zzcn), Long.valueOf(currentTimeMillis), com_google_android_gms_internal_zzcme.zzjlt);
        }
        try {
            byte[] bArr = new byte[com_google_android_gms_internal_zzcme.zzho()];
            zzfjk zzo = zzfjk.zzo(bArr, 0, bArr.length);
            com_google_android_gms_internal_zzcme.zza(zzo);
            zzo.zzcwt();
            bArr = zzawu().zzq(bArr);
            zzawy().zzazj().zzj("Saving bundle, size", Integer.valueOf(bArr.length));
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", com_google_android_gms_internal_zzcme.zzcn);
            contentValues.put("bundle_end_timestamp", com_google_android_gms_internal_zzcme.zzjlt);
            contentValues.put("data", bArr);
            contentValues.put("has_realtime", Integer.valueOf(z));
            try {
                if (getWritableDatabase().insert("queue", null, contentValues) != -1) {
                    return true;
                }
                zzawy().zzazd().zzj("Failed to insert bundle (got -1). appId", zzchm.zzjk(com_google_android_gms_internal_zzcme.zzcn));
                return false;
            } catch (SQLiteException e2) {
                e = e2;
                zzazd = zzawy().zzazd();
                str = "Error storing bundle. appId";
                zzazd.zze(str, zzchm.zzjk(com_google_android_gms_internal_zzcme.zzcn), e);
                return false;
            }
        } catch (IOException e3) {
            e = e3;
            zzazd = zzawy().zzazd();
            str = "Data loss. Failed to serialize bundle. appId";
            zzazd.zze(str, zzchm.zzjk(com_google_android_gms_internal_zzcme.zzcn), e);
            return false;
        }
    }

    @WorkerThread
    public final zzcgw zzae(String str, String str2) {
        Object obj;
        SQLiteException e;
        Throwable th;
        Throwable th2;
        String str3 = str2;
        zzbq.zzgm(str);
        zzbq.zzgm(str2);
        zzve();
        zzxf();
        Cursor cursor;
        try {
            String[] strArr = new String[2];
            strArr[0] = str;
            boolean z = true;
            strArr[1] = str3;
            Cursor query = getWritableDatabase().query("events", new String[]{"lifetime_count", "current_bundle_count", "last_fire_timestamp", "last_bundled_timestamp", "last_sampled_complex_event_id", "last_sampling_rate", "last_exempt_from_sampling"}, "app_id=? and name=?", strArr, null, null, null);
            try {
                if (query.moveToFirst()) {
                    Boolean bool;
                    long j = query.getLong(0);
                    long j2 = query.getLong(1);
                    long j3 = query.getLong(2);
                    long j4 = query.isNull(3) ? 0 : query.getLong(3);
                    zzcgw valueOf = query.isNull(4) ? null : Long.valueOf(query.getLong(4));
                    zzcgw valueOf2 = query.isNull(5) ? null : Long.valueOf(query.getLong(5));
                    if (query.isNull(6)) {
                        bool = null;
                    } else {
                        try {
                            if (query.getLong(6) != 1) {
                                z = false;
                            }
                            bool = Boolean.valueOf(z);
                        } catch (SQLiteException e2) {
                            obj = e2;
                            cursor = query;
                            try {
                                zzawy().zzazd().zzd("Error querying events. appId", zzchm.zzjk(str), zzawt().zzjh(str2), obj);
                                if (cursor != null) {
                                    cursor.close();
                                }
                                return null;
                            } catch (Throwable th3) {
                                th = th3;
                                th2 = th;
                                if (cursor != null) {
                                    cursor.close();
                                }
                                throw th2;
                            }
                        } catch (Throwable th4) {
                            th2 = th4;
                            cursor = query;
                            if (cursor != null) {
                                cursor.close();
                            }
                            throw th2;
                        }
                    }
                    zzcgw com_google_android_gms_internal_zzcgw = com_google_android_gms_internal_zzcgw;
                    String str4 = str3;
                    cursor = query;
                    try {
                        com_google_android_gms_internal_zzcgw = new zzcgw(str, str4, j, j2, j3, j4, valueOf, valueOf2, bool);
                        if (cursor.moveToNext()) {
                            zzawy().zzazd().zzj("Got multiple records for event aggregates, expected one. appId", zzchm.zzjk(str));
                        }
                        if (cursor != null) {
                            cursor.close();
                        }
                        return com_google_android_gms_internal_zzcgw;
                    } catch (SQLiteException e3) {
                        e2 = e3;
                        obj = e2;
                        zzawy().zzazd().zzd("Error querying events. appId", zzchm.zzjk(str), zzawt().zzjh(str2), obj);
                        if (cursor != null) {
                            cursor.close();
                        }
                        return null;
                    }
                }
                if (query != null) {
                    query.close();
                }
                return null;
            } catch (SQLiteException e4) {
                e2 = e4;
                cursor = query;
                obj = e2;
                zzawy().zzazd().zzd("Error querying events. appId", zzchm.zzjk(str), zzawt().zzjh(str2), obj);
                if (cursor != null) {
                    cursor.close();
                }
                return null;
            } catch (Throwable th5) {
                th4 = th5;
                cursor = query;
                th2 = th4;
                if (cursor != null) {
                    cursor.close();
                }
                throw th2;
            }
        } catch (SQLiteException e22) {
            obj = e22;
            cursor = null;
            zzawy().zzazd().zzd("Error querying events. appId", zzchm.zzjk(str), zzawt().zzjh(str2), obj);
            if (cursor != null) {
                cursor.close();
            }
            return null;
        } catch (Throwable th42) {
            th2 = th42;
            cursor = null;
            if (cursor != null) {
                cursor.close();
            }
            throw th2;
        }
    }

    @WorkerThread
    public final void zzaf(String str, String str2) {
        zzbq.zzgm(str);
        zzbq.zzgm(str2);
        zzve();
        zzxf();
        try {
            zzawy().zzazj().zzj("Deleted user attribute rows", Integer.valueOf(getWritableDatabase().delete("user_attributes", "app_id=? and name=?", new String[]{str, str2})));
        } catch (SQLiteException e) {
            zzawy().zzazd().zzd("Error deleting user attribute. appId", zzchm.zzjk(str), zzawt().zzjj(str2), e);
        }
    }

    @WorkerThread
    public final zzclp zzag(String str, String str2) {
        Cursor query;
        SQLiteException e;
        Object obj;
        Throwable th;
        Throwable th2;
        zzcgo com_google_android_gms_internal_zzcgo;
        String str3 = str2;
        zzbq.zzgm(str);
        zzbq.zzgm(str2);
        zzve();
        zzxf();
        try {
            query = getWritableDatabase().query("user_attributes", new String[]{"set_timestamp", Param.VALUE, Param.ORIGIN}, "app_id=? and name=?", new String[]{str, str3}, null, null, null);
            try {
                if (query.moveToFirst()) {
                    long j = query.getLong(0);
                    try {
                        String str4 = str;
                        zzclp com_google_android_gms_internal_zzclp = new zzclp(str4, query.getString(2), str3, j, zza(query, 1));
                        if (query.moveToNext()) {
                            zzawy().zzazd().zzj("Got multiple records for user property, expected one. appId", zzchm.zzjk(str));
                        }
                        if (query != null) {
                            query.close();
                        }
                        return com_google_android_gms_internal_zzclp;
                    } catch (SQLiteException e2) {
                        e = e2;
                        obj = e;
                        try {
                            zzawy().zzazd().zzd("Error querying user property. appId", zzchm.zzjk(str), zzawt().zzjj(str3), obj);
                            if (query != null) {
                                query.close();
                            }
                            return null;
                        } catch (Throwable th3) {
                            th = th3;
                            th2 = th;
                            if (query != null) {
                                query.close();
                            }
                            throw th2;
                        }
                    }
                }
                if (query != null) {
                    query.close();
                }
                return null;
            } catch (SQLiteException e3) {
                e = e3;
                com_google_android_gms_internal_zzcgo = this;
                obj = e;
                zzawy().zzazd().zzd("Error querying user property. appId", zzchm.zzjk(str), zzawt().zzjj(str3), obj);
                if (query != null) {
                    query.close();
                }
                return null;
            } catch (Throwable th4) {
                th = th4;
                com_google_android_gms_internal_zzcgo = this;
                th2 = th;
                if (query != null) {
                    query.close();
                }
                throw th2;
            }
        } catch (SQLiteException e4) {
            com_google_android_gms_internal_zzcgo = this;
            obj = e4;
            query = null;
            zzawy().zzazd().zzd("Error querying user property. appId", zzchm.zzjk(str), zzawt().zzjj(str3), obj);
            if (query != null) {
                query.close();
            }
            return null;
        } catch (Throwable th5) {
            com_google_android_gms_internal_zzcgo = this;
            th2 = th5;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th2;
        }
    }

    @WorkerThread
    public final zzcgl zzah(String str, String str2) {
        Cursor query;
        SQLiteException e;
        Object obj;
        Throwable th;
        Throwable th2;
        zzcgo com_google_android_gms_internal_zzcgo;
        String str3 = str2;
        zzbq.zzgm(str);
        zzbq.zzgm(str2);
        zzve();
        zzxf();
        try {
            query = getWritableDatabase().query("conditional_properties", new String[]{Param.ORIGIN, Param.VALUE, "active", "trigger_event_name", "trigger_timeout", "timed_out_event", "creation_timestamp", "triggered_event", "triggered_timestamp", "time_to_live", "expired_event"}, "app_id=? and name=?", new String[]{str, str3}, null, null, null);
            try {
                if (query.moveToFirst()) {
                    String string = query.getString(0);
                    try {
                        Object zza = zza(query, 1);
                        boolean z = query.getInt(2) != 0;
                        String string2 = query.getString(3);
                        long j = query.getLong(4);
                        zzcha com_google_android_gms_internal_zzcha = (zzcha) zzawu().zzb(query.getBlob(5), zzcha.CREATOR);
                        String str4 = str;
                        zzcgl com_google_android_gms_internal_zzcgl = new zzcgl(str4, string, new zzcln(str3, query.getLong(8), zza, string), query.getLong(6), z, string2, com_google_android_gms_internal_zzcha, j, (zzcha) zzawu().zzb(query.getBlob(7), zzcha.CREATOR), query.getLong(9), (zzcha) zzawu().zzb(query.getBlob(10), zzcha.CREATOR));
                        if (query.moveToNext()) {
                            zzawy().zzazd().zze("Got multiple records for conditional property, expected one", zzchm.zzjk(str), zzawt().zzjj(str3));
                        }
                        if (query != null) {
                            query.close();
                        }
                        return com_google_android_gms_internal_zzcgl;
                    } catch (SQLiteException e2) {
                        e = e2;
                        obj = e;
                        try {
                            zzawy().zzazd().zzd("Error querying conditional property", zzchm.zzjk(str), zzawt().zzjj(str3), obj);
                            if (query != null) {
                                query.close();
                            }
                            return null;
                        } catch (Throwable th3) {
                            th = th3;
                            th2 = th;
                            if (query != null) {
                                query.close();
                            }
                            throw th2;
                        }
                    }
                }
                if (query != null) {
                    query.close();
                }
                return null;
            } catch (SQLiteException e3) {
                e = e3;
                com_google_android_gms_internal_zzcgo = this;
                obj = e;
                zzawy().zzazd().zzd("Error querying conditional property", zzchm.zzjk(str), zzawt().zzjj(str3), obj);
                if (query != null) {
                    query.close();
                }
                return null;
            } catch (Throwable th4) {
                th = th4;
                com_google_android_gms_internal_zzcgo = this;
                th2 = th;
                if (query != null) {
                    query.close();
                }
                throw th2;
            }
        } catch (SQLiteException e4) {
            com_google_android_gms_internal_zzcgo = this;
            obj = e4;
            query = null;
            zzawy().zzazd().zzd("Error querying conditional property", zzchm.zzjk(str), zzawt().zzjj(str3), obj);
            if (query != null) {
                query.close();
            }
            return null;
        } catch (Throwable th5) {
            com_google_android_gms_internal_zzcgo = this;
            th2 = th5;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th2;
        }
    }

    public final void zzah(List<Long> list) {
        zzbq.checkNotNull(list);
        zzve();
        zzxf();
        StringBuilder stringBuilder = new StringBuilder("rowid in (");
        for (int i = 0; i < list.size(); i++) {
            if (i != 0) {
                stringBuilder.append(",");
            }
            stringBuilder.append(((Long) list.get(i)).longValue());
        }
        stringBuilder.append(")");
        int delete = getWritableDatabase().delete("raw_events", stringBuilder.toString(), null);
        if (delete != list.size()) {
            zzawy().zzazd().zze("Deleted fewer rows from raw events table than expected", Integer.valueOf(delete), Integer.valueOf(list.size()));
        }
    }

    @WorkerThread
    public final int zzai(String str, String str2) {
        zzbq.zzgm(str);
        zzbq.zzgm(str2);
        zzve();
        zzxf();
        try {
            return getWritableDatabase().delete("conditional_properties", "app_id=? and name=?", new String[]{str, str2});
        } catch (SQLiteException e) {
            zzawy().zzazd().zzd("Error deleting conditional property", zzchm.zzjk(str), zzawt().zzjj(str2), e);
            return 0;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    final java.util.Map<java.lang.Integer, java.util.List<com.google.android.gms.internal.zzcls>> zzaj(java.lang.String r13, java.lang.String r14) {
        /*
        r12 = this;
        r12.zzxf();
        r12.zzve();
        com.google.android.gms.common.internal.zzbq.zzgm(r13);
        com.google.android.gms.common.internal.zzbq.zzgm(r14);
        r0 = new android.support.v4.util.ArrayMap;
        r0.<init>();
        r1 = r12.getWritableDatabase();
        r9 = 0;
        r2 = "event_filters";
        r3 = "audience_id";
        r4 = "data";
        r3 = new java.lang.String[]{r3, r4};	 Catch:{ SQLiteException -> 0x0096, all -> 0x0093 }
        r4 = "app_id=? AND event_name=?";
        r5 = 2;
        r5 = new java.lang.String[r5];	 Catch:{ SQLiteException -> 0x0096, all -> 0x0093 }
        r10 = 0;
        r5[r10] = r13;	 Catch:{ SQLiteException -> 0x0096, all -> 0x0093 }
        r11 = 1;
        r5[r11] = r14;	 Catch:{ SQLiteException -> 0x0096, all -> 0x0093 }
        r6 = 0;
        r7 = 0;
        r8 = 0;
        r14 = r1.query(r2, r3, r4, r5, r6, r7, r8);	 Catch:{ SQLiteException -> 0x0096, all -> 0x0093 }
        r1 = r14.moveToFirst();	 Catch:{ SQLiteException -> 0x0091 }
        if (r1 != 0) goto L_0x0042;
    L_0x0038:
        r0 = java.util.Collections.emptyMap();	 Catch:{ SQLiteException -> 0x0091 }
        if (r14 == 0) goto L_0x0041;
    L_0x003e:
        r14.close();
    L_0x0041:
        return r0;
    L_0x0042:
        r1 = r14.getBlob(r11);	 Catch:{ SQLiteException -> 0x0091 }
        r2 = r1.length;	 Catch:{ SQLiteException -> 0x0091 }
        r1 = com.google.android.gms.internal.zzfjj.zzn(r1, r10, r2);	 Catch:{ SQLiteException -> 0x0091 }
        r2 = new com.google.android.gms.internal.zzcls;	 Catch:{ SQLiteException -> 0x0091 }
        r2.<init>();	 Catch:{ SQLiteException -> 0x0091 }
        r2.zza(r1);	 Catch:{ IOException -> 0x0073 }
        r1 = r14.getInt(r10);	 Catch:{ SQLiteException -> 0x0091 }
        r3 = java.lang.Integer.valueOf(r1);	 Catch:{ SQLiteException -> 0x0091 }
        r3 = r0.get(r3);	 Catch:{ SQLiteException -> 0x0091 }
        r3 = (java.util.List) r3;	 Catch:{ SQLiteException -> 0x0091 }
        if (r3 != 0) goto L_0x006f;
    L_0x0063:
        r3 = new java.util.ArrayList;	 Catch:{ SQLiteException -> 0x0091 }
        r3.<init>();	 Catch:{ SQLiteException -> 0x0091 }
        r1 = java.lang.Integer.valueOf(r1);	 Catch:{ SQLiteException -> 0x0091 }
        r0.put(r1, r3);	 Catch:{ SQLiteException -> 0x0091 }
    L_0x006f:
        r3.add(r2);	 Catch:{ SQLiteException -> 0x0091 }
        goto L_0x0085;
    L_0x0073:
        r1 = move-exception;
        r2 = r12.zzawy();	 Catch:{ SQLiteException -> 0x0091 }
        r2 = r2.zzazd();	 Catch:{ SQLiteException -> 0x0091 }
        r3 = "Failed to merge filter. appId";
        r4 = com.google.android.gms.internal.zzchm.zzjk(r13);	 Catch:{ SQLiteException -> 0x0091 }
        r2.zze(r3, r4, r1);	 Catch:{ SQLiteException -> 0x0091 }
    L_0x0085:
        r1 = r14.moveToNext();	 Catch:{ SQLiteException -> 0x0091 }
        if (r1 != 0) goto L_0x0042;
    L_0x008b:
        if (r14 == 0) goto L_0x0090;
    L_0x008d:
        r14.close();
    L_0x0090:
        return r0;
    L_0x0091:
        r0 = move-exception;
        goto L_0x0098;
    L_0x0093:
        r13 = move-exception;
        r14 = r9;
        goto L_0x00b0;
    L_0x0096:
        r0 = move-exception;
        r14 = r9;
    L_0x0098:
        r1 = r12.zzawy();	 Catch:{ all -> 0x00af }
        r1 = r1.zzazd();	 Catch:{ all -> 0x00af }
        r2 = "Database error querying filters. appId";
        r13 = com.google.android.gms.internal.zzchm.zzjk(r13);	 Catch:{ all -> 0x00af }
        r1.zze(r2, r13, r0);	 Catch:{ all -> 0x00af }
        if (r14 == 0) goto L_0x00ae;
    L_0x00ab:
        r14.close();
    L_0x00ae:
        return r9;
    L_0x00af:
        r13 = move-exception;
    L_0x00b0:
        if (r14 == 0) goto L_0x00b5;
    L_0x00b2:
        r14.close();
    L_0x00b5:
        throw r13;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzcgo.zzaj(java.lang.String, java.lang.String):java.util.Map<java.lang.Integer, java.util.List<com.google.android.gms.internal.zzcls>>");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    final java.util.Map<java.lang.Integer, java.util.List<com.google.android.gms.internal.zzclv>> zzak(java.lang.String r13, java.lang.String r14) {
        /*
        r12 = this;
        r12.zzxf();
        r12.zzve();
        com.google.android.gms.common.internal.zzbq.zzgm(r13);
        com.google.android.gms.common.internal.zzbq.zzgm(r14);
        r0 = new android.support.v4.util.ArrayMap;
        r0.<init>();
        r1 = r12.getWritableDatabase();
        r9 = 0;
        r2 = "property_filters";
        r3 = "audience_id";
        r4 = "data";
        r3 = new java.lang.String[]{r3, r4};	 Catch:{ SQLiteException -> 0x0096, all -> 0x0093 }
        r4 = "app_id=? AND property_name=?";
        r5 = 2;
        r5 = new java.lang.String[r5];	 Catch:{ SQLiteException -> 0x0096, all -> 0x0093 }
        r10 = 0;
        r5[r10] = r13;	 Catch:{ SQLiteException -> 0x0096, all -> 0x0093 }
        r11 = 1;
        r5[r11] = r14;	 Catch:{ SQLiteException -> 0x0096, all -> 0x0093 }
        r6 = 0;
        r7 = 0;
        r8 = 0;
        r14 = r1.query(r2, r3, r4, r5, r6, r7, r8);	 Catch:{ SQLiteException -> 0x0096, all -> 0x0093 }
        r1 = r14.moveToFirst();	 Catch:{ SQLiteException -> 0x0091 }
        if (r1 != 0) goto L_0x0042;
    L_0x0038:
        r0 = java.util.Collections.emptyMap();	 Catch:{ SQLiteException -> 0x0091 }
        if (r14 == 0) goto L_0x0041;
    L_0x003e:
        r14.close();
    L_0x0041:
        return r0;
    L_0x0042:
        r1 = r14.getBlob(r11);	 Catch:{ SQLiteException -> 0x0091 }
        r2 = r1.length;	 Catch:{ SQLiteException -> 0x0091 }
        r1 = com.google.android.gms.internal.zzfjj.zzn(r1, r10, r2);	 Catch:{ SQLiteException -> 0x0091 }
        r2 = new com.google.android.gms.internal.zzclv;	 Catch:{ SQLiteException -> 0x0091 }
        r2.<init>();	 Catch:{ SQLiteException -> 0x0091 }
        r2.zza(r1);	 Catch:{ IOException -> 0x0073 }
        r1 = r14.getInt(r10);	 Catch:{ SQLiteException -> 0x0091 }
        r3 = java.lang.Integer.valueOf(r1);	 Catch:{ SQLiteException -> 0x0091 }
        r3 = r0.get(r3);	 Catch:{ SQLiteException -> 0x0091 }
        r3 = (java.util.List) r3;	 Catch:{ SQLiteException -> 0x0091 }
        if (r3 != 0) goto L_0x006f;
    L_0x0063:
        r3 = new java.util.ArrayList;	 Catch:{ SQLiteException -> 0x0091 }
        r3.<init>();	 Catch:{ SQLiteException -> 0x0091 }
        r1 = java.lang.Integer.valueOf(r1);	 Catch:{ SQLiteException -> 0x0091 }
        r0.put(r1, r3);	 Catch:{ SQLiteException -> 0x0091 }
    L_0x006f:
        r3.add(r2);	 Catch:{ SQLiteException -> 0x0091 }
        goto L_0x0085;
    L_0x0073:
        r1 = move-exception;
        r2 = r12.zzawy();	 Catch:{ SQLiteException -> 0x0091 }
        r2 = r2.zzazd();	 Catch:{ SQLiteException -> 0x0091 }
        r3 = "Failed to merge filter";
        r4 = com.google.android.gms.internal.zzchm.zzjk(r13);	 Catch:{ SQLiteException -> 0x0091 }
        r2.zze(r3, r4, r1);	 Catch:{ SQLiteException -> 0x0091 }
    L_0x0085:
        r1 = r14.moveToNext();	 Catch:{ SQLiteException -> 0x0091 }
        if (r1 != 0) goto L_0x0042;
    L_0x008b:
        if (r14 == 0) goto L_0x0090;
    L_0x008d:
        r14.close();
    L_0x0090:
        return r0;
    L_0x0091:
        r0 = move-exception;
        goto L_0x0098;
    L_0x0093:
        r13 = move-exception;
        r14 = r9;
        goto L_0x00b0;
    L_0x0096:
        r0 = move-exception;
        r14 = r9;
    L_0x0098:
        r1 = r12.zzawy();	 Catch:{ all -> 0x00af }
        r1 = r1.zzazd();	 Catch:{ all -> 0x00af }
        r2 = "Database error querying filters. appId";
        r13 = com.google.android.gms.internal.zzchm.zzjk(r13);	 Catch:{ all -> 0x00af }
        r1.zze(r2, r13, r0);	 Catch:{ all -> 0x00af }
        if (r14 == 0) goto L_0x00ae;
    L_0x00ab:
        r14.close();
    L_0x00ae:
        return r9;
    L_0x00af:
        r13 = move-exception;
    L_0x00b0:
        if (r14 == 0) goto L_0x00b5;
    L_0x00b2:
        r14.close();
    L_0x00b5:
        throw r13;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzcgo.zzak(java.lang.String, java.lang.String):java.util.Map<java.lang.Integer, java.util.List<com.google.android.gms.internal.zzclv>>");
    }

    @WorkerThread
    protected final long zzal(String str, String str2) {
        Object e;
        zzbq.zzgm(str);
        zzbq.zzgm(str2);
        zzve();
        zzxf();
        SQLiteDatabase writableDatabase = getWritableDatabase();
        writableDatabase.beginTransaction();
        long zza;
        try {
            ContentValues contentValues;
            StringBuilder stringBuilder = new StringBuilder(32 + String.valueOf(str2).length());
            stringBuilder.append("select ");
            stringBuilder.append(str2);
            stringBuilder.append(" from app2 where app_id=?");
            zza = zza(stringBuilder.toString(), new String[]{str}, -1);
            if (zza == -1) {
                contentValues = new ContentValues();
                contentValues.put("app_id", str);
                contentValues.put("first_open_count", Integer.valueOf(0));
                contentValues.put("previous_install_count", Integer.valueOf(0));
                if (writableDatabase.insertWithOnConflict("app2", null, contentValues, 5) == -1) {
                    zzawy().zzazd().zze("Failed to insert column (got -1). appId", zzchm.zzjk(str), str2);
                    writableDatabase.endTransaction();
                    return -1;
                }
                zza = 0;
            }
            try {
                contentValues = new ContentValues();
                contentValues.put("app_id", str);
                contentValues.put(str2, Long.valueOf(1 + zza));
                if (((long) writableDatabase.update("app2", contentValues, "app_id = ?", new String[]{str})) == 0) {
                    zzawy().zzazd().zze("Failed to update column (got 0). appId", zzchm.zzjk(str), str2);
                    writableDatabase.endTransaction();
                    return -1;
                }
                writableDatabase.setTransactionSuccessful();
                writableDatabase.endTransaction();
                return zza;
            } catch (SQLiteException e2) {
                e = e2;
                try {
                    zzawy().zzazd().zzd("Error inserting column. appId", zzchm.zzjk(str), str2, e);
                    writableDatabase.endTransaction();
                    return zza;
                } catch (Throwable th) {
                    writableDatabase.endTransaction();
                }
            }
        } catch (SQLiteException e3) {
            e = e3;
            zza = 0;
            zzawy().zzazd().zzd("Error inserting column. appId", zzchm.zzjk(str), str2, e);
            writableDatabase.endTransaction();
            return zza;
        }
    }

    protected final boolean zzaxz() {
        return false;
    }

    @WorkerThread
    public final String zzayf() {
        Cursor rawQuery;
        Object e;
        Throwable th;
        try {
            rawQuery = getWritableDatabase().rawQuery("select app_id from queue order by has_realtime desc, rowid asc limit 1;", null);
            try {
                if (rawQuery.moveToFirst()) {
                    String string = rawQuery.getString(0);
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                    return string;
                }
                if (rawQuery != null) {
                    rawQuery.close();
                }
                return null;
            } catch (SQLiteException e2) {
                e = e2;
                try {
                    zzawy().zzazd().zzj("Database error getting next bundle app id", e);
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                    throw th;
                }
            }
        } catch (SQLiteException e3) {
            e = e3;
            rawQuery = null;
            zzawy().zzazd().zzj("Database error getting next bundle app id", e);
            if (rawQuery != null) {
                rawQuery.close();
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
            rawQuery = null;
            if (rawQuery != null) {
                rawQuery.close();
            }
            throw th;
        }
    }

    public final boolean zzayg() {
        return zzb("select count(1) > 0 from queue where has_realtime = 1", null) != 0;
    }

    @WorkerThread
    final void zzayh() {
        zzve();
        zzxf();
        if (zzayn()) {
            long j = zzawz().zzjcu.get();
            long elapsedRealtime = zzws().elapsedRealtime();
            if (Math.abs(elapsedRealtime - j) > ((Long) zzchc.zzjbb.get()).longValue()) {
                zzawz().zzjcu.set(elapsedRealtime);
                zzve();
                zzxf();
                if (zzayn()) {
                    int delete = getWritableDatabase().delete("queue", "abs(bundle_end_timestamp - ?) > cast(? as integer)", new String[]{String.valueOf(zzws().currentTimeMillis()), String.valueOf(zzcgn.zzayb())});
                    if (delete > 0) {
                        zzawy().zzazj().zzj("Deleted stale rows. rowsDeleted", Integer.valueOf(delete));
                    }
                }
            }
        }
    }

    @WorkerThread
    public final long zzayi() {
        return zza("select max(bundle_end_timestamp) from queue", null, 0);
    }

    @WorkerThread
    public final long zzayj() {
        return zza("select max(timestamp) from raw_events", null, 0);
    }

    public final boolean zzayk() {
        return zzb("select count(1) > 0 from raw_events", null) != 0;
    }

    public final boolean zzayl() {
        return zzb("select count(1) > 0 from raw_events where realtime = 1", null) != 0;
    }

    public final long zzaym() {
        Object obj;
        Throwable th;
        Cursor cursor = null;
        try {
            Cursor rawQuery = getWritableDatabase().rawQuery("select rowid from raw_events order by rowid desc limit 1;", null);
            try {
                if (rawQuery.moveToFirst()) {
                    long j = rawQuery.getLong(0);
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                    return j;
                }
                if (rawQuery != null) {
                    rawQuery.close();
                }
                return -1;
            } catch (SQLiteException e) {
                Cursor cursor2 = rawQuery;
                obj = e;
                cursor = cursor2;
                try {
                    zzawy().zzazd().zzj("Error querying raw events", obj);
                    if (cursor != null) {
                        cursor.close();
                    }
                    return -1;
                } catch (Throwable th2) {
                    th = th2;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                cursor = rawQuery;
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        } catch (SQLiteException e2) {
            obj = e2;
            zzawy().zzazd().zzj("Error querying raw events", obj);
            if (cursor != null) {
                cursor.close();
            }
            return -1;
        }
    }

    public final String zzba(long j) {
        Object e;
        Throwable th;
        zzve();
        zzxf();
        Cursor rawQuery;
        try {
            rawQuery = getWritableDatabase().rawQuery("select app_id from apps where app_id in (select distinct app_id from raw_events) and config_fetched_time < ? order by failed_config_fetch_time limit 1;", new String[]{String.valueOf(j)});
            try {
                if (rawQuery.moveToFirst()) {
                    String string = rawQuery.getString(0);
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                    return string;
                }
                zzawy().zzazj().log("No expired configs for apps with pending events");
                if (rawQuery != null) {
                    rawQuery.close();
                }
                return null;
            } catch (SQLiteException e2) {
                e = e2;
                try {
                    zzawy().zzazd().zzj("Error selecting expired configs", e);
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                    throw th;
                }
            }
        } catch (SQLiteException e3) {
            e = e3;
            rawQuery = null;
            zzawy().zzazd().zzj("Error selecting expired configs", e);
            if (rawQuery != null) {
                rawQuery.close();
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
            rawQuery = null;
            if (rawQuery != null) {
                rawQuery.close();
            }
            throw th;
        }
    }

    public final List<zzcgl> zzc(String str, String[] strArr) {
        Object obj;
        Throwable th;
        zzve();
        zzxf();
        List<zzcgl> arrayList = new ArrayList();
        Cursor cursor = null;
        Cursor query;
        try {
            query = getWritableDatabase().query("conditional_properties", new String[]{"app_id", Param.ORIGIN, "name", Param.VALUE, "active", "trigger_event_name", "trigger_timeout", "timed_out_event", "creation_timestamp", "triggered_event", "triggered_timestamp", "time_to_live", "expired_event"}, str, strArr, null, null, "rowid", "1001");
            try {
                if (query.moveToFirst()) {
                    do {
                        if (arrayList.size() >= 1000) {
                            zzawy().zzazd().zzj("Read more than the max allowed conditional properties, ignoring extra", Integer.valueOf(1000));
                            break;
                        }
                        boolean z = false;
                        String string = query.getString(0);
                        String string2 = query.getString(1);
                        String string3 = query.getString(2);
                        Object zza = zza(query, 3);
                        if (query.getInt(4) != 0) {
                            z = true;
                        }
                        String string4 = query.getString(5);
                        long j = query.getLong(6);
                        zzcha com_google_android_gms_internal_zzcha = (zzcha) zzawu().zzb(query.getBlob(7), zzcha.CREATOR);
                        long j2 = query.getLong(8);
                        zzcha com_google_android_gms_internal_zzcha2 = (zzcha) zzawu().zzb(query.getBlob(9), zzcha.CREATOR);
                        long j3 = query.getLong(10);
                        long j4 = query.getLong(11);
                        zzcha com_google_android_gms_internal_zzcha3 = (zzcha) zzawu().zzb(query.getBlob(12), zzcha.CREATOR);
                        zzcln com_google_android_gms_internal_zzcln = new zzcln(string3, j3, zza, string2);
                        boolean z2 = z;
                        zzcgl com_google_android_gms_internal_zzcgl = r4;
                        zzcgl com_google_android_gms_internal_zzcgl2 = new zzcgl(string, string2, com_google_android_gms_internal_zzcln, j2, z2, string4, com_google_android_gms_internal_zzcha, j, com_google_android_gms_internal_zzcha2, j4, com_google_android_gms_internal_zzcha3);
                        arrayList.add(com_google_android_gms_internal_zzcgl);
                    } while (query.moveToNext());
                    if (query != null) {
                        query.close();
                    }
                    return arrayList;
                }
                if (query != null) {
                    query.close();
                }
                return arrayList;
            } catch (SQLiteException e) {
                obj = e;
                cursor = query;
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (SQLiteException e2) {
            obj = e2;
            try {
                zzawy().zzazd().zzj("Error querying conditional user property value", obj);
                arrayList = Collections.emptyList();
                if (cursor != null) {
                    cursor.close();
                }
                return arrayList;
            } catch (Throwable th22) {
                th = th22;
                query = cursor;
                if (query != null) {
                    query.close();
                }
                throw th;
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    @android.support.annotation.WorkerThread
    public final java.util.List<com.google.android.gms.internal.zzclp> zzg(java.lang.String r24, java.lang.String r25, java.lang.String r26) {
        /*
        r23 = this;
        com.google.android.gms.common.internal.zzbq.zzgm(r24);
        r23.zzve();
        r23.zzxf();
        r1 = new java.util.ArrayList;
        r1.<init>();
        r2 = 0;
        r3 = new java.util.ArrayList;	 Catch:{ SQLiteException -> 0x0109, all -> 0x0104 }
        r4 = 3;
        r3.<init>(r4);	 Catch:{ SQLiteException -> 0x0109, all -> 0x0104 }
        r12 = r24;
        r3.add(r12);	 Catch:{ SQLiteException -> 0x0100, all -> 0x0104 }
        r5 = new java.lang.StringBuilder;	 Catch:{ SQLiteException -> 0x0100, all -> 0x0104 }
        r6 = "app_id=?";
        r5.<init>(r6);	 Catch:{ SQLiteException -> 0x0100, all -> 0x0104 }
        r6 = android.text.TextUtils.isEmpty(r25);	 Catch:{ SQLiteException -> 0x0100, all -> 0x0104 }
        if (r6 != 0) goto L_0x0037;
    L_0x0027:
        r6 = r25;
        r3.add(r6);	 Catch:{ SQLiteException -> 0x0032, all -> 0x0104 }
        r7 = " and origin=?";
        r5.append(r7);	 Catch:{ SQLiteException -> 0x0032, all -> 0x0104 }
        goto L_0x0039;
    L_0x0032:
        r0 = move-exception;
        r13 = r23;
        goto L_0x0110;
    L_0x0037:
        r6 = r25;
    L_0x0039:
        r7 = android.text.TextUtils.isEmpty(r26);	 Catch:{ SQLiteException -> 0x0032, all -> 0x0104 }
        if (r7 != 0) goto L_0x0051;
    L_0x003f:
        r7 = java.lang.String.valueOf(r26);	 Catch:{ SQLiteException -> 0x0032, all -> 0x0104 }
        r8 = "*";
        r7 = r7.concat(r8);	 Catch:{ SQLiteException -> 0x0032, all -> 0x0104 }
        r3.add(r7);	 Catch:{ SQLiteException -> 0x0032, all -> 0x0104 }
        r7 = " and name glob ?";
        r5.append(r7);	 Catch:{ SQLiteException -> 0x0032, all -> 0x0104 }
    L_0x0051:
        r7 = r3.size();	 Catch:{ SQLiteException -> 0x0032, all -> 0x0104 }
        r7 = new java.lang.String[r7];	 Catch:{ SQLiteException -> 0x0032, all -> 0x0104 }
        r3 = r3.toArray(r7);	 Catch:{ SQLiteException -> 0x0032, all -> 0x0104 }
        r17 = r3;
        r17 = (java.lang.String[]) r17;	 Catch:{ SQLiteException -> 0x0032, all -> 0x0104 }
        r13 = r23.getWritableDatabase();	 Catch:{ SQLiteException -> 0x0032, all -> 0x0104 }
        r14 = "user_attributes";
        r3 = "name";
        r7 = "set_timestamp";
        r8 = "value";
        r9 = "origin";
        r15 = new java.lang.String[]{r3, r7, r8, r9};	 Catch:{ SQLiteException -> 0x0032, all -> 0x0104 }
        r16 = r5.toString();	 Catch:{ SQLiteException -> 0x0032, all -> 0x0104 }
        r18 = 0;
        r19 = 0;
        r20 = "rowid";
        r21 = "1001";
        r3 = r13.query(r14, r15, r16, r17, r18, r19, r20, r21);	 Catch:{ SQLiteException -> 0x0032, all -> 0x0104 }
        r5 = r3.moveToFirst();	 Catch:{ SQLiteException -> 0x00fb, all -> 0x00f7 }
        if (r5 != 0) goto L_0x008d;
    L_0x0087:
        if (r3 == 0) goto L_0x008c;
    L_0x0089:
        r3.close();
    L_0x008c:
        return r1;
    L_0x008d:
        r5 = r1.size();	 Catch:{ SQLiteException -> 0x00fb, all -> 0x00f7 }
        r7 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        if (r5 < r7) goto L_0x00a9;
    L_0x0095:
        r4 = r23.zzawy();	 Catch:{ SQLiteException -> 0x00fb, all -> 0x00f7 }
        r4 = r4.zzazd();	 Catch:{ SQLiteException -> 0x00fb, all -> 0x00f7 }
        r5 = "Read more than the max allowed user properties, ignoring excess";
        r7 = java.lang.Integer.valueOf(r7);	 Catch:{ SQLiteException -> 0x00fb, all -> 0x00f7 }
        r4.zzj(r5, r7);	 Catch:{ SQLiteException -> 0x00fb, all -> 0x00f7 }
        r13 = r23;
        goto L_0x00ec;
    L_0x00a9:
        r5 = 0;
        r8 = r3.getString(r5);	 Catch:{ SQLiteException -> 0x00fb, all -> 0x00f7 }
        r5 = 1;
        r9 = r3.getLong(r5);	 Catch:{ SQLiteException -> 0x00fb, all -> 0x00f7 }
        r5 = 2;
        r13 = r23;
        r11 = r13.zza(r3, r5);	 Catch:{ SQLiteException -> 0x00f5 }
        r14 = r3.getString(r4);	 Catch:{ SQLiteException -> 0x00f5 }
        if (r11 != 0) goto L_0x00d8;
    L_0x00c0:
        r5 = r23.zzawy();	 Catch:{ SQLiteException -> 0x00d4 }
        r5 = r5.zzazd();	 Catch:{ SQLiteException -> 0x00d4 }
        r6 = "(2)Read invalid user property value, ignoring it";
        r7 = com.google.android.gms.internal.zzchm.zzjk(r24);	 Catch:{ SQLiteException -> 0x00d4 }
        r15 = r26;
        r5.zzd(r6, r7, r14, r15);	 Catch:{ SQLiteException -> 0x00d4 }
        goto L_0x00e6;
    L_0x00d4:
        r0 = move-exception;
        r1 = r0;
        r6 = r14;
        goto L_0x0112;
    L_0x00d8:
        r15 = r26;
        r7 = new com.google.android.gms.internal.zzclp;	 Catch:{ SQLiteException -> 0x00d4 }
        r5 = r7;
        r6 = r12;
        r4 = r7;
        r7 = r14;
        r5.<init>(r6, r7, r8, r9, r11);	 Catch:{ SQLiteException -> 0x00d4 }
        r1.add(r4);	 Catch:{ SQLiteException -> 0x00d4 }
    L_0x00e6:
        r4 = r3.moveToNext();	 Catch:{ SQLiteException -> 0x00d4 }
        if (r4 != 0) goto L_0x00f2;
    L_0x00ec:
        if (r3 == 0) goto L_0x00f1;
    L_0x00ee:
        r3.close();
    L_0x00f1:
        return r1;
    L_0x00f2:
        r6 = r14;
        r4 = 3;
        goto L_0x008d;
    L_0x00f5:
        r0 = move-exception;
        goto L_0x00fe;
    L_0x00f7:
        r0 = move-exception;
        r13 = r23;
        goto L_0x012a;
    L_0x00fb:
        r0 = move-exception;
        r13 = r23;
    L_0x00fe:
        r1 = r0;
        goto L_0x0112;
    L_0x0100:
        r0 = move-exception;
        r13 = r23;
        goto L_0x010e;
    L_0x0104:
        r0 = move-exception;
        r13 = r23;
        r1 = r0;
        goto L_0x012c;
    L_0x0109:
        r0 = move-exception;
        r13 = r23;
        r12 = r24;
    L_0x010e:
        r6 = r25;
    L_0x0110:
        r1 = r0;
        r3 = r2;
    L_0x0112:
        r4 = r23.zzawy();	 Catch:{ all -> 0x0129 }
        r4 = r4.zzazd();	 Catch:{ all -> 0x0129 }
        r5 = "(2)Error querying user properties";
        r7 = com.google.android.gms.internal.zzchm.zzjk(r24);	 Catch:{ all -> 0x0129 }
        r4.zzd(r5, r7, r6, r1);	 Catch:{ all -> 0x0129 }
        if (r3 == 0) goto L_0x0128;
    L_0x0125:
        r3.close();
    L_0x0128:
        return r2;
    L_0x0129:
        r0 = move-exception;
    L_0x012a:
        r1 = r0;
        r2 = r3;
    L_0x012c:
        if (r2 == 0) goto L_0x0131;
    L_0x012e:
        r2.close();
    L_0x0131:
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzcgo.zzg(java.lang.String, java.lang.String, java.lang.String):java.util.List<com.google.android.gms.internal.zzclp>");
    }

    @WorkerThread
    public final List<zzcgl> zzh(String str, String str2, String str3) {
        zzbq.zzgm(str);
        zzve();
        zzxf();
        List arrayList = new ArrayList(3);
        arrayList.add(str);
        StringBuilder stringBuilder = new StringBuilder("app_id=?");
        if (!TextUtils.isEmpty(str2)) {
            arrayList.add(str2);
            stringBuilder.append(" and origin=?");
        }
        if (!TextUtils.isEmpty(str3)) {
            arrayList.add(String.valueOf(str3).concat("*"));
            stringBuilder.append(" and name glob ?");
        }
        return zzc(stringBuilder.toString(), (String[]) arrayList.toArray(new String[arrayList.size()]));
    }

    @WorkerThread
    public final List<zzclp> zzja(String str) {
        Object e;
        Throwable th;
        zzbq.zzgm(str);
        zzve();
        zzxf();
        List<zzclp> arrayList = new ArrayList();
        Cursor query;
        try {
            query = getWritableDatabase().query("user_attributes", new String[]{"name", Param.ORIGIN, "set_timestamp", Param.VALUE}, "app_id=?", new String[]{str}, null, null, "rowid", "1000");
            try {
                if (query.moveToFirst()) {
                    do {
                        String string = query.getString(0);
                        String string2 = query.getString(1);
                        if (string2 == null) {
                            string2 = "";
                        }
                        String str2 = string2;
                        long j = query.getLong(2);
                        Object zza = zza(query, 3);
                        if (zza == null) {
                            zzawy().zzazd().zzj("Read invalid user property value, ignoring it. appId", zzchm.zzjk(str));
                        } else {
                            arrayList.add(new zzclp(str, str2, string, j, zza));
                        }
                    } while (query.moveToNext());
                    if (query != null) {
                        query.close();
                    }
                    return arrayList;
                }
                if (query != null) {
                    query.close();
                }
                return arrayList;
            } catch (SQLiteException e2) {
                e = e2;
            }
        } catch (SQLiteException e3) {
            e = e3;
            query = null;
            try {
                zzawy().zzazd().zze("Error querying user properties. appId", zzchm.zzjk(str), e);
                if (query != null) {
                    query.close();
                }
                return null;
            } catch (Throwable th2) {
                th = th2;
                if (query != null) {
                    query.close();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
    }

    @WorkerThread
    public final zzcgh zzjb(String str) {
        SQLiteException e;
        Cursor cursor;
        Object obj;
        Throwable th;
        Throwable th2;
        zzcgo com_google_android_gms_internal_zzcgo;
        String str2 = str;
        zzbq.zzgm(str);
        zzve();
        zzxf();
        Cursor query;
        try {
            String[] strArr = new String[1];
            boolean z = false;
            strArr[0] = str2;
            query = getWritableDatabase().query("apps", new String[]{"app_instance_id", "gmp_app_id", "resettable_device_id_hash", "last_bundle_index", "last_bundle_start_timestamp", "last_bundle_end_timestamp", "app_version", "app_store", "gmp_version", "dev_cert_hash", "measurement_enabled", "day", "daily_public_events_count", "daily_events_count", "daily_conversions_count", "config_fetched_time", "failed_config_fetch_time", "app_version_int", "firebase_instance_id", "daily_error_events_count", "daily_realtime_events_count", "health_monitor_sample", "android_id", "adid_reporting_enabled"}, "app_id=?", strArr, null, null, null);
            try {
                if (query.moveToFirst()) {
                    try {
                        boolean z2;
                        zzcgh com_google_android_gms_internal_zzcgh = new zzcgh(this.zziwf, str2);
                        com_google_android_gms_internal_zzcgh.zzir(query.getString(0));
                        com_google_android_gms_internal_zzcgh.zzis(query.getString(1));
                        com_google_android_gms_internal_zzcgh.zzit(query.getString(2));
                        com_google_android_gms_internal_zzcgh.zzaq(query.getLong(3));
                        com_google_android_gms_internal_zzcgh.zzal(query.getLong(4));
                        com_google_android_gms_internal_zzcgh.zzam(query.getLong(5));
                        com_google_android_gms_internal_zzcgh.setAppVersion(query.getString(6));
                        com_google_android_gms_internal_zzcgh.zziv(query.getString(7));
                        com_google_android_gms_internal_zzcgh.zzao(query.getLong(8));
                        com_google_android_gms_internal_zzcgh.zzap(query.getLong(9));
                        if (!query.isNull(10)) {
                            if (query.getInt(10) == 0) {
                                z2 = false;
                                com_google_android_gms_internal_zzcgh.setMeasurementEnabled(z2);
                                com_google_android_gms_internal_zzcgh.zzat(query.getLong(11));
                                com_google_android_gms_internal_zzcgh.zzau(query.getLong(12));
                                com_google_android_gms_internal_zzcgh.zzav(query.getLong(13));
                                com_google_android_gms_internal_zzcgh.zzaw(query.getLong(14));
                                com_google_android_gms_internal_zzcgh.zzar(query.getLong(15));
                                com_google_android_gms_internal_zzcgh.zzas(query.getLong(16));
                                com_google_android_gms_internal_zzcgh.zzan(query.isNull(17) ? -2147483648L : (long) query.getInt(17));
                                com_google_android_gms_internal_zzcgh.zziu(query.getString(18));
                                com_google_android_gms_internal_zzcgh.zzay(query.getLong(19));
                                com_google_android_gms_internal_zzcgh.zzax(query.getLong(20));
                                com_google_android_gms_internal_zzcgh.zziw(query.getString(21));
                                com_google_android_gms_internal_zzcgh.zzaz(query.isNull(22) ? 0 : query.getLong(22));
                                if (query.isNull(23) || query.getInt(23) != 0) {
                                    z = true;
                                }
                                com_google_android_gms_internal_zzcgh.zzbl(z);
                                com_google_android_gms_internal_zzcgh.zzaxb();
                                if (query.moveToNext()) {
                                    zzawy().zzazd().zzj("Got multiple records for app, expected one. appId", zzchm.zzjk(str));
                                }
                                if (query != null) {
                                    query.close();
                                }
                                return com_google_android_gms_internal_zzcgh;
                            }
                        }
                        z2 = true;
                        com_google_android_gms_internal_zzcgh.setMeasurementEnabled(z2);
                        com_google_android_gms_internal_zzcgh.zzat(query.getLong(11));
                        com_google_android_gms_internal_zzcgh.zzau(query.getLong(12));
                        com_google_android_gms_internal_zzcgh.zzav(query.getLong(13));
                        com_google_android_gms_internal_zzcgh.zzaw(query.getLong(14));
                        com_google_android_gms_internal_zzcgh.zzar(query.getLong(15));
                        com_google_android_gms_internal_zzcgh.zzas(query.getLong(16));
                        if (query.isNull(17)) {
                        }
                        com_google_android_gms_internal_zzcgh.zzan(query.isNull(17) ? -2147483648L : (long) query.getInt(17));
                        com_google_android_gms_internal_zzcgh.zziu(query.getString(18));
                        com_google_android_gms_internal_zzcgh.zzay(query.getLong(19));
                        com_google_android_gms_internal_zzcgh.zzax(query.getLong(20));
                        com_google_android_gms_internal_zzcgh.zziw(query.getString(21));
                        if (query.isNull(22)) {
                        }
                        com_google_android_gms_internal_zzcgh.zzaz(query.isNull(22) ? 0 : query.getLong(22));
                        z = true;
                        com_google_android_gms_internal_zzcgh.zzbl(z);
                        com_google_android_gms_internal_zzcgh.zzaxb();
                        if (query.moveToNext()) {
                            zzawy().zzazd().zzj("Got multiple records for app, expected one. appId", zzchm.zzjk(str));
                        }
                        if (query != null) {
                            query.close();
                        }
                        return com_google_android_gms_internal_zzcgh;
                    } catch (SQLiteException e2) {
                        e = e2;
                        cursor = query;
                        obj = e;
                        try {
                            zzawy().zzazd().zze("Error querying app. appId", zzchm.zzjk(str), obj);
                            if (cursor != null) {
                                cursor.close();
                            }
                            return null;
                        } catch (Throwable th22) {
                            th = th22;
                            query = cursor;
                            if (query != null) {
                                query.close();
                            }
                            throw th;
                        }
                    } catch (Throwable th3) {
                        th22 = th3;
                        th = th22;
                        if (query != null) {
                            query.close();
                        }
                        throw th;
                    }
                }
                if (query != null) {
                    query.close();
                }
                return null;
            } catch (SQLiteException e3) {
                e = e3;
                com_google_android_gms_internal_zzcgo = this;
                cursor = query;
                obj = e;
                zzawy().zzazd().zze("Error querying app. appId", zzchm.zzjk(str), obj);
                if (cursor != null) {
                    cursor.close();
                }
                return null;
            } catch (Throwable th4) {
                th22 = th4;
                com_google_android_gms_internal_zzcgo = this;
                th = th22;
                if (query != null) {
                    query.close();
                }
                throw th;
            }
        } catch (SQLiteException e4) {
            com_google_android_gms_internal_zzcgo = this;
            obj = e4;
            cursor = null;
            zzawy().zzazd().zze("Error querying app. appId", zzchm.zzjk(str), obj);
            if (cursor != null) {
                cursor.close();
            }
            return null;
        } catch (Throwable th222) {
            com_google_android_gms_internal_zzcgo = this;
            th = th222;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
    }

    public final long zzjc(String str) {
        zzbq.zzgm(str);
        zzve();
        zzxf();
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            String valueOf = String.valueOf(Math.max(0, Math.min(1000000, zzaxa().zzb(str, zzchc.zzjas))));
            return (long) writableDatabase.delete("raw_events", "rowid in (select rowid from raw_events where app_id=? order by rowid desc limit -1 offset ?)", new String[]{str, valueOf});
        } catch (SQLiteException e) {
            zzawy().zzazd().zze("Error deleting over the limit events. appId", zzchm.zzjk(str), e);
            return 0;
        }
    }

    @WorkerThread
    public final byte[] zzjd(String str) {
        Object e;
        Throwable th;
        zzbq.zzgm(str);
        zzve();
        zzxf();
        Cursor query;
        try {
            query = getWritableDatabase().query("apps", new String[]{"remote_config"}, "app_id=?", new String[]{str}, null, null, null);
            try {
                if (query.moveToFirst()) {
                    byte[] blob = query.getBlob(0);
                    if (query.moveToNext()) {
                        zzawy().zzazd().zzj("Got multiple records for app config, expected one. appId", zzchm.zzjk(str));
                    }
                    if (query != null) {
                        query.close();
                    }
                    return blob;
                }
                if (query != null) {
                    query.close();
                }
                return null;
            } catch (SQLiteException e2) {
                e = e2;
                try {
                    zzawy().zzazd().zze("Error querying remote config. appId", zzchm.zzjk(str), e);
                    if (query != null) {
                        query.close();
                    }
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    if (query != null) {
                        query.close();
                    }
                    throw th;
                }
            }
        } catch (SQLiteException e3) {
            e = e3;
            query = null;
            zzawy().zzazd().zze("Error querying remote config. appId", zzchm.zzjk(str), e);
            if (query != null) {
                query.close();
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    final java.util.Map<java.lang.Integer, com.google.android.gms.internal.zzcmf> zzje(java.lang.String r12) {
        /*
        r11 = this;
        r11.zzxf();
        r11.zzve();
        com.google.android.gms.common.internal.zzbq.zzgm(r12);
        r0 = r11.getWritableDatabase();
        r8 = 0;
        r1 = "audience_filter_values";
        r2 = "audience_id";
        r3 = "current_results";
        r2 = new java.lang.String[]{r2, r3};	 Catch:{ SQLiteException -> 0x007c, all -> 0x0079 }
        r3 = "app_id=?";
        r9 = 1;
        r4 = new java.lang.String[r9];	 Catch:{ SQLiteException -> 0x007c, all -> 0x0079 }
        r10 = 0;
        r4[r10] = r12;	 Catch:{ SQLiteException -> 0x007c, all -> 0x0079 }
        r5 = 0;
        r6 = 0;
        r7 = 0;
        r0 = r0.query(r1, r2, r3, r4, r5, r6, r7);	 Catch:{ SQLiteException -> 0x007c, all -> 0x0079 }
        r1 = r0.moveToFirst();	 Catch:{ SQLiteException -> 0x0077 }
        if (r1 != 0) goto L_0x0033;
    L_0x002d:
        if (r0 == 0) goto L_0x0032;
    L_0x002f:
        r0.close();
    L_0x0032:
        return r8;
    L_0x0033:
        r1 = new android.support.v4.util.ArrayMap;	 Catch:{ SQLiteException -> 0x0077 }
        r1.<init>();	 Catch:{ SQLiteException -> 0x0077 }
    L_0x0038:
        r2 = r0.getInt(r10);	 Catch:{ SQLiteException -> 0x0077 }
        r3 = r0.getBlob(r9);	 Catch:{ SQLiteException -> 0x0077 }
        r4 = r3.length;	 Catch:{ SQLiteException -> 0x0077 }
        r3 = com.google.android.gms.internal.zzfjj.zzn(r3, r10, r4);	 Catch:{ SQLiteException -> 0x0077 }
        r4 = new com.google.android.gms.internal.zzcmf;	 Catch:{ SQLiteException -> 0x0077 }
        r4.<init>();	 Catch:{ SQLiteException -> 0x0077 }
        r4.zza(r3);	 Catch:{ IOException -> 0x0055 }
        r2 = java.lang.Integer.valueOf(r2);	 Catch:{ SQLiteException -> 0x0077 }
        r1.put(r2, r4);	 Catch:{ SQLiteException -> 0x0077 }
        goto L_0x006b;
    L_0x0055:
        r3 = move-exception;
        r4 = r11.zzawy();	 Catch:{ SQLiteException -> 0x0077 }
        r4 = r4.zzazd();	 Catch:{ SQLiteException -> 0x0077 }
        r5 = "Failed to merge filter results. appId, audienceId, error";
        r6 = com.google.android.gms.internal.zzchm.zzjk(r12);	 Catch:{ SQLiteException -> 0x0077 }
        r2 = java.lang.Integer.valueOf(r2);	 Catch:{ SQLiteException -> 0x0077 }
        r4.zzd(r5, r6, r2, r3);	 Catch:{ SQLiteException -> 0x0077 }
    L_0x006b:
        r2 = r0.moveToNext();	 Catch:{ SQLiteException -> 0x0077 }
        if (r2 != 0) goto L_0x0038;
    L_0x0071:
        if (r0 == 0) goto L_0x0076;
    L_0x0073:
        r0.close();
    L_0x0076:
        return r1;
    L_0x0077:
        r1 = move-exception;
        goto L_0x007e;
    L_0x0079:
        r12 = move-exception;
        r0 = r8;
        goto L_0x0096;
    L_0x007c:
        r1 = move-exception;
        r0 = r8;
    L_0x007e:
        r2 = r11.zzawy();	 Catch:{ all -> 0x0095 }
        r2 = r2.zzazd();	 Catch:{ all -> 0x0095 }
        r3 = "Database error querying filter results. appId";
        r12 = com.google.android.gms.internal.zzchm.zzjk(r12);	 Catch:{ all -> 0x0095 }
        r2.zze(r3, r12, r1);	 Catch:{ all -> 0x0095 }
        if (r0 == 0) goto L_0x0094;
    L_0x0091:
        r0.close();
    L_0x0094:
        return r8;
    L_0x0095:
        r12 = move-exception;
    L_0x0096:
        if (r0 == 0) goto L_0x009b;
    L_0x0098:
        r0.close();
    L_0x009b:
        throw r12;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzcgo.zzje(java.lang.String):java.util.Map<java.lang.Integer, com.google.android.gms.internal.zzcmf>");
    }

    public final long zzjf(String str) {
        zzbq.zzgm(str);
        return zza("select count(1) from events where app_id=? and name not like '!_%' escape '!'", new String[]{str}, 0);
    }

    @WorkerThread
    public final List<Pair<zzcme, Long>> zzl(String str, int i, int i2) {
        Cursor query;
        Object e;
        zzcho zzazd;
        String str2;
        Object zzjk;
        Object e2;
        Throwable th;
        zzve();
        zzxf();
        zzbq.checkArgument(i > 0);
        zzbq.checkArgument(i2 > 0);
        zzbq.zzgm(str);
        Cursor cursor = null;
        try {
            query = getWritableDatabase().query("queue", new String[]{"rowid", "data"}, "app_id=?", new String[]{str}, null, null, "rowid", String.valueOf(i));
            try {
                if (query.moveToFirst()) {
                    List<Pair<zzcme, Long>> arrayList = new ArrayList();
                    int i3 = 0;
                    do {
                        long j = query.getLong(0);
                        try {
                            byte[] zzr = zzawu().zzr(query.getBlob(1));
                            if (!arrayList.isEmpty() && zzr.length + i3 > i2) {
                                break;
                            }
                            zzfjj zzn = zzfjj.zzn(zzr, 0, zzr.length);
                            zzfjs com_google_android_gms_internal_zzcme = new zzcme();
                            try {
                                com_google_android_gms_internal_zzcme.zza(zzn);
                                i3 += zzr.length;
                                arrayList.add(Pair.create(com_google_android_gms_internal_zzcme, Long.valueOf(j)));
                            } catch (IOException e3) {
                                e = e3;
                                zzazd = zzawy().zzazd();
                                str2 = "Failed to merge queued bundle. appId";
                                zzjk = zzchm.zzjk(str);
                                zzazd.zze(str2, zzjk, e);
                                if (query.moveToNext()) {
                                    break;
                                } else if (i3 > i2) {
                                }
                                if (query != null) {
                                    query.close();
                                }
                                return arrayList;
                            }
                            if (query.moveToNext()) {
                                break;
                            }
                        } catch (IOException e4) {
                            e = e4;
                            zzazd = zzawy().zzazd();
                            str2 = "Failed to unzip queued bundle. appId";
                            zzjk = zzchm.zzjk(str);
                            zzazd.zze(str2, zzjk, e);
                            if (query.moveToNext()) {
                                break;
                            } else if (i3 > i2) {
                            }
                            if (query != null) {
                                query.close();
                            }
                            return arrayList;
                        }
                    } while (i3 > i2);
                    if (query != null) {
                        query.close();
                    }
                    return arrayList;
                }
                List<Pair<zzcme, Long>> emptyList = Collections.emptyList();
                if (query != null) {
                    query.close();
                }
                return emptyList;
            } catch (SQLiteException e5) {
                e2 = e5;
                cursor = query;
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (SQLiteException e6) {
            e2 = e6;
            try {
                zzawy().zzazd().zze("Error querying bundles. appId", zzchm.zzjk(str), e2);
                List<Pair<zzcme, Long>> emptyList2 = Collections.emptyList();
                if (cursor != null) {
                    cursor.close();
                }
                return emptyList2;
            } catch (Throwable th3) {
                th = th3;
                query = cursor;
                if (query != null) {
                    query.close();
                }
                throw th;
            }
        }
    }
}
