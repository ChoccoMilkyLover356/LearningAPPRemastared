package com.example.learningappremastered.Classes;

import java.util.ArrayList;

public class Letters extends com.example.learningappremastered.Classes.ActiveGame {
    ArrayList<Character> letters = new ArrayList<Character>();

    public Letters(int totalPlayTime, int playTimeToday, boolean visible, String name, int points, ArrayList<Character> letters) {
        super(totalPlayTime, playTimeToday, visible, name, points);
        this.letters = letters;
    }

    public ArrayList<Character> getLetters() {
        return letters;
    }

    public void setLetters(ArrayList<Character> letters) {
        this.letters = letters;
    }
}
