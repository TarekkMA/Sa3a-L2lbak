package com.example;

import java.util.Collections;

import static com.example.JokeList.JOKES;

public class JokeSimth {
  private final String deviceUUID;

  public JokeSimth(String deviceUUID) {
    this.deviceUUID = deviceUUID;
  }

  public Joke getJoke(){
    Collections.shuffle(JOKES);
    String jokeText = JOKES.get(0);
    return new Joke(jokeText);
  }

}
