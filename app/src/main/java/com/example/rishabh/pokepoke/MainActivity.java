package com.example.rishabh.pokepoke;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {
    MediaPlayer pokemon;
    static PokeDetails mypoke;
    EditText editText;
    Button search,previous,next;
    TextView textView;
    ImageView image;
    ImageButton imageButton;
    String finalURL;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.pokesearch);
        search = findViewById(R.id.btngo);
        imageButton = findViewById(R.id.imageButton);
        previous = findViewById(R.id.btnpre);
        next = findViewById(R.id.btnnext);



//        pokemon = MediaPlayer.create(getBaseContext(), R.raw.pokemon);
//        pokemon.start();




        Log.e("TAG", "onCreate: "+editText.getText());
        int no=1;
        finalURL = "https://pokeapi.co/api/v2/pokemon/"+no;
        makeNetworkCall("https://pokeapi.co/api/v2/pokemon/"+no);
        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Integer.parseInt(editText.getText().toString())==1)
                {
                    Toast.makeText(MainActivity.this, "NO POKEMON!!!", Toast.LENGTH_SHORT).show();
                }

                else
                {
                    int no = Integer.parseInt(editText.getText().toString());
                    no--;
                    finalURL = "https://pokeapi.co/api/v2/pokemon/"+no;
                    editText.setText(""+no);
                    makeNetworkCall(finalURL);
                }
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if(Integer.parseInt(editText.getText().toString())==802)
                {
                    Toast.makeText(MainActivity.this, "NO POKEMON", Toast.LENGTH_SHORT).show();
                }
                else if(editText.getText().toString()!="")
                {
                    int no = Integer.parseInt(editText.getText().toString());
                    no++;
                    finalURL = "https://pokeapi.co/api/v2/pokemon/"+no;
                    editText.setText(""+no);
                    makeNetworkCall(finalURL);

                }

            }
        });

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String url = "https://pokeapi.co/api/v2/pokemon/" + editText.getText().toString();
                int no = Integer.parseInt(editText.getText().toString());
                finalURL = url;
                if(no<=802)
                {
                    makeNetworkCall(finalURL);
                }
                else {
                    Toast.makeText(MainActivity.this, "POKE!POKE!! Enter valid POKE", Toast.LENGTH_SHORT).show();
                }


            }
        });

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Thread mythread = new Thread()
                {
                    @Override
                    public void run() {
                        try {
//                            sleep(500);
                            image = findViewById(R.id.splash);
                            imageButton.animate().translationY(-1000f).setDuration(500);
                            //                            image.animate().translationX(1200).setDuration(2000);


                            sleep(550);
                            imageButton.animate().translationY(10f).setDuration(500);
                            sleep(400);

                            addIntent(finalURL);

                        } catch (InterruptedException e) {
                            e.printStackTrace();
                            Log.e("TAG", "run: not possible");
                        }
                    }

                };
                mythread.start();


//
            }
        });

    }

    private void addIntent(String finalURL) {

//        pokemon.stop();
        Intent i = new Intent(getBaseContext(),SecondActivity.class);
        i.putExtra("url",finalURL);
//        i.putExtra("serialised",mypoke);
//        i.putExtra("par",mypoke);
        startActivity(i);
    }

    private void makeNetworkCall(String url) {


        OkHttpClient okHttpClient = new OkHttpClient();
        final Request request = new Request.Builder().url(url).build();

        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e("TAG", "onFailure: try again network failed ");
//                Toast.makeText(MainActivity.this, "POKEPOKE!!! Try Again", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                final String result = response.body().string();
                final Gson gson = new Gson();
                final PokeDetails pokeDetails = gson.fromJson(result, PokeDetails.class);
                mypoke = pokeDetails;

                (MainActivity.this).runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        textView = findViewById(R.id.tvresult);
                        image = findViewById(R.id.image);
                        textView.setText(pokeDetails.getName());


                        Picasso.get().load(pokeDetails.sprites.front_default)
                                .placeholder(R.drawable.ic_launcher_background)
                                .resize(550, 550)
                                .into(image);

                        final Animation zoomAnimation = AnimationUtils.loadAnimation(getBaseContext(),R.anim.zoom);
                        image.startAnimation(zoomAnimation);


                    }
                });
            }
        });


    }
}
