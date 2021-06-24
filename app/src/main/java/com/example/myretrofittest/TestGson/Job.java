package com.example.myretrofittest.TestGson;

public class Job {

    private int ID;
    private String job;

    public Job(int ID, String job) {
        this.ID = ID;
        this.job = job;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }
}
