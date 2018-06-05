package com.google.android.gms.internal;

import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;

final class zzekq implements zzekp {
    private static ThreadLocal<CharsetDecoder> zzndn = new zzekr();
    private static ThreadLocal<CharsetEncoder> zzndo = new zzeks();
    private StringBuilder zzndp = new StringBuilder();

    zzekq() {
    }

    private static java.lang.String zzap(byte[] r1) {
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
        r1 = java.nio.ByteBuffer.wrap(r1);	 Catch:{ CharacterCodingException -> 0x0015 }
        r0 = zzndn;	 Catch:{ CharacterCodingException -> 0x0015 }
        r0 = r0.get();	 Catch:{ CharacterCodingException -> 0x0015 }
        r0 = (java.nio.charset.CharsetDecoder) r0;	 Catch:{ CharacterCodingException -> 0x0015 }
        r1 = r0.decode(r1);	 Catch:{ CharacterCodingException -> 0x0015 }
        r1 = r1.toString();	 Catch:{ CharacterCodingException -> 0x0015 }
        return r1;
    L_0x0015:
        r1 = 0;
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzekq.zzap(byte[]):java.lang.String");
    }

    public final boolean zzao(byte[] bArr) {
        String zzap = zzap(bArr);
        if (zzap == null) {
            return false;
        }
        this.zzndp.append(zzap);
        return true;
    }

    public final zzelc zzcar() {
        return new zzelc(this.zzndp.toString());
    }
}
