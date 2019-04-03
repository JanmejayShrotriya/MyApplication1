package com.example.lenovo.myapplication1.Network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MyBase {

    public static final String BASE="http://collegeinventory.000webhostapp.com/android/";

   static Retrofit retrofit=null;

    public static Retrofit getRetrofit() {

        if(retrofit==null){
            retrofit=new Retrofit.Builder()
                    .baseUrl(BASE)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit;
    }
}
