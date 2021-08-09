// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.admarvel.android.ads;

public interface AdMarvelInterstitialAds$AdMarvelInterstitialAdListener
{
    void onAdMarvelVideoActivityLaunched(final AdMarvelVideoActivity p0);
    
    void onAdmarvelActivityLaunched(final AdMarvelActivity p0);
    
    void onClickInterstitialAd(final String p0);
    
    void onCloseInterstitialAd();
    
    void onFailedToReceiveInterstitialAd(final AdMarvelUtils$SDKAdNetwork p0, final String p1, final int p2, final AdMarvelUtils$ErrorReason p3);
    
    void onReceiveInterstitialAd(final AdMarvelUtils$SDKAdNetwork p0, final String p1, final AdMarvelAd p2);
    
    void onRequestInterstitialAd();
}
