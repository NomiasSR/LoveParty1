package com.google.firebase.database.connection.idl;

import android.os.IBinder;
import android.os.IInterface;
import com.google.android.gms.internal.zzev;

public abstract class zzu extends zzev implements zzt {
    public zzu() {
        attachInterface(this, "com.google.firebase.database.connection.idl.IPersistentConnection");
    }

    public static zzt asInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.firebase.database.connection.idl.IPersistentConnection");
        return queryLocalInterface instanceof zzt ? (zzt) queryLocalInterface : new zzv(iBinder);
    }

    public boolean onTransact(int r9, android.os.Parcel r10, android.os.Parcel r11, int r12) throws android.os.RemoteException {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:97:0x01eb in {2, 6, 7, 9, 10, 11, 14, 17, 18, 19, 22, 25, 26, 27, 30, 33, 34, 35, 38, 41, 42, 43, 46, 49, 50, 51, 54, 57, 58, 59, 60, 61, 64, 67, 68, 74, 75, 76, 77, 78, 79, 81, 84, 87, 88, 91, 94, 95, 96} preds:[]
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:129)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.visit(BlockProcessor.java:38)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r8 = this;
        r12 = r8.zza(r9, r10, r11, r12);
        r0 = 1;
        if (r12 == 0) goto L_0x0008;
    L_0x0007:
        return r0;
    L_0x0008:
        r12 = 0;
        switch(r9) {
            case 1: goto L_0x01a2;
            case 2: goto L_0x019b;
            case 3: goto L_0x0197;
            case 4: goto L_0x0193;
            case 5: goto L_0x0145;
            case 6: goto L_0x0135;
            case 7: goto L_0x0130;
            case 8: goto L_0x0106;
            case 9: goto L_0x00d8;
            case 10: goto L_0x00ae;
            case 11: goto L_0x0084;
            case 12: goto L_0x005a;
            case 13: goto L_0x0038;
            case 14: goto L_0x002f;
            case 15: goto L_0x0026;
            case 16: goto L_0x0017;
            case 17: goto L_0x000e;
            default: goto L_0x000c;
        };
    L_0x000c:
        r9 = 0;
        return r9;
    L_0x000e:
        r9 = r10.readString();
        r8.refreshAuthToken2(r9);
        goto L_0x019e;
    L_0x0017:
        r9 = r10.readString();
        r9 = r8.isInterrupted(r9);
        r11.writeNoException();
        com.google.android.gms.internal.zzew.zza(r11, r9);
        return r0;
    L_0x0026:
        r9 = r10.readString();
        r8.resume(r9);
        goto L_0x019e;
    L_0x002f:
        r9 = r10.readString();
        r8.interrupt(r9);
        goto L_0x019e;
    L_0x0038:
        r9 = r10.createStringArrayList();
        r10 = r10.readStrongBinder();
        if (r10 != 0) goto L_0x0043;
    L_0x0042:
        goto L_0x0055;
    L_0x0043:
        r12 = "com.google.firebase.database.connection.idl.IRequestResultCallback";
        r12 = r10.queryLocalInterface(r12);
        r1 = r12 instanceof com.google.firebase.database.connection.idl.zzah;
        if (r1 == 0) goto L_0x0050;
    L_0x004d:
        r12 = (com.google.firebase.database.connection.idl.zzah) r12;
        goto L_0x0055;
    L_0x0050:
        r12 = new com.google.firebase.database.connection.idl.zzaj;
        r12.<init>(r10);
    L_0x0055:
        r8.onDisconnectCancel(r9, r12);
        goto L_0x019e;
    L_0x005a:
        r9 = r10.createStringArrayList();
        r1 = r10.readStrongBinder();
        r1 = com.google.android.gms.dynamic.IObjectWrapper.zza.zzaq(r1);
        r10 = r10.readStrongBinder();
        if (r10 != 0) goto L_0x006d;
    L_0x006c:
        goto L_0x007f;
    L_0x006d:
        r12 = "com.google.firebase.database.connection.idl.IRequestResultCallback";
        r12 = r10.queryLocalInterface(r12);
        r2 = r12 instanceof com.google.firebase.database.connection.idl.zzah;
        if (r2 == 0) goto L_0x007a;
    L_0x0077:
        r12 = (com.google.firebase.database.connection.idl.zzah) r12;
        goto L_0x007f;
    L_0x007a:
        r12 = new com.google.firebase.database.connection.idl.zzaj;
        r12.<init>(r10);
    L_0x007f:
        r8.onDisconnectMerge(r9, r1, r12);
        goto L_0x019e;
    L_0x0084:
        r9 = r10.createStringArrayList();
        r1 = r10.readStrongBinder();
        r1 = com.google.android.gms.dynamic.IObjectWrapper.zza.zzaq(r1);
        r10 = r10.readStrongBinder();
        if (r10 != 0) goto L_0x0097;
    L_0x0096:
        goto L_0x00a9;
    L_0x0097:
        r12 = "com.google.firebase.database.connection.idl.IRequestResultCallback";
        r12 = r10.queryLocalInterface(r12);
        r2 = r12 instanceof com.google.firebase.database.connection.idl.zzah;
        if (r2 == 0) goto L_0x00a4;
    L_0x00a1:
        r12 = (com.google.firebase.database.connection.idl.zzah) r12;
        goto L_0x00a9;
    L_0x00a4:
        r12 = new com.google.firebase.database.connection.idl.zzaj;
        r12.<init>(r10);
    L_0x00a9:
        r8.onDisconnectPut(r9, r1, r12);
        goto L_0x019e;
    L_0x00ae:
        r9 = r10.createStringArrayList();
        r1 = r10.readStrongBinder();
        r1 = com.google.android.gms.dynamic.IObjectWrapper.zza.zzaq(r1);
        r10 = r10.readStrongBinder();
        if (r10 != 0) goto L_0x00c1;
    L_0x00c0:
        goto L_0x00d3;
    L_0x00c1:
        r12 = "com.google.firebase.database.connection.idl.IRequestResultCallback";
        r12 = r10.queryLocalInterface(r12);
        r2 = r12 instanceof com.google.firebase.database.connection.idl.zzah;
        if (r2 == 0) goto L_0x00ce;
    L_0x00cb:
        r12 = (com.google.firebase.database.connection.idl.zzah) r12;
        goto L_0x00d3;
    L_0x00ce:
        r12 = new com.google.firebase.database.connection.idl.zzaj;
        r12.<init>(r10);
    L_0x00d3:
        r8.merge(r9, r1, r12);
        goto L_0x019e;
    L_0x00d8:
        r9 = r10.createStringArrayList();
        r1 = r10.readStrongBinder();
        r1 = com.google.android.gms.dynamic.IObjectWrapper.zza.zzaq(r1);
        r2 = r10.readString();
        r10 = r10.readStrongBinder();
        if (r10 != 0) goto L_0x00ef;
    L_0x00ee:
        goto L_0x0101;
    L_0x00ef:
        r12 = "com.google.firebase.database.connection.idl.IRequestResultCallback";
        r12 = r10.queryLocalInterface(r12);
        r3 = r12 instanceof com.google.firebase.database.connection.idl.zzah;
        if (r3 == 0) goto L_0x00fc;
    L_0x00f9:
        r12 = (com.google.firebase.database.connection.idl.zzah) r12;
        goto L_0x0101;
    L_0x00fc:
        r12 = new com.google.firebase.database.connection.idl.zzaj;
        r12.<init>(r10);
    L_0x0101:
        r8.compareAndPut(r9, r1, r2, r12);
        goto L_0x019e;
    L_0x0106:
        r9 = r10.createStringArrayList();
        r1 = r10.readStrongBinder();
        r1 = com.google.android.gms.dynamic.IObjectWrapper.zza.zzaq(r1);
        r10 = r10.readStrongBinder();
        if (r10 != 0) goto L_0x0119;
    L_0x0118:
        goto L_0x012b;
    L_0x0119:
        r12 = "com.google.firebase.database.connection.idl.IRequestResultCallback";
        r12 = r10.queryLocalInterface(r12);
        r2 = r12 instanceof com.google.firebase.database.connection.idl.zzah;
        if (r2 == 0) goto L_0x0126;
    L_0x0123:
        r12 = (com.google.firebase.database.connection.idl.zzah) r12;
        goto L_0x012b;
    L_0x0126:
        r12 = new com.google.firebase.database.connection.idl.zzaj;
        r12.<init>(r10);
    L_0x012b:
        r8.put(r9, r1, r12);
        goto L_0x019e;
    L_0x0130:
        r8.purgeOutstandingWrites();
        goto L_0x019e;
    L_0x0135:
        r9 = r10.createStringArrayList();
        r10 = r10.readStrongBinder();
        r10 = com.google.android.gms.dynamic.IObjectWrapper.zza.zzaq(r10);
        r8.unlisten(r9, r10);
        goto L_0x019e;
    L_0x0145:
        r2 = r10.createStringArrayList();
        r9 = r10.readStrongBinder();
        r3 = com.google.android.gms.dynamic.IObjectWrapper.zza.zzaq(r9);
        r9 = r10.readStrongBinder();
        if (r9 != 0) goto L_0x0159;
    L_0x0157:
        r4 = r12;
        goto L_0x016e;
    L_0x0159:
        r1 = "com.google.firebase.database.connection.idl.IListenHashProvider";
        r1 = r9.queryLocalInterface(r1);
        r4 = r1 instanceof com.google.firebase.database.connection.idl.zzq;
        if (r4 == 0) goto L_0x0168;
    L_0x0163:
        r9 = r1;
        r9 = (com.google.firebase.database.connection.idl.zzq) r9;
        r4 = r9;
        goto L_0x016e;
    L_0x0168:
        r1 = new com.google.firebase.database.connection.idl.zzs;
        r1.<init>(r9);
        r4 = r1;
    L_0x016e:
        r5 = r10.readLong();
        r9 = r10.readStrongBinder();
        if (r9 != 0) goto L_0x017a;
    L_0x0178:
        r7 = r12;
        goto L_0x018e;
    L_0x017a:
        r10 = "com.google.firebase.database.connection.idl.IRequestResultCallback";
        r10 = r9.queryLocalInterface(r10);
        r12 = r10 instanceof com.google.firebase.database.connection.idl.zzah;
        if (r12 == 0) goto L_0x0188;
    L_0x0184:
        r12 = r10;
        r12 = (com.google.firebase.database.connection.idl.zzah) r12;
        goto L_0x0178;
    L_0x0188:
        r12 = new com.google.firebase.database.connection.idl.zzaj;
        r12.<init>(r9);
        goto L_0x0178;
    L_0x018e:
        r1 = r8;
        r1.listen(r2, r3, r4, r5, r7);
        goto L_0x019e;
    L_0x0193:
        r8.refreshAuthToken();
        goto L_0x019e;
    L_0x0197:
        r8.shutdown();
        goto L_0x019e;
    L_0x019b:
        r8.initialize();
    L_0x019e:
        r11.writeNoException();
        return r0;
    L_0x01a2:
        r9 = com.google.firebase.database.connection.idl.zzc.CREATOR;
        r9 = com.google.android.gms.internal.zzew.zza(r10, r9);
        r9 = (com.google.firebase.database.connection.idl.zzc) r9;
        r1 = r10.readStrongBinder();
        if (r1 != 0) goto L_0x01b2;
    L_0x01b0:
        r1 = r12;
        goto L_0x01c6;
    L_0x01b2:
        r2 = "com.google.firebase.database.connection.idl.IConnectionAuthTokenProvider";
        r2 = r1.queryLocalInterface(r2);
        r3 = r2 instanceof com.google.firebase.database.connection.idl.zzk;
        if (r3 == 0) goto L_0x01c0;
    L_0x01bc:
        r1 = r2;
        r1 = (com.google.firebase.database.connection.idl.zzk) r1;
        goto L_0x01c6;
    L_0x01c0:
        r2 = new com.google.firebase.database.connection.idl.zzm;
        r2.<init>(r1);
        r1 = r2;
    L_0x01c6:
        r2 = r10.readStrongBinder();
        r2 = com.google.android.gms.dynamic.IObjectWrapper.zza.zzaq(r2);
        r10 = r10.readStrongBinder();
        if (r10 != 0) goto L_0x01d5;
    L_0x01d4:
        goto L_0x01e7;
    L_0x01d5:
        r12 = "com.google.firebase.database.connection.idl.IPersistentConnectionDelegate";
        r12 = r10.queryLocalInterface(r12);
        r3 = r12 instanceof com.google.firebase.database.connection.idl.zzw;
        if (r3 == 0) goto L_0x01e2;
    L_0x01df:
        r12 = (com.google.firebase.database.connection.idl.zzw) r12;
        goto L_0x01e7;
    L_0x01e2:
        r12 = new com.google.firebase.database.connection.idl.zzy;
        r12.<init>(r10);
    L_0x01e7:
        r8.setup(r9, r1, r2, r12);
        goto L_0x019e;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.database.connection.idl.zzu.onTransact(int, android.os.Parcel, android.os.Parcel, int):boolean");
    }
}
