package com.example.rishabh.pokepoke;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class SplashActivity  extends AppCompatActivity{

    //    private SLEEP_TIMER =3;
    ImageView image;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

//        image = findViewById(R.id.splash);
        Thread mythread = new Thread()
        {
            @Override
            public void run() {
                try {
                    sleep(1000);
                    image = findViewById(R.id.splash);
                    image.animate().alpha(0.4f).setDuration(500);
                    //                            image.animate().translationX(1200).setDuration(2000);
                    sleep(500);
                    Intent i = new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(i);
                    finish();


                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        };

        mythread.start();


    }
}
