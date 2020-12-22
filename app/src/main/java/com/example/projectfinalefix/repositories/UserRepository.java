package com.example.projectfinalefix.repositories;

import androidx.lifecycle.MutableLiveData;

import com.example.projectfinalefix.model.APIResponse;
import com.example.projectfinalefix.model.LoginRequest;
import com.example.projectfinalefix.model.RegisterRequest;
import com.example.projectfinalefix.networking.API;
import com.example.projectfinalefix.networking.RetrofitService;
import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserRepository {

    private static UserRepository userRepository;
    private API api;

    public static UserRepository getInstance(){
        if(userRepository==null){
            userRepository=new UserRepository();
        }
        return userRepository;
    }

    public UserRepository(){
        api = RetrofitService.createService(API.class);
    }

    public MutableLiveData<APIResponse> postRegister(RegisterRequest registerRequest){
        String request = new Gson().toJson(registerRequest);
        System.out.println("request : " + request);
        MutableLiveData<APIResponse> response = new MutableLiveData<>();
        api.register(registerRequest).enqueue(new Callback<APIResponse>() {
            @Override
            public void onResponse(Call<APIResponse> call, Response<APIResponse> responses) {
                response.setValue(responses.body());
                System.out.println("test : " + responses.body());
            }

            @Override
            public void onFailure(Call<APIResponse> call, Throwable t) {
                System.out.println("test ");
            }
        });
        return response;
    }

    public MutableLiveData<APIResponse> postLogin(LoginRequest loginRequest){
        MutableLiveData<APIResponse> loginResult = new MutableLiveData<>();
        api.login(loginRequest).enqueue(new Callback<APIResponse>() {
            @Override
            public void onResponse(Call<APIResponse> call, Response<APIResponse> response) {
                loginResult.setValue(response.body());
            }

            @Override
            public void onFailure(Call<APIResponse> call, Throwable t) {
                loginResult.setValue(null);
            }
        });
        return loginResult;
    }

    public MutableLiveData<APIResponse> getSaldo(String string){
        MutableLiveData<APIResponse> saldoRequest = new MutableLiveData<>();
        api.getSaldo(string).enqueue(new Callback<APIResponse>() {
            @Override
            public void onResponse(Call<APIResponse> call, Response<APIResponse> response) {
                saldoRequest.setValue(response.body());
                System.out.println("Testv");
            }

            @Override
            public void onFailure(Call<APIResponse> call, Throwable t) {
                saldoRequest.setValue(null);
            }
        });
        return saldoRequest;
    }
}
