package com.cicari.p001270.gaveta;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {
    private static final String TAG = "SplashActivity";
    private final int SPLASH_DISPLAY_LENGTH = 5000;

    class C03491 implements Runnable {
        C03491() {
        }

        public void run() {
            SplashActivity.this.startActivity(new Intent(SplashActivity.this, LoginActivity.class));
            SplashActivity.this.finish();
        }
    }

    protected void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        super.onCreate(bundle);
        setContentView((int) C0346R.layout.activity_splash);
        bundle = getSupportActionBar();
        if (bundle != null) {
            bundle.hide();
        }
        new Handler().postDelayed(new C03491(), 5000);
    }
}
