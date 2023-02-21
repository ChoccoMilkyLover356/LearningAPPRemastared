package com.example.learningappremastered.Classes;

import java.util.ArrayList;

public class Directions extends com.example.learningappremastered.Classes.ActiveGame {
    ArrayList<String> directions = new ArrayList<String>();

    public Directions(int totalPlayTime, int playTimeToday, boolean visible, String name, int points, ArrayList<String> directions) {
        super(totalPlayTime, playTimeToday, visible, name, points);
        this.directions = directions;
    }

    public ArrayList<String> getDirections() {
        return directions;
    }

    public void setDirections(ArrayList<String> directions) {
        this.directions = directions;
    }
}
