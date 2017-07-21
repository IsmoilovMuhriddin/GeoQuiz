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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        score=0;
        questionView =  (TextView) findViewById(R.id.questText);
        trueButton = (ImageButton) findViewById(R.id.trueBtn);
        falseButton =(ImageButton)findViewById(R.id.falseBtn);
        nextButton = (Button) findViewById(R.id.nextButton);
        
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
