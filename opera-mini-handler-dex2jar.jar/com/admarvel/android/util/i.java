// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.admarvel.android.util;

import android.util.TypedValue;
import android.content.Context;

public class i
{
    public static float a(final float n, final Context context) {
        return TypedValue.applyDimension(1, n, context.getResources().getDisplayMetrics());
    }
    
    public static int b(final float n, final Context context) {
        return (int)(a(n, context) + 0.5f);
    }
}
