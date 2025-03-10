package com.example.test4;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HubActivityTeacher extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hub_teacher);

        // Инициализация Bottom Navigation
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnItemSelectedListener(item -> {
            if (item.getItemId() == R.id.nav_hub_teacher) {
                // Уже находимся на этой вкладке
                return true;
            } else if (item.getItemId() == R.id.nav_create_test) {
                // Переход на CreateTestActivity
                startActivity(new Intent(HubActivityTeacher.this, CreateTestActivity.class));
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                return true;
            } else if (item.getItemId() == R.id.nav_created_tests) {
                // Переход на CreatedTestActivity
                startActivity(new Intent(HubActivityTeacher.this, CreatedTestActivity.class));
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                return true;
            }
            return false;
        });

        // Устанавливаем начальный выбранный элемент
        bottomNavigationView.setSelectedItemId(R.id.nav_hub_teacher);
    }
}