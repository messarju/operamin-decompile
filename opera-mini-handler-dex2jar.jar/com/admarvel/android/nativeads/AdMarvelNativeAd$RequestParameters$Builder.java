// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.admarvel.android.nativeads;

import java.util.Map;
import android.content.Context;

public final class AdMarvelNativeAd$RequestParameters$Builder
{
    private Context mContext;
    private String mPartnerId;
    private String mSiteId;
    private Map mTargetParams;
    
    public final AdMarvelNativeAd$RequestParameters build() {
        return new AdMarvelNativeAd$RequestParameters(this, null);
    }
    
    public final AdMarvelNativeAd$RequestParameters$Builder context(final Context mContext) {
        this.mContext = mContext;
        return this;
    }
    
    public final AdMarvelNativeAd$RequestParameters$Builder partnerId(final String mPartnerId) {
        this.mPartnerId = mPartnerId;
        return this;
    }
    
    public final AdMarvelNativeAd$RequestParameters$Builder siteId(final String mSiteId) {
        this.mSiteId = mSiteId;
        return this;
    }
    
    public final AdMarvelNativeAd$RequestParameters$Builder targetParams(final Map mTargetParams) {
        this.mTargetParams = mTargetParams;
        return this;
    }
}
