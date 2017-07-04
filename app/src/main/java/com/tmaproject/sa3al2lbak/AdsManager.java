package com.tmaproject.sa3al2lbak;

import android.content.Context;
import android.view.View;

/**
 * Created by TarekLMA on 7/4/17.
 * tarekkma@gmail.com
 */

abstract public class AdsManager {

  abstract public void setUpAds(Context context);

  abstract public void displayAd(View adView);

  abstract public void displayInterstitialAd(Context context);

  protected abstract View getBannerView(Context context);
}
