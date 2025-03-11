package com.example.test4;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class CreateTestActivity extends AppCompatActivity {
    private EditText testTitleEditText, question1EditText, question2EditText, question3EditText, question4EditText, question5EditText;
    private EditText option1_1, option1_2, option1_3, option1_4;
    private EditText option2_1, option2_2, option2_3, option2_4;
    private EditText option3_1, option3_2, option3_3, option3_4;
    private EditText option4_1, option4_2, option4_3, option4_4;
    private EditText option5_1, option5_2, option5_3, option5_4;
    private CheckBox correctOption1_1, correctOption1_2, correctOption1_3, correctOption1_4;
    private CheckBox correctOption2_1, correctOption2_2, correctOption2_3, correctOption2_4;
    private CheckBox correctOption3_1, correctOption3_2, correctOption3_3, correctOption3_4;
    private CheckBox correctOption4_1, correctOption4_2, correctOption4_3, correctOption4_4;
    private CheckBox correctOption5_1, correctOption5_2, correctOption5_3, correctOption5_4;

    private List<Question> questions = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_test);
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        // Устанавливаем начальный выбранный элемент
        bottomNavigationView.setSelectedItemId(R.id.nav_created_tests);

        // Устанавливаем обработчик нажатий
        bottomNavigationView.setOnItemSelectedListener(item -> {
            if (item.getItemId() == R.id.nav_hub_teacher) {
                // Переход на HubActivityTeacher
                startActivity(new Intent(CreateTestActivity.this, HubActivityTeacher.class));
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                return true;
            } else if (item.getItemId() == R.id.nav_create_test) {
                // Переход на CreateTestActivity
                startActivity(new Intent(CreateTestActivity.this, CreateTestActivity.class));
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                return true;
            } else if (item.getItemId() == R.id.nav_created_tests) {
                // Уже находимся на этой вкладке
                return true;
            }
            return false;
        });


        testTitleEditText = findViewById(R.id.testTitle);

        // Вопросы
        question1EditText = findViewById(R.id.question1);
        question2EditText = findViewById(R.id.question2);
        question3EditText = findViewById(R.id.question3);
        question4EditText = findViewById(R.id.question4);
        question5EditText = findViewById(R.id.question5);

        // Варианты ответов для каждого вопроса
        option1_1 = findViewById(R.id.option1_1);
        option1_2 = findViewById(R.id.option1_2);
        option1_3 = findViewById(R.id.option1_3);
        option1_4 = findViewById(R.id.option1_4);

        option2_1 = findViewById(R.id.option2_1);
        option2_2 = findViewById(R.id.option2_2);
        option2_3 = findViewById(R.id.option2_3);
        option2_4 = findViewById(R.id.option2_4);

        option3_1 = findViewById(R.id.option3_1);
        option3_2 = findViewById(R.id.option3_2);
        option3_3 = findViewById(R.id.option3_3);
        option3_4 = findViewById(R.id.option3_4);

        option4_1 = findViewById(R.id.option4_1);
        option4_2 = findViewById(R.id.option4_2);
        option4_3 = findViewById(R.id.option4_3);
        option4_4 = findViewById(R.id.option4_4);

        option5_1 = findViewById(R.id.option5_1);
        option5_2 = findViewById(R.id.option5_2);
        option5_3 = findViewById(R.id.option5_3);
        option5_4 = findViewById(R.id.option5_4);

        // Галочки для правильных вариантов ответов
        correctOption1_1 = findViewById(R.id.correctOption1_1);
        correctOption1_2 = findViewById(R.id.correctOption1_2);
        correctOption1_3 = findViewById(R.id.correctOption1_3);
        correctOption1_4 = findViewById(R.id.correctOption1_4);

        correctOption2_1 = findViewById(R.id.correctOption2_1);
        correctOption2_2 = findViewById(R.id.correctOption2_2);
        correctOption2_3 = findViewById(R.id.correctOption2_3);
        correctOption2_4 = findViewById(R.id.correctOption2_4);

        correctOption3_1 = findViewById(R.id.correctOption3_1);
        correctOption3_2 = findViewById(R.id.correctOption3_2);
        correctOption3_3 = findViewById(R.id.correctOption3_3);
        correctOption3_4 = findViewById(R.id.correctOption3_4);

        correctOption4_1 = findViewById(R.id.correctOption4_1);
        correctOption4_2 = findViewById(R.id.correctOption4_2);
        correctOption4_3 = findViewById(R.id.correctOption4_3);
        correctOption4_4 = findViewById(R.id.correctOption4_4);

        correctOption5_1 = findViewById(R.id.correctOption5_1);
        correctOption5_2 = findViewById(R.id.correctOption5_2);
        correctOption5_3 = findViewById(R.id.correctOption5_3);
        correctOption5_4 = findViewById(R.id.correctOption5_4);
    }

    public void saveTest(View view) {
        // Сохраняем название теста
        String testTitle = testTitleEditText.getText().toString();

        // Сохраняем вопросы и ответы
        saveQuestion(question1EditText, option1_1, option1_2, option1_3, option1_4, correctOption1_1, correctOption1_2, correctOption1_3, correctOption1_4);
        saveQuestion(question2EditText, option2_1, option2_2, option2_3, option2_4, correctOption2_1, correctOption2_2, correctOption2_3, correctOption2_4);
        saveQuestion(question3EditText, option3_1, option3_2, option3_3, option3_4, correctOption3_1, correctOption3_2, correctOption3_3, correctOption3_4);
        saveQuestion(question4EditText, option4_1, option4_2, option4_3, option4_4, correctOption4_1, correctOption4_2, correctOption4_3, correctOption4_4);
        saveQuestion(question5EditText, option5_1, option5_2, option5_3, option5_4, correctOption5_1, correctOption5_2, correctOption5_3, correctOption5_4);

        // Сохраняем тест в SharedPreferences
        saveTestToSharedPreferences(testTitle, questions);
    }

    private void saveQuestion(EditText questionEditText, EditText option1, EditText option2, EditText option3, EditText option4,
                              CheckBox correctOption1, CheckBox correctOption2, CheckBox correctOption3, CheckBox correctOption4) {
        String questionText = questionEditText.getText().toString();

        List<String> options = new ArrayList<>();
        options.add(option1.getText().toString());
        options.add(option2.getText().toString());
        options.add(option3.getText().toString());
        options.add(option4.getText().toString());

        List<Boolean> correctAnswers = new ArrayList<>();
        correctAnswers.add(correctOption1.isChecked());
        correctAnswers.add(correctOption2.isChecked());
        correctAnswers.add(correctOption3.isChecked());
        correctAnswers.add(correctOption4.isChecked());


    }

    private void saveTestToSharedPreferences(String testTitle, List<Question> questions) {
        SharedPreferences sharedPreferences = getSharedPreferences("tests", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        // Сохраняем тест
        Gson gson = new Gson();
        String json = gson.toJson(questions);
        editor.putString(testTitle, json);
        editor.apply();
    }
}