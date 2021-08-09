// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.google.analytics.tracking.android;

final class Code
{
    private boolean Code;
    
    Code() {
        try {
            this.Code = (Class.forName("Code") != null);
        }
        catch (ClassNotFoundException ex) {
            this.Code = false;
        }
    }
    
    final int Code() {
        if (!this.Code) {
            return 0;
        }
        return I.Code().I();
    }
}
