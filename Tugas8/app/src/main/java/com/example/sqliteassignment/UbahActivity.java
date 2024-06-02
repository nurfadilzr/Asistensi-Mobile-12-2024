package com.example.sqliteassignment;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.core.view.WindowCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.sqliteassignment.databinding.ActivityUbahBinding;

public class UbahActivity extends AppCompatActivity {
    private EditText et_judul, et_deskripsi;
    private Button btn_submit;
    private DBConfig dbConfig;
    private int recordId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ubah);

        et_judul = findViewById(R.id.et_judul);
        et_deskripsi = findViewById(R.id.et_deskripsi);
        btn_submit = findViewById(R.id.btn_submit);
        dbConfig = new DBConfig(this);

        // Pastikan action bar diatur setelah setContentView
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Ubah");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }


        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("record_id")) {
            recordId = intent.getIntExtra("record_id", -1);
            loadRecordData(recordId);
        }

        btn_submit.setOnClickListener(v -> {
            String title = et_judul.getText().toString().trim();
            String description = et_deskripsi.getText().toString().trim();

            if (!title.isEmpty() && !description.isEmpty()) {
                dbConfig.updateRecord(recordId, title, description);
                finish();
            } else {
                Toast.makeText(this, "Please fill the field", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void loadRecordData(int id) {
        Cursor cursor = dbConfig.getReadableDatabase().rawQuery("SELECT * FROM " + dbConfig.getTableName() + " WHERE " + dbConfig.getColumnId() + " = ?", new String[]{String.valueOf(id)});
        if (cursor != null && cursor.moveToFirst()) {
            et_judul.setText(cursor.getString(cursor.getColumnIndexOrThrow(dbConfig.getColumnJudul())));
            et_deskripsi.setText(cursor.getString(cursor.getColumnIndexOrThrow(dbConfig.getColumnDeskripsi())));
            cursor.close();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_delete) {
            dbConfig.deleteRecords(recordId);
            finish();
            Toast.makeText(this, "Delete action clicked", Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == android.R.id.home) {
            // Tangani aksi tombol kembali di sini
            onBackPressed();
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }

}