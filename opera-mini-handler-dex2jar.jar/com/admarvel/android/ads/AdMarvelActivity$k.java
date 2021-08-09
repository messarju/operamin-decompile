// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.admarvel.android.ads;

import com.admarvel.android.util.Logging;
import android.util.Log;
import android.view.WindowManager;
import android.app.Activity;
import java.lang.ref.WeakReference;

class AdMarvelActivity$k implements Runnable
{
    private static int a;
    private final WeakReference b;
    
    static {
        AdMarvelActivity$k.a = Integer.MIN_VALUE;
    }
    
    public AdMarvelActivity$k(final Activity activity) {
        this.b = new WeakReference((T)activity);
    }
    
    public int a() {
        return AdMarvelActivity$k.a;
    }
    
    @Override
    public void run() {
        try {
            if (this.b.get() != null) {
                AdMarvelActivity$k.a = ((WindowManager)((Activity)this.b.get()).getSystemService("window")).getDefaultDisplay().getRotation();
            }
        }
        catch (Exception ex) {
            Logging.log(Log.getStackTraceString((Throwable)ex));
        }
    }
}
