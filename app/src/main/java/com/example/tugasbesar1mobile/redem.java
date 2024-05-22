package com.example.tugasbesar1mobile;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class redem extends AppCompatActivity {
    private int counter = 0;
    private TextView tvCounter;
    private ImageButton tambah, kurang;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_redem);
        tvCounter = findViewById(R.id.result_shope);
        tambah = findViewById(R.id.tambah_shope);
        kurang = findViewById(R.id.kurang_shope);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        tambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter++;
                tvCounter.setText(" " + counter);
            }
        });
        kurang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter++;
                tvCounter.setText(" " + counter);
            }
        });

    }

    public void  gotraveloka(View view) {
        // Kode untuk berpindah ke halaman baru
        Intent intent = new Intent(this, traveloka.class);
        startActivity(intent);
    }
    public void go_home(View view) {
        Intent intent = new Intent(this, beranda.class);
        startActivity(intent );

    }
}