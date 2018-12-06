package com.example.lenovo.myapplication1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.TextView;

public class register extends AppCompatActivity implements View.OnClickListener {
CardView c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        c=(CardView)findViewById(R.id.cardView);
        c.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        Intent i=new Intent(register.this,Main2Activity.class);
        startActivity(i);
    }
}
