package com.example.learningappremastered.Classes;

public class ActiveGame extends Game {
    int points;

    public ActiveGame(int totalPlayTime, int playTimeToday, boolean visible, String name, int resource, int points) {
        super(totalPlayTime, playTimeToday, visible, name, resource);
        this.points = points;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
