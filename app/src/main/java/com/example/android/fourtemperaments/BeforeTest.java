package com.example.android.fourtemperaments;

import android.content.Intent;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class BeforeTest extends AppCompatActivity {

    private ArrayList<CompoundButton> buttons = new ArrayList<>();
    int sex, yesNo, age, buttonCheck;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_before_test);

        beforeButtons(R.id.woman, R.id.man, R.id.yes, R.id.no, R.id.age1, R.id.age2,
                R.id.age3, R.id.age4, R.id.age5, R.id.age6);
    }

    private void beforeButtons(@IdRes int... ids) {
        for (int id : ids) {
            CompoundButton cd = (CompoundButton) findViewById(id);
            buttons.add(cd);
        }
    }

    //  If checked do for Intent
    public void beforeTest(View v) {

        for (CompoundButton button : buttons) {


            if (button.getTag().equals("woman"))
                if (button.isChecked()) {
                    sex = 1;
                    buttonCheck++;
                }

            if (button.getTag().equals("man"))
                if (button.isChecked()) {
                    sex = 2;
                    buttonCheck++;
                }

            if (button.getTag().equals("yes"))
                if (button.isChecked()) {
                    yesNo = 1;
                    buttonCheck++;
                }
            if (button.getTag().equals("no"))
                if (button.isChecked()) {
                    yesNo = 2;
                    buttonCheck++;
                }

            if (button.getTag().equals("age1"))
                if (button.isChecked()) {
                    age = 1;
                    buttonCheck++;
                }

            if (button.getTag().equals("age2"))
                if (button.isChecked()) {
                    age = 2;
                    buttonCheck++;
                }

            if (button.getTag().equals("age3"))
                if (button.isChecked()) {
                    age = 3;
                    buttonCheck++;
                }

            if (button.getTag().equals("age4"))
                if (button.isChecked()) {
                    age = 4;
                    buttonCheck++;
                }

            if (button.getTag().equals("age5"))
                if (button.isChecked()) {
                    age = 5;
                    buttonCheck++;
                }

            if (button.getTag().equals("age6"))
                if (button.isChecked()) {
                    age = 6;
                    buttonCheck++;
                }
        }
        CheckBox udacity = (CheckBox) findViewById(R.id.udacityCheck);
        EditText yourName = (EditText) findViewById(R.id.yourName);

        if (yourName.getText().length() <= 2) {
            Toast toast = Toast.makeText(this, R.string.enterYourName, Toast.LENGTH_SHORT);
            LinearLayout toastLayout = (LinearLayout) toast.getView();
            TextView toastTV = (TextView) toastLayout.getChildAt(0);
            if (toastTV != null) toastTV.setGravity(Gravity.CENTER);
            toast.setGravity(Gravity.CENTER | Gravity.CENTER_VERTICAL, 0, 0);
            toastTV.setTextSize(30);
            toast.show();
        }
        if (buttonCheck <= 2) {
            buttonCheck = 0;
            Toast toast = Toast.makeText(this, R.string.buttonAnswer, Toast.LENGTH_SHORT);
            LinearLayout toastLayout = (LinearLayout) toast.getView();
            TextView toastTV = (TextView) toastLayout.getChildAt(0);
            if (toastTV != null) toastTV.setGravity(Gravity.CENTER);
            toastTV.setTextSize(30);
            toast.show();
        }
        if (yourName.getText().length() >= 3 && buttonCheck == 3) {

            String name = yourName.getText().toString();
            Intent i = new Intent(this, MainActivity.class);
            i.putExtra("name", name);
            i.putExtra("sex", sex);
            i.putExtra("yesNo", yesNo);
            i.putExtra("age", age);
            if (udacity.isChecked()) {
                i.putExtra("udacity", 1);
            }
            finish();
            startActivity(i);
        }

    }

}
