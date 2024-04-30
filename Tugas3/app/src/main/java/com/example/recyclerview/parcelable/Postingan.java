package com.example.recyclerview.parcelable;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Postingan implements Parcelable {
    private Integer profile;
    private String username;
    private Integer post;
    private String caption;

    public Postingan(Integer profile, String username, Integer post, String caption) {
        this.profile = profile;
        this.username = username;
        this.post = post;
        this.caption = caption;
    }

    public Integer getProfile() {
        return profile;
    }

    public void setProfile(Integer profile) {
        this.profile = profile;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getPost() {
        return post;
    }

    public void setPost(Integer post) {
        this.post = post;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    protected Postingan(Parcel in) {
        if (in.readByte() == 0) {
            profile = null;
        } else {
            profile = in.readInt();
        }
        username = in.readString();
        if (in.readByte() == 0) {
            post = null;
        } else {
            post = in.readInt();
        }
        caption = in.readString();
    }

    public static final Creator<Postingan> CREATOR = new Creator<Postingan>() {
        @Override
        public Postingan createFromParcel(Parcel in) {
            return new Postingan(in);
        }

        @Override
        public Postingan[] newArray(int size) {
            return new Postingan[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        if (profile == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(profile);
        }
        dest.writeString(username);
        if (post == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(post);
        }
        dest.writeString(caption);
    }
}