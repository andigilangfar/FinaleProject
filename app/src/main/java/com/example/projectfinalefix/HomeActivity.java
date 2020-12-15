package com.example.projectfinalefix;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity {
    private Button bpjspaymentBT, mutasirekeningBT;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        findViewById();
        onCLickGroup();

    }

    void findViewById(){
        bpjspaymentBT = findViewById(R.id.bpjspaymentBT);
        mutasirekeningBT = findViewById(R.id. mutasirekeningBT);

    }

    void onCLickGroup() {
        bpjspaymentBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, BpjsActivity.class);
                startActivity(intent);
            }
        });
        mutasirekeningBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, MutasiActivity.class);
                startActivity(intent);
            }
        });
    }

}