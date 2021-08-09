// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.google.analytics.tracking.android;

import android.util.Log;

public final class ae
{
    private static boolean Code;
    
    public static int B(final String s) {
        if (ae.Code) {
            return Log.v("GAV2", b(s));
        }
        return 0;
    }
    
    public static int C(final String s) {
        return Log.w("GAV2", b(s));
    }
    
    public static int Code(final String s) {
        if (ae.Code) {
            return Log.d("GAV2", b(s));
        }
        return 0;
    }
    
    public static void Code(final boolean code) {
        ae.Code = code;
    }
    
    public static boolean Code() {
        return ae.Code;
    }
    
    public static int I(final String s) {
        return Log.e("GAV2", b(s));
    }
    
    public static int J(final String s) {
        if (ae.Code) {
            return Z(s);
        }
        return 0;
    }
    
    public static int Z(final String s) {
        return Log.i("GAV2", b(s));
    }
    
    public static int a(final String s) {
        if (ae.Code) {
            return C(s);
        }
        return 0;
    }
    
    private static String b(final String s) {
        return Thread.currentThread().toString() + ": " + s;
    }
}
