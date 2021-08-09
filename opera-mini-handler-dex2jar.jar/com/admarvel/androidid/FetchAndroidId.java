// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.admarvel.androidid;

import android.provider.Settings$Secure;
import android.content.Context;

public class FetchAndroidId
{
    public static String getId(final Context context) {
        return Settings$Secure.getString(context.getContentResolver(), "android_id");
    }
}
