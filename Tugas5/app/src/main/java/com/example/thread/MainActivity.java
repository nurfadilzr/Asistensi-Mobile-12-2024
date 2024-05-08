package com.example.thread;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.widget.ImageView;

import com.example.thread.fragment.HomeFragment;
import com.example.thread.fragment.PostFragment;
import com.example.thread.fragment.ProfileFragment;
import com.example.thread.fragment.SearchFragment;

public class MainActivity extends AppCompatActivity {

    ImageView iv_home, iv_search, iv_add, iv_profile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iv_home = findViewById(R.id.iv_home);
        iv_search = findViewById(R.id.iv_search);
        iv_add = findViewById(R.id.iv_add);
        iv_profile = findViewById(R.id.iv_profile);

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

        iv_search.setOnClickListener(v -> {
            SearchFragment searchFragment = new SearchFragment();
            fragmentManager
                    .beginTransaction()
                    .replace(R.id.frame_container, searchFragment)
                    .addToBackStack(null)
                    .commit();
        });

        iv_add.setOnClickListener(v -> {
            PostFragment postFragment = new PostFragment();
            fragmentManager
                    .beginTransaction()
                    .replace(R.id.frame_container, postFragment)
                    .addToBackStack(null)
                    .commit();
        });

        iv_profile.setOnClickListener(v -> {
            ProfileFragment profileFragment = new ProfileFragment();
            fragmentManager
                    .beginTransaction()
                    .replace(R.id.frame_container, profileFragment)
                    .addToBackStack(null)
                    .commit();
        });
    }
}