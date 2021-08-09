// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.facebook.ads.internal;

public enum AdType
{
    HTML("HTML", 0, 0), 
    NATIVE("NATIVE", 1, 1);
    
    private final int value;
    
    private AdType(final String s, final int n, final int value) {
        this.value = value;
    }
    
    public final int getValue() {
        return this.value;
    }
}
