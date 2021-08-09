// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.opera.mini.android.notifications;

import android.telephony.SignalStrength;
import android.telephony.PhoneStateListener;

final class d extends PhoneStateListener
{
    private d() {
    }
    
    public final void onSignalStrengthsChanged(final SignalStrength signalStrength) {
        final byte b = 99;
        if (B.Code == null) {
            B.Code = new a();
        }
        final int gsmSignalStrength = signalStrength.getGsmSignalStrength();
        final a j = B.Code;
        byte code;
        if (gsmSignalStrength >= 0 && gsmSignalStrength <= 99) {
            code = (byte)gsmSignalStrength;
        }
        else {
            code = 99;
        }
        j.Code = code;
        final int gsmBitErrorRate = signalStrength.getGsmBitErrorRate();
        final a i = B.Code;
        byte k = b;
        if (gsmBitErrorRate >= 0) {
            k = b;
            if (gsmBitErrorRate <= 99) {
                k = (byte)gsmBitErrorRate;
            }
        }
        i.I = k;
    }
}
