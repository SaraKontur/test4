package com.example.test4;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class TakeTestActivity extends AppCompatActivity {
    private Test test;
    private List<Answer> answers = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_take_test);

        test = (Test) getIntent().getSerializableExtra("test");

        TextView testTitle = findViewById(R.id.testTitle);
        testTitle.setText(test.getTitle());

        LinearLayout questionsContainer = findViewById(R.id.questionsContainer);
        for (Question question : test.getQuestions()) {
            TextView questionText = new TextView(this);
            questionText.setText(question.getText());
            questionsContainer.addView(questionText);

            RadioGroup radioGroup = new RadioGroup(this);
            for (String option : question.getOptions()) {
                RadioButton radioButton = new RadioButton(this);
                radioButton.setText(option);
                radioGroup.addView(radioButton);
            }
            questionsContainer.addView(radioGroup);
        }
    }

    public void submitTest(View view) {
        // Обработка ответов и сохранение результатов
    }
}