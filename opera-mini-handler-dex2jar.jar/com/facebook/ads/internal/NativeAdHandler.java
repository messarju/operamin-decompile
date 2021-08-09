// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.facebook.ads.internal;

import android.content.Context;

public class NativeAdHandler extends AdHandler
{
    public NativeAdHandler(final AdHandler$ImpressionHelper adHandler$ImpressionHelper, final long n, final NativeAdDataModel adDataModel, final Context context) {
        super(adHandler$ImpressionHelper, n, context);
        this.setAdDataModel(adDataModel);
    }
    
    @Override
    protected void sendImpression() {
        synchronized (this) {
            ((NativeAdDataModel)this.adDataModel).logImpression(this.impressionHelper.wasManual());
        }
    }
}
