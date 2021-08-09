// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.admarvel.android.util;

import android.graphics.BitmapFactory;
import android.content.Context;
import android.graphics.drawable.BitmapDrawable;

public enum AdMarvelBitmapDrawableUtils$a
{
    a("BACK_DISABLE", 0), 
    b("BACK", 1), 
    c("CLOSE", 2), 
    d("DONE", 3), 
    e("MUTE", 4), 
    f("PAUSE", 5), 
    g("PLAY", 6), 
    h("REPLAY", 7), 
    i("RESUME_DISABLE", 8), 
    j("RESUME", 9), 
    k("STOP", 10), 
    l("TIME", 11), 
    m("UNMUTE", 12), 
    n("OPEN_URL_DISABLED", 13), 
    o("OPEN_URL", 14);
    
    private BitmapDrawable p;
    private int q;
    
    private AdMarvelBitmapDrawableUtils$a(final String s, final int n) {
    }
    
    private byte[] a(final String s) {
        final String[] split = s.split(",");
        final int length = split.length;
        final byte[] array = new byte[length];
        for (int i = 0; i < length; ++i) {
            array[i] = Byte.parseByte(split[i]);
        }
        this.q = array.length;
        return array;
    }
    
    public final BitmapDrawable a(final Context context, final String s) {
        if (s == null) {
            return null;
        }
        if (this.p == null) {
            (this.p = new BitmapDrawable(context.getResources(), BitmapFactory.decodeByteArray(this.a(s), 0, this.q))).setTargetDensity(com.admarvel.android.util.i.b(context.getResources().getDisplayMetrics().xdpi, context));
        }
        return this.p;
    }
}
