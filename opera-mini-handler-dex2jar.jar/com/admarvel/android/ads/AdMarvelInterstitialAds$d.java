// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.admarvel.android.ads;

import android.os.Handler;
import android.os.Looper;
import com.admarvel.android.util.e;
import android.content.Context;
import java.lang.ref.WeakReference;

class AdMarvelInterstitialAds$d implements AdMarvelInterstitialAdapterListener
{
    private final WeakReference a;
    private WeakReference b;
    private AdMarvelAd c;
    
    public AdMarvelInterstitialAds$d(final AdMarvelInterstitialAds adMarvelInterstitialAds) {
        this.a = new WeakReference((T)adMarvelInterstitialAds);
    }
    
    public void a(final AdMarvelAd c) {
        this.c = c;
        this.b = new WeakReference((T)c);
    }
    
    @Override
    public void onClickInterstitialAd(final String s) {
        final AdMarvelAd adMarvelAd = (AdMarvelAd)this.b.get();
        final AdMarvelInterstitialAds adMarvelInterstitialAds = (AdMarvelInterstitialAds)this.a.get();
        if (adMarvelInterstitialAds != null && adMarvelInterstitialAds.contextReference != null && adMarvelInterstitialAds.contextReference.get() != null && adMarvelAd != null) {
            final Context context = (Context)adMarvelInterstitialAds.contextReference.get();
            if (context != null && AdMarvelInterstitialAds.listener != null) {
                AdMarvelInterstitialAds.listener.a(context, s, adMarvelAd.getSiteId(), adMarvelAd.getId(), adMarvelAd.getTargetParams(), adMarvelAd.getIpAddress());
            }
        }
    }
    
    @Override
    public void onCloseInterstitialAd() {
        if (AdMarvelInterstitialAds.listener != null) {
            AdMarvelInterstitialAds.listener.b();
        }
    }
    
    @Override
    public void onFailedToReceiveInterstitialAd(final AdMarvelUtils$SDKAdNetwork adMarvelUtils$SDKAdNetwork, final String s, final int n, final AdMarvelUtils$ErrorReason adMarvelUtils$ErrorReason, final AdMarvelAd adMarvelAd) {
        final AdMarvelInterstitialAds adMarvelInterstitialAds = (AdMarvelInterstitialAds)this.a.get();
        if (adMarvelInterstitialAds != null) {
            int n2 = 0;
            Label_0220: {
                if (adMarvelAd.getRetry().equals(true)) {
                    n2 = n2;
                    if (adMarvelAd.getRetrynum() <= adMarvelAd.getMaxretries()) {
                        final int n3 = adMarvelAd.getRetrynum() + 1;
                        final String excluded = adMarvelAd.getExcluded();
                        String s2;
                        if (adMarvelAd.getExcluded() != null && adMarvelAd.getExcluded().length() > 0) {
                            s2 = excluded + "," + adMarvelAd.getBannerid();
                        }
                        else {
                            s2 = adMarvelAd.getBannerid();
                        }
                        if (adMarvelInterstitialAds.contextReference != null && adMarvelInterstitialAds.contextReference.get() != null) {
                            if (Version.getAndroidSDKVersion() >= 11) {
                                e.a().b().execute(new AdMarvelInterstitialAds$b(adMarvelAd.getTargetParams(), adMarvelAd.getPartnerId(), adMarvelAd.getSiteId(), adMarvelAd.getAndroidId(), adMarvelAd.getOrientation(), adMarvelAd.getDeviceConnectivity(), adMarvelInterstitialAds, n3, s2, (Context)adMarvelInterstitialAds.contextReference.get()));
                                n2 = 1;
                                break Label_0220;
                            }
                            new Handler(Looper.getMainLooper()).post((Runnable)new AdMarvelInterstitialAds$a(adMarvelAd.getTargetParams(), adMarvelAd.getPartnerId(), adMarvelAd.getSiteId(), adMarvelAd.getAndroidId(), adMarvelAd.getOrientation(), adMarvelAd.getDeviceConnectivity(), adMarvelInterstitialAds, n3, s2, (Context)adMarvelInterstitialAds.contextReference.get()));
                        }
                        n2 = 1;
                    }
                }
            }
            if (n2 == 0 && adMarvelInterstitialAds.contextReference != null) {
                final Context context = (Context)adMarvelInterstitialAds.contextReference.get();
                if (context != null && AdMarvelInterstitialAds.listener != null) {
                    AdMarvelInterstitialAds.listener.a(context, adMarvelUtils$SDKAdNetwork, s, n, adMarvelUtils$ErrorReason, adMarvelAd.getSiteId(), adMarvelAd.getId(), adMarvelAd.getTargetParams(), adMarvelAd.getIpAddress());
                }
            }
        }
    }
    
    @Override
    public void onReceiveInterstitialAd(final AdMarvelUtils$SDKAdNetwork adMarvelUtils$SDKAdNetwork, final String s, final AdMarvelAd adMarvelAd) {
        final AdMarvelInterstitialAds adMarvelInterstitialAds = (AdMarvelInterstitialAds)this.a.get();
        if (adMarvelInterstitialAds != null && adMarvelInterstitialAds.contextReference != null && adMarvelInterstitialAds.contextReference.get() != null) {
            final Context context = (Context)adMarvelInterstitialAds.contextReference.get();
            if (context != null && AdMarvelInterstitialAds.listener != null) {
                AdMarvelInterstitialAds.listener.a(context, adMarvelUtils$SDKAdNetwork, s, adMarvelAd, adMarvelAd.getSiteId(), adMarvelAd.getId(), adMarvelAd.getTargetParams(), adMarvelAd.getIpAddress());
            }
        }
    }
    
    @Override
    public void onRequestInterstitialAd() {
        if (AdMarvelInterstitialAds.listener != null) {
            AdMarvelInterstitialAds.listener.a();
        }
    }
}
