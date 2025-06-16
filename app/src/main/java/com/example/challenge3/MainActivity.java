package com.example.challenge3;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        Button additionButton = findViewById(R.id.button);
        Button subtractionButton = findViewById(R.id.button2);
        Button multiplicationButton = findViewById(R.id.button3);

        additionButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, AdditionActivity.class);
            startActivity(intent);
        });

        subtractionButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, SubtractionActivity.class);
            startActivity(intent);
        });

        multiplicationButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, MultiplicationActivity.class);
            startActivity(intent);
        });
    }
}