// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.admarvel.android.ads;

import android.webkit.WebView;
import android.annotation.SuppressLint;

@SuppressLint({ "ViewConstructor" })
class aa
{
    static void a(final WebView webView) {
        webView.onResume();
    }
    
    static void b(final WebView webView) {
        webView.onPause();
    }
}
