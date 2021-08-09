// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.opera.mini.android;

import android.content.SharedPreferences;
import android.content.SharedPreferences$Editor;
import java.util.Date;

public class aq implements UncaughtExceptionHandler
{
    private static aq I;
    private static final String J = "LAST_CRASH_TIMESTAMP";
    private UncaughtExceptionHandler Code;
    private long Z;
    
    static {
        aq.I = null;
    }
    
    public aq() {
        this.Z = 0L;
    }
    
    public static void Code() {
        final SharedPreferences$Editor edit = Browser.Z.getPreferences(0).edit();
        final long time = new Date().getTime();
        edit.putLong("LAST_CRASH_TIMESTAMP", time);
        edit.commit();
        aq.I.Z = time;
    }
    
    public static void I() {
        if (aq.I == null) {
            aq.I = new aq();
            J();
            aq.I.Code = Thread.getDefaultUncaughtExceptionHandler();
            Thread.setDefaultUncaughtExceptionHandler((Thread.UncaughtExceptionHandler)aq.I);
            final SharedPreferences preferences = Browser.Z.getPreferences(0);
            if (preferences.contains("LAST_CRASH_TIMESTAMP")) {
                aq.I.Z = preferences.getLong("LAST_CRASH_TIMESTAMP", 0L);
            }
        }
    }
    
    private static native void J();
    
    public static long Z() {
        return aq.I.Z;
    }
    
    @Override
    public void uncaughtException(final Thread thread, final Throwable t) {
        Code();
        if (this.Code != null) {
            this.Code.uncaughtException(thread, t);
        }
    }
}
