package com.example.thread;

import java.util.ArrayList;

public class DataSource {

    public static ArrayList<Post> post = generateDummyPost();

    private static ArrayList<Post> generateDummyPost() {
        ArrayList<Post> posts = new ArrayList<>();
        posts.add(new Post(R.drawable.cat, "thomas", "Thomas The Cat", "Is you is or is you ain't my baby", R.drawable.cat));
        posts.add(new Post(R.drawable.jadwal, "jadwal", "Jadwal Kelas", "xiiipa5", R.drawable.jadwal));
        posts.add(new Post(R.drawable.jam, "jam", "Jam Tangan", "cakep", R.drawable.jam));
        posts.add(new Post(R.drawable.maps, "maps", "Google Maps", "jauh", R.drawable.maps));
        posts.add(new Post(R.drawable.tari, "tari", "Tari Tradi", "seroja2020", R.drawable.tari));

        return posts;
    }
}
