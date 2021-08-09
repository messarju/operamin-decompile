// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.opera.mini.android;

import com.opera.mini.android.notifications.B;
import android.content.Context;
import com.opera.mini.android.notifications.g;
import android.app.Application;

public class OperaApplication extends Application
{
    private static final long Code;
    
    static {
        Code = System.nanoTime();
    }
    
    public static long Code() {
        return System.nanoTime() - OperaApplication.Code / 1000000L;
    }
    
    public void onCreate() {
        super.onCreate();
        if (x.al) {
            g.Code((Context)this);
        }
        B.Code();
    }
}
