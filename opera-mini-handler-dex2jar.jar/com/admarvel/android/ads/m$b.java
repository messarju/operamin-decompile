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
import android.graphics.Bitmap;
import com.admarvel.android.util.Logging;
import android.webkit.WebView;
import android.webkit.WebViewClient;

class m$b extends WebViewClient
{
    final /* synthetic */ m a;
    
    m$b(final m a) {
        this.a = a;
    }
    
    public void onLoadResource(final WebView webView, final String s) {
        Logging.log("Load Ad : onLoadResource URL - " + s);
        super.onLoadResource(webView, s);
    }
    
    public void onPageFinished(final WebView webView, final String s) {
        super.onPageFinished(webView, s);
        Logging.log("Load Ad: onPageFinished");
        if (AdMarvelUtils.isLogDumpEnabled()) {
            webView.loadUrl("javascript:window.ADMARVEL.fetchWebViewHtmlContent(document.getElementsByTagName('html')[0].outerHTML);");
        }
        if (!this.a.S) {
            this.a.setVisibility(8);
            ((d)this.a.findViewWithTag((Object)(this.a.s + "INTERNAL"))).setLayoutParamsForBanner(true);
        }
        if (!this.a.p.get() && this.a.b.compareAndSet(true, false) && m.a(this.a.s) != null) {
            d.a(this.a.s, (b)this.a.ai.get());
            m.a(this.a.s).a(this.a, this.a.am);
        }
        this.a.q.set(true);
    }
    
    public void onPageStarted(final WebView webView, final String s, final Bitmap bitmap) {
        super.onPageStarted(webView, s, bitmap);
        Logging.log("Load Ad: onPageStarted");
        this.a.q.set(false);
    }
    
    public void onReceivedError(final WebView webView, final int n, final String s, final String s2) {
        Logging.log("Load Ad : onReceivedError Failing URL - " + s2);
        super.onReceivedError(webView, n, s, s2);
        if (this.a.b.compareAndSet(true, false) && m.a(this.a.s) != null) {
            m.a(this.a.s).a(this.a, this.a.am, 305, r.a(305));
        }
    }
    
    public boolean shouldOverrideUrlLoading(WebView webView, final String s) {
        Logging.log("Load Ad : shouldOverrideUrlLoading URL - " + s);
        if (s == null) {
            return false;
        }
        d d2 = null;
        Label_0889: {
            try {
                final d d = (d)this.a.findViewWithTag((Object)(this.a.s + "INTERNAL"));
                if ((d2 = d) == null) {
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
                if (!this.a.af) {
                    break Label_0889;
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
                if (s == null || r.a(s, "admarvelcustomvideo") == r$j.c) {
                    break Label_0889;
                }
                webView = (WebView)new Intent(this.a.getContext(), (Class)AdMarvelVideoActivity.class);
                ((Intent)webView).addFlags(268435456);
                ((Intent)webView).putExtra("url", s);
                this.a.am.removeNonStringEntriesTargetParam();
                try {
                    final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    final ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
                    objectOutputStream.writeObject(this.a.am);
                    objectOutputStream.close();
                    ((Intent)webView).putExtra("serialized_admarvelad", byteArrayOutputStream.toByteArray());
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
                }
            }
            catch (Exception ex2) {
                Logging.log(ex2.getMessage() + "exception in shouldOverrideUrlLoading");
            }
            return true;
        }
        if (this.a.r.get() || d2.c()) {
            this.a.c(s);
            return true;
        }
        return true;
    }
}
