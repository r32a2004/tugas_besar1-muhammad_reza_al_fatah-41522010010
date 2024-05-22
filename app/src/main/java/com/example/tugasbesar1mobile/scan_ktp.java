package com.example.tugasbesar1mobile;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

public class scan_ktp extends AppCompatActivity {

    ImageButton btnScanBarcode;
    TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan_ktp);
        btnScanBarcode = findViewById(R.id.hasil_scantext);
        resultText = findViewById(R.id.textView25);
        btnScanBarcode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(scan_ktp.this, ScannedBarcodeActivity.class);
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
                        Bitmap barcodeImage = data.getParcelableExtra("barcodeImage");

                        // Menampilkan hasil pemindaian dan gambar QR code
                        Intent displayIntent = new Intent(scan_ktp.this, DisplayImageActivity.class);
                        displayIntent.putExtra("intentData", intentData);
                        displayIntent.putExtra("barcodeImage", barcodeImage);
                        startActivity(displayIntent);
                    }
                }
            });
    public void go_home(View view) {
        Intent intent = new Intent(scan_ktp.this, beranda.class);
        startActivity(intent );

    }



}
