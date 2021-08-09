// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.facebook.ads.internal;

import java.lang.reflect.Method;
import android.os.Looper;
import android.content.Context;

public class AdvertisingIdInfo
{
    private static final int CONNECTION_RESULT_SUCCESS = 0;
    private final String id;
    private final boolean limitAdTrackingEnabled;
    
    private AdvertisingIdInfo(final String id, final boolean limitAdTrackingEnabled) {
        this.id = id;
        this.limitAdTrackingEnabled = limitAdTrackingEnabled;
    }
    
    public static AdvertisingIdInfo getAdvertisingIdInfo(final Context context, final AdUtilities$Fb4aData adUtilities$Fb4aData) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            throw new IllegalStateException("Cannot get advertising info on main thread.");
        }
        if (adUtilities$Fb4aData != null && !StringUtils.isNullOrEmpty(adUtilities$Fb4aData.advertisingId)) {
            return new AdvertisingIdInfo(adUtilities$Fb4aData.advertisingId, adUtilities$Fb4aData.limitTrackingEnabled);
        }
        final Method method = AdUtilities.getMethod("com.google.android.gms.common.GooglePlayServicesUtil", "isGooglePlayServicesAvailable", Context.class);
        if (method == null) {
            return null;
        }
        final Object invokeMethod = AdUtilities.invokeMethod(null, method, context);
        if (invokeMethod == null || (int)invokeMethod != 0) {
            return null;
        }
        final Method method2 = AdUtilities.getMethod("com.google.android.gms.ads.identifier.AdvertisingIdClient", "getAdvertisingIdInfo", Context.class);
        if (method2 == null) {
            return null;
        }
        final Object invokeMethod2 = AdUtilities.invokeMethod(null, method2, context);
        if (invokeMethod2 == null) {
            return null;
        }
        final Method method3 = AdUtilities.getMethod(invokeMethod2.getClass(), "getId", new Class[0]);
        final Method method4 = AdUtilities.getMethod(invokeMethod2.getClass(), "isLimitAdTrackingEnabled", new Class[0]);
        if (method3 == null || method4 == null) {
            return null;
        }
        return new AdvertisingIdInfo((String)AdUtilities.invokeMethod(invokeMethod2, method3, new Object[0]), (boolean)AdUtilities.invokeMethod(invokeMethod2, method4, new Object[0]));
    }
    
    public String getId() {
        return this.id;
    }
    
    public boolean isLimitAdTrackingEnabled() {
        return this.limitAdTrackingEnabled;
    }
}
