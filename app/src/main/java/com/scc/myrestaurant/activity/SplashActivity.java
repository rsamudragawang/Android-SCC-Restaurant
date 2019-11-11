package com.scc.myrestaurant.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.scc.myrestaurant.R;

public class SplashActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        Thread thread = new Thread() {
            public void run(){
                try {
                    sleep(4000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    startActivity(new Intent(SplashActivity.this, IntroActivity.class));
                    finish();
                }
            }
        };
        thread.start();
    }
}