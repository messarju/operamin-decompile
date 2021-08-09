// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.opera.mini.android;

import com.opera.mini.android.events.ConnectivityChangedEvent;
import android.net.NetworkInfo;
import com.opera.mini.android.notifications.B;
import android.content.Context;

public final class ao
{
    private int Code;
    
    public ao(final Context context) {
        this.Code = -1;
        Code(B.Z(context));
    }
    
    private static void Code(final NetworkInfo networkInfo) {
        if (u.I.I()) {
            return;
        }
        int n2;
        final int n = n2 = -1;
        if (networkInfo != null) {
            n2 = n;
            if (networkInfo.isAvailable()) {
                n2 = n;
                if (networkInfo.isConnected()) {
                    switch (networkInfo.getType()) {
                        default: {
                            n2 = 0;
                            break;
                        }
                        case 0:
                        case 2:
                        case 3:
                        case 4:
                        case 5: {
                            n2 = 1;
                            break;
                        }
                        case 1: {
                            n2 = 6;
                            break;
                        }
                        case 6: {
                            n2 = 5;
                            break;
                        }
                        case 9: {
                            n2 = 7;
                            break;
                        }
                    }
                }
            }
        }
        u.I.h();
        u.Z.c(n2);
        u.I.Z(15);
    }
    
    @cr
    public final void onConnectivityChanged(final ConnectivityChangedEvent connectivityChangedEvent) {
        final NetworkInfo code = connectivityChangedEvent.Code;
        int type;
        if (code != null) {
            type = code.getType();
        }
        else {
            type = -1;
        }
        if (type != this.Code) {
            this.Code = type;
            Code(connectivityChangedEvent.Code);
        }
    }
}
