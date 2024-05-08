package com.example.thread.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.thread.DataSource;
import com.example.thread.Post;
import com.example.thread.R;
import com.example.thread.adapter.PostAdapter;

public class HomeFragment extends Fragment {

    public static final String EXTRA_POST = "extra_post";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView rv_post = view.findViewById(R.id.rv_post);
        rv_post.setHasFixedSize(true);

        PostAdapter postAdapter = new PostAdapter(DataSource.post);
        rv_post.setAdapter(postAdapter);

        Bundle bundle = getArguments();
        if (bundle != null) {
            Post posts = bundle.getParcelable(EXTRA_POST);
            if (posts != null) {
                DataSource.post.add(0, posts);
                postAdapter.notifyDataSetChanged();
            }
        }
    }
}