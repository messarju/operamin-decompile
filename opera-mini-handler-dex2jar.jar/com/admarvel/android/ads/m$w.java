// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.admarvel.android.ads;

import android.annotation.TargetApi;
import com.admarvel.android.util.Logging;
import android.util.Log;
import android.os.Handler;
import android.os.Looper;
import java.lang.ref.WeakReference;

class m$w implements Runnable
{
    private final WeakReference a;
    private final WeakReference b;
    
    public m$w(final m m, final d d) {
        this.a = new WeakReference((T)m);
        this.b = new WeakReference((T)d);
    }
    
    @TargetApi(14)
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
                    a = (a)m.findViewWithTag((Object)(m.s + "EMBEDDED_VIDEO"));
                    if (a == null) {
                        break;
                    }
                    if (a.getHeight() == 0) {
                        new Handler(Looper.getMainLooper()).postDelayed((Runnable)new Runnable() {
                            @Override
                            public void run() {
                                if (a.getHeight() == 0 && m.N != null && m.N.length() > 0) {
                                    d.e(m.N + "()");
                                    return;
                                }
                                a.f();
                            }
                        }, 500L);
                        if (m.G != null && m.G.length() > 0) {
                            d.e(m.G + "()");
                            return;
                        }
                        break;
                    }
                }
                catch (Exception ex) {
                    Logging.log(Log.getStackTraceString((Throwable)ex));
                    return;
                }
                a.f();
                continue;
            }
        }
    }
}
