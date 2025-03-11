package com.example.test4;

public class Course {
    private int id;
    private String title;
    private int imageResId;

    public Course(int id, String title, int imageResId) {
        this.id = id;
        this.title = title;
        this.imageResId = imageResId;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getImageResId() {
        return imageResId;
    }
}