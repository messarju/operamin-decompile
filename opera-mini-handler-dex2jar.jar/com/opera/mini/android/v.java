// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.opera.mini.android;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;

final class v extends ResultReceiver
{
    v(final Handler handler) {
        super(handler);
    }
    
    protected final void onReceiveResult(final int n, final Bundle bundle) {
        switch (n) {
            default: {}
            case 0:
            case 2: {
                Browser.Z.Code(false);
            }
            case 1:
            case 3: {
                Browser.Z.Code(true);
            }
        }
    }
}
