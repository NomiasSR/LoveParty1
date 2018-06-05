package com.google.android.gms.common.data;

import java.util.NoSuchElementException;

public final class zzh<T> extends zzb<T> {
    private T zzfwq;

    public zzh(DataBuffer<T> dataBuffer) {
        super(dataBuffer);
    }

    public final T next() {
        if (hasNext()) {
            this.zzfvv++;
            if (this.zzfvv == 0) {
                this.zzfwq = this.zzfvu.get(0);
                if (!(this.zzfwq instanceof zzc)) {
                    String valueOf = String.valueOf(this.zzfwq.getClass());
                    StringBuilder stringBuilder = new StringBuilder(44 + String.valueOf(valueOf).length());
                    stringBuilder.append("DataBuffer reference of type ");
                    stringBuilder.append(valueOf);
                    stringBuilder.append(" is not movable");
                    throw new IllegalStateException(stringBuilder.toString());
                }
            }
            ((zzc) this.zzfwq).zzbx(this.zzfvv);
            return this.zzfwq;
        }
        int i = this.zzfvv;
        stringBuilder = new StringBuilder(46);
        stringBuilder.append("Cannot advance the iterator beyond ");
        stringBuilder.append(i);
        throw new NoSuchElementException(stringBuilder.toString());
    }
}
