package com.example.tugasbesar1mobile;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;


import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

public class scan_ktp_real extends AppCompatActivity {
    ImageButton btnScanBarcode;
    TextView resultText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_scan_ktp_real);
        btnScanBarcode = findViewById(R.id.hasil_scantext);
        resultText = findViewById(R.id.textView25);
        btnScanBarcode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(scan_ktp_real.this, ScannedBarcodeActivity.class);
                scanBarcodeLauncher.launch(intent);
            }
        });


    }
    private ActivityResultLauncher<Intent> scanBarcodeLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                if (result.getResultCode() == Activity.RESULT_OK) {
                    Intent data = result.getData();
                    if (data != null && data.hasExtra("intentData")) {
                        String intentData = data.getStringExtra("intentData");
                        int counterValue = getIntent().getIntExtra("counter_value", 0);
                        // Uncomment the following line if you want to pass a Bitmap as well
                        // Bitmap barcodeImage = data.getParcelableExtra("barcodeImage");

                        // Menampilkan hasil pemindaian dan gambar QR code
                        Intent displayIntent = new Intent(scan_ktp_real.this, DisplayImageActivity.class);
                        displayIntent.putExtra("intentData", intentData);
                        // Uncomment the following line if you are passing a Bitmap as well
                        // displayIntent.putExtra("barcodeImage", barcodeImage);
                        displayIntent.putExtra("counter_value", counterValue);
                        startActivity(displayIntent);


                    }
                }
            });
    public void reesult_scan_ktp(View view) {
        Intent intent = new Intent(scan_ktp_real.this, reesult_scan_ktp.class);
        startActivity(intent );

    }
    public void go_home(View view) {
        Intent intent = new Intent(this, beranda.class);
        startActivity(intent );

    }
}