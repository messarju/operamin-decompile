// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.admarvel.android.ads;

import com.admarvel.android.util.Logging;
import android.util.Log;
import java.lang.ref.WeakReference;
import android.os.AsyncTask;

class AdMarvelActivity$a extends AsyncTask
{
    private final WeakReference a;
    private final AdMarvelAd b;
    
    public AdMarvelActivity$a(final AdMarvelActivity adMarvelActivity, final AdMarvelAd b) {
        this.a = new WeakReference((T)adMarvelActivity);
        this.b = b;
    }
    
    protected Object doInBackground(Object... array) {
        if (this.a != null) {
            array = (Object[])this.a.get();
        }
        else {
            array = null;
        }
        if (array == null) {
            return null;
        }
        try {
            ((AdMarvelActivity)array).L.sendEmptyMessage(0);
            return null;
        }
        catch (Exception ex) {
            Logging.log(Log.getStackTraceString((Throwable)ex));
            ((AdMarvelActivity)array).finish();
            return null;
        }
    }
}
