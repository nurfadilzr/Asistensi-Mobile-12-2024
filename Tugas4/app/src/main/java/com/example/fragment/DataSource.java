package com.example.fragment;

import java.util.ArrayList;

public class DataSource {

    public static ArrayList<Post> post = generateDummyPost();

    private static ArrayList<Post> generateDummyPost() {
        ArrayList<Post> posts = new ArrayList<>();
        posts.add(new Post(R.drawable.bento, "bento", "Bento Box", "bento Aliquam eget libero aliquet, imperdiet nisl a, ornare ex. Sed rhoncus est ut libero porta lobortis. Fusce in dictum tellus.Suspendisse interdum ornare ante. Aliquam nec cursus lorem. Morbi id magna felis. Vivamus",  R.drawable.bento));
        posts.add(new Post(R.drawable.konro, "konro", "Sop Konro", "konro Morbi tellus erat, dapibus ut sem a, iaculis tincidunt dui.", R.drawable.konro));
        posts.add(new Post(R.drawable.puding, "puding", "Puding Jeneponto", "puding Fusce blandit tincidunt nulla, quis sollicitudin libero facilisis et. Integer interdum nunc ligula, et fermentum metus hendrerit id. Vestibulum lectus felis, dictum at lacinia sit amet", R.drawable.puding));
        posts.add(new Post(R.drawable.tumpeng, "tumpeng", "Nasi Tumpeng", "tumpeng et fermentum metus hendrerit id. Vestibulum lectus felis, dictum atlacinia sit amet", R.drawable.tumpeng));
        posts.add(new Post(R.drawable.udon, "udon", "Curry Udon", "udon Pellentesque id tellus orci", R.drawable.udon));
        return posts;
    }
}
