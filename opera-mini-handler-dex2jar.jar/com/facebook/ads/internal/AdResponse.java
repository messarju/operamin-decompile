// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.facebook.ads.internal;

import org.json.JSONArray;
import java.util.ArrayList;
import org.json.JSONObject;
import android.content.Context;
import com.facebook.ads.AdError;
import java.util.List;

public class AdResponse
{
    private static final int DEFAULT_MIN_VIEWABILITY_PERCENTAGE = 10;
    private static final int DEFAULT_REFRESH_INTERVAL_SECONDS = 0;
    private static final int DEFAULT_REFRESH_THRESHOLD_SECONDS = 20;
    private final List dataModels;
    private final AdError error;
    private final int refreshIntervalMillis;
    private final int refreshThresholdMillis;
    private final int viewabilityThreshold;
    
    private AdResponse(final int refreshIntervalMillis, final int refreshThresholdMillis, final int viewabilityThreshold, final List dataModels, final AdError error) {
        this.refreshIntervalMillis = refreshIntervalMillis;
        this.refreshThresholdMillis = refreshThresholdMillis;
        this.viewabilityThreshold = viewabilityThreshold;
        this.dataModels = dataModels;
        this.error = error;
    }
    
    public static AdResponse parseResponse(final Context context, JSONObject optJSONObject) {
        int i = 0;
        final int optInt = optJSONObject.optInt("refresh", 0);
        final int optInt2 = optJSONObject.optInt("refresh_threshold", 20);
        final int optInt3 = optJSONObject.optInt("min_viewability_percentage", 10);
        final JSONObject optJSONObject2 = optJSONObject.optJSONObject("reason");
        AdError adError;
        if (optJSONObject2 != null) {
            adError = new AdError(optJSONObject2.optInt("code"), optJSONObject2.optString("message"));
        }
        else {
            adError = null;
        }
        final int optInt4 = optJSONObject.optInt("ad_type");
        final ArrayList list = new ArrayList();
        final JSONArray optJSONArray = optJSONObject.optJSONArray("ads");
        Label_0235: {
            if (optJSONArray == null || optJSONArray.length() <= 0) {
                break Label_0235;
            }
            while (i < optJSONArray.length()) {
                optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    AdDataModel adDataModel;
                    if (optInt4 == AdType.HTML.getValue()) {
                        adDataModel = HtmlAdDataModel.fromJSONObject(optJSONObject.optJSONObject("data"));
                    }
                    else if (optInt4 == AdType.NATIVE.getValue()) {
                        adDataModel = NativeAdDataModel.fromJSONObject(optJSONObject.optJSONObject("metadata"));
                    }
                    else {
                        adDataModel = null;
                    }
                    if (adDataModel != null && !AdInvalidationUtils.shouldInvalidate(context, adDataModel)) {
                        list.add(adDataModel);
                    }
                }
                ++i;
            }
            if (!list.isEmpty()) {
                break Label_0235;
            }
            final AdError no_FILL = AdError.NO_FILL;
            return new AdResponse(optInt * 1000, optInt2 * 1000, optInt3, list, no_FILL);
        }
        final AdError no_FILL = adError;
        return new AdResponse(optInt * 1000, optInt2 * 1000, optInt3, list, no_FILL);
    }
    
    public AdDataModel getDataModel() {
        if (this.dataModels == null || this.dataModels.isEmpty()) {
            return null;
        }
        return this.dataModels.get(0);
    }
    
    public AdError getError() {
        return this.error;
    }
    
    public int getRefreshIntervalMillis() {
        return this.refreshIntervalMillis;
    }
    
    public int getRefreshThresholdMillis() {
        return this.refreshThresholdMillis;
    }
    
    public int getViewabilityThreshold() {
        return this.viewabilityThreshold;
    }
}
