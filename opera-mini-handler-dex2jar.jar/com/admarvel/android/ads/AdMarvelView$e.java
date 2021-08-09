// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.admarvel.android.ads;

import com.admarvel.android.util.a;
import android.app.Activity;
import android.content.Context;

class AdMarvelView$e implements Runnable
{
    private final AdMarvelAd a;
    private final Context b;
    
    public AdMarvelView$e(final AdMarvelAd a, final Context context) {
        this.a = a;
        Context b = context;
        if (!(context instanceof Activity)) {
            b = context;
            if (AdMarvelView.u != null) {
                b = context;
                if (AdMarvelView.u.get() != null) {
                    b = (Context)AdMarvelView.u.get();
                }
            }
        }
        this.b = b;
    }
    
    @Override
    public void run() {
        final a b = com.admarvel.android.util.a.b(this.b);
        if (b != null) {
            final int a = b.a(this.b);
            this.a.setAdHistoryCounter(a);
            b.a(this.a.getAdHistoryDumpString(), a);
        }
    }
}
