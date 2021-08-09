// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.google.android.apps.analytics;

import android.util.Log;
import android.net.Uri;

final class w
{
    static String Code(final String s, final long n) {
        final String queryParameter = Uri.parse(s).getQueryParameter("utmht");
        String string = s;
        if (queryParameter == null) {
            return string;
        }
        try {
            string = s + "&utmqt=" + (n - Long.parseLong(queryParameter));
            return string;
        }
        catch (NumberFormatException ex) {
            Log.e("GoogleAnalyticsTracker", "Error parsing utmht parameter: " + ex.toString());
            return s;
        }
    }
}
