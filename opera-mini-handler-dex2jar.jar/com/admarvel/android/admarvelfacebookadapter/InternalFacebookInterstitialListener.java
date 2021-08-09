// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.admarvel.android.admarvelfacebookadapter;

import com.admarvel.android.ads.AdMarvelUtils;
import com.facebook.ads.AdError;
import com.admarvel.android.ads.AdMarvelUtils$SDKAdNetwork;
import com.admarvel.android.util.Logging;
import com.facebook.ads.Ad;
import com.facebook.ads.InterstitialAd;
import com.admarvel.android.ads.AdMarvelAd;
import com.admarvel.android.ads.AdMarvelInterstitialAdapterListener;
import java.lang.ref.WeakReference;
import com.facebook.ads.InterstitialAdListener;

public class InternalFacebookInterstitialListener implements InterstitialAdListener
{
    private final WeakReference adMarvelAdReference;
    private WeakReference adMarvelInterstitialAdapterListenerReference;
    private final WeakReference interstitialAdReference;
    
    public InternalFacebookInterstitialListener(final AdMarvelInterstitialAdapterListener adMarvelInterstitialAdapterListener, final AdMarvelAd adMarvelAd, final InterstitialAd interstitialAd) {
        this.adMarvelInterstitialAdapterListenerReference = new WeakReference((T)adMarvelInterstitialAdapterListener);
        this.adMarvelAdReference = new WeakReference((T)adMarvelAd);
        this.interstitialAdReference = new WeakReference((T)interstitialAd);
    }
    
    @Override
    public void onAdClicked(final Ad ad) {
        if (this.adMarvelInterstitialAdapterListenerReference != null && this.adMarvelInterstitialAdapterListenerReference.get() != null) {
            ((AdMarvelInterstitialAdapterListener)this.adMarvelInterstitialAdapterListenerReference.get()).onClickInterstitialAd("");
            Logging.log("Facebook SDK : onAdClicked");
            return;
        }
        Logging.log("Facebook SDK : onAdClicked No listener found");
    }
    
    @Override
    public void onAdLoaded(final Ad ad) {
        final AdMarvelAd adMarvelAd = (AdMarvelAd)this.adMarvelAdReference.get();
        if (this.adMarvelInterstitialAdapterListenerReference != null && this.adMarvelInterstitialAdapterListenerReference.get() != null && adMarvelAd != null) {
            ((AdMarvelInterstitialAdapterListener)this.adMarvelInterstitialAdapterListenerReference.get()).onReceiveInterstitialAd(AdMarvelUtils$SDKAdNetwork.FACEBOOK, adMarvelAd.getPubId(), adMarvelAd);
            Logging.log("Facebook SDK : onAdLoaded");
            return;
        }
        Logging.log("Facebook SDK : onAdLoaded No listenr found");
    }
    
    @Override
    public void onError(final Ad ad, final AdError adError) {
        final AdMarvelAd adMarvelAd = (AdMarvelAd)this.adMarvelAdReference.get();
        if (this.adMarvelInterstitialAdapterListenerReference != null && this.adMarvelInterstitialAdapterListenerReference.get() != null && adMarvelAd != null) {
            ((AdMarvelInterstitialAdapterListener)this.adMarvelInterstitialAdapterListenerReference.get()).onFailedToReceiveInterstitialAd(AdMarvelUtils$SDKAdNetwork.FACEBOOK, adMarvelAd.getPubId(), 205, AdMarvelUtils.getErrorReason(205), adMarvelAd);
            Logging.log("Facebook SDK : onError");
            return;
        }
        Logging.log("Facebook SDK : onError No listenr found");
    }
    
    @Override
    public void onInterstitialDismissed(final Ad ad) {
        if (this.interstitialAdReference != null) {
            final InterstitialAd interstitialAd = (InterstitialAd)this.interstitialAdReference.get();
            if (interstitialAd != null) {
                interstitialAd.destroy();
            }
        }
        if (this.adMarvelInterstitialAdapterListenerReference != null && this.adMarvelInterstitialAdapterListenerReference.get() != null) {
            ((AdMarvelInterstitialAdapterListener)this.adMarvelInterstitialAdapterListenerReference.get()).onCloseInterstitialAd();
            Logging.log("Facebook SDK : onAdDismissed");
            return;
        }
        Logging.log("Facebook SDK : onAdDismissed No listenr found");
    }
    
    @Override
    public void onInterstitialDisplayed(final Ad ad) {
        Logging.log("Facebook SDK : onInterstitialDisplayed");
    }
}
