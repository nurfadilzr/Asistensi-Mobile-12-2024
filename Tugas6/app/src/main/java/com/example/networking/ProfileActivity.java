package com.example.networking;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProfileActivity extends AppCompatActivity {

    public static final String EXTRA_USER = "user";

    ImageView iv_avatar;
    TextView tv_name, tv_email, tv_lost;
    ProgressBar progressBar1;
    Button btn_retry;
    private ApiService apiService;
    private Handler handler;
    private int userId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        iv_avatar = findViewById(R.id.iv_avatar);
        tv_name = findViewById(R.id.tv_name);
        tv_email = findViewById(R.id.tv_email);
        tv_lost = findViewById(R.id.tv_lost);
        btn_retry = findViewById(R.id.btn_retry);
        progressBar1 = findViewById(R.id.progressBar1);
        handler = new Handler();

        Intent intent = getIntent();
        userId = intent.getIntExtra(EXTRA_USER, -1);

        apiService = RetrofitClient.getClient().create(ApiService.class);
        loadInitialUser();
    }

    private void loadInitialUser() {
        if (isNetworkAvailable()) {
            if (userId != -1) {
                loadUser(userId);
            } else {
                // Handle invalid userId here, if needed
            }
        } else {
            showErrorView();
        }
    }

    private void loadUser(int userId) {
        progressBar1.setVisibility(View.VISIBLE);
        Call<UserResponse2> call = apiService.getUserById(userId);
        call.enqueue(new Callback<UserResponse2>() {
            @Override
            public void onResponse(@NonNull Call<UserResponse2> call, @NonNull Response<UserResponse2> response) {
                if (response.isSuccessful()) {
                    User user = response.body().getData();
                    progressBar1.setVisibility(View.GONE);
                    iv_avatar.setVisibility(View.VISIBLE);
                    tv_name.setVisibility(View.VISIBLE);
                    tv_email.setVisibility(View.VISIBLE);
                    userDetails(user);
                }
            }

            @Override
            public void onFailure(@NonNull Call<UserResponse2> call, @NonNull Throwable t) {
                showErrorView();
            }
        });
    }

    private void userDetails(User user) {
        Picasso.get().load(user.getAvatar()).into(iv_avatar);
        tv_name.setText(user.getFirst_name() + " " + user.getLast_name());
        tv_email.setText(user.getEmail());
    }

    private void showErrorView() {
        tv_lost.setVisibility(View.VISIBLE);
        btn_retry.setVisibility(View.VISIBLE);
        iv_avatar.setVisibility(View.GONE);
        tv_name.setVisibility(View.GONE);
        tv_email.setVisibility(View.GONE);
        progressBar1.setVisibility(View.GONE);

        btn_retry.setOnClickListener(v -> {
            if (isNetworkAvailable()) {
                progressBar1.setVisibility(View.VISIBLE);
                tv_lost.setVisibility(View.GONE);
                btn_retry.setVisibility(View.GONE);
                loadUser(userId);
            } else {
                handler.post(() -> {
                    progressBar1.setVisibility(View.VISIBLE);
                    loadUser(userId);
                    tv_lost.setVisibility(View.VISIBLE);
                    btn_retry.setVisibility(View.VISIBLE);
                });
            }
        });
    }

    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        return networkInfo != null && networkInfo.isConnected();
    }
}