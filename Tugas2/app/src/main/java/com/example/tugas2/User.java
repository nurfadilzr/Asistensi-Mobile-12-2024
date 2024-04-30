package com.example.tugas2;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class User implements Parcelable {
    private String nama;
    private String username;
    private String title;
    private String content;
    private String foto;

    public User(String nama, String username){
        this.nama = nama;
        this.username = username;
    }

    protected User(Parcel in) {
        nama = in.readString();
        username = in.readString();
        title = in.readString();
        content = in.readString();
        foto = in.readString();
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    public String getNama() {
        return nama;
    }
    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }

    public String getFoto() { return foto; }
    public void setFoto(String foto) { this.foto = foto; }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int flags) {
        parcel.writeString(nama);
        parcel.writeString(username);
        parcel.writeString(title);
        parcel.writeString(content);
        parcel.writeString(foto);
    }
}
