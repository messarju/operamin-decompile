// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.admarvel.android.ads;

import com.admarvel.android.util.Logging;
import android.util.Log;
import android.widget.RelativeLayout;
import java.lang.ref.WeakReference;

class AdMarvelActivity$p implements Runnable
{
    private final WeakReference a;
    private final WeakReference b;
    
    public AdMarvelActivity$p(final AdMarvelActivity adMarvelActivity, final d d) {
        this.a = new WeakReference((T)adMarvelActivity);
        this.b = new WeakReference((T)d);
    }
    
    @Override
    public void run() {
        while (true) {
            while (true) {
                j j;
                try {
                    final AdMarvelActivity adMarvelActivity = (AdMarvelActivity)this.a.get();
                    final d d = (d)this.b.get();
                    if (adMarvelActivity == null) {
                        break;
                    }
                    if (d == null) {
                        return;
                    }
                    j = (j)((RelativeLayout)adMarvelActivity.findViewById(AdMarvelActivity.b)).findViewWithTag((Object)(adMarvelActivity.h + "BR_VIDEO"));
                    if (j == null) {
                        break;
                    }
                    if (j.getHeight() == 0) {
                        adMarvelActivity.g.postDelayed((Runnable)new Runnable() {
                            @Override
                            public void run() {
                                if (j.getHeight() == 0) {
                                    d.loadUrl("javascript:" + adMarvelActivity.q + "()");
                                    return;
                                }
                                j.start();
                            }
                        }, 500L);
                        if (adMarvelActivity.E == null) {
                            adMarvelActivity.E = new AdMarvelActivity$t(adMarvelActivity, d);
                            adMarvelActivity.g.postDelayed((Runnable)adMarvelActivity.E, 1000L);
                        }
                        if (adMarvelActivity.j && adMarvelActivity.l != null && adMarvelActivity.l.length() > 0) {
                            d.loadUrl("javascript:" + adMarvelActivity.l + "()");
                            return;
                        }
                        break;
                    }
                }
                catch (Exception ex) {
                    Logging.log(Log.getStackTraceString((Throwable)ex));
                    return;
                }
                j.start();
                continue;
            }
        }
    }
}
