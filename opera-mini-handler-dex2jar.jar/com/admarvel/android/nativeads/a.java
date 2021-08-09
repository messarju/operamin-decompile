// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.admarvel.android.nativeads;

import com.admarvel.android.ads.AdMarvelUtils$AdMArvelErrorReason;
import java.util.Map;
import android.content.Context;
import com.admarvel.android.ads.AdMarvelAnalyticsAdapterInstances;
import com.admarvel.android.util.Logging;

public class a
{
    private AdMarvelNativeAd$AdMarvelNativeAdListener a;
    
    public void a() {
        if (this.a != null) {
            Logging.log("onRequestInterstitialAd");
            this.a.onRequestNativeAd();
        }
    }
    
    public void a(final AdMarvelNativeAd$AdMarvelNativeAdListener a) {
        this.a = a;
    }
    
    public void a(final AdMarvelNativeAd adMarvelNativeAd) {
        final Context getmContext = adMarvelNativeAd.getmContext();
        final String siteId = adMarvelNativeAd.getSiteId();
        final int id = adMarvelNativeAd.getId();
        final String ipAddress = adMarvelNativeAd.getIpAddress();
        final Map targetParams = adMarvelNativeAd.getTargetParams();
        while (true) {
            try {
                AdMarvelAnalyticsAdapterInstances.getInstance("com.admarvel.android.admarvelmologiqadapter.AdMarvelMologiqAdapter", getmContext).onReceiveAd(siteId, id, targetParams, ipAddress);
                if (this.a != null) {
                    Logging.log("onReceiveNativeAd");
                    this.a.onReceiveNativeAd(adMarvelNativeAd);
                }
            }
            catch (Exception ex) {
                continue;
            }
            break;
        }
    }
    
    public void a(final AdMarvelNativeAd adMarvelNativeAd, final int n, final AdMarvelUtils$AdMArvelErrorReason adMarvelUtils$AdMArvelErrorReason) {
        final Context getmContext = adMarvelNativeAd.getmContext();
        final String siteId = adMarvelNativeAd.getSiteId();
        final int id = adMarvelNativeAd.getId();
        final String ipAddress = adMarvelNativeAd.getIpAddress();
        final Map targetParams = adMarvelNativeAd.getTargetParams();
        while (true) {
            if (getmContext == null) {
                break Label_0053;
            }
            try {
                AdMarvelAnalyticsAdapterInstances.getInstance("com.admarvel.android.admarvelmologiqadapter.AdMarvelMologiqAdapter", getmContext).onFailedToReceiveAd(siteId, id, targetParams, ipAddress);
                if (this.a != null) {
                    Logging.log("onFailedToReceiveNativeAd : Error Code " + n);
                    this.a.onFailedToReceiveNativeAd(n, adMarvelUtils$AdMArvelErrorReason, adMarvelNativeAd);
                }
            }
            catch (Exception ex) {
                continue;
            }
            break;
        }
    }
}
