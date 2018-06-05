package com.google.firebase.database;

import android.support.annotation.Nullable;
import com.google.android.gms.internal.zzedk;
import com.google.android.gms.internal.zzefa;
import com.google.android.gms.internal.zzege;
import com.google.android.gms.internal.zzejg;
import com.google.android.gms.internal.zzeju;
import com.google.android.gms.internal.zzejw;
import com.google.android.gms.internal.zzekd;
import com.google.android.gms.internal.zzekg;
import com.google.android.gms.internal.zzekj;
import com.google.android.gms.internal.zzelv;
import com.google.android.gms.internal.zzelw;

public class MutableData {
    private final zzefa zzmko;
    private final zzedk zzmkp;

    private MutableData(zzefa com_google_android_gms_internal_zzefa, zzedk com_google_android_gms_internal_zzedk) {
        this.zzmko = com_google_android_gms_internal_zzefa;
        this.zzmkp = com_google_android_gms_internal_zzedk;
        zzege.zza(this.zzmkp, getValue());
    }

    MutableData(zzekd com_google_android_gms_internal_zzekd) {
        this(new zzefa(com_google_android_gms_internal_zzekd), new zzedk(""));
    }

    public MutableData child(String str) {
        zzelv.zzqh(str);
        return new MutableData(this.zzmko, this.zzmkp.zzh(new zzedk(str)));
    }

    public boolean equals(Object obj) {
        if (obj instanceof MutableData) {
            MutableData mutableData = (MutableData) obj;
            if (this.zzmko.equals(mutableData.zzmko) && this.zzmkp.equals(mutableData.zzmkp)) {
                return true;
            }
        }
        return false;
    }

    public Iterable<MutableData> getChildren() {
        zzekd zzbsv = zzbsv();
        if (!zzbsv.isEmpty()) {
            if (!zzbsv.zzbzu()) {
                return new zzk(this, zzejw.zzj(zzbsv).iterator());
            }
        }
        return new zzi(this);
    }

    public long getChildrenCount() {
        return (long) zzbsv().getChildCount();
    }

    public String getKey() {
        return this.zzmkp.zzbwk() != null ? this.zzmkp.zzbwk().asString() : null;
    }

    public Object getPriority() {
        return zzbsv().zzbzv().getValue();
    }

    @Nullable
    public Object getValue() {
        return zzbsv().getValue();
    }

    @Nullable
    public <T> T getValue(GenericTypeIndicator<T> genericTypeIndicator) {
        return zzelw.zza(zzbsv().getValue(), (GenericTypeIndicator) genericTypeIndicator);
    }

    @Nullable
    public <T> T getValue(Class<T> cls) {
        return zzelw.zza(zzbsv().getValue(), (Class) cls);
    }

    public boolean hasChild(String str) {
        return !zzbsv().zzan(new zzedk(str)).isEmpty();
    }

    public boolean hasChildren() {
        zzekd zzbsv = zzbsv();
        return (zzbsv.zzbzu() || zzbsv.isEmpty()) ? false : true;
    }

    public void setPriority(Object obj) {
        this.zzmko.zzg(this.zzmkp, zzbsv().zzf(zzekj.zzc(this.zzmkp, obj)));
    }

    public void setValue(Object obj) throws DatabaseException {
        zzege.zza(this.zzmkp, obj);
        obj = zzelw.zzbw(obj);
        zzelv.zzbv(obj);
        this.zzmko.zzg(this.zzmkp, zzekg.zza(obj, zzeju.zzcaf()));
    }

    public String toString() {
        zzejg zzbwh = this.zzmkp.zzbwh();
        String asString = zzbwh != null ? zzbwh.asString() : "<none>";
        String valueOf = String.valueOf(this.zzmko.zzbwr().getValue(true));
        StringBuilder stringBuilder = new StringBuilder((32 + String.valueOf(asString).length()) + String.valueOf(valueOf).length());
        stringBuilder.append("MutableData { key = ");
        stringBuilder.append(asString);
        stringBuilder.append(", value = ");
        stringBuilder.append(valueOf);
        stringBuilder.append(" }");
        return stringBuilder.toString();
    }

    final zzekd zzbsv() {
        return this.zzmko.zzp(this.zzmkp);
    }
}
