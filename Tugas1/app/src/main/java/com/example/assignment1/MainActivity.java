package com.example.assignment1;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    Button button;
    RelativeLayout relativeLayout;
    ListView listView;
    ArrayAdapter<String> adapter;
    ArrayList<String> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        button = findViewById(R.id.btn_ok);
        listView = findViewById(R.id.list_view);
        relativeLayout = findViewById(R.id.parentLayout);

        // ArrayList digunakan untuk menyimpan item-item yang akan ditampilkan di ListView
        // ArrayAdapter digunakan untuk menghubungkan ArrayList dengan ListView

        list = new ArrayList<>();
        // 3 param = activity.this, layout utk tampil tiap item sbg teks tunggal, sumber data utk tampilin item
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, list);
        listView.setAdapter(adapter);

        button.setOnClickListener(v -> {
            // ambil dri editText, convert to string, hapus spasi ekstra diawal dan akhir
            String newItem = editText.getText().toString().trim();
            if (!newItem.isEmpty()) {
                list.add(newItem);
                // tell adapter data has change, adapter akan memperbarui tampilan ListView
                adapter.notifyDataSetChanged();
                editText.getText().clear();
            }
        });
    }
}