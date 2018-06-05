package com.google.android.gms.internal;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.DatabaseReference.CompletionListener;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Transaction;
import com.google.firebase.database.Transaction.Handler;
import com.google.firebase.database.Transaction.Result;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.zzh;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public final class zzedn implements zzebn {
    private final zzeeq zzmkj;
    private zzebm zzmqr;
    private final zzelp zzmsr = new zzelp(new zzelj(), 0);
    private zzefa zzmss;
    private zzefb zzmst;
    private zzehs<List<zzeeo>> zzmsu;
    private boolean zzmsv = false;
    private final zzeif zzmsw;
    private final zzedc zzmsx;
    private final zzejc zzmsy;
    private final zzejc zzmsz;
    private final zzejc zzmta;
    private long zzmtb = 0;
    private long zzmtc = 1;
    private zzefh zzmtd;
    private zzefh zzmte;
    private FirebaseDatabase zzmtf;
    private boolean zzmtg = false;
    private long zzmth = 0;

    zzedn(zzeeq com_google_android_gms_internal_zzeeq, zzedc com_google_android_gms_internal_zzedc, FirebaseDatabase firebaseDatabase) {
        this.zzmkj = com_google_android_gms_internal_zzeeq;
        this.zzmsx = com_google_android_gms_internal_zzedc;
        this.zzmtf = firebaseDatabase;
        this.zzmsy = this.zzmsx.zzpv("RepoOperation");
        this.zzmsz = this.zzmsx.zzpv("Transaction");
        this.zzmta = this.zzmsx.zzpv("DataOperation");
        this.zzmsw = new zzeif(this.zzmsx);
        zzo(new zzedo(this));
    }

    private final zzekd zza(zzedk com_google_android_gms_internal_zzedk, List<Long> list) {
        zzekd zzc = this.zzmte.zzc(com_google_android_gms_internal_zzedk, list);
        return zzc == null ? zzeju.zzcaf() : zzc;
    }

    private final void zza(long j, zzedk com_google_android_gms_internal_zzedk, DatabaseError databaseError) {
        if (databaseError == null || databaseError.getCode() != -25) {
            List zza = this.zzmte.zza(j, (databaseError == null ? 1 : 0) ^ 1, true, this.zzmsr);
            if (zza.size() > 0) {
                zzn(com_google_android_gms_internal_zzedk);
            }
            zzau(zza);
        }
    }

    private final void zza(zzehs<List<zzeeo>> com_google_android_gms_internal_zzehs_java_util_List_com_google_android_gms_internal_zzeeo) {
        if (((List) com_google_android_gms_internal_zzehs_java_util_List_com_google_android_gms_internal_zzeeo.getValue()) != null) {
            List<zzeeo> zzc = zzc((zzehs) com_google_android_gms_internal_zzehs_java_util_List_com_google_android_gms_internal_zzeeo);
            Boolean valueOf = Boolean.valueOf(true);
            for (zzeeo zzc2 : zzc) {
                if (zzc2.zzmuj != zzeep.zzmus) {
                    valueOf = Boolean.valueOf(false);
                    break;
                }
            }
            if (valueOf.booleanValue()) {
                zzedk zzbsy = com_google_android_gms_internal_zzehs_java_util_List_com_google_android_gms_internal_zzeeo.zzbsy();
                List arrayList = new ArrayList();
                for (zzeeo zzc22 : zzc) {
                    arrayList.add(Long.valueOf(zzc22.zzmun));
                }
                zzekd zza = zza(zzbsy, arrayList);
                String zzbzt = zza.zzbzt();
                for (zzeeo com_google_android_gms_internal_zzeeo : zzc) {
                    com_google_android_gms_internal_zzeeo.zzmuj = zzeep.zzmut;
                    com_google_android_gms_internal_zzeeo.retryCount = com_google_android_gms_internal_zzeeo.retryCount + 1;
                    zza = zza.zzl(zzedk.zza(zzbsy, com_google_android_gms_internal_zzeeo.zzmks), com_google_android_gms_internal_zzeeo.zzmup);
                }
                this.zzmqr.zza(zzbsy.zzbwg(), zza.getValue(true), zzbzt, new zzedv(this, zzbsy, zzc, this));
            }
            return;
        }
        if (com_google_android_gms_internal_zzehs_java_util_List_com_google_android_gms_internal_zzeeo.hasChildren()) {
            com_google_android_gms_internal_zzehs_java_util_List_com_google_android_gms_internal_zzeeo.zza(new zzedu(this));
        }
    }

    private final void zza(zzehs<List<zzeeo>> com_google_android_gms_internal_zzehs_java_util_List_com_google_android_gms_internal_zzeeo, int i) {
        zzedn com_google_android_gms_internal_zzedn = this;
        zzehs<List<zzeeo>> com_google_android_gms_internal_zzehs_java_util_List_com_google_android_gms_internal_zzeeo2 = com_google_android_gms_internal_zzehs_java_util_List_com_google_android_gms_internal_zzeeo;
        int i2 = i;
        List list = (List) com_google_android_gms_internal_zzehs_java_util_List_com_google_android_gms_internal_zzeeo.getValue();
        List arrayList = new ArrayList();
        if (list != null) {
            DatabaseError zzpg;
            List arrayList2 = new ArrayList();
            if (i2 == -9) {
                zzpg = DatabaseError.zzpg("overriddenBySet");
            } else {
                boolean z = i2 == -25;
                StringBuilder stringBuilder = new StringBuilder(45);
                stringBuilder.append("Unknown transaction abort reason: ");
                stringBuilder.append(i2);
                zzelt.zzb(z, stringBuilder.toString());
                zzpg = DatabaseError.zzgp(-25);
            }
            int i3 = -1;
            for (int i4 = 0; i4 < list.size(); i4++) {
                zzeeo com_google_android_gms_internal_zzeeo = (zzeeo) list.get(i4);
                if (com_google_android_gms_internal_zzeeo.zzmuj != zzeep.zzmuv) {
                    if (com_google_android_gms_internal_zzeeo.zzmuj == zzeep.zzmut) {
                        com_google_android_gms_internal_zzeeo.zzmuj = zzeep.zzmuv;
                        com_google_android_gms_internal_zzeeo.zzmum = zzpg;
                        i3 = i4;
                    } else {
                        zze(new zzegf(com_google_android_gms_internal_zzedn, com_google_android_gms_internal_zzeeo.zzmui, zzeik.zzam(com_google_android_gms_internal_zzeeo.zzmks)));
                        if (i2 == -9) {
                            arrayList.addAll(com_google_android_gms_internal_zzedn.zzmte.zza(com_google_android_gms_internal_zzeeo.zzmun, true, false, (zzeli) com_google_android_gms_internal_zzedn.zzmsr));
                        } else {
                            boolean z2 = i2 == -25;
                            StringBuilder stringBuilder2 = new StringBuilder(45);
                            stringBuilder2.append("Unknown transaction abort reason: ");
                            stringBuilder2.append(i2);
                            zzelt.zzb(z2, stringBuilder2.toString());
                        }
                        arrayList2.add(new zzeee(com_google_android_gms_internal_zzedn, com_google_android_gms_internal_zzeeo, zzpg));
                    }
                }
            }
            if (i3 == -1) {
                com_google_android_gms_internal_zzehs_java_util_List_com_google_android_gms_internal_zzeeo2.setValue(null);
                i2 = 0;
            } else {
                i2 = 0;
                com_google_android_gms_internal_zzehs_java_util_List_com_google_android_gms_internal_zzeeo2.setValue(list.subList(0, i3 + 1));
            }
            zzau(arrayList);
            ArrayList arrayList3 = (ArrayList) arrayList2;
            int size = arrayList3.size();
            while (i2 < size) {
                Object obj = arrayList3.get(i2);
                i2++;
                zzm((Runnable) obj);
            }
        }
    }

    private final void zza(zzejg com_google_android_gms_internal_zzejg, Object obj) {
        if (com_google_android_gms_internal_zzejg.equals(zzedb.zzmrz)) {
            this.zzmsr.zzby(((Long) obj).longValue());
        }
        zzedk com_google_android_gms_internal_zzedk = new zzedk(zzedb.zzmry, com_google_android_gms_internal_zzejg);
        try {
            zzekd zza = zzekg.zza(obj, zzeju.zzcaf());
            this.zzmss.zzg(com_google_android_gms_internal_zzedk, zza);
            zzau(this.zzmtd.zzi(com_google_android_gms_internal_zzedk, zza));
        } catch (Throwable e) {
            this.zzmsy.zzd("Failed to parse info update", e);
        }
    }

    private final void zza(String str, zzedk com_google_android_gms_internal_zzedk, DatabaseError databaseError) {
        if (databaseError != null && databaseError.getCode() != -1 && databaseError.getCode() != -25) {
            zzejc com_google_android_gms_internal_zzejc = this.zzmsy;
            String com_google_android_gms_internal_zzedk2 = com_google_android_gms_internal_zzedk.toString();
            String databaseError2 = databaseError.toString();
            StringBuilder stringBuilder = new StringBuilder(((13 + String.valueOf(str).length()) + String.valueOf(com_google_android_gms_internal_zzedk2).length()) + String.valueOf(databaseError2).length());
            stringBuilder.append(str);
            stringBuilder.append(" at ");
            stringBuilder.append(com_google_android_gms_internal_zzedk2);
            stringBuilder.append(" failed: ");
            stringBuilder.append(databaseError2);
            com_google_android_gms_internal_zzejc.zze(stringBuilder.toString(), null);
        }
    }

    private final void zza(List<zzeeo> list, zzehs<List<zzeeo>> com_google_android_gms_internal_zzehs_java_util_List_com_google_android_gms_internal_zzeeo) {
        List list2 = (List) com_google_android_gms_internal_zzehs_java_util_List_com_google_android_gms_internal_zzeeo.getValue();
        if (list2 != null) {
            list.addAll(list2);
        }
        com_google_android_gms_internal_zzehs_java_util_List_com_google_android_gms_internal_zzeeo.zza(new zzeeb(this, list));
    }

    private final void zzau(List<? extends zzeib> list) {
        if (!list.isEmpty()) {
            this.zzmsw.zzaw(list);
        }
    }

    private final zzedk zzb(zzedk com_google_android_gms_internal_zzedk, int i) {
        zzedk zzbsy = zzo(com_google_android_gms_internal_zzedk).zzbsy();
        if (this.zzmsz.zzbzl()) {
            zzejc com_google_android_gms_internal_zzejc = this.zzmsy;
            String valueOf = String.valueOf(com_google_android_gms_internal_zzedk);
            String valueOf2 = String.valueOf(zzbsy);
            StringBuilder stringBuilder = new StringBuilder((44 + String.valueOf(valueOf).length()) + String.valueOf(valueOf2).length());
            stringBuilder.append("Aborting transactions for path: ");
            stringBuilder.append(valueOf);
            stringBuilder.append(". Affected: ");
            stringBuilder.append(valueOf2);
            com_google_android_gms_internal_zzejc.zzb(stringBuilder.toString(), null, new Object[0]);
        }
        zzehs zzak = this.zzmsu.zzak(com_google_android_gms_internal_zzedk);
        zzak.zza(new zzeec(this, i), false);
        zza(zzak, i);
        zzak.zza(new zzeed(this, i), false, false);
        return zzbsy;
    }

    private final void zzb(zzehs<List<zzeeo>> com_google_android_gms_internal_zzehs_java_util_List_com_google_android_gms_internal_zzeeo) {
        Object obj = (List) com_google_android_gms_internal_zzehs_java_util_List_com_google_android_gms_internal_zzeeo.getValue();
        if (obj != null) {
            int i = 0;
            while (i < obj.size()) {
                if (((zzeeo) obj.get(i)).zzmuj == zzeep.zzmuu) {
                    obj.remove(i);
                } else {
                    i++;
                }
            }
            if (obj.size() <= 0) {
                obj = null;
            }
            com_google_android_gms_internal_zzehs_java_util_List_com_google_android_gms_internal_zzeeo.setValue(obj);
        }
        com_google_android_gms_internal_zzehs_java_util_List_com_google_android_gms_internal_zzeeo.zza(new zzedx(this));
    }

    private static DatabaseError zzbe(String str, String str2) {
        return str != null ? DatabaseError.zzbc(str, str2) : null;
    }

    private final void zzbwl() {
        this.zzmqr = this.zzmsx.zza(new zzebk(this.zzmkj.host, this.zzmkj.zzjrg, this.zzmkj.secure), this);
        this.zzmsx.zzmsd.zza(new zzeea(this));
        this.zzmqr.initialize();
        zzegy zzpw = this.zzmsx.zzpw(this.zzmkj.host);
        this.zzmss = new zzefa();
        this.zzmst = new zzefb();
        this.zzmsu = new zzehs();
        this.zzmtd = new zzefh(this.zzmsx, new zzegx(), new zzeef(this));
        this.zzmte = new zzefh(this.zzmsx, zzpw, new zzeeh(this));
        List<zzegd> zzbtb = zzpw.zzbtb();
        Map zza = zzeex.zza(this.zzmsr);
        long j = Long.MIN_VALUE;
        for (zzegd com_google_android_gms_internal_zzegd : zzbtb) {
            zzece com_google_android_gms_internal_zzeej = new zzeej(this, com_google_android_gms_internal_zzegd);
            if (j >= com_google_android_gms_internal_zzegd.zzbwy()) {
                throw new IllegalStateException("Write ids were not in order.");
            }
            j = com_google_android_gms_internal_zzegd.zzbwy();
            this.zzmtc = com_google_android_gms_internal_zzegd.zzbwy() + 1;
            zzejc com_google_android_gms_internal_zzejc;
            long zzbwy;
            StringBuilder stringBuilder;
            if (com_google_android_gms_internal_zzegd.zzbxb()) {
                if (this.zzmsy.zzbzl()) {
                    com_google_android_gms_internal_zzejc = this.zzmsy;
                    zzbwy = com_google_android_gms_internal_zzegd.zzbwy();
                    stringBuilder = new StringBuilder(48);
                    stringBuilder.append("Restoring overwrite with id ");
                    stringBuilder.append(zzbwy);
                    com_google_android_gms_internal_zzejc.zzb(stringBuilder.toString(), null, new Object[0]);
                }
                this.zzmqr.zza(com_google_android_gms_internal_zzegd.zzbsy().zzbwg(), com_google_android_gms_internal_zzegd.zzbwz().getValue(true), com_google_android_gms_internal_zzeej);
                this.zzmte.zza(com_google_android_gms_internal_zzegd.zzbsy(), com_google_android_gms_internal_zzegd.zzbwz(), zzeex.zza(com_google_android_gms_internal_zzegd.zzbwz(), zza), com_google_android_gms_internal_zzegd.zzbwy(), true, false);
            } else {
                if (this.zzmsy.zzbzl()) {
                    com_google_android_gms_internal_zzejc = this.zzmsy;
                    zzbwy = com_google_android_gms_internal_zzegd.zzbwy();
                    stringBuilder = new StringBuilder(44);
                    stringBuilder.append("Restoring merge with id ");
                    stringBuilder.append(zzbwy);
                    com_google_android_gms_internal_zzejc.zzb(stringBuilder.toString(), null, new Object[0]);
                }
                this.zzmqr.zza(com_google_android_gms_internal_zzegd.zzbsy().zzbwg(), com_google_android_gms_internal_zzegd.zzbxa().zzcn(true), com_google_android_gms_internal_zzeej);
                this.zzmte.zza(com_google_android_gms_internal_zzegd.zzbsy(), com_google_android_gms_internal_zzegd.zzbxa(), zzeex.zza(com_google_android_gms_internal_zzegd.zzbxa(), zza), com_google_android_gms_internal_zzegd.zzbwy(), false);
            }
        }
        zza(zzedb.zzmsa, Boolean.valueOf(false));
        zza(zzedb.zzmsb, Boolean.valueOf(false));
    }

    private final long zzbwp() {
        long j = this.zzmtc;
        this.zzmtc = 1 + j;
        return j;
    }

    private final void zzbwq() {
        zzehs com_google_android_gms_internal_zzehs = this.zzmsu;
        zzb(com_google_android_gms_internal_zzehs);
        zza(com_google_android_gms_internal_zzehs);
    }

    private final List<zzeeo> zzc(zzehs<List<zzeeo>> com_google_android_gms_internal_zzehs_java_util_List_com_google_android_gms_internal_zzeeo) {
        List arrayList = new ArrayList();
        zza(arrayList, (zzehs) com_google_android_gms_internal_zzehs_java_util_List_com_google_android_gms_internal_zzeeo);
        Collections.sort(arrayList);
        return arrayList;
    }

    private final zzedk zzn(zzedk com_google_android_gms_internal_zzedk) {
        zzehs zzo = zzo(com_google_android_gms_internal_zzedk);
        zzedk zzbsy = zzo.zzbsy();
        List<zzeeo> zzc = zzc(zzo);
        if (!zzc.isEmpty()) {
            int i;
            List arrayList = new ArrayList();
            List arrayList2 = new ArrayList();
            for (zzeeo zzb : zzc) {
                arrayList2.add(Long.valueOf(zzb.zzmun));
            }
            Iterator it = zzc.iterator();
            while (true) {
                i = 0;
                if (!it.hasNext()) {
                    break;
                }
                DataSnapshot zza;
                zzeeo com_google_android_gms_internal_zzeeo = (zzeeo) it.next();
                zzedk.zza(zzbsy, com_google_android_gms_internal_zzeeo.zzmks);
                List arrayList3 = new ArrayList();
                DatabaseError databaseError = null;
                int i2 = 1;
                if (com_google_android_gms_internal_zzeeo.zzmuj == zzeep.zzmuw) {
                    databaseError = com_google_android_gms_internal_zzeeo.zzmum;
                    if (databaseError.getCode() != -25) {
                    }
                    zzau(arrayList3);
                    if (i2 == 0) {
                        com_google_android_gms_internal_zzeeo.zzmuj = zzeep.zzmuu;
                        zza = zzh.zza(zzh.zza(r1, com_google_android_gms_internal_zzeeo.zzmks), zzejw.zzj(com_google_android_gms_internal_zzeeo.zzmuo));
                        zzo(new zzedy(r1, com_google_android_gms_internal_zzeeo));
                        arrayList.add(new zzedz(r1, com_google_android_gms_internal_zzeeo, databaseError, zza));
                    }
                } else {
                    if (com_google_android_gms_internal_zzeeo.zzmuj == zzeep.zzmus) {
                        if (com_google_android_gms_internal_zzeeo.retryCount >= 25) {
                            databaseError = DatabaseError.zzpg("maxretries");
                        } else {
                            Result doTransaction;
                            DatabaseError databaseError2;
                            zzekd zza2 = zza(com_google_android_gms_internal_zzeeo.zzmks, arrayList2);
                            com_google_android_gms_internal_zzeeo.zzmuo = zza2;
                            try {
                                doTransaction = com_google_android_gms_internal_zzeeo.zzmuh.doTransaction(zzh.zza(zza2));
                                databaseError2 = null;
                            } catch (Throwable th) {
                                DatabaseError fromException = DatabaseError.fromException(th);
                                databaseError2 = fromException;
                                doTransaction = Transaction.abort();
                            }
                            if (doTransaction.isSuccess()) {
                                Long valueOf = Long.valueOf(com_google_android_gms_internal_zzeeo.zzmun);
                                Map zza3 = zzeex.zza(r1.zzmsr);
                                zzekd zzbsv = doTransaction.zzbsv();
                                zza2 = zzeex.zza(zzbsv, zza3);
                                com_google_android_gms_internal_zzeeo.zzmup = zzbsv;
                                com_google_android_gms_internal_zzeeo.zzmuq = zza2;
                                com_google_android_gms_internal_zzeeo.zzmun = zzbwp();
                                arrayList2.remove(valueOf);
                                arrayList3.addAll(r1.zzmte.zza(com_google_android_gms_internal_zzeeo.zzmks, zzbsv, zza2, com_google_android_gms_internal_zzeeo.zzmun, com_google_android_gms_internal_zzeeo.zzmul, false));
                                arrayList3.addAll(r1.zzmte.zza(valueOf.longValue(), true, false, (zzeli) r1.zzmsr));
                            } else {
                                arrayList3.addAll(r1.zzmte.zza(com_google_android_gms_internal_zzeeo.zzmun, true, false, (zzeli) r1.zzmsr));
                                databaseError = databaseError2;
                                zzau(arrayList3);
                                if (i2 == 0) {
                                    com_google_android_gms_internal_zzeeo.zzmuj = zzeep.zzmuu;
                                    zza = zzh.zza(zzh.zza(r1, com_google_android_gms_internal_zzeeo.zzmks), zzejw.zzj(com_google_android_gms_internal_zzeeo.zzmuo));
                                    zzo(new zzedy(r1, com_google_android_gms_internal_zzeeo));
                                    arrayList.add(new zzedz(r1, com_google_android_gms_internal_zzeeo, databaseError, zza));
                                }
                            }
                        }
                    }
                    i2 = 0;
                    zzau(arrayList3);
                    if (i2 == 0) {
                        com_google_android_gms_internal_zzeeo.zzmuj = zzeep.zzmuu;
                        zza = zzh.zza(zzh.zza(r1, com_google_android_gms_internal_zzeeo.zzmks), zzejw.zzj(com_google_android_gms_internal_zzeeo.zzmuo));
                        zzo(new zzedy(r1, com_google_android_gms_internal_zzeeo));
                        arrayList.add(new zzedz(r1, com_google_android_gms_internal_zzeeo, databaseError, zza));
                    }
                }
                arrayList3.addAll(r1.zzmte.zza(com_google_android_gms_internal_zzeeo.zzmun, true, false, (zzeli) r1.zzmsr));
                zzau(arrayList3);
                if (i2 == 0) {
                    com_google_android_gms_internal_zzeeo.zzmuj = zzeep.zzmuu;
                    zza = zzh.zza(zzh.zza(r1, com_google_android_gms_internal_zzeeo.zzmks), zzejw.zzj(com_google_android_gms_internal_zzeeo.zzmuo));
                    zzo(new zzedy(r1, com_google_android_gms_internal_zzeeo));
                    arrayList.add(new zzedz(r1, com_google_android_gms_internal_zzeeo, databaseError, zza));
                }
            }
            zzb(r1.zzmsu);
            while (i < arrayList.size()) {
                zzm((Runnable) arrayList.get(i));
                i++;
            }
            zzbwq();
        }
        return zzbsy;
    }

    private final zzehs<List<zzeeo>> zzo(zzedk com_google_android_gms_internal_zzedk) {
        zzehs<List<zzeeo>> com_google_android_gms_internal_zzehs_java_util_List_com_google_android_gms_internal_zzeeo = this.zzmsu;
        while (!com_google_android_gms_internal_zzedk.isEmpty() && com_google_android_gms_internal_zzehs_java_util_List_com_google_android_gms_internal_zzeeo.getValue() == null) {
            com_google_android_gms_internal_zzehs_java_util_List_com_google_android_gms_internal_zzeeo = com_google_android_gms_internal_zzehs_java_util_List_com_google_android_gms_internal_zzeeo.zzak(new zzedk(com_google_android_gms_internal_zzedk.zzbwh()));
            com_google_android_gms_internal_zzedk = com_google_android_gms_internal_zzedk.zzbwi();
        }
        return com_google_android_gms_internal_zzehs_java_util_List_com_google_android_gms_internal_zzeeo;
    }

    public final FirebaseDatabase getDatabase() {
        return this.zzmtf;
    }

    final void interrupt() {
        this.zzmqr.interrupt("repo_interrupt");
    }

    public final void onDisconnect() {
        zza(zzedb.zzmsb, Boolean.valueOf(false));
        Map zza = zzeex.zza(this.zzmsr);
        zzefb com_google_android_gms_internal_zzefb = this.zzmst;
        zzefb com_google_android_gms_internal_zzefb2 = new zzefb();
        com_google_android_gms_internal_zzefb.zza(new zzedk(""), new zzeey(com_google_android_gms_internal_zzefb2, zza));
        List arrayList = new ArrayList();
        com_google_android_gms_internal_zzefb2.zza(zzedk.zzbwe(), new zzedr(this, arrayList));
        this.zzmst = new zzefb();
        zzau(arrayList);
    }

    public final void purgeOutstandingWrites() {
        if (this.zzmsy.zzbzl()) {
            this.zzmsy.zzb("Purging writes", null, new Object[0]);
        }
        zzau(this.zzmte.zzbwv());
        zzb(zzedk.zzbwe(), -25);
        this.zzmqr.purgeOutstandingWrites();
    }

    final void resume() {
        this.zzmqr.resume("repo_interrupt");
    }

    public final String toString() {
        return this.zzmkj.toString();
    }

    public final void zza(zzedk com_google_android_gms_internal_zzedk, zzecy com_google_android_gms_internal_zzecy, CompletionListener completionListener, Map<String, Object> map) {
        if (this.zzmsy.zzbzl()) {
            zzejc com_google_android_gms_internal_zzejc = this.zzmsy;
            String valueOf = String.valueOf(com_google_android_gms_internal_zzedk);
            StringBuilder stringBuilder = new StringBuilder(8 + String.valueOf(valueOf).length());
            stringBuilder.append("update: ");
            stringBuilder.append(valueOf);
            com_google_android_gms_internal_zzejc.zzb(stringBuilder.toString(), null, new Object[0]);
        }
        if (this.zzmta.zzbzl()) {
            com_google_android_gms_internal_zzejc = this.zzmta;
            valueOf = String.valueOf(com_google_android_gms_internal_zzedk);
            String valueOf2 = String.valueOf(map);
            StringBuilder stringBuilder2 = new StringBuilder((9 + String.valueOf(valueOf).length()) + String.valueOf(valueOf2).length());
            stringBuilder2.append("update: ");
            stringBuilder2.append(valueOf);
            stringBuilder2.append(" ");
            stringBuilder2.append(valueOf2);
            com_google_android_gms_internal_zzejc.zzb(stringBuilder2.toString(), null, new Object[0]);
        }
        if (com_google_android_gms_internal_zzecy.isEmpty()) {
            if (this.zzmsy.zzbzl()) {
                this.zzmsy.zzb("update called with no changes. No-op", null, new Object[0]);
            }
            zza(completionListener, null, com_google_android_gms_internal_zzedk);
            return;
        }
        zzecy zza = zzeex.zza(com_google_android_gms_internal_zzecy, zzeex.zza(this.zzmsr));
        long zzbwp = zzbwp();
        zzau(this.zzmte.zza(com_google_android_gms_internal_zzedk, com_google_android_gms_internal_zzecy, zza, zzbwp, true));
        this.zzmqr.zza(com_google_android_gms_internal_zzedk.zzbwg(), (Map) map, new zzeem(this, com_google_android_gms_internal_zzedk, zzbwp, completionListener));
        Iterator it = com_google_android_gms_internal_zzecy.iterator();
        while (it.hasNext()) {
            zzn(zzb(com_google_android_gms_internal_zzedk.zzh((zzedk) ((Entry) it.next()).getKey()), -9));
        }
    }

    public final void zza(zzedk com_google_android_gms_internal_zzedk, zzekd com_google_android_gms_internal_zzekd, CompletionListener completionListener) {
        if (this.zzmsy.zzbzl()) {
            zzejc com_google_android_gms_internal_zzejc = this.zzmsy;
            String valueOf = String.valueOf(com_google_android_gms_internal_zzedk);
            StringBuilder stringBuilder = new StringBuilder(5 + String.valueOf(valueOf).length());
            stringBuilder.append("set: ");
            stringBuilder.append(valueOf);
            com_google_android_gms_internal_zzejc.zzb(stringBuilder.toString(), null, new Object[0]);
        }
        if (this.zzmta.zzbzl()) {
            com_google_android_gms_internal_zzejc = this.zzmta;
            valueOf = String.valueOf(com_google_android_gms_internal_zzedk);
            String valueOf2 = String.valueOf(com_google_android_gms_internal_zzekd);
            StringBuilder stringBuilder2 = new StringBuilder((6 + String.valueOf(valueOf).length()) + String.valueOf(valueOf2).length());
            stringBuilder2.append("set: ");
            stringBuilder2.append(valueOf);
            stringBuilder2.append(" ");
            stringBuilder2.append(valueOf2);
            com_google_android_gms_internal_zzejc.zzb(stringBuilder2.toString(), null, new Object[0]);
        }
        zzekd zza = zzeex.zza(com_google_android_gms_internal_zzekd, zzeex.zza(this.zzmsr));
        long zzbwp = zzbwp();
        zzau(this.zzmte.zza(com_google_android_gms_internal_zzedk, com_google_android_gms_internal_zzekd, zza, zzbwp, true, true));
        this.zzmqr.zza(com_google_android_gms_internal_zzedk.zzbwg(), com_google_android_gms_internal_zzekd.getValue(true), new zzeel(this, com_google_android_gms_internal_zzedk, zzbwp, completionListener));
        zzn(zzb(com_google_android_gms_internal_zzedk, -9));
    }

    public final void zza(zzedk com_google_android_gms_internal_zzedk, CompletionListener completionListener) {
        this.zzmqr.zza(com_google_android_gms_internal_zzedk.zzbwg(), new zzedq(this, com_google_android_gms_internal_zzedk, completionListener));
    }

    public final void zza(zzedk com_google_android_gms_internal_zzedk, Handler handler, boolean z) {
        zzedk com_google_android_gms_internal_zzedk2 = com_google_android_gms_internal_zzedk;
        Handler handler2 = handler;
        if (this.zzmsy.zzbzl()) {
            zzejc com_google_android_gms_internal_zzejc = r1.zzmsy;
            String valueOf = String.valueOf(com_google_android_gms_internal_zzedk);
            StringBuilder stringBuilder = new StringBuilder(String.valueOf(valueOf).length() + 13);
            stringBuilder.append("transaction: ");
            stringBuilder.append(valueOf);
            com_google_android_gms_internal_zzejc.zzb(stringBuilder.toString(), null, new Object[0]);
        }
        if (r1.zzmta.zzbzl()) {
            com_google_android_gms_internal_zzejc = r1.zzmsy;
            valueOf = String.valueOf(com_google_android_gms_internal_zzedk);
            StringBuilder stringBuilder2 = new StringBuilder(13 + String.valueOf(valueOf).length());
            stringBuilder2.append("transaction: ");
            stringBuilder2.append(valueOf);
            com_google_android_gms_internal_zzejc.zzb(stringBuilder2.toString(), null, new Object[0]);
        }
        if (r1.zzmsx.zzmnr && !r1.zzmtg) {
            r1.zzmtg = true;
            r1.zzmsz.info("runTransaction() usage detected while persistence is enabled. Please be aware that transactions *will not* be persisted across database restarts.  See https://www.firebase.com/docs/android/guide/offline-capabilities.html#section-handling-transactions-offline for more details.");
        }
        DatabaseReference zza = zzh.zza(this, com_google_android_gms_internal_zzedk);
        ValueEventListener com_google_android_gms_internal_zzeds = new zzeds(r1);
        zzf(new zzegf(r1, com_google_android_gms_internal_zzeds, zza.zzbsz()));
        int i = zzeep.zzmur;
        long j = r1.zzmth;
        r1.zzmth = 1 + j;
        zzeeo com_google_android_gms_internal_zzeeo = new zzeeo(com_google_android_gms_internal_zzedk2, handler2, com_google_android_gms_internal_zzeds, i, z, j);
        zzekd zza2 = zza(com_google_android_gms_internal_zzedk2, new ArrayList());
        com_google_android_gms_internal_zzeeo.zzmuo = zza2;
        Result doTransaction;
        DatabaseError databaseError;
        try {
            doTransaction = handler2.doTransaction(zzh.zza(zza2));
            if (doTransaction == null) {
                throw new NullPointerException("Transaction returned null as result");
            }
            databaseError = null;
            if (doTransaction.isSuccess()) {
                com_google_android_gms_internal_zzeeo.zzmuj = zzeep.zzmus;
                zzehs zzak = r1.zzmsu.zzak(com_google_android_gms_internal_zzedk2);
                List list = (List) zzak.getValue();
                if (list == null) {
                    list = new ArrayList();
                }
                list.add(com_google_android_gms_internal_zzeeo);
                zzak.setValue(list);
                Map zza3 = zzeex.zza(r1.zzmsr);
                zzekd zzbsv = doTransaction.zzbsv();
                zzekd zza4 = zzeex.zza(zzbsv, zza3);
                com_google_android_gms_internal_zzeeo.zzmup = zzbsv;
                com_google_android_gms_internal_zzeeo.zzmuq = zza4;
                com_google_android_gms_internal_zzeeo.zzmun = zzbwp();
                zzau(r1.zzmte.zza(com_google_android_gms_internal_zzedk2, zzbsv, zza4, com_google_android_gms_internal_zzeeo.zzmun, z, false));
                zzbwq();
                return;
            }
            com_google_android_gms_internal_zzeeo.zzmup = null;
            com_google_android_gms_internal_zzeeo.zzmuq = null;
            zzm(new zzedt(r1, handler2, databaseError, zzh.zza(zza, zzejw.zzj(com_google_android_gms_internal_zzeeo.zzmuo))));
        } catch (Throwable th) {
            DatabaseError fromException = DatabaseError.fromException(th);
            databaseError = fromException;
            doTransaction = Transaction.abort();
        }
    }

    public final void zza(zzedk com_google_android_gms_internal_zzedk, Map<zzedk, zzekd> map, CompletionListener completionListener, Map<String, Object> map2) {
        this.zzmqr.zzb(com_google_android_gms_internal_zzedk.zzbwg(), (Map) map2, new zzedp(this, com_google_android_gms_internal_zzedk, map, completionListener));
    }

    public final void zza(zzeik com_google_android_gms_internal_zzeik, boolean z) {
        this.zzmte.zza(com_google_android_gms_internal_zzeik, z);
    }

    final void zza(CompletionListener completionListener, DatabaseError databaseError, zzedk com_google_android_gms_internal_zzedk) {
        if (completionListener != null) {
            zzejg zzbwk = com_google_android_gms_internal_zzedk.zzbwk();
            if (zzbwk != null && zzbwk.zzbzr()) {
                com_google_android_gms_internal_zzedk = com_google_android_gms_internal_zzedk.zzbwj();
            }
            zzm(new zzeek(this, completionListener, databaseError, zzh.zza(this, com_google_android_gms_internal_zzedk)));
        }
    }

    public final void zza(List<String> list, Object obj, boolean z, Long l) {
        List zza;
        zzedk com_google_android_gms_internal_zzedk = new zzedk((List) list);
        if (this.zzmsy.zzbzl()) {
            zzejc com_google_android_gms_internal_zzejc = this.zzmsy;
            String valueOf = String.valueOf(com_google_android_gms_internal_zzedk);
            StringBuilder stringBuilder = new StringBuilder(14 + String.valueOf(valueOf).length());
            stringBuilder.append("onDataUpdate: ");
            stringBuilder.append(valueOf);
            com_google_android_gms_internal_zzejc.zzb(stringBuilder.toString(), null, new Object[0]);
        }
        if (this.zzmta.zzbzl()) {
            com_google_android_gms_internal_zzejc = this.zzmsy;
            valueOf = String.valueOf(com_google_android_gms_internal_zzedk);
            String valueOf2 = String.valueOf(obj);
            StringBuilder stringBuilder2 = new StringBuilder((15 + String.valueOf(valueOf).length()) + String.valueOf(valueOf2).length());
            stringBuilder2.append("onDataUpdate: ");
            stringBuilder2.append(valueOf);
            stringBuilder2.append(" ");
            stringBuilder2.append(valueOf2);
            com_google_android_gms_internal_zzejc.zzb(stringBuilder2.toString(), null, new Object[0]);
        }
        this.zzmtb++;
        if (l != null) {
            try {
                zzega com_google_android_gms_internal_zzega = new zzega(l.longValue());
                if (z) {
                    Map hashMap = new HashMap();
                    for (Entry entry : ((Map) obj).entrySet()) {
                        hashMap.put(new zzedk((String) entry.getKey()), zzekg.zza(entry.getValue(), zzeju.zzcaf()));
                    }
                    zza = this.zzmte.zza(com_google_android_gms_internal_zzedk, hashMap, com_google_android_gms_internal_zzega);
                } else {
                    zza = this.zzmte.zza(com_google_android_gms_internal_zzedk, zzekg.zza(obj, zzeju.zzcaf()), com_google_android_gms_internal_zzega);
                }
            } catch (Throwable e) {
                this.zzmsy.zzd("FIREBASE INTERNAL ERROR", e);
                return;
            }
        } else if (z) {
            Map hashMap2 = new HashMap();
            for (Entry entry2 : ((Map) obj).entrySet()) {
                hashMap2.put(new zzedk((String) entry2.getKey()), zzekg.zza(entry2.getValue(), zzeju.zzcaf()));
            }
            zza = this.zzmte.zza(com_google_android_gms_internal_zzedk, hashMap2);
        } else {
            zza = this.zzmte.zzi(com_google_android_gms_internal_zzedk, zzekg.zza(obj, zzeju.zzcaf()));
        }
        if (zza.size() > 0) {
            zzn(com_google_android_gms_internal_zzedk);
        }
        zzau(zza);
    }

    public final void zza(List<String> list, List<zzecd> list2, Long l) {
        zzedk com_google_android_gms_internal_zzedk = new zzedk((List) list);
        if (this.zzmsy.zzbzl()) {
            zzejc com_google_android_gms_internal_zzejc = this.zzmsy;
            String valueOf = String.valueOf(com_google_android_gms_internal_zzedk);
            StringBuilder stringBuilder = new StringBuilder(20 + String.valueOf(valueOf).length());
            stringBuilder.append("onRangeMergeUpdate: ");
            stringBuilder.append(valueOf);
            com_google_android_gms_internal_zzejc.zzb(stringBuilder.toString(), null, new Object[0]);
        }
        if (this.zzmta.zzbzl()) {
            com_google_android_gms_internal_zzejc = this.zzmsy;
            valueOf = String.valueOf(com_google_android_gms_internal_zzedk);
            String valueOf2 = String.valueOf(list2);
            StringBuilder stringBuilder2 = new StringBuilder((21 + String.valueOf(valueOf).length()) + String.valueOf(valueOf2).length());
            stringBuilder2.append("onRangeMergeUpdate: ");
            stringBuilder2.append(valueOf);
            stringBuilder2.append(" ");
            stringBuilder2.append(valueOf2);
            com_google_android_gms_internal_zzejc.zzb(stringBuilder2.toString(), null, new Object[0]);
        }
        this.zzmtb++;
        List arrayList = new ArrayList(list2.size());
        for (zzecd com_google_android_gms_internal_zzekk : list2) {
            arrayList.add(new zzekk(com_google_android_gms_internal_zzekk));
        }
        arrayList = l != null ? this.zzmte.zza(com_google_android_gms_internal_zzedk, arrayList, new zzega(l.longValue())) : this.zzmte.zzb(com_google_android_gms_internal_zzedk, arrayList);
        if (arrayList.size() > 0) {
            zzn(com_google_android_gms_internal_zzedk);
        }
        zzau(arrayList);
    }

    public final void zzai(Map<String, Object> map) {
        for (Entry entry : map.entrySet()) {
            zza(zzejg.zzpz((String) entry.getKey()), entry.getValue());
        }
    }

    public final void zzb(zzedk com_google_android_gms_internal_zzedk, zzekd com_google_android_gms_internal_zzekd, CompletionListener completionListener) {
        this.zzmqr.zzb(com_google_android_gms_internal_zzedk.zzbwg(), com_google_android_gms_internal_zzekd.getValue(true), new zzeen(this, com_google_android_gms_internal_zzedk, com_google_android_gms_internal_zzekd, completionListener));
    }

    public final void zzbuk() {
        zza(zzedb.zzmsb, Boolean.valueOf(true));
    }

    public final zzeeq zzbwm() {
        return this.zzmkj;
    }

    public final long zzbwn() {
        return this.zzmsr.millis();
    }

    final boolean zzbwo() {
        if (this.zzmtd.isEmpty()) {
            if (this.zzmte.isEmpty()) {
                return false;
            }
        }
        return true;
    }

    public final void zzcl(boolean z) {
        zza(zzedb.zzmsa, Boolean.valueOf(z));
    }

    public final void zze(zzedh com_google_android_gms_internal_zzedh) {
        zzau((zzedb.zzmry.equals(com_google_android_gms_internal_zzedh.zzbvp().zzbsy().zzbwh()) ? this.zzmtd : this.zzmte).zzh(com_google_android_gms_internal_zzedh));
    }

    public final void zzf(zzedh com_google_android_gms_internal_zzedh) {
        zzejg zzbwh = com_google_android_gms_internal_zzedh.zzbvp().zzbsy().zzbwh();
        zzefh com_google_android_gms_internal_zzefh = (zzbwh == null || !zzbwh.equals(zzedb.zzmry)) ? this.zzmte : this.zzmtd;
        zzau(com_google_android_gms_internal_zzefh.zzg(com_google_android_gms_internal_zzedh));
    }

    public final void zzm(Runnable runnable) {
        this.zzmsx.zzbvw();
        this.zzmsx.zzmsc.zzm(runnable);
    }

    public final void zzo(Runnable runnable) {
        this.zzmsx.zzbvw();
        this.zzmsx.zzmse.zzo(runnable);
    }
}
