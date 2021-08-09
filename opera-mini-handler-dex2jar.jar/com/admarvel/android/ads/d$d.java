// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.admarvel.android.ads;

import android.app.Activity;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import com.admarvel.android.util.Logging;
import android.webkit.WebView;
import android.content.Context;
import java.lang.ref.WeakReference;
import android.webkit.WebViewClient;

class d$d extends WebViewClient
{
    private final WeakReference a;
    private final WeakReference b;
    private final AdMarvelAd c;
    
    public d$d(final d d, final Context context, final AdMarvelAd c) {
        this.a = new WeakReference((T)d);
        this.b = new WeakReference((T)context);
        this.c = c;
    }
    
    public void onLoadResource(final WebView webView, final String s) {
        super.onLoadResource(webView, s);
        final d d = (d)this.a.get();
        if (d != null && !d.M && d.F && s.contains("mraid.js")) {
            webView.loadUrl("javascript: (function() { var script=document.createElement('script');script.type='text/javascript';script.src='http://admarvel.s3.amazonaws.com/js/admarvel_mraid_v2_complete.js';document.getElementsByTagName('head').item(0).appendChild(script);})()");
            d.F = false;
        }
    }
    
    public void onPageFinished(final WebView webView, final String s) {
        super.onPageFinished(webView, s);
        final d d = (d)this.a.get();
        if (d != null && !d.M) {
            final Context context = (Context)this.b.get();
            if (context != null && !d.M) {
                Logging.log("Load Ad: onPageFinished");
                if (d.w.get()) {
                    d.S = true;
                }
                else {
                    d.R = true;
                }
                new Handler(Looper.getMainLooper()).post((Runnable)new d$k(d, context));
            }
        }
    }
    
    public void onPageStarted(final WebView webView, final String s, final Bitmap bitmap) {
        final d d = (d)this.a.get();
        if (d != null && !d.M) {
            Logging.log("Load Ad: onPageStarted");
            if (d.w.get() && d.getParent() != null && d.getParent() instanceof RelativeLayout) {
                final RelativeLayout relativeLayout = (RelativeLayout)d.getParent();
                final o o = (o)relativeLayout.findViewWithTag((Object)(d.s + "CONTROLS"));
                if (o != null) {
                    d.setVisibility(0);
                    o.setVisibility(0);
                    o.findViewWithTag((Object)(d.s + "PROGRESS_BAR")).setVisibility(0);
                    ((ProgressBar)o.findViewWithTag((Object)(d.s + "PROGRESS_BAR"))).setProgress(10);
                    relativeLayout.requestLayout();
                }
            }
            final Context context = (Context)this.b.get();
            if (context != null) {
                if (d.w.get()) {
                    if (d.T) {
                        d.S = false;
                        new Handler(Looper.getMainLooper()).postDelayed((Runnable)new d$g(d, context), Constants.WAIT_FOR_INAPP_BROWSER);
                        d.T = false;
                    }
                }
                else if (d.U) {
                    d.R = false;
                    new Handler(Looper.getMainLooper()).postDelayed((Runnable)new d$h(d, context), Constants.WAIT_FOR_INTERSTITIAL);
                    d.U = false;
                }
            }
        }
    }
    
    public void onReceivedError(final WebView webView, final int n, final String s, final String s2) {
        super.onReceivedError(webView, n, s, s2);
        final Context context = (Context)this.b.get();
        if (context != null && context instanceof Activity) {
            final Activity activity = (Activity)context;
            if (activity != null && activity instanceof AdMarvelActivity) {
                final AdMarvelActivity adMarvelActivity = (AdMarvelActivity)activity;
                if (adMarvelActivity != null) {
                    Logging.log("onReceivedError - Closing AdMarvel FullScreen due to bad URL : " + s2);
                    adMarvelActivity.g();
                }
            }
        }
    }
    
    public boolean shouldOverrideUrlLoading(final WebView webView, final String s) {
        final d d = (d)this.a.get();
        return d != null && !d.M && d.f(s);
    }
}
