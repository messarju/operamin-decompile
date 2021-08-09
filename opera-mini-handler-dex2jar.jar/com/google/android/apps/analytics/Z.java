// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.google.android.apps.analytics;

final class Z
{
    private final int Code;
    private final String I;
    private final int J;
    private final String Z;
    
    public Z(final int j, final String i, final String z, final int code) {
        if (code != 1 && code != 2 && code != 3) {
            throw new IllegalArgumentException("Invalid Scope:" + code);
        }
        if (j <= 0 || j > 5) {
            throw new IllegalArgumentException("Index must be between 1 and 5 inclusive.");
        }
        if (i == null || i.length() == 0) {
            throw new IllegalArgumentException("Invalid argument for name:  Cannot be empty");
        }
        if (z == null || z.length() == 0) {
            throw new IllegalArgumentException("Invalid argument for value:  Cannot be empty");
        }
        final int length = com.google.android.apps.analytics.I.Code(i + z, "UTF-8").length();
        if (length > 64) {
            throw new IllegalArgumentException("Encoded form of name and value must not exceed 64 characters combined.  Character length: " + length);
        }
        this.J = j;
        this.Code = code;
        this.I = i;
        this.Z = z;
    }
    
    public final int Code() {
        return this.Code;
    }
    
    public final String I() {
        return this.I;
    }
    
    public final int J() {
        return this.J;
    }
    
    public final String Z() {
        return this.Z;
    }
}
