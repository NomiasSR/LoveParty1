package com.google.android.gms.internal;

import java.util.Arrays;
import java.util.Stack;

final class zzfhs {
    private final Stack<zzfes> zzpjm;

    private zzfhs() {
        this.zzpjm = new Stack();
    }

    private final void zzba(zzfes com_google_android_gms_internal_zzfes) {
        while (!com_google_android_gms_internal_zzfes.zzcvo()) {
            if (com_google_android_gms_internal_zzfes instanceof zzfhq) {
                zzfhq com_google_android_gms_internal_zzfhq = (zzfhq) com_google_android_gms_internal_zzfes;
                zzba(com_google_android_gms_internal_zzfhq.zzpji);
                com_google_android_gms_internal_zzfes = com_google_android_gms_internal_zzfhq.zzpjj;
            } else {
                String valueOf = String.valueOf(com_google_android_gms_internal_zzfes.getClass());
                StringBuilder stringBuilder = new StringBuilder(49 + String.valueOf(valueOf).length());
                stringBuilder.append("Has a new type of ByteString been created? Found ");
                stringBuilder.append(valueOf);
                throw new IllegalArgumentException(stringBuilder.toString());
            }
        }
        int zzlz = zzlz(com_google_android_gms_internal_zzfes.size());
        int i = zzfhq.zzpjg[zzlz + 1];
        if (!this.zzpjm.isEmpty()) {
            if (((zzfes) this.zzpjm.peek()).size() < i) {
                zzlz = zzfhq.zzpjg[zzlz];
                zzfes com_google_android_gms_internal_zzfes2 = (zzfes) this.zzpjm.pop();
                while (!this.zzpjm.isEmpty() && ((zzfes) this.zzpjm.peek()).size() < zzlz) {
                    com_google_android_gms_internal_zzfes2 = new zzfhq((zzfes) this.zzpjm.pop(), com_google_android_gms_internal_zzfes2);
                }
                zzfes com_google_android_gms_internal_zzfhq2 = new zzfhq(com_google_android_gms_internal_zzfes2, com_google_android_gms_internal_zzfes);
                while (!this.zzpjm.isEmpty()) {
                    if (((zzfes) this.zzpjm.peek()).size() >= zzfhq.zzpjg[zzlz(com_google_android_gms_internal_zzfhq2.size()) + 1]) {
                        break;
                    }
                    com_google_android_gms_internal_zzfhq2 = new zzfhq((zzfes) this.zzpjm.pop(), com_google_android_gms_internal_zzfhq2);
                }
                this.zzpjm.push(com_google_android_gms_internal_zzfhq2);
                return;
            }
        }
        this.zzpjm.push(com_google_android_gms_internal_zzfes);
    }

    private final zzfes zzc(zzfes com_google_android_gms_internal_zzfes, zzfes com_google_android_gms_internal_zzfes2) {
        zzba(com_google_android_gms_internal_zzfes);
        zzba(com_google_android_gms_internal_zzfes2);
        com_google_android_gms_internal_zzfes = (zzfes) this.zzpjm.pop();
        while (!this.zzpjm.isEmpty()) {
            com_google_android_gms_internal_zzfes = new zzfhq((zzfes) this.zzpjm.pop(), com_google_android_gms_internal_zzfes);
        }
        return com_google_android_gms_internal_zzfes;
    }

    private static int zzlz(int i) {
        i = Arrays.binarySearch(zzfhq.zzpjg, i);
        return i < 0 ? (-(i + 1)) - 1 : i;
    }
}
