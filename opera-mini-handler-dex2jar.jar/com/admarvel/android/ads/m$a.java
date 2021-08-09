// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.admarvel.android.ads;

import android.content.Context;
import java.io.IOException;
import java.io.OutputStream;
import java.io.ObjectOutputStream;
import java.io.ByteArrayOutputStream;
import android.net.Uri;
import android.content.Intent;
import android.view.ViewGroup;
import android.app.Activity;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.net.URL;
import java.net.HttpURLConnection;
import android.util.Log;
import java.io.InputStream;
import java.io.FileInputStream;
import java.io.File;
import android.webkit.WebResourceResponse;
import android.os.Handler;
import android.os.Looper;
import android.graphics.Bitmap;
import com.admarvel.android.util.Logging;
import android.webkit.WebView;
import android.webkit.WebViewClient;

class m$a extends WebViewClient
{
    final /* synthetic */ m a;
    
    m$a(final m a) {
        this.a = a;
    }
    
    public void onLoadResource(final WebView webView, final String s) {
        Logging.log("Load Ad : onLoadResource URL - " + s);
        super.onLoadResource(webView, s);
    }
    
    public void onPageFinished(final WebView webView, final String s) {
        super.onPageFinished(webView, s);
        this.a.an = true;
        Logging.log("Load Ad: onPageFinished");
        if (AdMarvelUtils.isLogDumpEnabled()) {
            webView.loadUrl("javascript:window.ADMARVEL.fetchWebViewHtmlContent(document.getElementsByTagName('html')[0].outerHTML);");
        }
        if (!this.a.S) {
            this.a.setVisibility(8);
            ((d)this.a.findViewWithTag((Object)(this.a.s + "INTERNAL"))).setLayoutParamsForBanner(true);
        }
        if (!this.a.p.get() && this.a.b.compareAndSet(true, false)) {
            if (m.a(this.a.s) != null) {
                d.a(this.a.s, (b)this.a.ai.get());
                m.a(this.a.s).a(this.a, this.a.am);
            }
            else {
                Logging.log("Load Ad: onPageFinished - No listener found");
            }
        }
        this.a.q.set(true);
    }
    
    public void onPageStarted(final WebView webView, final String s, final Bitmap bitmap) {
        super.onPageStarted(webView, s, bitmap);
        Logging.log("Load Ad: onPageStarted");
        this.a.q.set(false);
        if (Version.getAndroidSDKVersion() > 18) {
            Logging.log(" adding onpagefinsihed callback reciever with delay of 5 sec" + Constants.WAIT_FOR_ON_PAGE_FINISHED);
            new Handler(Looper.getMainLooper()).postDelayed((Runnable)new m$t(this.a, s), Constants.WAIT_FOR_ON_PAGE_FINISHED);
        }
    }
    
    public void onReceivedError(final WebView webView, final int n, final String s, final String s2) {
        d.b(this.a.s);
        Logging.log("Load Ad: onReceivedError - Failing Url " + s2);
        super.onReceivedError(webView, n, s, s2);
        if (this.a.b.compareAndSet(true, false) && m.a(this.a.s) != null) {
            m.a(this.a.s).a(this.a, this.a.am, 305, r.a(305));
        }
    }
    
    public WebResourceResponse shouldInterceptRequest(final WebView webView, final String s) {
        final int n = 0;
        Logging.log("Load Ad : shouldInterceptRequest URL - " + s);
        if (s.equals("http://baseurl.admarvel.com/mraid.js")) {
            final File dir = ((d)this.a.findViewWithTag((Object)(this.a.s + "INTERNAL"))).getContext().getDir("adm_mraid_file", 0);
            File file;
            if (dir != null && dir.isDirectory()) {
                file = new File(dir.getAbsolutePath() + "/mraid.js");
            }
            else {
                file = null;
            }
            if (file != null && file.exists()) {
                try {
                    Logging.log("Mraid loading from client");
                    return new WebResourceResponse("text/css", "UTF-8", (InputStream)new FileInputStream(file));
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
                        final m$d m$d = new m$d(null);
                        m$d.a = a;
                        m$d.b = read;
                        n2 += read;
                        list.add(m$d);
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
                    final m$d m$d2 = (m$d)list.get(j);
                    System.arraycopy(m$d2.a, 0, array, n3, m$d2.b);
                    n3 += m$d2.b;
                    ++j;
                }
                s2 = new String(array);
            }
            else {
                s2 = "";
            }
            return new WebResourceResponse("text/css", "UTF-8", (InputStream)new ByteArrayInputStream(s2.getBytes()));
        }
        return super.shouldInterceptRequest(webView, s);
    }
    
    public boolean shouldOverrideUrlLoading(WebView webView, final String s) {
        Logging.log("Load Ad : shouldOverrideUrlLoading URL - " + s);
        d d2;
        final d d = d2 = (d)this.a.findViewWithTag((Object)(this.a.s + "INTERNAL"));
        if (d == null) {
            d2 = d;
            if (this.a.x) {
                final Context context = this.a.getContext();
                d2 = d;
                if (context != null) {
                    d2 = d;
                    if (context instanceof Activity) {
                        d2 = (d)((ViewGroup)((Activity)context).getWindow().findViewById(16908290)).findViewWithTag((Object)(this.a.s + "INTERNAL"));
                    }
                }
            }
        }
        if (d2 != null && d2.b()) {
            return false;
        }
        if (r.f(s)) {
            return true;
        }
        if (this.a.af) {
            if (d2 != null && !d2.c() && (s == null || s.length() <= 0 || (!s.startsWith("admarvelsdk") && !s.startsWith("admarvelinternal")))) {
                return true;
            }
            if (r.a(this.a.getContext(), s, this.a.R)) {
                new r(this.a.getContext()).c(this.a.ah);
                return true;
            }
            if (s != null && r.a(s, "admarvelsdk") != r$j.c) {
                if (m.a(this.a.s) != null) {
                    m.a(this.a.s).a(this.a.am, r.a(s, "admarvelsdk", "", r.a(s, "admarvelsdk"), this.a.getContext()));
                }
                new r(this.a.getContext()).c(this.a.ah);
                return true;
            }
            if (s != null && r.a(s, "admarvelinternal") != r$j.c) {
                if (m.a(this.a.s) != null) {
                    m.a(this.a.s).a(this.a.am, r.a(s, "admarvelinternal", "", r.a(s, "admarvelinternal"), this.a.getContext()));
                }
                new r(this.a.getContext()).c(this.a.ah);
                return true;
            }
            if (s != null && r.a(s, "admarvelvideo") != r$j.c) {
                final String a = r.a(s, "admarvelvideo", "http://", r.a(s, "admarvelvideo"), this.a.getContext());
                final Intent intent = new Intent("android.intent.action.VIEW");
                intent.addFlags(268435456);
                intent.setDataAndType(Uri.parse(a), "video/*");
                if (r.a(this.a.getContext(), intent)) {
                    this.a.getContext().startActivity(intent);
                }
                new r(this.a.getContext()).c(this.a.ah);
                return true;
            }
            if (s != null && r.a(s, "admarvelexternal") != r$j.c) {
                final Intent intent2 = new Intent("android.intent.action.VIEW", Uri.parse(r.a(s, "admarvelexternal", "", r.a(s, "admarvelexternal"), this.a.getContext())));
                intent2.addFlags(268435456);
                if (r.a(this.a.getContext(), intent2)) {
                    this.a.getContext().startActivity(intent2);
                }
                new r(this.a.getContext()).c(this.a.ah);
                return true;
            }
            if (s != null && r.a(s, "admarvelcustomvideo") != r$j.c) {
                webView = (WebView)new Intent(this.a.getContext(), (Class)AdMarvelVideoActivity.class);
                ((Intent)webView).addFlags(268435456);
                this.a.am.removeNonStringEntriesTargetParam();
                while (true) {
                    try {
                        final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        final ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
                        objectOutputStream.writeObject(this.a.am);
                        objectOutputStream.close();
                        ((Intent)webView).putExtra("serialized_admarvelad", byteArrayOutputStream.toByteArray());
                        ((Intent)webView).putExtra("url", s);
                        ((Intent)webView).putExtra("isCustomUrl", true);
                        ((Intent)webView).putExtra("xml", this.a.ah);
                        ((Intent)webView).putExtra("source", this.a.ad);
                        ((Intent)webView).putExtra("GUID", this.a.s);
                        this.a.getContext().startActivity((Intent)webView);
                        new r(this.a.getContext()).c(this.a.ah);
                        return true;
                    }
                    catch (IOException ex) {
                        ex.printStackTrace();
                        continue;
                    }
                    break;
                }
            }
        }
        if (this.a.r.get() || (d2 != null && d2.c())) {
            this.a.c(s);
        }
        return true;
    }
}
