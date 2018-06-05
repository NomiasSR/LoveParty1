package com.google.android.gms.maps.model;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

public abstract class UrlTileProvider implements TileProvider {
    private final int zzalv;
    private final int zzalw;

    public UrlTileProvider(int i, int i2) {
        this.zzalv = i;
        this.zzalw = i2;
    }

    private static long zza(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[4096];
        long j = 0;
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                return j;
            }
            outputStream.write(bArr, 0, read);
            j += (long) read;
        }
    }

    public final com.google.android.gms.maps.model.Tile getTile(int r3, int r4, int r5) {
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
        r2 = this;
        r3 = r2.getTileUrl(r3, r4, r5);
        if (r3 != 0) goto L_0x0009;
    L_0x0006:
        r3 = NO_TILE;
        return r3;
    L_0x0009:
        r4 = new com.google.android.gms.maps.model.Tile;	 Catch:{ IOException -> 0x0023 }
        r5 = r2.zzalv;	 Catch:{ IOException -> 0x0023 }
        r0 = r2.zzalw;	 Catch:{ IOException -> 0x0023 }
        r3 = r3.openStream();	 Catch:{ IOException -> 0x0023 }
        r1 = new java.io.ByteArrayOutputStream;	 Catch:{ IOException -> 0x0023 }
        r1.<init>();	 Catch:{ IOException -> 0x0023 }
        zza(r3, r1);	 Catch:{ IOException -> 0x0023 }
        r3 = r1.toByteArray();	 Catch:{ IOException -> 0x0023 }
        r4.<init>(r5, r0, r3);	 Catch:{ IOException -> 0x0023 }
        return r4;
    L_0x0023:
        r4 = 0;
        return r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.maps.model.UrlTileProvider.getTile(int, int, int):com.google.android.gms.maps.model.Tile");
    }

    public abstract URL getTileUrl(int i, int i2, int i3);
}
