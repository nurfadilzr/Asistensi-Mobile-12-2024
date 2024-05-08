package com.example.networking;

import java.util.List;

public class UserResponse {         // class utk menampung hasil dri response berupa list user utk ditampilkan di mainact

    private List<User> data;

    public List<User> getData() {
        return data;
    }

    public void setData(List<User> data) {
        this.data = data;
    }
}
