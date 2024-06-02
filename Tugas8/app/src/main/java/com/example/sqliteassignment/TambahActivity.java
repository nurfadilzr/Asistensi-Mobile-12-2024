package com.example.sqliteassignment;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class TambahActivity extends AppCompatActivity {

    private Button btn_submit;
    private EditText et_judul, et_deskripsi;
    private DBConfig dbConfig;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah);

        et_judul = findViewById(R.id.et_judul);
        et_deskripsi = findViewById(R.id.et_deskripsi);
        btn_submit = findViewById(R.id.btn_submit);
        dbConfig = new DBConfig(this);

        // Pastikan action bar diatur setelah setContentView
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Tambah");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        btn_submit.setOnClickListener(v -> {
            String title = et_judul.getText().toString().trim();
            String description = et_deskripsi.getText().toString().trim();

            if (!title.isEmpty() && !description.isEmpty()) {
                dbConfig.insertData(title, description);
                finish();
            } else {
                Toast.makeText(this, "Please fill the field", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == android.R.id.home) {
            // Tangani aksi tombol kembali di sini
            onBackPressed();
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }
}