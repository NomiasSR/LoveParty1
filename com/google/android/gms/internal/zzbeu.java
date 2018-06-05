package com.google.android.gms.internal;

import android.content.Context;
import android.util.Log;
import com.bumptech.glide.load.Key;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

public final class zzbeu implements zzbeb {
    private static final Charset UTF_8 = Charset.forName(Key.STRING_CHARSET_NAME);
    private static final zzcup zzfkh = new zzcup(zzcue.zzks("com.google.android.gms.clearcut.public")).zzku("gms:playlog:service:sampling_").zzkv("LogSampling__");
    private static Map<String, zzcui<String>> zzfki;
    private static Boolean zzfkj;
    private static Long zzfkk;
    private final Context zzair;

    public zzbeu(Context context) {
        this.zzair = context;
        if (zzfki == null) {
            zzfki = new HashMap();
        }
        if (this.zzair != null) {
            zzcui.zzdz(this.zzair);
        }
    }

    private static boolean zzcb(Context context) {
        if (zzfkj == null) {
            zzfkj = Boolean.valueOf(zzbhf.zzdb(context).checkCallingOrSelfPermission("com.google.android.providers.gsf.permission.READ_GSERVICES") == 0);
        }
        return zzfkj.booleanValue();
    }

    private static zzbev zzfw(String str) {
        if (str == null) {
            return null;
        }
        String str2 = "";
        int indexOf = str.indexOf(44);
        int i = 0;
        if (indexOf >= 0) {
            str2 = str.substring(0, indexOf);
            i = indexOf + 1;
        }
        String str3 = str2;
        int indexOf2 = str.indexOf(47, i);
        if (indexOf2 <= 0) {
            str2 = "LogSamplerImpl";
            String str4 = "Failed to parse the rule: ";
            str = String.valueOf(str);
            Log.e(str2, str.length() != 0 ? str4.concat(str) : new String(str4));
            return null;
        }
        try {
            long parseLong = Long.parseLong(str.substring(i, indexOf2));
            long parseLong2 = Long.parseLong(str.substring(indexOf2 + 1));
            if (parseLong >= 0) {
                if (parseLong2 >= 0) {
                    return new zzbev(str3, parseLong, parseLong2);
                }
            }
            StringBuilder stringBuilder = new StringBuilder(72);
            stringBuilder.append("negative values not supported: ");
            stringBuilder.append(parseLong);
            stringBuilder.append("/");
            stringBuilder.append(parseLong2);
            Log.e("LogSamplerImpl", stringBuilder.toString());
            return null;
        } catch (Throwable e) {
            str4 = "LogSamplerImpl";
            String str5 = "parseLong() failed while parsing: ";
            str = String.valueOf(str);
            Log.e(str4, str.length() != 0 ? str5.concat(str) : new String(str5), e);
            return null;
        }
    }

    public final boolean zzg(String str, int i) {
        String str2 = null;
        if (str == null || str.isEmpty()) {
            str = i >= 0 ? String.valueOf(i) : null;
        }
        if (str == null) {
            return true;
        }
        if (this.zzair != null) {
            if (zzcb(this.zzair)) {
                zzcui com_google_android_gms_internal_zzcui = (zzcui) zzfki.get(str);
                if (com_google_android_gms_internal_zzcui == null) {
                    com_google_android_gms_internal_zzcui = zzfkh.zzaw(str, null);
                    zzfki.put(str, com_google_android_gms_internal_zzcui);
                }
                str2 = (String) com_google_android_gms_internal_zzcui.get();
            }
        }
        zzbev zzfw = zzfw(str2);
        if (zzfw == null) {
            return true;
        }
        long j;
        byte[] bytes;
        long zzj;
        long j2;
        long j3;
        int i2;
        StringBuilder stringBuilder;
        str2 = zzfw.zzfkl;
        Context context = this.zzair;
        if (zzfkk == null) {
            if (context != null) {
                zzfkk = zzcb(context) ? Long.valueOf(zzdmf.getLong(context.getContentResolver(), "android_id", 0)) : Long.valueOf(0);
            } else {
                j = 0;
                if (str2 != null) {
                    if (str2.isEmpty()) {
                        bytes = str2.getBytes(UTF_8);
                        ByteBuffer allocate = ByteBuffer.allocate(bytes.length + 8);
                        allocate.put(bytes);
                        allocate.putLong(j);
                        bytes = allocate.array();
                        zzj = zzbep.zzj(bytes);
                        j2 = zzfw.zzfkm;
                        j3 = zzfw.zzfkn;
                        if (j2 >= 0) {
                            i2 = (j3 > 0 ? 1 : (j3 == 0 ? 0 : -1));
                            if (i2 >= 0) {
                                if (i2 > 0) {
                                    if ((zzj < 0 ? zzj % j3 : (((Long.MAX_VALUE % j3) + 1) + ((zzj & Long.MAX_VALUE) % j3)) % j3) < j2) {
                                        return true;
                                    }
                                }
                                return false;
                            }
                        }
                        stringBuilder = new StringBuilder(72);
                        stringBuilder.append("negative values not supported: ");
                        stringBuilder.append(j2);
                        stringBuilder.append("/");
                        stringBuilder.append(j3);
                        throw new IllegalArgumentException(stringBuilder.toString());
                    }
                }
                bytes = ByteBuffer.allocate(8).putLong(j).array();
                zzj = zzbep.zzj(bytes);
                j2 = zzfw.zzfkm;
                j3 = zzfw.zzfkn;
                if (j2 >= 0) {
                    i2 = (j3 > 0 ? 1 : (j3 == 0 ? 0 : -1));
                    if (i2 >= 0) {
                        if (i2 > 0) {
                            if (zzj < 0) {
                            }
                            if ((zzj < 0 ? zzj % j3 : (((Long.MAX_VALUE % j3) + 1) + ((zzj & Long.MAX_VALUE) % j3)) % j3) < j2) {
                                return true;
                            }
                        }
                        return false;
                    }
                }
                stringBuilder = new StringBuilder(72);
                stringBuilder.append("negative values not supported: ");
                stringBuilder.append(j2);
                stringBuilder.append("/");
                stringBuilder.append(j3);
                throw new IllegalArgumentException(stringBuilder.toString());
            }
        }
        j = zzfkk.longValue();
        if (str2 != null) {
            if (str2.isEmpty()) {
                bytes = str2.getBytes(UTF_8);
                ByteBuffer allocate2 = ByteBuffer.allocate(bytes.length + 8);
                allocate2.put(bytes);
                allocate2.putLong(j);
                bytes = allocate2.array();
                zzj = zzbep.zzj(bytes);
                j2 = zzfw.zzfkm;
                j3 = zzfw.zzfkn;
                if (j2 >= 0) {
                    i2 = (j3 > 0 ? 1 : (j3 == 0 ? 0 : -1));
                    if (i2 >= 0) {
                        if (i2 > 0) {
                            if (zzj < 0) {
                            }
                            if ((zzj < 0 ? zzj % j3 : (((Long.MAX_VALUE % j3) + 1) + ((zzj & Long.MAX_VALUE) % j3)) % j3) < j2) {
                                return true;
                            }
                        }
                        return false;
                    }
                }
                stringBuilder = new StringBuilder(72);
                stringBuilder.append("negative values not supported: ");
                stringBuilder.append(j2);
                stringBuilder.append("/");
                stringBuilder.append(j3);
                throw new IllegalArgumentException(stringBuilder.toString());
            }
        }
        bytes = ByteBuffer.allocate(8).putLong(j).array();
        zzj = zzbep.zzj(bytes);
        j2 = zzfw.zzfkm;
        j3 = zzfw.zzfkn;
        if (j2 >= 0) {
            i2 = (j3 > 0 ? 1 : (j3 == 0 ? 0 : -1));
            if (i2 >= 0) {
                if (i2 > 0) {
                    if (zzj < 0) {
                    }
                    if ((zzj < 0 ? zzj % j3 : (((Long.MAX_VALUE % j3) + 1) + ((zzj & Long.MAX_VALUE) % j3)) % j3) < j2) {
                        return true;
                    }
                }
                return false;
            }
        }
        stringBuilder = new StringBuilder(72);
        stringBuilder.append("negative values not supported: ");
        stringBuilder.append(j2);
        stringBuilder.append("/");
        stringBuilder.append(j3);
        throw new IllegalArgumentException(stringBuilder.toString());
    }
}
