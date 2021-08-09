// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.google.analytics.tracking.android;

import android.content.Intent;
import java.util.List;
import java.util.Map;
import android.os.RemoteException;
import android.content.Context;
import android.content.ServiceConnection;

final class J implements Z
{
    private C B;
    private ServiceConnection Code;
    private com.google.analytics.tracking.android.C I;
    private Context J;
    private a Z;
    
    public J(final Context j, final com.google.analytics.tracking.android.C i, final a z) {
        this.J = j;
        if (i == null) {
            throw new IllegalArgumentException("onConnectedListener cannot be null");
        }
        this.I = i;
        if (z == null) {
            throw new IllegalArgumentException("onConnectionFailedListener cannot be null");
        }
        this.Z = z;
    }
    
    private C J() {
        int n;
        if (this.B != null) {
            n = 1;
        }
        else {
            n = 0;
        }
        if (n == 0) {
            throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
        }
        return this.B;
    }
    
    @Override
    public final void Code() {
        try {
            this.J().Code();
        }
        catch (RemoteException ex) {
            ae.I("clear hits failed: " + ex);
        }
    }
    
    @Override
    public final void Code(final Map map, final long n, final String s, final List list) {
        try {
            this.J().Code(map, n, s, list);
        }
        catch (RemoteException ex) {
            ae.I("sendHit failed: " + ex);
        }
    }
    
    @Override
    public final void I() {
        final Intent intent = new Intent("com.google.android.gms.analytics.service.START");
        intent.putExtra("app_package_name", this.J.getPackageName());
        if (this.Code != null) {
            ae.I("Calling connect() while still connected, missing disconnect().");
        }
        else {
            this.Code = (ServiceConnection)new B(this);
            final boolean bindService = this.J.bindService(intent, this.Code, 129);
            ae.J("connect: bindService returned " + bindService + " for " + intent);
            if (!bindService) {
                this.Code = null;
                this.Z.Code(1);
            }
        }
    }
    
    @Override
    public final void Z() {
        this.B = null;
        if (this.Code == null) {
            return;
        }
        while (true) {
            try {
                this.J.unbindService(this.Code);
                this.Code = null;
                this.I.I();
            }
            catch (IllegalArgumentException ex) {
                continue;
            }
            catch (IllegalStateException ex2) {
                continue;
            }
            break;
        }
    }
}
