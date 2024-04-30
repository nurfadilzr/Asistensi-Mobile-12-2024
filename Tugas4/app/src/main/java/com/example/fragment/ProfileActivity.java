package com.example.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import android.widget.ImageView;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {

    ImageView iv_profile;
    TextView tv_username, tv_name;
    public static final String E = "data";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_profile);

        iv_profile = findViewById(R.id.iv_profile);
        tv_username = findViewById(R.id.tv_username);
        tv_name = findViewById(R.id.tv_name);

        Intent intent = getIntent();
        Post post = intent.getParcelableExtra(E);

        assert post != null;

        iv_profile.setImageResource(post.getProfilePhoto());
        tv_username.setText(post.getUsername());
        tv_name.setText(post.getName());
    }
}