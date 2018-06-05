package com.google.android.gms.internal;

import android.util.Log;
import com.google.firebase.database.DatabaseException;
import com.google.firebase.database.PropertyName;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

final class zzelx<T> {
    private final Class<T> zznfk;
    private final Constructor<T> zznfl;
    private final boolean zznfm;
    private final boolean zznfn;
    private final Map<String, String> zznfo = new HashMap();
    private final Map<String, Method> zznfp = new HashMap();
    private final Map<String, Method> zznfq = new HashMap();
    private final Map<String, Field> zznfr = new HashMap();

    public zzelx(java.lang.Class<T> r13) {
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
        r12 = this;
        r12.<init>();
        r12.zznfk = r13;
        r0 = com.google.firebase.database.ThrowOnExtraProperties.class;
        r0 = r13.isAnnotationPresent(r0);
        r12.zznfm = r0;
        r0 = com.google.firebase.database.IgnoreExtraProperties.class;
        r0 = r13.isAnnotationPresent(r0);
        r1 = 1;
        r0 = r0 ^ r1;
        r12.zznfn = r0;
        r0 = new java.util.HashMap;
        r0.<init>();
        r12.zznfo = r0;
        r0 = new java.util.HashMap;
        r0.<init>();
        r12.zznfq = r0;
        r0 = new java.util.HashMap;
        r0.<init>();
        r12.zznfp = r0;
        r0 = new java.util.HashMap;
        r0.<init>();
        r12.zznfr = r0;
        r0 = 0;
        r2 = new java.lang.Class[r0];	 Catch:{ NoSuchMethodException -> 0x003e }
        r2 = r13.getDeclaredConstructor(r2);	 Catch:{ NoSuchMethodException -> 0x003e }
        r2.setAccessible(r1);	 Catch:{ NoSuchMethodException -> 0x003e }
        goto L_0x003f;
    L_0x003e:
        r2 = 0;
    L_0x003f:
        r12.zznfl = r2;
        r2 = r13.getMethods();
        r3 = r2.length;
        r4 = r0;
    L_0x0047:
        if (r4 >= r3) goto L_0x00e5;
    L_0x0049:
        r5 = r2[r4];
        r6 = r5.getName();
        r7 = "get";
        r6 = r6.startsWith(r7);
        if (r6 != 0) goto L_0x0065;
    L_0x0057:
        r6 = r5.getName();
        r7 = "is";
        r6 = r6.startsWith(r7);
        if (r6 != 0) goto L_0x0065;
    L_0x0063:
        r6 = r0;
        goto L_0x00a7;
    L_0x0065:
        r6 = r5.getDeclaringClass();
        r7 = java.lang.Object.class;
        r6 = r6.equals(r7);
        if (r6 == 0) goto L_0x0072;
    L_0x0071:
        goto L_0x0063;
    L_0x0072:
        r6 = r5.getModifiers();
        r6 = java.lang.reflect.Modifier.isPublic(r6);
        if (r6 != 0) goto L_0x007d;
    L_0x007c:
        goto L_0x0063;
    L_0x007d:
        r6 = r5.getModifiers();
        r6 = java.lang.reflect.Modifier.isStatic(r6);
        if (r6 == 0) goto L_0x0088;
    L_0x0087:
        goto L_0x0063;
    L_0x0088:
        r6 = r5.getReturnType();
        r7 = java.lang.Void.TYPE;
        r6 = r6.equals(r7);
        if (r6 == 0) goto L_0x0095;
    L_0x0094:
        goto L_0x0063;
    L_0x0095:
        r6 = r5.getParameterTypes();
        r6 = r6.length;
        if (r6 == 0) goto L_0x009d;
    L_0x009c:
        goto L_0x0063;
    L_0x009d:
        r6 = com.google.firebase.database.Exclude.class;
        r6 = r5.isAnnotationPresent(r6);
        if (r6 == 0) goto L_0x00a6;
    L_0x00a5:
        goto L_0x0063;
    L_0x00a6:
        r6 = r1;
    L_0x00a7:
        if (r6 == 0) goto L_0x00e1;
    L_0x00a9:
        r6 = zza(r5);
        r12.zzqk(r6);
        r5.setAccessible(r1);
        r7 = r12.zznfp;
        r7 = r7.containsKey(r6);
        if (r7 == 0) goto L_0x00dc;
    L_0x00bb:
        r13 = new com.google.firebase.database.DatabaseException;
        r0 = "Found conflicting getters for name: ";
        r1 = r5.getName();
        r1 = java.lang.String.valueOf(r1);
        r2 = r1.length();
        if (r2 == 0) goto L_0x00d2;
    L_0x00cd:
        r0 = r0.concat(r1);
        goto L_0x00d8;
    L_0x00d2:
        r1 = new java.lang.String;
        r1.<init>(r0);
        r0 = r1;
    L_0x00d8:
        r13.<init>(r0);
        throw r13;
    L_0x00dc:
        r7 = r12.zznfp;
        r7.put(r6, r5);
    L_0x00e1:
        r4 = r4 + 1;
        goto L_0x0047;
    L_0x00e5:
        r2 = r13.getFields();
        r3 = r2.length;
        r4 = r0;
    L_0x00eb:
        if (r4 >= r3) goto L_0x0134;
    L_0x00ed:
        r5 = r2[r4];
        r6 = r5.getDeclaringClass();
        r7 = java.lang.Object.class;
        r6 = r6.equals(r7);
        if (r6 == 0) goto L_0x00fd;
    L_0x00fb:
        r6 = r0;
        goto L_0x0128;
    L_0x00fd:
        r6 = r5.getModifiers();
        r6 = java.lang.reflect.Modifier.isPublic(r6);
        if (r6 != 0) goto L_0x0108;
    L_0x0107:
        goto L_0x00fb;
    L_0x0108:
        r6 = r5.getModifiers();
        r6 = java.lang.reflect.Modifier.isStatic(r6);
        if (r6 == 0) goto L_0x0113;
    L_0x0112:
        goto L_0x00fb;
    L_0x0113:
        r6 = r5.getModifiers();
        r6 = java.lang.reflect.Modifier.isTransient(r6);
        if (r6 == 0) goto L_0x011e;
    L_0x011d:
        goto L_0x00fb;
    L_0x011e:
        r6 = com.google.firebase.database.Exclude.class;
        r6 = r5.isAnnotationPresent(r6);
        if (r6 == 0) goto L_0x0127;
    L_0x0126:
        goto L_0x00fb;
    L_0x0127:
        r6 = r1;
    L_0x0128:
        if (r6 == 0) goto L_0x0131;
    L_0x012a:
        r5 = zza(r5);
        r12.zzqk(r5);
    L_0x0131:
        r4 = r4 + 1;
        goto L_0x00eb;
    L_0x0134:
        r2 = r13;
    L_0x0135:
        r3 = r2.getDeclaredMethods();
        r4 = r3.length;
        r5 = r0;
    L_0x013b:
        if (r5 >= r4) goto L_0x029a;
    L_0x013d:
        r6 = r3[r5];
        r7 = r6.getName();
        r8 = "set";
        r7 = r7.startsWith(r8);
        if (r7 != 0) goto L_0x014d;
    L_0x014b:
        r7 = r0;
        goto L_0x0184;
    L_0x014d:
        r7 = r6.getDeclaringClass();
        r8 = java.lang.Object.class;
        r7 = r7.equals(r8);
        if (r7 == 0) goto L_0x015a;
    L_0x0159:
        goto L_0x014b;
    L_0x015a:
        r7 = r6.getModifiers();
        r7 = java.lang.reflect.Modifier.isStatic(r7);
        if (r7 == 0) goto L_0x0165;
    L_0x0164:
        goto L_0x014b;
    L_0x0165:
        r7 = r6.getReturnType();
        r8 = java.lang.Void.TYPE;
        r7 = r7.equals(r8);
        if (r7 != 0) goto L_0x0172;
    L_0x0171:
        goto L_0x014b;
    L_0x0172:
        r7 = r6.getParameterTypes();
        r7 = r7.length;
        if (r7 == r1) goto L_0x017a;
    L_0x0179:
        goto L_0x014b;
    L_0x017a:
        r7 = com.google.firebase.database.Exclude.class;
        r7 = r6.isAnnotationPresent(r7);
        if (r7 == 0) goto L_0x0183;
    L_0x0182:
        goto L_0x014b;
    L_0x0183:
        r7 = r1;
    L_0x0184:
        if (r7 == 0) goto L_0x0296;
    L_0x0186:
        r7 = zza(r6);
        r8 = r12.zznfo;
        r9 = r7.toLowerCase();
        r8 = r8.get(r9);
        r8 = (java.lang.String) r8;
        if (r8 == 0) goto L_0x0296;
    L_0x0198:
        r8 = r8.equals(r7);
        if (r8 != 0) goto L_0x01bf;
    L_0x019e:
        r13 = new com.google.firebase.database.DatabaseException;
        r0 = "Found setter with invalid case-sensitive name: ";
        r1 = r6.getName();
        r1 = java.lang.String.valueOf(r1);
        r2 = r1.length();
        if (r2 == 0) goto L_0x01b5;
    L_0x01b0:
        r0 = r0.concat(r1);
        goto L_0x01bb;
    L_0x01b5:
        r1 = new java.lang.String;
        r1.<init>(r0);
        r0 = r1;
    L_0x01bb:
        r13.<init>(r0);
        throw r13;
    L_0x01bf:
        r8 = r12.zznfq;
        r8 = r8.get(r7);
        r8 = (java.lang.reflect.Method) r8;
        if (r8 != 0) goto L_0x01d3;
    L_0x01c9:
        r6.setAccessible(r1);
        r8 = r12.zznfq;
        r8.put(r7, r6);
        goto L_0x0296;
    L_0x01d3:
        r7 = r6.getDeclaringClass();
        r9 = r8.getDeclaringClass();
        r7 = r7.isAssignableFrom(r9);
        r9 = "Expected override from a base class";
        com.google.android.gms.internal.zzelt.zzb(r7, r9);
        r7 = r6.getReturnType();
        r9 = java.lang.Void.TYPE;
        r7 = r7.equals(r9);
        r9 = "Expected void return type";
        com.google.android.gms.internal.zzelt.zzb(r7, r9);
        r7 = r8.getReturnType();
        r9 = java.lang.Void.TYPE;
        r7 = r7.equals(r9);
        r9 = "Expected void return type";
        com.google.android.gms.internal.zzelt.zzb(r7, r9);
        r7 = r6.getParameterTypes();
        r9 = r8.getParameterTypes();
        r10 = r7.length;
        if (r10 != r1) goto L_0x020f;
    L_0x020d:
        r10 = r1;
        goto L_0x0210;
    L_0x020f:
        r10 = r0;
    L_0x0210:
        r11 = "Expected exactly one parameter";
        com.google.android.gms.internal.zzelt.zzb(r10, r11);
        r10 = r9.length;
        if (r10 != r1) goto L_0x021a;
    L_0x0218:
        r10 = r1;
        goto L_0x021b;
    L_0x021a:
        r10 = r0;
    L_0x021b:
        r11 = "Expected exactly one parameter";
        com.google.android.gms.internal.zzelt.zzb(r10, r11);
        r10 = r6.getName();
        r11 = r8.getName();
        r10 = r10.equals(r11);
        if (r10 == 0) goto L_0x023a;
    L_0x022e:
        r7 = r7[r0];
        r9 = r9[r0];
        r7 = r7.equals(r9);
        if (r7 == 0) goto L_0x023a;
    L_0x0238:
        r7 = r1;
        goto L_0x023b;
    L_0x023a:
        r7 = r0;
    L_0x023b:
        if (r7 != 0) goto L_0x0296;
    L_0x023d:
        r13 = new com.google.firebase.database.DatabaseException;
        r0 = r6.getName();
        r1 = r8.getName();
        r2 = r8.getDeclaringClass();
        r2 = r2.getName();
        r3 = 69;
        r4 = java.lang.String.valueOf(r0);
        r4 = r4.length();
        r3 = r3 + r4;
        r4 = java.lang.String.valueOf(r1);
        r4 = r4.length();
        r3 = r3 + r4;
        r4 = java.lang.String.valueOf(r2);
        r4 = r4.length();
        r3 = r3 + r4;
        r4 = new java.lang.StringBuilder;
        r4.<init>(r3);
        r3 = "Found a conflicting setters with name: ";
        r4.append(r3);
        r4.append(r0);
        r0 = " (conflicts with ";
        r4.append(r0);
        r4.append(r1);
        r0 = " defined on ";
        r4.append(r0);
        r4.append(r2);
        r0 = ")";
        r4.append(r0);
        r0 = r4.toString();
        r13.<init>(r0);
        throw r13;
    L_0x0296:
        r5 = r5 + 1;
        goto L_0x013b;
    L_0x029a:
        r3 = r2.getDeclaredFields();
        r4 = r3.length;
        r5 = r0;
    L_0x02a0:
        if (r5 >= r4) goto L_0x02c7;
    L_0x02a2:
        r6 = r3[r5];
        r7 = zza(r6);
        r8 = r12.zznfo;
        r9 = r7.toLowerCase();
        r8 = r8.containsKey(r9);
        if (r8 == 0) goto L_0x02c4;
    L_0x02b4:
        r8 = r12.zznfr;
        r8 = r8.containsKey(r7);
        if (r8 != 0) goto L_0x02c4;
    L_0x02bc:
        r6.setAccessible(r1);
        r8 = r12.zznfr;
        r8.put(r7, r6);
    L_0x02c4:
        r5 = r5 + 1;
        goto L_0x02a0;
    L_0x02c7:
        r2 = r2.getSuperclass();
        if (r2 == 0) goto L_0x02d5;
    L_0x02cd:
        r3 = java.lang.Object.class;
        r3 = r2.equals(r3);
        if (r3 == 0) goto L_0x0135;
    L_0x02d5:
        r0 = r12.zznfo;
        r0 = r0.isEmpty();
        if (r0 == 0) goto L_0x02fd;
    L_0x02dd:
        r0 = new com.google.firebase.database.DatabaseException;
        r1 = "No properties to serialize found on class ";
        r13 = r13.getName();
        r13 = java.lang.String.valueOf(r13);
        r2 = r13.length();
        if (r2 == 0) goto L_0x02f4;
    L_0x02ef:
        r13 = r1.concat(r13);
        goto L_0x02f9;
    L_0x02f4:
        r13 = new java.lang.String;
        r13.<init>(r1);
    L_0x02f9:
        r0.<init>(r13);
        throw r0;
    L_0x02fd:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzelx.<init>(java.lang.Class):void");
    }

    private static String zza(AccessibleObject accessibleObject) {
        return accessibleObject.isAnnotationPresent(PropertyName.class) ? ((PropertyName) accessibleObject.getAnnotation(PropertyName.class)).value() : null;
    }

    private static String zza(Field field) {
        String zza = zza((AccessibleObject) field);
        return zza != null ? zza : field.getName();
    }

    private static String zza(Method method) {
        String zza = zza((AccessibleObject) method);
        if (zza != null) {
            return zza;
        }
        String name = method.getName();
        String[] strArr = new String[]{"get", "set", "is"};
        int i = 0;
        String str = null;
        for (int i2 = 0; i2 < 3; i2++) {
            String str2 = strArr[i2];
            if (name.startsWith(str2)) {
                str = str2;
            }
        }
        if (str == null) {
            String str3 = "Unknown Bean prefix for method: ";
            name = String.valueOf(name);
            throw new IllegalArgumentException(name.length() != 0 ? str3.concat(name) : new String(str3));
        }
        char[] toCharArray = name.substring(str.length()).toCharArray();
        while (i < toCharArray.length && Character.isUpperCase(toCharArray[i])) {
            toCharArray[i] = Character.toLowerCase(toCharArray[i]);
            i++;
        }
        return new String(toCharArray);
    }

    private static Type zza(Type type, Map<TypeVariable<Class<T>>, Type> map) {
        if (!(type instanceof TypeVariable)) {
            return type;
        }
        Type type2 = (Type) map.get(type);
        if (type2 != null) {
            return type2;
        }
        String valueOf = String.valueOf(type);
        StringBuilder stringBuilder = new StringBuilder(23 + String.valueOf(valueOf).length());
        stringBuilder.append("Could not resolve type ");
        stringBuilder.append(valueOf);
        throw new IllegalStateException(stringBuilder.toString());
    }

    private final void zzqk(String str) {
        String str2 = (String) this.zznfo.put(str.toLowerCase(), str);
        if (str2 != null && !str.equals(str2)) {
            String str3 = "Found two getters or fields with conflicting case sensitivity for property: ";
            str = String.valueOf(str.toLowerCase());
            throw new DatabaseException(str.length() != 0 ? str3.concat(str) : new String(str3));
        }
    }

    public final Map<String, Object> zzcb(T t) {
        if (this.zznfk.isAssignableFrom(t.getClass())) {
            Map<String, Object> hashMap = new HashMap();
            for (String str : this.zznfo.values()) {
                Object invoke;
                if (this.zznfp.containsKey(str)) {
                    try {
                        invoke = ((Method) this.zznfp.get(str)).invoke(t, new Object[0]);
                    } catch (Throwable e) {
                        throw new RuntimeException(e);
                    } catch (Throwable e2) {
                        throw new RuntimeException(e2);
                    }
                }
                Field field = (Field) this.zznfr.get(str);
                if (field == null) {
                    String str2 = "Bean property without field or getter:";
                    String valueOf = String.valueOf(str);
                    throw new IllegalStateException(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
                }
                try {
                    invoke = field.get(t);
                } catch (Throwable e22) {
                    throw new RuntimeException(e22);
                }
                hashMap.put(str, zzelw.zzbx(invoke));
            }
            return hashMap;
        }
        String valueOf2 = String.valueOf(t.getClass());
        valueOf = String.valueOf(this.zznfk);
        StringBuilder stringBuilder = new StringBuilder((59 + String.valueOf(valueOf2).length()) + String.valueOf(valueOf).length());
        stringBuilder.append("Can't serialize object of class ");
        stringBuilder.append(valueOf2);
        stringBuilder.append(" with BeanMapper for class ");
        stringBuilder.append(valueOf);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    public final T zze(Map<String, Object> map, Map<TypeVariable<Class<T>>, Type> map2) {
        if (this.zznfl == null) {
            String name = this.zznfk.getName();
            StringBuilder stringBuilder = new StringBuilder(123 + String.valueOf(name).length());
            stringBuilder.append("Class ");
            stringBuilder.append(name);
            stringBuilder.append(" does not define a no-argument constructor. If you are using ProGuard, make sure these constructors are not stripped.");
            throw new DatabaseException(stringBuilder.toString());
        }
        try {
            T newInstance = this.zznfl.newInstance(new Object[0]);
            for (Entry entry : map.entrySet()) {
                String str = (String) entry.getKey();
                if (this.zznfq.containsKey(str)) {
                    Method method = (Method) this.zznfq.get(str);
                    Type[] genericParameterTypes = method.getGenericParameterTypes();
                    if (genericParameterTypes.length != 1) {
                        throw new IllegalStateException("Setter does not have exactly one parameter");
                    }
                    Object zzb = zzelw.zza(entry.getValue(), zza(genericParameterTypes[0], map2));
                    try {
                        method.invoke(newInstance, new Object[]{zzb});
                    } catch (Throwable e) {
                        throw new RuntimeException(e);
                    } catch (Throwable e2) {
                        throw new RuntimeException(e2);
                    }
                } else if (this.zznfr.containsKey(str)) {
                    Field field = (Field) this.zznfr.get(str);
                    try {
                        field.set(newInstance, zzelw.zza(entry.getValue(), zza(field.getGenericType(), map2)));
                    } catch (Throwable e22) {
                        throw new RuntimeException(e22);
                    }
                } else {
                    String name2 = this.zznfk.getName();
                    StringBuilder stringBuilder2 = new StringBuilder((36 + String.valueOf(str).length()) + String.valueOf(name2).length());
                    stringBuilder2.append("No setter/field for ");
                    stringBuilder2.append(str);
                    stringBuilder2.append(" found on class ");
                    stringBuilder2.append(name2);
                    name2 = stringBuilder2.toString();
                    if (this.zznfo.containsKey(str.toLowerCase())) {
                        name2 = String.valueOf(name2).concat(" (fields/setters are case sensitive!)");
                    }
                    if (this.zznfm) {
                        throw new DatabaseException(name2);
                    } else if (this.zznfn) {
                        Log.w("ClassMapper", name2);
                    }
                }
            }
            return newInstance;
        } catch (Throwable e222) {
            throw new RuntimeException(e222);
        } catch (Throwable e2222) {
            throw new RuntimeException(e2222);
        } catch (Throwable e22222) {
            throw new RuntimeException(e22222);
        }
    }
}
