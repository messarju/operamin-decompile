// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.admarvel.android.ads;

import android.widget.RelativeLayout;
import java.lang.ref.WeakReference;

class AdMarvelActivity$b implements b
{
    private final WeakReference a;
    
    public AdMarvelActivity$b(final AdMarvelActivity adMarvelActivity) {
        this.a = new WeakReference((T)adMarvelActivity);
    }
    
    @Override
    public void a(final String s) {
        final AdMarvelActivity adMarvelActivity = (AdMarvelActivity)this.a.get();
        if (adMarvelActivity != null) {
            final RelativeLayout relativeLayout = (RelativeLayout)adMarvelActivity.findViewById(AdMarvelActivity.b);
            if (relativeLayout != null) {
                final d d = (d)relativeLayout.findViewWithTag((Object)(s + "WEBVIEW"));
                if (d != null && !d.b() && d.u != null && d.u.length() > 0) {
                    d.loadUrl("javascript:" + d.u + "()");
                }
            }
        }
    }
}
