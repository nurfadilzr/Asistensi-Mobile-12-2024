package com.example.recyclerview.parcelable;

import android.os.Parcel;
import android.os.Parcelable;

// dri item_story.xml
public class Story implements Parcelable {

    private Integer story;
    private String username;

    public Story(Integer story, String username) {
        this.story = story;
        this.username = username;
    }

    public Integer getStory() {
        return story;
    }

    public void setStory(Integer story) {
        this.story = story;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    protected Story(Parcel in) {
        if (in.readByte() == 0) {
            story = null;
        } else {
            story = in.readInt();
        }
        username = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (story == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(story);
        }
        dest.writeString(username);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Story> CREATOR = new Creator<Story>() {
        @Override
        public Story createFromParcel(Parcel in) {
            return new Story(in);
        }

        @Override
        public Story[] newArray(int size) {
            return new Story[size];
        }
    };
}