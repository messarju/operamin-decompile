// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.admarvel.android.nativeads;

import com.admarvel.android.ads.AdMarvelUtils$AdMArvelErrorReason;

public interface AdMarvelNativeAd$AdMarvelNativeAdListener
{
    void onClickNativeAd(final String p0);
    
    void onFailedToReceiveNativeAd(final int p0, final AdMarvelUtils$AdMArvelErrorReason p1, final AdMarvelNativeAd p2);
    
    void onReceiveNativeAd(final AdMarvelNativeAd p0);
    
    void onRequestNativeAd();
}
