// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.admarvel.android.nativeads;

import com.admarvel.android.ads.AdMarvelUtils;
import com.admarvel.android.util.Logging;
import com.admarvel.android.ads.AdMarvelXMLReader;
import com.admarvel.android.ads.AdMarvelUtils$AdMArvelErrorReason;
import com.admarvel.android.ads.AdMarvelAdapterInstances;
import com.admarvel.android.ads.AdFetcher$Adtype;
import com.admarvel.android.ads.AdFetcher;
import com.admarvel.android.ads.AdMarvelAnalyticsAdapterInstances;
import java.util.Map;
import android.content.Context;
import android.os.AsyncTask;

class b extends AsyncTask
{
    String a;
    private AdMarvelNativeAd b;
    
    b() {
        this.a = null;
    }
    
    private Map a(final Context context, final String s, final Map map) {
        try {
            final Map enhancedTargetParams = AdMarvelAnalyticsAdapterInstances.getInstance("com.admarvel.android.admarvelmologiqadapter.AdMarvelMologiqAdapter", context).getEnhancedTargetParams(s, map);
            if (enhancedTargetParams != null) {
                if (map == null) {
                    return enhancedTargetParams;
                }
                map.putAll(enhancedTargetParams);
            }
            return map;
        }
        catch (Exception ex) {
            return map;
        }
    }
    
    protected AdMarvelNativeAd a(final Object... array) {
        final AdMarvelNativeAd$RequestParameters adMarvelNativeAd$RequestParameters = (AdMarvelNativeAd$RequestParameters)array[0];
        this.b = (AdMarvelNativeAd)array[1];
        if (this.b == null) {
            return null;
        }
        final int intValue = (int)array[2];
        final String s = (String)array[3];
        final Map targetParams = adMarvelNativeAd$RequestParameters.getTargetParams();
        final String partnerId = adMarvelNativeAd$RequestParameters.getPartnerId();
        final String siteId = adMarvelNativeAd$RequestParameters.getSiteId();
        final Context getmContext = this.b.getmContext();
        if (getmContext == null) {
            return null;
        }
        final Map a = this.a(getmContext, siteId, targetParams);
        final AdFetcher adFetcher = new AdFetcher();
        try {
            this.a = adFetcher.fetchAd(AdFetcher$Adtype.NATIVE, getmContext, null, this.b.getOrientation(), this.b.getDeviceConnectivity(), a, partnerId, siteId, intValue, s, false, false, false, this.b.getAdMarvelNetworkHandler());
            if (this.a != null) {
                final AdMarvelXMLReader loadAd = this.b.loadAd(this.a);
                if (loadAd != null && this.b.getAdType() == AdMarvelNativeAd$AdType.SDKCALL && this.b.getSdkNetwork() != null && this.b.getSdkNetwork().length() > 0) {
                    AdMarvelAdapterInstances.getInstance(this.b.ADMARVEL_NATIVE_AD_GUID, this.b.getSdkNetwork()).loadNativeAd(this.b, loadAd);
                }
                return this.b;
            }
            final a listener = this.b.getListener();
            if (listener != null) {
                listener.a(this.b, AdMarvelUtils$AdMArvelErrorReason.AD_REQUEST_XML_PARSING_EXCEPTION.getErrorCode(), AdMarvelUtils$AdMArvelErrorReason.AD_REQUEST_XML_PARSING_EXCEPTION);
            }
        }
        catch (Exception ex) {
            this.b.setAdType(AdMarvelNativeAd$AdType.ERROR);
            this.b.setErrorCode(AdMarvelUtils$AdMArvelErrorReason.AD_REQUEST_XML_PARSING_EXCEPTION.getErrorCode());
            return this.b;
        }
        return null;
    }
    
    protected void a(final AdMarvelNativeAd adMarvelNativeAd) {
        if (adMarvelNativeAd != null) {
            if (adMarvelNativeAd.getAdType() == AdMarvelNativeAd$AdType.ERROR) {
                Logging.log("ADType Error ");
                final a listener = adMarvelNativeAd.getListener();
                if (listener != null) {
                    final AdMarvelUtils$AdMArvelErrorReason adMArvelErrorReason = AdMarvelUtils.getAdMArvelErrorReason(adMarvelNativeAd.getErrorCode());
                    int errorCode;
                    if (adMArvelErrorReason != null) {
                        errorCode = adMArvelErrorReason.getErrorCode();
                    }
                    else {
                        errorCode = -1;
                    }
                    listener.a(adMarvelNativeAd, errorCode, adMArvelErrorReason);
                }
            }
            else if (adMarvelNativeAd.getAdType() == AdMarvelNativeAd$AdType.SDKCALL) {
                if (adMarvelNativeAd.getSdkNetwork() != null) {
                    adMarvelNativeAd.requestPendingAd();
                }
            }
            else if (adMarvelNativeAd.isDisableAdrequest()) {
                final String disableAdDuration = adMarvelNativeAd.getDisableAdDuration();
                if (disableAdDuration != null) {
                    adMarvelNativeAd.disableAdRequest(disableAdDuration);
                }
            }
            else {
                final a listener2 = adMarvelNativeAd.getListener();
                if (listener2 != null) {
                    listener2.a(adMarvelNativeAd);
                }
            }
        }
    }
}
