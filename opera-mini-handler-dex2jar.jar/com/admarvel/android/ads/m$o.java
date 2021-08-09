// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.admarvel.android.ads;

import android.content.Context;
import android.view.WindowManager;
import java.lang.ref.WeakReference;

class m$o implements Runnable
{
    private static int a;
    private final WeakReference b;
    
    static {
        m$o.a = Integer.MIN_VALUE;
    }
    
    public m$o(final m m) {
        this.b = new WeakReference((T)m);
    }
    
    public int a() {
        return m$o.a;
    }
    
    @Override
    public void run() {
        final m m = (m)this.b.get();
        if (m != null) {
            final Context context = m.getContext();
            if (context != null) {
                m$o.a = ((WindowManager)context.getSystemService("window")).getDefaultDisplay().getRotation();
                m.u = m$o.a;
            }
        }
    }
}
