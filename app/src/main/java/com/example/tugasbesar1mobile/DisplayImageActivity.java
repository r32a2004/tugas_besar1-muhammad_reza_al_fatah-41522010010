package com.example.tugasbesar1mobile;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

public class DisplayImageActivity extends AppCompatActivity {

    ImageView barcodeImageView;
    TextView intentDataTextView,poin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_image);

        barcodeImageView = findViewById(R.id.imageView37);
        intentDataTextView = findViewById(R.id.hasil_scantext);
        poin = findViewById(R.id.poin);

        // Mengambil data dari intent
        Intent intent = getIntent();
        if (intent != null) {
            String intentData = intent.getStringExtra("intentData");
            int counterValue = intent.getIntExtra("counter_value", 0);

            // Menampilkan data hasil pemindaian
            intentDataTextView.setText(intentData);
            poin.setText(String.valueOf(counterValue));

            // Mengonversi teks menjadi gambar kode QR
            Bitmap qrBitmap = generateQRCode(intentData);

            // Menampilkan gambar kode QR di ImageView
            barcodeImageView.setImageBitmap(qrBitmap);
        }
    }

    private Bitmap generateQRCode(String text) {
        try {
            QRCodeWriter writer = new QRCodeWriter();
            BitMatrix bitMatrix = writer.encode(text, BarcodeFormat.QR_CODE, 512, 512);
            int width = bitMatrix.getWidth();
            int height = bitMatrix.getHeight();
            Bitmap bmp = Bitmap.createBitmap(width, height, Bitmap.Config.RGB_565);
            for (int x = 0; x < width; x++) {
                for (int y = 0; y < height; y++) {
                    bmp.setPixel(x, y, bitMatrix.get(x, y) ? 0xFF000000 : 0xFFFFFFFF);
                }
            }
            return bmp;
        } catch (WriterException e) {
            e.printStackTrace();
            return null;
        }
    }
    public void go_home(View view) {
        Intent intent = new Intent(DisplayImageActivity.this, beranda.class);
        intent.putExtra("counter_value", Integer.parseInt(poin.getText().toString()));

        startActivity(intent );

    }
    public void go_scan(View view) {

        Intent intent = new Intent(DisplayImageActivity.this, scan_ktp.class);

        startActivity(intent );

    }
}
