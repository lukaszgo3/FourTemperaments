package com.example.android.fourtemperaments;

import android.content.Intent;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    private ArrayList<CompoundButton> buttons = new ArrayList<>(40);
    private int scoreA, scoreB, scoreC, scoreD;

    @Override
    public void onBackPressed() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Button's IDs
        setupButtons(R.id.answer1, R.id.answer2, R.id.answer3, R.id.answer4,
                R.id.answer1a, R.id.answer2a, R.id.answer3a, R.id.answer4a,
                R.id.answer1b, R.id.answer2b, R.id.answer3b, R.id.answer4b,
                R.id.answer1c, R.id.answer2c, R.id.answer3c, R.id.answer4c,
                R.id.answer1d, R.id.answer2d, R.id.answer3d, R.id.answer4d,
                R.id.answer1e, R.id.answer2e, R.id.answer3e, R.id.answer4e,
                R.id.answer1f, R.id.answer2f, R.id.answer3f, R.id.answer4f,
                R.id.answer1g, R.id.answer2g, R.id.answer3g, R.id.answer4g,
                R.id.answer1h, R.id.answer2h, R.id.answer3h, R.id.answer4h,
                R.id.answer1i, R.id.answer2i, R.id.answer3i, R.id.answer4i,
                R.id.answer1j, R.id.answer2j, R.id.answer3j, R.id.answer4j,
                R.id.answer1k, R.id.answer2k, R.id.answer3k, R.id.answer4k,
                R.id.answer1l, R.id.answer2l, R.id.answer3l, R.id.answer4l,
                R.id.answer1m, R.id.answer2m, R.id.answer3m, R.id.answer4m,
                R.id.answer1n, R.id.answer2n, R.id.answer3n, R.id.answer4n,
                R.id.answer1o, R.id.answer2o, R.id.answer3o, R.id.answer4o,
                R.id.answer1p, R.id.answer2p, R.id.answer3p, R.id.answer4p,
                R.id.answer1r, R.id.answer2r, R.id.answer3r, R.id.answer4r,
                R.id.answer1s, R.id.answer2s, R.id.answer3s, R.id.answer4s,
                R.id.answer1t, R.id.answer2t, R.id.answer3t, R.id.answer4t,
                R.id.answer1u, R.id.answer2u, R.id.answer3u, R.id.answer4u,
                R.id.answer1w, R.id.answer2w, R.id.answer3w, R.id.answer4w,
                R.id.answer1x, R.id.answer2x, R.id.answer3x, R.id.answer4x,
                R.id.answer1y, R.id.answer2y, R.id.answer3y, R.id.answer4y,
                R.id.answer1z, R.id.answer2z, R.id.answer3z, R.id.answer4z,
                R.id.answer1aa, R.id.answer2aa, R.id.answer3aa, R.id.answer4aa,
                R.id.answer1ab, R.id.answer2ab, R.id.answer3ab, R.id.answer4ab,
                R.id.answer1ac, R.id.answer2ac, R.id.answer3ac, R.id.answer4ac,
                R.id.answer1ad, R.id.answer2ad, R.id.answer3ad, R.id.answer4ad,
                R.id.answer1ae, R.id.answer2ae, R.id.answer3ae, R.id.answer4ae,
                R.id.answer1af, R.id.answer2af, R.id.answer3af, R.id.answer4af,
                R.id.answer1ag, R.id.answer2ag, R.id.answer3ag, R.id.answer4ag,
                R.id.answer1ah, R.id.answer2ah, R.id.answer3ah, R.id.answer4ah,
                R.id.answer1ai, R.id.answer2ai, R.id.answer3ai, R.id.answer4ai,
                R.id.answer1aj, R.id.answer2aj, R.id.answer3aj, R.id.answer4aj,
                R.id.answer1ak, R.id.answer2ak, R.id.answer3ak, R.id.answer4ak,
                R.id.answer1al, R.id.answer2al, R.id.answer3al, R.id.answer4al,
                R.id.answer1am, R.id.answer2am, R.id.answer3am, R.id.answer4am,
                R.id.answer1an, R.id.answer2an, R.id.answer3an, R.id.answer4an,
                R.id.answer1ao, R.id.answer2ao, R.id.answer3ao, R.id.answer4ao);
    }

    private void setupButtons(@IdRes int... ids) {
        for (int id : ids) {
            CompoundButton cd = (CompoundButton) findViewById(id);
            buttons.add(cd);
        }
    }

    //Points by click button
    public void submitAnswer(View view) {

        for (CompoundButton button : buttons) {

            if (button.getTag().equals("A"))
                if (button.isChecked())
                    scoreA++;

            if (button.getTag().equals("B"))
                if (button.isChecked())
                    scoreB++;

            if (button.getTag().equals("C"))
                if (button.isChecked())
                    scoreC++;

            if (button.getTag().equals("D"))
                if (button.isChecked())
                    scoreD++;
        }

        int scoreAll;
        scoreAll = scoreA + scoreB + scoreC + scoreD;
        if (scoreAll >= 40) {

            Intent mIntent = getIntent();
            String name = mIntent.getStringExtra("name");
            int udacity = mIntent.getIntExtra("udacity", 0);
            int sex = mIntent.getIntExtra("sex", 0);
            int yesNo = mIntent.getIntExtra("yesNo", 0);
            int age = mIntent.getIntExtra("age", 0);

            Intent i = new Intent(this, ResultActivity.class);
            i.putExtra("scoreA", scoreA);
            i.putExtra("scoreB", scoreB);
            i.putExtra("scoreC", scoreC);
            i.putExtra("scoreD", scoreD);
            i.putExtra("udacity", udacity);
            i.putExtra("name", name);
            i.putExtra("sex", sex);
            i.putExtra("yesNo", yesNo);
            i.putExtra("age", age);
            finish();
            startActivity(i);

        } else {
            scoreA = 0;
            scoreB = 0;
            scoreC = 0;
            scoreD = 0;

            Toast toast = Toast.makeText(this, R.string.buttonAnswer, Toast.LENGTH_SHORT);
            LinearLayout toastLayout = (LinearLayout) toast.getView();
            TextView toastTV = (TextView) toastLayout.getChildAt(0);
            if (toastTV != null) toastTV.setGravity(Gravity.CENTER);
            toastTV.setTextSize(30);
            toast.show();

        }
    }
}


