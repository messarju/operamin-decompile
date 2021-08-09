// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.facebook.ads;

import android.content.Intent;
import android.content.Context;
import android.content.BroadcastReceiver;

class AdView$ScreenStateReceiver extends BroadcastReceiver
{
    final /* synthetic */ AdView this$0;
    
    private AdView$ScreenStateReceiver(final AdView this$0) {
        this.this$0 = this$0;
    }
    
    public void onReceive(final Context context, final Intent intent) {
        if ("android.intent.action.SCREEN_OFF".equals(intent.getAction())) {
            this.this$0.adHandler.cancelImpressionRetry();
            return;
        }
        this.this$0.adHandler.scheduleImpressionRetry();
    }
}
