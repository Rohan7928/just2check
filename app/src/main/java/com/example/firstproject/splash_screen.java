package com.example.firstproject;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class splash_screen extends AppCompatActivity {
    FirebaseUser user;
    FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        auth=FirebaseAuth.getInstance();
        user=auth.getCurrentUser();
        Handler handler=new Handler();
        if(user != null){
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // This method will be executed once the timer is over
                    Intent i = new Intent(getApplicationContext(), contactlist.class);
                    startActivity(i);
                    finish();
                }
            }, 5000);
        }
        else
        {
            Intent i = new Intent(getApplicationContext(), login.class);
            startActivity(i);
            finish();
        }


    }
}