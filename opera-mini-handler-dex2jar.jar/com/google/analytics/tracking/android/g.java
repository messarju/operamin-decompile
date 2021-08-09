// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.google.analytics.tracking.android;

import java.util.Locale;
import java.util.HashMap;
import java.util.Map;
import android.content.Context;

public class g implements ap
{
    private static g b;
    private volatile String B;
    private volatile Boolean C;
    private f Code;
    private Context I;
    private Code J;
    private an Z;
    private final Map a;
    
    g() {
        this.a = new HashMap();
    }
    
    private g(final Context context) {
        this(context, x.Code(context));
    }
    
    private g(final Context context, final f code) {
        this.a = new HashMap();
        if (context == null) {
            throw new IllegalArgumentException("context cannot be null");
        }
        this.I = context.getApplicationContext();
        this.Code = code;
        this.J = new Code();
        this.Code.Code(new Object() {});
        this.Code.Code(new Object() {});
    }
    
    public static g Code(final Context context) {
        synchronized (g.class) {
            if (g.b == null) {
                g.b = new g(context);
            }
            return g.b;
        }
    }
    
    public static void Code(final boolean b) {
        y.Code().Code(aa.f);
        ae.Code(b);
    }
    
    public final an Code(final String s) {
        monitorenter(this);
        if (s == null) {
            try {
                throw new IllegalArgumentException("trackingId cannot be null");
            }
            finally {
                monitorexit(this);
            }
        }
        an an;
        if ((an = this.a.get(s)) == null) {
            final an z = new an(s, this);
            this.a.put(s, z);
            an = z;
            if (this.Z == null) {
                this.Z = z;
                an = z;
            }
        }
        y.Code().Code(aa.g);
        monitorexit(this);
        return an;
    }
    
    @Override
    public final void Code(final Map map) {
        monitorenter(this);
        if (map == null) {
            try {
                throw new IllegalArgumentException("hit cannot be null");
            }
            finally {
                monitorexit(this);
            }
        }
        map.put("language", aq.Code(Locale.getDefault()));
        map.put("adSenseAdMobHitId", Integer.toString(this.J.Code()));
        map.put("screenResolution", this.I.getResources().getDisplayMetrics().widthPixels + "x" + this.I.getResources().getDisplayMetrics().heightPixels);
        map.put("usage", y.Code().Z());
        y.Code().I();
        this.Code.Code(map);
        map.get("trackingId");
        monitorexit(this);
    }
    
    public final void I(final boolean b) {
        y.Code().Code(aa.h);
        this.C = b;
        this.Code.Code(b);
    }
}
