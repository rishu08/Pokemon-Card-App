package com.example.rishabh.pokepoke;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class EntryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entry);

//        final MediaPlayer pokemon =MediaPlayer.create(getBaseContext(), R.raw.pokemon_go);
//        pokemon.start();

        Thread MyThread = new Thread()
        {
            @Override
            public void run() {
                try {
                    sleep(1000);

                    Intent i = new Intent(getApplicationContext(),SplashActivity.class);
                    startActivity(i);
                    finish();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        MyThread.start();

    }
}
