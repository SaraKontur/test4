package com.example.test4;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class HubActivityStudent extends AppCompatActivity {

    private RecyclerView recyclerViewCourses;
    private CourseAdapter courseAdapter;
    private List<Course> courseList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_hub);

        recyclerViewCourses = findViewById(R.id.recyclerViewCourses);

        // Настройка RecyclerView
        recyclerViewCourses.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        // Создание списка курсов
        courseList = new ArrayList<>();
        courseList.add(new Course(1, "Курс 1", R.drawable.course_image_1));
        courseList.add(new Course(2, "Курс 2", R.drawable.course_image_2));
        courseList.add(new Course(3, "Курс 3", R.drawable.course_image_3));

        // Установка адаптера
        courseAdapter = new CourseAdapter(this, courseList);
        recyclerViewCourses.setAdapter(courseAdapter);
    }
}