package com.example.challenge3;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class AdditionActivity extends AppCompatActivity {
    private TextView scoreResult, lifeResult, timerResult, questionText;
    private EditText answerEditText;
    private Button okButton, nextButton;
    private int score = 0;
    private int lives = 3;
    private CountDownTimer timer;
    private static final long TIMER_DURATION = 60000; // 60 giây
    private Random random = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addition);

        // Khởi tạo các thành phần giao diện
        scoreResult = findViewById(R.id.scoreResult);
        lifeResult = findViewById(R.id.lifeResult);
        timerResult = findViewById(R.id.timerResult);
        questionText = findViewById(R.id.textView7);
        answerEditText = findViewById(R.id.editTextText);
        okButton = findViewById(R.id.OkButton);
        nextButton = findViewById(R.id.nextButton);

        // Khởi tạo câu hỏi đầu tiên và bộ đếm thời gian
        generateQuestion();
        startTimer();

        // Xử lý nút Ok
        okButton.setOnClickListener(v -> checkAnswer());

        // Xử lý nút Next question
        nextButton.setOnClickListener(v -> {
            generateQuestion();
            answerEditText.setText("");
        });
    }
    private void generateQuestion() {
        int num1 = random.nextInt(100) + 1; // Số từ 1 đến 100
        int num2 = random.nextInt(100) + 1;
        questionText.setText(num1 + " + " + num2 + " = ?");
    }
    private void checkAnswer() {
        String userAnswerStr = answerEditText.getText().toString().trim();
        if (!userAnswerStr.isEmpty()) {
            try {
                int userAnswer = Integer.parseInt(userAnswerStr);
                String question = questionText.getText().toString();
                int correctAnswer = getCorrectAnswer(question);
                if (userAnswer == correctAnswer) {
                    score += 10;
                    scoreResult.setText(String.valueOf(score));
                } else {
                    lives--;
                    lifeResult.setText(String.valueOf(lives));
                }
                checkGameOver();
            } catch (NumberFormatException e) {
                answerEditText.setError("Please enter a valid number");
            }
        } else {
            answerEditText.setError("Please enter an answer");
        }
    }

    private int getCorrectAnswer(String question) {
        String[] parts = question.split(" \\+ | = \\?");
        int num1 = Integer.parseInt(parts[0]);
        int num2 = Integer.parseInt(parts[1]);
        return num1 + num2;
    }

    private void startTimer() {
        timer = new CountDownTimer(TIMER_DURATION, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timerResult.setText(String.valueOf(millisUntilFinished / 1000));
            }

            @Override
            public void onFinish() {
                timerResult.setText("0");
                lives = 0;
                lifeResult.setText("0");
                checkGameOver();
            }
        }.start();
    }

    private void checkGameOver() {
        if (lives <= 0) {
            timer.cancel();
            Intent intent = new Intent(AdditionActivity.this, ResultActivity.class);
            intent.putExtra("FINAL_SCORE", score);
            startActivity(intent);
            finish();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (timer != null) {
            timer.cancel();
        }
    }
}
