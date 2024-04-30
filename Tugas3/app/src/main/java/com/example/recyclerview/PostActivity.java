package com.example.recyclerview;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.PersistableBundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.core.view.WindowCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.recyclerview.databinding.ActivityPostBinding;

public class PostActivity extends AppCompatActivity {

    ImageView iv_profile, iv_post;
    TextView tv_username, tv_caption;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);

        iv_profile = findViewById(R.id.iv_profile);
        iv_post = findViewById(R.id.iv_post);
        tv_username = findViewById(R.id.tv_username);
        tv_caption = findViewById(R.id.tv_caption);

        Intent intent = getIntent();
        int profile = intent.getIntExtra("PROFILE", 0);
        String username = intent.getStringExtra("USERNAME");
        int post = intent.getIntExtra("POST", 0);
        String caption = intent.getStringExtra("CAPTION");

        iv_profile.setImageResource(profile);
        tv_username.setText(username);
        iv_post.setImageResource(post);
        tv_caption.setText(caption);

        iv_profile.setOnClickListener(v -> {
            if (profile == R.drawable.disaster){
                Intent storyIntent = new Intent(PostActivity.this, StoryActivity.class);
                storyIntent.putExtra("PROFILE", R.drawable.disaster);
                storyIntent.putExtra("USERNAME", "ril_disaster");
                storyIntent.putExtra("STORY", R.drawable.disaster);
                startActivity(storyIntent);
            } if (profile == R.drawable.eid){
                Intent storyIntent = new Intent(PostActivity.this, StoryActivity.class);
                storyIntent.putExtra("PROFILE", R.drawable.eid);
                storyIntent.putExtra("USERNAME", "happy_eid");
                storyIntent.putExtra("STORY", R.drawable.eid);
                startActivity(storyIntent);
            } if (profile == R.drawable.forest){
                Intent storyIntent = new Intent(PostActivity.this, StoryActivity.class);
                storyIntent.putExtra("PROFILE", R.drawable.forest);
                storyIntent.putExtra("USERNAME", "hijaudaun");
                storyIntent.putExtra("STORY", R.drawable.forest);
                startActivity(storyIntent);
            } if (profile == R.drawable.newyear){
                Intent storyIntent = new Intent(PostActivity.this, StoryActivity.class);
                storyIntent.putExtra("PROFILE", R.drawable.newyear);
                storyIntent.putExtra("USERNAME", "newme");
                storyIntent.putExtra("STORY", R.drawable.newyear);
                startActivity(storyIntent);
            } if (profile == R.drawable.starfish){
                Intent storyIntent = new Intent(PostActivity.this, StoryActivity.class);
                storyIntent.putExtra("PROFILE", R.drawable.starfish);
                storyIntent.putExtra("USERNAME", "not_patrick");
                storyIntent.putExtra("STORY", R.drawable.starfish);
                startActivity(storyIntent);
            } if (profile == R.drawable.station){
                Intent storyIntent = new Intent(PostActivity.this, StoryActivity.class);
                storyIntent.putExtra("PROFILE", R.drawable.station);
                storyIntent.putExtra("USERNAME", "thomasnf");
                storyIntent.putExtra("STORY", R.drawable.station);
                startActivity(storyIntent);
            } if (profile == R.drawable.sunset){
                Intent storyIntent = new Intent(PostActivity.this, StoryActivity.class);
                storyIntent.putExtra("PROFILE", R.drawable.sunset);
                storyIntent.putExtra("USERNAME", "teletubbies.sun");
                storyIntent.putExtra("STORY", R.drawable.sunset);
                startActivity(storyIntent);
            } if (profile == R.drawable.tol){
                Intent storyIntent = new Intent(PostActivity.this, StoryActivity.class);
                storyIntent.putExtra("PROFILE", R.drawable.tol);
                storyIntent.putExtra("USERNAME", "tolcgk");
                storyIntent.putExtra("STORY", R.drawable.tol);
                startActivity(storyIntent);
            } if (profile == R.drawable.trees){
                Intent storyIntent = new Intent(PostActivity.this, StoryActivity.class);
                storyIntent.putExtra("PROFILE", R.drawable.trees);
                storyIntent.putExtra("USERNAME", "pohong");
                storyIntent.putExtra("STORY", R.drawable.trees);
                startActivity(storyIntent);
            } if (profile == R.drawable.windmill){
                Intent storyIntent = new Intent(PostActivity.this, StoryActivity.class);
                storyIntent.putExtra("PROFILE", R.drawable.windmill);
                storyIntent.putExtra("USERNAME", "holland");
                storyIntent.putExtra("STORY", R.drawable.windmill);
                startActivity(storyIntent);
            }
        });
    }
}