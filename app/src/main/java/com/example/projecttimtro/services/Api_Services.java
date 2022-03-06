package com.example.projecttimtro.services;

import com.example.projecttimtro.models.auth.MessageSignInModel;
import com.example.projecttimtro.models.auth.UserModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.PUT;

public interface Api_Services {
    //GET
    @GET("/getAuthSignIn")
    Call<MessageSignInModel> getToken();

    //PUT
    @PUT("/putAuthSignIn")
    Call<List<UserModel>> authUser(@Body UserModel body);
}
