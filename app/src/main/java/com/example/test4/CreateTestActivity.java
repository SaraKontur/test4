package com.example.test4;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CreateTestActivity extends AppCompatActivity {
    private EditText testTitle;
    private Button addQuestionButton, saveTestButton;
    private List<Question> questions = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_test);

        testTitle = findViewById(R.id.testTitle);
        addQuestionButton = findViewById(R.id.addQuestionButton);
        saveTestButton = findViewById(R.id.saveTestButton);

        addQuestionButton.setOnClickListener(v -> {
            Intent intent = new Intent(this, AddQuestionActivity.class);
            startActivityForResult(intent, 1);
        });

        saveTestButton.setOnClickListener(this::saveTest);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        // Устанавливаем обработчик нажатий
        bottomNavigationView.setOnItemSelectedListener(item -> {
            if (item.getItemId() == R.id.nav_hub_teacher) {
                // Переход на HubActivityTeacher
                startActivity(new Intent(CreateTestActivity.this, HubActivityTeacher.class));
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                return true;
            } else if (item.getItemId() == R.id.nav_created_tests) {
                // Переход на CreatedTestActivity
                startActivity(new Intent(CreateTestActivity.this, CreatedTestActivity.class));
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                return true;
            } else if (item.getItemId() == R.id.nav_create_test) {
                // Уже находимся на этой вкладке
                return true;
            }
            return false;
        });

        // Устанавливаем начальный выбранный элемент
        bottomNavigationView.setSelectedItemId(R.id.nav_create_test);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK) {
            Question question = (Question) data.getSerializableExtra("question");
            questions.add(question);
        }
    }

    public void saveTest(View view) {
        String title = testTitle.getText().toString();
        if (title.isEmpty() || questions.isEmpty()) {
            return; // Не сохраняем пустые тесты
        }

        Test test = new Test(UUID.randomUUID().toString(), title, questions);

        // Сохраняем тест
        SharedPreferences sharedPreferences = getSharedPreferences("tests", Context.MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("test_list", "[]");

        Type type = new TypeToken<ArrayList<Test>>() {}.getType();
        List<Test> testList = gson.fromJson(json, type);
        testList.add(test);

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("test_list", gson.toJson(testList));
        editor.apply();

        // Переход обратно в CreatedTestActivity
        Intent intent = new Intent(this, CreatedTestActivity.class);
        startActivity(intent);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        finish(); // Закрываем текущую активность
    }
}