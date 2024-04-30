package com.example.tugas2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity3 extends AppCompatActivity {
    public static final String EXTRA_USER = "extra_user";

    ImageView terimaFoto;
    TextView terimaNama, terimaUser, terimaTitle, terimaContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        terimaFoto = findViewById(R.id.terimaFoto);
        terimaNama = findViewById(R.id.terimaNama);
        terimaUser = findViewById(R.id.terimaUser);
        terimaTitle = findViewById(R.id.terimaTitle);
        terimaContent = findViewById(R.id.terimaContent);

        Intent intent = getIntent();
        User user = intent.getParcelableExtra(EXTRA_USER);
        String nama = intent.getStringExtra("nama");
        String username = intent.getStringExtra("username");
        String title = intent.getStringExtra("title");
        String content = intent.getStringExtra("content");
        String foto = intent.getStringExtra("foto");
        Uri imageUri = Uri.parse(foto);

        terimaFoto.setImageURI(imageUri);
        terimaNama.setText(nama);
        terimaUser.setText(username);
        terimaTitle.setText(title);
        terimaContent.setText(content);

        // begitu mmg cara kerjanya intent. dari activity 1 dikirim ke activity selanjutnya gabisa skip
    }
}