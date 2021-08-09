// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.admarvel.android.ads;

import android.view.View;
import java.lang.ref.WeakReference;

class AdMarvelView$g implements Runnable
{
    private final WeakReference a;
    
    public AdMarvelView$g(final AdMarvelView adMarvelView) {
        this.a = new WeakReference((T)adMarvelView);
    }
    
    @Override
    public void run() {
        final AdMarvelView adMarvelView = (AdMarvelView)this.a.get();
        if (adMarvelView != null) {
            final View viewWithTag = adMarvelView.findViewWithTag((Object)"CURRENT");
            if (viewWithTag != null && viewWithTag instanceof m) {
                ((m)viewWithTag).f();
            }
        }
    }
}
