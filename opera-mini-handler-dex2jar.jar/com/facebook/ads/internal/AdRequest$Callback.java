// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.facebook.ads.internal;

import com.facebook.ads.AdError;

public interface AdRequest$Callback
{
    void onCompleted(final AdResponse p0);
    
    void onError(final AdError p0);
}
