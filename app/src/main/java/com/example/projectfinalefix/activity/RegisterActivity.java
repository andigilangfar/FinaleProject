package com.example.projectfinalefix.activity;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.projectfinalefix.R;
import com.example.projectfinalefix.databinding.ActivityRegisterBinding;
import com.example.projectfinalefix.model.APIResponse;
import com.example.projectfinalefix.model.RegisterRequest;
import com.example.projectfinalefix.viewmodel.UserViewModel;

import java.time.LocalDate;

public class RegisterActivity extends AppCompatActivity {
    private UserViewModel userViewModel;
    private ActivityRegisterBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        binding = ActivityRegisterBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        init();
        onClickGroup();
    }

    void onClickGroup(){
        binding.registregisterBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doRegister();
            }
        });
    }

    private void init(){
        userViewModel = ViewModelProviders.of(this).get(UserViewModel.class);
        userViewModel.init();
    }

    private void doRegister(){
        String username =  binding.registpasswordET.getText().toString();
        String password =  binding.registpasswordET.getText().toString();
        String nama_lengkap = binding.fullnameET.getText().toString();
        String alamat =  binding.addressET.getText().toString();
        String email =  binding.emailET.getText().toString();
        String no_telp =  binding.notelpET.getText().toString();


        if (password.equals("")){
            Toast.makeText(getApplicationContext(),"Password Harus Di Isi", Toast.LENGTH_SHORT).show();
        } else {
            RegisterRequest registerRequest = new RegisterRequest(username, password, email, alamat, no_telp, nama_lengkap);
            userViewModel.postRegister(registerRequest).observe(this,nasabahResponse -> {
                System.out.println("atas response : " + nasabahResponse.getMessage());
                APIResponse response = nasabahResponse;
                if (response.getResponse() == 200) {
                    moveToMessageActivity("Sukses", "Selamat Anda Berhasil Terdaftar", 200);
                    Toast.makeText(getApplicationContext(), "Registrasi Berhasil", Toast.LENGTH_SHORT).show();
                }
            });
            }

        }

        void moveToMessageActivity(String status, String message, int code){
        Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("status", status);
        bundle.putString("message", message);
        bundle.putInt("code", code);
        intent.putExtras(bundle);
        startActivity(intent);
        }
    }
