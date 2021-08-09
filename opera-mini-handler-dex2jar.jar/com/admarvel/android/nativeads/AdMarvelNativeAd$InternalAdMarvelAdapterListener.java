// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.admarvel.android.nativeads;

import com.admarvel.android.ads.AdMarvelUtils$AdMArvelErrorReason;
import android.os.AsyncTask;
import com.admarvel.android.util.Logging;
import java.util.List;
import com.admarvel.android.ads.AdMarvelUtils$ErrorReason;
import com.admarvel.android.ads.AdMarvelAdapterListener;

class AdMarvelNativeAd$InternalAdMarvelAdapterListener implements AdMarvelAdapterListener
{
    private AdMarvelNativeAd mNativeAd;
    
    public AdMarvelNativeAd$InternalAdMarvelAdapterListener(final AdMarvelNativeAd mNativeAd) {
        this.mNativeAd = mNativeAd;
    }
    
    @Override
    public void onClickAd(final String s) {
    }
    
    @Override
    public void onClose() {
    }
    
    @Override
    public void onExpand() {
    }
    
    @Override
    public void onFailedToReceiveAd(int retrynum, final AdMarvelUtils$ErrorReason adMarvelUtils$ErrorReason) {
        if (this.mNativeAd != null && this.mNativeAd.getRetry().equals(true) && this.mNativeAd.getRetrynum() <= this.mNativeAd.getMaxretries()) {
            this.mNativeAd.pixels = null;
            this.mNativeAd.canRegisterViewForInteraction = false;
            retrynum = this.mNativeAd.getRetrynum();
            final String excluded = this.mNativeAd.getExcluded();
            String s;
            if (this.mNativeAd.getExcluded() != null && this.mNativeAd.getExcluded().length() > 0) {
                s = excluded + "," + this.mNativeAd.getAdId();
            }
            else {
                s = this.mNativeAd.getAdId();
            }
            if (this.mNativeAd.getmContext() != null) {
                Logging.log("Retry : onRequestAd");
                final AdMarvelNativeAd$RequestParameters$Builder adMarvelNativeAd$RequestParameters$Builder = new AdMarvelNativeAd$RequestParameters$Builder();
                adMarvelNativeAd$RequestParameters$Builder.context(this.mNativeAd.mContext);
                adMarvelNativeAd$RequestParameters$Builder.partnerId(this.mNativeAd.partnerId);
                adMarvelNativeAd$RequestParameters$Builder.siteId(this.mNativeAd.siteId);
                adMarvelNativeAd$RequestParameters$Builder.targetParams(this.mNativeAd.targetParams);
                c.a(new b(), adMarvelNativeAd$RequestParameters$Builder.build(), this.mNativeAd, retrynum + 1, s);
            }
            retrynum = 1;
        }
        else {
            retrynum = 0;
        }
        if (retrynum == 0 && this.mNativeAd.listenerImpl != null) {
            this.mNativeAd.listenerImpl.a(this.mNativeAd, AdMarvelUtils$AdMArvelErrorReason.NO_AD_FOUND.getErrorCode(), AdMarvelUtils$AdMArvelErrorReason.NO_AD_FOUND);
        }
    }
    
    @Override
    public void onReceiveAd() {
    }
    
    @Override
    public void onReceiveNativeAd(final Object o) {
        if (o != null && o instanceof AdMarvelNativeAd) {
            this.mNativeAd = (AdMarvelNativeAd)o;
        }
        if (this.mNativeAd.listenerImpl != null) {
            this.mNativeAd.listenerImpl.a(this.mNativeAd);
        }
    }
}
