package com.example.challenge3;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private Button additionButton, subtractionButton, multiplicationButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        additionButton = findViewById(R.id.button);
        subtractionButton = findViewById(R.id.button2);
        multiplicationButton = findViewById(R.id.button3);

        additionButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, AdditionActivity.class);
            startActivity(intent);
        });

        // Tạm thời bỏ qua Subtraction và Multiplication cho bài tập này
        subtractionButton.setEnabled(false);
        multiplicationButton.setEnabled(false);
    }
}