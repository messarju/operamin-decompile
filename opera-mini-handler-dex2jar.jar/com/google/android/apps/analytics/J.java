// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.google.android.apps.analytics;

final class J
{
    private Z[] Code;
    
    public J() {
        this.Code = new Z[5];
    }
    
    private static void J(final int n) {
        if (n <= 0 || n > 5) {
            throw new IllegalArgumentException("Index must be between 1 and 5 inclusive.");
        }
    }
    
    public final void Code(final Z z) {
        J(z.J());
        this.Code[z.J() - 1] = z;
    }
    
    public final boolean Code(final int n) {
        J(n);
        return this.Code[n - 1] == null;
    }
    
    public final Z[] Code() {
        return this.Code.clone();
    }
    
    public final Z I(final int n) {
        J(n);
        return this.Code[n - 1];
    }
    
    public final boolean I() {
        final boolean b = false;
        int n = 0;
        boolean b2;
        while (true) {
            b2 = b;
            if (n >= this.Code.length) {
                break;
            }
            if (this.Code[n] != null) {
                b2 = true;
                break;
            }
            ++n;
        }
        return b2;
    }
    
    public final void Z(final int n) {
        J(n);
        this.Code[n - 1] = null;
    }
}
