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

import com.example.recyclerview.R;
import com.example.recyclerview.StoryActivity;
import com.example.recyclerview.parcelable.Story;

import java.util.ArrayList;

public class StoryAdapter extends RecyclerView.Adapter<StoryAdapter.ViewHolder> {

    private final ArrayList<Story> stories;
    private Context context;

    public StoryAdapter(ArrayList<Story> stories, Context context) {
        this.stories = stories;
        this.context = context;
    }

    @NonNull
    @Override
    public StoryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_story, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StoryAdapter.ViewHolder holder, int position) {
        Story story = stories.get(position);
        holder.setData(story);

        holder.imageView.setOnClickListener(v -> {
            if (stories.get(position).getStory().equals(R.drawable.disaster)) {
                Intent storyIntent = new Intent(context, StoryActivity.class);
                storyIntent.putExtra("PROFILE", R.drawable.disaster);
                storyIntent.putExtra("USERNAME", "ril_disaster");
                storyIntent.putExtra("STORY", R.drawable.disaster);
                context.startActivity(storyIntent);
            } if (stories.get(position).getStory().equals(R.drawable.eid)) {
                Intent storyIntent = new Intent(context, StoryActivity.class);
                storyIntent.putExtra("PROFILE", R.drawable.eid);
                storyIntent.putExtra("USERNAME", "happy_eid");
                storyIntent.putExtra("STORY", R.drawable.eid);
                context.startActivity(storyIntent);
            } if (stories.get(position).getStory().equals(R.drawable.forest)) {
                Intent storyIntent = new Intent(context, StoryActivity.class);
                storyIntent.putExtra("PROFILE", R.drawable.forest);
                storyIntent.putExtra("USERNAME", "hijaudaun");
                storyIntent.putExtra("STORY", R.drawable.forest);
                context.startActivity(storyIntent);
            } if (stories.get(position).getStory().equals(R.drawable.newyear)) {
                Intent storyIntent = new Intent(context, StoryActivity.class);
                storyIntent.putExtra("PROFILE", R.drawable.newyear);
                storyIntent.putExtra("USERNAME", "newme");
                storyIntent.putExtra("STORY", R.drawable.newyear);
                context.startActivity(storyIntent);
            } if (stories.get(position).getStory().equals(R.drawable.starfish)) {
                Intent storyIntent = new Intent(context, StoryActivity.class);
                storyIntent.putExtra("PROFILE", R.drawable.starfish);
                storyIntent.putExtra("USERNAME", "not_patrick");
                storyIntent.putExtra("STORY", R.drawable.starfish);
                context.startActivity(storyIntent);
            } if (stories.get(position).getStory().equals(R.drawable.station)) {
                Intent storyIntent = new Intent(context, StoryActivity.class);
                storyIntent.putExtra("PROFILE", R.drawable.station);
                storyIntent.putExtra("USERNAME", "thomasnf");
                storyIntent.putExtra("STORY", R.drawable.station);
                context.startActivity(storyIntent);
            } if (stories.get(position).getStory().equals(R.drawable.sunset)) {
                Intent storyIntent = new Intent(context, StoryActivity.class);
                storyIntent.putExtra("PROFILE", R.drawable.sunset);
                storyIntent.putExtra("USERNAME", "teletubbies.sun");
                storyIntent.putExtra("STORY", R.drawable.sunset);
                context.startActivity(storyIntent);
            } if (stories.get(position).getStory().equals(R.drawable.tol)) {
                Intent storyIntent = new Intent(context, StoryActivity.class);
                storyIntent.putExtra("PROFILE", R.drawable.tol);
                storyIntent.putExtra("USERNAME", "tolcgk");
                storyIntent.putExtra("STORY", R.drawable.tol);
                context.startActivity(storyIntent);
            } if (stories.get(position).getStory().equals(R.drawable.trees)) {
                Intent storyIntent = new Intent(context, StoryActivity.class);
                storyIntent.putExtra("PROFILE", R.drawable.trees);
                storyIntent.putExtra("USERNAME", "pohong");
                storyIntent.putExtra("STORY", R.drawable.trees);
                context.startActivity(storyIntent);
            } if (stories.get(position).getStory().equals(R.drawable.windmill)) {
                Intent storyIntent = new Intent(context, StoryActivity.class);
                storyIntent.putExtra("PROFILE", R.drawable.windmill);
                storyIntent.putExtra("USERNAME", "holland");
                storyIntent.putExtra("STORY", R.drawable.windmill);
                context.startActivity(storyIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return stories.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final ImageView imageView;
        private final TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.iv_story);
            textView = itemView.findViewById(R.id.tv_nama);
        }

        public void setData(Story story) {
            imageView.setImageResource(story.getStory());
            textView.setText(story.getUsername());
        }
    }
}