// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.admarvel.android.nativeads;

import java.util.Map;
import android.content.Context;

public final class AdMarvelNativeAd$RequestParameters
{
    private final Context mContext;
    private final String mPartnerId;
    private final String mSiteId;
    private final Map mTargetParams;
    
    private AdMarvelNativeAd$RequestParameters(final AdMarvelNativeAd$RequestParameters$Builder adMarvelNativeAd$RequestParameters$Builder) {
        this.mSiteId = adMarvelNativeAd$RequestParameters$Builder.mSiteId;
        this.mPartnerId = adMarvelNativeAd$RequestParameters$Builder.mPartnerId;
        this.mContext = adMarvelNativeAd$RequestParameters$Builder.mContext;
        this.mTargetParams = adMarvelNativeAd$RequestParameters$Builder.mTargetParams;
    }
    
    public final Context getContext() {
        return this.mContext;
    }
    
    public final String getPartnerId() {
        return this.mPartnerId;
    }
    
    public final String getSiteId() {
        return this.mSiteId;
    }
    
    public final Map getTargetParams() {
        return this.mTargetParams;
    }
}
