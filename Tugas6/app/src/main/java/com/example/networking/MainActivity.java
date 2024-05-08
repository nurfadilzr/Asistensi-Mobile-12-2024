package com.example.networking;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private ProgressBar progressBar1;
    private RecyclerView recyclerView;
    private TextView tv_lost;
    private Button btn_load, btn_retry;

    private ApiService apiService;
    private UserAdapter userAdapter;
    private List<User> users;
    private Handler handler;
    private int currentPage = 1;
    private Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar1 = findViewById(R.id.progressBar1);
        recyclerView = findViewById(R.id.recyclerView);
        tv_lost = findViewById(R.id.tv_lost);
        btn_load = findViewById(R.id.btn_load);
        btn_retry = findViewById(R.id.btn_retry);

        apiService = RetrofitClient.getClient().create(ApiService.class);
        userAdapter = new UserAdapter(users, context);
        users = new ArrayList<>();
        handler = new Handler(Looper.myLooper());

        loadInitialData();

        btn_load.setOnClickListener(v -> {
            btn_load.setVisibility(View.GONE);
            progressBar1.setVisibility(View.VISIBLE);
            loadMoreData();
        });
    }

    private void loadInitialData() {
        if (isNetworkAvailable()) {
            currentPage = 1; // Reset currentPage when loading initial data
            loadData();
        } else {
            showErrorView();
        }
    }

    private void loadData(){
        progressBar1.setVisibility(View.VISIBLE);
        btn_load.setVisibility(View.GONE);
        Call<UserResponse> call = apiService.getUsers(1,6);
        call.enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(@NonNull Call<UserResponse> call, @NonNull Response<UserResponse> response) {
                if (response.isSuccessful()) {
                    users = response.body().getData();
                    handler.post(() -> {
                        userAdapter = new UserAdapter(users, context);
                        progressBar1.setVisibility(View.GONE);
                        btn_load.setVisibility(View.VISIBLE);
                        recyclerView.setAdapter(userAdapter);
                        recyclerView.setVisibility(View.VISIBLE);
                        if (users.size() >= 6) {
                            btn_load.setVisibility(View.VISIBLE);
                        }
                    });
                } else {
                    handler.post(() -> {
                        progressBar1.setVisibility(View.GONE);
                        showErrorView();
                    });
                }
            }

            @Override
            public void onFailure(@NonNull Call<UserResponse> call, @NonNull Throwable t) {
                showErrorView();
            }
        });
    }

    private void loadMoreData() {
        currentPage++;
        Call<UserResponse> call = apiService.getUsers(currentPage, 6);
        call.enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(@NonNull Call<UserResponse> call, @NonNull Response<UserResponse> response) {
                if (response.isSuccessful()) {
                    List<User> newUsers = response.body().getData();
                    System.out.println(newUsers.get(0).getFirst_name());
                    if (!newUsers.isEmpty()) {
                        users.addAll(newUsers);
                        userAdapter.notifyDataSetChanged();
                        if (newUsers.size() < 6) {
                            btn_load.setVisibility(View.GONE);
                        }
                    } else {
                        btn_load.setVisibility(View.GONE);
                    }
                } else {
                    showErrorView();
                }
                progressBar1.setVisibility(View.GONE);
            }

            @Override
            public void onFailure(@NonNull Call<UserResponse> call, @NonNull Throwable t) {
                showErrorView();
            }
        });
    }

    private void showErrorView() {
        recyclerView.setVisibility(View.GONE);
        btn_load.setVisibility(View.GONE);
        tv_lost.setVisibility(View.VISIBLE);
        btn_retry.setVisibility(View.VISIBLE);
        progressBar1.setVisibility(View.GONE);

        btn_retry.setOnClickListener(v -> {
            if (isNetworkAvailable()) {
                progressBar1.setVisibility(View.VISIBLE);
                tv_lost.setVisibility(View.GONE);
                btn_retry.setVisibility(View.GONE);
                currentPage = 1; // Reset currentPage when retrying
                loadData();
            } else {
                progressBar1.setVisibility(View.VISIBLE);
                loadData();
                tv_lost.setVisibility(View.VISIBLE);
                btn_retry.setVisibility(View.VISIBLE);

            }
        });
    }

    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        return networkInfo != null && networkInfo.isConnected();
    }
}