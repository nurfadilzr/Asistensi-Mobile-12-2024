package com.example.fragment;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Post implements Parcelable {
    private Integer profilePhoto;
    private String username;
    private String name;
    private String caption;
    private Integer postPhoto;
    private Uri selectedImageUri;

    public Post(Integer profilePhoto, String username, String name, String caption, Integer postPhoto) {
        this.profilePhoto = profilePhoto;
        this.username = username;
        this.name = name;
        this.caption = caption;
        this.postPhoto = postPhoto;
    }

    public Post(Integer profilePhoto, String username, String name, String caption, Uri selectedImageUri) {
        this.profilePhoto = profilePhoto;
        this.username = username;
        this.name = name;
        this.caption = caption;
        this.selectedImageUri = selectedImageUri;
    }


    protected Post(Parcel in) {
        if (in.readByte() == 0) {
            profilePhoto = null;
        } else {
            profilePhoto = in.readInt();
        }
        username = in.readString();
        name = in.readString();
        caption = in.readString();
        if (in.readByte() == 0) {
            postPhoto = null;
        } else {
            postPhoto = in.readInt();
        }
        selectedImageUri = in.readParcelable(Uri.class.getClassLoader());
    }

    public static final Creator<Post> CREATOR = new Creator<Post>() {
        @Override
        public Post createFromParcel(Parcel in) {
            return new Post(in);
        }

        @Override
        public Post[] newArray(int size) {
            return new Post[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        if (profilePhoto == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(profilePhoto);
        }
        dest.writeString(username);
        dest.writeString(name);
        dest.writeString(caption);
        if (postPhoto == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(postPhoto);
        }
        dest.writeParcelable(selectedImageUri, flags);
    }

    public Integer getProfilePhoto() {
        return profilePhoto;
    }

    public void setProfilePhoto(Integer profilePhoto) {
        this.profilePhoto = profilePhoto;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public Integer getPostPhoto() {
        return postPhoto;
    }

    public void setPostPhoto(Integer postPhoto) {
        this.postPhoto = postPhoto;
    }

    public Uri getSelectedImageUri() {
        return selectedImageUri;
    }

    public void setSelectedImageUri(Uri selectedImageUri) {
        this.selectedImageUri = selectedImageUri;
    }
}
