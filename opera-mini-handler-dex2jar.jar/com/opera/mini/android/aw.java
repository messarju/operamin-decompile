// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.opera.mini.android;

import android.net.NetworkInfo;
import com.opera.mini.android.events.ConnectivityChangedEvent;

final class aw
{
    @cr
    public final void onConnectivityChanged(final ConnectivityChangedEvent connectivityChangedEvent) {
        final NetworkInfo code = connectivityChangedEvent.Code;
        String typeName;
        final String s = typeName = "DISCONNECTED";
        if (code != null) {
            typeName = s;
            if (code.isAvailable()) {
                typeName = s;
                if (code.isConnected()) {
                    typeName = code.getTypeName();
                }
            }
        }
        au.C.Code(typeName);
    }
}
