package com.inhaprojects.muhriddin.geoquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
    private ImageButton falseButton;
    private Toast toast;

    Question[] QuestionArray;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        QuestionArray = new Question[]{
                new Question(R.string.question_africa, true),
                new Question(R.string.question_americas, true),
                new Question(R.string.question_asia, true),
                new Question(R.string.question_australia, true),
                new Question(R.string.question_mideast, false),
                new Question(R.string.question_oceans, true),

        };

        score=0;
        questionView =  (TextView) findViewById(R.id.questText);
        trueButton = (ImageButton) findViewById(R.id.trueButton);
        falseButton = (ImageButton) findViewById(R.id.falseButton);
        nextButton = (Button) findViewById(R.id.nextButton);

        questionView.setText(QuestionArray[0].getQuestionId());

        trueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                score++;
                toast = Toast.makeText(QuizActivity.this, "Correct \n Your Score: "+ score,Toast.LENGTH_SHORT);

                toast.show();

            }
        });

        falseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toast = Toast.makeText(QuizActivity.this, "Incorrect \n Your Score:"+ score,Toast.LENGTH_SHORT);
                toast.show();
            }
        });



    }

}
