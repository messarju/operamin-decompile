// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.admarvel.android.ads;

import android.view.View;
import android.content.Context;
import com.admarvel.android.util.a.b;
import android.os.Handler;
import java.lang.ref.WeakReference;

class AdMarvelView$f implements Runnable
{
    private final WeakReference a;
    
    public AdMarvelView$f(final AdMarvelView adMarvelView) {
        this.a = new WeakReference((T)adMarvelView);
    }
    
    @Override
    public void run() {
        final AdMarvelView adMarvelView = (AdMarvelView)this.a.get();
        if (adMarvelView != null) {
            final Handler handler = new Handler();
            final Context context = adMarvelView.getContext();
            final View viewWithTag = adMarvelView.findViewWithTag((Object)"CURRENT");
            if (viewWithTag != null && viewWithTag instanceof m) {
                final AdMarvelAd adMarvelAd = ((m)viewWithTag).getAdMarvelAd();
                if (adMarvelAd != null) {
                    new b().a(adMarvelAd, context, handler);
                }
            }
        }
    }
}
