package com.example.learningappremastered.Classes;

import java.util.ArrayList;

public class Storys extends com.example.learningappremastered.Classes.PassiveGame {
    ArrayList<String> storyList = new ArrayList<>();

    public Storys(int totalPlayTime, int playTimeToday, boolean visible, String name, int resource, ArrayList<String> storyList) {
        super(totalPlayTime, playTimeToday, visible, name, resource);
        this.storyList = storyList;
    }

    public ArrayList<String> getStoryList() {
        return storyList;
    }

    public void setStoryList(ArrayList<String> storyList) {
        this.storyList = storyList;
    }
}
