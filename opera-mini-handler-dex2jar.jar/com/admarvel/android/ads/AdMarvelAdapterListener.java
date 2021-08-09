// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.admarvel.android.ads;

public interface AdMarvelAdapterListener
{
    void onClickAd(final String p0);
    
    void onClose();
    
    void onExpand();
    
    void onFailedToReceiveAd(final int p0, final AdMarvelUtils$ErrorReason p1);
    
    void onReceiveAd();
    
    void onReceiveNativeAd(final Object p0);
}
