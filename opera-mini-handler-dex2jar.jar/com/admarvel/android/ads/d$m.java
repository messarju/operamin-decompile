// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.admarvel.android.ads;

import android.content.Context;
import java.lang.ref.WeakReference;

class d$m implements Runnable
{
    private WeakReference a;
    private WeakReference b;
    private long c;
    
    public d$m(final d d, final Context context, final m m) {
        this.c = 500L;
        this.a = new WeakReference((T)d);
        this.b = new WeakReference((T)m);
    }
    
    @Override
    public void run() {
        final m m = (m)this.b.get();
        final d d = (d)this.a.get();
        if (d != null && m != null && !d.M && !d.N && !Thread.currentThread().isInterrupted()) {
            final int[] array2;
            final int[] array = array2 = new int[2];
            array2[1] = (array2[0] = -1);
            d.getLocationInWindow(array);
            int n;
            if (d.getHeight() > 0) {
                n = d.getHeight() / 2;
            }
            else {
                n = 0;
            }
            int n2;
            if (d.getHeight() > 0) {
                n2 = d.getHeight() / 3 * 2;
            }
            else {
                n2 = 0;
            }
            int v;
            if (m.v != Integer.MIN_VALUE && m.v > 0) {
                v = m.v;
            }
            else {
                v = 0;
            }
            boolean b;
            if (n + (array[1] - v) >= 0 && array[1] + n2 < r.h(m.getContext())) {
                b = true;
            }
            else {
                b = false;
            }
            if (!Thread.currentThread().isInterrupted()) {
                if (b && !d.k) {
                    d.e(d.j + "(true)");
                    d.k = true;
                    return;
                }
                if (!b && d.k) {
                    d.e(d.j + "(false)");
                    d.k = false;
                }
            }
        }
    }
}
