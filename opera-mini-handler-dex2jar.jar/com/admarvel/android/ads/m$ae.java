// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.admarvel.android.ads;

import java.lang.ref.WeakReference;

class m$ae implements Runnable
{
    private final WeakReference a;
    private String b;
    
    public m$ae(final String b, final m m) {
        this.b = null;
        this.b = b;
        this.a = new WeakReference((T)m);
    }
    
    @Override
    public void run() {
        final m m = (m)this.a.get();
        if (m != null) {
            final d d = (d)m.findViewWithTag((Object)(m.s + "INTERNAL"));
            if (d != null) {
                final int visibility = d.getVisibility();
                if (this.b.equals("show") && visibility != 0) {
                    d.setVisibility(0);
                }
                if (this.b.equals("hide") && visibility == 0) {
                    d.setVisibility(4);
                }
            }
        }
    }
}
