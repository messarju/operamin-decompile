// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.facebook.ads;

import com.facebook.ads.internal.action.AdAction;
import android.util.Log;
import java.util.Map;
import android.content.Context;
import com.facebook.ads.internal.action.AdActionFactory;
import android.net.Uri;
import com.facebook.ads.internal.AdUtilities;
import android.net.http.SslError;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;

class InterstitialAdActivity$AdWebViewClient extends WebViewClient
{
    private static final String FBAD_CLOSE = "close";
    final /* synthetic */ InterstitialAdActivity this$0;
    
    private InterstitialAdActivity$AdWebViewClient(final InterstitialAdActivity this$0) {
        this.this$0 = this$0;
    }
    
    public void onLoadResource(final WebView webView, final String s) {
        this.this$0.adHandler.activateAd();
    }
    
    public void onReceivedSslError(final WebView webView, final SslErrorHandler sslErrorHandler, final SslError sslError) {
        if (AdUtilities.isSandboxUrl()) {
            sslErrorHandler.proceed();
            return;
        }
        sslErrorHandler.cancel();
    }
    
    public boolean shouldOverrideUrlLoading(final WebView webView, final String s) {
        final Uri parse = Uri.parse(s);
        if ("fbad".equals(parse.getScheme()) && "close".equals(parse.getAuthority())) {
            this.this$0.finish();
        }
        else {
            this.this$0.sendBroadcastForEvent("com.facebook.ads.interstitial.clicked");
            final AdAction adAction = AdActionFactory.getAdAction((Context)this.this$0, parse);
            if (adAction != null) {
                try {
                    adAction.execute(null);
                    return true;
                }
                catch (Exception ex) {
                    Log.e(InterstitialAdActivity.TAG, "Error executing action", (Throwable)ex);
                    return true;
                }
            }
        }
        return true;
    }
}
