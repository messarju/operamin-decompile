// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.facebook.ads.internal;

import java.util.Locale;

public enum AdInvalidationBehavior
{
    INSTALLED("INSTALLED", 1), 
    NONE("NONE", 0), 
    NOT_INSTALLED("NOT_INSTALLED", 2);
    
    private AdInvalidationBehavior(final String s, final int n) {
    }
    
    public static AdInvalidationBehavior fromString(final String s) {
        if (StringUtils.isNullOrEmpty(s)) {
            return AdInvalidationBehavior.NONE;
        }
        try {
            return valueOf(s.toUpperCase(Locale.US));
        }
        catch (IllegalArgumentException ex) {
            return AdInvalidationBehavior.NONE;
        }
    }
}
