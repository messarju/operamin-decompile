// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.google.android.apps.analytics;

import android.util.Log;
import android.content.Intent;
import android.content.Context;
import android.content.BroadcastReceiver;

public class AnalyticsReceiver extends BroadcastReceiver
{
    public void onReceive(final Context context, final Intent intent) {
        final String stringExtra = intent.getStringExtra("referrer");
        if (!"com.android.vending.INSTALL_REFERRER".equals(intent.getAction()) || stringExtra == null) {
            return;
        }
        Log.i("GoogleAnalyticsTracker", "referrer=" + stringExtra);
        if (new p(context).Code(stringExtra)) {
            Log.d("GoogleAnalyticsTracker", "Referrer store attemped succeeded.");
            return;
        }
        Log.w("GoogleAnalyticsTracker", "Referrer store attempt failed.");
    }
}
