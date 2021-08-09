// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.admarvel.android.admarvelfacebookadapter;

import com.admarvel.android.ads.AdMarvelUtils;
import com.facebook.ads.AdError;
import com.facebook.ads.AdView;
import com.admarvel.android.util.Logging;
import com.facebook.ads.Ad;
import com.admarvel.android.ads.AdMarvelAdapterListener;
import java.lang.ref.WeakReference;
import com.facebook.ads.AdListener;

public class InternalFacebookListener implements AdListener
{
    private WeakReference adMarvelAdapterListenerReference;
    
    public InternalFacebookListener(final AdMarvelAdapterListener adMarvelAdapterListener) {
        this.adMarvelAdapterListenerReference = new WeakReference((T)adMarvelAdapterListener);
    }
    
    @Override
    public void onAdClicked(final Ad ad) {
        if (this.adMarvelAdapterListenerReference != null && this.adMarvelAdapterListenerReference.get() != null) {
            ((AdMarvelAdapterListener)this.adMarvelAdapterListenerReference.get()).onClickAd("");
            Logging.log("Facebook SDK : onAdClicked");
            return;
        }
        Logging.log("Facebook SDK : onAdClicked .. No listener Found");
    }
    
    @Override
    public void onAdLoaded(final Ad ad) {
        if (ad instanceof AdView) {
            ((AdView)ad).setVisibility(0);
        }
        if (this.adMarvelAdapterListenerReference != null && this.adMarvelAdapterListenerReference.get() != null) {
            ((AdMarvelAdapterListener)this.adMarvelAdapterListenerReference.get()).onReceiveAd();
            Logging.log("Facebook SDK : onAdLoaded");
            return;
        }
        Logging.log("Facebook SDK : onAdLoaded .. No listener Found");
    }
    
    @Override
    public void onError(final Ad ad, final AdError adError) {
        if (this.adMarvelAdapterListenerReference != null && this.adMarvelAdapterListenerReference.get() != null) {
            ((AdMarvelAdapterListener)this.adMarvelAdapterListenerReference.get()).onFailedToReceiveAd(205, AdMarvelUtils.getErrorReason(205));
            Logging.log("Facebook SDK : onError - " + adError.getErrorMessage());
            return;
        }
        Logging.log("Facebook SDK : onError .. No listener Found - " + adError.getErrorMessage());
    }
}
