// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.admarvel.android.ads;

import java.lang.ref.WeakReference;

class AdMarvelView$c implements Runnable
{
    private final WeakReference a;
    
    public AdMarvelView$c(final AdMarvelView adMarvelView) {
        this.a = new WeakReference((T)adMarvelView);
    }
    
    @Override
    public void run() {
        final AdMarvelView adMarvelView = (AdMarvelView)this.a.get();
        if (adMarvelView == null) {
            return;
        }
        adMarvelView.a(adMarvelView.findViewWithTag((Object)"CURRENT"));
        if (!adMarvelView.i) {
            adMarvelView.h(adMarvelView);
        }
        adMarvelView.removeAllViews();
        if (AdMarvelView.u != null) {
            AdMarvelView.u.clear();
        }
        AdMarvelAdapterInstances.destroyAdMarvelAdapterInstances(adMarvelView.b);
        d.d();
    }
}
