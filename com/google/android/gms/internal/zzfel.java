package com.google.android.gms.internal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class zzfel<MessageType extends zzfek<MessageType, BuilderType>, BuilderType extends zzfel<MessageType, BuilderType>> implements zzfhf {
    protected static <T> void zza(Iterable<T> iterable, List<? super T> list) {
        zzffz.checkNotNull(iterable);
        if (iterable instanceof zzfgl) {
            List zzcyl = ((zzfgl) iterable).zzcyl();
            zzfgl com_google_android_gms_internal_zzfgl = (zzfgl) list;
            int size = list.size();
            for (Object next : zzcyl) {
                if (next == null) {
                    int size2 = com_google_android_gms_internal_zzfgl.size() - size;
                    StringBuilder stringBuilder = new StringBuilder(37);
                    stringBuilder.append("Element at index ");
                    stringBuilder.append(size2);
                    stringBuilder.append(" is null.");
                    String stringBuilder2 = stringBuilder.toString();
                    for (int size3 = com_google_android_gms_internal_zzfgl.size() - 1; size3 >= size; size3--) {
                        com_google_android_gms_internal_zzfgl.remove(size3);
                    }
                    throw new NullPointerException(stringBuilder2);
                } else if (!(next instanceof zzfes)) {
                    com_google_android_gms_internal_zzfgl.add((String) next);
                }
            }
        } else if (iterable instanceof zzfhl) {
            list.addAll((Collection) iterable);
        } else {
            zzb((Iterable) iterable, (List) list);
        }
    }

    private static <T> void zzb(Iterable<T> iterable, List<? super T> list) {
        if ((list instanceof ArrayList) && (iterable instanceof Collection)) {
            ((ArrayList) list).ensureCapacity(list.size() + ((Collection) iterable).size());
        }
        int size = list.size();
        for (Object next : iterable) {
            if (next == null) {
                int size2 = list.size() - size;
                StringBuilder stringBuilder = new StringBuilder(37);
                stringBuilder.append("Element at index ");
                stringBuilder.append(size2);
                stringBuilder.append(" is null.");
                String stringBuilder2 = stringBuilder.toString();
                for (int size3 = list.size() - 1; size3 >= size; size3--) {
                    list.remove(size3);
                }
                throw new NullPointerException(stringBuilder2);
            }
            list.add(next);
        }
    }

    public /* synthetic */ Object clone() throws CloneNotSupportedException {
        return zzcvh();
    }

    protected abstract BuilderType zza(MessageType messageType);

    public abstract BuilderType zza(zzffb com_google_android_gms_internal_zzffb, zzffm com_google_android_gms_internal_zzffm) throws IOException;

    public /* synthetic */ zzfhf zzb(zzffb com_google_android_gms_internal_zzffb, zzffm com_google_android_gms_internal_zzffm) throws IOException {
        return zza(com_google_android_gms_internal_zzffb, com_google_android_gms_internal_zzffm);
    }

    public abstract BuilderType zzcvh();

    public final /* synthetic */ zzfhf zzd(zzfhe com_google_android_gms_internal_zzfhe) {
        if (zzcxq().getClass().isInstance(com_google_android_gms_internal_zzfhe)) {
            return zza((zzfek) com_google_android_gms_internal_zzfhe);
        }
        throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
    }
}
