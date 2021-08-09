// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.opera.mini.android;

import android.app.Activity;

public class TrackedActivity extends Activity
{
    private static int Code;
    
    static {
        TrackedActivity.Code = 0;
    }
    
    protected void onStart() {
        super.onStart();
        if (x.s()) {
            as.Code(this);
            ++TrackedActivity.Code;
        }
    }
    
    protected void onStop() {
        super.onStop();
        if (x.s()) {
            as.I(this);
            if (--TrackedActivity.Code == 0) {
                as.Code("[background]");
            }
        }
    }
}
