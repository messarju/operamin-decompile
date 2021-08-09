// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.admarvel.android.ads;

import android.view.ViewParent;
import android.webkit.WebView;
import android.os.Handler;
import android.os.Looper;
import com.admarvel.android.util.Logging;
import java.lang.ref.WeakReference;

class d$l implements Runnable
{
    final /* synthetic */ d a;
    private final WeakReference b;
    
    public d$l(final d a, final d d) {
        this.a = a;
        this.b = new WeakReference((T)d);
    }
    
    @Override
    public void run() {
        if (this.b != null) {
            final d d = (d)this.b.get();
            if (d != null && !d.b()) {
                Label_0110: {
                    if (d.y.get() || d.z.get()) {
                        if (d.j != null && d.k) {
                            d.e(d.j + "(false)");
                            d.k = false;
                            if (d.y.get()) {
                                d.m = true;
                            }
                        }
                    }
                    else if (d.x.get() && d.j != null) {
                        final int[] array2;
                        final int[] array = array2 = new int[2];
                        array2[1] = (array2[0] = -1);
                        d.getLocationInWindow(array);
                        int n;
                        if (this.a.getHeight() > 0) {
                            n = this.a.getHeight() / 2;
                        }
                        else {
                            n = 0;
                        }
                        final ViewParent parent = d.getParent();
                        while (true) {
                            Label_0370: {
                                if (!(parent instanceof m)) {
                                    break Label_0370;
                                }
                                final m m = (m)parent;
                                if (m == null) {
                                    break Label_0370;
                                }
                                int v;
                                if (m.v != Integer.MIN_VALUE && m.v > 0) {
                                    v = m.v;
                                }
                                else {
                                    v = 0;
                                }
                                boolean b;
                                if (array[1] - v + n >= 0 && array[1] + n < r.h(this.a.getContext())) {
                                    b = true;
                                }
                                else {
                                    b = false;
                                }
                                if (d.j != null && d.k && b) {
                                    final String string = d.j + "(false)";
                                    Logging.log("javascript:" + string);
                                    d.e(string);
                                    d.k = false;
                                }
                                break Label_0110;
                            }
                            int v = 0;
                            continue;
                        }
                    }
                }
                d.h();
                new Handler(Looper.getMainLooper()).post((Runnable)new Runnable() {
                    @Override
                    public void run() {
                        d.stopLoading();
                        if (Version.getAndroidSDKVersion() >= 11) {
                            aa.b(d);
                            return;
                        }
                        ab.b(d);
                    }
                });
            }
        }
    }
}
