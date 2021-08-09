// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.opera.mini.android.events;

import android.net.NetworkInfo;

public class ConnectivityChangedEvent
{
    public NetworkInfo Code;
    
    public ConnectivityChangedEvent(final NetworkInfo code) {
        this.Code = code;
    }
}
