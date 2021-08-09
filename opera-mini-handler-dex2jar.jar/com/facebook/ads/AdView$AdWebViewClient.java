// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.facebook.ads;

import java.util.Map;
import com.facebook.ads.internal.action.AdAction;
import android.util.Log;
import java.util.UUID;
import com.facebook.ads.internal.HtmlAdDataModel;
import com.facebook.ads.internal.action.AdActionFactory;
import android.net.Uri;
import com.facebook.ads.internal.AdUtilities;
import android.net.http.SslError;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;

class AdView$AdWebViewClient extends WebViewClient
{
    final /* synthetic */ AdView this$0;
    
    private AdView$AdWebViewClient(final AdView this$0) {
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
        if (this.this$0.adListener != null) {
            this.this$0.adListener.onAdClicked(this.this$0);
        }
        final AdAction adAction = AdActionFactory.getAdAction(this.this$0.getContext(), Uri.parse(s));
        final Map dataModelMap = ((HtmlAdDataModel)this.this$0.adHandler.getAdDataModel()).getDataModelMap();
        dataModelMap.put("adInterstitialUniqueId", UUID.randomUUID().toString());
        if (adAction == null) {
            return true;
        }
        try {
            adAction.execute(dataModelMap);
            return true;
        }
        catch (Exception ex) {
            Log.e(AdView.TAG, "Error executing action", (Throwable)ex);
            return true;
        }
    }
}
