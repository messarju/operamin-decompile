// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.admarvel.android.ads;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.net.URL;
import java.net.HttpURLConnection;
import android.util.Log;
import java.io.InputStream;
import java.io.FileInputStream;
import java.io.File;
import android.webkit.WebResourceResponse;
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

class d$c extends WebViewClient
{
    private final WeakReference a;
    private final WeakReference b;
    private final AdMarvelAd c;
    
    public d$c(final d d, final Context context, final AdMarvelAd c) {
        this.a = new WeakReference((T)d);
        this.b = new WeakReference((T)context);
        this.c = c;
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
        super.onPageStarted(webView, s, bitmap);
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
    
    public WebResourceResponse shouldInterceptRequest(final WebView webView, final String s) {
        final File file = null;
        final int n = 0;
        final d d = (d)this.a.get();
        if (d == null) {
            return null;
        }
        if (d.M) {
            return null;
        }
        if (s == null) {
            return null;
        }
        if (s.equals("http://baseurl.admarvel.com/mraid.js") || (d.F && s.endsWith("mraid.js"))) {
            final File dir = d.getContext().getDir("adm_mraid_file", 0);
            File file2 = file;
            if (dir != null) {
                file2 = file;
                if (dir.isDirectory()) {
                    file2 = new File(dir.getAbsolutePath() + "/mraid.js");
                }
            }
            if (file2 != null && file2.exists()) {
                try {
                    Logging.log("Mraid loading from client");
                    return new WebResourceResponse("text/css", "UTF-8", (InputStream)new FileInputStream(file2));
                }
                catch (Exception ex) {
                    Logging.log(Log.getStackTraceString((Throwable)ex));
                    return super.shouldInterceptRequest(webView, s);
                }
            }
            InputStream inputStream;
            ArrayList list;
            int n2;
            try {
                final HttpURLConnection httpURLConnection = (HttpURLConnection)new URL("http://admarvel.s3.amazonaws.com/js/admarvel_mraid_v2_complete.js").openConnection();
                httpURLConnection.setRequestMethod("GET");
                httpURLConnection.setDoOutput(false);
                httpURLConnection.setDoInput(true);
                httpURLConnection.setUseCaches(false);
                httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                httpURLConnection.setRequestProperty("Content-Length", "0");
                httpURLConnection.setConnectTimeout(2000);
                httpURLConnection.setReadTimeout(10000);
                final int responseCode = httpURLConnection.getResponseCode();
                final int contentLength = httpURLConnection.getContentLength();
                Logging.log("Mraid Connection Status Code: " + responseCode);
                Logging.log("Mraid Content Length: " + contentLength);
                if (responseCode != 200) {
                    return super.shouldInterceptRequest(webView, s);
                }
                inputStream = (InputStream)httpURLConnection.getContent();
                list = new ArrayList();
                int i = 8192;
                n2 = 0;
                while (i != -1) {
                    final byte[] a = new byte[8192];
                    final int read = inputStream.read(a, 0, 8192);
                    if ((i = read) > 0) {
                        final d$e d$e = new d$e(null);
                        d$e.a = a;
                        d$e.b = read;
                        n2 += read;
                        list.add(d$e);
                        i = read;
                    }
                }
            }
            catch (Exception ex2) {
                Logging.log(Log.getStackTraceString((Throwable)ex2));
                return super.shouldInterceptRequest(webView, s);
            }
            inputStream.close();
            String s2;
            if (n2 > 0) {
                final byte[] array = new byte[n2];
                int j = 0;
                int n3 = n;
                while (j < list.size()) {
                    final d$e d$e2 = (d$e)list.get(j);
                    System.arraycopy(d$e2.a, 0, array, n3, d$e2.b);
                    n3 += d$e2.b;
                    ++j;
                }
                s2 = new String(array);
            }
            else {
                s2 = "";
            }
            d.F = false;
            return new WebResourceResponse("text/css", "UTF-8", (InputStream)new ByteArrayInputStream(s2.getBytes()));
        }
        return super.shouldInterceptRequest(webView, s);
    }
    
    public boolean shouldOverrideUrlLoading(final WebView webView, final String s) {
        final d d = (d)this.a.get();
        return d != null && !d.M && d.f(s);
    }
}
