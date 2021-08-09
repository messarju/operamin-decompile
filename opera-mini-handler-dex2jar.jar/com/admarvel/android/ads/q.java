// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.admarvel.android.ads;

import android.app.Activity;

class q
{
    static void a(final Activity activity, final String s) {
        if (s.equalsIgnoreCase("LandscapeRight")) {
            activity.setRequestedOrientation(8);
        }
        else if (s.equalsIgnoreCase("PortraitUpsideDown")) {
            activity.setRequestedOrientation(9);
        }
    }
}
