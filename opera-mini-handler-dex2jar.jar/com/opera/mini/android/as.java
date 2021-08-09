// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.opera.mini.android;

import com.google.analytics.tracking.android.g;
import com.opera.mini.android.events.EventDispatcher;
import com.google.analytics.tracking.android.l;
import android.app.Activity;
import java.util.Iterator;
import com.google.analytics.tracking.android.e;
import android.os.AsyncTask;
import java.util.Random;
import java.util.Calendar;
import java.util.Locale;
import java.util.LinkedList;
import java.text.SimpleDateFormat;
import android.content.Context;

public final class as
{
    private static int B;
    private static Context Code;
    private static boolean I;
    private static SimpleDateFormat J;
    private static LinkedList Z;
    
    static {
        as.Z = new LinkedList();
        as.J = new SimpleDateFormat("yyyyMMdd", Locale.US);
    }
    
    public static void Code() {
        au.b.Code(x.Code(as.Code));
        au.I.Code(u.Code.ac());
        final boolean b = Browser.Z.b();
        final boolean c = Browser.Z.c();
        if (c) {
            au.a.Code(x.r());
            if (x.ak >= 9) {
                au.Z.Code(as.J.format(at.Code()));
            }
        }
        if (b) {
            au.c.Code(as.J.format(Calendar.getInstance().getTime()));
            I("start", "version_change", "OperaMiniInstalled", null);
        }
        else if (c) {
            I("start", "version_change", "OperaMiniUpdated", null);
        }
        final Random random = new Random();
        if (c || random.nextInt(10) == 0) {
            String s;
            if (b) {
                s = "first_start";
            }
            else if (c) {
                s = "version_update";
            }
            else {
                s = "launch";
            }
            I("start", OperaApplication.Code(), s, "");
        }
        an.Code(new AsyncTask() {}, (Object[])new Void[0]);
    }
    
    public static void Code(final int b) {
        as.B = b;
    }
    
    public static void Code(final Activity activity) {
        if (!as.I) {
            as.Z.add(new Runnable() {
                @Override
                public final void run() {
                    as.Code(activity);
                }
            });
            return;
        }
        a();
        l.Code().Code(activity);
    }
    
    public static void Code(final Context code) {
        as.Code = code;
        l.Code().Code(code);
        EventDispatcher.Z(new aw());
    }
    
    public static void Code(final String s) {
        if (!as.I) {
            as.Z.add(new Runnable() {
                @Override
                public final void run() {
                    as.Code(s);
                }
            });
            return;
        }
        a();
        l.I().Z(s);
    }
    
    public static void Code(final String s, final long n) {
        try {
            av.valueOf(s).Code(n);
        }
        catch (IllegalArgumentException ex) {}
    }
    
    public static void Code(final String s, final String s2) {
        try {
            au.valueOf(s).Code(s2);
        }
        catch (IllegalArgumentException ex) {}
    }
    
    public static void Code(final boolean b) {
        g.Code(as.Code).I(b);
    }
    
    public static void I() {
        I("font", (System.nanoTime() - com.opera.mini.android.g.e()) / 1000000L, "font_calculation", "");
    }
    
    public static void I(final Activity activity) {
        if (!as.I) {
            as.Z.add(new Runnable() {
                @Override
                public final void run() {
                    as.I(activity);
                }
            });
            return;
        }
        l.Code().I(activity);
    }
    
    private static void I(final String s, final long n, final String s2, final String s3) {
        if (!as.I) {
            as.Z.add(new Runnable() {
                @Override
                public final void run() {
                    I(s, n, s2, s3);
                }
            });
            return;
        }
        a();
        l.I().Code(s, n, s2, s3);
    }
    
    private static void I(final String s, final String s2, final String s3, final Long n) {
        if (!as.I) {
            as.Z.add(new Runnable() {
                @Override
                public final void run() {
                    I(s, s2, s3, n);
                }
            });
            return;
        }
        a();
        l.I().Code(s, s2, s3, n);
    }
    
    private static void a() {
        au.Code.Code(String.valueOf(as.B));
        au.Code();
        av.Code();
    }
}
