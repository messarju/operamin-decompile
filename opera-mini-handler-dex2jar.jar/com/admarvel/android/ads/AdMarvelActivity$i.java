// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.admarvel.android.ads;

import com.admarvel.android.util.Logging;
import android.util.Log;
import android.widget.RelativeLayout;
import android.os.PowerManager;

class AdMarvelActivity$i implements Runnable
{
    final /* synthetic */ AdMarvelActivity a;
    
    private AdMarvelActivity$i(final AdMarvelActivity a) {
        this.a = a;
    }
    
    @Override
    public void run() {
        try {
            final PowerManager powerManager = (PowerManager)this.a.getSystemService("power");
            if (!this.a.isFinishing() && powerManager != null && powerManager.isScreenOn()) {
                final RelativeLayout relativeLayout = (RelativeLayout)this.a.findViewById(AdMarvelActivity.b);
                if (relativeLayout != null) {
                    final d d = (d)relativeLayout.findViewWithTag((Object)(this.a.h + "WEBVIEW"));
                    if (d != null && !d.b() && d.j != null && d.j.length() > 0 && d.k) {
                        d.e(d.j + "(false)");
                        d.k = false;
                    }
                }
                if (this.a.j) {
                    if (((RelativeLayout)this.a.findViewById(AdMarvelActivity.b)).findViewWithTag((Object)(this.a.h + "BR_VIDEO")) != null && this.a.t) {
                        if (this.a.r != null && this.a.r.length() > 0 && relativeLayout != null) {
                            final d d2 = (d)relativeLayout.findViewWithTag((Object)(this.a.h + "WEBVIEW"));
                            if (d2 != null) {
                                d2.loadUrl("javascript:" + this.a.r + "()");
                            }
                        }
                        this.a.g();
                    }
                }
                else if (this.a.i && this.a.t && ((RelativeLayout)this.a.findViewById(AdMarvelActivity.b)).findViewWithTag((Object)(this.a.h + "BR_VIDEO")) != null) {
                    this.a.g();
                }
            }
        }
        catch (Exception ex) {
            Logging.log(Log.getStackTraceString((Throwable)ex));
            this.a.K.sendEmptyMessage(0);
        }
    }
}
