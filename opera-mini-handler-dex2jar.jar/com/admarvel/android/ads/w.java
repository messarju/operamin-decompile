// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.admarvel.android.ads;

import android.annotation.SuppressLint;
import android.graphics.Paint;
import android.webkit.WebSettings$PluginState;
import java.util.concurrent.atomic.AtomicBoolean;
import android.content.Context;
import android.webkit.WebView;

class w
{
    @SuppressLint({ "SetJavaScriptEnabled" })
    static void a(final WebView webView, final Context context, final AtomicBoolean atomicBoolean, final boolean b) {
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        webView.getSettings().setAllowFileAccess(true);
        webView.getSettings().setPluginState(WebSettings$PluginState.OFF);
        webView.getSettings().setUseWideViewPort(true);
        webView.getSettings().setLoadWithOverviewMode(true);
        webView.getSettings().setAppCacheEnabled(true);
        webView.getSettings().setDomStorageEnabled(true);
        webView.getSettings().setAllowFileAccessFromFileURLs(true);
        webView.getSettings().setAllowUniversalAccessFromFileURLs(true);
        webView.getSettings().setAllowContentAccess(true);
        webView.getSettings().setAllowFileAccess(true);
        if (r.c() && b) {
            webView.setLayerType(1, (Paint)null);
        }
        if (atomicBoolean.get()) {
            webView.getSettings().setBuiltInZoomControls(true);
            webView.getSettings().setSupportZoom(true);
        }
    }
}
