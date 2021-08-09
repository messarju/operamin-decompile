// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.opera.mini.android;

import com.opera.mini.android.events.EventDispatcher;
import com.opera.mini.android.events.OnPowerConnected;
import android.content.Intent;
import android.content.Context;
import android.content.BroadcastReceiver;

public class PowerConnectedReceiver extends BroadcastReceiver
{
    public void onReceive(final Context context, final Intent intent) {
        EventDispatcher.Code(new OnPowerConnected());
    }
}
