// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.admarvel.android.ads;

import com.admarvel.android.util.Logging;
import android.util.Log;
import java.lang.ref.WeakReference;

class m$ad implements Runnable
{
    private final WeakReference a;
    private String b;
    
    public m$ad(final m m, final String b) {
        this.a = new WeakReference((T)m);
        this.b = b;
    }
    
    @Override
    public void run() {
        a a;
        try {
            final m m = (m)this.a.get();
            if (m == null) {
                return;
            }
            a = (a)m.findViewWithTag((Object)(m.s + "EMBEDDED_VIDEO"));
            if (a == null || this.b == null || this.b.trim().length() <= 0) {
                return;
            }
            if (this.b.equalsIgnoreCase("mute")) {
                a.d();
                return;
            }
        }
        catch (Exception ex) {
            Logging.log(Log.getStackTraceString((Throwable)ex));
            return;
        }
        if (this.b.equalsIgnoreCase("unmute")) {
            a.e();
        }
    }
}
