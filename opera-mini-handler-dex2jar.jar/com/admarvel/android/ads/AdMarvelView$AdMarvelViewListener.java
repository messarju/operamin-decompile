// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.admarvel.android.ads;

public interface AdMarvelView$AdMarvelViewListener
{
    void onClickAd(final AdMarvelView p0, final String p1);
    
    void onClose();
    
    void onExpand();
    
    void onFailedToReceiveAd(final AdMarvelView p0, final int p1, final AdMarvelUtils$ErrorReason p2);
    
    void onReceiveAd(final AdMarvelView p0);
    
    void onRequestAd(final AdMarvelView p0);
}
