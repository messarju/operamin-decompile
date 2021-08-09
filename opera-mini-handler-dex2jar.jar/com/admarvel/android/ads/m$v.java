// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.admarvel.android.ads;

import com.admarvel.android.util.Logging;
import android.util.Log;
import android.os.Handler;
import android.os.Looper;
import java.lang.ref.WeakReference;

class m$v implements Runnable
{
    private final WeakReference a;
    private final WeakReference b;
    
    public m$v(final m m, final d d) {
        this.a = new WeakReference((T)m);
        this.b = new WeakReference((T)d);
    }
    
    @Override
    public void run() {
        while (true) {
            while (true) {
                a a;
                try {
                    final m m = (m)this.a.get();
                    final d d = (d)this.b.get();
                    if (m == null) {
                        break;
                    }
                    if (d == null) {
                        return;
                    }
                    if (m.O != null) {
                        new Handler(Looper.getMainLooper()).removeCallbacks((Runnable)m.O);
                        m.O = null;
                    }
                    a = (a)m.findViewWithTag((Object)(m.s + "EMBEDDED_VIDEO"));
                    if (a == null) {
                        break;
                    }
                    if (a.isPlaying()) {
                        a.pause();
                        if (m.K != null && m.K.length() > 0) {
                            d.e(m.K + "()");
                            return;
                        }
                        break;
                    }
                }
                catch (Exception ex) {
                    Logging.log(Log.getStackTraceString((Throwable)ex));
                    return;
                }
                a.c();
                continue;
            }
        }
    }
}
