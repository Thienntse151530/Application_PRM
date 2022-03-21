package com.example.projecttimtro.services;

import com.example.projecttimtro.models.address.MessageAddress;
import com.example.projecttimtro.models.address.Province;
import com.example.projecttimtro.models.hostel.HostelModel;
import com.example.projecttimtro.models.auth.MessageSignInModel;
import com.example.projecttimtro.models.auth.UserModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface Api_Services {
    //GET
    @GET("/getAuthSignIn")
    Call<MessageSignInModel> getToken();

    @GET("/getHostel")
    Call<List<HostelModel>> getHostels();

    @GET("/api/?depth=3")
    Call<List<Province>> getProvinces();

    @GET("/getHostelsByAddress")
    Call<List<HostelModel>> getHostelsByAddress(@Query("mess") String mess, @Query("value") String value);

    //PUT
    @PUT("/putAuthSignIn")
    Call<UserModel> authUser(@Body UserModel body);


}
