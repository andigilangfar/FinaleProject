package com.example.projectfinalefix.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import com.example.projectfinalefix.R;
import com.example.projectfinalefix.databinding.ActivityLoginBinding;
import com.example.projectfinalefix.model.APIResponse;
import com.example.projectfinalefix.model.LoginRequest;
import com.example.projectfinalefix.viewmodel.UserViewModel;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;

public class LoginActivity extends AppCompatActivity {
    private Button loginBT, registerhereBT;

    private ActivityLoginBinding binding;
    private UserViewModel userViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        init();
        onCLickGroup();
    }

    void init() {
        userViewModel = ViewModelProviders.of(this).get(UserViewModel.class);
        userViewModel.init();
    }

    void onCLickGroup() {
        binding.loginBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doLogin();
            }
        });
        binding.registerhereBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity(intent);
            }
        });
    }

    void doLogin() {
        String username = binding.loginusernameET.getText().toString();
        String password = binding.loginpasswordET.getText().toString();
        LoginRequest loginRequest = new LoginRequest(username, password);
        userViewModel.postLogin(loginRequest).observe(this,apiResponse ->{
            APIResponse response = apiResponse;
            if (response.getResponse() == 200) {
                SharedPreferences sharedPreferences = getSharedPreferences("com.example.projectfinale.login", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("com.example.projectfinale.login", binding.loginusernameET.getText().toString());
                editor.apply();
                Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                startActivity(intent);
                finish();
            } else {
                new MaterialAlertDialogBuilder(this)
                        .setTitle("Gagal Login")
                        .setMessage("Username atau Password Salah")
                        .setNegativeButton("close", null)
                        .show();
            }
        });
    }
}