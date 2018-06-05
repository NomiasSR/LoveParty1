package com.google.android.gms.internal;

import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Stack;

public final class zzeak<K, V> implements Iterator<Entry<K, V>> {
    private final Stack<zzeat<K, V>> zzmmg = new Stack();
    private final boolean zzmmh;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    zzeak(com.google.android.gms.internal.zzeap<K, V> r3, K r4, java.util.Comparator<K> r5, boolean r6) {
        /*
        r2 = this;
        r2.<init>();
        r0 = new java.util.Stack;
        r0.<init>();
        r2.zzmmg = r0;
        r2.zzmmh = r6;
    L_0x000c:
        r0 = r3.isEmpty();
        if (r0 != 0) goto L_0x004c;
    L_0x0012:
        if (r4 == 0) goto L_0x0028;
    L_0x0014:
        if (r6 == 0) goto L_0x001f;
    L_0x0016:
        r0 = r3.getKey();
        r0 = r5.compare(r4, r0);
        goto L_0x0029;
    L_0x001f:
        r0 = r3.getKey();
        r0 = r5.compare(r0, r4);
        goto L_0x0029;
    L_0x0028:
        r0 = 1;
    L_0x0029:
        if (r0 >= 0) goto L_0x0032;
    L_0x002b:
        if (r6 != 0) goto L_0x0047;
    L_0x002d:
        r3 = r3.zzbtq();
        goto L_0x000c;
    L_0x0032:
        if (r0 != 0) goto L_0x003c;
    L_0x0034:
        r4 = r2.zzmmg;
        r3 = (com.google.android.gms.internal.zzeat) r3;
        r4.push(r3);
        return;
    L_0x003c:
        r0 = r2.zzmmg;
        r1 = r3;
        r1 = (com.google.android.gms.internal.zzeat) r1;
        r0.push(r1);
        if (r6 == 0) goto L_0x0047;
    L_0x0046:
        goto L_0x002d;
    L_0x0047:
        r3 = r3.zzbtp();
        goto L_0x000c;
    L_0x004c:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzeak.<init>(com.google.android.gms.internal.zzeap, java.lang.Object, java.util.Comparator, boolean):void");
    }

    private final java.util.Map.Entry<K, V> next() {
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
        r4 = this;
        r0 = r4.zzmmg;	 Catch:{ EmptyStackException -> 0x0048 }
        r0 = r0.pop();	 Catch:{ EmptyStackException -> 0x0048 }
        r0 = (com.google.android.gms.internal.zzeat) r0;	 Catch:{ EmptyStackException -> 0x0048 }
        r1 = new java.util.AbstractMap$SimpleEntry;	 Catch:{ EmptyStackException -> 0x0048 }
        r2 = r0.getKey();	 Catch:{ EmptyStackException -> 0x0048 }
        r3 = r0.getValue();	 Catch:{ EmptyStackException -> 0x0048 }
        r1.<init>(r2, r3);	 Catch:{ EmptyStackException -> 0x0048 }
        r2 = r4.zzmmh;	 Catch:{ EmptyStackException -> 0x0048 }
        if (r2 == 0) goto L_0x0030;	 Catch:{ EmptyStackException -> 0x0048 }
    L_0x0019:
        r0 = r0.zzbtp();	 Catch:{ EmptyStackException -> 0x0048 }
    L_0x001d:
        r2 = r0.isEmpty();	 Catch:{ EmptyStackException -> 0x0048 }
        if (r2 != 0) goto L_0x0047;	 Catch:{ EmptyStackException -> 0x0048 }
    L_0x0023:
        r2 = r4.zzmmg;	 Catch:{ EmptyStackException -> 0x0048 }
        r3 = r0;	 Catch:{ EmptyStackException -> 0x0048 }
        r3 = (com.google.android.gms.internal.zzeat) r3;	 Catch:{ EmptyStackException -> 0x0048 }
        r2.push(r3);	 Catch:{ EmptyStackException -> 0x0048 }
        r0 = r0.zzbtq();	 Catch:{ EmptyStackException -> 0x0048 }
        goto L_0x001d;	 Catch:{ EmptyStackException -> 0x0048 }
    L_0x0030:
        r0 = r0.zzbtq();	 Catch:{ EmptyStackException -> 0x0048 }
    L_0x0034:
        r2 = r0.isEmpty();	 Catch:{ EmptyStackException -> 0x0048 }
        if (r2 != 0) goto L_0x0047;	 Catch:{ EmptyStackException -> 0x0048 }
    L_0x003a:
        r2 = r4.zzmmg;	 Catch:{ EmptyStackException -> 0x0048 }
        r3 = r0;	 Catch:{ EmptyStackException -> 0x0048 }
        r3 = (com.google.android.gms.internal.zzeat) r3;	 Catch:{ EmptyStackException -> 0x0048 }
        r2.push(r3);	 Catch:{ EmptyStackException -> 0x0048 }
        r0 = r0.zzbtp();	 Catch:{ EmptyStackException -> 0x0048 }
        goto L_0x0034;
    L_0x0047:
        return r1;
    L_0x0048:
        r0 = new java.util.NoSuchElementException;
        r0.<init>();
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzeak.next():java.util.Map$Entry<K, V>");
    }

    public final boolean hasNext() {
        return this.zzmmg.size() > 0;
    }

    public final void remove() {
        throw new UnsupportedOperationException("remove called on immutable collection");
    }
}
