// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.facebook.ads;

import android.util.Log;
import android.content.SharedPreferences;
import java.util.UUID;
import com.facebook.ads.internal.StringUtils;
import android.os.Build;
import android.content.Context;
import java.util.HashSet;
import java.util.Collection;

public class AdSettings
{
    private static final String DEVICE_ID_HASH_PREFS_KEY = "deviceIdHash";
    private static final String PREFS_NAME = "FBAdPrefs";
    public static final String TAG;
    private static boolean childDirected;
    private static String deviceIdHash;
    private static final Collection emulatorProducts;
    static volatile boolean testDeviceNoticeDisplayed;
    private static final Collection testDevices;
    private static String urlPrefix;
    
    static {
        TAG = AdSettings.class.getSimpleName();
        AdSettings.urlPrefix = null;
        AdSettings.childDirected = false;
        AdSettings.deviceIdHash = null;
        testDevices = new HashSet();
        (emulatorProducts = new HashSet()).add("sdk");
        AdSettings.emulatorProducts.add("google_sdk");
        AdSettings.emulatorProducts.add("vbox86p");
        AdSettings.emulatorProducts.add("vbox86tp");
        AdSettings.testDeviceNoticeDisplayed = false;
    }
    
    public static void addTestDevice(final String s) {
        AdSettings.testDevices.add(s);
    }
    
    public static void addTestDevices(final Collection collection) {
        AdSettings.testDevices.addAll(collection);
    }
    
    public static void clearTestDevices() {
        AdSettings.testDevices.clear();
    }
    
    public static String getUrlPrefix() {
        return AdSettings.urlPrefix;
    }
    
    public static boolean isChildDirected() {
        return AdSettings.childDirected;
    }
    
    public static boolean isTestMode(final Context context) {
        if (!AdSettings.emulatorProducts.contains(Build.PRODUCT)) {
            if (AdSettings.deviceIdHash == null) {
                final SharedPreferences sharedPreferences = context.getSharedPreferences("FBAdPrefs", 0);
                if (StringUtils.isNullOrEmpty(AdSettings.deviceIdHash = sharedPreferences.getString("deviceIdHash", (String)null))) {
                    AdSettings.deviceIdHash = StringUtils.md5(UUID.randomUUID().toString());
                    sharedPreferences.edit().putString("deviceIdHash", AdSettings.deviceIdHash).apply();
                }
            }
            if (!AdSettings.testDevices.contains(AdSettings.deviceIdHash)) {
                printTestDeviceNotice(AdSettings.deviceIdHash);
                return false;
            }
        }
        return true;
    }
    
    private static void printTestDeviceNotice(final String s) {
        if (AdSettings.testDeviceNoticeDisplayed) {
            return;
        }
        AdSettings.testDeviceNoticeDisplayed = true;
        Log.d(AdSettings.TAG, "Test mode device hash: " + s);
        Log.d(AdSettings.TAG, "When testing your app with Facebook's ad units you must specify the device hashed ID to ensure the delivery of test ads, add the following code before loading an ad: AdSettings.addTestDevice(\"" + s + "\");");
    }
    
    public static void setIsChildDirected(final boolean childDirected) {
        AdSettings.childDirected = childDirected;
    }
    
    public static void setUrlPrefix(final String urlPrefix) {
        AdSettings.urlPrefix = urlPrefix;
    }
}
