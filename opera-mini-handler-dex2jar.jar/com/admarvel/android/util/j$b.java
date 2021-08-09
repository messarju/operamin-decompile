// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.admarvel.android.util;

import android.content.ComponentName;
import android.os.IBinder;
import java.util.concurrent.LinkedBlockingQueue;
import android.content.ServiceConnection;

final class j$b implements ServiceConnection
{
    boolean a;
    private final LinkedBlockingQueue b;
    
    private j$b() {
        this.a = false;
        this.b = new LinkedBlockingQueue(1);
    }
    
    public final IBinder a() {
        if (this.a) {
            throw new IllegalStateException();
        }
        this.a = true;
        return this.b.take();
    }
    
    public final void onServiceConnected(final ComponentName componentName, final IBinder binder) {
        try {
            this.b.put(binder);
        }
        catch (InterruptedException ex) {}
    }
    
    public final void onServiceDisconnected(final ComponentName componentName) {
    }
}
