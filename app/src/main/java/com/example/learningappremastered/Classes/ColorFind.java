package com.example.learningappremastered.Classes;

import java.util.ArrayList;

public class ColorFind extends com.example.learningappremastered.Classes.ActiveGame {
    ArrayList<String> colors = new ArrayList<String>();

    public ColorFind(int totalPlayTime, int playTimeToday, boolean visible, String name, int points, ArrayList<String> colors) {
        super(totalPlayTime, playTimeToday, visible, name, points);
        this.colors = colors;
    }

    public ArrayList<String> getColors() {
        return colors;
    }

    public void setColors(ArrayList<String> colors) {
        this.colors = colors;
    }
}
