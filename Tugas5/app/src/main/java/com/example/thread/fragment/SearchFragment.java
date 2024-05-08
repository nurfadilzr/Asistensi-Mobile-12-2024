package com.example.thread.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.SearchView;

import com.example.thread.DataSource;
import com.example.thread.Post;
import com.example.thread.R;
import com.example.thread.adapter.SearchAdapter;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SearchFragment extends Fragment {

    private ArrayList<Post> postArrayList;
    private SearchAdapter searchAdapter;
    private RecyclerView rv_search;
    private SearchView searchView;
    private ProgressBar progressBar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        postArrayList = new ArrayList<>();
        searchAdapter = new SearchAdapter(postArrayList);

        rv_search = view.findViewById(R.id.rv_search);
        searchView = view.findViewById(R.id.searchView);
        progressBar = view.findViewById(R.id.progressBar);

        rv_search.setLayoutManager(new LinearLayoutManager(getActivity()));
        rv_search.setAdapter(searchAdapter);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                progressBar.setVisibility(View.VISIBLE);
                rv_search.setVisibility(View.GONE);

                ExecutorService executor = Executors.newSingleThreadExecutor();
                Handler handler = new Handler(Looper.getMainLooper());

                executor.execute(() -> {
                    ArrayList<Post> filteredList = new ArrayList<>();
                    if (!newText.isEmpty()) {
                        for (Post item : DataSource.post) {
                            if (item.getUsername().toLowerCase().contains(newText.toLowerCase()) ||
                                    item.getName().toLowerCase().contains(newText.toLowerCase())) {
                                filteredList.add(item);
                            }
                        }
                    }
                    try {
                        Thread.sleep(1500);
                        handler.post(() -> {
                            progressBar.setVisibility(View.GONE);
                            rv_search.setVisibility(View.VISIBLE);
                            postArrayList.clear();

                            if (!newText.isEmpty()) {
                                postArrayList.addAll(filteredList);
                            }
                            searchAdapter.notifyDataSetChanged();
                        });
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
                return true;
            }
        });
    }
}