package com.example.test4;

import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class TakeTestActivity extends AppCompatActivity {
    private Test test;
    private RecyclerView questionsRecyclerView;
    private QuestionAdapter questionAdapter;
    private Button finishTestButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_take_test);

        // Получаем тест из Intent
        test = (Test) getIntent().getSerializableExtra("test");

        // Отображаем название теста
        TextView testTitleTextView = findViewById(R.id.testTitle);
        testTitleTextView.setText(test.getTitle());

        // Настройка RecyclerView для вопросов
        questionsRecyclerView = findViewById(R.id.questionsRecyclerView);
        questionsRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        questionAdapter = new QuestionAdapter(test.getQuestions());
        questionsRecyclerView.setAdapter(questionAdapter);

        // Кнопка завершения теста
        finishTestButton = findViewById(R.id.finishTestButton);
        finishTestButton.setOnClickListener(v -> finishTest());
    }

    private void finishTest() {
        int correctAnswers = 0;

        // Проверяем каждый вопрос
        for (int i = 0; i < test.getQuestions().size(); i++) {
            Question question = test.getQuestions().get(i);
            RecyclerView.ViewHolder holder = questionsRecyclerView.findViewHolderForAdapterPosition(i);

            if (holder instanceof QuestionAdapter.QuestionViewHolder) {
                QuestionAdapter.QuestionViewHolder questionViewHolder = (QuestionAdapter.QuestionViewHolder) holder;
                int selectedId = questionViewHolder.optionsRadioGroup.getCheckedRadioButtonId();

                if (selectedId != -1) {
                    RadioButton selectedRadioButton = questionViewHolder.itemView.findViewById(selectedId);
                    String selectedAnswer = selectedRadioButton.getText().toString();

                    if (selectedAnswer.equals(question.getCorrectAnswer())) {
                        correctAnswers++;
                    }
                }
            }
        }

        // Показываем результат
        Toast.makeText(this, "Правильных ответов: " + correctAnswers + " из " + test.getQuestions().size(), Toast.LENGTH_LONG).show();
    }
}