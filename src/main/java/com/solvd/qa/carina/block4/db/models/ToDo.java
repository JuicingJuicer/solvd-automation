package com.solvd.qa.carina.block4.db.models;

public class ToDo {
    private int userId;
    private int id;
    private String title;
    private boolean completed;

    public ToDo(){}

    public void setUserId(int userId) {
        this.userId = userId;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public int getUserId() {
        return userId;
    }
    public int getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public boolean getCompleted() {
        return completed;
    }

}
