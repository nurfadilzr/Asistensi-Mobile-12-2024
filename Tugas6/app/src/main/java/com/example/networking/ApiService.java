package com.example.networking;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {                   // memanggil parameter dari link API nya beserta query page nya

    @GET("api/users")           // link api utk tampilkan isi mainact
    Call<UserResponse> getUsers(@Query("page") int page, @Query("per_page") int per_page);

    @GET("api/users/{id}")      // link api utk tampilkan isi profileact
    Call<UserResponse2> getUserById(@Path("id") int userId);
}
