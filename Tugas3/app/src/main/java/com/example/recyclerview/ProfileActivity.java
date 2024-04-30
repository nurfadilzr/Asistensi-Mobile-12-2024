package com.example.recyclerview;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.core.view.WindowCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.recyclerview.databinding.ActivityProfileBinding;

import org.w3c.dom.Text;

public class ProfileActivity extends AppCompatActivity {

    ImageView iv_profile, iv_postingan;
    TextView tv_username, tv_followers, tv_following;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        iv_profile = findViewById(R.id.iv_profile);
        tv_username = findViewById(R.id.tv_username);
        tv_followers = findViewById(R.id.foles);
        tv_following = findViewById(R.id.folis);
        iv_postingan = findViewById(R.id.iv_postingan);

        Intent intent = getIntent();
        int profile = intent.getIntExtra("PROFILE", 0);
        String username = intent.getStringExtra("USERNAME");
        String followers = intent.getStringExtra("FOLLOWERS");
        String following = intent.getStringExtra("FOLLOWING");
        int post = intent.getIntExtra("POST", 0);

        iv_profile.setImageResource(profile);
        tv_username.setText(username);
        tv_followers.setText(followers);
        tv_following.setText(following);
        iv_postingan.setImageResource(post);

        iv_profile.setOnClickListener(v -> {
            if (profile == R.drawable.disaster){
                Intent storyIntent = new Intent(ProfileActivity.this, StoryActivity.class);
                storyIntent.putExtra("PROFILE", R.drawable.disaster);
                storyIntent.putExtra("USERNAME", "ril_disaster");
                storyIntent.putExtra("STORY", R.drawable.disaster);
                startActivity(storyIntent);
            } if (profile == R.drawable.eid){
                Intent storyIntent = new Intent(ProfileActivity.this, StoryActivity.class);
                storyIntent.putExtra("PROFILE", R.drawable.eid);
                storyIntent.putExtra("USERNAME", "happy_eid");
                storyIntent.putExtra("STORY", R.drawable.eid);
                startActivity(storyIntent);
            } if (profile == R.drawable.forest){
                Intent storyIntent = new Intent(ProfileActivity.this, StoryActivity.class);
                storyIntent.putExtra("PROFILE", R.drawable.forest);
                storyIntent.putExtra("USERNAME", "hijaudaun");
                storyIntent.putExtra("STORY", R.drawable.forest);
                startActivity(storyIntent);
            } if (profile == R.drawable.newyear){
                Intent storyIntent = new Intent(ProfileActivity.this, StoryActivity.class);
                storyIntent.putExtra("PROFILE", R.drawable.newyear);
                storyIntent.putExtra("USERNAME", "newme");
                storyIntent.putExtra("STORY", R.drawable.newyear);
                startActivity(storyIntent);
            } if (profile == R.drawable.starfish){
                Intent storyIntent = new Intent(ProfileActivity.this, StoryActivity.class);
                storyIntent.putExtra("PROFILE", R.drawable.starfish);
                storyIntent.putExtra("USERNAME", "not_patrick");
                storyIntent.putExtra("STORY", R.drawable.starfish);
                startActivity(storyIntent);
            } if (profile == R.drawable.station){
                Intent storyIntent = new Intent(ProfileActivity.this, StoryActivity.class);
                storyIntent.putExtra("PROFILE", R.drawable.station);
                storyIntent.putExtra("USERNAME", "thomasnf");
                storyIntent.putExtra("STORY", R.drawable.station);
                startActivity(storyIntent);
            } if (profile == R.drawable.sunset){
                Intent storyIntent = new Intent(ProfileActivity.this, StoryActivity.class);
                storyIntent.putExtra("PROFILE", R.drawable.sunset);
                storyIntent.putExtra("USERNAME", "teletubbies.sun");
                storyIntent.putExtra("STORY", R.drawable.sunset);
                startActivity(storyIntent);
            } if (profile == R.drawable.tol){
                Intent storyIntent = new Intent(ProfileActivity.this, StoryActivity.class);
                storyIntent.putExtra("PROFILE", R.drawable.tol);
                storyIntent.putExtra("USERNAME", "tolcgk");
                storyIntent.putExtra("STORY", R.drawable.tol);
                startActivity(storyIntent);
            } if (profile == R.drawable.trees){
                Intent storyIntent = new Intent(ProfileActivity.this, StoryActivity.class);
                storyIntent.putExtra("PROFILE", R.drawable.trees);
                storyIntent.putExtra("USERNAME", "pohong");
                storyIntent.putExtra("STORY", R.drawable.trees);
                startActivity(storyIntent);
            } if (profile == R.drawable.windmill){
                Intent storyIntent = new Intent(ProfileActivity.this, StoryActivity.class);
                storyIntent.putExtra("PROFILE", R.drawable.windmill);
                storyIntent.putExtra("USERNAME", "holland");
                storyIntent.putExtra("STORY", R.drawable.windmill);
                startActivity(storyIntent);
            }
        });

        iv_postingan.setOnClickListener(v -> {
            if (post == R.drawable.disaster){
                Intent postIntent = new Intent(ProfileActivity.this, PostActivity.class);
                postIntent.putExtra("PROFILE", R.drawable.disaster);
                postIntent.putExtra("USERNAME", "ril_disaster");
                postIntent.putExtra("POST", R.drawable.disaster);
                postIntent.putExtra("CAPTION", "the beginning...");
                startActivity(postIntent);
            } if (post == R.drawable.eid){
                Intent postIntent = new Intent(ProfileActivity.this, PostActivity.class);
                postIntent.putExtra("PROFILE", R.drawable.eid);
                postIntent.putExtra("USERNAME", "happy_eid");
                postIntent.putExtra("POST", R.drawable.eid);
                postIntent.putExtra("CAPTION", "yaahhhuuu");
                startActivity(postIntent);
            } if (post == R.drawable.forest){
                Intent postIntent = new Intent(ProfileActivity.this, PostActivity.class);
                postIntent.putExtra("PROFILE", R.drawable.forest);
                postIntent.putExtra("USERNAME", "hijaudaun");
                postIntent.putExtra("POST", R.drawable.forest);
                postIntent.putExtra("CAPTION", "sehijau kamu xixi");
                startActivity(postIntent);
            } if (post == R.drawable.newyear){
                Intent postIntent = new Intent(ProfileActivity.this, PostActivity.class);
                postIntent.putExtra("PROFILE", R.drawable.newyear);
                postIntent.putExtra("USERNAME", "newme");
                postIntent.putExtra("POST", R.drawable.newyear);
                postIntent.putExtra("CAPTION", "duarrrr");
                startActivity(postIntent);
            } if (post == R.drawable.starfish){
                Intent postIntent = new Intent(ProfileActivity.this, PostActivity.class);
                postIntent.putExtra("PROFILE", R.drawable.starfish);
                postIntent.putExtra("USERNAME", "not_patrick");
                postIntent.putExtra("POST", R.drawable.starfish);
                postIntent.putExtra("CAPTION", "banyak bet kakinya");
                startActivity(postIntent);
            } if (post == R.drawable.station){
                Intent postIntent = new Intent(ProfileActivity.this, PostActivity.class);
                postIntent.putExtra("PROFILE", R.drawable.station);
                postIntent.putExtra("USERNAME", "thomasnf");
                postIntent.putExtra("POST", R.drawable.station);
                postIntent.putExtra("CAPTION", "miring fotonya");
                startActivity(postIntent);
            } if (post == R.drawable.sunset){
                Intent postIntent = new Intent(ProfileActivity.this, PostActivity.class);
                postIntent.putExtra("PROFILE", R.drawable.sunset);
                postIntent.putExtra("USERNAME", "teletubbies.sun");
                postIntent.putExtra("POST", R.drawable.sunset);
                postIntent.putExtra("CAPTION", "cakep kan");
                startActivity(postIntent);
            } if (post == R.drawable.tol){
                Intent postIntent = new Intent(ProfileActivity.this, PostActivity.class);
                postIntent.putExtra("PROFILE", R.drawable.tol);
                postIntent.putExtra("USERNAME", "tolcgk");
                postIntent.putExtra("POST", R.drawable.tol);
                postIntent.putExtra("CAPTION", "bubye");
                startActivity(postIntent);
            } if (post == R.drawable.trees){
                Intent postIntent = new Intent(ProfileActivity.this, PostActivity.class);
                postIntent.putExtra("PROFILE", R.drawable.trees);
                postIntent.putExtra("USERNAME", "pohong");
                postIntent.putExtra("POST", R.drawable.trees);
                postIntent.putExtra("CAPTION", "banyak garem disitu");
                startActivity(postIntent);
            } if (post == R.drawable.windmill){
                Intent postIntent = new Intent(ProfileActivity.this, PostActivity.class);
                postIntent.putExtra("PROFILE", R.drawable.windmill);
                postIntent.putExtra("USERNAME", "holland");
                postIntent.putExtra("POST", R.drawable.windmill);
                postIntent.putExtra("CAPTION", "barusan liat beginian");
                startActivity(postIntent);
            }
        });
    }
}