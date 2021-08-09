// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.opera.mini.android;

import android.os.AsyncTask;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import android.net.ConnectivityManager;
import android.telephony.SignalStrength;
import android.content.Context;

public final class bk
{
    private static int Code;
    private static String I;
    private static Context Z;
    
    static {
        bk.Code = 99;
    }
    
    public static void Code(final Context z) {
        bk.Z = z;
        if (u.Code.p()) {
            return;
        }
        u.I.h();
        u.Z.b(u.Z.Code(57, 1, new bl(z, (byte)0)));
        u.I.Z(7);
    }
    
    private static int I(final SignalStrength signalStrength) {
        if (x.ak >= 14) {
            try {
                return (int)bs.Code(signalStrength, "getAsuLevel", new Object[0]);
            }
            catch (Exception ex) {}
        }
        return signalStrength.getGsmSignalStrength();
    }
}
