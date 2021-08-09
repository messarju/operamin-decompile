// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.admarvel.android.ads;

import com.admarvel.android.util.Logging;
import android.util.Log;
import java.lang.ref.WeakReference;

class m$m implements Runnable
{
    private final WeakReference a;
    
    public m$m(final m m) {
        this.a = new WeakReference((T)m);
    }
    
    @Override
    public void run() {
        try {
            final m m = (m)this.a.get();
            if (m == null) {
                return;
            }
            final a a = (a)m.findViewWithTag((Object)(m.s + "EMBEDDED_VIDEO"));
            if (a != null) {
                a.c();
            }
        }
        catch (Exception ex) {
            Logging.log(Log.getStackTraceString((Throwable)ex));
        }
    }
}
