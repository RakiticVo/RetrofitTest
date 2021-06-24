package com.example.myretrofittest.TestGson;

import java.util.List;

public class User {

    private int ID;
    private String name;
    private boolean isActive;
    private Job job;
    private List<Hobby> hobbies;

    public User(int ID, String name, boolean isActive, Job job, List<Hobby> hobbies) {
        this.ID = ID;
        this.name = name;
        this.isActive = isActive;
        this.job = job;
        this.hobbies = hobbies;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public List<Hobby> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<Hobby> hobbies) {
        this.hobbies = hobbies;
    }
}