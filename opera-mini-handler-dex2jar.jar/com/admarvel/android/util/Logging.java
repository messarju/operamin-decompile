// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.admarvel.android.util;

import com.admarvel.android.ads.AdMarvelUtils;
import android.util.Log;

public class Logging
{
    private static final String LOGTAG = "admarvel";
    
    public static void log(final String s) {
        if (Log.isLoggable("admarvel", 2) || AdMarvelUtils.isLoggingEnabled()) {
            Log.d("admarvel", s);
        }
    }
}
