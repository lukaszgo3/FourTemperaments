package com.example.android.fourtemperaments;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainMenu extends AppCompatActivity {

    @Override
    public void onBackPressed() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
    }

    public void play(View v) {
        Intent i = new Intent(this, BeforeTest.class);
        startActivity(i);

    }
    public void temperaments(View v) {
        Intent i = new Intent(this, Temperaments.class);
        startActivity(i);

    }public void about(View v) {
        Intent i = new Intent(this, About.class);
        startActivity(i);

    }

    public void exit(View v) {
        android.os.Process.killProcess(android.os.Process.myPid());
        this.finish();
        System.exit(0);
    }
}
