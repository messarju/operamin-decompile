// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.admarvel.android.ads;

import com.admarvel.android.util.Logging;
import android.util.Log;
import java.lang.ref.WeakReference;

class m$ab implements Runnable
{
    private final WeakReference a;
    private final WeakReference b;
    
    public m$ab(final m m, final d d) {
        this.a = new WeakReference((T)m);
        this.b = new WeakReference((T)d);
    }
    
    @Override
    public void run() {
        try {
            final m m = (m)this.a.get();
            final d d = (d)this.b.get();
            if (m != null) {
                if (d == null) {
                    return;
                }
                final a a = (a)m.findViewWithTag((Object)(m.s + "EMBEDDED_VIDEO"));
                if (a != null && a.isPlaying()) {
                    a.c();
                    if (m.M != null && m.M.length() > 0) {
                        d.e(m.M + "()");
                    }
                }
            }
        }
        catch (Exception ex) {
            Logging.log(Log.getStackTraceString((Throwable)ex));
        }
    }
}
