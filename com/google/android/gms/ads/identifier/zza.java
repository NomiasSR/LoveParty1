package com.google.android.gms.ads.identifier;

import android.net.Uri;
import android.net.Uri.Builder;
import android.support.v7.widget.helper.ItemTouchHelper.Callback;
import android.util.Log;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

final class zza extends Thread {
    private /* synthetic */ Map zzanb;

    zza(AdvertisingIdClient advertisingIdClient, Map map) {
        this.zzanb = map;
    }

    public final void run() {
        HttpURLConnection httpURLConnection;
        Throwable e;
        String str;
        String str2;
        zzc com_google_android_gms_ads_identifier_zzc = new zzc();
        Map map = this.zzanb;
        Builder buildUpon = Uri.parse("https://pagead2.googlesyndication.com/pagead/gen_204?id=gmob-apps").buildUpon();
        for (String str3 : map.keySet()) {
            String str32;
            buildUpon.appendQueryParameter(str32, (String) map.get(str32));
        }
        String uri = buildUpon.build().toString();
        StringBuilder stringBuilder;
        try {
            httpURLConnection = (HttpURLConnection) new URL(uri).openConnection();
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode < Callback.DEFAULT_DRAG_ANIMATION_DURATION || responseCode >= 300) {
                stringBuilder = new StringBuilder(65 + String.valueOf(uri).length());
                stringBuilder.append("Received non-success response code ");
                stringBuilder.append(responseCode);
                stringBuilder.append(" from pinging URL: ");
                stringBuilder.append(uri);
                Log.w("HttpUrlPinger", stringBuilder.toString());
            }
            httpURLConnection.disconnect();
        } catch (IndexOutOfBoundsException e2) {
            e = e2;
            str = "HttpUrlPinger";
            str32 = e.getMessage();
            stringBuilder = new StringBuilder((32 + String.valueOf(uri).length()) + String.valueOf(str32).length());
            str2 = "Error while parsing ping URL: ";
            stringBuilder.append(str2);
            stringBuilder.append(uri);
            stringBuilder.append(". ");
            stringBuilder.append(str32);
            Log.w(str, stringBuilder.toString(), e);
        } catch (IOException e3) {
            e = e3;
            str = "HttpUrlPinger";
            str32 = e.getMessage();
            stringBuilder = new StringBuilder((27 + String.valueOf(uri).length()) + String.valueOf(str32).length());
            str2 = "Error while pinging URL: ";
            stringBuilder.append(str2);
            stringBuilder.append(uri);
            stringBuilder.append(". ");
            stringBuilder.append(str32);
            Log.w(str, stringBuilder.toString(), e);
        } catch (Throwable th) {
            httpURLConnection.disconnect();
        }
    }
}
