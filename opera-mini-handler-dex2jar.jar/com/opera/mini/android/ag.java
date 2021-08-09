// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.opera.mini.android;

import android.provider.Settings$Global;
import android.content.ContentResolver;

public class ag
{
    @DontOptimize
    static int Code(final ContentResolver contentResolver, final String s, final int n) {
        return Settings$Global.getInt(contentResolver, s, n);
    }
}
