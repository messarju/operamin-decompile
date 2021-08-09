// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.google.android.apps.analytics;

public final class v
{
    private double B;
    private final String Code;
    private String I;
    private double J;
    private final double Z;
    
    public v(final String code, final double z) {
        this.I = null;
        this.J = 0.0;
        this.B = 0.0;
        if (code == null || code.trim().length() == 0) {
            throw new IllegalArgumentException("orderId must not be empty or null");
        }
        this.Code = code;
        this.Z = z;
    }
    
    public final v Code(final double j) {
        this.J = j;
        return this;
    }
    
    public final v Code(final String i) {
        this.I = i;
        return this;
    }
    
    public final v I(final double b) {
        this.B = b;
        return this;
    }
}
