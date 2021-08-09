// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.admarvel.android.ads;

import java.lang.ref.WeakReference;

class m$c implements b, i
{
    private final WeakReference a;
    
    public m$c(final m m) {
        this.a = new WeakReference((T)m);
    }
    
    @Override
    public void a() {
        final m m = (m)this.a.get();
        if (m != null) {
            final d d = (d)m.findViewWithTag((Object)(m.s + "INTERNAL"));
            if (d != null) {
                m.y = false;
                m.n = false;
                if (com.admarvel.android.ads.m.a(m.s) != null) {
                    com.admarvel.android.ads.m.a(m.s).b();
                }
                if (m.l != null) {
                    d.e(m.l + "()");
                }
            }
        }
    }
    
    @Override
    public void a(final String s) {
        final m m = (m)this.a.get();
        if (m != null) {
            final d d = (d)m.findViewWithTag((Object)(s + "INTERNAL"));
            if (d != null && d.u != null && d.u.length() > 0) {
                d.e(d.u + "()");
            }
        }
    }
    
    public void b() {
        this.a.clear();
    }
}
