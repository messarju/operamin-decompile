// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.facebook.ads.internal;

import android.content.Context;
import android.webkit.WebView;

public class HtmlAdHandler extends AdHandler
{
    private volatile boolean adActivated;
    private WebView webView;
    
    public HtmlAdHandler(final WebView webView, final AdHandler$ImpressionHelper adHandler$ImpressionHelper, final long n, final Context context) {
        super(adHandler$ImpressionHelper, n, context);
        this.webView = webView;
    }
    
    public void activateAd() {
        synchronized (this) {
            if (this.adActivated && this.adDataModel != null) {
                final HtmlAdDataModel htmlAdDataModel = (HtmlAdDataModel)this.adDataModel;
                if (this.webView != null && !StringUtils.isNullOrEmpty(htmlAdDataModel.getActivationCommand())) {
                    this.webView.loadUrl("javascript:" + htmlAdDataModel.getActivationCommand());
                }
                this.scheduleImpressionRetry();
                this.adActivated = true;
            }
        }
    }
    
    public void destroy() {
        synchronized (this) {
            this.webView = null;
        }
    }
    
    @Override
    protected void sendImpression() {
        synchronized (this) {
            final HtmlAdDataModel htmlAdDataModel = (HtmlAdDataModel)this.adDataModel;
            if (this.webView != null && !StringUtils.isNullOrEmpty(htmlAdDataModel.getSendImpressionCommand())) {
                this.webView.loadUrl("javascript:" + htmlAdDataModel.getSendImpressionCommand());
            }
            final String nativeImpressionUrl = htmlAdDataModel.getNativeImpressionUrl();
            if (!StringUtils.isNullOrEmpty(nativeImpressionUrl)) {
                new OpenUrlTask().execute((Object[])new String[] { nativeImpressionUrl });
                if (this.impressionHelper != null) {
                    this.impressionHelper.afterImpressionSent();
                }
            }
        }
    }
    
    public void setAdDataModel(final HtmlAdDataModel adDataModel) {
        super.setAdDataModel(adDataModel);
        this.adActivated = false;
    }
}
