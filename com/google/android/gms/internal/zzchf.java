package com.google.android.gms.internal;

public abstract class zzchf extends zzev implements zzche {
    public zzchf() {
        attachInterface(this, "com.google.android.gms.measurement.internal.IMeasurementService");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTransact(int r8, android.os.Parcel r9, android.os.Parcel r10, int r11) throws android.os.RemoteException {
        /*
        r7 = this;
        r11 = r7.zza(r8, r9, r10, r11);
        r0 = 1;
        if (r11 == 0) goto L_0x0008;
    L_0x0007:
        return r0;
    L_0x0008:
        switch(r8) {
            case 1: goto L_0x012a;
            case 2: goto L_0x0116;
            case 3: goto L_0x000b;
            case 4: goto L_0x010a;
            case 5: goto L_0x00f6;
            case 6: goto L_0x00ea;
            case 7: goto L_0x00d3;
            case 8: goto L_0x000b;
            case 9: goto L_0x00bc;
            case 10: goto L_0x00a6;
            case 11: goto L_0x0093;
            case 12: goto L_0x007e;
            case 13: goto L_0x0071;
            case 14: goto L_0x0058;
            case 15: goto L_0x0042;
            case 16: goto L_0x002c;
            case 17: goto L_0x001a;
            case 18: goto L_0x000d;
            default: goto L_0x000b;
        };
    L_0x000b:
        r8 = 0;
        return r8;
    L_0x000d:
        r8 = com.google.android.gms.internal.zzcgi.CREATOR;
        r8 = com.google.android.gms.internal.zzew.zza(r9, r8);
        r8 = (com.google.android.gms.internal.zzcgi) r8;
        r7.zzd(r8);
        goto L_0x013d;
    L_0x001a:
        r8 = r9.readString();
        r11 = r9.readString();
        r9 = r9.readString();
        r8 = r7.zzj(r8, r11, r9);
        goto L_0x00e3;
    L_0x002c:
        r8 = r9.readString();
        r11 = r9.readString();
        r1 = com.google.android.gms.internal.zzcgi.CREATOR;
        r9 = com.google.android.gms.internal.zzew.zza(r9, r1);
        r9 = (com.google.android.gms.internal.zzcgi) r9;
        r8 = r7.zza(r8, r11, r9);
        goto L_0x00e3;
    L_0x0042:
        r8 = r9.readString();
        r11 = r9.readString();
        r1 = r9.readString();
        r9 = com.google.android.gms.internal.zzew.zza(r9);
        r8 = r7.zza(r8, r11, r1, r9);
        goto L_0x00e3;
    L_0x0058:
        r8 = r9.readString();
        r11 = r9.readString();
        r1 = com.google.android.gms.internal.zzew.zza(r9);
        r2 = com.google.android.gms.internal.zzcgi.CREATOR;
        r9 = com.google.android.gms.internal.zzew.zza(r9, r2);
        r9 = (com.google.android.gms.internal.zzcgi) r9;
        r8 = r7.zza(r8, r11, r1, r9);
        goto L_0x00e3;
    L_0x0071:
        r8 = com.google.android.gms.internal.zzcgl.CREATOR;
        r8 = com.google.android.gms.internal.zzew.zza(r9, r8);
        r8 = (com.google.android.gms.internal.zzcgl) r8;
        r7.zzb(r8);
        goto L_0x013d;
    L_0x007e:
        r8 = com.google.android.gms.internal.zzcgl.CREATOR;
        r8 = com.google.android.gms.internal.zzew.zza(r9, r8);
        r8 = (com.google.android.gms.internal.zzcgl) r8;
        r11 = com.google.android.gms.internal.zzcgi.CREATOR;
        r9 = com.google.android.gms.internal.zzew.zza(r9, r11);
        r9 = (com.google.android.gms.internal.zzcgi) r9;
        r7.zza(r8, r9);
        goto L_0x013d;
    L_0x0093:
        r8 = com.google.android.gms.internal.zzcgi.CREATOR;
        r8 = com.google.android.gms.internal.zzew.zza(r9, r8);
        r8 = (com.google.android.gms.internal.zzcgi) r8;
        r8 = r7.zzc(r8);
        r10.writeNoException();
        r10.writeString(r8);
        return r0;
    L_0x00a6:
        r2 = r9.readLong();
        r4 = r9.readString();
        r5 = r9.readString();
        r6 = r9.readString();
        r1 = r7;
        r1.zza(r2, r4, r5, r6);
        goto L_0x013d;
    L_0x00bc:
        r8 = com.google.android.gms.internal.zzcha.CREATOR;
        r8 = com.google.android.gms.internal.zzew.zza(r9, r8);
        r8 = (com.google.android.gms.internal.zzcha) r8;
        r9 = r9.readString();
        r8 = r7.zza(r8, r9);
        r10.writeNoException();
        r10.writeByteArray(r8);
        return r0;
    L_0x00d3:
        r8 = com.google.android.gms.internal.zzcgi.CREATOR;
        r8 = com.google.android.gms.internal.zzew.zza(r9, r8);
        r8 = (com.google.android.gms.internal.zzcgi) r8;
        r9 = com.google.android.gms.internal.zzew.zza(r9);
        r8 = r7.zza(r8, r9);
    L_0x00e3:
        r10.writeNoException();
        r10.writeTypedList(r8);
        return r0;
    L_0x00ea:
        r8 = com.google.android.gms.internal.zzcgi.CREATOR;
        r8 = com.google.android.gms.internal.zzew.zza(r9, r8);
        r8 = (com.google.android.gms.internal.zzcgi) r8;
        r7.zzb(r8);
        goto L_0x013d;
    L_0x00f6:
        r8 = com.google.android.gms.internal.zzcha.CREATOR;
        r8 = com.google.android.gms.internal.zzew.zza(r9, r8);
        r8 = (com.google.android.gms.internal.zzcha) r8;
        r11 = r9.readString();
        r9 = r9.readString();
        r7.zza(r8, r11, r9);
        goto L_0x013d;
    L_0x010a:
        r8 = com.google.android.gms.internal.zzcgi.CREATOR;
        r8 = com.google.android.gms.internal.zzew.zza(r9, r8);
        r8 = (com.google.android.gms.internal.zzcgi) r8;
        r7.zza(r8);
        goto L_0x013d;
    L_0x0116:
        r8 = com.google.android.gms.internal.zzcln.CREATOR;
        r8 = com.google.android.gms.internal.zzew.zza(r9, r8);
        r8 = (com.google.android.gms.internal.zzcln) r8;
        r11 = com.google.android.gms.internal.zzcgi.CREATOR;
        r9 = com.google.android.gms.internal.zzew.zza(r9, r11);
        r9 = (com.google.android.gms.internal.zzcgi) r9;
        r7.zza(r8, r9);
        goto L_0x013d;
    L_0x012a:
        r8 = com.google.android.gms.internal.zzcha.CREATOR;
        r8 = com.google.android.gms.internal.zzew.zza(r9, r8);
        r8 = (com.google.android.gms.internal.zzcha) r8;
        r11 = com.google.android.gms.internal.zzcgi.CREATOR;
        r9 = com.google.android.gms.internal.zzew.zza(r9, r11);
        r9 = (com.google.android.gms.internal.zzcgi) r9;
        r7.zza(r8, r9);
    L_0x013d:
        r10.writeNoException();
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzchf.onTransact(int, android.os.Parcel, android.os.Parcel, int):boolean");
    }
}
