// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.facebook.ads.internal;

import java.util.Iterator;
import java.util.HashSet;
import java.util.Collection;
import org.json.JSONArray;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager$NameNotFoundException;
import android.content.Context;

public class AdInvalidationUtils
{
    public static boolean isNativePackageInstalled(final Context context, final String s) {
        if (StringUtils.isNullOrEmpty(s)) {
            return false;
        }
        final PackageManager packageManager = context.getPackageManager();
        try {
            packageManager.getPackageInfo(s, 1);
            return true;
        }
        catch (PackageManager$NameNotFoundException ex) {
            return false;
        }
    }
    
    public static Collection parseDetectionStrings(final JSONArray jsonArray) {
        if (jsonArray == null || jsonArray.length() == 0) {
            return null;
        }
        final HashSet set = new HashSet();
        for (int i = 0; i < jsonArray.length(); ++i) {
            set.add(jsonArray.optString(i));
        }
        return set;
    }
    
    public static boolean shouldInvalidate(final Context context, final AdDataModel adDataModel) {
        final AdInvalidationBehavior invalidationBehavior = adDataModel.getInvalidationBehavior();
        if (invalidationBehavior != null && invalidationBehavior != AdInvalidationBehavior.NONE) {
            final Collection detectionStrings = adDataModel.getDetectionStrings();
            if (detectionStrings != null && !detectionStrings.isEmpty()) {
                final Iterator iterator = detectionStrings.iterator();
                while (true) {
                    while (iterator.hasNext()) {
                        if (isNativePackageInstalled(context, (String)iterator.next())) {
                            final boolean b = true;
                            if (invalidationBehavior == AdInvalidationBehavior.INSTALLED) {
                                return b;
                            }
                            if (invalidationBehavior == AdInvalidationBehavior.NOT_INSTALLED && !b) {
                                return true;
                            }
                            return false;
                        }
                    }
                    final boolean b = false;
                    continue;
                }
            }
        }
        return false;
    }
}
