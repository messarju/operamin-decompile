// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.facebook.ads;

import org.json.JSONObject;

public class NativeAd$Image
{
    private final int height;
    private final String url;
    private final int width;
    
    private NativeAd$Image(final String url, final int width, final int height) {
        this.url = url;
        this.width = width;
        this.height = height;
    }
    
    public static NativeAd$Image fromJSONObject(final JSONObject jsonObject) {
        if (jsonObject != null) {
            final String optString = jsonObject.optString("url");
            if (optString != null) {
                return new NativeAd$Image(optString, jsonObject.optInt("width", 0), jsonObject.optInt("height", 0));
            }
        }
        return null;
    }
    
    public int getHeight() {
        return this.height;
    }
    
    public String getUrl() {
        return this.url;
    }
    
    public int getWidth() {
        return this.width;
    }
}
