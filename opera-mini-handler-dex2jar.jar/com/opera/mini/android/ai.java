// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.opera.mini.android;

import android.content.Context;
import android.os.PowerManager;

public class ai
{
    private static PowerManager Code;
    
    @DontOptimize
    public static boolean Code(final Context context) {
        if (ai.Code == null) {
            ai.Code = (PowerManager)context.getSystemService("power");
        }
        return ai.Code.isScreenOn();
    }
}
