// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.opera.mini.android;

public class ah
{
    private static int Code;
    
    static {
        ah.Code = 0;
    }
    
    @DontOptimize
    static int Code() {
        return x.ag.densityDpi;
    }
    
    @DontOptimize
    static int I() {
        if (ah.Code == 0) {
            ah.Code = (Browser.Z.getResources().getConfiguration().screenLayout & 0xF);
        }
        return ah.Code;
    }
}
