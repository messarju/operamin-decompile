// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.facebook.ads;

import org.json.JSONObject;

public class NativeAd$Rating
{
    private final double scale;
    private final double value;
    
    private NativeAd$Rating(final double value, final double scale) {
        this.value = value;
        this.scale = scale;
    }
    
    public static NativeAd$Rating fromJSONObject(final JSONObject jsonObject) {
        if (jsonObject != null) {
            final double optDouble = jsonObject.optDouble("value", 0.0);
            final double optDouble2 = jsonObject.optDouble("scale", 0.0);
            if (optDouble != 0.0 && optDouble2 != 0.0) {
                return new NativeAd$Rating(optDouble, optDouble2);
            }
        }
        return null;
    }
    
    public double getScale() {
        return this.scale;
    }
    
    public double getValue() {
        return this.value;
    }
}
