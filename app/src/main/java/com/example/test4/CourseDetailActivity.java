package com.example.test4;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class CourseDetailActivity extends AppCompatActivity {

    private TextView tvCourseTitle;
    private TextView tvCourseDescription;
    private Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_detail);

        tvCourseTitle = findViewById(R.id.tvCourseTitle);
        tvCourseDescription = findViewById(R.id.tvCourseDescription);
        btnBack = findViewById(R.id.btnBack);

        // Получаем данные о курсе из Intent
        Intent intent = getIntent();
        int courseId = intent.getIntExtra("courseId", -1);

        // Здесь можно добавить логику для получения информации о курсе по ID
        // Для примера, просто установим заголовок и описание
        if (courseId == 1) {
            tvCourseTitle.setText("Курс по Java");
            tvCourseDescription.setText("Этот курс охватывает основы Java, включая синтаксис, ООП и работу с библиотеками.");
        } else if (courseId == 2) {
            tvCourseTitle.setText("Курс по Android");
            tvCourseDescription.setText("Научитесь создавать приложения для Android с нуля, используя Java и Android Studio.");
        } else if (courseId == 3) {
            tvCourseTitle.setText("Курс по веб-разработке");
            tvCourseDescription.setText("Изучите основы веб-разработки, включая HTML, CSS и JavaScript.");
        }

        // Обработчик нажатия на кнопку "Назад"
        btnBack.setOnClickListener(v -> finish());
    }
}