package com.example.android.fourtemperaments;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    @Override
    public void onBackPressed() {
    }

    Button sendToMe, sendYou, udacityForum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Intent mIntent = getIntent();
        int scoreA = mIntent.getIntExtra("scoreA", 0);
        int scoreB = mIntent.getIntExtra("scoreB", 0);
        int scoreC = mIntent.getIntExtra("scoreC", 0);
        int scoreD = mIntent.getIntExtra("scoreD", 0);
        String name = mIntent.getStringExtra("name");
        int udacity = mIntent.getIntExtra("udacity", 0);
        int sex = mIntent.getIntExtra("sex", 0);
        int yesNo = mIntent.getIntExtra("yesNo", 0);
        int age = mIntent.getIntExtra("age", 0);

        //Test result (one or two temperaments)
        TextView answersTextView = (TextView) findViewById(R.id.resultTxt);
        answersTextView.setText(resultMessage(scoreA, scoreB, scoreC, scoreD));

        //player name
        TextView yourInfo = (TextView) findViewById(R.id.name);
        yourInfo.setText(resultInfo(name, sex, yesNo, age, udacity));

        final String mailInf = resultInfo(name, sex, yesNo, age, udacity);
        final String mailRes = resultMessage(scoreA, scoreB, scoreC, scoreD);
        sendToMe = (Button) findViewById(R.id.sendMe);
        sendToMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto:lukaszgo3@gmail.com")); // only email apps should handle this
                intent.putExtra(Intent.EXTRA_SUBJECT, "Four Temperaments");
                intent.putExtra(intent.EXTRA_TEXT, mailInf + "\n" + mailRes);
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
            }
        });

        sendYou = (Button) findViewById(R.id.sendYou);
        sendYou.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto: ")); // only email apps should handle this
                intent.putExtra(Intent.EXTRA_SUBJECT, "Four Temperaments");
                intent.putExtra(intent.EXTRA_TEXT, mailInf + "\n" + mailRes);
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
            }
        });


        udacityForum = (Button) findViewById(R.id.udacityFor);
        if (udacity == 1) {
            udacityForum.setVisibility(View.VISIBLE);
            ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
            ClipData clip = ClipData.newPlainText("label", mailInf + "\n" + mailRes);
            clipboard.setPrimaryClip(clip);
        }
        udacityForum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "https://discussions.udacity.com/t/four-temperaments-quiz-test/227266";
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(browserIntent);
            }
        });
    }

    private String resultInfo(String name, int sex, int yesNo, int age, int udacity) {
        String infoMsg = getString(R.string.name) + name + "\n" + "\n";

        if (udacity == 1) {
            infoMsg += getString(R.string.uCityStudent) + getString(R.string.yes) + "\n" + "\n";
        } else infoMsg += getString(R.string.uCityStudent) + getString(R.string.no) + "\n" + "\n";

        if (sex == 1) {
            infoMsg += getString(R.string.sex) + getString(R.string.woman) + "\n" + "\n";

        } else infoMsg += getString(R.string.sex) + getString(R.string.man) + "\n" + "\n";

        if (age == 1) {
            infoMsg += getString(R.string.age) + getString(R.string.age17) + "\n" + "\n";

        }
        if (age == 2) {
            infoMsg += getString(R.string.age) + "18-24" + "\n" + "\n";

        }
        if (age == 3) {
            infoMsg += getString(R.string.age) + "25-30" + "\n" + "\n";

        }
        if (age == 4) {
            infoMsg += getString(R.string.age) + "31-35" + "\n" + "\n";

        }
        if (age == 5) {
            infoMsg += getString(R.string.age) + "36-40" + "\n" + "\n";

        }
        if (age == 6) {
            infoMsg += getString(R.string.age) + "40+" + "\n" + "\n";
        }

        if (yesNo == 1) {
            infoMsg += getString(R.string.experience) + getString(R.string.yes) + "\n";

        } else infoMsg += getString(R.string.experience) + getString(R.string.no) + "\n";

        return infoMsg;
    }

    private String resultMessage(int scoreA, int scoreB, int scoreC, int scoreD) {
        String tempMsg = "";

        if (scoreA == scoreB && scoreA == scoreC && scoreA == scoreD) {
            tempMsg += getString(R.string.Points);
            return tempMsg;
        }
        if (scoreA == scoreB && scoreA == scoreC && scoreA > scoreD) {
            tempMsg += getString(R.string.Points);
            return tempMsg;
        }
        if (scoreA == scoreB && scoreA == scoreD && scoreA > scoreC) {
            tempMsg += getString(R.string.Points);
            return tempMsg;
        }
        if (scoreA == scoreC && scoreA == scoreD && scoreA > scoreB) {
            tempMsg += getString(R.string.Points);
            return tempMsg;
        }
        if (scoreB == scoreC && scoreB == scoreD && scoreB > scoreA) {
            tempMsg += getString(R.string.Points);
            return tempMsg;
        }
        if (scoreA >= scoreB && scoreA >= scoreC && scoreA >= scoreD) {

            TextView answersTextViewA = (TextView) findViewById(R.id.resultTitle);
            answersTextViewA.setText(R.string.sanguine);

            if (scoreA > scoreB && scoreA > scoreC && scoreA > scoreD) {
                tempMsg += getString(R.string.sanguineTxt);
                return tempMsg;
            }

            if (scoreA == scoreB) {
                tempMsg += getString(R.string.sanguineTxt) + "\n";

                TextView answersTextViewB = (TextView) findViewById(R.id.resultTitle2);
                answersTextViewB.setText(R.string.choleric);

                TextView answersTextView = (TextView) findViewById(R.id.resultTxt2);
                answersTextView.setText(R.string.cholericTxt);
                return tempMsg;
            }

            if (scoreA == scoreC) {
                tempMsg += getString(R.string.sanguineTxt) + "\n";

                TextView answersTextViewC = (TextView) findViewById(R.id.resultTitle2);
                answersTextViewC.setText(R.string.melancholic);

                TextView answersTextView = (TextView) findViewById(R.id.resultTxt2);
                answersTextView.setText(R.string.melancholicTxt);
                return tempMsg;
            }
            if (scoreA == scoreD) {
                tempMsg += getString(R.string.sanguineTxt) + "\n";

                TextView answersTextViewD = (TextView) findViewById(R.id.resultTitle2);
                answersTextViewD.setText(R.string.phlegmatic);

                TextView answersTextView = (TextView) findViewById(R.id.resultTxt2);
                answersTextView.setText(R.string.phlegmaticTxt);

                return tempMsg;
            }
            return tempMsg;
        }
        if (scoreB >= scoreA && scoreB >= scoreC && scoreB >= scoreD) {

            TextView answersTextViewA = (TextView) findViewById(R.id.resultTitle);
            answersTextViewA.setText(R.string.choleric);

            if (scoreB > scoreA && scoreB > scoreC && scoreB > scoreD) {
                tempMsg += getString(R.string.cholericTxt);
                return tempMsg;
            }
            if (scoreB == scoreC) {
                tempMsg += getString(R.string.cholericTxt) + "\n";

                TextView answersTextViewC = (TextView) findViewById(R.id.resultTitle2);
                answersTextViewC.setText(R.string.melancholic);

                TextView answersTextView = (TextView) findViewById(R.id.resultTxt2);
                answersTextView.setText(R.string.melancholicTxt);
                return tempMsg;
            }
            if (scoreB == scoreD) {
                tempMsg += getString(R.string.cholericTxt) + "\n";

                TextView answersTextViewD = (TextView) findViewById(R.id.resultTitle2);
                answersTextViewD.setText(R.string.phlegmatic);

                TextView answersTextView = (TextView) findViewById(R.id.resultTxt2);
                answersTextView.setText(R.string.phlegmaticTxt);
                return tempMsg;
            }
            return tempMsg;

        }
        if (scoreC >= scoreA && scoreC >= scoreB && scoreC >= scoreD) {

            TextView answersTextViewA = (TextView) findViewById(R.id.resultTitle);
            answersTextViewA.setText(R.string.melancholic);

            if (scoreC > scoreA && scoreC > scoreB && scoreC > scoreD) {
                tempMsg += getString(R.string.melancholicTxt);
                return tempMsg;
            }
            if (scoreC == scoreD) {
                tempMsg += getString(R.string.melancholicTxt) + "\n";

                TextView answersTextViewD = (TextView) findViewById(R.id.resultTitle2);
                answersTextViewD.setText(R.string.phlegmatic);

                TextView answersTextView = (TextView) findViewById(R.id.resultTxt2);
                answersTextView.setText(R.string.phlegmaticTxt);
                return tempMsg;
            }
            return tempMsg;
        }
        if (scoreD > scoreA && scoreD > scoreB && scoreD > scoreC) {

            TextView answersTextViewA = (TextView) findViewById(R.id.resultTitle);
            answersTextViewA.setText(R.string.phlegmatic);

            tempMsg += getString(R.string.phlegmaticTxt);
            return tempMsg;
        }
        return tempMsg;
    }

    public void mainMenu(View v) {
        Intent i = new Intent(this, MainMenu.class);
        finish();
        startActivity(i);
    }
}
