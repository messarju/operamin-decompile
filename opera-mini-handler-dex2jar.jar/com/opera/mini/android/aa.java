// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.opera.mini.android;

public class aa implements ch
{
    private long Code;
    private int I;
    private int Z;
    
    private native boolean Code(final byte[] p0, final int p1, final int p2, final int p3, final int p4);
    
    private native boolean Code(final byte[] p0, final int p1, final int p2, final int[] p3);
    
    @Override
    public final int Code() {
        return this.I;
    }
    
    @Override
    public final boolean Code(final byte[] array, final int n, final int n2) {
        final int[] array2 = new int[2];
        if (this.Code(array, n, n2, array2)) {
            this.I = array2[0];
            this.Z = array2[1];
            if (this.I * this.Z != 0) {
                return this.Code(array, n, n2, this.I, this.Z);
            }
        }
        return false;
    }
    
    @Override
    public final int I() {
        return this.Z;
    }
    
    public final long Z() {
        return this.Code;
    }
}
