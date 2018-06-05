package com.google.android.gms.internal;

import com.google.firebase.database.DatabaseException;
import com.google.firebase.database.GenericTypeIndicator;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public final class zzelw {
    private static final ConcurrentMap<Class<?>, zzelx<?>> zznfj = new ConcurrentHashMap();

    public static <T> T zza(Object obj, GenericTypeIndicator<T> genericTypeIndicator) {
        Type genericSuperclass = genericTypeIndicator.getClass().getGenericSuperclass();
        if (genericSuperclass instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) genericSuperclass;
            if (parameterizedType.getRawType().equals(GenericTypeIndicator.class)) {
                return zza(obj, parameterizedType.getActualTypeArguments()[0]);
            }
            String valueOf = String.valueOf(genericSuperclass);
            StringBuilder stringBuilder = new StringBuilder(47 + String.valueOf(valueOf).length());
            stringBuilder.append("Not a direct subclass of GenericTypeIndicator: ");
            stringBuilder.append(valueOf);
            throw new DatabaseException(stringBuilder.toString());
        }
        valueOf = String.valueOf(genericSuperclass);
        stringBuilder = new StringBuilder(47 + String.valueOf(valueOf).length());
        stringBuilder.append("Not a direct subclass of GenericTypeIndicator: ");
        stringBuilder.append(valueOf);
        throw new DatabaseException(stringBuilder.toString());
    }

    public static <T> T zza(Object obj, Class<T> cls) {
        return zzb(obj, (Class) cls);
    }

    private static <T> T zza(Object obj, Type type) {
        if (obj == null) {
            return null;
        }
        StringBuilder stringBuilder;
        String valueOf;
        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            Class cls = (Class) parameterizedType.getRawType();
            int i = 0;
            T arrayList;
            if (List.class.isAssignableFrom(cls)) {
                type = parameterizedType.getActualTypeArguments()[0];
                if (obj instanceof List) {
                    List<Object> list = (List) obj;
                    arrayList = new ArrayList(list.size());
                    for (Object zza : list) {
                        arrayList.add(zza(zza, type));
                    }
                    return arrayList;
                }
                String valueOf2 = String.valueOf(obj.getClass());
                stringBuilder = new StringBuilder(47 + String.valueOf(valueOf2).length());
                stringBuilder.append("Expected a List while deserializing, but got a ");
                stringBuilder.append(valueOf2);
                throw new DatabaseException(stringBuilder.toString());
            } else if (Map.class.isAssignableFrom(cls)) {
                Object obj2 = parameterizedType.getActualTypeArguments()[0];
                type = parameterizedType.getActualTypeArguments()[1];
                if (obj2.equals(String.class)) {
                    r6 = zzby(obj);
                    arrayList = new HashMap();
                    for (Entry entry : r6.entrySet()) {
                        arrayList.put((String) entry.getKey(), zza(entry.getValue(), type));
                    }
                    return arrayList;
                }
                valueOf = String.valueOf(obj2);
                stringBuilder = new StringBuilder(70 + String.valueOf(valueOf).length());
                stringBuilder.append("Only Maps with string keys are supported, but found Map with key type ");
                stringBuilder.append(valueOf);
                throw new DatabaseException(stringBuilder.toString());
            } else if (Collection.class.isAssignableFrom(cls)) {
                throw new DatabaseException("Collections are not supported, please use Lists instead");
            } else {
                r6 = zzby(obj);
                zzelx zzf = zzf(cls);
                Map hashMap = new HashMap();
                TypeVariable[] typeParameters = zzf.zznfk.getTypeParameters();
                Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
                if (actualTypeArguments.length != typeParameters.length) {
                    throw new IllegalStateException("Mismatched lengths for type variables and actual types");
                }
                while (i < typeParameters.length) {
                    hashMap.put(typeParameters[i], actualTypeArguments[i]);
                    i++;
                }
                return zzf.zze(r6, hashMap);
            }
        } else if (type instanceof Class) {
            return zzb(obj, (Class) type);
        } else {
            if (type instanceof WildcardType) {
                throw new DatabaseException("Generic wildcard types are not supported");
            } else if (type instanceof GenericArrayType) {
                throw new DatabaseException("Generic Arrays are not supported, please use Lists instead");
            } else {
                valueOf = String.valueOf(type);
                stringBuilder = new StringBuilder(26 + String.valueOf(valueOf).length());
                stringBuilder.append("Unknown type encountered: ");
                stringBuilder.append(valueOf);
                throw new IllegalStateException(stringBuilder.toString());
            }
        }
    }

    public static Map<String, Object> zzan(Map<String, Object> map) {
        Object zzbx = zzbx(map);
        zzelt.zzcp(zzbx instanceof Map);
        return (Map) zzbx;
    }

    private static <T> T zzb(Object obj, Class<T> cls) {
        if (obj == null) {
            return null;
        }
        String name;
        String name2;
        if (!(cls.isPrimitive() || Number.class.isAssignableFrom(cls) || Boolean.class.isAssignableFrom(cls))) {
            if (!Character.class.isAssignableFrom(cls)) {
                if (String.class.isAssignableFrom(cls)) {
                    if (obj instanceof String) {
                        return (String) obj;
                    }
                    name = obj.getClass().getName();
                    StringBuilder stringBuilder = new StringBuilder(42 + String.valueOf(name).length());
                    stringBuilder.append("Failed to convert value of type ");
                    stringBuilder.append(name);
                    stringBuilder.append(" to String");
                    throw new DatabaseException(stringBuilder.toString());
                } else if (cls.isArray()) {
                    throw new DatabaseException("Converting to Arrays is not supported, please use Listsinstead");
                } else if (cls.getTypeParameters().length > 0) {
                    name2 = cls.getName();
                    StringBuilder stringBuilder2 = new StringBuilder(75 + String.valueOf(name2).length());
                    stringBuilder2.append("Class ");
                    stringBuilder2.append(name2);
                    stringBuilder2.append(" has generic type parameters, please use GenericTypeIndicator instead");
                    throw new DatabaseException(stringBuilder2.toString());
                } else if (cls.equals(Object.class)) {
                    return obj;
                } else {
                    if (cls.isEnum()) {
                        return zzc(obj, cls);
                    }
                    zzelx zzf = zzf(cls);
                    if (obj instanceof Map) {
                        return zzf.zze(zzby(obj), Collections.emptyMap());
                    }
                    name = obj.getClass().getName();
                    name2 = cls.getName();
                    StringBuilder stringBuilder3 = new StringBuilder((38 + String.valueOf(name).length()) + String.valueOf(name2).length());
                    stringBuilder3.append("Can't convert object of type ");
                    stringBuilder3.append(name);
                    stringBuilder3.append(" to type ");
                    stringBuilder3.append(name2);
                    throw new DatabaseException(stringBuilder3.toString());
                }
            }
        }
        if (!Integer.class.isAssignableFrom(cls)) {
            if (!Integer.TYPE.isAssignableFrom(cls)) {
                if (!Boolean.class.isAssignableFrom(cls)) {
                    if (!Boolean.TYPE.isAssignableFrom(cls)) {
                        if (!Double.class.isAssignableFrom(cls)) {
                            if (!Double.TYPE.isAssignableFrom(cls)) {
                                if (!Long.class.isAssignableFrom(cls)) {
                                    if (!Long.TYPE.isAssignableFrom(cls)) {
                                        if (!Float.class.isAssignableFrom(cls)) {
                                            if (!Float.TYPE.isAssignableFrom(cls)) {
                                                if (!Short.class.isAssignableFrom(cls)) {
                                                    if (!Short.TYPE.isAssignableFrom(cls)) {
                                                        if (!Byte.class.isAssignableFrom(cls)) {
                                                            if (!Byte.TYPE.isAssignableFrom(cls)) {
                                                                if (!Character.class.isAssignableFrom(cls)) {
                                                                    if (!Character.TYPE.isAssignableFrom(cls)) {
                                                                        name2 = String.valueOf(cls);
                                                                        stringBuilder2 = new StringBuilder(24 + String.valueOf(name2).length());
                                                                        stringBuilder2.append("Unknown primitive type: ");
                                                                        stringBuilder2.append(name2);
                                                                        throw new IllegalArgumentException(stringBuilder2.toString());
                                                                    }
                                                                }
                                                                throw new DatabaseException("Deserializing to char is not supported");
                                                            }
                                                        }
                                                        throw new DatabaseException("Deserializing to bytes is not supported");
                                                    }
                                                }
                                                throw new DatabaseException("Deserializing to shorts is not supported");
                                            }
                                        }
                                        return Float.valueOf(zzbz(obj).floatValue());
                                    }
                                }
                                if (obj instanceof Integer) {
                                    return Long.valueOf(((Integer) obj).longValue());
                                }
                                if (obj instanceof Long) {
                                    return (Long) obj;
                                }
                                if (obj instanceof Double) {
                                    Double d = (Double) obj;
                                    if (d.doubleValue() >= -9.223372036854776E18d && d.doubleValue() <= 9.223372036854776E18d) {
                                        return Long.valueOf(d.longValue());
                                    }
                                    name = String.valueOf(d);
                                    stringBuilder2 = new StringBuilder(89 + String.valueOf(name).length());
                                    stringBuilder2.append("Numeric value out of 64-bit long range: ");
                                    stringBuilder2.append(name);
                                    stringBuilder2.append(". Did you mean to use a double instead of a long?");
                                    throw new DatabaseException(stringBuilder2.toString());
                                }
                                name = obj.getClass().getName();
                                stringBuilder = new StringBuilder(42 + String.valueOf(name).length());
                                stringBuilder.append("Failed to convert a value of type ");
                                stringBuilder.append(name);
                                stringBuilder.append(" to long");
                                throw new DatabaseException(stringBuilder.toString());
                            }
                        }
                        return zzbz(obj);
                    }
                }
                if (obj instanceof Boolean) {
                    return (Boolean) obj;
                }
                name = obj.getClass().getName();
                stringBuilder2 = new StringBuilder(43 + String.valueOf(name).length());
                stringBuilder2.append("Failed to convert value of type ");
                stringBuilder2.append(name);
                stringBuilder2.append(" to boolean");
                throw new DatabaseException(stringBuilder2.toString());
            }
        }
        if (obj instanceof Integer) {
            return (Integer) obj;
        }
        if (!(obj instanceof Long)) {
            if (!(obj instanceof Double)) {
                name = obj.getClass().getName();
                stringBuilder2 = new StringBuilder(41 + String.valueOf(name).length());
                stringBuilder2.append("Failed to convert a value of type ");
                stringBuilder2.append(name);
                stringBuilder2.append(" to int");
                throw new DatabaseException(stringBuilder2.toString());
            }
        }
        Number number = (Number) obj;
        double doubleValue = number.doubleValue();
        if (doubleValue >= -2.147483648E9d && doubleValue <= 2.147483647E9d) {
            return Integer.valueOf(number.intValue());
        }
        stringBuilder3 = new StringBuilder(124);
        stringBuilder3.append("Numeric value out of 32-bit integer range: ");
        stringBuilder3.append(doubleValue);
        stringBuilder3.append(". Did you mean to use a long or double instead of an int?");
        throw new DatabaseException(stringBuilder3.toString());
    }

    public static Object zzbw(Object obj) {
        return zzbx(obj);
    }

    private static <T> Object zzbx(T t) {
        if (t == null) {
            return null;
        }
        if (t instanceof Number) {
            if (!(t instanceof Float)) {
                if (!(t instanceof Double)) {
                    if (t instanceof Short) {
                        throw new DatabaseException("Shorts are not supported, please use int or long");
                    } else if (!(t instanceof Byte)) {
                        return t;
                    } else {
                        throw new DatabaseException("Bytes are not supported, please use int or long");
                    }
                }
            }
            Number number = (Number) t;
            double doubleValue = number.doubleValue();
            return (doubleValue > 9.223372036854776E18d || doubleValue < -9.223372036854776E18d || Math.floor(doubleValue) != doubleValue) ? Double.valueOf(doubleValue) : Long.valueOf(number.longValue());
        } else if ((t instanceof String) || (t instanceof Boolean)) {
            return t;
        } else {
            if (t instanceof Character) {
                throw new DatabaseException("Characters are not supported, please use Strings");
            } else if (t instanceof Map) {
                Map hashMap = new HashMap();
                for (Entry entry : ((Map) t).entrySet()) {
                    Object key = entry.getKey();
                    if (key instanceof String) {
                        hashMap.put((String) key, zzbx(entry.getValue()));
                    } else {
                        throw new DatabaseException("Maps with non-string keys are not supported");
                    }
                }
                return hashMap;
            } else if (t instanceof Collection) {
                if (t instanceof List) {
                    List<Object> list = (List) t;
                    List arrayList = new ArrayList(list.size());
                    for (Object zzbx : list) {
                        arrayList.add(zzbx(zzbx));
                    }
                    return arrayList;
                }
                throw new DatabaseException("Serializing Collections is not supported, please use Lists instead");
            } else if (!t.getClass().isArray()) {
                return t instanceof Enum ? ((Enum) t).name() : zzf(t.getClass()).zzcb(t);
            } else {
                throw new DatabaseException("Serializing Arrays is not supported, please use Lists instead");
            }
        }
    }

    private static Map<String, Object> zzby(Object obj) {
        if (obj instanceof Map) {
            return (Map) obj;
        }
        String valueOf = String.valueOf(obj.getClass());
        StringBuilder stringBuilder = new StringBuilder(46 + String.valueOf(valueOf).length());
        stringBuilder.append("Expected a Map while deserializing, but got a ");
        stringBuilder.append(valueOf);
        throw new DatabaseException(stringBuilder.toString());
    }

    private static Double zzbz(Object obj) {
        if (obj instanceof Integer) {
            return Double.valueOf(((Integer) obj).doubleValue());
        }
        String valueOf;
        StringBuilder stringBuilder;
        if (obj instanceof Long) {
            Long l = (Long) obj;
            Double valueOf2 = Double.valueOf(l.doubleValue());
            if (valueOf2.longValue() == l.longValue()) {
                return valueOf2;
            }
            valueOf = String.valueOf(obj);
            stringBuilder = new StringBuilder(97 + String.valueOf(valueOf).length());
            stringBuilder.append("Loss of precision while converting number to double: ");
            stringBuilder.append(valueOf);
            stringBuilder.append(". Did you mean to use a 64-bit long instead?");
            throw new DatabaseException(stringBuilder.toString());
        } else if (obj instanceof Double) {
            return (Double) obj;
        } else {
            valueOf = obj.getClass().getName();
            stringBuilder = new StringBuilder(44 + String.valueOf(valueOf).length());
            stringBuilder.append("Failed to convert a value of type ");
            stringBuilder.append(valueOf);
            stringBuilder.append(" to double");
            throw new DatabaseException(stringBuilder.toString());
        }
    }

    private static <T> T zzc(java.lang.Object r3, java.lang.Class<T> r4) {
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
        r0 = r3 instanceof java.lang.String;
        if (r0 == 0) goto L_0x0047;
    L_0x0004:
        r3 = (java.lang.String) r3;
        r0 = java.lang.Enum.valueOf(r4, r3);	 Catch:{ IllegalArgumentException -> 0x000b }
        return r0;
    L_0x000b:
        r0 = new com.google.firebase.database.DatabaseException;
        r4 = r4.getName();
        r1 = 42;
        r2 = java.lang.String.valueOf(r4);
        r2 = r2.length();
        r1 = r1 + r2;
        r2 = java.lang.String.valueOf(r3);
        r2 = r2.length();
        r1 = r1 + r2;
        r2 = new java.lang.StringBuilder;
        r2.<init>(r1);
        r1 = "Could not find enum value of ";
        r2.append(r1);
        r2.append(r4);
        r4 = " for value \"";
        r2.append(r4);
        r2.append(r3);
        r3 = "\"";
        r2.append(r3);
        r3 = r2.toString();
        r0.<init>(r3);
        throw r0;
    L_0x0047:
        r0 = new com.google.firebase.database.DatabaseException;
        r4 = java.lang.String.valueOf(r4);
        r3 = r3.getClass();
        r3 = java.lang.String.valueOf(r3);
        r1 = 57;
        r2 = java.lang.String.valueOf(r4);
        r2 = r2.length();
        r1 = r1 + r2;
        r2 = java.lang.String.valueOf(r3);
        r2 = r2.length();
        r1 = r1 + r2;
        r2 = new java.lang.StringBuilder;
        r2.<init>(r1);
        r1 = "Expected a String while deserializing to enum ";
        r2.append(r1);
        r2.append(r4);
        r4 = " but got a ";
        r2.append(r4);
        r2.append(r3);
        r3 = r2.toString();
        r0.<init>(r3);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzelw.zzc(java.lang.Object, java.lang.Class):T");
    }

    private static <T> zzelx<T> zzf(Class<T> cls) {
        zzelx<T> com_google_android_gms_internal_zzelx_T = (zzelx) zznfj.get(cls);
        if (com_google_android_gms_internal_zzelx_T != null) {
            return com_google_android_gms_internal_zzelx_T;
        }
        com_google_android_gms_internal_zzelx_T = new zzelx(cls);
        zznfj.put(cls, com_google_android_gms_internal_zzelx_T);
        return com_google_android_gms_internal_zzelx_T;
    }
}
