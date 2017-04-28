package com.example.android.fourtemperaments;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class Warmup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_warmup);
    }

    int a = 0;

    public void warmResult(View v) {

        /**
         * Question 1
         */
        EditText hisName = (EditText) findViewById(R.id.question1);
        if (hisName.getText().toString().contains("Einstein")) {
            a++;
        }
        /**
         * Question 2
         */
        EditText number = (EditText) findViewById(R.id.question2);
        if (number.getText().toString().equals("4")) {
            a++;
        }
        /**
         * Question 3
         */
        CheckBox question3a = (CheckBox) findViewById(R.id.question3a);
        CheckBox question3b = (CheckBox) findViewById(R.id.question3b);
        CheckBox question3c = (CheckBox) findViewById(R.id.question3c);
        CheckBox question3d = (CheckBox) findViewById(R.id.question3d);
        if (question3a.isChecked() && question3b.isChecked() && question3c.isChecked() && !question3d.isChecked()) {
            a++;
        }
        /**
         * Question 4
         */
        CheckBox question4a = (CheckBox) findViewById(R.id.question4a);
        CheckBox question4b = (CheckBox) findViewById(R.id.question4b);
        CheckBox question4c = (CheckBox) findViewById(R.id.question4c);
        CheckBox question4d = (CheckBox) findViewById(R.id.question4d);

        if (question4a.isChecked() && question4c.isChecked() && !question4b.isChecked() && !question4d.isChecked()) {
            a++;
        }

        //Setting toast with number of points and making button "Result" invisible
        Toast.makeText(this, "Your score:" + a + "/4", Toast.LENGTH_LONG).show();
        final Button resultBt = (Button) findViewById(R.id.warmResultBt);
        resultBt.setVisibility(View.INVISIBLE);

        //Making button "Next" Visible and setting Intent for new activity
        Button nextQuestions = (Button) findViewById(R.id.nextQuestions);
        nextQuestions.setVisibility(View.VISIBLE);
        nextQuestions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Warmup.this, BeforeTest.class);
                startActivity(i);
            }
        });
    }
}
