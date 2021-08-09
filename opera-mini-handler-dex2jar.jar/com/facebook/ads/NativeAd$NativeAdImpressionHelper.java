// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.facebook.ads;

import com.facebook.ads.internal.AdHandler$ImpressionHelper;

class NativeAd$NativeAdImpressionHelper implements AdHandler$ImpressionHelper
{
    final /* synthetic */ NativeAd this$0;
    
    private NativeAd$NativeAdImpressionHelper(final NativeAd this$0) {
        this.this$0 = this$0;
    }
    
    @Override
    public void afterImpressionSent() {
    }
    
    @Override
    public void onLoggingImpression() {
        if (this.this$0.impListener != null) {
            this.this$0.impListener.onLoggingImpression(this.this$0);
        }
    }
    
    @Override
    public boolean shouldSendImpression() {
        return this.this$0.isViewOnScreen();
    }
    
    @Override
    public boolean wasManual() {
        return false;
    }
}
