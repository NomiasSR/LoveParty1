package com.google.android.gms.internal;

public final class zzelq<T, U> {
    private final T first;
    private final U second;

    public zzelq(T t, U u) {
        this.first = t;
        this.second = u;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        zzelq com_google_android_gms_internal_zzelq = (zzelq) obj;
        if (this.first != null) {
            if (!this.first.equals(com_google_android_gms_internal_zzelq.first)) {
                return false;
            }
        } else if (com_google_android_gms_internal_zzelq.first != null) {
            return false;
        }
        if (this.second != null) {
            if (!this.second.equals(com_google_android_gms_internal_zzelq.second)) {
                return false;
            }
        } else if (com_google_android_gms_internal_zzelq.second != null) {
            return false;
        }
        return true;
    }

    public final T getFirst() {
        return this.first;
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = (this.first != null ? this.first.hashCode() : 0) * 31;
        if (this.second != null) {
            i = this.second.hashCode();
        }
        return hashCode + i;
    }

    public final String toString() {
        String valueOf = String.valueOf(this.first);
        String valueOf2 = String.valueOf(this.second);
        StringBuilder stringBuilder = new StringBuilder((7 + String.valueOf(valueOf).length()) + String.valueOf(valueOf2).length());
        stringBuilder.append("Pair(");
        stringBuilder.append(valueOf);
        stringBuilder.append(",");
        stringBuilder.append(valueOf2);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public final U zzcbg() {
        return this.second;
    }
}
