// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.facebook.ads.internal;

import android.webkit.JavascriptInterface;
import android.util.Log;

public class AdWebViewInterface
{
    private static final String TAG;
    
    static {
        TAG = AdWebViewInterface.class.getSimpleName();
    }
    
    @JavascriptInterface
    public void alert(final String s) {
        Log.e(AdWebViewInterface.TAG, s);
    }
    
    @JavascriptInterface
    public String getAnalogInfo() {
        return AdUtilities.jsonEncode(AdAnalogData.getAnalogInfo());
    }
}
