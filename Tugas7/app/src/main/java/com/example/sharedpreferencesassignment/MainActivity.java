package com.example.sharedpreferencesassignment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText et_nim, et_password;
    Button btn_login, btn_register;
    SharedPreferences userPreferences, modePreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_nim = findViewById(R.id.et_nim);
        et_password = findViewById(R.id.et_pass);
        btn_login = findViewById(R.id.btn_login);
        btn_register = findViewById(R.id.btn_regis);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userPreferences = getSharedPreferences("user_pref", MODE_PRIVATE);
                String nim = et_nim.getText().toString();
                String pass = et_password.getText().toString();

                String savedNIM = userPreferences.getString("nim", null);
                String savedPassword = userPreferences.getString("pass", null);
                System.out.println(savedPassword);

                // jika nim dan pass terisi
                if (!nim.isEmpty() && !pass.isEmpty()) {
                    // jika pass atau nim yg tersimpan
                    if(savedPassword == null || savedNIM == null){
                        Toast.makeText(MainActivity.this, "Data tidak tersedia", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    if (!nim.equals(savedNIM) && !pass.equals(savedPassword)){
                        Toast.makeText(MainActivity.this, "Username dan password tidak cocok", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    et_nim.setError("Please fill this field");
                    et_password.setError("Please fill this field");
                }
            }
        });

        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });

        modePreferences = getSharedPreferences("mode_pref", MODE_PRIVATE);
        boolean DarkTheme = modePreferences.getBoolean("dark_theme", false);
        if (DarkTheme) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }
    }
}