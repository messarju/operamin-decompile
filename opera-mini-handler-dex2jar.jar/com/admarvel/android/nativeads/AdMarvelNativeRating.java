// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.admarvel.android.nativeads;

public class AdMarvelNativeRating
{
    private String base;
    private AdMarvelNativeImage blank;
    private AdMarvelNativeImage complete;
    private AdMarvelNativeImage full;
    private AdMarvelNativeImage half;
    private String value;
    
    public String getBase() {
        return this.base;
    }
    
    public AdMarvelNativeImage getBlank() {
        return this.blank;
    }
    
    public AdMarvelNativeImage getComplete() {
        return this.complete;
    }
    
    public AdMarvelNativeImage getFull() {
        return this.full;
    }
    
    public AdMarvelNativeImage getHalf() {
        return this.half;
    }
    
    public String getValue() {
        return this.value;
    }
    
    public void setBase(final String base) {
        this.base = base;
    }
    
    public void setBlank(final AdMarvelNativeImage blank) {
        this.blank = blank;
    }
    
    public void setComplete(final AdMarvelNativeImage complete) {
        this.complete = complete;
    }
    
    public void setFull(final AdMarvelNativeImage full) {
        this.full = full;
    }
    
    public void setHalf(final AdMarvelNativeImage half) {
        this.half = half;
    }
    
    public void setValue(final String value) {
        this.value = value;
    }
}
