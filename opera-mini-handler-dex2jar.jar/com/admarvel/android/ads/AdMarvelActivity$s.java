// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.admarvel.android.ads;

import com.admarvel.android.util.Logging;
import android.util.Log;
import android.widget.RelativeLayout;
import java.lang.ref.WeakReference;

class AdMarvelActivity$s implements Runnable
{
    private final WeakReference a;
    private final WeakReference b;
    
    public AdMarvelActivity$s(final AdMarvelActivity adMarvelActivity, final d d) {
        this.a = new WeakReference((T)adMarvelActivity);
        this.b = new WeakReference((T)d);
    }
    
    @Override
    public void run() {
        try {
            final AdMarvelActivity adMarvelActivity = (AdMarvelActivity)this.a.get();
            final d d = (d)this.b.get();
            if (adMarvelActivity != null) {
                if (d == null) {
                    return;
                }
                final j j = (j)((RelativeLayout)adMarvelActivity.findViewById(AdMarvelActivity.b)).findViewWithTag((Object)(adMarvelActivity.h + "BR_VIDEO"));
                if (j != null && j.isPlaying()) {
                    j.a();
                    d.loadUrl("javascript:stop()");
                }
            }
        }
        catch (Exception ex) {
            Logging.log(Log.getStackTraceString((Throwable)ex));
        }
    }
}
