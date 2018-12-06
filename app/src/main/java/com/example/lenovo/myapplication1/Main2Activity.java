package com.example.lenovo.myapplication1;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener{
TextView t;
CardView c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        t=(TextView)findViewById(R.id.textView2);
        t.setOnClickListener(this);
        c=(CardView) findViewById(R.id.cardView);
        c.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.textView2:
            Intent i = new Intent(Main2Activity.this, register.class);
            startActivity(i);
            break;
            case R.id.cardView:
            Intent i1 = new Intent(Main2Activity.this, Main3Activity.class);
            startActivity(i1);
            break;
        }
    }
}
