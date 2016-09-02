package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.test.AndroidTestCase;
import android.util.Pair;
import android.widget.ProgressBar;

/**
 * Created by AENAYA on 30/08/2016.
 */
public class AsyncTaskTest extends AndroidTestCase {

    public void testNonEmptyString() {

        JokeAsyncTask task = new JokeAsyncTask();
        String testResult = task.doInBackground(new Pair<Context, ProgressBar>(getContext(), null));

        assertFalse(testResult.equals(""));
    }
}
