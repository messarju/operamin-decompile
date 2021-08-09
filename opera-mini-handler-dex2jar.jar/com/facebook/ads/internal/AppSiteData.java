// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.facebook.ads.internal;

import org.json.JSONArray;
import java.util.ArrayList;
import org.json.JSONObject;
import java.util.List;

public class AppSiteData
{
    private final String appLinkUri;
    private final String className;
    private final String fallbackUrl;
    private final List keyHashes;
    private final String marketUri;
    private final String packageName;
    
    private AppSiteData(final String packageName, final String className, final String appLinkUri, final List keyHashes, final String marketUri, final String fallbackUrl) {
        this.packageName = packageName;
        this.className = className;
        this.appLinkUri = appLinkUri;
        this.keyHashes = keyHashes;
        this.marketUri = marketUri;
        this.fallbackUrl = fallbackUrl;
    }
    
    public static AppSiteData fromJSONObject(final JSONObject jsonObject) {
        if (jsonObject == null) {
            return null;
        }
        final String optString = jsonObject.optString("package");
        final String optString2 = jsonObject.optString("appsite");
        final String optString3 = jsonObject.optString("appsite_url");
        final JSONArray optJSONArray = jsonObject.optJSONArray("key_hashes");
        final ArrayList list = new ArrayList();
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); ++i) {
                list.add(optJSONArray.optString(i));
            }
        }
        return new AppSiteData(optString, optString2, optString3, list, jsonObject.optString("market_uri"), jsonObject.optString("fallback_url"));
    }
    
    public String getAppLinkUri() {
        return this.appLinkUri;
    }
    
    public String getClassName() {
        return this.className;
    }
    
    public String getFallbackUrl() {
        return this.fallbackUrl;
    }
    
    public List getKeyHashes() {
        return this.keyHashes;
    }
    
    public String getMarketUri() {
        return this.marketUri;
    }
    
    public String getPackageName() {
        return this.packageName;
    }
}
