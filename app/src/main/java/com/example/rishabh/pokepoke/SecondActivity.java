package com.example.rishabh.pokepoke;

import android.media.MediaPlayer;
import android.os.Build;
import android.speech.tts.TextToSpeech;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class SecondActivity extends AppCompatActivity {

    TextView name , weight , height , order , experiences;
    TextToSpeech tt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);


        Toast.makeText(this, "Sound Onn !!", Toast.LENGTH_SHORT).show();


        final MediaPlayer pokemon =MediaPlayer.create(getBaseContext(), R.raw.who_that);
        pokemon.start();



        Bundle bundle = getIntent().getExtras();
        String url = bundle.getString("url");
        makeNetworkCall(url);




    }


    private void makeNetworkCall(String url)
    {
        OkHttpClient okHttpClient = new OkHttpClient();
        final Request request = new Request.Builder()
                .url(url).build();

        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Toast.makeText(SecondActivity.this, "Can't process your Request now!!!", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                final String result = response.body().string();
                final Gson gson = new Gson();
                final PokeDetails pokeDetails = gson.fromJson(result, PokeDetails.class);

                (SecondActivity.this).runOnUiThread(new Runnable() {
                    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
                    @Override
                    public void run() {

                        name = findViewById(R.id.name_card);
                        weight = findViewById(R.id.weight_card);
                        height = findViewById(R.id.height_card);
                        order = findViewById(R.id.order_card);
                        experiences = findViewById(R.id.experience_card);
//                        stats = findViewById(R.id.stats_card);

                        ArrayList<stats> stats = pokeDetails.getStats();
                        ArrayList<Abilities> abilities = pokeDetails.getAbilities();
                        ArrayList<types> types = pokeDetails.getTypes();
                        RecyclerView rvtypes = findViewById(R.id.rv_types);
                        RecyclerView rv = findViewById(R.id.rv_stats);
                        RecyclerView rvabal = findViewById(R.id.rv_abilities);


                        ListAdapterStats la_stats = new ListAdapterStats(stats,getBaseContext());
                        rv.setLayoutManager(new LinearLayoutManager(getBaseContext()));
                        rv.setAdapter(la_stats);

                        ListAdapterAbilities la_abalities = new ListAdapterAbilities(abilities,SecondActivity.this);
                        rvabal.setLayoutManager(new LinearLayoutManager(getBaseContext()));
                        rvabal.setAdapter(la_abalities);

                        ListAdapterTypes la_types = new ListAdapterTypes(types,getBaseContext());
                        rvtypes.setLayoutManager(new LinearLayoutManager(getBaseContext()));
                        rvtypes.setAdapter(la_types);



//                        int weight1 = pokeDetails.getWeight();

                        name.setText(pokeDetails.getName());

                        tt = new TextToSpeech(getBaseContext(), new TextToSpeech.OnInitListener() {

                            @Override
                            public void onInit(int status) {
                                    tt.setLanguage(Locale.ENGLISH);
                                Log.e("TAG", "run: "+status);
                                tt.speak(pokeDetails.getName(),TextToSpeech.QUEUE_FLUSH,null,null);

                            }
                        });
//                        tt.speak(pokeDetails.getName(),TextToSpeech.QUEUE_FLUSH,null,null);

                        weight.setText(""+pokeDetails.getWeight());
//                        weight.setText(pokeDetails.getWeight());
                        height.setText(""+pokeDetails.getHeight());
                        order.setText(""+pokeDetails.getOrder());
                        experiences.setText(""+pokeDetails.getBase_experience());



                        LinearLayout gallery = findViewById(R.id.gallery);
                        LayoutInflater inflater = LayoutInflater.from(SecondActivity.this);

                        int i=0;
//        for (int i = 0; i<6;i++)
                        if(i==0)
                        {
                            if(pokeDetails.sprites.back_female != null) {

                                View view = inflater.inflate(R.layout.item_list, gallery, false);
                                ImageView imageView = view.findViewById(R.id.imageView);
                                Picasso.get().load(pokeDetails.sprites.back_female)
                                        .placeholder(R.drawable.ic_launcher_background)
                                        .resize(550, 550)
                                        .into(imageView);
                                gallery.addView(view);

                                final Animation zoomAnimation = AnimationUtils.loadAnimation(getBaseContext(),R.anim.zoom_card);
                                imageView.startAnimation(zoomAnimation);

                            }
                            i++;
                        }

                        if(i==1)
                        {
                            if(pokeDetails.sprites.back_female != null) {
                                View view = inflater.inflate(R.layout.item_list, gallery, false);
                                ImageView imageView = view.findViewById(R.id.imageView);
                                Picasso.get().load(pokeDetails.sprites.back_shiny_female)
                                        .placeholder(R.drawable.ic_launcher_background)
                                        .resize(550, 550)
                                        .into(imageView);
                                gallery.addView(view);
                                final Animation zoomAnimation = AnimationUtils.loadAnimation(getBaseContext(),R.anim.zoom_card);
                                imageView.startAnimation(zoomAnimation);

                            }
                            i++;
                        } if(i==2)
                        {
                            if(pokeDetails.sprites.back_default != null) {
                                View view = inflater.inflate(R.layout.item_list, gallery, false);
                                ImageView imageView = view.findViewById(R.id.imageView);
                                Picasso.get().load(pokeDetails.sprites.back_default)
                                        .placeholder(R.drawable.ic_launcher_background)
                                        .resize(550, 550)
                                        .into(imageView);
                                gallery.addView(view);
                                final Animation zoomAnimation = AnimationUtils.loadAnimation(getBaseContext(),R.anim.zoom_card);
                                imageView.startAnimation(zoomAnimation);

                            }
                            i++;
                        } if(i==3)
                        {
                            if(pokeDetails.sprites.front_female != null) {
                                View view = inflater.inflate(R.layout.item_list, gallery, false);
                                ImageView imageView = view.findViewById(R.id.imageView);
                                Picasso.get().load(pokeDetails.sprites.front_female)
                                        .placeholder(R.drawable.ic_launcher_background)
                                        .resize(550, 550)
                                        .into(imageView);
                                gallery.addView(view);
                                final Animation zoomAnimation = AnimationUtils.loadAnimation(getBaseContext(),R.anim.zoom_card);
                                imageView.startAnimation(zoomAnimation);

                            }
                            i++;
                        } if(i==4)
                        {
                            if(pokeDetails.sprites.front_shiny_female != null) {
                                View view = inflater.inflate(R.layout.item_list, gallery, false);
                                ImageView imageView = view.findViewById(R.id.imageView);
                                Picasso.get().load(pokeDetails.sprites.front_shiny_female)
                                        .placeholder(R.drawable.ic_launcher_background)
                                        .resize(550, 550)
                                        .into(imageView);
                                gallery.addView(view);
                                final Animation zoomAnimation = AnimationUtils.loadAnimation(getBaseContext(),R.anim.zoom_card);
                                imageView.startAnimation(zoomAnimation);

                            }
                            i++;
                        } if(i==5) {
                            if (pokeDetails.sprites.back_shiny != null) {

                            View view = inflater.inflate(R.layout.item_list, gallery, false);
                            ImageView imageView = view.findViewById(R.id.imageView);
                            Picasso.get().load(pokeDetails.sprites.back_shiny)
                                    .placeholder(R.drawable.ic_launcher_background)
                                    .resize(550, 550)
                                    .into(imageView);
                            gallery.addView(view);
                                final Animation zoomAnimation = AnimationUtils.loadAnimation(getBaseContext(),R.anim.zoom_card);
                                imageView.startAnimation(zoomAnimation);

                        }
                            i++;
                        } if(i==6)
                        {
                            if(pokeDetails.sprites.front_default != null) {
                                View view = inflater.inflate(R.layout.item_list, gallery, false);
                                ImageView imageView = view.findViewById(R.id.imageView);
                                Picasso.get().load(pokeDetails.sprites.front_default)
                                        .placeholder(R.drawable.ic_launcher_background)
                                        .resize(550, 550)
                                        .into(imageView);
                                gallery.addView(view);
                                final Animation zoomAnimation = AnimationUtils.loadAnimation(getBaseContext(),R.anim.zoom_card);
                                imageView.startAnimation(zoomAnimation);

                            }
                            i++;

                        } if(i==7)
                        {
                            if(pokeDetails.sprites.front_shiny != null) {
                                View view = inflater.inflate(R.layout.item_list, gallery, false);
                                ImageView imageView = view.findViewById(R.id.imageView);
                                Picasso.get().load(pokeDetails.sprites.front_shiny)
                                        .placeholder(R.drawable.ic_launcher_background)
                                        .resize(550, 550)
                                        .into(imageView);
                                gallery.addView(view);
                                final Animation zoomAnimation = AnimationUtils.loadAnimation(getBaseContext(),R.anim.zoom_card);
                                imageView.startAnimation(zoomAnimation);

                            }
                            i=0;
                        }



                    }
                });


            }
        });

    }

}
