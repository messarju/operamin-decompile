// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.admarvel.android.ads;

import android.content.pm.PackageManager;
import android.content.Context;

class r$f
{
    public static boolean a(final Context context, final String s) {
        final PackageManager packageManager = context.getPackageManager();
        if (s.equals("camera")) {
            return packageManager.hasSystemFeature("android.hardware.camera");
        }
        if (Version.getAndroidSDKVersion() >= 8) {
            if (s.equals("location")) {
                return packageManager.hasSystemFeature("android.hardware.location");
            }
            if (s.equals("accelerometer")) {
                return packageManager.hasSystemFeature("android.hardware.sensor.accelerometer");
            }
            if (s.equals("compass")) {
                return packageManager.hasSystemFeature("android.hardware.sensor.compass");
            }
        }
        return false;
    }
}
