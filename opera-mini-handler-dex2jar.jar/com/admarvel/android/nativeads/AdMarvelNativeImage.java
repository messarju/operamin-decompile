// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.admarvel.android.nativeads;

import android.widget.ImageView;

public class AdMarvelNativeImage
{
    private int height;
    private String imageUrl;
    private int width;
    
    public void downloadAndDisplayImage(final ImageView imageView) {
        new AdMarvelNativeImage$a(this, imageView).execute((Object[])new String[] { this.getImageUrl() });
    }
    
    public int getHeight() {
        return this.height;
    }
    
    public String getImageUrl() {
        return this.imageUrl;
    }
    
    public int getWidth() {
        return this.width;
    }
    
    public void setHeight(final int height) {
        this.height = height;
    }
    
    public void setImageUrl(final String imageUrl) {
        this.imageUrl = imageUrl;
    }
    
    public void setWidth(final int width) {
        this.width = width;
    }
}
