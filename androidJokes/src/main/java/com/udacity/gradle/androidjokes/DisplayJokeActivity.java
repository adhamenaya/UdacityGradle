package com.udacity.gradle.androidjokes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayJokeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(getIntent().getExtras()!=null){
            String jokText = getIntent().getExtras().getString("joke");
           // TextView textView  (TextView) findViewById(R.id.text_joke);

        }
    }
}
