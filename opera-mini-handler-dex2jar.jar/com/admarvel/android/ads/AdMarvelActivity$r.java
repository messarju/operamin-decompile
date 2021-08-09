// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.admarvel.android.ads;

import android.view.Display;
import com.admarvel.android.util.Logging;
import android.util.Log;
import android.view.WindowManager;
import android.app.Activity;
import java.lang.ref.WeakReference;

class AdMarvelActivity$r implements Runnable
{
    private final WeakReference a;
    private String b;
    private Activity c;
    
    public AdMarvelActivity$r(final Activity activity, final String b) {
        this.b = null;
        this.c = null;
        this.a = new WeakReference((T)activity);
        this.b = b;
    }
    
    @Override
    public void run() {
        Display defaultDisplay;
        try {
            this.c = (Activity)this.a.get();
            if (this.c == null) {
                return;
            }
            if (this.b == null) {
                return;
            }
            defaultDisplay = ((WindowManager)this.c.getSystemService("window")).getDefaultDisplay();
            if (this.b.equalsIgnoreCase("Portrait")) {
                this.c.setRequestedOrientation(1);
                if (defaultDisplay.getRotation() != 0) {
                    this.c.setRequestedOrientation(9);
                }
                return;
            }
        }
        catch (Exception ex) {
            Logging.log(Log.getStackTraceString((Throwable)ex));
            return;
        }
        if (this.b.equalsIgnoreCase("LandscapeLeft")) {
            this.c.setRequestedOrientation(0);
            if (defaultDisplay.getRotation() != 1) {
                this.c.setRequestedOrientation(8);
            }
        }
        else if (this.b.equalsIgnoreCase("PortraitUpSideDown")) {
            this.c.setRequestedOrientation(9);
            if (defaultDisplay.getRotation() != 2) {
                this.c.setRequestedOrientation(1);
            }
        }
        else if (this.b.equalsIgnoreCase("LandscapeRight")) {
            this.c.setRequestedOrientation(8);
            if (defaultDisplay.getRotation() != 3) {
                this.c.setRequestedOrientation(0);
            }
        }
        else if (this.b.equalsIgnoreCase("none")) {
            if (defaultDisplay.getRotation() == 2) {
                this.c.setRequestedOrientation(9);
                if (defaultDisplay.getRotation() != 2) {
                    this.c.setRequestedOrientation(1);
                }
            }
            else if (defaultDisplay.getRotation() == 3) {
                this.c.setRequestedOrientation(8);
                if (defaultDisplay.getRotation() != 3) {
                    this.c.setRequestedOrientation(0);
                }
            }
        }
    }
}
