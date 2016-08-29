package com.udacity.gradle.backend;

/**
 * The object model for the data we are sending through endpoints
 */
public class Joke {

    private String text;

    public String getJokeText() {
        return this.text;
    }

    public void setJokeText(String text) {
        this.text = text;
    }
}