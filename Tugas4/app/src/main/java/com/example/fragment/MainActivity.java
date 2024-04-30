package com.example.fragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ImageView;
import com.example.fragment.fragment.HomeFragment;
import com.example.fragment.fragment.PostFragment;
import com.example.fragment.fragment.ProfileFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView iv_home = findViewById(R.id.iv_home);
        ImageView iv_posting = findViewById(R.id.iv_posting);
        ImageView iv_account = findViewById(R.id.iv_account);

        FragmentManager fragmentManager = getSupportFragmentManager();

        HomeFragment homeFragment = new HomeFragment();

        Fragment fragment = fragmentManager.findFragmentByTag(HomeFragment.class.getSimpleName());

        if (!(fragment instanceof HomeFragment)){
            fragmentManager
                    .beginTransaction()
                    .add(R.id.frame_container, homeFragment)
                    .commit();
        }

        iv_home.setOnClickListener(v -> {
            HomeFragment homeFragment1 = new HomeFragment();
            fragmentManager
                    .beginTransaction()
                    .replace(R.id.frame_container, homeFragment1)
                    .addToBackStack(null)
                    .commit();
        });

        iv_posting.setOnClickListener(v -> {
            PostFragment postFragment = new PostFragment();
            fragmentManager
                    .beginTransaction()
                    .replace(R.id.frame_container, postFragment)
                    .addToBackStack(null)
                    .commit();
        });

        iv_account.setOnClickListener(v -> {
            ProfileFragment profileFragment = new ProfileFragment();
            fragmentManager
                    .beginTransaction()
                    .replace(R.id.frame_container, profileFragment)
                    .addToBackStack(null)
                    .commit();
        });
    }
}