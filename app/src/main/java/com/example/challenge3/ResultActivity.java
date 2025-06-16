package com.example.challenge3;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        TextView congratulationTitle = findViewById(R.id.congratulationTitle);
        TextView scoreText = findViewById(R.id.textView2);
        Button playAgainButton = findViewById(R.id.playAgainButton);
        Button exitButton = findViewById(R.id.exitButton);

        // Lấy điểm cuối cùng từ Intent
        int finalScore = getIntent().getIntExtra("FINAL_SCORE", 0);
        scoreText.setText("Score: " + finalScore);

        // Hiển thị thông điệp chúc mừng
        if (finalScore > 50) {
            congratulationTitle.setText("Congratulation! Great Job!");
        } else {
            congratulationTitle.setText("Congratulation! Try Again!");
        }

        // Xử lý nút Play Again
        playAgainButton.setOnClickListener(v -> {
            Intent intent = new Intent(ResultActivity.this, AdditionActivity.class);
            startActivity(intent);
            finish();
        });

        // Xử lý nút Exit
        exitButton.setOnClickListener(v -> finish());
    }
}
