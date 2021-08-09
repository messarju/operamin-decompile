// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.admarvel.android.ads;

import java.util.HashMap;
import java.util.Map;
import android.content.Context;
import com.admarvel.android.util.Logging;

public class l
{
    private AdMarvelView$AdMarvelViewListener a;
    private AdMarvelView$AdMarvelViewExtendedListener b;
    
    public void a() {
        if (this.a != null) {
            Logging.log("onExpand");
            this.a.onExpand();
            return;
        }
        Logging.log("onExpand - No listener found");
    }
    
    public void a(final Context context, final AdMarvelView adMarvelView, final int n, final AdMarvelUtils$ErrorReason adMarvelUtils$ErrorReason, final String s, final int n2, final Map map, final String s2) {
        while (true) {
            try {
                final AdMarvelAnalyticsAdapter instance = AdMarvelAnalyticsAdapterInstances.getInstance("com.admarvel.android.admarvelmologiqadapter.AdMarvelMologiqAdapter", context);
                Map map2 = map;
                if (map == null) {
                    map2 = new HashMap();
                }
                instance.onFailedToReceiveAd(s, n2, map2, s2);
                if (this.a != null) {
                    Logging.log("onFailedToReceiveAd : Error Code " + n);
                    this.a.onFailedToReceiveAd(adMarvelView, n, adMarvelUtils$ErrorReason);
                    return;
                }
                Logging.log("onFailedToReceiveAd - No listener found");
            }
            catch (Exception ex) {
                continue;
            }
            break;
        }
    }
    
    public void a(final Context context, final AdMarvelView adMarvelView, final String s, final int n, final Map map, final String s2) {
        while (true) {
            try {
                final AdMarvelAnalyticsAdapter instance = AdMarvelAnalyticsAdapterInstances.getInstance("com.admarvel.android.admarvelmologiqadapter.AdMarvelMologiqAdapter", context);
                Map map2 = map;
                if (map == null) {
                    map2 = new HashMap();
                }
                instance.onReceiveAd(s, n, map2, s2);
                if (this.a != null) {
                    Logging.log("onReceiveAd");
                    this.a.onReceiveAd(adMarvelView);
                    return;
                }
                Logging.log("onReceiveAd - No listener found");
            }
            catch (Exception ex) {
                continue;
            }
            break;
        }
    }
    
    public void a(final Context context, final AdMarvelView adMarvelView, final String s, final String s2, final int n, final Map map, final String s3) {
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
                    Logging.log("onClickAd");
                    this.a.onClickAd(adMarvelView, s);
                    return;
                }
                Logging.log("onClickAd - No listener found");
            }
            catch (Exception ex) {
                continue;
            }
            break;
        }
    }
    
    public void a(final AdMarvelView$AdMarvelViewExtendedListener b) {
        this.b = b;
    }
    
    public void a(final AdMarvelView$AdMarvelViewListener a) {
        this.a = a;
    }
    
    public void a(final AdMarvelView adMarvelView) {
        if (this.a != null) {
            Logging.log("onRequestAd");
            this.a.onRequestAd(adMarvelView);
            return;
        }
        Logging.log("onRequestAd - No listener found");
    }
    
    public void a(final AdMarvelView adMarvelView, final AdMarvelAd adMarvelAd) {
        if (this.b != null) {
            Logging.log("onAdFetched");
            this.b.onAdFetched(adMarvelView, adMarvelAd);
            return;
        }
        Logging.log("onAdFetched - No listener found");
    }
    
    public void b() {
        if (this.a != null) {
            Logging.log("onClose");
            this.a.onClose();
            return;
        }
        Logging.log("onClose - No listener found");
    }
    
    public void b(final Context context, final AdMarvelView adMarvelView, final String s, final int n, final Map map, final String s2) {
        while (true) {
            try {
                final AdMarvelAnalyticsAdapter instance = AdMarvelAnalyticsAdapterInstances.getInstance("com.admarvel.android.admarvelmologiqadapter.AdMarvelMologiqAdapter", context);
                Map map2 = map;
                if (map == null) {
                    map2 = new HashMap();
                }
                instance.onReceiveAd(s, n, map2, s2);
                if (this.b != null) {
                    Logging.log("onDisplayedAd");
                    this.b.onAdDisplayed(adMarvelView);
                    return;
                }
                Logging.log("onDisplayedAd - No listener found");
            }
            catch (Exception ex) {
                continue;
            }
            break;
        }
    }
}
