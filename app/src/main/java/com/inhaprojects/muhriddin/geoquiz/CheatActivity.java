package com.inhaprojects.muhriddin.geoquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CheatActivity extends AppCompatActivity {
    private TextView questTextView;
    private TextView ansTextView;
    private Button showAnswerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat);
        Intent receivedIntent = getIntent();
        String str = receivedIntent.getStringExtra("data1");
        final int questionIndex = receivedIntent.getIntExtra("data2", -1);
        final boolean answer = receivedIntent.getBooleanExtra("data3", false);
        ansTextView = (TextView) findViewById(R.id.answerText);
        questTextView = (TextView) findViewById(R.id.questText);
        showAnswerButton = (Button) findViewById(R.id.showAnswerButton);

        questTextView.setText(str);
        ansTextView.setText("" + answer);
        showAnswerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sendMessage = new Intent(CheatActivity.this, QuizActivity.class);
                sendMessage.putExtra("data1", "hello back");
                setResult(RESULT_OK);
                finish();

            }
        });

    }


}
