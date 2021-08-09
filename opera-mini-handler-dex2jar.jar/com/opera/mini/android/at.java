// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.opera.mini.android;

import android.content.pm.PackageManager$NameNotFoundException;
import java.util.Calendar;
import java.util.Date;

final class at
{
    public static Date Code() {
        try {
            return new Date(as.Code.getPackageManager().getPackageInfo(as.Code.getPackageName(), 0).firstInstallTime);
        }
        catch (PackageManager$NameNotFoundException ex) {
            return Calendar.getInstance().getTime();
        }
    }
}
