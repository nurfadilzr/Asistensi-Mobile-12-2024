package com.example.tugas2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    EditText inputTitle, inputContent;
    Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        inputTitle = findViewById(R.id.inputTitle);
        inputContent = findViewById(R.id.inputContent);
        btnSave = findViewById(R.id.btnSave);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = inputTitle.getText().toString();
                String content = inputContent.getText().toString();
                String foto = getIntent().getStringExtra("foto");
                String nama = getIntent().getStringExtra("nama");
                String username = getIntent().getStringExtra("username");

                User user2 = new User(title, content);
                if (!title.isEmpty() && !content.isEmpty()) {
                    Intent intent = new Intent(MainActivity2.this, MainActivity3.class);
                    intent.putExtra("foto", foto);
                    intent.putExtra("nama", nama);
                    intent.putExtra("username", username);
                    intent.putExtra("title", title);
                    intent.putExtra("content", content);
                    intent.putExtra(MainActivity3.EXTRA_USER, user2);
                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity2.this, "Harap lengkapi", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}