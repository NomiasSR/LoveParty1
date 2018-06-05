package com.google.android.gms.internal;

public final class zzekl extends zzejy<zzekl> {
    private final String value;

    public zzekl(String str, zzekd com_google_android_gms_internal_zzekd) {
        super(com_google_android_gms_internal_zzekd);
        this.value = str;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzekl)) {
            return false;
        }
        zzekl com_google_android_gms_internal_zzekl = (zzekl) obj;
        return this.value.equals(com_google_android_gms_internal_zzekl.value) && this.zznbx.equals(com_google_android_gms_internal_zzekl.zznbx);
    }

    public final Object getValue() {
        return this.value;
    }

    public final int hashCode() {
        return this.value.hashCode() + this.zznbx.hashCode();
    }

    protected final /* synthetic */ int zza(zzejy com_google_android_gms_internal_zzejy) {
        return this.value.compareTo(((zzekl) com_google_android_gms_internal_zzejy).value);
    }

    public final String zza(zzekf com_google_android_gms_internal_zzekf) {
        String zzb;
        String str;
        StringBuilder stringBuilder;
        switch (zzekm.zznct[com_google_android_gms_internal_zzekf.ordinal()]) {
            case 1:
                zzb = zzb(com_google_android_gms_internal_zzekf);
                str = this.value;
                stringBuilder = new StringBuilder((7 + String.valueOf(zzb).length()) + String.valueOf(str).length());
                break;
            case 2:
                zzb = zzb(com_google_android_gms_internal_zzekf);
                str = zzelt.zzqf(this.value);
                stringBuilder = new StringBuilder((7 + String.valueOf(zzb).length()) + String.valueOf(str).length());
                break;
            default:
                zzb = String.valueOf(com_google_android_gms_internal_zzekf);
                stringBuilder = new StringBuilder(38 + String.valueOf(zzb).length());
                stringBuilder.append("Invalid hash version for string node: ");
                stringBuilder.append(zzb);
                throw new IllegalArgumentException(stringBuilder.toString());
        }
        stringBuilder.append(zzb);
        stringBuilder.append("string:");
        stringBuilder.append(str);
        return stringBuilder.toString();
    }

    protected final zzeka zzbzm() {
        return zzeka.String;
    }

    public final /* synthetic */ zzekd zzf(zzekd com_google_android_gms_internal_zzekd) {
        return new zzekl(this.value, com_google_android_gms_internal_zzekd);
    }
}
