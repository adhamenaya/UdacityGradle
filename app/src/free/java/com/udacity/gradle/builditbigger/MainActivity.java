package com.udacity.gradle.builditbigger;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;


public class MainActivity extends ActionBarActivity implements MainActivityFragment.Callback {
    InterstitialAd mInterstitialAd;
    String jokeString = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initialize adMob
        MobileAds.initialize(getApplicationContext(), getResources().getString(R.string.banner_ad_unit_id));

        // Full screen ad
        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId(getResources().getString(R.string.banner_ad_unit_id));
        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                super.onAdClosed();
                requestNewInterstitial();
                startJokeActivity(getApplicationContext(), jokeString);
            }
        });

        requestNewInterstitial();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void startJokeActivity(Context context, String jokeString) {
        if (jokeString.equals("")) return;
        Intent intent = new Intent("com.udacity.gradle.androidjokes.DisplayJokeActivity");
        intent.putExtra("joke", jokeString);
        startActivity(intent);
    }

    private void requestNewInterstitial() {
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .addTestDevice("CBBB6DDE22934C86364EBBDF01A3BDFD")
                .build();

        mInterstitialAd.loadAd(adRequest);
    }

    public void showJokeOrAd(String jokeString) {
        this.jokeString = jokeString;
        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
            Log.d("show ad", "s------------");
        } else {
            startJokeActivity(getApplicationContext(), jokeString);
        }
    }
}
