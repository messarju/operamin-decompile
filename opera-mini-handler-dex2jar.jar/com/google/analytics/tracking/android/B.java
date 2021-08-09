// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.google.analytics.tracking.android;

import android.os.RemoteException;
import android.os.IBinder;
import android.content.ComponentName;
import android.content.ServiceConnection;

final class B implements ServiceConnection
{
    private /* synthetic */ J Code;
    
    B(final J code) {
        this.Code = code;
    }
    
    public final void onServiceConnected(final ComponentName componentName, final IBinder binder) {
        ae.Code("service connected, binder: " + binder);
        try {
            if ("com.google.android.gms.analytics.internal.IAnalyticsService".equals(binder.getInterfaceDescriptor())) {
                ae.Code("bound to service");
                this.Code.B = a.Code(binder);
                J.Code(this.Code);
                return;
            }
        }
        catch (RemoteException ex) {}
        this.Code.J.unbindService((ServiceConnection)this);
        this.Code.Code = null;
        this.Code.Z.Code(2);
    }
    
    public final void onServiceDisconnected(final ComponentName componentName) {
        ae.Code("service disconnected: " + componentName);
        this.Code.Code = null;
        this.Code.I.I();
    }
}
