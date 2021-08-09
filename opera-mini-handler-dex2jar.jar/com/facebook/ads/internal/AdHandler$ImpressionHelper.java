// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.facebook.ads.internal;

public interface AdHandler$ImpressionHelper
{
    void afterImpressionSent();
    
    void onLoggingImpression();
    
    boolean shouldSendImpression();
    
    boolean wasManual();
}
