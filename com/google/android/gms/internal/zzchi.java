package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteFullException;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.support.annotation.WorkerThread;
import com.google.android.gms.common.util.zzd;

public final class zzchi extends zzcjl {
    private final zzchj zzjbn = new zzchj(this, getContext(), "google_app_measurement_local.db");
    private boolean zzjbo;

    zzchi(zzcim com_google_android_gms_internal_zzcim) {
        super(com_google_android_gms_internal_zzcim);
    }

    @WorkerThread
    private final SQLiteDatabase getWritableDatabase() {
        if (this.zzjbo) {
            return null;
        }
        SQLiteDatabase writableDatabase = this.zzjbn.getWritableDatabase();
        if (writableDatabase != null) {
            return writableDatabase;
        }
        this.zzjbo = true;
        return null;
    }

    @WorkerThread
    @TargetApi(11)
    private final boolean zzb(int i, byte[] bArr) {
        SQLiteDatabase writableDatabase;
        Object obj;
        Cursor cursor;
        SQLiteDatabase sQLiteDatabase;
        Throwable th;
        zzve();
        boolean z = false;
        if (this.zzjbo) {
            return false;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("type", Integer.valueOf(i));
        contentValues.put("entry", bArr);
        int i2 = 5;
        int i3 = 0;
        int i4 = 5;
        while (i3 < i2) {
            Cursor cursor2 = null;
            try {
                writableDatabase = getWritableDatabase();
                if (writableDatabase == null) {
                    try {
                        r1.zzjbo = true;
                        if (writableDatabase != null) {
                            writableDatabase.close();
                        }
                        return z;
                    } catch (SQLiteFullException e) {
                        obj = e;
                    } catch (SQLiteException e2) {
                        obj = e2;
                        cursor = null;
                        sQLiteDatabase = writableDatabase;
                        try {
                            if (VERSION.SDK_INT >= 11 || !(obj instanceof SQLiteDatabaseLockedException)) {
                                if (sQLiteDatabase != null && sQLiteDatabase.inTransaction()) {
                                    sQLiteDatabase.endTransaction();
                                }
                                zzawy().zzazd().zzj("Error writing entry to local database", obj);
                                r1.zzjbo = true;
                            } else {
                                SystemClock.sleep((long) i4);
                                i4 += 20;
                            }
                            if (cursor != null) {
                                cursor.close();
                            }
                            if (sQLiteDatabase == null) {
                                sQLiteDatabase.close();
                            }
                            i3++;
                            z = false;
                            i2 = 5;
                        } catch (Throwable th2) {
                            th = th2;
                            writableDatabase = sQLiteDatabase;
                        }
                    }
                } else {
                    writableDatabase.beginTransaction();
                    long j = 0;
                    cursor = writableDatabase.rawQuery("select count(1) from messages", null);
                    if (cursor != null) {
                        try {
                            if (cursor.moveToFirst()) {
                                j = cursor.getLong(z);
                            }
                        } catch (SQLiteFullException e3) {
                            obj = e3;
                            cursor2 = cursor;
                        } catch (SQLiteException e22) {
                            SQLiteException sQLiteException = e22;
                            sQLiteDatabase = writableDatabase;
                            if (VERSION.SDK_INT >= 11) {
                            }
                            sQLiteDatabase.endTransaction();
                            zzawy().zzazd().zzj("Error writing entry to local database", obj);
                            r1.zzjbo = true;
                            if (cursor != null) {
                                cursor.close();
                            }
                            if (sQLiteDatabase == null) {
                                sQLiteDatabase.close();
                            }
                            i3++;
                            z = false;
                            i2 = 5;
                        } catch (Throwable th22) {
                            th = th22;
                        }
                    }
                    if (j >= 100000) {
                        zzawy().zzazd().log("Data loss, local db full");
                        long j2 = (100000 - j) + 1;
                        j = (long) writableDatabase.delete("messages", "rowid in (select rowid from messages order by rowid asc limit ?)", new String[]{Long.toString(j2)});
                        if (j != j2) {
                            zzawy().zzazd().zzd("Different delete count than expected in local db. expected, received, difference", Long.valueOf(j2), Long.valueOf(j), Long.valueOf(j2 - j));
                        }
                    }
                    writableDatabase.insertOrThrow("messages", null, contentValues);
                    writableDatabase.setTransactionSuccessful();
                    writableDatabase.endTransaction();
                    if (cursor != null) {
                        cursor.close();
                    }
                    if (writableDatabase != null) {
                        writableDatabase.close();
                    }
                    return true;
                }
            } catch (SQLiteFullException e32) {
                obj = e32;
                writableDatabase = null;
                try {
                    zzawy().zzazd().zzj("Error writing entry to local database", obj);
                    r1.zzjbo = true;
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    if (writableDatabase != null) {
                        writableDatabase.close();
                    }
                    i3++;
                    z = false;
                    i2 = 5;
                } catch (Throwable th222) {
                    th = th222;
                    cursor = cursor2;
                }
            } catch (SQLiteException e222) {
                obj = e222;
                cursor = null;
                if (VERSION.SDK_INT >= 11) {
                }
                sQLiteDatabase.endTransaction();
                zzawy().zzazd().zzj("Error writing entry to local database", obj);
                r1.zzjbo = true;
                if (cursor != null) {
                    cursor.close();
                }
                if (sQLiteDatabase == null) {
                    sQLiteDatabase.close();
                }
                i3++;
                z = false;
                i2 = 5;
            } catch (Throwable th2222) {
                th = th2222;
                writableDatabase = null;
                cursor = writableDatabase;
            }
        }
        zzawy().zzazf().log("Failed to write entry to local database");
        return false;
        if (cursor != null) {
            cursor.close();
        }
        if (writableDatabase != null) {
            writableDatabase.close();
        }
        throw th;
    }

    public final /* bridge */ /* synthetic */ Context getContext() {
        return super.getContext();
    }

    @WorkerThread
    public final void resetAnalyticsData() {
        zzve();
        try {
            int delete = 0 + getWritableDatabase().delete("messages", null, null);
            if (delete > 0) {
                zzawy().zzazj().zzj("Reset local analytics data. records", Integer.valueOf(delete));
            }
        } catch (SQLiteException e) {
            zzawy().zzazd().zzj("Error resetting local analytics data. error", e);
        }
    }

    public final boolean zza(zzcha com_google_android_gms_internal_zzcha) {
        Parcel obtain = Parcel.obtain();
        com_google_android_gms_internal_zzcha.writeToParcel(obtain, 0);
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        if (marshall.length <= 131072) {
            return zzb(0, marshall);
        }
        zzawy().zzazf().log("Event is too long for local database. Sending event directly to service");
        return false;
    }

    public final boolean zza(zzcln com_google_android_gms_internal_zzcln) {
        Parcel obtain = Parcel.obtain();
        com_google_android_gms_internal_zzcln.writeToParcel(obtain, 0);
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        if (marshall.length <= 131072) {
            return zzb(1, marshall);
        }
        zzawy().zzazf().log("User property too long for local database. Sending directly to service");
        return false;
    }

    public final /* bridge */ /* synthetic */ void zzawi() {
        super.zzawi();
    }

    public final /* bridge */ /* synthetic */ void zzawj() {
        super.zzawj();
    }

    public final /* bridge */ /* synthetic */ zzcgd zzawk() {
        return super.zzawk();
    }

    public final /* bridge */ /* synthetic */ zzcgk zzawl() {
        return super.zzawl();
    }

    public final /* bridge */ /* synthetic */ zzcjn zzawm() {
        return super.zzawm();
    }

    public final /* bridge */ /* synthetic */ zzchh zzawn() {
        return super.zzawn();
    }

    public final /* bridge */ /* synthetic */ zzcgu zzawo() {
        return super.zzawo();
    }

    public final /* bridge */ /* synthetic */ zzckg zzawp() {
        return super.zzawp();
    }

    public final /* bridge */ /* synthetic */ zzckc zzawq() {
        return super.zzawq();
    }

    public final /* bridge */ /* synthetic */ zzchi zzawr() {
        return super.zzawr();
    }

    public final /* bridge */ /* synthetic */ zzcgo zzaws() {
        return super.zzaws();
    }

    public final /* bridge */ /* synthetic */ zzchk zzawt() {
        return super.zzawt();
    }

    public final /* bridge */ /* synthetic */ zzclq zzawu() {
        return super.zzawu();
    }

    public final /* bridge */ /* synthetic */ zzcig zzawv() {
        return super.zzawv();
    }

    public final /* bridge */ /* synthetic */ zzclf zzaww() {
        return super.zzaww();
    }

    public final /* bridge */ /* synthetic */ zzcih zzawx() {
        return super.zzawx();
    }

    public final /* bridge */ /* synthetic */ zzchm zzawy() {
        return super.zzawy();
    }

    public final /* bridge */ /* synthetic */ zzchx zzawz() {
        return super.zzawz();
    }

    public final /* bridge */ /* synthetic */ zzcgn zzaxa() {
        return super.zzaxa();
    }

    protected final boolean zzaxz() {
        return false;
    }

    public final boolean zzc(zzcgl com_google_android_gms_internal_zzcgl) {
        zzawu();
        byte[] zza = zzclq.zza((Parcelable) com_google_android_gms_internal_zzcgl);
        if (zza.length <= 131072) {
            return zzb(2, zza);
        }
        zzawy().zzazf().log("Conditional user property too long for local database. Sending directly to service");
        return false;
    }

    @android.annotation.TargetApi(11)
    public final java.util.List<com.google.android.gms.internal.zzbfm> zzeb(int r21) {
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
        r20 = this;
        r1 = r20;
        r20.zzve();
        r2 = r1.zzjbo;
        r3 = 0;
        if (r2 == 0) goto L_0x000b;
    L_0x000a:
        return r3;
    L_0x000b:
        r2 = new java.util.ArrayList;
        r2.<init>();
        r4 = r20.getContext();
        r5 = "google_app_measurement_local.db";
        r4 = r4.getDatabasePath(r5);
        r4 = r4.exists();
        if (r4 != 0) goto L_0x0021;
    L_0x0020:
        return r2;
    L_0x0021:
        r4 = 5;
        r5 = 0;
        r7 = r4;
        r6 = r5;
    L_0x0025:
        if (r6 >= r4) goto L_0x01f2;
    L_0x0027:
        r8 = 1;
        r15 = r20.getWritableDatabase();	 Catch:{ SQLiteFullException -> 0x01c4, SQLiteException -> 0x018a, all -> 0x0185 }
        if (r15 != 0) goto L_0x0045;
    L_0x002e:
        r1.zzjbo = r8;	 Catch:{ SQLiteFullException -> 0x0040, SQLiteException -> 0x003b, all -> 0x0036 }
        if (r15 == 0) goto L_0x0035;
    L_0x0032:
        r15.close();
    L_0x0035:
        return r3;
    L_0x0036:
        r0 = move-exception;
        r2 = r0;
        r9 = r3;
        goto L_0x01e6;
    L_0x003b:
        r0 = move-exception;
        r4 = r0;
        r9 = r3;
        goto L_0x018e;
    L_0x0040:
        r0 = move-exception;
        r4 = r0;
        r9 = r3;
        goto L_0x01c8;
    L_0x0045:
        r15.beginTransaction();	 Catch:{ SQLiteFullException -> 0x0180, SQLiteException -> 0x017b, all -> 0x0175 }
        r10 = "messages";	 Catch:{ SQLiteFullException -> 0x0180, SQLiteException -> 0x017b, all -> 0x0175 }
        r9 = "rowid";	 Catch:{ SQLiteFullException -> 0x0180, SQLiteException -> 0x017b, all -> 0x0175 }
        r11 = "type";	 Catch:{ SQLiteFullException -> 0x0180, SQLiteException -> 0x017b, all -> 0x0175 }
        r12 = "entry";	 Catch:{ SQLiteFullException -> 0x0180, SQLiteException -> 0x017b, all -> 0x0175 }
        r11 = new java.lang.String[]{r9, r11, r12};	 Catch:{ SQLiteFullException -> 0x0180, SQLiteException -> 0x017b, all -> 0x0175 }
        r12 = 0;	 Catch:{ SQLiteFullException -> 0x0180, SQLiteException -> 0x017b, all -> 0x0175 }
        r13 = 0;	 Catch:{ SQLiteFullException -> 0x0180, SQLiteException -> 0x017b, all -> 0x0175 }
        r14 = 0;	 Catch:{ SQLiteFullException -> 0x0180, SQLiteException -> 0x017b, all -> 0x0175 }
        r16 = 0;	 Catch:{ SQLiteFullException -> 0x0180, SQLiteException -> 0x017b, all -> 0x0175 }
        r17 = "rowid asc";	 Catch:{ SQLiteFullException -> 0x0180, SQLiteException -> 0x017b, all -> 0x0175 }
        r9 = 100;	 Catch:{ SQLiteFullException -> 0x0180, SQLiteException -> 0x017b, all -> 0x0175 }
        r18 = java.lang.Integer.toString(r9);	 Catch:{ SQLiteFullException -> 0x0180, SQLiteException -> 0x017b, all -> 0x0175 }
        r9 = r15;
        r4 = r15;
        r15 = r16;
        r16 = r17;
        r17 = r18;
        r9 = r9.query(r10, r11, r12, r13, r14, r15, r16, r17);	 Catch:{ SQLiteFullException -> 0x0171, SQLiteException -> 0x016d, all -> 0x016b }
        r10 = -1;
    L_0x006f:
        r12 = r9.moveToNext();	 Catch:{ SQLiteFullException -> 0x0169, SQLiteException -> 0x0167, all -> 0x0163 }
        if (r12 == 0) goto L_0x012f;	 Catch:{ SQLiteFullException -> 0x0169, SQLiteException -> 0x0167, all -> 0x0163 }
    L_0x0075:
        r10 = r9.getLong(r5);	 Catch:{ SQLiteFullException -> 0x0169, SQLiteException -> 0x0167, all -> 0x0163 }
        r12 = r9.getInt(r8);	 Catch:{ SQLiteFullException -> 0x0169, SQLiteException -> 0x0167, all -> 0x0163 }
        r13 = 2;	 Catch:{ SQLiteFullException -> 0x0169, SQLiteException -> 0x0167, all -> 0x0163 }
        r14 = r9.getBlob(r13);	 Catch:{ SQLiteFullException -> 0x0169, SQLiteException -> 0x0167, all -> 0x0163 }
        if (r12 != 0) goto L_0x00b8;	 Catch:{ SQLiteFullException -> 0x0169, SQLiteException -> 0x0167, all -> 0x0163 }
    L_0x0084:
        r12 = android.os.Parcel.obtain();	 Catch:{ SQLiteFullException -> 0x0169, SQLiteException -> 0x0167, all -> 0x0163 }
        r13 = r14.length;	 Catch:{ zzbfo -> 0x00a3 }
        r12.unmarshall(r14, r5, r13);	 Catch:{ zzbfo -> 0x00a3 }
        r12.setDataPosition(r5);	 Catch:{ zzbfo -> 0x00a3 }
        r13 = com.google.android.gms.internal.zzcha.CREATOR;	 Catch:{ zzbfo -> 0x00a3 }
        r13 = r13.createFromParcel(r12);	 Catch:{ zzbfo -> 0x00a3 }
        r13 = (com.google.android.gms.internal.zzcha) r13;	 Catch:{ zzbfo -> 0x00a3 }
        r12.recycle();	 Catch:{ SQLiteFullException -> 0x0169, SQLiteException -> 0x0167, all -> 0x0163 }
        if (r13 == 0) goto L_0x006f;	 Catch:{ SQLiteFullException -> 0x0169, SQLiteException -> 0x0167, all -> 0x0163 }
    L_0x009c:
        r2.add(r13);	 Catch:{ SQLiteFullException -> 0x0169, SQLiteException -> 0x0167, all -> 0x0163 }
        goto L_0x006f;
    L_0x00a0:
        r0 = move-exception;
        r10 = r0;
        goto L_0x00b4;
    L_0x00a3:
        r13 = r20.zzawy();	 Catch:{ all -> 0x00a0 }
        r13 = r13.zzazd();	 Catch:{ all -> 0x00a0 }
        r14 = "Failed to load event from local database";	 Catch:{ all -> 0x00a0 }
        r13.log(r14);	 Catch:{ all -> 0x00a0 }
        r12.recycle();	 Catch:{ SQLiteFullException -> 0x0169, SQLiteException -> 0x0167, all -> 0x0163 }
        goto L_0x006f;	 Catch:{ SQLiteFullException -> 0x0169, SQLiteException -> 0x0167, all -> 0x0163 }
    L_0x00b4:
        r12.recycle();	 Catch:{ SQLiteFullException -> 0x0169, SQLiteException -> 0x0167, all -> 0x0163 }
        throw r10;	 Catch:{ SQLiteFullException -> 0x0169, SQLiteException -> 0x0167, all -> 0x0163 }
    L_0x00b8:
        if (r12 != r8) goto L_0x00ec;	 Catch:{ SQLiteFullException -> 0x0169, SQLiteException -> 0x0167, all -> 0x0163 }
    L_0x00ba:
        r12 = android.os.Parcel.obtain();	 Catch:{ SQLiteFullException -> 0x0169, SQLiteException -> 0x0167, all -> 0x0163 }
        r13 = r14.length;	 Catch:{ zzbfo -> 0x00d4 }
        r12.unmarshall(r14, r5, r13);	 Catch:{ zzbfo -> 0x00d4 }
        r12.setDataPosition(r5);	 Catch:{ zzbfo -> 0x00d4 }
        r13 = com.google.android.gms.internal.zzcln.CREATOR;	 Catch:{ zzbfo -> 0x00d4 }
        r13 = r13.createFromParcel(r12);	 Catch:{ zzbfo -> 0x00d4 }
        r13 = (com.google.android.gms.internal.zzcln) r13;	 Catch:{ zzbfo -> 0x00d4 }
        r12.recycle();	 Catch:{ SQLiteFullException -> 0x0169, SQLiteException -> 0x0167, all -> 0x0163 }
        goto L_0x00e5;
    L_0x00d1:
        r0 = move-exception;
        r10 = r0;
        goto L_0x00e8;
    L_0x00d4:
        r13 = r20.zzawy();	 Catch:{ all -> 0x00d1 }
        r13 = r13.zzazd();	 Catch:{ all -> 0x00d1 }
        r14 = "Failed to load user property from local database";	 Catch:{ all -> 0x00d1 }
        r13.log(r14);	 Catch:{ all -> 0x00d1 }
        r12.recycle();	 Catch:{ SQLiteFullException -> 0x0169, SQLiteException -> 0x0167, all -> 0x0163 }
        r13 = r3;	 Catch:{ SQLiteFullException -> 0x0169, SQLiteException -> 0x0167, all -> 0x0163 }
    L_0x00e5:
        if (r13 == 0) goto L_0x006f;	 Catch:{ SQLiteFullException -> 0x0169, SQLiteException -> 0x0167, all -> 0x0163 }
    L_0x00e7:
        goto L_0x009c;	 Catch:{ SQLiteFullException -> 0x0169, SQLiteException -> 0x0167, all -> 0x0163 }
    L_0x00e8:
        r12.recycle();	 Catch:{ SQLiteFullException -> 0x0169, SQLiteException -> 0x0167, all -> 0x0163 }
        throw r10;	 Catch:{ SQLiteFullException -> 0x0169, SQLiteException -> 0x0167, all -> 0x0163 }
    L_0x00ec:
        if (r12 != r13) goto L_0x0120;	 Catch:{ SQLiteFullException -> 0x0169, SQLiteException -> 0x0167, all -> 0x0163 }
    L_0x00ee:
        r12 = android.os.Parcel.obtain();	 Catch:{ SQLiteFullException -> 0x0169, SQLiteException -> 0x0167, all -> 0x0163 }
        r13 = r14.length;	 Catch:{ zzbfo -> 0x0108 }
        r12.unmarshall(r14, r5, r13);	 Catch:{ zzbfo -> 0x0108 }
        r12.setDataPosition(r5);	 Catch:{ zzbfo -> 0x0108 }
        r13 = com.google.android.gms.internal.zzcgl.CREATOR;	 Catch:{ zzbfo -> 0x0108 }
        r13 = r13.createFromParcel(r12);	 Catch:{ zzbfo -> 0x0108 }
        r13 = (com.google.android.gms.internal.zzcgl) r13;	 Catch:{ zzbfo -> 0x0108 }
        r12.recycle();	 Catch:{ SQLiteFullException -> 0x0169, SQLiteException -> 0x0167, all -> 0x0163 }
        goto L_0x0119;
    L_0x0105:
        r0 = move-exception;
        r10 = r0;
        goto L_0x011c;
    L_0x0108:
        r13 = r20.zzawy();	 Catch:{ all -> 0x0105 }
        r13 = r13.zzazd();	 Catch:{ all -> 0x0105 }
        r14 = "Failed to load user property from local database";	 Catch:{ all -> 0x0105 }
        r13.log(r14);	 Catch:{ all -> 0x0105 }
        r12.recycle();	 Catch:{ SQLiteFullException -> 0x0169, SQLiteException -> 0x0167, all -> 0x0163 }
        r13 = r3;	 Catch:{ SQLiteFullException -> 0x0169, SQLiteException -> 0x0167, all -> 0x0163 }
    L_0x0119:
        if (r13 == 0) goto L_0x006f;	 Catch:{ SQLiteFullException -> 0x0169, SQLiteException -> 0x0167, all -> 0x0163 }
    L_0x011b:
        goto L_0x009c;	 Catch:{ SQLiteFullException -> 0x0169, SQLiteException -> 0x0167, all -> 0x0163 }
    L_0x011c:
        r12.recycle();	 Catch:{ SQLiteFullException -> 0x0169, SQLiteException -> 0x0167, all -> 0x0163 }
        throw r10;	 Catch:{ SQLiteFullException -> 0x0169, SQLiteException -> 0x0167, all -> 0x0163 }
    L_0x0120:
        r12 = r20.zzawy();	 Catch:{ SQLiteFullException -> 0x0169, SQLiteException -> 0x0167, all -> 0x0163 }
        r12 = r12.zzazd();	 Catch:{ SQLiteFullException -> 0x0169, SQLiteException -> 0x0167, all -> 0x0163 }
        r13 = "Unknown record type in local database";	 Catch:{ SQLiteFullException -> 0x0169, SQLiteException -> 0x0167, all -> 0x0163 }
        r12.log(r13);	 Catch:{ SQLiteFullException -> 0x0169, SQLiteException -> 0x0167, all -> 0x0163 }
        goto L_0x006f;	 Catch:{ SQLiteFullException -> 0x0169, SQLiteException -> 0x0167, all -> 0x0163 }
    L_0x012f:
        r12 = "messages";	 Catch:{ SQLiteFullException -> 0x0169, SQLiteException -> 0x0167, all -> 0x0163 }
        r13 = "rowid <= ?";	 Catch:{ SQLiteFullException -> 0x0169, SQLiteException -> 0x0167, all -> 0x0163 }
        r14 = new java.lang.String[r8];	 Catch:{ SQLiteFullException -> 0x0169, SQLiteException -> 0x0167, all -> 0x0163 }
        r10 = java.lang.Long.toString(r10);	 Catch:{ SQLiteFullException -> 0x0169, SQLiteException -> 0x0167, all -> 0x0163 }
        r14[r5] = r10;	 Catch:{ SQLiteFullException -> 0x0169, SQLiteException -> 0x0167, all -> 0x0163 }
        r10 = r4.delete(r12, r13, r14);	 Catch:{ SQLiteFullException -> 0x0169, SQLiteException -> 0x0167, all -> 0x0163 }
        r11 = r2.size();	 Catch:{ SQLiteFullException -> 0x0169, SQLiteException -> 0x0167, all -> 0x0163 }
        if (r10 >= r11) goto L_0x0152;	 Catch:{ SQLiteFullException -> 0x0169, SQLiteException -> 0x0167, all -> 0x0163 }
    L_0x0145:
        r10 = r20.zzawy();	 Catch:{ SQLiteFullException -> 0x0169, SQLiteException -> 0x0167, all -> 0x0163 }
        r10 = r10.zzazd();	 Catch:{ SQLiteFullException -> 0x0169, SQLiteException -> 0x0167, all -> 0x0163 }
        r11 = "Fewer entries removed from local database than expected";	 Catch:{ SQLiteFullException -> 0x0169, SQLiteException -> 0x0167, all -> 0x0163 }
        r10.log(r11);	 Catch:{ SQLiteFullException -> 0x0169, SQLiteException -> 0x0167, all -> 0x0163 }
    L_0x0152:
        r4.setTransactionSuccessful();	 Catch:{ SQLiteFullException -> 0x0169, SQLiteException -> 0x0167, all -> 0x0163 }
        r4.endTransaction();	 Catch:{ SQLiteFullException -> 0x0169, SQLiteException -> 0x0167, all -> 0x0163 }
        if (r9 == 0) goto L_0x015d;
    L_0x015a:
        r9.close();
    L_0x015d:
        if (r4 == 0) goto L_0x0162;
    L_0x015f:
        r4.close();
    L_0x0162:
        return r2;
    L_0x0163:
        r0 = move-exception;
        r2 = r0;
        goto L_0x01e7;
    L_0x0167:
        r0 = move-exception;
        goto L_0x016f;
    L_0x0169:
        r0 = move-exception;
        goto L_0x0173;
    L_0x016b:
        r0 = move-exception;
        goto L_0x0177;
    L_0x016d:
        r0 = move-exception;
        r9 = r3;
    L_0x016f:
        r15 = r4;
        goto L_0x017e;
    L_0x0171:
        r0 = move-exception;
        r9 = r3;
    L_0x0173:
        r15 = r4;
        goto L_0x0183;
    L_0x0175:
        r0 = move-exception;
        r4 = r15;
    L_0x0177:
        r2 = r0;
        r9 = r3;
        goto L_0x01e7;
    L_0x017b:
        r0 = move-exception;
        r4 = r15;
        r9 = r3;
    L_0x017e:
        r4 = r0;
        goto L_0x018e;
    L_0x0180:
        r0 = move-exception;
        r4 = r15;
        r9 = r3;
    L_0x0183:
        r4 = r0;
        goto L_0x01c8;
    L_0x0185:
        r0 = move-exception;
        r2 = r0;
        r4 = r3;
        r9 = r4;
        goto L_0x01e7;
    L_0x018a:
        r0 = move-exception;
        r4 = r0;
        r9 = r3;
        r15 = r9;
    L_0x018e:
        r10 = android.os.Build.VERSION.SDK_INT;	 Catch:{ all -> 0x01e4 }
        r11 = 11;	 Catch:{ all -> 0x01e4 }
        if (r10 < r11) goto L_0x019f;	 Catch:{ all -> 0x01e4 }
    L_0x0194:
        r10 = r4 instanceof android.database.sqlite.SQLiteDatabaseLockedException;	 Catch:{ all -> 0x01e4 }
        if (r10 == 0) goto L_0x019f;	 Catch:{ all -> 0x01e4 }
    L_0x0198:
        r10 = (long) r7;	 Catch:{ all -> 0x01e4 }
        android.os.SystemClock.sleep(r10);	 Catch:{ all -> 0x01e4 }
        r7 = r7 + 20;	 Catch:{ all -> 0x01e4 }
        goto L_0x01b9;	 Catch:{ all -> 0x01e4 }
    L_0x019f:
        if (r15 == 0) goto L_0x01aa;	 Catch:{ all -> 0x01e4 }
    L_0x01a1:
        r10 = r15.inTransaction();	 Catch:{ all -> 0x01e4 }
        if (r10 == 0) goto L_0x01aa;	 Catch:{ all -> 0x01e4 }
    L_0x01a7:
        r15.endTransaction();	 Catch:{ all -> 0x01e4 }
    L_0x01aa:
        r10 = r20.zzawy();	 Catch:{ all -> 0x01e4 }
        r10 = r10.zzazd();	 Catch:{ all -> 0x01e4 }
        r11 = "Error reading entries from local database";	 Catch:{ all -> 0x01e4 }
        r10.zzj(r11, r4);	 Catch:{ all -> 0x01e4 }
        r1.zzjbo = r8;	 Catch:{ all -> 0x01e4 }
    L_0x01b9:
        if (r9 == 0) goto L_0x01be;
    L_0x01bb:
        r9.close();
    L_0x01be:
        if (r15 == 0) goto L_0x01df;
    L_0x01c0:
        r15.close();
        goto L_0x01df;
    L_0x01c4:
        r0 = move-exception;
        r4 = r0;
        r9 = r3;
        r15 = r9;
    L_0x01c8:
        r10 = r20.zzawy();	 Catch:{ all -> 0x01e4 }
        r10 = r10.zzazd();	 Catch:{ all -> 0x01e4 }
        r11 = "Error reading entries from local database";	 Catch:{ all -> 0x01e4 }
        r10.zzj(r11, r4);	 Catch:{ all -> 0x01e4 }
        r1.zzjbo = r8;	 Catch:{ all -> 0x01e4 }
        if (r9 == 0) goto L_0x01dc;
    L_0x01d9:
        r9.close();
    L_0x01dc:
        if (r15 == 0) goto L_0x01df;
    L_0x01de:
        goto L_0x01c0;
    L_0x01df:
        r6 = r6 + 1;
        r4 = 5;
        goto L_0x0025;
    L_0x01e4:
        r0 = move-exception;
        r2 = r0;
    L_0x01e6:
        r4 = r15;
    L_0x01e7:
        if (r9 == 0) goto L_0x01ec;
    L_0x01e9:
        r9.close();
    L_0x01ec:
        if (r4 == 0) goto L_0x01f1;
    L_0x01ee:
        r4.close();
    L_0x01f1:
        throw r2;
    L_0x01f2:
        r2 = r20.zzawy();
        r2 = r2.zzazf();
        r4 = "Failed to read events from database in reasonable time";
        r2.log(r4);
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzchi.zzeb(int):java.util.List<com.google.android.gms.internal.zzbfm>");
    }

    public final /* bridge */ /* synthetic */ void zzve() {
        super.zzve();
    }

    public final /* bridge */ /* synthetic */ zzd zzws() {
        return super.zzws();
    }
}
