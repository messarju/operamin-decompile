// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.facebook.ads.internal;

import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONArray;
import org.json.JSONObject;
import android.content.Intent;
import android.os.Bundle;
import java.util.Collection;

public class HtmlAdDataModel implements AdDataModel
{
    private static final String ACTIVATION_COMMAND_KEY = "activation_command";
    private static final String DETECTION_STRINGS_KEY = "detection_strings";
    private static final String INVALIDATION_BEHAVIOR_KEY = "invalidation_behavior";
    private static final String MARKUP_KEY = "markup";
    private static final String NATIVE_IMPRESSION_URL = "native_impression_report_url";
    private static final String SECONDARY_ACTIVATION_COMMAND_KEY = "secondary_activation_command";
    private static final String SECONDARY_MARKUP_KEY = "secondary_markup";
    private final String activationCommand;
    private final Collection detectionStrings;
    private final AdInvalidationBehavior invalidationBehavior;
    private final String markup;
    private final String nativeImpressionUrl;
    private final String secondaryActivationCommand;
    private final String secondaryMarkup;
    
    private HtmlAdDataModel(final String markup, final String secondaryMarkup, final String activationCommand, final String secondaryActivationCommand, final String nativeImpressionUrl, final AdInvalidationBehavior invalidationBehavior, final Collection detectionStrings) {
        this.markup = markup;
        this.secondaryMarkup = secondaryMarkup;
        this.activationCommand = activationCommand;
        this.secondaryActivationCommand = secondaryActivationCommand;
        this.nativeImpressionUrl = nativeImpressionUrl;
        this.invalidationBehavior = invalidationBehavior;
        this.detectionStrings = detectionStrings;
    }
    
    public static HtmlAdDataModel fromBundle(final Bundle bundle) {
        return new HtmlAdDataModel(bundle.getString("markup"), null, bundle.getString("activation_command"), null, bundle.getString("native_impression_report_url"), AdInvalidationBehavior.NONE, null);
    }
    
    public static HtmlAdDataModel fromIntentExtra(final Intent intent) {
        return new HtmlAdDataModel(intent.getStringExtra("markup"), null, intent.getStringExtra("activation_command"), null, intent.getStringExtra("native_impression_report_url"), AdInvalidationBehavior.NONE, null);
    }
    
    public static HtmlAdDataModel fromJSONObject(final JSONObject jsonObject) {
        if (jsonObject == null) {
            return null;
        }
        final String optString = jsonObject.optString("markup");
        final String optString2 = jsonObject.optString("secondary_markup");
        final String optString3 = jsonObject.optString("activation_command");
        final String optString4 = jsonObject.optString("secondary_activation_command");
        final String optString5 = jsonObject.optString("native_impression_report_url");
        final AdInvalidationBehavior fromString = AdInvalidationBehavior.fromString(jsonObject.optString("invalidation_behavior"));
        try {
            final JSONArray jsonArray = new JSONArray(jsonObject.optString("detection_strings"));
            return new HtmlAdDataModel(optString, optString2, optString3, optString4, optString5, fromString, AdInvalidationUtils.parseDetectionStrings(jsonArray));
        }
        catch (JSONException ex) {
            ex.printStackTrace();
            final JSONArray jsonArray = null;
            return new HtmlAdDataModel(optString, optString2, optString3, optString4, optString5, fromString, AdInvalidationUtils.parseDetectionStrings(jsonArray));
        }
    }
    
    public void addSecondaryToIntentExtra(final Intent intent) {
        intent.putExtra("secondary_markup", this.secondaryMarkup);
        intent.putExtra("secondary_activation_command", this.secondaryActivationCommand);
    }
    
    public void addToIntentExtra(final Intent intent) {
        intent.putExtra("markup", this.markup);
        intent.putExtra("activation_command", this.activationCommand);
        intent.putExtra("native_impression_report_url", this.nativeImpressionUrl);
    }
    
    public String getActivationCommand() {
        return this.activationCommand;
    }
    
    public Map getDataModelMap() {
        final HashMap hashMap = new HashMap();
        hashMap.put("markup", this.secondaryMarkup);
        hashMap.put("activation_command", this.secondaryActivationCommand);
        hashMap.put("native_impression_report_url", this.nativeImpressionUrl);
        return hashMap;
    }
    
    @Override
    public Collection getDetectionStrings() {
        return this.detectionStrings;
    }
    
    @Override
    public AdInvalidationBehavior getInvalidationBehavior() {
        return this.invalidationBehavior;
    }
    
    public String getMarkup() {
        return this.markup;
    }
    
    public String getNativeImpressionUrl() {
        return this.nativeImpressionUrl;
    }
    
    public String getSendImpressionCommand() {
        return "facebookAd.sendImpression();";
    }
    
    public Bundle saveToBundle() {
        final Bundle bundle = new Bundle();
        bundle.putString("markup", this.markup);
        bundle.putString("native_impression_report_url", this.nativeImpressionUrl);
        return bundle;
    }
}
