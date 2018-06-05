package com.cicari.p001270.gaveta;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo.State;
import android.widget.Toast;

public class InternetGenerics {
    public static boolean checkInternetStatus(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager.getNetworkInfo(0).getState() != State.CONNECTED) {
            if (connectivityManager.getNetworkInfo(1).getState() != State.CONNECTED) {
                Toast.makeText(context, "Please check your Internet Connection.", 1).show();
                return false;
            }
        }
        return true;
    }
}
