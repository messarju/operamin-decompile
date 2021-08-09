// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.opera.mini.android;

public class q extends az
{
    private long I;
    private aw Z;
    
    static {
        C();
    }
    
    q(final int n, final int n2) {
        this.Z = null;
        this.Code(n, n2);
    }
    
    private q(final az az, final int n, final int n2, final int n3, final int n4, final int n5, final int n6, final int n7, final int n8, final int n9, final int n10, final int n11, final boolean b) {
        this.Z = null;
        this.Code(az, n, n2, n3, n4, n5, n6, n7, n8, n9, n10, n11, b);
    }
    
    q(final int[] array, final int n, final int n2, final int n3, final int n4, final int n5) {
        this.Z = null;
        this.Code(array, n, n2, n3, n4, n5, false);
    }
    
    q(final int[] array, final int n, final int n2, final boolean b) {
        this.Z = null;
        this.Code(array, n, n2, n, n2, 0, b);
    }
    
    private static native void C();
    
    private native void Code(final int p0, final int p1);
    
    private native void Code(final az p0, final int p1, final int p2, final int p3, final int p4, final int p5, final int p6, final int p7, final int p8, final int p9, final int p10, final int p11, final boolean p12);
    
    private native void Code(final byte[] p0);
    
    private native void Code(final int[] p0, final int p1, final int p2, final int p3, final int p4, final int p5, final boolean p6);
    
    @Override
    public aw B() {
        if (this.Z == null) {
            this.Z = k.Code(this);
        }
        return this.Z;
    }
    
    @Override
    public final az Code(final int n, final int n2, final int n3, final int n4, final int n5, final int n6, final int n7, final int n8, final int n9, final int n10, final int n11, final boolean b) {
        return new q(this, n, n2, n3, n4, n5, n6, n7, n8, n9, n10, n11, b);
    }
    
    @Override
    public native int I();
    
    @Override
    public native int J();
    
    @Override
    public native int Z();
    
    @Override
    protected native void finalize();
}
