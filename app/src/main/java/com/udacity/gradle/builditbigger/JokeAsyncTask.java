package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.udacity.gradle.backend.com.udacity.gradle.backend.jokeApi.JokeApi;

import java.io.IOException;

/**
 * Created by AENAYA on 20/08/2016.
 */
public class JokeAsyncTask extends AsyncTask<Context, Void, String> {

    private static JokeApi mJokeApi = null;
    private Context mContext;

    @Override
    protected String doInBackground(Context... contexts) {

        if (mJokeApi == null) {
            JokeApi.Builder builder = new JokeApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    .setRootUrl("http://192.168.1.109:8080/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> request) throws IOException {
                            request.setDisableGZipContent(true);
                        }
                    });
            mJokeApi = builder.build();
        }
        try {
            return mJokeApi.tellJoke().execute().getJokeText();
        } catch (IOException ioex) {
            return "";
        }
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);

        Log.d("Joke", s);

    }
}
