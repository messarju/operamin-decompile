// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.admarvel.android.util;

import com.admarvel.android.ads.r;
import android.content.Intent;
import android.content.Context;
import com.admarvel.android.ads.d;
import java.lang.ref.WeakReference;
import android.content.BroadcastReceiver;

public class b extends BroadcastReceiver
{
    private static String a;
    private static WeakReference b;
    
    static {
        com.admarvel.android.util.b.a = null;
    }
    
    public static void a(final d d, final String a) {
        com.admarvel.android.util.b.b = new WeakReference((T)d);
        if (a != null) {
            com.admarvel.android.util.b.a = a;
        }
    }
    
    public void onReceive(final Context context, final Intent intent) {
        while (true) {
            while (true) {
                try {
                    final String a = r.a(context);
                    if (a.equals("mobile") || a.equals("wifi")) {
                        final Boolean b = true;
                        if (com.admarvel.android.util.b.b != null) {
                            final d d = (d)com.admarvel.android.util.b.b.get();
                            if (d != null && com.admarvel.android.util.b.a != null) {
                                d.e(com.admarvel.android.util.b.a + "('" + b + "','" + a + "')");
                            }
                        }
                        return;
                    }
                }
                catch (Exception ex) {
                    Logging.log(ex.getMessage() + " Exception in AdMarvelConnectivityChangeReceiver ");
                    return;
                }
                final Boolean b = false;
                continue;
            }
        }
    }
}
