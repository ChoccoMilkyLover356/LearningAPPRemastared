package com.example.learningappremastered.Classes;

import java.util.ArrayList;

public class Storys extends com.example.learningapp.Classes.PassiveGame {
    ArrayList<String> storyList = new ArrayList<>();

    public Storys(int totalPlayTime, int playTimeToday, boolean visible, String name, ArrayList<String> storyList) {
        super(totalPlayTime, playTimeToday, visible, name);
        this.storyList = storyList;
    }

    public ArrayList<String> getStoryList() {
        return storyList;
    }

    public void setStoryList(ArrayList<String> storyList) {
        this.storyList = storyList;
    }
}
