package com.example.sqliteassignment;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.ViewHolder> {
    private List<Notes> note;
    public Context context;

    public NotesAdapter(List<Notes> note, Context context) {
        this.note = note;
        this.context = context;
    }

    @NonNull
    @Override
    public NotesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.search, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NotesAdapter.ViewHolder holder, int position) {
        Notes notes = note.get(position);
        holder.tv_judul.setText(notes.getJudul());
        holder.tv_deskripsi.setText(notes.getDeskripsi());

        String timestampText;
        if (notes.getCreatedAt().equals(notes.getUpdatedAt())) {
            timestampText = "Created at " + notes.getCreatedAt();
        } else {
            timestampText = "Updated at " + notes.getUpdatedAt();
        }
        holder.tv_timestamp.setText(timestampText);

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, UbahActivity.class);
            intent.putExtra("record_id", notes.getId());
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return note.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv_timestamp, tv_judul, tv_deskripsi;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_timestamp = itemView.findViewById(R.id.tv_timestamp);
            tv_judul = itemView.findViewById(R.id.tv_judul);
            tv_deskripsi = itemView.findViewById(R.id.tv_deskripsi);
        }
    }
}
