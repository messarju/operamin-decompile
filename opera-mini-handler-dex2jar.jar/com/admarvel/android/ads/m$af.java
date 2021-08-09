// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.admarvel.android.ads;

import android.graphics.Paint;
import java.lang.ref.WeakReference;

class m$af implements Runnable
{
    private final WeakReference a;
    
    public m$af(final d d) {
        this.a = new WeakReference((T)d);
    }
    
    @Override
    public void run() {
        final d d = (d)this.a.get();
        if (d == null) {
            return;
        }
        d.setLayerType(1, (Paint)null);
    }
}
