package com.example.projecttimtro.services;

import com.google.gson.Gson;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public interface InstanceServerProvinces {

    ConfigIpServer configProvince = new ConfigIpServer();
    Gson gson = new Gson();
    Retrofit retrofitProvince = new Retrofit.Builder()
            .baseUrl(configProvince.ipAddressServerProvinces)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build();
}
