package com.udacity.gradle.androidjokes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayJokeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_joke);

        if(getIntent().getExtras()!=null){
            String jokeText = getIntent().getExtras().getString("joke");
            TextView textView = (TextView) findViewById(R.id.text_joke);
            textView.setText(jokeText);
        }
    }
}
