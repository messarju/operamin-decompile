// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.facebook.ads;

import android.support.v4.content.I;
import android.content.IntentFilter;
import android.content.Intent;
import android.content.Context;
import android.content.BroadcastReceiver;

class InterstitialAd$AdInterstitialBroadcastReceiver extends BroadcastReceiver
{
    final /* synthetic */ InterstitialAd this$0;
    
    private InterstitialAd$AdInterstitialBroadcastReceiver(final InterstitialAd this$0) {
        this.this$0 = this$0;
    }
    
    public void onReceive(final Context context, final Intent intent) {
        final String s = intent.getAction().split(":")[0];
        if (this.this$0.adListener != null || s.equals("com.facebook.ads.interstitial.impression.logged")) {
            if ("com.facebook.ads.interstitial.clicked".equals(s)) {
                this.this$0.adListener.onAdClicked(this.this$0);
                return;
            }
            if ("com.facebook.ads.interstitial.dismissed".equals(s)) {
                this.this$0.adListener.onInterstitialDismissed(this.this$0);
                return;
            }
            if ("com.facebook.ads.interstitial.displayed".equals(s)) {
                this.this$0.adListener.onInterstitialDisplayed(this.this$0);
                return;
            }
            if ("com.facebook.ads.interstitial.impression.logged".equals(s) && this.this$0.impListener != null) {
                this.this$0.impListener.onLoggingImpression(this.this$0);
            }
        }
    }
    
    public void register() {
        final IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.facebook.ads.interstitial.displayed:" + this.this$0.uniqueId);
        intentFilter.addAction("com.facebook.ads.interstitial.dismissed:" + this.this$0.uniqueId);
        intentFilter.addAction("com.facebook.ads.interstitial.clicked:" + this.this$0.uniqueId);
        intentFilter.addAction("com.facebook.ads.interstitial.impression.logged:" + this.this$0.uniqueId);
        I.Code(this.this$0.context).Code(this, intentFilter);
    }
    
    public void unregister() {
        try {
            I.Code(this.this$0.context).Code(this);
        }
        catch (Exception ex) {}
    }
}
