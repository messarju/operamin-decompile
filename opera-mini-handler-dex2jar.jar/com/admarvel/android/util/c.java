// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.admarvel.android.util;

import android.location.LocationListener;
import com.admarvel.android.ads.r;
import android.location.Location;
import com.admarvel.android.ads.d;
import java.util.List;
import android.location.LocationManager;
import android.content.Context;
import java.lang.ref.WeakReference;

public class c
{
    private static c a;
    private static c$a b;
    private static c$a c;
    private String d;
    private String e;
    private WeakReference f;
    
    static {
        com.admarvel.android.util.c.a = null;
        com.admarvel.android.util.c.b = null;
        com.admarvel.android.util.c.c = null;
    }
    
    private c() {
    }
    
    public static c a() {
        if (com.admarvel.android.util.c.a == null) {
            com.admarvel.android.util.c.a = new c();
        }
        return com.admarvel.android.util.c.a;
    }
    
    private boolean a(final Context context, final String s) {
        final boolean b = false;
        final LocationManager locationManager = (LocationManager)context.getSystemService("location");
        try {
            final List allProviders = locationManager.getAllProviders();
            int n = 0;
            boolean b2;
            while (true) {
                b2 = b;
                if (n >= allProviders.size()) {
                    break;
                }
                if (s.equals(allProviders.get(n))) {
                    b2 = true;
                    break;
                }
                ++n;
            }
            return b2;
        }
        catch (Throwable t) {
            return false;
        }
    }
    
    public Location a(final d d) {
        final Location location = null;
        if (!r.c(d.getContext(), "android.permission.ACCESS_COARSE_LOCATION") && !r.c(d.getContext(), "android.permission.ACCESS_FINE_LOCATION")) {
            return null;
        }
        final LocationManager locationManager = (LocationManager)d.getContext().getSystemService("location");
        final List providers = locationManager.getProviders(true);
        int n = providers.size() - 1;
        Location lastKnownLocation = location;
        Location location2;
        while (true) {
            location2 = lastKnownLocation;
            if (n < 0) {
                break;
            }
            lastKnownLocation = locationManager.getLastKnownLocation((String)providers.get(n));
            if ((location2 = lastKnownLocation) != null) {
                break;
            }
            --n;
        }
        return location2;
    }
    
    public void a(final Context context) {
        final LocationManager locationManager = (LocationManager)context.getSystemService("location");
        if (com.admarvel.android.util.c.c != null) {
            locationManager.removeUpdates((LocationListener)com.admarvel.android.util.c.c);
        }
        if (com.admarvel.android.util.c.b != null) {
            locationManager.removeUpdates((LocationListener)com.admarvel.android.util.c.b);
        }
        com.admarvel.android.util.c.c = null;
        com.admarvel.android.util.c.b = null;
    }
    
    public void a(final d ex, final String e) {
        if (r.c(((d)ex).getContext(), "android.permission.ACCESS_COARSE_LOCATION") || r.c(((d)ex).getContext(), "android.permission.ACCESS_FINE_LOCATION")) {
            final LocationManager locationManager = (LocationManager)((d)ex).getContext().getSystemService("location");
            this.f = new WeakReference((T)ex);
            this.e = e;
            while (true) {
                try {
                    if (this.a(((d)ex).getContext(), "gps") && locationManager.getProvider("gps") != null) {
                        com.admarvel.android.util.c.b = new c$a(this, "gps", locationManager);
                    }
                    try {
                        if (this.a(((d)ex).getContext(), "network") && locationManager.getProvider("network") != null) {
                            com.admarvel.android.util.c.c = new c$a(this, "network", locationManager);
                        }
                        if (com.admarvel.android.util.c.c != null) {
                            com.admarvel.android.util.c.c.a();
                        }
                        if (com.admarvel.android.util.c.b != null) {
                            com.admarvel.android.util.c.b.a();
                        }
                    }
                    catch (Exception ex) {}
                }
                catch (Exception ex2) {
                    continue;
                }
                break;
            }
        }
    }
}
