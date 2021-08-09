// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.facebook.ads.internal;

import org.json.JSONArray;

enum AdSdkCapability
{
    AD_CHOICES("AD_CHOICES", 5, 5), 
    APP_AD("APP_AD", 0, 0), 
    APP_AD_V2("APP_AD_V2", 2, 2), 
    APP_ENGAGEMENT_AD("APP_ENGAGEMENT_AD", 4, 4), 
    JS_TRIGGER("JS_TRIGGER", 6, 6), 
    JS_TRIGGER_NO_AUTO_IMP_LOGGING("JS_TRIGGER_NO_AUTO_IMP_LOGGING", 7, 7), 
    LINK_AD("LINK_AD", 1, 1), 
    LINK_AD_V2("LINK_AD_V2", 3, 3);
    
    private static final AdSdkCapability[] supportedCapabilities;
    private static final String supportedCapabilitiesStr;
    private final int value;
    
    static {
        int i = 0;
        supportedCapabilities = new AdSdkCapability[] { AdSdkCapability.LINK_AD_V2, AdSdkCapability.APP_ENGAGEMENT_AD, AdSdkCapability.AD_CHOICES, AdSdkCapability.JS_TRIGGER_NO_AUTO_IMP_LOGGING };
        final JSONArray jsonArray = new JSONArray();
        for (AdSdkCapability[] supportedCapabilities2 = AdSdkCapability.supportedCapabilities; i < supportedCapabilities2.length; ++i) {
            jsonArray.put(supportedCapabilities2[i].getValue());
        }
        supportedCapabilitiesStr = jsonArray.toString();
    }
    
    private AdSdkCapability(final String s, final int n, final int value) {
        this.value = value;
    }
    
    public static String getSupportedCapabilitiesAsJSONString() {
        return AdSdkCapability.supportedCapabilitiesStr;
    }
    
    final int getValue() {
        return this.value;
    }
}
