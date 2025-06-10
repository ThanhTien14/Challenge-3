package com.example.challenge3;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {
    private TextView congratulationTitle, scoreText;
    private Button playAgainButton, exitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        congratulationTitle = findViewById(R.id.congratulationTitle);
        scoreText = findViewById(R.id.textView2);
        playAgainButton = findViewById(R.id.playAgainButton);
        exitButton = findViewById(R.id.exitButton);

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
