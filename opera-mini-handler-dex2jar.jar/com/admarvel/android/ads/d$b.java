// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.admarvel.android.ads;

import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.webkit.JsPromptResult;
import android.app.Activity;
import android.webkit.JsResult;
import android.webkit.WebView;
import android.content.Context;
import java.lang.ref.WeakReference;
import android.webkit.WebChromeClient;

class d$b extends WebChromeClient
{
    private final WeakReference a;
    private final WeakReference b;
    
    public d$b(final d d, final Context context) {
        this.a = new WeakReference((T)d);
        this.b = new WeakReference((T)context);
    }
    
    public boolean onJsAlert(final WebView webView, final String s, final String s2, final JsResult jsResult) {
        final d d = (d)this.a.get();
        if (d == null) {
            jsResult.cancel();
            return true;
        }
        if (d.M) {
            jsResult.cancel();
            return true;
        }
        if (d.x.get()) {
            jsResult.cancel();
            return true;
        }
        if (this.b.get() != null && this.b.get() instanceof Activity) {
            return super.onJsAlert(webView, s, s2, jsResult);
        }
        jsResult.cancel();
        return true;
    }
    
    public boolean onJsBeforeUnload(final WebView webView, final String s, final String s2, final JsResult jsResult) {
        jsResult.cancel();
        return true;
    }
    
    public boolean onJsConfirm(final WebView webView, final String s, final String s2, final JsResult jsResult) {
        final d d = (d)this.a.get();
        if (d == null) {
            jsResult.cancel();
            return true;
        }
        if (d.M) {
            jsResult.cancel();
            return true;
        }
        if (d.x.get()) {
            jsResult.cancel();
            return true;
        }
        if (this.b.get() != null && this.b.get() instanceof Activity) {
            return super.onJsConfirm(webView, s, s2, jsResult);
        }
        jsResult.cancel();
        return true;
    }
    
    public boolean onJsPrompt(final WebView webView, final String s, final String s2, final String s3, final JsPromptResult jsPromptResult) {
        final d d = (d)this.a.get();
        if (d == null) {
            jsPromptResult.cancel();
            return true;
        }
        if (d.M) {
            jsPromptResult.cancel();
            return true;
        }
        if (d.x.get()) {
            jsPromptResult.cancel();
            return true;
        }
        if (this.b.get() != null && this.b.get() instanceof Activity) {
            return super.onJsPrompt(webView, s, s2, s3, jsPromptResult);
        }
        jsPromptResult.cancel();
        return true;
    }
    
    public void onProgressChanged(final WebView webView, final int progress) {
        final d d = (d)this.a.get();
        if (d != null && !d.M) {
            o o = null;
            if (d.getParent() instanceof RelativeLayout) {
                o = (o)((RelativeLayout)d.getParent()).findViewWithTag((Object)(d.s + "CONTROLS"));
            }
            if (o != null && d.v.get()) {
                ((ProgressBar)o.findViewWithTag((Object)(d.s + "PROGRESS_BAR"))).setProgress(progress);
            }
        }
    }
}
