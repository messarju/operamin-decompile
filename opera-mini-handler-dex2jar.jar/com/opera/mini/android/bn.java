// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.opera.mini.android;

import android.telephony.SignalStrength;
import android.content.Context;
import android.telephony.TelephonyManager;
import android.telephony.PhoneStateListener;

final class bn extends PhoneStateListener
{
    private final TelephonyManager Code;
    
    bn(final Context context) {
        (this.Code = (TelephonyManager)context.getSystemService("phone")).listen((PhoneStateListener)this, 256);
    }
    
    public final void onSignalStrengthsChanged(final SignalStrength signalStrength) {
        bk.Code = I(signalStrength);
        this.Code.listen((PhoneStateListener)this, 0);
    }
}
