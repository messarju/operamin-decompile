// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.admarvel.android.ads;

import com.admarvel.android.util.Logging;
import java.lang.ref.WeakReference;

class d$j implements Runnable
{
    final /* synthetic */ d a;
    private final WeakReference b;
    private String c;
    
    public d$j(final d a, final d d, final String c) {
        this.a = a;
        this.c = null;
        this.b = new WeakReference((T)d);
        this.c = c;
    }
    
    @Override
    public void run() {
        if (this.b != null) {
            final d d = (d)this.b.get();
            if (d != null && !d.b()) {
                d.loadUrl("javascript:" + this.c);
                Logging.log("Inject JS:" + this.c);
            }
        }
    }
}
