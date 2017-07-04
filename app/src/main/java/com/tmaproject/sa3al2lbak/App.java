package com.tmaproject.sa3al2lbak;

import android.app.Application;
import com.google.android.gms.ads.MobileAds;

/**
 * Created by TarekLMA on 7/4/17.
 * tarekkma@gmail.com
 */

public class App extends Application {
  @Override public void onCreate() {
    super.onCreate();
    MobileAds.initialize(this, "ca-app-pub-3510598204121240~8229965511");
  }
}
