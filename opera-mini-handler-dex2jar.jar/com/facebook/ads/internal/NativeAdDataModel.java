// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.facebook.ads.internal;

import com.facebook.ads.internal.action.AdAction;
import android.util.Log;
import com.facebook.ads.internal.action.AdActionFactory;
import java.util.HashMap;
import android.content.Context;
import java.util.Collections;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONArray;
import org.json.JSONObject;
import com.facebook.ads.NativeAd$Rating;
import com.facebook.ads.NativeAd$Image;
import java.util.Collection;
import android.net.Uri;

public class NativeAdDataModel implements AdDataModel
{
    private static final String TAG;
    private final Uri adCommand;
    private final String body;
    private final String callToAction;
    private final boolean canManuallyLog;
    private boolean clickLogged;
    private final String clickReportUrl;
    private final Collection detectionStrings;
    private final NativeAd$Image icon;
    private final NativeAd$Image image;
    private boolean impressionLogged;
    private final String impressionReportUrl;
    private final AdInvalidationBehavior invalidationBehavior;
    private final String socialContext;
    private final NativeAd$Rating starRating;
    private final String title;
    
    static {
        TAG = NativeAdDataModel.class.getSimpleName();
    }
    
    private NativeAdDataModel(final Uri adCommand, final String title, final String body, final String callToAction, final String socialContext, final NativeAd$Image icon, final NativeAd$Image image, final NativeAd$Rating starRating, final String impressionReportUrl, final String clickReportUrl, final AdInvalidationBehavior invalidationBehavior, final Collection detectionStrings, final boolean canManuallyLog) {
        this.adCommand = adCommand;
        this.title = title;
        this.body = body;
        this.callToAction = callToAction;
        this.socialContext = socialContext;
        this.icon = icon;
        this.image = image;
        this.starRating = starRating;
        this.impressionReportUrl = impressionReportUrl;
        this.clickReportUrl = clickReportUrl;
        this.invalidationBehavior = invalidationBehavior;
        this.detectionStrings = detectionStrings;
        this.canManuallyLog = canManuallyLog;
    }
    
    public static NativeAdDataModel fromJSONObject(final JSONObject jsonObject) {
        if (jsonObject == null) {
            return null;
        }
        final Uri parse = Uri.parse(jsonObject.optString("fbad_command"));
        final String optString = jsonObject.optString("title");
        final String optString2 = jsonObject.optString("body");
        final String optString3 = jsonObject.optString("call_to_action");
        final String optString4 = jsonObject.optString("social_context");
        final NativeAd$Image fromJSONObject = NativeAd$Image.fromJSONObject(jsonObject.optJSONObject("icon"));
        final NativeAd$Image fromJSONObject2 = NativeAd$Image.fromJSONObject(jsonObject.optJSONObject("image"));
        final NativeAd$Rating fromJSONObject3 = NativeAd$Rating.fromJSONObject(jsonObject.optJSONObject("star_rating"));
        final String optString5 = jsonObject.optString("impression_report_url");
        final String optString6 = jsonObject.optString("click_report_url");
        final boolean optBoolean = jsonObject.optBoolean("manual_imp");
        final AdInvalidationBehavior fromString = AdInvalidationBehavior.fromString(jsonObject.optString("invalidation_behavior"));
        try {
            final JSONArray jsonArray = new JSONArray(jsonObject.optString("detection_strings"));
            return new NativeAdDataModel(parse, optString, optString2, optString3, optString4, fromJSONObject, fromJSONObject2, fromJSONObject3, optString5, optString6, fromString, AdInvalidationUtils.parseDetectionStrings(jsonArray), optBoolean);
        }
        catch (JSONException ex) {
            ex.printStackTrace();
            final JSONArray jsonArray = null;
            return new NativeAdDataModel(parse, optString, optString2, optString3, optString4, fromJSONObject, fromJSONObject2, fromJSONObject3, optString5, optString6, fromString, AdInvalidationUtils.parseDetectionStrings(jsonArray), optBoolean);
        }
    }
    
    private Map getManualLoggingExtraData() {
        return Collections.singletonMap("mil", String.valueOf(true));
    }
    
    public boolean canManuallyLog() {
        return this.canManuallyLog;
    }
    
    public String getBody() {
        return this.body;
    }
    
    public String getCallToAction() {
        return this.callToAction;
    }
    
    @Override
    public Collection getDetectionStrings() {
        return this.detectionStrings;
    }
    
    public NativeAd$Image getIcon() {
        return this.icon;
    }
    
    public NativeAd$Image getImage() {
        return this.image;
    }
    
    @Override
    public AdInvalidationBehavior getInvalidationBehavior() {
        return this.invalidationBehavior;
    }
    
    public String getSocialContext() {
        return this.socialContext;
    }
    
    public NativeAd$Rating getStarRating() {
        return this.starRating;
    }
    
    public String getTitle() {
        return this.title;
    }
    
    public void handleClick(final Context context, final Map map, final boolean b) {
        if (!this.clickLogged) {
            final HashMap hashMap = new HashMap();
            if (map != null) {
                hashMap.put("touch", AdUtilities.jsonEncode(map));
            }
            if (b) {
                hashMap.putAll(this.getManualLoggingExtraData());
            }
            new OpenUrlTask(hashMap).execute((Object[])new String[] { this.clickReportUrl });
            this.clickLogged = true;
            AdUtilities.displayDebugMessage(context, "Click logged");
        }
        final AdAction adAction = AdActionFactory.getAdAction(context, this.adCommand);
        if (adAction == null) {
            return;
        }
        try {
            adAction.execute(null);
        }
        catch (Exception ex) {
            Log.e(NativeAdDataModel.TAG, "Error executing action", (Throwable)ex);
        }
    }
    
    public boolean isValid() {
        return this.title != null && this.title.length() > 0 && this.callToAction != null && this.callToAction.length() > 0 && this.icon != null && this.image != null;
    }
    
    public void logImpression(final boolean b) {
        if (!this.impressionLogged) {
            Map manualLoggingExtraData;
            if (b) {
                manualLoggingExtraData = this.getManualLoggingExtraData();
            }
            else {
                manualLoggingExtraData = null;
            }
            new OpenUrlTask(manualLoggingExtraData).execute((Object[])new String[] { this.impressionReportUrl });
            this.impressionLogged = true;
        }
    }
}
