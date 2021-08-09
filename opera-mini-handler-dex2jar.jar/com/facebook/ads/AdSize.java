// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.facebook.ads;

public enum AdSize
{
    BANNER_320_50("BANNER_320_50", 0, 320, 50), 
    BANNER_HEIGHT_50("BANNER_HEIGHT_50", 2, -1, 50), 
    BANNER_HEIGHT_90("BANNER_HEIGHT_90", 3, -1, 90), 
    INTERSTITIAL("INTERSTITIAL", 1, 0, 0);
    
    private final int height;
    private final int width;
    
    private AdSize(final String s, final int n, final int width, final int height) {
        this.width = width;
        this.height = height;
    }
    
    public final int getHeight() {
        return this.height;
    }
    
    public final int getWidth() {
        return this.width;
    }
}
