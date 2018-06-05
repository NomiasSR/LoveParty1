package com.google.android.gms.common.data;

import com.google.android.gms.common.internal.zzbq;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class zzb<T> implements Iterator<T> {
    protected final DataBuffer<T> zzfvu;
    protected int zzfvv = -1;

    public zzb(DataBuffer<T> dataBuffer) {
        this.zzfvu = (DataBuffer) zzbq.checkNotNull(dataBuffer);
    }

    public boolean hasNext() {
        return this.zzfvv < this.zzfvu.getCount() - 1;
    }

    public T next() {
        if (hasNext()) {
            DataBuffer dataBuffer = this.zzfvu;
            int i = this.zzfvv + 1;
            this.zzfvv = i;
            return dataBuffer.get(i);
        }
        i = this.zzfvv;
        StringBuilder stringBuilder = new StringBuilder(46);
        stringBuilder.append("Cannot advance the iterator beyond ");
        stringBuilder.append(i);
        throw new NoSuchElementException(stringBuilder.toString());
    }

    public void remove() {
        throw new UnsupportedOperationException("Cannot remove elements from a DataBufferIterator");
    }
}
