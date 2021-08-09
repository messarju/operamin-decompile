// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.google.android.apps.analytics;

public final class l
{
    private String B;
    private String C;
    private final String Code;
    private final String I;
    private final long J;
    private final double Z;
    
    public l(final String code, final String i, final double z, final long j) {
        this.B = null;
        this.C = null;
        if (code == null || code.trim().length() == 0) {
            throw new IllegalArgumentException("orderId must not be empty or null");
        }
        if (i == null || i.trim().length() == 0) {
            throw new IllegalArgumentException("itemSKU must not be empty or null");
        }
        this.Code = code;
        this.I = i;
        this.Z = z;
        this.J = j;
    }
    
    public final l Code(final String b) {
        this.B = b;
        return this;
    }
    
    public final l I(final String c) {
        this.C = c;
        return this;
    }
}
