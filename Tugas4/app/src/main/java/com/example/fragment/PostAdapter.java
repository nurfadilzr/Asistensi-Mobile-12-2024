package com.example.fragment;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.WindowDecorActionBar;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.ViewHolder> {

    private ArrayList<Post> posts;

    public PostAdapter(ArrayList<Post> posts){
        this.posts = posts;
    }

    @NonNull
    @Override
    public PostAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.postingan, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostAdapter.ViewHolder holder, int position) {
        Post post = posts.get(position);

        holder.tv_username.setText(post.getUsername());
        holder.tv_name.setText(post.getName());
        holder.iv_profile.setImageResource(post.getProfilePhoto());
        Integer img = post.getPostPhoto();
        Uri img2 = post.getSelectedImageUri();
        if(img != null){
            holder.iv_post_photo.setImageResource(post.getPostPhoto());
        } else if(img2 != null){
            holder.iv_post_photo.setImageURI(post.getSelectedImageUri());
        }


        holder.tv_caption.setText(post.getCaption());

        holder.iv_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(holder.context, ProfileActivity.class);
                intent.putExtra(ProfileActivity.E, post);
                holder.context.startActivity(intent);
            }
        });

        holder.tv_username.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(holder.context, ProfileActivity.class);
                intent.putExtra("post", post);
                holder.context.startActivity(intent);
            }
        });

        holder.tv_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(holder.context, ProfileActivity.class);
                intent.putExtra("post", post);
                holder.context.startActivity(intent);
            }
        });

        holder.iv_delete.setOnClickListener(v -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(holder.context);
            builder.setTitle("Confirmation");
            builder.setMessage("Are you sure you want to delete this post?");
            builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    int adapterPosition = holder.getAdapterPosition();
                    if (adapterPosition != RecyclerView.NO_POSITION) {
                        posts.remove(adapterPosition);
                        notifyItemRemoved(adapterPosition);
                    }
                }
            });

            builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });
            builder.create().show();
        });
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView iv_profile, iv_post_photo, iv_selected_image, iv_delete;
        TextView tv_username, tv_name, tv_caption;
        Context context;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            iv_profile = itemView.findViewById(R.id.iv_profile);
            iv_post_photo = itemView.findViewById(R.id.iv_post);
            iv_selected_image = itemView.findViewById(R.id.iv_post);
            iv_delete = itemView.findViewById(R.id.iv_delete);
            tv_username = itemView.findViewById(R.id.tv_username);
            tv_name = itemView.findViewById(R.id.tv_name);
            tv_caption = itemView.findViewById(R.id.tv_caption);
            context = itemView.getContext();
        }
    }
}
