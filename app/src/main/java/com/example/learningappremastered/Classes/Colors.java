package com.example.learningappremastered.Classes;

import java.util.ArrayList;

public class Colors extends com.example.learningapp.Classes.ActiveGame {
    ArrayList<String> colors = new ArrayList<String>();

    public Colors(int totalPlayTime, int playTimeToday, boolean visible, String name, int points, ArrayList<String> colors) {
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
