// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.admarvel.android.ads;

import java.util.HashMap;
import android.content.Context;
import java.util.Map;

public class AdMarvelAnalyticsAdapterInstances
{
    private static Map instances;
    
    static {
        AdMarvelAnalyticsAdapterInstances.instances = null;
    }
    
    static Map createInstances(final Context context) {
        final HashMap hashMap = new HashMap();
        try {
            hashMap.put("com.admarvel.android.admarvelmologiqadapter.AdMarvelMologiqAdapter", AdMarvelAnalyticsAdapter.createInstance("com.admarvel.android.admarvelmologiqadapter.AdMarvelMologiqAdapter", context));
            return hashMap;
        }
        catch (Exception ex) {
            return hashMap;
        }
    }
    
    public static AdMarvelAnalyticsAdapter getInstance(final String s, final Context context) {
        if (AdMarvelAnalyticsAdapterInstances.instances == null) {
            AdMarvelAnalyticsAdapterInstances.instances = createInstances(context);
        }
        return AdMarvelAnalyticsAdapterInstances.instances.get(s);
    }
}
