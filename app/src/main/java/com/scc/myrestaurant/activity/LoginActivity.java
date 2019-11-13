package com.scc.myrestaurant.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.scc.myrestaurant.R;
import com.scc.myrestaurant.activity.MainActivity;

public class LoginActivity extends AppCompatActivity {
    Button btn_pindah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        btn_pindah = findViewById(R.id.masuk);
        btn_pindah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent view = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(view);
            }
        });
        btn_pindah = findViewById(R.id.daftar);
        btn_pindah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent view = new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity(view);
            }
        });

    }
}
