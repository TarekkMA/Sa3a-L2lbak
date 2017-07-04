package com.example;

public class JokeSimth {
  private final String deviceUUID;

  public JokeSimth(String deviceUUID) {
    this.deviceUUID = deviceUUID;
  }

  public Joke getJoke(){
    Joke j = new Joke();
    j.setJoke("فيه وحدة تصلي دخلوا عليها اثنتين قالت الأولى للثانية شوفي البنت بتصلي بخشوع ازاي قامت ردت عليهم وكمان انا صايمة ..");
    return j;
  }

}
