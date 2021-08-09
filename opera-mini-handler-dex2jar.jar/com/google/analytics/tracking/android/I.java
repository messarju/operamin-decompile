// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.google.analytics.tracking.android;

import java.util.Random;

final class I
{
    private static final I Code;
    private int I;
    private Random Z;
    
    static {
        Code = new I();
    }
    
    private I() {
        this.Z = new Random();
    }
    
    static I Code() {
        return I.Code;
    }
    
    final int I() {
        return this.I = this.Z.nextInt(2147483646) + 1;
    }
}
