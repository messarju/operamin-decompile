// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.facebook.ads;

import android.view.Display;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import android.content.Intent;
import com.facebook.ads.internal.HtmlAdDataModel;
import com.facebook.ads.internal.AdRequest$Callback;
import com.facebook.ads.internal.AdType;
import java.util.UUID;
import android.content.Context;
import com.facebook.ads.internal.AdResponse;
import com.facebook.ads.internal.AdRequestController;

public class InterstitialAd implements Ad
{
    public static final String DISPLAY_HEIGHT_INTENT_EXTRA = "displayHeight";
    public static final String DISPLAY_ROTATION_INTENT_EXTRA = "displayRotation";
    public static final String DISPLAY_WIDTH_INTENT_EXTRA = "displayWidth";
    public static final String IMPRESSION_WILL_LOG = "com.facebook.ads.interstitial.impression.logged";
    public static final String INTERSTITIAL_CLICKED = "com.facebook.ads.interstitial.clicked";
    public static final String INTERSTITIAL_DISMISSED = "com.facebook.ads.interstitial.dismissed";
    public static final String INTERSTITIAL_DISPLAYED = "com.facebook.ads.interstitial.displayed";
    public static final String INTERSTITIAL_UNIQUE_ID_EXTRA = "adInterstitialUniqueId";
    public static final String SEPARATOR = ":";
    private InterstitialAdListener adListener;
    private boolean adLoaded;
    private AdRequestController adRequestController;
    private AdResponse adResponse;
    private final InterstitialAd$AdInterstitialBroadcastReceiver broadcastReceiver;
    private final Context context;
    private ImpressionListener impListener;
    private final String uniqueId;
    
    public InterstitialAd(final Context context, final String s) {
        this.uniqueId = UUID.randomUUID().toString();
        this.adLoaded = false;
        this.context = context;
        this.adRequestController = new AdRequestController(this.context, s, AdSize.INTERSTITIAL, false, AdType.HTML, new AdRequest$Callback() {
            @Override
            public void onCompleted(final AdResponse adResponse) {
                InterstitialAd.this.adResponse = adResponse;
                if (adResponse.getDataModel() != null && adResponse.getDataModel() instanceof HtmlAdDataModel) {
                    InterstitialAd.this.adLoaded = true;
                    if (InterstitialAd.this.adListener != null) {
                        InterstitialAd.this.adListener.onAdLoaded(InterstitialAd.this);
                    }
                }
                else if (adResponse.getDataModel() == null) {
                    InterstitialAd.this.adLoaded = false;
                    if (InterstitialAd.this.adListener != null) {
                        final InterstitialAdListener access$200 = InterstitialAd.this.adListener;
                        final InterstitialAd this$0 = InterstitialAd.this;
                        AdError adError;
                        if (adResponse.getError() != null) {
                            adError = adResponse.getError();
                        }
                        else {
                            adError = AdError.INTERNAL_ERROR;
                        }
                        access$200.onError(this$0, adError);
                    }
                }
                else {
                    InterstitialAd.this.adLoaded = false;
                    if (InterstitialAd.this.adListener != null) {
                        InterstitialAd.this.adListener.onError(InterstitialAd.this, AdError.INTERNAL_ERROR);
                    }
                }
            }
            
            @Override
            public void onError(final AdError adError) {
                InterstitialAd.this.adLoaded = false;
                if (InterstitialAd.this.adListener != null) {
                    InterstitialAd.this.adListener.onError(InterstitialAd.this, adError);
                }
            }
        });
        (this.broadcastReceiver = new InterstitialAd$AdInterstitialBroadcastReceiver(this, null)).register();
    }
    
    private void ensureAdRequestController() {
        if (this.adRequestController == null) {
            throw new RuntimeException("No request controller available, has the InterstitialAd been destroyed?");
        }
    }
    
    @Override
    public void destroy() {
        if (this.adRequestController != null) {
            this.adRequestController.destroy();
            this.adRequestController = null;
            this.broadcastReceiver.unregister();
        }
    }
    
    public boolean isAdLoaded() {
        return this.adLoaded;
    }
    
    @Override
    public void loadAd() {
        this.ensureAdRequestController();
        this.adLoaded = false;
        this.adRequestController.loadAd();
    }
    
    public void setAdListener(final InterstitialAdListener adListener) {
        this.adListener = adListener;
    }
    
    public void setImpressionListener(final ImpressionListener impListener) {
        this.impListener = impListener;
    }
    
    public boolean show() {
        if (!this.adLoaded) {
            if (this.adListener != null) {
                this.adListener.onError(this, AdError.INTERNAL_ERROR);
            }
            return false;
        }
        final Intent intent = new Intent(this.context, (Class)InterstitialAdActivity.class);
        ((HtmlAdDataModel)this.adResponse.getDataModel()).addToIntentExtra(intent);
        this.adLoaded = false;
        final Display defaultDisplay = ((WindowManager)this.context.getSystemService("window")).getDefaultDisplay();
        final DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getMetrics(displayMetrics);
        intent.putExtra("displayRotation", defaultDisplay.getRotation());
        intent.putExtra("displayWidth", displayMetrics.widthPixels);
        intent.putExtra("displayHeight", displayMetrics.heightPixels);
        intent.putExtra("adInterstitialUniqueId", this.uniqueId);
        this.context.startActivity(intent);
        return true;
    }
}
