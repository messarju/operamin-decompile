// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.admarvel.android.ads;

import com.admarvel.android.util.Logging;
import android.util.Log;
import java.lang.ref.WeakReference;

class r$c implements Runnable
{
    private final WeakReference a;
    private final String b;
    
    public r$c(final d d, final String b) {
        this.a = new WeakReference((T)d);
        this.b = b;
    }
    
    @Override
    public void run() {
        d d;
        try {
            d = (d)this.a.get();
            if (d == null) {
                return;
            }
            if (r.f(d.getContext())) {
                d.e(this.b + "(\"YES\")");
                return;
            }
        }
        catch (Exception ex) {
            Logging.log(Log.getStackTraceString((Throwable)ex));
            return;
        }
        d.e(this.b + "(\"NO\")");
    }
}
