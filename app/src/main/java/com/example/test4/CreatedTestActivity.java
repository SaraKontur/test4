package com.example.test4;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import android.widget.Toast;

public class CreatedTestActivity extends AppCompatActivity implements TestAdapter.OnTestClickListener {
    private RecyclerView recyclerView;
    private TestAdapter testAdapter;
    private List<Test> testList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_created_test);

        recyclerView = findViewById(R.id.testsRecyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2)); // 2 колонки

        // Загружаем тесты
        loadTests();

        // Инициализируем адаптер после загрузки данных
        testAdapter = new TestAdapter(testList, this);
        recyclerView.setAdapter(testAdapter);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        // Устанавливаем обработчик нажатий
        bottomNavigationView.setOnItemSelectedListener(item -> {
            if (item.getItemId() == R.id.nav_hub_teacher) {
                startActivity(new Intent(CreatedTestActivity.this, HubActivityTeacher.class));
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                return true;
            } else if (item.getItemId() == R.id.nav_create_test) {
                startActivity(new Intent(CreatedTestActivity.this, CreateTestActivity.class));
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                return true;
            } else if (item.getItemId() == R.id.nav_created_tests) {
                return true;
            }
            return false;
        });

        // Устанавливаем начальный выбранный элемент
        bottomNavigationView.setSelectedItemId(R.id.nav_created_tests);
    }

    private void loadTests() {
        SharedPreferences sharedPreferences = getSharedPreferences("tests", Context.MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("test_list", "[]");

        Type type = new TypeToken<ArrayList<Test>>() {}.getType();
        testList = gson.fromJson(json, type);

        // Обновляем адаптер после загрузки данных
        if (testAdapter != null) {
            testAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onTestClick(int position) {
        // Получаем выбранный тест
        Test selectedTest = testList.get(position);

        // Переход на активность для прохождения теста
        Intent intent = new Intent(this, TakeTestActivity.class);
        intent.putExtra("test", selectedTest);
        startActivity(intent);
    }
}