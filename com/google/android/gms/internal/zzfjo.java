package com.google.android.gms.internal;

public final class zzfjo implements Cloneable {
    private static final zzfjp zzpne = new zzfjp();
    private int mSize;
    private boolean zzpnf;
    private int[] zzpng;
    private zzfjp[] zzpnh;

    zzfjo() {
        this(10);
    }

    private zzfjo(int i) {
        this.zzpnf = false;
        i = idealIntArraySize(i);
        this.zzpng = new int[i];
        this.zzpnh = new zzfjp[i];
        this.mSize = 0;
    }

    private static int idealIntArraySize(int i) {
        i <<= 2;
        for (int i2 = 4; i2 < 32; i2++) {
            int i3 = (1 << i2) - 12;
            if (i <= i3) {
                i = i3;
                break;
            }
        }
        return i / 4;
    }

    private final int zzml(int r1) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.DecodeException: Load method exception in method: com.google.android.gms.internal.zzfjo.zzml(int):int
	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:116)
	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:249)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
Caused by: jadx.core.utils.exceptions.DecodeException: Unknown instruction: not-int
	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:568)
	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:56)
	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:102)
	... 5 more
*/
        /*
        // Can't load method instructions.
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzfjo.zzml(int):int");
    }

    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        int i = this.mSize;
        zzfjo com_google_android_gms_internal_zzfjo = new zzfjo(i);
        int i2 = 0;
        System.arraycopy(this.zzpng, 0, com_google_android_gms_internal_zzfjo.zzpng, 0, i);
        while (i2 < i) {
            if (this.zzpnh[i2] != null) {
                com_google_android_gms_internal_zzfjo.zzpnh[i2] = (zzfjp) this.zzpnh[i2].clone();
            }
            i2++;
        }
        com_google_android_gms_internal_zzfjo.mSize = i;
        return com_google_android_gms_internal_zzfjo;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzfjo)) {
            return false;
        }
        zzfjo com_google_android_gms_internal_zzfjo = (zzfjo) obj;
        if (this.mSize != com_google_android_gms_internal_zzfjo.mSize) {
            return false;
        }
        boolean z;
        int[] iArr = this.zzpng;
        int[] iArr2 = com_google_android_gms_internal_zzfjo.zzpng;
        int i = this.mSize;
        for (int i2 = 0; i2 < i; i2++) {
            if (iArr[i2] != iArr2[i2]) {
                z = false;
                break;
            }
        }
        z = true;
        if (z) {
            boolean z2;
            zzfjp[] com_google_android_gms_internal_zzfjpArr = this.zzpnh;
            zzfjp[] com_google_android_gms_internal_zzfjpArr2 = com_google_android_gms_internal_zzfjo.zzpnh;
            int i3 = this.mSize;
            for (i = 0; i < i3; i++) {
                if (!com_google_android_gms_internal_zzfjpArr[i].equals(com_google_android_gms_internal_zzfjpArr2[i])) {
                    z2 = false;
                    break;
                }
            }
            z2 = true;
            if (z2) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = 17;
        for (int i2 = 0; i2 < this.mSize; i2++) {
            i = (((i * 31) + this.zzpng[i2]) * 31) + this.zzpnh[i2].hashCode();
        }
        return i;
    }

    public final boolean isEmpty() {
        return this.mSize == 0;
    }

    final int size() {
        return this.mSize;
    }

    final void zza(int r1, com.google.android.gms.internal.zzfjp r2) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.DecodeException: Load method exception in method: com.google.android.gms.internal.zzfjo.zza(int, com.google.android.gms.internal.zzfjp):void
	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:116)
	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:249)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
Caused by: jadx.core.utils.exceptions.DecodeException: Unknown instruction: not-int
	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:568)
	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:56)
	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:102)
	... 5 more
*/
        /*
        // Can't load method instructions.
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzfjo.zza(int, com.google.android.gms.internal.zzfjp):void");
    }

    final zzfjp zzmj(int i) {
        i = zzml(i);
        if (i >= 0) {
            if (this.zzpnh[i] != zzpne) {
                return this.zzpnh[i];
            }
        }
        return null;
    }

    final zzfjp zzmk(int i) {
        return this.zzpnh[i];
    }
}
