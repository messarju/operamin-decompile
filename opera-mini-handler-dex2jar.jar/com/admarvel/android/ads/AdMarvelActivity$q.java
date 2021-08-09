// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.admarvel.android.ads;

import com.admarvel.android.util.Logging;
import android.util.Log;
import android.widget.RelativeLayout;
import java.lang.ref.WeakReference;

class AdMarvelActivity$q implements Runnable
{
    private final WeakReference a;
    private final WeakReference b;
    private float c;
    
    public AdMarvelActivity$q(final AdMarvelActivity adMarvelActivity, final d d, final float c) {
        this.a = new WeakReference((T)adMarvelActivity);
        this.b = new WeakReference((T)d);
        this.c = c;
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
                final RelativeLayout relativeLayout = (RelativeLayout)adMarvelActivity.findViewById(AdMarvelActivity.b);
                if (relativeLayout != null) {
                    final j j = (j)relativeLayout.findViewWithTag((Object)(adMarvelActivity.h + "BR_VIDEO"));
                    if (j != null) {
                        j.seekTo((int)(this.c * 1000.0f));
                    }
                }
            }
        }
        catch (Exception ex) {
            Logging.log(Log.getStackTraceString((Throwable)ex));
        }
    }
}
