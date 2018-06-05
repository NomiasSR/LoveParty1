package com.google.android.gms.internal;

import java.util.HashMap;
import java.util.Map;

final class zzebc implements zzeci {
    private static long zzmnd;
    private final zzejc zzmlr;
    private zzebk zzmne;
    private zzecf zzmnf;
    private zzebd zzmng;
    private int zzmnh = zzebf.zzmnl;

    public zzebc(zzebi com_google_android_gms_internal_zzebi, zzebk com_google_android_gms_internal_zzebk, String str, zzebd com_google_android_gms_internal_zzebd, String str2) {
        long j = zzmnd;
        zzmnd = 1 + j;
        this.zzmne = com_google_android_gms_internal_zzebk;
        this.zzmng = com_google_android_gms_internal_zzebd;
        StringBuilder stringBuilder = new StringBuilder(25);
        stringBuilder.append("conn_");
        stringBuilder.append(j);
        this.zzmlr = new zzejc(com_google_android_gms_internal_zzebi.zzbub(), "Connection", stringBuilder.toString());
        this.zzmnf = new zzecf(com_google_android_gms_internal_zzebi, com_google_android_gms_internal_zzebk, str, this, str2);
    }

    private final void zza(zzebe com_google_android_gms_internal_zzebe) {
        if (this.zzmnh != zzebf.zzmnn) {
            if (this.zzmlr.zzbzl()) {
                this.zzmlr.zzb("closing realtime connection", null, new Object[0]);
            }
            this.zzmnh = zzebf.zzmnn;
            if (this.zzmnf != null) {
                this.zzmnf.close();
                this.zzmnf = null;
            }
            this.zzmng.zzb(com_google_android_gms_internal_zzebe);
        }
    }

    public final void close() {
        zza(zzebe.OTHER);
    }

    public final void open() {
        if (this.zzmlr.zzbzl()) {
            this.zzmlr.zzb("Opening a connection", null, new Object[0]);
        }
        this.zzmnf.open();
    }

    public final void zza(Map<String, Object> map, boolean z) {
        Map hashMap = new HashMap();
        hashMap.put("t", "d");
        hashMap.put("d", map);
        if (this.zzmnh != zzebf.zzmnm) {
            this.zzmlr.zzb("Tried to send on an unconnected connection", null, new Object[0]);
            return;
        }
        zzejc com_google_android_gms_internal_zzejc;
        String str;
        Object[] objArr;
        if (z) {
            com_google_android_gms_internal_zzejc = this.zzmlr;
            str = "Sending data (contents hidden)";
            objArr = new Object[0];
        } else {
            com_google_android_gms_internal_zzejc = this.zzmlr;
            str = "Sending data: %s";
            objArr = new Object[]{hashMap};
        }
        com_google_android_gms_internal_zzejc.zzb(str, null, objArr);
        this.zzmnf.send(hashMap);
    }

    public final void zzag(Map<String, Object> map) {
        zzejc com_google_android_gms_internal_zzejc;
        String str;
        String valueOf;
        try {
            String str2 = (String) map.get("t");
            if (str2 == null) {
                if (this.zzmlr.zzbzl()) {
                    com_google_android_gms_internal_zzejc = this.zzmlr;
                    str = "Failed to parse server message: missing message type:";
                    valueOf = String.valueOf(map.toString());
                    com_google_android_gms_internal_zzejc.zzb(valueOf.length() != 0 ? str.concat(valueOf) : new String(str), null, new Object[0]);
                }
                zza(zzebe.OTHER);
            } else if (str2.equals("d")) {
                r8 = (Map) map.get("d");
                if (this.zzmlr.zzbzl()) {
                    com_google_android_gms_internal_zzejc = this.zzmlr;
                    str = "received data message: ";
                    r4 = String.valueOf(r8.toString());
                    com_google_android_gms_internal_zzejc.zzb(r4.length() != 0 ? str.concat(r4) : new String(str), null, new Object[0]);
                }
                this.zzmng.zzah(r8);
            } else if (str2.equals("c")) {
                r8 = (Map) map.get("d");
                if (this.zzmlr.zzbzl()) {
                    com_google_android_gms_internal_zzejc = this.zzmlr;
                    str = "Got control message: ";
                    r4 = String.valueOf(r8.toString());
                    com_google_android_gms_internal_zzejc.zzb(r4.length() != 0 ? str.concat(r4) : new String(str), null, new Object[0]);
                }
                try {
                    str2 = (String) r8.get("t");
                    if (str2 != null) {
                        zzebe com_google_android_gms_internal_zzebe;
                        if (str2.equals("s")) {
                            valueOf = (String) r8.get("d");
                            if (this.zzmlr.zzbzl()) {
                                this.zzmlr.zzb("Connection shutdown command received. Shutting down...", null, new Object[0]);
                            }
                            this.zzmng.zzpk(valueOf);
                            com_google_android_gms_internal_zzebe = zzebe.OTHER;
                        } else if (str2.equals("r")) {
                            valueOf = (String) r8.get("d");
                            if (this.zzmlr.zzbzl()) {
                                com_google_android_gms_internal_zzejc = this.zzmlr;
                                str = this.zzmne.getHost();
                                StringBuilder stringBuilder = new StringBuilder((62 + String.valueOf(str).length()) + String.valueOf(valueOf).length());
                                stringBuilder.append("Got a reset; killing connection to ");
                                stringBuilder.append(str);
                                stringBuilder.append("; Updating internalHost to ");
                                stringBuilder.append(valueOf);
                                com_google_android_gms_internal_zzejc.zzb(stringBuilder.toString(), null, new Object[0]);
                            }
                            this.zzmng.zzpj(valueOf);
                            com_google_android_gms_internal_zzebe = zzebe.SERVER_RESET;
                        } else if (str2.equals("h")) {
                            r8 = (Map) r8.get("d");
                            long longValue = ((Long) r8.get("ts")).longValue();
                            this.zzmng.zzpj((String) r8.get("h"));
                            valueOf = (String) r8.get("s");
                            if (this.zzmnh == zzebf.zzmnl) {
                                if (this.zzmlr.zzbzl()) {
                                    this.zzmlr.zzb("realtime connection established", null, new Object[0]);
                                }
                                this.zzmnh = zzebf.zzmnm;
                                this.zzmng.zzc(longValue, valueOf);
                                return;
                            }
                            return;
                        } else if (this.zzmlr.zzbzl()) {
                            r8 = this.zzmlr;
                            str = "Ignoring unknown control message: ";
                            str2 = String.valueOf(str2);
                            r8.zzb(str2.length() != 0 ? str.concat(str2) : new String(str), null, new Object[0]);
                            return;
                        }
                        zza(com_google_android_gms_internal_zzebe);
                        return;
                    }
                    if (this.zzmlr.zzbzl()) {
                        com_google_android_gms_internal_zzejc = this.zzmlr;
                        str = "Got invalid control message: ";
                        valueOf = String.valueOf(r8.toString());
                        com_google_android_gms_internal_zzejc.zzb(valueOf.length() != 0 ? str.concat(valueOf) : new String(str), null, new Object[0]);
                    }
                    zza(zzebe.OTHER);
                } catch (ClassCastException e) {
                    if (this.zzmlr.zzbzl()) {
                        com_google_android_gms_internal_zzejc = this.zzmlr;
                        str = "Failed to parse control message: ";
                        valueOf = String.valueOf(e.toString());
                        com_google_android_gms_internal_zzejc.zzb(valueOf.length() != 0 ? str.concat(valueOf) : new String(str), null, new Object[0]);
                    }
                    zza(zzebe.OTHER);
                }
            } else if (this.zzmlr.zzbzl()) {
                r8 = this.zzmlr;
                str = "Ignoring unknown server message type: ";
                str2 = String.valueOf(str2);
                r8.zzb(str2.length() != 0 ? str.concat(str2) : new String(str), null, new Object[0]);
            }
        } catch (ClassCastException e2) {
            if (this.zzmlr.zzbzl()) {
                com_google_android_gms_internal_zzejc = this.zzmlr;
                str = "Failed to parse server message: ";
                valueOf = String.valueOf(e2.toString());
                com_google_android_gms_internal_zzejc.zzb(valueOf.length() != 0 ? str.concat(valueOf) : new String(str), null, new Object[0]);
            }
            zza(zzebe.OTHER);
        }
    }

    public final void zzck(boolean z) {
        zzejc com_google_android_gms_internal_zzejc;
        String str;
        this.zzmnf = null;
        if (z || this.zzmnh != zzebf.zzmnl) {
            if (this.zzmlr.zzbzl()) {
                com_google_android_gms_internal_zzejc = this.zzmlr;
                str = "Realtime connection lost";
            }
            zza(zzebe.OTHER);
        }
        if (this.zzmlr.zzbzl()) {
            com_google_android_gms_internal_zzejc = this.zzmlr;
            str = "Realtime connection failed";
        }
        zza(zzebe.OTHER);
        com_google_android_gms_internal_zzejc.zzb(str, null, new Object[0]);
        zza(zzebe.OTHER);
    }
}
