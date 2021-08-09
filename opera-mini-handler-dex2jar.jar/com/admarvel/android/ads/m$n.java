// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.admarvel.android.ads;

import android.os.Handler;
import com.admarvel.android.util.a.b;
import java.lang.ref.WeakReference;

class m$n implements Runnable
{
    private final WeakReference a;
    private final WeakReference b;
    private final String c;
    
    public m$n(final d d, final m m, final String c) {
        this.a = new WeakReference((T)d);
        this.b = new WeakReference((T)m);
        this.c = c;
    }
    
    @Override
    public void run() {
        if (this.a.get() != null) {
            final m m = (m)this.b.get();
            if (m != null && this.c != null && this.c.length() != 0) {
                if (AdMarvelView.a) {
                    try {
                        new b().a(this.c, m.getContext(), new Handler());
                        return;
                    }
                    catch (Exception ex) {
                        return;
                    }
                }
                new r(m.getContext()).b(this.c);
            }
        }
    }
}
