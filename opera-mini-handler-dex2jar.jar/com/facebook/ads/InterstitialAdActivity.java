// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.facebook.ads;

import com.facebook.ads.internal.AdHandler$ImpressionHelper;
import android.view.View;
import android.webkit.WebViewClient;
import com.facebook.ads.internal.AdWebViewInterface;
import android.view.ViewGroup$LayoutParams;
import android.widget.RelativeLayout$LayoutParams;
import android.widget.RelativeLayout;
import android.view.WindowManager;
import android.content.Context;
import android.support.v4.content.I;
import com.facebook.ads.internal.AdWebViewUtils;
import android.os.Bundle;
import android.content.Intent;
import com.facebook.ads.internal.HtmlAdDataModel;
import android.webkit.WebView;
import com.facebook.ads.internal.HtmlAdHandler;
import android.app.Activity;

public class InterstitialAdActivity extends Activity
{
    private static final int AD_WEBVIEW_ID = 100001;
    private static final String DATA_MODEL_KEY = "dataModel";
    private static final String LAST_REQUESTED_ORIENTATION_KEY = "lastRequestedOrientation";
    private static final int ORIENTATION_REVERSE_LANDSCAPE = 8;
    private static final int ORIENTATION_REVERSE_PORTRAIT = 9;
    private static final String TAG;
    private HtmlAdHandler adHandler;
    private WebView adWebView;
    private HtmlAdDataModel dataModel;
    private int displayHeight;
    private int displayWidth;
    private String interstitialID;
    private boolean isRestart;
    private int lastRequestedOrientation;
    
    static {
        TAG = InterstitialAdActivity.class.getSimpleName();
    }
    
    public InterstitialAdActivity() {
        this.isRestart = false;
    }
    
    private void loadAdFromIntentOrSavedState(final Intent intent, final Bundle bundle) {
        if (bundle != null && bundle.containsKey("dataModel")) {
            this.dataModel = HtmlAdDataModel.fromBundle(bundle.getBundle("dataModel"));
            if (this.dataModel != null) {
                this.adWebView.loadDataWithBaseURL(AdWebViewUtils.getBaseUrl(), this.dataModel.getMarkup(), "text/html", "utf-8", (String)null);
            }
            this.lastRequestedOrientation = bundle.getInt("lastRequestedOrientation", -1);
            this.interstitialID = bundle.getString("adInterstitialUniqueId");
            this.isRestart = true;
        }
        else {
            this.displayWidth = intent.getIntExtra("displayWidth", 0);
            this.displayHeight = intent.getIntExtra("displayHeight", 0);
            this.interstitialID = intent.getStringExtra("adInterstitialUniqueId");
            this.dataModel = HtmlAdDataModel.fromIntentExtra(intent);
            if (this.dataModel != null) {
                this.adHandler.setAdDataModel(this.dataModel);
                this.adWebView.loadDataWithBaseURL(AdWebViewUtils.getBaseUrl(), this.dataModel.getMarkup(), "text/html", "utf-8", (String)null);
            }
        }
    }
    
    private void sendBroadcastForEvent(final String s) {
        I.Code((Context)this).Code(new Intent(s + ":" + this.interstitialID));
    }
    
    private void setScreenOrientation(int n, int rotation) {
        if (rotation >= n) {
            n = 1;
        }
        else {
            n = 0;
        }
        rotation = ((WindowManager)this.getSystemService("window")).getDefaultDisplay().getRotation();
        if (n != 0) {
            switch (rotation) {
                default: {
                    this.setRequestedOrientation(1);
                }
                case 1:
                case 2: {
                    this.setRequestedOrientation(9);
                }
            }
        }
        else {
            switch (rotation) {
                default: {
                    this.setRequestedOrientation(0);
                }
                case 2:
                case 3: {
                    this.setRequestedOrientation(8);
                }
            }
        }
    }
    
    public void finish() {
        this.adHandler.cancelImpressionRetry();
        this.adWebView.loadUrl("about:blank");
        this.adWebView.clearCache(true);
        this.sendBroadcastForEvent("com.facebook.ads.interstitial.dismissed");
        super.finish();
    }
    
    public void onCreate(final Bundle bundle) {
        super.onCreate(bundle);
        this.requestWindowFeature(1);
        this.getWindow().setFlags(1024, 1024);
        final RelativeLayout relativeLayout = new RelativeLayout((Context)this);
        (this.adWebView = new WebView((Context)this)).setId(100001);
        this.adWebView.setLayoutParams((ViewGroup$LayoutParams)new RelativeLayout$LayoutParams(-1, -1));
        AdWebViewUtils.config(this.adWebView, new InterstitialAdActivity$AdWebViewClient(this, null), new AdWebViewInterface());
        relativeLayout.addView((View)this.adWebView);
        this.adHandler = new HtmlAdHandler(this.adWebView, new AdHandler$ImpressionHelper() {
            @Override
            public void afterImpressionSent() {
            }
            
            @Override
            public void onLoggingImpression() {
                InterstitialAdActivity.this.sendBroadcastForEvent("com.facebook.ads.interstitial.impression.logged");
            }
            
            @Override
            public boolean shouldSendImpression() {
                return true;
            }
            
            @Override
            public boolean wasManual() {
                return false;
            }
        }, 1000L, (Context)this);
        this.setContentView((View)relativeLayout, (ViewGroup$LayoutParams)new RelativeLayout$LayoutParams(-1, -1));
        this.loadAdFromIntentOrSavedState(this.getIntent(), bundle);
        this.sendBroadcastForEvent("com.facebook.ads.interstitial.displayed");
    }
    
    public void onRestart() {
        super.onRestart();
        this.isRestart = true;
    }
    
    public void onSaveInstanceState(final Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.dataModel != null) {
            bundle.putBundle("dataModel", this.dataModel.saveToBundle());
        }
        bundle.putInt("lastRequestedOrientation", this.lastRequestedOrientation);
        bundle.putString("adInterstitialUniqueId", this.interstitialID);
    }
    
    public void onStart() {
        super.onStart();
        if (!this.isRestart) {
            this.setScreenOrientation(this.displayWidth, this.displayHeight);
        }
        else if (this.lastRequestedOrientation >= 0) {
            this.setRequestedOrientation(this.lastRequestedOrientation);
            this.lastRequestedOrientation = -1;
        }
        this.isRestart = false;
    }
    
    public void setRequestedOrientation(final int lastRequestedOrientation) {
        super.setRequestedOrientation(this.lastRequestedOrientation = lastRequestedOrientation);
    }
}
