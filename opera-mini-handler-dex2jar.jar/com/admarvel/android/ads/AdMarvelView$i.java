// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.admarvel.android.ads;

import android.view.View;
import android.os.Handler;
import android.os.Looper;
import java.lang.ref.WeakReference;

class AdMarvelView$i implements n
{
    private final WeakReference a;
    
    public AdMarvelView$i(final AdMarvelView adMarvelView) {
        this.a = new WeakReference((T)adMarvelView);
    }
    
    @Override
    public void a() {
        final AdMarvelView adMarvelView = (AdMarvelView)this.a.get();
        if (adMarvelView == null) {
            return;
        }
        adMarvelView.h.a();
    }
    
    @Override
    public void a(final AdMarvelAd adMarvelAd, final String s) {
        final AdMarvelView adMarvelView = (AdMarvelView)this.a.get();
        if (adMarvelView == null) {
            return;
        }
        adMarvelView.h.a(adMarvelView.getContext(), adMarvelView, s, adMarvelAd.getSiteId(), adMarvelAd.getId(), adMarvelAd.getTargetParams(), adMarvelAd.getIpAddress());
    }
    
    @Override
    public void a(final m m, final AdMarvelAd adMarvelAd) {
        final AdMarvelView adMarvelView = (AdMarvelView)this.a.get();
        if (adMarvelView == null) {
            return;
        }
        new Handler(Looper.getMainLooper()).post((Runnable)new AdMarvelView$d(adMarvelView, adMarvelAd));
    }
    
    @Override
    public void a(final m m, final AdMarvelAd adMarvelAd, final int n, final AdMarvelUtils$ErrorReason adMarvelUtils$ErrorReason) {
        final AdMarvelView adMarvelView = (AdMarvelView)this.a.get();
        if (adMarvelView != null) {
            final View viewWithTag = adMarvelView.findViewWithTag((Object)"PENDING");
            if (viewWithTag != null) {
                adMarvelView.removeView(viewWithTag);
            }
            if (adMarvelAd != null) {
                adMarvelView.h.a(adMarvelView.getContext(), adMarvelView, n, adMarvelUtils$ErrorReason, adMarvelAd.getSiteId(), adMarvelAd.getId(), adMarvelAd.getTargetParams(), adMarvelAd.getIpAddress());
            }
        }
    }
    
    @Override
    public void b() {
        final AdMarvelView adMarvelView = (AdMarvelView)this.a.get();
        if (adMarvelView == null) {
            return;
        }
        adMarvelView.h.b();
    }
}
