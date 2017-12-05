package com.example.admin.antoni;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashScreen extends AppCompatActivity {


    Boolean isLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        isLogin=false;

        startNewActivity();
    }

    public void startNewActivity()
    {
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                SharedPreferences preferences=getSharedPreferences("mypreference", Context.MODE_PRIVATE);
                if(preferences.contains("isLogin"))
                {
                    isLogin=preferences.getBoolean("isLogin",false);

                }

                if(isLogin==true)
                {
                    Utility.startActivity(SplashScreen.this,Home.class);
                    finish();
                }
                else
                {
                    startActivity(new Intent(SplashScreen.this, WelcomeScreen.class));
                    finish();
                }


            }

        }, 3000);
    }
}
