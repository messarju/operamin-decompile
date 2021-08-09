// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.facebook.ads;

public interface AdListener
{
    void onAdClicked(final Ad p0);
    
    void onAdLoaded(final Ad p0);
    
    void onError(final Ad p0, final AdError p1);
}
