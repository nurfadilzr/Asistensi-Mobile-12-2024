package com.example.tugas2;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ImageView pilihFoto;
    EditText inputNama, inputUsername;
    Button btnSubmit;
    private Uri foto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pilihFoto       = findViewById(R.id.pilihFoto);
        inputNama       = findViewById(R.id.inputNama);
        inputUsername   = findViewById(R.id.inputUsername);
        btnSubmit       = findViewById(R.id.btnSubmit);

        // objek utk memulai activity yang mengambil foto dari galeri dan menangani hasilnya
        ActivityResultLauncher<Intent> launcherIntentGallery = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(), result -> {
                    // periksa kode hasil aktivitas apakah selesai dgn sukses
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        // mengambil data hasil dri aktivitas yg sdh dimulai
                        // getData() utk mendapatkan intent yang digunakan untuk memulai aktivitas tersebut
                        Intent data = result.getData();
                        // untuk mendapatkan URI foto dari intent
                        foto = data.getData();
                        pilihFoto.setImageURI(foto);
                    }
                }
        );

        // buka galeri, foto yg dipilih dihandle diatas
        pilihFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openGallery = new Intent(Intent.ACTION_PICK);
                openGallery.setType("image/*");
                // memulai aktivitas (galeri) dengan intent yang telah disiapkan sebelumnya (openGallery).
                launcherIntentGallery.launch(openGallery);
            }
        });

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nama = inputNama.getText().toString();
                String username = inputUsername.getText().toString();

                if (foto != null && !nama.isEmpty() && !username.isEmpty()) {
                    // buat objek dri kls user dgn parameter
                    User user = new User(nama, username);
                    Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                    intent.putExtra("nama", nama);
                    intent.putExtra("username", username);
                    intent.putExtra("foto", foto.toString());
                    intent.putExtra(MainActivity3.EXTRA_USER, user);
                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity.this, "Harap lengkapi", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}