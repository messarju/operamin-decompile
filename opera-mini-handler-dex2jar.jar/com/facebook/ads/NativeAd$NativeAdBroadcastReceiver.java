// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.facebook.ads;

import android.support.v4.content.I;
import android.content.IntentFilter;
import java.util.Map;
import android.content.Intent;
import android.content.Context;
import android.content.BroadcastReceiver;

class NativeAd$NativeAdBroadcastReceiver extends BroadcastReceiver
{
    final /* synthetic */ NativeAd this$0;
    
    private NativeAd$NativeAdBroadcastReceiver(final NativeAd this$0) {
        this.this$0 = this$0;
    }
    
    public void onReceive(final Context context, final Intent intent) {
        final String s = intent.getAction().split(":")[0];
        if ("com.facebook.ads.native.impression".equals(s)) {
            this.this$0.handler.trySendImpression();
        }
        else if ("com.facebook.ads.native.click".equals(s)) {
            this.this$0.adDataModel.handleClick(context, null, true);
        }
    }
    
    public void register() {
        final IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.facebook.ads.native.impression:" + this.this$0.uniqueId);
        intentFilter.addAction("com.facebook.ads.native.click:" + this.this$0.uniqueId);
        I.Code(this.this$0.context).Code(this, intentFilter);
    }
    
    public void unregister() {
        try {
            I.Code(this.this$0.context).Code(this);
        }
        catch (Exception ex) {}
    }
}
