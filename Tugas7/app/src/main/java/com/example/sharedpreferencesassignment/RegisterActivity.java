package com.example.sharedpreferencesassignment;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.core.view.WindowCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.sharedpreferencesassignment.databinding.ActivityRegisterBinding;

public class RegisterActivity extends AppCompatActivity {

    EditText et_nim, et_password;
    Button btn_register;
    SharedPreferences userPreferences, modePreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        et_nim = findViewById(R.id.et_nim);
        et_password = findViewById(R.id.et_pass);
        btn_register = findViewById(R.id.btn_regis);

        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userPreferences = getSharedPreferences("user_pref", MODE_PRIVATE);
                String nim = et_nim.getText().toString();
                String pass = et_password.getText().toString();

                // jika nim dan pass terisi, data sebelumnya dihapus, data baru disimpan
                if (!nim.isEmpty() && !pass.isEmpty()) {
                    SharedPreferences.Editor editor = userPreferences.edit();

                    editor.clear();
                    editor.apply();

                    editor.putString("nim", nim);
                    editor.putString("pass", pass);
                    editor.apply();

                    Toast.makeText(RegisterActivity.this, "Berhasil Membuat Akun", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    et_nim.setError("Please fill this fields");
                    et_password.setError("Please fill this fields");
                }
            }
        });

        modePreferences = getSharedPreferences("mode_pref", MODE_PRIVATE);
    }
}