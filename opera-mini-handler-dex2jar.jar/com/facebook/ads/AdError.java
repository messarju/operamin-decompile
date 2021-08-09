// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.facebook.ads;

import com.facebook.ads.internal.StringUtils;

public class AdError
{
    public static final AdError INTERNAL_ERROR;
    public static final int INVALID_ERROR_CODE = -1;
    public static final AdError LOAD_TOO_FREQUENTLY;
    public static final AdError MISSING_PROPERTIES;
    public static final AdError NO_FILL;
    private final int errorCode;
    private final String errorMessage;
    
    static {
        NO_FILL = new AdError(1001, "No Fill");
        LOAD_TOO_FREQUENTLY = new AdError(1002, "Ad was re-loaded too frequently");
        INTERNAL_ERROR = new AdError(2001, "Internal Error");
        MISSING_PROPERTIES = new AdError(2002, "Native ad failed to load due to missing properties");
    }
    
    public AdError(final int errorCode, final String s) {
        String errorMessage = s;
        if (StringUtils.isNullOrEmpty(s)) {
            errorMessage = "unknown error";
        }
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }
    
    public int getErrorCode() {
        return this.errorCode;
    }
    
    public String getErrorMessage() {
        return this.errorMessage;
    }
}
