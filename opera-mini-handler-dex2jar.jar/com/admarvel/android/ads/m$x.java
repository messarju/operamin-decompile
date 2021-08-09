// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.admarvel.android.ads;

import android.annotation.TargetApi;
import com.admarvel.android.util.Logging;
import android.util.Log;
import java.lang.ref.WeakReference;

class m$x implements Runnable
{
    private final WeakReference a;
    private final WeakReference b;
    private int c;
    private int d;
    private int e;
    private int f;
    
    public m$x(final m m, final d d, final int c, final int d2, final int e, final int f) {
        this.a = new WeakReference((T)m);
        this.b = new WeakReference((T)d);
        this.c = c;
        this.d = d2;
        this.e = e;
        this.f = f;
    }
    
    @TargetApi(14)
    @Override
    public void run() {
        while (true) {
            while (true) {
                try {
                    final m m = (m)this.a.get();
                    final d d = (d)this.b.get();
                    if (m == null) {
                        break;
                    }
                    if (d == null) {
                        return;
                    }
                    if (m != null) {
                        final a a = (a)m.findViewWithTag((Object)(m.s + "EMBEDDED_VIDEO"));
                        if (a != null) {
                            a.a(this.e, this.f, this.c, this.d);
                            a.i();
                            return;
                        }
                        break;
                    }
                }
                catch (Exception ex) {
                    Logging.log(Log.getStackTraceString((Throwable)ex));
                    return;
                }
                final a a = null;
                continue;
            }
        }
    }
}
