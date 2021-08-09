// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.facebook.ads;

import android.content.res.Configuration;
import android.view.ViewGroup$LayoutParams;
import android.widget.RelativeLayout$LayoutParams;
import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import com.facebook.ads.internal.AdType;
import android.view.View;
import android.webkit.WebViewClient;
import com.facebook.ads.internal.AdWebViewUtils;
import com.facebook.ads.internal.AdWebViewInterface;
import com.facebook.ads.internal.AdDataModel;
import com.facebook.ads.internal.AdResponse;
import com.facebook.ads.internal.AdRequest$Callback;
import com.facebook.ads.internal.HtmlAdDataModel;
import com.facebook.ads.internal.AdHandler$ImpressionHelper;
import android.content.Context;
import android.util.DisplayMetrics;
import android.webkit.WebView;
import com.facebook.ads.internal.AdRequestController;
import com.facebook.ads.internal.HtmlAdHandler;
import android.widget.RelativeLayout;

public class AdView extends RelativeLayout implements Ad
{
    private static final int DEFAULT_ALPHA = 255;
    private static final String DEFAULT_ENCODING = "utf-8";
    private static final String DEFAULT_MIME_TYPE = "text/html";
    private static final int MIN_ALPHA = 229;
    private static final String TAG;
    private HtmlAdHandler adHandler;
    private AdListener adListener;
    private AdRequestController adRequestController;
    private final AdSize adSize;
    private WebView adWebView;
    private int currentAlpha;
    private ImpressionListener impListener;
    private final DisplayMetrics metrics;
    private final String placementId;
    private final AdView$ScreenStateReceiver screenStateReceiver;
    private int viewabilityThreshold;
    
    static {
        TAG = AdView.class.getSimpleName();
    }
    
    public AdView(final Context context, final String placementId, final AdSize adSize) {
        super(context);
        this.currentAlpha = 255;
        this.adListener = null;
        this.impListener = null;
        if (adSize == null || adSize == AdSize.INTERSTITIAL) {
            throw new IllegalArgumentException("adSize");
        }
        this.placementId = placementId;
        this.adSize = adSize;
        this.metrics = context.getResources().getDisplayMetrics();
        this.screenStateReceiver = new AdView$ScreenStateReceiver(this, null);
        this.initializeView(context);
        this.adHandler = new HtmlAdHandler(this.adWebView, new AdHandler$ImpressionHelper() {
            @Override
            public void afterImpressionSent() {
                if (AdView.this.adRequestController != null) {
                    AdView.this.adRequestController.scheduleRefresh("on imp sent");
                }
            }
            
            @Override
            public void onLoggingImpression() {
                if (AdView.this.impListener != null) {
                    AdView.this.impListener.onLoggingImpression(AdView.this);
                }
            }
            
            @Override
            public boolean shouldSendImpression() {
                return AdView.this.isAdViewVisible();
            }
            
            @Override
            public boolean wasManual() {
                return false;
            }
        }, 1000L, context);
        this.registerScreenStateReceiver();
    }
    
    private AdRequest$Callback createAdRequestCallback() {
        return new AdRequest$Callback() {
            @Override
            public void onCompleted(final AdResponse adResponse) {
                AdView.this.adHandler.cancelImpressionRetry();
                final AdDataModel dataModel = adResponse.getDataModel();
                if (dataModel != null && dataModel instanceof HtmlAdDataModel) {
                    AdView.this.adHandler.setAdDataModel((HtmlAdDataModel)dataModel);
                    AdView.this.updateView((HtmlAdDataModel)dataModel);
                    if (AdView.this.adListener != null) {
                        AdView.this.adListener.onAdLoaded(AdView.this);
                    }
                    AdView.this.viewabilityThreshold = adResponse.getViewabilityThreshold();
                }
                else if (dataModel == null) {
                    if (AdView.this.adListener != null) {
                        final AdListener access$600 = AdView.this.adListener;
                        final AdView this$0 = AdView.this;
                        AdError adError;
                        if (adResponse.getError() != null) {
                            adError = adResponse.getError();
                        }
                        else {
                            adError = AdError.INTERNAL_ERROR;
                        }
                        access$600.onError(this$0, adError);
                    }
                    if (AdView.this.adRequestController != null) {
                        AdView.this.adRequestController.scheduleRefresh("on no fill");
                    }
                }
                else {
                    if (AdView.this.adListener != null) {
                        AdView.this.adListener.onError(AdView.this, AdError.INTERNAL_ERROR);
                    }
                    if (AdView.this.adRequestController != null) {
                        AdView.this.adRequestController.scheduleRefresh("on internal error");
                    }
                }
            }
            
            @Override
            public void onError(final AdError adError) {
                AdView.this.adHandler.cancelImpressionRetry();
                if (AdView.this.adListener != null) {
                    AdView.this.adListener.onError(AdView.this, adError);
                }
            }
        };
    }
    
    private void ensureAdRequestController() {
        if (this.adRequestController == null) {
            throw new RuntimeException("No request controller available, has the AdView been destroyed?");
        }
    }
    
    private void initializeView(final Context context) {
        (this.adWebView = new WebView(context)).setVisibility(8);
        AdWebViewUtils.config(this.adWebView, new AdView$AdWebViewClient(this, null), new AdWebViewInterface());
        this.addView((View)this.adWebView);
        this.resizeAdView();
        this.adRequestController = new AdRequestController(this.getContext(), this.placementId, this.adSize, true, AdType.HTML, this.createAdRequestCallback());
    }
    
    private boolean isAdViewVisible() {
        if (this.getVisibility() == 0 && this.getParent() != null && this.currentAlpha >= 229) {
            final int[] array = new int[2];
            this.getLocationOnScreen(array);
            if (array[0] >= 0 && this.metrics.widthPixels - array[0] >= (int)Math.ceil(this.adSize.getWidth() * this.metrics.density)) {
                final int n = (int)Math.ceil(this.adSize.getHeight() * this.metrics.density);
                final int n2 = (int)(n * (100.0 - this.viewabilityThreshold) / 100.0);
                if ((array[1] >= 0 || Math.abs(array[1]) <= n2) && array[1] + n - this.metrics.heightPixels <= n2) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private void registerScreenStateReceiver() {
        final IntentFilter intentFilter = new IntentFilter("android.intent.action.SCREEN_ON");
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        this.getContext().registerReceiver((BroadcastReceiver)this.screenStateReceiver, intentFilter);
    }
    
    private void resizeAdView() {
        if (this.adWebView != null) {
            int widthPixels;
            if ((int)(this.metrics.widthPixels / this.metrics.density) >= this.adSize.getWidth()) {
                widthPixels = this.metrics.widthPixels;
            }
            else {
                widthPixels = (int)Math.ceil(this.adSize.getWidth() * this.metrics.density);
            }
            final RelativeLayout$LayoutParams layoutParams = new RelativeLayout$LayoutParams(widthPixels, (int)Math.ceil(this.adSize.getHeight() * this.metrics.density));
            layoutParams.addRule(14);
            this.adWebView.setLayoutParams((ViewGroup$LayoutParams)layoutParams);
        }
    }
    
    private void unregisterScreenStateReceiver() {
        try {
            this.getContext().unregisterReceiver((BroadcastReceiver)this.screenStateReceiver);
        }
        catch (Exception ex) {}
    }
    
    private void updateView(final HtmlAdDataModel htmlAdDataModel) {
        if (this.adWebView != null) {
            this.adWebView.loadUrl("about:blank");
            this.adWebView.clearCache(true);
            this.adWebView.setVisibility(8);
            this.adWebView.loadDataWithBaseURL(AdWebViewUtils.getBaseUrl(), htmlAdDataModel.getMarkup(), "text/html", "utf-8", (String)null);
            this.adWebView.setVisibility(0);
        }
    }
    
    public void destroy() {
        if (this.adRequestController != null) {
            this.adRequestController.destroy();
            this.adRequestController = null;
        }
        this.adHandler.cancelImpressionRetry();
        this.adHandler.destroy();
        if (this.adWebView == null) {
            return;
        }
        this.unregisterScreenStateReceiver();
        while (true) {
            try {
                WebView.class.getMethod("onPause", (Class<?>[])new Class[0]).invoke(this.adWebView, new Object[0]);
                this.removeView((View)this.adWebView);
                this.adWebView.destroy();
                this.adWebView = null;
            }
            catch (Exception ex) {
                continue;
            }
            break;
        }
    }
    
    public void disableAutoRefresh() {
        this.adRequestController.disableRefresh();
    }
    
    public void loadAd() {
        this.ensureAdRequestController();
        this.adRequestController.loadAd();
    }
    
    protected void onConfigurationChanged(final Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.resizeAdView();
    }
    
    protected boolean onSetAlpha(final int currentAlpha) {
        this.currentAlpha = currentAlpha;
        return super.onSetAlpha(currentAlpha);
    }
    
    protected void onWindowVisibilityChanged(final int n) {
        super.onWindowVisibilityChanged(n);
        if (this.adRequestController != null) {
            this.adRequestController.onWindowVisibilityChanged(n);
        }
        if (n == 0) {
            this.adHandler.scheduleImpressionRetry();
            return;
        }
        this.adHandler.cancelImpressionRetry();
    }
    
    public void setAdListener(final AdListener adListener) {
        this.adListener = adListener;
    }
    
    public void setImpressionListener(final ImpressionListener impListener) {
        this.impListener = impListener;
    }
}
