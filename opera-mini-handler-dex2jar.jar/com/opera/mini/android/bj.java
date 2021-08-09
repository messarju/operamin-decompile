// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.opera.mini.android;

import android.view.MotionEvent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.content.Context;
import java.lang.reflect.Method;

public abstract class bj
{
    private static boolean B;
    private static final Integer[] C;
    private static Method I;
    private static Method J;
    private static Method Z;
    protected int Code;
    
    static {
        C = new Integer[] { new Integer(1) };
    }
    
    public static boolean Code(final Context context) {
        try {
            if ("HTC Legend".equals(Build.MODEL)) {
                return true;
            }
            if ("ZTE_GV821".equals(Build.MODEL)) {
                return false;
            }
            if (!(boolean)PackageManager.class.getDeclaredMethod("hasSystemFeature", String.class).invoke(context.getPackageManager(), "android.hardware.touchscreen.multitouch")) {
                return false;
            }
        }
        catch (Exception ex) {
            return false;
        }
        return I(context) != null;
    }
    
    public static bj I(final Context context) {
        try {
            if ((bj.J = MotionEvent.class.getDeclaredMethod("getPointerCount", (Class<?>[])null)) != null) {
                bj.B = true;
                bj.I = MotionEvent.class.getDeclaredMethod("getX", Integer.TYPE);
                bj.Z = MotionEvent.class.getDeclaredMethod("getY", Integer.TYPE);
            }
            try {
                return Z(context);
            }
            catch (Exception ex) {
                return null;
            }
        }
        catch (Exception ex2) {
            return null;
        }
    }
    
    private static bj Z(final Context context) {
        return (bj)Class.forName("com.opera.mini.android.bt").getConstructor(Context.class).newInstance(context);
    }
    
    protected void Code(final int n, final int n2, final int n3, final int n4) {
        u.I.h();
        u.Z.c(n2);
        u.Z.c(n3);
        u.Z.c(n4);
        u.Z.c(this.Code);
        u.I.Z(n);
    }
    
    public abstract boolean Code(final MotionEvent p0);
}
