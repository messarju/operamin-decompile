// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.admarvel.android.ads;

import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.DecelerateInterpolator;
import com.admarvel.android.util.m;
import android.view.View;
import java.lang.ref.WeakReference;

class AdMarvelView$k implements Runnable
{
    private final WeakReference a;
    private final WeakReference b;
    private final AdMarvelAd c;
    
    public AdMarvelView$k(final View view, final AdMarvelView adMarvelView, final AdMarvelAd c) {
        this.a = new WeakReference((T)view);
        this.b = new WeakReference((T)adMarvelView);
        this.c = c;
    }
    
    @Override
    public void run() {
        if (this.a != null && this.b != null) {
            final View view = (View)this.a.get();
            final AdMarvelView adMarvelView = (AdMarvelView)this.b.get();
            if (adMarvelView != null) {
                final View viewWithTag = adMarvelView.findViewWithTag((Object)"CURRENT");
                if (viewWithTag != null) {
                    adMarvelView.a(viewWithTag);
                    adMarvelView.e();
                    view.setVisibility(0);
                    view.setTag((Object)"CURRENT");
                    adMarvelView.removeAllViews();
                    adMarvelView.addView(view);
                    if (!adMarvelView.i) {
                        adMarvelView.b(viewWithTag);
                    }
                    final m m = new m(90.0f, 0.0f, adMarvelView.getWidth() / 2.0f, adMarvelView.getHeight() / 2.0f, -0.3f * adMarvelView.getWidth(), false);
                    m.setDuration(700L);
                    m.setFillAfter(true);
                    m.setInterpolator((Interpolator)new DecelerateInterpolator());
                    adMarvelView.startAnimation((Animation)m);
                    if (this.c != null) {
                        if (adMarvelView.b()) {
                            adMarvelView.h.b(adMarvelView.getContext(), adMarvelView, this.c.getSiteId(), this.c.getId(), this.c.getTargetParams(), this.c.getIpAddress());
                        }
                        else {
                            adMarvelView.h.a(adMarvelView.getContext(), adMarvelView, this.c.getSiteId(), this.c.getId(), this.c.getTargetParams(), this.c.getIpAddress());
                        }
                        if (AdMarvelUtils.isLogDumpEnabled()) {
                            new Handler().postDelayed((Runnable)new AdMarvelView$e(this.c, adMarvelView.getContext()), 1000L);
                        }
                    }
                }
            }
        }
    }
}
