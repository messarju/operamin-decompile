// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.facebook.ads.internal.action;

import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import android.util.Log;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import android.content.pm.PackageManager;
import android.content.ComponentName;
import android.content.pm.ResolveInfo;
import com.facebook.ads.internal.AdInvalidationUtils;
import com.facebook.ads.internal.StringUtils;
import android.content.Intent;
import com.facebook.ads.internal.AppSiteData;
import android.net.Uri;
import android.content.Context;

public class AppAdAction extends AdAction
{
    private static final String MARKET_DETAIL_URI_FORMAT = "market://details?id=%s";
    private static final String TAG;
    private final Context context;
    private final Uri uri;
    
    static {
        TAG = AppAdAction.class.getSimpleName();
    }
    
    public AppAdAction(final Context context, final Uri uri) {
        this.context = context;
        this.uri = uri;
    }
    
    private Intent getAppLaunchIntent(final AppSiteData appSiteData) {
        if (StringUtils.isNullOrEmpty(appSiteData.getPackageName())) {
            return null;
        }
        if (!AdInvalidationUtils.isNativePackageInstalled(this.context, appSiteData.getPackageName())) {
            return null;
        }
        final String appLinkUri = appSiteData.getAppLinkUri();
        if (!StringUtils.isNullOrEmpty(appLinkUri) && (appLinkUri.startsWith("tel:") || appLinkUri.startsWith("telprompt:"))) {
            return new Intent("android.intent.action.CALL", Uri.parse(appLinkUri));
        }
        final PackageManager packageManager = this.context.getPackageManager();
        if (StringUtils.isNullOrEmpty(appSiteData.getClassName()) && StringUtils.isNullOrEmpty(appLinkUri)) {
            return packageManager.getLaunchIntentForPackage(appSiteData.getPackageName());
        }
        final Intent appLinkIntentUnresolved = this.getAppLinkIntentUnresolved(appSiteData);
        final List queryIntentActivities = packageManager.queryIntentActivities(appLinkIntentUnresolved, 65536);
        if (appLinkIntentUnresolved.getComponent() == null) {
            for (final ResolveInfo resolveInfo : queryIntentActivities) {
                if (resolveInfo.activityInfo.packageName.equals(appSiteData.getPackageName())) {
                    appLinkIntentUnresolved.setComponent(new ComponentName(resolveInfo.activityInfo.packageName, resolveInfo.activityInfo.name));
                    break;
                }
            }
        }
        if (queryIntentActivities.isEmpty() || appLinkIntentUnresolved.getComponent() == null) {
            return null;
        }
        return appLinkIntentUnresolved;
    }
    
    private Intent getAppLinkIntentUnresolved(final AppSiteData appSiteData) {
        final Intent intent = new Intent("android.intent.action.VIEW");
        intent.addFlags(268435456);
        if (!StringUtils.isNullOrEmpty(appSiteData.getPackageName()) && !StringUtils.isNullOrEmpty(appSiteData.getClassName())) {
            intent.setComponent(new ComponentName(appSiteData.getPackageName(), appSiteData.getClassName()));
        }
        if (!StringUtils.isNullOrEmpty(appSiteData.getAppLinkUri())) {
            intent.setData(Uri.parse(appSiteData.getAppLinkUri()));
        }
        return intent;
    }
    
    private List getAppsiteDatas() {
        final String queryParameter = this.uri.getQueryParameter("appsite_data");
        List list;
        if (StringUtils.isNullOrEmpty(queryParameter) || "[]".equals(queryParameter)) {
            list = null;
        }
        else {
            final ArrayList list2 = new ArrayList();
            try {
                final JSONArray optJSONArray = new JSONObject(queryParameter).optJSONArray("android");
                list = list2;
                if (optJSONArray != null) {
                    int n = 0;
                    while (true) {
                        list = list2;
                        if (n >= optJSONArray.length()) {
                            break;
                        }
                        final AppSiteData fromJSONObject = AppSiteData.fromJSONObject(optJSONArray.optJSONObject(n));
                        if (fromJSONObject != null) {
                            list2.add(fromJSONObject);
                        }
                        ++n;
                    }
                }
            }
            catch (JSONException ex) {
                Log.w(AppAdAction.TAG, "Error parsing appsite_data", (Throwable)ex);
                return list2;
            }
        }
        return list;
    }
    
    @Override
    public void execute(Map iterator) {
        this.logAdClick(this.context, this.uri);
        final List appLaunchIntents = this.getAppLaunchIntents();
        if (appLaunchIntents != null) {
            iterator = appLaunchIntents.iterator();
            while (iterator.hasNext()) {
                final Intent intent = (Intent)iterator.next();
                try {
                    this.context.startActivity(intent);
                    return;
                }
                catch (Exception ex) {
                    Log.d(AppAdAction.TAG, "Failed to open app intent, falling back", (Throwable)ex);
                    continue;
                }
                break;
            }
        }
        this.goToMarketURL();
    }
    
    protected List getAppLaunchIntents() {
        final List appsiteDatas = this.getAppsiteDatas();
        final ArrayList list = new ArrayList();
        if (appsiteDatas != null) {
            final Iterator iterator = appsiteDatas.iterator();
            while (iterator.hasNext()) {
                final Intent appLaunchIntent = this.getAppLaunchIntent((AppSiteData)iterator.next());
                if (appLaunchIntent != null) {
                    list.add(appLaunchIntent);
                }
            }
        }
        return list;
    }
    
    protected Uri getMarketUri() {
        return Uri.parse(String.format("market://details?id=%s", this.uri.getQueryParameter("store_id")));
    }
    
    public void goToMarketURL() {
        final Intent intent = new Intent("android.intent.action.VIEW", this.getMarketUri());
        intent.addFlags(268435456);
        try {
            this.context.startActivity(intent);
        }
        catch (Exception ex) {
            Log.d(AppAdAction.TAG, "Failed to open market url: " + this.uri.toString(), (Throwable)ex);
            final String queryParameter = this.uri.getQueryParameter("store_url_web_fallback");
            if (queryParameter == null || queryParameter.length() <= 0) {
                return;
            }
            final Intent intent2 = new Intent("android.intent.action.VIEW", Uri.parse(queryParameter));
            intent2.addFlags(268435456);
            try {
                this.context.startActivity(intent2);
            }
            catch (Exception ex2) {
                Log.d(AppAdAction.TAG, "Failed to open fallback url: " + queryParameter, (Throwable)ex2);
            }
        }
    }
}
