package com.google.android.gms.internal;

import java.util.Iterator;

final class zzeax implements Iterable<zzeaz> {
    private final int length;
    private long value;

    public zzeax(int i) {
        i++;
        this.length = (int) Math.floor(Math.log((double) i) / Math.log(2.0d));
        this.value = (((long) Math.pow(2.0d, (double) this.length)) - 1) & ((long) i);
    }

    public final Iterator<zzeaz> iterator() {
        return new zzeay(this);
    }
}
