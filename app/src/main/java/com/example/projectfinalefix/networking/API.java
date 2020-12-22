package com.example.projectfinalefix.networking;

import com.example.projectfinalefix.model.APIResponse;
import com.example.projectfinalefix.model.LoginRequest;
import com.example.projectfinalefix.model.RegisterRequest;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface API {
    @POST("/register")
    Call<APIResponse> register (@Body RegisterRequest registerRequest);

    @POST("/login/")
    Call<APIResponse> login (@Body LoginRequest loginRequest);

    @GET("/nasabah")
    Call<APIResponse> getNasabah();

    @GET("/bpjs")
    Call<APIResponse> getBpjs();

    @GET("/checksaldo/{username}")
    Call<APIResponse> getSaldo(@Path("username")String checkSaldo);

}
