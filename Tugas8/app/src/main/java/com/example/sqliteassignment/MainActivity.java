package com.example.sqliteassignment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.widget.SearchView;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private TextView tv_no_data;
    private SearchView searchView;
    private RecyclerView rv_search;
    private FloatingActionButton fab_add;
    private DBConfig dbConfig;
    private List<Notes> note;
    private NotesAdapter notesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_no_data = findViewById(R.id.tv_no_data);
        searchView = findViewById(R.id.searchView);
        rv_search = findViewById(R.id.rv_search);
        fab_add = findViewById(R.id.fab_add);

        dbConfig = new DBConfig(this);
        note = new ArrayList<>();
        notesAdapter = new NotesAdapter(note, this);
        rv_search.setAdapter(notesAdapter);
        rv_search.setLayoutManager(new GridLayoutManager(this, 1));

        loadData("");

        fab_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TambahActivity.class);
                startActivity(intent);
            }
        });

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                loadData(query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                loadData(newText);
                return true;
            }
        });

        // Pastikan action bar diatur setelah setContentView
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Notes");
            getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        }
    }

    private void loadData(String query) {
        note.clear();
        Cursor cursor;
        if (query.isEmpty()) {
            cursor = dbConfig.getAllRecords();
        } else {
            cursor = dbConfig.searchByTitle(query);
        }

        if (cursor != null && cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(cursor.getColumnIndexOrThrow(dbConfig.getColumnId()));
                String judul = cursor.getString(cursor.getColumnIndexOrThrow(dbConfig.getColumnJudul()));
                String deskripsi = cursor.getString(cursor.getColumnIndexOrThrow(dbConfig.getColumnDeskripsi()));
                String createdAt = cursor.getString(cursor.getColumnIndexOrThrow(dbConfig.getColumnCreatedAt()));
                String updatedAt = cursor.getString(cursor.getColumnIndexOrThrow(dbConfig.getColumnUpdatedAt()));
                note.add(new Notes(id, judul, deskripsi, createdAt, updatedAt));
            } while (cursor.moveToNext());
            cursor.close();
        }

        if (note.isEmpty()) {
            tv_no_data.setVisibility(View.VISIBLE);
            rv_search.setVisibility(View.GONE);
        } else {
            tv_no_data.setVisibility(View.GONE);
            rv_search.setVisibility(View.VISIBLE);
        }

        notesAdapter.notifyDataSetChanged();
    }

    @Override
    protected void onResume() {
        super.onResume();
        loadData("");
    }
}