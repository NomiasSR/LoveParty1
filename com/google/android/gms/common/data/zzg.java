package com.google.android.gms.common.data;

import java.util.ArrayList;

public abstract class zzg<T> extends AbstractDataBuffer<T> {
    private boolean zzfwo = false;
    private ArrayList<Integer> zzfwp;

    protected zzg(DataHolder dataHolder) {
        super(dataHolder);
    }

    private final void zzakb() {
        synchronized (this) {
            if (!this.zzfwo) {
                int i = this.zzfqt.zzfwg;
                this.zzfwp = new ArrayList();
                if (i > 0) {
                    this.zzfwp.add(Integer.valueOf(0));
                    String zzaka = zzaka();
                    Object zzd = this.zzfqt.zzd(zzaka, 0, this.zzfqt.zzbz(0));
                    for (int i2 = 1; i2 < i; i2++) {
                        int zzbz = this.zzfqt.zzbz(i2);
                        String zzd2 = this.zzfqt.zzd(zzaka, i2, zzbz);
                        if (zzd2 == null) {
                            StringBuilder stringBuilder = new StringBuilder(78 + String.valueOf(zzaka).length());
                            stringBuilder.append("Missing value for markerColumn: ");
                            stringBuilder.append(zzaka);
                            stringBuilder.append(", at row: ");
                            stringBuilder.append(i2);
                            stringBuilder.append(", for window: ");
                            stringBuilder.append(zzbz);
                            throw new NullPointerException(stringBuilder.toString());
                        }
                        if (!zzd2.equals(zzd)) {
                            this.zzfwp.add(Integer.valueOf(i2));
                            zzd = zzd2;
                        }
                    }
                }
                this.zzfwo = true;
            }
        }
    }

    private final int zzcc(int i) {
        if (i >= 0) {
            if (i < this.zzfwp.size()) {
                return ((Integer) this.zzfwp.get(i)).intValue();
            }
        }
        StringBuilder stringBuilder = new StringBuilder(53);
        stringBuilder.append("Position ");
        stringBuilder.append(i);
        stringBuilder.append(" is out of bounds for this buffer");
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    public final T get(int i) {
        int intValue;
        zzakb();
        int zzcc = zzcc(i);
        if (i >= 0) {
            if (i != this.zzfwp.size()) {
                intValue = (i == this.zzfwp.size() - 1 ? this.zzfqt.zzfwg : ((Integer) this.zzfwp.get(i + 1)).intValue()) - ((Integer) this.zzfwp.get(i)).intValue();
                if (intValue == 1) {
                    this.zzfqt.zzbz(zzcc(i));
                }
                return zzl(zzcc, intValue);
            }
        }
        intValue = 0;
        return zzl(zzcc, intValue);
    }

    public int getCount() {
        zzakb();
        return this.zzfwp.size();
    }

    protected abstract String zzaka();

    protected abstract T zzl(int i, int i2);
}
