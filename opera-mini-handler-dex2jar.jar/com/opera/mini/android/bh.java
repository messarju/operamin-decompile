// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.opera.mini.android;

class bh
{
    private int B;
    final /* synthetic */ MiniView Code;
    private float I;
    private float J;
    private long Z;
    
    bh(final MiniView code, final int b) {
        this.Code = code;
        this.B = b;
        this.J = 1.0f;
    }
    
    int Code(final float i) {
        if (i == 0.0f) {
            return 0;
        }
        final long currentTimeMillis = System.currentTimeMillis();
        final long n = currentTimeMillis - this.Z;
        final float abs = Math.abs(i);
        if (n > 1500L || this.I * i < 0.0f) {
            this.J = 1.0f;
        }
        else if (abs >= this.I) {
            this.J += abs * this.B / n;
        }
        else {
            this.J -= abs * this.B / n;
            this.J = Math.max(this.J, 1.0f);
        }
        this.Z = currentTimeMillis;
        this.I = i;
        return (int)(this.J * i);
    }
}
