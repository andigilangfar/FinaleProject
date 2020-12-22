package com.example.projectfinalefix.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.projectfinalefix.R;

public class LoginActivity extends AppCompatActivity {
    private Button loginBT,registerhereBT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        findViewById();
        onCLickGroup();
    }

    void findViewById(){
        loginBT = findViewById(R.id.loginBT);
        registerhereBT = findViewById(R.id.registerhereBT);
    }

    void onCLickGroup(){
        registerhereBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);

      }
        });
        loginBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }




}