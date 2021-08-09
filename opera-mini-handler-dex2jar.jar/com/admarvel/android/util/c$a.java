// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.admarvel.android.util;

import android.os.Bundle;
import com.admarvel.android.ads.d;
import android.location.Location;
import android.location.LocationManager;
import android.location.LocationListener;

class c$a implements LocationListener
{
    LocationManager a;
    final /* synthetic */ c b;
    private boolean c;
    
    public c$a(final c b, final String s, final LocationManager a) {
        this.b = b;
        this.c = false;
        this.a = a;
        b.d = s;
    }
    
    public void a() {
        if (!this.c) {
            this.a.requestLocationUpdates(this.b.d, 0L, 0.0f, (LocationListener)this);
            this.c = true;
        }
    }
    
    public void onLocationChanged(final Location location) {
        d d;
        if (this.b.f != null) {
            d = (d)this.b.f.get();
        }
        else {
            d = null;
        }
        if (d != null && d.getHandler() != null && this.b.e != null && location != null && this.b.f != null) {
            d.e(this.b.e + "(" + location.getLatitude() + "," + location.getLongitude() + "," + location.getAccuracy() + ")");
        }
    }
    
    public void onProviderDisabled(final String s) {
    }
    
    public void onProviderEnabled(final String s) {
    }
    
    public void onStatusChanged(final String s, final int n, final Bundle bundle) {
    }
}
