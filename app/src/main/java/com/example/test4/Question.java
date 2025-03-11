package com.example.test4;

import java.util.List;

import java.io.Serializable;
import java.util.List;

public class Question {
    private String questionText;
    private String questionType;  // Добавлено поле для типа вопроса
    private List<String> options;
    private String correctAnswer;

    // Конструктор с четырьмя параметрами
    public Question(String questionText, String questionType, List<String> options, String correctAnswer) {
        this.questionText = questionText;
        this.questionType = questionType;  // Нужно передать тип вопроса
        this.options = options;
        this.correctAnswer = correctAnswer;
    }

    // Геттеры
    public String getQuestionText() {
        return questionText;
    }

    public String getQuestionType() {
        return questionType;
    }

    public List<String> getOptions() {
        return options;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }
}