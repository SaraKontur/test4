package com.example.test4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class AddQuestionActivity extends AppCompatActivity {
    private EditText questionText;
    private EditText option1, option2, option3, option4;
    private RadioGroup correctAnswerGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_question);

        questionText = findViewById(R.id.questionText);
        option1 = findViewById(R.id.option1);
        option2 = findViewById(R.id.option2);
        option3 = findViewById(R.id.option3);
        option4 = findViewById(R.id.option4);
        correctAnswerGroup = findViewById(R.id.correctAnswerGroup);
    }

    public void saveQuestion(View view) {
        String text = questionText.getText().toString();
        if (text.isEmpty()) {
            Toast.makeText(this, "Введите вопрос", Toast.LENGTH_SHORT).show();
            return;
        }

        List<String> options = Arrays.asList(
                option1.getText().toString(),
                option2.getText().toString(),
                option3.getText().toString(),
                option4.getText().toString()
        );

        int selectedId = correctAnswerGroup.getCheckedRadioButtonId();
        if (selectedId == -1) {
            Toast.makeText(this, "Выберите правильный ответ", Toast.LENGTH_SHORT).show();
            return;
        }

        RadioButton selectedRadioButton = findViewById(selectedId);
        String correctAnswer = selectedRadioButton.getText().toString();

        Question question = new Question(UUID.randomUUID().toString(), text, options, correctAnswer);

        Intent resultIntent = new Intent();
        resultIntent.putExtra("question", question);
        setResult(RESULT_OK, resultIntent);
        finish();
    }

}