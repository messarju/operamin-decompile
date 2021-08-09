// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.admarvel.android.ads;

import com.admarvel.android.util.Logging;
import android.util.Log;
import android.content.Context;
import com.admarvel.android.util.a.b;
import java.lang.ref.WeakReference;

class AdMarvelActivity$j implements Runnable
{
    private final WeakReference a;
    private final WeakReference b;
    private final String c;
    
    public AdMarvelActivity$j(final d d, final AdMarvelActivity adMarvelActivity, final String c) {
        this.a = new WeakReference((T)d);
        this.b = new WeakReference((T)adMarvelActivity);
        this.c = c;
    }
    
    @Override
    public void run() {
        AdMarvelActivity adMarvelActivity;
        try {
            if (this.a.get() == null) {
                return;
            }
            adMarvelActivity = (AdMarvelActivity)this.b.get();
            if (adMarvelActivity == null || this.c == null || this.c.length() <= 0) {
                return;
            }
            if (AdMarvelInterstitialAds.enableOfflineSDK) {
                new b().a(this.c, (Context)adMarvelActivity, adMarvelActivity.g);
                return;
            }
        }
        catch (Exception ex) {
            Logging.log(Log.getStackTraceString((Throwable)ex));
            return;
        }
        new r((Context)adMarvelActivity).b(this.c);
    }
}
