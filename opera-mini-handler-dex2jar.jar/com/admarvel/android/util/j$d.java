// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.admarvel.android.util;

import android.content.Context;

public class j$d implements Runnable
{
    final /* synthetic */ j a;
    private final Context b;
    
    public j$d(final j a, final Context b) {
        this.a = a;
        this.b = b;
    }
    
    @Override
    public void run() {
        if (this.b == null) {
            return;
        }
        try {
            e(this.b);
        }
        catch (Exception ex) {
            Logging.log("FetchAndroidAdvertisingIdUsingIntentRunnable error " + ex.getMessage());
        }
    }
}
