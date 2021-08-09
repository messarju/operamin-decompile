// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.admarvel.android.ads;

import com.admarvel.android.util.Logging;
import android.util.Log;
import android.view.ViewGroup$LayoutParams;
import android.widget.LinearLayout$LayoutParams;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import java.lang.ref.WeakReference;

class m$f implements Runnable
{
    private final WeakReference a;
    
    public m$f(final m m) {
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
                a.b();
                m.removeView((View)a);
                a.e = null;
            }
            if (m.O != null) {
                new Handler(Looper.getMainLooper()).removeCallbacks((Runnable)m.O);
                m.O = null;
            }
            r.n(m.getContext());
            final d d = (d)m.findViewWithTag((Object)(m.s + "INTERNAL"));
            if (d != null) {
                d.h();
                d.j = null;
                d.invalidate();
                d.requestLayout();
            }
            final LinearLayout$LayoutParams layoutParams = (LinearLayout$LayoutParams)m.getLayoutParams();
            layoutParams.height = -2;
            m.setLayoutParams((ViewGroup$LayoutParams)layoutParams);
            m.forceLayout();
            m.requestLayout();
            m.invalidate();
            m.requestFocus();
            this.a.clear();
        }
        catch (Exception ex) {
            Logging.log(Log.getStackTraceString((Throwable)ex));
        }
    }
}
