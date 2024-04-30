package com.example.fragment.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fragment.DataSource;
import com.example.fragment.Post;
import com.example.fragment.PostAdapter;
import com.example.fragment.R;

public class HomeFragment extends Fragment {

    public static final String EXTRA_POST = "extra_post";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @SuppressLint("NotifyDataSetChanged")
    @Override   // kaya method onCreate() di activity
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView rvPost = view.findViewById(R.id.rv_post);
        rvPost.setHasFixedSize(true);

        PostAdapter postAdapter = new PostAdapter(DataSource.post);
        rvPost.setAdapter(postAdapter);

        Bundle bundle = getArguments();
        if (bundle != null) {
            Post post = bundle.getParcelable(EXTRA_POST);
            if (post != null) {
                DataSource.post.add(0, post);
                postAdapter.notifyDataSetChanged();
            }
        }
    }
}