package com.example.learningappremastered.Classes;

import android.os.Parcel;
import android.os.Parcelable;

public class Game implements Parcelable {
    int totalPlayTime;
    int playTimeToday;
    boolean visible;
    String name;

    public Game() { }

    public Game(int totalPlayTime, int playTimeToday, boolean visible, String name) {
        this.totalPlayTime = totalPlayTime;
        this.playTimeToday = playTimeToday;
        this.visible = visible;
        this.name = name;
    }

    protected Game(Parcel in) {
        totalPlayTime = in.readInt();
        playTimeToday = in.readInt();
        visible = in.readByte() != 0;
        name = in.readString();
    }

    public static final Creator<Game> CREATOR = new Creator<Game>() {
        @Override
        public Game createFromParcel(Parcel in) {
            return new Game(in);
        }

        @Override
        public Game[] newArray(int size) {
            return new Game[size];
        }
    };

    @Override
    public String toString() {
        return "Game{" +
                "totalPlayTime=" + totalPlayTime +
                ", playTimeToday=" + playTimeToday +
                ", visible=" + visible +
                ", name='" + name + '\'' +
                '}';
    }

    public int getTotalPlayTime() {
        return totalPlayTime;
    }

    public void setTotalPlayTime(int totalPlayTime) {
        this.totalPlayTime = totalPlayTime;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPlayTimeToday() {
        return playTimeToday;
    }

    public void setPlayTimeToday(int playTimeToday) {
        this.playTimeToday = playTimeToday;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(totalPlayTime);
        dest.writeInt(playTimeToday);
        dest.writeByte((byte) (visible ? 1 : 0));
        dest.writeString(name);
    }
}