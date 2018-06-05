package com.google.android.gms.internal;

final class zzfih {
    static String zzbc(zzfes com_google_android_gms_internal_zzfes) {
        zzfij com_google_android_gms_internal_zzfii = new zzfii(com_google_android_gms_internal_zzfes);
        StringBuilder stringBuilder = new StringBuilder(com_google_android_gms_internal_zzfii.size());
        for (int i = 0; i < com_google_android_gms_internal_zzfii.size(); i++) {
            String str;
            byte zzkn = com_google_android_gms_internal_zzfii.zzkn(i);
            if (zzkn == (byte) 34) {
                str = "\\\"";
            } else if (zzkn == (byte) 39) {
                str = "\\'";
            } else if (zzkn != (byte) 92) {
                switch (zzkn) {
                    case (byte) 7:
                        str = "\\a";
                        break;
                    case (byte) 8:
                        str = "\\b";
                        break;
                    case (byte) 9:
                        str = "\\t";
                        break;
                    case (byte) 10:
                        str = "\\n";
                        break;
                    case (byte) 11:
                        str = "\\v";
                        break;
                    case (byte) 12:
                        str = "\\f";
                        break;
                    case (byte) 13:
                        str = "\\r";
                        break;
                    default:
                        char c;
                        if (zzkn < (byte) 32 || zzkn > (byte) 126) {
                            stringBuilder.append('\\');
                            stringBuilder.append((char) (((zzkn >>> 6) & 3) + 48));
                            stringBuilder.append((char) (((zzkn >>> 3) & 7) + 48));
                            c = (char) (48 + (zzkn & 7));
                        } else {
                            c = (char) zzkn;
                        }
                        stringBuilder.append(c);
                        continue;
                }
            } else {
                str = "\\\\";
            }
            stringBuilder.append(str);
        }
        return stringBuilder.toString();
    }
}
