package com.google.android.gms.internal;

import android.support.annotation.WorkerThread;
import com.google.android.gms.common.internal.zzbq;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;
import java.util.Map.Entry;

@WorkerThread
final class zzchu implements Runnable {
    private final String mPackageName;
    private final URL zzbxv;
    private final byte[] zzgfx;
    private final zzchs zzjck;
    private final Map<String, String> zzjcl;
    private /* synthetic */ zzchq zzjcm;

    public zzchu(zzchq com_google_android_gms_internal_zzchq, String str, URL url, byte[] bArr, Map<String, String> map, zzchs com_google_android_gms_internal_zzchs) {
        this.zzjcm = com_google_android_gms_internal_zzchq;
        zzbq.zzgm(str);
        zzbq.checkNotNull(url);
        zzbq.checkNotNull(com_google_android_gms_internal_zzchs);
        this.zzbxv = url;
        this.zzgfx = bArr;
        this.zzjck = com_google_android_gms_internal_zzchs;
        this.mPackageName = str;
        this.zzjcl = map;
    }

    public final void run() {
        HttpURLConnection httpURLConnection;
        int i;
        Map map;
        Throwable th;
        zzcih zzawx;
        Runnable com_google_android_gms_internal_zzcht;
        int i2;
        Map map2;
        Throwable th2;
        Throwable e;
        this.zzjcm.zzawj();
        OutputStream outputStream = null;
        try {
            URLConnection openConnection = this.zzbxv.openConnection();
            if (openConnection instanceof HttpURLConnection) {
                httpURLConnection = (HttpURLConnection) openConnection;
                httpURLConnection.setDefaultUseCaches(false);
                httpURLConnection.setConnectTimeout(60000);
                httpURLConnection.setReadTimeout(61000);
                httpURLConnection.setInstanceFollowRedirects(false);
                httpURLConnection.setDoInput(true);
                try {
                    if (this.zzjcl != null) {
                        for (Entry entry : this.zzjcl.entrySet()) {
                            httpURLConnection.addRequestProperty((String) entry.getKey(), (String) entry.getValue());
                        }
                    }
                    if (this.zzgfx != null) {
                        byte[] zzq = this.zzjcm.zzawu().zzq(this.zzgfx);
                        this.zzjcm.zzawy().zzazj().zzj("Uploading data. size", Integer.valueOf(zzq.length));
                        httpURLConnection.setDoOutput(true);
                        httpURLConnection.addRequestProperty("Content-Encoding", "gzip");
                        httpURLConnection.setFixedLengthStreamingMode(zzq.length);
                        httpURLConnection.connect();
                        OutputStream outputStream2 = httpURLConnection.getOutputStream();
                        try {
                            outputStream2.write(zzq);
                            outputStream2.close();
                        } catch (Throwable e2) {
                            i = 0;
                            map = null;
                            outputStream = outputStream2;
                            th = e2;
                            if (outputStream != null) {
                                try {
                                    outputStream.close();
                                } catch (IOException e3) {
                                    this.zzjcm.zzawy().zzazd().zze("Error closing HTTP compressed POST connection output stream. appId", zzchm.zzjk(this.mPackageName), e3);
                                }
                            }
                            if (httpURLConnection != null) {
                                httpURLConnection.disconnect();
                            }
                            zzawx = this.zzjcm.zzawx();
                            com_google_android_gms_internal_zzcht = new zzcht(this.mPackageName, this.zzjck, i, th, null, map);
                            zzawx.zzg(r1);
                        } catch (Throwable e22) {
                            i2 = 0;
                            map2 = null;
                            outputStream = outputStream2;
                            th2 = e22;
                            if (outputStream != null) {
                                try {
                                    outputStream.close();
                                } catch (IOException e32) {
                                    this.zzjcm.zzawy().zzazd().zze("Error closing HTTP compressed POST connection output stream. appId", zzchm.zzjk(this.mPackageName), e32);
                                }
                            }
                            if (httpURLConnection != null) {
                                httpURLConnection.disconnect();
                            }
                            this.zzjcm.zzawx().zzg(new zzcht(this.mPackageName, this.zzjck, i2, null, null, map2));
                            throw th2;
                        }
                    }
                    i2 = httpURLConnection.getResponseCode();
                    try {
                        map2 = httpURLConnection.getHeaderFields();
                    } catch (IOException e4) {
                        e = e4;
                        map = null;
                        i = i2;
                        th = e;
                        if (outputStream != null) {
                            outputStream.close();
                        }
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        zzawx = this.zzjcm.zzawx();
                        com_google_android_gms_internal_zzcht = new zzcht(this.mPackageName, this.zzjck, i, th, null, map);
                        zzawx.zzg(r1);
                    } catch (Throwable e5) {
                        th2 = e5;
                        map2 = null;
                        if (outputStream != null) {
                            outputStream.close();
                        }
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        this.zzjcm.zzawx().zzg(new zzcht(this.mPackageName, this.zzjck, i2, null, null, map2));
                        throw th2;
                    }
                    try {
                        byte[] zza = zzchq.zzc(httpURLConnection);
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        zzawx = this.zzjcm.zzawx();
                        Runnable com_google_android_gms_internal_zzcht2 = new zzcht(this.mPackageName, this.zzjck, i2, null, zza, map2);
                    } catch (IOException e6) {
                        e5 = e6;
                        i = i2;
                        map = map2;
                        th = e5;
                        if (outputStream != null) {
                            outputStream.close();
                        }
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        zzawx = this.zzjcm.zzawx();
                        com_google_android_gms_internal_zzcht = new zzcht(this.mPackageName, this.zzjck, i, th, null, map);
                        zzawx.zzg(r1);
                    } catch (Throwable e52) {
                        th2 = e52;
                        if (outputStream != null) {
                            outputStream.close();
                        }
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        this.zzjcm.zzawx().zzg(new zzcht(this.mPackageName, this.zzjck, i2, null, null, map2));
                        throw th2;
                    }
                } catch (Throwable th22) {
                    i = 0;
                    map = null;
                    th = th22;
                    if (outputStream != null) {
                        outputStream.close();
                    }
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    zzawx = this.zzjcm.zzawx();
                    com_google_android_gms_internal_zzcht = new zzcht(this.mPackageName, this.zzjck, i, th, null, map);
                    zzawx.zzg(r1);
                } catch (Throwable th3) {
                    th22 = th3;
                    i2 = 0;
                    map2 = null;
                    if (outputStream != null) {
                        outputStream.close();
                    }
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    this.zzjcm.zzawx().zzg(new zzcht(this.mPackageName, this.zzjck, i2, null, null, map2));
                    throw th22;
                }
                zzawx.zzg(r1);
            }
            throw new IOException("Failed to obtain HTTP connection");
        } catch (Throwable e7) {
            i = 0;
            map = null;
            th = e7;
            httpURLConnection = map;
            if (outputStream != null) {
                outputStream.close();
            }
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            zzawx = this.zzjcm.zzawx();
            com_google_android_gms_internal_zzcht = new zzcht(this.mPackageName, this.zzjck, i, th, null, map);
            zzawx.zzg(r1);
        } catch (Throwable e72) {
            i2 = 0;
            map2 = null;
            th22 = e72;
            httpURLConnection = map2;
            if (outputStream != null) {
                outputStream.close();
            }
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            this.zzjcm.zzawx().zzg(new zzcht(this.mPackageName, this.zzjck, i2, null, null, map2));
            throw th22;
        }
    }
}
