package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.recyclerview.adapter.PostAdapter;
import com.example.recyclerview.adapter.StoryAdapter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView rv_story = findViewById(R.id.rv_story);
        RecyclerView rv_post = findViewById(R.id.rv_post);
        PostAdapter postAdapter = new PostAdapter(DataSource.posts, this);
        StoryAdapter storyAdapter = new StoryAdapter(DataSource.stories, this);


        rv_story.setHasFixedSize(true);
        rv_story.setAdapter(storyAdapter);
        rv_post.setHasFixedSize(true);
        rv_post.setAdapter(postAdapter);
    }
}