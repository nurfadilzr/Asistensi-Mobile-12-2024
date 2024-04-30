package com.example.recyclerview;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.core.view.WindowCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.recyclerview.databinding.ActivityStoryBinding;

public class StoryActivity extends AppCompatActivity {

    ImageView iv_imgStory, iv_profile;
    TextView tv_username;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);

        iv_profile = findViewById(R.id.iv_profile);
        tv_username = findViewById(R.id.tv_username);
        iv_imgStory = findViewById(R.id.iv_imgStory);

        Intent intent = getIntent();
        int profile = intent.getIntExtra("PROFILE", 0);
        String username = intent.getStringExtra("USERNAME");
        int imgStory = intent.getIntExtra("STORY", 0);

        iv_profile.setImageResource(profile);
        tv_username.setText(username);
        iv_imgStory.setImageResource(imgStory);
    }
}