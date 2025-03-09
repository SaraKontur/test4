package com.example.test4;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivityTeacher extends AppCompatActivity {


    private final String password = "15049";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_login);

        EditText keyPassEditText = findViewById(R.id.key_pass);

        // Добавьте кнопку для подтверждения ввода пароля
        Button loginButton = findViewById(R.id.btn_login_teacher); // Предполагая, что у вас есть кнопка с id login_button

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String keyPassString = keyPassEditText.getText().toString();

                if (keyPassString.equals(password)) {
                    // Переход на HubActivityTeacher
                    Intent intent = new Intent(LoginActivityTeacher.this, HubActivityTeacher.class);
                    startActivity(intent);
                    finish(); // Закрыть текущую активность, если это необходимо
                } else {
                    // Вы можете добавить обработку неверного пароля, например, показать тост
                    Toast.makeText(LoginActivityTeacher.this, "Неверный пароль", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}