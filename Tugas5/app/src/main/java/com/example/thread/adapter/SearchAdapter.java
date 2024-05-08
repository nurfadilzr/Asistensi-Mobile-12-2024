package com.example.thread.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.thread.Post;
import com.example.thread.ProfileActivity;
import com.example.thread.R;

import java.util.ArrayList;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.ViewHolder> {

    private ArrayList<Post> posts;
    public SearchAdapter(ArrayList<Post> posts){
        this.posts = posts;
    }

    @NonNull
    @Override
    public SearchAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.search, parent, false);
        return new SearchAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SearchAdapter.ViewHolder holder, int position) {
        Post post = posts.get(position);

        holder.iv_searched_profile.setImageResource(post.getProfilePhoto());
        holder.tv_username.setText(post.getUsername());
        holder.tv_name.setText(post.getName());

        holder.search_layout.setOnClickListener(v -> {
            Intent intent = new Intent(holder.context, ProfileActivity.class);
            intent.putExtra(ProfileActivity.EXTRA_PROFILE, post);
            holder.context.startActivity(intent);
        });

    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView iv_searched_profile;
        TextView tv_username, tv_name;
        Context context;
        LinearLayout search_layout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            iv_searched_profile = itemView.findViewById(R.id.iv_searched_profile);
            tv_username = itemView.findViewById(R.id.tv_username);
            tv_name = itemView.findViewById(R.id.tv_name);
            context = itemView.getContext();
            search_layout = itemView.findViewById(R.id.search_layout);
        }
    }
}
