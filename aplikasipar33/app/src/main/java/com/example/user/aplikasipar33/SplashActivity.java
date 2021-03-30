package com.example.user.aplikasipar33;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ProgressBar;

public class SplashActivity extends AppCompatActivity {

    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);




        imageView =(ImageView) findViewById(R.id.imageSplash);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent mainIntent = new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(mainIntent);
                finish();
            }
        }, 3000);//delay 2 detik
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("PAR33");
        }
    }

}
