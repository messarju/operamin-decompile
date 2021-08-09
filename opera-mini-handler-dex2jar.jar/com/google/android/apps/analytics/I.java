// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.google.android.apps.analytics;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public final class I
{
    static String Code(final String s, String replace) {
        try {
            replace = URLEncoder.encode(s, replace).replace("+", "%20");
            return replace;
        }
        catch (UnsupportedEncodingException ex) {
            throw new AssertionError((Object)("URL encoding failed for: " + s));
        }
    }
}
