package com.inhaprojects.muhriddin.geoquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity {

    private TextView questionView ;
    private Button trueButton;
    private Button falseButton;
    private Toast toast;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);


        questionView =  (TextView) findViewById(R.id.questText);
        trueButton = (Button) findViewById(R.id.trueBtn);
        falseButton =(Button)findViewById(R.id.falseBtn);

        trueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toast = Toast.makeText(QuizActivity.this, "Correct",Toast.LENGTH_SHORT);
                toast.show();
            }
        });

        falseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toast = Toast.makeText(QuizActivity.this, "Incorrect",Toast.LENGTH_SHORT);
                toast.show();
            }
        });



    }

}
