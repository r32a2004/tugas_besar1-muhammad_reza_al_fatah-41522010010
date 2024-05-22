package com.example.tugasbesar1mobile;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class auth extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_auth);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void login(View view) {
        Intent intent = new Intent(auth.this, login.class);
        startActivity(intent);

    }

    public void register(View view) {
        Intent intent = new Intent(auth.this, register.class);
        startActivity(intent);

    }


    protected void onResume() {
        super.onResume();

        Configuration newConfig = getResources().getConfiguration();
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            // Memuat layout landscape
            setContentView(R.layout.activity_auth_land);
        } else {
            // Memuat layout portrait
            setContentView(R.layout.activity_auth);
        }

    }
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // Cek apakah orientasi layar berubah menjadi landscape
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            // Memuat layout landscape
            setContentView(R.layout.activity_auth_land);
        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
            // Memuat layout portrait
            setContentView(R.layout.activity_auth);
        }
    }
}


