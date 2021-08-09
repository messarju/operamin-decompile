// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.google.analytics.tracking.android;

import java.text.DecimalFormat;

final class ai
{
    private static final ag Code;
    private static final ag I;
    
    static {
        Code = new ag() {
            @Override
            public final String Code(final String s) {
                if (aq.Z(s)) {
                    return "1";
                }
                return "0";
            }
        };
        I = new ag() {
            private final DecimalFormat Code = new DecimalFormat("0.##");
            
            @Override
            public final String Code(final String s) {
                return this.Code.format(aq.I(s));
            }
        };
    }
    
    public static void Code(final af af) {
        af.Code("apiVersion", "v", null, null);
        af.Code("libraryVersion", "_v", null, null);
        af.Code("anonymizeIp", "aip", "0", ai.Code);
        af.Code("trackingId", "tid", null, null);
        af.Code("hitType", "t", null, null);
        af.Code("sessionControl", "sc", null, null);
        af.Code("adSenseAdMobHitId", "a", null, null);
        af.Code("usage", "_u", null, null);
        af.Code("title", "dt", null, null);
        af.Code("referrer", "dr", null, null);
        af.Code("language", "ul", null, null);
        af.Code("encoding", "de", null, null);
        af.Code("page", "dp", null, null);
        af.Code("screenColors", "sd", null, null);
        af.Code("screenResolution", "sr", null, null);
        af.Code("viewportSize", "vp", null, null);
        af.Code("javaEnabled", "je", "1", ai.Code);
        af.Code("flashVersion", "fl", null, null);
        af.Code("clientId", "cid", null, null);
        af.Code("campaignName", "cn", null, null);
        af.Code("campaignSource", "cs", null, null);
        af.Code("campaignMedium", "cm", null, null);
        af.Code("campaignKeyword", "ck", null, null);
        af.Code("campaignContent", "cc", null, null);
        af.Code("campaignId", "ci", null, null);
        af.Code("gclid", "gclid", null, null);
        af.Code("dclid", "dclid", null, null);
        af.Code("gmob_t", "gmob_t", null, null);
        af.Code("eventCategory", "ec", null, null);
        af.Code("eventAction", "ea", null, null);
        af.Code("eventLabel", "el", null, null);
        af.Code("eventValue", "ev", null, null);
        af.Code("nonInteraction", "ni", "0", ai.Code);
        af.Code("socialNetwork", "sn", null, null);
        af.Code("socialAction", "sa", null, null);
        af.Code("socialTarget", "st", null, null);
        af.Code("appName", "an", null, null);
        af.Code("appVersion", "av", null, null);
        af.Code("description", "cd", null, null);
        af.Code("appId", "aid", null, null);
        af.Code("appInstallerId", "aiid", null, null);
        af.Code("transactionId", "ti", null, null);
        af.Code("transactionAffiliation", "ta", null, null);
        af.Code("transactionShipping", "ts", null, null);
        af.Code("transactionTotal", "tr", null, null);
        af.Code("transactionTax", "tt", null, null);
        af.Code("currencyCode", "cu", null, null);
        af.Code("itemPrice", "ip", null, null);
        af.Code("itemCode", "ic", null, null);
        af.Code("itemName", "in", null, null);
        af.Code("itemCategory", "iv", null, null);
        af.Code("itemQuantity", "iq", null, null);
        af.Code("exDescription", "exd", null, null);
        af.Code("exFatal", "exf", "1", ai.Code);
        af.Code("timingVar", "utv", null, null);
        af.Code("timingValue", "utt", null, null);
        af.Code("timingCategory", "utc", null, null);
        af.Code("timingLabel", "utl", null, null);
        af.Code("sampleRate", "sf", "100", ai.I);
        af.Code("hitTime", "ht", null, null);
        af.Code("customDimension", "cd", null, null);
        af.Code("customMetric", "cm", null, null);
        af.Code("contentGrouping", "cg", null, null);
    }
}
