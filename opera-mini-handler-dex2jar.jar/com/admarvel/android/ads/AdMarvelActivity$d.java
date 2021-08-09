// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.admarvel.android.ads;

import com.admarvel.android.util.Logging;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
import java.lang.ref.WeakReference;

class AdMarvelActivity$d implements Runnable
{
    private final WeakReference a;
    
    public AdMarvelActivity$d(final AdMarvelActivity adMarvelActivity) {
        this.a = new WeakReference((T)adMarvelActivity);
    }
    
    @Override
    public void run() {
        try {
            final AdMarvelActivity adMarvelActivity = (AdMarvelActivity)this.a.get();
            if (adMarvelActivity == null) {
                return;
            }
            adMarvelActivity.i = false;
            final RelativeLayout relativeLayout = (RelativeLayout)adMarvelActivity.findViewById(AdMarvelActivity.b);
            final j j = (j)relativeLayout.findViewWithTag((Object)(adMarvelActivity.h + "BR_VIDEO"));
            if (j != null) {
                j.a();
                relativeLayout.removeView((View)j);
            }
            if (adMarvelActivity.E != null) {
                adMarvelActivity.g.removeCallbacks((Runnable)adMarvelActivity.E);
                adMarvelActivity.E = null;
            }
        }
        catch (Exception ex) {
            Logging.log(Log.getStackTraceString((Throwable)ex));
        }
    }
}
