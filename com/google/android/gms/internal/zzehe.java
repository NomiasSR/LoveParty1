package com.google.android.gms.internal;

public final class zzehe {
    public final boolean complete;
    public final long id;
    public final boolean zziyi;
    public final zzeik zzmyn;
    public final long zzmyo;

    public zzehe(long j, zzeik com_google_android_gms_internal_zzeik, long j2, boolean z, boolean z2) {
        this.id = j;
        if (!com_google_android_gms_internal_zzeik.zzbyv() || com_google_android_gms_internal_zzeik.isDefault()) {
            this.zzmyn = com_google_android_gms_internal_zzeik;
            this.zzmyo = j2;
            this.complete = z;
            this.zziyi = z2;
            return;
        }
        throw new IllegalArgumentException("Can't create TrackedQuery for a non-default query that loads all data");
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        zzehe com_google_android_gms_internal_zzehe = (zzehe) obj;
        return this.id == com_google_android_gms_internal_zzehe.id && this.zzmyn.equals(com_google_android_gms_internal_zzehe.zzmyn) && this.zzmyo == com_google_android_gms_internal_zzehe.zzmyo && this.complete == com_google_android_gms_internal_zzehe.complete && this.zziyi == com_google_android_gms_internal_zzehe.zziyi;
    }

    public final int hashCode() {
        return (((((((Long.valueOf(this.id).hashCode() * 31) + this.zzmyn.hashCode()) * 31) + Long.valueOf(this.zzmyo).hashCode()) * 31) + Boolean.valueOf(this.complete).hashCode()) * 31) + Boolean.valueOf(this.zziyi).hashCode();
    }

    public final String toString() {
        long j = this.id;
        String valueOf = String.valueOf(this.zzmyn);
        long j2 = this.zzmyo;
        boolean z = this.complete;
        boolean z2 = this.zziyi;
        StringBuilder stringBuilder = new StringBuilder(109 + String.valueOf(valueOf).length());
        stringBuilder.append("TrackedQuery{id=");
        stringBuilder.append(j);
        stringBuilder.append(", querySpec=");
        stringBuilder.append(valueOf);
        stringBuilder.append(", lastUse=");
        stringBuilder.append(j2);
        stringBuilder.append(", complete=");
        stringBuilder.append(z);
        stringBuilder.append(", active=");
        stringBuilder.append(z2);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public final zzehe zzbxt() {
        return new zzehe(this.id, this.zzmyn, this.zzmyo, true, this.zziyi);
    }
}
