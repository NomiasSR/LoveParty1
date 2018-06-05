package com.google.android.gms.internal;

import java.io.PrintStream;
import java.io.PrintWriter;

public final class zzdvl {
    private static zzdvm zzmag;
    private static int zzmah;

    static final class zza extends zzdvm {
        zza() {
        }

        public final void zza(Throwable th, PrintStream printStream) {
            th.printStackTrace(printStream);
        }

        public final void zza(Throwable th, PrintWriter printWriter) {
            th.printStackTrace(printWriter);
        }
    }

    static {
        Integer zzbqm;
        zzdvm com_google_android_gms_internal_zzdvq;
        Throwable th;
        PrintStream printStream;
        String name;
        StringBuilder stringBuilder;
        int i = 1;
        try {
            zzbqm = zzbqm();
            if (zzbqm != null) {
                try {
                    if (zzbqm.intValue() >= 19) {
                        com_google_android_gms_internal_zzdvq = new zzdvq();
                        zzmag = com_google_android_gms_internal_zzdvq;
                        if (zzbqm != null) {
                            i = zzbqm.intValue();
                        }
                        zzmah = i;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    printStream = System.err;
                    name = zza.class.getName();
                    stringBuilder = new StringBuilder(132 + String.valueOf(name).length());
                    stringBuilder.append("An error has occured when initializing the try-with-resources desuguring strategy. The default strategy ");
                    stringBuilder.append(name);
                    stringBuilder.append("will be used. The error is: ");
                    printStream.println(stringBuilder.toString());
                    th.printStackTrace(System.err);
                    com_google_android_gms_internal_zzdvq = new zza();
                    zzmag = com_google_android_gms_internal_zzdvq;
                    if (zzbqm != null) {
                        i = zzbqm.intValue();
                    }
                    zzmah = i;
                }
            }
            com_google_android_gms_internal_zzdvq = (Boolean.getBoolean("com.google.devtools.build.android.desugar.runtime.twr_disable_mimic") ^ 1) != 0 ? new zzdvp() : new zza();
        } catch (Throwable th3) {
            th = th3;
            zzbqm = null;
            printStream = System.err;
            name = zza.class.getName();
            stringBuilder = new StringBuilder(132 + String.valueOf(name).length());
            stringBuilder.append("An error has occured when initializing the try-with-resources desuguring strategy. The default strategy ");
            stringBuilder.append(name);
            stringBuilder.append("will be used. The error is: ");
            printStream.println(stringBuilder.toString());
            th.printStackTrace(System.err);
            com_google_android_gms_internal_zzdvq = new zza();
            zzmag = com_google_android_gms_internal_zzdvq;
            if (zzbqm != null) {
                i = zzbqm.intValue();
            }
            zzmah = i;
        }
        zzmag = com_google_android_gms_internal_zzdvq;
        if (zzbqm != null) {
            i = zzbqm.intValue();
        }
        zzmah = i;
    }

    public static void zza(Throwable th, PrintStream printStream) {
        zzmag.zza(th, printStream);
    }

    public static void zza(Throwable th, PrintWriter printWriter) {
        zzmag.zza(th, printWriter);
    }

    private static Integer zzbqm() {
        try {
            return (Integer) Class.forName("android.os.Build$VERSION").getField("SDK_INT").get(null);
        } catch (Exception e) {
            System.err.println("Failed to retrieve value from android.os.Build$VERSION.SDK_INT due to the following exception.");
            e.printStackTrace(System.err);
            return null;
        }
    }
}
