package com.example.projectfinalefix.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.projectfinalefix.R;
import com.example.projectfinalefix.databinding.ActivityHomeBinding;
import com.example.projectfinalefix.model.APIResponse;
import com.example.projectfinalefix.viewmodel.UserViewModel;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class HomeActivity extends AppCompatActivity {
    private ActivityHomeBinding binding;
    private UserViewModel userViewModel;
    private ImageButton bpjspaymentBT, mutasirekeningBT;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        init();
        onCLickGroup();

    }


    void init(){
        userViewModel = ViewModelProviders.of(this).get(UserViewModel.class);
        userViewModel.init();
        SharedPreferences sharedPreferences = getSharedPreferences("com.example.projectfinale.login", Context.MODE_PRIVATE);
        String username = sharedPreferences.getString("com.example.projectfinale.login", "");
        System.out.println("Username : " + username);
        userViewModel.getSaldo(username).observe(this, new Observer<APIResponse>() {
            @Override
            public void onChanged(APIResponse apiResponse) {
                DecimalFormat kurs = (DecimalFormat) DecimalFormat.getCurrencyInstance();
                DecimalFormatSymbols formatRp = new DecimalFormatSymbols();
                formatRp.setCurrencySymbol("Rp. ");
                formatRp.setMonetaryDecimalSeparator(',');
                formatRp.setGroupingSeparator('.');
                kurs.setDecimalFormatSymbols(formatRp);
                Double saldo = Double.parseDouble(apiResponse.getMessage());
                binding.totalsaldorpTV.setText(kurs.format(saldo));
            }
        });

    }
//    void findViewById(){
//        bpjspaymentBT = findViewById(R.id.bpjspaymentBT);
//        mutasirekeningBT = findViewById(R.id. mutasirekeningBT);
//
//    }

    void onCLickGroup() {
//        bpjspaymentBT.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(HomeActivity.this, BpjsActivity.class);
//                startActivity(intent);
//
//            }
//        });
//        mutasirekeningBT.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(HomeActivity.this, MutasiActivity.class);
//                startActivity(intent);
//
//            }
//        });
    }

}