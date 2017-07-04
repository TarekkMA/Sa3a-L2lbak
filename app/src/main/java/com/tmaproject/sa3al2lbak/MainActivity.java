package com.tmaproject.sa3al2lbak;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.tmaproject.jokeinterfacelibrary.NewJokeActivity;

public class MainActivity extends AppCompatActivity {

  AdsManagerImpl adsManager;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    ButterKnife.bind(this);

    adsManager = new AdsManagerImpl();
    View bannerView = adsManager.getBannerView(this);
    if(bannerView!=null) {
      ((FrameLayout) findViewById(R.id.adContainer)).addView(bannerView);
      adsManager.displayAd(bannerView);
    }
  }


  public void getJoke(View view) {
    adsManager.displayInterstitialAd(getApplicationContext());
    Intent intent = new Intent(this, NewJokeActivity.class);
    startActivity(intent);

  }
}
