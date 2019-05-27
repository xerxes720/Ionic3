package com.example.Ionic3;


public class MyListData {


    private String title;
    private String assign;
    private int id;

    public MyListData(String title, String assign, int id) {
        this.title = title;
        this.assign = assign;
        this.id = id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAssign() {
        return assign;
    }

    public void setAssign(String assign) {
        this.assign = assign;
    }

}
