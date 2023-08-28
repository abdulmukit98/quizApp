package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView mScoreView;
    private TextView mQuestionView;
    private Button mButtonChoice1;
    private Button mButtonChoice2;
    private Button mButtonChoice3;
    private Button mQuit;

    private QuestionLibrary mQuestionLibrary = new QuestionLibrary();
    private String mAnswer;
    private int mScore = 0;
    private int mQuestionNumber = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mScoreView = findViewById(R.id.tvScore);
        mQuestionView = findViewById(R.id.tvQuestion);
        mButtonChoice1 = findViewById(R.id.btnChoice1);
        mButtonChoice2 = findViewById(R.id.btnChoice2);
        mButtonChoice3 = findViewById(R.id.btnChoice3);
        mQuit = findViewById(R.id.btnQuit);

        mButtonChoice1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if (mButtonChoice1.getText()==mAnswer)
                    {
                        mScore = mScore + 1;
                        updateScore(mScore);
                        updateQuestion();
                        Toast.makeText(MainActivity.this, "Correct", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        Toast.makeText(MainActivity.this, "Wrong", Toast.LENGTH_SHORT).show();
                        updateQuestion();
                    }
                } catch (Exception e)
                {
                    Toast.makeText(MainActivity.this, e.getMessage()+"", Toast.LENGTH_SHORT).show();
                }

            }
        });


        mButtonChoice2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if (mButtonChoice2.getText()==mAnswer)
                    {
                        mScore = mScore + 1;
                        updateScore(mScore);
                        updateQuestion();
                        Toast.makeText(MainActivity.this, "Correct", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        Toast.makeText(MainActivity.this, "Wrong", Toast.LENGTH_SHORT).show();
                        updateQuestion();
                    }
                } catch (Exception e)
                {
                    Toast.makeText(MainActivity.this, e.getMessage()+"", Toast.LENGTH_SHORT).show();
                }

            }
        });


        mButtonChoice3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if (mButtonChoice3.getText()==mAnswer)
                    {
                        mScore = mScore + 1;
                        updateScore(mScore);
                        updateQuestion();
                        Toast.makeText(MainActivity.this, "Correct", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        Toast.makeText(MainActivity.this, "Wrong", Toast.LENGTH_SHORT).show();
                        updateQuestion();
                    }
                } catch (Exception e)
                {
                    Toast.makeText(MainActivity.this, e.getMessage()+"", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

    private void updateQuestion()
    {
        mQuestionView.setText(mQuestionLibrary.getQuestion(mQuestionNumber));
        mButtonChoice1.setText(mQuestionLibrary.getChoice1(mQuestionNumber));
        mButtonChoice2.setText(mQuestionLibrary.getChoice2(mQuestionNumber));
        mButtonChoice3.setText(mQuestionLibrary.getChoice3(mQuestionNumber));

        mAnswer = mQuestionLibrary.getCorrectAnswer(mQuestionNumber);
        mQuestionNumber++;
    }

    private void updateScore(int point)
    {
        mScoreView.setText("Score: " + point);
    }
}