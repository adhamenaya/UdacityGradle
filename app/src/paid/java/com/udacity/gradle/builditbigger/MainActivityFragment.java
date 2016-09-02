package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;

import com.udacity.gradle.backend.com.udacity.gradle.backend.jokeApi.JokeApi;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    private static JokeApi mJokeApi = null;
    private ProgressBar mProgressBar;
    private Button mButton;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);

        mButton = (Button) root.findViewById(R.id.button_joke);
        mProgressBar = (ProgressBar) root.findViewById(R.id.progressBar);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tellJoke();
            }
        });

        return root;
    }

    public void tellJoke() {
        JokeAsyncTask task = new JokeAsyncTask();
        task.execute(new Pair<Context, ProgressBar>(getContext(), mProgressBar));
    }
}

