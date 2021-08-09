// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.admarvel.android.ads;

import com.admarvel.android.util.Logging;
import android.util.Log;
import android.os.Handler;
import android.os.Looper;
import java.lang.ref.WeakReference;

class m$y implements Runnable
{
    private final WeakReference a;
    private final WeakReference b;
    
    public m$y(final m m, final d d) {
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
                if (m.O == null) {
                    m.O = new m$ac(m, d);
                    new Handler(Looper.getMainLooper()).postDelayed((Runnable)m.O, 500L);
                }
                final a a = (a)m.findViewWithTag((Object)(m.s + "EMBEDDED_VIDEO"));
                if (a != null && !a.isPlaying()) {
                    a.g();
                    if (m.L != null && m.L.length() > 0) {
                        d.e(m.L + "()");
                    }
                }
            }
        }
        catch (Exception ex) {
            Logging.log(Log.getStackTraceString((Throwable)ex));
        }
    }
}
