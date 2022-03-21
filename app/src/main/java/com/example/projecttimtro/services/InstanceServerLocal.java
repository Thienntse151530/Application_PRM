package com.example.projecttimtro.services;

import com.google.gson.Gson;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public interface InstanceServerLocal {
    ConfigIpServer configLocal = new ConfigIpServer();
    Gson gson = new Gson();
    Retrofit retrofitLocal = new Retrofit.Builder()
            .baseUrl(configLocal.ipAddressServerLocal)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build();
}
