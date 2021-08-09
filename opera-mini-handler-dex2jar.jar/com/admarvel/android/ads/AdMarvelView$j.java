// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.admarvel.android.ads;

import android.view.View;
import java.lang.ref.WeakReference;

class AdMarvelView$j implements Runnable
{
    final WeakReference a;
    
    public AdMarvelView$j(final AdMarvelView adMarvelView) {
        this.a = new WeakReference((T)adMarvelView);
    }
    
    @Override
    public void run() {
        final AdMarvelView adMarvelView = (AdMarvelView)this.a.get();
        if (adMarvelView != null) {
            final View viewWithTag = adMarvelView.findViewWithTag((Object)"PENDING");
            if (viewWithTag != null) {
                adMarvelView.removeView(viewWithTag);
            }
        }
    }
}
