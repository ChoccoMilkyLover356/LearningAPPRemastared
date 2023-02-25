package com.example.learningappremastered.Classes;

import java.util.ArrayList;
import java.util.Map;

public class User {
    protected String username;
    protected Map<String, ArrayList> game;
    protected String userID;

    public User(){}

    public User(String username, Map game, String userID){
        this.username = username;
        this.game = game;
        this.userID = userID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Map<String, ArrayList> getGame() {
        return game;
    }

    public void setGame(Map<String, ArrayList> game) {
        this.game = game;
    }
}
