package com.example.recyclerview.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerview.PostActivity;
import com.example.recyclerview.ProfileActivity;
import com.example.recyclerview.R;
import com.example.recyclerview.StoryActivity;
import com.example.recyclerview.parcelable.Postingan;

import java.util.ArrayList;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.ViewHolder> {

    private final ArrayList<Postingan> postingans;  // simpan daftar postingan yg akan ditampilkan adapter

    private Context context;    // menyimpan konteks dari aktivitas yang pake adapter. Konteks digunakan untuk memulai aktivitas baru

    public PostAdapter(ArrayList<Postingan> postingans, Context context) {
        this.postingans = postingans;
        this.context = context;
    }

    // 1 utk buat viewholder baru utk tampilin item
    // inflate item_post jdi view dan diberikan ke viewholder yg dibuat, lalu return view
    @NonNull
    @Override
    public PostAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_post, parent, false);
        return new ViewHolder(view);
    }

    // 2 menampilkan data pada posisi tertentu dalam ViewHolder yang sudah ada
    // ambil data di posisi tertentu dri daftar dan di-set ke viewholder
    @Override
    public void onBindViewHolder(@NonNull PostAdapter.ViewHolder holder, int position) {
        Postingan postingan = postingans.get(position);
        holder.setData(postingan);

        // pencet username ntr kebuka ke profile
        holder.username.setOnClickListener(v -> {
            if (postingans.get(position).getUsername().equals("ril_disaster")) {
                Intent intent = new Intent(context, ProfileActivity.class);
                intent.putExtra("PROFILE", R.drawable.disaster);
                intent.putExtra("USERNAME", "ril_disaster");
                intent.putExtra("FOLLOWERS","1,5 JT");
                intent.putExtra("FOLLOWING","5");
                intent.putExtra("POST", R.drawable.disaster);
                context.startActivity(intent);
            } if (postingans.get(position).getUsername().equals("happy_eid")){
                Intent intent = new Intent(context, PostActivity.class);
                intent.putExtra("PROFILE", R.drawable.eid);
                intent.putExtra("USERNAME", "happy_eid");
                intent.putExtra("FOLLOWERS","1,5 JT");
                intent.putExtra("FOLLOWING","5");
                intent.putExtra("POST", R.drawable.eid);
                context.startActivity(intent);
            } if (postingans.get(position).getUsername().equals("hijaudaun")){
                Intent intent = new Intent(context, PostActivity.class);
                intent.putExtra("PROFILE", R.drawable.forest);
                intent.putExtra("USERNAME", "hijaudaun");
                intent.putExtra("FOLLOWERS","1,5 JT");
                intent.putExtra("FOLLOWING","5");
                intent.putExtra("POST", R.drawable.forest);
                context.startActivity(intent);
            } if (postingans.get(position).getUsername().equals("newme")){
                Intent intent = new Intent(context, PostActivity.class);
                intent.putExtra("PROFILE", R.drawable.newyear);
                intent.putExtra("USERNAME", "newme");
                intent.putExtra("FOLLOWERS","1,5 JT");
                intent.putExtra("FOLLOWING","5");
                intent.putExtra("POST", R.drawable.newyear);
                context.startActivity(intent);
            } if (postingans.get(position).getUsername().equals("not_patrick")){
                Intent intent = new Intent(context, PostActivity.class);
                intent.putExtra("PROFILE", R.drawable.starfish);
                intent.putExtra("USERNAME", "not_patrick");
                intent.putExtra("FOLLOWERS","1,5 JT");
                intent.putExtra("FOLLOWING","5");
                intent.putExtra("POST", R.drawable.starfish);
                context.startActivity(intent);
            } if (postingans.get(position).getUsername().equals("thomasnf")){
                Intent intent = new Intent(context, PostActivity.class);
                intent.putExtra("PROFILE", R.drawable.station);
                intent.putExtra("USERNAME", "thomasnf");
                intent.putExtra("FOLLOWERS","1,5 JT");
                intent.putExtra("FOLLOWING","5");
                intent.putExtra("POST", R.drawable.station);
                context.startActivity(intent);
            } if (postingans.get(position).getUsername().equals("teletubbies.sun")){
                Intent intent = new Intent(context, PostActivity.class);
                intent.putExtra("PROFILE", R.drawable.sunset);
                intent.putExtra("USERNAME", "teletubbies.sun");
                intent.putExtra("FOLLOWERS","1,5 JT");
                intent.putExtra("FOLLOWING","5");
                intent.putExtra("POST", R.drawable.sunset);
                context.startActivity(intent);
            } if (postingans.get(position).getUsername().equals("tolcgk")){
                Intent intent = new Intent(context, PostActivity.class);
                intent.putExtra("PROFILE", R.drawable.tol);
                intent.putExtra("USERNAME", "tolcgk");
                intent.putExtra("FOLLOWERS","1,5 JT");
                intent.putExtra("FOLLOWING","5");
                intent.putExtra("POST", R.drawable.tol);
                context.startActivity(intent);
            } if (postingans.get(position).getUsername().equals("happy_eid")) {
                Intent intent = new Intent(context, PostActivity.class);
                intent.putExtra("PROFILE", R.drawable.trees);
                intent.putExtra("USERNAME", "pohong");
                intent.putExtra("FOLLOWERS","1,5 JT");
                intent.putExtra("FOLLOWING","5");
                intent.putExtra("POST", R.drawable.trees);
                context.startActivity(intent);
            } if (postingans.get(position).getUsername().equals("holland")){
                Intent intent = new Intent(context, PostActivity.class);
                intent.putExtra("PROFILE", R.drawable.windmill);
                intent.putExtra("USERNAME", "holland");
                intent.putExtra("FOLLOWERS","1,5 JT");
                intent.putExtra("FOLLOWING","5");
                intent.putExtra("POST", R.drawable.windmill);
                context.startActivity(intent);
            }
        });

        // pencet foto profile kebuka ke story
        holder.profile.setOnClickListener(v -> {
            if (postingans.get(position).getProfile().equals(R.drawable.disaster)) {
                Intent storyIntent = new Intent(context, StoryActivity.class);
                storyIntent.putExtra("PROFILE", R.drawable.disaster);
                storyIntent.putExtra("USERNAME", "ril_disaster");
                storyIntent.putExtra("STORY", R.drawable.disaster);
                context.startActivity(storyIntent);
            } if (postingans.get(position).getProfile().equals(R.drawable.eid)) {
                Intent storyIntent = new Intent(context, StoryActivity.class);
                storyIntent.putExtra("PROFILE", R.drawable.eid);
                storyIntent.putExtra("USERNAME", "happy_eid");
                storyIntent.putExtra("STORY", R.drawable.eid);
                context.startActivity(storyIntent);
            } if (postingans.get(position).getProfile().equals(R.drawable.forest)) {
                Intent storyIntent = new Intent(context, StoryActivity.class);
                storyIntent.putExtra("PROFILE", R.drawable.forest);
                storyIntent.putExtra("USERNAME", "hijaudaun");
                storyIntent.putExtra("STORY", R.drawable.forest);
                context.startActivity(storyIntent);
            } if (postingans.get(position).getProfile().equals(R.drawable.newyear)) {
                Intent storyIntent = new Intent(context, StoryActivity.class);
                storyIntent.putExtra("PROFILE", R.drawable.newyear);
                storyIntent.putExtra("USERNAME", "newme");
                storyIntent.putExtra("STORY", R.drawable.newyear);
                context.startActivity(storyIntent);
            } if (postingans.get(position).getProfile().equals(R.drawable.starfish)) {
                Intent storyIntent = new Intent(context, StoryActivity.class);
                storyIntent.putExtra("PROFILE", R.drawable.starfish);
                storyIntent.putExtra("USERNAME", "not_patrick");
                storyIntent.putExtra("STORY", R.drawable.starfish);
                context.startActivity(storyIntent);
            } if (postingans.get(position).getProfile().equals(R.drawable.station)) {
                Intent storyIntent = new Intent(context, StoryActivity.class);
                storyIntent.putExtra("PROFILE", R.drawable.station);
                storyIntent.putExtra("USERNAME", "thomasnf");
                storyIntent.putExtra("STORY", R.drawable.station);
                context.startActivity(storyIntent);
            } if (postingans.get(position).getProfile().equals(R.drawable.sunset)) {
                Intent storyIntent = new Intent(context, StoryActivity.class);
                storyIntent.putExtra("PROFILE", R.drawable.sunset);
                storyIntent.putExtra("USERNAME", "teletubbies.sun");
                storyIntent.putExtra("STORY", R.drawable.sunset);
                context.startActivity(storyIntent);
            } if (postingans.get(position).getProfile().equals(R.drawable.tol)) {
                Intent storyIntent = new Intent(context, StoryActivity.class);
                storyIntent.putExtra("PROFILE", R.drawable.tol);
                storyIntent.putExtra("USERNAME", "tolcgk");
                storyIntent.putExtra("STORY", R.drawable.tol);
                context.startActivity(storyIntent);
            } if (postingans.get(position).getProfile().equals(R.drawable.trees)) {
                Intent storyIntent = new Intent(context, StoryActivity.class);
                storyIntent.putExtra("PROFILE", R.drawable.trees);
                storyIntent.putExtra("USERNAME", "pohong");
                storyIntent.putExtra("STORY", R.drawable.trees);
                context.startActivity(storyIntent);
            } if (postingans.get(position).getProfile().equals(R.drawable.windmill)) {
                Intent storyIntent = new Intent(context, StoryActivity.class);
                storyIntent.putExtra("PROFILE", R.drawable.windmill);
                storyIntent.putExtra("USERNAME", "holland");
                storyIntent.putExtra("STORY", R.drawable.windmill);
                context.startActivity(storyIntent);
            }
        });
    }

    // 3  menetapkan ukuran dari jumlah data yang ingin ditampilkan
    @Override
    public int getItemCount() {
        return postingans.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final ImageView profile, post;
        private final TextView username, caption;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            profile = itemView.findViewById(R.id.iv_profile);
            username = itemView.findViewById(R.id.tv_username);
            post = itemView.findViewById(R.id.iv_post);
            caption = itemView.findViewById(R.id.tv_caption);
        }

        // ambil dari Postingan.java
        public void setData(Postingan postingan) {
            profile.setImageResource(postingan.getProfile());
            username.setText(postingan.getUsername());
            post.setImageResource(postingan.getPost());
            caption.setText(postingan.getCaption());
        }
    }
}

// implement 3 methods dri adapter
// create class ViewHolder extends RV, add constr super
// create const for class PostAdapter
// create method setData in class ViewHolder
