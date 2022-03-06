package com.example.projecttimtro.services;

import com.google.gson.Gson;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public interface Instance {
    Gson gson = new Gson();
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://192.168.0.7:8000")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build();
}
