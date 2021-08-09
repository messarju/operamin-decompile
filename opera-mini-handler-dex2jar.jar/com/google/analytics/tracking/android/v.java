// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.google.analytics.tracking.android;

import java.util.List;
import java.util.Map;

final class v
{
    private final Map Code;
    private final long I;
    private final List J;
    private final String Z;
    
    public v(final Map code, final long i, final String z, final List j) {
        this.Code = code;
        this.I = i;
        this.Z = z;
        this.J = j;
    }
    
    public final Map Code() {
        return this.Code;
    }
    
    public final long I() {
        return this.I;
    }
    
    public final List J() {
        return this.J;
    }
    
    public final String Z() {
        return this.Z;
    }
}
