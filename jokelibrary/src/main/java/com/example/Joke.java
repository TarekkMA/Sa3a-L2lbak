package com.example;

/**
 * Created by TarekLMA on 7/4/17.
 * tarekkma@gmail.com
 */

public class Joke {
  private String joke;
  private String id;
  private int shownTimes;
  private boolean isFavored;
  private int likes;
  private int dislikes;

  public Joke(String joke, String id, int shownTimes, boolean isFavored, int likes, int dislikes) {
    this.joke = joke;
    this.id = id;
    this.shownTimes = shownTimes;
    this.isFavored = isFavored;
    this.likes = likes;
    this.dislikes = dislikes;
  }

  public Joke(String joke) {
    this.joke = joke;
  }

  public String getJoke() {
    return joke;
  }

  public void setJoke(String joke) {
    this.joke = joke;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public int getShownTimes() {
    return shownTimes;
  }

  public void setShownTimes(int shownTimes) {
    this.shownTimes = shownTimes;
  }

  public boolean isFavored() {
    return isFavored;
  }

  public void setFavored(boolean favored) {
    isFavored = favored;
  }

  public int getLikes() {
    return likes;
  }

  public void setLikes(int likes) {
    this.likes = likes;
  }

  public int getDislikes() {
    return dislikes;
  }

  public void setDislikes(int dislikes) {
    this.dislikes = dislikes;
  }
}
