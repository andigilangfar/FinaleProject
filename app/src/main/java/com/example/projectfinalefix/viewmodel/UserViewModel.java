package com.example.projectfinalefix.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.projectfinalefix.model.APIResponse;
import com.example.projectfinalefix.model.LoginRequest;
import com.example.projectfinalefix.model.RegisterRequest;
import com.example.projectfinalefix.repositories.UserRepository;

public class UserViewModel extends ViewModel {
    private UserRepository userRepository;
    private LiveData<APIResponse> mutableLiveData;
    public void init(){
        if(mutableLiveData!=null){
            return;
        }
        userRepository = userRepository.getInstance();
    }
    public LiveData<APIResponse> postRegister(RegisterRequest registerRequest){
        if(mutableLiveData==null){
            userRepository = userRepository.getInstance();
        }
        mutableLiveData = userRepository.postRegister(registerRequest);
        return mutableLiveData;
    }

    public LiveData<APIResponse> postLogin(LoginRequest loginRequest){
        if (mutableLiveData == null){
            userRepository = UserRepository.getInstance();
        }
        mutableLiveData = userRepository.postLogin(loginRequest);
        return mutableLiveData;
    }

    public LiveData<APIResponse> getSaldo(String string){
        if (mutableLiveData == null){
            userRepository = UserRepository.getInstance();
        }
        mutableLiveData = userRepository.getSaldo(string);
        return mutableLiveData;
    }
}
