// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.admarvel.android.ads;

import com.admarvel.android.util.c;
import com.admarvel.android.util.d;
import android.content.SharedPreferences$Editor;
import com.admarvel.android.util.a;
import android.util.DisplayMetrics;
import com.admarvel.android.util.j;
import com.admarvel.android.util.e;
import android.os.Handler;
import com.admarvel.android.util.Logging;
import android.app.Activity;
import android.content.Context;
import java.lang.ref.WeakReference;
import java.util.Map;

public class AdMarvelUtils
{
    protected static final String ADMARVEL_ADAPTER_GUID = "ADMARVELGUID";
    static final int AD_HISTORY_AD_DUMP_DELAY = 1000;
    static final int AD_HISTORY_REDIRECTED_PAGE_DUMP_DELAY = 3000;
    private static AdMarvelUtils$AdmarvelOrientationInfo AdmarvelActivityOrientationInfo;
    public static final String PATH = "/data/com.admarvel.android.admarvelcachedads";
    private static Map adMarvelOptionalFlags;
    private static boolean enableLogging;
    private static boolean isLogDumpEnabled;
    private static boolean notificationBarInFullScreenLaunchEnabled;
    private WeakReference contextReference;
    
    static {
        AdMarvelUtils.enableLogging = false;
        AdMarvelUtils.isLogDumpEnabled = false;
        AdMarvelUtils.notificationBarInFullScreenLaunchEnabled = false;
        AdMarvelUtils.AdmarvelActivityOrientationInfo = null;
    }
    
    public AdMarvelUtils(final Context context) {
        this.contextReference = new WeakReference((T)context);
    }
    
    public static void appendParams(final StringBuilder sb, final String s, final String s2) {
        r.a(sb, s, s2);
    }
    
    public static String captureTargetingParams(final Map map, final String s) {
        return r.a(map, s);
    }
    
    public static boolean detectDeviceForWebViewCrash() {
        return r.c();
    }
    
    public static void disableLogDump() {
        AdMarvelUtils.isLogDumpEnabled = false;
    }
    
    public static void enableLogDump() {
        AdMarvelUtils.isLogDumpEnabled = true;
    }
    
    public static void enableLogging(final boolean enableLogging) {
        AdMarvelUtils.enableLogging = enableLogging;
    }
    
    public static void enableNotificationBarInFullScreenLaunch(final boolean notificationBarInFullScreenLaunchEnabled) {
        AdMarvelUtils.notificationBarInFullScreenLaunchEnabled = notificationBarInFullScreenLaunchEnabled;
    }
    
    public static String encodeString(final String s) {
        return r.d(s);
    }
    
    public static void forceCloseFullScreenAd(final Activity activity, final AdMarvelActivity adMarvelActivity, final AdMarvelVideoActivity adMarvelVideoActivity) {
        if (adMarvelActivity != null) {
            adMarvelActivity.finish();
        }
        if (adMarvelVideoActivity != null) {
            adMarvelVideoActivity.finish();
        }
        try {
            AdMarvelAdapterInstances.getInstance("ADMARVELGUID", "com.admarvel.android.admarveladcolonyadapter.AdMarvelAdColonyAdapter").forceCloseFullScreenAd(activity);
            Logging.log("com.admarvel.android.admarveladcolonyadapter.AdMarvelAdColonyAdapter: forceCloseFullScreenAd");
        }
        catch (Exception ex) {}
    }
    
    public static AdMarvelUtils$AdMArvelErrorReason getAdMArvelErrorReason(final int n) {
        switch (n) {
            default: {
                return null;
            }
            case 201: {
                return AdMarvelUtils$AdMArvelErrorReason.SITE_ID_OR_PARTNER_ID_NOT_PRESENT;
            }
            case 202: {
                return AdMarvelUtils$AdMArvelErrorReason.SITE_ID_AND_PARTNER_ID_DO_NOT_MATCH;
            }
            case 203: {
                return AdMarvelUtils$AdMArvelErrorReason.BOT_USER_AGENT_FOUND;
            }
            case 204: {
                return AdMarvelUtils$AdMArvelErrorReason.NO_BANNER_FOUND;
            }
            case 205: {
                return AdMarvelUtils$AdMArvelErrorReason.NO_AD_FOUND;
            }
            case 206: {
                return AdMarvelUtils$AdMArvelErrorReason.NO_USER_AGENT_FOUND;
            }
            case 207: {
                return AdMarvelUtils$AdMArvelErrorReason.SITE_ID_NOT_PRESENT;
            }
            case 208: {
                return AdMarvelUtils$AdMArvelErrorReason.PARTNER_ID_NOT_PRESENT;
            }
            case 301: {
                return AdMarvelUtils$AdMArvelErrorReason.NO_NETWORK_CONNECTIVITY;
            }
            case 302: {
                return AdMarvelUtils$AdMArvelErrorReason.NETWORK_CONNECTIVITY_DISRUPTED;
            }
            case 303: {
                return AdMarvelUtils$AdMArvelErrorReason.AD_REQUEST_XML_PARSING_EXCEPTION;
            }
            case 304: {
                return AdMarvelUtils$AdMArvelErrorReason.AD_REQUEST_IN_PROCESS_EXCEPTION;
            }
            case 305: {
                return AdMarvelUtils$AdMArvelErrorReason.AD_UNIT_NOT_ABLE_TO_RENDER;
            }
            case 306: {
                return AdMarvelUtils$AdMArvelErrorReason.AD_REQUEST_MISSING_XML_ELEMENTS;
            }
            case 307: {
                return AdMarvelUtils$AdMArvelErrorReason.AD_REQUEST_SDK_TYPE_UNSUPPORTED;
            }
            case 308: {
                return AdMarvelUtils$AdMArvelErrorReason.AD_UNIT_NOT_ABLE_TO_LOAD;
            }
        }
    }
    
    public static Map getAdMarvelOptionalFlags() {
        return AdMarvelUtils.adMarvelOptionalFlags;
    }
    
    public static Integer getAdmarvelActivityOrientationInfo(final Context context) {
        if (AdMarvelUtils.AdmarvelActivityOrientationInfo != null) {
            switch (AdMarvelUtils$2.a[AdMarvelUtils.AdmarvelActivityOrientationInfo.ordinal()]) {
                case 1: {
                    return 1;
                }
                case 2: {
                    return 0;
                }
                case 3: {
                    return 8;
                }
                case 4: {
                    return 9;
                }
                case 5: {
                    return r.e(context);
                }
            }
        }
        return null;
    }
    
    public static int getAndroidSDKVersion() {
        return Version.getAndroidSDKVersion();
    }
    
    public static String getDeviceConnectivitiy(final Context context) {
        return r.a(context);
    }
    
    public static float getDeviceDensity(final Context context) {
        return r.i(context);
    }
    
    public static int getDeviceHeight(final Context context) {
        return r.h(context);
    }
    
    public static int getDeviceWidth(final Context context) {
        return r.g(context);
    }
    
    public static int getErrorCode(final AdMarvelUtils$ErrorReason adMarvelUtils$ErrorReason) {
        return r.a(adMarvelUtils$ErrorReason);
    }
    
    public static AdMarvelUtils$ErrorReason getErrorReason(final int n) {
        return r.a(n);
    }
    
    public static boolean getPreferenceValueBoolean(final Context context, final String s, final String s2) {
        synchronized (AdMarvelUtils.class) {
            return context.getSharedPreferences(s, 0).getBoolean(s2, false);
        }
    }
    
    public static int getPreferenceValueInt(final Context context, final String s, final String s2) {
        synchronized (AdMarvelUtils.class) {
            return context.getSharedPreferences(s, 0).getInt(s2, Integer.MIN_VALUE);
        }
    }
    
    public static long getPreferenceValueLong(final Context context, final String s, final String s2) {
        synchronized (AdMarvelUtils.class) {
            return context.getSharedPreferences(s, 0).getLong(s2, -2147483648L);
        }
    }
    
    public static String getPreferenceValueString(final Context context, final String s, final String s2) {
        synchronized (AdMarvelUtils.class) {
            return context.getSharedPreferences(s, 0).getString(s2, "VALUE_NOT_DEFINED");
        }
    }
    
    public static String getSDKVersion() {
        return "2.4.6";
    }
    
    public static String getSDKVersionDate() {
        return "2014-11-06";
    }
    
    public static int getScreenOrientation(final Context context) {
        return r.d(context);
    }
    
    public static String getSupportedInterfaceOrientations(final Activity activity) {
        return r.a(activity);
    }
    
    public static String getUserAgent(final Context context, final Handler handler) {
        return new r(context).a();
    }
    
    public static void initialize(final Activity activity, final Map ex) {
        if (Version.getAndroidSDKVersion() >= 11 && AdMarvelView.a()) {
            AdMarvelUtils$a.a(activity);
        }
        while (true) {
            try {
                AdMarvelAdapterInstances.getInstance("ADMARVELGUID", "com.admarvel.android.admarveladcolonyadapter.AdMarvelAdColonyAdapter").initialize(activity, (Map)ex);
                Logging.log("com.admarvel.android.admarveladcolonyadapter.AdMarvelAdColonyAdapter: initialize");
                try {
                    AdMarvelAdapterInstances.getInstance("ADMARVELGUID", "com.admarvel.android.admarvelinmobiadapter.AdMarvelInmobiAdapter").initialize(activity, (Map)ex);
                    Logging.log("com.admarvel.android.admarvelinmobiadapter.AdMarvelInmobiAdapter: initialize");
                    try {
                        AdMarvelAdapterInstances.getInstance("ADMARVELGUID", "com.admarvel.android.admarvelheyzapadapter.AdMarvelHeyzapAdapter").initialize(activity, (Map)ex);
                        Logging.log("com.admarvel.android.admarvelheyzapadapter.AdMarvelHeyzapAdapter: initialize");
                        try {
                            AdMarvelAnalyticsAdapterInstances.getInstance("com.admarvel.android.admarvelmologiqadapter.AdMarvelMologiqAdapter", (Context)activity).start();
                            e.a().b().execute(new Runnable() {
                                @Override
                                public final void run() {
                                    r.l((Context)activity);
                                    j.c((Context)activity);
                                    r.o((Context)activity);
                                }
                            });
                            r.n((Context)activity);
                            if (!isLogDumpEnabled()) {
                                r.m((Context)activity);
                            }
                        }
                        catch (Exception ex2) {}
                    }
                    catch (Exception ex) {}
                }
                catch (Exception ex3) {}
            }
            catch (Exception ex4) {
                continue;
            }
            break;
        }
    }
    
    public static boolean isLogDumpEnabled() {
        return AdMarvelUtils.isLogDumpEnabled;
    }
    
    public static boolean isLoggingEnabled() {
        return AdMarvelUtils.enableLogging;
    }
    
    public static final boolean isNetworkAvailable(final Context context) {
        return r.f(context);
    }
    
    public static boolean isNotificationBarInFullScreenLaunchEnabled() {
        return AdMarvelUtils.notificationBarInFullScreenLaunchEnabled;
    }
    
    public static boolean isTabletDevice(final Context context) {
        final DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        if (displayMetrics.widthPixels >= 600) {
            final float n = displayMetrics.widthPixels / displayMetrics.xdpi;
            final float n2 = displayMetrics.heightPixels / displayMetrics.ydpi;
            final Double value = Math.sqrt(n2 * n2 + n * n);
            Logging.log("Device Screen Size : " + value);
            if (value > 6.5) {
                return true;
            }
        }
        return false;
    }
    
    public static void lockAdMarvelActivityOrientation(final AdMarvelUtils$AdmarvelOrientationInfo admarvelActivityOrientationInfo) {
        AdMarvelUtils.AdmarvelActivityOrientationInfo = admarvelActivityOrientationInfo;
    }
    
    public static String reportAdMarvelAdHistory(final int n, final Context context) {
        String a = "";
        if (isNetworkAvailable(context)) {
            a = a;
            if (AdMarvelUtils.isLogDumpEnabled) {
                a = com.admarvel.android.util.a.b(context).a(n);
            }
        }
        return a;
    }
    
    public static String reportAdMarvelAdHistory(final Context context) {
        String a = "";
        if (isNetworkAvailable(context)) {
            a = a;
            if (AdMarvelUtils.isLogDumpEnabled) {
                a = com.admarvel.android.util.a.b(context).a(20);
            }
        }
        return a;
    }
    
    public static void setAdMarvelOptionalFlags(final Map adMarvelOptionalFlags) {
        AdMarvelUtils.adMarvelOptionalFlags = adMarvelOptionalFlags;
    }
    
    public static AdMarvelAd setAdStatus(final AdMarvelAd adMarvelAd, final String errorReason) {
        synchronized (AdMarvelUtils.class) {
            adMarvelAd.setAdType(AdMarvelAd$AdType.ERROR);
            adMarvelAd.setErrorCode(306);
            adMarvelAd.setErrorReason(errorReason);
            return adMarvelAd;
        }
    }
    
    public static void setFullScreenloadingTimeout(final int n) {
        if (n > 0) {
            Constants.WAIT_FOR_INTERSTITIAL = n * 1000;
            return;
        }
        Logging.log("setFullScreenloadingTimeout :- time cannot be less than zero");
    }
    
    public static void setPreferenceValueBoolean(final Context context, final String s, final String s2, final boolean b) {
        synchronized (AdMarvelUtils.class) {
            final SharedPreferences$Editor edit = context.getSharedPreferences(s, 0).edit();
            edit.putBoolean(s2, b);
            edit.commit();
        }
    }
    
    public static void setPreferenceValueInt(final Context context, final String s, final String s2, final int n) {
        synchronized (AdMarvelUtils.class) {
            final SharedPreferences$Editor edit = context.getSharedPreferences(s, 0).edit();
            edit.putInt(s2, n);
            edit.commit();
        }
    }
    
    public static void setPreferenceValueLong(final Context context, final String s, final String s2, final long n) {
        synchronized (AdMarvelUtils.class) {
            final SharedPreferences$Editor edit = context.getSharedPreferences(s, 0).edit();
            edit.putLong(s2, n);
            edit.commit();
        }
    }
    
    public static void setPreferenceValueString(final Context context, final String s, final String s2, final String s3) {
        synchronized (AdMarvelUtils.class) {
            final SharedPreferences$Editor edit = context.getSharedPreferences(s, 0).edit();
            edit.putString(s2, s3);
            edit.commit();
        }
    }
    
    public static void uninitialize(final Activity ex) {
        final d a = d.a();
        if (a != null && a.b()) {
            a.c();
        }
        final c a2 = c.a();
        if (a2 != null) {
            a2.a((Context)ex);
        }
        j.a();
        r.n((Context)ex);
        if (!isLogDumpEnabled()) {
            r.m((Context)ex);
        }
        while (true) {
            try {
                AdMarvelAdapterInstances.getInstance("ADMARVELGUID", "com.admarvel.android.admarvelgoogleplayadapter.AdMarvelGooglePlayAdapter").uninitialize((Activity)ex, null);
                Logging.log("com.admarvel.android.admarvelgoogleplayadapter.AdMarvelGooglePlayAdapter: uninitialize");
                try {
                    AdMarvelAdapterInstances.getInstance("ADMARVELGUID", "com.admarvel.android.admarvelamazonadapter.AdMarvelAmazonAdapter").uninitialize((Activity)ex, null);
                    Logging.log("com.admarvel.android.admarvelamazonadapter.AdMarvelAmazonAdapter: uninitialize");
                    try {
                        AdMarvelAdapterInstances.getInstance("ADMARVELGUID", "com.admarvel.android.admarveladcolonyadapter.AdMarvelAdColonyAdapter").uninitialize((Activity)ex, null);
                        Logging.log("com.admarvel.android.admarveladcolonyadapter.AdMarvelAdColonyAdapter: uninitialize");
                        try {
                            AdMarvelAdapterInstances.getInstance("ADMARVELGUID", "com.admarvel.android.admarvelfacebookadapter.AdMarvelFacebookAdapter").uninitialize((Activity)ex, null);
                            Logging.log("com.admarvel.android.admarvelfacebookadapter.AdMarvelFacebookAdapter: uninitialize");
                            try {
                                AdMarvelAdapterInstances.getInstance("ADMARVELGUID", "com.admarvel.android.admarvelheyzapadapter.AdMarvelHeyzapAdapter").uninitialize((Activity)ex, null);
                                Logging.log("com.admarvel.android.admarvelheyzapadapter.AdMarvelHeyzapAdapter: uninitialize");
                                try {
                                    AdMarvelAdapterInstances.getInstance("ADMARVELGUID", "com.admarvel.android.admarvelinmobiadapter.AdMarvelInmobiAdapter").uninitialize((Activity)ex, null);
                                    Logging.log("com.admarvel.android.admarvelinmobiadapter.AdMarvelInmobiAdapter: uninitialize");
                                    try {
                                        AdMarvelAdapterInstances.getInstance("ADMARVELGUID", "com.admarvel.android.admarvelmillennialadapter.AdMarvelMillennialAdapter").uninitialize((Activity)ex, null);
                                        Logging.log("com.admarvel.android.admarvelmillennialadapter.AdMarvelMillennialAdapter: uninitialize");
                                        try {
                                            AdMarvelAdapterInstances.getInstance("ADMARVELGUID", "com.admarvel.android.admarvelrhythmadapter.AdMarvelRhythmAdapter").uninitialize((Activity)ex, null);
                                            Logging.log("com.admarvel.android.admarvelrhythmadapter.AdMarvelRhythmAdapter: uninitialize");
                                        }
                                        catch (Exception ex) {}
                                    }
                                    catch (Exception ex2) {}
                                }
                                catch (Exception ex3) {}
                            }
                            catch (Exception ex4) {}
                        }
                        catch (Exception ex5) {}
                    }
                    catch (Exception ex6) {}
                }
                catch (Exception ex7) {}
            }
            catch (Exception ex8) {
                continue;
            }
            break;
        }
    }
    
    public void firePixel(final AdMarvelAd adMarvelAd) {
        new r((Context)this.contextReference.get()).a(adMarvelAd);
    }
    
    public void firePixel(final String s) {
        new r((Context)this.contextReference.get()).b(s);
    }
    
    public void firePixelUsingHTTP(final String s) {
        new r((Context)this.contextReference.get()).a(s);
    }
    
    public void firePixelUsingHTTP(final String s, final Handler handler) {
        new r((Context)this.contextReference.get()).a(s, handler);
    }
    
    public String getUserAgent() {
        return new r((Context)this.contextReference.get()).a();
    }
}
