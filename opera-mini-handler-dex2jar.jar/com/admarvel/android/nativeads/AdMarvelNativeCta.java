// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.admarvel.android.nativeads;

public class AdMarvelNativeCta
{
    private String action;
    private String clickUrl;
    private AdMarvelNativeImage image;
    private String title;
    
    public String getAction() {
        return this.action;
    }
    
    public String getClickUrl() {
        return this.clickUrl;
    }
    
    public AdMarvelNativeImage getImage() {
        return this.image;
    }
    
    public String getTitle() {
        return this.title;
    }
    
    public void setAction(final String action) {
        this.action = action;
    }
    
    public void setClickUrl(final String clickUrl) {
        this.clickUrl = clickUrl;
    }
    
    public void setImage(final AdMarvelNativeImage image) {
        this.image = image;
    }
    
    public void setTitle(final String title) {
        this.title = title;
    }
}
