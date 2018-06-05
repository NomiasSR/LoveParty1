package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.annotation.WorkerThread;
import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.common.util.zzd;
import com.google.android.gms.measurement.AppMeasurement.ConditionalUserProperty;
import com.google.android.gms.measurement.AppMeasurement.EventInterceptor;
import com.google.android.gms.measurement.AppMeasurement.OnEventListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicReference;

public final class zzcjn extends zzcjl {
    protected zzckb zzjgx;
    private EventInterceptor zzjgy;
    private final Set<OnEventListener> zzjgz = new CopyOnWriteArraySet();
    private boolean zzjha;
    private final AtomicReference<String> zzjhb = new AtomicReference();

    protected zzcjn(zzcim com_google_android_gms_internal_zzcim) {
        super(com_google_android_gms_internal_zzcim);
    }

    private final void zza(ConditionalUserProperty conditionalUserProperty) {
        long currentTimeMillis = zzws().currentTimeMillis();
        zzbq.checkNotNull(conditionalUserProperty);
        zzbq.zzgm(conditionalUserProperty.mName);
        zzbq.zzgm(conditionalUserProperty.mOrigin);
        zzbq.checkNotNull(conditionalUserProperty.mValue);
        conditionalUserProperty.mCreationTimestamp = currentTimeMillis;
        String str = conditionalUserProperty.mName;
        Object obj = conditionalUserProperty.mValue;
        if (zzawu().zzkd(str) != 0) {
            zzawy().zzazd().zzj("Invalid conditional user property name", zzawt().zzjj(str));
        } else if (zzawu().zzl(str, obj) != 0) {
            zzawy().zzazd().zze("Invalid conditional user property value", zzawt().zzjj(str), obj);
        } else {
            Object zzm = zzawu().zzm(str, obj);
            if (zzm == null) {
                zzawy().zzazd().zze("Unable to normalize conditional user property value", zzawt().zzjj(str), obj);
                return;
            }
            conditionalUserProperty.mValue = zzm;
            long j = conditionalUserProperty.mTriggerTimeout;
            if (TextUtils.isEmpty(conditionalUserProperty.mTriggerEventName) || (j <= 15552000000L && j >= 1)) {
                j = conditionalUserProperty.mTimeToLive;
                if (j <= 15552000000L) {
                    if (j >= 1) {
                        zzawx().zzg(new zzcjp(this, conditionalUserProperty));
                        return;
                    }
                }
                zzawy().zzazd().zze("Invalid conditional user property time to live", zzawt().zzjj(str), Long.valueOf(j));
                return;
            }
            zzawy().zzazd().zze("Invalid conditional user property timeout", zzawt().zzjj(str), Long.valueOf(j));
        }
    }

    private final void zza(String str, String str2, long j, Bundle bundle, boolean z, boolean z2, boolean z3, String str3) {
        Bundle bundle2;
        Bundle bundle3 = bundle;
        if (bundle3 == null) {
            bundle2 = new Bundle();
        } else {
            Bundle bundle4 = new Bundle(bundle3);
            for (String str4 : bundle4.keySet()) {
                Object obj = bundle4.get(str4);
                if (obj instanceof Bundle) {
                    bundle4.putBundle(str4, new Bundle((Bundle) obj));
                } else {
                    int i = 0;
                    if (obj instanceof Parcelable[]) {
                        Parcelable[] parcelableArr = (Parcelable[]) obj;
                        while (i < parcelableArr.length) {
                            if (parcelableArr[i] instanceof Bundle) {
                                parcelableArr[i] = new Bundle((Bundle) parcelableArr[i]);
                            }
                            i++;
                        }
                    } else if (obj instanceof ArrayList) {
                        ArrayList arrayList = (ArrayList) obj;
                        while (i < arrayList.size()) {
                            Object obj2 = arrayList.get(i);
                            if (obj2 instanceof Bundle) {
                                arrayList.set(i, new Bundle((Bundle) obj2));
                            }
                            i++;
                        }
                    }
                }
            }
            bundle2 = bundle4;
        }
        zzawx().zzg(new zzcjv(this, str, str2, j, bundle2, z, z2, z3, str3));
    }

    private final void zza(String str, String str2, long j, Object obj) {
        zzawx().zzg(new zzcjw(this, str, str2, obj, j));
    }

    private final void zza(String str, String str2, Bundle bundle, boolean z, boolean z2, boolean z3, String str3) {
        zza(str, str2, zzws().currentTimeMillis(), bundle, true, z2, z3, null);
    }

    @WorkerThread
    private final void zza(String str, String str2, Object obj, long j) {
        zzbq.zzgm(str);
        zzbq.zzgm(str2);
        zzve();
        zzxf();
        if (!this.zziwf.isEnabled()) {
            zzawy().zzazi().log("User property not set since app measurement is disabled");
        } else if (this.zziwf.zzazv()) {
            zzawy().zzazi().zze("Setting user property (FE)", zzawt().zzjh(str2), obj);
            zzawp().zzb(new zzcln(str2, j, obj, str));
        }
    }

    private final void zza(String str, String str2, String str3, Bundle bundle) {
        long currentTimeMillis = zzws().currentTimeMillis();
        zzbq.zzgm(str2);
        ConditionalUserProperty conditionalUserProperty = new ConditionalUserProperty();
        conditionalUserProperty.mAppId = str;
        conditionalUserProperty.mName = str2;
        conditionalUserProperty.mCreationTimestamp = currentTimeMillis;
        if (str3 != null) {
            conditionalUserProperty.mExpiredEventName = str3;
            conditionalUserProperty.mExpiredEventParams = bundle;
        }
        zzawx().zzg(new zzcjq(this, conditionalUserProperty));
    }

    private final Map<String, Object> zzb(String str, String str2, String str3, boolean z) {
        zzcho zzazd;
        if (zzawx().zzazs()) {
            zzazd = zzawy().zzazd();
            str2 = "Cannot get user properties from analytics worker thread";
        } else {
            zzawx();
            if (zzcih.zzau()) {
                zzazd = zzawy().zzazd();
                str2 = "Cannot get user properties from main thread";
            } else {
                AtomicReference atomicReference = new AtomicReference();
                synchronized (atomicReference) {
                    this.zziwf.zzawx().zzg(new zzcjs(this, atomicReference, str, str2, str3, z));
                    try {
                        atomicReference.wait(5000);
                    } catch (InterruptedException e) {
                        zzawy().zzazf().zzj("Interrupted waiting for get user properties", e);
                    }
                }
                List<zzcln> list = (List) atomicReference.get();
                if (list == null) {
                    zzazd = zzawy().zzazf();
                    str2 = "Timed out waiting for get user properties";
                } else {
                    Map<String, Object> arrayMap = new ArrayMap(list.size());
                    for (zzcln com_google_android_gms_internal_zzcln : list) {
                        arrayMap.put(com_google_android_gms_internal_zzcln.name, com_google_android_gms_internal_zzcln.getValue());
                    }
                    return arrayMap;
                }
            }
        }
        zzazd.log(str2);
        return Collections.emptyMap();
    }

    @android.support.annotation.WorkerThread
    private final void zzb(com.google.android.gms.measurement.AppMeasurement.ConditionalUserProperty r22) {
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
        r21 = this;
        r0 = r22;
        r21.zzve();
        r21.zzxf();
        com.google.android.gms.common.internal.zzbq.checkNotNull(r22);
        r1 = r0.mName;
        com.google.android.gms.common.internal.zzbq.zzgm(r1);
        r1 = r0.mOrigin;
        com.google.android.gms.common.internal.zzbq.zzgm(r1);
        r1 = r0.mValue;
        com.google.android.gms.common.internal.zzbq.checkNotNull(r1);
        r1 = r21;
        r2 = r1.zziwf;
        r2 = r2.isEnabled();
        if (r2 != 0) goto L_0x0032;
    L_0x0024:
        r0 = r21.zzawy();
        r0 = r0.zzazi();
        r2 = "Conditional property not sent since Firebase Analytics is disabled";
        r0.log(r2);
        return;
    L_0x0032:
        r2 = new com.google.android.gms.internal.zzcln;
        r4 = r0.mName;
        r5 = r0.mTriggeredTimestamp;
        r7 = r0.mValue;
        r8 = r0.mOrigin;
        r3 = r2;
        r3.<init>(r4, r5, r7, r8);
        r9 = r21.zzawu();	 Catch:{ IllegalArgumentException -> 0x009c }
        r10 = r0.mTriggeredEventName;	 Catch:{ IllegalArgumentException -> 0x009c }
        r11 = r0.mTriggeredEventParams;	 Catch:{ IllegalArgumentException -> 0x009c }
        r12 = r0.mOrigin;	 Catch:{ IllegalArgumentException -> 0x009c }
        r13 = 0;	 Catch:{ IllegalArgumentException -> 0x009c }
        r15 = 1;	 Catch:{ IllegalArgumentException -> 0x009c }
        r16 = 0;	 Catch:{ IllegalArgumentException -> 0x009c }
        r14 = r9.zza(r10, r11, r12, r13, r15, r16);	 Catch:{ IllegalArgumentException -> 0x009c }
        r3 = r21.zzawu();	 Catch:{ IllegalArgumentException -> 0x009c }
        r4 = r0.mTimedOutEventName;	 Catch:{ IllegalArgumentException -> 0x009c }
        r5 = r0.mTimedOutEventParams;	 Catch:{ IllegalArgumentException -> 0x009c }
        r6 = r0.mOrigin;	 Catch:{ IllegalArgumentException -> 0x009c }
        r7 = 0;	 Catch:{ IllegalArgumentException -> 0x009c }
        r9 = 1;	 Catch:{ IllegalArgumentException -> 0x009c }
        r10 = 0;	 Catch:{ IllegalArgumentException -> 0x009c }
        r11 = r3.zza(r4, r5, r6, r7, r9, r10);	 Catch:{ IllegalArgumentException -> 0x009c }
        r3 = r21.zzawu();	 Catch:{ IllegalArgumentException -> 0x009c }
        r4 = r0.mExpiredEventName;	 Catch:{ IllegalArgumentException -> 0x009c }
        r5 = r0.mExpiredEventParams;	 Catch:{ IllegalArgumentException -> 0x009c }
        r6 = r0.mOrigin;	 Catch:{ IllegalArgumentException -> 0x009c }
        r7 = 0;	 Catch:{ IllegalArgumentException -> 0x009c }
        r9 = 1;	 Catch:{ IllegalArgumentException -> 0x009c }
        r10 = 0;	 Catch:{ IllegalArgumentException -> 0x009c }
        r17 = r3.zza(r4, r5, r6, r7, r9, r10);	 Catch:{ IllegalArgumentException -> 0x009c }
        r15 = new com.google.android.gms.internal.zzcgl;
        r4 = r0.mAppId;
        r5 = r0.mOrigin;
        r7 = r0.mCreationTimestamp;
        r10 = r0.mTriggerEventName;
        r12 = r0.mTriggerTimeout;
        r18 = r10;
        r9 = r0.mTimeToLive;
        r3 = r15;
        r6 = r2;
        r19 = r9;
        r0 = 0;
        r9 = r0;
        r10 = r18;
        r0 = r15;
        r15 = r19;
        r3.<init>(r4, r5, r6, r7, r9, r10, r11, r12, r14, r15, r17);
        r2 = r21.zzawp();
        r2.zzf(r0);
    L_0x009c:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzcjn.zzb(com.google.android.gms.measurement.AppMeasurement$ConditionalUserProperty):void");
    }

    @android.support.annotation.WorkerThread
    private final void zzb(java.lang.String r25, java.lang.String r26, long r27, android.os.Bundle r29, boolean r30, boolean r31, boolean r32, java.lang.String r33) {
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
        r24 = this;
        r1 = r24;
        r8 = r25;
        r9 = r26;
        com.google.android.gms.common.internal.zzbq.zzgm(r25);
        com.google.android.gms.common.internal.zzbq.zzgm(r26);
        com.google.android.gms.common.internal.zzbq.checkNotNull(r29);
        r24.zzve();
        r24.zzxf();
        r2 = r1.zziwf;
        r2 = r2.isEnabled();
        if (r2 != 0) goto L_0x002b;
    L_0x001d:
        r2 = r24.zzawy();
        r2 = r2.zzazi();
        r3 = "Event not sent since app measurement is disabled";
        r2.log(r3);
        return;
    L_0x002b:
        r2 = r1.zzjha;
        r10 = 0;
        r11 = 1;
        if (r2 != 0) goto L_0x006f;
    L_0x0031:
        r1.zzjha = r11;
        r2 = "com.google.android.gms.tagmanager.TagManagerService";	 Catch:{ ClassNotFoundException -> 0x0062 }
        r2 = java.lang.Class.forName(r2);	 Catch:{ ClassNotFoundException -> 0x0062 }
        r3 = "initialize";	 Catch:{ Exception -> 0x0052 }
        r4 = new java.lang.Class[r11];	 Catch:{ Exception -> 0x0052 }
        r5 = android.content.Context.class;	 Catch:{ Exception -> 0x0052 }
        r4[r10] = r5;	 Catch:{ Exception -> 0x0052 }
        r2 = r2.getDeclaredMethod(r3, r4);	 Catch:{ Exception -> 0x0052 }
        r3 = 0;	 Catch:{ Exception -> 0x0052 }
        r4 = new java.lang.Object[r11];	 Catch:{ Exception -> 0x0052 }
        r5 = r24.getContext();	 Catch:{ Exception -> 0x0052 }
        r4[r10] = r5;	 Catch:{ Exception -> 0x0052 }
        r2.invoke(r3, r4);	 Catch:{ Exception -> 0x0052 }
        goto L_0x006f;
    L_0x0052:
        r0 = move-exception;
        r2 = r0;
        r3 = r24.zzawy();	 Catch:{ ClassNotFoundException -> 0x0062 }
        r3 = r3.zzazf();	 Catch:{ ClassNotFoundException -> 0x0062 }
        r4 = "Failed to invoke Tag Manager's initialize() method";	 Catch:{ ClassNotFoundException -> 0x0062 }
        r3.zzj(r4, r2);	 Catch:{ ClassNotFoundException -> 0x0062 }
        goto L_0x006f;
    L_0x0062:
        r2 = r24.zzawy();
        r2 = r2.zzazh();
        r3 = "Tag Manager is not found and thus will not be used";
        r2.log(r3);
    L_0x006f:
        r2 = "am";
        r12 = r2.equals(r8);
        r2 = com.google.android.gms.internal.zzclq.zzki(r26);
        if (r30 == 0) goto L_0x00ad;
    L_0x007b:
        r3 = r1.zzjgy;
        if (r3 == 0) goto L_0x00ad;
    L_0x007f:
        if (r2 != 0) goto L_0x00ad;
    L_0x0081:
        if (r12 != 0) goto L_0x00ad;
    L_0x0083:
        r2 = r24.zzawy();
        r2 = r2.zzazi();
        r3 = "Passing event to registered event handler (FE)";
        r4 = r24.zzawt();
        r4 = r4.zzjh(r9);
        r5 = r24.zzawt();
        r13 = r29;
        r5 = r5.zzx(r13);
        r2.zze(r3, r4, r5);
        r2 = r1.zzjgy;
        r3 = r8;
        r4 = r9;
        r5 = r13;
        r6 = r27;
        r2.interceptEvent(r3, r4, r5, r6);
        return;
    L_0x00ad:
        r13 = r29;
        r2 = r1.zziwf;
        r2 = r2.zzazv();
        if (r2 != 0) goto L_0x00b8;
    L_0x00b7:
        return;
    L_0x00b8:
        r2 = r24.zzawu();
        r5 = r2.zzkb(r9);
        if (r5 == 0) goto L_0x00e0;
    L_0x00c2:
        r24.zzawu();
        r2 = 40;
        r7 = com.google.android.gms.internal.zzclq.zza(r9, r2, r11);
        if (r9 == 0) goto L_0x00d1;
    L_0x00cd:
        r10 = r26.length();
    L_0x00d1:
        r8 = r10;
        r2 = r1.zziwf;
        r3 = r2.zzawu();
        r6 = "_ev";
        r4 = r33;
        r3.zza(r4, r5, r6, r7, r8);
        return;
    L_0x00e0:
        r2 = "_o";
        r19 = java.util.Collections.singletonList(r2);
        r2 = r24.zzawu();
        r7 = 1;
        r3 = r9;
        r4 = r13;
        r5 = r19;
        r6 = r32;
        r2 = r2.zza(r3, r4, r5, r6, r7);
        r6 = new java.util.ArrayList;
        r6.<init>();
        r6.add(r2);
        r3 = r24.zzawu();
        r3 = r3.zzbaz();
        r3 = r3.nextLong();
        r5 = r2.keySet();
        r7 = r29.size();
        r7 = new java.lang.String[r7];
        r5 = r5.toArray(r7);
        r5 = (java.lang.String[]) r5;
        java.util.Arrays.sort(r5);
        r7 = r5.length;
        r14 = r10;
        r15 = r14;
    L_0x011f:
        if (r15 >= r7) goto L_0x01a1;
    L_0x0121:
        r13 = r5[r15];
        r10 = r2.get(r13);
        r24.zzawu();
        r10 = com.google.android.gms.internal.zzclq.zzaf(r10);
        if (r10 == 0) goto L_0x018c;
    L_0x0130:
        r11 = r10.length;
        r2.putInt(r13, r11);
        r20 = r5;
        r11 = 0;
    L_0x0137:
        r5 = r10.length;
        if (r11 >= r5) goto L_0x0181;
    L_0x013a:
        r5 = r10[r11];
        r16 = r24.zzawu();
        r17 = "_ep";
        r18 = 0;
        r21 = r7;
        r7 = r13;
        r13 = r16;
        r22 = r12;
        r12 = r14;
        r14 = r17;
        r23 = r15;
        r15 = r5;
        r16 = r19;
        r17 = r32;
        r5 = r13.zza(r14, r15, r16, r17, r18);
        r13 = "_en";
        r5.putString(r13, r9);
        r13 = "_eid";
        r5.putLong(r13, r3);
        r13 = "_gn";
        r5.putString(r13, r7);
        r13 = "_ll";
        r14 = r10.length;
        r5.putInt(r13, r14);
        r13 = "_i";
        r5.putInt(r13, r11);
        r6.add(r5);
        r11 = r11 + 1;
        r13 = r7;
        r14 = r12;
        r7 = r21;
        r12 = r22;
        r15 = r23;
        goto L_0x0137;
    L_0x0181:
        r21 = r7;
        r22 = r12;
        r12 = r14;
        r23 = r15;
        r5 = r10.length;
        r14 = r12 + r5;
        goto L_0x0195;
    L_0x018c:
        r20 = r5;
        r21 = r7;
        r22 = r12;
        r12 = r14;
        r23 = r15;
    L_0x0195:
        r15 = r23 + 1;
        r5 = r20;
        r7 = r21;
        r12 = r22;
        r10 = 0;
        r11 = 1;
        goto L_0x011f;
    L_0x01a1:
        r22 = r12;
        r12 = r14;
        if (r12 == 0) goto L_0x01b0;
    L_0x01a6:
        r5 = "_eid";
        r2.putLong(r5, r3);
        r3 = "_epc";
        r2.putInt(r3, r12);
    L_0x01b0:
        r3 = r24.zzawq();
        r10 = r3.zzbao();
        if (r10 == 0) goto L_0x01c5;
    L_0x01ba:
        r3 = "_sc";
        r2 = r2.containsKey(r3);
        if (r2 != 0) goto L_0x01c5;
    L_0x01c2:
        r2 = 1;
        r10.zzjib = r2;
    L_0x01c5:
        r11 = 0;
    L_0x01c6:
        r2 = r6.size();
        if (r11 >= r2) goto L_0x0255;
    L_0x01cc:
        r2 = r6.get(r11);
        r2 = (android.os.Bundle) r2;
        if (r11 == 0) goto L_0x01d6;
    L_0x01d4:
        r3 = 1;
        goto L_0x01d7;
    L_0x01d6:
        r3 = 0;
    L_0x01d7:
        if (r3 == 0) goto L_0x01dc;
    L_0x01d9:
        r3 = "_ep";
        goto L_0x01dd;
    L_0x01dc:
        r3 = r9;
    L_0x01dd:
        r4 = "_o";
        r2.putString(r4, r8);
        r4 = "_sc";
        r4 = r2.containsKey(r4);
        if (r4 != 0) goto L_0x01ed;
    L_0x01ea:
        com.google.android.gms.internal.zzckc.zza(r10, r2);
    L_0x01ed:
        if (r31 == 0) goto L_0x01f7;
    L_0x01ef:
        r4 = r24.zzawu();
        r2 = r4.zzy(r2);
    L_0x01f7:
        r13 = r2;
        r2 = r24.zzawy();
        r2 = r2.zzazi();
        r4 = "Logging event (FE)";
        r5 = r24.zzawt();
        r5 = r5.zzjh(r9);
        r7 = r24.zzawt();
        r7 = r7.zzx(r13);
        r2.zze(r4, r5, r7);
        r14 = new com.google.android.gms.internal.zzcha;
        r4 = new com.google.android.gms.internal.zzcgx;
        r4.<init>(r13);
        r2 = r14;
        r5 = r8;
        r15 = r6;
        r6 = r27;
        r2.<init>(r3, r4, r5, r6);
        r2 = r24.zzawp();
        r6 = r33;
        r2.zzc(r14, r6);
        if (r22 != 0) goto L_0x0250;
    L_0x022f:
        r2 = r1.zzjgz;
        r14 = r2.iterator();
    L_0x0235:
        r2 = r14.hasNext();
        if (r2 == 0) goto L_0x0250;
    L_0x023b:
        r2 = r14.next();
        r2 = (com.google.android.gms.measurement.AppMeasurement.OnEventListener) r2;
        r5 = new android.os.Bundle;
        r5.<init>(r13);
        r3 = r8;
        r4 = r9;
        r6 = r27;
        r2.onEvent(r3, r4, r5, r6);
        r6 = r33;
        goto L_0x0235;
    L_0x0250:
        r11 = r11 + 1;
        r6 = r15;
        goto L_0x01c6;
    L_0x0255:
        r2 = r24.zzawq();
        r2 = r2.zzbao();
        if (r2 == 0) goto L_0x026f;
    L_0x025f:
        r2 = "_ae";
        r2 = r2.equals(r9);
        if (r2 == 0) goto L_0x026f;
    L_0x0267:
        r2 = r24.zzaww();
        r3 = 1;
        r2.zzbs(r3);
    L_0x026f:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzcjn.zzb(java.lang.String, java.lang.String, long, android.os.Bundle, boolean, boolean, boolean, java.lang.String):void");
    }

    @WorkerThread
    private final void zzbp(boolean z) {
        zzve();
        zzxf();
        zzawy().zzazi().zzj("Setting app measurement enabled (FE)", Boolean.valueOf(z));
        zzawz().setMeasurementEnabled(z);
        zzawp().zzbaq();
    }

    @android.support.annotation.WorkerThread
    private final void zzc(com.google.android.gms.measurement.AppMeasurement.ConditionalUserProperty r23) {
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
        r22 = this;
        r0 = r23;
        r22.zzve();
        r22.zzxf();
        com.google.android.gms.common.internal.zzbq.checkNotNull(r23);
        r1 = r0.mName;
        com.google.android.gms.common.internal.zzbq.zzgm(r1);
        r1 = r22;
        r2 = r1.zziwf;
        r2 = r2.isEnabled();
        if (r2 != 0) goto L_0x0028;
    L_0x001a:
        r0 = r22.zzawy();
        r0 = r0.zzazi();
        r2 = "Conditional property not cleared since Firebase Analytics is disabled";
        r0.log(r2);
        return;
    L_0x0028:
        r2 = new com.google.android.gms.internal.zzcln;
        r4 = r0.mName;
        r5 = 0;
        r7 = 0;
        r8 = 0;
        r3 = r2;
        r3.<init>(r4, r5, r7, r8);
        r9 = r22.zzawu();	 Catch:{ IllegalArgumentException -> 0x006f }
        r10 = r0.mExpiredEventName;	 Catch:{ IllegalArgumentException -> 0x006f }
        r11 = r0.mExpiredEventParams;	 Catch:{ IllegalArgumentException -> 0x006f }
        r12 = r0.mOrigin;	 Catch:{ IllegalArgumentException -> 0x006f }
        r13 = r0.mCreationTimestamp;	 Catch:{ IllegalArgumentException -> 0x006f }
        r15 = 1;	 Catch:{ IllegalArgumentException -> 0x006f }
        r16 = 0;	 Catch:{ IllegalArgumentException -> 0x006f }
        r17 = r9.zza(r10, r11, r12, r13, r15, r16);	 Catch:{ IllegalArgumentException -> 0x006f }
        r15 = new com.google.android.gms.internal.zzcgl;
        r4 = r0.mAppId;
        r5 = r0.mOrigin;
        r7 = r0.mCreationTimestamp;
        r9 = r0.mActive;
        r10 = r0.mTriggerEventName;
        r12 = r0.mTriggerTimeout;
        r14 = 0;
        r18 = r12;
        r11 = r0.mTimeToLive;
        r3 = r15;
        r6 = r2;
        r20 = r11;
        r0 = 0;
        r11 = r0;
        r12 = r18;
        r0 = r15;
        r15 = r20;
        r3.<init>(r4, r5, r6, r7, r9, r10, r11, r12, r14, r15, r17);
        r2 = r22.zzawp();
        r2.zzf(r0);
    L_0x006f:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzcjn.zzc(com.google.android.gms.measurement.AppMeasurement$ConditionalUserProperty):void");
    }

    private final List<ConditionalUserProperty> zzk(String str, String str2, String str3) {
        zzcho zzazd;
        if (zzawx().zzazs()) {
            zzazd = zzawy().zzazd();
            str2 = "Cannot get conditional user properties from analytics worker thread";
        } else {
            zzawx();
            if (zzcih.zzau()) {
                zzazd = zzawy().zzazd();
                str2 = "Cannot get conditional user properties from main thread";
            } else {
                AtomicReference atomicReference = new AtomicReference();
                synchronized (atomicReference) {
                    this.zziwf.zzawx().zzg(new zzcjr(this, atomicReference, str, str2, str3));
                    try {
                        atomicReference.wait(5000);
                    } catch (InterruptedException e) {
                        zzawy().zzazf().zze("Interrupted waiting for get conditional user properties", str, e);
                    }
                }
                List<zzcgl> list = (List) atomicReference.get();
                if (list == null) {
                    zzawy().zzazf().zzj("Timed out waiting for get conditional user properties", str);
                    return Collections.emptyList();
                }
                List<ConditionalUserProperty> arrayList = new ArrayList(list.size());
                for (zzcgl com_google_android_gms_internal_zzcgl : list) {
                    ConditionalUserProperty conditionalUserProperty = new ConditionalUserProperty();
                    conditionalUserProperty.mAppId = str;
                    conditionalUserProperty.mOrigin = str2;
                    conditionalUserProperty.mCreationTimestamp = com_google_android_gms_internal_zzcgl.zziyh;
                    conditionalUserProperty.mName = com_google_android_gms_internal_zzcgl.zziyg.name;
                    conditionalUserProperty.mValue = com_google_android_gms_internal_zzcgl.zziyg.getValue();
                    conditionalUserProperty.mActive = com_google_android_gms_internal_zzcgl.zziyi;
                    conditionalUserProperty.mTriggerEventName = com_google_android_gms_internal_zzcgl.zziyj;
                    if (com_google_android_gms_internal_zzcgl.zziyk != null) {
                        conditionalUserProperty.mTimedOutEventName = com_google_android_gms_internal_zzcgl.zziyk.name;
                        if (com_google_android_gms_internal_zzcgl.zziyk.zzizt != null) {
                            conditionalUserProperty.mTimedOutEventParams = com_google_android_gms_internal_zzcgl.zziyk.zzizt.zzayx();
                        }
                    }
                    conditionalUserProperty.mTriggerTimeout = com_google_android_gms_internal_zzcgl.zziyl;
                    if (com_google_android_gms_internal_zzcgl.zziym != null) {
                        conditionalUserProperty.mTriggeredEventName = com_google_android_gms_internal_zzcgl.zziym.name;
                        if (com_google_android_gms_internal_zzcgl.zziym.zzizt != null) {
                            conditionalUserProperty.mTriggeredEventParams = com_google_android_gms_internal_zzcgl.zziym.zzizt.zzayx();
                        }
                    }
                    conditionalUserProperty.mTriggeredTimestamp = com_google_android_gms_internal_zzcgl.zziyg.zzjji;
                    conditionalUserProperty.mTimeToLive = com_google_android_gms_internal_zzcgl.zziyn;
                    if (com_google_android_gms_internal_zzcgl.zziyo != null) {
                        conditionalUserProperty.mExpiredEventName = com_google_android_gms_internal_zzcgl.zziyo.name;
                        if (com_google_android_gms_internal_zzcgl.zziyo.zzizt != null) {
                            conditionalUserProperty.mExpiredEventParams = com_google_android_gms_internal_zzcgl.zziyo.zzizt.zzayx();
                        }
                    }
                    arrayList.add(conditionalUserProperty);
                }
                return arrayList;
            }
        }
        zzazd.log(str2);
        return Collections.emptyList();
    }

    public final void clearConditionalUserProperty(String str, String str2, Bundle bundle) {
        zza(null, str, str2, bundle);
    }

    public final void clearConditionalUserPropertyAs(String str, String str2, String str3, Bundle bundle) {
        zzbq.zzgm(str);
        zzawi();
        zza(str, str2, str3, bundle);
    }

    public final Task<String> getAppInstanceId() {
        try {
            String zzazn = zzawz().zzazn();
            return zzazn != null ? Tasks.forResult(zzazn) : Tasks.call(zzawx().zzazt(), new zzcjy(this));
        } catch (Exception e) {
            zzawy().zzazf().log("Failed to schedule task for getAppInstanceId");
            return Tasks.forException(e);
        }
    }

    public final List<ConditionalUserProperty> getConditionalUserProperties(String str, String str2) {
        return zzk(null, str, str2);
    }

    public final List<ConditionalUserProperty> getConditionalUserPropertiesAs(String str, String str2, String str3) {
        zzbq.zzgm(str);
        zzawi();
        return zzk(str, str2, str3);
    }

    public final /* bridge */ /* synthetic */ Context getContext() {
        return super.getContext();
    }

    public final Map<String, Object> getUserProperties(String str, String str2, boolean z) {
        return zzb(null, str, str2, z);
    }

    public final Map<String, Object> getUserPropertiesAs(String str, String str2, String str3, boolean z) {
        zzbq.zzgm(str);
        zzawi();
        return zzb(str, str2, str3, z);
    }

    public final void registerOnMeasurementEventListener(OnEventListener onEventListener) {
        zzxf();
        zzbq.checkNotNull(onEventListener);
        if (!this.zzjgz.add(onEventListener)) {
            zzawy().zzazf().log("OnEventListener already registered");
        }
    }

    public final void resetAnalyticsData() {
        zzawx().zzg(new zzcka(this));
    }

    public final void setConditionalUserProperty(ConditionalUserProperty conditionalUserProperty) {
        zzbq.checkNotNull(conditionalUserProperty);
        ConditionalUserProperty conditionalUserProperty2 = new ConditionalUserProperty(conditionalUserProperty);
        if (!TextUtils.isEmpty(conditionalUserProperty2.mAppId)) {
            zzawy().zzazf().log("Package name should be null when calling setConditionalUserProperty");
        }
        conditionalUserProperty2.mAppId = null;
        zza(conditionalUserProperty2);
    }

    public final void setConditionalUserPropertyAs(ConditionalUserProperty conditionalUserProperty) {
        zzbq.checkNotNull(conditionalUserProperty);
        zzbq.zzgm(conditionalUserProperty.mAppId);
        zzawi();
        zza(new ConditionalUserProperty(conditionalUserProperty));
    }

    @WorkerThread
    public final void setEventInterceptor(EventInterceptor eventInterceptor) {
        zzve();
        zzxf();
        if (!(eventInterceptor == null || eventInterceptor == this.zzjgy)) {
            zzbq.zza(this.zzjgy == null, (Object) "EventInterceptor already set.");
        }
        this.zzjgy = eventInterceptor;
    }

    public final void setMeasurementEnabled(boolean z) {
        zzxf();
        zzawx().zzg(new zzcjo(this, z));
    }

    public final void setMinimumSessionDuration(long j) {
        zzawx().zzg(new zzcjt(this, j));
    }

    public final void setSessionTimeoutDuration(long j) {
        zzawx().zzg(new zzcju(this, j));
    }

    public final void unregisterOnMeasurementEventListener(OnEventListener onEventListener) {
        zzxf();
        zzbq.checkNotNull(onEventListener);
        if (!this.zzjgz.remove(onEventListener)) {
            zzawy().zzazf().log("OnEventListener had not been registered");
        }
    }

    public final void zza(String str, String str2, Bundle bundle, long j) {
        zza(str, str2, j, bundle, false, true, true, null);
    }

    public final void zza(String str, String str2, Bundle bundle, boolean z) {
        if (this.zzjgy != null) {
            if (!zzclq.zzki(str2)) {
                z = false;
                zza(str, str2, bundle, true, z, true, null);
            }
        }
        z = true;
        zza(str, str2, bundle, true, z, true, null);
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

    @Nullable
    public final String zzazn() {
        return (String) this.zzjhb.get();
    }

    public final void zzb(String str, String str2, Object obj) {
        zzbq.zzgm(str);
        long currentTimeMillis = zzws().currentTimeMillis();
        int zzkd = zzawu().zzkd(str2);
        int i = 0;
        if (zzkd != 0) {
            zzawu();
            str = zzclq.zza(str2, 24, true);
            if (str2 != null) {
                i = str2.length();
            }
            this.zziwf.zzawu().zza(zzkd, "_ev", str, i);
        } else if (obj != null) {
            zzkd = zzawu().zzl(str2, obj);
            if (zzkd != 0) {
                zzawu();
                str = zzclq.zza(str2, 24, true);
                if ((obj instanceof String) || (obj instanceof CharSequence)) {
                    i = String.valueOf(obj).length();
                }
                this.zziwf.zzawu().zza(zzkd, "_ev", str, i);
                return;
            }
            Object zzm = zzawu().zzm(str2, obj);
            if (zzm != null) {
                zza(str, str2, currentTimeMillis, zzm);
            }
        } else {
            zza(str, str2, currentTimeMillis, null);
        }
    }

    @android.support.annotation.Nullable
    final java.lang.String zzbd(long r4) {
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
        r0 = new java.util.concurrent.atomic.AtomicReference;
        r0.<init>();
        monitor-enter(r0);
        r1 = r3.zzawx();	 Catch:{ all -> 0x002d }
        r2 = new com.google.android.gms.internal.zzcjz;	 Catch:{ all -> 0x002d }
        r2.<init>(r3, r0);	 Catch:{ all -> 0x002d }
        r1.zzg(r2);	 Catch:{ all -> 0x002d }
        r0.wait(r4);	 Catch:{ InterruptedException -> 0x001d }
        monitor-exit(r0);	 Catch:{ all -> 0x002d }
        r4 = r0.get();
        r4 = (java.lang.String) r4;
        return r4;
    L_0x001d:
        r4 = r3.zzawy();	 Catch:{ all -> 0x002d }
        r4 = r4.zzazf();	 Catch:{ all -> 0x002d }
        r5 = "Interrupted waiting for app instance id";	 Catch:{ all -> 0x002d }
        r4.log(r5);	 Catch:{ all -> 0x002d }
        r4 = 0;	 Catch:{ all -> 0x002d }
        monitor-exit(r0);	 Catch:{ all -> 0x002d }
        return r4;	 Catch:{ all -> 0x002d }
    L_0x002d:
        r4 = move-exception;	 Catch:{ all -> 0x002d }
        monitor-exit(r0);	 Catch:{ all -> 0x002d }
        throw r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzcjn.zzbd(long):java.lang.String");
    }

    public final List<zzcln> zzbq(boolean z) {
        zzcho zzazd;
        String str;
        zzxf();
        zzawy().zzazi().log("Fetching user attributes (FE)");
        if (zzawx().zzazs()) {
            zzazd = zzawy().zzazd();
            str = "Cannot get all user properties from analytics worker thread";
        } else {
            zzawx();
            if (zzcih.zzau()) {
                zzazd = zzawy().zzazd();
                str = "Cannot get all user properties from main thread";
            } else {
                AtomicReference atomicReference = new AtomicReference();
                synchronized (atomicReference) {
                    this.zziwf.zzawx().zzg(new zzcjx(this, atomicReference, z));
                    try {
                        atomicReference.wait(5000);
                    } catch (InterruptedException e) {
                        zzawy().zzazf().zzj("Interrupted waiting for get user properties", e);
                    }
                }
                List<zzcln> list = (List) atomicReference.get();
                if (list != null) {
                    return list;
                }
                zzazd = zzawy().zzazf();
                str = "Timed out waiting for get user properties";
            }
        }
        zzazd.log(str);
        return Collections.emptyList();
    }

    public final void zzc(String str, String str2, Bundle bundle) {
        boolean z;
        if (this.zzjgy != null) {
            if (!zzclq.zzki(str2)) {
                z = false;
                zza(str, str2, bundle, true, z, false, null);
            }
        }
        z = true;
        zza(str, str2, bundle, true, z, false, null);
    }

    final void zzjp(@Nullable String str) {
        this.zzjhb.set(str);
    }

    public final /* bridge */ /* synthetic */ void zzve() {
        super.zzve();
    }

    public final /* bridge */ /* synthetic */ zzd zzws() {
        return super.zzws();
    }
}
