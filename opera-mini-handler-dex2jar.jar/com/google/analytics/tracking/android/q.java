// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.google.analytics.tracking.android;

import android.os.Build$VERSION;

final class q
{
    public static int Code() {
        try {
            return Integer.parseInt(Build$VERSION.SDK);
        }
        catch (NumberFormatException ex) {
            ae.I("Invalid version number: " + Build$VERSION.SDK);
            return 0;
        }
    }
}
