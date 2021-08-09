// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.admarvel.android.ads;

import android.location.Location;
import com.admarvel.android.util.c;
import com.admarvel.android.util.Logging;
import android.util.Log;
import java.lang.ref.WeakReference;

class r$i implements Runnable
{
    private final WeakReference a;
    private final String b;
    private String c;
    
    public r$i(final d d, final String b) {
        this.c = "null";
        this.a = new WeakReference((T)d);
        this.b = b;
    }
    
    @Override
    public void run() {
        d d;
        try {
            d = (d)this.a.get();
            if (d == null) {
                return;
            }
            if (!r.c(d.getContext(), "android.permission.ACCESS_COARSE_LOCATION") && !r.c(d.getContext(), "android.permission.ACCESS_FINE_LOCATION")) {
                d.e(this.b + "(" + this.c + ")");
                return;
            }
        }
        catch (Exception ex) {
            Logging.log(Log.getStackTraceString((Throwable)ex));
            return;
        }
        if (r.b(d.getContext(), "location")) {
            final Location a = com.admarvel.android.util.c.a().a(d);
            if (a != null) {
                this.c = a.getLatitude() + "," + a.getLongitude() + "," + a.getAccuracy();
            }
            d.e(this.b + "(" + this.c + ")");
        }
    }
}
