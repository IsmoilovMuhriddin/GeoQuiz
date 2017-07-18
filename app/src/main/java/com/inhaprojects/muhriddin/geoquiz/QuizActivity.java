package com.inhaprojects.muhriddin.geoquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class QuizActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
    }


    public void GreetingMethod(View view) {
        TextView output = (TextView) findViewById(R.id.printView);
        EditText input =(EditText) findViewById(R.id.inputName);
        output.setText(input.getText());

    }
}
