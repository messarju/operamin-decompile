// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.facebook.ads.internal;

import android.content.Intent;
import android.content.Context;
import android.content.BroadcastReceiver;

class AdRequestController$ScreenStateReceiver extends BroadcastReceiver
{
    final /* synthetic */ AdRequestController this$0;
    
    private AdRequestController$ScreenStateReceiver(final AdRequestController this$0) {
        this.this$0 = this$0;
    }
    
    public void onReceive(final Context context, final Intent intent) {
        final String action = intent.getAction();
        if ("android.intent.action.SCREEN_OFF".equals(action)) {
            this.this$0.cancelRefresh(intent.getAction());
        }
        else if ("android.intent.action.SCREEN_ON".equals(action) && this.this$0.currentVisibility == 0) {
            this.this$0.scheduleRefresh(intent.getAction());
        }
    }
}
