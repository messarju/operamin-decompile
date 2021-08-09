// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.admarvel.android.ads;

import com.admarvel.android.util.Logging;
import android.util.Log;
import android.os.AsyncTask;

class AdMarvelActivity$h implements Runnable
{
    final /* synthetic */ AdMarvelActivity a;
    private final AdMarvelAd b;
    
    public AdMarvelActivity$h(final AdMarvelActivity a, final AdMarvelAd b) {
        this.a = a;
        this.b = b;
    }
    
    @Override
    public void run() {
        try {
            new AdMarvelActivity$a(this.a, this.b).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Object[0]);
        }
        catch (Exception ex) {
            Logging.log(Log.getStackTraceString((Throwable)ex));
            this.a.K.sendEmptyMessage(0);
        }
    }
}
