// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.opera.mini.android;

abstract class bo
{
    public final int B;
    private int C;
    public final String[] Code;
    public final int[] I;
    public final String J;
    public String Z;
    
    bo(final String s) {
        this.Code = s.split(";");
        if (this.Code.length < 6 || s.startsWith("#")) {
            throw new IllegalArgumentException("Invalidly formatted test " + s);
        }
        this.J = this.Code[0];
        this.B = Integer.parseInt(this.Code[3]);
        this.C = Integer.parseInt(this.Code[5]);
        this.I = new int[this.C];
    }
    
    protected abstract int Code();
    
    public final void I() {
        int i = 0;
        try {
            while (i < this.I.length) {
                this.I[i] = this.Code();
                ++i;
            }
        }
        catch (Exception ex) {
            this.Z = ex.getMessage();
        }
    }
}
