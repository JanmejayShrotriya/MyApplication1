package com.example.lenovo.myapplication1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class splesh extends AppCompatActivity {
ImageView i;
    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        i=(ImageView)findViewById(R.id.imageView2);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                SharedPreferences preferences = getSharedPreferences("pref", MODE_PRIVATE);
                if (preferences.getBoolean("loggedin", false) == true) {
                    startActivity(new Intent(splesh.this, Main3Activity.class));

                } else {
                    startActivity(new Intent(splesh.this, Main2Activity.class));
                }
                finish();
            }
        },3000);




    Animation myanim= AnimationUtils.loadAnimation(this,R.anim.fortop);
        i.startAnimation(myanim);
    }
}
