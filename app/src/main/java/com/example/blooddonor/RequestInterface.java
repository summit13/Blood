package com.example.blooddonor;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface RequestInterface {

    @FormUrlEncoded
    @POST("register.php")
    Call<JsonResponse> create(@Field("name") String name, @Field("address") String address, @Field("dob") String dob, @Field("phone") String phone, @Field("email") String email, @Field("password") String password, @Field("bloodGroup") String bloodGroup);

    @FormUrlEncoded
    @POST("login.php")
    Call<JsonResponse> login(@Field("email") String email, @Field("password") String password);

}


