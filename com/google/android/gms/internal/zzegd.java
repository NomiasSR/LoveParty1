package com.google.android.gms.internal;

public final class zzegd {
    private final zzedk zzmks;
    private final long zzmwq;
    private final zzekd zzmwr;
    private final zzecy zzmws;
    private final boolean zzmwt;

    public zzegd(long j, zzedk com_google_android_gms_internal_zzedk, zzecy com_google_android_gms_internal_zzecy) {
        this.zzmwq = j;
        this.zzmks = com_google_android_gms_internal_zzedk;
        this.zzmwr = null;
        this.zzmws = com_google_android_gms_internal_zzecy;
        this.zzmwt = true;
    }

    public zzegd(long j, zzedk com_google_android_gms_internal_zzedk, zzekd com_google_android_gms_internal_zzekd, boolean z) {
        this.zzmwq = j;
        this.zzmks = com_google_android_gms_internal_zzedk;
        this.zzmwr = com_google_android_gms_internal_zzekd;
        this.zzmws = null;
        this.zzmwt = z;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r7) {
        /*
        r6 = this;
        r0 = 1;
        if (r6 != r7) goto L_0x0004;
    L_0x0003:
        return r0;
    L_0x0004:
        r1 = 0;
        if (r7 == 0) goto L_0x0058;
    L_0x0007:
        r2 = r6.getClass();
        r3 = r7.getClass();
        if (r2 == r3) goto L_0x0012;
    L_0x0011:
        return r1;
    L_0x0012:
        r7 = (com.google.android.gms.internal.zzegd) r7;
        r2 = r6.zzmwq;
        r4 = r7.zzmwq;
        r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r2 == 0) goto L_0x001d;
    L_0x001c:
        return r1;
    L_0x001d:
        r2 = r6.zzmks;
        r3 = r7.zzmks;
        r2 = r2.equals(r3);
        if (r2 != 0) goto L_0x0028;
    L_0x0027:
        return r1;
    L_0x0028:
        r2 = r6.zzmwt;
        r3 = r7.zzmwt;
        if (r2 == r3) goto L_0x002f;
    L_0x002e:
        return r1;
    L_0x002f:
        r2 = r6.zzmwr;
        if (r2 == 0) goto L_0x003e;
    L_0x0033:
        r2 = r6.zzmwr;
        r3 = r7.zzmwr;
        r2 = r2.equals(r3);
        if (r2 == 0) goto L_0x0042;
    L_0x003d:
        goto L_0x0043;
    L_0x003e:
        r2 = r7.zzmwr;
        if (r2 == 0) goto L_0x0043;
    L_0x0042:
        return r1;
    L_0x0043:
        r2 = r6.zzmws;
        if (r2 == 0) goto L_0x0052;
    L_0x0047:
        r2 = r6.zzmws;
        r7 = r7.zzmws;
        r7 = r2.equals(r7);
        if (r7 == 0) goto L_0x0056;
    L_0x0051:
        return r0;
    L_0x0052:
        r7 = r7.zzmws;
        if (r7 == 0) goto L_0x0057;
    L_0x0056:
        return r1;
    L_0x0057:
        return r0;
    L_0x0058:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzegd.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = ((((((Long.valueOf(this.zzmwq).hashCode() * 31) + Boolean.valueOf(this.zzmwt).hashCode()) * 31) + this.zzmks.hashCode()) * 31) + (this.zzmwr != null ? this.zzmwr.hashCode() : 0)) * 31;
        if (this.zzmws != null) {
            i = this.zzmws.hashCode();
        }
        return hashCode + i;
    }

    public final boolean isVisible() {
        return this.zzmwt;
    }

    public final String toString() {
        long j = this.zzmwq;
        String valueOf = String.valueOf(this.zzmks);
        boolean z = this.zzmwt;
        String valueOf2 = String.valueOf(this.zzmwr);
        String valueOf3 = String.valueOf(this.zzmws);
        StringBuilder stringBuilder = new StringBuilder(((78 + String.valueOf(valueOf).length()) + String.valueOf(valueOf2).length()) + String.valueOf(valueOf3).length());
        stringBuilder.append("UserWriteRecord{id=");
        stringBuilder.append(j);
        stringBuilder.append(" path=");
        stringBuilder.append(valueOf);
        stringBuilder.append(" visible=");
        stringBuilder.append(z);
        stringBuilder.append(" overwrite=");
        stringBuilder.append(valueOf2);
        stringBuilder.append(" merge=");
        stringBuilder.append(valueOf3);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public final zzedk zzbsy() {
        return this.zzmks;
    }

    public final long zzbwy() {
        return this.zzmwq;
    }

    public final zzekd zzbwz() {
        if (this.zzmwr != null) {
            return this.zzmwr;
        }
        throw new IllegalArgumentException("Can't access overwrite when write is a merge!");
    }

    public final zzecy zzbxa() {
        if (this.zzmws != null) {
            return this.zzmws;
        }
        throw new IllegalArgumentException("Can't access merge when write is an overwrite!");
    }

    public final boolean zzbxb() {
        return this.zzmwr != null;
    }
}
