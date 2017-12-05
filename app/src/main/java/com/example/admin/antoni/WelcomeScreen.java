package com.example.admin.antoni;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.example.admin.antoni.databinding.WelcomeScreenBinding;


public class WelcomeScreen extends AppCompatActivity implements View.OnClickListener{

    ConstraintLayout btnFB,btnGoogle,btnEmail;
    WelcomeScreenBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome_screen);

        binding= DataBindingUtil.setContentView(WelcomeScreen.this,R.layout.welcome_screen);

        binding.btnFb.setOnClickListener(this);
        binding.btnGoogle.setOnClickListener(this);
        binding.btnEmail.setOnClickListener(this);
        binding.login.setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {
        if(view==binding.btnFb)
        {
            Intent intent=new Intent(WelcomeScreen.this,AddInfo.class);

            intent.putExtra("Login","facebook");
            startActivity(intent);
            finish();
        }
        if(view==binding.btnGoogle)
        {
            Intent intent=new Intent(WelcomeScreen.this,AddInfo.class);

            intent.putExtra("Login","google");
            startActivity(intent);
            finish();
        }
        if(view==binding.btnEmail)
        {
            startActivity(new Intent(WelcomeScreen.this,Signup.class));
        }
        if(view==binding.login)
        {
            startActivity(new Intent(WelcomeScreen.this,Login.class));
        }
    }
}
