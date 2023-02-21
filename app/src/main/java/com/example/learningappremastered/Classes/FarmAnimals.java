package com.example.learningappremastered.Classes;

import java.util.HashMap;

public class FarmAnimals extends PassiveGame {
    HashMap<String,String> animalList = new HashMap<>();

    public FarmAnimals(int totalPlayTime, int playTimeToday, boolean visible, String name, HashMap<String, String> animalList) {
        super(totalPlayTime, playTimeToday, visible, name);
        this.animalList = animalList;
    }

    public HashMap<String, String> getAnimalList() {
        return animalList;
    }

    public void setAnimalList(HashMap<String, String> animalList) {
        this.animalList = animalList;
    }
}
