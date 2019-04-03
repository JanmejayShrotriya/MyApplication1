package com.example.lenovo.myapplication1;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.lenovo.myapplication1.Network.MyBase;
import com.example.lenovo.myapplication1.Network.MyCalls;
import com.example.lenovo.myapplication1.Network.ServerFormat;

import retrofit2.Call;
import retrofit2.Callback;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener {
    CardView c;
    EditText name, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        name = findViewById(R.id.username);
        password = findViewById(R.id.password);

        c = findViewById(R.id.login);
        c.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {

        if (TextUtils.isEmpty(name.getText().toString().trim())) {

            name.setError("Please Enter Email");
            name.requestFocus();
        }
//         else if (!Patterns..matcher(name.getText().toString().trim()).matches()) {
//
//            name.setError("Please Enter Valid Email");
//            name.requestFocus();
//
//        }
         else if (TextUtils.isEmpty(password.getText().toString().trim())) {

            password.setError("Please Enter Password");
            password.requestFocus();
        }
        else if (!(password.getText().toString().length() >= 6)) {

            password.setError("Please Enter Minimum 6 Character Password");
            password.requestFocus();
        }
        else {
            /*      */
            login();
        }

    }


    public void login() {

        final ProgressDialog dialog = new ProgressDialog(Main2Activity.this);
        dialog.setMessage("please wait");
        dialog.setCancelable(false);
        dialog.show();

        MyCalls calls = MyBase.getRetrofit().create(MyCalls.class);
        Call<ServerFormat> call = calls.login(name.getText().toString().trim(), password.getText().toString().trim());
        call.enqueue(new Callback<ServerFormat>() {
            @Override
            public void onResponse(Call<ServerFormat> call, retrofit2.Response<ServerFormat> response) {
                dialog.dismiss();
                if (response.body().status.equals("1")) {
                    Toast.makeText(Main2Activity.this, "Login Successfully ", Toast.LENGTH_SHORT).show();
                    SharedPreferences preferences = getSharedPreferences(
                            "pref", MODE_PRIVATE);
                    preferences.edit().putBoolean("loggedin", true).commit();
                    preferences.edit().putString("name", name.getText().toString().trim()).commit();
                    Intent i = new Intent(Main2Activity.this, Main3Activity.class);
                    startActivity(i);
                    finish();

                } else {
                    Toast.makeText(Main2Activity.this, "invalid credentials", Toast.LENGTH_SHORT).show();

                }

            }

            @Override
            public void onFailure(Call<ServerFormat> call, Throwable t) {
                Toast.makeText(Main2Activity.this, "internet error", Toast.LENGTH_SHORT).show();
                dialog.dismiss();

            }
        });


    }

}