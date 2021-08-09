// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.google.android.gms.common;

import android.content.ComponentName;
import android.os.IBinder;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.BlockingQueue;
import android.content.ServiceConnection;

public final class I implements ServiceConnection
{
    private boolean Code;
    private final BlockingQueue I;
    
    public I() {
        this.Code = false;
        this.I = new LinkedBlockingQueue();
    }
    
    public final IBinder Code() {
        if (this.Code) {
            throw new IllegalStateException();
        }
        this.Code = true;
        return this.I.take();
    }
    
    public final void onServiceConnected(final ComponentName componentName, final IBinder binder) {
        try {
            this.I.put(binder);
        }
        catch (InterruptedException ex) {}
    }
    
    public final void onServiceDisconnected(final ComponentName componentName) {
    }
}
