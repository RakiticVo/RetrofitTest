package com.example.myretrofittest.TestGson;

public class Hobby {
    private int ID;
    private String hobby;

    public Hobby(int ID, String hobby) {
        this.ID = ID;
        this.hobby = hobby;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }
}
