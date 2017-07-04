package com.tmaproject.sa3al2lbak;

import android.app.Application;

/**
 * Created by TarekLMA on 7/4/17.
 * tarekkma@gmail.com
 */

public class App extends Application {
  @Override public void onCreate() {
    super.onCreate();
    new AdsManagerImpl().setUpAds(this);
  }
}
