package com.google.android.gms.internal;

import java.io.IOException;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;

public abstract class zzfes implements Serializable, Iterable<Byte> {
    public static final zzfes zzpfg = new zzfez(zzffz.EMPTY_BYTE_ARRAY);
    private static final zzfew zzpfh;
    private int zzmal = 0;

    static {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = new com.google.android.gms.internal.zzfez;
        r1 = com.google.android.gms.internal.zzffz.EMPTY_BYTE_ARRAY;
        r0.<init>(r1);
        zzpfg = r0;
        r0 = "android.content.Context";	 Catch:{ ClassNotFoundException -> 0x0010 }
        java.lang.Class.forName(r0);	 Catch:{ ClassNotFoundException -> 0x0010 }
        r0 = 1;
        goto L_0x0011;
    L_0x0010:
        r0 = 0;
    L_0x0011:
        r1 = 0;
        if (r0 == 0) goto L_0x001a;
    L_0x0014:
        r0 = new com.google.android.gms.internal.zzffa;
        r0.<init>(r1);
        goto L_0x001f;
    L_0x001a:
        r0 = new com.google.android.gms.internal.zzfeu;
        r0.<init>(r1);
    L_0x001f:
        zzpfh = r0;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzfes.<clinit>():void");
    }

    zzfes() {
    }

    private static zzfes zza(Iterator<zzfes> it, int i) {
        if (i <= 0) {
            throw new IllegalArgumentException(String.format("length (%s) must be >= 1", new Object[]{Integer.valueOf(i)}));
        } else if (i == 1) {
            return (zzfes) it.next();
        } else {
            int i2 = i >>> 1;
            zzfes zza = zza(it, i2);
            zzfes zza2 = zza(it, i - i2);
            if (ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED - zza.size() >= zza2.size()) {
                return zzfhq.zza(zza, zza2);
            }
            i2 = zza.size();
            int size = zza2.size();
            StringBuilder stringBuilder = new StringBuilder(53);
            stringBuilder.append("ByteString would be too long: ");
            stringBuilder.append(i2);
            stringBuilder.append("+");
            stringBuilder.append(size);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
    }

    public static zzfes zzaz(byte[] bArr) {
        return zze(bArr, 0, bArr.length);
    }

    static zzfes zzba(byte[] bArr) {
        return new zzfez(bArr);
    }

    public static zzfes zze(byte[] bArr, int i, int i2) {
        return new zzfez(zzpfh.zzf(bArr, i, i2));
    }

    public static zzfes zzf(Iterable<zzfes> iterable) {
        int size = ((Collection) iterable).size();
        return size == 0 ? zzpfg : zza(iterable.iterator(), size);
    }

    static int zzh(int i, int i2, int i3) {
        int i4 = i2 - i;
        if ((((i | i2) | i4) | (i3 - i2)) >= 0) {
            return i4;
        }
        if (i < 0) {
            StringBuilder stringBuilder = new StringBuilder(32);
            stringBuilder.append("Beginning index: ");
            stringBuilder.append(i);
            stringBuilder.append(" < 0");
            throw new IndexOutOfBoundsException(stringBuilder.toString());
        } else if (i2 < i) {
            r1 = new StringBuilder(66);
            r1.append("Beginning index larger than ending index: ");
            r1.append(i);
            r1.append(", ");
            r1.append(i2);
            throw new IndexOutOfBoundsException(r1.toString());
        } else {
            r1 = new StringBuilder(37);
            r1.append("End index: ");
            r1.append(i2);
            r1.append(" >= ");
            r1.append(i3);
            throw new IndexOutOfBoundsException(r1.toString());
        }
    }

    static zzfex zzko(int i) {
        return new zzfex(i);
    }

    public static zzfes zztr(String str) {
        return new zzfez(str.getBytes(zzffz.UTF_8));
    }

    static void zzy(int i, int i2) {
        if (((i2 - (i + 1)) | i) >= 0) {
            return;
        }
        if (i < 0) {
            StringBuilder stringBuilder = new StringBuilder(22);
            stringBuilder.append("Index < 0: ");
            stringBuilder.append(i);
            throw new ArrayIndexOutOfBoundsException(stringBuilder.toString());
        }
        StringBuilder stringBuilder2 = new StringBuilder(40);
        stringBuilder2.append("Index > length: ");
        stringBuilder2.append(i);
        stringBuilder2.append(", ");
        stringBuilder2.append(i2);
        throw new ArrayIndexOutOfBoundsException(stringBuilder2.toString());
    }

    public abstract boolean equals(Object obj);

    public final int hashCode() {
        int i = this.zzmal;
        if (i == 0) {
            i = size();
            i = zzg(i, 0, i);
            if (i == 0) {
                i = 1;
            }
            this.zzmal = i;
        }
        return i;
    }

    public final boolean isEmpty() {
        return size() == 0;
    }

    public /* synthetic */ Iterator iterator() {
        return new zzfet(this);
    }

    public abstract int size();

    public final byte[] toByteArray() {
        int size = size();
        if (size == 0) {
            return zzffz.EMPTY_BYTE_ARRAY;
        }
        byte[] bArr = new byte[size];
        zzb(bArr, 0, 0, size);
        return bArr;
    }

    public final String toString() {
        return String.format("<ByteString@%s size=%d>", new Object[]{Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(size())});
    }

    abstract void zza(zzfer com_google_android_gms_internal_zzfer) throws IOException;

    public final void zza(byte[] bArr, int i, int i2, int i3) {
        zzh(i, i + i3, size());
        zzh(i2, i2 + i3, bArr.length);
        if (i3 > 0) {
            zzb(bArr, i, i2, i3);
        }
    }

    protected abstract void zzb(byte[] bArr, int i, int i2, int i3);

    public abstract zzffb zzcvm();

    protected abstract int zzcvn();

    protected abstract boolean zzcvo();

    protected final int zzcvp() {
        return this.zzmal;
    }

    protected abstract int zzg(int i, int i2, int i3);

    public abstract byte zzkn(int i);

    public abstract zzfes zzx(int i, int i2);
}
