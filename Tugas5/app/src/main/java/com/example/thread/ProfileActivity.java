package com.example.thread;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ProfileActivity extends AppCompatActivity {

    public static final String EXTRA_PROFILE = "profile";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_profile);

        ImageView iv_profile = findViewById(R.id.iv_profile);
        TextView tv_username = findViewById(R.id.tv_username);
        TextView tv_name = findViewById(R.id.tv_name);
        ProgressBar progressBar = findViewById(R.id.progressBar);

        iv_profile.setVisibility(View.GONE);
        tv_username.setVisibility(View.GONE);
        tv_name.setVisibility(View.GONE);
        progressBar.setVisibility(View.VISIBLE);

        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);

//                    progressBar.setVisibility(View.GONE);
//                    iv_profile.setVisibility(View.VISIBLE);
//                    tv_username.setVisibility(View.VISIBLE);
//                    tv_name.setVisibility(View.VISIBLE);

                    // perubahan ui harus dilakukan di main thread atau ui thread
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            progressBar.setVisibility(View.GONE);
                            iv_profile.setVisibility(View.VISIBLE);
                            tv_username.setVisibility(View.VISIBLE);
                            tv_name.setVisibility(View.VISIBLE);
                        }
                    });

                    Intent intent = getIntent();
                    Post post = intent.getParcelableExtra(EXTRA_PROFILE);

                    assert post != null;
                    iv_profile.setImageResource(post.getProfilePhoto());
                    tv_username.setText(post.getUsername());
                    tv_name.setText(post.getName());

                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }
}