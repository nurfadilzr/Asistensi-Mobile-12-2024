package com.example.sharedpreferencesassignment;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.core.view.WindowCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.sharedpreferencesassignment.databinding.ActivityHomeBinding;

public class HomeActivity extends AppCompatActivity {

    TextView tv_selamat;
    Button btn_logout, btn_setting;
    SharedPreferences userPreferences, modePreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        tv_selamat = findViewById(R.id.tv_selamat);
        btn_logout = findViewById(R.id.btn_logout);
        btn_setting = findViewById(R.id.btn_setting);
        userPreferences = getSharedPreferences("user_pref", MODE_PRIVATE);

        String nim = userPreferences.getString("nim", "");
        tv_selamat.setText("Selamat Datang" + " " + nim);

        btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        btn_setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, SettingActivity.class);
                startActivity(intent);
            }
        });

        modePreferences = getSharedPreferences("mode_pref", MODE_PRIVATE);
    }
}