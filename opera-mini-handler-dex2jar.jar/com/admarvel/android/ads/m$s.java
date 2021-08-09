// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.admarvel.android.ads;

import com.admarvel.android.util.Logging;
import android.util.Log;
import java.lang.ref.WeakReference;

class m$s implements Runnable
{
    private final WeakReference a;
    private final WeakReference b;
    private String c;
    
    public m$s(final String c, final m m, final d d) {
        this.c = c;
        this.a = new WeakReference((T)m);
        this.b = new WeakReference((T)d);
    }
    
    @Override
    public void run() {
        try {
            final m m = (m)this.a.get();
            final d d = (d)this.b.get();
            if (m != null && d != null && this.c != null) {
                if (this.c.length() <= 0) {
                    return;
                }
                final a a = (a)m.findViewWithTag((Object)(m.s + "EMBEDDED_VIDEO"));
                if (a != null) {
                    a.e(this.c);
                }
            }
        }
        catch (Exception ex) {
            Logging.log(Log.getStackTraceString((Throwable)ex));
        }
    }
}
