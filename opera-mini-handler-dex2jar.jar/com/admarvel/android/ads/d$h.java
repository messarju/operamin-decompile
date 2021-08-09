// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.admarvel.android.ads;

import com.admarvel.android.util.Logging;
import android.content.Context;
import java.lang.ref.WeakReference;

class d$h implements Runnable
{
    private final WeakReference a;
    private final WeakReference b;
    
    public d$h(final d d, final Context context) {
        this.a = new WeakReference((T)context);
        this.b = new WeakReference((T)d);
    }
    
    @Override
    public void run() {
        final d d = null;
        Object o;
        if (this.a != null) {
            o = this.a.get();
        }
        else {
            o = null;
        }
        if (o != null && o instanceof AdMarvelActivity) {
            final AdMarvelActivity adMarvelActivity = (AdMarvelActivity)o;
            d d2 = d;
            if (this.b.get() != null) {
                d2 = (d)this.b.get();
            }
            if (d2 != null && !d2.b() && !d2.R) {
                Logging.log("Closing Interstitial as onpagefinished is not called");
                adMarvelActivity.g();
            }
        }
    }
}
