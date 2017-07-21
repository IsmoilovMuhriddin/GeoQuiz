package com.inhaprojects.muhriddin.geoquiz;

import android.content.DialogInterface;
import android.content.Intent;
import android.provider.Settings;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity {
    private static  int score ;
    private TextView questionView ;
    private ImageButton trueButton;
    private Button nextButton;
    private Button cheatButton;
    private ImageButton falseButton;
    private Toast toast;
    static int questionNumber;
    final String QUESTIONNUMBER = "questionNumber";
    final String SCORE = "score";

    Question[] QuestionArray;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        Log.i("tag", "onCreate is running  ..");

        questionNumber = (savedInstanceState != null) ? savedInstanceState.getInt(QUESTIONNUMBER) : 0;
        score = (savedInstanceState != null) ? savedInstanceState.getInt(SCORE) : 0;
        QuestionArray = new Question[]{
                new Question(R.string.question_africa, true),
                new Question(R.string.question_americas, true),
                new Question(R.string.question_asia, true),
                new Question(R.string.question_australia, true),
                new Question(R.string.question_mideast, false),
                new Question(R.string.question_oceans, true),

        };

        cheatButton = (Button) findViewById(R.id.cheatButton);
        questionView =  (TextView) findViewById(R.id.questText);
        trueButton = (ImageButton) findViewById(R.id.trueButton);
        falseButton = (ImageButton) findViewById(R.id.falseButton);
        nextButton = (Button) findViewById(R.id.nextButton);

        questionView.setText(QuestionArray[questionNumber].getQuestionId());

        trueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (QuestionArray[questionNumber].isAnswer() == true) {
                    score++;
                    nextCheck();
                    toast = Toast.makeText(QuizActivity.this, "Correct \n Your Score:" + score, Toast.LENGTH_SHORT);
                    toast.show();
                } else {
                    toast = Toast.makeText(QuizActivity.this, "Incorrect \n Your Score:" + score, Toast.LENGTH_SHORT);
                    toast.show();
                }

            }
        });

        falseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (QuestionArray[questionNumber].isAnswer() == false) {
                    score++;
                    nextCheck();
                    toast = Toast.makeText(QuizActivity.this, "Correct \n Your Score:" + score, Toast.LENGTH_SHORT);
                    toast.show();
                } else {
                    toast = Toast.makeText(QuizActivity.this, "Incorrect \n Your Score:" + score, Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextCheck();
            }
        });

        cheatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(QuizActivity.this, CheatActivity.class);
                intent.putExtra("data1", QuestionArray[questionNumber].getQuestionId());
                intent.putExtra("data2", questionNumber);
                intent.putExtra("data3", QuestionArray[questionNumber].isAnswer());
                startActivityForResult(intent, 12345);
            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i("tag", "onSavedinstance is running  ..");
        outState.putInt(QUESTIONNUMBER, questionNumber);
        outState.putInt(SCORE, score);

    }

    public void nextCheck() {
        questionNumber++;
        if (questionNumber == 5) {
            toast = Toast.makeText(QuizActivity.this, "\n Your Score:" + score, Toast.LENGTH_SHORT);
            toast.show();
            atTheEndQuestion();

        }
        questionView.setText(QuestionArray[questionNumber].getQuestionId());
    }

    public void atTheEndQuestion() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("Do You want to play again?");
        builder.setMessage("Your Score: " + score);

        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                questionNumber = 0;
                score = 0;
                dialog.dismiss();
            }
        });

        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {

                // Do nothing
                System.exit(0);
                dialog.dismiss();
            }
        });


        AlertDialog alert = builder.create();
        alert.show();
    }
}
