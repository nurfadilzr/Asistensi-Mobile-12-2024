package com.example.recyclerview;

import com.example.recyclerview.parcelable.Postingan;
import com.example.recyclerview.parcelable.Story;

import java.util.ArrayList;

public class DataSource {
    // deklarasi 2 arraylist yg berisi objek Postingan dan Story

    public static ArrayList<Postingan> posts = generateDummyPosts(); // menghasilkan data dummy

    private static ArrayList<Postingan> generateDummyPosts(){ // mengembalikan data dummy
        ArrayList<Postingan> posts = new ArrayList<>();
        posts.add(new Postingan(R.drawable.disaster, "ril_disaster", R.drawable.disaster, "the beginning"));
        posts.add(new Postingan(R.drawable.eid, "happy_eid", R.drawable.eid, "yaahhhuuu"));
        posts.add(new Postingan(R.drawable.forest, "hijaudaun", R.drawable.eid, "sehijau kamu xixi"));
        posts.add(new Postingan(R.drawable.newyear, "newme", R.drawable.eid, "duarrrr"));
        posts.add(new Postingan(R.drawable.starfish, "not_patrick", R.drawable.eid, "banyak bet kakinya"));
        posts.add(new Postingan(R.drawable.station, "thomasnf", R.drawable.eid, "miring fotonya"));
        posts.add(new Postingan(R.drawable.sunset, "teletubbies.sun", R.drawable.eid, "cakep kan"));
        posts.add(new Postingan(R.drawable.tol, "tolcgk", R.drawable.eid, "bubye"));
        posts.add(new Postingan(R.drawable.trees, "pohong", R.drawable.eid, "banyak garem disitu"));
        posts.add(new Postingan(R.drawable.windmill, "holland", R.drawable.eid, "barusan liat beginian"));
        return posts;
    }

    public static ArrayList<Story> stories = generateDummyStories();

    private static ArrayList<Story> generateDummyStories(){
        ArrayList<Story> stories = new ArrayList<>();
        stories.add(new Story(R.drawable.disaster, "ril_disaster"));
        stories.add(new Story(R.drawable.eid, "happy_eid"));
        stories.add(new Story(R.drawable.forest, "hijaudaun"));
        stories.add(new Story(R.drawable.newyear, "newme"));
        stories.add(new Story(R.drawable.starfish, "not_patrick"));
        stories.add(new Story(R.drawable.station, "thomasnf"));
        stories.add(new Story(R.drawable.sunset, "teletubbies.sun"));
        stories.add(new Story(R.drawable.tol, "tolcgk"));
        stories.add(new Story(R.drawable.trees, "pohong"));
        stories.add(new Story(R.drawable.windmill, "holland"));
        return stories;
    }
}