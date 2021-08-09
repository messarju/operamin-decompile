// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.google.analytics.tracking.android;

import android.os.Bundle;
import android.content.Intent;
import android.content.Context;
import android.content.BroadcastReceiver;

class GANetworkReceiver extends BroadcastReceiver
{
    private final al Code;
    
    GANetworkReceiver(final al code) {
        this.Code = code;
    }
    
    public void onReceive(final Context context, final Intent intent) {
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
            final Bundle extras = intent.getExtras();
            Boolean b = Boolean.FALSE;
            if (extras != null) {
                b = intent.getExtras().getBoolean("noConnectivity");
            }
            this.Code.Code(!b);
        }
    }
}
