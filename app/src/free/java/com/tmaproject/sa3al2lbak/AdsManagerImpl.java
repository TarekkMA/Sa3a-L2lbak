package com.tmaproject.sa3al2lbak;

import android.content.Context;
import android.view.View;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.tmaproject.sa3al2lbak.AdsManager;

/**
 * Created by TarekLMA on 7/4/17.
 * tarekkma@gmail.com
 */

public class AdsManagerImpl extends AdsManager {

  private boolean init = false;

  @Override
  public void setUpAds(Context context) {
    if (!init) {
      init = true;
      MobileAds.initialize(context, "ca-app-pub-3510598204121240~8229965511");
    }
  }

  @Override
  public void displayAd(View adView) {
    if (adView != null) ((AdView) adView).loadAd(new AdRequest.Builder().build());
  }

  @Override public void displayInterstitialAd(Context context) {
    final InterstitialAd interstitialAd = new InterstitialAd(context);
    interstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
    interstitialAd.loadAd(new AdRequest.Builder().build());
    interstitialAd.setAdListener(new AdListener() {
      @Override public void onAdLoaded() {
        super.onAdLoaded();
        interstitialAd.show();
      }
    });

  }

  @Override protected View getBannerView(Context context) {
    AdView adView = new AdView(context);
    adView.setAdSize(AdSize.SMART_BANNER);
    adView.setAdUnitId("ca-app-pub-3940256099942544/6300978111");
    displayAd(adView);
    return adView;
  }
}
