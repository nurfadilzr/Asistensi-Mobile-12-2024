package com.example.sharedpreferencesassignment;

import android.content.SharedPreferences;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;

import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.view.WindowCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.sharedpreferencesassignment.databinding.ActivitySettingBinding;

public class SettingActivity extends AppCompatActivity {

    Switch switch_mode;
    SharedPreferences modePreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        switch_mode = findViewById(R.id.switch_mode);
        modePreferences = getSharedPreferences("mode_pref", MODE_PRIVATE);
        SharedPreferences.Editor editor = modePreferences.edit();

        // ambil nilai boolean yg kesimpen, klo gaada yg disimpen jadinya false (mode terang)
        boolean DarkTheme = modePreferences.getBoolean("dark_theme", false);
        // set tombol switch nya sesuai boolean yg diatas
        switch_mode.setChecked(DarkTheme);

        switch_mode.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                // isChecked utk liat klo switch berubah, klo true darkmode nyala
                if (isChecked) {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                } else {
                    // Mengaktifkan tema terang
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                }

                // set nilai boolean key nya dark_theme, value sesuai isChecked
                editor.putBoolean("dark_theme", isChecked);
                editor.apply();
            }
        });
    }
}