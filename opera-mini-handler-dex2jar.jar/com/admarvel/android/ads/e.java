// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.admarvel.android.ads;

import java.util.HashMap;
import java.util.Map;
import android.content.Context;
import com.admarvel.android.util.Logging;

public class e
{
    private AdMarvelInterstitialAds$AdMarvelInterstitialAdListener a;
    
    public void a() {
        if (this.a != null) {
            Logging.log("onRequestInterstitialAd");
            this.a.onRequestInterstitialAd();
        }
    }
    
    public void a(final Context context, final AdMarvelUtils$SDKAdNetwork adMarvelUtils$SDKAdNetwork, final String s, final int n, final AdMarvelUtils$ErrorReason adMarvelUtils$ErrorReason, final String s2, final int n2, final Map map, final String s3) {
        while (true) {
            try {
                final AdMarvelAnalyticsAdapter instance = AdMarvelAnalyticsAdapterInstances.getInstance("com.admarvel.android.admarvelmologiqadapter.AdMarvelMologiqAdapter", context);
                Map map2 = map;
                if (map == null) {
                    map2 = new HashMap();
                }
                instance.onFailedToReceiveAd(s2, n2, map2, s3);
                if (this.a != null) {
                    Logging.log("onFailedToReceiveInterstitialAd : Error Code " + n);
                    this.a.onFailedToReceiveInterstitialAd(adMarvelUtils$SDKAdNetwork, s, n, adMarvelUtils$ErrorReason);
                }
            }
            catch (Exception ex) {
                continue;
            }
            break;
        }
    }
    
    public void a(final Context context, final AdMarvelUtils$SDKAdNetwork adMarvelUtils$SDKAdNetwork, final String s, final AdMarvelAd adMarvelAd, final String s2, final int n, final Map map, final String s3) {
        while (true) {
            try {
                final AdMarvelAnalyticsAdapter instance = AdMarvelAnalyticsAdapterInstances.getInstance("com.admarvel.android.admarvelmologiqadapter.AdMarvelMologiqAdapter", context);
                Map map2 = map;
                if (map == null) {
                    map2 = new HashMap();
                }
                instance.onReceiveAd(s2, n, map2, s3);
                if (this.a != null) {
                    Logging.log("onReceiveInterstitialAd");
                    this.a.onReceiveInterstitialAd(adMarvelUtils$SDKAdNetwork, s, adMarvelAd);
                }
            }
            catch (Exception ex) {
                continue;
            }
            break;
        }
    }
    
    public void a(final Context context, final String s, final String s2, final int n, final Map map, final String s3) {
        while (true) {
            try {
                final AdMarvelAnalyticsAdapter instance = AdMarvelAnalyticsAdapterInstances.getInstance("com.admarvel.android.admarvelmologiqadapter.AdMarvelMologiqAdapter", context);
                HashMap hashMap;
                if (map == null) {
                    hashMap = new HashMap();
                }
                else {
                    hashMap = (HashMap)map;
                }
                instance.onAdClick(s2, n, hashMap, s, s3);
                if (this.a != null) {
                    Logging.log("onClickInterstitialAd");
                    this.a.onClickInterstitialAd(s);
                }
            }
            catch (Exception ex) {
                continue;
            }
            break;
        }
    }
    
    public void a(final AdMarvelActivity adMarvelActivity) {
        if (this.a != null) {
            Logging.log("onAdmarvelActivityLaunched");
            this.a.onAdmarvelActivityLaunched(adMarvelActivity);
        }
    }
    
    public void a(final AdMarvelInterstitialAds$AdMarvelInterstitialAdListener a) {
        this.a = a;
    }
    
    public void a(final AdMarvelVideoActivity adMarvelVideoActivity) {
        if (this.a != null) {
            Logging.log("onAdMarvelVideoActivityLaunched");
            this.a.onAdMarvelVideoActivityLaunched(adMarvelVideoActivity);
        }
    }
    
    public boolean b() {
        if (this.a != null) {
            Logging.log("onCloseInterstitialAd");
            this.a.onCloseInterstitialAd();
            return true;
        }
        return false;
    }
}
