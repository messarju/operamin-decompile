// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.admarvel.android.ads;

import java.lang.ref.WeakReference;

class m$aa implements Runnable
{
    private final WeakReference a;
    
    public m$aa(final m m) {
        this.a = new WeakReference((T)m);
    }
    
    @Override
    public void run() {
        final m m = (m)this.a.get();
        if (m == null) {
            return;
        }
        m.setBackgroundColor(m.c);
    }
}
