package com.example.test4;

import java.util.List;

import java.io.Serializable;
import java.util.List;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

public class Test implements Serializable {
    private String id;
    private String title;
    private List<Question> questions;

    public Test(String id, String title, List<Question> questions) {
        this.id = id;
        this.title = title;
        this.questions = questions;
    }

    // Геттеры и сеттеры
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }
}