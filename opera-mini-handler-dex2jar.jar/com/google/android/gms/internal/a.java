// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.google.android.gms.internal;

import android.os.Build$VERSION;

public final class a
{
    public static boolean Code() {
        return Code(11);
    }
    
    private static boolean Code(final int n) {
        return Build$VERSION.SDK_INT >= n;
    }
    
    public static boolean I() {
        return Code(13);
    }
}
